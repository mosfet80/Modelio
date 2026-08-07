package com.modeliosoft.modelio.moduleconf;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.FileSystemException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.apache.maven.plugin.MojoExecutionException;
import org.modelio.gproject.data.module.JaxbModelPersistence;
import org.modelio.gproject.data.module.jaxbv2.Jxbv2Command;
import org.modelio.gproject.data.module.jaxbv2.Jxbv2Handler;
import org.modelio.gproject.data.module.jaxbv2.Jxbv2Module;
import org.modelio.gproject.data.module.jaxbv2.Jxbv2Module.Jxbv2Gui;
import org.modelio.gproject.data.module.jaxbv2.Jxbv2Module.Jxbv2Gui.Jxbv2Commands;
import org.modelio.gproject.data.module.jaxbv2.Jxbv2Module.Jxbv2Gui.Jxbv2Diagrams;
import org.modelio.gproject.data.module.jaxbv2.Jxbv2Module.Jxbv2Gui.Jxbv2Diagrams.Jxbv2DiagramType;
import org.modelio.gproject.data.module.jaxbv2.Jxbv2Module.Jxbv2Gui.Jxbv2Diagrams.Jxbv2DiagramType.Jxbv2Wizard;
import org.modelio.gproject.data.module.jaxbv2.Jxbv2Module.Jxbv2Gui.Jxbv2Tools;
import org.modelio.gproject.data.module.jaxbv2.Jxbv2Module.Jxbv2Gui.Jxbv2Views;
import org.modelio.gproject.data.module.jaxbv2.Jxbv2Module.Jxbv2Gui.Jxbv2Views.Jxbv2PropertyPage;
import org.modelio.gproject.data.module.jaxbv2.Jxbv2Module.Jxbv2Parameters;
import org.modelio.gproject.data.module.jaxbv2.Jxbv2Module.Jxbv2Parameters.Jxbv2Parameter;
import org.modelio.gproject.data.module.jaxbv2.Jxbv2Tool;
import org.modelio.vbasic.files.FileUtils;

import com.modeliosoft.modelio.AbstractModelioLauncherMojo;

public class ConfValidation extends AbstractModelioLauncherMojo {
    private Path moduleFile;
    private Path sourceBasedir;
    private String version;
    private List<String> classNames;

    public ConfValidation(Path moduleFile, Path sourceBasedir, String version, List<String> classpathElements) throws MojoExecutionException {
        this.moduleFile = moduleFile;
        this.sourceBasedir = sourceBasedir;
        this.version = version;

        /** Read Lib content **/
        this.classNames = new ArrayList<>();

        for (String elementPath : classpathElements) {
            try (ZipInputStream zip = new ZipInputStream(new FileInputStream(elementPath))) {
                for (ZipEntry entry = zip.getNextEntry(); entry != null; entry = zip.getNextEntry()) {
                    if (entry.getName().endsWith(".class") && !entry.isDirectory()) {
                        // This ZipEntry represents a class. 
                        // Now, what class does it represent?
                        // Replace '/' by '.' and strip '.class' .
                        StringBuilder className = new StringBuilder();
                        for (String part : entry.getName().split("/")) {
                            if (className.length() != 0) {
                                className.append(".");
                            }
                            className.append(part);
                            if (part.endsWith(".class")) {
                                className.setLength(className.length() - ".class".length());
                            }
                        }
                        this.classNames.add(className.toString());
                    }
                }
                zip.close();
            } catch (IOException e) {
                throw new MojoExecutionException( FileUtils.getLocalizedMessage(e), e);
            }
        }
    }

    public void validate() throws MojoExecutionException {

        Jxbv2Module module = null;
        try {
            module = JaxbModelPersistence.loadJaxbModel(this.moduleFile);
        } catch (FileSystemException e) {
            throw new MojoExecutionException(FileUtils.getLocalizedMessage(e), e);
        } catch (IOException e) {
            throw new MojoExecutionException(e.getLocalizedMessage(), e);
        } catch (RuntimeException e) {
            throw new MojoExecutionException(e.toString(), e);
        }

        if (!existingClass(module.getClazz())) {
            throw new MojoExecutionException("[module.xml][module]  The Class " + module.getClazz() + "  is missing.");
        }

        if (!isVersion(this.version)) {
            throw new MojoExecutionException("[Version]  The Version of module mutch must follow this pattern *.*.** (exemple : 2.1.00)");
        }

        final Jxbv2Gui gui = module.getGui();
        if (gui != null) {
            final Jxbv2Commands commands = gui.getCommands();
            if (commands != null) {
                for (Jxbv2Command command : commands.getCommand()) {
                    final Jxbv2Handler handler = command.getHandler();
                    if (handler != null) {
                        if (handler.getClazz() != null) {
                            if (!existingClass(handler.getClazz())) {
                                throw new MojoExecutionException("[module.xml - Commande][" + command.getId() + "]  The Class " + handler.getClazz() + "  is missing.");
                            }
                        }
                    }
                }

                Jxbv2Tools tools = gui.getTools();
                if (tools != null) {
                    for (Jxbv2Tool tool : tools.getTool()) {
                        final Jxbv2Handler handler = tool.getHandler();
                        if (handler.getClazz() != null) {
                            if (!existingClass(handler.getClazz())) {
                                throw new MojoExecutionException("[module.xml - Tool][" + tool.getId() + "]  The Class " + handler.getClazz() + "  is missing.");
                            }
                        }
                    }
                }

                Jxbv2Diagrams diags = gui.getDiagrams();
                if(diags != null){
                    for(Jxbv2DiagramType dtype : diags.getDiagramType()){
                        Jxbv2Wizard wiz = dtype.getWizard();
                        if(wiz != null){
                            final Jxbv2Handler handler = wiz.getHandler();
                            if (handler == null) {
                                throw new MojoExecutionException("[module.xml - Wizard][" + wiz.getLabel() + "]  The handler is missing.");
                            } else  if (handler.getClazz() != null) {
                                if (!existingClass(handler.getClazz())) {
                                    throw new MojoExecutionException("[module.xml - Wizard][" + wiz.getLabel() + "]  The Class " + handler.getClazz() + "  is missing.");
                                }
                            }
                        }

                        Jxbv2Handler diagHandler = dtype.getHandler();
                        if (diagHandler == null) {
                            throw new MojoExecutionException("[module.xml - Diagram Handler][" + dtype.getStereotype() + "]  Handler  is missing.");
                        } else  if (diagHandler.getClazz() != null) {
                            if (!existingClass(diagHandler.getClazz())) {
                                throw new MojoExecutionException("[module.xml - Diagram Handler][" + dtype.getStereotype() + "]  The Class " + diagHandler.getClazz() + "  is missing.");
                            }
                        }
                    }
                }
            }

            Jxbv2Views views = gui.getViews();
            if(views != null){
                for(Jxbv2PropertyPage prop : views.getPropertyPage()){
                    if (!existingClass(prop.getClazz())) {
                        throw new MojoExecutionException("[module.xml - Property Page][" + prop.getId() + "]  The Class " + prop.getClazz() + "  is missing.");
                    }
                }
            }
        }

        Set<String> names = new HashSet<>();
        final Jxbv2Parameters parameters = module.getParameters();
        if (parameters != null) {
            for (Jxbv2Parameter parameter : parameters.getParameter()) {
                if ("Enum".equalsIgnoreCase(parameter.getType()) && parameter.getEnumeration() == null) {
                    throw new MojoExecutionException("[module.xml - Parameter][" + parameter.getId() + "]  has \"Enum\" type but does not define the Enumeration.");
                }
                if (!names.add(parameter.getId())) {
                    throw new MojoExecutionException("[module.xml - Parameter][" + parameter.getId() + "]  must be unique.");
                }
            }
        }
    }

    private static boolean isVersion(String version) {
        Pattern p = Pattern.compile("[0-9]+\\.[0-9]+\\.[0-9]+");
        Matcher m = p.matcher(version);
        return m.matches();
    }

    private boolean existingClass(String clazz) {
        switch (clazz) {
        case "GenericElementCreationHandler": // Old modelio < 3.3 value
        case "GenericDiagramCreationHandler": // Old modelio < 3.3 value
        case "ElementCreate":  // Modelio >= 3.3 value
        case "DiagramCreate":  // Modelio >= 3.3 value
        case "AttachedBox":
        case "Multilink":
        case "Link":
        case "Box":
        case "StandardCustomizer" :
        case "GenericWizardContributor" :
        case "RunJyScript" :
        case "DocumentGenerate" :
        case "PatternApply" :
        case "MatrixCreate" : // since Modelio 3.4
            return true;
        default:
            String[] dirs = clazz.split("\\.");

            if (Files.exists(this.sourceBasedir)) {
                String path = this.sourceBasedir.toString();
                for (String dir : dirs) {
                    path = path + "/" + dir;
                }
                if(new File(path + ".java").exists()) {
                    return true;
                }
            }
        }

        if(this.classNames.contains(clazz)){
            return true;
        }
        return false;
    }
}

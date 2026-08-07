package com.modeliosoft.modelio;

import java.io.File;
import java.io.IOException;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.modelio.vbasic.files.FileUtils;
import com.modeliosoft.modelio.utils.ProcessManager;

/**
 * Creates a project in Modelio.
 * 
 * goal: create-project
 */
@Mojo(name="create-project")
public class ModelioProjectCreatorMojo extends AbstractModelioLauncherMojo {
    /**
     * Template to use in project creation.
     * 
     * parameter: default-value="Default"
     */
    @Parameter(defaultValue="Default")
    private String templateName;

    protected String getTemplateName() {
        return this.templateName;
    }

    @Override
    public void execute() throws MojoExecutionException {
        getLog().info("Creating Modelio Project");

        File projectFile = new File(getWorkspaceDir(), getProjectName());
        if (!projectFile.exists()) {
            File emptyJython;
            try {
                emptyJython = File.createTempFile("modelio-maven", ".py");

                String[] command = {
                        getModelioDir() + File.separator + "modelio.exe",
                        "-workspace",       getWorkspaceDir().toString(),
                        "-project",         getProjectName(),
                        "-script",          emptyJython.toString(),
                        "-template",        getTemplateName()
                };
                
                ProcessManager pm = new ProcessManager(getLog());
                if (pm.execute(command, true) != 0) {
                    throw new MojoExecutionException("Error during execution");
                }

                emptyJython.delete();
            } catch (IOException e) {
                throw new MojoExecutionException("Error during execution: "+FileUtils.getLocalizedMessage(e), e);
            }
        }
    }
}
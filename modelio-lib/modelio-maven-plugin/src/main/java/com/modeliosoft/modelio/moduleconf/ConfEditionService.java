package com.modeliosoft.modelio.moduleconf;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import org.apache.maven.artifact.Artifact;
import org.apache.maven.plugin.MojoExecutionException;
import org.modelio.gproject.data.module.JaxbModelPersistence;
import org.modelio.gproject.data.module.jaxbv2.Jxbv2ExternDocumentType;
import org.modelio.gproject.data.module.jaxbv2.Jxbv2Module;
import org.modelio.gproject.data.module.jaxbv2.Jxbv2Module.Jxbv2Parameters;
import org.modelio.gproject.data.module.jaxbv2.Jxbv2Module.Jxbv2Parameters.Jxbv2Parameter;
import org.modelio.gproject.data.module.jaxbv2.Jxbv2Module.Jxbv2Profiles;
import org.modelio.gproject.data.module.jaxbv2.Jxbv2Module.Jxbv2Profiles.Jxbv2Profile;
import org.modelio.gproject.data.module.jaxbv2.Jxbv2Module.Jxbv2Profiles.Jxbv2Profile.Jxbv2MetaclassReference;
import org.modelio.gproject.data.module.jaxbv2.Jxbv2Module.Jxbv2Profiles.Jxbv2Profile.Jxbv2MetaclassReference.Jxbv2ExternDocumentTypes;
import org.modelio.gproject.data.module.jaxbv2.Jxbv2Module.Jxbv2Profiles.Jxbv2Profile.Jxbv2MetaclassReference.Jxbv2NoteTypes;
import org.modelio.gproject.data.module.jaxbv2.Jxbv2Module.Jxbv2Profiles.Jxbv2Profile.Jxbv2MetaclassReference.Jxbv2TagTypes;
import org.modelio.gproject.data.module.jaxbv2.Jxbv2Module.Jxbv2Profiles.Jxbv2Profile.Jxbv2Stereotype;
import org.modelio.gproject.data.module.jaxbv2.Jxbv2MultiPathes;
import org.modelio.gproject.data.module.jaxbv2.Jxbv2MultiPathes.Jxbv2PathEntry;
import org.modelio.gproject.data.module.jaxbv2.Jxbv2NoteType;
import org.modelio.gproject.data.module.jaxbv2.Jxbv2PropertyDefinition;
import org.modelio.gproject.data.module.jaxbv2.Jxbv2PropertyTableDefinition;
import org.modelio.gproject.data.module.jaxbv2.Jxbv2TagType;
import org.modelio.gproject.data.module.jaxbv2.ObjectFactory;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

public class ConfEditionService {

    private Path moduleFile;
    private HashSet<String> uids;
    private Collection<Artifact> dependencies;

    public ConfEditionService(Path moduleFile, Collection<Artifact> dependencies) {
        this.moduleFile = moduleFile;
        this.uids = new HashSet<>();
        this.dependencies = dependencies;
    }

    private static boolean isJarArtifact(Artifact a) {
        String type = a.getType();
        return type == null || type.isEmpty() || type.equals("jar");
    }

    public void updateModuleFile() throws MojoExecutionException {
        Jxbv2Module module = loadModule();

        if (module.getUid() == null) {
            module.setUid(getUUID());
        } else {
            if (!isValid(module.getUid().toString())) {
                module.setUid(getUUID());
            }
        }

        Jxbv2MultiPathes paths = module.getClassPath();
        if (paths != null) {
        	// Remove all entries having the same artifact name as a dependency
        	for (Jxbv2PathEntry entry : new ArrayList<>(paths.getPathEntry())) {
        	   String path = entry.getPath();
        	   int idx = entry.getPath().lastIndexOf("-");
        	   String fileName;
        	   if (idx > 0) {
        	     fileName = path.substring(0, idx);
        	   } else {
        	     idx = entry.getPath().lastIndexOf(".jar");
        	     fileName = idx > 0 ? path.substring(0, idx) : path;
        	   }
        		String jarName = fileName.replace("lib/", "");
        		for (Artifact realDependency : this.dependencies) {
                    if(isJarArtifact(realDependency) && realDependency.getArtifactId().equals(jarName)){
                    	paths.getPathEntry().remove(entry);
                    	break;
                    }
                }
        	}

        	// Add an entry for each dependency
            ObjectFactory jxb2Factory = new ObjectFactory();
        	for (Artifact realDependency : this.dependencies) {
        	    if (isJarArtifact(realDependency)) {
        	        Jxbv2PathEntry newEntry = jxb2Factory.createMultiPathesPathEntry();

        	        newEntry.setPath("lib/" + realDependency.getFile().getName());
        	        paths.getPathEntry().add(newEntry);
        	    }
        	}

            // Remove duplicates
        	Set<String> entries = new HashSet<>();
            for (Jxbv2PathEntry entry : new ArrayList<>(paths.getPathEntry())) {
               String path = entry.getPath();
               if (entries.contains(path)) {
                   paths.getPathEntry().remove(entry);
               } else {
                   entries.add(path);
               }
            }
        }

        final Jxbv2Profiles profiles = module.getProfiles();
        if (profiles != null) {
            for (Jxbv2Profile profile : profiles.getProfile()) {
                if (profile.getUid() == null) {
                    profile.setUid(getUUID());
                } else {
                    if (!isValid(profile.getUid().toString())) {
                        profile.setUid(getUUID());
                    }
                }

                for (Jxbv2MetaclassReference stereotype : profile.getMetaclassReference()) {
                    if (stereotype.getUid() == null) {
                        stereotype.setUid(getUUID());
                    } else {
                        if (!isValid(stereotype.getUid().toString())) {
                            stereotype.setUid(getUUID());
                        }
                    }

                    final Jxbv2TagTypes tagTypes = stereotype.getTagTypes();
                    if (tagTypes != null) {
                        for (Jxbv2TagType tag : tagTypes.getTagType()) {
                            if (tag.getUid() == null) {
                                tag.setUid(getUUID());
                            } else {
                                if (!isValid(tag.getUid().toString())) {
                                    tag.setUid(getUUID());
                                }
                            }
                        }
                    }

                    final Jxbv2NoteTypes noteTypes = stereotype.getNoteTypes();
                    if (noteTypes != null) {
                        for (Jxbv2NoteType note : noteTypes.getNoteType()) {
                            if (note.getUid() == null) {
                                note.setUid(getUUID());
                            } else {
                                if (!isValid(note.getUid().toString())) {
                                    note.setUid(getUUID());
                                }
                            }
                        }
                    }

                    final Jxbv2ExternDocumentTypes docTypes = stereotype.getExternDocumentTypes();
                    if (docTypes != null) {
                        for (Jxbv2ExternDocumentType doc : docTypes.getExternDocumentType()) {
                            if (doc.getUid() == null) {
                                doc.setUid(getUUID());
                            } else {
                                if (!isValid(doc.getUid().toString())) {
                                    doc.setUid(getUUID());
                                }
                            }
                        }
                    }

                }

                for (Jxbv2Stereotype stereotype : profile.getStereotype()) {
                    if (stereotype.getUid() == null) {
                        stereotype.setUid(getUUID());
                    } else {
                        if (!isValid(stereotype.getUid().toString())) {
                            stereotype.setUid(getUUID());
                        }
                    }

                    final org.modelio.gproject.data.module.jaxbv2.Jxbv2Module.Jxbv2Profiles.Jxbv2Profile.Jxbv2Stereotype.Jxbv2TagTypes tagTypes = stereotype.getTagTypes();
                    if (tagTypes != null) {
                        for (Jxbv2TagType tag : tagTypes.getTagType()) {
                            if (tag.getUid() == null) {
                                tag.setUid(getUUID());
                            } else {
                                if (!isValid(tag.getUid().toString())) {
                                    tag.setUid(getUUID());
                                }
                            }
                        }
                    }

                    final org.modelio.gproject.data.module.jaxbv2.Jxbv2Module.Jxbv2Profiles.Jxbv2Profile.Jxbv2Stereotype.Jxbv2NoteTypes noteTypes = stereotype.getNoteTypes();
                    if (noteTypes != null) {
                        for (Jxbv2NoteType note : noteTypes.getNoteType()) {
                            if (note.getUid() == null) {
                                note.setUid(getUUID());
                            } else {
                                if (!isValid(note.getUid().toString())) {
                                    note.setUid(getUUID());
                                }
                            }
                        }
                    }

                    final org.modelio.gproject.data.module.jaxbv2.Jxbv2Module.Jxbv2Profiles.Jxbv2Profile.Jxbv2Stereotype.Jxbv2ExternDocumentTypes docTypes = stereotype.getExternDocumentTypes();
                    if (docTypes != null) {
                        for (Jxbv2ExternDocumentType doc : docTypes.getExternDocumentType()) {
                            if (doc.getUid() == null) {
                                doc.setUid(getUUID());
                            } else {
                                if (!isValid(doc.getUid().toString())) {
                                    doc.setUid(getUUID());
                                }
                            }
                        }
                    }

                    final Jxbv2PropertyTableDefinition propertyTable = stereotype.getPropertyTable();
                    if (propertyTable != null) {
                        if (propertyTable.getUid() == null) {
                            propertyTable.setUid(getUUID());
                        } else {
                            if (!isValid(propertyTable.getUid().toString())) {
                                propertyTable.setUid(getUUID());
                            }
                        }

                        for (Jxbv2PropertyDefinition propertyDefinition : propertyTable.getPropertyDefinition()) {
                            if (propertyDefinition.getUid() == null) {
                                propertyDefinition.setUid(getUUID());
                            } else {
                                if (!isValid(propertyDefinition.getUid().toString())) {
                                    propertyDefinition.setUid(getUUID());
                                }
                            }
                        }
                    }
                }
            }
        }

        final Jxbv2Parameters parameters = module.getParameters();
        if (parameters != null) {
            for (Jxbv2Parameter parameter : parameters.getParameter()) {
                if (parameter.getUid() == null) {
                    parameter.setUid(getUUID());
                } else {
                    if (!isValid(parameter.getUid().toString())) {
                        parameter.setUid(getUUID());
                    }
                }

                if (!"Enum".equalsIgnoreCase(parameter.getType()) && parameter.getEnumeration() != null) {
                    parameter.setType("Enum");
                }
            }
        }

        saveModule(module);
    }

    public void addLibrary() throws MojoExecutionException {
        Jxbv2Module module = loadModule();

        saveModule(module);
    }

    private boolean isValid(String uid) {
        try {
            UUID.fromString(uid);
        } catch (Exception e) {
            return false;
        }

        if (this.uids.contains(uid)) {
            return false;
        } else {
            this.uids.add(uid);
        }

        return true;
    }

    private String getUUID() {
        return UUID.randomUUID().toString();
    }

    private Jxbv2Module loadModule() throws MojoExecutionException {
        try {
            return JaxbModelPersistence.loadJaxbModel(this.moduleFile);
        } catch (IOException e) {
            throw new MojoExecutionException(e.getCause().getMessage());
        }
    }

    private void saveModule(Jxbv2Module module) throws MojoExecutionException {
        try {
            // JaxbModelPersistence.saveJaxbModel(module, this.moduleFile);
            // Do not use saveJaxbModel, we need to format the file...
            try (OutputStream outputStream = Files.newOutputStream(this.moduleFile)) {
                String packageName = Jxbv2Module.class.getPackage().getName();
                JAXBContext jaxbContext = JAXBContext.newInstance(packageName);
                Marshaller marshaller = jaxbContext.createMarshaller();
                marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

                marshaller.marshal(module, outputStream);
            } catch (JAXBException e) {
                throw new IOException(e);
            }
        } catch (IOException e) {
            throw new MojoExecutionException(e.getCause().getMessage());
        }
    }
}

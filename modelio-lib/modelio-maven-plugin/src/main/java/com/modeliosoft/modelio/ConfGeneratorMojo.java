package com.modeliosoft.modelio;

import java.io.File;
import java.util.Collection;
import java.util.stream.Collectors;
import org.apache.maven.artifact.Artifact;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.plugins.annotations.ResolutionScope;
import com.modeliosoft.modelio.moduleconf.ConfEditionService;

/**
 * Update module.xml file.
 *
 * goal: module-configuration
 * phase: generate-sources
 * requiresDependencyResolution: compile
 */
@Mojo(name="module-configuration", defaultPhase=LifecyclePhase.GENERATE_SOURCES, requiresDependencyResolution=ResolutionScope.COMPILE)
public class ConfGeneratorMojo extends AbstractMojo {
    /**
     * Location of the file to generate Uids into.
     *
     * parameter: default-value="res/module.xml"
     */
    @Parameter(defaultValue="res/module.xml")
    private File moduleFile;


    /** 
     * mavenProject
     *
     * parameter: expression="${project}"
     */
    @Parameter(defaultValue="${project}", readonly=true)
    private org.apache.maven.project.MavenProject mavenProject;

    @Override
    public void execute() throws MojoExecutionException {
        getLog().info("Updating content of " + this.moduleFile);

        Collection<Artifact> dependencies = ((Collection<Artifact>) this.mavenProject.getArtifacts())
                .stream()
                .filter(a -> !excludeDependency(a))
                .collect(Collectors.toList());

        updateModuleConfFile(this.moduleFile, dependencies);
    }

    public File getModuleFile() {
        return this.moduleFile;
    }

    private void updateModuleConfFile(File moduleConfFile, Collection<Artifact> dependencies) throws MojoExecutionException {
        ConfEditionService service = new ConfEditionService(moduleConfFile.toPath(), dependencies);
        service.updateModuleFile();
    }

    private boolean excludeDependency(Artifact dependency) {
        String id = dependency.getArtifactId();
        if ("provided".equals(dependency.getScope()) 
                || id.startsWith("org.modelio.documentation") 
                || id.startsWith("com.modeliosoft.modelio.documentation")) {
            return true;
        }

        return false;
    }

}

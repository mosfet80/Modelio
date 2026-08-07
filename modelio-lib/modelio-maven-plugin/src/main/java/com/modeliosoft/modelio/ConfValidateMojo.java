package com.modeliosoft.modelio;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.maven.artifact.Artifact;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.plugins.annotations.ResolutionScope;
import org.apache.maven.project.MavenProject;

import com.modeliosoft.modelio.moduleconf.ConfValidation;

/**
 * Validate module.xml file.
 *
 * goal: module-validation
 * phase: validate
 */
@Mojo(
        defaultPhase=LifecyclePhase.VALIDATE, 
        name = "module-validation", 
        requiresProject=true, 
        requiresDependencyResolution = ResolutionScope.COMPILE)
public class ConfValidateMojo extends AbstractMojo {
    /**
     * Location of the file module.xml into.
     *
     */
    @Parameter(defaultValue="res/module.xml")
    private File moduleFile;

    /**
     * Any Object to print out.
     */
    @Parameter(defaultValue="${project.basedir}/src/main/java/")
    private File sourceBasedir;

    /**
     * The project version.
     *
     * parameter: default-value="${project.version}"
     */
    @Parameter(defaultValue="${project.version}")
    private String version;

    /**
     * The Maven Project.
     */
    @Parameter(required=true, readonly=true, defaultValue="${project}")
    private MavenProject project;


    @Override
    public void execute() throws MojoExecutionException {

        final List<String> classpathElements = getClasspathElements();
        if (classpathElements.isEmpty()) {
            throw new MojoExecutionException("no element in classpath");
        }

        getLog().info("Updating content of " + this.moduleFile);
        validateClassPath(classpathElements);
    }



    /**
     *
     * @return the module version.
     */
    public String getVersion() {
        return this.version;
    }

    /**
     * Get the path to "module.xml" file.
     * @return the module.xml file path
     */
    public File getModuleFile() {
        return this.moduleFile;
    }


    /**
     * Get the directory where the java sources of the module are stored.
     * @return the java sources directory
     */
    public File getSourceBasedir() {
        return this.sourceBasedir;
    }

    /**
     *
     * @param sourceBasedir the java sources directory.
     */
    public void setSourceBasedir(File sourceBasedir) {
        this.sourceBasedir = sourceBasedir;
    }

    private void validateClassPath( List<String> classpathElements) throws MojoExecutionException {
        ConfValidation service = new ConfValidation(this.moduleFile.toPath(), this.sourceBasedir.toPath(), this.version,classpathElements);
        service.validate();
    }

    /**
     * Get the class path of the module
     * @return a list of jar file paths.
     */
    protected List<String> getClasspathElements() {

        final List<String> paths = new ArrayList<>();

        /*
         * Add build dependencies as classpath elements
         */
        final Collection<Artifact> dependencies = this.project.getArtifacts();
        if ( dependencies != null ) {
            for ( Artifact dependency : dependencies ) {
                getLog().debug( String.format(
                        "Adding '%s-%s' artifact : %s",
                        dependency.getArtifactId(),
                        dependency.getVersion(), 
                        dependency.getFile().getPath() ));
                
                paths.add( dependency.getFile().getPath() );

                /*if ( dependency.getSystemPath() != null ) {
                    getLog().debug( "Adding dependency with systemPath " + dependency.getSystemPath() );
                    paths.add( dependency.getSystemPath() );
                } else {
                    getLog().debug( "Adding artifact " + dependency.getFile().getPath() );
                    paths.add( dependency.getFile().getPath() );
                }*/
            }
        }
        return paths;
    }
}

package com.modeliosoft.modelio;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.modelio.vbasic.files.FileUtils;

/**
 * Generates Java sources from a Modelio project.
 *
 * goal: generate-modelio-sources
 * phase: generate-sources
 */
@Mojo(name="generate-modelio-sources", defaultPhase=LifecyclePhase.GENERATE_SOURCES)
public class ModelioSourceGeneratorMojo extends AbstractModelioLauncherMojo {
    /**
     * Launch an SVN update before generation.
     *
     * parameter: default-value="false"
     */
    @Parameter(defaultValue="false")
    private Boolean updateBeforeGeneration;

    protected Boolean getUpdateBeforeGeneration() {
        return this.updateBeforeGeneration;
    }

    @Override
    public void execute() throws MojoExecutionException {
        getLog().info("Generating Java sources");

        try (InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream(this.updateBeforeGeneration ? "updateAndGenerateJavaSources.py" : "generateJavaSources.py")) {

            File tempFile = saveTempFile(resourceAsStream);
            setJythonScriptFile(tempFile);

            resourceAsStream.close();

            super.execute();

            tempFile.delete();
        } catch (IOException e) {
            // Error when closing the stream
            throw new MojoExecutionException("Java sources generation failed: "+FileUtils.getLocalizedMessage(e), e);
        }
    }
}
package com.modeliosoft.modelio;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Mojo;
import org.modelio.vbasic.files.FileUtils;

/**
 * Generates Java sources from a Modelio project.
 *
 * goal: generate-modelio-javadoc
 */
@Mojo(name="generate-modelio-javadoc")
public class ModelioJavaDocGeneratorMojo extends AbstractModelioLauncherMojo {
    @Override
    public void execute() throws MojoExecutionException {
        getLog().info("Generating Javadoc");

        try (InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream("generateJavaDoc.py")) {
            File tempFile = saveTempFile(resourceAsStream);
            setJythonScriptFile(tempFile);

            resourceAsStream.close();

            super.execute();

            tempFile.delete();
        } catch (IOException e) {
            throw new MojoExecutionException("Javadoc generation failed: "+FileUtils.getLocalizedMessage(e), e);
        }
    }

}
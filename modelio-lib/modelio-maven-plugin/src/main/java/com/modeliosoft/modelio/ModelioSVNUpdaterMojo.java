package com.modeliosoft.modelio;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Mojo;
import org.modelio.vbasic.files.FileUtils;

/**
 * Update model from a Modelio project.
 *
 * goal: update-modelio-model
 */
@Mojo(name="update-modelio-model")
public class ModelioSVNUpdaterMojo extends AbstractModelioLauncherMojo {
    @Override
    public void execute() throws MojoExecutionException {
        System.out.println("Updating model from SVN");

        try (InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream("updateModel.py")) {
            File tempFile = saveTempFile(resourceAsStream);
            setJythonScriptFile(tempFile);

            resourceAsStream.close();

            super.execute();

            tempFile.delete();
        } catch (IOException e) {
            // Error when closing the stream
            throw new MojoExecutionException("Model SVN update failed: "+FileUtils.getLocalizedMessage(e), e);
        }
    }
}
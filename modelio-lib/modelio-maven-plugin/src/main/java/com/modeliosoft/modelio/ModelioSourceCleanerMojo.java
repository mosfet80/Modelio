package com.modeliosoft.modelio;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.modelio.vbasic.files.FileUtils;

/**
 * Deletes all Java sources from a Modelio project.
 *
 * goal: clean-modelio-sources
 * phase: clean
 */
@Mojo(name="clean-modelio-sources", defaultPhase=LifecyclePhase.CLEAN)
public class ModelioSourceCleanerMojo extends AbstractModelioLauncherMojo {
    @Override
    public void execute() throws MojoExecutionException {
        getLog().info("Cleaning Java sources ...");

        try (InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream("cleanJavaSources.py")) {

            File tempFile = saveTempFile(resourceAsStream);
            setJythonScriptFile(tempFile);

            resourceAsStream.close();

            super.execute();

            tempFile.delete();
        } catch (IOException e) {
            // Error when closing the stream
            throw new MojoExecutionException("Sources cleaning failed: "+FileUtils.getLocalizedMessage(e), e);
        }
    }
}
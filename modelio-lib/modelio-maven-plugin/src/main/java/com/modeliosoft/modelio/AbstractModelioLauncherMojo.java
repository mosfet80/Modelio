package com.modeliosoft.modelio;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Parameter;
import com.modeliosoft.modelio.utils.ProcessManager;

/**
 * Launches Modelio with a script
 */
public abstract class AbstractModelioLauncherMojo extends AbstractMojo {
    /**
     * Script to use.
     *
     * parameter:
     */
    @Parameter()
    private File jythonScriptFile;

    /**
     * Workspace to use.
     *
     * parameter:
     */
    @Parameter()
    private File workspaceDir;

    /**
     * Project to use.
     *
     * parameter:
     */
    @Parameter()
    private String projectName;

    /**
     * Modelio to use.
     *
     * parameter:
     */
    @Parameter()
    private File modelioDir;

    @Override
    public void execute() throws MojoExecutionException {
        String os_name = System.getProperty("os.name").toString();
        String[] command = {
                this.modelioDir + File.separator + "modelio.exe",
                "-workspace",    this.workspaceDir.toString(),
                "-project",      this.projectName,
                "-batch",        this.jythonScriptFile.toString()
        };
        if (os_name.startsWith("Linux")) {
            command[0] = this.modelioDir + File.separator + "modelio.sh";
        }
        
        ProcessManager pm = new ProcessManager(getLog());
        
        if (pm.execute(command, true) != 0) {
            throw new MojoExecutionException("Error during execution");
        }

    }

    protected File getJythonScriptFile() {
        return this.jythonScriptFile;
    }

    protected void setJythonScriptFile(File jythonScriptFile) {
        this.jythonScriptFile = jythonScriptFile;
    }

    protected File getModelioDir() {
        return this.modelioDir;
    }

    protected void setModelioDir(File modelioDir) {
        this.modelioDir = modelioDir;
    }

    protected File getWorkspaceDir() {
        return this.workspaceDir;
    }

    protected void setWorkspaceDir(File workspaceDir) {
        this.workspaceDir = workspaceDir;
    }

    protected String getProjectName() {
        return this.projectName;
    }

    protected void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    protected File saveTempFile(InputStream in) throws IOException {
        // Create a temporary file
        Path outputFile = Files.createTempFile("modelio-maven", ".py");
        Files.copy(in, outputFile);

        return outputFile.toFile();
    }
}

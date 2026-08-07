package com.modeliosoft.modelio.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.maven.plugin.logging.Log;

/**
 * Utility class used to run a command in a new process.
 * All its output and error messages are redirected into the current {@link Log}.
 */
public class ProcessManager {
    protected Log log;

    /**
     * Constructor initializing the log.
     * @param log the log to write all messages into.
     */
    public ProcessManager(Log log) {
        this.log = log;
    }

    /**
     * Execute the given command in a new process.
     * @param command the command to execute.
     * @param wait indicates if the current thread must wait until the new process has terminated before returning.
     * @return the exit value of the process.
     */
    public int execute(String[] command, boolean wait) {
        Runtime runtime = Runtime.getRuntime();
        String cmd = "";
        for (String s : command) {
            cmd += s + " ";
        }
        try {
            this.log.info(cmd);

            final Process process = runtime.exec(command);

            new Thread () {
                @Override
                public void run() {
                    try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                        String line = "";
                        try {
                            while ((line = reader.readLine()) != null) {
                                ProcessManager.this.log.info(line + System.getProperty("line.separator"));
                            }
                        } finally {
                            reader.close();
                        }
                    } catch (IOException ioe) {
                        ioe.printStackTrace();
                    }
                }
            }.start();

            new Thread () {
                @Override
                public void run() {
                    try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getErrorStream()))) {
                        String line = "";
                        try {
                            while ((line = reader.readLine()) != null) {
                                ProcessManager.this.log.error(line + System.getProperty("line.separator"));
                            }
                        } finally {
                            reader.close();
                        }
                    } catch (IOException ioe) {
                        ioe.printStackTrace();
                    }
                }
            }.start();

            if (wait) {
                process.waitFor();
            }

            return process.exitValue();
        } catch (IOException e) {
            System.err.println("Execution error " + e.getMessage());
        } catch (InterruptedException e) {
            System.err.println("Interrupted " + e.getMessage());
        }
        return -1;
    }
}

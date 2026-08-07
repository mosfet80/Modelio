/*
 * Copyright 2013-2025 Docaposte
 *
 * This file is part of Modelio.
 *
 * Modelio is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Modelio is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Modelio.  If not, see <http://www.gnu.org/licenses/>.
 *
 */
package org.modelio.gproject.migration;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.gproject.plugin.CoreProject;
import org.modelio.vcore.model.spi.mm.IMigrationReporter;
import org.modelio.vcore.model.spi.mm.IMigrationReporter.IMigrationLogger;

/**
 * Basic IMigrationReporter implementation that writes log to a file and store result in a string.
 *
 * @author cmarin
 * @since 3.4
 */
@objid ("d91e1877-ed87-46e8-b81d-9ac739a3034f")
public class BasicMigrationReporter implements IMigrationReporter, Closeable {
    @objid ("cc236137-fbf8-4d08-a7ef-e35a65f01ec6")
    private PrintWriterMigrationLogger logger;

    @objid ("e90d6c9e-281f-47fc-a099-8339a887a0f0")
    private PrintWriterMigrationLogger resultWriter;

    @objid ("e4e4a021-1e54-4764-bca7-b8ebb16453c1")
    private StringWriter result;

    @objid ("45a8bfbe-7f8c-42fa-8970-7b5f77df923f")
    private BufferedWriter fileWriter;

    /**
     *
     * @param reportFile the log file path
     * @throws IOException on failure opening the log file.
     */
    @objid ("39d1ba8d-7e4f-4b85-824b-6dcad22de91e")
    public BasicMigrationReporter(Path reportFile) throws IOException {
        this.result = new StringWriter();
        this.resultWriter = new PrintWriterMigrationLogger(this.result);

        Files.createDirectories(reportFile.getParent());
        this.fileWriter = Files.newBufferedWriter(reportFile);
        this.logger = new PrintWriterMigrationLogger(this.fileWriter);

        this.resultWriter.println(CoreProject.I18N.getMessage("BasicMigrationReporter.logFileWritten", reportFile));

    }

    @objid ("c9ea383a-4e55-4ed9-ac91-c6b3d63e3499")
    @Override
    public IMigrationLogger getLogger() {
        return this.logger;
    }

    @objid ("54bdfabb-1bc7-4824-9861-8f38f01657a4")
    @Override
    public IMigrationLogger getResultReporter() {
        return this.resultWriter;
    }

    /**
     *
     * @return the content stored to {@link #getResultReporter()}
     */
    @objid ("c7dac7ef-bb3a-48e1-95ba-138d37b8ecae")
    public String getResult() {
        return this.result.toString();
    }

    @objid ("b62cec73-13d5-4ee0-a392-922c6bd5aaeb")
    @Override
    public void close() throws IOException {
        if (this.resultWriter != null) {
            this.resultWriter.close();
            this.resultWriter = null;
        }

        if (this.fileWriter != null) {
            this.fileWriter.close();
            this.fileWriter = null;
        }

    }

    @objid ("27187297-ef71-4bf1-92e5-0931c4d291a5")
    private static class PrintWriterMigrationLogger implements IMigrationLogger {
        @objid ("02b9e4bb-f8a8-4b6f-a0e3-146b7771cb38")
        private final PrintWriter writer;

        @objid ("ec1ce6b1-169a-4f24-9fe1-405bb792edf2")
        public PrintWriterMigrationLogger(Writer writer) {
            this.writer = new PrintWriter(writer);
        }

        @objid ("bed72ed0-d56b-4c76-b11c-a035ee60c785")
        @Override
        public void append(CharSequence s) {
            this.writer.append(s);
        }

        @objid ("e3757201-d200-444b-b3e0-1c7f35414c5e")
        @Override
        public void printStackTrace(Throwable e) {
            e.printStackTrace(this.writer);
        }

        @objid ("0ffbd1a4-4552-450d-aeb7-f3039d8a31e4")
        @Override
        public void printf(String format, Object... args) {
            this.writer.printf(format, args);
        }

        @objid ("ceb97a1d-dab2-4ad4-8e0a-3d73fa74a931")
        @Override
        public void format(String format, Object... args) {
            this.writer.format(format, args);
        }

        @objid ("38892e07-097c-4a33-93c7-d360d86fe369")
        @Override
        public void println() {
            this.writer.println();
        }

        @objid ("5c3a9099-9900-4419-aaf5-0b1f42fe9769")
        @Override
        public void println(String s) {
            this.writer.println(s);
        }

        @objid ("1c18ab44-3ec3-4b00-9ff9-5a3d1e6a312d")
        public void close() {
            this.writer.flush();
            this.writer.close();

        }

    }

}

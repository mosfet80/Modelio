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
package org.modelio.vcore.model.spi.mm;

import java.io.PrintWriter;
import java.io.StringWriter;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

/**
 * Interface to report migration log and result.
 *
 * @author cmarin
 * @since 3.4
 */
@objid ("0d5da315-3ca2-4a09-87ef-752b5dc597a5")
public interface IMigrationReporter {
    /**
     *
     * @return The logger to use to report migration details.
     */
    @objid ("c89d11f9-b769-4ad3-bf8b-b9eecfc6c9cd")
    IMigrationLogger getLogger();

    /**
     *
     * @return the writer to use to display  migration result to the user.
     */
    @objid ("eb687b13-f5dc-4641-9545-11afdc51bec0")
    IMigrationLogger getResultReporter();

    /**
     * Extract of {@link java.io.PrintWriter} to avoid billions of "resource not closed" compilation warnings.
     *
     * @author cmarin
     * @since 5.4.1-20240111
     */
    @objid ("c6803ad1-bca3-417d-917f-1e7bdd095e5e")
    interface IMigrationLogger {
        /**
         *
         * @param s a string
         * @see java.io.PrintWriter#println(String)
         */
        @objid ("c46365b2-7286-4022-86e3-21da3c7f9a18")
        default void println(String s) {
            append(s);
            append("\n");

        }

        /**
         *
         * @param format see {@link String#format(String, Object...)}
         * @param args see {@link String#format(String, Object...)}
         * @see java.io.PrintWriter#printf(String, Object...)
         */
        @objid ("ee0dc87d-9bcf-42f5-b277-154b64294aa3")
        default void printf(String format, Object... args) {
            append (String.format(format, args));
        }

        /**
         *
         * @param format see {@link String#format(String, Object...)}
         * @param args see {@link String#format(String, Object...)}
         * @see java.io.PrintWriter#printf(String, Object...)
         * @see #printf(String, Object...)
         */
        @objid ("305dba62-6450-48bb-b14b-6ea75d6cb806")
        default void format(String format, Object... args) {
            printf (format, args);
        }

        /**
         *
         * @see java.io.PrintWriter#println()
         */
        @objid ("47197332-6fa5-4099-a873-8e31b9e27879")
        default void println() {
            append ("\n");
        }

        /**
         * print the stack trace of the exception
         *
         * @param e an exception
         */
        @objid ("7c7338e1-bd4b-40b5-8d96-1b0b9397d76e")
        default void printStackTrace(Throwable e) {
            StringWriter ssw = new StringWriter();
            e.printStackTrace(new PrintWriter(ssw));
            append (ssw.toString());

        }

        /**
         *
         * @param s a string
         * @see java.io.PrintWriter#append(CharSequence)
         */
        @objid ("547392f5-800e-4a44-b021-3d845a8c65f5")
        void append(CharSequence s);

    }

}

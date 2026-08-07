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
/*
 * Copyright 2013-2024 Docaposte
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
/*
 * Copyright 2013-2024 Docaposte
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
package com.sun.star.lib.loader;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.vbasic.files.FileUtils;

/**
 * This class provides functionality for reading string values from the
 * Windows Registry.
 */
@objid ("92ba4fad-0f7b-413b-9782-43d7d00f2b6b")
final class WinRegKey {
    @objid ("f750384b-6e48-4701-9405-c9c772d6d4f4")
    private final String m_keyName;

    /**
     * Constructs a <code>WinRegKey</code>.
     *
     * @param keyName the registry key complete name.
     */
    @objid ("e2dd20dd-d65e-42cb-8025-fd93d8782a7f")
    public WinRegKey(String keyName) {
        this.m_keyName = keyName;
    }

    /**
     * Reads the default string value.
     *
     * @return the default string value.
     * @throws WinRegKeyException on failure
     */
    @objid ("d7f42f22-1b50-41d6-bc65-d4d329afdb6c")
    public String getStringValue() throws WinRegKeyException {
        try {
            // added "/ve" to get only "default" value
            Process p = new ProcessBuilder("reg", "QUERY", this.m_keyName, "/ve")
                    .redirectErrorStream(true)
                    .start();
            try (BufferedReader r = p.inputReader();) {
                String v = null;
                StringBuilder allOut = new StringBuilder();

                // In french " reg query HKLM\Software\Classes\.386 /ve" returns
                //    "    (par défaut)    REG_SZ    vxdfile"
                // or "    (par d?faut)    REG_SZ    C:\Program Files\LibreOffice\program"
                Pattern pt = Pattern.compile("\\s+\\([^()]+\\)\\s+REG_SZ\\s+(.+)");
                for (;;) {
                    String s = r.readLine();
                    if (s == null) {
                        break;
                    }
                    allOut.append(s).append("\n");
                    Matcher m = pt.matcher(s);
                    if (m.matches()) {
                        if (v != null) {
                            // too many lines match
                            throw new RuntimeException("'reg QUERY' did not provided expected output: "+allOut);
                        }
                        v = m.group(1);
                    }
                }
                p.waitFor();
                int e = p.exitValue();
                if (e != 0) {
                    // Should happen only when the registry key is not found :
                    // "Erreur : Erreur : le système n’a pas trouvé la clé ou la valeur de Registre spécifiée."
                    throw new WinRegKeyException("'reg QUERY' exited with code " + e + ":\n" + allOut);
                }
                if (v == null) {
                    // Exit code '0' but no line matched regex
                    throw new RuntimeException("'reg QUERY' did not provide expected output: "+allOut);
                }
                return v;
            }
        } catch (InterruptedException e) {
            throw new WinRegKeyException(e);
        } catch (IOException e) {
            throw new WinRegKeyException(FileUtils.getLocalizedMessage(e), e);
        }
    }

}

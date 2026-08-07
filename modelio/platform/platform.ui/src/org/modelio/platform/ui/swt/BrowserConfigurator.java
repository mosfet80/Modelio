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
package org.modelio.platform.ui.swt;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.swt.SWT;
import org.eclipse.swt.SWTError;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.widgets.Composite;
import org.modelio.platform.ui.plugin.UI;

/**
 * {@link Browser} widget factory.
 * <p>
 * Used to try to instantiate Edge browser on Windows, with fallback to Internet Explorer.
 * <p>
 * <h2>Usage</h2>
 * Preferably call {@link #newBrowser(Composite, int)} .
 * <p>
 * If your content is not compatible with Edge security policies, fall back to IE with {@link #oldBrowser(Composite, int)}.
 *
 * @see org.eclipse.swt.browser.Edge
 */
@objid ("9ebc8ad1-7f6e-405a-8367-ebe8c3351e44")
public class BrowserConfigurator {
    /**
     * See org.eclipse.swt.browser.Edge#DATA_DIR_PROP
     */
    @objid ("82f998a7-8fb8-46c7-a761-d978bb5fd476")
    private static final String EDGE_DATA_DIR = "org.eclipse.swt.browser.EdgeDataDir";

    /**
     * See org.eclipse.swt.browser.Edge#BROWSER_DIR_PROP
     */
    @objid ("71440917-a282-48c8-9d70-45daf95b7645")
    @SuppressWarnings("unused")
    private static final String BROWSER_DIR_PROP = "org.eclipse.swt.browser.EdgeDir";

    /**
     * Becomes true when Edge instantiation did not work.
     */
    @objid ("28e5b1ba-874b-4ac6-bd11-ec34781c80c5")
    private static boolean fallBackNeeded = false;

    /**
     * Instantiate an SWT Browser dependent of the system.
     * <p>
     * On Windows try to instantiate <b>Edge</b>.
     *
     * @param parent a widget which will be the parent of the new Browser (cannot be null)
     * @param style the style of Browser widget to construct
     * @return a SWT Browser widget.
     */
    @objid ("3b0d5b56-ac26-4431-915b-c43a08fcf113")
    public static Browser newBrowser(Composite parent, int style) {
        String osName = System.getProperty("os.name");
        if (osName.equals("Windows 10") || osName.equals("Windows 11")) {
            if (! fallBackNeeded)
                return newEdgeBrowser(parent, style);
        }

        return new Browser(parent, style );
    }

    @objid ("117d3c8c-572c-4cc1-b2ec-dd0b4ec82c72")
    private static Browser newEdgeBrowser(Composite parent, int style) throws SWTError {
        try {
            assert ((style & SWT.WEBKIT) == 0) : "style contains SWT.WEBKIT";

            return new Browser(parent, SWT.EDGE | style);
        } catch (SWTError e) {
            if (e.code == SWT.ERROR_NO_HANDLES && e.getMessage().contains("0x8007139f")) {
                UI.LOG.warning("Edge Browser instantiation failed with : %s", e.getMessage());

                // org.eclipse.swt.SWTError: No more handles [0x8007139f]
                // see: https://github.com/eclipse-platform/eclipse.platform.swt/issues/1013
                // see: https://github.com/eclipse-platform/eclipse.platform.swt/blob/2a51e8c925354594e42fc758b332336db937e01c/bundles/org.eclipse.swt/Eclipse%20SWT%20Browser/win32/org/eclipse/swt/browser/Edge.java#L316
                try {
                    Path tempRoot = Path.of(System.getProperty("java.io.tmpdir"), "modelio");
                    Files.createDirectories(tempRoot);
                    Path tmpDir = Files.createTempDirectory(tempRoot, "Webview-EDGE-");
                    System.setProperty(EDGE_DATA_DIR, tmpDir.toString());
                    tmpDir.toFile().deleteOnExit();
                    UI.LOG.warning("Setting '%s' property to '%s' and try again...", EDGE_DATA_DIR, tmpDir);
                    return new Browser(parent, SWT.EDGE | style);
                } catch (SWTError | IOException e1) {
                    e1.addSuppressed(e);
                    UI.LOG.warning("Edge Browser instantiation failed again with : %s", e1);
                    UI.LOG.warning("Fall back to Internet Explorer...");

                    try {
                        // Fallback to IE
                        fallBackNeeded = true;
                        Browser oldBrowser = oldBrowser(parent, style);
                        // log debug the exception on success.
                        UI.LOG.debug(e);
                        return oldBrowser;
                    } catch (SWTError e2) {
                        e2.addSuppressed(e1);
                        // Log all and rethrow
                        UI.LOG.error(e);
                        throw e2;
                    }
                }
            }
            throw e;
        }
    }

    @objid ("145a6713-e45a-4f2d-9ae1-7f4f32f9b76d")
    @Deprecated
    public static Browser oldBrowser(Composite parent, int style) {
        return new Browser(parent, style & ~SWT.EDGE );
    }

}

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
package org.modelio.archimate.ui.plugin;

import java.util.ResourceBundle;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.equinox.log.ExtendedLogService;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.modelio.platform.utils.i18n.BundledMessages;
import org.modelio.platform.utils.log.writers.PluginLogger;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

/**
 * The activator class controls the plug-in life cycle
 */
@objid ("25d5a9bb-0ec5-4cef-aa65-116d9712772b")
public class ArchiUiOrg extends AbstractUIPlugin {
    /**
     * The plug-in ID
     */
    @objid ("7b5e3c41-f20c-4929-b390-7cf19704d957")
    public static final String PLUGIN_ID = "org.modelio.archimate.ui.ext"; // $NON-NLS-1$


    @objid ("a7c28dcd-ff9e-4d8f-8417-051628c5178b")
    private static BundleContext context;

    /**
     * The plug-in's i18n bundle.
     */
    @objid ("9f6e7706-e60c-45f6-b6a5-b50a625d04c4")
    public static BundledMessages I18N;

    /**
     * The plug-in's logger.
     */
    @objid ("5ac246af-0473-4c99-afb7-92a7fe99c037")
    public static PluginLogger LOG;

    @objid ("fbef767c-4e56-4537-92e6-4b0ffc46b95c")
    @Override
    public void start(final BundleContext bundleContext) throws Exception {
        ArchiUiOrg.context = bundleContext;
        ServiceReference<ExtendedLogService> ref = bundleContext
                .getServiceReference(ExtendedLogService.class);
        ExtendedLogService service = bundleContext.getService(ref);
        ArchiUiOrg.LOG = new PluginLogger(service.getLogger(bundleContext.getBundle(), ArchiUiOrg.PLUGIN_ID));
        ArchiUiOrg.I18N = new BundledMessages(ArchiUiOrg.LOG, ResourceBundle.getBundle("archibrowser"));

    }

    @objid ("e2e9a4cf-2bb5-4cf9-b887-678f26d12384")
    @Override
    public void stop(final BundleContext bundleContext) throws Exception {
        ArchiUiOrg.context = null;
    }

    /**
     * Returns an image descriptor for the image file at the given plug-in
     * relative path
     *
     * @param path the path
     * @return the image descriptor
     */
    @objid ("49398a18-64ec-44a6-82f6-b08cca9c414d")
    public static ImageDescriptor getImageDescriptor(final String path) {
        return AbstractUIPlugin.imageDescriptorFromPlugin(ArchiUiOrg.PLUGIN_ID, path);
    }

    /**
     *
     * @return the bundle's execution context within the Framework.
     */
    @objid ("b4ac6960-669f-4b61-91cc-ea06e2c47d81")
    public static BundleContext getContext() {
        return ArchiUiOrg.context;
    }

}

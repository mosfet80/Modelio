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
package org.modelio.archimate.diagrams.plugin;

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
@objid ("8d66f0f2-ff97-4c9c-b80e-3e7434185348")
public class ArchiDiagrams extends AbstractUIPlugin {
    /**
     * The plug-in ID
     */
    @objid ("b850a871-10ca-4531-b149-c93044dd4fc1")
    public static final String PLUGIN_ID = "org.modelio.archimate.diagrams"; // $NON-NLS-1$


    @objid ("bd6d4ce2-11ac-4c53-a17a-dd05f9029b1e")
    private static BundleContext context;

    /**
     * The plug-in's i18n bundle.
     */
    @objid ("3075e075-83d4-4250-9f47-9f2fcfe676c2")
    public static BundledMessages I18N;

    /**
     * The plug-in's logger.
     */
    @objid ("ddf1a352-5647-4c5c-911f-7499144ec63f")
    public static PluginLogger LOG;

    @objid ("0e22a91a-c913-4c35-85d9-9a496135b063")
    @Override
    public void start(final BundleContext bundleContext) throws Exception {
        context = bundleContext;
        ServiceReference<ExtendedLogService> ref = bundleContext
                .getServiceReference(ExtendedLogService.class);
        ExtendedLogService service = bundleContext.getService(ref);
        LOG = new PluginLogger(service.getLogger(bundleContext.getBundle(), PLUGIN_ID));
        I18N = new BundledMessages(LOG, ResourceBundle.getBundle("archidiagrams"));

    }

    @objid ("6c3c62d5-f1dd-4bd6-849a-5cac989932f3")
    @Override
    public void stop(final BundleContext bundleContext) throws Exception {
        context = null;
    }

    /**
     * Returns an image descriptor for the image file at the given plug-in relative path
     *
     * @param path the path
     * @return the image descriptor
     */
    @objid ("b7849b6d-ba72-4cdf-b8ad-1bf1aa709a4a")
    public static ImageDescriptor getImageDescriptor(final String path) {
        return AbstractUIPlugin.imageDescriptorFromPlugin(PLUGIN_ID, path);
    }

    /**
     *
     * @return the bundle's execution context within the Framework.
     */
    @objid ("260616f1-f151-49a7-9e56-4de37bba2e5d")
    public static BundleContext getContext() {
        return context;
    }

}

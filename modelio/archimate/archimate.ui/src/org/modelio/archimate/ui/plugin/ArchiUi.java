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
@objid ("b22ddb96-74eb-4770-aa01-dd9bc4bf855a")
public class ArchiUi extends AbstractUIPlugin {
    /**
     * The plug-in ID
     */
    @objid ("a3d023cc-a401-453e-bfed-a45b2267de57")
    public static final String PLUGIN_ID = "org.modelio.archimate.ui"; // $NON-NLS-1$


    @objid ("aa8bf7a0-6408-4b10-89c5-cf59f44b3696")
    private static BundleContext context;

    /**
     * The plug-in's i18n bundle.
     */
    @objid ("993e6267-f58d-4756-8456-da3097d9759d")
    public static BundledMessages I18N;

    /**
     * The plug-in's logger.
     */
    @objid ("6f257a59-c67e-46ae-af58-1533f549622c")
    public static PluginLogger LOG;

    @objid ("7ea37158-be07-46e8-9228-25611ba30624")
    @Override
    public void start(final BundleContext bundleContext) throws Exception {
        context = bundleContext;
        ServiceReference<ExtendedLogService> ref = bundleContext
                .getServiceReference(ExtendedLogService.class);
        ExtendedLogService service = bundleContext.getService(ref);
        LOG = new PluginLogger(service.getLogger(bundleContext.getBundle(), PLUGIN_ID));
        I18N = new BundledMessages(LOG, ResourceBundle.getBundle("archibrowser"));

    }

    @objid ("d9dfbea5-053c-4059-9b21-f078b7ad5db0")
    @Override
    public void stop(final BundleContext bundleContext) throws Exception {
        context = null;
    }

    /**
     * Returns an image descriptor for the image file at the given plug-in
     * relative path
     *
     * @param path the path
     * @return the image descriptor
     */
    @objid ("1b20ac07-2da7-456d-bbbb-849c2a05d9c0")
    public static ImageDescriptor getImageDescriptor(final String path) {
        return AbstractUIPlugin.imageDescriptorFromPlugin(PLUGIN_ID, path);
    }

    /**
     *
     * @return the bundle's execution context within the Framework.
     */
    @objid ("cb2dfbcb-2a84-488d-afd7-1093aa3e3cfb")
    public static BundleContext getContext() {
        return context;
    }

}

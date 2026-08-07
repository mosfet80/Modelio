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
package org.modelio.archimate.exchange.plugin;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.URIUtil;
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
@objid ("29a928d6-8168-4f80-8b11-ae17f0410a04")
public class ArchiExchange extends AbstractUIPlugin {
    /**
     * The plug-in ID
     */
    @objid ("cfca3e10-7c67-47ca-8972-7235e74c8b1f")
    public static final String PLUGIN_ID = "org.modelio.archimate.exchange"; // $NON-NLS-1$


    @objid ("be67902c-b063-4fd8-a705-2ca1769208bd")
    private static BundleContext context;

    /**
     * The plug-in's i18n bundle.
     */
    @objid ("ebfc05ad-0a9d-4311-b257-c2519a745c79")
    public static BundledMessages I18N;

    /**
     * The plug-in's logger.
     */
    @objid ("5e6c2fb8-44fa-467c-9158-c03636f7ce41")
    public static PluginLogger LOG;

    @objid ("ee2337ed-9f81-4f40-b893-b86feceab594")
    @Override
    public void start(final BundleContext bundleContext) throws Exception {
        context = bundleContext;
        ServiceReference<ExtendedLogService> ref = bundleContext
                .getServiceReference(ExtendedLogService.class);
        ExtendedLogService service = bundleContext.getService(ref);
        LOG = new PluginLogger(service.getLogger(bundleContext.getBundle(), PLUGIN_ID));
        I18N = new BundledMessages(LOG, ResourceBundle.getBundle("archiexchange"));

    }

    @objid ("ddd8ed1d-4528-482b-a47f-ae454c0175ef")
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
    @objid ("f0b74652-ff91-4721-8ca4-fa1f03d963e1")
    public static ImageDescriptor getImageDescriptor(final String path) {
        return AbstractUIPlugin.imageDescriptorFromPlugin(PLUGIN_ID, path);
    }

    /**
     *
     * @return the bundle's execution context within the Framework.
     */
    @objid ("5e400927-fe2a-4289-b51e-99a6cc69440a")
    public static BundleContext getContext() {
        return context;
    }

    @objid ("3eab7ddc-e5a8-466f-b36a-5f81446e68c1")
    public static File getBundleFile(final String relPath) throws ResourceNotFoundError {
        try {
            URL url = FileLocator.find(context.getBundle(), new Path(relPath), null);
            URL fileUrl = FileLocator.toFileURL(url);
            return new File(URIUtil.toURI(fileUrl));
        } catch (IOException | URISyntaxException | RuntimeException e  ) {
            // should never occur
            final ResourceNotFoundError e1 = new ResourceNotFoundError("'"+relPath+"' not found in plugin.", e);
            LOG.error(e1);
            throw e1;
        }

    }

    @objid ("0b4d1886-7ea6-40f8-8ed6-28e2619237df")
    public static class ResourceNotFoundError extends Error {
        @objid ("e93fd5a9-80e1-4813-ae03-dd9a5cf38d7e")
        public ResourceNotFoundError(String message, Throwable cause) {
            super(message, cause);
            // TODO Auto-generated constructor stub

        }

    }

}

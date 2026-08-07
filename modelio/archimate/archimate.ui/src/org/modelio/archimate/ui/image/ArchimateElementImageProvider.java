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
package org.modelio.archimate.ui.image;

import java.net.URL;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;
import org.modelio.archimate.metamodel.core.ArchimateAbstractElement;
import org.modelio.archimate.metamodel.core.structure.Model;
import org.modelio.archimate.metamodel.visitors.DefaultArchimateVisitor;
import org.modelio.archimate.ui.plugin.ArchiUi;
import org.modelio.platform.model.ui.swt.images.spi.IElementImageProvider;
import org.modelio.platform.model.ui.swt.images.spi.IMetamodelImageProvider;
import org.modelio.platform.ui.swt.QualifiedImage;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.mapi.MObject;

/**
 * Default image provider with Archimate elements for the model browser.
 */
@objid ("af917178-8db8-468e-ae1c-d66e736d68f9")
public class ArchimateElementImageProvider implements IElementImageProvider, IMetamodelImageProvider {
    @objid ("37821fb8-80b7-4537-a209-428dfe27704d")
    private static final String IMAGES_PATH = "mmimages/";

    @objid ("6b2613d0-b337-4fe3-8357-19f056bedcac")
    private static final String IMAGES_EXTENSION = ".png";

    @objid ("b9dd1b12-f933-48d7-ae54-a04ce2cb9b0a")
    private static final ImageRegistry REGISTRY = new ImageRegistry();

    @objid ("97951dca-3f87-496e-8b36-5aa3c3507546")
    @Override
    public QualifiedImage getIcon(MObject element) {
        return getIcon(element.getMClass(), getFlavor(element));
    }

    /**
     * Get the icon for a metaclass and a flavor
     *
     * @param metaclass a metaclass
     * @param flavor a flavor to concatenate to the lookup key.
     * @return the found icon or a default unknown icon.
     */
    @objid ("1e4637cf-3a3f-444d-9313-ee247f6422de")
    @Override
    public QualifiedImage getIcon(MClass metaclass, String flavor) {
        // since 3.8.1 ALWAYS get metaclass icons by a qualified name
        return getImageFromKey(getIconKey(metaclass, flavor));
    }

    @objid ("2acdc6ca-53c1-4cb2-964b-0ad72e7385f7")
    @Override
    public QualifiedImage getImage(MObject element) {
        return getImage(element.getMClass(), getFlavor(element));
    }

    /**
     * Get the diagram big image for a metaclass and a flavor.
     *
     * @param metaclass a metaclass
     * @param flavor a flavor to concatenate to the lookup key.
     * @return the found image or null.
     */
    @objid ("feb6f754-1406-4839-b0bb-4f4ca697f9aa")
    @Override
    public QualifiedImage getImage(MClass metaclass, String flavor) {
        final String key = getImageKey(metaclass, flavor);
        return getImageFromKey(key);
    }

    /**
     *
     * @return a flavor to concatenate to the lookup key. Might be <code>null</code>.
     */
    @objid ("0b47d1a1-5bd1-4e45-b2ac-f85e99f51d29")
    private String getFlavor(MObject element) {
        return (String) element.accept(new ImageFlavorBuilder());
    }

    @objid ("03c9eda2-3376-4d99-8b8a-fe27177a3b2e")
    private String getImageKey(MClass metaclass, String flavor) {
        return getIconKey(metaclass, flavor) + ".image";
    }

    @objid ("8bbe0b21-fe31-48e0-a373-bda08c6bf01e")
    private String getIconKey(MClass metaclass, String flavor) {
        final String className = metaclass.getQualifiedName();
        if (flavor == null || flavor.isEmpty()) {
            return className;
        } else {
            final StringBuilder keyBuffer = new StringBuilder(className.length() + flavor.length() + 1);
            keyBuffer.append(className);
            keyBuffer.append(".");
            keyBuffer.append(flavor);
            return keyBuffer.toString();
        }

    }

    @objid ("b882e77d-ecfd-43f3-bf06-9512dacf511b")
    private Image loadImage(String key) {
        final IPath imagePath = new Path(getIconPath(key));
        URL url = FileLocator.find(ArchiUi.getContext().getBundle(), imagePath, null);
        if (url != null) {
            ImageDescriptor desc = ImageDescriptor.createFromURL(url);
            return desc.createImage();
        }
        return null;
    }

    /**
     * Get the icon for a metaclass.
     *
     * @param metaclassName a metaclass name.
     * @return the metaclass icon.
     */
    @objid ("84d36b67-9f58-40a9-be87-4328d65d2c2c")
    @Override
    public QualifiedImage getIcon(final String metaclassName) {
        return getImageFromKey(metaclassName);
    }

    /**
     * Get the image for a given key.
     * <p>
     * The image is loaded into the registry if not yet done.
     * @return
     */
    @objid ("2ae65942-d891-499d-8791-a92f6b2ef62f")
    private QualifiedImage getImageFromKey(final String key) {
        Image image = ArchimateElementImageProvider.REGISTRY.get(key);

        if (image == null) {
            image = loadImage(key);
            if (image != null) {
                ArchimateElementImageProvider.REGISTRY.put(key, image);
            } else {
                return null;
            }
        }
        // Image is not null
        return new QualifiedImage(image, key);
    }

    /**
     * Get the relative file name from the current plugin.
     */
    @objid ("a9af5acb-1186-43e9-b743-7a271837ba6e")
    private String getIconPath(String key) {
        final StringBuilder path = new StringBuilder(ArchimateElementImageProvider.IMAGES_PATH);
        path.append(key.toLowerCase());
        path.append(ArchimateElementImageProvider.IMAGES_EXTENSION);
        return path.toString();
    }

    @objid ("e7bb02ad-2047-4115-b32f-c011731235f9")
    @Override
    public String getIconCompletePath(String metaclassName) {
        String iconPath = getIconPath(metaclassName);
        final IPath imagePath = new Path(iconPath);
        URL url = FileLocator.find(ArchiUi.getContext().getBundle(), imagePath, null);
        if (url != null) {
            StringBuilder ret = new StringBuilder();
            ret.append("platform:/plugin/");
            ret.append(ArchiUi.PLUGIN_ID);
            ret.append("/");
            ret.append(iconPath);
            return ret.toString();
        } else {
            return null;
        }

    }

    @objid ("4333e172-47a8-4273-94db-7c89d6804459")
    @Override
    public String getIconCompletePath(MClass metaclass) {
        final String key = getIconKey(metaclass, null);
        return getIconCompletePath(key);
    }

    /**
     * Visitor that computes a flavor to concatenate to the lookup key for a given element.
     */
    @objid ("84996846-0ef3-4438-a08a-b2fec3ee2bb9")
    protected static class ImageFlavorBuilder extends DefaultArchimateVisitor {
        @objid ("4b1495d2-de19-4d09-bdd2-002113631563")
        @Override
        public Object visitArchimateAbstractElement(ArchimateAbstractElement theArchimateAbstractElement) {
            return null;
        }

        @objid ("d74d90d4-6c5b-40c9-b74f-98eda1e8da68")
        @Override
        public Object visitModel(Model obj) {
            // Do not call super, we do not want the layer image
            return null;
        }

    }

}

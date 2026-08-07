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
package org.modelio.platform.model.ui.swt.images;

import java.net.URL;
import java.util.HashMap;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.DecorationOverlayIcon;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.swt.graphics.Image;
import org.modelio.gproject.core.IGModelFragment;
import org.modelio.gproject.core.IGPartState.GPartStateEnum;
import org.modelio.gproject.data.project.GProjectPartDescriptor;
import org.modelio.gproject.data.project.GProjectPartDescriptor.GProjectPartType;
import org.modelio.platform.model.ui.plugin.CoreUi;
import org.osgi.framework.Bundle;

/**
 * Service to get an image for model fragments.
 */
@objid ("40ae8cf1-3304-4650-aee6-e0c14e7ecee9")
public class FragmentImageService {
    @objid ("d128fdd9-cc53-45ae-8fef-c61a48070718")
    private static final String IMAGES_PATH = "icons/";

    @objid ("61dea506-b2f9-4ee4-b1cc-ef3535e72c5e")
    private static final HashMap<GProjectPartType, Image> upImages = new HashMap<>();

    @objid ("c6325a8a-8bcc-4ef8-97ec-05260d1d3f02")
    private static final HashMap<GProjectPartType, Image> downImages = new HashMap<>();

    @objid ("efb995a2-f477-4f58-9285-785636e25cde")
    private static final Bundle bundle = Platform.getBundle(CoreUi.PLUGIN_ID);

    @objid ("7c5c9f97-c8c1-4264-be9d-49e496f62297")
    private static final Image UNDEFINED_FRAGMENT_IMAGE;

    @objid ("2099a341-492d-45a7-b5ab-3f5730f390be")
    private static final Image UNDEFINED_FRAGMENT_DOWN_IMAGE;

    @objid ("e0fae795-4d81-48ad-ab4f-7c273a9ed2ff")
    private static final Image FRAG_STATE_DOWN;

    @objid ("331e9607-745f-4908-a79e-c86e75f83dfa")
    private static final Image FRAG_STATE_MOUNTING;

    @objid ("b6488c50-9c45-4c75-a877-a2a2c614c9c4")
    private static final Image FRAG_STATE_UP;

    @objid ("f59ddd4a-857f-46df-b77d-8d53f314eebd")
    private static final Image FRAG_STATE_UP_LIGHT;

    /**
     * Get the image for a model fragment, taking its {@link GPartStateEnum} into account.
     *
     * @param fragment a model fragment.
     * @return an image or <code>null</code> for a <code>null</code> fragment.
     */
    @objid ("3fb5d705-6662-42b8-8f8a-01a6e9e32217")
    public static Image getImage(IGModelFragment fragment) {
        // null object special case
        if (fragment == null) {
            return null;
        }

        Image image = null;
        if (fragment.getState().getValue() == GPartStateEnum.DOWN) {
            image = FragmentImageService.downImages.get(fragment.getType());
        } else {
            image = FragmentImageService.upImages.get(fragment.getType());
        }

        if (image == null) {
            CoreUi.LOG.warning("No image found for fragment type: " + fragment.getType());
            if (fragment.getState().getValue() == GPartStateEnum.DOWN) {
                image = FragmentImageService.UNDEFINED_FRAGMENT_DOWN_IMAGE;
            } else {
                image = FragmentImageService.UNDEFINED_FRAGMENT_IMAGE;
            }
        }
        return image;
    }

    @objid ("0c09451c-4624-4144-b180-38daa29ba685")
    private static Image loadImage(String imageFileName) {
        ImageDescriptor desc = null;
        Image image = null;

        // Get the relative file name
        final StringBuilder path = new StringBuilder(FragmentImageService.IMAGES_PATH);
        path.append(imageFileName);

        final IPath imagePath = new Path(path.toString());
        final URL url = FileLocator.find(FragmentImageService.bundle, imagePath, null);
        assert (url != null);

        if (url != null) {
            desc = ImageDescriptor.createFromURL(url);
            image = desc.createImage();
            assert (image != null);
        }
        return image;
    }

    /**
     * Get the image for {@link GPartStateEnum}.
     *
     * @param fragmentState a fragment state.
     * @return an image or <code>null</code> for a <code>null</code> state.
     */
    @objid ("8acb7ee0-8813-43d3-afe1-35bb72db6dd3")
    public static Image getStateImage(GPartStateEnum fragmentState) {
        if (fragmentState == null) {
            return null;
        }

        switch (fragmentState) {
        case DOWN:
        case INSTANTIATED:
            return FragmentImageService.FRAG_STATE_DOWN;
        case MOUNTING:
            return FragmentImageService.FRAG_STATE_MOUNTING;
        case MOUNTED:
            return FragmentImageService.FRAG_STATE_UP;
        default:
            return null;
        }
    }

    /**
     * Get the image for a fragment descriptor.
     *
     * @param fragment a fragment descriptor.
     * @return an image or <code>null</code> for a <code>null</code> descriptor.
     */
    @objid ("6bbbd64d-3ec5-46a6-b1b7-d86cdd90d1b7")
    public static Image getImage(GProjectPartDescriptor fragment) {
        // null object special case
        if (fragment == null) {
            return null;
        } else {
            return getImage(fragment.getType());
        }
    }

    /**
     * Get the image for a fragment type.
     *
     * @param type a fragment type.
     * @return an image.
     */
    @objid ("240c3a63-d851-4229-883e-13e5d5380a50")
    public static Image getImage(GProjectPartType type) {
        Image image = FragmentImageService.upImages.get(type);
        if (image == null) {
            CoreUi.LOG.warning("No image found for fragment type: " + type);
            image = FragmentImageService.UNDEFINED_FRAGMENT_IMAGE;
        }
        return image;
    }

    @objid ("682b99e7-daa2-429c-8f82-7591515b8865")
    private static void initFragmentImages(GProjectPartType type, String fileName, ImageDescriptor downOverlay) {
        Image loadedImage = loadImage(fileName);
        upImages.put(type, loadedImage);
        downImages.put(type, (new DecorationOverlayIcon(
                loadedImage,
                downOverlay,
                IDecoration.BOTTOM_RIGHT)).createImage());
    }

static {
                                final IPath downOverlayPath = new Path(FragmentImageService.IMAGES_PATH + "down_indicator.png");
                                final URL downOverlayUrl = FileLocator.find(FragmentImageService.bundle, downOverlayPath, null);
                                assert (downOverlayUrl != null) : "missing file 'icons/down_indicator.png' at "+downOverlayPath;
                                final ImageDescriptor downOverlay = ImageDescriptor.createFromURL(downOverlayUrl);

                                UNDEFINED_FRAGMENT_IMAGE = loadImage("undefinedfragment.png");
                                UNDEFINED_FRAGMENT_DOWN_IMAGE = (new DecorationOverlayIcon(
                                        UNDEFINED_FRAGMENT_IMAGE,
                                        downOverlay,
                                        IDecoration.BOTTOM_RIGHT)).createImage();

                                initFragmentImages(GProjectPartType.EXMLFRAGMENT, "exmlfragment.png", downOverlay);
                                initFragmentImages(GProjectPartType.RAMC, "ramcfragment.png", downOverlay);
                                initFragmentImages(GProjectPartType.MODULE, "mdafragment.png", downOverlay);
                                initFragmentImages(GProjectPartType.HTTPFRAGMENT, "httpfragment.png", downOverlay);
                                initFragmentImages(GProjectPartType.SVNFRAGMENT, "svnfragment.png", downOverlay);
                                initFragmentImages(GProjectPartType.CONFERENCEFRAGMENT, "conferencefragment.png", downOverlay);

                                // fragment state images
                                FRAG_STATE_DOWN = loadImage("fragment_state_down.png");
                                FRAG_STATE_MOUNTING = loadImage("fragment_state_mounting.png");
                                FRAG_STATE_UP = loadImage("fragment_state_up.png");
                                FRAG_STATE_UP_LIGHT = loadImage("fragment_state_up_light.png");
                            }

}

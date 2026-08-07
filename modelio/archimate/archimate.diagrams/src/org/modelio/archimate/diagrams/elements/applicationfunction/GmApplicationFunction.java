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
package org.modelio.archimate.diagrams.elements.applicationfunction;

import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.applicationfunction.v0._GmApplicationFunction;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPortContainer;
import org.modelio.archimate.metamodel.layers.application.behavior.ApplicationFunction;
import org.modelio.diagram.elements.common.portcontainer.GmPortContainer;
import org.modelio.diagram.elements.core.model.GmAbstractObject;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.elements.core.node.GmNodeModel;
import org.modelio.diagram.persistence.IDiagramReader;
import org.modelio.diagram.persistence.IDiagramWriter;
import org.modelio.diagram.styles.core.AbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;
import org.modelio.diagram.styles.core.StyleKey.RepresentationMode;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Specialized class for {@link ApplicationFunction}.
 */
@objid ("36b84e9b-860d-4880-b209-c14cd688b9e7")
public class GmApplicationFunction extends GmArchiElementPortContainer<ApplicationFunction> {
    @objid ("edf558b6-41cc-4bcf-992a-49b40c29768e")
    private static final int MAJOR_VERSION = 1;

    /**
     * Current version of this Gm.
     */
    @objid ("f0e26a99-9724-4302-8738-3334357912f0")
    private static final int MINOR_VERSION = 0;

    @objid ("3757a16b-2853-45d5-8c36-7d531fe71837")
    static final AbstractStyleKeyProvider IMAGE_KEYS = new GmApplicationFunctionImageStyleKeys();

    @objid ("3b8643d9-f27d-4c24-b187-c5c10e261ef3")
    static final AbstractStyleKeyProvider SIMPLE_KEYS = new GmApplicationFunctionSimpleStyleKeys();

    @objid ("b69b0ce6-8548-45e0-b9b9-c3ea99bc1d51")
    static final AbstractStyleKeyProvider STRUCTURED_KEYS = new GmApplicationFunctionStructuredStyleKeys();

    @objid ("e1a1b858-7b9f-470c-bfec-ac7845dfab38")
    static final AbstractStyleKeyProvider USERIMAGE_KEYS = new GmApplicationFunctionUserImageStyleKeys();

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the ApplicationFunction is unmasked.
     * @param el the unmasked ApplicationFunction.
     * @param ref a reference to the unmasked ApplicationFunction.
     */
    @objid ("4443b281-6471-4e82-b8bd-dcea6711a3ca")
    public GmApplicationFunction(IGmDiagram diagram, ApplicationFunction el, MRef ref) {
        super(diagram, el, ref);

        GmApplicationFunctionPrimaryNode mainNode = new GmApplicationFunctionPrimaryNode(diagram, el, ref);
        mainNode.setRoleInComposition(GmPortContainer.MAIN_NODE_ROLE);
        addChild(mainNode);

    }

    /**
     * Migration constructor from major version 0, should only be called by migrator.
     *
     * @param oldVersionGm the instance to migrate from.
     */
    @objid ("dc1cf754-733e-4637-8f42-a0200bad464c")
    GmApplicationFunction(final _GmApplicationFunction oldVersionGm) {
        super(oldVersionGm.getDiagram(), oldVersionGm.getRelatedElement(), oldVersionGm.getRepresentedRef());

        GmApplicationFunctionPrimaryNode primary = new GmApplicationFunctionPrimaryNode(oldVersionGm);
        primary.setRoleInComposition(GmPortContainer.MAIN_NODE_ROLE);
        addChild(primary);

    }

    @objid ("81995e3a-252c-4c30-a136-80dec71be7c0")
    @Override
    public int getMajorVersion() {
        return GmApplicationFunction.MAJOR_VERSION;
    }

    @objid ("c6a110ed-767a-46fc-82ff-24a700fd8eec")
    @Override
    public StyleKey getStyleKey(MetaKey metakey) {
        StyleKey styleKey = GmApplicationFunction.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return GmApplicationFunction.IMAGE_KEYS.getStyleKey(metakey);
            case USER_IMAGE:
                return GmApplicationFunction.USERIMAGE_KEYS.getStyleKey(metakey);
            case SIMPLE:
                return GmApplicationFunction.SIMPLE_KEYS.getStyleKey(metakey);
            case STRUCTURED:
                return GmApplicationFunction.STRUCTURED_KEYS.getStyleKey(metakey);
            default:
                break;
            }
        }
        return null;
    }

    @objid ("b0f05671-849d-4973-8dd8-26400b34b713")
    @Override
    public List<StyleKey> getStyleKeys() {
        StyleKey styleKey = GmApplicationFunction.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return GmApplicationFunction.IMAGE_KEYS.getStyleKeys();
            case USER_IMAGE:
                return GmApplicationFunction.USERIMAGE_KEYS.getStyleKeys();
            case SIMPLE:
                return GmApplicationFunction.SIMPLE_KEYS.getStyleKeys();
            case STRUCTURED:
                return GmApplicationFunction.STRUCTURED_KEYS.getStyleKeys();
            default:
                break;
            }
        }
        return Collections.emptyList();
    }

    @objid ("828bced8-e686-49f6-b7ae-49d9c65552dd")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = GmAbstractObject.readMinorVersion(in, "GmApplicationFunction.");
        switch (readVersion) {
        case 0: {
            read_0(in);
            break;
        }
        default: {
            assert (false) : readVersion + " version number not covered!";
            // reading as last handled version: 0
            read_0(in);
            break;
        }
        }

    }

    @objid ("787f99d4-0685-4f2f-ace3-c4de7c7060f0")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        GmAbstractObject.writeMinorVersion(out, "GmApplicationFunction.", GmApplicationFunction.MINOR_VERSION);

    }

    @objid ("656af900-042d-47e2-87c4-6b4ca1bece7e")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("bc8e355a-1317-4b78-a372-fca95be0717c")
    public GmApplicationFunction() {
        // Nothing specific to do.
    }

    @objid ("1c229f1a-88c1-4300-9d8e-11a51c964841")
    @Override
    public List<GmNodeModel> getVisibleChildren() {
        List<GmNodeModel> ret = super.getVisibleChildren();

        GmNodeModel firstChild = getMainNode();
        if (firstChild != null && firstChild.getRepresentationMode() == RepresentationMode.SIMPLE) {
            // In simple mode, remove the floating label: a proper label is provider by the primary node
            ret.remove(getFirstChild(GmPortContainer.SATELLITE_ROLE));
        }
        return ret;
    }

}

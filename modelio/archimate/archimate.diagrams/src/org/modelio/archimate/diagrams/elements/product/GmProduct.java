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
package org.modelio.archimate.diagrams.elements.product;

import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPortContainer;
import org.modelio.archimate.diagrams.elements.product.v0._GmProduct;
import org.modelio.archimate.metamodel.layers.business.composite.Product;
import org.modelio.diagram.elements.common.portcontainer.GmPortContainer;
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
 * Specialized class for {@link Product}.
 */
@objid ("3033fd24-f956-44fa-8047-bf92d5729d49")
public class GmProduct extends GmArchiElementPortContainer<Product> {
    @objid ("ec9cc98e-b7ae-49e5-84c3-19a35f1efcba")
    private static final int MAJOR_VERSION = 1;

    /**
     * Current version of this Gm.
     */
    @objid ("9ba54b09-7440-483f-91ea-2bb1d5a28a73")
    private static final int MINOR_VERSION = 0;

    @objid ("02c5e930-0559-49fd-bed2-02abfe5278f0")
    static final AbstractStyleKeyProvider IMAGE_KEYS = new GmProductImageStyleKeys();

    @objid ("8323f5e9-3e90-47e0-b00d-51a43c122be3")
    static final AbstractStyleKeyProvider SIMPLE_KEYS = new GmProductSimpleStyleKeys();

    @objid ("f63db0ce-292c-46eb-a6a2-48e2fdc2b90e")
    static final AbstractStyleKeyProvider STRUCTURED_KEYS = new GmProductStructuredStyleKeys();

    @objid ("e4c5767e-232d-4027-a264-463f70776b11")
    static final AbstractStyleKeyProvider USERIMAGE_KEYS = new GmProductUserImageStyleKeys();

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the Product is unmasked.
     * @param el the unmasked Product.
     * @param ref a reference to the unmasked Product.
     */
    @objid ("28e05f37-a1e7-499b-b511-a96c114675b2")
    public GmProduct(IGmDiagram diagram, Product el, MRef ref) {
        super(diagram, el, ref);

        GmProductPrimaryNode mainNode = new GmProductPrimaryNode(diagram, el, ref);
        mainNode.setRoleInComposition(GmPortContainer.MAIN_NODE_ROLE);
        addChild(mainNode);

    }

    /**
     * Migration constructor from major version 0, should only be called by migrator.
     *
     * @param oldVersionGm the instance to migrate from.
     */
    @objid ("882bc134-a87c-41c8-8aa8-6ee19bc4137e")
    GmProduct(final _GmProduct oldVersionGm) {
        super(oldVersionGm.getDiagram(), oldVersionGm.getRelatedElement(), oldVersionGm.getRepresentedRef());

        GmProductPrimaryNode primary = new GmProductPrimaryNode(oldVersionGm);
        primary.setRoleInComposition(GmPortContainer.MAIN_NODE_ROLE);
        addChild(primary);

    }

    @objid ("9136b42a-86b2-4de2-802c-d65f3732ea55")
    @Override
    public int getMajorVersion() {
        return GmProduct.MAJOR_VERSION;
    }

    @objid ("9fde0f74-f9f7-4e4a-8ed9-e15c7d1c77e4")
    @Override
    public StyleKey getStyleKey(MetaKey metakey) {
        StyleKey styleKey = GmProduct.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return GmProduct.IMAGE_KEYS.getStyleKey(metakey);
            case USER_IMAGE:
                return GmProduct.USERIMAGE_KEYS.getStyleKey(metakey);
            case SIMPLE:
                return GmProduct.SIMPLE_KEYS.getStyleKey(metakey);
            case STRUCTURED:
                return GmProduct.STRUCTURED_KEYS.getStyleKey(metakey);
            default:
                break;
            }
        }
        return null;
    }

    @objid ("68d39c93-b9ce-4e03-9364-2ba3ccc6c38d")
    @Override
    public List<StyleKey> getStyleKeys() {
        StyleKey styleKey = GmProduct.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return GmProduct.IMAGE_KEYS.getStyleKeys();
            case USER_IMAGE:
                return GmProduct.USERIMAGE_KEYS.getStyleKeys();
            case SIMPLE:
                return GmProduct.SIMPLE_KEYS.getStyleKeys();
            case STRUCTURED:
                return GmProduct.STRUCTURED_KEYS.getStyleKeys();
            default:
                break;
            }
        }
        return Collections.emptyList();
    }

    @objid ("e0b9ab21-fa6c-4235-9691-f4df7210b1b5")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = readMinorVersion(in, "GmProduct.");
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

    @objid ("431bf3e6-4656-480e-b8e9-0e6df615673e")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        writeMinorVersion(out, "GmProduct.", MINOR_VERSION);

    }

    @objid ("865156b5-fb2f-4d04-9fee-819ce6442725")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("f6175f6a-6af0-4904-8e26-73358a1a64b7")
    public GmProduct() {
        // Nothing specific to do.
    }

    @objid ("2eb80b46-387a-47d4-8c74-8f3fcefa68e3")
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

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
package org.modelio.archimate.diagrams.elements.businessfunction;

import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.businessfunction.v0._GmBusinessFunction;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPortContainer;
import org.modelio.archimate.metamodel.layers.business.behavior.BusinessFunction;
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
 * Specialized class for {@link BusinessFunction}.
 */
@objid ("c0ae8776-6e10-499b-b350-70f657a5e4c3")
public class GmBusinessFunction extends GmArchiElementPortContainer<BusinessFunction> {
    @objid ("bf823e70-4cc3-44ad-96bd-cb86f301c445")
    private static final int MAJOR_VERSION = 1;

    /**
     * Current version of this Gm.
     */
    @objid ("647acf6c-14ba-42be-a0f1-23ee5411e4d6")
    private static final int MINOR_VERSION = 0;

    @objid ("1bc03e6b-d955-4cdf-a6ee-a6b6c34dbdd1")
    static final AbstractStyleKeyProvider IMAGE_KEYS = new GmBusinessFunctionImageStyleKeys();

    @objid ("2565079d-10fa-49f6-b07c-f840c9cfb81a")
    static final AbstractStyleKeyProvider SIMPLE_KEYS = new GmBusinessFunctionSimpleStyleKeys();

    @objid ("fbd5c33e-8956-4c08-bb9c-b8d365901556")
    static final AbstractStyleKeyProvider STRUCTURED_KEYS = new GmBusinessFunctionStructuredStyleKeys();

    @objid ("0ddeec40-e6b7-4e0d-8edb-9edcd08945d3")
    static final AbstractStyleKeyProvider USERIMAGE_KEYS = new GmBusinessFunctionUserImageStyleKeys();

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the BusinessFunction is unmasked.
     * @param el the unmasked BusinessFunction.
     * @param ref a reference to the unmasked BusinessFunction.
     */
    @objid ("2c5317c7-a761-4b19-94d4-661d6cd133b5")
    public GmBusinessFunction(IGmDiagram diagram, BusinessFunction el, MRef ref) {
        super(diagram, el, ref);

        GmBusinessFunctionPrimaryNode mainNode = new GmBusinessFunctionPrimaryNode(diagram, el, ref);
        mainNode.setRoleInComposition(GmPortContainer.MAIN_NODE_ROLE);
        addChild(mainNode);

    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("280c1d0e-6107-4712-bcf3-9cb424e12181")
    public GmBusinessFunction() {
        // Nothing specific to do.
    }

    @objid ("3bfc271c-5681-439c-b81a-d5f5f3c0920c")
    @Override
    public int getMajorVersion() {
        return GmBusinessFunction.MAJOR_VERSION;
    }

    @objid ("c31a8559-c4aa-40f4-b6a5-c67d4659ba6f")
    @Override
    public StyleKey getStyleKey(MetaKey metakey) {
        StyleKey styleKey = GmBusinessFunction.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return GmBusinessFunction.IMAGE_KEYS.getStyleKey(metakey);
            case USER_IMAGE:
                return GmBusinessFunction.USERIMAGE_KEYS.getStyleKey(metakey);
            case SIMPLE:
                return GmBusinessFunction.SIMPLE_KEYS.getStyleKey(metakey);
            case STRUCTURED:
                return GmBusinessFunction.STRUCTURED_KEYS.getStyleKey(metakey);
            default:
                break;
            }
        }
        return null;
    }

    @objid ("84724cc0-9210-45ed-baef-187b399ecefe")
    @Override
    public List<StyleKey> getStyleKeys() {
        StyleKey styleKey = GmBusinessFunction.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return GmBusinessFunction.IMAGE_KEYS.getStyleKeys();
            case USER_IMAGE:
                return GmBusinessFunction.USERIMAGE_KEYS.getStyleKeys();
            case SIMPLE:
                return GmBusinessFunction.SIMPLE_KEYS.getStyleKeys();
            case STRUCTURED:
                return GmBusinessFunction.STRUCTURED_KEYS.getStyleKeys();
            default:
                break;
            }
        }
        return Collections.emptyList();
    }

    @objid ("29bc0460-309e-425a-ab3b-561e5b20ab5b")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = GmAbstractObject.readMinorVersion(in, "GmBusinessFunction.");
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

    @objid ("037c0bba-ef73-46b9-ae87-82bc04129039")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        GmAbstractObject.writeMinorVersion(out, "GmBusinessFunction.", GmBusinessFunction.MINOR_VERSION);

    }

    @objid ("9bdb61da-73f8-4d3d-b71a-42479beccb79")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

    /**
     * Migration constructor from major version 0, should only be called by migrator.
     *
     * @param oldVersionGm the instance to migrate from.
     */
    @objid ("c516c503-a2a3-43ed-b1f6-c938921901e7")
    GmBusinessFunction(final _GmBusinessFunction oldVersionGm) {
        super(oldVersionGm.getDiagram(), oldVersionGm.getRelatedElement(), oldVersionGm.getRepresentedRef());

        GmBusinessFunctionPrimaryNode primary = new GmBusinessFunctionPrimaryNode(oldVersionGm);
        primary.setRoleInComposition(GmPortContainer.MAIN_NODE_ROLE);
        addChild(primary);

    }

    @objid ("a8a12bfa-3a48-47d5-886c-c099275906ef")
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

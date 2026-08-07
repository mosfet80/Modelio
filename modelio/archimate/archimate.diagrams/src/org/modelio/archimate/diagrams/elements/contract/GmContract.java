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
package org.modelio.archimate.diagrams.elements.contract;

import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPortContainer;
import org.modelio.archimate.diagrams.elements.contract.v0._GmContract;
import org.modelio.archimate.metamodel.layers.business.structure.passive.Contract;
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
 * Specialized class for {@link Contract}.
 */
@objid ("dac0f8b6-ceea-4480-a81a-1e6ac3e627b3")
public class GmContract extends GmArchiElementPortContainer<Contract> {
    @objid ("05a632cd-4137-48f9-bb18-fc682ddaa803")
    private static final int MAJOR_VERSION = 1;

    /**
     * Current version of this Gm.
     */
    @objid ("67114752-ed11-4058-be4e-3e284d956aa5")
    private static final int MINOR_VERSION = 0;

    @objid ("c6b01e37-1549-4560-b03d-bab7079ae7db")
    static final AbstractStyleKeyProvider IMAGE_KEYS = new GmContractImageStyleKeys();

    @objid ("c367b4cb-17a5-4dd5-95f8-c1d0f7015533")
    static final AbstractStyleKeyProvider SIMPLE_KEYS = new GmContractSimpleStyleKeys();

    @objid ("5e8aded5-da26-4fa3-9fe2-4e329d3c5913")
    static final AbstractStyleKeyProvider STRUCTURED_KEYS = new GmContractStructuredStyleKeys();

    @objid ("b51e64b2-e3e4-41b9-9c94-e3156b85ca96")
    static final AbstractStyleKeyProvider USERIMAGE_KEYS = new GmContractUserImageStyleKeys();

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the Contract is unmasked.
     * @param el the unmasked Contract.
     * @param ref a reference to the unmasked Contract.
     */
    @objid ("d4215555-433f-4e4f-979f-8348ca393ba3")
    public GmContract(IGmDiagram diagram, Contract el, MRef ref) {
        super(diagram, el, ref);

        GmContractPrimaryNode mainNode = new GmContractPrimaryNode(diagram, el, ref);
        mainNode.setRoleInComposition(GmPortContainer.MAIN_NODE_ROLE);
        addChild(mainNode);

    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("f02834f3-7a19-4c7d-b5ac-4f94b3798334")
    public GmContract() {
        // Nothing specific to do.
    }

    @objid ("57f4028a-5b0d-449d-a49d-5fb9edf6a3bf")
    @Override
    public int getMajorVersion() {
        return GmContract.MAJOR_VERSION;
    }

    @objid ("341bff5c-4c5a-482c-91ca-475e70fedea8")
    @Override
    public StyleKey getStyleKey(MetaKey metakey) {
        StyleKey styleKey = GmContract.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return GmContract.IMAGE_KEYS.getStyleKey(metakey);
            case USER_IMAGE:
                return GmContract.USERIMAGE_KEYS.getStyleKey(metakey);
            case SIMPLE:
                return GmContract.SIMPLE_KEYS.getStyleKey(metakey);
            case STRUCTURED:
                return GmContract.STRUCTURED_KEYS.getStyleKey(metakey);
            default:
                break;
            }
        }
        return null;
    }

    @objid ("65e21482-0c93-4cb6-b945-b728789ec0a3")
    @Override
    public List<StyleKey> getStyleKeys() {
        StyleKey styleKey = GmContract.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return GmContract.IMAGE_KEYS.getStyleKeys();
            case USER_IMAGE:
                return GmContract.USERIMAGE_KEYS.getStyleKeys();
            case SIMPLE:
                return GmContract.SIMPLE_KEYS.getStyleKeys();
            case STRUCTURED:
                return GmContract.STRUCTURED_KEYS.getStyleKeys();
            default:
                break;
            }
        }
        return Collections.emptyList();
    }

    @objid ("ddbd97c4-05eb-49de-b1f1-609da61381ef")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = GmAbstractObject.readMinorVersion(in, "GmContract.");
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

    @objid ("1cdcebcf-843e-40d5-8397-5f05c70e6416")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        GmAbstractObject.writeMinorVersion(out, "GmContract.", GmContract.MINOR_VERSION);

    }

    @objid ("081952a2-514c-4b7d-89a8-251e4934cd27")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

    /**
     * Migration constructor from major version 0, should only be called by migrator.
     *
     * @param oldVersionGm the instance to migrate from.
     */
    @objid ("8a7073b4-b075-415a-86cc-37c3cc13e280")
    GmContract(final _GmContract oldVersionGm) {
        super(oldVersionGm.getDiagram(), oldVersionGm.getRelatedElement(), oldVersionGm.getRepresentedRef());

        GmContractPrimaryNode primary = new GmContractPrimaryNode(oldVersionGm);
        primary.setRoleInComposition(GmPortContainer.MAIN_NODE_ROLE);
        addChild(primary);

    }

    @objid ("95775502-25aa-49f9-99e0-d3d0ae127323")
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

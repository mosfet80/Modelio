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
package org.modelio.archimate.diagrams.elements.contract.v0;

import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.archielement.GmArchiElement;
import org.modelio.archimate.diagrams.elements.contract.GmContractImageStyleKeys;
import org.modelio.archimate.diagrams.elements.contract.GmContractSimpleStyleKeys;
import org.modelio.archimate.diagrams.elements.contract.GmContractStructuredStyleKeys;
import org.modelio.archimate.diagrams.elements.contract.GmContractUserImageStyleKeys;
import org.modelio.archimate.metamodel.layers.business.structure.passive.Contract;
import org.modelio.diagram.elements.core.model.GmAbstractObject;
import org.modelio.diagram.elements.core.model.IGmDiagram;
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
@objid ("2348f819-d3d7-4e0b-a1b6-e93bcbba1b1d")
public class _GmContract extends GmArchiElement<Contract> {
    @objid ("bdf42e84-8a2c-4ede-8a78-d9bffda91fbc")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm.
     */
    @objid ("163ccd89-14bd-4a54-94bb-d925c987abad")
    private static final int MINOR_VERSION = 0;

    @objid ("95d168d6-fec6-484b-9923-6315ef7d7572")
    static final AbstractStyleKeyProvider IMAGE_KEYS = new GmContractImageStyleKeys();

    @objid ("ef9a6844-56ff-43a4-9bc2-23cba633cc15")
    static final AbstractStyleKeyProvider SIMPLE_KEYS = new GmContractSimpleStyleKeys();

    @objid ("8e9a5ab9-e5af-4d4e-b498-3d56a2617cb5")
    static final AbstractStyleKeyProvider STRUCTURED_KEYS = new GmContractStructuredStyleKeys();

    @objid ("bc7dc9d3-0746-464e-b2fe-cbd9a6af8ff2")
    static final AbstractStyleKeyProvider USERIMAGE_KEYS = new GmContractUserImageStyleKeys();

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the Contract is unmasked.
     * @param el the unmasked Contract.
     * @param ref a reference to the unmasked Contract.
     */
    @objid ("80ddc3d3-efb9-4be5-8394-c083909103de")
    public _GmContract(IGmDiagram diagram, Contract el, MRef ref) {
        super(diagram, el, ref);
        this.header.setShowMetaclassIcon(false);

    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("84e28ce2-1349-45dc-b5a3-b6c80d4b971b")
    public _GmContract() {
        // Nothing specific to do.
    }

    @objid ("edfc07b2-5895-44d7-b2fe-0a83f7b99b86")
    @Override
    public int getMajorVersion() {
        return _GmContract.MAJOR_VERSION;
    }

    @objid ("94ebc0b9-85df-49fb-b522-2c41aee591e9")
    @Override
    public StyleKey getStyleKey(MetaKey metakey) {
        StyleKey styleKey = _GmContract.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return _GmContract.IMAGE_KEYS.getStyleKey(metakey);
            case USER_IMAGE:
                return _GmContract.USERIMAGE_KEYS.getStyleKey(metakey);
            case SIMPLE:
                return _GmContract.SIMPLE_KEYS.getStyleKey(metakey);
            case STRUCTURED:
                return _GmContract.STRUCTURED_KEYS.getStyleKey(metakey);
            default:
                break;
            }
        }
        return null;
    }

    @objid ("984e5a78-c46e-49cf-a0ab-b9dc9688f53a")
    @Override
    public List<StyleKey> getStyleKeys() {
        StyleKey styleKey = _GmContract.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return _GmContract.IMAGE_KEYS.getStyleKeys();
            case USER_IMAGE:
                return _GmContract.USERIMAGE_KEYS.getStyleKeys();
            case SIMPLE:
                return _GmContract.SIMPLE_KEYS.getStyleKeys();
            case STRUCTURED:
                return _GmContract.STRUCTURED_KEYS.getStyleKeys();
            default:
                break;
            }
        }
        return Collections.emptyList();
    }

    @objid ("cea6ef45-ea86-48b1-b479-ccb2efcf3799")
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

    @objid ("47d8a2f2-b326-4634-a260-6b654ffbfc08")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        GmAbstractObject.writeMinorVersion(out, "GmContract.", _GmContract.MINOR_VERSION);

    }

    @objid ("b75676f3-1aab-443a-bcfd-eb74102d90f4")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

}

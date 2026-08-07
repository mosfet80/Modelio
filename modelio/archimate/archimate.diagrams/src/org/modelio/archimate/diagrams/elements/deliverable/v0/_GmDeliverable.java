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
package org.modelio.archimate.diagrams.elements.deliverable.v0;

import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.archielement.GmArchiElement;
import org.modelio.archimate.diagrams.elements.deliverable.GmDeliverableImageStyleKeys;
import org.modelio.archimate.diagrams.elements.deliverable.GmDeliverableSimpleStyleKeys;
import org.modelio.archimate.diagrams.elements.deliverable.GmDeliverableStructuredStyleKeys;
import org.modelio.archimate.diagrams.elements.deliverable.GmDeliverableUserImageStyleKeys;
import org.modelio.archimate.metamodel.layers.implementation_and_migration.Deliverable;
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
 * Specialized class for {@link Deliverable}.
 */
@objid ("44ff32f5-e8ec-40f6-af44-f856e4004948")
public class _GmDeliverable extends GmArchiElement<Deliverable> {
    @objid ("2f488a4c-b290-4518-8cd0-f7d984f09309")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm.
     */
    @objid ("bc9dab79-e1b6-4332-ac9d-54eb979bcdc9")
    private static final int MINOR_VERSION = 0;

    @objid ("2a0e333c-5073-442f-807b-5d423b166ada")
    static final AbstractStyleKeyProvider IMAGE_KEYS = new GmDeliverableImageStyleKeys();

    @objid ("d0cdfbd4-6bc2-4b5e-8866-394e5e9ac195")
    static final AbstractStyleKeyProvider SIMPLE_KEYS = new GmDeliverableSimpleStyleKeys();

    @objid ("ff42dc0f-b449-443f-bbc5-c4bfcc1f8c0e")
    static final AbstractStyleKeyProvider STRUCTURED_KEYS = new GmDeliverableStructuredStyleKeys();

    @objid ("bcaf3e02-f18d-4a71-9b5b-30b761163fdd")
    static final AbstractStyleKeyProvider USERIMAGE_KEYS = new GmDeliverableUserImageStyleKeys();

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the Deliverable is unmasked.
     * @param el the unmasked Deliverable.
     * @param ref a reference to the unmasked Deliverable.
     */
    @objid ("62ebbd89-2aba-4ae5-be43-4af4421602eb")
    public _GmDeliverable(IGmDiagram diagram, Deliverable el, MRef ref) {
        super(diagram, el, ref);
    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("96350db2-d989-4327-ad33-286916d3ddbb")
    public _GmDeliverable() {
        // Nothing specific to do.
    }

    @objid ("c24e4fa9-ef6d-40c9-8efe-30c4aced9f2f")
    @Override
    public int getMajorVersion() {
        return _GmDeliverable.MAJOR_VERSION;
    }

    @objid ("4eb1c430-ef2b-4d05-bf63-1393596cb8e5")
    @Override
    public StyleKey getStyleKey(MetaKey metakey) {
        StyleKey styleKey = _GmDeliverable.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return _GmDeliverable.IMAGE_KEYS.getStyleKey(metakey);
            case USER_IMAGE:
                return _GmDeliverable.USERIMAGE_KEYS.getStyleKey(metakey);
            case SIMPLE:
                return _GmDeliverable.SIMPLE_KEYS.getStyleKey(metakey);
            case STRUCTURED:
                return _GmDeliverable.STRUCTURED_KEYS.getStyleKey(metakey);
            default:
                break;
            }
        }
        return null;
    }

    @objid ("fb2bd79f-e184-49e6-bbaa-90c66c613ceb")
    @Override
    public List<StyleKey> getStyleKeys() {
        StyleKey styleKey = _GmDeliverable.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return _GmDeliverable.IMAGE_KEYS.getStyleKeys();
            case USER_IMAGE:
                return _GmDeliverable.USERIMAGE_KEYS.getStyleKeys();
            case SIMPLE:
                return _GmDeliverable.SIMPLE_KEYS.getStyleKeys();
            case STRUCTURED:
                return _GmDeliverable.STRUCTURED_KEYS.getStyleKeys();
            default:
                break;
            }
        }
        return Collections.emptyList();
    }

    @objid ("6c42e216-1d8d-48fe-8bcc-e156308d9115")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = GmAbstractObject.readMinorVersion(in, "GmDeliverable.");
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

    @objid ("131c3eec-b9f1-4c30-8554-cf5353d0d528")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        GmAbstractObject.writeMinorVersion(out, "GmDeliverable.", _GmDeliverable.MINOR_VERSION);

    }

    @objid ("ce5b83d7-b6a8-4f45-b247-469db3c56e4f")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

}

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
package org.modelio.archimate.diagrams.elements.applicationevent.v0;

import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.applicationevent.GmApplicationEventImageStyleKeys;
import org.modelio.archimate.diagrams.elements.applicationevent.GmApplicationEventSimpleStyleKeys;
import org.modelio.archimate.diagrams.elements.applicationevent.GmApplicationEventStructuredStyleKeys;
import org.modelio.archimate.diagrams.elements.applicationevent.GmApplicationEventUserImageStyleKeys;
import org.modelio.archimate.diagrams.elements.common.archielement.GmArchiElement;
import org.modelio.archimate.metamodel.layers.application.behavior.ApplicationEvent;
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
 * Specialized class for {@link ApplicationEvent}.
 */
@objid ("38baf2d6-46df-4115-8004-8370b53350b7")
public class _GmApplicationEvent extends GmArchiElement<ApplicationEvent> {
    @objid ("c8af7894-7e25-4d28-ac26-6a29f346eb75")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm.
     */
    @objid ("e601c40b-d4f4-403b-94d5-033aead84c4f")
    private static final int MINOR_VERSION = 0;

    @objid ("1d1fb9ae-3f5b-417d-8f6b-03ff35f35523")
    static final AbstractStyleKeyProvider IMAGE_KEYS = new GmApplicationEventImageStyleKeys();

    @objid ("b8e53223-7634-4d98-afe4-2b09304658fe")
    static final AbstractStyleKeyProvider SIMPLE_KEYS = new GmApplicationEventSimpleStyleKeys();

    @objid ("b0b8f98f-ea41-40a0-b8d9-64191716f3c0")
    static final AbstractStyleKeyProvider STRUCTURED_KEYS = new GmApplicationEventStructuredStyleKeys();

    @objid ("d9ff70d5-8185-4a03-97b1-a619c88496ac")
    static final AbstractStyleKeyProvider USERIMAGE_KEYS = new GmApplicationEventUserImageStyleKeys();

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the ApplicationEvent is unmasked.
     * @param el the unmasked ApplicationEvent.
     * @param ref a reference to the unmasked ApplicationEvent.
     */
    @objid ("d7e55c5b-9a6f-4016-85e6-bac9409d63f2")
    public _GmApplicationEvent(IGmDiagram diagram, ApplicationEvent el, MRef ref) {
        super(diagram, el, ref);
    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("5a7148fb-612e-47ed-afbe-823eb9cc169f")
    public _GmApplicationEvent() {
        // Nothing specific to do.
    }

    @objid ("3550c2ad-a85b-4011-9ddc-e5ff8fc9cbbf")
    @Override
    public int getMajorVersion() {
        return _GmApplicationEvent.MAJOR_VERSION;
    }

    @objid ("02bc9deb-a1ae-446a-9ffe-30386fd02e61")
    @Override
    public StyleKey getStyleKey(MetaKey metakey) {
        StyleKey styleKey = _GmApplicationEvent.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return _GmApplicationEvent.IMAGE_KEYS.getStyleKey(metakey);
            case USER_IMAGE:
                return _GmApplicationEvent.USERIMAGE_KEYS.getStyleKey(metakey);
            case SIMPLE:
                return _GmApplicationEvent.SIMPLE_KEYS.getStyleKey(metakey);
            case STRUCTURED:
                return _GmApplicationEvent.STRUCTURED_KEYS.getStyleKey(metakey);
            default:
                break;
            }
        }
        return null;
    }

    @objid ("6dcfd29b-47da-4971-87d0-3de002226f03")
    @Override
    public List<StyleKey> getStyleKeys() {
        StyleKey styleKey = _GmApplicationEvent.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return _GmApplicationEvent.IMAGE_KEYS.getStyleKeys();
            case USER_IMAGE:
                return _GmApplicationEvent.USERIMAGE_KEYS.getStyleKeys();
            case SIMPLE:
                return _GmApplicationEvent.SIMPLE_KEYS.getStyleKeys();
            case STRUCTURED:
                return _GmApplicationEvent.STRUCTURED_KEYS.getStyleKeys();
            default:
                break;
            }
        }
        return Collections.emptyList();
    }

    @objid ("92828c9d-6ec8-4b88-bfc8-63698f8ac827")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = GmAbstractObject.readMinorVersion(in, "GmApplicationEvent.");
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

    @objid ("e5a9d9ee-8a73-4c1a-a5b2-d699fb9b638e")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        GmAbstractObject.writeMinorVersion(out, "GmApplicationEvent.", _GmApplicationEvent.MINOR_VERSION);

    }

    @objid ("b51ef6d2-6ba4-43f3-9389-ca9547262160")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

}

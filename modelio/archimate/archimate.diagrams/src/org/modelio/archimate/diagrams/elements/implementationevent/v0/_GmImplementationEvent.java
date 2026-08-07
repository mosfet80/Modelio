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
package org.modelio.archimate.diagrams.elements.implementationevent.v0;

import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.archielement.GmArchiElement;
import org.modelio.archimate.diagrams.elements.implementationevent.GmImplementationEventImageStyleKeys;
import org.modelio.archimate.diagrams.elements.implementationevent.GmImplementationEventSimpleStyleKeys;
import org.modelio.archimate.diagrams.elements.implementationevent.GmImplementationEventStructuredStyleKeys;
import org.modelio.archimate.diagrams.elements.implementationevent.GmImplementationEventUserImageStyleKeys;
import org.modelio.archimate.metamodel.layers.implementation_and_migration.ImplementationEvent;
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
 * Specialized class for {@link ImplementationEvent}.
 */
@objid ("1a09a827-451d-47d7-9743-0845ed62f746")
public class _GmImplementationEvent extends GmArchiElement<ImplementationEvent> {
    @objid ("95356f70-4612-4d4d-b6cb-9929ef8f9a10")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm.
     */
    @objid ("ba141a41-e840-4f33-bee2-73494d54f213")
    private static final int MINOR_VERSION = 0;

    @objid ("bc49c2c9-b168-4736-89f0-10e8f3fb8069")
    static final AbstractStyleKeyProvider IMAGE_KEYS = new GmImplementationEventImageStyleKeys();

    @objid ("243a2d16-41be-46ee-8639-7fff94dd00fa")
    static final AbstractStyleKeyProvider SIMPLE_KEYS = new GmImplementationEventSimpleStyleKeys();

    @objid ("f0a192d3-9fd1-49d4-902a-23123fb59b4a")
    static final AbstractStyleKeyProvider STRUCTURED_KEYS = new GmImplementationEventStructuredStyleKeys();

    @objid ("1da0760c-9eac-49fe-8514-fc24ebeba050")
    static final AbstractStyleKeyProvider USERIMAGE_KEYS = new GmImplementationEventUserImageStyleKeys();

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the ImplementationEvent is unmasked.
     * @param el the unmasked ImplementationEvent.
     * @param ref a reference to the unmasked ImplementationEvent.
     */
    @objid ("bb99124d-b2ab-48e5-8b9a-47dd0940423f")
    public _GmImplementationEvent(IGmDiagram diagram, ImplementationEvent el, MRef ref) {
        super(diagram, el, ref);
    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("ed3ef388-8269-4dec-b62e-d04ea942cf45")
    public _GmImplementationEvent() {
        // Nothing specific to do.
    }

    @objid ("e0b87554-5a95-4737-a625-e3ee46540092")
    @Override
    public int getMajorVersion() {
        return _GmImplementationEvent.MAJOR_VERSION;
    }

    @objid ("68b78abd-65e7-44b6-a68f-9755912f06af")
    @Override
    public StyleKey getStyleKey(MetaKey metakey) {
        StyleKey styleKey = _GmImplementationEvent.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return _GmImplementationEvent.IMAGE_KEYS.getStyleKey(metakey);
            case USER_IMAGE:
                return _GmImplementationEvent.USERIMAGE_KEYS.getStyleKey(metakey);
            case SIMPLE:
                return _GmImplementationEvent.SIMPLE_KEYS.getStyleKey(metakey);
            case STRUCTURED:
                return _GmImplementationEvent.STRUCTURED_KEYS.getStyleKey(metakey);
            default:
                break;
            }
        }
        return null;
    }

    @objid ("87bef474-13e2-42a5-a998-c6027a80847a")
    @Override
    public List<StyleKey> getStyleKeys() {
        StyleKey styleKey = _GmImplementationEvent.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return _GmImplementationEvent.IMAGE_KEYS.getStyleKeys();
            case USER_IMAGE:
                return _GmImplementationEvent.USERIMAGE_KEYS.getStyleKeys();
            case SIMPLE:
                return _GmImplementationEvent.SIMPLE_KEYS.getStyleKeys();
            case STRUCTURED:
                return _GmImplementationEvent.STRUCTURED_KEYS.getStyleKeys();
            default:
                break;
            }
        }
        return Collections.emptyList();
    }

    @objid ("f174ace4-a04f-45c8-a7ab-c10e7fd12e2f")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = GmAbstractObject.readMinorVersion(in, "GmImplementationEvent.");
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

    @objid ("5ccd8323-18c4-4723-a3b4-80e67eb6f986")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        GmAbstractObject.writeMinorVersion(out, "GmImplementationEvent.", _GmImplementationEvent.MINOR_VERSION);

    }

    @objid ("427988ab-283b-466a-922d-de91b5124069")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

}

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
package org.modelio.archimate.diagrams.elements.driver.v0;

import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.archielement.GmArchiElement;
import org.modelio.archimate.diagrams.elements.driver.GmDriverImageStyleKeys;
import org.modelio.archimate.diagrams.elements.driver.GmDriverSimpleStyleKeys;
import org.modelio.archimate.diagrams.elements.driver.GmDriverStructuredStyleKeys;
import org.modelio.archimate.diagrams.elements.driver.GmDriverUserImageStyleKeys;
import org.modelio.archimate.metamodel.layers.motivation.Driver;
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
 * Specialized class for {@link Driver}.
 */
@objid ("7e8e2def-eece-45d2-982c-7a29e0c42738")
public class _GmDriver extends GmArchiElement<Driver> {
    @objid ("95005420-51fa-4da4-b66c-eaba2cc0a875")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm.
     */
    @objid ("27d6bfe8-22b8-4dac-bcc8-416666cc01f6")
    private static final int MINOR_VERSION = 0;

    @objid ("04227ea6-68f4-4b84-819f-6c8e839ad4c2")
    static final AbstractStyleKeyProvider IMAGE_KEYS = new GmDriverImageStyleKeys();

    @objid ("a51b3821-119e-450d-ab9f-dd4445edc128")
    static final AbstractStyleKeyProvider SIMPLE_KEYS = new GmDriverSimpleStyleKeys();

    @objid ("d13d7cc6-76c5-46e1-b443-a585fd1ecf48")
    static final AbstractStyleKeyProvider STRUCTURED_KEYS = new GmDriverStructuredStyleKeys();

    @objid ("67a82a48-f40b-4442-8bd0-6367bc27dc78")
    static final AbstractStyleKeyProvider USERIMAGE_KEYS = new GmDriverUserImageStyleKeys();

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the Driver is unmasked.
     * @param el the unmasked Driver.
     * @param ref a reference to the unmasked Driver.
     */
    @objid ("b8a4cc70-9860-4021-a06c-16ac54fad478")
    public _GmDriver(IGmDiagram diagram, Driver el, MRef ref) {
        super(diagram, el, ref);
    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("0ccd10b7-1d69-494a-aacf-7827872d3317")
    public _GmDriver() {
        // Nothing specific to do.
    }

    @objid ("76d53d49-b014-4347-a498-23c20fcf704b")
    @Override
    public int getMajorVersion() {
        return _GmDriver.MAJOR_VERSION;
    }

    @objid ("0c22c316-d2a1-4def-83e9-3bbc2afef07f")
    @Override
    public StyleKey getStyleKey(MetaKey metakey) {
        StyleKey styleKey = _GmDriver.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return _GmDriver.IMAGE_KEYS.getStyleKey(metakey);
            case USER_IMAGE:
                return _GmDriver.USERIMAGE_KEYS.getStyleKey(metakey);
            case SIMPLE:
                return _GmDriver.SIMPLE_KEYS.getStyleKey(metakey);
            case STRUCTURED:
                return _GmDriver.STRUCTURED_KEYS.getStyleKey(metakey);
            default:
                break;
            }
        }
        return null;
    }

    @objid ("f078588f-1c79-4fbc-a21b-991e8b97da07")
    @Override
    public List<StyleKey> getStyleKeys() {
        StyleKey styleKey = _GmDriver.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return _GmDriver.IMAGE_KEYS.getStyleKeys();
            case USER_IMAGE:
                return _GmDriver.USERIMAGE_KEYS.getStyleKeys();
            case SIMPLE:
                return _GmDriver.SIMPLE_KEYS.getStyleKeys();
            case STRUCTURED:
                return _GmDriver.STRUCTURED_KEYS.getStyleKeys();
            default:
                break;
            }
        }
        return Collections.emptyList();
    }

    @objid ("28836ce6-9526-4691-b454-f5c3e2123cdb")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = GmAbstractObject.readMinorVersion(in, "GmDriver.");
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

    @objid ("601350ea-1874-478f-88a6-24a0520e5d32")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        GmAbstractObject.writeMinorVersion(out, "GmDriver.", _GmDriver.MINOR_VERSION);

    }

    @objid ("259729f7-b909-495d-84f0-114e83e92b94")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

}

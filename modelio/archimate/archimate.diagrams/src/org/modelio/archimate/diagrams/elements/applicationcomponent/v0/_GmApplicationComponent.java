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
package org.modelio.archimate.diagrams.elements.applicationcomponent.v0;

import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.applicationcomponent.GmApplicationComponentImageStyleKeys;
import org.modelio.archimate.diagrams.elements.applicationcomponent.GmApplicationComponentSimpleStyleKeys;
import org.modelio.archimate.diagrams.elements.applicationcomponent.GmApplicationComponentStructuredStyleKeys;
import org.modelio.archimate.diagrams.elements.applicationcomponent.GmApplicationComponentUserImageStyleKeys;
import org.modelio.archimate.diagrams.elements.common.archielement.GmArchiElement;
import org.modelio.archimate.metamodel.layers.application.structure.active.ApplicationComponent;
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
 * Specialized class for {@link ApplicationComponent}.
 */
@objid ("0160b19f-4966-4964-b0f8-3c7fd3dc0601")
public class _GmApplicationComponent extends GmArchiElement<ApplicationComponent> {
    @objid ("77ba4021-79ac-4ba7-a019-03f44ba8600e")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm.
     */
    @objid ("7ab5b1d0-8802-4753-848a-6711d872961d")
    private static final int MINOR_VERSION = 0;

    @objid ("d6fdb6f2-09c7-4107-a294-59218d7f12ae")
    static final AbstractStyleKeyProvider IMAGE_KEYS = new GmApplicationComponentImageStyleKeys();

    @objid ("143af6f2-2c8e-425a-b567-8b347a8c4fa4")
    static final AbstractStyleKeyProvider SIMPLE_KEYS = new GmApplicationComponentSimpleStyleKeys();

    @objid ("f38e6d96-d19d-4255-806b-1644cd1fc9fd")
    static final AbstractStyleKeyProvider STRUCTURED_KEYS = new GmApplicationComponentStructuredStyleKeys();

    @objid ("1b6bc2cf-0d27-48bd-82cf-5658a33d97eb")
    static final AbstractStyleKeyProvider USERIMAGE_KEYS = new GmApplicationComponentUserImageStyleKeys();

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the ApplicationComponent is unmasked.
     * @param el the unmasked ApplicationComponent.
     * @param ref a reference to the unmasked ApplicationComponent.
     */
    @objid ("ed110651-aa75-4069-b5ba-c46cad867c00")
    public _GmApplicationComponent(IGmDiagram diagram, ApplicationComponent el, MRef ref) {
        super(diagram, el, ref);
    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("20a058bc-39ee-4820-a7f7-c312c974a46f")
    public _GmApplicationComponent() {
        // Nothing specific to do.
    }

    @objid ("8494052d-ff14-492c-a07d-87d490153073")
    @Override
    public int getMajorVersion() {
        return _GmApplicationComponent.MAJOR_VERSION;
    }

    @objid ("aba87e6e-a788-4bf1-ac25-388576d96fe5")
    @Override
    public StyleKey getStyleKey(MetaKey metakey) {
        StyleKey styleKey = _GmApplicationComponent.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return _GmApplicationComponent.IMAGE_KEYS.getStyleKey(metakey);
            case USER_IMAGE:
                return _GmApplicationComponent.USERIMAGE_KEYS.getStyleKey(metakey);
            case SIMPLE:
                return _GmApplicationComponent.SIMPLE_KEYS.getStyleKey(metakey);
            case STRUCTURED:
                return _GmApplicationComponent.STRUCTURED_KEYS.getStyleKey(metakey);
            default:
                break;
            }
        }
        return null;
    }

    @objid ("fed77409-d0c0-4b21-b313-f71b720b0445")
    @Override
    public List<StyleKey> getStyleKeys() {
        StyleKey styleKey = _GmApplicationComponent.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return _GmApplicationComponent.IMAGE_KEYS.getStyleKeys();
            case USER_IMAGE:
                return _GmApplicationComponent.USERIMAGE_KEYS.getStyleKeys();
            case SIMPLE:
                return _GmApplicationComponent.SIMPLE_KEYS.getStyleKeys();
            case STRUCTURED:
                return _GmApplicationComponent.STRUCTURED_KEYS.getStyleKeys();
            default:
                break;
            }
        }
        return Collections.emptyList();
    }

    @objid ("5d8212bb-a2b7-4a39-80cf-ca71490c8fa1")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = GmAbstractObject.readMinorVersion(in, "GmApplicationComponent.");
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

    @objid ("cdc5ad6a-8654-4ac2-aa32-2024ba044fa2")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        GmAbstractObject.writeMinorVersion(out, "GmApplicationComponent.", _GmApplicationComponent.MINOR_VERSION);

    }

    @objid ("b73267fd-9cb5-4a45-90a9-b6c4ebf17320")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

}

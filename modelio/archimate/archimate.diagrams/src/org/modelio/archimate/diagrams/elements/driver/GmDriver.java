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
package org.modelio.archimate.diagrams.elements.driver;

import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPortContainer;
import org.modelio.archimate.diagrams.elements.driver.v0._GmDriver;
import org.modelio.archimate.metamodel.layers.motivation.Driver;
import org.modelio.diagram.elements.common.portcontainer.GmPortContainer;
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
@objid ("18db8cd0-6a1d-4942-83bb-339bbc27dc6c")
public class GmDriver extends GmArchiElementPortContainer<Driver> {
    @objid ("d092540f-c0dc-467b-9f14-9fc21081c4f4")
    private static final int MAJOR_VERSION = 1;

    /**
     * Current version of this Gm.
     */
    @objid ("68ed72f9-f121-48d4-8901-30a39fcc53b1")
    private static final int MINOR_VERSION = 0;

    @objid ("4031160d-0830-45af-b7b4-ff842a45fb3a")
    static final AbstractStyleKeyProvider IMAGE_KEYS = new GmDriverImageStyleKeys();

    @objid ("c80aee0b-45a1-4f0f-bd2e-b35502e3058e")
    static final AbstractStyleKeyProvider SIMPLE_KEYS = new GmDriverSimpleStyleKeys();

    @objid ("093396cf-436d-447f-ae3a-a8ac516a5034")
    static final AbstractStyleKeyProvider STRUCTURED_KEYS = new GmDriverStructuredStyleKeys();

    @objid ("831eaae9-0e39-4b1e-831f-73e95259402f")
    static final AbstractStyleKeyProvider USERIMAGE_KEYS = new GmDriverUserImageStyleKeys();

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the Driver is unmasked.
     * @param el the unmasked Driver.
     * @param ref a reference to the unmasked Driver.
     */
    @objid ("88dcbe11-750c-4e86-8cda-928ef562f1da")
    public GmDriver(IGmDiagram diagram, Driver el, MRef ref) {
        super(diagram, el, ref);

        GmDriverPrimaryNode mainNode = new GmDriverPrimaryNode(diagram, el, ref);
        mainNode.setRoleInComposition(GmPortContainer.MAIN_NODE_ROLE);
        addChild(mainNode);

    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("424ad35f-0f46-4926-96bd-12dad28c9d6f")
    public GmDriver() {
        // Nothing specific to do.
    }

    @objid ("5722785a-d7cd-4544-9e57-9055d5bf5b3e")
    @Override
    public int getMajorVersion() {
        return GmDriver.MAJOR_VERSION;
    }

    @objid ("14a3d263-1787-4791-b644-3b6021f3b50f")
    @Override
    public StyleKey getStyleKey(MetaKey metakey) {
        StyleKey styleKey = GmDriver.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return GmDriver.IMAGE_KEYS.getStyleKey(metakey);
            case USER_IMAGE:
                return GmDriver.USERIMAGE_KEYS.getStyleKey(metakey);
            case SIMPLE:
                return GmDriver.SIMPLE_KEYS.getStyleKey(metakey);
            case STRUCTURED:
                return GmDriver.STRUCTURED_KEYS.getStyleKey(metakey);
            default:
                break;
            }
        }
        return null;
    }

    @objid ("b6e1f230-2fe6-422a-9a44-ff4d0a2a49ce")
    @Override
    public List<StyleKey> getStyleKeys() {
        StyleKey styleKey = GmDriver.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return GmDriver.IMAGE_KEYS.getStyleKeys();
            case USER_IMAGE:
                return GmDriver.USERIMAGE_KEYS.getStyleKeys();
            case SIMPLE:
                return GmDriver.SIMPLE_KEYS.getStyleKeys();
            case STRUCTURED:
                return GmDriver.STRUCTURED_KEYS.getStyleKeys();
            default:
                break;
            }
        }
        return Collections.emptyList();
    }

    @objid ("69912a2c-16cb-43a8-89d9-785d99cc2cda")
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

    @objid ("312146b0-9b0d-4ee3-8abe-cf7241e4fbf0")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        GmAbstractObject.writeMinorVersion(out, "GmDriver.", GmDriver.MINOR_VERSION);

    }

    @objid ("c23be69e-5f4e-4017-aef0-a5c30fc055bd")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

    /**
     * Migration constructor from major version 0, should only be called by migrator.
     *
     * @param oldVersionGm the instance to migrate from.
     */
    @objid ("aae5b74d-9b3a-40da-8066-633ccec4ba6d")
    GmDriver(final _GmDriver oldVersionGm) {
        super(oldVersionGm.getDiagram(), oldVersionGm.getRelatedElement(), oldVersionGm.getRepresentedRef());

        GmDriverPrimaryNode primary = new GmDriverPrimaryNode(oldVersionGm);
        primary.setRoleInComposition(GmPortContainer.MAIN_NODE_ROLE);
        addChild(primary);

    }

}

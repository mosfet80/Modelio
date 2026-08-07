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
package org.modelio.archimate.diagrams.elements.specialization;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.archilink.GmArchiRelationship;
import org.modelio.archimate.metamodel.relationships.other.Specialization;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.persistence.IDiagramReader;
import org.modelio.diagram.persistence.IDiagramWriter;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Graphic model for {@link Specialization}.
 */
@objid ("c412ac32-362a-48dc-a108-e7421e525fb1")
public class GmSpecialization extends GmArchiRelationship<Specialization> {
    /**
     * Current version of this Gm. Defaults to 0.
     */
    @objid ("c704d0ca-4427-4893-a37d-89cd109ba58f")
    private static final int MINOR_VERSION = 0;

    @objid ("0bcd0532-2879-4124-9ac9-0cb623631686")
    private static final int MAJOR_VERSION = 0;

    /**
     * Style keys.
     */
    @objid ("3697b96d-253a-4777-802e-dcd7a16b6335")
    public static final GmSpecializationLinkStyleKeys styleKeyProvider = new GmSpecializationLinkStyleKeys();

    /**
     * Initialize a graphic model.
     *
     * @param diagram The owning diagram.
     * @param elt The link element, may be <code>null</code>.
     * @param ref The link reference, may not be <code>null</code>.
     */
    @objid ("73ec6891-db3a-4e6f-85f3-add080fecc53")
    public GmSpecialization(IGmDiagram diagram, Specialization elt, MRef ref) {
        super(diagram, elt, ref);
    }

    /**
     * For deserialization only.
     */
    @objid ("bbd4b02c-ac22-4f09-a0a8-f358133b8ef0")
    public GmSpecialization() {
        // Empty
    }

    @objid ("b2c564e4-a04f-4aee-ad84-75d6aab0b2c5")
    @Override
    public StyleKey getStyleKey(MetaKey metakey) {
        return styleKeyProvider.getStyleKey(metakey);
    }

    @objid ("10f3f757-9218-4014-8705-d89bcbf104e3")
    @Override
    public List<StyleKey> getStyleKeys() {
        return styleKeyProvider.getStyleKeys();
    }

    @objid ("bc156079-adff-4e0f-8d45-1eb4b9f9735a")
    @Override
    protected void readLink(IDiagramReader in) {
        super.readLink(in);
    }

    @objid ("960fe67d-8524-427a-acf4-ffec14dee01d")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        writeMinorVersion(out, "GmSpecialization.", MINOR_VERSION);

    }

    @objid ("e53a678c-4dfb-4f3f-a69b-e28c2a1f44be")
    @Override
    public int getMajorVersion() {
        return MAJOR_VERSION;
    }

}

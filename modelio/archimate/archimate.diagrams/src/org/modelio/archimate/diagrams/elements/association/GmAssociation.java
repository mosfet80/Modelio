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
package org.modelio.archimate.diagrams.elements.association;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.archilink.GmArchiRelationship;
import org.modelio.archimate.metamodel.relationships.other.Association;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.elements.core.model.IGmObject;
import org.modelio.diagram.persistence.IDiagramReader;
import org.modelio.diagram.persistence.IDiagramWriter;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Graphic model for {@link Association}.
 */
@objid ("c0d7847e-fc7b-401d-8c17-a264c787f389")
public class GmAssociation extends GmArchiRelationship<Association> {
    /**
     * Current version of this Gm. Defaults to 0.
     */
    @objid ("4ac512b3-315a-4b57-943d-00db716ea7c2")
    private static final int MINOR_VERSION = 0;

    @objid ("29c124b9-49f2-4a7a-b60b-84e7c9f63488")
    private static final int MAJOR_VERSION = 0;

    /**
     * Style keys.
     */
    @objid ("84ba2d90-1d47-40ef-9506-75d868b02d07")
    public static final GmAssociationLinkStyleKeys styleKeyProvider = new GmAssociationLinkStyleKeys();

    /**
     * Initialize a graphic model.
     *
     * @param diagram The owning diagram.
     * @param elt The link element, may be <code>null</code>.
     * @param ref The link reference, may not be <code>null</code>.
     */
    @objid ("b2ff0838-748d-4af6-93e3-5bd182c1198d")
    public GmAssociation(IGmDiagram diagram, Association elt, MRef ref) {
        super(diagram, elt, ref);
    }

    /**
     * For deserialization only.
     */
    @objid ("a74efdd0-1124-4adf-87c0-3905a7f1c634")
    public GmAssociation() {
        // Empty
    }

    @objid ("be117a68-f414-4084-baa3-00a924191a2d")
    @Override
    public StyleKey getStyleKey(MetaKey metakey) {
        return styleKeyProvider.getStyleKey(metakey);
    }

    @objid ("b4522a88-ec67-499c-95ed-cd480ca2b3c2")
    @Override
    public List<StyleKey> getStyleKeys() {
        return styleKeyProvider.getStyleKeys();
    }

    @objid ("bc265fea-43e6-4865-b603-15ba83fcc636")
    @Override
    protected void readLink(IDiagramReader in) {
        super.readLink(in);
    }

    @objid ("a8446b66-5e06-46dd-a343-eb715b0f4ae4")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        writeMinorVersion(out, "GmAssociation.", MINOR_VERSION);

    }

    @objid ("0bb1776d-6a16-47f8-8f12-74213dc2bfc7")
    @Override
    public int getMajorVersion() {
        return MAJOR_VERSION;
    }

    @objid ("5fae68d9-15ed-436e-97dc-6d6b59d78684")
    public boolean isDirected() {
        Association elt = getRepresentedElement();
        return elt != null && elt.isDirected();
    }

    @objid ("bda0127f-c38d-4229-9ea2-35206bd113e2")
    @Override
    public void refreshFromObModel() {
        super.refreshFromObModel();

        // force refresh for navigability
        firePropertyChange(IGmObject.PROPERTY_LAYOUTDATA, null, this);

    }

}

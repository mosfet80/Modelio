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
package org.modelio.archimate.diagrams.elements.common.archilink;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.archiheader.GmArchiHeader;
import org.modelio.archimate.metamodel.core.Relationship;
import org.modelio.diagram.elements.common.label.modelelement.GmDefaultModelElementLabel;
import org.modelio.diagram.elements.core.link.ExtensionLocation;
import org.modelio.diagram.elements.core.link.GmLink;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.persistence.IDiagramReader;
import org.modelio.diagram.persistence.IDiagramWriter;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Abstract class for Archimate elements represented as links.
 * <p>
 * Comes with a {@link GmArchiHeader}.
 * </p>
 *
 * @param <T> metaclass of the element represented by this Gm.
 */
@objid ("db3584ad-72fb-4c41-9322-40c58e7e7244")
public abstract class GmArchiRelationship<T extends Relationship> extends GmLink {
    @objid ("6be6868e-c726-4a86-8fac-9dacb0883bfa")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm. Defaults to 0.
     */
    @objid ("5a3c1312-77e0-400a-95bb-e11e2840b923")
    private static final int MINOR_VERSION = 0;

    @objid ("c9c7418b-52a3-4aee-b17c-aaa2363840f0")
    private T elt;

    /**
     * Initialize the graphic model.
     *
     * @param diagram The owning diagram.
     * @param elt The link element, may be <code>null</code>.
     * @param ref The link reference, may not be <code>null</code>.
     */
    @objid ("80867374-3aff-427e-b1fa-6335880cb479")
    public GmArchiRelationship(IGmDiagram diagram, T elt, MRef ref) {
        super(diagram, ref);
        this.elt = elt;

        addExtension(ExtensionLocation.MiddleNW, ROLE_MAIN_LABEL, new GmDefaultModelElementLabel(diagram, ref));

    }

    /**
     * For deserialization only.
     */
    @objid ("be205912-d4d4-4ba1-8269-de6ead77a005")
    public GmArchiRelationship() {
        // Empty
    }

    @objid ("a9206c9f-dc68-43a3-a43d-531fa990eb53")
    @Override
    public final MObject getFromElement() {
        return this.elt != null ? this.elt.getFrom() : null;
    }

    @objid ("117e0d98-e525-4571-bbfc-75786d5e4f84")
    @Override
    public int getMajorVersion() {
        return MAJOR_VERSION;
    }

    @objid ("ce3971b3-dda5-4a0a-87d5-5a34bca258be")
    @Override
    public final T getRelatedElement() {
        return getRepresentedElement();
    }

    @objid ("b1046f31-4d93-48f4-ba7f-4bca0bc0e039")
    @Override
    public final T getRepresentedElement() {
        return this.elt;
    }

    @objid ("4b35e4ce-1525-4ba7-8ae9-50e645fcb568")
    @Override
    public final MObject getToElement() {
        return this.elt != null ? this.elt.getTo() : null;
    }

    @objid ("0f7733c0-2201-42ee-9b84-052a13cc2996")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        writeMinorVersion(out, "GmArchiRelationship.", MINOR_VERSION);

    }

    @objid ("24230919-915e-4ac0-8fdf-8aacf8ce0143")
    @Override
    protected void readLink(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = readMinorVersion(in, "GmArchiRelationship.");
        switch (readVersion) {
        case 0: {
            read_0(in);
            break;
        }
        default: {
            assert false : readVersion + " version number not covered!";
            // reading as last handled version: 0
            read_0(in);
            break;
        }
        }

    }

    @objid ("24d581cf-edb0-42b1-8ea8-525504b72f2f")
    @Override
    protected void read_GmLinkV0_roles() {
        read_GmLinkV0_roles_one_main_label();
    }

    @objid ("8bab9ce3-85e9-44ef-b33b-7bf06c583572")
    @SuppressWarnings ("unchecked")
    private void read_0(IDiagramReader in) {
        super.readLink(in);
        this.elt = (T) resolveRef(this.getRepresentedRef());

    }

}

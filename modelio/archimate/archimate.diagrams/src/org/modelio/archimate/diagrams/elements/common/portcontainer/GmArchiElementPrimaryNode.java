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
package org.modelio.archimate.diagrams.elements.common.portcontainer;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.swt.graphics.Image;
import org.modelio.archimate.diagrams.elements.common.archielement.GmArchiFreeZone;
import org.modelio.archimate.diagrams.elements.common.archiheader.GmArchiHeader;
import org.modelio.archimate.diagrams.elements.common.archiheader.INodeWithArchiHeader;
import org.modelio.archimate.metamodel.core.Element;
import org.modelio.diagram.elements.common.header.GmModelElementHeader;
import org.modelio.diagram.elements.core.model.GmAbstractObject;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.elements.core.node.GmCompositeNode;
import org.modelio.diagram.elements.core.node.GmNoStyleCompositeNode;
import org.modelio.diagram.elements.core.node.GmNodeModel;
import org.modelio.diagram.elements.core.node.IImageableNode;
import org.modelio.diagram.persistence.IDiagramReader;
import org.modelio.diagram.persistence.IDiagramWriter;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey.RepresentationMode;
import org.modelio.platform.model.ui.swt.images.ElementImageService;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Abstract class for Archimate elements represented as primary nodes in a port container.
 * <p>
 * This node has a proxy style that delegates all to its parent node.
 * </p>
 * <p>
 * Comes with a {@link GmArchiHeader}.
 * </p>
 *
 * @param <T> metaclass of the element represented by this Gm.
 */
@objid ("4318754e-3ec3-4ead-8c20-b0c096df513f")
public abstract class GmArchiElementPrimaryNode<T extends Element> extends GmNoStyleCompositeNode implements IImageableNode, INodeWithArchiHeader {
    @objid ("3b2f6dd8-eaad-46d9-bdcf-66dcb6a1793d")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm.
     */
    @objid ("019ff0ee-01f6-4e75-bb8b-00795a1ae5a0")
    private static final int MINOR_VERSION = 0;

    @objid ("ecf43583-1168-44be-b0eb-d32f58b43f3c")
    private T element;

    @objid ("c6976cfe-de91-44ca-82fe-ed06191f5fa4")
    protected static final String HEADER_ROLE = "header";

    @objid ("76af329d-6f18-41f9-95a9-8a156214b75b")
    protected static final String BODY_ROLE = "body";

    @objid ("d10f28bf-07a2-4b8e-9be7-d4781294431f")
    protected GmArchiHeader header;

    @objid ("2659fc0f-60b7-4b53-93e4-839df6acc5e4")
    protected GmArchiFreeZone body;

    /**
     * Initialize the graphic model.
     *
     * @param diagram the diagram in which the T is unmasked.
     * @param el the unmasked T.
     * @param ref a reference to the unmasked T.
     */
    @objid ("0ce4f59c-4d2e-41f9-a209-ef84ea345e3f")
    public GmArchiElementPrimaryNode(IGmDiagram diagram, T el, MRef ref) {
        super(diagram, ref);
        this.element = el;

        this.header = new GmArchiHeader(diagram, ref);
        this.header.setShowMetaclassIcon(true);
        this.header.setRoleInComposition(GmArchiElementPrimaryNode.HEADER_ROLE);
        this.addChild(this.header);

        this.body = new GmArchiFreeZone(diagram, ref);
        this.body.setRoleInComposition(GmArchiElementPrimaryNode.BODY_ROLE);
        this.addChild(this.body);

    }

    /**
     * Migration constructor, using existing 'header' and 'body' elements instead of creating them.
     *
     * @param diagram the diagram in which the T is unmasked.
     * @param el the unmasked T.
     * @param ref a reference to the unmasked T.
     */
    @objid ("68a96239-ff53-457d-8b52-24d416703c69")
    public GmArchiElementPrimaryNode(IGmDiagram diagram, T el, MRef ref, GmArchiHeader header, GmArchiFreeZone body) {
        super(diagram, ref);
        this.element = el;

        if (header.getParentNode() != null) {
            header.getParentNode().removeChild(header);
        }
        this.header = header;
        this.addChild(header);

        if (body.getParentNode() != null) {
            body.getParentNode().removeChild(body);
        }
        this.body = body;
        this.addChild(body);

    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("6626d3f6-439f-4b0b-abb5-625e2310af8b")
    public GmArchiElementPrimaryNode() {
        // Nothing specific to do.
    }

    /**
     * Returns whether or not a 'type' can be created in this T.
     */
    @objid ("4dc3c235-e50b-4e87-884f-2b0cb2c590eb")
    @Override
    public boolean canCreate(Class<? extends MObject> type) {
        return true;
    }

    /**
     * Returns whether or not 'el' can be unmasked in this T.
     */
    @objid ("1cad10dd-d2c3-4de9-aa22-26e07cf78326")
    @Override
    public boolean canUnmask(MObject el) {
        // Assume it's possible for anything but a link
        return el != null && !el.getMClass().isLinkMetaclass();
    }

    @objid ("c43887f6-ec1b-46b6-a051-a5421dd44168")
    @Override
    public GmCompositeNode getCompositeFor(Class<? extends MObject> metaclass) {
        return this.body;
    }

    @objid ("c6c61798-1ff9-446a-9cdc-f185a269c1f9")
    @Override
    public int getMajorVersion() {
        return GmArchiElementPrimaryNode.MAJOR_VERSION;
    }

    @objid ("3b3744d5-b332-496a-8b2b-df1ecacd6bb2")
    @Override
    public final T getRelatedElement() {
        return getRepresentedElement();
    }

    @objid ("df2399a8-d999-41b2-accd-9750c859c626")
    @Override
    public RepresentationMode getRepresentationMode() {
        return (RepresentationMode) getDisplayedStyle().getProperty(getStyleKey(MetaKey.REPMODE));
    }

    @objid ("a5e9db4d-7301-459e-9c72-fe0823a7e2a3")
    @Override
    public final T getRepresentedElement() {
        return this.element;
    }

    @objid ("115f62f1-1124-4838-bbd7-6ad9ebb97b1c")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = GmAbstractObject.readMinorVersion(in, "GmNoStyleArchiElement.");
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

    @objid ("5757da36-25ee-4230-bda9-1440c6871922")
    @SuppressWarnings ("unchecked")
    private void read_0(IDiagramReader in) {
        super.read(in);
        this.element = (T) resolveRef(getRepresentedRef());
        this.header = (GmArchiHeader) getFirstChild(GmArchiElementPrimaryNode.HEADER_ROLE);
        this.body = (GmArchiFreeZone) getFirstChild(GmArchiElementPrimaryNode.BODY_ROLE);

    }

    @objid ("f22bd1e7-6950-4c51-879c-6aa69c90d95b")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        GmAbstractObject.writeMinorVersion(out, "GmNoStyleArchiElement.", GmArchiElementPrimaryNode.MINOR_VERSION);

    }

    /**
     * Get the stereotype image to display.
     *
     * @return the stereotype image to display. Must not be <i>null</i>.
     */
    @objid ("d627f9db-f67c-40d6-81ed-b60922941040")
    @Override
    public Image getImage() {
        return ElementImageService.getImage(getRelatedElement());
    }

    /**
     *
     * @return the Gm having the "header" role.
     */
    @objid ("938e0759-4b35-4875-bbe3-33d222c5ab39")
    @Override
    public GmModelElementHeader getHeader() {
        return this.header;
    }

    @objid ("94d888c5-ea25-40f3-869e-fd915884e08b")
    @Override
    public List<GmNodeModel> getVisibleChildren() {
        List<GmNodeModel> visibleChildren = super.getVisibleChildren();
        if (getRepresentationMode() != RepresentationMode.STRUCTURED) {
            visibleChildren.remove(this.header);
        }
        return visibleChildren;
    }

    @objid ("e3c0c79c-4c3f-4a27-9e31-4a92f17f9900")
    @Override
    public void refreshFromObModel() {
        super.refreshFromObModel();
        // forcing visual refresh in case Image changed
        firePropertyChange(PROPERTY_LAYOUTDATA, null, getLayoutData());

    }

}

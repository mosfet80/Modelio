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
package org.modelio.archimate.diagrams.elements.common.archielement;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.swt.graphics.Image;
import org.modelio.archimate.diagrams.elements.common.archiheader.GmArchiHeader;
import org.modelio.archimate.diagrams.elements.common.archiheader.INodeWithArchiHeader;
import org.modelio.archimate.metamodel.core.Element;
import org.modelio.diagram.elements.core.model.GmAbstractObject;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.elements.core.node.GmCompositeNode;
import org.modelio.diagram.elements.core.node.IImageableNode;
import org.modelio.diagram.persistence.IDiagramReader;
import org.modelio.diagram.persistence.IDiagramWriter;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey.RepresentationMode;
import org.modelio.platform.model.ui.swt.images.ElementImageService;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Abstract class for Archimate elements represented as nodes.
 * <p>
 * Comes with a {@link GmArchiHeader}.
 * </p>
 *
 * @param <T> metaclass of the element represented by this Gm.
 */
@objid ("610224e9-c4d2-4542-987f-2695b4f16702")
public abstract class GmArchiElement<T extends Element> extends GmCompositeNode implements IImageableNode, INodeWithArchiHeader {
    @objid ("c907162b-e2cd-435c-970a-c2a69b17234c")
    protected static final String BODY_ROLE = "body";

    @objid ("a0e70804-7b17-450f-917b-159782ed9a15")
    protected static final String HEADER_ROLE = "header";

    @objid ("740d4faf-995c-4960-8267-d0ae356d0415")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm.
     */
    @objid ("cfe59a96-9bb0-4f1b-a2aa-90c06198ed3e")
    private static final int MINOR_VERSION = 0;

    @objid ("387b67ab-2c6d-4cf9-8c66-fa12c8f51f5d")
    private T element;

    @objid ("cf7918d3-4641-4377-b3ad-a9ea0d57cbcc")
    protected GmArchiFreeZone body;

    @objid ("3591a7a0-4f34-49a5-b8bb-284a8738e086")
    protected GmArchiHeader header;

    /**
     * Initialize the graphic model.
     *
     * @param diagram the diagram in which the T is unmasked.
     * @param el the unmasked T.
     * @param ref a reference to the unmasked T.
     */
    @objid ("6edfb93b-d02d-451f-847d-86f4b42c7674")
    public GmArchiElement(IGmDiagram diagram, T el, MRef ref) {
        super(diagram, ref);
        this.element = el;

        this.header = new GmArchiHeader(diagram, ref);
        this.header.setShowMetaclassIcon(true);
        this.header.setRoleInComposition(GmArchiElement.HEADER_ROLE);
        this.addChild(this.header);

        this.body = new GmArchiFreeZone(diagram, ref);
        this.body.setRoleInComposition(GmArchiElement.BODY_ROLE);
        this.addChild(this.body);

    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("d9045700-ddf8-402b-875f-e51e54169c5b")
    public GmArchiElement() {
        // Nothing specific to do.
    }

    /**
     * Returns whether or not a 'type' can be created in this T.
     */
    @objid ("7245ab17-1d11-4ce3-a43c-07c25083f251")
    @Override
    public boolean canCreate(Class<? extends MObject> type) {
        return true;
    }

    /**
     * Returns whether or not 'el' can be unmasked in this T.
     */
    @objid ("8213ee94-ced7-4752-ab32-ce13ff016ff2")
    @Override
    public boolean canUnmask(MObject el) {
        // Assume it's possible for anything but a link
        return el != null && !el.getMClass().isLinkMetaclass();
    }

    @objid ("d6d15a35-1825-4565-9be9-520561d5f6df")
    @Override
    public GmCompositeNode getCompositeFor(Class<? extends MObject> metaclass) {
        return this.body;
    }

    /**
     *
     * @return the Gm having the "header" role.
     */
    @objid ("6939946a-67bd-4db8-95e3-308700d2658d")
    @Override
    public GmArchiHeader getHeader() {
        return this.header;
    }

    /**
     * Get the stereotype image to display.
     *
     * @return the stereotype image to display. Must not be <i>null</i>.
     */
    @objid ("5cc27d50-3558-4782-81b3-f2fcaf552931")
    @Override
    public Image getImage() {
        return ElementImageService.getImage(getRelatedElement());
    }

    @objid ("df495c73-446b-4f74-84cc-7270dbe97211")
    @Override
    public int getMajorVersion() {
        return GmArchiElement.MAJOR_VERSION;
    }

    @objid ("6234ec64-558e-4282-a1ab-59349219284a")
    @Override
    public final T getRelatedElement() {
        return getRepresentedElement();
    }

    @objid ("2c769edc-efc7-4e66-8eea-da40a2c7f61c")
    @Override
    public final RepresentationMode getRepresentationMode() {
        return (RepresentationMode) getDisplayedStyle().getProperty(getStyleKey(MetaKey.REPMODE));
    }

    @objid ("250ae7d9-95e0-4cc6-9471-cea168ca2e58")
    @Override
    public final T getRepresentedElement() {
        return this.element;
    }

    @objid ("b70eb87e-b105-43c6-8fa3-a90125fa6830")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = GmAbstractObject.readMinorVersion(in, "GmArchiElement.");
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

    @objid ("982575b3-dab3-49db-b5a2-d6d233f1758e")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        GmAbstractObject.writeMinorVersion(out, "GmArchiElement.", GmArchiElement.MINOR_VERSION);

    }

    @objid ("b4e939b7-9f56-4c2c-901f-bda54eef0180")
    @SuppressWarnings ("unchecked")
    private void read_0(IDiagramReader in) {
        super.read(in);
        this.element = (T) resolveRef(getRepresentedRef());
        this.header = (GmArchiHeader) getFirstChild(GmArchiElement.HEADER_ROLE);
        this.body = (GmArchiFreeZone) getFirstChild(GmArchiElement.BODY_ROLE);

    }

    /**
     *
     * @return the Gm having the "header" role.
     */
    @objid ("6136e2b7-d19d-493c-b117-1f5741e377a8")
    public GmArchiFreeZone getBody() {
        return this.body;
    }

    @objid ("c0f73b33-a6a0-432a-bb89-347e0bef3846")
    @Override
    public void refreshFromObModel() {
        super.refreshFromObModel();

        // forcing visual refresh in case Image changed
        firePropertyChange(PROPERTY_LAYOUTDATA, null, getLayoutData());

    }

}

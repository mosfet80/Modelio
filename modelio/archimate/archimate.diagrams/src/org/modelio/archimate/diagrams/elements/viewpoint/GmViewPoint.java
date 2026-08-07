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
package org.modelio.archimate.diagrams.elements.viewpoint;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.swt.graphics.Image;
import org.modelio.archimate.diagrams.elements.common.archielement.GmArchiFreeZone;
import org.modelio.archimate.diagrams.elements.common.archiheader.GmArchiHeader;
import org.modelio.archimate.diagrams.elements.common.archiheader.INodeWithArchiHeader;
import org.modelio.archimate.metamodel.core.structure.ViewPoint;
import org.modelio.diagram.elements.common.header.GmModelElementHeader;
import org.modelio.diagram.elements.core.model.GmAbstractObject;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.elements.core.node.GmCompositeNode;
import org.modelio.diagram.elements.core.node.IImageableNode;
import org.modelio.diagram.persistence.IDiagramReader;
import org.modelio.diagram.persistence.IDiagramWriter;
import org.modelio.diagram.styles.core.AbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;
import org.modelio.diagram.styles.core.StyleKey.RepresentationMode;
import org.modelio.platform.model.ui.swt.images.ElementImageService;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Specialized class for {@link ViewPoint}.
 */
@objid ("84f05c54-b7a2-45ec-967f-1c78b35276f5")
public class GmViewPoint extends GmCompositeNode implements IImageableNode, INodeWithArchiHeader {
    @objid ("7044c73c-0020-4edc-af71-8e8cad394a2e")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm.
     */
    @objid ("0344f04a-6036-474d-9d96-8d2697b6ab80")
    private static final int MINOR_VERSION = 1;

    @objid ("586a5c25-9084-4d97-baec-ba3adafa3114")
    protected static final String BODY_ROLE = "body";

    @objid ("4fa85294-0f9c-433d-a5d7-dd4be1db255e")
    protected static final String HEADER_ROLE = "header";

    @objid ("a24ca867-e14e-473c-afb3-803e78df638a")
    static final AbstractStyleKeyProvider STRUCTURED_KEYS = new GmViewPointStructuredStyleKeys();

    @objid ("fdf1d00c-1f2a-4799-9d18-c9bd842d6c3b")
    private ViewPoint element;

    @objid ("b0594964-a2fa-4913-ab4e-01d53fd41898")
    private GmArchiFreeZone body;

    @objid ("983c67ca-d045-4076-b8b1-d9faa74fbdc7")
    protected GmViewPointHeader header;

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the ViewPoint is unmasked.
     * @param el the unmasked ViewPoint.
     * @param ref a reference to the unmasked ViewPoint.
     */
    @objid ("53ad304b-9e16-483d-b8ac-c0ae6f2d41b6")
    public GmViewPoint(IGmDiagram diagram, ViewPoint el, MRef ref) {
        super(diagram, ref);
        this.element = el;

        this.header = new GmViewPointHeader(diagram, ref);
        this.header.setShowMetaclassIcon(true);
        this.header.setRoleInComposition(GmViewPoint.HEADER_ROLE);
        this.addChild(this.header);

        this.body = new GmArchiFreeZone(diagram, ref);
        this.body.setRoleInComposition(GmViewPoint.BODY_ROLE);
        this.addChild(this.body);

    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("71f7c71b-a515-4629-ae43-77cd6705c892")
    public GmViewPoint() {
        // Nothing specific to do.
    }

    /**
     * Returns whether or not a 'type' can be created in this T.
     */
    @objid ("26b407ba-0186-49dd-ad0d-ca95d4451944")
    @Override
    public boolean canCreate(Class<? extends MObject> type) {
        return false;
    }

    /**
     * Returns whether or not 'el' can be unmasked in this T.
     */
    @objid ("5b3bbdd0-5a10-4555-9122-782228f0f280")
    @Override
    public boolean canUnmask(MObject el) {
        return false;
    }

    @objid ("4861d2f0-206e-4905-a915-263eae6f29e6")
    @Override
    public GmCompositeNode getCompositeFor(Class<? extends MObject> metaclass) {
        return this.body;
    }

    /**
     *
     * @return the Gm having the "header" role.
     */
    @objid ("c28aa1ae-e47c-4abd-a13f-d4fade8a72cd")
    @Override
    public GmModelElementHeader getHeader() {
        return this.header;
    }

    /**
     * Get the stereotype image to display.
     *
     * @return the stereotype image to display. Must not be <i>null</i>.
     */
    @objid ("5a3f2cf9-685f-41f2-8bad-ae230c0749c3")
    @Override
    public Image getImage() {
        return ElementImageService.getImage(getRelatedElement());
    }

    @objid ("0d5d8e3c-87f8-46ec-82d8-24036fb3168a")
    @Override
    public int getMajorVersion() {
        return GmViewPoint.MAJOR_VERSION;
    }

    @objid ("fc602d6a-5ed8-40c9-817e-c81422b3703c")
    @Override
    public final ViewPoint getRelatedElement() {
        return getRepresentedElement();
    }

    @objid ("c77743cf-4dc6-4932-9b31-be930e9489d5")
    @Override
    public final RepresentationMode getRepresentationMode() {
        return RepresentationMode.STRUCTURED;
    }

    @objid ("6771d441-a423-4a5d-978f-3b2793566ec7")
    @Override
    public final ViewPoint getRepresentedElement() {
        return this.element;
    }

    @objid ("68a58a28-acfe-4287-afa2-564a93870707")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = GmAbstractObject.readMinorVersion(in, "GmViewPoint.");
        switch (readVersion) {
        case 0: {
            read_0(in);
            break;
        }
        case 1: {
            read_1(in);
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

    @objid ("21421e8c-127d-4a30-9154-6a39646e6e3b")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        GmAbstractObject.writeMinorVersion(out, "GmViewPoint.", GmViewPoint.MINOR_VERSION);

    }

    @objid ("12a8ce26-bf44-4a91-b41c-68e938bce485")
    private void read_0(IDiagramReader in) {
        super.read(in);
        this.element = (ViewPoint) resolveRef(getRepresentedRef());
        this.body = (GmArchiFreeZone) getFirstChild(GmViewPoint.BODY_ROLE);

        GmArchiHeader oldHeader = (GmArchiHeader) getFirstChild(GmViewPoint.HEADER_ROLE);
        Object oldLayoutData = oldHeader.getLayoutData();
        oldHeader.delete();

        this.header = new GmViewPointHeader(getDiagram(), getRepresentedRef());
        this.header.setRoleInComposition(GmViewPoint.HEADER_ROLE);
        this.header.setLayoutData(oldLayoutData);
        super.addChild(this.header);

    }

    @objid ("7698f243-7311-419a-a732-ec9f1f4d3260")
    @Override
    public StyleKey getStyleKey(MetaKey metakey) {
        return GmViewPoint.STRUCTURED_KEYS.getStyleKey(metakey);
    }

    @objid ("7958af8e-e7dd-452f-8383-5b2c81ca7efb")
    @Override
    public List<StyleKey> getStyleKeys() {
        return GmViewPoint.STRUCTURED_KEYS.getStyleKeys();
    }

    @objid ("11617a86-a013-4ab4-8b18-5f603d46daae")
    private void read_1(IDiagramReader in) {
        super.read(in);
        this.element = (ViewPoint) resolveRef(getRepresentedRef());
        this.header = (GmViewPointHeader) getFirstChild(GmViewPoint.HEADER_ROLE);
        this.body = (GmArchiFreeZone) getFirstChild(GmViewPoint.BODY_ROLE);

    }

}

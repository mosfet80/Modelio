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
package org.modelio.archimate.diagrams.elements.archimatediagram;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.ArchimateMetamodel;
import org.modelio.archimate.metamodel.core.ArchimateView;
import org.modelio.archimate.metamodel.core.structure.Model;
import org.modelio.diagram.elements.common.abstractdiagram.GmAbstractDiagram;
import org.modelio.diagram.elements.common.portcontainer.GmPortContainer;
import org.modelio.diagram.elements.core.model.GmAbstractObject;
import org.modelio.diagram.elements.core.model.GmModel;
import org.modelio.diagram.elements.core.model.IGmDiagram.IModelManager;
import org.modelio.diagram.elements.core.model.IGmLink;
import org.modelio.diagram.elements.core.model.IGmLinkObject;
import org.modelio.diagram.elements.core.node.GmCompositeNode;
import org.modelio.diagram.elements.core.node.GmNodeModel;
import org.modelio.diagram.elements.plugin.DiagramElements;
import org.modelio.diagram.persistence.IDiagramReader;
import org.modelio.diagram.persistence.IDiagramWriter;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;
import org.modelio.diagram.styles.core.StyleKey.RepresentationMode;
import org.modelio.metamodel.InfrastructureMetamodel;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * This class represents the Gm of an {@link ArchimateView}.
 */
@objid ("d3071039-af8f-4f76-9296-5dbf70c6299f")
public class GmArchimateDiagram extends GmAbstractDiagram {
    /**
     * Current version of this Gm.
     * <p>
     * <li> 0 : initial version
     * <li> 1 : change links attached to port container to attach them to the primary node
     */
    @objid ("53d044d6-bd77-43a7-a4ac-79aa51bf9e75")
    private static final int MINOR_VERSION = 1;

    @objid ("e9bc1bf4-a6f6-4908-bc9b-f316c95d8d1a")
    private static final int MAJOR_VERSION = 0;

    @objid ("112615c9-9255-436a-bfd0-6f05726a3128")
    private ArchimateView element;

    @objid ("e72382c0-30cf-43bb-a06e-55002bfe4ac7")
    private static final GmArchimateDiagramStyleKeys STYLEKEYS = new GmArchimateDiagramStyleKeys();

    /**
     * Initialize the diagram.
     *
     * @param manager The model manager
     * @param theArchimateViewDiagram the displayed diagram.
     * @param diagramRef the reference of the displayed diagram. Must reference a {@link ArchimateView}.
     */
    @objid ("4632a882-7377-47c7-833e-2a8ee52b8c4f")
    public GmArchimateDiagram(IModelManager manager, ArchimateView theArchimateViewDiagram, MRef diagramRef) {
        super(manager, diagramRef);
        this.element = theArchimateViewDiagram;

    }

    @objid ("28086998-fb04-4506-89a0-b8dd503ce571")
    @Override
    public GmCompositeNode getCompositeFor(Class<? extends MObject> metaclass) {
        if (canCreate(metaclass)) {
            return this;
        } else {
            return null;
        }

    }

    @objid ("0d081518-a7dd-4834-b5b3-dde7221ffde5")
    @Override
    public RepresentationMode getRepresentationMode() {
        return RepresentationMode.STRUCTURED;
    }

    @objid ("c9af869d-84e9-48f6-a744-5820063a8446")
    @Override
    public StyleKey getStyleKey(MetaKey metakey) {
        return GmArchimateDiagram.STYLEKEYS.getStyleKey(metakey);
    }

    @objid ("428a1b75-aa19-4314-ba26-054b366dd544")
    @Override
    public List<StyleKey> getStyleKeys() {
        return GmArchimateDiagram.STYLEKEYS.getStyleKeys();
    }

    @objid ("900ae939-6a8b-4adf-b234-921570101380")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = GmAbstractObject.readMinorVersion(in, "GmArchimateViewDiagram.");
        switch (readVersion) {
        case 0: {
            read_0(in);
            break;
        }
        case 1:
            read_1(in);
            break;
        default: {
            assert (false) : readVersion + " version number not covered!";
            // reading as last handled version: 1
            read_1(in);
            break;
        }
        }

    }

    @objid ("da616339-7156-4a50-82b6-973ee18b93ce")
    @Override
    public void refreshFromObModel() {
        // Nothing to do.
    }

    @objid ("a8f291e0-2fab-4f5f-9f13-7a74bd540aad")
    @Override
    public ArchimateView getRepresentedElement() {
        return this.element;
    }

    @objid ("9d18b783-d2ad-432d-a020-53691ee0acab")
    @Override
    public ArchimateView getRelatedElement() {
        return getRepresentedElement();
    }

    @objid ("5b686db5-2311-47ba-ab35-e3e61a6dac39")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        GmAbstractObject.writeMinorVersion(out, "GmArchimateView.", GmArchimateDiagram.MINOR_VERSION);

    }

    @objid ("ff359d68-900d-457c-9600-22e521e79e8b")
    private void read_0(IDiagramReader in) {
        super.read(in);
        this.element = (ArchimateView) resolveRef(getRepresentedRef());

        // Fix Modelio 3.8.1 diagram migration issue:
        // Links are loaded after all nodes so node migration cannot change their attached links.
        // Change links attached to port container to attach them to the primary node
        for (IGmLinkObject gmLinkObj : getAllLinks()) {
            if (gmLinkObj instanceof IGmLink) {
                IGmLink gmLink = (IGmLink) gmLinkObj;
                if (gmLink.getFrom() instanceof GmPortContainer) {
                    GmPortContainer gmPc = (GmPortContainer) gmLink.getFrom();
                    GmNodeModel gmMainNode = gmPc.getMainNode();
                    gmPc.removeStartingLink(gmLink);
                    gmMainNode.addStartingLink(gmLink);
                }

                if (gmLink.getTo() instanceof GmPortContainer) {
                    GmPortContainer gmPc = (GmPortContainer) gmLink.getTo();
                    GmNodeModel gmMainNode = gmPc.getMainNode();
                    gmPc.removeEndingLink(gmLink);
                    gmMainNode.addEndingLink(gmLink);
                }

            }
        }

    }

    @objid ("b01c3161-3873-4cf1-b2ff-24d8525db127")
    private void read_1(IDiagramReader in) {
        super.read(in);
        this.element = (ArchimateView) resolveRef(getRepresentedRef());

    }

    @objid ("8cf3616c-1ea1-430e-ad09-becedcadf51b")
    @Override
    public int getMajorVersion() {
        return GmArchimateDiagram.MAJOR_VERSION;
    }

    @objid ("cf29c68c-20a4-41a2-aac4-6e21d160be9d")
    @Override
    public boolean canCreate(Class<? extends MObject> type) {
        return true;
    }

    @objid ("3de11133-07af-4533-9e0c-80bd8db467e9")
    @Override
    public boolean doCanUnmask(MObject el) {
        if (el instanceof Model) {
            return false;
        }
        return true;
    }

    @objid ("48aff292-7292-47cc-94c7-9b5b9b7df1ef")
    @Override
    public GmNodeModel unmask(GmCompositeNode parentNode, MObject newElement, Object initialLayoutData) {
        if (!isMultipleUnmaskAllowed(newElement)) {
            List<GmModel> allGMRepresenting = getAllGMRepresenting(new MRef(newElement));
            for (GmModel gmModel : allGMRepresenting) {
                if (gmModel instanceof GmNodeModel) {
                    GmNodeModel gmNodeModel = (GmNodeModel) gmModel;
                    if (parentNode.equals(gmNodeModel.getParentNode())) {
                        return gmNodeModel;
                    }
                }
            }
        }

        // No GmNode under this parent, create a new one...
        try {
            return getGmNodeFactory().create(this, parentNode, newElement, initialLayoutData);
        } catch (UnsupportedOperationException e) {
            // Failed to unmask, log error.
            DiagramElements.LOG.warning(e.getMessage());

            // No valid GM found, return null
            return null;
        }

    }

    /**
     *
     * @return <code>true</code> if the element belongs either to the ArchiMate or Infrastructure metamodel.
     */
    @objid ("bc886263-aa0d-4876-b8ef-9d6fd1c8510b")
    private boolean isMultipleUnmaskAllowed(MObject elt) {
        String originFragment = elt.getMClass().getOrigin().getName();
        return originFragment.equals(ArchimateMetamodel.NAME) || originFragment.equals(InfrastructureMetamodel.NAME);
    }

    @objid ("ddea5bff-49db-41fd-adc8-6be8f8bdb39e")
    @Override
    public String getFactoryIdentifier() {
        return ArchimateView.MNAME;
    }

    @objid ("27cdb573-be73-4cf6-bd49-e758f9cca865")
    @Override
    public boolean canUnmaskGenericElements() {
        return true;
    }

}

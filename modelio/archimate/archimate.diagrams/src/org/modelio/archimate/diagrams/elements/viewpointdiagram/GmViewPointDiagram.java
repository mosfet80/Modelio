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
package org.modelio.archimate.diagrams.elements.viewpointdiagram;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.draw2d.geometry.Rectangle;
import org.modelio.archimate.metamodel.core.ArchimateView;
import org.modelio.archimate.metamodel.core.ViewPointDiagram;
import org.modelio.archimate.metamodel.core.structure.ViewPoint;
import org.modelio.diagram.elements.common.abstractdiagram.GmAbstractDiagram;
import org.modelio.diagram.elements.core.model.IGmDiagram.IModelManager;
import org.modelio.diagram.elements.core.node.GmCompositeNode;
import org.modelio.diagram.elements.core.node.GmNodeModel;
import org.modelio.diagram.persistence.IDiagramReader;
import org.modelio.diagram.persistence.IDiagramWriter;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;
import org.modelio.diagram.styles.core.StyleKey.RepresentationMode;
import org.modelio.diagram.styles.core.view.ISymbolViewModel;
import org.modelio.metamodel.diagrams.AbstractDiagram;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * This class represents the Gm of an {@link ViewPointDiagram}.
 */
@objid ("e7f8e678-59b2-41c0-a9b9-29808204c7f9")
public class GmViewPointDiagram extends GmAbstractDiagram {
    /**
     * Current version of this Gm. Defaults to 0.
     */
    @objid ("8f75d7fe-1a97-4f4d-9f0c-16716498bb16")
    private static final int MINOR_VERSION = 0;

    @objid ("9e3ed266-2aa1-4e4b-a220-792f8638ddd0")
    private static final int MAJOR_VERSION = 0;

    @objid ("842e1f64-5dfc-4543-8138-0f6d9706e432")
    private ViewPointDiagram element;

    @objid ("f77f8c89-e748-4c18-88a1-a0953258084a")
    private static final GmViewPointDiagramStyleKeys STYLEKEYS = new GmViewPointDiagramStyleKeys();

    /**
     * Initialize the diagram.
     *
     * @param manager The model manager
     * @param theArchimateViewDiagram the displayed diagram.
     * @param diagramRef the reference of the displayed diagram. Must reference a {@link ArchimateView}.
     */
    @objid ("5fd8fc93-e432-4f61-afa8-d03ab0cd8ecd")
    public GmViewPointDiagram(IModelManager manager, ViewPointDiagram theArchimateViewDiagram, MRef diagramRef) {
        super(manager, diagramRef);
        this.element = theArchimateViewDiagram;
    }

    @objid ("8fccf62f-6bf9-4eaf-957e-1a0ab9ab8ba8")
    @Override
    public GmCompositeNode getCompositeFor(Class<? extends MObject> metaclass) {
        if (canCreate(metaclass)) {
            return this;
        } else {
            return null;
        }
    }

    @objid ("669a5903-fee7-4322-acc5-b3e69b5de806")
    @Override
    public RepresentationMode getRepresentationMode() {
        return RepresentationMode.STRUCTURED;
    }

    @objid ("d3d90573-cda1-4b95-a187-7479ad0f8254")
    @Override
    public StyleKey getStyleKey(MetaKey metakey) {
        return GmViewPointDiagram.STYLEKEYS.getStyleKey(metakey);
    }

    @objid ("0e289ec3-7c46-402c-857c-c1dd7dfd194d")
    @Override
    public List<StyleKey> getStyleKeys() {
        return GmViewPointDiagram.STYLEKEYS.getStyleKeys();
    }

    @objid ("0fb2a626-6988-4152-9680-0b9354a66e1f")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = readMinorVersion(in, "GmViewPointDiagram.");
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

    @objid ("c9cba92f-f62e-4587-80da-faad4cf77681")
    @Override
    public void refreshFromObModel() {
        super.refreshFromObModel();

        if (!getDisplayedStyle().getBoolean(GmViewPointDiagramStyleKeys.AUTOLAYOUT))
            return;

        ViewPoint owner = (ViewPoint) getRelatedElement().getCompositionOwner();
        if (owner == null)
            return;

        for (AbstractDiagram diagram : owner.getProduct()) {
            if (diagram instanceof ArchimateView) {
                if (getChild(new MRef(diagram)) == null) {
                    GmNodeModel node = getDiagram().unmask(this, diagram, null);
                    node.setLayoutData(new Rectangle(0, 0, 200, 200));
                }
            }
        }

        for (ViewPoint childViewPoint : owner.getChild()) {
            if (getChild(new MRef(childViewPoint)) == null) {
                GmNodeModel node = getDiagram().unmask(this, childViewPoint, null);
                node.setLayoutData(new Rectangle(0, 0, 200, 200));
            }
        }
    }

    @objid ("82aa1f4c-c6bf-4b73-9046-f3906c8b78c9")
    @Override
    public ViewPointDiagram getRepresentedElement() {
        return this.element;
    }

    @objid ("e36a8f74-a346-4ffb-a872-1560cda7f4b7")
    @Override
    public ViewPointDiagram getRelatedElement() {
        return getRepresentedElement();
    }

    @objid ("7f6d9349-43e9-4d82-9285-474cf60a07eb")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        writeMinorVersion(out, "ViewPointDiagram.", GmViewPointDiagram.MINOR_VERSION);
    }

    @objid ("043eddd9-ea2a-4631-ad8f-f29ad248a44f")
    private void read_0(IDiagramReader in) {
        super.read(in);
        this.element = (ViewPointDiagram) this.resolveRef(this.getRepresentedRef());
    }

    @objid ("eb1c6c8d-e8ed-4a74-beca-f70202fdf183")
    @Override
    public int getMajorVersion() {
        return GmViewPointDiagram.MAJOR_VERSION;
    }

    @objid ("351648eb-1d7d-4e7c-a615-0844ffae87f3")
    @Override
    public boolean canCreate(Class<? extends MObject> type) {
        return true;
    }

    @objid ("9fca3520-ab4c-4da9-9b25-afc621c93acc")
    @Override
    public boolean doCanUnmask(MObject el) {
        return true;
    }

    @objid ("5c7f8995-d1c9-46f3-b769-d3bbcbcacc97")
    @Override
    public String getFactoryIdentifier() {
        return ViewPointDiagram.MNAME;
    }

    @objid ("2164e627-d3c2-4868-9d9c-997d5f2fbb3e")
    @Override
    public boolean canUnmaskGenericElements() {
        return false;
    }

    @objid ("f0320e19-ad57-4b56-a213-142eec7a19cc")
    @Override
    public ISymbolViewModel getSymbolViewModel() {
        return new GmViewPointDiagramSymbolViewModelProvider().create(getPersistedStyle(), this);
    }

}

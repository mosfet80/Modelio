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
import org.modelio.diagram.elements.common.freezone.GmFreeZone;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.elements.core.node.GmNodeModel;
import org.modelio.diagram.persistence.IDiagramReader;
import org.modelio.diagram.persistence.IDiagramWriter;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;
import org.modelio.diagram.styles.core.StyleKey.RepresentationMode;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Defaults implementation of the abstract GmFreeZone that can be used for "body" of Archimate elements. The canUnmask and canCreate operations always return true.
 */
@objid ("315a04dc-c1f4-491d-bcb3-f3d988cd64da")
public class GmArchiFreeZone extends GmFreeZone {
    @objid ("b5963873-e0a6-4014-85cc-616afbba51f3")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm. Defaults to 0.
     */
    @objid ("61d9db80-3b3b-4f41-843d-faaedf81af57")
    private static final int MINOR_VERSION = 0;

    @objid ("ebf7d78c-1b42-4b46-b437-a4fd30883c71")
    private boolean isVisible = false;

    /**
     * C'tor for deserialization.
     */
    @objid ("86ca712c-3ef4-4a3f-9e05-02fea201e1f5")
    public GmArchiFreeZone() {
        // Nothing to do.
    }

    /**
     * C'tor.
     *
     * @param diagram the diagram in which this Gm is created.
     * @param relatedRef a reference to the element this GmModel is related to. never <i>null</i>.
     */
    @objid ("aedecc9d-873b-4fd4-8697-4a2311b04595")
    public GmArchiFreeZone(IGmDiagram diagram, MRef relatedRef) {
        super(diagram, relatedRef);
    }

    @objid ("01cd8250-0519-426a-8db1-c0309dcafbe1")
    @Override
    public boolean canCreate(Class<? extends MObject> type) {
        // Assume it's possible
        return true;
    }

    @objid ("06fef7bd-b67b-4164-9f1b-adfaea596edf")
    @Override
    public boolean canUnmask(MObject el) {
        // Assume it's possible for anything but a link
        return el != null && !el.getMClass().isLinkMetaclass();
    }

    @objid ("ceacaff8-9943-484e-8eee-1a2113af5ab0")
    @Override
    public int getMajorVersion() {
        return GmArchiFreeZone.MAJOR_VERSION;
    }

    @objid ("c5bcfb1c-cbde-4dba-b793-8ae51268df9f")
    @Override
    public boolean isVisible() {
        return getParent() != null && getParent().getRepresentationMode() == RepresentationMode.STRUCTURED && this.isVisible;
    }

    @objid ("b4f9ae65-bf13-4562-8a50-fb2c2e7c0777")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = readMinorVersion(in, "GmArchiFreeZone.");
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

    @objid ("47e72c8e-8893-469d-870e-f87fe7e966d2")
    @Override
    public void removeChild(GmNodeModel child) {
        super.removeChild(child);

        // Hide the group when the last child is removed
        if (!hasChildren()) {
            this.isVisible = false;
        }

        fireVisibilityChanged();

    }

    @objid ("afd7b649-b579-4a30-ac4a-d2a9536cad93")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        writeMinorVersion(out, "GmArchiFreeZone.", GmArchiFreeZone.MINOR_VERSION);

    }

    @objid ("8ce04c5c-15e9-47b6-a391-4df4e325d5a1")
    @Override
    protected void doSetVisible(boolean visible) {
        if (visible) {
            StyleKey key = getStyleKey(MetaKey.REPMODE);
            if (key != null) {
                getParent().getDisplayedStyle().setProperty(key, RepresentationMode.STRUCTURED);
            }
            this.isVisible = true;
        }

    }

    @objid ("de00518f-9332-4b9c-b177-56ba968168c7")
    @Override
    protected boolean isValidChild(GmNodeModel node) {
        final MObject childEl = node.getRelatedElement();
        return childEl == null || (!childEl.isDeleted() && canUnmask(childEl));
    }

    @objid ("c0be92ad-da7f-4db2-ba0c-8a69c4fb9eb0")
    private void read_0(IDiagramReader in) {
        super.read(in);

        this.isVisible = hasChildren();

    }

}

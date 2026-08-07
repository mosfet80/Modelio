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
package org.modelio.archimate.diagrams.elements.applicationprocess;

import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.applicationprocess.v0._GmApplicationProcess;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPortContainer;
import org.modelio.archimate.metamodel.layers.application.behavior.ApplicationProcess;
import org.modelio.diagram.elements.common.portcontainer.GmPortContainer;
import org.modelio.diagram.elements.core.model.GmAbstractObject;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.elements.core.node.GmNodeModel;
import org.modelio.diagram.persistence.IDiagramReader;
import org.modelio.diagram.persistence.IDiagramWriter;
import org.modelio.diagram.styles.core.AbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;
import org.modelio.diagram.styles.core.StyleKey.RepresentationMode;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Specialized class for {@link ApplicationProcess}.
 */
@objid ("2a98ca14-f063-42cf-9e57-d76dba8d3071")
public class GmApplicationProcess extends GmArchiElementPortContainer<ApplicationProcess> {
    @objid ("08320859-aa81-4706-aedd-50bc21eb5aeb")
    private static final int MAJOR_VERSION = 1;

    /**
     * Current version of this Gm.
     */
    @objid ("a40091a5-5f3b-49a6-aceb-efca9e73b346")
    private static final int MINOR_VERSION = 0;

    @objid ("21059da3-20fa-4332-8b6b-acc9aa49f946")
    static final AbstractStyleKeyProvider IMAGE_KEYS = new GmApplicationProcessImageStyleKeys();

    @objid ("92a6e405-c9ce-423e-a74e-71d4cc4f018a")
    static final AbstractStyleKeyProvider SIMPLE_KEYS = new GmApplicationProcessSimpleStyleKeys();

    @objid ("1d22d49c-85ce-4e41-b643-5eb4ada635e5")
    static final AbstractStyleKeyProvider STRUCTURED_KEYS = new GmApplicationProcessStructuredStyleKeys();

    @objid ("ddded6bc-51d0-47ca-a235-164c540dc23e")
    static final AbstractStyleKeyProvider USERIMAGE_KEYS = new GmApplicationProcessUserImageStyleKeys();

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the ApplicationProcess is unmasked.
     * @param el the unmasked ApplicationProcess.
     * @param ref a reference to the unmasked ApplicationProcess.
     */
    @objid ("c9186c04-bc37-4f3c-b0ac-af6e9f7ceab8")
    public GmApplicationProcess(IGmDiagram diagram, ApplicationProcess el, MRef ref) {
        super(diagram, el, ref);

        GmApplicationProcessPrimaryNode mainNode = new GmApplicationProcessPrimaryNode(diagram, el, ref);
        mainNode.setRoleInComposition(GmPortContainer.MAIN_NODE_ROLE);
        addChild(mainNode);

    }

    /**
     * Migration constructor from major version 0, should only be called by migrator.
     *
     * @param oldVersionGm the instance to migrate from.
     */
    @objid ("9cdb29c8-3d39-4555-9405-a26854cdca7c")
    GmApplicationProcess(final _GmApplicationProcess oldVersionGm) {
        super(oldVersionGm.getDiagram(), oldVersionGm.getRelatedElement(), oldVersionGm.getRepresentedRef());

        GmApplicationProcessPrimaryNode primary = new GmApplicationProcessPrimaryNode(oldVersionGm);
        primary.setRoleInComposition(GmPortContainer.MAIN_NODE_ROLE);
        addChild(primary);

    }

    @objid ("fc372405-c6df-4ff5-a719-3d904e58b6d2")
    @Override
    public int getMajorVersion() {
        return GmApplicationProcess.MAJOR_VERSION;
    }

    @objid ("14339a10-ae9a-4326-bf81-06681066e034")
    @Override
    public StyleKey getStyleKey(MetaKey metakey) {
        StyleKey styleKey = GmApplicationProcess.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return GmApplicationProcess.IMAGE_KEYS.getStyleKey(metakey);
            case USER_IMAGE:
                return GmApplicationProcess.USERIMAGE_KEYS.getStyleKey(metakey);
            case SIMPLE:
                return GmApplicationProcess.SIMPLE_KEYS.getStyleKey(metakey);
            case STRUCTURED:
                return GmApplicationProcess.STRUCTURED_KEYS.getStyleKey(metakey);
            default:
                break;
            }
        }
        return null;
    }

    @objid ("1f07cbfd-2453-4ad6-b297-280e713e70b9")
    @Override
    public List<StyleKey> getStyleKeys() {
        StyleKey styleKey = GmApplicationProcess.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return GmApplicationProcess.IMAGE_KEYS.getStyleKeys();
            case USER_IMAGE:
                return GmApplicationProcess.USERIMAGE_KEYS.getStyleKeys();
            case SIMPLE:
                return GmApplicationProcess.SIMPLE_KEYS.getStyleKeys();
            case STRUCTURED:
                return GmApplicationProcess.STRUCTURED_KEYS.getStyleKeys();
            default:
                break;
            }
        }
        return Collections.emptyList();
    }

    @objid ("896f5363-e206-4148-9e4c-d78fc049dde3")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = GmAbstractObject.readMinorVersion(in, "GmApplicationProcess.");
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

    @objid ("37f35ce2-5d04-4d79-8392-1ae486f495bb")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        GmAbstractObject.writeMinorVersion(out, "GmApplicationProcess.", GmApplicationProcess.MINOR_VERSION);

    }

    @objid ("f1dfda7c-5875-4754-be68-aeee1eefeeb6")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("c9e4b4c7-6134-4b6f-8d4a-ee5279b95e9b")
    public GmApplicationProcess() {
        // Nothing specific to do.
    }

    @objid ("ecee9fdb-f579-4b9e-bab5-7fd5a8a29af6")
    @Override
    public List<GmNodeModel> getVisibleChildren() {
        List<GmNodeModel> ret = super.getVisibleChildren();

        GmNodeModel firstChild = getMainNode();
        if (firstChild != null && firstChild.getRepresentationMode() == RepresentationMode.SIMPLE) {
            // In simple mode, remove the floating label: a proper label is provider by the primary node
            ret.remove(getFirstChild(GmPortContainer.SATELLITE_ROLE));
        }
        return ret;
    }

}

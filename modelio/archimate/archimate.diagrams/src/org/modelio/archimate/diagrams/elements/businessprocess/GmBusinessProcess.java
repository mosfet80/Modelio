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
package org.modelio.archimate.diagrams.elements.businessprocess;

import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.businessprocess.v0._GmBusinessProcess;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPortContainer;
import org.modelio.archimate.metamodel.layers.business.behavior.BusinessProcess;
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
 * Specialized class for {@link BusinessProcess}.
 */
@objid ("a07c9e6b-40cf-4e9d-a08f-5f76d12a992f")
public class GmBusinessProcess extends GmArchiElementPortContainer<BusinessProcess> {
    @objid ("9412b289-2332-4c5d-8c53-fc2692d818e3")
    private static final int MAJOR_VERSION = 1;

    /**
     * Current version of this Gm.
     */
    @objid ("e93bc362-3c10-465d-92bc-5ce6e4ef1971")
    private static final int MINOR_VERSION = 0;

    @objid ("83cfbe82-9a10-4376-ad80-a5e505664a05")
    static final AbstractStyleKeyProvider IMAGE_KEYS = new GmBusinessProcessImageStyleKeys();

    @objid ("1ac062ce-8acb-487a-a666-d52e8e4d8f89")
    static final AbstractStyleKeyProvider SIMPLE_KEYS = new GmBusinessProcessSimpleStyleKeys();

    @objid ("82b87b3a-1879-43b8-80f9-7c27cb43b7ea")
    static final AbstractStyleKeyProvider STRUCTURED_KEYS = new GmBusinessProcessStructuredStyleKeys();

    @objid ("f62a2332-d63d-4280-ad1f-284f57695bbd")
    static final AbstractStyleKeyProvider USERIMAGE_KEYS = new GmBusinessProcessUserImageStyleKeys();

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the BusinessProcess is unmasked.
     * @param el the unmasked BusinessProcess.
     * @param ref a reference to the unmasked BusinessProcess.
     */
    @objid ("da826a12-e423-4e94-b01a-f4f4a84566f1")
    public GmBusinessProcess(IGmDiagram diagram, BusinessProcess el, MRef ref) {
        super(diagram, el, ref);

        GmBusinessProcessPrimaryNode mainNode = new GmBusinessProcessPrimaryNode(diagram, el, ref);
        mainNode.setRoleInComposition(GmPortContainer.MAIN_NODE_ROLE);
        addChild(mainNode);

    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("8cd0cff5-2088-43a6-913b-6f0640b1acc8")
    public GmBusinessProcess() {
        // Nothing specific to do.
    }

    @objid ("32b3df67-5e9a-4c71-a00a-1be48543cf81")
    @Override
    public int getMajorVersion() {
        return GmBusinessProcess.MAJOR_VERSION;
    }

    @objid ("5b70c331-6357-49f0-b825-8616e213f44c")
    @Override
    public StyleKey getStyleKey(MetaKey metakey) {
        StyleKey styleKey = GmBusinessProcess.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return GmBusinessProcess.IMAGE_KEYS.getStyleKey(metakey);
            case USER_IMAGE:
                return GmBusinessProcess.USERIMAGE_KEYS.getStyleKey(metakey);
            case SIMPLE:
                return GmBusinessProcess.SIMPLE_KEYS.getStyleKey(metakey);
            case STRUCTURED:
                return GmBusinessProcess.STRUCTURED_KEYS.getStyleKey(metakey);
            default:
                break;
            }
        }
        return null;
    }

    @objid ("2d1ef0c2-1f3a-4c1a-83b8-99cc9f6783b9")
    @Override
    public List<StyleKey> getStyleKeys() {
        StyleKey styleKey = GmBusinessProcess.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return GmBusinessProcess.IMAGE_KEYS.getStyleKeys();
            case USER_IMAGE:
                return GmBusinessProcess.USERIMAGE_KEYS.getStyleKeys();
            case SIMPLE:
                return GmBusinessProcess.SIMPLE_KEYS.getStyleKeys();
            case STRUCTURED:
                return GmBusinessProcess.STRUCTURED_KEYS.getStyleKeys();
            default:
                break;
            }
        }
        return Collections.emptyList();
    }

    @objid ("bf400306-cbe5-4750-8cbc-534d44bde59b")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = GmAbstractObject.readMinorVersion(in, "GmBusinessProcess.");
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

    @objid ("7793d4f9-2a86-41fe-9e15-705dafe952a8")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        GmAbstractObject.writeMinorVersion(out, "GmBusinessProcess.", GmBusinessProcess.MINOR_VERSION);

    }

    @objid ("b6b1d6be-996b-4e40-a4b6-a233893427d5")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

    /**
     * Migration constructor from major version 0, should only be called by migrator.
     *
     * @param oldVersionGm the instance to migrate from.
     */
    @objid ("8e950b4b-e7ac-44b2-ad55-d979369c84e6")
    GmBusinessProcess(final _GmBusinessProcess oldVersionGm) {
        super(oldVersionGm.getDiagram(), oldVersionGm.getRelatedElement(), oldVersionGm.getRepresentedRef());

        GmBusinessProcessPrimaryNode primary = new GmBusinessProcessPrimaryNode(oldVersionGm);
        primary.setRoleInComposition(GmPortContainer.MAIN_NODE_ROLE);
        addChild(primary);

    }

    @objid ("c29f9639-0af7-4cda-b471-10eab1d92331")
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

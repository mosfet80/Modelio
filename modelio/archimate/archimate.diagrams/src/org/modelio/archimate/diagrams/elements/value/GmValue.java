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
package org.modelio.archimate.diagrams.elements.value;

import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPortContainer;
import org.modelio.archimate.diagrams.elements.value.v0._GmValue;
import org.modelio.archimate.metamodel.layers.motivation.Value;
import org.modelio.diagram.elements.common.portcontainer.GmPortContainer;
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
 * Specialized class for {@link Value}.
 */
@objid ("4b9176e7-4bfa-41da-aade-e6e4dcd47072")
public class GmValue extends GmArchiElementPortContainer<Value> {
    @objid ("38e44766-6668-47e5-b27e-e61c541c3964")
    private static final int MAJOR_VERSION = 1;

    /**
     * Current version of this Gm.
     */
    @objid ("9f9a4eee-4bff-4840-84a8-f8ac615091e9")
    private static final int MINOR_VERSION = 0;

    @objid ("663694f2-e05e-4e94-8473-127925d4fd86")
    static final AbstractStyleKeyProvider IMAGE_KEYS = new GmValueImageStyleKeys();

    @objid ("2c4720c7-5abd-4cc5-aca7-2d55cd94eaf7")
    static final AbstractStyleKeyProvider SIMPLE_KEYS = new GmValueSimpleStyleKeys();

    @objid ("92cf1543-a95e-4090-9765-cc626440c084")
    static final AbstractStyleKeyProvider STRUCTURED_KEYS = new GmValueStructuredStyleKeys();

    @objid ("811bfa5d-9aa6-4c9d-8527-23dbb896bcba")
    static final AbstractStyleKeyProvider USERIMAGE_KEYS = new GmValueUserImageStyleKeys();

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the Value is unmasked.
     * @param el the unmasked Value.
     * @param ref a reference to the unmasked Value.
     */
    @objid ("8e181f12-10e6-4a52-9cb6-c6495ee99479")
    public GmValue(IGmDiagram diagram, Value el, MRef ref) {
        super(diagram, el, ref);

        GmValuePrimaryNode mainNode = new GmValuePrimaryNode(diagram, el, ref);
        mainNode.setRoleInComposition(GmPortContainer.MAIN_NODE_ROLE);
        addChild(mainNode);

    }

    /**
     * Migration constructor from major version 0, should only be called by migrator.
     *
     * @param oldVersionGm the instance to migrate from.
     */
    @objid ("7c54be0f-1dbb-47c4-b3ef-99a4f7e9f8e2")
    GmValue(final _GmValue oldVersionGm) {
        super(oldVersionGm.getDiagram(), oldVersionGm.getRelatedElement(), oldVersionGm.getRepresentedRef());

        GmValuePrimaryNode primary = new GmValuePrimaryNode(oldVersionGm);
        primary.setRoleInComposition(GmPortContainer.MAIN_NODE_ROLE);
        addChild(primary);

    }

    @objid ("9b158b79-903f-439e-abec-e10868bc351f")
    @Override
    public int getMajorVersion() {
        return GmValue.MAJOR_VERSION;
    }

    @objid ("c37040fe-ed57-4154-972b-05dd59026f0f")
    @Override
    public StyleKey getStyleKey(MetaKey metakey) {
        StyleKey styleKey = STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return IMAGE_KEYS.getStyleKey(metakey);
            case USER_IMAGE:
                return USERIMAGE_KEYS.getStyleKey(metakey);
            case SIMPLE:
                return SIMPLE_KEYS.getStyleKey(metakey);
            case STRUCTURED:
                return STRUCTURED_KEYS.getStyleKey(metakey);
            default:
                break;
            }
        }
        return null;
    }

    @objid ("f3212f59-4bd0-4580-bf4f-4c8ee171efd3")
    @Override
    public List<StyleKey> getStyleKeys() {
        StyleKey styleKey = STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return IMAGE_KEYS.getStyleKeys();
            case USER_IMAGE:
                return USERIMAGE_KEYS.getStyleKeys();
            case SIMPLE:
                return SIMPLE_KEYS.getStyleKeys();
            case STRUCTURED:
                return STRUCTURED_KEYS.getStyleKeys();
            default:
                break;
            }
        }
        return Collections.emptyList();
    }

    @objid ("d97cc79f-b986-44da-8e02-e012873f051d")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = readMinorVersion(in, "GmValue.");
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

    @objid ("1ddc8521-4f58-4ba9-b882-63f6b3bddf7c")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        writeMinorVersion(out, "GmValue.", MINOR_VERSION);

    }

    @objid ("f0e6d8de-9165-497b-8558-2505291b87dd")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("88d22ca3-e8d4-4146-9f2e-b18e73f7fd3b")
    public GmValue() {
        // Nothing specific to do.
    }

    @objid ("e3df44d0-50af-4641-b4d5-55503acaa378")
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

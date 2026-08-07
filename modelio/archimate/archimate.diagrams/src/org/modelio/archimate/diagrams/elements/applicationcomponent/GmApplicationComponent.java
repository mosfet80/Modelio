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
package org.modelio.archimate.diagrams.elements.applicationcomponent;

import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.applicationcomponent.v0._GmApplicationComponent;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPortContainer;
import org.modelio.archimate.metamodel.layers.application.structure.active.ApplicationComponent;
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
 * Specialized class for {@link ApplicationComponent}.
 */
@objid ("425fe854-3a26-4d9f-b9d4-ba54153e12c6")
public class GmApplicationComponent extends GmArchiElementPortContainer<ApplicationComponent> {
    @objid ("666dc401-1a12-4964-a50d-4ef1e87b30db")
    private static final int MAJOR_VERSION = 1;

    /**
     * Current version of this Gm.
     */
    @objid ("f820cfd0-0816-488f-b01b-b689d16f1a8a")
    private static final int MINOR_VERSION = 0;

    @objid ("7e64906b-7afc-406d-8ca1-d51c559b12f3")
    static final AbstractStyleKeyProvider IMAGE_KEYS = new GmApplicationComponentImageStyleKeys();

    @objid ("9fcb3a8d-797c-46a7-8970-b4a03f86859b")
    static final AbstractStyleKeyProvider SIMPLE_KEYS = new GmApplicationComponentSimpleStyleKeys();

    @objid ("ec3123be-e3d2-4d22-9359-01fb6ebbd13b")
    static final AbstractStyleKeyProvider STRUCTURED_KEYS = new GmApplicationComponentStructuredStyleKeys();

    @objid ("19c52e27-db44-4e49-be93-249d11aff85a")
    static final AbstractStyleKeyProvider USERIMAGE_KEYS = new GmApplicationComponentUserImageStyleKeys();

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the ApplicationComponent is unmasked.
     * @param el the unmasked ApplicationComponent.
     * @param ref a reference to the unmasked ApplicationComponent.
     */
    @objid ("0500e606-ca5f-42bf-ab15-a915144f9c2d")
    public GmApplicationComponent(IGmDiagram diagram, ApplicationComponent el, MRef ref) {
        super(diagram, el, ref);

        GmApplicationComponentPrimaryNode mainNode = new GmApplicationComponentPrimaryNode(diagram, el, ref);
        mainNode.setRoleInComposition(GmPortContainer.MAIN_NODE_ROLE);
        addChild(mainNode);

    }

    /**
     * Migration constructor from major version 0, should only be called by migrator.
     *
     * @param oldVersionGm the instance to migrate from.
     */
    @objid ("4816b6e7-da8b-4bd0-a6d0-71f3ea8af86c")
    GmApplicationComponent(final _GmApplicationComponent oldVersionGm) {
        super(oldVersionGm.getDiagram(), oldVersionGm.getRelatedElement(), oldVersionGm.getRepresentedRef());

        GmApplicationComponentPrimaryNode primary = new GmApplicationComponentPrimaryNode(oldVersionGm);
        primary.setRoleInComposition(GmPortContainer.MAIN_NODE_ROLE);
        addChild(primary);

    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("1210c614-190e-489b-81ba-75105f2d697b")
    public GmApplicationComponent() {
        // Nothing specific to do.
    }

    @objid ("abc2d501-683b-459c-b63b-811bbfe853a5")
    @Override
    public int getMajorVersion() {
        return GmApplicationComponent.MAJOR_VERSION;
    }

    @objid ("a3c7f97e-25ad-466a-b042-48f73b111482")
    @Override
    public StyleKey getStyleKey(MetaKey metakey) {
        StyleKey styleKey = GmApplicationComponent.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return GmApplicationComponent.IMAGE_KEYS.getStyleKey(metakey);
            case USER_IMAGE:
                return GmApplicationComponent.USERIMAGE_KEYS.getStyleKey(metakey);
            case SIMPLE:
                return GmApplicationComponent.SIMPLE_KEYS.getStyleKey(metakey);
            case STRUCTURED:
                return GmApplicationComponent.STRUCTURED_KEYS.getStyleKey(metakey);
            default:
                break;
            }
        }
        return null;
    }

    @objid ("75960a88-6f4c-4fb9-b8ef-bfa4b3fbb6b4")
    @Override
    public List<StyleKey> getStyleKeys() {
        StyleKey styleKey = GmApplicationComponent.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return GmApplicationComponent.IMAGE_KEYS.getStyleKeys();
            case USER_IMAGE:
                return GmApplicationComponent.USERIMAGE_KEYS.getStyleKeys();
            case SIMPLE:
                return GmApplicationComponent.SIMPLE_KEYS.getStyleKeys();
            case STRUCTURED:
                return GmApplicationComponent.STRUCTURED_KEYS.getStyleKeys();
            default:
                break;
            }
        }
        return Collections.emptyList();
    }

    @objid ("2ed794d9-5d92-4250-a787-c7d8e397724c")
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

    @objid ("5b7bff26-0603-4629-a1fb-2bc409632da7")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = GmAbstractObject.readMinorVersion(in, "GmApplicationComponent.");
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

    @objid ("6e637980-2dff-4abe-aba3-ba84128e7376")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        GmAbstractObject.writeMinorVersion(out, "GmApplicationComponent.", GmApplicationComponent.MINOR_VERSION);

    }

    @objid ("23f2252c-dfce-4203-876b-dc08b94aee5f")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

}

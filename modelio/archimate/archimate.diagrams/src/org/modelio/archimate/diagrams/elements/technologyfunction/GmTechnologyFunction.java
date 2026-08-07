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
package org.modelio.archimate.diagrams.elements.technologyfunction;

import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPortContainer;
import org.modelio.archimate.diagrams.elements.technologyfunction.v0._GmTechnologyFunction;
import org.modelio.archimate.metamodel.layers.technology.behavior.TechnologyFunction;
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
 * Specialized class for {@link TechnologyFunction}.
 */
@objid ("97e0182d-dc54-44d1-be3f-0e2fcf9492cd")
public class GmTechnologyFunction extends GmArchiElementPortContainer<TechnologyFunction> {
    @objid ("018c3506-b641-4a10-a4d6-754fb5bb5a2c")
    private static final int MAJOR_VERSION = 1;

    /**
     * Current version of this Gm.
     */
    @objid ("05aa5fa1-9ce5-4a54-a49b-6283235d5b72")
    private static final int MINOR_VERSION = 0;

    @objid ("89ffbbf7-8879-4347-b199-165d8b4f37a1")
    static final AbstractStyleKeyProvider IMAGE_KEYS = new GmTechnologyFunctionImageStyleKeys();

    @objid ("939f8623-263a-447c-93a6-a8f0bb657f87")
    static final AbstractStyleKeyProvider SIMPLE_KEYS = new GmTechnologyFunctionSimpleStyleKeys();

    @objid ("a891ccc5-80ba-46ab-8b08-21d6304c15d1")
    static final AbstractStyleKeyProvider STRUCTURED_KEYS = new GmTechnologyFunctionStructuredStyleKeys();

    @objid ("683d9819-39af-4945-90e1-2c432ccb3714")
    static final AbstractStyleKeyProvider USERIMAGE_KEYS = new GmTechnologyFunctionUserImageStyleKeys();

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the TechnologyFunction is unmasked.
     * @param el the unmasked TechnologyFunction.
     * @param ref a reference to the unmasked TechnologyFunction.
     */
    @objid ("6499fb63-4e02-4e7c-a6be-dffc3db5b434")
    public GmTechnologyFunction(IGmDiagram diagram, TechnologyFunction el, MRef ref) {
        super(diagram, el, ref);

        GmTechnologyFunctionPrimaryNode mainNode = new GmTechnologyFunctionPrimaryNode(diagram, el, ref);
        mainNode.setRoleInComposition(GmPortContainer.MAIN_NODE_ROLE);
        addChild(mainNode);

    }

    /**
     * Migration constructor from major version 0, should only be called by migrator.
     *
     * @param oldVersionGm the instance to migrate from.
     */
    @objid ("e019af84-0c90-46c1-8828-90b132f2598b")
    GmTechnologyFunction(final _GmTechnologyFunction oldVersionGm) {
        super(oldVersionGm.getDiagram(), oldVersionGm.getRelatedElement(), oldVersionGm.getRepresentedRef());

        GmTechnologyFunctionPrimaryNode primary = new GmTechnologyFunctionPrimaryNode(oldVersionGm);
        primary.setRoleInComposition(GmPortContainer.MAIN_NODE_ROLE);
        addChild(primary);

    }

    @objid ("0de66708-93df-4fb3-96dd-e34035bf6f98")
    @Override
    public int getMajorVersion() {
        return GmTechnologyFunction.MAJOR_VERSION;
    }

    @objid ("02b7e8d8-ccb4-4879-9efb-d0c004312782")
    @Override
    public StyleKey getStyleKey(MetaKey metakey) {
        StyleKey styleKey = GmTechnologyFunction.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return GmTechnologyFunction.IMAGE_KEYS.getStyleKey(metakey);
            case USER_IMAGE:
                return GmTechnologyFunction.USERIMAGE_KEYS.getStyleKey(metakey);
            case SIMPLE:
                return GmTechnologyFunction.SIMPLE_KEYS.getStyleKey(metakey);
            case STRUCTURED:
                return GmTechnologyFunction.STRUCTURED_KEYS.getStyleKey(metakey);
            default:
                break;
            }
        }
        return null;
    }

    @objid ("47a47737-799a-4b76-b37a-5b2fabaf56bc")
    @Override
    public List<StyleKey> getStyleKeys() {
        StyleKey styleKey = GmTechnologyFunction.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return GmTechnologyFunction.IMAGE_KEYS.getStyleKeys();
            case USER_IMAGE:
                return GmTechnologyFunction.USERIMAGE_KEYS.getStyleKeys();
            case SIMPLE:
                return GmTechnologyFunction.SIMPLE_KEYS.getStyleKeys();
            case STRUCTURED:
                return GmTechnologyFunction.STRUCTURED_KEYS.getStyleKeys();
            default:
                break;
            }
        }
        return Collections.emptyList();
    }

    @objid ("7c0f430c-ef7b-4bdd-867f-a7355ecb959c")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = readMinorVersion(in, "GmTechnologyFunction.");
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

    @objid ("17cef997-11ab-43d1-a6da-37a21f73de38")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        writeMinorVersion(out, "GmTechnologyFunction.", MINOR_VERSION);

    }

    @objid ("1c2aa024-5faf-4982-8a45-21fc589c2fca")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("bfbd7ed4-a66a-4c23-8556-01bd6e572695")
    public GmTechnologyFunction() {
        // Nothing specific to do.
    }

    @objid ("b7d26229-1cb9-492a-a267-1d7264eb0f51")
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

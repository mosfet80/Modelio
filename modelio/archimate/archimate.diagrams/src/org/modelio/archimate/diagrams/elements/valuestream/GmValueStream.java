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
package org.modelio.archimate.diagrams.elements.valuestream;

import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPortContainer;
import org.modelio.archimate.metamodel.layers.strategy.behavior.ValueStream;
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
 * Specialized class for {@link ValueStream}.
 */
@objid ("a4aaca33-bb16-4c36-988d-358f3a95e827")
public class GmValueStream extends GmArchiElementPortContainer<ValueStream> {
    @objid ("7b514784-e579-460f-af85-40d548208a74")
    private static final int MAJOR_VERSION = 1;

    /**
     * Current version of this Gm.
     */
    @objid ("ff035e38-d436-472b-81f3-2502ea5505f1")
    private static final int MINOR_VERSION = 0;

    @objid ("a777ebdf-50b5-4d37-a545-29c29c50618b")
    static final AbstractStyleKeyProvider IMAGE_KEYS = new GmValueStreamImageStyleKeys();

    @objid ("f0e7375d-e5dd-4dc0-a10c-6547abe4e9c3")
    static final AbstractStyleKeyProvider SIMPLE_KEYS = new GmValueStreamSimpleStyleKeys();

    @objid ("102896f0-8581-40b5-8c19-7589f3326eaf")
    static final AbstractStyleKeyProvider STRUCTURED_KEYS = new GmValueStreamStructuredStyleKeys();

    @objid ("a125d6d1-6936-415c-b702-a3207f6cf4d2")
    static final AbstractStyleKeyProvider USERIMAGE_KEYS = new GmValueStreamUserImageStyleKeys();

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the ValueStream is unmasked.
     * @param el the unmasked ValueStream.
     * @param ref a reference to the unmasked ValueStream.
     */
    @objid ("ff1c0e36-495f-419a-8742-fa0f85e10c90")
    public GmValueStream(IGmDiagram diagram, ValueStream el, MRef ref) {
        super(diagram, el, ref);

        GmValueStreamPrimaryNode mainNode = new GmValueStreamPrimaryNode(diagram, el, ref);
        mainNode.setRoleInComposition(GmPortContainer.MAIN_NODE_ROLE);
        addChild(mainNode);

    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("7b12f03c-41ff-4967-89d4-959536186abb")
    public GmValueStream() {
        // Nothing specific to do.
    }

    @objid ("7a5907ef-9449-43c1-a0d7-25762c740542")
    @Override
    public int getMajorVersion() {
        return GmValueStream.MAJOR_VERSION;
    }

    @objid ("c7e421b4-ef2e-454b-9f8c-751b3aea17ae")
    @Override
    public StyleKey getStyleKey(MetaKey metakey) {
        StyleKey styleKey = GmValueStream.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return GmValueStream.IMAGE_KEYS.getStyleKey(metakey);
            case USER_IMAGE:
                return GmValueStream.USERIMAGE_KEYS.getStyleKey(metakey);
            case SIMPLE:
                return GmValueStream.SIMPLE_KEYS.getStyleKey(metakey);
            case STRUCTURED:
                return GmValueStream.STRUCTURED_KEYS.getStyleKey(metakey);
            default:
                break;
            }
        }
        return null;
    }

    @objid ("e9767c30-5c8d-46cf-b85f-60311f0943fd")
    @Override
    public List<StyleKey> getStyleKeys() {
        StyleKey styleKey = GmValueStream.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return GmValueStream.IMAGE_KEYS.getStyleKeys();
            case USER_IMAGE:
                return GmValueStream.USERIMAGE_KEYS.getStyleKeys();
            case SIMPLE:
                return GmValueStream.SIMPLE_KEYS.getStyleKeys();
            case STRUCTURED:
                return GmValueStream.STRUCTURED_KEYS.getStyleKeys();
            default:
                break;
            }
        }
        return Collections.emptyList();
    }

    @objid ("84bff309-0928-43a4-ab32-96d2bab380bc")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = GmAbstractObject.readMinorVersion(in, "GmValueStream.");
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

    @objid ("218c62b6-2f0f-454b-ac5c-38c56045c182")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        GmAbstractObject.writeMinorVersion(out, "GmValueStream.", GmValueStream.MINOR_VERSION);

    }

    @objid ("96c269d2-f51d-47a8-8b2d-f0e3a4df4d39")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

    @objid ("85cf47c5-c96c-4e85-953d-b56b74cf1516")
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

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
package org.modelio.archimate.diagrams.elements.flow;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.archilink.GmArchiRelationship;
import org.modelio.archimate.metamodel.relationships.dynamic.Flow;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.persistence.IDiagramReader;
import org.modelio.diagram.persistence.IDiagramWriter;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Graphic model for {@link Flow}.
 */
@objid ("92595490-6c52-4f9e-99b4-5e4e793df469")
public class GmFlow extends GmArchiRelationship<Flow> {
    /**
     * Current version of this Gm. Defaults to 0.
     */
    @objid ("bcfe17c4-cc83-4e98-a80e-faab6af6af99")
    private static final int MINOR_VERSION = 0;

    @objid ("d15bd3fe-3547-4dc1-a1a5-bc975d3979e7")
    private static final int MAJOR_VERSION = 0;

    /**
     * Style keys.
     */
    @objid ("6890fdde-4269-488a-a001-575ee4355ed0")
    public static final GmFlowLinkStyleKeys styleKeyProvider = new GmFlowLinkStyleKeys();

    /**
     * Initialize a graphic model.
     *
     * @param diagram The owning diagram.
     * @param elt The link element, may be <code>null</code>.
     * @param ref The link reference, may not be <code>null</code>.
     */
    @objid ("8c363952-65aa-40c8-b8e1-17889d767168")
    public GmFlow(IGmDiagram diagram, Flow elt, MRef ref) {
        super(diagram, elt, ref);
    }

    /**
     * For deserialization only.
     */
    @objid ("84b37d0f-60ef-4a8d-8c6f-62c483fab088")
    public GmFlow() {
        // Empty
    }

    @objid ("972f53b6-09db-4354-898b-8140df6c8084")
    @Override
    public StyleKey getStyleKey(MetaKey metakey) {
        return styleKeyProvider.getStyleKey(metakey);
    }

    @objid ("5a36f93f-deeb-4c3d-8ef0-099df88c514b")
    @Override
    public List<StyleKey> getStyleKeys() {
        return styleKeyProvider.getStyleKeys();
    }

    @objid ("30b8167d-e90b-4e38-a4ef-1e9f1d321d51")
    @Override
    protected void readLink(IDiagramReader in) {
        super.readLink(in);
    }

    @objid ("b17a4d1b-e064-4444-9fb6-67f645f48f01")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        writeMinorVersion(out, "GmFlow.", MINOR_VERSION);

    }

    @objid ("3eb81aa0-8894-4d35-806e-25a03d6b76f2")
    @Override
    public int getMajorVersion() {
        return MAJOR_VERSION;
    }

}

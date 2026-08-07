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
package org.modelio.archimate.diagrams.elements.common.anchors;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.gef.GraphicalEditPart;
import org.modelio.diagram.elements.core.link.anchors.fixed2.DefaultFixedAnchorProvider;
import org.modelio.diagram.elements.core.link.anchors.fixed2.core.IFixedNodeAnchorProvider;

/**
 * Central point to instantiate {@link IFixedNodeAnchorProvider}
 *
 * @author cmarin
 */
@objid ("87cc4920-58d8-4ca9-bc7e-8695ec9176c4")
public class ArchimateAnchors {
    @objid ("7e872cb2-71a5-4b46-97fb-f95b340a440f")
    public static IFixedNodeAnchorProvider defaultFor(GraphicalEditPart ep) {
        return DefaultFixedAnchorProvider.defaultFor(ep);
    }

}

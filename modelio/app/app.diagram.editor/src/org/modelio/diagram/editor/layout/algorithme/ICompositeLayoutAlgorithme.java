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
package org.modelio.diagram.editor.layout.algorithme;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.diagram.editor.layout.ILayoutAlgorithme;

@objid ("02f125f2-5bbe-4562-8d07-840f912ff5f4")
public interface ICompositeLayoutAlgorithme extends ILayoutAlgorithme {
    /**
     * Returns a list of sub-layout algorithms that this composite layout algorithm contains.
     * Each sub-layout algorithm can be used to layout a specific part of the diagram.
     *
     * @return a list of ILayoutAlgorithme instances representing the sub-layouts
     */
    @objid ("5dfe25e3-c0d7-4952-85fb-0e317ec30f05")
    List<ILayoutAlgorithme> getSubLayoutAlgorithmes();

}

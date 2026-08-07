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
package org.modelio.archimate.diagrams.elements.viewpointdiagram;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.diagram.elements.common.abstractdiagram.DiagramSymbolViewModelProvider;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.elements.style.SymbolViewContentBuilder;
import org.modelio.diagram.styles.core.IStyle;

/**
 * Symbol view builder for ViewPoint diagrams.
 *
 * @since 4.0
 */
@objid ("6ddc01f2-4656-4da1-8cbb-7dc47eebbb8d")
public class GmViewPointDiagramSymbolViewModelProvider extends DiagramSymbolViewModelProvider {
    @objid ("9be45cd9-5784-4fe7-bf68-fc9378df1985")
    @Override
    protected void addMoreItems(SymbolViewContentBuilder b, IStyle editedStyle, IGmDiagram input) {
        b.add(b.createStyleItem(GmViewPointDiagramStyleKeys.AUTOLAYOUT)
                .setNextChildrenFilter(b.filterEquals(GmViewPointDiagramStyleKeys.AUTOLAYOUT, Boolean.TRUE))
                .add(b.createStyleItem(GmViewPointDiagramStyleKeys.LAYOUTCOLUNMS)));

    }

}

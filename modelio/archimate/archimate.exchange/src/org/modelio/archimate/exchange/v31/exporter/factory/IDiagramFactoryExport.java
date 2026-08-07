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
package org.modelio.archimate.exchange.v31.exporter.factory;

import java.util.Map;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.exchange.v31.xmlmodel.Diagram;
import org.modelio.archimate.exchange.v31.xmlmodel.ModelType;
import org.modelio.archimate.exchange.v31.xmlmodel.ViewpointType;
import org.modelio.metamodel.diagrams.AbstractDiagram;

@objid ("1819138a-a59c-453e-a571-7a77fafe43bf")
public interface IDiagramFactoryExport {
    @objid ("5ca67dfa-5903-4727-978d-02a5185854d4")
    void setReferenceMap(Map<String, Object> refs);

    @objid ("ac46c4a2-288b-4151-8036-b8d2aade70cb")
    void createArchimateView(Diagram view, AbstractDiagram diagram);

    @objid ("86d1a634-ac2d-4b73-a0ac-f44deec4ae48")
    ViewpointType createViewPoint(ModelType context, Diagram view, AbstractDiagram diagram);

}

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
package org.modelio.archimate.exchange.v30.exporter.factory;

import java.util.Map;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.exchange.v30.xmlmodel.Diagram;
import org.modelio.archimate.exchange.v30.xmlmodel.ModelType;
import org.modelio.archimate.exchange.v30.xmlmodel.ViewpointType;
import org.modelio.metamodel.diagrams.AbstractDiagram;

@objid ("207ca067-d3b1-4ec4-af0c-d55a165a53de")
public interface IDiagramFactoryExport {
    @objid ("46c4f074-be43-4bb8-ae93-1b1de726be77")
    void setReferenceMap(Map<String, Object> refs);

    @objid ("1e73079b-c41f-4cff-ad2c-e8aa11b9762e")
    void createArchimateView(Diagram view, AbstractDiagram diagram);

    @objid ("23ec40ca-8ef5-419e-a3fb-27c835894c56")
    ViewpointType createViewPoint(ModelType context, Diagram view, AbstractDiagram diagram);

}

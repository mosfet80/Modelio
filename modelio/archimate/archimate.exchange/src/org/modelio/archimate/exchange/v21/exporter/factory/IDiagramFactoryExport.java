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
package org.modelio.archimate.exchange.v21.exporter.factory;

import java.util.Map;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.exchange.v21.xmlmodel.ViewType;
import org.modelio.metamodel.diagrams.AbstractDiagram;

@objid ("4bb2df4b-4c7b-4833-b7b6-1d1f4706ac9b")
public interface IDiagramFactoryExport {
    @objid ("8cab5bee-fced-42e1-bd66-0b5891b14562")
    void setReferenceMap(Map<String, Object> refs);

    @objid ("13151c42-77b6-4eb9-9da9-0bb1976311ad")
    void createArchimateView(ViewType view, AbstractDiagram diagram);

}

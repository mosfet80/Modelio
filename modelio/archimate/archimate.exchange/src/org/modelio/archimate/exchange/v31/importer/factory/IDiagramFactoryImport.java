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
package org.modelio.archimate.exchange.v31.importer.factory;

import java.util.Map;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.exchange.v31.xmlmodel.Diagram;
import org.modelio.archimate.metamodel.core.ArchimateView;
import org.modelio.archimate.metamodel.core.structure.Model;
import org.modelio.metamodel.uml.infrastructure.ModelElement;

@objid ("eb7235f7-2e29-4c36-b984-7f7afab577c0")
public interface IDiagramFactoryImport {
    @objid ("f51f65bf-953c-4d40-89e5-66081a2106ae")
    void setReferenceMap(Map<String, ModelElement> refs);

    @objid ("1b59eb47-dad6-49f1-8d54-57d04bd1c720")
    void createArchimateView(Model model, ArchimateView context, Diagram view);

}

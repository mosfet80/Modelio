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
import org.modelio.archimate.exchange.v21.xmlmodel.ModelType;
import org.modelio.archimate.metamodel.core.structure.Model;
import org.modelio.metamodel.uml.infrastructure.ModelElement;

@objid ("6dabef22-aab2-497e-848e-8f2bf9f315d1")
public interface IElementFactoryExport {
    @objid ("414f632b-7daa-4f2d-8de8-0174df06c630")
    void setReferenceMap(Map<String, Object> refs);

    @objid ("e9c303bc-7206-49c5-8ebd-735d715fe6f9")
    Object updateElement(ModelType context, Object jaxElement, ModelElement element);

    @objid ("f98e6589-f196-4e22-babc-a442d8e0d6b8")
    Object createElement(ModelElement element);

    @objid ("0854f499-5704-4b35-9817-e85162177e8a")
    void createOrganizations(ModelType context, Model model);

}

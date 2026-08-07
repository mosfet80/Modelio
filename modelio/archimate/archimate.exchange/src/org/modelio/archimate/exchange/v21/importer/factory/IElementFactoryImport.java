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
package org.modelio.archimate.exchange.v21.importer.factory;

import java.util.Map;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.exchange.v21.xmlmodel.OrganizationType;
import org.modelio.archimate.metamodel.core.structure.Model;
import org.modelio.metamodel.uml.infrastructure.ModelElement;

@objid ("03390236-28d9-4c8a-beb4-3a4b65c91bc6")
public interface IElementFactoryImport {
    @objid ("7e186a71-f0a5-486d-a40d-d263bd3d39d8")
    void setReferenceMap(Map<String, ModelElement> refs);

    @objid ("06ebba2b-b649-4edb-a5b9-c2d5af5f8468")
    void createOrganization(OrganizationType jaxOrg, Model model);

    @objid ("490c4ac8-4370-449d-8f50-a6d0b5cb0dbb")
    ModelElement findElement(String identifier);

    @objid ("a298c208-6dfa-4161-a952-cac00c731760")
    ModelElement createElement(String identifier, Object jaxElement);

    @objid ("ee205a40-6e61-4b22-9ef9-83d7d3284637")
    ModelElement updateElement(ModelElement element, Object jaxElement);

}

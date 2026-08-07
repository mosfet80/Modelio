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
package org.modelio.archimate.exchange.v30.importer.factory;

import java.util.Map;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.exchange.v30.xmlmodel.OrganizationsType;
import org.modelio.archimate.metamodel.core.structure.Model;
import org.modelio.metamodel.uml.infrastructure.ModelElement;

@objid ("711d966e-55a9-4ca3-b4c9-08c235932b6d")
public interface IElementFactoryImport {
    @objid ("c9e81ab1-7c86-453a-96b4-ea040b095f6b")
    void setReferenceMap(Map<String, ModelElement> refs);

    @objid ("7b394f2c-bd85-4b19-a7d5-ee448861cd0a")
    void createOrganization(OrganizationsType jaxOrg, Model model);

    @objid ("fb38b7c9-daa1-420e-814f-da7547d8be22")
    ModelElement findElement(String identifier);

    @objid ("0da5ed8a-bdfc-4654-8cd2-7558a27e0692")
    ModelElement createElement(String identifier, Object jaxElement);

    @objid ("29eaff6e-021c-4f16-8f11-b1dcf6d50188")
    ModelElement updateElement(ModelElement element, Object jaxElement);

}

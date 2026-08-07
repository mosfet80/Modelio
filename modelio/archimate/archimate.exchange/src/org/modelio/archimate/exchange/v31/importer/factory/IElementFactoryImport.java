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
import org.modelio.archimate.exchange.v31.xmlmodel.OrganizationsType;
import org.modelio.archimate.metamodel.core.structure.Model;
import org.modelio.metamodel.uml.infrastructure.ModelElement;

@objid ("276aa8a6-e194-46dd-b24b-55d9e209776f")
public interface IElementFactoryImport {
    @objid ("73f80e92-dfd8-4d8f-a038-ee0dbfd623d7")
    void setReferenceMap(Map<String, ModelElement> refs);

    @objid ("44fb284c-9947-4547-824f-ed143cd4649c")
    void createOrganization(OrganizationsType jaxOrg, Model model);

    @objid ("17c10cb7-9235-4de5-ade1-90789dcb5efc")
    ModelElement findElement(String identifier);

    @objid ("8d27798a-6b92-4e31-a167-93ffa56f5437")
    ModelElement createElement(String identifier, Object jaxElement);

    @objid ("534d82cd-056d-472f-8c7e-ca85a2cd8edf")
    ModelElement updateElement(ModelElement element, Object jaxElement);

}

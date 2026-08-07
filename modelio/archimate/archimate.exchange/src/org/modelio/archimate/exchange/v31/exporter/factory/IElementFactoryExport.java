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
import org.modelio.archimate.exchange.v31.xmlmodel.ModelType;
import org.modelio.archimate.metamodel.core.structure.Model;
import org.modelio.metamodel.uml.infrastructure.ModelElement;

@objid ("f155fdd0-050a-49ac-995c-80932f77dcb2")
public interface IElementFactoryExport {
    @objid ("349b46ab-90d9-40b7-b373-4ad3747691ed")
    void setReferenceMap(Map<String, Object> refs);

    @objid ("d3fa00dd-f303-4b60-b4d8-b54672a23edd")
    Object updateElement(ModelType context, Object jaxElement, ModelElement element);

    @objid ("ac62e617-954f-4071-865b-758a6960de17")
    Object createElement(ModelElement element);

    @objid ("9025a1f8-a211-493c-a908-45405958856d")
    void createOrganizations(ModelType context, Model model);

}

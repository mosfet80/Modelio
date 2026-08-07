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
import org.modelio.archimate.exchange.v30.xmlmodel.ModelType;
import org.modelio.archimate.metamodel.core.structure.Model;
import org.modelio.metamodel.uml.infrastructure.ModelElement;

@objid ("d33b0be2-7da9-4a23-8488-807e9465b436")
public interface IElementFactoryExport {
    @objid ("5974d467-c768-4811-af07-e28fd79d4790")
    void setReferenceMap(Map<String, Object> refs);

    @objid ("4399a7a7-9813-4f21-b777-45538d8d8506")
    Object updateElement(ModelType context, Object jaxElement, ModelElement element);

    @objid ("fe8bcb8e-4015-435d-a899-c6831fb1bbd1")
    Object createElement(ModelElement element);

    @objid ("85e9e3e7-dc75-4832-b3ae-f6554d52a395")
    void createOrganizations(ModelType context, Model model);

}

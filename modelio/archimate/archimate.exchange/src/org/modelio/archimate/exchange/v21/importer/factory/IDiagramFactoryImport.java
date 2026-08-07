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
import org.modelio.archimate.exchange.v21.xmlmodel.ViewType;
import org.modelio.archimate.metamodel.core.ArchimateView;
import org.modelio.archimate.metamodel.core.structure.Model;
import org.modelio.metamodel.uml.infrastructure.ModelElement;

@objid ("59de70e7-6f8b-46cb-8384-761e4ad63b6a")
public interface IDiagramFactoryImport {
    @objid ("5b24ac63-5058-4a70-8ca9-386668a699cf")
    void setReferenceMap(Map<String, ModelElement> refs);

    @objid ("92135954-7e64-41b2-8291-2728472cc78c")
    void createArchimateView(Model model, ArchimateView context, ViewType view);

}

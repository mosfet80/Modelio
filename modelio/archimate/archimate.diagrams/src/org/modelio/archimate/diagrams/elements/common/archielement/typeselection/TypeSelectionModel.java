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
package org.modelio.archimate.diagrams.elements.common.archielement.typeselection;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.api.modelio.model.scope.ElementScope;

@objid ("c9e11453-7f06-4b30-ba11-5a0148e7fe67")
public class TypeSelectionModel {
    /**
     * A list of all the types that are possible to create.
     */
    @objid ("4bbe160a-0120-4320-9743-7655f7887a86")
    private List<ElementScope> allowedTypes;

    @objid ("b2f86d99-e735-4cb7-bc88-17abbf45ee49")
    private ElementScope selectedType;

    @objid ("7503c8f8-7b53-4517-bdf3-f514c03edf1f")
    public TypeSelectionModel(final List<ElementScope> allowedTypes) {
        this.allowedTypes = allowedTypes;
    }

    @objid ("1b2ac709-c033-4eab-830b-565d4a369bb9")
    public List<ElementScope> getAllowedTypes() {
        return this.allowedTypes;
    }

    @objid ("99011995-b726-48cc-85bc-ed57b0aca04f")
    public void setAllowedTypes(final List<ElementScope> allowedTypes) {
        this.allowedTypes = allowedTypes;
    }

    @objid ("57d25d01-c8eb-437e-aba2-9c6dcaab88c6")
    public ElementScope getSelectedType() {
        return this.selectedType;
    }

    @objid ("30e64b22-6ba8-493f-9862-f3ebfda7409c")
    public void setSelectedType(final ElementScope selectedType) {
        this.selectedType = selectedType;
    }

}

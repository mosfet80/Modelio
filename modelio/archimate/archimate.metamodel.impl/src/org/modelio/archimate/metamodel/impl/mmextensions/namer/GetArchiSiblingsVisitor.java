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
package org.modelio.archimate.metamodel.impl.mmextensions.namer;

import java.util.HashSet;
import java.util.Set;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.core.ArchimateAbstractElement;
import org.modelio.archimate.metamodel.core.ArchimateView;
import org.modelio.archimate.metamodel.core.Relationship;
import org.modelio.archimate.metamodel.visitors.DefaultArchimateVisitor;
import org.modelio.metamodel.uml.infrastructure.Element;
import org.modelio.metamodel.uml.infrastructure.ModelElement;
import org.modelio.vcore.smkernel.mapi.MObject;

@objid ("ea8ab911-a6cd-499e-8479-fa0653115a0b")
public class GetArchiSiblingsVisitor extends DefaultArchimateVisitor {
    @objid ("70a51547-2ea9-4e9d-be1f-0dc4f24a81bb")
    private Set<String> results;

    @objid ("5eeb6a13-c648-4975-a4ec-f31658fc396d")
    public GetArchiSiblingsVisitor() {
        super();
        this.results = null;

    }

    @objid ("e3c0f06f-d000-4bfa-bbf9-e08656da83c3")
    public Set<String> getSiblings(Element element) {
        this.results = new HashSet<>(16);
        element.accept(this);
        this.results.remove(element.getName());
        return this.results;
    }

    @objid ("f0dc85cc-3ace-4e6b-b70f-c87f83c2d3bd")
    @Override
    public Object visitArchimateView(ArchimateView view) {
        ModelElement owner = view.getOrigin();
        if (owner != null) {
            for (Element e : owner.getProduct()) {
                this.results.add(e.getName());
            }
        }
        return null;
    }

    @objid ("c69f3d7c-96f0-40ea-95a4-bcec15c82a45")
    @Override
    public Object visitArchimateAbstractElement(ArchimateAbstractElement obj) {
        MObject owner = obj.getCompositionOwner();
        if (owner != null) {
            for (MObject child : owner.getCompositionChildren()) {
                this.results.add(child.getName());
            }
        }
        return null;
    }

    @objid ("00a11a4b-5751-47ba-bdd1-faabde2c3b26")
    @Override
    public Object visitRelationship(Relationship obj) {
        return "";
    }

}

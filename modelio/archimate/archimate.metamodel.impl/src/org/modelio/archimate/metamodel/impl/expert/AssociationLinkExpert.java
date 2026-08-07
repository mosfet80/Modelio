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
package org.modelio.archimate.metamodel.impl.expert;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.core.Element;
import org.modelio.archimate.metamodel.core.Relationship;
import org.modelio.archimate.metamodel.relationships.other.Association;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.mapi.MMetamodel;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.utils.metamodel.experts.ILinkExpertHelper;
import org.modelio.vcore.utils.metamodel.experts.links.WrappedLinkExpertHelper;

/**
 * Link expert for {@link Association} metaclass.
 * <p>
 * An association relationship is always allowed between two elements, or between a relationship and an element.
 *
 * @author cmarin
 */
@objid ("f1b21197-4d1b-4904-bc03-40a845546575")
class AssociationLinkExpert extends WrappedLinkExpertHelper {
    @objid ("e13ff126-2901-470d-b884-e5f1f1aa0c60")
    private final MClass mcElement;

    @objid ("421c1c5c-6ecd-46d5-abdb-72a511fa5b2e")
    private final MClass mcRelationship;

    /**
     *
     * @param defaultExpert the generated expert
     * @param mm the metamodel
     */
    @objid ("cff17e61-ff11-4a0a-90f2-2e3c2a204a4b")
    public AssociationLinkExpert(ILinkExpertHelper defaultExpert, MMetamodel mm) {
        super(defaultExpert);
        this.mcElement = mm.getMClass(Element.class);
        this.mcRelationship = mm.getMClass(Relationship.class);

    }

    @objid ("c14eaf3f-2468-4b3a-9832-5003c7b5cb3b")
    @Override
    public boolean canLink(MClass linkMetaclass, MClass from, MClass to) {
        if (from.hasBase(this.mcElement)) {
            if (to.hasBase(this.mcElement) || to.hasBase(this.mcRelationship)) {
                return true;
            }
            else
                return false;
        } else if (from.hasBase(this.mcRelationship)) {
            if (to.hasBase(this.mcElement))
                return true;
            else
                return false;
        }
        else
            return false;

    }

    @objid ("02b55cfa-2b91-4d9c-9942-f7ac98a9be05")
    @Override
    public boolean canLink(MClass linkMetaclass, MObject from, MObject to) {
        return canLink(linkMetaclass, from.getMClass(), to.getMClass());
    }

    @objid ("1cb1087d-9b54-4144-9ef7-8f8e0fdfbf8a")
    @Override
    public boolean canSource(MClass linkMetaclass, MClass from) {
        return (from.hasBase(this.mcElement) || from.hasBase(this.mcRelationship));
    }

    @objid ("84773bf1-890f-4599-a656-80b57eb1597a")
    @Override
    public boolean canSource(MObject linkElement, MObject from) {
        return canSource(linkElement.getMClass(), from.getMClass());
    }

    @objid ("21e2d2b2-5e22-4ea9-a8c6-4ae5a4fba3cf")
    @Override
    public boolean canTarget(MClass linkMetaclass, MClass to) {
        return to.hasBase(this.mcElement);
    }

    @objid ("42a832a6-5437-446c-8526-6aa258439c92")
    @Override
    public boolean canTarget(MObject linkElement, MObject to) {
        return canTarget(linkElement.getMClass(), to.getMClass());
    }

}

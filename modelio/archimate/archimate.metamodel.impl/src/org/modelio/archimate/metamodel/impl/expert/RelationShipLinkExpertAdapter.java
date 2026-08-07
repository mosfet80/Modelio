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
import org.modelio.archimate.metamodel.core.Relationship;
import org.modelio.archimate.metamodel.relationships.dependency.Access;
import org.modelio.archimate.metamodel.relationships.dependency.Influence;
import org.modelio.archimate.metamodel.relationships.dependency.Serving;
import org.modelio.archimate.metamodel.relationships.dynamic.DynamicRelationship;
import org.modelio.archimate.metamodel.relationships.other.Association;
import org.modelio.archimate.metamodel.relationships.other.Junction;
import org.modelio.archimate.metamodel.relationships.structural.Assignment;
import org.modelio.archimate.metamodel.relationships.structural.Realization;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.mapi.MMetamodel;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.utils.metamodel.experts.ILinkExpertHelper;
import org.modelio.vcore.utils.metamodel.experts.links.WrappedLinkExpertHelper;

/**
 * Extends the wrapped expert with handling junctions sources and targets.
 * <p>
 * A junction is used to connect relationships of the same type.
 * <p>
 * The relationships that can be used in combination with a junction are all the dynamic
 * relationships, as well as assignment, realization, and association.
 */
@objid ("5ba920a0-1cd3-4907-9566-149c51191aa6")
class RelationShipLinkExpertAdapter extends WrappedLinkExpertHelper {
    @objid ("87d208a1-311e-4680-9d65-cf0336075117")
    private MClass mcJunction;

    /**
     *
     * @param defaultExpert the expert to wrap
     * @param mm the metamodel
     */
    @objid ("c3cd846a-ea9c-484b-8c32-7c48f0ec5080")
    public RelationShipLinkExpertAdapter(ILinkExpertHelper defaultExpert, MMetamodel mm) {
        super(defaultExpert);
        this.mcJunction = mm.getMClass(Junction.class);

        mm.getMClass(DynamicRelationship.class);
        mm.getMClass(Assignment.class);
        mm.getMClass(Realization.class);
        mm.getMClass(Association.class);

    }

    @objid ("851e8013-4a73-4b86-a5b5-49cc89c48ef9")
    private boolean isAllowedJunctionLink(MClass mcls) {
        Class<? extends MObject> jcls = mcls.getJavaInterface();
        return DynamicRelationship.class.isAssignableFrom(jcls) ||
                                        Assignment.class.isAssignableFrom(jcls) ||
                                        Realization.class.isAssignableFrom(jcls) ||
                                        Association.class.isAssignableFrom(jcls) ||
                                        Serving.class.isAssignableFrom(jcls)||
                                        Access.class.isAssignableFrom(jcls)||
                                        Influence.class.isAssignableFrom(jcls);

    }

    @objid ("183a66d9-a893-4eb9-a4d9-64fc2edd7f7a")
    @Override
    public boolean canLink(MClass linkMetaclass, MClass from, MClass to) {
        int junctionState = 0;

        if (from.hasBase(this.mcJunction)) {
            junctionState |= 1;
        }

        if (to.hasBase(this.mcJunction)) {
            junctionState |= 2;
        }

        switch( junctionState) {
        case 0:
            return super.canLink(linkMetaclass, from, to);
        case 1:
            return isAllowedJunctionLink(linkMetaclass) && super.canTarget(linkMetaclass, to);
        case 2:
            return isAllowedJunctionLink(linkMetaclass) && super.canSource(linkMetaclass, from);
        case 3:
            return isAllowedJunctionLink(linkMetaclass) ;
        default:
            throw new IllegalStateException(String.valueOf(junctionState));
        }

    }

    @objid ("f9a90207-aa40-4ccc-b75a-a7f463e2564c")
    @Override
    public boolean canSource(MClass linkMetaclass, MClass from) {
        if (from.hasBase(this.mcJunction)) {
            return isAllowedJunctionLink(linkMetaclass);
        } else {
            return super.canSource(linkMetaclass, from);
        }

    }

    @objid ("23d03eb7-74fc-4d38-8a0a-507bc45541f5")
    @Override
    public boolean canTarget(MClass linkMetaclass, MClass to) {
        if (to.hasBase(this.mcJunction)) {
            return isAllowedJunctionLink(linkMetaclass);
        } else {
            return super.canTarget(linkMetaclass, to);
        }

    }

    @objid ("427ea485-33e8-402c-b676-0067fd3c451c")
    @Override
    public boolean canSource(MObject linkElement, MObject from) {
        if (from instanceof Junction) {
            if (isAllowedJunctionLink(linkElement.getMClass())) {
                MClass junctionType = getJunctionType((Junction) from);
                return (junctionType == null || junctionType.equals(linkElement.getMClass())) ;
            } else {
                return false;
            }
        } else {
            return super.canSource(linkElement, from);
        }

    }

    @objid ("a0236c98-6f8c-4cde-bd23-ad2817f06578")
    @Override
    public boolean canTarget(MObject linkElement, MObject to) {
        if (to instanceof Junction) {
            if (isAllowedJunctionLink(linkElement.getMClass())) {
                MClass junctionType = getJunctionType((Junction) to);
                return (junctionType == null || junctionType.equals(linkElement.getMClass())) ;
            } else {
                return false;
            }
        } else {
            return super.canTarget(linkElement, to);
        }

    }

    @objid ("82544aa2-7d2c-42c3-983b-5faeef9720a6")
    @Override
    public boolean canLink(MClass linkMetaclass, MObject from, MObject to) {
        int junctionState = 0;

        if (from instanceof Junction) {
            junctionState |= 1;
            MClass junctionType = getJunctionType((Junction) from);
            if (junctionType != null && ! junctionType.equals(linkMetaclass)) {
                return false;
            }
        }

        if (to instanceof Junction) {
            junctionState |= 2;
            MClass junctionType = getJunctionType((Junction) to);
            if (junctionType != null && ! junctionType.equals(linkMetaclass)) {
                return false;
            }
        }

        switch( junctionState) {
        case 0:
            return super.canLink(linkMetaclass, from, to);
        case 1:
            return isAllowedJunctionLink(linkMetaclass) && super.canTarget(linkMetaclass, to.getMClass());
        case 2:
            return isAllowedJunctionLink(linkMetaclass) && super.canSource(linkMetaclass, from.getMClass());
        case 3:
            return isAllowedJunctionLink(linkMetaclass);
        default:
            throw new IllegalStateException(String.valueOf(junctionState));
        }

    }

    /**
     * Get the type of the junction relations.
     * <p>
     * Return the type of the first relation already connected to this junction.
     *
     * @param j a junction
     * @return the type of this junction relations.
     */
    @objid ("31b81c33-96c6-4308-a5a2-d2627c55d5c9")
    private MClass getJunctionType(Junction j) {
        for (Relationship r : j.getRelatedFrom()) {
            return r.getMClass();
        }

        for (Relationship r : j.getRelatedTo()) {
            return r.getMClass();
        }
        return null;
    }

}

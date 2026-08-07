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
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.mapi.MMetamodel;
import org.modelio.vcore.utils.metamodel.experts.ILinkExpertHelper;

/**
 * Link expert for link metaclasses that are <b>always allowed</b> between two instances
 * of the same {@link Element} type, such as aggregation, composition and specialization.
 *
 * @author cmarin
 */
@objid ("171bb79a-e824-41a4-9cbe-2c9b4f7e90b2")
class ReflexiveLinkExpert extends RedefinedLinkExpert {
    @objid ("31b2f281-95d0-4962-9a0f-5cb65a34518f")
    private MClass mcElement;

    /**
     *
     * @param defaultExpert the expert to wrap
     * @param mm the metamodel
     */
    @objid ("6f147d71-487e-448f-a6d9-9ca6ce17234d")
    public ReflexiveLinkExpert(ILinkExpertHelper defaultExpert, MMetamodel mm) {
        super(defaultExpert);
        this.mcElement = mm.getMClass(Element.class);

    }

    @objid ("b96ecfb3-f576-4ed0-a0de-047e045b7ac0")
    @Override
    public boolean canLink(MClass linkMetaclass, MClass from, MClass to) {
        return from.equals(to) || super.canLink(linkMetaclass, from, to);
    }

    @objid ("b32a65d0-4e35-479a-84f7-f4ad72b6109f")
    @Override
    public boolean canSource(MClass linkMetaclass, MClass from) {
        return from.hasBase(this.mcElement);
    }

    @objid ("5b40afc0-21f6-44d1-8114-6ad5e1a27d5f")
    @Override
    public boolean canTarget(MClass linkMetaclass, MClass to) {
        return to.hasBase(this.mcElement);
    }

}

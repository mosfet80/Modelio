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
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.utils.metamodel.experts.ILinkExpertHelper;
import org.modelio.vcore.utils.metamodel.experts.links.WrappedLinkExpertHelper;

/**
 * WrappedLinkExpertHelper with some more methods redefined with default behavior.
 *
 * @author cmarin
 */
@objid ("f9a590ec-587b-4275-8d06-f4fb7bf6ce18")
abstract class RedefinedLinkExpert extends WrappedLinkExpertHelper {
    /**
     *
     * @param defaultExpert the expert to wrap.
     */
    @objid ("893f0c17-4d38-44dd-9ad2-be339178185d")
    public RedefinedLinkExpert(ILinkExpertHelper defaultExpert) {
        super(defaultExpert);
    }

    @objid ("deac28a2-eec2-41e4-9fe0-08b4fde90f22")
    @Override
    public boolean canLink(MClass linkMetaclass, MObject from, MObject to) {
        return canLink(linkMetaclass, from.getMClass(), to.getMClass());
    }

    @objid ("6255255e-3d8e-42ba-bc05-5f25a292c21f")
    @Override
    public boolean canSource(MObject linkElement, MObject from) {
        return canSource(linkElement.getMClass(), from.getMClass());
    }

    @objid ("dc2e31c0-d436-4e20-9640-e82388ff2c14")
    @Override
    public boolean canTarget(MObject linkElement, MObject to) {
        return canTarget(linkElement.getMClass(), to.getMClass());
    }

}

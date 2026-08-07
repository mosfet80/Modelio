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
package org.modelio.vcore.smkernel.transaction;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.vcore.smkernel.mapi.MAttribute;

/**
 * MObject {@link MAttribute attribute} modification action.
 *
 * @since 5.5
 */
@objid ("287f18ad-a11a-47ec-b3e0-1e4b44e75453")
public interface ISmSetAttAction extends ISmAction {
    /**
     *
     * @return the modified attribute
     */
    @objid ("ecaa20cb-e20b-4a78-9e66-d1b13ac18689")
    MAttribute getAtt();

    /**
     *
     * @return the new attribute value
     */
    @objid ("6d1c7ebf-0397-4d6d-8eb6-7063aa6f43fc")
    Object getNewValue();

    /**
     *
     * @return the old attribute value
     */
    @objid ("63e638ea-5b09-4a74-aa2b-315ea9a0769b")
    Object getOldValue();

    @objid ("2f7370ca-447e-4acb-ad40-2b5051718fba")
    @Override
    default <T> T acceptSmActionVisitor(ISmActionVisitor<T> visitor) {
        return visitor.visitSmSetAttAction(this);
    }

}

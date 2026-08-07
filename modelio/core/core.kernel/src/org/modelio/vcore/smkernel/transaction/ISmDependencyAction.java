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
import org.modelio.vcore.smkernel.mapi.MDependency;
import org.modelio.vcore.smkernel.mapi.MObject;

/**
 * Dependency modification action.
 * <p>
 * This is an "abstract" interface, do not implement it.
 * Implement instead its sub interfaces.
 *
 * @since 5.5
 */
@objid ("d1e0975e-25af-4fd1-8ba7-af6c269df4de")
public interface ISmDependencyAction extends ISmAction {
    /**
     *
     * @return the modified dependency
     */
    @objid ("218fa9ad-4992-4e0c-95b5-e416b2f47095")
    MDependency getDep();

    /**
     *
     * @return the added/removed/... dependency value
     */
    @objid ("3f79d323-42dd-4f19-a439-4e527228b2d8")
    MObject getValue();

    /**
     *
     * @return the index of the insertion/deletion/...
     */
    @objid ("be3ba977-cee1-4fdb-bd55-fc8ca616ed2b")
    int getIndex();

}

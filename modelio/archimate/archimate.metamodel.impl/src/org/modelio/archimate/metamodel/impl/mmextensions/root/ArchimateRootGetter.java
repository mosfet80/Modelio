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
package org.modelio.archimate.metamodel.impl.mmextensions.root;

import java.util.Collection;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.core.structure.ArchimateProject;
import org.modelio.vcore.model.api.IRepositoryRootGetter;
import org.modelio.vcore.session.api.repository.IRepository;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.SmMetamodel;

@objid ("402d77cd-a93f-4be2-b8c7-d30fc2a6a7fe")
public class ArchimateRootGetter implements IRepositoryRootGetter {
    @objid ("a27253c8-b435-41f4-80a8-95049de1bca8")
    private final SmMetamodel mm;

    @objid ("817ea41f-7173-42d4-a60a-bb7dbf4dd3d7")
    @Override
    public Collection<MObject> getRootElements(IRepository repository) {
        Collection<MObject> roots = repository.findByClass(this.mm.getMClass(ArchimateProject.class));
        return roots;
    }

    @objid ("65d8e6d6-63ca-4c6a-8c78-f40954d66af2")
    public ArchimateRootGetter(SmMetamodel mm) {
        this.mm = mm;
    }

}

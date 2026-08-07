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
/*
 * Copyright 2013-2024 Docaposte
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
package org.modelio.vcore.session.impl.query;

import java.util.Collection;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.vcore.session.api.repository.IRepository;
import org.modelio.vcore.session.api.repository.IRepositoryQueryRunner;
import org.modelio.vcore.smkernel.IMetaOf;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MQueryRunner;
import org.modelio.vcore.smkernel.meta.SmDependency;

/**
 * Default {@link MQueryRunner} implementation for all {@link IMetaOf} implementations.
 */
@objid ("6773c74a-26b1-49e2-b2fe-c38e0cf373cc")
@SuppressWarnings("deprecation")
public class StdQueryRunner implements MQueryRunner {
    @objid ("44294bc4-070b-4507-b88e-960371d0dead")
    private final List<IRepositoryQueryRunner> repositories;

    @objid ("ef529e1a-899d-4a73-ba93-3d90d8e3d709")
    public StdQueryRunner(Collection<IRepository> repositories) {
        this.repositories = repositories.stream().map(r->r.query()).toList();
    }

    @objid ("b11b221c-19f6-4d27-9cc8-44799676c7a9")
    @Override
    public void loadAllReferencesTo(Collection<SmObjectImpl> objs) {
        for (IRepositoryQueryRunner repo : this.repositories) {
            repo.loadAllReferencesTo(objs);
        }
    }

    @objid ("32ae4c34-c8a2-4dec-9a69-b315ee9999c3")
    @Override
    public Collection<SmObjectImpl> getDepValue(SmObjectImpl object, SmDependency dep) {
        // Currently everything is loaded into the object itself.
        // Return the dependency content skipping the meta object.
        return dep.getValueAsCollection(object.getData());
    }

    @objid ("e080f362-f887-42fe-9ab2-9e847163f081")
    @Override
    public void close() {
        for (IRepositoryQueryRunner repo : this.repositories) {
            repo.close();
        }
    }

}

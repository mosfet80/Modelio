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
package org.modelio.archimate.metamodel.impl.mmextensions.populator;

import java.util.ArrayList;
import java.util.Collection;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.core.structure.ArchimateProject;
import org.modelio.archimate.metamodel.core.structure.Folder;
import org.modelio.archimate.metamodel.mmextensions.archimate.IArchimateModelFactory;
import org.modelio.vcore.model.api.IRepositoryContentInitializer;
import org.modelio.vcore.model.api.MTools;
import org.modelio.vcore.session.api.ICoreSession;
import org.modelio.vcore.session.api.repository.IRepository;
import org.modelio.vcore.smkernel.mapi.MObject;

/**
 * Initialize new fragments content.
 * <p>
 * Creates the {@link ArchimateProject} and layer {@link Folder}s.
 */
@objid ("d34055f1-1a1a-46b7-bdcd-1b317a5ce3fd")
public class ArchimatePopulator implements IRepositoryContentInitializer {
    /**
     * Populate the given repository using the given session.
     *
     * @param fragmentName the fragment name
     * @param s the session to use
     * @param repository the repository to populate.
     * @return the created objects.
     */
    @objid ("204c0b01-095b-4d5b-a843-f00c4bfc6fb0")
    @Override
    public Collection<MObject> populate(String fragmentName, ICoreSession s, IRepository repository) {
        Collection<MObject> ret = new ArrayList<>();

        IArchimateModelFactory modelFactory = MTools.get(s).getModelFactory(IArchimateModelFactory.class);
        ret.add(modelFactory.createArchimateProject(fragmentName, repository));
        return ret;
    }

}

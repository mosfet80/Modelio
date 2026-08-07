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
package org.modelio.archimate.metamodel.impl.mmextensions;

import org.modelio.archimate.metamodel.impl.ArchimateMetamodelFragment;
import org.modelio.archimate.metamodel.impl.mmextensions.configurator.ArchimateElementConfigurator;
import org.modelio.archimate.metamodel.impl.mmextensions.factory.ArchimateModelFactory;
import org.modelio.archimate.metamodel.impl.mmextensions.migration.ArchimateMmMigrationProvider;
import org.modelio.archimate.metamodel.impl.mmextensions.namer.ArchimateNamer;
import org.modelio.archimate.metamodel.impl.mmextensions.populator.ArchimatePopulator;
import org.modelio.archimate.metamodel.impl.mmextensions.root.ArchimateRootGetter;
import org.modelio.vcore.model.api.IElementConfigurator;
import org.modelio.vcore.model.api.IElementNamer;
import org.modelio.vcore.model.api.IRepositoryContentInitializer;
import org.modelio.vcore.model.api.IRepositoryRootGetter;
import org.modelio.vcore.model.spi.AbstractGMetamodelExtension;
import org.modelio.vcore.model.spi.IModelFactoryProvider;
import org.modelio.vcore.model.spi.mm.IMofRepositoryMigratorProvider;
import org.modelio.vcore.session.api.ICoreSession;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

/**
 * Archimate metamodel extensions declaration.
 *
 * @author cmarin
 * @since 3.6
 */
@objid("99d4a9cc-ff54-4aec-ab45-e9d22afb4552")
public class ArchimateMetamodelExtension extends AbstractGMetamodelExtension {
	@objid("778bba6c-d180-4e21-afd2-7aa3cd4adce9")
	public ArchimateMetamodelExtension() {
		super(ArchimateMetamodelFragment.getInstance());
	}

	@objid("3c5b06bf-9d47-4799-894f-637ba83c5595")
	@Override
	protected IElementNamer getNamer(ICoreSession session) {
		return new ArchimateNamer();
	}

	@objid("bf9e8247-b2e1-41b5-905a-258ab524ab0a")
	@Override
	protected IElementConfigurator getConfigurator(ICoreSession session) {
		return new ArchimateElementConfigurator();
	}

	@objid("121b3c08-416d-458d-8e58-3a56bf2d903d")
	@Override
	protected IRepositoryContentInitializer getPopulator(ICoreSession session) {
		return new ArchimatePopulator();
	}

	@objid("2bc7ca47-8e6d-458f-a275-403e889435cf")
	@Override
	protected IRepositoryRootGetter getRootGetter(ICoreSession session) {
		return new ArchimateRootGetter(session.getMetamodel());
	}

	@objid("b7266654-c3af-40d2-a697-6d00756b789c")
	@Override
	protected IModelFactoryProvider getModelFactoryProvider(ICoreSession session) {
		return (s) -> new ArchimateModelFactory(s);
	}

	@objid("384cce0e-c748-4d59-a6f2-f8192d658aae")
	@Override
	public <T> T createExtension(Class<T> service, ICoreSession session) {
		if (service == IMofRepositoryMigratorProvider.class) {
			return service.cast(new ArchimateMmMigrationProvider());
		}
		return super.createExtension(service, session);
	}

}

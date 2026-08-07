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
package org.modelio.archimate.metamodel.impl.mmextensions.migration;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.ArchimateMetamodel;
import org.modelio.archimate.metamodel.impl.mmextensions.migration.from_381.ArchimateMm103Migrator;
import org.modelio.archimate.metamodel.layers.strategy.behavior.ValueStream;
import org.modelio.vbasic.log.Log;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.model.spi.mm.IMofRepositoryMigrator;
import org.modelio.vcore.model.spi.mm.IMofRepositoryMigratorProvider;
import org.modelio.vcore.model.spi.mm.MetamodelChangeDescriptor;
import org.modelio.vcore.model.spi.mm.NoopMofRepositoryMigrator;
import org.modelio.vcore.smkernel.mapi.MetamodelVersionDescriptor;

/**
 * Archimate Metamodel migration provider
 *
 * @since 4.0.0
 */
@objid ("67d4e9da-2e54-4cb6-a44b-ec1598174f0b")
public class ArchimateMmMigrationProvider implements IMofRepositoryMigratorProvider {
    @objid ("a046296d-d192-43d5-9ee7-0ea687e928d8")
    @Override
    public IMofRepositoryMigrator getMigrator(MetamodelVersionDescriptor fromMetamodel, MetamodelVersionDescriptor targetMetamodel) {
        Version fromVersion = fromMetamodel.getVersion(ArchimateMetamodel.NAME);
        Version lastVersion = new Version(ArchimateMetamodel.VERSION);
        final Version V4_0 = new Version(1, 0, 4);

        if (fromVersion == null) {
            // metamodel absent, we are not involved
            return null;
        } else if (fromVersion.isNewerOrSameThan(lastVersion)) {
            // Same or Future version: no retro migration.
            return null;
        } else if (V4_0.isNewerThan(fromVersion)) {
            /*
             * Migrate to 1.0.4 (Modelio 4.0.0): # ValueStream new CMS nodes metaclasses
             */
            return new ArchimateMm103Migrator(
                    fromMetamodel,
                    fromMetamodel.copy()
                    .put(ArchimateMetamodel.NAME, V4_0))
                    .setMetamodelChanges(new MetamodelChangeDescriptor()
                            .addClass(ArchimateMetamodel.NAME, ValueStream.MNAME)
                            .newCmsNode(ArchimateMetamodel.NAME, ValueStream.MNAME));
        } else if (lastVersion.isNewerBuildOf(fromVersion)) {
            // Older but build compatible. fromVersion >= 1.0.4
            assert fromVersion.isNewerOrSameThan(V4_0);
            assert lastVersion.isNewerThan(V4_0);

            return new NoopMofRepositoryMigrator(fromMetamodel, fromMetamodel
                    .copy()
                    .put(ArchimateMetamodel.NAME, lastVersion));

        } else {
            // older: Not supported, a migrator is probably missing here
            Log.trace("No migrator to migrate from %s v%s to v%s ", ArchimateMetamodel.NAME, fromVersion, lastVersion);
            return null;
        }

    }

}

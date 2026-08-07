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
package org.modelio.vcore.model.spi.mm;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.vcore.smkernel.mapi.MetamodelVersionDescriptor;

/**
 * Participant in a MOF migration.
 *
 * @author cma
 * @since 3.6
 */
@objid ("207f421f-3b15-49cf-9246-2a10b8e07c77")
public interface IMofRepositoryMigratorProvider {
    /**
     * Tells how this migrator can transform the given metamodel.
     * <p>
     * The returned {@link IMofRepositoryMigrator#getTargetMetamodel()} should return a copy of the given {@link MetamodelVersionDescriptor}
     * with the modifications it can make, by replacing old versions by new ones, replacing
     * some by other ...
     * <p>
     * If no migrator is applicable it must return null.
     * <h2>Default implementation</h2>
     * The default implementation calls {@link #getMigrator(MetamodelVersionDescriptor, MetamodelVersionDescriptor)}, and
     * append migrators if the returned migrator has a {@link MetamodelChangeDescriptor} that tells that there are CMS node flags changes.
     *
     * @param fromMetamodel the given metamodel
     * @param targetMetamodel the target metamodel
     * @return the metamodel after this migrator would run.
     * @since 5.4.1-20240111 10/01/2024
     */
    @objid ("4db4859f-9830-4386-8f8e-ef3ce6060505")
    default MigrationStepGroup getMigrationStepGroup(MetamodelVersionDescriptor fromMetamodel, MetamodelVersionDescriptor targetMetamodel) {
        IMofRepositoryMigrator m = getMigrator(fromMetamodel, targetMetamodel);
        if (m == null)
            return null;

        // If there is a MetamodelChangeDescriptor that tells that there are CMS node flags changes,
        // add the needed migrators.
        MetamodelChangeDescriptor mmchanges = m.getMetamodelChanges();
        if (mmchanges == null || ( mmchanges.getAddedCmsNodes().isEmpty() && mmchanges.getRemovedCmsNodes().isEmpty()))
            return new MigrationStepGroup(m);

        MetamodelVersionDescriptor stepTarget = m.getTargetMetamodel();
        return new MigrationStepGroup(m)
                .addAll(CmsNodeChangeMofMigrators.create(stepTarget, stepTarget, mmchanges));

    }

    /**
     * Tells how this migrator can transform the given metamodel.
     * <p>
     * The returned {@link IMofRepositoryMigrator#getTargetMetamodel()} should return a copy of the given {@link MetamodelVersionDescriptor}
     * with the modifications it can make, by replacing old versions by new ones, replacing
     * some by other ...
     * <p>
     * If no migrator is applicable it must return null.
     * <p>
     * If you need to run several migrators , implement {@link #getMigrationStepGroup(MetamodelVersionDescriptor, MetamodelVersionDescriptor)} instead.
     *
     * @param fromMetamodel the given metamodel
     * @param targetMetamodel the target metamodel
     * @return the metamodel after this migrator would run.
     */
    @objid ("7a583e8e-c4cc-46ff-96be-bbe7c81d3a7a")
    IMofRepositoryMigrator getMigrator(MetamodelVersionDescriptor fromMetamodel, MetamodelVersionDescriptor targetMetamodel);

}

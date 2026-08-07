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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.vcore.smkernel.mapi.MetamodelVersionDescriptor;

/**
 * Groups a list of {@link IMofRepositoryMigrator} to execute to get from one metamodel version to another.
 *
 * @author cmarin
 * @since 5.4.1-202401102130
 */
@objid ("fa58949f-0318-48a1-a9e6-91107974d0c1")
public class MigrationStepGroup {
    @objid ("8b3db98c-b578-4390-806c-b345f2cc453e")
    private final List<IMofRepositoryMigrator> steps;

    @objid ("76c2679d-b956-4f6f-91bd-9324f3f5c466")
    public MigrationStepGroup(Collection<IMofRepositoryMigrator> chain) {
        this.steps = new ArrayList<>(chain);
    }

    @objid ("bb412d85-ca9c-4069-975e-11a387377334")
    public MigrationStepGroup(IMofRepositoryMigrator m) {
        this.steps = new ArrayList<>(3);
        this.steps.add(m);

    }

    /**
     * Tells whether the migration chain is a valid migration chain that does not modify the model.
     * <p>
     * This case usually means that source and target metamodel are compatible and only version metadatas need to be updated.
     *
     * @return true if the repository don't need to be modified.
     */
    @objid ("1d132c91-be51-4445-a356-64328bf66ab0")
    public boolean isNoop() {
        for (IMofRepositoryMigrator m : this.steps) {
            if (m.doesModifyRepository()) {
                return false;
            }
        }
        return true;
    }

    @objid ("4956c767-c373-4fbe-a4c2-89e40f656c43")
    public List<IMofRepositoryMigrator> getSteps() {
        return this.steps;
    }

    @objid ("41d210d5-5b87-4305-b15e-72bc2ce19f29")
    public MetamodelVersionDescriptor getTargetMetamodel() {
        if (this.steps.isEmpty())
            return null;
        return this.steps.get(this.steps.size()-1).getTargetMetamodel();
    }

    /**
     *
     * @param migrators the migrators to append to this group
     * @return this instance
     */
    @objid ("e0abdbac-fb84-46c3-bb73-722c4889755b")
    public MigrationStepGroup addAll(List<? extends IMofRepositoryMigrator> migrators) {
        this.steps.addAll(migrators);
        return this;
    }

    /**
     *
     * @param migrator the migrator to append to this group
     * @return this instance
     */
    @objid ("13e0d979-05ea-4071-8caa-a2f64fd556d8")
    public MigrationStepGroup add(IMofRepositoryMigrator migrator) {
        this.steps.add(migrator);
        return this;
    }

    @objid ("87c87f6f-7b4b-4967-9158-4ae668c610e2")
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("MigrationStepGroup [");
        if (this.steps != null) {
            builder.append(this.steps);
        }
        builder.append("]");
        return builder.toString();
    }

}

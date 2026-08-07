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
package org.modelio.archimate.metamodel.impl.mmextensions.migration.from_381;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.relationships.dependency.Influence;
import org.modelio.archimate.metamodel.relationships.dependency.InfluenceStrength;
import org.modelio.vbasic.progress.IModelioProgress;
import org.modelio.vcore.model.spi.mm.AbstractMofRepositoryMigrator;
import org.modelio.vcore.model.spi.mm.IMofSession;
import org.modelio.vcore.model.spi.mm.MofMigrationException;
import org.modelio.vcore.smkernel.mapi.MetaclassNotFoundException;
import org.modelio.vcore.smkernel.mapi.MetamodelVersionDescriptor;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.mof.MofSmObjectImpl;

/**
 * Migrate Archimate metamodel from 1.0.3 to 1.0.4 (eg From Modelio <= 3.8.1 to 4.0.0).
 */
@objid ("0cb7a763-63ee-4d53-bed6-35515d9591d2")
public class ArchimateMm103Migrator extends AbstractMofRepositoryMigrator {
    @objid ("18b3cee6-98fb-44f1-8239-0f258dbd647d")
    public ArchimateMm103Migrator(MetamodelVersionDescriptor fromMetamodel, MetamodelVersionDescriptor targetMetamodel) {
        super(fromMetamodel, targetMetamodel);
    }

    @objid ("e531bd07-d5bc-4db8-9aa5-046b20d444b6")
    @Override
    public void run(IModelioProgress monitor, IMofSession session) throws MofMigrationException {
        try {

            /**
             * MILDLYPOSITIVE and MILDLYNEGATIVE values of Strength did not exist.
             * Replacement by the nearest value
             */
            SmClass InfluenceMc = session.getMetaclass(Influence.MQNAME);
            for (MofSmObjectImpl influence : session.findByClass(InfluenceMc, true)) {
                String oldStrength = (String) influence.getAtt("Strength");

                String newStrenght = oldStrength;
                if("MILDLYPOSITIVE".equals(oldStrength)) {
                    newStrenght = InfluenceStrength.STRONGLYPOSITIVE_NAME;
                }else if("MILDLYNEGATIVE".equals(oldStrength)) {
                    newStrenght = InfluenceStrength.STRONGLYNEGATIVE_NAME;
                }

                influence.setAttVal("Strength", newStrenght);
            }

        } catch (MetaclassNotFoundException e) {
            throw new MofMigrationException(e.getLocalizedMessage(), e);
        }

    }

}

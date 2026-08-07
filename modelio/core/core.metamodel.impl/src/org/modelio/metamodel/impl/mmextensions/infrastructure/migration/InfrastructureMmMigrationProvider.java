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
package org.modelio.metamodel.impl.mmextensions.infrastructure.migration;

import java.io.IOException;
import java.io.InputStream;
import java.util.Comparator;
import java.util.stream.Stream;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.InfrastructureMetamodel;
import org.modelio.metamodel.impl.mmextensions.infrastructure.migration.from_36.InfrastructureMigratorFrom36;
import org.modelio.vbasic.files.FileUtils;
import org.modelio.vbasic.log.Log;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.model.spi.mm.IMofRepositoryMigrator;
import org.modelio.vcore.model.spi.mm.IMofRepositoryMigratorProvider;
import org.modelio.vcore.model.spi.mm.MofMigrationException;
import org.modelio.vcore.model.spi.mm.NoopMofRepositoryMigrator;
import org.modelio.vcore.model.spi.mm.NoopMofRepositoryModifyMigration;
import org.modelio.vcore.smkernel.mapi.MetamodelVersionDescriptor;
import org.modelio.vcore.smkernel.meta.descriptor.MetamodelDescriptor;
import org.modelio.vcore.smkernel.meta.descriptor.MetamodelDescriptorReader;

/**
 * Migration provider for the infrastructure metamodel (Analyst , Infrastructure and impact before 3.6).
 *
 * @author cma
 * @since 3.6
 */
@objid ("43ebc7c7-52b9-4143-bfcf-93349261851e")
public class InfrastructureMmMigrationProvider implements IMofRepositoryMigratorProvider {
    @objid ("89328fd7-22d8-4c2f-bda7-a2d3de0d57ed")
    @Override
    public IMofRepositoryMigrator getMigrator(MetamodelVersionDescriptor fromMetamodel, MetamodelVersionDescriptor toMetamodel) {
        /*
         * 2.0.00 : Modelio 3.6.x
         *    Initial version when metamodel fragments were split
         * 2.1.00 : Modelio 3.7 - 30/03/2017
         *    + AbstractResource ^ ModelElement
         *    + Resource ^AbstractResource
         *    # ExternDocument renamed Document, inherit from AbstractResource
         *    # ExternDocumentType renamed ResourceType
         *    # ExternDocument.Type : ExternDocumentType --> AbstractResource.Type : ResourceType
         *    # ExternDocument.MimeType --> AbstractResource.MimeType
         *    # ExternDocument.Path --> AbstractResource.storageInfo
         *    # ExternDocumentType.TypedDoc : ExternDocument --> ResourceType.TypedResource : AbstractResource
         *    # ModelElement.Document : ExternDocument --> Modelelement.Attached : AbstractResource
         *    # Stereotype.DefinedExternDocumentType : ExternDocumentType --> Stereotype.DefinedResourceType : ResourceType
         *    # MetaclassReference.DefinedExternDocumentType : ExternDocumentType --> MetaclassReference.DefinedResourceType : ResourceType
         *
         * 2.1.01 - Modelio Valkyrie 3.8
         *  + MethodologicalLink : methodological link
         *  + Stereotype.IsAbstract : boolean = false
         *
         * 2.1.02 - Modelio Valkyrie 3.8
         *  + GraphDiagram
         *
         * 2.1.03 - Modelio Valkyrie 3.8.1
         * + ExternElement
         * + AbstractDiagram.PreviewData
         *
         * 2.1.04 - Modelio 5.4.0
         *  + Add JsStructure Attribute to AbstractDiagram
         *    All diagrams must be opened and saved.
         */

        final Version lastInfraMmVersion = new Version(InfrastructureMetamodel.VERSION);
        final Version V3_6 = new Version(2,0,00);
        final Version V3_7 = new Version(2,1,00);
        final Version V5_4 = new Version(2,1,04);

        Version fromVersion = fromMetamodel.getVersion(InfrastructureMetamodel.NAME);

        // 1) General shortcut cases to test first
        if (fromVersion == null) {
            // standard metamodel absent, we are not involved
            return null;
        } else if (fromVersion.equals(lastInfraMmVersion)) {
            // nothing to do, we are not involved
            return null;
        } else if (fromVersion.isNewerThan(lastInfraMmVersion)) {
            // Future version: no retro migration at least for the moment
            return null;
        }

        // 2) Here is a test against the latest migration step target version.
        // Update the tested version when adding a migration step.
        if (fromVersion.isNewerThan(V5_4)) {
            if (lastInfraMmVersion.isNewerBuildOf(fromVersion)) {
                // Newer than latest migration but build compatible.
                return new NoopMofRepositoryMigrator(fromMetamodel, fromMetamodel
                        .copy()
                        .put(InfrastructureMetamodel.NAME, lastInfraMmVersion));
            } else {
                // Not supported, a migrator is probably missing on top of 3).
                // The metamodel version was incremented but you forgot to think about migration.

                Log.warning("No migrator to migrate from %s v%s to v%s ", InfrastructureMetamodel.NAME, fromVersion, lastInfraMmVersion);
                return null;
            }
        }

        // 3) From here the cases must be ordered by 'fromVersion' descending,
        // always testing for "fromVersion.isNewerOrSameThan(xxxx)" .
        if (fromVersion.isNewerOrSameThan(V3_7)) {
            // Migrate from 3.7 to 5.4.0 :
            // AbstractDiagram.JsStructure attribute must be populated for all diagrams.
            // All diagrams must be opened and saved to do this.
            // Add a dummy step that declares modifying the repository so that diagrams are
            // refreshed via DiagramMigrationContributor .
            return new NoopMofRepositoryModifyMigration(fromMetamodel, fromMetamodel
                    .copy()
                    .put(InfrastructureMetamodel.NAME, V5_4));
        } else if (fromVersion.isNewerOrSameThan(V3_6)) {
            // Migrate to 3.6
            return new InfrastructureMigratorFrom36(fromMetamodel, fromMetamodel
                    .copy()
                    .put(InfrastructureMetamodel.NAME, new Version(InfrastructureMetamodel.VERSION)));

        } else {
            // older: Not supported, a migrator is probably missing here
            Log.trace("No migrator to migrate from %s v%s to v%s ", InfrastructureMetamodel.NAME, fromVersion, lastInfraMmVersion);
            return null;
        }

    }

    @objid ("36991b97-d759-47da-bab3-52db83ee7343")
    public static MetamodelDescriptor loadMetamodel(MetamodelVersionDescriptor fromMetamodel) throws MofMigrationException {
        Version fromVersion = fromMetamodel.getVersion(InfrastructureMetamodel.NAME);

        // The version to load is the same or next version for which we have a descriptor file.
        Version toLoad =
                Stream.of("2.0.00")
                .map(s -> new Version(s))
                .sorted(Comparator.reverseOrder())
                .filter(v -> v.isOlderOrSameThan(fromVersion))
                .findFirst()
                .orElseThrow(() -> new MofMigrationException(String.format("No metamodel descriptor for version '%s'", fromVersion)));

        String path = "/migration/metamodel_"+toLoad.toString()+".xml";
        try (InputStream is = InfrastructureMmMigrationProvider.class.getResourceAsStream(path)) {
            return MetamodelDescriptorReader.readFrom(is, path);
        } catch (IOException e) {
            throw new MofMigrationException(FileUtils.getLocalizedMessage(e), e);
        }

    }

}

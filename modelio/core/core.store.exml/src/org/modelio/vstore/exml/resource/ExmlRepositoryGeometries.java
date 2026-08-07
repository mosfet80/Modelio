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
package org.modelio.vstore.exml.resource;

import java.io.IOException;
import java.util.Collection;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.vcore.smkernel.mapi.MMetamodel;
import org.modelio.vcore.smkernel.mapi.MRef;
import org.modelio.vstore.exml.common.RepositoryVersions;

/**
 * Central factory for {@link IExmlRepositoryGeometry} implementations.
 *
 * @since 6.0.1 28/06/2024
 */
@objid ("bd85dd2d-9b04-4611-92a3-341653495cd6")
public class ExmlRepositoryGeometries {
    @objid ("7933e460-273e-4b79-9469-5ddc897a4bf2")
    private static final ExmlRepositoryGeometry1 geometry1 = new ExmlRepositoryGeometry1();

    @objid ("3ab9f377-67a0-44b1-88b2-7817a2158398")
    private static final ExmlRepositoryGeometry2 geometry2 = new ExmlRepositoryGeometry2();

    @objid ("4f65333d-021f-450d-9015-b5af29b0d8da")
    private static final ExmlRepositoryGeometry3 geometry3 = new ExmlRepositoryGeometry3();

    /**
     *
     * @return the latest bleeding edge format.
     */
    @objid ("fd40cbaf-a677-4f1a-8c90-0d9d45f8f48d")
    public static IExmlRepositoryGeometry ofLatest() {
        return geometry3;
    }

    /**
     *
     * @return the latest stable format.
     */
    @objid ("0fdff3e9-fbf3-4398-a75f-72d5dd384548")
    public static IExmlRepositoryGeometry ofLatestStable() {
        return geometry3;
    }

    /**
     * Get the geometry matching the repository format version.
     *
     * @param repoFormat a repository format version
     * @return the matching geometry
     * @throws IOException if the format is unknown
     * @throws UnsupportedOperationException if the format is not yet implemented, and should be.
     */
    @objid ("b3af5a75-e99c-4f7f-8c7d-1dce6c041315")
    public static IExmlRepositoryGeometry ofFormat(int repoFormat) throws IOException, UnsupportedOperationException {
        switch (repoFormat) {
        case 0:
        case 1:
            return geometry1;
        case 2:
            return geometry2;
        case 3:
            return geometry3;
        default:
            if (repoFormat == RepositoryVersions.CURRENT_FORMAT) {
                // This is a BUG : please implement the missing format instantiation
                throw new UnsupportedOperationException(String.format("Repository format version '%d' not yet implemented. Last known format is %d .",repoFormat, RepositoryVersions.CURRENT_FORMAT));
            } else {
                // This Modelio is probably too old
                throw new IOException(String.format("Unsupported repository format version '%d'. Last known format is %d .",repoFormat, RepositoryVersions.CURRENT_FORMAT));
            }
        }
    }

    /**
     * Get an hybrid geometry for migration
     *
     * @param sourceRepoFormat the current format. Will be used as main format.
     * @param targetRepoFormat the format after migration. Will be used as fallback for some methods.
     * @return a migration geometry
     * @throws IOException if one of the format numbers is unknown
     * @throws UnsupportedOperationException if one the format is not yet implemented, and should be.
     */
    @objid ("b5660b01-408c-4744-857b-f730ac526c44")
    public static IExmlRepositoryGeometry forMigration(int sourceRepoFormat, int targetRepoFormat) throws IOException, UnsupportedOperationException {
        return new HybridExmlRepositoryGeometry(ofFormat(sourceRepoFormat), ofFormat(targetRepoFormat));
    }

    /**
     * Hybrid geometry to be used for migrations.
     */
    @objid ("82592933-0080-4b7e-b151-521eb48f603e")
    private static class HybridExmlRepositoryGeometry implements IExmlRepositoryGeometry {
        @objid ("469aef2e-0c8e-462c-88fe-f7c3801ca8b7")
        private final IExmlRepositoryGeometry main;

        @objid ("1d40ef49-a760-489c-898c-0a9237d276ac")
        private final IExmlRepositoryGeometry fallback;

        @objid ("8f472abc-d442-413b-8abe-d383cbfeb346")
        public HybridExmlRepositoryGeometry(IExmlRepositoryGeometry main, IExmlRepositoryGeometry fallback) {
            super();
            this.main = main;
            this.fallback = fallback;
        }

        @objid ("2cefca1e-a765-4297-9925-17e07e15d6b0")
        @Override
        public String getBlobKey(String relativePath) {
            return this.main.getBlobKey(relativePath);
        }

        @objid ("9e1995ce-5029-495b-933c-fd51056a81cc")
        @Override
        public String getBlobPath(String blobKey) {
            return this.main.getBlobPath(blobKey);
        }

        @objid ("74a53cb1-7f95-4d5a-9bcd-3eb44455961a")
        @Override
        public Collection<String> getInitialDirectories(MMetamodel metamodel) {
            return this.main.getInitialDirectories(metamodel);
        }

        @objid ("5df295bf-da82-4fd6-a5a7-fe3cdf5da953")
        @Override
        public String getLocalFileRelativePath(MRef ref) {
            return this.main.getLocalFileRelativePath(ref);
        }

        @objid ("85301d5d-e6bb-46f8-8388-f47b902fbb8b")
        @Override
        public String getMetamodelDescriptorPath() {
            return this.main.getMetamodelDescriptorPath();
        }

        @objid ("41f2d1c5-2063-492b-8847-01886782b505")
        @Override
        public int getModelDirectoryLevels() {
            return Math.max(this.main.getModelDirectoryLevels(), this.main.getModelDirectoryLevels());
        }

        @objid ("fd168fe0-4e36-4f28-9444-44a8ffa562bf")
        @Override
        public String getModelPath() {
            return this.main.getModelPath();
        }

        @objid ("425ff70a-2f54-44e0-baf7-e452e7362f5d")
        @Override
        public MRef getObRef(String relativePath) {
            MRef ret = this.main.getObRef(relativePath);
            if (ret != null)
                return ret;
            return this.fallback.getObRef(relativePath);
        }

        @objid ("13bbec1a-28cd-4a21-a521-1bf0cf187ab8")
        @Override
        public String getRelativePath(MRef ref) {
            return this.main.getRelativePath(ref);
        }

        @objid ("f28d188e-21ce-4456-8e75-af5355a50153")
        @Override
        public boolean isBlobPath(String relativePath) {
            return this.main.isBlobPath(relativePath) || this.fallback.isBlobPath(relativePath);
        }

        @objid ("415d257b-e564-4859-b9ae-eb5f2d329056")
        @Override
        public boolean isModelPath(String relativePath) {
            return this.main.isModelPath(relativePath) || this.fallback.isModelPath(relativePath);
        }

    }

}

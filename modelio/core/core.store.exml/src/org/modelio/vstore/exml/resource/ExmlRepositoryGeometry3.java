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

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.vcore.smkernel.mapi.MMetamodel;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Represents a local file system repository directory structure.
 * <p>
 * This implementation is for the format version 3 : files are distributed in a file system implementation of a hash table, like blobs.
 */
@objid ("f7ef9da5-f45b-4c38-b6de-413cccd7a2c0")
public class ExmlRepositoryGeometry3 implements IExmlRepositoryGeometry {
    /**
     * EXML files storage directory path relative to the project space path.
     */
    @objid ("1e3ae88d-cd7a-4ad1-8935-0e125eec883c")
    static final String MODEL_STORAGE_PATH = MODEL_DIRNAME;

    @objid ("bc98e1a0-b2fb-4d5d-8ea1-e7cd20ec7127")
    @Override
    public String getRelativePath(final MRef ref) {
        return MODEL_STORAGE_PATH+ "/" +  defaultHashDir(ref) + ref.uuid + "--" + ref.mc + EXT_EXML;
    }

    @objid ("d67a7755-77f0-4309-ba46-5918a2f1740f")
    @Override
    public String getLocalFileRelativePath(final MRef ref) {
        return MODEL_STORAGE_PATH+ "/" + defaultHashDir(ref)+ "/" + ref.uuid  + "--" + ref.mc + EXT_LOCAL_EXML;
    }

    @objid ("a1723061-71bc-4772-87b2-f0c068f5d217")
    @Override
    public MRef getObRef(String relativePath) {
        String fileName = GeometryUtils.getFileName(relativePath);

        int iSep = fileName.indexOf("--");
        if (iSep==-1)
            throw new IllegalArgumentException(relativePath);

        String uuid = fileName.substring(0, iSep);
        int lastIndexOf = fileName.lastIndexOf(EXT_EXML);
        if (lastIndexOf <  iSep)
            throw new IllegalArgumentException(relativePath);

        String mc = fileName.substring(iSep+2, lastIndexOf);
        return new MRef(mc,uuid);
    }

    /**
     * Tells whether a file is an EXML file that can be versioned.
     * <p>
     * The answer is based on the file extension.
     * Returns <i>false</i> if it is a {@link IExmlRepositoryGeometry#EXT_LOCAL_EXML ".local.exml"} file.
     *
     * @param relativePath a file path relative to the repository root.
     * @return <i>true</i> if it is an EXML file, else <i>false</i>.
     */
    @objid ("ed162d51-5294-4c4d-9b3e-6f96dba2f90a")
    @Override
    public boolean isModelPath(String relativePath) {
        if ((relativePath != null)
                && (relativePath.startsWith(MODEL_STORAGE_PATH))
                && (relativePath.endsWith(EXT_EXML))
                && (!relativePath.endsWith(EXT_LOCAL_EXML))) {
            try {
                getObRef(relativePath);
                return true;
            } catch (RuntimeException e) {
                return false;
            }
        }
        return false;
    }

    @objid ("9665163f-d19d-4e05-9a01-5aea09c93eec")
    @Override
    public String getModelPath() {
        return MODEL_DIRNAME;
    }

    @objid ("fb1b2724-8bfa-4db0-a8d8-5ae79e4528d2")
    @Override
    public String getBlobPath(String blobKey) {
        return BlobGeometry.getBlobPath(blobKey);
    }

    /**
     * In "fb1b2724-8bfa-4db0-a8d8-5ae79e4528d2", return "8b/fa/" .
     * <p>
     * This seems to be the best varying part of an UUID whatever its version.
     * See https://www.rfc-editor.org/rfc/rfc9562 far all UUID layouts.
     *
     * @param out the output string
     * @param uuid the uuid string to extract an hash from.
     */
    @objid ("f86bbbb2-ba5e-46a3-aa13-701ee3cc1045")
    private static String defaultHashDir(MRef ref) {
        StringBuilder out = new StringBuilder(2+1+2+1);
        splitsubString(out , ref.uuid, 9);
        return out.toString();
    }

    /**
     * Extract 4 hex digits from the input string and put them into 'out' as "12/34" .
     *
     * @param out the output buffer
     * @param uuid the string to parse
     * @param startAt the index in the string to start from
     */
    @objid ("1fecaca3-c17d-455a-8756-1c7c23afe310")
    private static void splitsubString(StringBuilder out, String uuid, int startAt) {
        int i = startAt;
        int iNext = startAt + 2;
        int len = startAt + 4; // the number of digits to extract.
        while (i < len && i<uuid.length()) {
            char c = uuid.charAt(i);
            if (c == '-') {
                // skip '-'
                i++;
                iNext++;
                len++;
            } else {
                out.append(c);
                i++;
                if (i == iNext) {
                    out.append('/');
                    iNext+=2;
                }
            }
        }
    }

    @objid ("0551cd57-2150-4442-8911-cead6f56c01f")
    private static void __hashUuid(StringBuilder out, UUID u) {
        switch (u.version()) {
        case 1:
            // time-based + MAC
            /*
                                     *  0                   1                   2                   3
                                     *  0 1 2 3|4 5 6 7|8 9 0 1|2 3 4 5|6 7 8 9|0 1 2 3|4 5 6 7|8 9 0 1|
                                     * +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
                                     * |                           time_low                            |
                                     * +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
                                     * |           time_mid            |  ver  |       time_high       |
                                     * +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
                                     * |var|         clock_seq         |             node              |
                                     * +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
                                     * |                              node                             |
                                     * +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
                                     */
            splitsubString(out, u.toString(), 8);
            return;
        case 2: // DCE Security UUIDs
        case 3: // MD5
        case 4: // random
        case 5 : // SHA-1
            splitsubString(out, u.toString(), 0);
            return;
        case 6 :
            /*
                                     *  Field-compatible version of UUIDv1 (Section 5.1), reordered for improved DB locality.
                                     *
                                     *  0                   1                   2                   3
                                     *  0 1 2 3|4 5 6 7|8 9 0 1|2 3 4 5|6 7 8 9|0 1 2 3|4 5 6 7|8 9 0 1|
                                     * +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
                                     * |                           time_high                           |
                                     * +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-^-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
                                     * |           time_mid            |  ver  |       time_low        |
                                     * +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
                                     * |var|         clock_seq         |             node              |
                                     * +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
                                     * |                              node                             |
                                     * +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
                                     */
        case 7 :
            /*
                                     * Unix Epoch timestamp source 48 bits + 74 random bits
                                     *
                                     *  0                   1                   2                   3
                                     *  0 1 2 3|4 5 6 7|8 9 0 1|2 3 4 5|6 7 8 9|0 1 2 3|4 5 6 7|8 9 0 1|
                                     * +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
                                     * |                           unix_ts_ms                          |
                                     * +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-^-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
                                     * |          unix_ts_ms           |  ver  |       rand_a          |
                                     * +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
                                     * |var|                        rand_b                             |
                                     * +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
                                     * |                            rand_b                             |
                                     * +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
                                     */
            splitsubString(out, u.toString(), 8);
            return;
        }
    }

    @objid ("7134b6eb-1c00-4358-bf73-49f8290914b1")
    @Override
    public String getBlobKey(String relativePath) {
        return BlobGeometry.getBlobKey(relativePath);
    }

    @objid ("93143c00-b18b-4698-afcb-a0452187d23b")
    @Override
    public boolean isBlobPath(String relativePath) {
        return relativePath.startsWith(BLOBS_DIRNAME)
                                && relativePath.endsWith(EXT_BLOB);
    }

    @objid ("1ba5b503-cf00-42ad-bff6-d53f79eb101f")
    @Override
    public Collection<String> getInitialDirectories(MMetamodel metamodel) {
        Collection<String> ret = new ArrayList<>(600);

        // Administration directory
        ret.add(ADMIN_DIRNAME);

        // Add "model" directory
        ret.add(MODEL_DIRNAME);

        // Add "blobs/*" directories
        ret.add(IExmlRepositoryGeometry.BLOBS_DIRNAME);

        for (int i=0; i<256; i++) {
            ret.add(String.format("%s/%02x",IExmlRepositoryGeometry.BLOBS_DIRNAME, i));
            ret.add(String.format("%s/%02x",IExmlRepositoryGeometry.MODEL_DIRNAME, i));
        }
        return ret;
    }

    @objid ("f630b12a-a6c3-4f2d-8e8d-00ae00736834")
    @Override
    public String getMetamodelDescriptorPath() {
        return MM_DESCRIPTOR_PATH;
    }

    @objid ("161288d8-b6bb-4eb4-9b6d-a3ecc644bcfc")
    @Override
    public int getModelDirectoryLevels() {
        return 2;
    }

}

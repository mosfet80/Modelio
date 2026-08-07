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
package org.modelio.archimate.exchange.service.utils;

import java.util.UUID;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.uml.infrastructure.properties.PropertyTableDefinition;

@objid ("d7391ed4-011a-49c2-a10c-e5bf94ce446c")
public class IDUtils {
    @objid ("a4ebf24a-d340-4724-b72f-1f5250637d8c")
    private static final String MODELIOID_PREFIX = "m-";

    @objid ("f1fc155c-8eee-4e1c-90e2-834a46d39ca4")
    private static final String REFID_PREFIX = "ref-";

    @objid ("89e06493-4cfb-4ccc-9de0-51a3297b6731")
    private static final String PROPERTY_SEPARATOR = "-propname-";

    @objid ("fc271b0a-6508-4178-8a59-5a746d5d11c7")
    public static String exportId(String id) {
        try {
            UUID.fromString(id);
            return MODELIOID_PREFIX + id;
        } catch (@SuppressWarnings ("unused") IllegalArgumentException e) {
            // the id is not a valid UID, return it as is
        }
        return id;
    }

    @objid ("8d6284b9-12fd-4938-bf9f-5be39eeb558d")
    public static String exportRefId(String id) {
        try {
            UUID.fromString(id);
            return REFID_PREFIX + id;
        } catch (@SuppressWarnings ("unused") IllegalArgumentException e) {
            // the id is not a valid UID, return it as is
        }
        return id;
    }

    @objid ("13e8e5e2-226a-4776-a981-0cec856fb561")
    public static String importId(String id) {
        if (id.startsWith(IDUtils.MODELIOID_PREFIX)) {
            try {
                UUID.fromString(id.substring(2, id.length()));
                return id.substring(2, id.length());
            } catch (@SuppressWarnings ("unused") IllegalArgumentException e) {
                // the second part of the id is not a valid UID, return it as is
            }
        }
        return id;
    }

    @objid ("e44cde0d-4700-428a-b801-5bc6829e9295")
    public static String exportId(PropertyTableDefinition propertyTableDefinition, String propName) {
        return MODELIOID_PREFIX + propertyTableDefinition.getUuid() + PROPERTY_SEPARATOR + propName;
    }

    @objid ("4e9eb7bf-4580-42fe-aa8a-f7d77f30020b")
    public static boolean isModelioProp(String id) {
        return (id.startsWith(MODELIOID_PREFIX)) && (id.contains(PROPERTY_SEPARATOR));
    }

    @objid ("af44e7c9-93cf-4eb9-88d5-d0211ff48dec")
    public static String getTableId(String id) {
        if (isModelioProp(id)) {
            return id.split(PROPERTY_SEPARATOR)[0].replaceFirst(MODELIOID_PREFIX, "");
        }else {
            return id;
        }

    }

    @objid ("b130e8bc-6708-4ee2-82a1-1fdfa809b0f7")
    public static String getPropName(String id) {
        if (isModelioProp(id)) {
            return id.split(PROPERTY_SEPARATOR)[1];
        }else {
            return id;
        }

    }

}

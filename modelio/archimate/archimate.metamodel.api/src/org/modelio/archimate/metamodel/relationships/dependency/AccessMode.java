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
package org.modelio.archimate.metamodel.relationships.dependency;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

/**
 * AccessMode vnull
 *
 *
 * <p>Determines where the Access relationship arrowheads appear.&nbsp;</p><p>The graphic notation&nbsp;will point in the opposite direction of the metamodel direction to&nbsp;denote &#39;read&#39; access, and in both directions to denote read-write access.</p><p>&nbsp;</p>
 *
 *
 */
@objid ("a3e06b9b-e711-4126-9a59-ae1744c8580e")
public enum AccessMode {
    @objid ("25f6b81f-0ada-4542-bc03-4c93ee838db8")
    UNDEFINED(0, "UNDEFINED", "UNDEFINED"),
    @objid ("d98cf036-a1cb-4377-bedf-9c98bfebc954")
    READ(1, "READ", "READ"),
    @objid ("f4bf1057-153c-4ba9-a2da-2e4cdb50d54e")
    WRITE(2, "WRITE", "WRITE"),
    @objid ("17838feb-d5a4-4021-bf09-69eaacb56ce2")
    READWRITE(3, "READWRITE", "READWRITE");

public static final int UNDEFINED_VALUE = 0;
    public static final int READ_VALUE = 1;
    public static final int WRITE_VALUE = 2;
    public static final int READWRITE_VALUE = 3;
    private static final AccessMode[] VALUES_ARRAY =
    new AccessMode[] {
    UNDEFINED,
    READ,
    WRITE,
    READWRITE,
    };
    public static final List<AccessMode> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));
    public static AccessMode get(String literal) {
      for (int i = 0; i < VALUES_ARRAY.length; ++i) {
        AccessMode result = VALUES_ARRAY[i];
        if (result.toString().equals(literal)) {
           return result;
        }
      }
      return null;
    }
    public static AccessMode getByName(String name) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
    AccessMode result = VALUES_ARRAY[i];
    if (result.getName().equals(name)) {
    return result;
    }
    }
    return null;
    }
    public static AccessMode get(int value) {
        switch (value) {
            case UNDEFINED_VALUE: return UNDEFINED;
            case READ_VALUE: return READ;
            case WRITE_VALUE: return WRITE;
            case READWRITE_VALUE: return READWRITE;
        }
        return null;
    }
    private final int value;
    private final String name;
    private final String literal;
    private AccessMode(int value, String name, String literal) {
      this.value = value;
      this.name = name;
      this.literal = literal;
    }
    public int getValue() {
       return value;
    }
     public String getName() {
        return name;
    }
    public String getLiteral() {
      return literal;
    }
     @Override
    public String toString() {
       return literal;
    }

}

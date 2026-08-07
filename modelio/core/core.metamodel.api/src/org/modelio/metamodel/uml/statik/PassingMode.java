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
package org.modelio.metamodel.uml.statik;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

/**
 * PassingMode v0.0.9054
 *
 *
 * null
 *
 */
@objid ("005a729c-91e0-1f74-804b-001ec947cd2a")
public enum PassingMode {
    @objid ("2811c97a-7619-4521-a75d-dde4cf400441")
    IN(0, "In", "In"),
    @objid ("dfc5c641-2d06-4c78-bc3a-b4d78ee6554c")
    OUT(1, "Out", "Out"),
    @objid ("12527776-16f6-4266-aeaa-04d0b0eb3f58")
    INOUT(2, "Inout", "Inout");

public static final int IN_VALUE = 0;
    public static final int OUT_VALUE = 1;
    public static final int INOUT_VALUE = 2;
    private static final PassingMode[] VALUES_ARRAY =
    new PassingMode[] {
    IN,
    OUT,
    INOUT,
    };
    public static final List<PassingMode> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));
    public static PassingMode get(String literal) {
      for (int i = 0; i < VALUES_ARRAY.length; ++i) {
        PassingMode result = VALUES_ARRAY[i];
        if (result.toString().equals(literal)) {
           return result;
        }
      }
      return null;
    }
    public static PassingMode getByName(String name) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
    PassingMode result = VALUES_ARRAY[i];
    if (result.getName().equals(name)) {
    return result;
    }
    }
    return null;
    }
    public static PassingMode get(int value) {
        switch (value) {
            case IN_VALUE: return IN;
            case OUT_VALUE: return OUT;
            case INOUT_VALUE: return INOUT;
        }
        return null;
    }
    private final int value;
    private final String name;
    private final String literal;
    private PassingMode(int value, String name, String literal) {
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

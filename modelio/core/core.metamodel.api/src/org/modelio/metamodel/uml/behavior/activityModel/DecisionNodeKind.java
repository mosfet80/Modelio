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
package org.modelio.metamodel.uml.behavior.activityModel;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

/**
 * DecisionNodeKind v0.0.9054
 *
 *
 * null
 *
 */
@objid ("007ee2a8-91e0-1f74-804b-001ec947cd2a")
public enum DecisionNodeKind {
    @objid ("40baeb20-a6cf-421f-a3f0-a547d7491ab6")
    COMPLEXDECISION(0, "ComplexDecision", "ComplexDecision"),
    @objid ("16e10c2f-80d9-4e7c-a997-1ca92745ebd0")
    EXCLUSIVEDECISION(1, "ExclusiveDecision", "ExclusiveDecision"),
    @objid ("3898a9fa-acf1-45d9-8aff-a52894895e94")
    INCLUSIVEDECISION(2, "InclusiveDecision", "InclusiveDecision"),
    @objid ("597bf996-026e-4f04-9033-82f36a420c3e")
    EVENTBASEDDECISION(3, "EventBasedDecision", "EventBasedDecision");

public static final int COMPLEXDECISION_VALUE = 0;
    public static final int EXCLUSIVEDECISION_VALUE = 1;
    public static final int INCLUSIVEDECISION_VALUE = 2;
    public static final int EVENTBASEDDECISION_VALUE = 3;
    private static final DecisionNodeKind[] VALUES_ARRAY =
    new DecisionNodeKind[] {
    COMPLEXDECISION,
    EXCLUSIVEDECISION,
    INCLUSIVEDECISION,
    EVENTBASEDDECISION,
    };
    public static final List<DecisionNodeKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));
    public static DecisionNodeKind get(String literal) {
      for (int i = 0; i < VALUES_ARRAY.length; ++i) {
        DecisionNodeKind result = VALUES_ARRAY[i];
        if (result.toString().equals(literal)) {
           return result;
        }
      }
      return null;
    }
    public static DecisionNodeKind getByName(String name) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
    DecisionNodeKind result = VALUES_ARRAY[i];
    if (result.getName().equals(name)) {
    return result;
    }
    }
    return null;
    }
    public static DecisionNodeKind get(int value) {
        switch (value) {
            case COMPLEXDECISION_VALUE: return COMPLEXDECISION;
            case EXCLUSIVEDECISION_VALUE: return EXCLUSIVEDECISION;
            case INCLUSIVEDECISION_VALUE: return INCLUSIVEDECISION;
            case EVENTBASEDDECISION_VALUE: return EVENTBASEDDECISION;
        }
        return null;
    }
    private final int value;
    private final String name;
    private final String literal;
    private DecisionNodeKind(int value, String name, String literal) {
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

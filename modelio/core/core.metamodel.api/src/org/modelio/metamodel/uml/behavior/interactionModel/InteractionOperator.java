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
package org.modelio.metamodel.uml.behavior.interactionModel;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

/**
 * InteractionOperator v0.0.9054
 *
 *
 * null
 *
 */
@objid ("00964254-91e0-1f74-804b-001ec947cd2a")
public enum InteractionOperator {
    @objid ("4e9be41d-832a-4bb5-8f88-75b2fc760115")
    SEQOP(0, "SeqOp", "SeqOp"),
    @objid ("2ef0534d-0326-4013-b11e-2e40b178e801")
    ALTOP(1, "AltOp", "AltOp"),
    @objid ("8a4bb6bd-4977-4c9a-9981-20f924522888")
    OPTOP(2, "OptOp", "OptOp"),
    @objid ("d78baddc-cd9b-4edf-9bea-1e8444c6dda0")
    BREAKOP(3, "BreakOp", "BreakOp"),
    @objid ("cda41601-5227-4834-aabb-fde7493032ec")
    PAROP(4, "ParOp", "ParOp"),
    @objid ("d2d6fcb8-663d-459c-9815-9ef6a57a0304")
    STRICTOP(5, "StrictOp", "StrictOp"),
    @objid ("49c21c93-0868-49d2-a397-54eb246aa645")
    LOOPOP(6, "LoopOp", "LoopOp"),
    @objid ("3c71b55b-3c3c-400d-9640-203e0e927b85")
    CRITICALOP(7, "CriticalOp", "CriticalOp"),
    @objid ("48df53c8-47d7-47d0-b926-2503004b76fa")
    NEGOP(8, "NegOp", "NegOp"),
    @objid ("ccf3253b-3477-4100-a638-ba1efa70db97")
    ASSERTOP(9, "AssertOp", "AssertOp"),
    @objid ("f64fb77d-852c-47c6-977a-e43e579e5fd6")
    IGNOREOP(10, "IgnoreOp", "IgnoreOp"),
    @objid ("2789f377-ce02-4732-9668-afb77a16c63c")
    CONSIDEROP(11, "ConsiderOp", "ConsiderOp");

public static final int SEQOP_VALUE = 0;
    public static final int ALTOP_VALUE = 1;
    public static final int OPTOP_VALUE = 2;
    public static final int BREAKOP_VALUE = 3;
    public static final int PAROP_VALUE = 4;
    public static final int STRICTOP_VALUE = 5;
    public static final int LOOPOP_VALUE = 6;
    public static final int CRITICALOP_VALUE = 7;
    public static final int NEGOP_VALUE = 8;
    public static final int ASSERTOP_VALUE = 9;
    public static final int IGNOREOP_VALUE = 10;
    public static final int CONSIDEROP_VALUE = 11;
    private static final InteractionOperator[] VALUES_ARRAY =
    new InteractionOperator[] {
    SEQOP,
    ALTOP,
    OPTOP,
    BREAKOP,
    PAROP,
    STRICTOP,
    LOOPOP,
    CRITICALOP,
    NEGOP,
    ASSERTOP,
    IGNOREOP,
    CONSIDEROP,
    };
    public static final List<InteractionOperator> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));
    public static InteractionOperator get(String literal) {
      for (int i = 0; i < VALUES_ARRAY.length; ++i) {
        InteractionOperator result = VALUES_ARRAY[i];
        if (result.toString().equals(literal)) {
           return result;
        }
      }
      return null;
    }
    public static InteractionOperator getByName(String name) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
    InteractionOperator result = VALUES_ARRAY[i];
    if (result.getName().equals(name)) {
    return result;
    }
    }
    return null;
    }
    public static InteractionOperator get(int value) {
        switch (value) {
            case SEQOP_VALUE: return SEQOP;
            case ALTOP_VALUE: return ALTOP;
            case OPTOP_VALUE: return OPTOP;
            case BREAKOP_VALUE: return BREAKOP;
            case PAROP_VALUE: return PAROP;
            case STRICTOP_VALUE: return STRICTOP;
            case LOOPOP_VALUE: return LOOPOP;
            case CRITICALOP_VALUE: return CRITICALOP;
            case NEGOP_VALUE: return NEGOP;
            case ASSERTOP_VALUE: return ASSERTOP;
            case IGNOREOP_VALUE: return IGNOREOP;
            case CONSIDEROP_VALUE: return CONSIDEROP;
        }
        return null;
    }
    private final int value;
    private final String name;
    private final String literal;
    private InteractionOperator(int value, String name, String literal) {
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

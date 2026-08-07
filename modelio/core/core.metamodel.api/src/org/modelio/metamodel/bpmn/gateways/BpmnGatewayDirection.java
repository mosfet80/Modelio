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
package org.modelio.metamodel.bpmn.gateways;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

/**
 * BpmnGatewayDirection v0.0.9054
 *
 *
 * null
 *
 */
@objid ("00654c58-91e1-1f74-804b-001ec947cd2a")
public enum BpmnGatewayDirection {
    @objid ("0fa7b04d-683e-4c3c-8688-e3798224bc8a")
    UNSPECIFIEDDIRECTION(0, "UnspecifiedDirection", "UnspecifiedDirection"),
    @objid ("5946677c-12cf-4237-b035-721b2628fac0")
    CONVERGINGDIRECTION(1, "ConvergingDirection", "ConvergingDirection"),
    @objid ("3df7792d-8526-464e-a2f4-bbf3cba91979")
    DIVERGINGDIRECTION(2, "DivergingDirection", "DivergingDirection"),
    @objid ("25f3548a-ed1c-48da-9272-1da84866ca8a")
    MIXEDDIRECTION(3, "MixedDirection", "MixedDirection");

public static final int UNSPECIFIEDDIRECTION_VALUE = 0;
    public static final int CONVERGINGDIRECTION_VALUE = 1;
    public static final int DIVERGINGDIRECTION_VALUE = 2;
    public static final int MIXEDDIRECTION_VALUE = 3;
    private static final BpmnGatewayDirection[] VALUES_ARRAY =
    new BpmnGatewayDirection[] {
    UNSPECIFIEDDIRECTION,
    CONVERGINGDIRECTION,
    DIVERGINGDIRECTION,
    MIXEDDIRECTION,
    };
    public static final List<BpmnGatewayDirection> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));
    public static BpmnGatewayDirection get(String literal) {
      for (int i = 0; i < VALUES_ARRAY.length; ++i) {
        BpmnGatewayDirection result = VALUES_ARRAY[i];
        if (result.toString().equals(literal)) {
           return result;
        }
      }
      return null;
    }
    public static BpmnGatewayDirection getByName(String name) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
    BpmnGatewayDirection result = VALUES_ARRAY[i];
    if (result.getName().equals(name)) {
    return result;
    }
    }
    return null;
    }
    public static BpmnGatewayDirection get(int value) {
        switch (value) {
            case UNSPECIFIEDDIRECTION_VALUE: return UNSPECIFIEDDIRECTION;
            case CONVERGINGDIRECTION_VALUE: return CONVERGINGDIRECTION;
            case DIVERGINGDIRECTION_VALUE: return DIVERGINGDIRECTION;
            case MIXEDDIRECTION_VALUE: return MIXEDDIRECTION;
        }
        return null;
    }
    private final int value;
    private final String name;
    private final String literal;
    private BpmnGatewayDirection(int value, String name, String literal) {
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

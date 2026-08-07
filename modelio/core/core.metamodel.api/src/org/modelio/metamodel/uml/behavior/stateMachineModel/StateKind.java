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
package org.modelio.metamodel.uml.behavior.stateMachineModel;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

/**
 * StateKind v0.0.9054
 *
 *
 * null
 *
 */
@objid ("000d61fa-91e1-1f74-804b-001ec947cd2a")
public enum StateKind {
    @objid ("dc6c7cf5-3e2c-4009-b34d-ad7e16490082")
    INITIALSTATE(0, "InitialState", "InitialState"),
    @objid ("eaae16dc-358d-4c71-b357-9772a5545fa8")
    DEEPHISTORYSTATE(1, "DeepHistoryState", "DeepHistoryState"),
    @objid ("b5c30909-382e-49f0-a56d-dd40e636d170")
    SHALLOWHISTORYSTATE(2, "ShallowHistoryState", "ShallowHistoryState"),
    @objid ("8d197568-7805-497b-9573-0ac7197574d2")
    JOINSTATE(3, "JoinState", "JoinState"),
    @objid ("51fefed4-cdc7-4916-86ef-1bc442bdf44f")
    FORKSTATE(4, "ForkState", "ForkState"),
    @objid ("4f40c8c5-5d89-4713-b912-ecbfb719732a")
    BRANCHSTATE(5, "BranchState", "BranchState"),
    @objid ("4ec064ef-4719-4a9d-b488-a5aa468b1b19")
    OLDFINALSTATE(6, "OldFinalState", "OldFinalState"),
    @objid ("9dcec546-ac60-4502-8708-0ba8ba50fa76")
    SIGNALRECEIPTSTATE(7, "SignalReceiptState", "SignalReceiptState"),
    @objid ("05247222-b3cc-453d-8dd2-e0dca5c51c64")
    SIGNALSENDINGSTATE(8, "SignalSendingState", "SignalSendingState"),
    @objid ("c04e7ecf-9dbf-4d0f-a6da-46f874d50c79")
    SYNCHRONIZATIONSTATE(9, "SynchronizationState", "SynchronizationState");

public static final int INITIALSTATE_VALUE = 0;
    public static final int DEEPHISTORYSTATE_VALUE = 1;
    public static final int SHALLOWHISTORYSTATE_VALUE = 2;
    public static final int JOINSTATE_VALUE = 3;
    public static final int FORKSTATE_VALUE = 4;
    public static final int BRANCHSTATE_VALUE = 5;
    public static final int OLDFINALSTATE_VALUE = 6;
    public static final int SIGNALRECEIPTSTATE_VALUE = 7;
    public static final int SIGNALSENDINGSTATE_VALUE = 8;
    public static final int SYNCHRONIZATIONSTATE_VALUE = 9;
    private static final StateKind[] VALUES_ARRAY =
    new StateKind[] {
    INITIALSTATE,
    DEEPHISTORYSTATE,
    SHALLOWHISTORYSTATE,
    JOINSTATE,
    FORKSTATE,
    BRANCHSTATE,
    OLDFINALSTATE,
    SIGNALRECEIPTSTATE,
    SIGNALSENDINGSTATE,
    SYNCHRONIZATIONSTATE,
    };
    public static final List<StateKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));
    public static StateKind get(String literal) {
      for (int i = 0; i < VALUES_ARRAY.length; ++i) {
        StateKind result = VALUES_ARRAY[i];
        if (result.toString().equals(literal)) {
           return result;
        }
      }
      return null;
    }
    public static StateKind getByName(String name) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
    StateKind result = VALUES_ARRAY[i];
    if (result.getName().equals(name)) {
    return result;
    }
    }
    return null;
    }
    public static StateKind get(int value) {
        switch (value) {
            case INITIALSTATE_VALUE: return INITIALSTATE;
            case DEEPHISTORYSTATE_VALUE: return DEEPHISTORYSTATE;
            case SHALLOWHISTORYSTATE_VALUE: return SHALLOWHISTORYSTATE;
            case JOINSTATE_VALUE: return JOINSTATE;
            case FORKSTATE_VALUE: return FORKSTATE;
            case BRANCHSTATE_VALUE: return BRANCHSTATE;
            case OLDFINALSTATE_VALUE: return OLDFINALSTATE;
            case SIGNALRECEIPTSTATE_VALUE: return SIGNALRECEIPTSTATE;
            case SIGNALSENDINGSTATE_VALUE: return SIGNALSENDINGSTATE;
            case SYNCHRONIZATIONSTATE_VALUE: return SYNCHRONIZATIONSTATE;
        }
        return null;
    }
    private final int value;
    private final String name;
    private final String literal;
    private StateKind(int value, String name, String literal) {
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

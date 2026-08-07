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
/* WARNING: GENERATED FILE -  DO NOT EDIT
     Metamodel: Standard, version 2.3.00, by Modeliosoft
     Generator version: 3.14.00
     Generated on: Aug 7, 2024
*/
package org.modelio.metamodel.uml.behavior.activityModel;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;

/**
 * InputPin v0.0.9054
 *
 *
 * An input pin is a pin that holds input values to be consumed by an action.
 *
 * An action cannot start execution if an input pin has fewer values than the lower multiplicity. The upper multiplicity determines how many values are consumed by a single execution of the action.
 *
 */
@objid ("003503ea-c4bf-1fd8-97fe-001ec947cd2a")
public interface InputPin extends Pin {
    /**
     * The metaclass simple name.
     */
    @objid ("a3cc76d5-d74b-4691-a8d4-d3e30af57931")
    public static final String MNAME = "InputPin";

    /**
     * The metaclass qualified name.
     */
    @objid ("78e8ebbc-fefa-4c41-b2fc-e9d971b998f5")
    public static final String MQNAME = "Standard.InputPin";

    /**
     * Getter for attribute 'InputPin.IsSelf'
     *
     * Metamodel description:
     * <i>Modelio extension: expresses that the pin represents the target object on which the action is executed.</i>
     */
    @objid ("fcdc526b-f720-40f9-a9d8-5a28dcdf5b22")
    boolean isIsSelf();

    /**
     * Setter for attribute 'InputPin.IsSelf'
     *
     * Metamodel description:
     * <i>Modelio extension: expresses that the pin represents the target object on which the action is executed.</i>
     */
    @objid ("c1156497-4c28-4363-8360-363fd3fcd60e")
    void setIsSelf(boolean value);

    /**
     * Getter for relation 'InputPin->Handler'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("0f871c66-a491-47b8-bdd8-c191e01b8297")
    EList<ExceptionHandler> getHandler();

    /**
     * Filtered Getter for relation 'InputPin->Handler'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("8210d4fc-1700-4c22-957c-854094de66e7")
    <T extends ExceptionHandler> List<T> getHandler(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'InputPin->Inputing'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("4825a435-4b1d-4411-be0c-c6458bd63673")
    ActivityAction getInputing();

    /**
     * Setter for relation 'InputPin->Inputing'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("7e13d199-fb78-4ab0-bea9-169f9d0085ca")
    void setInputing(ActivityAction value);

}

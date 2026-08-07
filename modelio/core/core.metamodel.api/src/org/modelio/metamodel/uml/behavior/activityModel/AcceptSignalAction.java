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
import org.modelio.metamodel.uml.behavior.commonBehaviors.Signal;

/**
 * AcceptSignalAction v0.0.9054
 *
 *
 * AcceptSignalAction is an accept event action representing the receipt of an asynchronous signal.
 *
 */
@objid ("00250f30-c4bf-1fd8-97fe-001ec947cd2a")
public interface AcceptSignalAction extends ActivityAction {
    /**
     * The metaclass simple name.
     */
    @objid ("a0d2cc9c-1e09-421e-a5cd-ea3ba522bc31")
    public static final String MNAME = "AcceptSignalAction";

    /**
     * The metaclass qualified name.
     */
    @objid ("1c6e55fb-e4da-47eb-b925-08a07c04a093")
    public static final String MQNAME = "Standard.AcceptSignalAction";

    /**
     * Getter for relation 'AcceptSignalAction->Accepted'
     *
     * Metamodel description:
     * <i>The type of signal accepted.</i>
     */
    @objid ("6aa633c2-5458-46b3-bf81-f4045337bfa8")
    EList<Signal> getAccepted();

    /**
     * Filtered Getter for relation 'AcceptSignalAction->Accepted'
     *
     * Metamodel description:
     * <i>The type of signal accepted.</i>
     */
    @objid ("9ce2c90a-5285-492b-9c9b-afa15b6fdf48")
    <T extends Signal> List<T> getAccepted(java.lang.Class<T> filterClass);

}

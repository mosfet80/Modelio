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
import org.modelio.metamodel.uml.infrastructure.UmlModelElement;
import org.modelio.metamodel.uml.statik.GeneralClass;

/**
 * ExceptionHandler v0.0.9054
 *
 *
 * null
 *
 */
@objid ("00307956-c4bf-1fd8-97fe-001ec947cd2a")
public interface ExceptionHandler extends UmlModelElement {
    /**
     * The metaclass simple name.
     */
    @objid ("94750920-0334-4f7e-a983-cc323bc4848c")
    public static final String MNAME = "ExceptionHandler";

    /**
     * The metaclass qualified name.
     */
    @objid ("80e4242d-b886-4111-8faa-eca8b3a4e29d")
    public static final String MQNAME = "Standard.ExceptionHandler";

    /**
     * Getter for attribute 'ExceptionHandler.Guard'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("c652812b-d665-4a0c-99f8-5ae0b9bc3365")
    String getGuard();

    /**
     * Setter for attribute 'ExceptionHandler.Guard'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("e0fa1eeb-0bc9-45f6-9b94-bfbcc3ecd66d")
    void setGuard(String value);

    /**
     * Getter for attribute 'ExceptionHandler.Weight'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("e9eb3718-4c78-41d2-a98d-e3800660e5e1")
    String getWeight();

    /**
     * Setter for attribute 'ExceptionHandler.Weight'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("9276a943-913d-442c-84ca-acaca45f9f0c")
    void setWeight(String value);

    /**
     * Getter for relation 'ExceptionHandler->ProtectedNode'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("e11bce4e-803d-4204-9296-660ef34c3148")
    ActivityAction getProtectedNode();

    /**
     * Setter for relation 'ExceptionHandler->ProtectedNode'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("70ec40c0-6247-40ca-8bd7-756eaab10fdb")
    void setProtectedNode(ActivityAction value);

    /**
     * Getter for relation 'ExceptionHandler->ExceptionInput'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("3f44c344-4d1e-4a12-a24b-417a026ef5c9")
    InputPin getExceptionInput();

    /**
     * Setter for relation 'ExceptionHandler->ExceptionInput'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("1fcdb3c2-672b-49e2-a922-2dda0b1eda82")
    void setExceptionInput(InputPin value);

    /**
     * Getter for relation 'ExceptionHandler->ExceptionType'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("aaa3fe1e-1027-43ba-8797-e50e3b687327")
    EList<GeneralClass> getExceptionType();

    /**
     * Filtered Getter for relation 'ExceptionHandler->ExceptionType'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("ff99b79c-377f-4a22-8ae4-70eb2b381602")
    <T extends GeneralClass> List<T> getExceptionType(java.lang.Class<T> filterClass);

}

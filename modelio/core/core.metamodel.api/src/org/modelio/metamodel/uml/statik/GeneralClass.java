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
package org.modelio.metamodel.uml.statik;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.uml.behavior.activityModel.ExceptionHandler;
import org.modelio.metamodel.uml.behavior.activityModel.ObjectNode;
import org.modelio.metamodel.uml.behavior.commonBehaviors.Signal;

/**
 * GeneralClass v0.0.9054
 *
 *
 * A GeneralClass is an elaborated Classifier.  It belongs to its NameSpace.
 *
 */
@objid ("000bbdb4-c4bf-1fd8-97fe-001ec947cd2a")
public interface GeneralClass extends Classifier {
    /**
     * The metaclass simple name.
     */
    @objid ("bae10a95-1b08-4b16-ae82-1a837e49d2bf")
    public static final String MNAME = "GeneralClass";

    /**
     * The metaclass qualified name.
     */
    @objid ("39690c49-359e-4534-aec3-ada459bb24c3")
    public static final String MQNAME = "Standard.GeneralClass";

    /**
     * Getter for attribute 'GeneralClass.IsElementary'
     *
     * Metamodel description:
     * <i>Determines whether a Class is elementary/primitive or not. A Class is primitive if its value cannot be broken down and its instances are not handled by the application. For example, integer and boolean are elementary Classes, whereas Human or Device are generally not.</i>
     */
    @objid ("2e4e462c-a24b-4ec5-a596-cc372e849dd1")
    boolean isIsElementary();

    /**
     * Setter for attribute 'GeneralClass.IsElementary'
     *
     * Metamodel description:
     * <i>Determines whether a Class is elementary/primitive or not. A Class is primitive if its value cannot be broken down and its instances are not handled by the application. For example, integer and boolean are elementary Classes, whereas Human or Device are generally not.</i>
     */
    @objid ("3def1ad6-a9e3-434e-ad87-19c3e7eb2c94")
    void setIsElementary(boolean value);

    /**
     * Getter for relation 'GeneralClass->Occurence'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("cd8928ab-a6fc-48ac-bc32-2a0715a3d848")
    EList<Parameter> getOccurence();

    /**
     * Filtered Getter for relation 'GeneralClass->Occurence'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("dc3c8662-cb3b-4905-b9f2-e4d8c058114c")
    <T extends Parameter> List<T> getOccurence(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'GeneralClass->ExceptionInput'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("e35df317-6049-48e8-8870-6f172ec98f39")
    ExceptionHandler getExceptionInput();

    /**
     * Setter for relation 'GeneralClass->ExceptionInput'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("418d3ff0-e5d9-4543-a502-aac9ac15a81d")
    void setExceptionInput(ExceptionHandler value);

    /**
     * Getter for relation 'GeneralClass->Object'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("54f7b95f-ed7e-47f0-9abf-3ad6bdde4455")
    EList<Attribute> getObject();

    /**
     * Filtered Getter for relation 'GeneralClass->Object'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("03d3617e-8356-46d4-9a92-61658afe982c")
    <T extends Attribute> List<T> getObject(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'GeneralClass->SRepresentation'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("41a6736c-8767-450e-8a39-555215799536")
    EList<Signal> getSRepresentation();

    /**
     * Filtered Getter for relation 'GeneralClass->SRepresentation'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("9437e385-36c6-4b7d-8fbf-4c48c5a2dbed")
    <T extends Signal> List<T> getSRepresentation(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'GeneralClass->OccurenceObjectNode'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("130a9988-5117-4baa-94cf-6886447d42de")
    EList<ObjectNode> getOccurenceObjectNode();

    /**
     * Filtered Getter for relation 'GeneralClass->OccurenceObjectNode'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("4e6da0ce-02e4-40f2-8e7e-7959a92f080f")
    <T extends ObjectNode> List<T> getOccurenceObjectNode(java.lang.Class<T> filterClass);

}

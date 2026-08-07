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
package org.modelio.metamodel.uml.behavior.commonBehaviors;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.uml.behavior.activityModel.AcceptSignalAction;
import org.modelio.metamodel.uml.behavior.activityModel.SendSignalAction;
import org.modelio.metamodel.uml.behavior.communicationModel.CommunicationMessage;
import org.modelio.metamodel.uml.behavior.interactionModel.Message;
import org.modelio.metamodel.uml.behavior.stateMachineModel.Transition;
import org.modelio.metamodel.uml.informationFlow.DataFlow;
import org.modelio.metamodel.uml.statik.GeneralClass;
import org.modelio.metamodel.uml.statik.Operation;
import org.modelio.metamodel.uml.statik.Parameter;

/**
 * Signal v0.0.9054
 *
 *
 * Signals are processed by StateMachines, which represent how SignalEvents are taken into account.
 *
 * Modelio provides the DataFlow extension to UML.  Using this extension, a Signal can be declared as representing a ModelElement (GeneralClass, Operation, or Parameter).
 *
 * A DataFlow associated to the Signal will then be able to express this data, represented by the Signal, and may circulate between different NameSpaces.
 *
 * In Modelio, a Signal belongs to a NameSpace, notably its Package.
 *
 */
@objid ("00421152-c4bf-1fd8-97fe-001ec947cd2a")
public interface Signal extends GeneralClass {
    /**
     * The metaclass simple name.
     */
    @objid ("0f35f7a0-0b01-4ced-837d-7035d7112bc1")
    public static final String MNAME = "Signal";

    /**
     * The metaclass qualified name.
     */
    @objid ("705cd0fd-1921-4825-928d-cf1557313eba")
    public static final String MQNAME = "Standard.Signal";

    /**
     * Getter for attribute 'Signal.IsEvent'
     *
     * Metamodel description:
     * <i>Establishes if it is an event in the sense of event based systems : CORBA, Java, XWindow's, SGBDR.</i>
     */
    @objid ("e489b0f4-ebd2-494b-9b2f-290414a6e5cd")
    boolean isIsEvent();

    /**
     * Setter for attribute 'Signal.IsEvent'
     *
     * Metamodel description:
     * <i>Establishes if it is an event in the sense of event based systems : CORBA, Java, XWindow's, SGBDR.</i>
     */
    @objid ("a2c347ab-9bf6-4b1b-93b5-2c94f83c4e23")
    void setIsEvent(boolean value);

    /**
     * Getter for attribute 'Signal.IsException'
     *
     * Metamodel description:
     * <i>Defines if it is an exception, as they exist in Java, C++, and so on.</i>
     */
    @objid ("3badd7e0-395c-44e4-8a1d-33dfbf4dc05b")
    boolean isIsException();

    /**
     * Setter for attribute 'Signal.IsException'
     *
     * Metamodel description:
     * <i>Defines if it is an exception, as they exist in Java, C++, and so on.</i>
     */
    @objid ("21817b91-ea21-42c6-b7a4-82aac96ebedd")
    void setIsException(boolean value);

    /**
     * Getter for relation 'Signal->Sender'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("d3ab28bb-d88d-40ee-89f9-b0bd0a37a87e")
    EList<SendSignalAction> getSender();

    /**
     * Filtered Getter for relation 'Signal->Sender'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("64d4e527-5b18-4065-ace6-a8c53e8a8262")
    <T extends SendSignalAction> List<T> getSender(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'Signal->Usage'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("ef55745a-a4d6-4d07-bdb5-affc6a77436c")
    EList<Message> getUsage();

    /**
     * Filtered Getter for relation 'Signal->Usage'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("3f11e4b0-a6f2-4f93-b07f-cdf4cad15335")
    <T extends Message> List<T> getUsage(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'Signal->Sends'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("b98defb5-4127-4a56-b4bc-d30857ef4846")
    EList<Transition> getSends();

    /**
     * Filtered Getter for relation 'Signal->Sends'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("7c7673c5-9c0e-4949-943a-577184bc0975")
    <T extends Transition> List<T> getSends(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'Signal->PBase'
     *
     * Metamodel description:
     * <i>Parameter that the Signal may represent.</i>
     */
    @objid ("d20ced38-edff-4504-9782-b16326ada4d1")
    Parameter getPBase();

    /**
     * Setter for relation 'Signal->PBase'
     *
     * Metamodel description:
     * <i>Parameter that the Signal may represent.</i>
     */
    @objid ("41266060-bfa4-4e11-a952-1b3d0a18546a")
    void setPBase(Parameter value);

    /**
     * Getter for relation 'Signal->OBase'
     *
     * Metamodel description:
     * <i>The Operation that the Signal may represent.</i>
     */
    @objid ("d1bfd82f-fbe2-4b50-abf1-7eb7a1da9ab4")
    Operation getOBase();

    /**
     * Setter for relation 'Signal->OBase'
     *
     * Metamodel description:
     * <i>The Operation that the Signal may represent.</i>
     */
    @objid ("c1d3f70d-bf8b-4298-a1b2-8dbe0dd27f1d")
    void setOBase(Operation value);

    /**
     * Getter for relation 'Signal->CommunicationUsage'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("a4a88f4c-8cef-42c8-ae78-2868723cb4cc")
    EList<CommunicationMessage> getCommunicationUsage();

    /**
     * Filtered Getter for relation 'Signal->CommunicationUsage'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("b9383da0-7fd2-4844-83bf-cb9180939692")
    <T extends CommunicationMessage> List<T> getCommunicationUsage(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'Signal->DOccurence'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("df479cc2-7926-45eb-9a53-527e713dca56")
    EList<DataFlow> getDOccurence();

    /**
     * Filtered Getter for relation 'Signal->DOccurence'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("abd9c8c1-6c6d-4c0c-af83-f222b99ac793")
    <T extends DataFlow> List<T> getDOccurence(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'Signal->EOccurence'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("0733a85e-2fb5-4332-b343-52fad23f0f2a")
    EList<Event> getEOccurence();

    /**
     * Filtered Getter for relation 'Signal->EOccurence'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("324fc997-2622-4114-9dfb-b727825a1731")
    <T extends Event> List<T> getEOccurence(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'Signal->Base'
     *
     * Metamodel description:
     * <i>Class that the Signal may represent.</i>
     */
    @objid ("97984903-8c96-43be-8efa-2a6d5276fa8b")
    GeneralClass getBase();

    /**
     * Setter for relation 'Signal->Base'
     *
     * Metamodel description:
     * <i>Class that the Signal may represent.</i>
     */
    @objid ("2b6b1d42-daf2-419b-bf48-cc10f3663b79")
    void setBase(GeneralClass value);

    /**
     * Getter for relation 'Signal->Receiver'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("9776288a-7eed-4fd3-9a5f-9f3e4a8823e3")
    EList<AcceptSignalAction> getReceiver();

    /**
     * Filtered Getter for relation 'Signal->Receiver'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("d4b530a0-5740-499d-bd4f-7f36f7320b2a")
    <T extends AcceptSignalAction> List<T> getReceiver(java.lang.Class<T> filterClass);

}

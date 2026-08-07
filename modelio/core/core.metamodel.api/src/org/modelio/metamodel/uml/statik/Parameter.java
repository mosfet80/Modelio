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
import org.modelio.metamodel.uml.behavior.activityModel.Pin;
import org.modelio.metamodel.uml.behavior.commonBehaviors.BehaviorParameter;
import org.modelio.metamodel.uml.behavior.commonBehaviors.ParameterEffectKind;
import org.modelio.metamodel.uml.behavior.commonBehaviors.Signal;
import org.modelio.metamodel.uml.infrastructure.UmlModelElement;

/**
 * Parameter v0.0.9054
 *
 *
 * The main characteristics of a Parameter are its name, passing mode and type.
 *
 * The return value of an Operation is a specific case managed by a specific Association between Operation and Parameter.
 *
 * In Modelio, a Parameter belongs to its Operation.
 *
 */
@objid ("0017c640-c4bf-1fd8-97fe-001ec947cd2a")
public interface Parameter extends UmlModelElement {
    /**
     * The metaclass simple name.
     */
    @objid ("a3bd6b86-ab2d-4338-b8fc-403f0a646e5b")
    public static final String MNAME = "Parameter";

    /**
     * The metaclass qualified name.
     */
    @objid ("973c4625-35a0-4bb9-a8d6-0f553068cf6e")
    public static final String MQNAME = "Standard.Parameter";

    /**
     * Getter for attribute 'Parameter.ParameterPassing'
     *
     * Metamodel description:
     * <i>Defines the passing mode (in, out or inout) of the Parameter.</i>
     */
    @objid ("ef648343-d366-4d92-bde4-6c050226160c")
    PassingMode getParameterPassing();

    /**
     * Setter for attribute 'Parameter.ParameterPassing'
     *
     * Metamodel description:
     * <i>Defines the passing mode (in, out or inout) of the Parameter.</i>
     */
    @objid ("d9645be1-301f-482d-9ab1-ece675863772")
    void setParameterPassing(PassingMode value);

    /**
     * Getter for attribute 'Parameter.MultiplicityMin'
     *
     * Metamodel description:
     * <i>Minimum value of the association's multiplicity. When placed on a target end, the multiplicity specifies the number of target instances that may be associated with a single source instance via the given Association.</i>
     */
    @objid ("196e6ec6-591e-4250-915e-a9be4610dbb6")
    String getMultiplicityMin();

    /**
     * Setter for attribute 'Parameter.MultiplicityMin'
     *
     * Metamodel description:
     * <i>Minimum value of the association's multiplicity. When placed on a target end, the multiplicity specifies the number of target instances that may be associated with a single source instance via the given Association.</i>
     */
    @objid ("6836cd28-1dd3-4b9b-89b4-85a2f6f6f53a")
    void setMultiplicityMin(String value);

    /**
     * Getter for attribute 'Parameter.MultiplicityMax'
     *
     * Metamodel description:
     * <i>Maximum value of the multiplicity.</i>
     */
    @objid ("dca696bf-1ed6-425e-b4a0-44c047d02299")
    String getMultiplicityMax();

    /**
     * Setter for attribute 'Parameter.MultiplicityMax'
     *
     * Metamodel description:
     * <i>Maximum value of the multiplicity.</i>
     */
    @objid ("602437cf-7403-4b08-bdaf-4f8c298d8a7c")
    void setMultiplicityMax(String value);

    /**
     * Getter for attribute 'Parameter.TypeConstraint'
     *
     * Metamodel description:
     * <i>Construction parameter of the Parameter's class (for example, the size of a characters string).</i>
     */
    @objid ("b4c40832-3b7a-43cb-a24a-87ab7a87ed27")
    String getTypeConstraint();

    /**
     * Setter for attribute 'Parameter.TypeConstraint'
     *
     * Metamodel description:
     * <i>Construction parameter of the Parameter's class (for example, the size of a characters string).</i>
     */
    @objid ("c0c04930-3381-45b3-99f8-69307d595d7f")
    void setTypeConstraint(String value);

    /**
     * Getter for attribute 'Parameter.DefaultValue'
     *
     * Metamodel description:
     * <i>Default value of the Parameter. When the caller does not specify a value, then the default value is applied.</i>
     */
    @objid ("2688bd41-7b2d-4e5e-bdea-e8c087dce438")
    String getDefaultValue();

    /**
     * Setter for attribute 'Parameter.DefaultValue'
     *
     * Metamodel description:
     * <i>Default value of the Parameter. When the caller does not specify a value, then the default value is applied.</i>
     */
    @objid ("ca5691d6-3c89-4b31-9368-4f09e34217fd")
    void setDefaultValue(String value);

    /**
     * Getter for attribute 'Parameter.IsOrdered'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("53348948-9b76-40fa-9be1-b8fb2f03e9e8")
    boolean isIsOrdered();

    /**
     * Setter for attribute 'Parameter.IsOrdered'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("d45abbdc-7375-4a07-ba0f-3f1da4a26cf6")
    void setIsOrdered(boolean value);

    /**
     * Getter for attribute 'Parameter.IsUnique'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("3908edc1-0385-4997-8879-a7e371bcc45d")
    boolean isIsUnique();

    /**
     * Setter for attribute 'Parameter.IsUnique'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("1f2de355-b191-4b62-94c7-c3764be12562")
    void setIsUnique(boolean value);

    /**
     * Getter for attribute 'Parameter.IsException'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("4790a952-03ac-4501-a8e4-6bd654796a3c")
    boolean isIsException();

    /**
     * Setter for attribute 'Parameter.IsException'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("5911d9ad-56da-4812-aefc-a85266ab5862")
    void setIsException(boolean value);

    /**
     * Getter for attribute 'Parameter.IsStream'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("e23cb95d-861e-4be0-bda7-c31647ba41f2")
    boolean isIsStream();

    /**
     * Setter for attribute 'Parameter.IsStream'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("ecd9428c-b249-4463-981e-d1b73f0c3fbd")
    void setIsStream(boolean value);

    /**
     * Getter for attribute 'Parameter.Effect'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("48b9c637-7ee7-456a-a47d-658f1e50a47d")
    ParameterEffectKind getEffect();

    /**
     * Setter for attribute 'Parameter.Effect'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("309e4404-bd3f-4987-9e8d-0ca349cee1ac")
    void setEffect(ParameterEffectKind value);

    /**
     * Getter for relation 'Parameter->Type'
     *
     * Metamodel description:
     * <i>Defines the Class to which the Parameter belongs.</i>
     */
    @objid ("61760572-540d-4184-bb0b-17c895184afa")
    GeneralClass getType();

    /**
     * Setter for relation 'Parameter->Type'
     *
     * Metamodel description:
     * <i>Defines the Class to which the Parameter belongs.</i>
     */
    @objid ("0995eb91-c0fe-49d3-9027-d89dd8c71961")
    void setType(GeneralClass value);

    /**
     * Getter for relation 'Parameter->Composed'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("2dfafbdf-e332-4dfc-ab98-050287307597")
    Operation getComposed();

    /**
     * Setter for relation 'Parameter->Composed'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("63b88cfd-558c-4fa2-8a55-063b8d389416")
    void setComposed(Operation value);

    /**
     * Getter for relation 'Parameter->Matching'
     *
     * Metamodel description:
     * <i></i>
     */
    @objid ("8b2ae9f1-1cb2-40b7-9482-61af66b009ed")
    EList<Pin> getMatching();

    /**
     * Filtered Getter for relation 'Parameter->Matching'
     *
     * Metamodel description:
     * <i></i>
     */
    @objid ("25030867-dedf-46ab-acd1-5adc523a08cd")
    <T extends Pin> List<T> getMatching(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'Parameter->SRepresentation'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("16338108-47c3-4874-b283-b2674b701608")
    EList<Signal> getSRepresentation();

    /**
     * Filtered Getter for relation 'Parameter->SRepresentation'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("d22ba499-8502-4599-ae38-b6d25ef858d8")
    <T extends Signal> List<T> getSRepresentation(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'Parameter->Returned'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("bdc302c1-da7c-4af9-8463-ff09a06f38cd")
    Operation getReturned();

    /**
     * Setter for relation 'Parameter->Returned'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("54f28ded-e05e-4a52-97cd-1ec0db8fd131")
    void setReturned(Operation value);

    /**
     * Getter for relation 'Parameter->BehaviorParam'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("5c2e20a4-ff56-41c5-9e00-b61a9217ac68")
    EList<BehaviorParameter> getBehaviorParam();

    /**
     * Filtered Getter for relation 'Parameter->BehaviorParam'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("3f77b250-1d19-4897-8e3c-9145e26d74e9")
    <T extends BehaviorParameter> List<T> getBehaviorParam(java.lang.Class<T> filterClass);

}

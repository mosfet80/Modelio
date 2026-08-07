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

/**
 * Port v0.0.9054
 *
 *
 * (UML 2.0) Ports are connected to other Parts through Connectors through which requests can be made to invoke the behavioral Features of a Classifier.
 *
 * A Port may specify the services a Classifier offers to its environment, as well as the services that a Classifier expects of its environment.
 *
 * In Modelio, Ports are declared on Classes (UML 2.0 structured Classifiers) by creating them in the Class's internal structure. These Ports can then be shown on Instances of the Class, by creating Port instances in the Class instances, and by binding these Port instances to the Ports defined at Class level.
 *
 * In Modelio, a Port always belongs to a Class, a Component or a Signal.
 *
 *
 */
@objid ("0018a768-c4bf-1fd8-97fe-001ec947cd2a")
public interface Port extends BindableInstance {
    /**
     * The metaclass simple name.
     */
    @objid ("d4ef8008-934f-4ab0-bee0-e30de92c1cd2")
    public static final String MNAME = "Port";

    /**
     * The metaclass qualified name.
     */
    @objid ("0bd49b84-1c91-45d9-bae5-1963d9d1903d")
    public static final String MQNAME = "Standard.Port";

    /**
     * Getter for attribute 'Port.IsBehavior'
     *
     * Metamodel description:
     * <i>Specifies whether requests arriving at this Port are sent to the Classifier behavior of this Classifier. Such Ports are referred to as behavior Port.
     *
     * Any invocation of a behavioral feature targeted at a behavior Port will be handled by the instance of the owning Classifier itself, rather than by any instances that this Classifier may contain.
     *
     * The default value is false.</i>
     */
    @objid ("cba44f5e-a8e6-4b7b-a0ee-5f37655fbbeb")
    boolean isIsBehavior();

    /**
     * Setter for attribute 'Port.IsBehavior'
     *
     * Metamodel description:
     * <i>Specifies whether requests arriving at this Port are sent to the Classifier behavior of this Classifier. Such Ports are referred to as behavior Port.
     *
     * Any invocation of a behavioral feature targeted at a behavior Port will be handled by the instance of the owning Classifier itself, rather than by any instances that this Classifier may contain.
     *
     * The default value is false.</i>
     */
    @objid ("6fbec322-3a30-463c-8a00-0e843308e301")
    void setIsBehavior(boolean value);

    /**
     * Getter for attribute 'Port.IsService'
     *
     * Metamodel description:
     * <i>If true, indicates that this Port is used to provide the published functionality of a Classifier. If false, this Port is used to implement the Classifier but is not part of the essential externally-visible functionality of the Classifier and can, therefore, be altered or deleted along with the internal implementation of the Classifier and other properties that are considered part of its implementation.
     *
     * The default value for this attribute is true.</i>
     */
    @objid ("cc8efc3f-725a-4e76-9c60-6396f55ed68f")
    boolean isIsService();

    /**
     * Setter for attribute 'Port.IsService'
     *
     * Metamodel description:
     * <i>If true, indicates that this Port is used to provide the published functionality of a Classifier. If false, this Port is used to implement the Classifier but is not part of the essential externally-visible functionality of the Classifier and can, therefore, be altered or deleted along with the internal implementation of the Classifier and other properties that are considered part of its implementation.
     *
     * The default value for this attribute is true.</i>
     */
    @objid ("6896e17a-3282-4dcf-a497-9a19431f60e0")
    void setIsService(boolean value);

    /**
     * Getter for attribute 'Port.IsConjugated'
     *
     * Metamodel description:
     * <i>Specifies the way that the provided and required interfaces are derived from the Port's Type.  The default value is false.</i>
     */
    @objid ("e1584e93-b1ef-4f1b-b4f7-3190b7062264")
    boolean isIsConjugated();

    /**
     * Setter for attribute 'Port.IsConjugated'
     *
     * Metamodel description:
     * <i>Specifies the way that the provided and required interfaces are derived from the Port's Type.  The default value is false.</i>
     */
    @objid ("68da80fd-e937-4888-90f1-0cf9bd20bd68")
    void setIsConjugated(boolean value);

    /**
     * Getter for attribute 'Port.Direction'
     *
     * Metamodel description:
     * <i><p>Specifies the way that the data&nbsp;flows through&nbsp;the Port.</p>
     * </i>
     */
    @objid ("36d880f5-e99a-456d-8b33-407340c3c69a")
    PortOrientation getDirection();

    /**
     * Setter for attribute 'Port.Direction'
     *
     * Metamodel description:
     * <i><p>Specifies the way that the data&nbsp;flows through&nbsp;the Port.</p>
     * </i>
     */
    @objid ("f047f305-53ae-4e01-9ea9-9af5e1cf0301")
    void setDirection(PortOrientation value);

    /**
     * Getter for relation 'Port->Provided'
     *
     * Metamodel description:
     * <i>References the Interfaces specifying the set of operations and receptions which the Classifier provides to its environment, and which it will handle either directly or by forwarding it to a part of its internal structure.</i>
     */
    @objid ("9cfb80d6-7de6-415e-94aa-d4bb11edd3a8")
    EList<ProvidedInterface> getProvided();

    /**
     * Filtered Getter for relation 'Port->Provided'
     *
     * Metamodel description:
     * <i>References the Interfaces specifying the set of operations and receptions which the Classifier provides to its environment, and which it will handle either directly or by forwarding it to a part of its internal structure.</i>
     */
    @objid ("aed3652d-a540-48bd-9250-4ade9319cf5e")
    <T extends ProvidedInterface> List<T> getProvided(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'Port->Required'
     *
     * Metamodel description:
     * <i>References the Interfaces specifying the set of operations and receptions which the Classifier expects its environment to handle.</i>
     */
    @objid ("a8325aba-d828-460f-9a4e-9a9a42ac2f5c")
    EList<RequiredInterface> getRequired();

    /**
     * Filtered Getter for relation 'Port->Required'
     *
     * Metamodel description:
     * <i>References the Interfaces specifying the set of operations and receptions which the Classifier expects its environment to handle.</i>
     */
    @objid ("2192845f-fefa-448c-b763-805f62f9009a")
    <T extends RequiredInterface> List<T> getRequired(java.lang.Class<T> filterClass);

}

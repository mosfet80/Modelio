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
import org.modelio.metamodel.uml.behavior.commonBehaviors.Behavior;

/**
 * Collaboration v0.0.9054
 *
 *
 * (UML 2.0) A Collaboration is represented as a kind of Classifier, and defines a set of cooperating entities to be played by instances (its roles), as well as a set of Connectors that define Links between the participating instances. The cooperating entities are the properties of the Collaboration.
 *
 * A Collaboration is not instanciable. A Collaboration specifies a view (or projection) of a set of cooperating Classifiers. It describes the required Links between instances that play the roles of the Collaboration, as well as the Features required of the Classifiers that specify the participating instances. Several Collaborations may describe different projections of the same set of Classifiers.
 *
 * In Modelio, Collaborations have the same meaning. Modelio extends them, by allowing them to directly bind Parts and Connectors to other ModelElements. This means that a bound Collaboration can be directly entered.
 *
 * In Modelio, a Collaboration belongs to a UseCase, a Class, a Package, a Collaboration or an Operation.
 *
 */
@objid ("0003f692-c4bf-1fd8-97fe-001ec947cd2a")
public interface Collaboration extends NameSpace {
    /**
     * The metaclass simple name.
     */
    @objid ("05fac554-de4c-4e0e-80cc-097fc1a2b26b")
    public static final String MNAME = "Collaboration";

    /**
     * The metaclass qualified name.
     */
    @objid ("82caa00d-e263-40c9-92a7-99f45cb2ed8d")
    public static final String MQNAME = "Standard.Collaboration";

    /**
     * Getter for attribute 'Collaboration.IsConcurrent'
     *
     * Metamodel description:
     * <i>Expresses if the Collaboration between objects is concurrent or sequential.</i>
     */
    @objid ("71ac7914-e352-4e79-a693-82eb8a88ce8f")
    boolean isIsConcurrent();

    /**
     * Setter for attribute 'Collaboration.IsConcurrent'
     *
     * Metamodel description:
     * <i>Expresses if the Collaboration between objects is concurrent or sequential.</i>
     */
    @objid ("de0282ad-adab-4efc-8ccb-0da8a945760e")
    void setIsConcurrent(boolean value);

    /**
     * Getter for relation 'Collaboration->ORepresented'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("fbe52179-79d6-413d-9754-43b0377d2774")
    Operation getORepresented();

    /**
     * Setter for relation 'Collaboration->ORepresented'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("86e87bd1-a1f5-4363-93f8-62b112150493")
    void setORepresented(Operation value);

    /**
     * Getter for relation 'Collaboration->BRepresented'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("c1273a21-5930-4019-b540-33b356ea6280")
    Behavior getBRepresented();

    /**
     * Setter for relation 'Collaboration->BRepresented'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("3f59cb40-e100-4ab7-810d-4e2040bba2a9")
    void setBRepresented(Behavior value);

    /**
     * Getter for relation 'Collaboration->Occurrence'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("4048d110-a54c-4816-9d6e-0247945ddf1e")
    EList<CollaborationUse> getOccurrence();

    /**
     * Filtered Getter for relation 'Collaboration->Occurrence'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("b750a3aa-a1bf-4e50-a56c-5b74ab0381a8")
    <T extends CollaborationUse> List<T> getOccurrence(java.lang.Class<T> filterClass);

}

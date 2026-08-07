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
package org.modelio.metamodel.uml.behavior.interactionModel;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;

/**
 * Gate v0.0.9054
 *
 *
 * Gates are connected through Messages. A Gate is actually a representative of an OccurrenceSpecification that is not in the same scope as the Gate.
 *
 * Gates play different roles: we have formal gates on Interactions, and actual gates on InteractionUses.
 *
 */
@objid ("004545ca-c4bf-1fd8-97fe-001ec947cd2a")
public interface Gate extends MessageEnd {
    /**
     * The metaclass simple name.
     */
    @objid ("b4f91d4c-ee82-4754-ab2a-2246a612c871")
    public static final String MNAME = "Gate";

    /**
     * The metaclass qualified name.
     */
    @objid ("2169d312-9cfa-428b-b4b8-542524bd4f0f")
    public static final String MQNAME = "Standard.Gate";

    /**
     * Getter for relation 'Gate->OwnerUse'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("d6d127c0-a5c0-4648-a666-a6763f0f1962")
    InteractionUse getOwnerUse();

    /**
     * Setter for relation 'Gate->OwnerUse'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("7b399b49-5b09-49a8-ab56-8ce8a9ce01ac")
    void setOwnerUse(InteractionUse value);

    /**
     * Getter for relation 'Gate->Actual'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("bdb1030a-c6d4-4e7f-a905-7941300a743e")
    EList<Gate> getActual();

    /**
     * Filtered Getter for relation 'Gate->Actual'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("65bb9d5f-1ba3-4f66-85fd-2a582df4a3fc")
    <T extends Gate> List<T> getActual(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'Gate->OwnerInteraction'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("ce039821-4d5e-4040-83b4-7643fa1588b5")
    Interaction getOwnerInteraction();

    /**
     * Setter for relation 'Gate->OwnerInteraction'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("4f0415cf-1826-4357-a163-0a80ddddfb22")
    void setOwnerInteraction(Interaction value);

    /**
     * Getter for relation 'Gate->OwnerFragment'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("1e76934d-76c1-49d6-a08b-b243b8def362")
    CombinedFragment getOwnerFragment();

    /**
     * Setter for relation 'Gate->OwnerFragment'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("b50343b2-8b9e-4b62-9819-e87e521f7e4c")
    void setOwnerFragment(CombinedFragment value);

    /**
     * Getter for relation 'Gate->Formal'
     *
     * Metamodel description:
     * <i>If the gate belongs to an InteractionUse, then it is connected to a formal gate belonging to the referred interaction.</i>
     */
    @objid ("ffcb61a9-6b14-47ab-b735-78992f36f8e7")
    Gate getFormal();

    /**
     * Setter for relation 'Gate->Formal'
     *
     * Metamodel description:
     * <i>If the gate belongs to an InteractionUse, then it is connected to a formal gate belonging to the referred interaction.</i>
     */
    @objid ("616c9dd0-fdf9-406f-8eb6-578d270ed874")
    void setFormal(Gate value);

}

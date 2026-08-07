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
 * InteractionUse v0.0.9054
 *
 *
 * An InteractionUse refers to an Interaction. The InteractionUse is a shorthand for copying the contents of the referred Interaction where the InteractionUse is. To be accurate the copying must connect the formal gates with the actual ones.
 *
 * It is common to want to share portions of an interaction between several other interactions. An InteractionUse allows multiple interactions to reference an interaction that represents a common portion of their specification.
 *
 *
 */
@objid ("00482c5e-c4bf-1fd8-97fe-001ec947cd2a")
public interface InteractionUse extends InteractionFragment {
    /**
     * The metaclass simple name.
     */
    @objid ("a8907c7a-5f66-451a-add6-0938cee5b4e2")
    public static final String MNAME = "InteractionUse";

    /**
     * The metaclass qualified name.
     */
    @objid ("ca85e94d-c6a1-4e1e-af12-5fbc13fbf1ea")
    public static final String MQNAME = "Standard.InteractionUse";

    /**
     * Getter for attribute 'InteractionUse.EndLineNumber'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("f9dba712-94cc-44d7-91f6-3b274b091814")
    int getEndLineNumber();

    /**
     * Setter for attribute 'InteractionUse.EndLineNumber'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("961f8856-b317-4ece-aad6-53e9f158c93e")
    void setEndLineNumber(int value);

    /**
     * Getter for relation 'InteractionUse->ActualGate'
     *
     * Metamodel description:
     * <i>The actual gates of the InteractionUse.</i>
     */
    @objid ("4761bf34-6803-457c-a961-9154640ab2c3")
    EList<Gate> getActualGate();

    /**
     * Filtered Getter for relation 'InteractionUse->ActualGate'
     *
     * Metamodel description:
     * <i>The actual gates of the InteractionUse.</i>
     */
    @objid ("4e1fa642-f6ad-4a7d-9f3a-ecfbf9cd6592")
    <T extends Gate> List<T> getActualGate(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'InteractionUse->RefersTo'
     *
     * Metamodel description:
     * <i>Refers to the Interaction that defines its meaning.</i>
     */
    @objid ("3db72432-a063-44d5-b4e4-7a92ab58d98c")
    Interaction getRefersTo();

    /**
     * Setter for relation 'InteractionUse->RefersTo'
     *
     * Metamodel description:
     * <i>Refers to the Interaction that defines its meaning.</i>
     */
    @objid ("6a15bb59-5571-47f5-b310-e73331ab4de5")
    void setRefersTo(Interaction value);

}

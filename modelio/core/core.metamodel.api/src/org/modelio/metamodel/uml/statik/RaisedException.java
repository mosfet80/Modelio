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

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.uml.infrastructure.UmlModelElement;

/**
 * RaisedException v0.0.9054
 *
 *
 *
 *
 */
@objid ("001a6e72-c4bf-1fd8-97fe-001ec947cd2a")
public interface RaisedException extends UmlModelElement {
    /**
     * The metaclass simple name.
     */
    @objid ("a6b71d7e-5aa4-4e17-8f90-d6ef2fc815f4")
    public static final String MNAME = "RaisedException";

    /**
     * The metaclass qualified name.
     */
    @objid ("135d1242-aff7-4d05-a026-f442ce1ec463")
    public static final String MQNAME = "Standard.RaisedException";

    /**
     * Getter for relation 'RaisedException->ThrownType'
     *
     * Metamodel description:
     * <i>Raised exception type.</i>
     */
    @objid ("11ce5c2b-42bc-4571-a3f9-408176c1822a")
    Classifier getThrownType();

    /**
     * Setter for relation 'RaisedException->ThrownType'
     *
     * Metamodel description:
     * <i>Raised exception type.</i>
     */
    @objid ("14086b9a-2658-4134-b5ba-de87a403a3ca")
    void setThrownType(Classifier value);

    /**
     * Getter for relation 'RaisedException->Thrower'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("c4d245cb-dc44-4c91-ad47-297275b14ca7")
    Operation getThrower();

    /**
     * Setter for relation 'RaisedException->Thrower'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("760d1eaa-21c8-402f-b445-1dfee571a20e")
    void setThrower(Operation value);

}

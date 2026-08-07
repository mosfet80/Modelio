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
package org.modelio.metamodel.uml.infrastructure;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.uml.infrastructure.Dependency;

/**
 * Abstraction v0.0.9054
 *
 *
 * An Abstraction is a relationship that relates two Elements or sets of Elements that represent the same concept at different levels of abstraction or from different viewpoints.
 *
 * An Abstraction is a Dependency in which the supplier and the client are mapped.
 *
 */
@objid ("00849680-c4be-1fd8-97fe-001ec947cd2a")
public interface Abstraction extends Dependency {
    /**
     * The metaclass simple name.
     */
    @objid ("03c753eb-2cf3-4c11-847c-b611430a01c5")
    public static final String MNAME = "Abstraction";

    /**
     * The metaclass qualified name.
     */
    @objid ("6b169db1-711e-43e4-b458-28faa372bd60")
    public static final String MQNAME = "Standard.Abstraction";

    /**
     * Getter for attribute 'Abstraction.Mapping'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("ac413ebd-a413-4b05-a424-ec911bdd48e3")
    String getMapping();

    /**
     * Setter for attribute 'Abstraction.Mapping'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("3a33add0-9379-4493-be92-0bcc4e3570fa")
    void setMapping(String value);

}

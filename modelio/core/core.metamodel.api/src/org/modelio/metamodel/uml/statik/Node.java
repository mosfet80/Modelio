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
 * Node v0.0.9054
 *
 *
 * In the metamodel, a Node is a subclass of Classifier.
 *
 * Nodes may have an internal structure defined in terms of the Parts and Connectors associated with them, which is used to model the deployment of Artifact on Nodes, and also the imbrications of Nodes.
 *
 * In Modelio, Nodes belong to their owner NameSpace, which can be a Package, a Class or a Node.
 *
 */
@objid ("0012fb88-c4bf-1fd8-97fe-001ec947cd2a")
public interface Node extends Classifier {
    /**
     * The metaclass simple name.
     */
    @objid ("2b31e1ae-eb1d-43a2-9cd5-ed2a30f0b610")
    public static final String MNAME = "Node";

    /**
     * The metaclass qualified name.
     */
    @objid ("3059e680-2f39-429e-afc1-d2c232ad15ea")
    public static final String MQNAME = "Standard.Node";

    /**
     * Getter for relation 'Node->Resident'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("26028cee-0b96-4e4b-b763-be476562c6ca")
    EList<Artifact> getResident();

    /**
     * Filtered Getter for relation 'Node->Resident'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("203d373c-b95e-4ac9-92cc-76b0dfe7eaf3")
    <T extends Artifact> List<T> getResident(java.lang.Class<T> filterClass);

}

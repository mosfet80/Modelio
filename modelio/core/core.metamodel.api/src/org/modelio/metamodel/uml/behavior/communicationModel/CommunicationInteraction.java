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
package org.modelio.metamodel.uml.behavior.communicationModel;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.uml.behavior.commonBehaviors.Behavior;

/**
 * CommunicationInteraction v0.0.9054
 *
 *
 *
 *
 */
@objid ("005a13d8-c4bf-1fd8-97fe-001ec947cd2a")
public interface CommunicationInteraction extends Behavior {
    /**
     * The metaclass simple name.
     */
    @objid ("b152bc8c-90b6-4c95-9c63-eba0382cc4e2")
    public static final String MNAME = "CommunicationInteraction";

    /**
     * The metaclass qualified name.
     */
    @objid ("226846f1-1436-47cb-80b2-b29c252db93e")
    public static final String MQNAME = "Standard.CommunicationInteraction";

    /**
     * Getter for relation 'CommunicationInteraction->Owned'
     *
     * Metamodel description:
     * <i></i>
     */
    @objid ("b04d0270-52ec-46ee-bd33-25cf80cba331")
    EList<CommunicationNode> getOwned();

    /**
     * Filtered Getter for relation 'CommunicationInteraction->Owned'
     *
     * Metamodel description:
     * <i></i>
     */
    @objid ("ca100724-f3d7-45cf-809b-c2b416b3c610")
    <T extends CommunicationNode> List<T> getOwned(java.lang.Class<T> filterClass);

}

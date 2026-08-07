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
package org.modelio.metamodel.impl.uml.behavior.activityModel;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.uml.behavior.activityModel.DecisionNodeKind;

@objid ("0030401c-c4bf-1fd8-97fe-001ec947cd2a")
public class DecisionMergeNodeData extends ControlNodeData {
    @objid ("d54ed54d-7039-4107-b3f6-fc7b4ab16845")
    Object mDecisionKind = DecisionNodeKind.EXCLUSIVEDECISION;

    @objid ("1dfc4107-c211-484a-a9d1-4273d729360f")
    Object mDecisionInputBehavior = "";

    @objid ("8ffebd40-8842-4f2f-b56c-e7a6cda9f5df")
    public DecisionMergeNodeData(DecisionMergeNodeSmClass smClass) {
        super(smClass);
    }

}

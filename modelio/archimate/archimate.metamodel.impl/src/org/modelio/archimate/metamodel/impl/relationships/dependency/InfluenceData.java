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
     Metamodel: Archimate, version 1.0.4, by Modeliosoft
     Generator version: 3.14.00
     Generated on: Feb 9, 2023
*/
package org.modelio.archimate.metamodel.impl.relationships.dependency;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.relationships.dependency.InfluenceStrength;

@objid ("8088dbde-260a-4cf9-acb7-d3b2a1ae4b1c")
public class InfluenceData extends DependencyRelationshipData {
    @objid ("fbbd49fb-dc4d-4729-812a-7c8e7e96609f")
    Object mStrength = InfluenceStrength.UNDEFINED.toString();

    @objid ("19869ac7-5a78-462f-b2ae-30b52a0f9c5b")
    public InfluenceData(InfluenceSmClass smClass) {
        super(smClass);
    }

}

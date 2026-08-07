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
package org.modelio.metamodel.impl.uml.statik;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.impl.uml.infrastructure.UmlModelElementData;
import org.modelio.vcore.smkernel.SmObjectImpl;

@objid ("001cc6ae-c4bf-1fd8-97fe-001ec947cd2a")
public class TemplateBindingData extends UmlModelElementData {
    @objid ("f70fc06f-8af7-48e4-8cd1-9e49a2b74182")
    List<SmObjectImpl> mParameterSubstitution = null;

    @objid ("aea0304c-3ff4-4727-8a50-fec25bfa314f")
    SmObjectImpl mBoundOperation;

    @objid ("21b83c9b-8434-4c76-91a7-24753a811d2d")
    SmObjectImpl mInstanciatedTemplateOperation;

    @objid ("c0938487-4d7b-418e-a771-8a694c30a188")
    SmObjectImpl mInstanciatedTemplate;

    @objid ("c3544806-dea9-4ca5-8965-f9820bbba9f1")
    SmObjectImpl mBoundElement;

    @objid ("361e5bcc-6d70-4204-aef6-11e35a3bfbe2")
    public TemplateBindingData(TemplateBindingSmClass smClass) {
        super(smClass);
    }

}

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
package org.modelio.metamodel.impl.uml.infrastructure;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.vcore.smkernel.SmObjectImpl;

@objid ("00859e2c-c4be-1fd8-97fe-001ec947cd2a")
public class ConstraintData extends UmlModelElementData {
    @objid ("20125433-ba31-4ce5-98a7-cbea783e0eb5")
    Object mBaseClass = "";

    @objid ("3441d381-7285-4f2f-b1f1-ee67ec9a98b4")
    Object mBody = "";

    @objid ("05af069b-2cbe-499d-9dfa-5408e94745ce")
    Object mLanguage = "";

    @objid ("3ec63300-5929-472d-bbc3-39203e252139")
    List<SmObjectImpl> mConstrainedElement = null;

    @objid ("dc4dc8ac-67f4-4be2-978d-b5844d40cf98")
    public ConstraintData(ConstraintSmClass smClass) {
        super(smClass);
    }

}

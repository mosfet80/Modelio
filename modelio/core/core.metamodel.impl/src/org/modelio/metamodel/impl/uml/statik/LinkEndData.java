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

@objid ("001037c2-c4bf-1fd8-97fe-001ec947cd2a")
public class LinkEndData extends UmlModelElementData {
    @objid ("686c5976-4e5c-4970-b44d-34eb9925229e")
    Object mIsOrdered = false;

    @objid ("8e0b116e-84bb-4e42-a405-7455ff9a05bc")
    Object mIsUnique = false;

    @objid ("65932151-6f68-4cc8-aaa5-04f9e7d372db")
    Object mMultiplicityMax = "1";

    @objid ("599d0d75-21b7-49ce-95c8-966d3ba5389b")
    Object mMultiplicityMin = "0";

    @objid ("ec7ac3b2-85fc-4bdd-ba9a-a52ca2d0d5be")
    SmObjectImpl mLink;

    @objid ("b58e88e7-5688-460d-a3a4-ce9de8228e8d")
    SmObjectImpl mTarget;

    @objid ("9ba26f1b-92d5-4246-93c6-3d1d12933efd")
    SmObjectImpl mOppositeOwner;

    @objid ("db034422-e3b8-439c-aa5c-eee69a0686cd")
    List<SmObjectImpl> mRealizedInformationFlow = null;

    @objid ("bbbbfb5a-a352-4a5a-a407-678a4183466b")
    SmObjectImpl mModel;

    @objid ("e80f2b49-1a8d-4d5a-a989-e0c4ef9bb67a")
    SmObjectImpl mConsumer;

    @objid ("cff570fe-9cdb-41bf-b2b9-527af76bfe68")
    SmObjectImpl mOpposite;

    @objid ("30884c76-d2b3-4c8d-b81b-4e7524d06cea")
    SmObjectImpl mSource;

    @objid ("38895b86-0e2a-497b-86d4-8db82c7ae03d")
    SmObjectImpl mProvider;

    @objid ("49a27082-28f5-4e2e-a74b-197a8f1838a2")
    public LinkEndData(LinkEndSmClass smClass) {
        super(smClass);
    }

}

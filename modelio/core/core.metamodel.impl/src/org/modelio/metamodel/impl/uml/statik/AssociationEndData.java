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
import org.modelio.metamodel.uml.statik.AggregationKind;
import org.modelio.vcore.smkernel.SmObjectImpl;

@objid ("0097b0da-c4be-1fd8-97fe-001ec947cd2a")
public class AssociationEndData extends StructuralFeatureData {
    @objid ("693cf432-ef7b-472d-8259-2495bb3e4e93")
    Object mAggregation = AggregationKind.KINDISASSOCIATION;

    @objid ("4d6f1ead-6591-4155-96ea-5cc309420cd8")
    Object mIsChangeable = true;

    @objid ("b36e4901-a0f6-465a-83e0-c8d942bd1091")
    SmObjectImpl mTarget;

    @objid ("0c9ad35b-6836-4414-886d-2917858c99e3")
    SmObjectImpl mOppositeOwner;

    @objid ("92de4899-e5ba-4296-8aa7-701c3e7a53c2")
    SmObjectImpl mSource;

    @objid ("fde707a4-f90d-408e-b235-0ad4797726c6")
    List<SmObjectImpl> mOccurence = null;

    @objid ("b13116e2-bfe8-40bd-9cc4-481b792f1bb6")
    List<SmObjectImpl> mSent = null;

    @objid ("7879e182-ca88-4a41-8e74-efcdae37b7b4")
    List<SmObjectImpl> mQualifier = null;

    @objid ("b1a1a990-5f99-4816-ae93-f4a3ed868a72")
    SmObjectImpl mOpposite;

    @objid ("bf9cb5b7-ad1d-4a7c-a800-6dd7698f8ba3")
    List<SmObjectImpl> mRepresentingObjectNode = null;

    @objid ("49aed61b-2f07-4727-974d-9c1e40b46c58")
    SmObjectImpl mAssociation;

    @objid ("5f292ef1-b7e0-44a1-a20d-a78d214baf70")
    public AssociationEndData(AssociationEndSmClass smClass) {
        super(smClass);
    }

}

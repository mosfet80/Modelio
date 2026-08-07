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
import org.modelio.metamodel.uml.statik.MethodPassingMode;
import org.modelio.vcore.smkernel.SmObjectImpl;

@objid ("0014d9d0-c4bf-1fd8-97fe-001ec947cd2a")
public class OperationData extends BehavioralFeatureData {
    @objid ("2592d08d-52f2-4739-8f50-46fc8f39f209")
    Object mConcurrency = false;

    @objid ("eda5ebb0-b123-4164-818a-e7ea8e7aacac")
    Object mFinal = false;

    @objid ("30125b38-9ee2-4445-9e2e-90d24805fd4d")
    Object mPassing = MethodPassingMode.METHODOUT;

    @objid ("57c5826f-57ae-491a-8346-1082354c2510")
    List<SmObjectImpl> mOwnedImport = null;

    @objid ("a57fc6d2-5164-4903-835e-faf5c598996b")
    List<SmObjectImpl> mThrown = null;

    @objid ("517d58ea-c6cb-4abd-ae8d-f6a5c9bbc947")
    List<SmObjectImpl> mRedefinition = null;

    @objid ("6f046dbf-1c3c-4e33-bd75-deac028b2037")
    List<SmObjectImpl> mExample = null;

    @objid ("cea106ab-d43c-4390-976c-50898195fa95")
    List<SmObjectImpl> mSRepresentation = null;

    @objid ("094e3517-42e5-4a1c-9e23-baf4e3651253")
    List<SmObjectImpl> mOwnedBehavior = null;

    @objid ("baabe237-87e1-4abe-a923-ed0f1ddd3695")
    List<SmObjectImpl> mIO = null;

    @objid ("b9d46eed-fb5d-4627-adf4-bcbd1f364603")
    List<SmObjectImpl> mTemplateInstanciation = null;

    @objid ("50a50a46-9946-49cb-9f2b-d30084b85703")
    SmObjectImpl mOwner;

    @objid ("9a371839-8963-413a-90bd-bc6cbe2869a3")
    List<SmObjectImpl> mOwnedPackageImport = null;

    @objid ("adf78aee-d3f5-4569-b0fb-0f5bb670577f")
    SmObjectImpl mReturn;

    @objid ("f416a4b7-1a10-42a7-947a-d00de9a3d162")
    List<SmObjectImpl> mInstanciatingBinding = null;

    @objid ("f97f09ee-eb07-4675-94ce-d8bce8b30fb6")
    List<SmObjectImpl> mUsage = null;

    @objid ("7b8e6e2d-e063-4f1d-a20f-ab4eacbba4e8")
    List<SmObjectImpl> mTemplate = null;

    @objid ("bb217fef-c9eb-4ffa-bbcb-3521bfa2dd98")
    List<SmObjectImpl> mOccurence = null;

    @objid ("74d885cb-8a98-4810-88dd-b5c9c3f66aa6")
    List<SmObjectImpl> mInvoker = null;

    @objid ("1afc60e8-6a1e-4251-86ab-53ae7b90bd1a")
    List<SmObjectImpl> mCommunicationUsage = null;

    @objid ("f06068b7-000d-47a6-8f2f-8a627a71463c")
    List<SmObjectImpl> mOwnedCollaborationUse = null;

    @objid ("16ba5074-072c-4f1d-ad9a-e421ca013b7d")
    SmObjectImpl mRedefines;

    @objid ("243bd424-d179-4a31-8578-30ef06b6ea32")
    List<SmObjectImpl> mCallingAction = null;

    @objid ("cd027d6d-cc55-442e-bcf4-427fc959be0d")
    List<SmObjectImpl> mEntryPointAction = null;

    @objid ("876282c7-f9e6-41b7-86bd-fe2301a3325b")
    public OperationData(OperationSmClass smClass) {
        super(smClass);
    }

}

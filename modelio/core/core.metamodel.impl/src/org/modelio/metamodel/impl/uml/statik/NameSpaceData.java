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
import org.modelio.metamodel.impl.uml.infrastructure.ModelTreeData;
import org.modelio.metamodel.uml.statik.VisibilityMode;
import org.modelio.vcore.smkernel.SmObjectImpl;

@objid ("0011d8de-c4bf-1fd8-97fe-001ec947cd2a")
public abstract class NameSpaceData extends ModelTreeData {
    @objid ("4c366a2c-cf98-4933-9ef3-090d3e2117ac")
    Object mIsAbstract = false;

    @objid ("4c6d5dc8-073b-4c05-a151-7cfa1414a483")
    Object mIsLeaf = false;

    @objid ("932b2dbb-939c-4010-8c43-6cb5e09c6ab2")
    Object mIsRoot = false;

    @objid ("1d17b7eb-3966-4cb2-8c0f-1ee6c242d665")
    Object mVisibility = VisibilityMode.PUBLIC;

    @objid ("c08d2272-c17a-44e0-85b2-93c9d03ef85b")
    List<SmObjectImpl> mParent = null;

    @objid ("06589377-3041-4a18-89ca-a307381955fb")
    List<SmObjectImpl> mTemplateInstanciation = null;

    @objid ("65d3f327-598e-4bf1-a874-fa2340d8c9dd")
    List<SmObjectImpl> mRepresenting = null;

    @objid ("6305b92a-fbcb-4b56-9dea-aa1250c1f0fa")
    List<SmObjectImpl> mOwnedBehavior = null;

    @objid ("640cbeab-d1c3-4141-bd5c-0158487579df")
    List<SmObjectImpl> mReceived = null;

    @objid ("8b1aa487-f629-462c-97e8-4ade7e545f54")
    List<SmObjectImpl> mOwnedInformationFlow = null;

    @objid ("3a9e3462-2f55-4b8c-9d61-3763baf209ca")
    List<SmObjectImpl> mImporting = null;

    @objid ("9d11a955-c138-478a-97c8-0cadaef0dc84")
    List<SmObjectImpl> mSent = null;

    @objid ("426c71f0-81bc-4996-8d5e-bb5036c75667")
    List<SmObjectImpl> mOwnedDataFlow = null;

    @objid ("09d6a6c4-5992-4643-80be-828a79e6ba64")
    List<SmObjectImpl> mOwnedCollaborationUse = null;

    @objid ("1d50993e-8e10-4248-808f-bd4052c1bdfb")
    List<SmObjectImpl> mOwnedPackageImport = null;

    @objid ("7228f81b-e95c-48e3-891a-bb4b2a8bd791")
    List<SmObjectImpl> mTemplate = null;

    @objid ("67532f8b-b0b0-49a2-8164-4013b1e92e7a")
    List<SmObjectImpl> mSpecialization = null;

    @objid ("781a54aa-d1ed-4d79-ac33-ced15ffe9834")
    List<SmObjectImpl> mRealized = null;

    @objid ("fdc940d8-752c-488d-a681-edc8d6892d42")
    List<SmObjectImpl> mDeclared = null;

    @objid ("33e22c74-8dfa-488a-8167-7fc7a66b5db4")
    List<SmObjectImpl> mInstanciatingBinding = null;

    @objid ("ab541c7e-6516-44ef-85c5-ed54401664ff")
    List<SmObjectImpl> mOwnedImport = null;

    @objid ("df956165-1ae0-4645-a48d-1a840d6b77c0")
    public NameSpaceData(NameSpaceSmClass smClass) {
        super(smClass);
    }

}

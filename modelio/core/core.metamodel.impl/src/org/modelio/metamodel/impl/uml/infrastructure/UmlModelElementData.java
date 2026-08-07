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
import org.modelio.metamodel.impl.uml.infrastructure.ModelElementData;
import org.modelio.vcore.smkernel.SmObjectImpl;

@objid ("06d4c303-2a06-4de8-93bd-bffe6eb88449")
public class UmlModelElementData extends ModelElementData {
    @objid ("264ed8e3-b13f-438b-89d0-418616f7756f")
    List<SmObjectImpl> mTemplateSubstitution = null;

    @objid ("6bc20ea5-5893-4b77-aaf4-46f87bb5787c")
    List<SmObjectImpl> mDefaultParametering = null;

    @objid ("c1d80fda-7284-4430-b596-17959376eb0e")
    List<SmObjectImpl> mRepresents = null;

    @objid ("85d52679-8e34-49d4-b9c0-9eeb7d3f5e48")
    SmObjectImpl mOwnerTemplateParameter;

    @objid ("393d8e33-a2cc-4257-a750-f8209624d43a")
    List<SmObjectImpl> mRepresentingEnd = null;

    @objid ("11adecbf-f2c3-4f17-b0fb-b9bc2a7b50b9")
    List<SmObjectImpl> mRepresentingPartition = null;

    @objid ("bd2f3b9f-9476-4b87-a757-cd9c0c9546f5")
    List<SmObjectImpl> mConstraintDefinition = null;

    @objid ("2aba34d0-4a9b-4b96-9c2b-deab46b08558")
    List<SmObjectImpl> mTypingParameter = null;

    @objid ("bc764a6b-a5db-4256-9dd8-a16ffe327ca7")
    List<SmObjectImpl> mManifesting = null;

    @objid ("d653e1ef-98d2-45ec-883d-00062e6ddc15")
    List<SmObjectImpl> mRepresentingInstance = null;

    @objid ("f3af60f9-af26-4025-a00e-9485e913719d")
    List<SmObjectImpl> mReceivedInfo = null;

    @objid ("907ff4e9-0e86-4a1e-919c-d6fe7af0ce3c")
    List<SmObjectImpl> mSentInfo = null;

    @objid ("c4ddb2be-b12b-4efb-a109-55dc2de43ed8")
    List<SmObjectImpl> mRepresentingConnector = null;

    @objid ("56a0dc21-ec4f-420d-9120-554b26cfea4e")
    public UmlModelElementData(UmlModelElementSmClass smClass) {
        super(smClass);
    }

}

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

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.impl.uml.infrastructure.UmlModelElementData;
import org.modelio.vcore.smkernel.SmObjectImpl;

@objid ("00768072-17e8-10a1-88a0-001ec947cd2a")
public class NaryLinkEndData extends UmlModelElementData {
    @objid ("c64998af-be72-4c52-b25b-0c281c27361e")
    Object mIsOrdered = false;

    @objid ("2146284c-256c-4ceb-8f90-202205410340")
    Object mIsUnique = false;

    @objid ("405df98c-f4fa-481f-a47b-cdb375e7aee8")
    Object mMultiplicityMax = "1";

    @objid ("18dcbb3a-014c-49bc-bdfc-88d549b5ddb4")
    Object mMultiplicityMin = "0";

    @objid ("4918d08d-7558-425f-a65f-a9c41e91ef8f")
    SmObjectImpl mSource;

    @objid ("1b897489-ad0f-4d4d-908f-711727e2d110")
    SmObjectImpl mNaryLink;

    @objid ("f4f50bdf-8d99-47b9-853f-5040038fe5f7")
    SmObjectImpl mConsumer;

    @objid ("f1f4114c-1b59-43b7-a6c6-14939ea30680")
    SmObjectImpl mProvider;

    @objid ("950dc341-8e52-46d4-8456-fe7a21fd2ac3")
    public NaryLinkEndData(NaryLinkEndSmClass smClass) {
        super(smClass);
    }

}

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
package org.modelio.metamodel.impl.uml.behavior.interactionModel;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.impl.uml.infrastructure.UmlModelElementData;
import org.modelio.vcore.smkernel.SmObjectImpl;

@objid ("0047676a-c4bf-1fd8-97fe-001ec947cd2a")
public abstract class InteractionFragmentData extends UmlModelElementData {
    @objid ("96f3e62b-8d57-4b63-8890-ac99d7655e7f")
    Object mLineNumber = -1;

    @objid ("bc7649da-3ab2-4009-a1ad-3216a251e75b")
    SmObjectImpl mEnclosingOperand;

    @objid ("4fb0af4f-c4b6-465b-a661-5e3b93ca978d")
    SmObjectImpl mEnclosingInteraction;

    @objid ("9da03dc9-ebf7-4e7d-866f-ac8fd4502781")
    List<SmObjectImpl> mCovered = null;

    @objid ("e61152f5-e139-41fd-ae1a-3dd102d12c39")
    public InteractionFragmentData(InteractionFragmentSmClass smClass) {
        super(smClass);
    }

}

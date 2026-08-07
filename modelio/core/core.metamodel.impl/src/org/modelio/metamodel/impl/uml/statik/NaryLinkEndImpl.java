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

import java.util.ArrayList;
import java.util.Collections;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.impl.uml.infrastructure.UmlModelElementImpl;
import org.modelio.metamodel.uml.statik.Instance;
import org.modelio.metamodel.uml.statik.NaryLink;
import org.modelio.metamodel.uml.statik.NaryLinkEnd;
import org.modelio.metamodel.uml.statik.ProvidedInterface;
import org.modelio.metamodel.uml.statik.RequiredInterface;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("0075d726-17e8-10a1-88a0-001ec947cd2a")
public class NaryLinkEndImpl extends UmlModelElementImpl implements NaryLinkEnd {
    @objid ("43fdc572-2641-435d-90c1-b989511fc653")
    @Override
    public boolean isIsOrdered() {
        return (Boolean) getAttVal(((NaryLinkEndSmClass)getClassOf()).getIsOrderedAtt());
    }

    @objid ("daa4312a-972d-494c-81fa-9b1bfcee0eff")
    @Override
    public void setIsOrdered(boolean value) {
        setAttVal(((NaryLinkEndSmClass)getClassOf()).getIsOrderedAtt(), value);
    }

    @objid ("3f127255-4256-428e-8fd7-2711263c950f")
    @Override
    public boolean isIsUnique() {
        return (Boolean) getAttVal(((NaryLinkEndSmClass)getClassOf()).getIsUniqueAtt());
    }

    @objid ("b008498d-c45f-4f59-ab7c-0270e8e9b3a8")
    @Override
    public void setIsUnique(boolean value) {
        setAttVal(((NaryLinkEndSmClass)getClassOf()).getIsUniqueAtt(), value);
    }

    @objid ("b4a52a96-063a-4179-8b70-c95682ec781c")
    @Override
    public String getMultiplicityMax() {
        return (String) getAttVal(((NaryLinkEndSmClass)getClassOf()).getMultiplicityMaxAtt());
    }

    @objid ("f70092af-e362-49ec-be1c-7e8d6f61dabb")
    @Override
    public void setMultiplicityMax(String value) {
        setAttVal(((NaryLinkEndSmClass)getClassOf()).getMultiplicityMaxAtt(), value);
    }

    @objid ("ee2afb37-4478-44f4-82a0-bc277463aafe")
    @Override
    public String getMultiplicityMin() {
        return (String) getAttVal(((NaryLinkEndSmClass)getClassOf()).getMultiplicityMinAtt());
    }

    @objid ("654a01db-66c5-4a91-b58d-b93d4d22d21f")
    @Override
    public void setMultiplicityMin(String value) {
        setAttVal(((NaryLinkEndSmClass)getClassOf()).getMultiplicityMinAtt(), value);
    }

    @objid ("d2d15e29-63d5-4ac3-8856-1447b441ef37")
    @Override
    public Instance getSource() {
        Object obj = getDepVal(((NaryLinkEndSmClass)getClassOf()).getSourceDep());
        return (obj instanceof Instance)? (Instance)obj : null;
    }

    @objid ("1df49e3d-0ade-4d88-9c04-a8ee3291d2ac")
    @Override
    public void setSource(Instance value) {
        appendDepVal(((NaryLinkEndSmClass)getClassOf()).getSourceDep(), (SmObjectImpl)value);
    }

    @objid ("50b080a0-e42c-400d-87a1-8eccc9da7070")
    @Override
    public NaryLink getNaryLink() {
        Object obj = getDepVal(((NaryLinkEndSmClass)getClassOf()).getNaryLinkDep());
        return (obj instanceof NaryLink)? (NaryLink)obj : null;
    }

    @objid ("3419e7f9-dcf3-4476-8c70-3bf8f9cbe8b5")
    @Override
    public void setNaryLink(NaryLink value) {
        appendDepVal(((NaryLinkEndSmClass)getClassOf()).getNaryLinkDep(), (SmObjectImpl)value);
    }

    @objid ("d708cf23-89e1-426f-bbb2-0d4968379f97")
    @Override
    public RequiredInterface getConsumer() {
        Object obj = getDepVal(((NaryLinkEndSmClass)getClassOf()).getConsumerDep());
        return (obj instanceof RequiredInterface)? (RequiredInterface)obj : null;
    }

    @objid ("8f73e3b6-01ba-4884-9752-8db3379e7436")
    @Override
    public void setConsumer(RequiredInterface value) {
        appendDepVal(((NaryLinkEndSmClass)getClassOf()).getConsumerDep(), (SmObjectImpl)value);
    }

    @objid ("2a4c1e84-538b-4f79-8422-247d0a012ac3")
    @Override
    public ProvidedInterface getProvider() {
        Object obj = getDepVal(((NaryLinkEndSmClass)getClassOf()).getProviderDep());
        return (obj instanceof ProvidedInterface)? (ProvidedInterface)obj : null;
    }

    @objid ("5dc6ae15-2bfb-4bce-a7bc-6b4aa403aba8")
    @Override
    public void setProvider(ProvidedInterface value) {
        appendDepVal(((NaryLinkEndSmClass)getClassOf()).getProviderDep(), (SmObjectImpl)value);
    }

    @objid ("45b9cd73-2659-4747-bfe3-63c7bbad7162")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        // Source
        obj = (SmObjectImpl)this.getDepVal(((NaryLinkEndSmClass)getClassOf()).getSourceDep());
        if (obj != null)
          return obj;
        // NaryLink
        obj = (SmObjectImpl)this.getDepVal(((NaryLinkEndSmClass)getClassOf()).getNaryLinkDep());
        if (obj != null)
          return obj;
        return super.getCompositionOwner();
    }

    @objid ("767318e0-a8d5-434a-a131-5b94458a761e")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        // Source
        dep = ((NaryLinkEndSmClass)getClassOf()).getSourceDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        // NaryLink
        dep = ((NaryLinkEndSmClass)getClassOf()).getNaryLinkDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        return super.getCompositionRelation();
    }

    @objid ("a5c99007-1191-4011-84ed-edae47867e68")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitNaryLinkEnd(this);
    }

}

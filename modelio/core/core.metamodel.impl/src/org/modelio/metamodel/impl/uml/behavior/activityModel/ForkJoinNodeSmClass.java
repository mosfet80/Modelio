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
package org.modelio.metamodel.impl.uml.behavior.activityModel;

import java.util.ArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.uml.behavior.activityModel.ControlNode;
import org.modelio.metamodel.uml.behavior.activityModel.ForkJoinNode;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmAttribute;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("1ebe4134-991e-4e1c-8bb0-d1db7d1d2e79")
public class ForkJoinNodeSmClass extends ControlNodeSmClass {
    @objid ("33b06d42-f012-45f1-a50f-f96e0f817b09")
    private SmAttribute isCombineDuplicateAtt;

    @objid ("f789d39e-33d7-4925-9d77-124f27ef3817")
    private SmAttribute joinSpecAtt;

    @objid ("271fd6e6-00dd-4581-99aa-ad9a5dcfe3af")
    public ForkJoinNodeSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("ce8ab632-96f7-41aa-bbaf-af856ded8798")
    @Override
    public String getName() {
        return "ForkJoinNode";

    }

    @objid ("e21c774f-08a6-4b32-b157-918d882bc2a2")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("6c11d579-a174-45a5-859c-755902869e22")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return ForkJoinNode.class;

    }

    @objid ("80da481a-08cd-4b47-b06c-2243d8b12065")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("1d8ee410-95d6-4da7-898a-48da8a6b85de")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("a4fbc8d8-e8b2-4494-853d-ebb6eb132001")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(ControlNode.MQNAME);
        this.registerFactory(new ForkJoinNodeObjectFactory(this));


        // Initialize and register the SmAttribute
        this.isCombineDuplicateAtt = new IsCombineDuplicateSmAttribute();
        this.isCombineDuplicateAtt.init("IsCombineDuplicate", this, Boolean.class );
        registerAttribute(this.isCombineDuplicateAtt);

        this.joinSpecAtt = new JoinSpecSmAttribute();
        this.joinSpecAtt.init("JoinSpec", this, String.class );
        registerAttribute(this.joinSpecAtt);


        // Initialize and register the SmDependency

    }

    @objid ("b11e316c-efb4-46b9-9048-1bc58e0609bb")
    public SmAttribute getIsCombineDuplicateAtt() {
        if (this.isCombineDuplicateAtt == null) {
        	this.isCombineDuplicateAtt = this.getAttributeDef("IsCombineDuplicate");
        }
        return this.isCombineDuplicateAtt;
    }

    @objid ("adc5d846-52cb-4dfd-b774-33e0440c9304")
    public SmAttribute getJoinSpecAtt() {
        if (this.joinSpecAtt == null) {
        	this.joinSpecAtt = this.getAttributeDef("JoinSpec");
        }
        return this.joinSpecAtt;
    }

    @objid ("8a67bf02-5901-4ea1-8437-a05394f707cd")
    private static class ForkJoinNodeObjectFactory implements ISmObjectFactory {
        @objid ("6e419bb9-80e4-492a-aa57-e4c8b447aa27")
        private ForkJoinNodeSmClass smClass;

        @objid ("b27a3eab-58aa-4d60-ae72-b1924b8856a3")
        public ForkJoinNodeObjectFactory(ForkJoinNodeSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("7adea06d-d023-4799-a1a7-a53c0e040c2e")
        @Override
        public ISmObjectData createData() {
            return new ForkJoinNodeData(this.smClass);
        }

        @objid ("afc42d8f-997b-4667-be0d-80d749ba9727")
        @Override
        public SmObjectImpl createImpl() {
            return new ForkJoinNodeImpl();
        }

    }

    @objid ("d49fbc43-b29a-46ff-ba01-70a4a5463023")
    public static class IsCombineDuplicateSmAttribute extends SmAttribute {
        @objid ("21b26fd4-57fb-42e5-a2a0-9100f22c3bcf")
        public Object getValue(ISmObjectData data) {
            return ((ForkJoinNodeData) data).mIsCombineDuplicate;
        }

        @objid ("719555d8-62a5-4b73-92b1-310392baca24")
        public void setValue(ISmObjectData data, Object value) {
            ((ForkJoinNodeData) data).mIsCombineDuplicate = value;
        }

    }

    @objid ("55312577-6cee-43a6-ae49-98a8e88fef7a")
    public static class JoinSpecSmAttribute extends SmAttribute {
        @objid ("cfce8420-4496-4642-8322-68503868655f")
        public Object getValue(ISmObjectData data) {
            return ((ForkJoinNodeData) data).mJoinSpec;
        }

        @objid ("0ea223f1-d6e6-42ba-b507-f88144ad365b")
        public void setValue(ISmObjectData data, Object value) {
            ((ForkJoinNodeData) data).mJoinSpec = value;
        }

    }

}

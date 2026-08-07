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
package org.modelio.metamodel.impl.bpmn.objects;

import java.util.ArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.bpmn.objects.BpmnDataObject;
import org.modelio.metamodel.bpmn.objects.BpmnItemAwareElement;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmAttribute;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("94f227aa-d368-490d-bc78-674fbc48e2a9")
public class BpmnDataObjectSmClass extends BpmnItemAwareElementSmClass {
    @objid ("bf4ce018-eb23-4335-ab8a-bbc700e520bd")
    private SmAttribute isCollectionAtt;

    @objid ("cb8bd958-c511-4cf9-8e68-9e57bbea0484")
    public BpmnDataObjectSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("0f763dde-22f0-4bab-96c2-b746c0cf3308")
    @Override
    public String getName() {
        return "BpmnDataObject";

    }

    @objid ("4bd92dc0-814d-4c56-91bc-70e40256b9bd")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("9dd81541-090a-4922-bcb4-640b179472dc")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return BpmnDataObject.class;

    }

    @objid ("57ed1d7f-0b52-45ea-bfe9-40216967c95f")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("a2282c7c-2f3e-4679-a929-33ac0a838201")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("a3dab809-1f07-4f77-8937-b734ed6f410a")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(BpmnItemAwareElement.MQNAME);
        this.registerFactory(new BpmnDataObjectObjectFactory(this));


        // Initialize and register the SmAttribute
        this.isCollectionAtt = new IsCollectionSmAttribute();
        this.isCollectionAtt.init("IsCollection", this, Boolean.class );
        registerAttribute(this.isCollectionAtt);


        // Initialize and register the SmDependency

    }

    @objid ("7462c61f-1365-4e40-826e-32dbdc4df7aa")
    public SmAttribute getIsCollectionAtt() {
        if (this.isCollectionAtt == null) {
        	this.isCollectionAtt = this.getAttributeDef("IsCollection");
        }
        return this.isCollectionAtt;
    }

    @objid ("63d20614-79e2-4d86-889f-6c059e148fee")
    private static class BpmnDataObjectObjectFactory implements ISmObjectFactory {
        @objid ("ef7cf29b-3e99-41e4-a87d-eb14bebd65dd")
        private BpmnDataObjectSmClass smClass;

        @objid ("ce9171c5-d695-434d-baa5-fe6c2991bb25")
        public BpmnDataObjectObjectFactory(BpmnDataObjectSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("3dca3e15-6e31-4fb7-bfb5-468fefad5410")
        @Override
        public ISmObjectData createData() {
            return new BpmnDataObjectData(this.smClass);
        }

        @objid ("d2eedf86-623d-4c0f-ba8a-f255546af688")
        @Override
        public SmObjectImpl createImpl() {
            return new BpmnDataObjectImpl();
        }

    }

    @objid ("c701cb4f-9f0a-4864-87c4-b5b29e77b188")
    public static class IsCollectionSmAttribute extends SmAttribute {
        @objid ("2c116da5-06c9-4559-b6a2-daade0f1431c")
        public Object getValue(ISmObjectData data) {
            return ((BpmnDataObjectData) data).mIsCollection;
        }

        @objid ("a9e8991e-a5dc-4e51-ac02-488f31271105")
        public void setValue(ISmObjectData data, Object value) {
            ((BpmnDataObjectData) data).mIsCollection = value;
        }

    }

}

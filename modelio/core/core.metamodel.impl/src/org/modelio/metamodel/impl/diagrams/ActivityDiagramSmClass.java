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
package org.modelio.metamodel.impl.diagrams;

import java.util.ArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.diagrams.ActivityDiagram;
import org.modelio.metamodel.diagrams.BehaviorDiagram;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmAttribute;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("61ba724d-091b-4b0f-91b3-0545ad0201cc")
public class ActivityDiagramSmClass extends BehaviorDiagramSmClass {
    @objid ("6070bd6d-9841-461b-b724-511a0c51b3b5")
    private SmAttribute isVerticalAtt;

    @objid ("2c67206b-2d19-4c38-ba1c-c8dbd859aeef")
    public ActivityDiagramSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("751e6b6c-322b-4048-9f4f-c5c256c90990")
    @Override
    public String getName() {
        return "ActivityDiagram";

    }

    @objid ("0e7e441f-49dd-4626-8ebc-36eeaa62339b")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("66f23a6b-9bce-416f-96c2-159491cb9cb5")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return ActivityDiagram.class;

    }

    @objid ("6f5378e1-6efb-4e94-aef2-01776ef19d39")
    @Override
    public boolean isCmsNode() {
        return true;

    }

    @objid ("9ec6019f-b24f-4368-9e5f-5457df003d24")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("1f7fa519-96ee-4647-be96-66d7af0db745")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(BehaviorDiagram.MQNAME);
        this.registerFactory(new ActivityDiagramObjectFactory(this));


        // Initialize and register the SmAttribute
        this.isVerticalAtt = new IsVerticalSmAttribute();
        this.isVerticalAtt.init("IsVertical", this, Boolean.class );
        registerAttribute(this.isVerticalAtt);


        // Initialize and register the SmDependency

    }

    @objid ("61ed41e7-ea03-4943-950c-278afbf4c0a6")
    public SmAttribute getIsVerticalAtt() {
        if (this.isVerticalAtt == null) {
        	this.isVerticalAtt = this.getAttributeDef("IsVertical");
        }
        return this.isVerticalAtt;
    }

    @objid ("5db99d36-7099-4938-b022-e5259eda69e4")
    private static class ActivityDiagramObjectFactory implements ISmObjectFactory {
        @objid ("27110c7c-ba65-4ac8-9788-c874120555e9")
        private ActivityDiagramSmClass smClass;

        @objid ("c8080c39-7050-4c0e-b723-447b718661c6")
        public ActivityDiagramObjectFactory(ActivityDiagramSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("5c1d61cd-c266-4f43-bbd9-7fa4a0ec6c24")
        @Override
        public ISmObjectData createData() {
            return new ActivityDiagramData(this.smClass);
        }

        @objid ("768b7a8e-ead5-4c44-bf51-e7b68f6b02ef")
        @Override
        public SmObjectImpl createImpl() {
            return new ActivityDiagramImpl();
        }

    }

    @objid ("68da4ff7-5b70-42e1-b6fe-c54fd787a986")
    public static class IsVerticalSmAttribute extends SmAttribute {
        @objid ("498d0f98-ebc7-49b4-92af-750e070fb96e")
        public Object getValue(ISmObjectData data) {
            return ((ActivityDiagramData) data).mIsVertical;
        }

        @objid ("e327915a-8528-46f3-87aa-a0825fd37c2a")
        public void setValue(ISmObjectData data, Object value) {
            ((ActivityDiagramData) data).mIsVertical = value;
        }

    }

}

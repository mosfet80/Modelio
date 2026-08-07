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
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.uml.statik.Artifact;
import org.modelio.metamodel.uml.statik.Classifier;
import org.modelio.metamodel.uml.statik.Node;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmDependency;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.SmMultipleDependency;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("59646a2c-a1d3-48dc-b061-9200708cc332")
public class NodeSmClass extends ClassifierSmClass {
    @objid ("27e15b73-7edd-4c10-b8b4-07f52a13f556")
    private SmDependency residentDep;

    @objid ("dbde99a0-98a5-47c3-9646-ca560c5e4dc4")
    public NodeSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("bd6a22ca-eb64-4479-8018-6c736037337a")
    @Override
    public String getName() {
        return "Node";

    }

    @objid ("2616b6dc-5aef-4729-b050-5fd9c1fbf443")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("ce0d6101-866f-4d88-b700-2db6664bd924")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return Node.class;

    }

    @objid ("7c92ec7c-933b-4780-a5de-ea0b7b7111f5")
    @Override
    public boolean isCmsNode() {
        return true;

    }

    @objid ("b081dd04-e54a-426a-97cf-505491f007f1")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("bf965d17-6584-4df2-8a0b-f258a9ac4b2a")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(Classifier.MQNAME);
        this.registerFactory(new NodeObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency
        this.residentDep = new ResidentSmDependency();
        this.residentDep.init("Resident", this, metamodel.getMClass(Artifact.MQNAME), 0, -1 , SmDirective.SMCDPARTOF);
        registerDependency(this.residentDep);

    }

    @objid ("61cf9a6b-2b6f-4e01-bf44-bd07f8ca01f5")
    public SmDependency getResidentDep() {
        if (this.residentDep == null) {
        	this.residentDep = this.getDependencyDef("Resident");
        }
        return this.residentDep;
    }

    @objid ("c950b822-9710-41c4-b49b-0134275175e8")
    private static class NodeObjectFactory implements ISmObjectFactory {
        @objid ("2d3ed2c6-d751-4a7c-a0ce-46879d4b7c71")
        private NodeSmClass smClass;

        @objid ("a92df787-534f-4715-b52f-10223797d977")
        public NodeObjectFactory(NodeSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("75572fe2-f881-4f9d-8f64-cea521cfc767")
        @Override
        public ISmObjectData createData() {
            return new NodeData(this.smClass);
        }

        @objid ("68b36dc0-12b7-4292-b4fc-8188c4ccb0cf")
        @Override
        public SmObjectImpl createImpl() {
            return new NodeImpl();
        }

    }

    @objid ("817fd4d7-b247-4f17-9352-e74d98b7ae54")
    public static class ResidentSmDependency extends SmMultipleDependency {
        @objid ("2245bc8f-de65-447d-9094-3e0b05cea113")
        private SmDependency symetricDep;

        @objid ("2d530722-81a9-478e-a20f-3dbc0db94199")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((NodeData)data).mResident != null)? ((NodeData)data).mResident:SmMultipleDependency.EMPTY;
        }

        @objid ("ac29308a-e454-4854-9899-99a2c42674d5")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((NodeData) data).mResident = values;

        }

        @objid ("570a2888-97e1-44a7-b633-7fb56414ea07")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((ArtifactSmClass)this.getTarget()).getDeploymentLocationDep();
            }
            return this.symetricDep;

        }

    }

}

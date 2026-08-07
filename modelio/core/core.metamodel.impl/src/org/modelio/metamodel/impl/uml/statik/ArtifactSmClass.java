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
import org.modelio.metamodel.uml.statik.Manifestation;
import org.modelio.metamodel.uml.statik.Node;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmAttribute;
import org.modelio.vcore.smkernel.meta.SmDependency;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.SmMultipleDependency;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("1cf1c572-23cc-4aa8-b86c-f4409fc31cba")
public class ArtifactSmClass extends ClassifierSmClass {
    @objid ("4a515f55-c0fc-420b-ac72-babb11b04fae")
    private SmAttribute fileNameAtt;

    @objid ("c4ebe457-a006-4e24-9f39-4c5a46dacc90")
    private SmDependency utilizedDep;

    @objid ("8cf48172-671e-4af6-a1a6-185197a783c1")
    private SmDependency deploymentLocationDep;

    @objid ("4c6271bb-8f7f-4c95-9312-1a1548f1544b")
    public ArtifactSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("71bb8a2a-31b4-4807-a90a-dd329b1f40b7")
    @Override
    public String getName() {
        return "Artifact";

    }

    @objid ("c4aa5224-7a9d-43aa-9fc8-ca9b98d116c6")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("78c7a2cd-d24a-4d2b-8e12-9c5fb4fdca76")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return Artifact.class;

    }

    @objid ("b4fecfad-c3d2-49a5-9ad8-f1c669d67fb6")
    @Override
    public boolean isCmsNode() {
        return true;

    }

    @objid ("814d032c-86eb-4416-be66-8b8f69914c58")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("8518b2f3-e506-4782-9e3e-3d53a3c58b58")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(Classifier.MQNAME);
        this.registerFactory(new ArtifactObjectFactory(this));


        // Initialize and register the SmAttribute
        this.fileNameAtt = new FileNameSmAttribute();
        this.fileNameAtt.init("FileName", this, String.class );
        registerAttribute(this.fileNameAtt);


        // Initialize and register the SmDependency
        this.utilizedDep = new UtilizedSmDependency();
        this.utilizedDep.init("Utilized", this, metamodel.getMClass(Manifestation.MQNAME), 0, -1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.utilizedDep);

        this.deploymentLocationDep = new DeploymentLocationSmDependency();
        this.deploymentLocationDep.init("DeploymentLocation", this, metamodel.getMClass(Node.MQNAME), 0, -1 );
        registerDependency(this.deploymentLocationDep);

    }

    @objid ("90f17459-9951-44b5-a083-6e99e3d6d2fd")
    public SmAttribute getFileNameAtt() {
        if (this.fileNameAtt == null) {
        	this.fileNameAtt = this.getAttributeDef("FileName");
        }
        return this.fileNameAtt;
    }

    @objid ("b6c838fe-1e75-4c22-b18e-7bc9111f22f0")
    public SmDependency getUtilizedDep() {
        if (this.utilizedDep == null) {
        	this.utilizedDep = this.getDependencyDef("Utilized");
        }
        return this.utilizedDep;
    }

    @objid ("d2fcb5a8-f98a-4e49-b3ba-3320f377f2c7")
    public SmDependency getDeploymentLocationDep() {
        if (this.deploymentLocationDep == null) {
        	this.deploymentLocationDep = this.getDependencyDef("DeploymentLocation");
        }
        return this.deploymentLocationDep;
    }

    @objid ("0d1b5320-12c1-4d07-af17-653f95fa2fcb")
    private static class ArtifactObjectFactory implements ISmObjectFactory {
        @objid ("b88d9358-b26e-4478-a2e5-d886592d8e04")
        private ArtifactSmClass smClass;

        @objid ("575939e1-8f21-498b-b3c1-ecedc0532aee")
        public ArtifactObjectFactory(ArtifactSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("65062421-f4a8-4498-b414-09b9cb605f9c")
        @Override
        public ISmObjectData createData() {
            return new ArtifactData(this.smClass);
        }

        @objid ("5375269f-ad6b-4cad-aa4b-033a4171f8ad")
        @Override
        public SmObjectImpl createImpl() {
            return new ArtifactImpl();
        }

    }

    @objid ("7c2dfdbc-5877-4c03-8170-7fbb981ca50b")
    public static class FileNameSmAttribute extends SmAttribute {
        @objid ("936c76ec-015e-46e8-8c92-8bb61e3beafa")
        public Object getValue(ISmObjectData data) {
            return ((ArtifactData) data).mFileName;
        }

        @objid ("74561da4-7822-4431-931a-a223dbbb6093")
        public void setValue(ISmObjectData data, Object value) {
            ((ArtifactData) data).mFileName = value;
        }

    }

    @objid ("09817731-f7c3-4681-a606-9acfceade331")
    public static class UtilizedSmDependency extends SmMultipleDependency {
        @objid ("36a61d51-29e0-4a20-8f1a-211ac707a663")
        private SmDependency symetricDep;

        @objid ("0b216447-b37f-4236-8042-c16dd3d51186")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((ArtifactData)data).mUtilized != null)? ((ArtifactData)data).mUtilized:SmMultipleDependency.EMPTY;
        }

        @objid ("e070ee27-7cfb-4a8f-b480-365c68237f4b")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((ArtifactData) data).mUtilized = values;

        }

        @objid ("2875ba19-3f22-4727-b775-1f33fa8a2863")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((ManifestationSmClass)this.getTarget()).getOwnerDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("c52ee089-d7f5-4362-8ff0-6bed938a7e0d")
    public static class DeploymentLocationSmDependency extends SmMultipleDependency {
        @objid ("15a7f42b-7c66-4473-827f-7f2b99875e25")
        private SmDependency symetricDep;

        @objid ("4579617e-7b05-430b-930a-b43b1235c0cf")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((ArtifactData)data).mDeploymentLocation != null)? ((ArtifactData)data).mDeploymentLocation:SmMultipleDependency.EMPTY;
        }

        @objid ("608a633e-f10f-4bd3-bfb8-a3203968f74c")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((ArtifactData) data).mDeploymentLocation = values;

        }

        @objid ("9070b4f9-b660-4b0b-8c2d-a13d1d3a73d9")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((NodeSmClass)this.getTarget()).getResidentDep();
            }
            return this.symetricDep;

        }

    }

}

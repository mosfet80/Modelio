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
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.impl.uml.infrastructure.UmlModelElementSmClass;
import org.modelio.metamodel.uml.infrastructure.UmlModelElement;
import org.modelio.metamodel.uml.statik.Artifact;
import org.modelio.metamodel.uml.statik.Manifestation;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmDependency;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.SmSingleDependency;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("4f4fd4c5-a171-4fa9-899d-85c75ae4e972")
public class ManifestationSmClass extends UmlModelElementSmClass {
    @objid ("71950e59-2c23-4235-9d73-8d9977fed38c")
    private SmDependency utilizedElementDep;

    @objid ("5c6f6982-4338-4ac9-8b90-2f759520d999")
    private SmDependency ownerDep;

    @objid ("703bea03-962f-452f-ac31-2aa8b55a8fc7")
    public ManifestationSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("cc1a847a-7bb7-4bef-b18c-85c23edd9f53")
    @Override
    public String getName() {
        return "Manifestation";

    }

    @objid ("a5e29f0a-3758-4c50-9eaf-3e2acb259da2")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("cb8d34a2-f028-44e6-a54c-7d913e3757e9")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return Manifestation.class;

    }

    @objid ("b8e512be-528b-4737-9c8e-6f0908965cc2")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("1e657f06-c101-4b34-8931-fb5b0fe2143e")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("8d2015f6-8545-493f-9f0c-4e94aa970b76")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(UmlModelElement.MQNAME);
        this.registerFactory(new ManifestationObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency
        this.utilizedElementDep = new UtilizedElementSmDependency();
        this.utilizedElementDep.init("UtilizedElement", this, metamodel.getMClass(UmlModelElement.MQNAME), 1, 1 , SmDirective.SMCDLINKTARGET, SmDirective.SMCDPARTOF);
        registerDependency(this.utilizedElementDep);

        this.ownerDep = new OwnerSmDependency();
        this.ownerDep.init("Owner", this, metamodel.getMClass(Artifact.MQNAME), 1, 1 , SmDirective.SMCDLINKSOURCE);
        registerDependency(this.ownerDep);

    }

    @objid ("d7ff1b3e-0605-4aa4-83fa-3e1012c53493")
    public SmDependency getUtilizedElementDep() {
        if (this.utilizedElementDep == null) {
        	this.utilizedElementDep = this.getDependencyDef("UtilizedElement");
        }
        return this.utilizedElementDep;
    }

    @objid ("edc329dd-b5d0-40c5-b6ee-c58163d97cf1")
    public SmDependency getOwnerDep() {
        if (this.ownerDep == null) {
        	this.ownerDep = this.getDependencyDef("Owner");
        }
        return this.ownerDep;
    }

    @objid ("036d80f9-1d9c-4cde-a5b4-eb2f613903b8")
    @Override
    public boolean isLinkMetaclass() {
        return true;

    }

    @objid ("ec781bc6-b111-4eaa-bb35-03c5bfc49845")
    private static class ManifestationObjectFactory implements ISmObjectFactory {
        @objid ("7972466a-e607-45fb-96c8-d45535149bba")
        private ManifestationSmClass smClass;

        @objid ("2d0eb9ff-8b03-41e1-8f0b-7e8b25057974")
        public ManifestationObjectFactory(ManifestationSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("1dafdd2c-b874-4e9d-8e69-70e632a019d7")
        @Override
        public ISmObjectData createData() {
            return new ManifestationData(this.smClass);
        }

        @objid ("c336eec0-acd3-4bfa-b48e-09f704e4f1f7")
        @Override
        public SmObjectImpl createImpl() {
            return new ManifestationImpl();
        }

    }

    @objid ("7f539b62-4e7f-4509-81d1-f3f73f6973b8")
    public static class UtilizedElementSmDependency extends SmSingleDependency {
        @objid ("2dbdd36f-8bd5-47c6-9b44-3e30b2cb1be0")
        private SmDependency symetricDep;

        @objid ("ed1cdd44-e731-4c55-92b7-2443512c7d7d")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((ManifestationData) data).mUtilizedElement;
        }

        @objid ("cbfac6b2-96b5-49c0-94c9-d5c40311f5b1")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((ManifestationData) data).mUtilizedElement = value;
        }

        @objid ("51e4648a-f9af-4607-8172-bc6821a43b6e")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((UmlModelElementSmClass)this.getTarget()).getManifestingDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("e6a86151-286b-49e0-a62e-62ccc2cdef1d")
    public static class OwnerSmDependency extends SmSingleDependency {
        @objid ("a57a620b-20d5-4c6d-9f41-b72fd8022ac0")
        private SmDependency symetricDep;

        @objid ("9118fb94-81fb-4a5b-80f7-a8909de28927")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((ManifestationData) data).mOwner;
        }

        @objid ("8df3f44c-b19d-4aef-885e-1abf64237829")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((ManifestationData) data).mOwner = value;
        }

        @objid ("bf2032b4-c44b-43c8-a855-021013f2422f")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((ArtifactSmClass)this.getTarget()).getUtilizedDep();
            }
            return this.symetricDep;

        }

    }

}

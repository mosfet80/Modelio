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
     Metamodel: Archimate, version 1.0.4, by Modeliosoft
     Generator version: 3.14.00
     Generated on: Feb 9, 2023
*/
package org.modelio.archimate.metamodel.impl.relationships.other;

import java.util.ArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.core.RelationshipConnector;
import org.modelio.archimate.metamodel.impl.core.RelationshipConnectorSmClass;
import org.modelio.archimate.metamodel.relationships.other.Junction;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("ff3a6368-6fe3-4ef0-9af3-29abad40bb5f")
public class JunctionSmClass extends RelationshipConnectorSmClass {
    @objid ("f157dcd7-b725-412d-9a10-17c926d6abe9")
    public JunctionSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("5a9cea90-0efa-4157-809c-da79cd9a9c49")
    @Override
    public String getName() {
        return "Junction";

    }

    @objid ("5e94e153-ae92-4e30-a4dc-7d3fd6f0afaf")
    @Override
    public Version getVersion() {
        return new Version("0.0.0");
    }

    @objid ("a508eebe-4e9f-4d56-8a6f-51970e40e257")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return Junction.class;

    }

    @objid ("55a8683d-40f4-424d-9f3a-a7ea9ba74e8f")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("950811e1-637f-4d17-adad-36de60ef9b15")
    @Override
    public boolean isAbstract() {
        return true;

    }

    @objid ("3e45b09a-1124-4122-b4d1-abc65b8446b4")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(RelationshipConnector.MQNAME);
        this.registerFactory(new JunctionObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("604c9343-2df0-4920-9ca1-08c7be81715d")
    private static class JunctionObjectFactory implements ISmObjectFactory {
        @objid ("5d505917-1e00-4acf-b15c-19b875e05bf9")
        private JunctionSmClass smClass;

        @objid ("dfcb12bc-76a4-4fff-8b3e-0c57af14badf")
        public JunctionObjectFactory(JunctionSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("81ec067f-2ac2-4ee4-ac9e-1c2ff91b4dc5")
        @Override
        public ISmObjectData createData() {
            throw new UnsupportedOperationException();
        }

        @objid ("b5e2924a-f829-401d-8b81-88d9f0e199bd")
        @Override
        public SmObjectImpl createImpl() {
            throw new UnsupportedOperationException();
        }

    }

}

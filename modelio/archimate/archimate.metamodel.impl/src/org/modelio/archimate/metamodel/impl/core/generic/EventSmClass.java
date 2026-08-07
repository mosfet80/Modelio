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
package org.modelio.archimate.metamodel.impl.core.generic;

import java.util.ArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.core.generic.BehaviorElement;
import org.modelio.archimate.metamodel.core.generic.Event;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmAttribute;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("2785a4d1-1657-4b36-83df-3ecd1e0234bf")
public class EventSmClass extends BehaviorElementSmClass {
    @objid ("982297ad-877f-43ec-a091-ae92e526d23c")
    private SmAttribute timeAtt;

    @objid ("60a2f80e-0228-41da-9aea-06bdb9a3835e")
    public EventSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("6f87a60a-f9bd-4c5a-baf7-651e047241e0")
    @Override
    public String getName() {
        return "Event";

    }

    @objid ("d5ae8dcd-4837-48b8-8ec9-8a1a259550a0")
    @Override
    public Version getVersion() {
        return new Version("0.0.0");
    }

    @objid ("02d8f077-b37f-42a5-9d4c-1488f2809f0b")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return Event.class;

    }

    @objid ("0484537a-7b7c-4321-b7ad-d53dec839a46")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("cc23430e-10d2-4d54-b21b-afed8113d39b")
    @Override
    public boolean isAbstract() {
        return true;

    }

    @objid ("e1b54033-1f59-4920-b11d-c3fc5db52da0")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(BehaviorElement.MQNAME);
        this.registerFactory(new EventObjectFactory(this));


        // Initialize and register the SmAttribute
        this.timeAtt = new TimeSmAttribute();
        this.timeAtt.init("Time", this, String.class );
        registerAttribute(this.timeAtt);


        // Initialize and register the SmDependency

    }

    @objid ("52cdbaea-823a-4157-8b1f-cbd5b9af3570")
    public SmAttribute getTimeAtt() {
        if (this.timeAtt == null) {
        	this.timeAtt = this.getAttributeDef("Time");
        }
        return this.timeAtt;
    }

    @objid ("3547d9ce-0dff-4ed0-b785-d2577ea44f5c")
    private static class EventObjectFactory implements ISmObjectFactory {
        @objid ("90375987-68b5-4876-9029-b1af0b61b1f5")
        private EventSmClass smClass;

        @objid ("ada96a99-ec61-4643-9eba-0d50daa71a3c")
        public EventObjectFactory(EventSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("fff69b81-6840-4ec8-8a75-033ed3df5ce1")
        @Override
        public ISmObjectData createData() {
            throw new UnsupportedOperationException();
        }

        @objid ("5ae306bb-796b-47ae-9d0e-7d86fdff12db")
        @Override
        public SmObjectImpl createImpl() {
            throw new UnsupportedOperationException();
        }

    }

    @objid ("710ac3a3-f4a0-4459-a966-036f7a066040")
    public static class TimeSmAttribute extends SmAttribute {
        @objid ("bab5b6d5-e541-40cd-8e85-9d590c01eefc")
        public Object getValue(ISmObjectData data) {
            return ((EventData) data).mTime;
        }

        @objid ("8a045fa7-6c7c-46c5-bfd1-afd19fcec1de")
        public void setValue(ISmObjectData data, Object value) {
            ((EventData) data).mTime = value;
        }

    }

}

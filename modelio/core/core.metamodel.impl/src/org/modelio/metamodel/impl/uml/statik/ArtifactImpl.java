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
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.uml.statik.Artifact;
import org.modelio.metamodel.uml.statik.Manifestation;
import org.modelio.metamodel.uml.statik.Node;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("0096da48-c4be-1fd8-97fe-001ec947cd2a")
public class ArtifactImpl extends ClassifierImpl implements Artifact {
    @objid ("b710d9c9-a726-4d4e-94c5-f9ff73feecd6")
    @Override
    public String getFileName() {
        return (String) getAttVal(((ArtifactSmClass)getClassOf()).getFileNameAtt());
    }

    @objid ("da81056b-21df-4dab-b6e5-9e2953e989db")
    @Override
    public void setFileName(String value) {
        setAttVal(((ArtifactSmClass)getClassOf()).getFileNameAtt(), value);
    }

    @objid ("b3da780f-ab74-438b-add0-bd19de311bed")
    @Override
    public EList<Manifestation> getUtilized() {
        return new SmList<>(this, ((ArtifactSmClass)getClassOf()).getUtilizedDep());
    }

    @objid ("5c57f891-1993-418b-85c5-242c611acd52")
    @Override
    public <T extends Manifestation> List<T> getUtilized(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final Manifestation element : getUtilized()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("e273d902-6372-4165-bc9b-b94288f00ee2")
    @Override
    public EList<Node> getDeploymentLocation() {
        return new SmList<>(this, ((ArtifactSmClass)getClassOf()).getDeploymentLocationDep());
    }

    @objid ("f17fe3a2-f0fe-4bb3-a7c0-a04e73aa8733")
    @Override
    public <T extends Node> List<T> getDeploymentLocation(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final Node element : getDeploymentLocation()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("73600b73-f790-4422-95b1-763a576d2c7f")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        return super.getCompositionOwner();
    }

    @objid ("95083c31-ef70-44bc-b9df-a88bdfee5316")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        return super.getCompositionRelation();
    }

    @objid ("3da0b277-1fa9-44c3-95a1-d2f1fc5f1d6d")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitArtifact(this);
    }

}

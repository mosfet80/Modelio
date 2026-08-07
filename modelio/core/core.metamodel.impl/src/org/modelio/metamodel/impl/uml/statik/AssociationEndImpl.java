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
import org.modelio.metamodel.uml.behavior.activityModel.ObjectNode;
import org.modelio.metamodel.uml.informationFlow.InformationFlow;
import org.modelio.metamodel.uml.statik.AggregationKind;
import org.modelio.metamodel.uml.statik.Association;
import org.modelio.metamodel.uml.statik.AssociationEnd;
import org.modelio.metamodel.uml.statik.Attribute;
import org.modelio.metamodel.uml.statik.Classifier;
import org.modelio.metamodel.uml.statik.LinkEnd;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("00977eda-c4be-1fd8-97fe-001ec947cd2a")
public class AssociationEndImpl extends StructuralFeatureImpl implements AssociationEnd {
    /**
     * Compute the association navigability from all roles construction.
     *
     * @return the association navigability.
     */
    @objid ("779babaf-b95e-442f-9c0d-af9c01f610c7")
    @Override
    public boolean isNavigable() {
        return getTarget() != null;
    }

    @objid ("00174af8-22ac-1080-943a-001ec947cd2a")
    @Override
    public void setNavigable(final boolean isNavigable) {
        AssociationEnd opposite = getOpposite();
        boolean otherNavigable = opposite.isNavigable();

        // The source classifier is the current source or the opposite end's target according to the old navigability
        Classifier source = getSource() != null ? getSource() : opposite.getTarget();

        // The target classifier is the opposite end's source or the current target according to the old navigability
        Classifier target = opposite.getSource() != null ? opposite.getSource() : getTarget();

        if (isNavigable && !otherNavigable) { // THIS SIDE
            this.setSource(source);
            this.setTarget(target);

            opposite.setSource(null);
            opposite.setTarget(null);
        } else if (!isNavigable && otherNavigable) { // OTHER SIDE
            this.setSource(null);
            this.setTarget(null);

            opposite.setSource(target);
            opposite.setTarget(source);
        } else if (isNavigable && otherNavigable) { // BOTH SIDES
            this.setSource(source);
            this.setTarget(target);

            opposite.setSource(target);
            opposite.setTarget(source);
        } else if (!isNavigable && !otherNavigable) { // NONE
            this.setSource(source);
            this.setTarget(null);

            opposite.setSource(target);
            opposite.setTarget(null);

        }

    }

    @objid ("0019e09c-22ac-1080-943a-001ec947cd2a")
    @Override
    public void setSource(final Classifier value, boolean fixModel) {
        if (fixModel) {
            boolean isNavigable = isNavigable();

            AssociationEnd opposite = getOpposite();
            boolean otherNavigable = opposite.isNavigable();

            Classifier source = value;

            // The target classifier is the opposite end's source or the current target according to the old navigability
            Classifier target = opposite.getSource() != null ? opposite.getSource() : getTarget();

            if (isNavigable && !otherNavigable) { // THIS SIDE
                this.setSource(source);
                this.setTarget(target);

                opposite.setSource(null);
                opposite.setTarget(null);
            } else if (!isNavigable && otherNavigable) { // OTHER SIDE
                this.setSource(source);
                this.setTarget(target);

                opposite.setSource(target);
                opposite.setTarget(source);
            } else if (isNavigable && otherNavigable) { // BOTH SIDES
                this.setSource(source);
                this.setTarget(target);

                opposite.setSource(target);
                opposite.setTarget(source);
            } else if (!isNavigable && !otherNavigable) { // NONE
                this.setSource(source);
                this.setTarget(null);

                opposite.setSource(target);
                opposite.setTarget(null);
            }
        } else {
            setSource(value);
        }

    }

    @objid ("001b2470-22ac-1080-943a-001ec947cd2a")
    @Override
    public void setTarget(final Classifier value, boolean fixModel) {
        if (fixModel) {
            boolean isNavigable = isNavigable();

            AssociationEnd opposite = getOpposite();
            boolean otherNavigable = opposite.isNavigable();

            // The source classifier is the current source or the opposite end's target according to the old navigability
            Classifier source = getSource() != null ? getSource() : opposite.getTarget();

            Classifier target = value;

            if (isNavigable && !otherNavigable) { // THIS SIDE
                this.setSource(source);
                this.setTarget(target);

                opposite.setSource(null);
                opposite.setTarget(null);
            } else if (!isNavigable && otherNavigable) { // OTHER SIDE
                this.setSource(source);
                this.setTarget(target);

                opposite.setSource(target);
                opposite.setTarget(source);
            } else if (isNavigable && otherNavigable) { // BOTH SIDES
                this.setSource(source);
                this.setTarget(target);

                opposite.setSource(target);
                opposite.setTarget(source);
            } else if (!isNavigable && !otherNavigable) { // NONE
                this.setSource(source);
                this.setTarget(target);

                opposite.setSource(null);
                opposite.setTarget(null);
            }
        } else {
            setTarget(value);
        }

    }

    @objid ("007041ee-1a19-10a1-88a0-001ec947cd2a")
    @Override
    public SmObjectImpl getCompositionOwner() {
        SmObjectImpl ret = (SmObjectImpl) getSource();

        if (ret != null) {
            return ret;
        } else {
            // Return the 'opposite' role only if it has a source:
            // Avoid cycle if both ends have no source.
            // Do not use 'Opposite' role, it is the wrong way and using it has horrible consequences
            // in repository handle initializations.
            AssociationEnd opp = getOppositeOwner();
            if (opp != null && opp.getSource() != null) {
                return (SmObjectImpl) opp;
            } else {
                return null;
            }
        }

    }

    @objid ("6f0ba97d-5b41-11e2-90ce-002564c97630")
    @Override
    public List<SmObjectImpl> getCompositionChildren() {
        final List<SmObjectImpl> compositionChildren = super.getCompositionChildren();


        // Avoid composition loops...
        // Do not use 'OppositeOwner' role, it is the wrong way and using it may have
        // horrible consequences in repository handle initializations.
        AssociationEnd opp = getOpposite();
        if (opp != null && opp.getSource() != null) {
            // The other side has a 'strong' owner, do not return it as a child
            compositionChildren.remove(opp);
        }
        return compositionChildren;
    }

    @objid ("0070616a-1a19-10a1-88a0-001ec947cd2a")
    @Override
    public SmDepVal getCompositionRelation() {
        // First look for 'source'
        SmDependency dep = ((AssociationEndSmClass) getClassOf()).getSourceDep();
        SmObjectImpl obj = (SmObjectImpl) getDepVal(dep);
        if (obj != null) {
            return new SmDepVal(dep, obj);
        }

        // Return the 'opposite' role only if it has a source:
        // Avoid cycle if both ends have no source.
        AssociationEnd opp = getOpposite();

        if (opp != null && opp.getSource() != null) {
            return new SmDepVal(((AssociationEndSmClass) getClassOf()).getOppositeOwnerDep(), opp);
        } else {
            return null;
        }

    }

    @objid ("7d321404-ca63-4d7b-93d6-9eeaed9fe01f")
    @Override
    public Classifier getOwner() {
        Classifier source = getSource();
        if (source != null) {
            return source;
        } else {
            AssociationEnd opposite = getOpposite();
            return opposite != null ? opposite.getTarget() : null;
        }

    }

    @objid ("de5ce14b-fc8c-4ab5-a0b9-2b41683ce4db")
    @Override
    public void afterEraseDepVal(SmDependency dep, SmObjectImpl value) {
        super.afterEraseDepVal(dep, value);

        if (dep == ((AssociationEndSmClass) getClassOf()).getSourceDep()) {
            // Workaround bug where the storage handle is not updated
            AssociationEnd opposite = getOpposite();
            if (opposite != null) {
                Classifier src = opposite.getSource();
                if (src != null) {
                    // detach and attach again
                    opposite.setOpposite(null);
                    opposite.setSource(null);
                    opposite.setSource(src);
                    opposite.setOpposite(this);
                }
            }

        }

    }

    @objid ("eed482b7-b9b0-4e91-9221-7c6f54d506bd")
    @Override
    public AggregationKind getAggregation() {
        return (AggregationKind) getAttVal(((AssociationEndSmClass)getClassOf()).getAggregationAtt());
    }

    @objid ("e7d155ea-3032-4a9e-89e3-eeb41e350529")
    @Override
    public void setAggregation(AggregationKind value) {
        setAttVal(((AssociationEndSmClass)getClassOf()).getAggregationAtt(), value);
    }

    @objid ("0fc9c1d4-12d1-4f15-99f0-97089ac9ec6b")
    @Override
    public boolean isIsChangeable() {
        return (Boolean) getAttVal(((AssociationEndSmClass)getClassOf()).getIsChangeableAtt());
    }

    @objid ("f31331ef-98d7-4ae0-99ab-28a3b9c98971")
    @Override
    public void setIsChangeable(boolean value) {
        setAttVal(((AssociationEndSmClass)getClassOf()).getIsChangeableAtt(), value);
    }

    @objid ("956eb6e8-b9c3-4c0e-b9fe-8f10b90079df")
    @Override
    public Classifier getTarget() {
        Object obj = getDepVal(((AssociationEndSmClass)getClassOf()).getTargetDep());
        return (obj instanceof Classifier)? (Classifier)obj : null;
    }

    @objid ("811e1ee0-9939-4694-9181-c713f89e4935")
    @Override
    public void setTarget(Classifier value) {
        appendDepVal(((AssociationEndSmClass)getClassOf()).getTargetDep(), (SmObjectImpl)value);
    }

    @objid ("fe55dcf5-2376-403e-af47-50d40f33e55f")
    @Override
    public AssociationEnd getOppositeOwner() {
        Object obj = getDepVal(((AssociationEndSmClass)getClassOf()).getOppositeOwnerDep());
        return (obj instanceof AssociationEnd)? (AssociationEnd)obj : null;
    }

    @objid ("8aa3adaf-61b7-4af2-9c10-a23cdecb9270")
    @Override
    public void setOppositeOwner(AssociationEnd value) {
        appendDepVal(((AssociationEndSmClass)getClassOf()).getOppositeOwnerDep(), (SmObjectImpl)value);
    }

    @objid ("90905b34-724e-4895-ba0f-e292ea392f76")
    @Override
    public Classifier getSource() {
        Object obj = getDepVal(((AssociationEndSmClass)getClassOf()).getSourceDep());
        return (obj instanceof Classifier)? (Classifier)obj : null;
    }

    @objid ("c8d1c017-84f0-442e-8cf2-d4ad13aef53b")
    @Override
    public void setSource(Classifier value) {
        appendDepVal(((AssociationEndSmClass)getClassOf()).getSourceDep(), (SmObjectImpl)value);
    }

    @objid ("55a4ed7a-093c-428e-82ed-74254a2ae058")
    @Override
    public EList<LinkEnd> getOccurence() {
        return new SmList<>(this, ((AssociationEndSmClass)getClassOf()).getOccurenceDep());
    }

    @objid ("b611b173-09a1-4d7f-89f8-e3b6fe5e0c0b")
    @Override
    public <T extends LinkEnd> List<T> getOccurence(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final LinkEnd element : getOccurence()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("6aa23fa9-7517-427d-9541-05ea1047a860")
    @Override
    public EList<InformationFlow> getSent() {
        return new SmList<>(this, ((AssociationEndSmClass)getClassOf()).getSentDep());
    }

    @objid ("eb9d1a32-eed1-48dd-b101-9a71e4aea29f")
    @Override
    public <T extends InformationFlow> List<T> getSent(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final InformationFlow element : getSent()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("2d8c4f0b-55ce-435b-8474-dcda82812334")
    @Override
    public EList<Attribute> getQualifier() {
        return new SmList<>(this, ((AssociationEndSmClass)getClassOf()).getQualifierDep());
    }

    @objid ("20679547-1d33-41ac-a8f0-b779fc729658")
    @Override
    public <T extends Attribute> List<T> getQualifier(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final Attribute element : getQualifier()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("121dbbb8-305b-4488-bb35-e062c6476786")
    @Override
    public AssociationEnd getOpposite() {
        Object obj = getDepVal(((AssociationEndSmClass)getClassOf()).getOppositeDep());
        return (obj instanceof AssociationEnd)? (AssociationEnd)obj : null;
    }

    @objid ("215277ef-b7a0-4d51-989b-fef0100dd500")
    @Override
    public void setOpposite(AssociationEnd value) {
        appendDepVal(((AssociationEndSmClass)getClassOf()).getOppositeDep(), (SmObjectImpl)value);
    }

    @objid ("28721faf-985c-4c07-bcb0-b7c8b8008200")
    @Override
    public EList<ObjectNode> getRepresentingObjectNode() {
        return new SmList<>(this, ((AssociationEndSmClass)getClassOf()).getRepresentingObjectNodeDep());
    }

    @objid ("1e8e99c2-0931-4273-9201-4f5c70a79fe0")
    @Override
    public <T extends ObjectNode> List<T> getRepresentingObjectNode(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final ObjectNode element : getRepresentingObjectNode()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("0397aba0-18a2-43fd-b8c9-f111583001f2")
    @Override
    public Association getAssociation() {
        Object obj = getDepVal(((AssociationEndSmClass)getClassOf()).getAssociationDep());
        return (obj instanceof Association)? (Association)obj : null;
    }

    @objid ("d866e79d-bbdf-40b1-a917-791130954074")
    @Override
    public void setAssociation(Association value) {
        appendDepVal(((AssociationEndSmClass)getClassOf()).getAssociationDep(), (SmObjectImpl)value);
    }

    @objid ("a3e5f175-d8d1-4819-b3ff-0c75ecfa55ae")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitAssociationEnd(this);
    }

}

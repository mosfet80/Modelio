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
import org.modelio.metamodel.impl.uml.infrastructure.UmlModelElementImpl;
import org.modelio.metamodel.uml.informationFlow.InformationFlow;
import org.modelio.metamodel.uml.statik.AssociationEnd;
import org.modelio.metamodel.uml.statik.Instance;
import org.modelio.metamodel.uml.statik.Link;
import org.modelio.metamodel.uml.statik.LinkEnd;
import org.modelio.metamodel.uml.statik.ProvidedInterface;
import org.modelio.metamodel.uml.statik.RequiredInterface;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("000ff2da-c4bf-1fd8-97fe-001ec947cd2a")
public class LinkEndImpl extends UmlModelElementImpl implements LinkEnd {
    /**
     * Compute the link navigation way from all roles construction.
     *
     * @return the link navigability.
     */
    @objid ("1efdf05d-4abe-4809-a5e2-6e5cf051d3a6")
    @Override
    public boolean isNavigable() {
        return getTarget() != null;
    }

    @objid ("007a3168-2787-1080-943a-001ec947cd2a")
    @Override
    public void setNavigable(final boolean isNavigable) {
        LinkEnd opposite = getOpposite();
        boolean otherNavigable = opposite.isNavigable();

        // The source instance is the current source or the opposite end's target according to the old navigability
        Instance source = getSource() != null ? getSource() : opposite.getTarget();

        // The target instance is the opposite end's source or the current target according to the old navigability
        Instance target = opposite.getSource() != null ? opposite.getSource() : getTarget();

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

    @objid ("0047aacc-27d2-1080-943a-001ec947cd2a")
    @Override
    public void setTarget(final Instance value, boolean fixModel) {
        if (fixModel) {
            boolean isNavigable = isNavigable();

            LinkEnd opposite = getOpposite();
            boolean otherNavigable = opposite.isNavigable();

            // The source instance is the current source or the opposite end's target according to the old navigability
            Instance source = getSource() != null ? getSource() : opposite.getTarget();

            Instance target = value;

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

    @objid ("000aa226-27ef-1080-943a-001ec947cd2a")
    @Override
    public void setSource(final Instance value, boolean fixModel) {
        if (fixModel) {
            boolean isNavigable = isNavigable();

            LinkEnd opposite = getOpposite();
            boolean otherNavigable = opposite.isNavigable();

            Instance source = value;

            // The target instance is the opposite end's source or the current target according to the old navigability
            Instance target = opposite.getSource() != null ? opposite.getSource() : getTarget();

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

    @objid ("001f2be2-1a19-10a1-88a0-001ec947cd2a")
    @Override
    public SmObjectImpl getCompositionOwner() {
        Instance src = getSource();
        if (src != null) {
            return (SmObjectImpl) src;
        } else {
            // Return the 'opposite' role only if it has a source:
            // Avoid cycle if both ends have no source.
            // Do not use 'Opposite' role, it is the wrong way and using it has horrible consequences
            // in repository handle initializations.
            LinkEnd opp = getOppositeOwner();
            if (opp != null && opp.getSource() != null) {
                return (SmObjectImpl) opp;
            } else {
                return null;
            }
        }

    }

    @objid ("71066600-5b42-11e2-90ce-002564c97630")
    @Override
    public List<SmObjectImpl> getCompositionChildren() {
        final List<SmObjectImpl> compositionChildren = super.getCompositionChildren();

        // Avoid composition loops...
        // Do not use 'OppositeOwner' role, it is the wrong way and using it may have
        // horrible consequences in repository handle initializations.
        LinkEnd opp = getOpposite();
        if (opp != null && opp.getSource() != null) {
            // The other side has a 'strong' owner, do not return it as a child
            compositionChildren.remove(opp);
        }
        return compositionChildren;
    }

    @objid ("001f4a50-1a19-10a1-88a0-001ec947cd2a")
    @Override
    public SmDepVal getCompositionRelation() {
        SmObjectImpl obj;

        // First look for 'source'
        obj = (SmObjectImpl) getDepVal(((LinkEndSmClass) getClassOf()).getSourceDep());
        if (obj != null) {
            return new SmDepVal(((LinkEndSmClass) getClassOf()).getSourceDep(), obj);
        }

        // Return the 'opposite' role only if it has a source:
        // Avoid cycle if both ends have no source.
        LinkEnd opp = getOpposite();

        if (opp != null && opp.getSource() != null) {
            return new SmDepVal(((LinkEndSmClass) getClassOf()).getOppositeOwnerDep(), opp);
        } else {
            return null;
        }

    }

    @objid ("0aed289b-c84f-4d32-9047-10a14bf76274")
    @Override
    public Instance getOwner() {
        Instance source = getSource();
        if (source != null) {
            return source;
        } else {
            LinkEnd opposite = getOpposite();
            return opposite != null ? opposite.getTarget() : null;
        }

    }

    @objid ("891a32f4-6ac7-42a6-b286-ad0bf75273a5")
    @Override
    public void afterEraseDepVal(SmDependency dep, SmObjectImpl value) {
        super.afterEraseDepVal(dep, value);

        if (dep == ((LinkEndSmClass) getClassOf()).getSourceDep()) {
            // Workaround bug where the storage handle is not updated
            LinkEnd opposite = getOpposite();
            if (opposite != null) {
                Instance src = opposite.getSource();
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

    @objid ("c798cac4-f8c2-43a6-87fb-0629bd2660d4")
    @Override
    public boolean isIsOrdered() {
        return (Boolean) getAttVal(((LinkEndSmClass)getClassOf()).getIsOrderedAtt());
    }

    @objid ("8c4dfc49-6bfb-4162-90d2-0cfee593cb29")
    @Override
    public void setIsOrdered(boolean value) {
        setAttVal(((LinkEndSmClass)getClassOf()).getIsOrderedAtt(), value);
    }

    @objid ("fb14f781-fb18-4c5b-9d27-e79d5f1081ea")
    @Override
    public boolean isIsUnique() {
        return (Boolean) getAttVal(((LinkEndSmClass)getClassOf()).getIsUniqueAtt());
    }

    @objid ("7cb6d624-9aac-48ff-b8d0-1672a951b938")
    @Override
    public void setIsUnique(boolean value) {
        setAttVal(((LinkEndSmClass)getClassOf()).getIsUniqueAtt(), value);
    }

    @objid ("bd7e0508-530a-473c-97cc-05e35bf45ba6")
    @Override
    public String getMultiplicityMax() {
        return (String) getAttVal(((LinkEndSmClass)getClassOf()).getMultiplicityMaxAtt());
    }

    @objid ("23a37781-89d7-4c14-b6dc-5773dbf24238")
    @Override
    public void setMultiplicityMax(String value) {
        setAttVal(((LinkEndSmClass)getClassOf()).getMultiplicityMaxAtt(), value);
    }

    @objid ("3a8d65ce-0a89-4404-a834-704931944d92")
    @Override
    public String getMultiplicityMin() {
        return (String) getAttVal(((LinkEndSmClass)getClassOf()).getMultiplicityMinAtt());
    }

    @objid ("ab0abd9d-7ed9-440c-b57b-b0c8e38a1220")
    @Override
    public void setMultiplicityMin(String value) {
        setAttVal(((LinkEndSmClass)getClassOf()).getMultiplicityMinAtt(), value);
    }

    @objid ("ac998e24-ef0f-4305-8417-023ac0f887ef")
    @Override
    public Link getLink() {
        Object obj = getDepVal(((LinkEndSmClass)getClassOf()).getLinkDep());
        return (obj instanceof Link)? (Link)obj : null;
    }

    @objid ("4ab4ee1b-f9ad-4e72-b637-d18fda8fffbf")
    @Override
    public void setLink(Link value) {
        appendDepVal(((LinkEndSmClass)getClassOf()).getLinkDep(), (SmObjectImpl)value);
    }

    @objid ("fe3a952f-1897-4128-b1b1-d4a265f66628")
    @Override
    public Instance getTarget() {
        Object obj = getDepVal(((LinkEndSmClass)getClassOf()).getTargetDep());
        return (obj instanceof Instance)? (Instance)obj : null;
    }

    @objid ("381e4c43-5135-4589-a5ef-d1018db6bafb")
    @Override
    public void setTarget(Instance value) {
        appendDepVal(((LinkEndSmClass)getClassOf()).getTargetDep(), (SmObjectImpl)value);
    }

    @objid ("22fbe5c7-9c6d-45e9-ac00-014bab1319bc")
    @Override
    public LinkEnd getOppositeOwner() {
        Object obj = getDepVal(((LinkEndSmClass)getClassOf()).getOppositeOwnerDep());
        return (obj instanceof LinkEnd)? (LinkEnd)obj : null;
    }

    @objid ("50a00154-4fa5-4c81-ba4a-7c5d95a578d8")
    @Override
    public void setOppositeOwner(LinkEnd value) {
        appendDepVal(((LinkEndSmClass)getClassOf()).getOppositeOwnerDep(), (SmObjectImpl)value);
    }

    @objid ("44ec77a2-fc57-4e13-8596-4401c484254a")
    @Override
    public EList<InformationFlow> getRealizedInformationFlow() {
        return new SmList<>(this, ((LinkEndSmClass)getClassOf()).getRealizedInformationFlowDep());
    }

    @objid ("c53c16cb-ac64-4896-b888-27d0ecce10da")
    @Override
    public <T extends InformationFlow> List<T> getRealizedInformationFlow(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final InformationFlow element : getRealizedInformationFlow()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("0b9ef7ce-363f-42d5-ae49-9c3d46216ffa")
    @Override
    public AssociationEnd getModel() {
        Object obj = getDepVal(((LinkEndSmClass)getClassOf()).getModelDep());
        return (obj instanceof AssociationEnd)? (AssociationEnd)obj : null;
    }

    @objid ("2c6cd4b8-97d9-47f3-a912-1a6008dfba9e")
    @Override
    public void setModel(AssociationEnd value) {
        appendDepVal(((LinkEndSmClass)getClassOf()).getModelDep(), (SmObjectImpl)value);
    }

    @objid ("3816cbca-76a2-4634-bf2e-bb79830af2b2")
    @Override
    public RequiredInterface getConsumer() {
        Object obj = getDepVal(((LinkEndSmClass)getClassOf()).getConsumerDep());
        return (obj instanceof RequiredInterface)? (RequiredInterface)obj : null;
    }

    @objid ("2ee305d6-972b-4c77-b34b-bbd0f3f1bc92")
    @Override
    public void setConsumer(RequiredInterface value) {
        appendDepVal(((LinkEndSmClass)getClassOf()).getConsumerDep(), (SmObjectImpl)value);
    }

    @objid ("c514d74f-8ab4-409d-a179-fa726b6c30fe")
    @Override
    public LinkEnd getOpposite() {
        Object obj = getDepVal(((LinkEndSmClass)getClassOf()).getOppositeDep());
        return (obj instanceof LinkEnd)? (LinkEnd)obj : null;
    }

    @objid ("b41ca01b-1ac0-4604-9c37-569290967e72")
    @Override
    public void setOpposite(LinkEnd value) {
        appendDepVal(((LinkEndSmClass)getClassOf()).getOppositeDep(), (SmObjectImpl)value);
    }

    @objid ("3246432f-75b8-46fd-bc42-8060693ad544")
    @Override
    public Instance getSource() {
        Object obj = getDepVal(((LinkEndSmClass)getClassOf()).getSourceDep());
        return (obj instanceof Instance)? (Instance)obj : null;
    }

    @objid ("ef1d619d-f555-407b-be55-58c92f42e3f8")
    @Override
    public void setSource(Instance value) {
        appendDepVal(((LinkEndSmClass)getClassOf()).getSourceDep(), (SmObjectImpl)value);
    }

    @objid ("cc635707-f59f-4892-9583-f0ae6ffaa8e7")
    @Override
    public ProvidedInterface getProvider() {
        Object obj = getDepVal(((LinkEndSmClass)getClassOf()).getProviderDep());
        return (obj instanceof ProvidedInterface)? (ProvidedInterface)obj : null;
    }

    @objid ("3e6165c7-a92d-4ee4-9196-9f23eff8040f")
    @Override
    public void setProvider(ProvidedInterface value) {
        appendDepVal(((LinkEndSmClass)getClassOf()).getProviderDep(), (SmObjectImpl)value);
    }

    @objid ("0bd3684f-268e-4ffe-95ff-33d31b2418c8")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitLinkEnd(this);
    }

}

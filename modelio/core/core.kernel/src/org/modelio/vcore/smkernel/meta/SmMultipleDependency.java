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
package org.modelio.vcore.smkernel.meta;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.vbasic.log.Log;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.IllegalModelManipulationException;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

/**
 * Represents a multiple dependency, ie when max cardinality is greater than one.
 *
 * @author phv
 */
@objid ("000919f6-0a98-1f20-85a5-001ec947cd2a")
public abstract class SmMultipleDependency extends SmDependency {
    @objid ("d4edc176-036c-4e01-be4f-380418157313")
    private static final EnumSet<SmDirective> COMPLEMENT_OF_NAVIGABILITY_FLAGS = EnumSet.complementOf(EnumSet.of(SmDirective.SMCDCOMPONENT, SmDirective.SMCDPARTOF, SmDirective.SMCDSHAREDCOMPONENT));

    /**
     * Constant used to identify empty lists on SmObjectData.
     * <p>
     * Avoid allocating billions of useless empty ArrayLists.
     */
    @objid ("8fac5bda-3d36-11e2-ab11-001ec947ccaf")
    public static final List<SmObjectImpl> EMPTY = Collections.unmodifiableList(new ArrayList<>(0));

    /**
     * This is the unique getter accessor for multiple dependencies. It is redefined by specialized classes to access the proper
     * data field.
     *
     * @param obj a model object data
     * @return the content of the dependency on the model object.
     */
    @objid ("0009222a-0a98-1f20-85a5-001ec947cd2a")
    public abstract List<SmObjectImpl> getValueList(final ISmObjectData obj);

    /**
     * Remove value from the list.
     *
     * @param data The object to modify
     * @param value the value to remove
     */
    @objid ("00093f26-0a98-1f20-85a5-001ec947cd2a")
    @Override
    public boolean remove(ISmObjectData data, final SmObjectImpl value) {
        if (getValueList(data) == SmMultipleDependency.EMPTY) {
            return false;
        } else {
            return getValueList(data).remove(value);
        }
    }

    /**
     * Insert <i>value</i> in the list at position <i>index</i>.
     * </ul>
     *
     * @param data The object to modify
     * @param value the value to add/set
     */
    @objid ("00098724-0a98-1f20-85a5-001ec947cd2a")
    @Override
    public void insert(ISmObjectData data, final SmObjectImpl value, final int index) {
        List<SmObjectImpl> valueList = getValueList(data);

        if (valueList == SmMultipleDependency.EMPTY) {
            valueList = allocateValueList(data);
        }

        int oldIndex = valueList.indexOf(value);
        if (oldIndex == -1) {
            // Happy path
            valueList.add(index, value);
            return;
        }

        // Value already present, check if we can ignore re-insertion
        EnumSet<SmDirective> testSet = EnumSet.copyOf(this.smFlags);
        testSet.removeAll(COMPLEMENT_OF_NAVIGABILITY_FLAGS);
        if (testSet.isEmpty() ) {
            // Opposite/Dynamic dependencies are subject to race conditions, just ignore re-insertions
            Log.trace(("SmMultipleDependency:" + value + " already present in non navigable " + data + "->" + getName() + "[" + oldIndex + "]"));
        } else if (oldIndex == index) {
            // Value already in place !!
            Log.trace(("SmMultipleDependency:" + value + " already present in " + data + "->" + getName() + "[" + oldIndex + "]"));
        } else {
            throw new IllegalArgumentException(value + " already present in " + data + "->" + getName() + "[" + oldIndex + "]");
            // valueList.remove(value);
            // valueList.add(index, value);
        }
    }

    /**
     * Add the value to the end of the list.
     *
     * @param obj The object to modify
     * @param value the value to add/set
     * @return <code>true</code> if a change was done, <code>false</code> if no change was needed (the value was already present).
     */
    @objid ("0009dd78-0a98-1f20-85a5-001ec947cd2a")
    @Override
    public boolean add(ISmObjectData obj, SmObjectImpl value) {
        List<SmObjectImpl> valueList = getValueList(obj);
        if (valueList == SmMultipleDependency.EMPTY) {
            valueList = allocateValueList(obj);
        }

        // Check element not already present only in debug mode.
        assert (assertAbsent(obj, value, valueList));
        return valueList.add(value);
    }

    @objid ("009880d2-3242-1085-9e4a-001ec947cd2a")
    @Override
    public void assertValueType(final SmObjectImpl smObjectImpl, final Object value) throws IllegalArgumentException, IllegalModelManipulationException {
        this.checker.assertType(smObjectImpl, value);
    }

    @objid ("00382be2-a0ef-10bc-9a9a-001ec947cd2a")
    private List<SmObjectImpl> allocateValueList(ISmObjectData data) {
        List<SmObjectImpl> valueList = new MObjectList(1);
        initValueList(data, valueList);
        return valueList;
    }

    /**
     * Check <i>value</i> is not already present on <i>valueList</i>
     *
     * @param obj the dependency source
     * @param value the value to check
     * @param valueList the dependency content
     * @throws IllegalArgumentException if the value is present in the content.
     */
    @objid ("4e70de17-f3ac-49c1-817f-7d711c2f012a")
    private boolean assertAbsent(ISmObjectData data, final SmObjectImpl value, List<SmObjectImpl> valueList) throws IllegalArgumentException {
        int oldIndex = valueList.indexOf(value);
        if (oldIndex != -1) {
            throw new IllegalArgumentException(value + " already present in " + data + "->" + getName() + "[" + oldIndex + "]");
        }
        return true;
    }

    /**
     * This method is called in order to initialize a the data structure for the dependency
     * when the dependency, being still empty and bound to the EMPTY list, has to be modified.
     * Its role is to initialize a concrete ArrayList for the dependency.
     *
     * @param data a model object data
     * @param list the allocated list.
     */
    @objid ("f12a8a37-8215-4566-b7bc-01e0a5f5f27b")
    protected abstract void initValueList(ISmObjectData data, List<SmObjectImpl> list);

    @objid ("fb1bcfc8-054f-45e1-a110-434294663417")
    @Override
    public Collection<SmObjectImpl> getValueAsCollection(ISmObjectData object) {
        return getValueList(object);
    }

    @objid ("c90c9f76-cff4-4306-aab5-8418327e90d0")
    @Override
    public Object getValue(ISmObjectData object) {
        return getValueList(object);
    }

    @objid ("0390e5cc-85bb-4210-afa9-3a49693d4b62")
    @Override
    public void moveRef(final ISmObjectData refered, final SmObjectImpl ref, final int offset) {
        if (offset == 0) {
            // No move needed
            return;
        }

        // Remove the value from the value list, and put in back in the appropriate place
        int oldIndex = getValueList(refered).indexOf(ref);
        if (remove(refered, ref)) {
            getValueList(refered).add(oldIndex + offset, ref);
        }
    }

}

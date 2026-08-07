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
package org.modelio.vcore.smkernel.mapi;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

/**
 * This interface defines the services available to programmers outside 'vcore' for handling SmObjectImpl instances.
 * <p>
 * The MObject services are obviously a subset of those provided by SmObjectImpl which is an internal implementation class of vcore.
 *
 * @author phv
 */
@objid ("001dc7ac-a714-1f4f-9c13-001ec947cd2a")
public interface MObject extends Comparable<MObject> {
    /**
     * Accept a visitor.
     * <p>
     * The Acyclic Visitor pattern allows new functions to be added to existing class hierarchies without affecting those
     * hierarchies, and without creating the dependency cycles that are inherent to the <a
     * href="http://c2.com/cgi/wiki?GangOfFour">GangOfFour</a> <a href="http://c2.com/cgi/wiki?VisitorPattern">VisitorPattern</a>
     *
     * @param v a visitor
     * @return an object returned by the visitor.
     * @see <a href="http://c2.com/cgi/wiki?GangOfFour">http://c2.com/cgi/wiki?AcyclicVisitor</a>
     */
    @objid ("ef589d44-bea9-11e1-b576-001ec947ccaf")
    Object accept(MVisitor v);

    /**
     * Delete the object from the model.
     */
    @objid ("aabfae41-bba4-11e1-ac85-001ec947ccaf")
    void delete();

    /**
     * Get the child objects in the composition graph.
     * <p>
     * Navigates string composition dependencies and shared composition ones.
     * <p>
     * <b>Beware:</b> There are cycles in the composition graph computed using this method.
     * <p>
     * To avoid dealing with cycles you can use
     * {@link org.modelio.vcore.model.CompositionGetter#getAllChildren(java.util.Collection) CompositionGetter.getAllChildren(Collection<MObject>)}
     *
     * @return the owned objects.
     * @see org.modelio.vcore.model.CompositionGetter#getAllChildren(java.util.Collection)
     */
    @objid ("0062e7ce-b2b0-1f4f-9c13-001ec947cd2a")
    List<? extends MObject> getCompositionChildren();

    /**
     * Get the object owning this object in the composition graph.
     *
     * @return the owner or <code>null</code> if this object is orphan.
     */
    @objid ("0062e0b2-b2b0-1f4f-9c13-001ec947cd2a")
    MObject getCompositionOwner();

    /**
     * Get the object metaclass.
     *
     * @return the object metaclass.
     */
    @objid ("003bd24c-2f05-1ffc-8433-001ec947cd2a")
    MClass getMClass();

    /**
     * Get the object name.
     * <p>
     * This method must never return <code>null</code>.
     *
     * @return the name of the object.
     */
    @objid ("0062d9aa-b2b0-1f4f-9c13-001ec947cd2a")
    String getName();

    /**
     * Get the object status flags.
     * <p>
     * The status flags tell for example whether the object is visible browsable, modifiable, its CMS state ...
     * <p>
     * CMS flags loading is a long operation and is done asynchronously since Modelio 6.0.0.
     * If accurate status is not necessary you may call {@link #getLazyStatus()} instead.
     *
     * @return the object status. {@link MStatus#isStatusFullyLoaded()} will always return true.
     * @see #getLazyStatus()
     * @see #getStatusAsync()
     */
    @objid ("eb67ff62-d4a2-11e1-b069-001ec947ccaf")
    MStatus getStatus();

    /**
     * Get the object status flags.
     * <p>
     * The status flags tell for example whether the object is visible browsable, modifiable, its CMS state ...
     * <p>
     * CMS flags loading is a long operation and is done asynchronously since Modelio 6.0.0.
     * If accurate status is not necessary you may call {@link #getLazyStatus()} instead.
     *
     * @return a future with the object status. {@link MStatus#isStatusFullyLoaded()} will always return true.
     * @see #getLazyStatus()
     * @see #getStatus()
     * @since 6.0.1 03/10/2024
     */
    @objid ("4dfbe6f5-6827-41a9-8b60-d8649db83c9b")
    CompletableFuture<MStatus> getStatusAsync();

    /**
     * Get a partially loaded snapshot of the object status flags.
     * <p>
     * The status flags tell for example whether the object is visible browsable, modifiable, its CMS state ...
     * <p>
     * CMS flags loading is a long operation and is done asynchronously since Modelio 6.0.0.
     * The returned status may be only partially loaded, in this case {@link MStatus#isStatusFullyLoaded()} returns false
     * and {@link MStatus#isModifiable()} will return false too .
     * <p>
     * The returned status is a snapshot and won't be updated when internal status will be fully loaded,
     * you will have to call {@link #getStatus()}, {@link #getStatusAsync()} or {@link #getLazyStatus()} again.
     *
     * @return the object status.
     * @see #getStatusAsync()
     * @see #getStatus()
     * @since 6.0.1 03/10/2024
     */
    @objid ("ee3a8246-ad65-4ee7-81b3-51f9a9267826")
    MStatus getStatusLazy();

    /**
     * Get the object unique identifier.
     *
     * @return the object identifier.
     */
    @objid ("68978360-c9ca-11e1-8052-001ec947ccaf")
    String getUuid();

    /**
     * Tells whether the element is deleted in the model.
     * <p>
     * A deleted object has the following behavior:
     * <ul>
     * <li>A deleted object is not modifiable. Trying to modify it will result in an exception.
     * <li>The object attributes are still readable.
     * <li>A deleted object is not visible from its non deleted owner and references, but the deleted object dependencies are still
     * browsable.
     * </ul>
     *
     * @return <code>true</code> if the element is alive or shell, <code>false</code> if it has been deleted.
     * @see #isShell()
     * @see #isValid()
     */
    @objid ("00451f0a-c8ce-1fe1-8fe0-001ec947cd2a")
    boolean isDeleted();

    /**
     * Tells whether the object can be modified
     *
     * @return <code>true</code> if the object can be modified else <code>false</code>.
     */
    @objid ("0008e472-3622-1ffc-8433-001ec947cd2a")
    boolean isModifiable();

    /**
     * Tells whether the object is an unresolved reference.
     * <p>
     * A shell object is an object that is not present in any known repository but is referenced in another one.
     * <p>
     * A shell object has the following behavior:
     * <ul>
     * <li>A shell object is not modifiable. Trying to modify it will result in an exception.
     * <li>Only the name of the object has a significant value.
     * <li>Other attributes have a default value and dependencies are empty.
     * </ul>
     * Browsing a shell object will return empty collections.
     *
     * @return <code>true</code> if the object is unresolved, else <code>false</code>.
     */
    @objid ("0008ef8a-3622-1ffc-8433-001ec947cd2a")
    boolean isShell();

    /**
     * Tells whether the object is usable.
     * <p>
     * An object is usable if its modeling session and its repository is open and if the object is not deleted nor shell.
     *
     * @return <code>true</code> if the object is valid else <code>false</code>.
     * @see #isDeleted()
     * @see #isShell()
     */
    @objid ("4d7023e0-1cf7-11e2-8eb9-001ec947ccaf")
    boolean isValid();

    /**
     * Get an attribute value
     *
     * @param att an attribute
     * @return its value.
     */
    @objid ("003bedea-2f05-1ffc-8433-001ec947cd2a")
    Object mGet(MAttribute att);

    /**
     * Get the given dependency content as a List.
     * <p>
     * The returned list reflects the content of the dependency at any moment. Modifying the list will modify the dependency
     * content.
     *
     * @param dep the dependency to get.
     * @return a reference to its content.
     */
    @objid ("003bfd3a-2f05-1ffc-8433-001ec947cd2a")
    List<MObject> mGet(MDependency dep);

    /**
     * Set an attribute value
     *
     * @param att an attribute
     * @param value its new value.
     */
    @objid ("003bdc92-2f05-1ffc-8433-001ec947cd2a")
    void mSet(MAttribute att, Object value);

    /**
     * Set the name of the object.
     *
     * @param name the name of the object.
     */
    @objid ("0062fcd2-b2b0-1f4f-9c13-001ec947cd2a")
    void setName(final String name);

}

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
package org.modelio.vcore.session.impl.transactions.smAction;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.SmDependency;
import org.modelio.vcore.smkernel.transaction.ISmDependencyAction;

/**
 * Classe abstraite regroupant les actions de modifications d'une association.
 * <p>
 * Elle poss�de un lien vers la dependance modifiee et un lien pour sauvegarde de l'objet reference.
 *
 * On sauvegarde aussi l'emplacement de l'objet reference dans la dependance
 * et le mode de propagation de l'action.
 */
@objid ("006e7c60-0d1e-1f20-85a5-001ec947cd2a")
public abstract class DependencyModificationAction extends SimpleAction implements ISmDependencyAction {
    /**
     * index of the insertion or removal.
     * <p>
     * -1 means last element.
     */
    @objid ("006d39cc-0d1e-1f20-85a5-001ec947cd2a")
    protected final int index;

    @objid ("006e7468-0d1e-1f20-85a5-001ec947cd2a")
    protected final SmDependency smDep;

    @objid ("006e9b5a-0d1e-1f20-85a5-001ec947cd2a")
    protected final SmObjectImpl ref;

    @objid ("006d3936-0d1e-1f20-85a5-001ec947cd2a")
    protected DependencyModificationAction(final SmObjectImpl obj, final SmDependency dep, final SmObjectImpl ref) {
        this(obj, dep, ref, -1);
    }

    @objid ("7d32d147-ba88-4c70-b080-756ec8eba7d2")
    protected DependencyModificationAction(final SmObjectImpl obj, final SmDependency dep, final SmObjectImpl ref, int index) {
        super(obj);
        this.smDep = dep;
        this.ref = ref;
        this.index = index;

    }

    /**
     *
     * @return the appended/deleted/... value
     */
    @objid ("0093e932-f11f-1f3c-aafd-001ec947cd2a")
    public SmObjectImpl getRef() {
        return this.ref;
    }

    @objid ("009402d2-f11f-1f3c-aafd-001ec947cd2a")
    @Override
    public SmDependency getDep() {
        return this.smDep;
    }

    @objid ("e32e7db4-23d9-40cc-9442-88fceac8015b")
    @Override
    public MObject getValue() {
        return this.ref;
    }

    @objid ("8c0ed5cf-8f40-4103-a94e-3ecd3df15c1d")
    @Override
    public int getIndex() {
        return this.index;
    }

}

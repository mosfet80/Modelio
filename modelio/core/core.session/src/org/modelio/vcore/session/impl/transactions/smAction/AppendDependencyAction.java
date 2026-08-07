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
import org.modelio.vcore.session.impl.transactions.smAction.smActionInteractions.IActionVisitor;
import org.modelio.vcore.smkernel.IMetaOf;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.meta.SmDependency;
import org.modelio.vcore.smkernel.meta.SmMultipleDependency;
import org.modelio.vcore.smkernel.transaction.ISmAppendDepValAction;

/**
 * permet d'ajouter un objet dans une association.
 */
@objid ("006e780a-0d1e-1f20-85a5-001ec947cd2a")
public class AppendDependencyAction extends DependencyModificationAction implements ISmAppendDepValAction {
    /**
     * L'enleve l'objet reference de la dependance. L'action est dejouee
     * uniquement si l'object n'est pas un transient objet ou si c'est un
     * rollback.i
     */
    @objid ("006d3fbc-0d1e-1f20-85a5-001ec947cd2a")
    @Override
    public void rollbackAction() {
        IMetaOf metaOf = this.refered.getMetaOf();
        metaOf.eraseObjDepVal(this.refered, this.smDep, this.ref);
    }

    /**
     * Remet l'objet reference dans l'association. L'action est dejouee
     * uniquement si l'object n'est pas un transient objet
     */
    @objid ("006d4052-0d1e-1f20-85a5-001ec947cd2a")
    @Override
    public void redoAction() {
        // On remet l'objet dans la dependance sans pour cela recreer une action
        IMetaOf metaOf = this.refered.getMetaOf();
        try {
            metaOf.appendObjDepValIndex(this.refered, this.smDep, this.ref, this.index);
        } catch (IndexOutOfBoundsException e) {
            // HACK : This happens on AbstractDiagram.RepresentedElement because some actions happen in non undoable sub transactions
            // and inconsistencies in conference fragments.
            // Tolerate it only in this specific case.
            // see org.modelio.diagram.elements.common.abstractdiagram.DiagramPersistence.updateDiagramElementRelation(AbstractDiagram)
            if (this.smDep.getName().equals("Represented") && this.smDep.getSource().getQualifiedName().equals("Infrastructure.AbstractDiagram")) {
                try {
                    metaOf.appendObjDepVal(this.refered, this.smDep, this.ref);
                } catch (RuntimeException e2) {
                    // Don't allow any other failure, chain both exceptions and throw the second one.
                    e2.addSuppressed(e); throw e2;
                }
            } else {
                throw e;
            }
        }
    }

    /**
     * Constructeur de l'action "append" sur une dependance.
     * <p>
     * Sauvegarde l'objet contenant la dependance dans l'association "Refer", la dependance dans
     * l'association "Dep" et l'objet a ajouter dans "Ref".
     * <p>
     * On sauvegarde aussi l'indice de l'objet dans l'association .
     *
     * @param obj the source model object
     * @param dep the dependency
     * @param ref the appended model object
     */
    @objid ("006d40e8-0d1e-1f20-85a5-001ec947cd2a")
    public AppendDependencyAction(final SmObjectImpl obj, final SmDependency dep, final SmObjectImpl ref) {
        this(obj, dep, ref, (dep.isMultiple())? ((SmMultipleDependency) dep).getValueList(obj.getData()).size() - 1 :-1);
    }

    @objid ("006d417e-0d1e-1f20-85a5-001ec947cd2a")
    @Override
    public void accept(IActionVisitor v) {
        v.visitAppendDependencyAction(this);
    }

    /**
     * Constructeur de l'action "append" sur une dependance.
     * <p>
     * Sauvegarde l'objet contenant la dependance dans l'association "Refer", la dependance dans
     * l'association "Dep" et l'objet a ajouter dans "Ref".
     * <p>
     * On sauvegarde aussi l'indice de l'objet dans l'association .
     *
     * @param obj the source model object
     * @param dep the dependency
     * @param ref the appended model object
     * @param index the index of the insertion
     */
    @objid ("0082a33e-702b-1f21-85a5-001ec947cd2a")
    public AppendDependencyAction(final SmObjectImpl obj, final SmDependency dep, final SmObjectImpl ref, final int index) {
        super(obj, dep, ref, index);
    }

    @objid ("5e9830de-b382-4ad2-8589-ee9cc19e20c9")
    @Override
    public String toString() {
        return String.format("append %s to %s->%s[%d]", this.ref, this.refered, this.smDep, this.index);
    }

}

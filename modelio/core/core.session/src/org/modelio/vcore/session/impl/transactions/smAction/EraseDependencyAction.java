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
import org.modelio.vcore.smkernel.transaction.ISmEraseDepValAction;

/**
 * Permet de retirer un objet d'une association. cet objet est sauvegarde pour
 * le undo.
 */
@objid ("006e7b52-0d1e-1f20-85a5-001ec947cd2a")
public class EraseDependencyAction extends DependencyModificationAction implements ISmEraseDepValAction {
    /**
     * Constructeur de l'action "erase" sur une dependance.
     * <p>
     * Sauvegarde l'objet contenant la dependance dans l'association "Refer", la dependance
     * concernee dans l'association "Dep" et l'objet reference dans
     * l'association "Ref". On sauvegarde aussi l'indice de l'objet dans
     * l'association.
     *
     * @param obj the modified object
     * @param dep the modified dependency
     * @param ref the removed value
     * @param index the removal index. < 0 is changed to 0.
     */
    @objid ("006d3c7e-0d1e-1f20-85a5-001ec947cd2a")
    public EraseDependencyAction(final SmObjectImpl obj, final SmDependency dep, final SmObjectImpl ref, final int index) {
        super(obj, dep, ref, (index >= 0) ? index : 0);
    }

    @objid ("006d3d14-0d1e-1f20-85a5-001ec947cd2a")
    @Override
    public void accept(IActionVisitor v) {
        v.visitEraseDependencyAction(this);
    }

    /**
     * enleve l'objet "Ref" de la dependance.
     */
    @objid ("006d3dbe-0d1e-1f20-85a5-001ec947cd2a")
    @Override
    public void redoAction() {
        // On enleve l'objet de la dependance sans pour cela recreer une action
        IMetaOf metaOf = this.refered.getMetaOf();
        metaOf.eraseObjDepVal (this.refered, this.smDep, this.ref);
    }

    /**
     * Reinjecte l'objet "ref" dans la dependance .
     */
    @objid ("006d3e4a-0d1e-1f20-85a5-001ec947cd2a")
    @Override
    public void rollbackAction() {
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

    @objid ("b4b28c67-0094-488f-ac64-aa3ebc2254b2")
    @Override
    public String toString() {
        return String.format("remove %s from %s->%s[%d]", this.ref, this.refered, this.smDep, this.index);
    }

}

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
package org.modelio.vcore.smkernel;

import java.util.Collection;
import java.util.HashSet;
import java.util.function.Predicate;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.vbasic.debug.Chronometer;
import org.modelio.vcore.model.ModelWalker;
import org.modelio.vcore.smkernel.mapi.MQueryRunner;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

/**
 * <p>Helper class that deletes a model object.</p>
 */
@objid ("bdae8001-cb6b-11e1-87f1-001ec947ccaf")
@SuppressWarnings("deprecation")
class DeleteHelper {
    /**
     * Initialize the deleter.
     */
    @objid ("bdae8004-cb6b-11e1-87f1-001ec947ccaf")
    public DeleteHelper() {

    }

    /**
     * Delete the given model object
     *
     * @param rootObjToDelete the object to delete.
     */
    @objid ("bdae8007-cb6b-11e1-87f1-001ec947ccaf")
    public void doDelete(SmObjectImpl rootObjToDelete) {
        Chronometer chrono = new Chronometer();
        try ( MQueryRunner query = rootObjToDelete.getMetaOf().query();) {

            // Compute all objects to delete
            Collection<SmObjectImpl> allComponents = new HashSet<>();
            Collection<SmObjectImpl> allObjsToDelete ;


            if (true) {
                // First pass : navigate strong composition associations only
                // to skip remote repositories query
                getAllComponents(rootObjToDelete, allComponents);
                allComponents.add(rootObjToDelete);
                chrono.logNext("DeleteHelper: Found "+allComponents.size()+" components to delete from "+rootObjToDelete);
            } else {
                allComponents.add(rootObjToDelete);
            }

            // Second pass : navigate all "to delete" associations
            allObjsToDelete = new Navigator(query)
                    .from(allComponents)
                    .loadTransitive(dep -> dep.isToDelete());

            chrono.logNext("DeleteHelper: Found "+allObjsToDelete.size()+" elements to delete from "+allComponents.size()+" initial elements.");


            // Set all objects as being deleted
            for (SmObjectImpl obj : allObjsToDelete) {
                obj.getData().setRFlags(IRStatus.BEINGDELETED, 0, 0);
            }

            boolean success = false;
            try {
                // Detach deleted objects from alive ones, only from the other side.
                for (SmObjectImpl objToDel : allObjsToDelete) {
                    SmClass cls = objToDel.getClassOf();
                    for (final SmDependency dep : cls.getAllDepDef()) {
                        if (!dep.isToDelete()) {
                            SmDependency opposite = dep.getSymetric();
                            if (opposite != null) {
                                boolean eraseReadonly = ! isToSkipReadonly(opposite);
                                for (SmObjectImpl target : query.getDepValue(objToDel, dep)) {
                                    // use synchronous status to check isModifiable()
                                    if (target.isValid() && (eraseReadonly || target.getStatus().isModifiable())) {
                                        target.getMetaOf().eraseObjDepVal(target, opposite, objToDel);
                                    }
                                }
                            }
                        }
                    }
                }

                // Set all objects as deleted
                for (SmObjectImpl obj : allObjsToDelete) {
                    obj.getMetaOf().deleteObject(obj);
                }

                success = true;

                chrono.logTotal("DeleteHelper: Deleted "+allObjsToDelete.size()+ " objects.");

            } finally {
                if (!success) {
                    // Transaction will be rollbacked except objects state,
                    // that must be set back here.
                    for (SmObjectImpl obj : allObjsToDelete) {
                        final ISmObjectData data = obj.getData();
                        setAsValid(data);
                    }
                }

            }
        }
    }

    @objid ("00396a66-1199-1f35-b94f-001ec947cd2a")
    private static void setAsValid(final ISmObjectData data) {
        data.setRFlags(0, IRStatus.DELETED | IRStatus.BEINGDELETED, 0);
    }

    @objid ("05786125-0b7e-4334-9c64-6918537fa477")
    private void getAllToDelete(SmObjectImpl obj, Collection<SmObjectImpl> toDelete) {
        toDelete.add(obj);
        final SmClass cls = obj.getClassOf();
        for (final SmDependency dep : cls.getAllDepDef()) {
            if (dep.isToDelete()) {
                for (SmObjectImpl c : obj.getDepValList(dep)) {
                    if (!toDelete.contains(c)) {
                        getAllToDelete(c, toDelete);
                    }
                }
            }
        }
    }

    @objid ("ee68d06b-f801-42f0-bb88-a0adef919c79")
    private void getAllComponents(SmObjectImpl obj, Collection<SmObjectImpl> toDelete) {
        toDelete.add(obj);
        final SmClass cls = obj.getClassOf();
        for (final SmDependency dep : cls.getAllComponentDepDef()) {
            if (dep.isToDelete()) {
                for (SmObjectImpl c : obj.getDepValList(dep)) {
                    if (!toDelete.contains(c)) {
                        getAllComponents(c, toDelete);
                    }
                }
            }
        }
    }

    @objid ("bc547458-54d1-4d68-b6bb-ccf4510fdd1b")
    private boolean isToSkipReadonly(SmDependency dep) {
        return (dep.hasDirective(SmDirective.SMCD_KEEP_DELETED_ON_READONLY));
    }

    /**
     * Service used to navigate transitively a whole model graph.
     * <p>
     * TODO : merge someday with {@link ModelWalker}
     *
     * @since 6.0.1 16/09/2024
     */
    @objid ("9b40310a-e0e0-4b6a-b9f1-fcaa5bce6070")
    @SuppressWarnings("deprecation")
    private static class Navigator {
        @objid ("eeeb20de-6dd0-4e5b-bf39-7d7c9ddb712e")
        private Collection<SmObjectImpl> allSelected = new HashSet<>();

        @objid ("ecd1d227-ac25-40d8-82b9-494ee315752d")
        private Collection<SmObjectImpl> next;

        @objid ("cb5f4d87-506c-437b-b5f3-b070317b3671")
        private Predicate<SmDependency> depFilter;

        @objid ("85007074-a828-4575-81ce-0e4cdeaa2ad9")
        private final MQueryRunner queryRunner;

        @objid ("4cef9de1-24ef-4c25-9456-29172914f2d2")
        public Navigator(MQueryRunner queryRunner) {
            this.queryRunner = queryRunner;
            this.next = new HashSet<>();
        }

        @objid ("95027c94-1ab6-4a7e-834e-2354505a6c3a")
        public Navigator from(SmObjectImpl rootToAdd) {
            this.allSelected.add(rootToAdd);
            this.next.add(rootToAdd);
            return this;
        }

        @objid ("d533d193-b8a3-46ae-b594-0182f61d6922")
        public Navigator from(Collection<SmObjectImpl> rootsToAdd) {
            this.allSelected.addAll(rootsToAdd);
            this.next.addAll(rootsToAdd);
            return this;
        }

        @objid ("c7836a84-59b7-4eed-847b-6ad0ea064da3")
        public Collection<SmObjectImpl> loadTransitive(Predicate<SmDependency> aDepFilter) {
            this.depFilter = aDepFilter;
            return run();
        }

        @objid ("88c05c1d-eef5-4a16-b838-92f2a1574984")
        private Collection<SmObjectImpl> run() {
            int i = 0;
            do {
                step();
                if (++ i > 10_000)
                    throw new StackOverflowError(String.format("%d steps, %d selected, %d next", i, this.allSelected.size(), this.next.size()));
            } while (! this.next.isEmpty());

            return this.allSelected;
        }

        @objid ("cb06fed6-96fc-467a-9e21-b5142ff90855")
        private void step() {
            // Replace this.next with new hash set
            // The set size is 20 <= (current * 2) <= 1,000,000
            Collection<SmObjectImpl> current = this.next;
            this.next = new HashSet<>(Math.min(1_000_000, Math.max(current.size() * 2, 20)));

            // Preload all inverse dependencies
            this.queryRunner.loadAllReferencesTo(current);

            for (SmObjectImpl obj : current) {
                // Preload the whole object too
                obj.getRepositoryObject().loadAtt(obj, null);

                for (SmDependency dep : obj.getClassOf().getAllDepDef()) {
                    if (this.depFilter.test(dep)) {
                        // skip meta object, the dependency is already loaded
                        Collection<SmObjectImpl> targets = this.queryRunner.getDepValue(obj, dep);
                        //Collection<SmObjectImpl> targets = dep.getValueAsCollection(obj.getData());
                        for (SmObjectImpl t : targets) {
                            if (this.allSelected.add(t))
                                this.next.add(t);
                        }
                    }
                }
            }
        }

    }

}

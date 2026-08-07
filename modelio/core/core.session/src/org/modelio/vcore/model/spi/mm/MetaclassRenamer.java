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
package org.modelio.vcore.model.spi.mm;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.vbasic.progress.IModelioProgress;
import org.modelio.vbasic.progress.SubProgress;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.mapi.MDependency;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.SmDependency;
import org.modelio.vcore.smkernel.meta.mof.MofSmClass;
import org.modelio.vcore.smkernel.meta.mof.MofSmObjectImpl;

/**
 * Utility class to rename metaclasses.
 *
 * @author cma
 * @since 3.6
 */
@objid ("ba40200d-52bf-435b-8f0d-a01181eb8aef")
public class MetaclassRenamer {
    @objid ("4b98363f-2c73-4361-a736-93664a7c753e")
    private IMofSession mofSession;

    @objid ("4c95c212-d422-485c-801b-e633d8d8e5ca")
    private final Map<String, MofSmClass[]> mcToTransmute = new HashMap<>();

    /**
     * Optional listener called on each object transmutted.
     */
    @objid ("2970b0ed-a113-42bf-90a8-dd6f2c1c08dc")
    private TransmuteListener listener;

    @objid ("5c5e8a1c-1c02-4e5f-93c6-4da1dbbb5a17")
    public MetaclassRenamer setListener(TransmuteListener listener) {
        this.listener = listener;
        return this;
    }

    /**
     * Register a metaclass renaming.
     *
     * @param oldMetaclass the old metaclass
     * @param newMetaclass the new metaclass.
     * @return
     */
    @objid ("27eb8873-7a96-4ece-b6d2-763a15ea90d1")
    public MetaclassRenamer addClassRenaming(MofSmClass oldMetaclass, MofSmClass newMetaclass) {
        this.mcToTransmute.put(oldMetaclass.getQualifiedName(), new MofSmClass[]{oldMetaclass,newMetaclass });
        return this;
    }

    /**
     * Transmute all elements whose metaclass is renamed.
     *
     * @param monitor a progress monitor
     * @param aMofSession the MOF session to use.
     */
    @objid ("0ebd0289-4338-4f87-9943-2816de6bccbe")
    public void transmuteRenamedClasses(IModelioProgress monitor, IMofSession aMofSession) {
        this.mofSession = aMofSession;
        SubProgress mon = SubProgress.convert(monitor, this.mcToTransmute.size());
        for (MofSmClass[] entry : this.mcToTransmute.values()) {
            if (!entry[0].isAbstract()) {
                for (MofSmObjectImpl obj : this.mofSession.findByClass(entry[0], false)) {
                    MofSmObjectImpl newObj = this.mofSession.transmute(obj, entry[1]);
                    if (this.listener != null)
                        this.listener.onTransmutted(obj, newObj, false);
                }

                for (MofSmObjectImpl obj : getAllForeignReferences(entry[0])) {
                    MofSmObjectImpl newObj = this.mofSession.transmute(obj, entry[1]);
                    if (this.listener != null)
                        this.listener.onTransmutted(obj, newObj, true);
                }
            }
            mon.worked(1);
        }

    }

    /**
     * Get all model objects of the given metaclasses that are not in the repository but
     * are referenced by at least another object.
     * <p>
     * Allows to get model objects not stored in the repository to migrate. Most of them are
     * unresolved references. Unresolved references must be transmuted too when metaclasses names change.
     *
     * @param withSubClasses true to look for sub metaclasses hierarchy.
     * @param metaclass the metaclass to look for
     * @return the found references.
     */
    @objid ("e56965cb-84e3-4cdf-917c-7b0d8a4afbc7")
    private Collection<MofSmObjectImpl> getAllForeignReferences(MClass metaclass) {
        Collection<MofSmObjectImpl> ret = new HashSet<>();

        for (MDependency dep : metaclass.getDependencies(true)) {
            if (!(dep.isComposition() || dep.isSharedComposition() || ((SmDependency) dep).isPartOf())) {
                MDependency opposite = dep.getSymetric();
                if (opposite != null) {
                    MClass mcToLoad = opposite.getSource();

                    getForeignReferences(ret, metaclass, opposite, mcToLoad);
                    MofSmClass renamed = getNewMetaclass(mcToLoad.getQualifiedName());
                    if (renamed != null) {
                        getForeignReferences(ret, metaclass, opposite, renamed);
                    }
                } else {
                    this.mofSession.getReport().getLogger().printf("  Warn: '%s.%s' has no opposite dependency", metaclass.getQualifiedName(), dep);
                }
            }
        }
        return ret;
    }

    /**
     * Add to 'out' all 'dep' dependency values <ul>
     * <li>from 'srcMetaclass' (and sub metaclasses)
     * <li>toward 'targetMetaclass' (without sub metaclasses)
     * <li>that are <b>not</b> in the migrated repository.
     * </ul>
     *
     * @param out all found targetMetaclass foreign references
     * @param targetMetaclass the type of foreign references
     * @param dep the dependency to load for each srcMetaclass instance
     * @param srcMetaclass the metaclass instances to start from
     */
    @objid ("84f6baa6-c9f0-4e40-8dc5-1a54f318a573")
    private void getForeignReferences(Collection<MofSmObjectImpl> out, MClass targetMetaclass, MDependency dep, MClass srcMetaclass) {
        byte targetRepositoryId = this.mofSession.getTargetRepository().getRepositoryId();

        for (MofSmObjectImpl toLoad : this.mofSession.findByClass(srcMetaclass, true)) {
            for (MObject ref : toLoad.mGet(dep)) {
                MofSmObjectImpl mofRef = (MofSmObjectImpl) ref;
                if (mofRef.getRepositoryObject().getRepositoryId() != targetRepositoryId) {
                    MofSmClass refClassOf = mofRef.getClassOf();
                    boolean matches = refClassOf.equals(targetMetaclass);
                    if (matches ) {
                        out.add(mofRef);
                    }
                }
            }
        }

    }

    /**
     * Look for the new metaclass from the old qualified name.
     *
     * @param oldQualifiedName the old metaclass qualified name
     * @return the new metaclass or null.
     */
    @objid ("af5d1c74-62e8-455a-8dc5-32777761f123")
    public MofSmClass getNewMetaclass(String oldQualifiedName) {
        MofSmClass[] entry = this.mcToTransmute.get(oldQualifiedName);
        if (entry != null) {
            return entry[1];
        } else {
            return null;
        }

    }

    /**
     * Optional listener called on each object transmutted.
     */
    @objid ("5f39f53b-920c-46c9-815d-9e988235a7f4")
    public interface TransmuteListener {
        /**
         * called on each object transmutted.
         *
         * @param old the old object. It is now {@link MofSmObjectImpl#isDeleted() deleted} and detached from all references.
         * @param newObj the new object. It has a different identifier than the original one
         * @param isForeign if true, the objects are foreign references, they should be {@link MofSmObjectImpl#isShell() shell}.
         */
        @objid ("377c2346-f037-4231-86f9-e8230e616ee4")
        void onTransmutted(MofSmObjectImpl old, MofSmObjectImpl newObj, boolean isForeign);

    }

}

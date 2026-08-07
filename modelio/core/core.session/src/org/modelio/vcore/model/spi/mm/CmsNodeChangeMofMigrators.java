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

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.vbasic.log.Log;
import org.modelio.vbasic.progress.IModelioProgress;
import org.modelio.vbasic.progress.SubProgress;
import org.modelio.vcore.model.spi.mm.IMigrationReporter.IMigrationLogger;
import org.modelio.vcore.smkernel.mapi.MRef;
import org.modelio.vcore.smkernel.mapi.MetamodelVersionDescriptor;
import org.modelio.vcore.smkernel.meta.descriptor.MClassDescriptor;
import org.modelio.vcore.smkernel.meta.descriptor.MClassRef;
import org.modelio.vcore.smkernel.meta.descriptor.MetamodelDescriptor;
import org.modelio.vcore.smkernel.meta.descriptor.MetamodelFragmentDescriptor;
import org.modelio.vcore.smkernel.meta.mof.MofMetamodel;
import org.modelio.vcore.smkernel.meta.mof.MofMetamodel.MofBuilder;
import org.modelio.vcore.smkernel.meta.mof.MofSmClass;
import org.modelio.vcore.smkernel.meta.mof.MofSmObjectImpl;

/**
 * Service for {@link IMofRepositoryMigratorProvider#getMigrationStepGroup(MetamodelVersionDescriptor, MetamodelVersionDescriptor)}
 * to build migrators for metaclasses whode {@link MofSmClass#isCmsNode() CMS node flag} changed.
 * <p>
 * Usage: call {@link #create(MetamodelVersionDescriptor, MetamodelVersionDescriptor, MetamodelChangeDescriptor)} and add the result to
 * the {@link MigrationStepGroup#addAll(List)} .
 *
 * @author cmarin
 * @since 5.4.1-202401202130
 */
@objid ("c28cf25f-b4e4-4011-9f3d-c3ecf8690f29")
public class CmsNodeChangeMofMigrators {
    /**
     *
     * @param fromMetamodel the source metamodel
     * @param targetMetamodel the target metamodel
     * @param changes the metamodel changes descriptor.
     * @return the created migrators to run in order.
     */
    @objid ("33cf28dd-59a5-4339-8ec2-4bc75a2bb3b9")
    public static List<AbstractMofRepositoryMigrator> create(MetamodelVersionDescriptor fromMetamodel, MetamodelVersionDescriptor targetMetamodel, MetamodelChangeDescriptor changes) {
        if (changes == null || ( changes.getAddedCmsNodes().isEmpty() && changes.getRemovedCmsNodes().isEmpty()))
            return Collections.emptyList();

        CmsNodeChangeMofMigratorsData d = new CmsNodeChangeMofMigratorsData(fromMetamodel, targetMetamodel, changes);
        return Arrays.asList(new A(d), new B(d));
    }

    @objid ("d5874fbf-dc9c-463b-99c8-1fe6b802dfd3")
    private static MofSmClass createTempMc(MofMetamodel metamodel, MofBuilder mmBuilder, MClassRef classRef, boolean cmsNode) {
        String tempClsName = classRef.getClassName()+"_temp";
        String fragmentName = classRef.getFragmentName();

        MofSmClass origMc = (MofSmClass) metamodel.getMClass(classRef.getQualifiedName());
        if (origMc==null)
            throw new IllegalStateException(String.format("No metaclass found for %s .", classRef));

        MofSmClass existing = (MofSmClass) metamodel.getMClass(fragmentName+"."+tempClsName);

        if (existing != null) {
            existing.setIsCmsNode(cmsNode);
            return existing;
        }
        return mmBuilder.createClass(tempClsName, fragmentName, cmsNode)
        .setParent(origMc)
        .setTemporary(true)
        .setVersion(metamodel.getFragment(fragmentName).getVersion())
        .build();

    }

    @objid ("62fd1493-9d53-4a54-b93a-7790621ebdfb")
    private static void logCmsClassChanges(IMigrationLogger logger, MetamodelChangeDescriptor prevMmChanges) {
        for (MClassRef classRef : prevMmChanges.getAddedCmsNodes()) {
            logger.printf(" + %s becomes CMS node %n", classRef.getQualifiedName());
        }
        for (MClassRef classRef : prevMmChanges.getRemovedCmsNodes()) {
            logger.printf(" - %s not CMS node anymore %n", classRef.getQualifiedName());
        }

    }

    @objid ("5cababae-789e-43a4-8657-dfc8b252c75c")
    private static long transmuteAll(IMofSession mofSession, MofMetamodel metamodel, McDebugState mcDebugState, MClassRef classRef, boolean origToTemp) {
        MofSmClass tempMc = (MofSmClass) metamodel.getMClass(classRef.getQualifiedName()+"_temp");
        MofSmClass mc = (MofSmClass) metamodel.getMClass(classRef.getQualifiedName());

        MofSmClass a = origToTemp ? mc : tempMc;
        MofSmClass b = origToTemp ? tempMc : mc;
        IMigrationLogger logger = mofSession.getReport().getLogger();
        logger.printf("  Transmutting all %s%s to %s%s...%n", a, a.isCmsNode() ? "[CMS node]" : "", b, b.isCmsNode() ? "[CMS node]" : "");

        MetaclassRenamer metaclassRenamer = new MetaclassRenamer();
        assert(setupDebugListener(mcDebugState, origToTemp, mc, metaclassRenamer));

        metaclassRenamer.addClassRenaming(a, b);
        metaclassRenamer.transmuteRenamedClasses(null, mofSession);
        return mcDebugState.count;
    }

    @objid ("3aae6e34-07c0-4a57-9247-9220e229fff1")
    private static boolean setupDebugListener(McDebugState mcDebugState, boolean origToTemp, MofSmClass mc, MetaclassRenamer metaclassRenamer) {
        if (origToTemp) {
            metaclassRenamer.setListener((old, newObj, isForeign)
                    -> mcDebugState.record(old));
        } else {
            // record the same metaclass in both case to allow comparisons
            metaclassRenamer.setListener((old, newObj, isForeign)
                    -> mcDebugState.record(new MRef(mc.getQualifiedName(), old.getUuid(), newObj.getName())));
        }
        return true;
    }

    /**
     * Migrator that creates temporary metaclasses for those for which {@link MofSmClass#isCmsNode() CMS node flag} changed,
     * and transmute all instances.
     * The original metaclasses CMS node flag is rolled back first.
     */
    @objid ("17540c2e-8799-4b03-afe7-5702ba1a0a0e")
    private static class A extends AbstractMofRepositoryMigrator {
        @objid ("bf4ab6bc-3860-4c45-8559-b8615031557d")
        private MetaclassRenamer metaclassRenamer = new MetaclassRenamer();

        @objid ("0a3fdc0e-26c8-495f-9e5a-fb0dce873ab8")
        private final CmsNodeChangeMofMigratorsData data;

        @objid ("6d8fb373-a281-48a0-a3a4-28dc97ef4f11")
        public A(CmsNodeChangeMofMigratorsData d) {
            super(d.fromMetamodel, d.targetMetamodel);
            this.setMetamodelChanges(d.changes);
            this.data = d;

        }

        @objid ("18d1f66c-3167-4edc-a11e-54aef21a6a0e")
        @SuppressWarnings ("unused")
        @Override
        public void prepareMetamodel(MofMetamodel metamodel) throws MofMigrationException {
            // revert CMS node change
            // create temporary metaclass with right CMS node flag
            MetamodelChangeDescriptor prevMmChanges = getMetamodelChanges();
            try (MofBuilder mmBuilder = metamodel.builder();) {
                mmBuilder.setTemporary(true);
                for (MClassRef classRef : prevMmChanges.getAddedCmsNodes()) {
                    MofSmClass tempMc = createTempMc(metamodel, mmBuilder, classRef, true);
                    MofSmClass mc = (MofSmClass) metamodel.getMClass(classRef.getQualifiedName());

                    // revert CMS node change
                    mc.setIsCmsNode(false);
                }

                for (MClassRef classRef : prevMmChanges.getRemovedCmsNodes()) {
                    MofSmClass mc = (MofSmClass) metamodel.getMClass(classRef.getQualifiedName());
                    MofSmClass tempMc = createTempMc(metamodel, mmBuilder, classRef, false);

                    // revert CMS node change
                    mc.setIsCmsNode(true);
                }
            }

        }

        @objid ("03b7a0f4-6c38-4689-a982-a6089e34bef0")
        @Override
        public void run(IModelioProgress monitor, IMofSession session) throws MofMigrationException {
            super.run(monitor, session);

            IMigrationLogger logger = session.getReport().getLogger();

            logger.println("Migrating CMS node changes 1/2:");
            logCmsClassChanges(logger, getMetamodelChanges());

            MofMetamodel metamodel = session.getMetamodel();

            MetamodelChangeDescriptor prevMmChanges = getMetamodelChanges();
            SubProgress mon = SubProgress.convert(monitor, prevMmChanges.getAddedCmsNodes().size() + prevMmChanges.getRemovedCmsNodes().size());
            for (MClassRef classRef : prevMmChanges.getAddedCmsNodes()) {
                transmuteAll(session, metamodel, this.data.A.get(classRef), classRef, true);
                mon.worked(1);
            }
            for (MClassRef classRef : prevMmChanges.getRemovedCmsNodes()) {
                transmuteAll(session, metamodel, this.data.A.get(classRef), classRef, true);
                mon.worked(1);
            }

        }

    }

    /**
     * Migrator that recreates the same temporary metaclasses as A ,
     * and transmute all instances of the temporary metaclasses back to the initial metaclass, with the target metamodel CMS node flag.
     */
    @objid ("b44c6a7e-0102-4297-924a-d4b7377f736c")
    private static class B extends AbstractMofRepositoryMigrator {
        @objid ("a80b0bf0-65a1-49e4-9b09-0644e7fc9355")
        private final CmsNodeChangeMofMigratorsData data;

        @objid ("2518e161-7d73-4840-9b46-e54d50a25d8c")
        public B(CmsNodeChangeMofMigratorsData d) {
            super(d.fromMetamodel, d.targetMetamodel);
            this.setMetamodelChanges(d.changes);
            this.data = d;

        }

        @objid ("d1ae49cc-ebfc-4851-be80-457b146efecf")
        @SuppressWarnings ("unused")
        @Override
        public void prepareMetamodel(MofMetamodel metamodel) throws MofMigrationException {
            // recreate temporary metaclass with right CMS node flag
            MetamodelChangeDescriptor prevMmChanges = getMetamodelChanges();
            try (MofBuilder mmBuilder = metamodel.builder();) {
                mmBuilder.setTemporary(true);

                for (MClassRef classRef : prevMmChanges.getAddedCmsNodes()) {
                    MofSmClass tempMc = createTempMc(metamodel, mmBuilder, classRef, true);
                    MofSmClass mc = (MofSmClass) metamodel.getMClass(classRef.getQualifiedName());
                    assert(mc != null);
                }

                for (MClassRef classRef : prevMmChanges.getRemovedCmsNodes()) {
                    MofSmClass mc = (MofSmClass) metamodel.getMClass(classRef.getQualifiedName());
                    MofSmClass tempMc = createTempMc(metamodel, mmBuilder, classRef, false);
                    assert(mc != null);
                }
            }

        }

        @objid ("7b33600e-74f3-46ff-826c-db626fbe20e1")
        @Override
        public void completeFinalMetamodelDescriptor(MetamodelDescriptor desc, IMigrationReporter reporter) throws MofMigrationException {
            IMigrationLogger log = reporter.getLogger();

            MetamodelChangeDescriptor prevMmChanges = getMetamodelChanges();
            for (Entry<String, MetamodelFragmentDescriptor> fragEntry : desc.getFragments().entrySet()) {
                String fragName = fragEntry.getKey();
                for (MClassDescriptor mcd : fragEntry.getValue().getMetaclasses()) {
                    if (prevMmChanges.getAddedCmsNodes().contains(new MClassRef(fragName, mcd.getName()))) {
                        setCmsNode(log, fragName, mcd, true);
                    }
                    if (prevMmChanges.getRemovedCmsNodes().contains(new MClassRef(fragName, mcd.getName()))) {
                        setCmsNode(log, fragName, mcd, false);
                    }
                }
            }

        }

        @objid ("faddaebf-6891-4bd5-867e-0517973bd2ea")
        @Override
        public void run(IModelioProgress monitor, IMofSession session) throws MofMigrationException {
            super.run(monitor, session);

            IMigrationLogger logger = session.getReport().getLogger();
            logger.println("Migrating CMS node changes 2/2");

            MofMetamodel metamodel = session.getMetamodel();

            MetamodelChangeDescriptor prevMmChanges = getMetamodelChanges();
            SubProgress mon = SubProgress.convert(monitor, prevMmChanges.getAddedCmsNodes().size() + prevMmChanges.getRemovedCmsNodes().size());
            for (MClassRef classRef : prevMmChanges.getAddedCmsNodes()) {
                setCmsNode(logger, (MofSmClass) metamodel.getMClass(classRef.getQualifiedName()), true);
                long b1 = transmuteAll(session, metamodel, this.data.B.get(classRef), classRef, false);
                mon.worked(1);
            }
            for (MClassRef classRef : prevMmChanges.getRemovedCmsNodes()) {
                setCmsNode(logger, (MofSmClass) metamodel.getMClass(classRef.getQualifiedName()), false);
                long b2 = transmuteAll(session, metamodel, this.data.B.get(classRef), classRef, false);
                mon.worked(1);
            }

            assert(this.data.checkDebugState(logger));

        }

        @objid ("73c5f5a4-ca39-441e-b36e-7e9e4c1bfd43")
        private void setCmsNode(IMigrationLogger log, MofSmClass c, boolean isCmsNode) {
            if (c.isCmsNode() != isCmsNode) {
                log.format("   %s: Fix %s.cmsNode to %s%n", getClass().getName(), c.getQualifiedName(), isCmsNode);
                c.setIsCmsNode(isCmsNode);
            }

        }

        @objid ("c52964af-6fb3-41ad-82bb-69f962bd2a25")
        private void setCmsNode(IMigrationLogger log, String fragName, MClassDescriptor c, boolean isCmsNode) {
            if (c.isCmsNode() != isCmsNode) {
                log.format(   "%s: Fix %s.%s#cmsNode to %s%n", getClass().getName(), fragName, c.getName(), isCmsNode);
                c.setCmsNode(isCmsNode);
            }

        }

    }

    /**
     * Data to pass to both phases.
     * <p>
     * Currently only used for debugging.
     */
    @objid ("5d2ba345-8377-4fd4-ae7c-fc0ac3069a34")
    private static class CmsNodeChangeMofMigratorsData {
        @objid ("9c1379a8-0f12-4ef2-9573-d93a2f1fbe24")
        public final DebugState A = new DebugState();

        @objid ("35c7ba9d-0138-4a57-ba10-53bfc87a0f6e")
        public final DebugState B = new DebugState();

        @objid ("e20e86e1-6ecc-4922-8390-a7cacbc12de1")
        public final MetamodelVersionDescriptor fromMetamodel;

        @objid ("08ddb4e4-5d4c-4e46-b6d2-1f44b2f7b70b")
        public final MetamodelVersionDescriptor targetMetamodel;

        @objid ("f1926163-2878-45e4-9e83-c8d2ae640af9")
        public final MetamodelChangeDescriptor changes;

        @objid ("2fcb9ff2-ace0-4fbe-b045-285f776b00df")
        public CmsNodeChangeMofMigratorsData(MetamodelVersionDescriptor fromMetamodel, MetamodelVersionDescriptor targetMetamodel, MetamodelChangeDescriptor changes) {
            this.fromMetamodel = fromMetamodel;
            this.targetMetamodel = targetMetamodel;
            this.changes = changes;

        }

        @objid ("1e59e592-84f7-449a-817d-2aeb67031656")
        public boolean checkDebugState(IMigrationLogger logger) {
            McDebugState EMPTY = new McDebugState();
            StringBuilder sb = new StringBuilder();


            for (Entry<MClassRef, McDebugState> enA : this.A.map.entrySet()) {
                McDebugState a = enA.getValue();
                McDebugState b = this.B.map.getOrDefault(enA.getKey(), EMPTY);
                if (a.count == b.count)
                    continue;

                sb.append("*********************************************************************\n");
                sb.append(String.format("%d %s transmutted in phase A, %d transmutted in phase B%n", a.count, enA.getKey(), b.count));

                b.refs.forEach(rb -> {
                    if (!a.refs.contains(rb)) {
                        sb.append(String.format("   - %s transmutted in phase B but not in phase A.%n", rb));
                    }
                });
                a.refs.forEach(ra -> {
                    if (!b.refs.contains(ra)) {
                        sb.append(String.format("   - %s transmutted in phase A but not in phase B.%n", ra));
                    }
                });
                sb.append("*********************************************************************\n");
            }

            if (sb.length() > 0) {
                Log.error(new IllegalStateException(sb.toString()));
            }
            return true;
        }

    }

    @objid ("54187440-e680-4176-bf19-f9d712c92dc6")
    private static class DebugState {
        @objid ("6dc57275-1364-4105-9b49-4f6cd2aae136")
        final Map<MClassRef, McDebugState> map = new HashMap<>();

        @objid ("6b1a2f93-ee75-4c68-af71-c99ee882077d")
        public McDebugState get(MClassRef classRef) {
            return this.map.computeIfAbsent(classRef, r -> new McDebugState());
        }

    }

    @objid ("9993ce31-1096-462d-96d8-b433ff7c1ae4")
    private static class McDebugState {
        @objid ("8a9cfedf-9a9b-4c75-89d3-a696f2122a1d")
        long count;

        @objid ("2e156929-9ee3-4a80-b096-4c7823f5f6b2")
        final Set<MRef> refs = new HashSet<>();

        @objid ("4764d9d1-bb13-43ed-9963-465d489bf277")
        public boolean record(MofSmObjectImpl o) {
            this.count++;
            this.refs.add(new MRef(o));
            return true;
        }

        @objid ("f61b8195-0f06-4eaa-8311-ff1579c8c710")
        public boolean record(MRef o) {
            this.count++;
            this.refs.add(o);
            return true;
        }

    }

}

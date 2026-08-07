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
package org.modelio.archimate.ui.audit;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.WeakHashMap;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.core.structure.ArchimateProject;
import org.modelio.audit.engine.core.AbstractControl;
import org.modelio.audit.engine.core.AuditEntry;
import org.modelio.audit.engine.core.IAuditExecutionPlan.AuditTrigger;
import org.modelio.audit.engine.core.IDiagnosticCollector;
import org.modelio.audit.engine.core.IRule;
import org.modelio.audit.engine.core.IRuleControlPoster;
import org.modelio.audit.service.AuditSeverity;
import org.modelio.vcore.session.api.ICoreSession;
import org.modelio.vcore.session.impl.CoreSession;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.SmClass;

/**
 * R4020 : Elements de meme type et de meme nom
 */
@objid ("e76c7c2a-9967-440a-a9d0-5ecfbf4a6e09")
public class R4020 extends AbstractArchimateRule {
    @objid ("7d96aa57-7884-4698-9882-e55fe54857f7")
    private static final String RULEID = "R4020";

    @objid ("653a5140-0f04-4fb2-b699-80ae667e2a39")
    private static final String[] APPLYTO = new String[] { "Archimate.CourseOfAction", "Archimate.Capability", "Archimate.ValueStream", "Archimate.ApplicationEvent", "Archimate.BusinessEvent", "Archimate.ImplementationEvent", "Archimate.TechnologyEvent",
                "Archimate.ApplicationService", "Archimate.BusinessService", "Archimate.TechnologyService", "Archimate.ApplicationFunction", "Archimate.ApplicationInteraction", "Archimate.ApplicationProcess", "Archimate.BusinessFunction",
                "Archimate.BusinessInteraction", "Archimate.BusinessProcess", "Archimate.TechnologyFunction", "Archimate.TechnologyInteraction", "Archimate.TechnologyProcess", "Archimate.WorkPackage", "Archimate.Product", "Archimate.Location",
                "Archimate.Plateau", "Archimate.Assessment", "Archimate.Driver", "Archimate.Goal", "Archimate.Meaning", "Archimate.Outcome", "Archimate.Principle", "Archimate.Requirement", "Archimate.Constraint", "Archimate.Stakeholder", "Archimate.Value",
                "Archimate.ApplicationInterface", "Archimate.BusinessInterface", "Archimate.TechnologyInterface", "Archimate.BusinessActor", "Archimate.BusinessCollaboration", "Archimate.BusinessRole", "Archimate.ApplicationCollaboration",
                "Archimate.ApplicationComponent", "Archimate.CommunicationNetwork", "Archimate.DistributionNetwork", "Archimate.Path", "Archimate.Node", "Archimate.Device", "Archimate.Equipment", "Archimate.Facility", "Archimate.SystemSoftware",
                "Archimate.TechnologyCollaboration", "Archimate.BusinessObject", "Archimate.Contract", "Archimate.Representation", "Archimate.DataObject", "Archimate.Deliverable", "Archimate.Gap", "Archimate.Artifact", "Archimate.Material",
                "Archimate.Resource" };

    @objid ("4e2d8467-3292-4b87-981c-7039d85645a8")
    private static WeakHashMap<ICoreSession, MObject> singletonObjects = new WeakHashMap<>(3);

    @objid ("be10d848-7d8d-45de-af89-95d9b5e9bd1a")
    @Override
    public String getRuleId() {
        return RULEID;
    }

    @objid ("a1a131c7-d3e7-4fca-a61b-5cf1eaa09fd6")
    @Override
    public void autoRegister(ArchimateAuditPlan plan) {
        for (String mc : APPLYTO) {
            plan.registerRule(mc, this, AuditTrigger.CREATE | AuditTrigger.UPDATE | AuditTrigger.DELETE);
        }

    }

    /**
     * Makes best efforts to returns always the same object from the passed element session.
     * <p>
     * Used to ensure the control is posted only once at all, as it scans the whole model.
     * <p>
     * The result is cached to avoid being constantly computed.
     *
     * @param from a model object
     * @return always the same object.
     */
    @objid ("e669b423-4270-4f39-b53a-1b4e8f445fae")
    private static MObject getSingleton(MObject from) {
        return singletonObjects.computeIfAbsent(CoreSession.getSession(from), R4020::findSingleton);
    }

    /**
     * Makes best efforts to returns always the same object from the passed element session.
     * <p>
     * Used to ensure the control is posted only once at all, as it scans the whole model.
     *
     * @param from a model object
     * @return always the same object.
     */
    @objid ("12cc3d55-a891-4521-b212-6e071da3823e")
    private static MObject findSingleton(ICoreSession from) {
        return from.getModel().findByClass(ArchimateProject.class).stream()
                .sorted(Comparator.comparing(o -> o.getUuid()))
                .findFirst()
                .get();

    }

    @objid ("f9c3d60a-81e5-476b-887f-d820f91a39ba")
    @Override
    public void postUpdateControls(IRuleControlPoster poster, MObject updatedElement) {
        poster.postControl(new CheckR4020(this, updatedElement.getMClass()), getSingleton(updatedElement));
    }

    @objid ("3588b441-7f86-4b00-b671-914f30618a6a")
    @Override
    public void postCreateControls(IRuleControlPoster poster, MObject createdElement) {
        poster.postControl(new CheckR4020(this, createdElement.getMClass()), getSingleton(createdElement));
    }

    @objid ("d435a747-8e38-4c00-979f-f778204a66b4")
    @Override
    public void postDeleteControls(IRuleControlPoster poster, MObject deletedElement, MObject ownerElement) {
        poster.postControl(new CheckR4020(this, deletedElement.getMClass()), getSingleton(ownerElement));
    }

    /**
     * Default constructor
     */
    @objid ("8e0c9c84-edcd-49b8-8278-bf35928f691b")
    public R4020() {

    }

    /**
     * R4020 checker: 2 instances are equal if they scan the same metaclass and are related to the same name.
     */
    @objid ("b6dd8899-2b0a-4326-836f-440d5a4fdf81")
    private static class CheckR4020 extends AbstractControl {
        @objid ("2bd02004-32d6-4b0a-bad9-6dc09fac2bbf")
        private final MClass metaclass;

        @objid ("dbfdc57f-7d6c-44fc-8089-33db094d592a")
        public CheckR4020(IRule rule, MClass metaclass) {
            super(rule);
            this.metaclass = metaclass;

        }

        @objid ("e9ec610d-2837-4f84-9568-eb0d4e73dfdb")
        @Override
        public int hashCode() {
            return Objects.hash(getClass(), this.metaclass);
        }

        @objid ("4743fb4b-c73a-436e-b8ea-a5c87f474d01")
        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            CheckR4020 other = (CheckR4020) obj;
            return Objects.equals(this.metaclass, other.metaclass);
        }

        @objid ("4be7f1a4-691a-400e-9fb6-72f939d8dd3f")
        @Override
        public IDiagnosticCollector doRun(IDiagnosticCollector diagnostic, MObject element) {
            checkR4020(diagnostic, element);
            return diagnostic;
        }

        @objid ("9220f0a7-79ec-4ee8-adc2-ae5cf73df552")
        private void checkR4020(IDiagnosticCollector diagnostic, MObject aRoot) {
            Map<String, List<MObject>> objByName = new HashMap<>();
            CoreSession session = CoreSession.getSession(aRoot);

            for (MObject obj : session.getModel().findByClass(this.metaclass, false)) {
                objByName.computeIfAbsent(obj.getName(), $ -> new ArrayList<>(3)).add(obj);
            }

            for (Entry<String, List<MObject>> entry : objByName.entrySet()) {
                List<Object> linkedObjects = new ArrayList<>();
                if (entry.getValue().size() > 1) {
                    linkedObjects.add(entry.getValue().get(0).getName());
                    linkedObjects.add(entry.getValue().get(0).getMClass().getName());
                    linkedObjects.add(entry.getValue().size());
                    linkedObjects.addAll(entry.getValue());

                    AuditEntry auditEntry = new AuditEntry(
                            this.rule.getRuleId(),
                            this.rule.getSeverity(),
                            entry.getValue().get(0),
                            linkedObjects);
                    diagnostic.addEntry(auditEntry);

                } else {
                    AuditEntry auditEntry = new AuditEntry(this.rule.getRuleId(), AuditSeverity.AuditSuccess, entry.getValue().get(0), null);
                    diagnostic.addEntry(auditEntry);
                }
            }

        }

    }

    @objid ("a9cd4c6a-ffa1-40b3-847e-196adf4c5b3f")
    @Deprecated
    private static class NotUsed {
        @objid ("539b732a-484e-44bf-9015-f3625bb98d6d")
        private WeakHashMap<ICoreSession, SoftReference<State>> stateMap = new WeakHashMap<>(3);

        @objid ("2097d2fc-d89b-4c39-bfc2-f7cf79a6746c")
        public State getState(MObject obj) {
            CoreSession session = CoreSession.getSession(obj);
            SoftReference<State> ref = this.stateMap.get(session);
            if (ref == null || ref.get() == null) {
                ref = new SoftReference<>(new State());
                this.stateMap.put(null, ref);
            }
            return ref.get();
        }

        @objid ("d3e67b7e-64a2-43ec-a77b-b981438bfb40")
        private static class State {
            @objid ("3a04f791-8619-4787-a984-863b47466b33")
            private Map<String, Collection<MObject>> objByName;

            @objid ("31f717c6-0aa1-41c2-814a-6fb5c8a3d847")
            CoreSession session;

            @objid ("c8b30178-20e5-4684-b5cc-985e729105d9")
            public void fill() {
                for (String mcName : APPLYTO) {
                    SmClass mc = this.session.getMetamodel().getMClass(mcName);
                    for (MObject obj : this.session.getModel().findByClass(mc, false)) {
                        this.objByName.computeIfAbsent(obj.getName(), $ -> new ArrayList<>(3)).add(obj);
                    }
                }

            }

        }

    }

}

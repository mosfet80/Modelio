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
package org.modelio.platform.search.engine.searchers.query.internal.executor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.uml.infrastructure.ModelElement;
import org.modelio.platform.search.engine.plugin.SearchEngine;
import org.modelio.platform.search.engine.searchers.query.api.model.query.Direction;
import org.modelio.platform.search.engine.searchers.query.api.model.resolved.ResolvedEdge;
import org.modelio.platform.search.engine.searchers.query.api.model.resolved.ResolvedEdge.EdgeAlternative;
import org.modelio.platform.search.engine.searchers.query.api.model.resolved.ResolvedEdge.LinkObjectEdge;
import org.modelio.platform.search.engine.searchers.query.api.model.resolved.ResolvedEdge.MDependencyEdge;
import org.modelio.platform.search.engine.searchers.query.api.model.resolved.ResolvedStep.TraverseStep;
import org.modelio.platform.search.engine.searchers.query.api.model.result.LinkPathStepOutput;
import org.modelio.platform.search.engine.searchers.query.api.model.result.MDependencyPathStepOutput;
import org.modelio.platform.search.engine.searchers.query.api.model.result.PathOutput;
import org.modelio.platform.search.engine.searchers.query.api.model.result.PathStepOutput;
import org.modelio.platform.utils.log.writers.PluginLogger;
import org.modelio.vcore.session.api.ICoreSession;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.mapi.MDependency;
import org.modelio.vcore.smkernel.mapi.MExpert;
import org.modelio.vcore.smkernel.mapi.MObject;

/**
 * Handles edge traversal for {@link org.modelio.platform.query.api.model.resolved.ResolvedStep.TraverseStep} steps.
 * Navigates MDependency and LinkObject edges, extends path outputs, and validates elements.
 */
@objid ("8bb97a42-6f3e-4b04-b68b-a905257cec6c")
final class TraverseStepExecutor {
    @objid ("e1471bcc-8e78-4d53-88c4-d8b410720138")
    private static final PluginLogger LOG = SearchEngine.LOG;

    @objid ("fc0843e7-6215-4819-bd0e-126749008997")
    private TraverseStepExecutor() {
        // utility class
    }

    /**
     * Wraps a traverse step: navigates edges from each input node and pushes targets downstream.
     * <p>
     * All edge alternatives are traversed with merge semantics (union of results).
     */
    @objid ("af3c37b4-4548-4767-b516-55db89e646bf")
    static Consumer<TraversalItem> wrapTraverse(TraverseStep step, Consumer<TraversalItem> downstream, ICoreSession session) {
        ResolvedEdge edge = step.edge();

        if (edge.isUnknown()) {
            LOG.warning("Traverse step has unknown edge (no resolved alternatives). Swallowing items.");
            return item -> {};
        }

        MExpert expert = session.getMetamodel().getMExpert();

        return item -> {
            for (EdgeAlternative alt : edge.alternatives()) {
                switch (alt) {
                    case MDependencyEdge mde -> traverseMDependencyPush(
                            item.node(), mde, item.path(), step, session, downstream);
                    case LinkObjectEdge loe -> traverseLinkObjectPush(
                            item.node(), loe, item.path(), step, expert, session, downstream);
                }
            }
        };
    }

    /**
     * Pushes MDependency traversal results directly downstream.
     */
    @objid ("050bfbc6-f1c1-44e8-addc-f503643496b6")
    private static void traverseMDependencyPush(MObject node, MDependencyEdge mde, PathOutput currentPath, TraverseStep step, ICoreSession session, Consumer<TraversalItem> downstream) {
        MDependency dep = mde.dependency();

        if (!dep.getSource().isInstance(node)) {
            return;
        }

        List<MObject> targets = node.mGet(dep);
        for (MObject target : targets) {
            if (!isValidElement(target)) {
                if (target != null) {
                    LOG.debug("Traverse step: skipped invalid/deleted element %s", target);
                }
                continue;
            }
            PathOutput extendedPath = extendPathForDep(currentPath, target, dep.getSource(), dep);
            downstream.accept(new TraversalItem(target, extendedPath));
        }
    }

    /**
     * Dispatches link-object traversal to forward or backward based on direction.
     */
    @objid ("f3c032ed-c644-4e33-828b-aca7ff562210")
    private static void traverseLinkObjectPush(MObject node, LinkObjectEdge loe, PathOutput currentPath, TraverseStep step, MExpert expert, ICoreSession session, Consumer<TraversalItem> downstream) {
        switch (loe.direction()) {
            case FORWARD -> traverseLinkForwardPush(
                    node, loe, currentPath, step, expert, session, downstream);
            case BACKWARD -> traverseLinkBackwardPush(
                    node, loe, currentPath, step, expert, session, downstream);
        }
    }

    /**
     * Forward link-object traversal: pushes targets directly downstream.
     * <p>
     * Uses {@code getLinkMetaclassSources()} to find the composition dependency from link to source,
     * then its symmetric to get link objects from the node, and {@code MExpert.getTarget(link)} for the far end.
     */
    @objid ("122d5f71-a1fe-4cc2-ab35-4509bb0f9065")
    private static void traverseLinkForwardPush(MObject node, LinkObjectEdge loe, PathOutput currentPath, TraverseStep step, MExpert expert, ICoreSession session, Consumer<TraversalItem> downstream) {
        MClass linkMetaclass = loe.linkMetaclass();
        Collection<MDependency> sourceDeps = linkMetaclass.getLinkMetaclassSources();

        for (MDependency srcDep : sourceDeps) {
            MDependency opposite = srcDep.getSymetric();
            if (opposite == null) {
                continue;
            }
            if (!opposite.getSource().isInstance(node)) {
                continue;
            }

            List<MObject> links = node.mGet(opposite);
            for (MObject link : links) {
                if (!link.getMClass().hasBase(linkMetaclass)) {
                    continue;
                }
                if (!matchesStereotype(link, loe)) {
                    continue;
                }
                if (step.edgeFilter() != null
                        && !ExpressionEvaluator.evaluate(step.edgeFilter(), link, session)) {
                    continue;
                }

                MObject target = expert.getTarget(link);
                if (!isValidElement(target)) {
                    if (target != null) {
                        LOG.debug("Traverse step: skipped invalid/deleted element %s", target);
                    }
                    continue;
                }
                PathOutput extendedPath = extendPathForLink(currentPath, target, link, Direction.FORWARD);
                downstream.accept(new TraversalItem(target, extendedPath));
            }
        }
    }

    /**
     * Backward link-object traversal: pushes sources directly downstream.
     * <p>
     * Uses {@code getLinkMetaclassTargets()} to find the dependency from link to target,
     * then its symmetric to get link objects from the node, and {@code MExpert.getSource(link)} for the far end.
     */
    @objid ("2710d3a7-2294-46ab-9017-12efb39a3b3b")
    private static void traverseLinkBackwardPush(MObject node, LinkObjectEdge loe, PathOutput currentPath, TraverseStep step, MExpert expert, ICoreSession session, Consumer<TraversalItem> downstream) {
        MClass linkMetaclass = loe.linkMetaclass();
        Collection<MDependency> targetDeps = linkMetaclass.getLinkMetaclassTargets();

        for (MDependency tgtDep : targetDeps) {
            MDependency opposite = tgtDep.getSymetric();
            if (opposite == null) {
                continue;
            }
            if (!opposite.getSource().isInstance(node)) {
                continue;
            }

            List<MObject> links = node.mGet(opposite);
            for (MObject link : links) {
                if (!link.getMClass().hasBase(linkMetaclass)) {
                    continue;
                }
                if (!matchesStereotype(link, loe)) {
                    continue;
                }
                if (step.edgeFilter() != null
                        && !ExpressionEvaluator.evaluate(step.edgeFilter(), link, session)) {
                    continue;
                }

                MObject source = expert.getSource(link);
                if (!isValidElement(source)) {
                    if (source != null) {
                        LOG.debug("Traverse step: skipped invalid/deleted element %s", source);
                    }
                    continue;
                }
                PathOutput extendedPath = extendPathForLink(currentPath, source, link, Direction.BACKWARD);
                downstream.accept(new TraversalItem(source, extendedPath));
            }
        }
    }

    // -----------------------------------------------------------------------
    // Helpers
    // -----------------------------------------------------------------------
    /**
     * Checks whether the link object matches the required stereotype of the edge, if any.
     */
    @objid ("c9c1457d-ed75-4710-89e0-311f1fc8021e")
    private static boolean matchesStereotype(MObject link, LinkObjectEdge loe) {
        if (loe.stereotype() == null) {
            return true; // No stereotype constraint
        }
        if (link instanceof ModelElement me) {
            return me.isStereotyped(loe.stereotype());
        }
        return false;
    }

    /**
     * Checks whether the given model element is non-null, valid and not deleted.
     */
    @objid ("b9229df4-c419-4d20-be0a-d9b6c07e1dfb")
    private static boolean isValidElement(MObject element) {
        return element != null && element.isValid() ;
    }

    /**
     * Extends a path with a new node reached via a link-object traversal.
     */
    @objid ("c37e0209-da79-431f-b831-608689d77543")
    private static PathOutput extendPathForLink(PathOutput existing, MObject newNode, MObject link, Direction direction) {
        List<MObject> newNodes = new ArrayList<>(existing.nodes());
        newNodes.add(newNode);
        List<PathStepOutput> newSteps = new ArrayList<>(existing.steps());
        newSteps.add(new LinkPathStepOutput(link, direction));
        return new PathOutput(List.copyOf(newNodes), List.copyOf(newSteps));
    }

    /**
     * Extends a path with a new node reached via an MDependency traversal.
     */
    @objid ("e7ebca50-e7ff-45b8-bc00-c9e05eca02ff")
    private static PathOutput extendPathForDep(PathOutput existing, MObject newNode, MClass sourceClass, MDependency dep) {
        List<MObject> newNodes = new ArrayList<>(existing.nodes());
        newNodes.add(newNode);
        List<PathStepOutput> newSteps = new ArrayList<>(existing.steps());
        newSteps.add(new MDependencyPathStepOutput(sourceClass, dep));
        return new PathOutput(List.copyOf(newNodes), List.copyOf(newSteps));
    }

}

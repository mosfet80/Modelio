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
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.uml.infrastructure.ModelElement;
import org.modelio.platform.search.engine.plugin.SearchEngine;
import org.modelio.platform.search.engine.searchers.query.api.model.resolved.ResolvedKind;
import org.modelio.platform.search.engine.searchers.query.api.model.resolved.ResolvedKind.AnyKind;
import org.modelio.platform.search.engine.searchers.query.api.model.resolved.ResolvedKind.KindAlternative;
import org.modelio.platform.search.engine.searchers.query.api.model.resolved.ResolvedKind.MetaclassKind;
import org.modelio.platform.search.engine.searchers.query.api.model.resolved.ResolvedKind.NoneKind;
import org.modelio.platform.search.engine.searchers.query.api.model.resolved.ResolvedKind.StereotypeKind;
import org.modelio.platform.search.engine.searchers.query.api.model.resolved.ResolvedSource;
import org.modelio.platform.search.engine.searchers.query.api.model.result.Diagnostic;
import org.modelio.platform.search.engine.searchers.query.api.model.result.Diagnostic.Level;
import org.modelio.platform.search.engine.searchers.query.api.model.result.DiagnosticCode;
import org.modelio.platform.search.engine.searchers.query.api.model.result.PathOutput;
import org.modelio.platform.search.engine.searchers.query.internal.resolver.diagnostics.Diagnostics;
import org.modelio.platform.utils.log.writers.PluginLogger;
import org.modelio.vcore.session.api.ICoreSession;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.mapi.MObject;

/**
 * Evaluates resolved query sources and pushes items/diagnostics into a streaming execution context.
 */
@objid ("90bc3dfa-8913-41ec-a744-910cb44b8dd3")
public final class SourceEvaluator {
    @objid ("121befdf-d806-4541-b1b8-fc00bee75513")
    private static final PluginLogger LOG = SearchEngine.LOG;

    @objid ("f25f5521-dd77-4e1c-825c-e4ca8dad0ce2")
    private SourceEvaluator() {

    }

    @objid ("a672ca4b-a89d-4f31-8b20-2702f7808166")
    public static void evaluate(ResolvedSource source, ICoreSession session, IQueryResponseFiller context) {
        if (source == null) {
            throw new IllegalArgumentException("source must not be null");
        }
        if (session == null) {
            throw new IllegalArgumentException("session must not be null");
        }
        if (context == null) {
            throw new IllegalArgumentException("context must not be null");
        }

        switch (source) {
        case ResolvedSource.ProvidedSource providedSource -> evaluateProvidedSource(providedSource, context);
        case ResolvedSource.AllSource allSource -> evaluateAllSource(allSource, session, context);
        }
    }

    @objid ("a6fe0faa-37ac-4405-850e-9475759074d4")
    private static void evaluateProvidedSource(org.modelio.platform.search.engine.searchers.query.api.model.resolved.ResolvedSource.ProvidedSource source, IQueryResponseFiller context) {
        final List<MObject> skippedElements = new ArrayList<>();
        int totalElements = 0;

        for (MObject element : source.elements()) {
            if (context.isComplete()) {
                return;
            }
            totalElements++;
            pushOrSkipElement(element, skippedElements, context);
        }

        if (skippedElements.isEmpty() && totalElements == 0) {
            context.pushDiagnostic(Diagnostics.info(
                    DiagnosticCode.EMPTY_PROVIDED_SOURCE,
                    SearchEngine.I18N.getMessage("MQL.executor.source.empty")));
            return;
        }

        if (!skippedElements.isEmpty()) {
            context.pushDiagnostic(Diagnostics.warning(
                    DiagnosticCode.INVALID_ELEMENT_SKIPPED,
                    SearchEngine.I18N.getMessage("MQL.executor.element.skipped", Integer.valueOf(skippedElements.size())),
                    skippedElements));
        }
    }

    @objid ("228612cf-553b-4307-9eaa-5b06ca6f9b77")
    private static void evaluateAllSource(org.modelio.platform.search.engine.searchers.query.api.model.resolved.ResolvedSource.AllSource source, ICoreSession session, IQueryResponseFiller context) {
        final ResolvedKind kind = source.kind();
        if (kind.isNone()) {
            context.pushDiagnostic(Diagnostics.warning(
                    DiagnosticCode.UNKNOWN_KIND,
                    SearchEngine.I18N.getMessage("MQL.executor.source.unknown.kind")));
            return;
        }

        LOG.debug("Evaluating AllSource with %d alternatives", kind.alternatives().size());

        final List<MObject> skippedElements = new ArrayList<>();
        for (KindAlternative alternative : kind.alternatives()) {
            if (context.isComplete()) {
                return;
            }

            switch (alternative) {
            case NoneKind k -> {
                // No kind specified, matches nothing
            }
            case AnyKind k -> {
                // Matches any element !
                LOG.warning("Running a MQL query against all the model! expect performances degradation !");
                // TODO internationalize the warning message
                context.pushDiagnostic(new Diagnostic(DiagnosticCode.AMBIGUOUS_KIND, Level.WARNING, "Running a MQL query against the whole model! Expect performances degradation .\nConsider refining the query to target specific metaclasses or stereotypes.", null));

                MClass rootMc = session.getMetamodel().getMClass(MObject.class);
                final Collection<? extends MObject> elements = session.getModel().findByClass(rootMc, true);


                for (MObject element : elements) {
                    if (context.isComplete()) {
                        return;
                    }
                    pushOrSkipElement(element, skippedElements, context);
                }
                // Exit now since AnyKind matches everything
                return;
            }
            case MetaclassKind metaclassKind -> {
                final Collection<? extends MObject> elements = session.getModel().findByClass(metaclassKind.metaclass(), true);
                LOG.debug(
                        "Alternative MetaclassKind(%s) produced %d items",
                        metaclassKind.metaclass().getQualifiedName(),
                        elements.size());
                for (MObject element : elements) {
                    if (context.isComplete()) {
                        return;
                    }
                    pushOrSkipElement(element, skippedElements, context);
                }
            }
            case StereotypeKind stereotypeKind -> {
                final List<ModelElement> elements = stereotypeKind.stereotype().getExtendedElement();
                LOG.debug(
                        "Alternative StereotypeKind(%s) produced %d items",
                        stereotypeKind.stereotype().getName(),
                        elements.size());
                for (ModelElement element : elements) {
                    if (context.isComplete()) {
                        return;
                    }
                    pushOrSkipElement(element, skippedElements, context);
                }
            }
            }
        }

        if (!skippedElements.isEmpty()) {
            context.pushDiagnostic(Diagnostics.warning(
                    DiagnosticCode.INVALID_ELEMENT_SKIPPED,
                    SearchEngine.I18N.getMessage("MQL.executor.element.skipped", Integer.valueOf(skippedElements.size())),
                    skippedElements));
        }
    }

    @objid ("8e9aeb99-c01c-4754-8c75-8c460f26cea6")
    private static void pushOrSkipElement(MObject element, List<MObject> skippedElements, IQueryResponseFiller context) {
        if (isValidElement(element)) {
            context.pushItem(new TraversalItem(element, trivialPath(element)));
        } else if (element != null) {
            skippedElements.add(element);
        }
    }

    @objid ("e671967c-4727-4c8a-b7ec-7bd059fea7b7")
    private static boolean isValidElement(MObject element) {
        return element != null && element.isValid() && !element.isDeleted();
    }

    @objid ("6baf087a-08b0-4c29-87f1-275665f8ec3e")
    private static PathOutput trivialPath(MObject element) {
        return new PathOutput(List.of(element), List.of());
    }

}

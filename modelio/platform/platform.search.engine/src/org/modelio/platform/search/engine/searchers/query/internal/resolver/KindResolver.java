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
package org.modelio.platform.search.engine.searchers.query.internal.resolver;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.uml.infrastructure.Stereotype;
import org.modelio.platform.search.engine.plugin.SearchEngine;
import org.modelio.platform.search.engine.searchers.query.api.model.resolved.ResolvedKind;
import org.modelio.platform.search.engine.searchers.query.api.model.resolved.ResolvedKind.KindAlternative;
import org.modelio.platform.search.engine.searchers.query.api.model.result.Diagnostic;
import org.modelio.platform.search.engine.searchers.query.api.model.result.DiagnosticCode;
import org.modelio.platform.search.engine.searchers.query.internal.resolver.diagnostics.Diagnostics;
import org.modelio.vcore.smkernel.mapi.MClass;

/**
 * Resolver for kind tokens (metaclass + stereotype).
 */
@objid ("901087a7-7199-44cd-894c-e5c373f55ef0")
public final class KindResolver {
    @objid ("59038b5f-30eb-4578-8974-be0c7da09b46")
    private final ResolverContext context;

    @objid ("6eebd72e-0ec5-4d0d-933d-5fe8a9e80e77")
    public KindResolver(ResolverContext context) {
        if (context == null) {
            throw new IllegalArgumentException("context must not be null");
        }
        this.context = context;
    }

    /**
     * Resolve the provided kind token into explicit alternatives.
     * <p>
     * Normalization is trim-only and resolution is case-sensitive.
     *
     * @param rawToken the raw kind token to resolve (may be null or blank)
     * @param diagnostics a list to which resolution diagnostics will be appended (may be null)
     * @return a resolved kind reference with 0 or more alternatives (never null)
     */
    @objid ("9d41736e-79fd-405d-a461-2a44bd535339")
    public ResolvedKind resolve(String rawToken, List<Diagnostic> diagnostics) {
        final String token = normalize(rawToken);
        final List<KindAlternative> alternatives = new ArrayList<>();

        final MClass metaclass = this.context.getMetaclass(token);
        if (metaclass != null) {
            appendAlternativesFor(alternatives, metaclass);
        }

        final List<Stereotype> stereotypes = new ArrayList<>(this.context.findStereotypesByName(token));
        // Sort by UUId so the result is always in the same order,
        // even if the underlying model's findByName returns them in a non-deterministic order (e.g., due to hash-based collections)
        stereotypes.sort(Comparator.comparing(Stereotype::getUuid));
        for (Stereotype stereotype : stereotypes) {
            alternatives.add(new ResolvedKind.StereotypeKind(stereotype));
        }

        final ResolvedKind resolvedKind = (alternatives.isEmpty()) ? ResolvedKind.none() : new ResolvedKind(alternatives);
        emitDiagnostics(token, resolvedKind, diagnostics);
        return resolvedKind;
    }

    @objid ("0b9813cc-176a-4ba7-9de4-4ddf0f2f56d3")
    private void appendAlternativesFor(final List<KindAlternative> alternatives, final MClass metaclass) {
        alternatives.add(new ResolvedKind.MetaclassKind(metaclass));

        // if metaclass is abstract , add all sub metaclasses as alternatives
        if (metaclass.isAbstract()) {
            for (MClass subMetaclass : metaclass.getSub(true)) {
                if (! subMetaclass.isAbstract()) {
                    alternatives.add(new ResolvedKind.MetaclassKind(subMetaclass));
                }
            }
        }
    }

    @objid ("fc0142d3-aef1-4155-ba34-698ad65e0971")
    private static String normalize(String rawToken) {
        return (rawToken == null) ? "" : rawToken.trim();
    }

    @objid ("875e6508-39f6-4524-bdac-28565d0f700d")
    private static void emitDiagnostics(String token, ResolvedKind resolvedKind, List<Diagnostic> diagnostics) {
        if (diagnostics == null) {
            return;
        }
        if (token.isBlank()) {
            diagnostics.add(Diagnostics.warning(DiagnosticCode.UNKNOWN_KIND, SearchEngine.I18N.getMessage("MQL.resolver.kind.unknown.blank")));
            return;
        }
        final int count = resolvedKind.alternatives().size();
        if (count == 0 || resolvedKind.isNone()) {
            diagnostics.add(Diagnostics.warning(DiagnosticCode.UNKNOWN_KIND, SearchEngine.I18N.getMessage("MQL.resolver.kind.unknown", token)));
        } else if (count > 1 ) {
            diagnostics.add(Diagnostics.warning(DiagnosticCode.AMBIGUOUS_KIND, SearchEngine.I18N.getMessage("MQL.resolver.kind.ambiguous", token, Integer.valueOf(count))));
        }
    }

    @objid ("e32b0b45-5394-42c5-b9fa-0d56e7788353")
    private static String renderAlternatives(ResolvedKind resolvedKind) {
        final StringBuilder builder = new StringBuilder();
        for (ResolvedKind.KindAlternative alternative : resolvedKind.alternatives()) {
            if (!builder.isEmpty()) {
                builder.append(", ");
            }

            if (alternative instanceof ResolvedKind.MetaclassKind metaclassKind) {
                builder.append("metaclass=").append(metaclassKind.metaclass().getQualifiedName());
            } else if (alternative instanceof ResolvedKind.StereotypeKind stereotypeKind) {
                builder.append("stereotype=")
                        .append(safeName(stereotypeKind.stereotype()))
                        .append("[base=")
                        .append(safeBaseClassName(stereotypeKind.stereotype()))
                        .append("]");
            }
        }
        return builder.toString();
    }

    @objid ("84f63154-dd2c-4024-99fd-234437a942a3")
    private static String safeName(Stereotype s) {
        try {
            final String name = s.getName();
            return (name == null) ? "" : name;
        } catch (RuntimeException e) {
            return "";
        }
    }

    @objid ("5234544b-bb99-4de7-8a1e-8834837e7c44")
    private static String safeBaseClassName(Stereotype s) {
        try {
            final String base = s.getBaseClassName();
            return (base == null) ? "" : base;
        } catch (RuntimeException e) {
            return "";
        }
    }

}

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
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.uml.infrastructure.Stereotype;
import org.modelio.platform.search.engine.plugin.SearchEngine;
import org.modelio.platform.search.engine.searchers.query.api.model.query.Direction;
import org.modelio.platform.search.engine.searchers.query.api.model.resolved.ResolvedEdge;
import org.modelio.platform.search.engine.searchers.query.api.model.resolved.ResolvedEdge.EdgeAlternative;
import org.modelio.platform.search.engine.searchers.query.api.model.resolved.ResolvedEdge.LinkObjectEdge;
import org.modelio.platform.search.engine.searchers.query.api.model.resolved.ResolvedEdge.MDependencyEdge;
import org.modelio.platform.search.engine.searchers.query.api.model.resolved.ResolvedKind;
import org.modelio.platform.search.engine.searchers.query.api.model.result.Diagnostic;
import org.modelio.platform.search.engine.searchers.query.api.model.result.DiagnosticCode;
import org.modelio.platform.search.engine.searchers.query.internal.resolver.diagnostics.Diagnostics;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.mapi.MDependency;

/**
 * Resolver for traverse edge tokens.
 */
@objid ("dbfd49b0-ac1e-49ed-b7b9-81251a4bead2")
public final class EdgeResolver {
    @objid ("6cd69934-b8bd-4fe2-b86f-ab371ae79050")
    private final EdgeRegistry registry;

    @objid ("83e4e482-60f8-415c-85fa-5716ce1f4981")
    public EdgeResolver(EdgeRegistry registry) {
        if (registry == null) {
            throw new IllegalArgumentException("registry must not be null");
        }
        this.registry = registry;
    }

    /**
     * Resolve the provided edge token into explicit alternatives.
     * <p>
     * Normalization is trim-only and resolution is case-sensitive.
     * Only alternatives compatible with the provided {@code currentKind} are retained.
     *
     * @param rawToken the raw edge token to resolve
     * @param direction the traversal direction
     * @param currentKind the current kind to filter by, or {@code null} to skip filtering
     * @param diagnostics a list to which resolution diagnostics will be appended, or null
     * @return a resolved edge reference, never null (but possibly with an empty set of alternatives)
     */
    @objid ("fe7d815c-a65a-42de-83c5-130410f11169")
    public ResolvedEdge resolve(String rawToken, Direction direction, ResolvedKind currentKind, List<Diagnostic> diagnostics) {
        Objects.requireNonNull(currentKind);

        final String token = normalize(rawToken);

        final List<EdgeAlternative> dependencyAlternatives = new ArrayList<>();
        final List<MDependency> deps = new ArrayList<>(this.registry.findDependenciesByName(token));
        deps.sort(Comparator
                .comparing( (MDependency dep) -> dep.getSource().getQualifiedName())
                .thenComparing((MDependency dep) -> dep.getName())
                .thenComparing((MDependency dep) -> dep.getTarget().getQualifiedName()));
        for (MDependency dep : deps) {
            final MDependencyEdge edge = new MDependencyEdge(dep);
            if (currentKind.isAny() || isEdgeSourceCompatible(edge, currentKind)) {
                dependencyAlternatives.add(edge);
            }
        }

        final List<EdgeAlternative> linkAlternatives = new ArrayList<>();
        final MClass linkMetaclass = this.registry.getMetaclass(token);
        if (linkMetaclass != null) {
            final LinkObjectEdge link = new LinkObjectEdge(linkMetaclass, null, direction);
            if (currentKind.isAny() || isLinkCompatible(link, currentKind)) {
                linkAlternatives.add(link);
            }
        }

        final List<Stereotype> stereotypes = new ArrayList<>(this.registry.findStereotypesByName(token));
        stereotypes.sort(Comparator
                .comparing(Stereotype::getUuid));
        for (Stereotype st : stereotypes) {
            final MClass base = this.registry.getMetaclass(safeStereotypeBase(st));
            if (base != null) {
                final LinkObjectEdge link = new LinkObjectEdge(base, st, direction);
                if (currentKind.isAny() || isLinkCompatible(link, currentKind)) {
                    linkAlternatives.add(link);
                }
            }
        }

        linkAlternatives.sort(Comparator
                .comparing(EdgeResolver::linkMetaclassQualifiedName)
                .thenComparing(EdgeResolver::linkStereotypeUuid));

        final List<EdgeAlternative> alternatives = new ArrayList<>(dependencyAlternatives.size() + linkAlternatives.size());
        alternatives.addAll(dependencyAlternatives);
        alternatives.addAll(linkAlternatives);

        final ResolvedEdge resolved = new ResolvedEdge(alternatives);
        emitDiagnostics(token, resolved, currentKind, diagnostics);
        return resolved;
    }

    @objid ("86fb271a-67a4-433c-a2cf-521e0d89dc5b")
    private static String normalize(String rawToken) {
        return (rawToken == null) ? "" : rawToken.trim();
    }

    @objid ("d32f8a5e-d977-4fd5-ba19-8b4ae868838b")
    private static void emitDiagnostics(String token, ResolvedEdge resolvedEdge, ResolvedKind currentKind, List<Diagnostic> diagnostics) {
        if (diagnostics == null) {
            return;
        }
        if (token.isBlank()) {
            diagnostics.add(Diagnostics.error(DiagnosticCode.UNKNOWN_EDGE, SearchEngine.I18N.getMessage("MQL.resolver.edge.unknown.blank")));
            return;
        }
        final int count = resolvedEdge.alternatives().size();
        if (count == 0) {
            diagnostics.add(Diagnostics.warning(DiagnosticCode.UNKNOWN_EDGE, SearchEngine.I18N.getMessage(
                    "MQL.resolver.edge.unknown",
                    token,
                    currentKind)));
        } else if (count > 1) {
            diagnostics.add(Diagnostics.warning(DiagnosticCode.AMBIGUOUS_EDGE, SearchEngine.I18N.getMessage(
                    "MQL.resolver.edge.ambiguous",
                    token,
                    count,
                    currentKind,
                    renderAlternatives(resolvedEdge))));
        }
    }

    @objid ("508230bf-94a0-4bce-8fac-1ad93de5716c")
    private static String renderAlternatives(ResolvedEdge resolvedEdge) {
        final StringBuilder builder = new StringBuilder();
        for (EdgeAlternative alternative : resolvedEdge.alternatives()) {
            if (!builder.isEmpty()) {
                builder.append(", ");
            }
            if (alternative instanceof MDependencyEdge dependency) {
                builder.append("dependency=")
                        .append(dependency.dependency().getSource().getQualifiedName())
                        .append("::")
                        .append(dependency.dependency().getName())
                        .append("->")
                        .append(dependency.dependency().getTarget().getQualifiedName());
            } else if (alternative instanceof LinkObjectEdge link) {
                builder.append("link=").append(link.linkMetaclass().getQualifiedName());
                if (link.stereotype() != null) {
                    builder.append("[stereotype=")
                            .append(safeStereotypeName(link.stereotype()))
                            .append("]");
                }
            }
        }
        return builder.toString();
    }

    @objid ("3342c152-f33e-47e9-887a-30e0a3c07f9d")
    private static String safeStereotypeName(Stereotype s) {
        try {
            return s.getName();
        } catch (RuntimeException e) {
            return "";
        }
    }

    @objid ("0c4a854f-4fe0-468f-9175-533725860b55")
    private static String safeStereotypeBase(Stereotype s) {
        try {
            final String base = s.getBaseClassName();
            return (base == null) ? "" : base;
        } catch (RuntimeException e) {
            return "";
        }
    }

    @objid ("efe97fe1-360b-4a0e-86c0-3f14dafcf261")
    private static String linkMetaclassQualifiedName(EdgeAlternative alt) {
        if (alt instanceof LinkObjectEdge link) {
            return link.linkMetaclass().getQualifiedName();
        }
        return "";
    }

    @objid ("ccf4bb39-2f40-4e27-9407-7422446bae2c")
    private static String linkStereotypeUuid(EdgeAlternative alt) {
        if (alt instanceof LinkObjectEdge link) {
            return link.stereotype().getUuid();
        }
        return "";
    }

    // --- Kind-based filtering helpers ---
    /**
     * Tells whether the provided dependency edge is compatible with the provided current kind,
     * by checking if at least one of the current kind alternatives is compatible with the dependency source.
     *
     * @param dependency the dependency edge to check source compatibility for
     * @param currentKind the current kind to check against
     * @return true if the dependency edge is compatible with the current kind, false otherwise
     */
    @objid ("bc822328-426f-4550-93f9-55403e298ecc")
    private boolean isEdgeSourceCompatible(MDependencyEdge dependency, ResolvedKind currentKind) {
        for (ResolvedKind.KindAlternative kindAlt : currentKind.alternatives()) {
            final MClass metaclass = toMetaclass(kindAlt);
            if (metaclass == null) {
                continue;
            }
            if (isDependencySourceCompatible(dependency, metaclass)) {
                return true;
            }
        }
        return false;
    }

    @objid ("06220ee5-b17c-4533-9925-0e283ac01e6d")
    private static boolean isDependencySourceCompatible(MDependencyEdge dependency, MClass currentMetaclass) {
        final MDependency dep = dependency.dependency();
        final Direction direction = dependency.direction();
        if (direction == Direction.BACKWARD) {
            throw new IllegalArgumentException("Backward direction not supported for dependencies: " + dep.getSource().getQualifiedName() + "::" + dep.getName() + "->" + dep.getTarget().getQualifiedName());
            //return isCompatibleMetaclass(currentMetaclass, dep.getTarget());
        }
        return isCompatibleMetaclass(currentMetaclass, dep.getSource());
    }

    @objid ("d9240da4-b99f-4436-9dac-0d0d8a716440")
    private boolean isLinkCompatible(LinkObjectEdge link, ResolvedKind currentKind) {
        for (ResolvedKind.KindAlternative kindAlt : currentKind.alternatives()) {
            final MClass metaclass = toMetaclass(kindAlt);
            if (metaclass == null) {
                continue;
            }
            boolean checkSource = (link.direction() == Direction.FORWARD);
            if (matchesLinkEndpoint(link.linkMetaclass(), metaclass, checkSource)) {
                return true;
            }
        }
        return false;
    }

    @objid ("bc087a97-058d-4867-a6f1-9e098fa67bd7")
    private boolean matchesLinkEndpoint(MClass linkMetaclass, MClass currentMetaclass, boolean checkSources) {
        final Collection<MDependency> deps = checkSources ? linkMetaclass.getLinkMetaclassSources() : linkMetaclass.getLinkMetaclassTargets();

        if (deps == null || deps.isEmpty()) {
            return false;
        }

        for (MDependency dep : deps) {
            if (dep == null) {
                continue;
            }
            if (isCompatibleMetaclass(currentMetaclass, dep.getTarget())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Tell whether the provided current metaclass is compatible with the expected metaclass:
     * <ul>
     * <li> if the current metaclass is null, it's not compatible with any expected metaclass.
     * <li> if the expected metaclass is null, it's not compatible with any current metaclass.
     * <li> if the current metaclass is same or a subtype of the expected metaclass, then it's compatible.
     * <li> if the current metaclass is a supertype of the expected metaclass, then it MAY be compatible .
     * It means filtering will have to be done at execution time, since the expected metaclass is not specific enough to guarantee that all its subtypes are valid.
     * </ul>
     *
     * @param currentMetaclass the current metaclass to check compatibility for
     * @param expected the expected metaclass to check compatibility against
     * @return true if the current metaclass is compatible with the expected metaclass, false otherwise
     */
    @objid ("f67c6633-f8bf-4444-8125-e8b1636dbac5")
    private static boolean isCompatibleMetaclass(MClass currentMetaclass, MClass expected) {
        if (currentMetaclass == null || expected == null) {
            return false;
        }
        if ( currentMetaclass.hasBase(expected)) {
            // current is same or subtype of expected: compatible
            return true;
        } else if (expected.hasBase(currentMetaclass)) {
            // current is supertype of expected: maybe compatible, filtering needed at execution time
            return true;
        }

        // current and expected are unrelated: not compatible
        return false;
    }

    @objid ("86999722-74aa-40fe-9283-27085b43718d")
    private MClass toMetaclass(org.modelio.platform.search.engine.searchers.query.api.model.resolved.ResolvedKind.KindAlternative kindAlternative) {
        if (kindAlternative instanceof ResolvedKind.MetaclassKind metaclassKind) {
            return metaclassKind.metaclass();
        }
        if (kindAlternative instanceof ResolvedKind.StereotypeKind stereotypeKind) {
            final String baseName = stereotypeKind.stereotype().getBaseClassName();
            if (baseName == null || baseName.isBlank()) {
                return null;
            }
            return this.registry.getMetaclass(baseName);
        }
        return null;
    }

}

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
import org.modelio.metamodel.uml.infrastructure.MetaclassReference;
import org.modelio.metamodel.uml.infrastructure.NoteType;
import org.modelio.metamodel.uml.infrastructure.Stereotype;
import org.modelio.metamodel.uml.infrastructure.TagType;
import org.modelio.platform.search.engine.plugin.SearchEngine;
import org.modelio.platform.search.engine.searchers.query.api.model.resolved.ResolvedKind;
import org.modelio.platform.search.engine.searchers.query.api.model.resolved.ResolvedProperty;
import org.modelio.platform.search.engine.searchers.query.api.model.resolved.ResolvedProperty.PropertyAlternative;
import org.modelio.platform.search.engine.searchers.query.api.model.result.Diagnostic;
import org.modelio.platform.search.engine.searchers.query.api.model.result.DiagnosticCode;
import org.modelio.platform.search.engine.searchers.query.internal.resolver.diagnostics.Diagnostics;
import org.modelio.vcore.smkernel.mapi.MAttribute;
import org.modelio.vcore.smkernel.mapi.MObject;

/**
 * Resolver for property key tokens.
 */
@objid ("6df37e56-46f1-4348-85b0-41eb474c2e27")
public final class PropertyKeyResolver {
    @objid ("eccd58d6-4e7a-495e-8431-cfc6f9dac7c1")
    private final PropertyKeyRegistry registry;

    @objid ("319d1cfe-9ae0-44bd-8026-1cd442ca6ab5")
    public PropertyKeyResolver(PropertyKeyRegistry registry) {
        if (registry == null) {
            throw new IllegalArgumentException("registry must not be null");
        }
        this.registry = registry;
    }

    /**
     * Resolve the provided property key token into explicit alternatives.
     * <p>
     * Normalization is trim-only and resolution is case-sensitive.
     * Only alternatives compatible with the provided {@code currentKind} are retained.
     *
     * @param rawToken the raw property key token to resolve
     * @param currentKind the current kind to filter by, not null.
     * @param outDiagnostics a list to which resolution diagnostics will be appended, or null if no diagnostics should be emitted
     * @return a resolved property key reference, never null (but possibly with an empty set of alternatives)
     */
    @objid ("c311fdd0-0638-4168-83a6-fb3913714505")
    public ResolvedProperty resolve(String rawToken, ResolvedKind currentKind, List<Diagnostic> outDiagnostics) {
        final String token = normalize(rawToken);
        final List<PropertyAlternative> alternatives = new ArrayList<>();

        final List<MAttribute> attributes = new ArrayList<>(this.registry.findAttributesByName(token, currentKind));
        attributes.sort(Comparator
                .comparing(PropertyKeyResolver::attributeSortKey)
                .thenComparing(MAttribute::getName));
        for (MAttribute attribute : attributes) {
            alternatives.add(new ResolvedProperty.ResolvedMAttribute(attribute));
        }

        final List<TagType> tagTypes = new ArrayList<>(this.registry.findTagTypesByName(token, currentKind));
        tagTypes.sort(Comparator
                .comparing(PropertyKeyResolver::tagTypeSortKey)
                .thenComparing(PropertyKeyResolver::safeName));
        for (TagType tagType : tagTypes) {
            alternatives.add(new ResolvedProperty.ResolvedTagType(tagType));
        }

        final List<NoteType> noteTypes = new ArrayList<>(this.registry.findNoteTypesByName(token, currentKind));
        noteTypes.sort(Comparator
                .comparing(PropertyKeyResolver::noteTypeSortKey)
                .thenComparing(PropertyKeyResolver::safeName));
        for (NoteType noteType : noteTypes) {
            alternatives.add(new ResolvedProperty.ResolvedNoteType(noteType));
        }

        final List<PropertyKeyRegistry.PropertyDefinitionCandidate> definitions =
                new ArrayList<>(this.registry.findPropertyDefinitionsByName(token, currentKind));
        definitions.sort(Comparator
            .comparing(PropertyKeyResolver::propertyDefinitionSortKey)
            .thenComparing(candidate -> safeName(candidate.definition())));
        for (PropertyKeyRegistry.PropertyDefinitionCandidate candidate : definitions) {
            alternatives.add(new ResolvedProperty.ResolvedPropertyDefinition(candidate.definition(), candidate.owner()));
        }

        final ResolvedProperty resolved = new ResolvedProperty(alternatives);
        emitDiagnostics(token, resolved, outDiagnostics);
        return resolved;
    }

    @objid ("84b8df65-8d65-4e04-9cde-d2e7ff03dd46")
    private static String normalize(String rawToken) {
        return (rawToken == null) ? "" : rawToken.trim();
    }

    /**
     * Check the resolution result and emit diagnostics if the token is blank, unknown, or ambiguous.
     *
     * @param token the normalized token that was resolved
     * @param resolvedKey the resolved property key reference, with its alternatives
     * @param outDiagnostics a list to which diagnostics will be appended, or null if no diagnostics should be emitted
     */
    @objid ("0d7d59a3-1b59-4570-86a3-8fa47a37da99")
    private static void emitDiagnostics(String token, ResolvedProperty resolvedKey, List<Diagnostic> outDiagnostics) {
        if (outDiagnostics == null) {
            return;
        }

        if (token.isBlank()) {
            outDiagnostics.add(Diagnostics.warning(DiagnosticCode.UNKNOWN_PROPERTY, SearchEngine.I18N.getMessage("MQL.resolver.property.unknown.blank")));
            return;
        }
        final int count = resolvedKey.alternatives().size();
        if (count == 0) {
            outDiagnostics.add(Diagnostics.warning(DiagnosticCode.UNKNOWN_PROPERTY, SearchEngine.I18N.getMessage("MQL.resolver.property.unknown", token)));
            return;
        }
        if (count > 1) {
            outDiagnostics.add(Diagnostics.warning(
                    DiagnosticCode.AMBIGUOUS_PROPERTY,
                    SearchEngine.I18N.getMessage("MQL.resolver.property.ambiguous", token, Integer.valueOf(count))));
        }
    }

    @objid ("ef3b89d0-b7e8-4194-a814-fa2452f6c2e6")
    private static String attributeSortKey(MAttribute attribute) {
        return attribute.getName() + ":" + attribute.getType().getName();
    }

    @objid ("8af97c36-cb96-49f5-a32e-0919c19c3fc5")
    private static String tagTypeSortKey(TagType tagType) {
        return safeName(tagType) + ":" + ownerLabel(tagType.getOwnerStereotype(), tagType.getOwnerReference());
    }

    @objid ("629c75b5-2caa-49f3-8785-36ad0275dfd0")
    private static String noteTypeSortKey(NoteType noteType) {
        return safeName(noteType) + ":" + ownerLabel(noteType.getOwnerStereotype(), noteType.getOwnerReference());
    }

    @objid ("3be06754-36c4-4648-88ae-4cf32f2e74e4")
    private static String propertyDefinitionSortKey(org.modelio.platform.search.engine.searchers.query.internal.resolver.PropertyKeyRegistry.PropertyDefinitionCandidate candidate) {
        return ownerLabel(candidate.owner()) + ":" + safeName(candidate.definition());
    }

    @objid ("8c2eb977-10f4-4708-a0fe-185682968d97")
    private static String ownerLabel(org.modelio.platform.search.engine.searchers.query.api.model.resolved.ResolvedProperty.PropertyTableOwner owner) {
        if (owner instanceof ResolvedProperty.OwnerStereotype st) {
            return "stereotype:" + safeName(st.stereotype());
        }
        if (owner instanceof ResolvedProperty.OwnerReference ref) {
            return "metaclass:" + safeMetaclassReferenceName(ref.reference());
        }
        return "owner";
    }

    @objid ("e330559e-341a-42db-9554-c84a3f109bfa")
    private static String ownerLabel(Stereotype stereotype, MetaclassReference reference) {
        if (stereotype != null) {
            return "stereotype:" + safeName(stereotype);
        }
        if (reference != null) {
            return "metaclass:" + safeMetaclassReferenceName(reference);
        }
        return "owner";
    }

    @objid ("a59d2a42-4858-4342-8160-e5dcf40be14b")
    private static String safeMetaclassReferenceName(MetaclassReference reference) {
        try {
            final String name = reference.getReferencedClassName();
            return (name == null) ? "" : name;
        } catch (RuntimeException e) {
            return "";
        }
    }

    @objid ("9a9e18e9-22fe-4a8c-8a3a-01dff810de2e")
    private static String safeName(MObject reference) {
        try {
            final String name = reference.getName();
            return (name == null) ? "" : name;
        } catch (RuntimeException e) {
            return "";
        }
    }

}

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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.mda.ModuleComponent;
import org.modelio.metamodel.uml.infrastructure.MetaclassReference;
import org.modelio.metamodel.uml.infrastructure.ModelElement;
import org.modelio.metamodel.uml.infrastructure.NoteType;
import org.modelio.metamodel.uml.infrastructure.Profile;
import org.modelio.metamodel.uml.infrastructure.Stereotype;
import org.modelio.metamodel.uml.infrastructure.TagType;
import org.modelio.metamodel.uml.infrastructure.properties.PropertyDefinition;
import org.modelio.metamodel.uml.infrastructure.properties.PropertyTableDefinition;
import org.modelio.platform.search.engine.searchers.query.api.model.resolved.ResolvedKind;
import org.modelio.platform.search.engine.searchers.query.api.model.resolved.ResolvedProperty;
import org.modelio.vcore.smkernel.mapi.MAttribute;
import org.modelio.vcore.smkernel.mapi.MClass;

/**
 * Small, per-resolution property key lookup index.
 * <p>
 * The registry indexes attributes, tag types, note types, and property
 * definitions so property key resolution can be done without scanning the whole
 * model repeatedly.
 */
@objid ("09d726ff-f331-4e3a-9a46-5daff0cf5d3e")
public final class PropertyKeyRegistry {
    @objid ("2a2874da-c830-4dd9-888e-508117c79b11")
    private final ResolverContext context;

    @objid ("24d68787-6a40-4064-9791-080d70363434")
    private volatile Map<String, List<MAttribute>> attributesByName;

    @objid ("579c976e-c7c2-4fcf-a60d-cc768e5d8885")
    private volatile Map<String, List<TagType>> tagTypesByName;

    @objid ("8c6222ec-7dc3-4438-ac3c-18af087f507c")
    private volatile Map<String, List<NoteType>> noteTypesByName;

    @objid ("2fc089a7-d66a-41c6-a6f7-d7b194e308e8")
    private volatile Map<String, List<PropertyDefinitionCandidate>> propertyDefinitionsByName;

    @objid ("7be3a9e2-a734-444c-9ba4-e0c09ab0203e")
    public PropertyKeyRegistry(ResolverContext context) {
        if (context == null) {
            throw new IllegalArgumentException("context must not be null");
        }
        this.context = context;
    }

    /**
     * Find attributes matching the given token, filtered by kind compatibility.
     *
     * @param token attribute name (trimmed, case-sensitive)
     * @param currentKind the current kind to filter by, not null.
     * @return matching attributes (never null)
     */
    @objid ("eaef11c4-ffc7-4985-b00d-42b5dfa76eed")
    public List<MAttribute> findAttributesByName(String token, ResolvedKind currentKind) {
        if (token == null || token.isBlank() || currentKind.isNone()) {
            return List.of();
        }
        ensureIndex();
        final List<MAttribute> all = this.attributesByName.getOrDefault(token, List.of());
        if (currentKind.isAny()) {
            return all;
        }
        return filterAttributesByKind(all, currentKind);
    }

    /**
     * Find tag types matching the given token, filtered by kind compatibility.
     *
     * @param token tag type name (trimmed, case-sensitive)
     * @param currentKind the current kind to filter by, or {@code null} to skip
     * filtering
     * @return matching tag types (never null)
     */
    @objid ("56925007-ae9d-46b7-a1b8-28f1c7032e5a")
    public List<TagType> findTagTypesByName(String token, ResolvedKind currentKind) {
        if (token == null || token.isBlank() || currentKind.isNone()) {
            return List.of();
        }

        ensureIndex();
        final List<TagType> all = this.tagTypesByName.getOrDefault(token, List.of());
        if (currentKind.isAny()) {
            return all;
        }
        return filterTagTypesByKind(all, currentKind);
    }

    /**
     * Find note types matching the given token, filtered by kind compatibility.
     *
     * @param token note type name (trimmed, case-sensitive)
     * @param currentKind the current kind to filter by, not null.
     * @return matching note types (never null)
     */
    @objid ("df4f17be-2cba-4a8b-b3be-d4a1f4fedc72")
    public List<NoteType> findNoteTypesByName(String token, ResolvedKind currentKind) {
        if (token == null || token.isBlank() || currentKind.isNone()) {
            return List.of();
        }
        ensureIndex();
        final List<NoteType> all = this.noteTypesByName.getOrDefault(token, List.of());
        if (currentKind.isAny()) {
            return all;
        }
        return filterNoteTypesByKind(all, currentKind);
    }

    /**
     * Find property definitions matching the given token, filtered by kind
     * compatibility.
     *
     * @param token property definition name (trimmed, case-sensitive)
     * @param currentKind the current kind to filter by, not null
     * @return matching property definitions (never null)
     */
    @objid ("20bb7146-decb-4939-9bbf-0c667a27ced6")
    public List<PropertyDefinitionCandidate> findPropertyDefinitionsByName(String token, ResolvedKind currentKind) {
        if (token == null || token.isBlank() || currentKind.isNone()) {
            return List.of();
        }
        ensureIndex();
        final List<PropertyDefinitionCandidate> all = this.propertyDefinitionsByName.getOrDefault(token, List.of());
        if (currentKind.isAny()) {
            return all;
        }
        return filterPropertyDefinitionsByKind(all, currentKind);
    }

    @objid ("f0a009ea-af12-4743-96cf-76c7a7e0dc52")
    private void ensureIndex() {
        if (this.attributesByName != null) {
            return;
        }
        synchronized (this) {
            if (this.attributesByName != null) {
                return;
            }
            buildIndex();
        }
    }

    @objid ("e5808280-97b9-4557-aa44-cd915ef93625")
    private void buildIndex() {
        final Map<String, List<MAttribute>> attributes = new HashMap<>();
        final Map<String, List<TagType>> tagTypes = new HashMap<>();
        final Map<String, List<NoteType>> noteTypes = new HashMap<>();
        final Map<String, List<PropertyDefinitionCandidate>> propertyDefinitions = new HashMap<>();

        for (MClass mc : this.context.getRegisteredMetaclasses()) {
            for (MAttribute attribute : mc.getAttributes(false)) {
                final String name = attribute.getName();
                final List<MAttribute> bucket = attributes.computeIfAbsent(name, k -> new ArrayList<>());
                if (!bucket.contains(attribute)) {
                    bucket.add(attribute);
                }
            }
        }

        for (ModuleComponent module : this.context.getModules()) {
            if (!module.isValid()) {
                continue;
            }
            for (Profile profile : module.getOwnedProfile()) {
                if (!profile.isValid()) {
                    continue;
                }

                for (MetaclassReference reference : profile.getOwnedReference()) {
                    indexReferenceTypes(reference, tagTypes, noteTypes, propertyDefinitions);
                }
                for (Stereotype stereotype : profile.getDefinedStereotype()) {
                    indexStereotypeTypes(stereotype, tagTypes, noteTypes, propertyDefinitions);
                }
            }
        }

        this.attributesByName = freezeMap(attributes);
        this.tagTypesByName = freezeMap(tagTypes);
        this.noteTypesByName = freezeMap(noteTypes);
        this.propertyDefinitionsByName = freezeMap(propertyDefinitions);
    }

    @objid ("3c762c82-8e35-43a8-9f38-2bbb04f65d02")
    private static void indexReferenceTypes(MetaclassReference reference, Map<String, List<TagType>> tagTypes, Map<String, List<NoteType>> noteTypes, Map<String, List<PropertyDefinitionCandidate>> propertyDefinitions) {
        if (reference == null) {
            return;
        }
        for (TagType tagType : reference.getDefinedTagType()) {
            final String name = safeName(tagType);
            if (!name.isBlank()) {
                tagTypes.computeIfAbsent(name, k -> new ArrayList<>()).add(tagType);
            }
        }
        for (NoteType noteType : reference.getDefinedNoteType()) {
            final String name = safeName(noteType);
            if (!name.isBlank()) {
                noteTypes.computeIfAbsent(name, k -> new ArrayList<>()).add(noteType);
            }
        }
        final PropertyTableDefinition table = reference.getDefinedTable();
        if (table != null && table.isValid()) {
            for (PropertyDefinition definition : table.getOwned()) {
                if (!definition.isValid()) {
                    continue;
                }

                final String name = safeName(definition);
                if (!name.isBlank()) {
                    final ResolvedProperty.PropertyTableOwner owner = new ResolvedProperty.OwnerReference(reference);
                    propertyDefinitions.computeIfAbsent(name, k -> new ArrayList<>()).add(new PropertyDefinitionCandidate(definition, owner));
                }
            }
        }
    }

    @objid ("a45030df-f91b-4d56-9791-5cb6a022e72d")
    private static void indexStereotypeTypes(Stereotype stereotype, Map<String, List<TagType>> tagTypes, Map<String, List<NoteType>> noteTypes, Map<String, List<PropertyDefinitionCandidate>> propertyDefinitions) {
        if (stereotype == null) {
            return;
        }
        for (TagType tagType : stereotype.getDefinedTagType()) {
            final String name = safeName(tagType);
            if (!name.isBlank()) {
                tagTypes.computeIfAbsent(name, k -> new ArrayList<>()).add(tagType);
            }
        }
        for (NoteType noteType : stereotype.getDefinedNoteType()) {
            final String name = safeName(noteType);
            if (!name.isBlank()) {
                noteTypes.computeIfAbsent(name, k -> new ArrayList<>()).add(noteType);
            }
        }
        final PropertyTableDefinition table = stereotype.getDefinedTable();
        if (table != null && table.isValid()) {
            for (PropertyDefinition definition : table.getOwned()) {
                final String name = safeName(definition);
                if (!name.isBlank()) {
                    final ResolvedProperty.PropertyTableOwner owner = new ResolvedProperty.OwnerStereotype(stereotype);
                    propertyDefinitions.computeIfAbsent(name, k -> new ArrayList<>()).add(new PropertyDefinitionCandidate(definition, owner));
                }
            }
        }
    }

    @objid ("5a9d89e4-11c8-42c3-8ee6-d288ef587c0c")
    private static <T> Map<String, List<T>> freezeMap(Map<String, List<T>> source) {
        final Map<String, List<T>> frozen = new HashMap<>(source.size());
        for (Map.Entry<String, List<T>> entry : source.entrySet()) {
            frozen.put(entry.getKey(), List.copyOf(entry.getValue()));
        }
        return Map.copyOf(frozen);
    }

    @objid ("95e8dbe1-f460-451f-bc96-1ad275545653")
    private static String safeName(ModelElement element) {
        try {
            final String name = element.getName();
            return (name == null) ? "" : name;
        } catch (RuntimeException e) {
            return "";
        }
    }

    // --- Kind-based filtering helpers ---
    @objid ("8dc33be3-993e-493c-8b19-1a5157cb56bc")
    private List<MAttribute> filterAttributesByKind(List<MAttribute> attributes, ResolvedKind currentKind) {
        final List<MAttribute> filtered = new ArrayList<>(attributes.size());
        for (MAttribute attribute : attributes) {
            if (isAttributeCompatible(attribute, currentKind)) {
                filtered.add(attribute);
            }
        }
        return filtered;
    }

    @objid ("b1081858-7ccd-4419-9b28-c46feb440021")
    private List<TagType> filterTagTypesByKind(List<TagType> tagTypes, ResolvedKind currentKind) {
        final List<TagType> filtered = new ArrayList<>(tagTypes.size());
        for (TagType tagType : tagTypes) {
            if (isTagTypeCompatible(tagType, currentKind)) {
                filtered.add(tagType);
            }
        }
        return filtered;
    }

    @objid ("660813a5-40a0-44b9-a2de-6de95a6c190f")
    private List<NoteType> filterNoteTypesByKind(List<NoteType> noteTypes, ResolvedKind currentKind) {
        final List<NoteType> filtered = new ArrayList<>(noteTypes.size());
        for (NoteType noteType : noteTypes) {
            if (isNoteTypeCompatible(noteType, currentKind)) {
                filtered.add(noteType);
            }
        }
        return filtered;
    }

    @objid ("8c5c5782-2726-434b-8318-d986b3a086c2")
    private List<PropertyDefinitionCandidate> filterPropertyDefinitionsByKind(List<PropertyDefinitionCandidate> candidates, ResolvedKind currentKind) {
        final List<PropertyDefinitionCandidate> filtered = new ArrayList<>(candidates.size());
        for (PropertyDefinitionCandidate candidate : candidates) {
            if (isPropertyDefinitionCandidateCompatible(candidate, currentKind)) {
                filtered.add(candidate);
            }
        }
        return filtered;
    }

    @objid ("518f1d4b-b6f5-4059-a5cd-d03436346af6")
    private boolean isAttributeCompatible(MAttribute attribute, ResolvedKind currentKind) {
        for (ResolvedKind.KindAlternative kindAlt : currentKind.alternatives()) {
            final MClass metaclass = toMetaclass(kindAlt);
            if (metaclass == null) {
                continue;
            }
            return metaclass.getAttributes(true).contains(attribute);
        }
        return false;
    }

    @objid ("aa492225-b92e-4280-809d-606b546896d0")
    private boolean isTagTypeCompatible(TagType tagType, ResolvedKind currentKind) {
        for (ResolvedKind.KindAlternative kindAlt : currentKind.alternatives()) {
            if (kindAlt instanceof ResolvedKind.StereotypeKind stereotypeKind) {
                // Resolve TagType base on Stereotype Hierarchy, not only the current
                // Stereotype, as TagTypes defined on parent Stereotypes are inherited by child
                // Stereotypes.
                Stereotype current = stereotypeKind.stereotype();
                while (current != null) {
                    if (Objects.equals(tagType.getOwnerStereotype(), current)) {
                        return true;
                    }
                    current = current.getParent();
                }
            }
            if (kindAlt instanceof ResolvedKind.MetaclassKind metaclassKind) {
                if (isReferenceCompatible(tagType.getOwnerReference(), metaclassKind.metaclass())) {
                    return true;
                }
            }
        }
        return false;
    }

    @objid ("486f19f9-63f6-4188-9635-d302a3a6da1f")
    private boolean isNoteTypeCompatible(NoteType noteType, ResolvedKind currentKind) {
        for (ResolvedKind.KindAlternative kindAlt : currentKind.alternatives()) {
            if (kindAlt instanceof ResolvedKind.StereotypeKind stereotypeKind) {
                // Resolve NoteType base on Stereotype Hierarchy, not only the current
                // Stereotype, as TagTypes defined on parent Stereotypes are inherited by child
                // Stereotypes.
                Stereotype current = stereotypeKind.stereotype();
                while (current != null) {
                    if (Objects.equals(noteType.getOwnerStereotype(), current)) {
                        return true;
                    }
                    current = current.getParent();
                }

            }
            if (kindAlt instanceof ResolvedKind.MetaclassKind metaclassKind) {
                if (isReferenceCompatible(noteType.getOwnerReference(), metaclassKind.metaclass())) {
                    return true;
                }
            }
        }
        return false;
    }

    @objid ("33ea61b6-8292-446b-9fa0-3154f7a6fa42")
    private boolean isPropertyDefinitionCandidateCompatible(PropertyDefinitionCandidate candidate, ResolvedKind currentKind) {
        for (ResolvedKind.KindAlternative kindAlt : currentKind.alternatives()) {
            if (candidate.owner() instanceof ResolvedProperty.OwnerStereotype ownerStereotype && kindAlt instanceof ResolvedKind.StereotypeKind stereotypeKind) {

                // Resolve NoteType base on Stereotype Hierarchy, not only the current
                // Stereotype, as TagTypes defined on parent Stereotypes are inherited by child
                // Stereotypes.
                Stereotype current = stereotypeKind.stereotype();
                while (current != null) {
                    if (Objects.equals(ownerStereotype.stereotype(), current)) {
                        return true;
                    }
                    current = current.getParent();
                }

            }
            if (candidate.owner() instanceof ResolvedProperty.OwnerReference ownerReference && kindAlt instanceof ResolvedKind.MetaclassKind metaclassKind) {
                if (isReferenceCompatible(ownerReference.reference(), metaclassKind.metaclass())) {
                    return true;
                }
            }
        }
        return false;
    }

    @objid ("8fb49c11-2d96-4231-b477-1faa686cc5b8")
    private MClass toMetaclass(org.modelio.platform.search.engine.searchers.query.api.model.resolved.ResolvedKind.KindAlternative kindAlternative) {
        if (kindAlternative instanceof ResolvedKind.MetaclassKind metaclassKind) {
            return metaclassKind.metaclass();
        }

        if (kindAlternative instanceof ResolvedKind.StereotypeKind stereotypeKind) {
            final String baseName = stereotypeKind.stereotype().getBaseClassName();
            if (baseName == null || baseName.isBlank()) {
                return null;
            }
            return this.context.getMetaclass(baseName);
        }

        return null;
    }

    @objid ("6c2e46d4-7bfe-4443-861f-70f7e06d425b")
    private boolean isReferenceCompatible(MetaclassReference reference, MClass metaclass) {
        if (reference == null || metaclass == null) {
            return false;
        }

        final String referencedName;
        try {
            referencedName = reference.getReferencedClassName();
        } catch (RuntimeException e) {
            return false;
        }

        if (referencedName == null || referencedName.isBlank()) {
            return false;
        }

        if (referencedName.equals(metaclass.getName())) {
            return true;
        }
        if (referencedName.equals(metaclass.getQualifiedName())) {
            return true;
        }

        MClass referencedMetaclass = this.context.getMetaclass(referencedName);
        if (referencedMetaclass != null) {
            if (metaclass.hasBase(referencedMetaclass)) {
                return true;
            }
        }

        return false;
    }

    @objid ("5125edfc-3ecc-4ccb-b43d-5126f1c57b5e")
    public record PropertyDefinitionCandidate ( PropertyDefinition definition,
            org.modelio.platform.search.engine.searchers.query.api.model.resolved.ResolvedProperty.PropertyTableOwner owner )  {
        @objid ("707e4101-02a1-449e-9bd2-258598fcaec7")
        public PropertyDefinitionCandidate {
            if (owner == null) {
                throw new IllegalArgumentException("owner must not be null");
            }
            if (definition == null) {
                throw new IllegalArgumentException("definition must not be null");
            }
        }

    }

}

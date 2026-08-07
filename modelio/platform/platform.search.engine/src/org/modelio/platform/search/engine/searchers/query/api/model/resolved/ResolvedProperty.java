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
package org.modelio.platform.search.engine.searchers.query.api.model.resolved;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.uml.infrastructure.MetaclassReference;
import org.modelio.metamodel.uml.infrastructure.NoteType;
import org.modelio.metamodel.uml.infrastructure.Stereotype;
import org.modelio.metamodel.uml.infrastructure.TagType;
import org.modelio.metamodel.uml.infrastructure.properties.PropertyDefinition;
import org.modelio.vcore.smkernel.mapi.MAttribute;
import org.modelio.vcore.smkernel.meta.SmAttribute;

/**
 * Resolved, ambiguity-aware property-key reference.
 * <p>
 * A property key can resolve to several kinds of definitions: meta attributes, tag types, note types, or
 * property definitions.
 * <p>
 * This container represents ambiguity (multiple valid resolutions) as well as
 * unknown references (empty alternatives).
 * <p>
 * Ordering is preserved as provided by the resolver, but callers must not rely on it being
 * deterministic across environments.
 *
 * @param alternatives the possible definitions of the property key
 */
@objid ("9ddaeb66-472f-4c8b-be60-330606e2d2b4")
public record ResolvedProperty ( List<org.modelio.platform.search.engine.searchers.query.api.model.resolved.ResolvedProperty.PropertyAlternative> alternatives )  {
    @objid ("6a0afeb3-cc9d-4a10-911e-4ec7bc80c78b")
    public static ResolvedProperty empty() {
        return new ResolvedProperty(List.of());
    }

    @objid ("8d5b9cd8-6604-4997-8bff-6c07eb611979")
    public boolean isUnknown() {
        return this.alternatives.isEmpty();
    }

    @objid ("a33abd18-0dbd-414a-8277-855ab60d97ef")
    public ResolvedProperty {
        if (alternatives == null) {
            throw new IllegalArgumentException("alternatives must not be null");
        }
    }

    @objid ("fc6327cf-426b-48a7-87da-2e9d893560c2")
    public sealed interface PropertyAlternative permits ResolvedMAttribute, ResolvedTagType, ResolvedNoteType, ResolvedPropertyDefinition {
    }

    @objid ("b3772870-5587-45c1-9342-dbe620d09ae7")
    public sealed interface PropertyTableOwner permits OwnerStereotype, OwnerReference {
    }

    @objid ("a246f875-78bd-41b5-98c7-f0c606e9f624")
    public record OwnerStereotype ( Stereotype stereotype )  implements PropertyTableOwner {
        @objid ("f326f6af-6329-46f3-b910-2639a70dbc8b")
        public OwnerStereotype {
            if (stereotype == null) {
                throw new IllegalArgumentException("stereotype must not be null");
            }
        }

    }

    @objid ("48717e71-b7da-4deb-8c59-3945388ced19")
    public record OwnerReference ( MetaclassReference reference )  implements PropertyTableOwner {
        @objid ("f9eb1ee0-e56f-4d7d-9ccd-1a509a51cef4")
        public OwnerReference {
            if (reference == null) {
                throw new IllegalArgumentException("reference must not be null");
            }
        }

    }

    @objid ("c3ca6fa7-b0b6-402a-9980-1544dfd6bb4a")
    public record ResolvedMAttribute ( MAttribute attribute )  implements PropertyAlternative {
        @objid ("7b556dc7-f558-4362-af95-a6528c2c9c5d")
        public ResolvedMAttribute {
            if (attribute == null) {
                throw new IllegalArgumentException("attribute must not be null");
            }
        }

        @objid ("c6200acd-d909-423f-bd64-811f404e3594")
        @Override
        public final String toString() {
            SmAttribute smAtt = ((SmAttribute) this.attribute);
            return "AttributeKey(" + smAtt.getOwner()+ "::" + this.attribute.toString() + ")";
        }

    }

    @objid ("0af7d7c9-8d8b-4d66-8103-9e284b4794b1")
    public record ResolvedTagType ( TagType tagType )  implements PropertyAlternative {
        @objid ("167edbac-da46-409b-a0f7-076705693410")
        public ResolvedTagType {
            if (tagType == null) {
                throw new IllegalArgumentException("tagType must not be null");
            }
        }

    }

    @objid ("9232793b-0a50-4a2d-8035-c5c57463d538")
    public record ResolvedNoteType ( NoteType noteType )  implements PropertyAlternative {
        @objid ("d26c12d0-8064-4cc0-9fe6-1ccc72ff48e8")
        public ResolvedNoteType {
            if (noteType == null) {
                throw new IllegalArgumentException("noteType must not be null");
            }
        }

    }

    @objid ("f74e7558-ed8b-499c-827b-5439ff478923")
    public record ResolvedPropertyDefinition ( PropertyDefinition propertyDefinition,
PropertyTableOwner owner )  implements PropertyAlternative {
        @objid ("70e29e76-69ed-416d-befa-2c7b14c22b05")
        public ResolvedPropertyDefinition {
            if (owner == null) {
                throw new IllegalArgumentException("owner must not be null");
            }
            if (propertyDefinition == null) {
                throw new IllegalArgumentException("propertyDefinition must not be null");
            }
        }

    }

}

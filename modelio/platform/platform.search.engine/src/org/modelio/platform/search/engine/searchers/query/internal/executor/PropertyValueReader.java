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

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.uml.infrastructure.MetaclassReference;
import org.modelio.metamodel.uml.infrastructure.ModelElement;
import org.modelio.metamodel.uml.infrastructure.Stereotype;
import org.modelio.platform.search.engine.searchers.query.api.model.resolved.ResolvedProperty;
import org.modelio.platform.search.engine.searchers.query.api.model.resolved.ResolvedProperty.OwnerReference;
import org.modelio.platform.search.engine.searchers.query.api.model.resolved.ResolvedProperty.OwnerStereotype;
import org.modelio.platform.search.engine.searchers.query.api.model.resolved.ResolvedProperty.PropertyAlternative;
import org.modelio.platform.search.engine.searchers.query.api.model.resolved.ResolvedProperty.PropertyTableOwner;
import org.modelio.platform.search.engine.searchers.query.api.model.resolved.ResolvedProperty.ResolvedMAttribute;
import org.modelio.platform.search.engine.searchers.query.api.model.resolved.ResolvedProperty.ResolvedNoteType;
import org.modelio.platform.search.engine.searchers.query.api.model.resolved.ResolvedProperty.ResolvedPropertyDefinition;
import org.modelio.platform.search.engine.searchers.query.api.model.resolved.ResolvedProperty.ResolvedTagType;
import org.modelio.vcore.smkernel.mapi.MObject;

/**
 * Reads a property value from an {@link MObject} given a {@link ResolvedProperty} with OR semantics
 * across alternatives.
 * <p>
 * Each alternative is tried in order. The first non-null result is returned. If no alternative
 * produces a value, {@code null} is returned. This method never throws — property absence returns null.
 */
@objid ("bcb8c9ed-b617-47c2-825f-f3823714203b")
public final class PropertyValueReader {
    @objid ("80f00e75-f79d-4628-a8fe-f9c91b499e76")
    private PropertyValueReader() {
        // utility class
    }

    /**
     * Reads the value of the given property from the given element.
     * <p>
     * Alternatives are tried in declaration order with OR semantics:
     * the first non-null value is returned immediately.
     *
     * @param element the model element to read from (must not be null)
     * @param property the resolved property with alternatives (must not be null)
     * @return the property value, or {@code null} if the property is unknown, absent, or the element
     * does not support the alternative
     */
    @objid ("be2cc947-f040-421e-bba7-d4f3d857c267")
    public static Object readValue(MObject element, ResolvedProperty property) {
        if (property.isUnknown()) {
            return null;
        }

        for (PropertyAlternative alternative : property.alternatives()) {
            Object value = readAlternative(element, alternative);
            if (value != null) {
                return value;
            }
        }

        return null;
    }

    /**
     * Reads a single alternative from the element.
     */
    @objid ("00b9d751-b40a-4d11-a23b-72e8f4e8b104")
    private static Object readAlternative(MObject element, PropertyAlternative alternative) {
        switch (alternative) {
        case ResolvedMAttribute a -> {
            return element.mGet(a.attribute());
        }
        case ResolvedTagType t -> {
            if (element instanceof ModelElement me) {
                return me.getTagValue(t.tagType());
            }
            return null;
        }
        case ResolvedNoteType n -> {
            if (element instanceof ModelElement me) {
                return me.getNoteContent(n.noteType());
            }
            return null;
        }
        case ResolvedPropertyDefinition pd -> {
            if (element instanceof ModelElement me) {
                PropertyTableOwner owner = pd.owner();
                switch (owner) {
                case OwnerStereotype os -> {
                    return me.getProperty(os.stereotype(), pd.propertyDefinition().getName());
                }
                case OwnerReference or -> {
                    return me.getProperty(or.reference(), pd.propertyDefinition().getName());
                }
                }
            }
            return null;
        }
        }
    }

}

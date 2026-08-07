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
package org.modelio.platform.search.engine.searchers.query.api.model.frozen.jackson;

import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.mapi.MObject;

/**
 * Jackson serializer for {@link MObject}.
 * <p>
 * Serializes an {@link MObject} as a small projection compatible with the technical spec examples:
 * {@code {"mc": "Standard.Class", "uuid": "...", "name": "..."}}.
 */
@objid ("9e094353-0544-4cb6-8d45-96743adc1b3b")
public final class MObjectSerializer extends JsonSerializer<MObject> {
    @objid ("ceba29fc-db63-4ba3-8f93-cf9ae58f2db1")
    @Override
    public void serialize(final MObject value, final JsonGenerator gen, final SerializerProvider serializers) throws IOException {
        if (value == null) {
            gen.writeNull();
            return;
        }

        gen.writeStartObject();

        final MClass mClass = value.getMClass();
        gen.writeStringField("mc", mClass != null ? mClass.getQualifiedName() : null);
        gen.writeStringField("uuid", value.getUuid());
        gen.writeStringField("name", value.getName());

        gen.writeEndObject();
    }

}

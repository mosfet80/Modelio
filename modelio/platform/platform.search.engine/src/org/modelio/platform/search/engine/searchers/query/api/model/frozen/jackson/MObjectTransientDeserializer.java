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
import java.util.Objects;
import java.util.function.Function;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.vcore.smkernel.mapi.MObject;

/**
 * Jackson deserializer for {@link MObject}.
 * <p>
 * Deserializes an MObject reference (mc, uuid, name) from JSON and converts it using a provided lambda.
 * If no converter is provided, returns {@code null}.
 */
@objid ("8ec8d61e-c417-42a1-be9b-6bc94b43bd9a")
public final class MObjectTransientDeserializer extends JsonDeserializer<MObject> {
    @objid ("b1483dcd-f99b-4027-9f34-1948410fa4bc")
    private final Function<MObjectRef, MObject> converter;

    /**
     * Creates a deserializer with a conversion function.
     *
     * @param converter function to convert MObjectRef to MObject, or null to disable conversion
     */
    @objid ("e989d0f0-9e76-47c4-afb9-e165f5e8aba6")
    public MObjectTransientDeserializer(final Function<MObjectRef, MObject> converter) {
        this.converter = Objects.requireNonNull(converter, "converter must not be null");
    }

    @objid ("b14f3ed0-4813-4d2b-8c60-e511f2aced8e")
    @SuppressWarnings("resource")
    @Override
    public MObject deserialize(final JsonParser p, final DeserializationContext ctxt) throws IOException {
        final MObjectRef ref = p.getCodec().readValue(p, MObjectRef.class);
        if (ref == null) {
            throw new JsonMappingException(ctxt.getParser(), "No MObject reference in JSON");
        }

        if (this.converter != null) {
            MObject ret = this.converter.apply(ref);
            if (ret == null) {
                throw new JsonMappingException(ctxt.getParser(), String.format("Cannot resolve MObject reference mc='%s' uuid='%s' name='%s'", ref.mc, ref.uuid, ref.name));
            }
            return ret;
        }
        return null;
    }

    /**
     * Intermediate Reference to an MObject (mc=metaclass qualified name, uuid, name).
     *
     * @param mc metaclass qualified name
     * @param uuid universally unique identifier
     * @param name the element name if known
     * @see org.modelio.vcore.smkernel.mapi.MRef
     */
    @objid ("2b193ec6-6ea4-45da-bee4-98d3a4d07e83")
    public record MObjectRef ( String mc,
            String uuid,
            String name )  {
    }

}

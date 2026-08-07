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
package org.modelio.vstore.exml.json.local;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.SmAttribute;
import org.modelio.vcore.smkernel.meta.SmDependency;
import org.modelio.vstore.exml.common.utils.ExmlUtils;

/**
 * Save a CMS node in an JSON file.
 *
 * @since 5.5
 */
@objid ("b9a532b0-1af1-4d64-a47a-e5aa5b861742")
class JsStoreSaver {
    @objid ("332eb2db-ff14-4f2d-9024-52076f62073b")
    private static final int FORMAT_VERSION = 1;

    @objid ("d561841f-e554-435f-9d08-36224ac92e30")
    private JsonGenerator out;

    @objid ("a7998097-9f3b-4f7a-bffb-add75bf2f53f")
    private Queue<SmObjectImpl> queue = new ArrayDeque<>();

    /**
     * Save the given CMS node in an output stream.
     *
     * @param object the CMS node to save
     * @param os an output stream.
     * @throws IOException in case of failure.
     */
    @objid ("3dea18c1-a6c9-4521-bf15-6356aa9e12f4")
    public void externalize(final SmObjectImpl object, final OutputStream os) throws IOException {
        // Note : http://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html
        // In a try-with-resources statement, any catch or finally block
        // is run after the resources declared have been closed.

        try (JsonGenerator closeableWriter = JsonFactory.builder().build().createGenerator(os)){
            this.out = closeableWriter;

            this.out.writeStartObject();
            //this.out.writeComment("GENERATED FILE, PLEASE DO NOT EDIT!!!");

            dumpEXT(object);

            this.out.writeEndObject();
        } finally {
            this.out = null;
        }
    }

    @objid ("c4514fed-80c7-4ceb-a457-1713bcb7ac39")
    private final void dumpOBJECT(final SmObjectImpl object, Collection<SmObjectImpl> recursionContext) throws IOException {
        if (recursionContext.contains(object)) {
            // Object already being externalized, skip it
            return;
        }

        // Process it, add it to context
        recursionContext.add(object);

        this.out.writeFieldName(object.getUuid());
        this.out.writeStartObject();

        dumpIDFields(object);

        dumpATTRIBUTES(object);
        dumpDEPENDENCIES(object, recursionContext);

        this.out.writeEndObject();

        // // Processed, remove from context
        // recursionContext.remove(object);
    }

    @objid ("4419b4bd-4dff-4120-89bb-16886932564f")
    private void dumpATT(final SmObjectImpl object, final SmAttribute att) throws IOException {
        Object attVal = object.getAttVal(att);
        if (attVal == null) {
            // ignore, skip
        } else {
            this.out.writeFieldName(att.getName());

            Class<?> type = att.getType();
            if (type == Long.class)
                this.out.writeNumber((Long) attVal);
            else if (type == Short.class)
                this.out.writeNumber((Short) attVal);
            else if (type == Integer.class)
                this.out.writeNumber((Integer) attVal);
            else if (type == String.class)
                this.out.writeString(attVal.toString());
            else if (type == Float.class)
                this.out.writeNumber((Float) attVal);
            else if (type == Double.class)
                this.out.writeNumber((Double) attVal);
            else if (Enum.class.isAssignableFrom(type))
                this.out.writeString(attVal.toString());
            else if (type == Boolean.class)
                this.out.writeBoolean((boolean) attVal);
            else
                throw new IllegalArgumentException(String.format("'%s' value of type '%s' not supported", attVal, type.getName()));

        }
    }

    @objid ("20f1fdff-d9e6-43e7-8bac-536e3082eaee")
    private void dumpATTRIBUTES(final SmObjectImpl object) throws IOException {
        this.out.writeFieldName("atts");

        this.out.writeStartObject();
        for (SmAttribute att : object.getClassOf().getAllAttDef()) {
            dumpATT(object, att);
        }
        this.out.writeEndObject();
    }

    @objid ("4419a523-29ac-42d2-94af-d6c7d11a21f4")
    private void dumpCOMPS(final SmObjectImpl object, final SmDependency dep, final List<SmObjectImpl> targets, Collection<SmObjectImpl> recursionContext) throws IOException {
        this.out.writeFieldName(dep.getName());
        this.out.writeStartArray();

        for (SmObjectImpl t : targets) {
            dumpID( t);

            if (t.getRepositoryObject() == object.getRepositoryObject() && ! recursionContext.contains(t) ) {
                // composed by value, add to queue
                this.queue.add(t);
            }
        }

        this.out.writeEndArray();
    }

    /**
     * Write the object SmDependencies.
     *
     * @param object the CMS node
     * @param recursionContext to avoid cycles
     */
    @objid ("c33fd715-5c82-4a00-9ca0-9170b0c41823")
    private void dumpDEPENDENCIES(final SmObjectImpl object, Collection<SmObjectImpl> recursionContext) throws IOException {
        this.out.writeObjectFieldStart("deps");

        List<SmDependency > dependencies = ExmlUtils.getExternalisableDeps(object);
        for (SmDependency dep : dependencies) {
            List<SmObjectImpl> content = object.getDepValList(dep);

            if (! content.isEmpty()) {
                if (ExmlUtils.isDepComponent(dep)) {
                    dumpCOMPS(object, dep, content, recursionContext);
                } else {
                    dumpLINKS(object, dep, content);
                }
            }
        }

        this.out.writeEndObject();
    }

    /**
     * Write the file header.
     *
     * @param object the main CMS node
     * @throws javax.xml.stream.XMLStreamException in case of write error.
     */
    @objid ("ec57be31-fb11-4624-b300-20b9337669a7")
    private void dumpEXT(final SmObjectImpl object) throws IOException {
        this.out.writeFieldName("metadatas");
        this.out.writeStartObject();
        this.out.writeStringField("comment", "GENERATED FILE, PLEASE DO NOT EDIT!!!");
        this.out.writeStringField("name", object.getName());
        this.out.writeNumberField("format-version", FORMAT_VERSION);
        this.out.writeEndObject();

        dumpIDFields(object);

        this.out.writeFieldName("content");
        this.out.writeStartObject();
        HashSet<SmObjectImpl> doneSet = new HashSet<>();

        dumpOBJECT(object, doneSet);

        while (!this.queue.isEmpty()) {
            dumpOBJECT(this.queue.remove(), doneSet);
        }
        this.out.writeEndObject();
    }

    @objid ("eb4832a4-9f4d-44e0-811d-3d5b9a33acf1")
    private void dumpID(final MObject object) throws IOException {
        this.out.writeStartObject();

        dumpIDFields(object);

        this.out.writeEndObject();
    }

    @objid ("a73925fe-a0c3-4991-a06f-bb8ee958d8ba")
    private void dumpIDFields(final MObject object) throws IOException {
        this.out.writeStringField("name", Objects.toString(object.getName(), ""));
        this.out.writeStringField("mc", object.getMClass().getQualifiedName());
        this.out.writeStringField("uuid", object.getUuid().toString());
    }

    @objid ("8862928f-3f5e-4e4c-9d36-88f825ab4569")
    private void dumpLINKS(final SmObjectImpl object, final SmDependency dep, final List<SmObjectImpl> targets) throws IOException {
        this.out.writeFieldName(dep.getName());
        this.out.writeStartArray();

        for (SmObjectImpl t : targets) {
            dumpID( t);
        }

        this.out.writeEndArray();
    }

}

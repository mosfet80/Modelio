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
package org.modelio.platform.model.ui.panels.search.query.elements.source;

import java.util.List;
import java.util.Objects;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.uml.infrastructure.Stereotype;
import org.modelio.platform.model.ui.panels.search.query.elements.core.AbstractMqlNode;
import org.modelio.platform.model.ui.panels.search.query.elements.core.MqlQueryModel;
import org.modelio.platform.search.engine.searchers.query.api.model.query.AllSource;
import org.modelio.platform.search.engine.searchers.query.api.model.query.ProvidedSource;
import org.modelio.platform.search.engine.searchers.query.api.model.query.Source;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.mapi.MObject;

/**
 * Editor model node for {@link Source} (either {@link AllSource} or {@link ProvidedSource}).
 */
@objid ("27986368-0f0c-4a26-acc8-9613959fde9c")
public final class MqlSourceNode extends AbstractMqlNode {
    @objid ("54cecbfa-4c28-4043-ab10-9717b6ff6b9e")
    public static final String PROP_KIND = "mql.source.kind";

    @objid ("176cc8a5-959b-4c85-bfb6-e3e42c3dc8dd")
    public static final String PROP_ALL_OF = "mql.source.all.of";

    @objid ("dd77d931-df17-4da7-a9cb-307d4a11d018")
    public static final String PROP_PROVIDED_ELEMENTS = "mql.source.provided.elements";

    @objid ("3a233622-ea10-48a9-9317-aceb5ebbb968")
    private Source source;

    @objid ("3bdff8a4-345d-460e-9190-c70ccf7c257f")
    public MqlSourceNode(final AbstractMqlNode parent, final Source source) {
        super(parent);
        this.source = Objects.requireNonNull(source, "source");
    }

    @objid ("01c3dd26-0312-4a20-a8f6-61cf34787531")
    public Source getAst() {
        return this.source;
    }

    @objid ("6e332b39-5a6e-4027-8e38-a72567513f5b")
    public boolean isAll() {
        return this.source instanceof AllSource;
    }

    @objid ("84ccfbc5-11df-4d14-b191-397bce49e466")
    public boolean isProvided() {
        return this.source instanceof ProvidedSource;
    }

    @objid ("d046709e-ba86-470c-8aa6-336df90c255e")
    public String getAllKindRef() {
        if (this.source instanceof AllSource all) {
            return all.getKindName();
        }
        return "";
    }

    @objid ("dc4f05bf-0a12-46eb-9f9b-253a28a929b8")
    public void setAllKindRef(final String kindRef) {
        if (kindRef == null) {
            throw new IllegalArgumentException("kindRef must not be null");
        }

        if (this.source instanceof AllSource all) {
            String old = all.getKindName();
            all.setKindName(kindRef);
            firePropertyChange(PROP_ALL_OF, old, kindRef);
            fireChanged();
        } else {
            replaceSource(new AllSource(kindRef));
        }
    }

    @objid ("2d309523-5893-4b95-87b7-1561b4d878df")
    public int getProvidedCount() {
        int count = 0;
        for (MObject ignored : getProvidedElements()) {
            count++;
            if (count > 50) {
                // Avoid counting all elements if there are many, as this is only used for display purposes.
                break;
            }
        }
        return count;
    }

    @objid ("d5ca48e3-e9a9-403c-a37b-e4044975d9e5")
    public Iterable<MObject> getProvidedElements() {
        if (this.source instanceof ProvidedSource provided) {
            return provided.getElements();
        }
        return List.of();
    }

    @objid ("7f6e7c63-8973-4de8-8e5d-ec6ea27d5f67")
    public void useProvidedSource() {
        if (this.source instanceof ProvidedSource) {
            return;
        }

        ProvidedSource newSource =  new ProvidedSource(List.of());
        replaceSource(newSource);
    }

    @objid ("b9b5ab05-621a-438f-921c-22d24591f28b")
    private void replaceSource(final Source newSource) {
        Objects.requireNonNull(newSource, "newSource");
        Source old = this.source;
        this.source = newSource;

        MqlQueryModel root = getRootModel();
        if (root != null) {
            root.getQueryAst().setSource(newSource);
        }

        firePropertyChange(PROP_KIND, old, newSource);
        fireChanged();
    }

}

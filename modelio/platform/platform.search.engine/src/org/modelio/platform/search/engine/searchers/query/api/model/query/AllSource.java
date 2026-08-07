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
package org.modelio.platform.search.engine.searchers.query.api.model.query;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.uml.infrastructure.Stereotype;
import org.modelio.platform.search.engine.searchers.query.api.model.frozen.FrozenAllSource;
import org.modelio.vcore.smkernel.mapi.MClass;

/**
 * Source: iterate over all elements matching a Kind (metaclass or stereotype).
 * <p>
 * This source type queries the model to find all elements of a specific type.
 * The Kind reference is a string that can be:
 * <ul>
 * <li>A metaclass name (e.g., "Standard.Class", "Standard.Package")</li>
 * <li>A stereotype name (e.g., "JavaClass", "Requirement")</li>
 * </ul>
 * <p>
 * <b>Kind Inheritance Semantics:</b>
 * <ul>
 * <li>If the kind resolves to a <b>concrete</b> metaclass or stereotype,
 * only elements of that <b>exact</b> type are matched</li>
 * <li>If the kind resolves to an <b>abstract</b> metaclass or stereotype,
 * elements of that type <b>and all its subtypes</b> are matched</li>
 * </ul>
 * <p>
 * If multiple valid interpretations exist (e.g., both a metaclass and stereotype
 * with the same name), the execution will be the UNION of all alternatives,
 * and a warning will be added to diagnostics.
 *
 * @see ProvidedSource
 */
@objid ("c1728a88-7540-4103-8c4a-92dfc9134795")
public final class AllSource implements Source {
    /**
     * Kind reference: metaclass name or stereotype name.
     */
    @objid ("3871cab3-c15f-48f1-804d-b35c852baf0c")
    private String kindName;

    /**
     * Constructor.
     *
     * @param kindName kind reference (metaclass name or stereotype name)
     */
    @objid ("7c8522b3-aa0e-4d18-a28a-f713585b09db")
    public AllSource(String kindName) {
        if (kindName == null || kindName.isBlank()) {
            throw new IllegalArgumentException("kind must not be null/blank");
        }
        this.kindName = kindName;
    }

    /**
     * Copy constructor.
     */
    @objid ("03bc90e5-6b4c-4f90-9a44-9fff947f2f2b")
    public AllSource(AllSource other) {
        this.kindName = other.kindName;
    }

    /**
     * Constructor from frozen.
     */
    @objid ("e0c89e5f-ebb1-4779-bff1-580186889af4")
    public AllSource(FrozenAllSource frozen) {
        this.kindName = frozen.of();
    }

    @objid ("9f8212fa-f018-4bde-b897-2d313f5f868f")
    public String getKindName() {
        return this.kindName;
    }

    @objid ("90201487-d22f-47d9-8b2d-d4799f0e6d14")
    public void setKindName(String of) {
        if (of == null || of.isBlank()) {
            throw new IllegalArgumentException("of must not be null/blank");
        }
        this.kindName = of;
    }

    /**
     * Convert to frozen (immutable) version.
     */
    @objid ("eab14b93-28dc-45c7-8140-c9870b0f0598")
    public FrozenAllSource freeze() {
        return new FrozenAllSource(this.kindName);
    }

    @objid ("5ea3c681-f94c-4a0e-854c-5b90d741a1f5")
    public static AllSource of(MClass mclass) {
        return new AllSource(mclass.getQualifiedName());
    }

    @objid ("9120c497-6cad-43c3-bced-303b5e1760c9")
    public static AllSource of(Stereotype stereotype) {
        return new AllSource(stereotype.getName());
    }

    @objid ("a2fb4368-31c9-4022-a830-0793b0e28a54")
    @Override
    public AllSource deepCopy() {
        return new AllSource(this);
    }

}

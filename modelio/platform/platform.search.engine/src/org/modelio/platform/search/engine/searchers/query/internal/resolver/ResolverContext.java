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

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.mda.ModuleComponent;
import org.modelio.metamodel.uml.infrastructure.Stereotype;
import org.modelio.vcore.smkernel.mapi.MClass;

/**
 * Internal resolver context.
 * <p>
 * This interface exists to make resolution logic unit-testable without requiring a full CoreSession.
 */
@objid ("11174385-cbd9-4197-b500-c896a7afa3e6")
public interface ResolverContext {
    /**
     * Resolve a metaclass by name.
     * <p>
     * Accepts short and qualified metaclass names (e.g., {@code Class} or {@code Standard.Class}).
     *
     * @param kindToken metaclass token (trimmed, case-sensitive)
     * @return metaclass, or null if not found
     */
    @objid ("f2d26783-effc-4754-aa2f-fddf04e6d18b")
    MClass getMetaclass(String kindToken);

    /**
     * Enumerate all registered metaclasses.
     * <p>
     * Used by resolvers to build small indices (e.g., dependency name → candidates) without requiring a full {@link org.modelio.vcore.session.api.ICoreSession}
     * in unit tests.
     *
     * @return registered metaclasses (never null)
     */
    @objid ("138e39d7-f882-465a-9677-bb4a415829bc")
    Iterable<? extends MClass> getRegisteredMetaclasses();

    /**
     * Find stereotypes whose name matches exactly.
     *
     * @param stereotypeName stereotype name token (trimmed, case-sensitive)
     * @return matching stereotypes (never null)
     */
    @objid ("d099d06a-a6b7-4460-ade2-e649c72a406d")
    List<Stereotype> findStereotypesByName(String stereotypeName);

    /**
     * Enumerate module components for extension types lookup.
     * <p>
     * Default implementation returns an empty list to keep tests lightweight.
     *
     * @return module components (never null)
     */
    @objid ("667c90ce-3298-4945-9877-0f70b9feab06")
    default Iterable<? extends ModuleComponent> getModules() {
        return List.of();
    }

}

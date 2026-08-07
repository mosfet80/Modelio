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
import org.modelio.metamodel.uml.infrastructure.ModelElement;
import org.modelio.metamodel.uml.infrastructure.Stereotype;
import org.modelio.platform.search.engine.searchers.query.api.model.resolved.ResolvedKind;
import org.modelio.platform.search.engine.searchers.query.api.model.resolved.ResolvedKind.AnyKind;
import org.modelio.platform.search.engine.searchers.query.api.model.resolved.ResolvedKind.KindAlternative;
import org.modelio.platform.search.engine.searchers.query.api.model.resolved.ResolvedKind.MetaclassKind;
import org.modelio.platform.search.engine.searchers.query.api.model.resolved.ResolvedKind.NoneKind;
import org.modelio.platform.search.engine.searchers.query.api.model.resolved.ResolvedKind.StereotypeKind;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.mapi.MObject;

/**
 * Matches an {@link MObject} against a {@link ResolvedKind} with OR semantics across alternatives.
 * <p>
 * Kind matching rules:
 * <ul>
 * <li>If the kind is unknown (no alternatives), the match always returns {@code false}.</li>
 * <li>For {@link MetaclassKind}: if the metaclass is abstract, the element matches if its metaclass
 * has the alternative metaclass as a base (inheritance match). If concrete, only an exact metaclass match.</li>
 * <li>For {@link StereotypeKind}: the element must be a {@link ModelElement} and have the stereotype applied.
 * If the stereotype is abstract, subtypes are accepted; otherwise exact match only.</li>
 * </ul>
 */
@objid ("4e9d6114-8069-46a0-a885-510f39c75ed1")
public final class KindMatcher {
    @objid ("95504a85-b362-44a7-b7c4-c7883e55641f")
    private KindMatcher() {
        // utility class
    }

    /**
     * Checks whether the given element matches at least one alternative of the resolved kind.
     *
     * @param element the model element to test (must not be null)
     * @param kind the resolved kind with alternatives (must not be null)
     * @code true} if the element matches any alternative, {@code false} otherwise
     */
    @objid ("639796ff-421e-4c79-9451-26bb7bcef0e3")
    public static boolean matches(MObject element, ResolvedKind kind) {
        if (kind.isNone()) {
            return false;
        }

        for (KindAlternative alternative : kind.alternatives()) {
            switch (alternative) {
            case MetaclassKind metaclassKind -> {
                MClass targetMc = metaclassKind.metaclass();
                MClass elementMc = element.getMClass();
                if (targetMc.isAbstract()) {
                    // Abstract metaclass: match if element's metaclass inherits from target
                    if (elementMc.hasBase(targetMc)) {
                        return true;
                    }
                } else {
                    // Concrete metaclass: exact match only
                    if (elementMc.equals(targetMc)) {
                        return true;
                    }
                }
            }
            case StereotypeKind stereotypeKind -> {
                if (element instanceof ModelElement me) {
                    Stereotype targetStereo = stereotypeKind.stereotype();
                    if (targetStereo.isIsAbstract()) {
                        // Abstract stereotype: match if element has the stereotype or any sub-stereotype
                        for (Stereotype appliedStereo : me.getExtension()) {
                            if (appliedStereo.equals(targetStereo) || isChildStereotype(appliedStereo, targetStereo)) {
                                return true;
                            }
                        }
                    } else {
                        // Concrete stereotype: exact match only
                        if (me.getExtension().contains(targetStereo)) {
                            return true;
                        }
                    }
                }
                // Element is not a ModelElement — this alternative doesn't match
            }
            case NoneKind x -> {
                // No kind specified, matches nothing
            }
            case AnyKind x -> {
                // Matches any element
                return true;
            }
            }
        }

        return false;
    }

    /**
     * Checks if {@code child} is a sub-stereotype of {@code parent} by walking the stereotype
     * inheritance hierarchy.
     */
    @objid ("fed4d232-4807-45db-aa69-c174768f4169")
    private static boolean isChildStereotype(Stereotype child, Stereotype parent) {
        Stereotype current = child.getParent();
        while (current != null) {
            if (current.equals(parent)) {
                return true;
            }
            current = current.getParent();
        }
        return false;
    }

}

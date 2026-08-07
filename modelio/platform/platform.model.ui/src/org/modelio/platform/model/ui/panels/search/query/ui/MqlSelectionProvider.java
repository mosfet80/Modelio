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
package org.modelio.platform.model.ui.panels.search.query.ui;

import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.modelio.platform.core.navigate.IModelioNavigationService;
import org.modelio.platform.model.ui.swt.InputHelper;
import org.modelio.vcore.smkernel.mapi.MObject;

/**
 * Helper for turning the current UI selection into a selection-backed {@link Supplier}.
 */
@objid ("b2d54218-089a-4a67-b41b-cf98fce478d2")
public final class MqlSelectionProvider {
    @objid ("9ef245a8-c336-4a59-958d-f82b899e5802")
    private MqlSelectionProvider() {
        // utility
    }

    @objid ("4e15a1f5-c197-4b4e-ac98-6d0fa0ad1537")
    public static Supplier<List<MObject>> fixed(final List<MObject> elements) {
        if (elements == null) {
            return () -> List.of();
        } else {
            List<MObject> copy = List.copyOf(elements); // defensive non modifiable copy and null check
            return () -> copy;
        }
    }

    /**
     * Adapter for retrieving a selection from the Eclipse 4 selection service.
     *
     * @param selectionService the E4 selection service to adapt, not null
     * @return a supplier of the current selection as a list of MObjects, never null
     */
    @objid ("5d9738f4-335d-4b16-a795-451f4e8d984e")
    public static Supplier<Iterable<MObject>> fromSelectionService(final ESelectionService selectionService) {
        Objects.requireNonNull(selectionService, "selectionService");

        return  () -> {
            Object selection = selectionService.getSelection();
            return InputHelper.toList(selection, MObject.class);
        };
    }

    @objid ("ca5ac93b-53d9-4c02-a631-f468b7be0cdc")
    public static Supplier<Iterable<MObject>> fromNavigationService(final IModelioNavigationService navigationService, final ESelectionService selectionService) {
        return fromSelectionService(selectionService);
    }

}

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
/*
 * Copyright 2013-2024 Docaposte
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
package org.modelio.vcore.session.api.model;

import java.util.function.Predicate;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.vcore.smkernel.mapi.MObject;

/**
 * Interface allowing to filter MObjects through its {@link #accept(MObject) method}.
 */
@objid ("cc438b71-0529-4637-9448-2218b3a2e8b5")
@FunctionalInterface
public interface IMObjectFilter extends Predicate<MObject> {
    /**
     * This method checks if an element is accepted.
     *
     * @param element the element to check.
     * @return <code>true</code> if the element is accepted.
     */
    @objid ("1ad704b9-ff53-4e66-a53f-e67d232a7622")
    boolean accept(final MObject element);

    /**
     * This method checks if an element is accepted.
     *
     * @param element the element to check.
     * @return <code>true</code> if the element is accepted.
     * @since 6.0.1 IMObjectFilter now extends Predicate<MObject>
     */
    @objid ("0bdb317e-3e23-4fc2-abea-fbf627bc8447")
    @Override
    default boolean test(MObject t) {
        return accept(t);
    }

}

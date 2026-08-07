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
package org.modelio.archimate.metamodel.impl.mmextensions.factory;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.vcore.smkernel.mapi.MObject;

/**
 * Interface that defines classes that are able to initialize a newly created element.
 * <p>
 * Implementers might also do some additional initializations based on a given property map.
 */
@objid ("da973c55-9da9-498e-95d3-98df71bf3ada")
interface IArchimateElementInitializer {
    /**
     * Initialize the given element.
     *
     * @param element The element to initialize.
     */
    @objid ("ad5d79d7-2fe6-4013-8ca5-5dc6ed0bdae6")
    void initialize(MObject element);

    @objid ("e90024ef-df92-4e47-9678-66dfdeaa5422")
    void setDefaultValue(String key, Object value);

}

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
/* WARNING: GENERATED FILE -  DO NOT EDIT
     Metamodel: Archimate, version 1.0.4, by Modeliosoft
     Generator version: 3.14.00
     Generated on: Feb 9, 2023
*/
package org.modelio.archimate.metamodel.layers.business.structure.active;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.core.generic.ExternalActiveStructureElement;

/**
 * BusinessInterface vnull
 *
 *
 * <p>A business interface exposes the functionality of a business service to other business roles or&nbsp;actors. It is often referred to as a channel (telephone, Internet, local office, etc.). The same&nbsp;business service may be exposed through different interfaces.</p><p>A business interface may be part of a business role or actor through a composition relationship,&nbsp;which is not shown in the standard notation, and a business interface may serve a business role.</p><p>A business interface may be assigned to one or more business services, which means that these&nbsp;services are exposed by the interface. The name of a business interface should preferably be a&nbsp;noun.</p>
 *
 *
 */
@objid ("ca0b1778-023d-4986-93a7-8d654810fd54")
public interface BusinessInterface extends ExternalActiveStructureElement {
    /**
     * The metaclass simple name.
     */
    @objid ("52d5a719-539a-4d0b-9e85-cf77e6150805")
    public static final String MNAME = "BusinessInterface";

    /**
     * The metaclass qualified name.
     */
    @objid ("10d2dbd0-6c92-43c5-abfc-b1ac44cb3354")
    public static final String MQNAME = "Archimate.BusinessInterface";

}

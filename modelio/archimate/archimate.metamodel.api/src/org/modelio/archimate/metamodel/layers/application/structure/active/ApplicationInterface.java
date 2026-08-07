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
package org.modelio.archimate.metamodel.layers.application.structure.active;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.core.generic.ExternalActiveStructureElement;

/**
 * ApplicationInterface vnull
 *
 *
 * <p>An application interface specifies how the functionality of a component can be accessed by other&nbsp;elements (provided interface), or which functionality the component requires from its&nbsp;environment (required interface). An application interface exposes application services to the&nbsp;environment. The same application service may be exposed through different interfaces, and the&nbsp;same interface may expose multiple services.</p><p>In a sense, an application interface specifies a kind of contract that a component realizing this&nbsp;interface must fulfill. This may include parameters, protocols used, pre- and post-conditions, and&nbsp;data formats.</p><p>An application interface may be part of an application component through composition (not&nbsp;shown in the standard notation), which means that these interfaces are provided by that&nbsp;component, and can serve other application components. An application interface can be&nbsp;assigned to application services or business services, which means that the interface exposes&nbsp;these services to the environment. The name of an application interface should preferably be a&nbsp;noun.</p>
 *
 *
 */
@objid ("742e6eac-ff65-4479-b280-d99a511f09e6")
public interface ApplicationInterface extends ExternalActiveStructureElement {
    /**
     * The metaclass simple name.
     */
    @objid ("4d797897-7dbe-49c9-8b58-9dfd90d6fb54")
    public static final String MNAME = "ApplicationInterface";

    /**
     * The metaclass qualified name.
     */
    @objid ("32af42f5-15a0-4335-90f4-abbe681efee0")
    public static final String MQNAME = "Archimate.ApplicationInterface";

}

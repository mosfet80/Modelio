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
package org.modelio.archimate.metamodel.layers.application.behavior;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

/**
 * ApplicationProcess vnull
 *
 *
 * <p>An application process describes the internal behavior performed by an application component&nbsp;that is required to realize a set of services. For a (human or automated) consumer the services are&nbsp;relevant and the required behavior is merely a black box, hence the designation &#8220;internal&#8221;.</p><p>An application process may realize application services. Other application services may serve&nbsp;(be used by) an application process. An application process may access data objects. An&nbsp;application component may be assigned to an application process (which means that this&nbsp;component performs the process). The name of an application process should clearly identify a&nbsp;series of application behaviors; e.g., &#8220;Claims adjudication process&#8221;, or &#8220;General ledger update&nbsp;job&#8221;.</p>
 *
 *
 */
@objid ("b2d20287-a7c4-4ba8-ac45-81fc76bb6cc2")
public interface ApplicationProcess extends ApplicationInternalBehaviorElement {
    /**
     * The metaclass simple name.
     */
    @objid ("b1fc985e-5560-4821-9d44-4bafbdb4dcdb")
    public static final String MNAME = "ApplicationProcess";

    /**
     * The metaclass qualified name.
     */
    @objid ("2fe5db40-19bd-42fa-b500-b2509d39fac2")
    public static final String MQNAME = "Archimate.ApplicationProcess";

}

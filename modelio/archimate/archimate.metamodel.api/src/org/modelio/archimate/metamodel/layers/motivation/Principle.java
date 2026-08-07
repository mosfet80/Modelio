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
package org.modelio.archimate.metamodel.layers.motivation;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.core.generic.motivation.MotivationElement;

/**
 * Principle vnull
 *
 *
 * <p>Principles are strongly related to goals and requirements. Similar to requirements, principles&nbsp;define intended properties of systems. However, in contrast to requirements, principles are&nbsp;broader in scope and more abstract than requirements. A principle defines a general property that&nbsp;applies to any system in a certain context. A requirement defines a property that applies to a&nbsp;specific system as described by an architecture.</p><p>A principle needs to be made specific for a given system by means of one or more requirements,&nbsp;in order to enforce that the system conforms to the principle. For example, the principle&nbsp;&quot;Information management processes comply with all relevant laws, policies, and regulations&quot; is&nbsp;realized by the requirements that are imposed by the actual laws, policies, and regulations that&nbsp;apply to the specific system under design.</p><p>A principle is motivated by some goal or driver. For example, the aforementioned principle may&nbsp;be motivated by the goal to maintain a good reputation and/or the goal to avoid penalties. The&nbsp;principle provides a means to realize its motivating goal, which is generally formulated as a&nbsp;guideline. This guideline constrains the design of all systems in a given context by stating the&nbsp;general properties that are required from any system in this context to realize the goal. Principles&nbsp;are intended to be more stable than requirements in the sense that they do not change as quickly&nbsp;as requirements may do. Organizational values, best practices, and design knowledge may be&nbsp;reflected and made applicable in terms of principles.</p>
 *
 *
 */
@objid ("27ada992-1f6a-4c75-b5fd-34e5b3ec63c2")
public interface Principle extends MotivationElement {
    /**
     * The metaclass simple name.
     */
    @objid ("8c81d3fc-a373-4f68-9688-728c66b67764")
    public static final String MNAME = "Principle";

    /**
     * The metaclass qualified name.
     */
    @objid ("884f704f-e6c0-48e0-b3ea-35da4677aadd")
    public static final String MQNAME = "Archimate.Principle";

}

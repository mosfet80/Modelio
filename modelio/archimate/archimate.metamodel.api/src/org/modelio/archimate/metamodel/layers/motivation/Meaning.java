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
 * Meaning vnull
 *
 *
 * <p>A meaning represents the interpretation of an element of the architecture. In particular, this is&nbsp;used to describe the meaning of passive structure elements, (for example, a document, message).</p><p>It is a description that expresses the intent of that element; i.e., how it informs the external user.</p><p>It is possible that different users view the informative functionality of an element differently. For&nbsp;example, what may be a &quot;registration confirmation&quot; for a client could be a &quot;client mutation&quot; for&nbsp;a CRM department (assuming for the sake of argument that it is modeled as an external user).</p><p>Also, various different representations may carry essentially the same meaning. For example,&nbsp;various different documents (a web document, a filled-in paper form, a &quot;client contact&quot; report&nbsp;from the call center) may essentially carry the same meaning.</p><p>A meaning can be associated with any core element. To denote that a meaning is specific to a&nbsp;particular stakeholder, this stakeholder can also be associated to the meaning.</p><p>The name of a&nbsp;meaning should preferably be a noun or noun phrase.</p>
 *
 * <h3>Refinement and equivalence link</h3>
 *
 * <p>An Archimate meaning may be refined in an Analyst <em>term</em>. The Archimate&nbsp;meaning&nbsp;may then be set as equivalent as the Analyst&nbsp;term&nbsp; Then, the&nbsp;Archimate&nbsp;meaning&nbsp;will be synchonized to the Analyt&nbsp;term&nbsp;&nbsp;calling getName() or setName() on the Archimate&nbsp;meaning&nbsp;will call the same method of the Analyst&nbsp;term.</p>
 *
 *
 */
@objid ("be5b08ae-fc58-45f4-b1ce-8c9b225a159c")
public interface Meaning extends MotivationElement {
    /**
     * The metaclass simple name.
     */
    @objid ("a949f962-a701-4b5c-91d9-154858d78c0e")
    public static final String MNAME = "Meaning";

    /**
     * The metaclass qualified name.
     */
    @objid ("2d785db4-6ec4-4d0b-ad89-eecb5b2c7e41")
    public static final String MQNAME = "Archimate.Meaning";

    /**
     * Getter for attribute 'Meaning.equivalentRef'
     *
     * Metamodel description:
     * <i>To set this meaning as equivalent to an analyst Term, set this attribute with the result of new MRef(analystElement).toString().</i>
     */
    @objid ("7d58c1d4-e02d-427c-9d45-5ad17a9ae2f3")
    String getEquivalentRef();

    /**
     * Setter for attribute 'Meaning.equivalentRef'
     *
     * Metamodel description:
     * <i>To set this meaning as equivalent to an analyst Term, set this attribute with the result of new MRef(analystElement).toString().</i>
     */
    @objid ("70da369e-0990-4f0d-af23-397c78a34c10")
    void setEquivalentRef(String value);

}

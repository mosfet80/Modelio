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
     Metamodel: Standard, version 2.3.00, by Modeliosoft
     Generator version: 3.14.00
     Generated on: Aug 7, 2024
*/
package org.modelio.metamodel.uml.infrastructure;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.uml.statik.Classifier;

/**
 * Substitution v0.0.9054
 *
 *
 * <p>A <em>Substitution</em> is a relationship between two <em>Classifiers</em>, which signifies that the substituting <em>Classifier</em> complies with the contract specified by the contract <em>Classifier</em>. This implies that <em>Instances</em> of the substituting <em>Classifier</em> are runtime substitutable where instances of the contract <em>Classifier</em> are expected.</p><p>The <em>Substitution</em> relationship denotes runtime substitutability that is not based on specialization. <em>Substitution</em>, unlike <em>specialization</em>, does not imply inheritance of structure, but only compliance of publicly available contracts. A <em>Substitution</em> like relationship is instrumental to specify runtime substitutability for domains that do not support specialization such as certain component technologies. It requires that</p>
 *
 * <ol>
 * 	<li><em>Interfaces</em> implemented by the contract <em>Classifier</em> are also implemented by the substituting Classifier, or else the substituting Classifier implements a more specialized <em>Interface</em> type.</li>
 * 	<li>that&nbsp;any <em>Port</em> owned by the contract <em>Classifier</em> has a matching <em>Port</em> (see <em>Ports</em>) owned by the substituting <em>Classifier</em>.</li>
 * </ol>
 *
 * <p>In Modelio, contrary to UML 2.0, <em>Substitution</em> derives from <em>ModelElement</em>. A <em>Substitution</em> is owned by its substituting <em>Classifier</em>.</p>
 *
 *
 */
@objid ("008dd736-c4be-1fd8-97fe-001ec947cd2a")
public interface Substitution extends UmlModelElement {
    /**
     * The metaclass simple name.
     */
    @objid ("bc40e22a-d5c9-4322-82ec-c73d6106a2ce")
    public static final String MNAME = "Substitution";

    /**
     * The metaclass qualified name.
     */
    @objid ("2442ee7c-3d23-46c9-953a-ae73e5a69a08")
    public static final String MQNAME = "Standard.Substitution";

    /**
     * Getter for relation 'Substitution->Contract'
     *
     * Metamodel description:
     * <i>Designates the Classifier that is substituted.</i>
     */
    @objid ("ec875538-95ef-4ec6-8682-ec0f4adac63a")
    Classifier getContract();

    /**
     * Setter for relation 'Substitution->Contract'
     *
     * Metamodel description:
     * <i>Designates the Classifier that is substituted.</i>
     */
    @objid ("c433e644-747c-467b-8b5e-826b584c6854")
    void setContract(Classifier value);

    /**
     * Getter for relation 'Substitution->SubstitutingClassifier'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("3b7b143a-e7d6-480a-a9ee-0c2689ceb545")
    Classifier getSubstitutingClassifier();

    /**
     * Setter for relation 'Substitution->SubstitutingClassifier'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("5b6f4b03-cb30-4dcb-995c-5be63f3936db")
    void setSubstitutingClassifier(Classifier value);

}

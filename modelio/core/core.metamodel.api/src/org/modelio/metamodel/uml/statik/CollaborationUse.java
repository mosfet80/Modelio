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
package org.modelio.metamodel.uml.statik;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.uml.infrastructure.UmlModelElement;

/**
 * CollaborationUse v0.0.9054
 *
 *
 * (UML 2.0) A CollaborationUse (or collaboration occurrence) represents one particular use of a Collaboration to explain the relationships between the properties of a Classifier. A CollaborationUse indicates a set of roles and Connectors that cooperate within the Classifier according to a given Collaboration, indicated by the type of the collaboration occurrence.
 *
 * There may be multiple uses of a given Collaboration within a Classifier, each involving a different set of roles and Connectors. A given role or Connector may be involved in multiple occurrences of the same or different Collaborations. Associated Bindings map Features of the Collaboration type to Features in the Classifier. These Bindings indicate which role in the Classifier plays which role in the Collaboration.
 *
 * In Modelio, a CollaborationUse can belong to a NameSpace (Classifier or Collaboration) or to an Operation.
 *
 */
@objid ("00047d6a-c4bf-1fd8-97fe-001ec947cd2a")
public interface CollaborationUse extends UmlModelElement {
    /**
     * The metaclass simple name.
     */
    @objid ("2bc2cb27-9b1f-4b5a-be7d-7838fc2c734a")
    public static final String MNAME = "CollaborationUse";

    /**
     * The metaclass qualified name.
     */
    @objid ("96ad7c2f-2c7e-4411-be0c-18afad6a7df6")
    public static final String MQNAME = "Standard.CollaborationUse";

    /**
     * Getter for relation 'CollaborationUse->Type'
     *
     * Metamodel description:
     * <i>Defines the Collaboration whose CollaborationUse is an occurrence.</i>
     */
    @objid ("6115c79d-7182-4616-8204-9743fea9e97a")
    Collaboration getType();

    /**
     * Setter for relation 'CollaborationUse->Type'
     *
     * Metamodel description:
     * <i>Defines the Collaboration whose CollaborationUse is an occurrence.</i>
     */
    @objid ("86df3165-cfd2-4f85-967b-be49f7960696")
    void setType(Collaboration value);

    /**
     * Getter for relation 'CollaborationUse->NRepresented'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("9230ce11-6072-440b-b581-8276fe7fd038")
    NameSpace getNRepresented();

    /**
     * Setter for relation 'CollaborationUse->NRepresented'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("b97e1f7f-f817-4324-868a-5d0b8d0848f9")
    void setNRepresented(NameSpace value);

    /**
     * Getter for relation 'CollaborationUse->ORepresented'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("b5d27f00-f075-445b-9a6c-a13eb7cddfb4")
    Operation getORepresented();

    /**
     * Setter for relation 'CollaborationUse->ORepresented'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("937c7eee-d23e-427f-b46a-939cea9dc704")
    void setORepresented(Operation value);

    /**
     * Getter for relation 'CollaborationUse->RoleBinding'
     *
     * Metamodel description:
     * <i>The CollaborationUse owns the Binding links that bind elements of the Type Collaboration to elements accessible from the owner NameSpace of the CollaborationUse.</i>
     */
    @objid ("dad5b7b1-24d9-47cb-b832-e3df0c78cea9")
    EList<Binding> getRoleBinding();

    /**
     * Filtered Getter for relation 'CollaborationUse->RoleBinding'
     *
     * Metamodel description:
     * <i>The CollaborationUse owns the Binding links that bind elements of the Type Collaboration to elements accessible from the owner NameSpace of the CollaborationUse.</i>
     */
    @objid ("a84c8274-1893-4407-98c4-210d44e3e3fc")
    <T extends Binding> List<T> getRoleBinding(java.lang.Class<T> filterClass);

}

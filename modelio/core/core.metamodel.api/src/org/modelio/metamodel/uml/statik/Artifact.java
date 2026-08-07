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

/**
 * Artifact v0.0.9054
 *
 *
 * In the metamodel, an Artifact is a Classifier that represents a physical entity.
 *
 * Artifacts can have Properties that represent features of the Artifact, and Operations that can be performed on its instances. Artifacts can be involved in Associations to other Artifacts, for example composition associations to Artifacts that are contained within it.
 *
 * Artifacts can be instantiated to represent detailed copy semantics, where different instances of the same Artifact may be deployed to various Node instances (and where each may have separate property values, for example for a time-stamp property).
 *
 * In Modelio, deployment or imbrications of Artifacts are modeled using the internalStructure mechanism. This provides a simpler, more formal and general mechanism that justifies metamodel differences to the standard, but enhances usability.
 *
 * In Modelio, an Artifact is a NameSpace, and therefore belongs to its owner NameSpace, which can be a Component, a Package, an Artifact or a TemplateParameter.
 *
 */
@objid ("0093d3de-c4be-1fd8-97fe-001ec947cd2a")
public interface Artifact extends Classifier {
    /**
     * The metaclass simple name.
     */
    @objid ("5081a5ca-0239-411b-b0cf-a69d830b5c7f")
    public static final String MNAME = "Artifact";

    /**
     * The metaclass qualified name.
     */
    @objid ("e767ac2e-1ed5-4eb9-8b90-adb30bbec7c5")
    public static final String MQNAME = "Standard.Artifact";

    /**
     * Getter for attribute 'Artifact.FileName'
     *
     * Metamodel description:
     * <i>The file system name for the Artifact.</i>
     */
    @objid ("35bdea58-b60a-4f26-90a4-812e8f7e9a8e")
    String getFileName();

    /**
     * Setter for attribute 'Artifact.FileName'
     *
     * Metamodel description:
     * <i>The file system name for the Artifact.</i>
     */
    @objid ("d2e555f5-8a76-475d-b15c-0151b6defb8f")
    void setFileName(String value);

    /**
     * Getter for relation 'Artifact->Utilized'
     *
     * Metamodel description:
     * <i>The set of model elements that are manifested in the Artifact. These model elements are utilized in the construction (or generation) of the artifact.</i>
     */
    @objid ("2b8acc8c-f097-439b-9197-19a5fdd1822b")
    EList<Manifestation> getUtilized();

    /**
     * Filtered Getter for relation 'Artifact->Utilized'
     *
     * Metamodel description:
     * <i>The set of model elements that are manifested in the Artifact. These model elements are utilized in the construction (or generation) of the artifact.</i>
     */
    @objid ("64a1084d-9c4a-4d2a-9e33-66a14f139bbc")
    <T extends Manifestation> List<T> getUtilized(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'Artifact->DeploymentLocation'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("09a63e3b-d0e7-4c97-b7f6-a149eaca7647")
    EList<Node> getDeploymentLocation();

    /**
     * Filtered Getter for relation 'Artifact->DeploymentLocation'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("411df18c-d0fe-4517-86d5-45a7dfc5fb34")
    <T extends Node> List<T> getDeploymentLocation(java.lang.Class<T> filterClass);

}

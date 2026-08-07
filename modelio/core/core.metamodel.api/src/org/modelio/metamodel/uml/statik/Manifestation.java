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

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.uml.infrastructure.UmlModelElement;

/**
 * Manifestation v0.0.9054
 *
 *
 * An Artifact embodies or manifests a number of ModelElements.
 *
 * An Artifact owns Manifestations, each of which represents the utilization of a packageable element. Specific profiles are expected to stereotype the Manifestation relationship to indicate particular forms of Manifestation, for example, <<tool generated>> and <<custom code>> might be two Manifestations for different Classes embodied in an Artifact.
 *
 * In Modelio, Manifestation derives directly from ModelElement, because Manifestations can only start from Artifact.
 *
 */
@objid ("00108470-c4bf-1fd8-97fe-001ec947cd2a")
public interface Manifestation extends UmlModelElement {
    /**
     * The metaclass simple name.
     */
    @objid ("cebe09e0-8a72-47f5-bb23-86227d039ea2")
    public static final String MNAME = "Manifestation";

    /**
     * The metaclass qualified name.
     */
    @objid ("9d7d57f6-df31-4f25-8f65-bd0879ad9a5f")
    public static final String MQNAME = "Standard.Manifestation";

    /**
     * Getter for relation 'Manifestation->UtilizedElement'
     *
     * Metamodel description:
     * <i>Elements that are rendered by the Artifact.</i>
     */
    @objid ("ead35415-0da6-458b-82d9-eff9ca387845")
    UmlModelElement getUtilizedElement();

    /**
     * Setter for relation 'Manifestation->UtilizedElement'
     *
     * Metamodel description:
     * <i>Elements that are rendered by the Artifact.</i>
     */
    @objid ("0cde34e7-7ffc-46a4-b3c1-f44fdebcb414")
    void setUtilizedElement(UmlModelElement value);

    /**
     * Getter for relation 'Manifestation->Owner'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("7febe5b6-ba18-487a-9397-3c5837a68989")
    Artifact getOwner();

    /**
     * Setter for relation 'Manifestation->Owner'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("7b7896a1-12ac-4624-98c0-3f3a9fbe7650")
    void setOwner(Artifact value);

}

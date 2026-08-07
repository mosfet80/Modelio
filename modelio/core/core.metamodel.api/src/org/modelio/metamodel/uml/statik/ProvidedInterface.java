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
 * ProvidedInterface v0.0.9054
 *
 *
 *
 *
 */
@objid ("00198dea-c4bf-1fd8-97fe-001ec947cd2a")
public interface ProvidedInterface extends UmlModelElement {
    /**
     * The metaclass simple name.
     */
    @objid ("93cd55e3-82e6-45b4-84ee-fd912e2074bd")
    public static final String MNAME = "ProvidedInterface";

    /**
     * The metaclass qualified name.
     */
    @objid ("c3c8e7ab-2019-4099-8bf2-06302ec79bea")
    public static final String MQNAME = "Standard.ProvidedInterface";

    /**
     * Getter for relation 'ProvidedInterface->ProvidedElement'
     *
     * Metamodel description:
     * <i>Interface provided by the Port.</i>
     */
    @objid ("282dfdbe-9db5-4578-8e8d-7e7e679257b8")
    EList<Interface> getProvidedElement();

    /**
     * Filtered Getter for relation 'ProvidedInterface->ProvidedElement'
     *
     * Metamodel description:
     * <i>Interface provided by the Port.</i>
     */
    @objid ("85caf01e-6093-44c0-8a3e-a5f065410ad8")
    <T extends Interface> List<T> getProvidedElement(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'ProvidedInterface->Providing'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("e90865e5-d567-453f-b3cd-6014ca803404")
    Port getProviding();

    /**
     * Setter for relation 'ProvidedInterface->Providing'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("67e09555-f1ab-44cd-b007-d4f75742d660")
    void setProviding(Port value);

    /**
     * Getter for relation 'ProvidedInterface->Consumer'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("929a03a7-e985-4a74-b844-c47b1c599b9f")
    EList<LinkEnd> getConsumer();

    /**
     * Filtered Getter for relation 'ProvidedInterface->Consumer'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("6b76ea34-31be-4e27-8c48-69b69c1b56bc")
    <T extends LinkEnd> List<T> getConsumer(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'ProvidedInterface->NaryConsumer'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("7c76120b-0f28-4f87-81a6-dedaa9c67056")
    EList<NaryLinkEnd> getNaryConsumer();

    /**
     * Filtered Getter for relation 'ProvidedInterface->NaryConsumer'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("9b1bf043-a00e-4c55-bf1a-70cb3eff773f")
    <T extends NaryLinkEnd> List<T> getNaryConsumer(java.lang.Class<T> filterClass);

}

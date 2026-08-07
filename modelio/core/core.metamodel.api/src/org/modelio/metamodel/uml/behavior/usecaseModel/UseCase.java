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
package org.modelio.metamodel.uml.behavior.usecaseModel;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.uml.statik.GeneralClass;

/**
 * UseCase v0.0.9054
 *
 *
 * A UseCase is expressed by sequences of Messages exchanged by system units and one or more Actors of the system.
 *
 * The definition of a UseCase includes all of the Behavior that it entails. This Behavior can be expressed by sequence diagrams, activity diagrams, Object diagrams, and so on.
 *
 * UseCases are structured by Packages, and have cooperation links with Actors.
 *
 * UseCases belong to a NameSpace.
 *
 */
@objid ("00588716-c4bf-1fd8-97fe-001ec947cd2a")
public interface UseCase extends GeneralClass {
    /**
     * The metaclass simple name.
     */
    @objid ("36e286b9-eaf7-4626-8ede-9baf511fabd8")
    public static final String MNAME = "UseCase";

    /**
     * The metaclass qualified name.
     */
    @objid ("cd3f800d-c049-4dd9-bd84-231a4f9790f4")
    public static final String MQNAME = "Standard.UseCase";

    /**
     * Getter for relation 'UseCase->Used'
     *
     * Metamodel description:
     * <i>In dependencies between UseCases, this defines the link to the UseCaseDependency association.</i>
     */
    @objid ("20bec60d-08f7-4600-8387-b2620cf61331")
    EList<UseCaseDependency> getUsed();

    /**
     * Filtered Getter for relation 'UseCase->Used'
     *
     * Metamodel description:
     * <i>In dependencies between UseCases, this defines the link to the UseCaseDependency association.</i>
     */
    @objid ("db7b5a5d-0cc2-455c-83b3-68ee358fada1")
    <T extends UseCaseDependency> List<T> getUsed(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'UseCase->OwnedExtension'
     *
     * Metamodel description:
     * <i>References the ExtensionPoints owned by the use case.</i>
     */
    @objid ("1735c593-881c-4a0c-bfb7-b0355082e86f")
    EList<ExtensionPoint> getOwnedExtension();

    /**
     * Filtered Getter for relation 'UseCase->OwnedExtension'
     *
     * Metamodel description:
     * <i>References the ExtensionPoints owned by the use case.</i>
     */
    @objid ("cead762d-a9ef-440f-bbea-3e574e1d95f9")
    <T extends ExtensionPoint> List<T> getOwnedExtension(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'UseCase->User'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("5a951638-c23b-4d36-bbf7-cba2e2131cd7")
    EList<UseCaseDependency> getUser();

    /**
     * Filtered Getter for relation 'UseCase->User'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("046f2223-829c-41ef-8e3d-33a9fb306850")
    <T extends UseCaseDependency> List<T> getUser(java.lang.Class<T> filterClass);

}

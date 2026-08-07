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
 * PackageMerge v0.0.9054
 *
 *
 * A PackageMerge is a relationship between two Packages, where the contents of the target Package (the one pointed at) is merged with the contents of the source Package through specialization and redefinition, where applicable. This is a mechanism that should be used when elements of the same name are intended to represent the same concept, regardless of the Package in which they are defined.
 *
 * A merging Package will take elements of the same kind with the same name from one or more Packages and merge them together into a single element using Generalization and redefinitions.
 *
 * It should be noted that a PackageMerge can be viewed as a short-hand way of explicitly defining those Generalizations and redefinitions. The merged Packages are still available, and the elements in those Packages can be separately qualified.
 *
 *
 */
@objid ("0016e662-c4bf-1fd8-97fe-001ec947cd2a")
public interface PackageMerge extends UmlModelElement {
    /**
     * The metaclass simple name.
     */
    @objid ("7d7b88a2-2ee5-4745-a2b7-58be9ea23930")
    public static final String MNAME = "PackageMerge";

    /**
     * The metaclass qualified name.
     */
    @objid ("e652de9c-735d-48bd-951b-b378a089a4aa")
    public static final String MQNAME = "Standard.PackageMerge";

    /**
     * Getter for relation 'PackageMerge->MergedPackage'
     *
     * Metamodel description:
     * <i>Package that is merged with the current Package.</i>
     */
    @objid ("538d2c33-e256-4345-a099-8cebdafb5661")
    Package getMergedPackage();

    /**
     * Setter for relation 'PackageMerge->MergedPackage'
     *
     * Metamodel description:
     * <i>Package that is merged with the current Package.</i>
     */
    @objid ("c4c76ddc-00ee-4b64-8b54-4ac994a40f05")
    void setMergedPackage(Package value);

    /**
     * Getter for relation 'PackageMerge->ReceivingPackage'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("2917aa2d-2e17-4f7e-9615-40c16d33a274")
    Package getReceivingPackage();

    /**
     * Setter for relation 'PackageMerge->ReceivingPackage'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("a76e72b3-486b-4ddc-a95a-903d9a934c02")
    void setReceivingPackage(Package value);

}

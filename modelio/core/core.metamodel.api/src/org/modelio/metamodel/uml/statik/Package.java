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
import org.modelio.metamodel.mda.Project;

/**
 * Package v1.1.1
 *
 *
 * The Package is the main structuring unit in a model. It defines a hierarchy that breaks down a Model.
 *
 * Packages can contain Packages, Classifiers, and so on.
 *
 * A Package belongs to its parent Package, represented as a NameSpace in the metamodel, except for the rootPackage, which belongs to a Project.
 *
 */
@objid ("001529ee-c4bf-1fd8-97fe-001ec947cd2a")
public interface Package extends NameSpace {
    /**
     * The metaclass simple name.
     */
    @objid ("d6956638-4ddb-4225-8470-1611f7626d5b")
    public static final String MNAME = "Package";

    /**
     * The metaclass qualified name.
     */
    @objid ("8ca0d6ee-6139-4662-9a74-a7043213eebd")
    public static final String MQNAME = "Standard.Package";

    /**
     * Getter for attribute 'Package.IsInstantiable'
     *
     * Metamodel description:
     * <i>This attribute should be discarded. It remains for backward compatibility reasons. A package is not instanciable in UML 2.0.</i>
     */
    @objid ("9a2a7dc7-bcd0-4eaa-a9aa-03c768a081d7")
    boolean isIsInstantiable();

    /**
     * Setter for attribute 'Package.IsInstantiable'
     *
     * Metamodel description:
     * <i>This attribute should be discarded. It remains for backward compatibility reasons. A package is not instanciable in UML 2.0.</i>
     */
    @objid ("2b709a5e-0bdf-42de-99d5-341d0857b317")
    void setIsInstantiable(boolean value);

    /**
     * Getter for relation 'Package->ReceivingMerge'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("2386c09f-8e52-4432-996a-8d87e6f894e9")
    EList<PackageMerge> getReceivingMerge();

    /**
     * Filtered Getter for relation 'Package->ReceivingMerge'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("0016573c-df51-4b3d-bbdc-032401456152")
    <T extends PackageMerge> List<T> getReceivingMerge(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'Package->Represented'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("a993e63c-fc21-4e2a-af07-a8b012492ab2")
    Project getRepresented();

    /**
     * Setter for relation 'Package->Represented'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("bfec1ab0-8c5e-4a84-8409-f90bbfa182d5")
    void setRepresented(Project value);

    /**
     * Getter for relation 'Package->Merge'
     *
     * Metamodel description:
     * <i>Merge relation between Packages. Corresponds to UML 2.0 merge semantics.</i>
     */
    @objid ("bed8919a-c553-45a6-b155-3c7574cfef3b")
    EList<PackageMerge> getMerge();

    /**
     * Filtered Getter for relation 'Package->Merge'
     *
     * Metamodel description:
     * <i>Merge relation between Packages. Corresponds to UML 2.0 merge semantics.</i>
     */
    @objid ("fee0008d-f304-4f4e-9a94-8cbbf7919b23")
    <T extends PackageMerge> List<T> getMerge(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'Package->PackageImporting'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("f8d56bc4-7980-406b-b3e1-fccde1773b48")
    EList<PackageImport> getPackageImporting();

    /**
     * Filtered Getter for relation 'Package->PackageImporting'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("d7903486-03ce-40b5-9ae2-f4795148dfa2")
    <T extends PackageImport> List<T> getPackageImporting(java.lang.Class<T> filterClass);

}

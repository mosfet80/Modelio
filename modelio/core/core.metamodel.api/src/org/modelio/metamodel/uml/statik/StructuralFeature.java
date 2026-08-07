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
import org.modelio.metamodel.uml.informationFlow.InformationFlow;

/**
 * StructuralFeature v0.0.9054
 *
 *
 * null
 *
 */
@objid ("001ee9c0-c4bf-1fd8-97fe-001ec947cd2a")
public interface StructuralFeature extends Feature {
    /**
     * The metaclass simple name.
     */
    @objid ("c5e8a959-7f9d-40b2-97bd-3eadc200c48c")
    public static final String MNAME = "StructuralFeature";

    /**
     * The metaclass qualified name.
     */
    @objid ("94a804a9-2a0f-4c80-8b82-0fb8221abdc3")
    public static final String MQNAME = "Standard.StructuralFeature";

    /**
     * Getter for attribute 'StructuralFeature.Changeable'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("a4b00535-e995-4913-a06c-6545bd6adb69")
    KindOfAccess getChangeable();

    /**
     * Setter for attribute 'StructuralFeature.Changeable'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("848ae752-8762-4237-86e3-41166c3806af")
    void setChangeable(KindOfAccess value);

    /**
     * Getter for attribute 'StructuralFeature.IsDerived'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("833df8f6-14b6-450e-b8c0-8da4f4ade6a6")
    boolean isIsDerived();

    /**
     * Setter for attribute 'StructuralFeature.IsDerived'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("13b52454-7bec-44c1-9ef8-81ca0a1383f2")
    void setIsDerived(boolean value);

    /**
     * Getter for attribute 'StructuralFeature.IsOrdered'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("a18ebae6-45d5-49d9-9b19-769f592c59b4")
    boolean isIsOrdered();

    /**
     * Setter for attribute 'StructuralFeature.IsOrdered'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("53ea364a-bd7e-4b23-a50b-7b5f3e60d051")
    void setIsOrdered(boolean value);

    /**
     * Getter for attribute 'StructuralFeature.IsUnique'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("f549b2c0-7b6c-4f06-a51c-7314d472d0f5")
    boolean isIsUnique();

    /**
     * Setter for attribute 'StructuralFeature.IsUnique'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("e89d2869-f482-487e-8a49-995ee10a3fb8")
    void setIsUnique(boolean value);

    /**
     * Getter for attribute 'StructuralFeature.MultiplicityMin'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("49fc0102-8345-4af6-b763-e76daab7e9c3")
    String getMultiplicityMin();

    /**
     * Setter for attribute 'StructuralFeature.MultiplicityMin'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("4ef5e13d-e199-44ef-9dfc-266e9b59dd5d")
    void setMultiplicityMin(String value);

    /**
     * Getter for attribute 'StructuralFeature.MultiplicityMax'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("80b08a92-7d29-434b-84a7-6f4c54be5ad8")
    String getMultiplicityMax();

    /**
     * Setter for attribute 'StructuralFeature.MultiplicityMax'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("7288ed90-ec09-4d04-a349-2030d547aae8")
    void setMultiplicityMax(String value);

    /**
     * Getter for relation 'StructuralFeature->RealizedInformationFlow'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("dbb33145-2420-43f3-9a29-f40235671f81")
    EList<InformationFlow> getRealizedInformationFlow();

    /**
     * Filtered Getter for relation 'StructuralFeature->RealizedInformationFlow'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("471882f9-3fdd-403f-9a6c-f092b9c6d10a")
    <T extends InformationFlow> List<T> getRealizedInformationFlow(java.lang.Class<T> filterClass);

}

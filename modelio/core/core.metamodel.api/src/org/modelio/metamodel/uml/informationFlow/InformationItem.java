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
package org.modelio.metamodel.uml.informationFlow;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.uml.statik.Classifier;

/**
 * InformationItem v0.0.9054
 *
 *
 * An information item is an abstraction of all kinds of information that can be exchanged between objects. It is a kind of classifier intended for representing information in a very abstract way, one which cannot be instantiated.
 *
 * One purpose of information items is to be able to define preliminary models, before having made detailed modeling decisions on types or structures. Another purpose of information items and information flows is to abstract complex models by a less precise but more general representation of the information exchanged between entities of a system.
 *
 * The Classifiers that can realize an information item can only be of the following kind: Class, Interface, InformationItem, Signal, Component.
 *
 */
@objid ("0063e890-c4bf-1fd8-97fe-001ec947cd2a")
public interface InformationItem extends Classifier {
    /**
     * The metaclass simple name.
     */
    @objid ("8ad6070f-4e16-4dad-bbd9-4c3e03399fb5")
    public static final String MNAME = "InformationItem";

    /**
     * The metaclass qualified name.
     */
    @objid ("fb217d37-5d1a-4238-8320-852c955989ed")
    public static final String MQNAME = "Standard.InformationItem";

    /**
     * Getter for relation 'InformationItem->Represented'
     *
     * Metamodel description:
     * <i>Determines the classifiers that will specify the structure and nature of the information.
     * An information item represents all its represented classifiers.</i>
     */
    @objid ("cdd0377e-7d85-4fe7-97e7-6d668ad6f92f")
    EList<Classifier> getRepresented();

    /**
     * Filtered Getter for relation 'InformationItem->Represented'
     *
     * Metamodel description:
     * <i>Determines the classifiers that will specify the structure and nature of the information.
     * An information item represents all its represented classifiers.</i>
     */
    @objid ("24664a91-9cba-469f-b3f8-4003162a1814")
    <T extends Classifier> List<T> getRepresented(java.lang.Class<T> filterClass);

}

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
     Metamodel: Archimate, version 1.0.4, by Modeliosoft
     Generator version: 3.14.00
     Generated on: Feb 9, 2023
*/
package org.modelio.archimate.metamodel.core;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.core.structure.Model;
import org.modelio.metamodel.diagrams.AbstractDiagram;

/**
 * ArchimateView vnull
 *
 *
 * <p>An ArchiMate View is a partial representation of the model. It&#39;s a photo of a set of model element displayed in the same diagram and selected according to business, user profile or interests criteria.</p><p><span style="line-height:1.6">An&nbsp;ArchimateView is owned by a </span><em style="line-height:1.6">ViewPoint</em><span style="line-height:1.6">, which also defines which elements the view should contain</span><em style="line-height:1.6">.</em></p>
 *
 *
 */
@objid ("a812bea7-c3ca-4d3d-9ec5-a32d6c4c4f52")
public interface ArchimateView extends AbstractDiagram {
    /**
     * The metaclass simple name.
     */
    @objid ("733cd370-6063-407b-b952-70bc01db93cf")
    public static final String MNAME = "ArchimateView";

    /**
     * The metaclass qualified name.
     */
    @objid ("32eb994b-519e-46e2-84a4-f0dbfcd3b8d5")
    public static final String MQNAME = "Archimate.ArchimateView";

    /**
     * Getter for relation 'ArchimateView->context'
     *
     * Metamodel description:
     * <i><p>The archimate model this diagram relates.&nbsp;</p><p>All elements created in this diagram will be put in folders on the model.</p>
     * </i>
     */
    @objid ("cf086dd4-22ab-4781-80b6-d8bb39e489d9")
    Model getContext();

    /**
     * Setter for relation 'ArchimateView->context'
     *
     * Metamodel description:
     * <i><p>The archimate model this diagram relates.&nbsp;</p><p>All elements created in this diagram will be put in folders on the model.</p>
     * </i>
     */
    @objid ("5c995e86-ce45-474b-b07d-1f24ddf8e0d6")
    void setContext(Model value);

}

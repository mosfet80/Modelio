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
package org.modelio.archimate.diagrams.elements.workpackage;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmWorkPackage when its representation mode is RepresentationMode.SIMPLE
 */
@objid ("6ffd3bb1-f2b6-4382-9fb8-b80909e4e750")
public class GmWorkPackageSimpleStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("af6d64cd-8320-4cdf-b2b5-51237c115485")
    static final StyleKey REPMODE = GmWorkPackageStructuredStyleKeys.REPMODE;

    @objid ("9e3fbf8e-8557-40f3-b350-e20c59d1553b")
    static final StyleKey LINECOLOR = GmWorkPackageStructuredStyleKeys.LINECOLOR;

    @objid ("9ec6c578-6211-4d73-a423-112342c8f25b")
    static final StyleKey FONT = GmWorkPackageStructuredStyleKeys.FONT;

    @objid ("83364707-7eff-4efe-a0c7-2964c5db2a12")
    static final StyleKey TEXTCOLOR = GmWorkPackageStructuredStyleKeys.TEXTCOLOR;

    @objid ("ded18ad1-39f1-4776-a047-ea8e406d3cd7")
    static final StyleKey SHOWSTEREOTYPES = GmWorkPackageStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("fb2f61a9-edd1-41b6-ae9d-ebcb510b2b4c")
    static final StyleKey SHOWTAGS = GmWorkPackageStructuredStyleKeys.SHOWTAGS;

}

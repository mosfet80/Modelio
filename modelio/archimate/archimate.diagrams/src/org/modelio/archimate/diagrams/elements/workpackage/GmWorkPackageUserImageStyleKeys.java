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
 * This class provides the StyleKey constants for a GmWorkPackage when its representation mode is RepresentationMode.IMAGE
 */
@objid ("b0f8e562-6e88-45f1-af57-40cd80f7b54a")
public class GmWorkPackageUserImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("582808ef-55dd-4b9c-a531-c276bf9c94dc")
    static final StyleKey REPMODE = GmWorkPackageStructuredStyleKeys.REPMODE;

    @objid ("2c15d474-9c88-4d8c-beb1-529a4bc59483")
    static final StyleKey FONT = GmWorkPackageStructuredStyleKeys.FONT;

    @objid ("f1e6f708-a01d-4cac-b924-6b30b838444c")
    static final StyleKey TEXTCOLOR = GmWorkPackageStructuredStyleKeys.TEXTCOLOR;

    @objid ("d1f839be-4042-4dac-aff4-14dfb4eeb4c9")
    static final StyleKey SHOWSTEREOTYPES = GmWorkPackageStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("97524382-3003-47bd-8916-3857cf9b6da8")
    static final StyleKey SHOWTAGS = GmWorkPackageStructuredStyleKeys.SHOWTAGS;

}

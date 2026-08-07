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
package org.modelio.archimate.diagrams.elements.courseofaction;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmCourseOfAction when its representation mode is RepresentationMode.IMAGE
 */
@objid ("3626d52a-a099-4eea-8ffb-9a0b2b7f7017")
public class GmCourseOfActionUserImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("c0fbc150-d2f2-4f57-8028-7bd5afc3cda6")
    static final StyleKey REPMODE = GmCourseOfActionStructuredStyleKeys.REPMODE;

    @objid ("5c412b8a-390b-42c5-83c8-65887a04ec93")
    static final StyleKey FONT = GmCourseOfActionStructuredStyleKeys.FONT;

    @objid ("c840ba9a-3d74-4b03-9943-376df4e13e38")
    static final StyleKey TEXTCOLOR = GmCourseOfActionStructuredStyleKeys.TEXTCOLOR;

    @objid ("bc49066f-7308-4dc4-bb38-1158b78663ce")
    static final StyleKey SHOWSTEREOTYPES = GmCourseOfActionStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("66a0d95f-3f4c-4c0e-bb2e-acd14c9270fd")
    static final StyleKey SHOWTAGS = GmCourseOfActionStructuredStyleKeys.SHOWTAGS;

}

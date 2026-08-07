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
@objid ("029d836a-36da-466f-b302-ff2c6a848564")
public class GmCourseOfActionImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("c7633de7-a2cb-4fa0-9d77-5e39a75f273e")
    static final StyleKey REPMODE = GmCourseOfActionStructuredStyleKeys.REPMODE;

    @objid ("ca03774c-9c68-4f61-af01-65998871c24d")
    static final StyleKey FONT = GmCourseOfActionStructuredStyleKeys.FONT;

    @objid ("e4bcf69b-e84a-4bb0-9464-724a35c0c777")
    static final StyleKey TEXTCOLOR = GmCourseOfActionStructuredStyleKeys.TEXTCOLOR;

    @objid ("153e4287-1d76-474a-a0a1-dae194931681")
    static final StyleKey SHOWSTEREOTYPES = GmCourseOfActionStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("147a441f-2743-4f4e-a6b5-64e5ed6af63d")
    static final StyleKey SHOWTAGS = GmCourseOfActionStructuredStyleKeys.SHOWTAGS;

}

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
package org.modelio.archimate.diagrams.elements.applicationcomponent;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmApplicationComponent when its representation mode is RepresentationMode.IMAGE
 */
@objid ("46ef9b22-3c7e-4c39-a8c8-ff3036f3f32c")
public class GmApplicationComponentUserImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("4dcb112f-d0fb-401b-9e6f-52a117ad4891")
    static final StyleKey REPMODE = GmApplicationComponentStructuredStyleKeys.REPMODE;

    @objid ("be348ea0-a4eb-4eea-9dd3-e9f119028f5e")
    static final StyleKey FONT = GmApplicationComponentStructuredStyleKeys.FONT;

    @objid ("b236987f-ab03-48a8-94ba-248108b89065")
    static final StyleKey TEXTCOLOR = GmApplicationComponentStructuredStyleKeys.TEXTCOLOR;

    @objid ("208b441c-2322-422f-b280-80f5ec79990c")
    static final StyleKey SHOWSTEREOTYPES = GmApplicationComponentStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("9b82d44f-0133-4ca8-896b-4d380782cc48")
    static final StyleKey SHOWTAGS = GmApplicationComponentStructuredStyleKeys.SHOWTAGS;

}

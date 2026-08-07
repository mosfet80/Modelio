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
package org.modelio.archimate.diagrams.elements.value;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmValue when its representation mode is RepresentationMode.IMAGE
 */
@objid ("1333e213-a3f6-4fbf-bc22-00accc0d14ee")
public class GmValueUserImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("f89e44d0-efe6-420c-94b6-14eb3598cde9")
    static final StyleKey REPMODE = GmValueStructuredStyleKeys.REPMODE;

    @objid ("584a13a5-4742-40b4-add9-0f16e4678947")
    static final StyleKey FONT = GmValueStructuredStyleKeys.FONT;

    @objid ("53114f98-83a5-4254-9882-4232c1b62019")
    static final StyleKey TEXTCOLOR = GmValueStructuredStyleKeys.TEXTCOLOR;

    @objid ("12555587-51cd-46c8-8034-c641ee8c8256")
    static final StyleKey SHOWSTEREOTYPES = GmValueStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("fae30817-afb8-4431-9567-06204625c47a")
    static final StyleKey SHOWTAGS = GmValueStructuredStyleKeys.SHOWTAGS;

}

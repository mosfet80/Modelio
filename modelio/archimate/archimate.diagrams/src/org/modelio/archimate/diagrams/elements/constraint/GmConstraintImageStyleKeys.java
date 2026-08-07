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
package org.modelio.archimate.diagrams.elements.constraint;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmConstraint when its representation mode is RepresentationMode.IMAGE
 */
@objid ("8e916fb8-88c8-459c-a7f8-62c7abf41162")
public class GmConstraintImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("f1cb2912-f4ba-4d3b-a10a-4e5d61c04834")
    static final StyleKey REPMODE = GmConstraintStructuredStyleKeys.REPMODE;

    @objid ("f876236b-0d40-423e-8737-b510bf9a1fe2")
    static final StyleKey FONT = GmConstraintStructuredStyleKeys.FONT;

    @objid ("351dd67e-ace1-49e6-b4f5-be5ccae05359")
    static final StyleKey TEXTCOLOR = GmConstraintStructuredStyleKeys.TEXTCOLOR;

    @objid ("3ca51f55-9d3a-4590-a411-1cfc5806414d")
    static final StyleKey SHOWSTEREOTYPES = GmConstraintStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("0a74b578-6275-4838-9adf-7242b0993329")
    static final StyleKey SHOWTAGS = GmConstraintStructuredStyleKeys.SHOWTAGS;

}

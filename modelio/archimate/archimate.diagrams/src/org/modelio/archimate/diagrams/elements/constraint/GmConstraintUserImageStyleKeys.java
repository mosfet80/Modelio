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
@objid ("9ad357e7-488d-40e8-841b-ff4971ea7724")
public class GmConstraintUserImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("7eebb4b2-a71e-47c1-a2ee-304596bcbdd4")
    static final StyleKey REPMODE = GmConstraintStructuredStyleKeys.REPMODE;

    @objid ("b15c25b4-a8e3-4054-96e9-8659324bbdc8")
    static final StyleKey FONT = GmConstraintStructuredStyleKeys.FONT;

    @objid ("5497e43b-adba-4b96-a71f-2a64343b7a17")
    static final StyleKey TEXTCOLOR = GmConstraintStructuredStyleKeys.TEXTCOLOR;

    @objid ("6b97e2d5-4899-47a5-86a8-645b7f088ad8")
    static final StyleKey SHOWSTEREOTYPES = GmConstraintStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("de48dede-484b-43d7-875a-ee4c55cf1bf1")
    static final StyleKey SHOWTAGS = GmConstraintStructuredStyleKeys.SHOWTAGS;

}

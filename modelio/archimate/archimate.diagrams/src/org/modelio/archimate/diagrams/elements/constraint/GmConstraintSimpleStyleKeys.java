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
 * This class provides the StyleKey constants for a GmConstraint when its representation mode is RepresentationMode.SIMPLE
 */
@objid ("dee26f9b-373e-40e1-ab65-a9e3dc5b830c")
public class GmConstraintSimpleStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("9157ac9e-6e6a-4985-bd80-7a21d5625e42")
    static final StyleKey REPMODE = GmConstraintStructuredStyleKeys.REPMODE;

    @objid ("f50c3694-fe9d-448e-b913-c873df6e31f0")
    static final StyleKey FILLCOLOR = GmConstraintStructuredStyleKeys.FILLCOLOR;

    @objid ("c2744031-db4e-49e4-9c26-3235436ca37a")
    static final StyleKey FILLMODE = GmConstraintStructuredStyleKeys.FILLMODE;

    @objid ("3a454bc8-2a1e-49e7-bf27-92d0021af82e")
    static final StyleKey LINECOLOR = GmConstraintStructuredStyleKeys.LINECOLOR;

    @objid ("7e1d1b4a-8bec-461a-8640-cfa723a7e622")
    static final StyleKey LINEWIDTH = GmConstraintStructuredStyleKeys.LINEWIDTH;

    @objid ("d7f5b0bb-7e24-4591-a46e-79c8eb4b2e05")
    static final StyleKey FONT = GmConstraintStructuredStyleKeys.FONT;

    @objid ("5ef6c4e2-8304-4d5b-8715-e5fa86f3ab9a")
    static final StyleKey TEXTCOLOR = GmConstraintStructuredStyleKeys.TEXTCOLOR;

    @objid ("0c7a807b-df5e-42b0-a835-394d9226a724")
    static final StyleKey SHOWSTEREOTYPES = GmConstraintStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("7e2c5be4-0bd0-43e3-8fc5-c8fdd3d364bd")
    static final StyleKey SHOWTAGS = GmConstraintStructuredStyleKeys.SHOWTAGS;

}

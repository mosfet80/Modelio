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
package org.modelio.archimate.diagrams.elements.artifact;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmArtifact when its representation mode is RepresentationMode.IMAGE
 */
@objid ("1e2ce801-7351-41b7-882a-faf5a2c68e94")
public class GmArtifactImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("588b7543-64a0-4f07-b4d4-fdbea1b22dad")
    static final StyleKey REPMODE = GmArtifactStructuredStyleKeys.REPMODE;

    @objid ("2602a53a-d25d-4f50-aac7-689fa3e4af9b")
    static final StyleKey FONT = GmArtifactStructuredStyleKeys.FONT;

    @objid ("f7ed6fc9-8308-4a1e-b108-827aafcdcdf7")
    static final StyleKey TEXTCOLOR = GmArtifactStructuredStyleKeys.TEXTCOLOR;

    @objid ("6887dd62-57a1-45ac-8d6e-af98e5b13a12")
    static final StyleKey SHOWSTEREOTYPES = GmArtifactStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("6c3a0ba8-6a1c-4445-a142-26b0ac0e3602")
    static final StyleKey SHOWTAGS = GmArtifactStructuredStyleKeys.SHOWTAGS;

}

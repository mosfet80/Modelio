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
 * This class provides the StyleKey constants for a GmArtifact when its representation mode is RepresentationMode.SIMPLE
 */
@objid ("6a7b03f7-13d1-4586-8ef8-3db0954ef67e")
public class GmArtifactSimpleStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("8deb21c5-8729-4855-aaab-9dfb7fecd3ac")
    static final StyleKey REPMODE = GmArtifactStructuredStyleKeys.REPMODE;

    @objid ("949c5ac0-5bc6-4584-be9c-28b34847de9b")
    static final StyleKey FILLCOLOR = GmArtifactStructuredStyleKeys.FILLCOLOR;

    @objid ("18f7e577-e47c-4b21-890e-44434709267a")
    static final StyleKey FILLMODE = GmArtifactStructuredStyleKeys.FILLMODE;

    @objid ("6f82c0a5-9156-4825-aff1-6e1c61632281")
    static final StyleKey LINECOLOR = GmArtifactStructuredStyleKeys.LINECOLOR;

    @objid ("669172b7-71d1-48f9-af02-a6eafa096fb7")
    static final StyleKey LINEWIDTH = GmArtifactStructuredStyleKeys.LINEWIDTH;

    @objid ("ab1b96f0-bede-484b-a8aa-763f3f0d8245")
    static final StyleKey FONT = GmArtifactStructuredStyleKeys.FONT;

    @objid ("d5400e15-107f-428d-86a5-5d41860fc18c")
    static final StyleKey TEXTCOLOR = GmArtifactStructuredStyleKeys.TEXTCOLOR;

    @objid ("642d9a54-945b-4b6e-bd7e-b356d71c363a")
    static final StyleKey SHOWSTEREOTYPES = GmArtifactStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("7b2eac6c-1fab-4766-a11c-78d630a40f0b")
    static final StyleKey SHOWTAGS = GmArtifactStructuredStyleKeys.SHOWTAGS;

}

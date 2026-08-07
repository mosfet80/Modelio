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
@objid ("81981b18-d59c-44b7-bb24-4cab6cad7a52")
public class GmArtifactUserImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("f1066815-7702-4490-9b09-e5cc2dbef4b6")
    static final StyleKey REPMODE = GmArtifactStructuredStyleKeys.REPMODE;

    @objid ("b77d648e-3c27-47b7-960e-155cae7df8e4")
    static final StyleKey FONT = GmArtifactStructuredStyleKeys.FONT;

    @objid ("c02db3b7-fe7b-44ee-9f77-f1508b16fc82")
    static final StyleKey TEXTCOLOR = GmArtifactStructuredStyleKeys.TEXTCOLOR;

    @objid ("bdad5768-2096-438b-b73a-e5375853cadd")
    static final StyleKey SHOWSTEREOTYPES = GmArtifactStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("2cc904f7-bdc7-4aec-b667-dea9bb87738b")
    static final StyleKey SHOWTAGS = GmArtifactStructuredStyleKeys.SHOWTAGS;

}

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
package org.modelio.archimate.diagrams.elements.meaning;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.StyleKey;
import org.modelio.diagram.styles.core.StyleKey.RepresentationMode;

/**
 * This class provides the StyleKey constants for a GmMeaning when its representation mode is {@link RepresentationMode#USER_IMAGE}.
 */
@objid ("2b3d5ac9-be63-4b97-ba53-dfd03c5fd67e")
public class GmMeaningUserImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("a369d2c7-c639-45d7-82c9-618cd0b12b83")
    static final StyleKey REPMODE = GmMeaningStructuredStyleKeys.REPMODE;

    @objid ("3a6b64af-5c8b-49f6-b695-4b11f9d5da6b")
    static final StyleKey FONT = GmMeaningStructuredStyleKeys.FONT;

    @objid ("7fc4ea4c-64cc-4fbb-b6cd-b40f899c6306")
    static final StyleKey TEXTCOLOR = GmMeaningStructuredStyleKeys.TEXTCOLOR;

    @objid ("6ca08982-14f1-46fe-9b06-7e9acebb4452")
    static final StyleKey SHOWSTEREOTYPES = GmMeaningStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("c3838126-0ec2-4b95-a961-5a794e0f5135")
    static final StyleKey SHOWTAGS = GmMeaningStructuredStyleKeys.SHOWTAGS;

}

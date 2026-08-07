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
package org.modelio.archimate.diagrams.elements.location;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmLocation when its representation mode is RepresentationMode.IMAGE
 */
@objid ("2c823501-a9fa-41f4-9900-9d39bbe5d86c")
public class GmLocationUserImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("a1d8419c-4462-4888-af0c-877745bebfdd")
    static final StyleKey REPMODE = GmLocationStructuredStyleKeys.REPMODE;

    @objid ("eb14a68a-ae15-4de4-aa65-32ef3ddcd4cc")
    static final StyleKey FONT = GmLocationStructuredStyleKeys.FONT;

    @objid ("55d568a7-7f16-491a-81f6-cd0734e69eaf")
    static final StyleKey TEXTCOLOR = GmLocationStructuredStyleKeys.TEXTCOLOR;

    @objid ("45ead766-7e01-4be6-9de8-6922d70a5efc")
    static final StyleKey SHOWSTEREOTYPES = GmLocationStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("49ac4fd4-c043-4e18-8e64-868c05ecc700")
    static final StyleKey SHOWTAGS = GmLocationStructuredStyleKeys.SHOWTAGS;

}

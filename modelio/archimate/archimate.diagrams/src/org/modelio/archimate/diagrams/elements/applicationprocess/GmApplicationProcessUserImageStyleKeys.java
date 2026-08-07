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
package org.modelio.archimate.diagrams.elements.applicationprocess;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmApplicationProcess when its representation mode is RepresentationMode.IMAGE
 */
@objid ("a7e4bd72-f924-45bb-8012-97d9f02935d0")
public class GmApplicationProcessUserImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("81ef23d9-92cc-4931-a4db-cfcde2a86992")
    static final StyleKey REPMODE = GmApplicationProcessStructuredStyleKeys.REPMODE;

    @objid ("28dbd8fc-1d8d-406c-85bb-d9b4f4689dad")
    static final StyleKey FONT = GmApplicationProcessStructuredStyleKeys.FONT;

    @objid ("e176b643-f79a-4a94-849a-a9b57ea7cdd0")
    static final StyleKey TEXTCOLOR = GmApplicationProcessStructuredStyleKeys.TEXTCOLOR;

    @objid ("aa4fb408-7a35-4fd8-a56f-2c4d5e2d9468")
    static final StyleKey SHOWSTEREOTYPES = GmApplicationProcessStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("9f9b6f71-b971-4afb-8c06-39b6c04dca9e")
    static final StyleKey SHOWTAGS = GmApplicationProcessStructuredStyleKeys.SHOWTAGS;

}

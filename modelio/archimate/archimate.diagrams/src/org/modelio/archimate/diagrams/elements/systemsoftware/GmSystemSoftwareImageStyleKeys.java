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
package org.modelio.archimate.diagrams.elements.systemsoftware;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmSystemSoftware when its representation mode is RepresentationMode.IMAGE
 */
@objid ("c9439c5d-47b3-4a8f-9b23-689911354a78")
public class GmSystemSoftwareImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("57331e46-e37e-47c8-8d20-93607b9b6716")
    static final StyleKey REPMODE = GmSystemSoftwareStructuredStyleKeys.REPMODE;

    @objid ("2a88cb54-7fb0-4403-8f7d-f310db569b62")
    static final StyleKey FONT = GmSystemSoftwareStructuredStyleKeys.FONT;

    @objid ("e54e59b0-b619-4dc0-87a6-1f4b0aa710a5")
    static final StyleKey TEXTCOLOR = GmSystemSoftwareStructuredStyleKeys.TEXTCOLOR;

    @objid ("eafe5f47-59c7-4166-8149-711c6e937a8a")
    static final StyleKey SHOWSTEREOTYPES = GmSystemSoftwareStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("4833162e-8308-407f-bfca-f6de22ba0a90")
    static final StyleKey SHOWTAGS = GmSystemSoftwareStructuredStyleKeys.SHOWTAGS;

}

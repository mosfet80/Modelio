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
package org.modelio.archimate.diagrams.elements.equipment;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmEquipment when its representation mode is RepresentationMode.IMAGE
 */
@objid ("e0276baf-86d9-4010-9a1a-942231072b58")
public class GmEquipmentImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("c58bb70a-628c-4cd1-8697-b7d6171b863f")
    static final StyleKey REPMODE = GmEquipmentStructuredStyleKeys.REPMODE;

    @objid ("687d0f83-7a49-45b3-97c2-ded29306c877")
    static final StyleKey FONT = GmEquipmentStructuredStyleKeys.FONT;

    @objid ("c2aa9716-47cf-4182-94e3-90328455eb24")
    static final StyleKey TEXTCOLOR = GmEquipmentStructuredStyleKeys.TEXTCOLOR;

    @objid ("b2f3a25d-0425-475e-a523-0583aaa21638")
    static final StyleKey SHOWSTEREOTYPES = GmEquipmentStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("b582122c-fe26-4003-b941-61a96749dbf9")
    static final StyleKey SHOWTAGS = GmEquipmentStructuredStyleKeys.SHOWTAGS;

}

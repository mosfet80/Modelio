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
@objid ("8980b4a2-cf7b-410e-b0af-e989ea521921")
public class GmEquipmentUserImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("b7a9f0a9-5c15-4701-81dc-54cf930bf79e")
    static final StyleKey REPMODE = GmEquipmentStructuredStyleKeys.REPMODE;

    @objid ("f40d4ce0-7575-464e-a26c-50e5e8737c80")
    static final StyleKey FONT = GmEquipmentStructuredStyleKeys.FONT;

    @objid ("03124618-79e9-4959-922d-46db2a2a0807")
    static final StyleKey TEXTCOLOR = GmEquipmentStructuredStyleKeys.TEXTCOLOR;

    @objid ("d50fada4-5996-407f-8c10-8f20f275f596")
    static final StyleKey SHOWSTEREOTYPES = GmEquipmentStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("25b931c4-e450-454f-a9c3-1831cca6eff0")
    static final StyleKey SHOWTAGS = GmEquipmentStructuredStyleKeys.SHOWTAGS;

}

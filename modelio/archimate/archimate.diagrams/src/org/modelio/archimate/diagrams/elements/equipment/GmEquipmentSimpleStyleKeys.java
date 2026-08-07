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
 * This class provides the StyleKey constants for a GmEquipment when its representation mode is RepresentationMode.SIMPLE
 */
@objid ("f8f51220-ffab-4f43-992f-1c229e4d2319")
public class GmEquipmentSimpleStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("6d077971-4938-4690-9868-73a5b9137d73")
    static final StyleKey REPMODE = GmEquipmentStructuredStyleKeys.REPMODE;

    @objid ("65ecafe1-b20b-4f45-a5a6-16b86ddf7e0a")
    static final StyleKey FILLCOLOR = GmEquipmentStructuredStyleKeys.FILLCOLOR;

    @objid ("546f1fd0-5335-4f57-9494-e522c169befe")
    static final StyleKey FILLMODE = GmEquipmentStructuredStyleKeys.FILLMODE;

    @objid ("d0b88669-7994-4ea3-87d7-e2ed729d75af")
    static final StyleKey LINECOLOR = GmEquipmentStructuredStyleKeys.LINECOLOR;

    @objid ("d30e898f-83bd-43e4-9a3a-4db2cffe1add")
    static final StyleKey LINEWIDTH = GmEquipmentStructuredStyleKeys.LINEWIDTH;

    @objid ("8af7c41c-cfa9-440f-8b3c-d7efd7f246bd")
    static final StyleKey FONT = GmEquipmentStructuredStyleKeys.FONT;

    @objid ("f56b0c86-cc30-4040-abf2-508a11e5fa1c")
    static final StyleKey TEXTCOLOR = GmEquipmentStructuredStyleKeys.TEXTCOLOR;

    @objid ("65a1ffd1-9538-426f-bd90-a786ba892caa")
    static final StyleKey SHOWSTEREOTYPES = GmEquipmentStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("b583aab2-43c9-4172-96b8-af222e330186")
    static final StyleKey SHOWTAGS = GmEquipmentStructuredStyleKeys.SHOWTAGS;

}

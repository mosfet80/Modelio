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
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmEquipment when its representation mode is RepresentationMode.STRUCTURED
 */
@objid ("b6540b0f-9267-48d3-b95a-f3e974c8cb38")
public class GmEquipmentStructuredStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("ce866030-cfae-4736-8b84-96422fd486a2")
    static final StyleKey REPMODE = createStyleKey("EQUIPMENT_REPMODE", MetaKey.REPMODE);

    @objid ("ddabae7c-2a8f-4f66-b433-b99868c7d506")
    static final StyleKey FILLCOLOR = createStyleKey("EQUIPMENT_FILLCOLOR", MetaKey.FILLCOLOR);

    @objid ("3d10a1e7-a76c-4995-9033-a03bf09696bc")
    static final StyleKey FILLMODE = createStyleKey("EQUIPMENT_FILLMODE", MetaKey.FILLMODE);

    @objid ("410ae964-c395-4fad-8dee-d8101516382a")
    static final StyleKey LINECOLOR = createStyleKey("EQUIPMENT_LINECOLOR", MetaKey.LINECOLOR);

    @objid ("63994b21-a711-4374-8cd7-eb7d7c117f0c")
    static final StyleKey LINEWIDTH = createStyleKey("EQUIPMENT_LINEWIDTH", MetaKey.LINEWIDTH);

    @objid ("077d2536-09c2-42a5-9cad-9272b01d6302")
    static final StyleKey FONT = createStyleKey("EQUIPMENT_FONT", MetaKey.FONT);

    @objid ("ddd870c8-6dad-4700-8792-1dea8d7933b9")
    static final StyleKey TEXTCOLOR = createStyleKey("EQUIPMENT_TEXTCOLOR", MetaKey.TEXTCOLOR);

    @objid ("59d29711-a324-421f-9527-41ac986d36ae")
    static final StyleKey SHOWSTEREOTYPES = createStyleKey("EQUIPMENT_SHOWSTEREOTYPES", MetaKey.SHOWSTEREOTYPES);

    @objid ("327a87af-26d9-4ca9-bd2f-77562e300d48")
    static final StyleKey SHOWTAGS = createStyleKey("EQUIPMENT_SHOWTAGS", MetaKey.SHOWTAGS);

}

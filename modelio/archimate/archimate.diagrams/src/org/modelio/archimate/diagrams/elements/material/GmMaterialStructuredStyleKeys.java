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
package org.modelio.archimate.diagrams.elements.material;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmMaterial when its representation mode is RepresentationMode.STRUCTURED
 */
@objid ("f471f6eb-a0fd-4339-b2d3-34effee9609f")
public class GmMaterialStructuredStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("7d492564-8839-4a1e-8e21-e9557c69f133")
    static final StyleKey REPMODE = createStyleKey("MATERIAL_REPMODE", MetaKey.REPMODE);

    @objid ("531e6342-da56-40dc-b6b6-2978421e8fd3")
    static final StyleKey FILLCOLOR = createStyleKey("MATERIAL_FILLCOLOR", MetaKey.FILLCOLOR);

    @objid ("0a01055c-49af-45e7-aa59-4815331058d8")
    static final StyleKey FILLMODE = createStyleKey("MATERIAL_FILLMODE", MetaKey.FILLMODE);

    @objid ("e0e56542-32a2-454c-b6a2-d92e284bbfa3")
    static final StyleKey LINECOLOR = createStyleKey("MATERIAL_LINECOLOR", MetaKey.LINECOLOR);

    @objid ("06a86689-d41b-4c11-a967-16aba9ad7601")
    static final StyleKey LINEWIDTH = createStyleKey("MATERIAL_LINEWIDTH", MetaKey.LINEWIDTH);

    @objid ("16bfa20a-9e40-41ec-b9ca-f77eb0e4306e")
    static final StyleKey FONT = createStyleKey("MATERIAL_FONT", MetaKey.FONT);

    @objid ("26e0d6d8-9008-4d05-a51c-3757edb26f07")
    static final StyleKey TEXTCOLOR = createStyleKey("MATERIAL_TEXTCOLOR", MetaKey.TEXTCOLOR);

    @objid ("86d03ab7-6a79-46ad-bbe3-0b355a3695f0")
    static final StyleKey SHOWSTEREOTYPES = createStyleKey("MATERIAL_SHOWSTEREOTYPES", MetaKey.SHOWSTEREOTYPES);

    @objid ("3f3b847c-f47f-44f8-8634-ae32e833fe59")
    static final StyleKey SHOWTAGS = createStyleKey("MATERIAL_SHOWTAGS", MetaKey.SHOWTAGS);

}

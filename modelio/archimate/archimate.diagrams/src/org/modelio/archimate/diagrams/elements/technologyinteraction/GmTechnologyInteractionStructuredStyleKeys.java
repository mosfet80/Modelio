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
package org.modelio.archimate.diagrams.elements.technologyinteraction;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmTechnologyInteraction when its representation mode is RepresentationMode.STRUCTURED
 */
@objid ("e3cf5088-c7e1-466c-b90c-b26357775fc2")
public class GmTechnologyInteractionStructuredStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("34040943-53f4-45b7-b0cd-59f5fc2160d0")
    static final StyleKey REPMODE = createStyleKey("TECHNOLOGYINTERACTION_REPMODE", MetaKey.REPMODE);

    @objid ("e2c9ab29-263a-41bf-a192-b8b2c0ac074f")
    static final StyleKey FILLCOLOR = createStyleKey("TECHNOLOGYINTERACTION_FILLCOLOR", MetaKey.FILLCOLOR);

    @objid ("8e9d7ba6-7737-4dec-bcfa-d547b55e58bc")
    static final StyleKey FILLMODE = createStyleKey("TECHNOLOGYINTERACTION_FILLMODE", MetaKey.FILLMODE);

    @objid ("55efe506-4d6a-4ab7-9878-74fdc3deceec")
    static final StyleKey LINECOLOR = createStyleKey("TECHNOLOGYINTERACTION_LINECOLOR", MetaKey.LINECOLOR);

    @objid ("444b8d23-e9ed-45e6-bb43-f660997025b1")
    static final StyleKey LINEWIDTH = createStyleKey("TECHNOLOGYINTERACTION_LINEWIDTH", MetaKey.LINEWIDTH);

    @objid ("77387d50-4cd8-4fdb-86f8-a8e2f724a829")
    static final StyleKey FONT = createStyleKey("TECHNOLOGYINTERACTION_FONT", MetaKey.FONT);

    @objid ("7d2450e8-51d6-4b52-9529-b1a5f2f3643f")
    static final StyleKey TEXTCOLOR = createStyleKey("TECHNOLOGYINTERACTION_TEXTCOLOR", MetaKey.TEXTCOLOR);

    @objid ("e7934ac8-922a-4de5-af61-54d3057eeb77")
    static final StyleKey SHOWSTEREOTYPES = createStyleKey("TECHNOLOGYINTERACTION_SHOWSTEREOTYPES", MetaKey.SHOWSTEREOTYPES);

    @objid ("f091fd47-bded-4947-ba99-240312184fad")
    static final StyleKey SHOWTAGS = createStyleKey("TECHNOLOGYINTERACTION_SHOWTAGS", MetaKey.SHOWTAGS);

}

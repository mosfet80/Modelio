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
package org.modelio.archimate.diagrams.elements.resource;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmResource when its representation mode is RepresentationMode.STRUCTURED
 */
@objid ("6ed6cec6-cef5-4b9e-8e63-f6fe24f012be")
public class GmResourceStructuredStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("4b2c8aae-b6d6-4e89-a839-22ffab33f83c")
    static final StyleKey REPMODE = createStyleKey("RESOURCE_REPMODE", MetaKey.REPMODE);

    @objid ("e273179e-4ca1-48f5-a4ec-8d55820ac032")
    static final StyleKey FILLCOLOR = createStyleKey("RESOURCE_FILLCOLOR", MetaKey.FILLCOLOR);

    @objid ("483782d9-8164-401c-b211-f29302667fe8")
    static final StyleKey FILLMODE = createStyleKey("RESOURCE_FILLMODE", MetaKey.FILLMODE);

    @objid ("e67f7aa3-686b-4d07-b7a0-83b5a203a6d8")
    static final StyleKey LINECOLOR = createStyleKey("RESOURCE_LINECOLOR", MetaKey.LINECOLOR);

    @objid ("18029aff-4362-4336-a14e-e8417bb0f3aa")
    static final StyleKey LINEWIDTH = createStyleKey("RESOURCE_LINEWIDTH", MetaKey.LINEWIDTH);

    @objid ("1abae958-4042-4d3f-8db8-20c61967f0c9")
    static final StyleKey FONT = createStyleKey("RESOURCE_FONT", MetaKey.FONT);

    @objid ("687fbbde-2c4a-43f9-9e0e-e8a798d4fe90")
    static final StyleKey TEXTCOLOR = createStyleKey("RESOURCE_TEXTCOLOR", MetaKey.TEXTCOLOR);

    @objid ("d9ea23c0-124b-4eb5-8c72-52a71efc0706")
    static final StyleKey SHOWSTEREOTYPES = createStyleKey("RESOURCE_SHOWSTEREOTYPES", MetaKey.SHOWSTEREOTYPES);

    @objid ("69e25e1a-625e-41d1-80a9-2cf9ff8beb9a")
    static final StyleKey SHOWTAGS = createStyleKey("RESOURCE_SHOWTAGS", MetaKey.SHOWTAGS);

}

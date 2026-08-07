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
package org.modelio.archimate.diagrams.elements.facility;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmFacility when its representation mode is RepresentationMode.STRUCTURED
 */
@objid ("b2348290-b274-4afb-96de-3b5e742c4b4a")
public class GmFacilityStructuredStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("39333f42-338e-4269-9e16-de2dc5808825")
    static final StyleKey REPMODE = createStyleKey("FACILITY_REPMODE", MetaKey.REPMODE);

    @objid ("dc67e629-aad5-4b67-aeaf-bb85b67236f0")
    static final StyleKey FILLCOLOR = createStyleKey("FACILITY_FILLCOLOR", MetaKey.FILLCOLOR);

    @objid ("4fded2c9-ecd0-41c2-aa95-844e96d1a21c")
    static final StyleKey FILLMODE = createStyleKey("FACILITY_FILLMODE", MetaKey.FILLMODE);

    @objid ("6bd6e9e8-6e02-4ee3-b071-3b6a9efbe8eb")
    static final StyleKey LINECOLOR = createStyleKey("FACILITY_LINECOLOR", MetaKey.LINECOLOR);

    @objid ("7d487679-153e-4624-acd0-ed76728065a4")
    static final StyleKey LINEWIDTH = createStyleKey("FACILITY_LINEWIDTH", MetaKey.LINEWIDTH);

    @objid ("c4bc583a-31fd-4085-a833-34667a742182")
    static final StyleKey FONT = createStyleKey("FACILITY_FONT", MetaKey.FONT);

    @objid ("3aa754e2-1001-4c2e-8de8-7ff6e1eab085")
    static final StyleKey TEXTCOLOR = createStyleKey("FACILITY_TEXTCOLOR", MetaKey.TEXTCOLOR);

    @objid ("17ea3210-41ae-415a-8d39-3e4b29d9e5ff")
    static final StyleKey SHOWSTEREOTYPES = createStyleKey("FACILITY_SHOWSTEREOTYPES", MetaKey.SHOWSTEREOTYPES);

    @objid ("3fa44e89-70ee-4df9-87e8-f797721bfd6d")
    static final StyleKey SHOWTAGS = createStyleKey("FACILITY_SHOWTAGS", MetaKey.SHOWTAGS);

}

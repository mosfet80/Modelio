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
package org.modelio.archimate.diagrams.elements.businessinteraction;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmBusinessInteraction when its representation mode is RepresentationMode.STRUCTURED
 */
@objid ("352e9233-9ef3-4c08-9198-e41fd25af1c2")
public class GmBusinessInteractionStructuredStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("63cdf823-8a70-4ee1-ae4f-90d400ead7ab")
    static final StyleKey REPMODE = createStyleKey("BUSINESSINTERACTION_REPMODE", MetaKey.REPMODE);

    @objid ("508d83f8-7342-4fca-88b1-203640667b73")
    static final StyleKey FILLCOLOR = createStyleKey("BUSINESSINTERACTION_FILLCOLOR", MetaKey.FILLCOLOR);

    @objid ("dae14f17-52f7-4f45-85b2-4f069c0d9e18")
    static final StyleKey FILLMODE = createStyleKey("BUSINESSINTERACTION_FILLMODE", MetaKey.FILLMODE);

    @objid ("e2aa39f0-d3b5-4f2a-960d-6740fe3f3c6d")
    static final StyleKey LINECOLOR = createStyleKey("BUSINESSINTERACTION_LINECOLOR", MetaKey.LINECOLOR);

    @objid ("46b96a66-6290-497a-9c5f-51bc2326c5d3")
    static final StyleKey LINEWIDTH = createStyleKey("BUSINESSINTERACTION_LINEWIDTH", MetaKey.LINEWIDTH);

    @objid ("1c3f37b6-78cb-4399-accf-f83d886f9bbe")
    static final StyleKey FONT = createStyleKey("BUSINESSINTERACTION_FONT", MetaKey.FONT);

    @objid ("88b895ee-bd8a-404d-9751-2aaf9009ecb0")
    static final StyleKey TEXTCOLOR = createStyleKey("BUSINESSINTERACTION_TEXTCOLOR", MetaKey.TEXTCOLOR);

    @objid ("b1fe91ef-e530-4850-93dc-eac98b70b3c7")
    static final StyleKey SHOWSTEREOTYPES = createStyleKey("BUSINESSINTERACTION_SHOWSTEREOTYPES", MetaKey.SHOWSTEREOTYPES);

    @objid ("a78a1ac7-cd52-4f35-abbd-59f42e109a0c")
    static final StyleKey SHOWTAGS = createStyleKey("BUSINESSINTERACTION_SHOWTAGS", MetaKey.SHOWTAGS);

}

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
package org.modelio.archimate.diagrams.elements.location;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmLocation when its representation mode is RepresentationMode.STRUCTURED
 */
@objid ("ae95843a-4e2a-4ad9-b233-1e64658b9e41")
public class GmLocationStructuredStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("c31a5c04-d2b2-4f5c-8b02-6d4f34f82bb7")
    static final StyleKey REPMODE = createStyleKey("LOCATION_REPMODE", MetaKey.REPMODE);

    @objid ("0ee0bdf1-ad23-4615-908c-da0a31f10e0a")
    static final StyleKey FILLCOLOR = createStyleKey("LOCATION_FILLCOLOR", MetaKey.FILLCOLOR);

    @objid ("ff415460-ad55-4530-bad6-c6979601e6d4")
    static final StyleKey FILLMODE = createStyleKey("LOCATION_FILLMODE", MetaKey.FILLMODE);

    @objid ("38a018e2-5707-4182-98dd-a8c6df49926f")
    static final StyleKey LINECOLOR = createStyleKey("LOCATION_LINECOLOR", MetaKey.LINECOLOR);

    @objid ("f2fc0b65-c2ba-48dd-b251-7d31e685eb60")
    static final StyleKey LINEWIDTH = createStyleKey("LOCATION_LINEWIDTH", MetaKey.LINEWIDTH);

    @objid ("2fa96c32-c4d1-4cff-ae5a-17c38668fb6d")
    static final StyleKey FONT = createStyleKey("LOCATION_FONT", MetaKey.FONT);

    @objid ("c0c3378a-46cd-49df-9718-411b209f7bfb")
    static final StyleKey TEXTCOLOR = createStyleKey("LOCATION_TEXTCOLOR", MetaKey.TEXTCOLOR);

    @objid ("1f1d88c5-b0bf-419d-a69a-963b8da1ae1d")
    static final StyleKey SHOWSTEREOTYPES = createStyleKey("LOCATION_SHOWSTEREOTYPES", MetaKey.SHOWSTEREOTYPES);

    @objid ("9c119a8e-bbdb-4f0d-ad87-fedb14db0cec")
    static final StyleKey SHOWTAGS = createStyleKey("LOCATION_SHOWTAGS", MetaKey.SHOWTAGS);

}

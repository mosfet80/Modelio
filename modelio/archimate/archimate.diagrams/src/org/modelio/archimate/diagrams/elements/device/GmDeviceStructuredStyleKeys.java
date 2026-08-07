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
package org.modelio.archimate.diagrams.elements.device;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmDevice when its representation mode is RepresentationMode.STRUCTURED
 */
@objid ("acbe45ab-527a-4e46-baad-8d129810462e")
public class GmDeviceStructuredStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("036b6460-89e7-4025-93ce-149b8b965baf")
    static final StyleKey REPMODE = createStyleKey("DEVICE_REPMODE", MetaKey.REPMODE);

    @objid ("40a7b02a-80cb-4e75-953e-724aa3b90c53")
    static final StyleKey FILLCOLOR = createStyleKey("DEVICE_FILLCOLOR", MetaKey.FILLCOLOR);

    @objid ("40123fbb-8b31-49ff-9ac5-9790e2474d06")
    static final StyleKey FILLMODE = createStyleKey("DEVICE_FILLMODE", MetaKey.FILLMODE);

    @objid ("46dca121-3e91-40e8-9c7e-1e2315aef9a0")
    static final StyleKey LINECOLOR = createStyleKey("DEVICE_LINECOLOR", MetaKey.LINECOLOR);

    @objid ("30557385-868a-405d-a3c9-df2f529abef5")
    static final StyleKey LINEWIDTH = createStyleKey("DEVICE_LINEWIDTH", MetaKey.LINEWIDTH);

    @objid ("80bb0581-4bf3-4382-821c-7efcefd9c2c1")
    static final StyleKey FONT = createStyleKey("DEVICE_FONT", MetaKey.FONT);

    @objid ("5ce945f3-db6d-4d6e-ae00-aca273b9173c")
    static final StyleKey TEXTCOLOR = createStyleKey("DEVICE_TEXTCOLOR", MetaKey.TEXTCOLOR);

    @objid ("8819d147-632b-40c1-99b1-21d9faceff05")
    static final StyleKey SHOWSTEREOTYPES = createStyleKey("DEVICE_SHOWSTEREOTYPES", MetaKey.SHOWSTEREOTYPES);

    @objid ("9626f7dc-4b4a-4cdb-ae1c-901ebe673b15")
    static final StyleKey SHOWTAGS = createStyleKey("DEVICE_SHOWTAGS", MetaKey.SHOWTAGS);

}

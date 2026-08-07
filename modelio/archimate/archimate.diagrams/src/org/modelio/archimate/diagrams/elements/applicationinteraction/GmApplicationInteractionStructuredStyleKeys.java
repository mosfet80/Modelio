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
package org.modelio.archimate.diagrams.elements.applicationinteraction;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmApplicationInteraction when its representation mode is RepresentationMode.STRUCTURED
 */
@objid ("523696a1-829f-4206-b47b-c7fb8ae53e25")
public class GmApplicationInteractionStructuredStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("b11add5d-9531-4b12-b01b-d7b8a1d0405a")
    static final StyleKey REPMODE = createStyleKey("APPLICATIONINTERACTION_REPMODE", MetaKey.REPMODE);

    @objid ("9db2e82b-d0b2-40ff-a966-ef555e1db501")
    static final StyleKey FILLCOLOR = createStyleKey("APPLICATIONINTERACTION_FILLCOLOR", MetaKey.FILLCOLOR);

    @objid ("b1b7aab4-d4fb-4479-950b-e633933860cf")
    static final StyleKey FILLMODE = createStyleKey("APPLICATIONINTERACTION_FILLMODE", MetaKey.FILLMODE);

    @objid ("e23b3b28-2c0f-46dc-9aba-c25c28c541bf")
    static final StyleKey LINECOLOR = createStyleKey("APPLICATIONINTERACTION_LINECOLOR", MetaKey.LINECOLOR);

    @objid ("8e2ba65e-3416-4dc3-a0e6-b8395f3c5437")
    static final StyleKey LINEWIDTH = createStyleKey("APPLICATIONINTERACTION_LINEWIDTH", MetaKey.LINEWIDTH);

    @objid ("852a702c-454d-4908-9bdb-4207249a74cb")
    static final StyleKey FONT = createStyleKey("APPLICATIONINTERACTION_FONT", MetaKey.FONT);

    @objid ("8d8e9330-f94f-4fb9-847a-3f81567b8dbc")
    static final StyleKey TEXTCOLOR = createStyleKey("APPLICATIONINTERACTION_TEXTCOLOR", MetaKey.TEXTCOLOR);

    @objid ("3f8ee3e8-46e5-444b-b737-3fe8e93cd130")
    static final StyleKey SHOWSTEREOTYPES = createStyleKey("APPLICATIONINTERACTION_SHOWSTEREOTYPES", MetaKey.SHOWSTEREOTYPES);

    @objid ("a77593b7-bb2c-4197-8ce6-b94e9f386490")
    static final StyleKey SHOWTAGS = createStyleKey("APPLICATIONINTERACTION_SHOWTAGS", MetaKey.SHOWTAGS);

}

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
package org.modelio.archimate.diagrams.elements.applicationinterface;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmApplicationInterface when its representation mode is RepresentationMode.STRUCTURED
 */
@objid ("63c3d7ac-7cd3-455d-badb-fe40f73e87d4")
public class GmApplicationInterfaceStructuredStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("cb9f8775-63e4-4d9e-8c78-37f16e4cfa04")
    static final StyleKey REPMODE = createStyleKey("APPLICATIONINTERFACE_REPMODE", MetaKey.REPMODE);

    @objid ("fd608826-34dc-4921-b3d7-7e38db14c5cd")
    static final StyleKey FILLCOLOR = createStyleKey("APPLICATIONINTERFACE_FILLCOLOR", MetaKey.FILLCOLOR);

    @objid ("a20dffb0-f07a-480d-b15b-2deb1664858f")
    static final StyleKey FILLMODE = createStyleKey("APPLICATIONINTERFACE_FILLMODE", MetaKey.FILLMODE);

    @objid ("228f2b31-68be-425e-a9eb-72d533de9fb2")
    static final StyleKey LINECOLOR = createStyleKey("APPLICATIONINTERFACE_LINECOLOR", MetaKey.LINECOLOR);

    @objid ("175617d1-3159-466e-bb11-d4a3648413b6")
    static final StyleKey LINEWIDTH = createStyleKey("APPLICATIONINTERFACE_LINEWIDTH", MetaKey.LINEWIDTH);

    @objid ("b01766a4-a3a5-45f5-840b-dd84a4088509")
    static final StyleKey FONT = createStyleKey("APPLICATIONINTERFACE_FONT", MetaKey.FONT);

    @objid ("f0079813-04b5-483b-877f-17b4fa02d842")
    static final StyleKey TEXTCOLOR = createStyleKey("APPLICATIONINTERFACE_TEXTCOLOR", MetaKey.TEXTCOLOR);

    @objid ("a0967c26-fce9-4c4b-b327-5ec893ec9253")
    static final StyleKey SHOWSTEREOTYPES = createStyleKey("APPLICATIONINTERFACE_SHOWSTEREOTYPES", MetaKey.SHOWSTEREOTYPES);

    @objid ("0d5b0b1c-e245-42a1-9567-8aa1aede3dde")
    static final StyleKey SHOWTAGS = createStyleKey("APPLICATIONINTERFACE_SHOWTAGS", MetaKey.SHOWTAGS);

}

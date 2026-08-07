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
package org.modelio.archimate.diagrams.elements.businessinterface;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmBusinessInterface when its representation mode is RepresentationMode.STRUCTURED
 */
@objid ("74509eeb-3d0a-4403-8aa1-d2a865001f9e")
public class GmBusinessInterfaceStructuredStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("5f7807b4-958d-4e99-9017-2237516304b3")
    static final StyleKey REPMODE = createStyleKey("BUSINESSINTERFACE_REPMODE", MetaKey.REPMODE);

    @objid ("886cae3f-f1c6-4ee7-9937-21249e55ab0e")
    static final StyleKey FILLCOLOR = createStyleKey("BUSINESSINTERFACE_FILLCOLOR", MetaKey.FILLCOLOR);

    @objid ("9251a308-76f4-4eba-bd20-d1fb783ba5a8")
    static final StyleKey FILLMODE = createStyleKey("BUSINESSINTERFACE_FILLMODE", MetaKey.FILLMODE);

    @objid ("54c7ec17-eb4f-41b9-b713-2e233ccb140c")
    static final StyleKey LINECOLOR = createStyleKey("BUSINESSINTERFACE_LINECOLOR", MetaKey.LINECOLOR);

    @objid ("b8b174ea-3ddd-4429-bfbe-62e691e71638")
    static final StyleKey LINEWIDTH = createStyleKey("BUSINESSINTERFACE_LINEWIDTH", MetaKey.LINEWIDTH);

    @objid ("8018e804-ad86-49d4-bc29-e7f6a8da6790")
    static final StyleKey FONT = createStyleKey("BUSINESSINTERFACE_FONT", MetaKey.FONT);

    @objid ("90c4e15d-f9df-4cbc-b070-45142b8a0d1d")
    static final StyleKey TEXTCOLOR = createStyleKey("BUSINESSINTERFACE_TEXTCOLOR", MetaKey.TEXTCOLOR);

    @objid ("83afc05e-57aa-4723-bbd4-8d0cc739adf1")
    static final StyleKey SHOWSTEREOTYPES = createStyleKey("BUSINESSINTERFACE_SHOWSTEREOTYPES", MetaKey.SHOWSTEREOTYPES);

    @objid ("42011e00-7ea7-411f-a955-a5b38e08561a")
    static final StyleKey SHOWTAGS = createStyleKey("BUSINESSINTERFACE_SHOWTAGS", MetaKey.SHOWTAGS);

}

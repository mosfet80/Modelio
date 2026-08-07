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
package org.modelio.archimate.diagrams.elements.driver;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmDriver when its representation mode is RepresentationMode.STRUCTURED
 */
@objid ("b7525296-3f69-450d-b66b-9fc556140ad9")
public class GmDriverStructuredStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("983a8bac-dad6-4471-814d-59da04aaf37f")
    static final StyleKey REPMODE = createStyleKey("DRIVER_REPMODE", MetaKey.REPMODE);

    @objid ("854fb18c-8bdb-4537-a868-31e643e19789")
    static final StyleKey FILLCOLOR = createStyleKey("DRIVER_FILLCOLOR", MetaKey.FILLCOLOR);

    @objid ("00ed48c4-f473-4355-b315-68e807c78f35")
    static final StyleKey FILLMODE = createStyleKey("DRIVER_FILLMODE", MetaKey.FILLMODE);

    @objid ("10e8316f-4226-4948-a472-40d6b5c66fad")
    static final StyleKey LINECOLOR = createStyleKey("DRIVER_LINECOLOR", MetaKey.LINECOLOR);

    @objid ("6f677c40-7508-4bba-b944-afe92ea5c2ff")
    static final StyleKey LINEWIDTH = createStyleKey("DRIVER_LINEWIDTH", MetaKey.LINEWIDTH);

    @objid ("e0d4ffe3-8a59-4381-8514-3e2145041df1")
    static final StyleKey FONT = createStyleKey("DRIVER_FONT", MetaKey.FONT);

    @objid ("5f0742bb-e77f-4d73-ab54-50658cd2b57d")
    static final StyleKey TEXTCOLOR = createStyleKey("DRIVER_TEXTCOLOR", MetaKey.TEXTCOLOR);

    @objid ("26c29414-907e-4963-9583-179c145a92f5")
    static final StyleKey SHOWSTEREOTYPES = createStyleKey("DRIVER_SHOWSTEREOTYPES", MetaKey.SHOWSTEREOTYPES);

    @objid ("e6b47444-5c9d-4d4d-bcf5-1faf438b31d4")
    static final StyleKey SHOWTAGS = createStyleKey("DRIVER_SHOWTAGS", MetaKey.SHOWTAGS);

}

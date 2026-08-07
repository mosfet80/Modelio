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
package org.modelio.archimate.diagrams.elements.specialization;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * GmSpecialization style keys for the standard structured mode.
 */
@objid ("990567e3-9823-40a0-ad41-ff455caef427")
public class GmSpecializationLinkStyleKeys extends ArchimateAbstractStyleKeyProvider {
    /**
     * Fill color.
     */
    @objid ("fd7db1e7-bfb8-44a8-bdb0-78829cea26f3")
    public static final StyleKey FILLCOLOR = createStyleKey("SPECIALIZATION_FILLCOLOR", MetaKey.FILLCOLOR);

    /**
     * Line color
     */
    @objid ("6244fca1-e0be-4852-ad6a-54e60d743e1a")
    public static final StyleKey LINECOLOR = createStyleKey("SPECIALIZATION_LINECOLOR", MetaKey.LINECOLOR);

    /**
     * Line width
     */
    @objid ("5ec89118-bc17-4892-bee9-9a32154fad18")
    public static final StyleKey LINEWIDTH = createStyleKey("SPECIALIZATION_LINEWIDTH", MetaKey.LINEWIDTH);

    /**
     * Text font
     */
    @objid ("de68d8b2-e5d9-476f-99c1-06b40a919b72")
    public static final StyleKey FONT = createStyleKey("SPECIALIZATION_FONT", MetaKey.FONT);

    /**
     * Text color
     */
    @objid ("5c143b52-eb43-43de-b9a1-a91013a8a095")
    public static final StyleKey TEXTCOLOR = createStyleKey("SPECIALIZATION_TEXTCOLOR", MetaKey.TEXTCOLOR);

    /**
     * Show stereotypes
     */
    @objid ("b35957d7-c2e0-4199-8d83-7f3318bbdba2")
    public static final StyleKey SHOWSTEREOTYPES = createStyleKey("SPECIALIZATION_SHOWSTEREOTYPES",
                    MetaKey.SHOWSTEREOTYPES);

    /**
     * Show tagged values
     */
    @objid ("8c30603e-6b4e-4ac4-8726-02132adf3425")
    public static final StyleKey SHOWTAGS = createStyleKey("SPECIALIZATION_SHOWTAGS", MetaKey.SHOWTAGS);

    /**
     * Connection routing mode.
     */
    @objid ("24708b36-7b49-4c84-9b3b-cf0f32e2edd8")
    public static final StyleKey CONNECTIONROUTER = createStyleKey("SPECIALIZATION_CONNECTIONROUTER",
                    MetaKey.CONNECTIONROUTER);

    /**
     * Line corners radius
     */
    @objid ("785bee88-2f21-4316-b886-e23b740718a4")
    public static final StyleKey LINERADIUS = createStyleKey("SPECIALIZATION_LINERADIUS", MetaKey.LINERADIUS);

    /**
     * Draw bridge where vertical segments cross horizontal ones.
     */
    @objid ("127fc660-d5b7-4da9-9b0e-b1e90d9eb02f")
    public static final StyleKey DRAWLINEBRIDGES = createStyleKey("SPECIALIZATION_DRAWLINEBRIDGES",
                    MetaKey.DRAWLINEBRIDGES);

    /**
     * Show name (alias)
     */
    @objid ("a237f1e8-d15d-48c1-a126-e678aa55415c")
    public static final StyleKey SHOWLABEL = createStyleKey("SPECIALIZATION_SHOWLABEL", MetaKey.SHOWLABEL);

    /**
     * Line pattern
     */
    @objid ("6d3a6f85-a813-41b7-b991-69112db559ee")
    public static final StyleKey LINEPATTERN = createStyleKey("SPECIALIZATION_LINEPATTERN", MetaKey.LINEPATTERN);

}

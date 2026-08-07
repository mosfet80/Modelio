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
package org.modelio.archimate.diagrams.elements.assignment;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * GmAssignment style keys for the standard structured mode.
 */
@objid ("cc5f30ec-1df0-4430-9a96-5aa4e9eb0497")
public class GmAssignmentLinkStyleKeys extends ArchimateAbstractStyleKeyProvider {
    /**
     * Line color
     */
    @objid ("d20514e4-5bb5-4206-98a6-407272842d22")
    public static final StyleKey LINECOLOR = createStyleKey("ASSIGNMENT_LINECOLOR", MetaKey.LINECOLOR);

    /**
     * Line width
     */
    @objid ("7b527a3f-ab71-42f8-891f-eaab587af2d8")
    public static final StyleKey LINEWIDTH = createStyleKey("ASSIGNMENT_LINEWIDTH", MetaKey.LINEWIDTH);

    /**
     * Text font
     */
    @objid ("1ee4fd03-194f-4fe1-be1b-2fedebfd0b0a")
    public static final StyleKey FONT = createStyleKey("ASSIGNMENT_FONT", MetaKey.FONT);

    /**
     * Text color
     */
    @objid ("f7bd7133-f42b-4f41-8d28-aa2084dd165a")
    public static final StyleKey TEXTCOLOR = createStyleKey("ASSIGNMENT_TEXTCOLOR", MetaKey.TEXTCOLOR);

    /**
     * Show stereotypes
     */
    @objid ("d82ea543-bae8-46fa-9449-ecd7eef48c17")
    public static final StyleKey SHOWSTEREOTYPES = createStyleKey("ASSIGNMENT_SHOWSTEREOTYPES",
                    MetaKey.SHOWSTEREOTYPES);

    /**
     * Show tagged values
     */
    @objid ("bbae938a-3c1a-4f40-a885-4ce3a82bba1d")
    public static final StyleKey SHOWTAGS = createStyleKey("ASSIGNMENT_SHOWTAGS", MetaKey.SHOWTAGS);

    /**
     * Connection routing mode.
     */
    @objid ("1c7d70a8-074c-46d0-9804-6a0eeb880719")
    public static final StyleKey CONNECTIONROUTER = createStyleKey("ASSIGNMENT_CONNECTIONROUTER",
                    MetaKey.CONNECTIONROUTER);

    /**
     * Line corners radius
     */
    @objid ("1eb3e7fa-b4a7-4009-a11f-693108d714e7")
    public static final StyleKey LINERADIUS = createStyleKey("ASSIGNMENT_LINERADIUS", MetaKey.LINERADIUS);

    /**
     * Draw bridge where vertical segments cross horizontal ones.
     */
    @objid ("7b59dbc9-1504-4b53-b960-c22527ab39b8")
    public static final StyleKey DRAWLINEBRIDGES = createStyleKey("ASSIGNMENT_DRAWLINEBRIDGES",
                    MetaKey.DRAWLINEBRIDGES);

    /**
     * Show name (alias)
     */
    @objid ("5d446f38-5539-4f15-93e3-0e10d8a3eae3")
    public static final StyleKey SHOWLABEL = createStyleKey("ASSIGNMENT_SHOWLABEL", MetaKey.SHOWLABEL);

    /**
     * Line pattern
     */
    @objid ("23616396-28e4-4254-b524-60e53f88fbc4")
    public static final StyleKey LINEPATTERN = createStyleKey("ASSIGNMENT_LINEPATTERN", MetaKey.LINEPATTERN);

}

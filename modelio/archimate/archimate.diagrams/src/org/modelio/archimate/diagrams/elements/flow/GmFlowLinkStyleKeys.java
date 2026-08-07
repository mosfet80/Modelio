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
package org.modelio.archimate.diagrams.elements.flow;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * GmFlow style keys for the standard structured mode.
 */
@objid ("24c271a5-30c5-49fa-b604-42c94e14bbe4")
public class GmFlowLinkStyleKeys extends ArchimateAbstractStyleKeyProvider {
    /**
     * Line color
     */
    @objid ("8cdaf38c-b5e6-4da1-b9f1-9073eed0aae6")
    public static final StyleKey LINECOLOR = createStyleKey("FLOW_LINECOLOR", MetaKey.LINECOLOR);

    /**
     * Line width
     */
    @objid ("b9c159d4-4453-4402-abc4-8df93859ee63")
    public static final StyleKey LINEWIDTH = createStyleKey("FLOW_LINEWIDTH", MetaKey.LINEWIDTH);

    /**
     * Text font
     */
    @objid ("eaabc08f-5787-4b32-af91-88055ea8c777")
    public static final StyleKey FONT = createStyleKey("FLOW_FONT", MetaKey.FONT);

    /**
     * Text color
     */
    @objid ("a56ba988-a2ef-4218-81a3-a57fe0a92b09")
    public static final StyleKey TEXTCOLOR = createStyleKey("FLOW_TEXTCOLOR", MetaKey.TEXTCOLOR);

    /**
     * Show stereotypes
     */
    @objid ("ba79f2f8-d98e-4f02-b3c6-471fa186471e")
    public static final StyleKey SHOWSTEREOTYPES = createStyleKey("FLOW_SHOWSTEREOTYPES",
                    MetaKey.SHOWSTEREOTYPES);

    /**
     * Show tagged values
     */
    @objid ("dfc6fa3a-6e13-4233-bf94-a11e1181b708")
    public static final StyleKey SHOWTAGS = createStyleKey("FLOW_SHOWTAGS", MetaKey.SHOWTAGS);

    /**
     * Connection routing mode.
     */
    @objid ("ea61ee5a-c0b2-4e2a-8c91-9061fe506110")
    public static final StyleKey CONNECTIONROUTER = createStyleKey("FLOW_CONNECTIONROUTER",
                    MetaKey.CONNECTIONROUTER);

    /**
     * Line corners radius
     */
    @objid ("d91e7407-4333-407a-b3c7-43fa17061eb1")
    public static final StyleKey LINERADIUS = createStyleKey("FLOW_LINERADIUS", MetaKey.LINERADIUS);

    /**
     * Draw bridge where vertical segments cross horizontal ones.
     */
    @objid ("1dc2d856-8ff6-48b5-9074-a302d2036b78")
    public static final StyleKey DRAWLINEBRIDGES = createStyleKey("FLOW_DRAWLINEBRIDGES",
                    MetaKey.DRAWLINEBRIDGES);

    /**
     * Show name (alias)
     */
    @objid ("95eaa0cd-db2d-4f7a-beb7-a33bc2ada741")
    public static final StyleKey SHOWLABEL = createStyleKey("FLOW_SHOWLABEL", MetaKey.SHOWLABEL);

    /**
     * Line pattern
     */
    @objid ("b7184606-718b-4e87-b70b-cc091692e9b7")
    public static final StyleKey LINEPATTERN = createStyleKey("FLOW_LINEPATTERN", MetaKey.LINEPATTERN);

}

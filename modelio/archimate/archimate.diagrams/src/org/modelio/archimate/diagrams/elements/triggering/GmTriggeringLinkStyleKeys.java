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
package org.modelio.archimate.diagrams.elements.triggering;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * GmTriggering style keys for the standard structured mode.
 */
@objid ("693d35e4-f0ec-474b-86e2-7ac8d09325e4")
public class GmTriggeringLinkStyleKeys extends ArchimateAbstractStyleKeyProvider {
    /**
     * Line color
     */
    @objid ("72d3ebaf-8f8e-4776-b64a-1e69a7d55e1a")
    public static final StyleKey LINECOLOR = createStyleKey("TRIGGERING_LINECOLOR", MetaKey.LINECOLOR);

    /**
     * Line width
     */
    @objid ("1a02582f-0040-4131-aeb0-b9a296c48f27")
    public static final StyleKey LINEWIDTH = createStyleKey("TRIGGERING_LINEWIDTH", MetaKey.LINEWIDTH);

    /**
     * Text font
     */
    @objid ("68f6f844-c426-4e0c-bd6f-e646996af2b8")
    public static final StyleKey FONT = createStyleKey("TRIGGERING_FONT", MetaKey.FONT);

    /**
     * Text color
     */
    @objid ("0eb41f74-4d7c-4020-9f80-91c3ff0c896c")
    public static final StyleKey TEXTCOLOR = createStyleKey("TRIGGERING_TEXTCOLOR", MetaKey.TEXTCOLOR);

    /**
     * Show stereotypes
     */
    @objid ("0f660348-1f7a-4652-9abd-f0e348452808")
    public static final StyleKey SHOWSTEREOTYPES = createStyleKey("TRIGGERING_SHOWSTEREOTYPES",
                    MetaKey.SHOWSTEREOTYPES);

    /**
     * Show tagged values
     */
    @objid ("43d7fef3-0fde-4654-bd1d-f45af24e1996")
    public static final StyleKey SHOWTAGS = createStyleKey("TRIGGERING_SHOWTAGS", MetaKey.SHOWTAGS);

    /**
     * Connection routing mode.
     */
    @objid ("c2b6488a-486c-4a36-9981-33fad53ad5c8")
    public static final StyleKey CONNECTIONROUTER = createStyleKey("TRIGGERING_CONNECTIONROUTER",
                    MetaKey.CONNECTIONROUTER);

    /**
     * Line corners radius
     */
    @objid ("05e606fc-1005-444a-9377-2d4fdc2eeced")
    public static final StyleKey LINERADIUS = createStyleKey("TRIGGERING_LINERADIUS", MetaKey.LINERADIUS);

    /**
     * Draw bridge where vertical segments cross horizontal ones.
     */
    @objid ("ed2e00ef-84e6-43da-aa1d-72aa373da0d9")
    public static final StyleKey DRAWLINEBRIDGES = createStyleKey("TRIGGERING_DRAWLINEBRIDGES",
                    MetaKey.DRAWLINEBRIDGES);

    /**
     * Show name (alias)
     */
    @objid ("d62e6875-e52e-4755-bf71-650185b8e3fb")
    public static final StyleKey SHOWLABEL = createStyleKey("TRIGGERING_SHOWLABEL", MetaKey.SHOWLABEL);

    /**
     * Line pattern
     */
    @objid ("2233e8ed-554d-4594-a067-97f9b66bd8d6")
    public static final StyleKey LINEPATTERN = createStyleKey("TRIGGERING_LINEPATTERN", MetaKey.LINEPATTERN);

}

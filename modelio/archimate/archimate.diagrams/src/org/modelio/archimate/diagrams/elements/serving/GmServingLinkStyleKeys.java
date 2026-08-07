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
package org.modelio.archimate.diagrams.elements.serving;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * GmServing style keys for the standard structured mode.
 */
@objid ("9fe38c06-3176-4b1b-8926-acfd19f01adb")
public class GmServingLinkStyleKeys extends ArchimateAbstractStyleKeyProvider {
    /**
     * Line color
     */
    @objid ("3e49dee8-38f3-4d9b-a480-e80f6a137a52")
    public static final StyleKey LINECOLOR = createStyleKey("SERVING_LINECOLOR", MetaKey.LINECOLOR);

    /**
     * Line width
     */
    @objid ("d57af429-1d27-4092-8649-9d1e30910928")
    public static final StyleKey LINEWIDTH = createStyleKey("SERVING_LINEWIDTH", MetaKey.LINEWIDTH);

    /**
     * Text font
     */
    @objid ("0ddbdaae-65ff-4707-a27c-82543fe4e333")
    public static final StyleKey FONT = createStyleKey("SERVING_FONT", MetaKey.FONT);

    /**
     * Text color
     */
    @objid ("f5c9a763-868e-43b8-9443-1164f524b849")
    public static final StyleKey TEXTCOLOR = createStyleKey("SERVING_TEXTCOLOR", MetaKey.TEXTCOLOR);

    /**
     * Show stereotypes
     */
    @objid ("3cb86d72-0306-40ff-896e-6ac0cb3437c6")
    public static final StyleKey SHOWSTEREOTYPES = createStyleKey("SERVING_SHOWSTEREOTYPES",
                    MetaKey.SHOWSTEREOTYPES);

    /**
     * Show tagged values
     */
    @objid ("5258f424-3816-4c6d-91f5-cf3007514c11")
    public static final StyleKey SHOWTAGS = createStyleKey("SERVING_SHOWTAGS", MetaKey.SHOWTAGS);

    /**
     * Connection routing mode.
     */
    @objid ("08176583-0294-4e6d-88f1-4e7058ee46f3")
    public static final StyleKey CONNECTIONROUTER = createStyleKey("SERVING_CONNECTIONROUTER",
                    MetaKey.CONNECTIONROUTER);

    /**
     * Line corners radius
     */
    @objid ("b1155787-9d8b-4128-9976-dd47adc8a888")
    public static final StyleKey LINERADIUS = createStyleKey("SERVING_LINERADIUS", MetaKey.LINERADIUS);

    /**
     * Draw bridge where vertical segments cross horizontal ones.
     */
    @objid ("f3194f8f-dd28-4de6-b080-3a37bdb5e63b")
    public static final StyleKey DRAWLINEBRIDGES = createStyleKey("SERVING_DRAWLINEBRIDGES",
                    MetaKey.DRAWLINEBRIDGES);

    /**
     * Show name (alias)
     */
    @objid ("6b4b129d-32c9-4d27-8b15-63eb0aafdf8f")
    public static final StyleKey SHOWLABEL = createStyleKey("SERVING_SHOWLABEL", MetaKey.SHOWLABEL);

    /**
     * Line pattern
     */
    @objid ("08aa5c30-c79d-41e5-84f9-eb18373f59c6")
    public static final StyleKey LINEPATTERN = createStyleKey("SERVING_LINEPATTERN", MetaKey.LINEPATTERN);

}

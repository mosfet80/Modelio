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
package org.modelio.archimate.diagrams.elements.access;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * GmAccess style keys for the standard structured mode.
 */
@objid ("2642ea5a-8d84-42b8-ad47-0576eaf86ecc")
public class GmAccessLinkStyleKeys extends ArchimateAbstractStyleKeyProvider {
    /**
     * Line color
     */
    @objid ("8223c576-b120-44ee-8148-76c83f6434ee")
    public static final StyleKey LINECOLOR = createStyleKey("ACCESS_LINECOLOR", MetaKey.LINECOLOR);

    /**
     * Line width
     */
    @objid ("a7028b0e-0b70-4deb-8885-b502cd79e529")
    public static final StyleKey LINEWIDTH = createStyleKey("ACCESS_LINEWIDTH", MetaKey.LINEWIDTH);

    /**
     * Text font
     */
    @objid ("09e9e739-2c48-4617-b7aa-f72b92c6eeb5")
    public static final StyleKey FONT = createStyleKey("ACCESS_FONT", MetaKey.FONT);

    /**
     * Text color
     */
    @objid ("89957530-0b41-4eb5-ad81-803aa249dafd")
    public static final StyleKey TEXTCOLOR = createStyleKey("ACCESS_TEXTCOLOR", MetaKey.TEXTCOLOR);

    /**
     * Show stereotypes
     */
    @objid ("4a73b13c-f16e-4c02-be12-c6033ad6953d")
    public static final StyleKey SHOWSTEREOTYPES = createStyleKey("ACCESS_SHOWSTEREOTYPES",
                    MetaKey.SHOWSTEREOTYPES);

    /**
     * Show tagged values
     */
    @objid ("a18c38c7-9d44-4ceb-9566-c6f86759b2e3")
    public static final StyleKey SHOWTAGS = createStyleKey("ACCESS_SHOWTAGS", MetaKey.SHOWTAGS);

    /**
     * Connection routing mode.
     */
    @objid ("d0c2506f-f0be-4023-be1c-90d242257485")
    public static final StyleKey CONNECTIONROUTER = createStyleKey("ACCESS_CONNECTIONROUTER",
                    MetaKey.CONNECTIONROUTER);

    /**
     * Line corners radius
     */
    @objid ("2784872d-740b-457b-afaa-3a245a067963")
    public static final StyleKey LINERADIUS = createStyleKey("ACCESS_LINERADIUS", MetaKey.LINERADIUS);

    /**
     * Draw bridge where vertical segments cross horizontal ones.
     */
    @objid ("e00faa82-0b3f-4197-b9da-84a2fd5f9c1a")
    public static final StyleKey DRAWLINEBRIDGES = createStyleKey("ACCESS_DRAWLINEBRIDGES",
                    MetaKey.DRAWLINEBRIDGES);

    /**
     * Show name (alias)
     */
    @objid ("5fd37717-5303-4845-9d92-ad5a513a56f1")
    public static final StyleKey SHOWLABEL = createStyleKey("ACCESS_SHOWLABEL", MetaKey.SHOWLABEL);

    /**
     * Line pattern
     */
    @objid ("40ae0996-66ec-44fe-a092-d0c726ff6840")
    public static final StyleKey LINEPATTERN = createStyleKey("ACCESS_LINEPATTERN", MetaKey.LINEPATTERN);

}

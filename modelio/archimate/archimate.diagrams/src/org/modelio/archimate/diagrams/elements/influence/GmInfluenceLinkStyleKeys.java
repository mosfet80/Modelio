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
package org.modelio.archimate.diagrams.elements.influence;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * GmInfluence style keys for the standard structured mode.
 */
@objid ("f289d134-8757-40da-b0a5-901e0ff593f0")
public class GmInfluenceLinkStyleKeys extends ArchimateAbstractStyleKeyProvider {
    /**
     * Line color
     */
    @objid ("4cf91e68-b70a-4d34-9d0d-f2956639c3a7")
    public static final StyleKey LINECOLOR = createStyleKey("INFLUENCE_LINECOLOR", MetaKey.LINECOLOR);

    /**
     * Line width
     */
    @objid ("b3cceda5-8afa-40ba-a635-4104ea4912c8")
    public static final StyleKey LINEWIDTH = createStyleKey("INFLUENCE_LINEWIDTH", MetaKey.LINEWIDTH);

    /**
     * Text font
     */
    @objid ("2336be50-f364-4358-ad90-4b34c681d893")
    public static final StyleKey FONT = createStyleKey("INFLUENCE_FONT", MetaKey.FONT);

    /**
     * Text color
     */
    @objid ("d865d093-c7b5-4910-8a44-9f7f1a91c9c5")
    public static final StyleKey TEXTCOLOR = createStyleKey("INFLUENCE_TEXTCOLOR", MetaKey.TEXTCOLOR);

    /**
     * Show stereotypes
     */
    @objid ("a9f407cd-8dd0-41b0-9e0d-af5379650532")
    public static final StyleKey SHOWSTEREOTYPES = createStyleKey("INFLUENCE_SHOWSTEREOTYPES",
                    MetaKey.SHOWSTEREOTYPES);

    /**
     * Show tagged values
     */
    @objid ("8c074fab-8226-4b22-9207-7359775fa827")
    public static final StyleKey SHOWTAGS = createStyleKey("INFLUENCE_SHOWTAGS", MetaKey.SHOWTAGS);

    /**
     * Connection routing mode.
     */
    @objid ("04857c88-3f81-4497-b643-5ec802e027b2")
    public static final StyleKey CONNECTIONROUTER = createStyleKey("INFLUENCE_CONNECTIONROUTER",
                    MetaKey.CONNECTIONROUTER);

    /**
     * Line corners radius
     */
    @objid ("b3fe62db-cbb9-40e0-99a6-e98e01e82eef")
    public static final StyleKey LINERADIUS = createStyleKey("INFLUENCE_LINERADIUS", MetaKey.LINERADIUS);

    /**
     * Draw bridge where vertical segments cross horizontal ones.
     */
    @objid ("1d34434d-a9c7-4e11-8fb7-c0524b79b53c")
    public static final StyleKey DRAWLINEBRIDGES = createStyleKey("INFLUENCE_DRAWLINEBRIDGES",
                    MetaKey.DRAWLINEBRIDGES);

    /**
     * Show name (alias)
     */
    @objid ("77ca1ed1-a4db-4a9a-8e48-9ef37a04b4fe")
    public static final StyleKey SHOWLABEL = createStyleKey("INFLUENCE_SHOWLABEL", MetaKey.SHOWLABEL);

    /**
     * Line pattern
     */
    @objid ("371e3baf-1361-4b32-ae6c-2b1042f596ca")
    public static final StyleKey LINEPATTERN = createStyleKey("INFLUENCE_LINEPATTERN", MetaKey.LINEPATTERN);

}

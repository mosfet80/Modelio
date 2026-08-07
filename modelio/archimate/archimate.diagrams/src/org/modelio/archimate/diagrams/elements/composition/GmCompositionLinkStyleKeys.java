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
package org.modelio.archimate.diagrams.elements.composition;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * GmComposition style keys for the standard structured mode.
 */
@objid ("67ce2b24-3f4f-4ebc-a560-f0059641a5ad")
public class GmCompositionLinkStyleKeys extends ArchimateAbstractStyleKeyProvider {
    /**
     * Line color
     */
    @objid ("b1b09d75-91ee-49c0-a44f-3ef63859d537")
    public static final StyleKey LINECOLOR = createStyleKey("COMPOSITION_LINECOLOR", MetaKey.LINECOLOR);

    /**
     * Line width
     */
    @objid ("6542c7fa-4f03-423a-83ec-27518f906a67")
    public static final StyleKey LINEWIDTH = createStyleKey("COMPOSITION_LINEWIDTH", MetaKey.LINEWIDTH);

    /**
     * Text font
     */
    @objid ("f33f6efe-8c9d-43bc-a508-67d1fdbc03ce")
    public static final StyleKey FONT = createStyleKey("COMPOSITION_FONT", MetaKey.FONT);

    /**
     * Text color
     */
    @objid ("a006ad2c-0aee-492a-ab23-b1306a967375")
    public static final StyleKey TEXTCOLOR = createStyleKey("COMPOSITION_TEXTCOLOR", MetaKey.TEXTCOLOR);

    /**
     * Show stereotypes
     */
    @objid ("4fa6e295-d235-46e5-9e71-fe1c06d7f4a2")
    public static final StyleKey SHOWSTEREOTYPES = createStyleKey("COMPOSITION_SHOWSTEREOTYPES",
                    MetaKey.SHOWSTEREOTYPES);

    /**
     * Show tagged values
     */
    @objid ("c3d327ec-5564-4b0c-93e7-78dca2a85ea4")
    public static final StyleKey SHOWTAGS = createStyleKey("COMPOSITION_SHOWTAGS", MetaKey.SHOWTAGS);

    /**
     * Connection routing mode.
     */
    @objid ("48516f05-4adf-42df-a448-d0e94f611d4e")
    public static final StyleKey CONNECTIONROUTER = createStyleKey("COMPOSITION_CONNECTIONROUTER",
                    MetaKey.CONNECTIONROUTER);

    /**
     * Line corners radius
     */
    @objid ("1188e65a-9ec9-4804-8840-18608812183e")
    public static final StyleKey LINERADIUS = createStyleKey("COMPOSITION_LINERADIUS", MetaKey.LINERADIUS);

    /**
     * Draw bridge where vertical segments cross horizontal ones.
     */
    @objid ("57cb7aef-2445-4a4c-8cc5-1e5320e39589")
    public static final StyleKey DRAWLINEBRIDGES = createStyleKey("COMPOSITION_DRAWLINEBRIDGES",
                    MetaKey.DRAWLINEBRIDGES);

    /**
     * Show name (alias)
     */
    @objid ("a066ed80-571b-429a-9940-189f1544e75d")
    public static final StyleKey SHOWLABEL = createStyleKey("COMPOSITION_SHOWLABEL", MetaKey.SHOWLABEL);

    /**
     * Line pattern
     */
    @objid ("e84a7d14-9124-4510-b38e-f1c59f6f4fdf")
    public static final StyleKey LINEPATTERN = createStyleKey("COMPOSITION_LINEPATTERN", MetaKey.LINEPATTERN);

}

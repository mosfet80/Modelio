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
package org.modelio.archimate.diagrams.elements.aggregation;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * GmAggregation style keys for the standard structured mode.
 */
@objid ("c08208ed-9ddc-491d-b477-4168782c9dcd")
public class GmAggregationLinkStyleKeys extends ArchimateAbstractStyleKeyProvider {
    /**
     * Fill color.
     */
    @objid ("d999f9f8-06e3-4b1e-a723-7122ea2dc5cb")
    public static final StyleKey FILLCOLOR = createStyleKey("AGGREGATION_FILLCOLOR", MetaKey.FILLCOLOR);

    /**
     * Line color
     */
    @objid ("c954ce8a-1762-4c58-8622-4182ba4048e0")
    public static final StyleKey LINECOLOR = createStyleKey("AGGREGATION_LINECOLOR", MetaKey.LINECOLOR);

    /**
     * Line width
     */
    @objid ("ca4b24aa-f66c-4058-896b-44c3ab29a81b")
    public static final StyleKey LINEWIDTH = createStyleKey("AGGREGATION_LINEWIDTH", MetaKey.LINEWIDTH);

    /**
     * Text font
     */
    @objid ("9f476e7f-6ccc-4709-9651-b205b0e07f55")
    public static final StyleKey FONT = createStyleKey("AGGREGATION_FONT", MetaKey.FONT);

    /**
     * Text color
     */
    @objid ("2b31e040-199e-42a5-9214-451b101744ef")
    public static final StyleKey TEXTCOLOR = createStyleKey("AGGREGATION_TEXTCOLOR", MetaKey.TEXTCOLOR);

    /**
     * Show stereotypes
     */
    @objid ("294bc6db-9167-4725-9461-256db93c8cc5")
    public static final StyleKey SHOWSTEREOTYPES = createStyleKey("AGGREGATION_SHOWSTEREOTYPES",
                    MetaKey.SHOWSTEREOTYPES);

    /**
     * Show tagged values
     */
    @objid ("90c657a2-6872-4ce6-8812-d088434539cd")
    public static final StyleKey SHOWTAGS = createStyleKey("AGGREGATION_SHOWTAGS", MetaKey.SHOWTAGS);

    /**
     * Connection routing mode.
     */
    @objid ("00467362-b399-4ba7-9b5e-2af1623521c8")
    public static final StyleKey CONNECTIONROUTER = createStyleKey("AGGREGATION_CONNECTIONROUTER",
                    MetaKey.CONNECTIONROUTER);

    /**
     * Line corners radius
     */
    @objid ("9c38cb21-a31c-4c57-bbe3-6c8ab8cc082d")
    public static final StyleKey LINERADIUS = createStyleKey("AGGREGATION_LINERADIUS", MetaKey.LINERADIUS);

    /**
     * Draw bridge where vertical segments cross horizontal ones.
     */
    @objid ("f5d73154-3ef1-4ba1-9d8a-a079f8cbfc0f")
    public static final StyleKey DRAWLINEBRIDGES = createStyleKey("AGGREGATION_DRAWLINEBRIDGES",
                    MetaKey.DRAWLINEBRIDGES);

    /**
     * Show name (alias)
     */
    @objid ("92027009-d55c-423b-b504-a92c6ee6dbb5")
    public static final StyleKey SHOWLABEL = createStyleKey("AGGREGATION_SHOWLABEL", MetaKey.SHOWLABEL);

    /**
     * Line pattern
     */
    @objid ("89c0db11-ee2b-41d8-a2f6-6d4ef0f6741b")
    public static final StyleKey LINEPATTERN = createStyleKey("AGGREGATION_LINEPATTERN", MetaKey.LINEPATTERN);

}

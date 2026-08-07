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
package org.modelio.archimate.diagrams.elements.realization;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * GmRealization style keys for the standard structured mode.
 */
@objid ("8a9dd5f3-c457-47d9-98c4-0c3da382ad0d")
public class GmRealizationLinkStyleKeys extends ArchimateAbstractStyleKeyProvider {
    /**
     * Fill color.
     */
    @objid ("ee8deb63-3f7a-4c18-b276-870aece90acd")
    public static final StyleKey FILLCOLOR = createStyleKey("REALIZATION_FILLCOLOR", MetaKey.FILLCOLOR);

    /**
     * Line color
     */
    @objid ("38640043-d803-4649-8048-f9d91b4fb9ed")
    public static final StyleKey LINECOLOR = createStyleKey("REALIZATION_LINECOLOR", MetaKey.LINECOLOR);

    /**
     * Line width
     */
    @objid ("5a29273a-429d-4cdf-b824-a0a5ab887dbf")
    public static final StyleKey LINEWIDTH = createStyleKey("REALIZATION_LINEWIDTH", MetaKey.LINEWIDTH);

    /**
     * Text font
     */
    @objid ("e30a9049-4354-416a-81b4-d6ee77516cec")
    public static final StyleKey FONT = createStyleKey("REALIZATION_FONT", MetaKey.FONT);

    /**
     * Text color
     */
    @objid ("6c4bf9cb-f8af-46ea-9e71-3edafd50248a")
    public static final StyleKey TEXTCOLOR = createStyleKey("REALIZATION_TEXTCOLOR", MetaKey.TEXTCOLOR);

    /**
     * Show stereotypes
     */
    @objid ("1065b88c-781e-4a60-9191-d7461ca1c6da")
    public static final StyleKey SHOWSTEREOTYPES = createStyleKey("REALIZATION_SHOWSTEREOTYPES",
                    MetaKey.SHOWSTEREOTYPES);

    /**
     * Show tagged values
     */
    @objid ("a1922503-cf48-4b33-ac4e-a3b4e24aec6e")
    public static final StyleKey SHOWTAGS = createStyleKey("REALIZATION_SHOWTAGS", MetaKey.SHOWTAGS);

    /**
     * Connection routing mode.
     */
    @objid ("59742ced-6c5e-4d3b-8f1b-7fbea8504bbe")
    public static final StyleKey CONNECTIONROUTER = createStyleKey("REALIZATION_CONNECTIONROUTER",
                    MetaKey.CONNECTIONROUTER);

    /**
     * Line corners radius
     */
    @objid ("6d0f769d-ae7d-4e3b-a094-d62a98ba7579")
    public static final StyleKey LINERADIUS = createStyleKey("REALIZATION_LINERADIUS", MetaKey.LINERADIUS);

    /**
     * Draw bridge where vertical segments cross horizontal ones.
     */
    @objid ("7e97a6a8-38eb-42d5-9db5-8dcbc4bfe45e")
    public static final StyleKey DRAWLINEBRIDGES = createStyleKey("REALIZATION_DRAWLINEBRIDGES",
                    MetaKey.DRAWLINEBRIDGES);

    /**
     * Show name (alias)
     */
    @objid ("2af97b8c-096e-4217-b147-7b87af89851a")
    public static final StyleKey SHOWLABEL = createStyleKey("REALIZATION_SHOWLABEL", MetaKey.SHOWLABEL);

    /**
     * Line pattern
     */
    @objid ("3a44b3c8-7372-4a82-9ba9-a03f7e0124e0")
    public static final StyleKey LINEPATTERN = createStyleKey("REALIZATION_LINEPATTERN", MetaKey.LINEPATTERN);

}

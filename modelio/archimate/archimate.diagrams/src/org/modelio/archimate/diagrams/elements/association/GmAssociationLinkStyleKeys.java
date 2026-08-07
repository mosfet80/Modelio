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
package org.modelio.archimate.diagrams.elements.association;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * GmAssociation style keys for the standard structured mode.
 */
@objid ("d6f3325f-25d5-4e0e-af6a-9db6acac0a29")
public class GmAssociationLinkStyleKeys extends ArchimateAbstractStyleKeyProvider {
    /**
     * Line color
     */
    @objid ("ce106bbf-5ad8-4261-bfaa-647315d46274")
    public static final StyleKey LINECOLOR = createStyleKey("ARCHIMATE_ASSOCIATION_LINECOLOR", MetaKey.LINECOLOR);

    /**
     * Line width
     */
    @objid ("fc500adb-1f2b-4b4e-a268-30e0b69bd785")
    public static final StyleKey LINEWIDTH = createStyleKey("ARCHIMATE_ASSOCIATION_LINEWIDTH", MetaKey.LINEWIDTH);

    /**
     * Text font
     */
    @objid ("0a5a57b4-e25b-49da-9287-be04be3222f3")
    public static final StyleKey FONT = createStyleKey("ARCHIMATE_ASSOCIATION_FONT", MetaKey.FONT);

    /**
     * Text color
     */
    @objid ("d74684fd-5a4d-4341-98ef-882fb183d89a")
    public static final StyleKey TEXTCOLOR = createStyleKey("ARCHIMATE_ASSOCIATION_TEXTCOLOR", MetaKey.TEXTCOLOR);

    /**
     * Show stereotypes
     */
    @objid ("10e475ec-7333-43b8-b3bf-afc95cf5a014")
    public static final StyleKey SHOWSTEREOTYPES = createStyleKey("ARCHIMATE_ASSOCIATION_SHOWSTEREOTYPES",
                    MetaKey.SHOWSTEREOTYPES);

    /**
     * Show tagged values
     */
    @objid ("14f361e7-2dfe-44f3-8825-80779bba1886")
    public static final StyleKey SHOWTAGS = createStyleKey("ARCHIMATE_ASSOCIATION_SHOWTAGS", MetaKey.SHOWTAGS);

    /**
     * Connection routing mode.
     */
    @objid ("56f9958c-1ef1-4783-af68-76a080a10f24")
    public static final StyleKey CONNECTIONROUTER = createStyleKey("ARCHIMATE_ASSOCIATION_CONNECTIONROUTER",
                    MetaKey.CONNECTIONROUTER);

    /**
     * Line corners radius
     */
    @objid ("46c805b2-c05a-4f81-8db5-828b0b587e63")
    public static final StyleKey LINERADIUS = createStyleKey("ARCHIMATE_ASSOCIATION_LINERADIUS", MetaKey.LINERADIUS);

    /**
     * Draw bridge where vertical segments cross horizontal ones.
     */
    @objid ("9b6e168f-956c-4b73-90f1-b1bb772f3022")
    public static final StyleKey DRAWLINEBRIDGES = createStyleKey("ARCHIMATE_ASSOCIATION_DRAWLINEBRIDGES",
                    MetaKey.DRAWLINEBRIDGES);

    /**
     * Show name (alias)
     */
    @objid ("094df03b-47a5-47fc-8fdb-ece08efab438")
    public static final StyleKey SHOWLABEL = createStyleKey("ARCHIMATE_ASSOCIATION_SHOWLABEL", MetaKey.SHOWLABEL);

    /**
     * Line pattern
     */
    @objid ("b0ba763e-2954-4dfd-a885-92fe24427a3d")
    public static final StyleKey LINEPATTERN = createStyleKey("ARCHIMATE_ASSOCIATION_LINEPATTERN", MetaKey.LINEPATTERN);

}

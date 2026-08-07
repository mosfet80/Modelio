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
package org.modelio.archimate.diagrams.elements.principle;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;
import org.modelio.diagram.styles.core.StyleKey.RepresentationMode;

/**
 * This class provides the StyleKey constants for a GmPrinciple when its representation mode is {@link RepresentationMode#STRUCTURED}.
 */
@objid ("ccf415a0-e09d-49a4-9601-b66817aac350")
public class GmPrincipleStructuredStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("a39c48bb-b867-4f57-b130-bfeb45322fe6")
    static final StyleKey REPMODE = createStyleKey("PRINCIPLE_REPMODE", MetaKey.REPMODE);

    @objid ("4eb17526-2c05-4e3e-b4cc-d99fe6eb916f")
    static final StyleKey FILLCOLOR = createStyleKey("PRINCIPLE_FILLCOLOR", MetaKey.FILLCOLOR);

    @objid ("54ca3df7-786f-4fb3-a989-bed09cc93d94")
    static final StyleKey FILLMODE = createStyleKey("PRINCIPLE_FILLMODE", MetaKey.FILLMODE);

    @objid ("56d5f2a4-6c9f-4a3e-aa72-4beba5891a6e")
    static final StyleKey LINECOLOR = createStyleKey("PRINCIPLE_LINECOLOR", MetaKey.LINECOLOR);

    @objid ("a7fd1608-3ccb-4610-94f8-551a2edb07f0")
    static final StyleKey LINEWIDTH = createStyleKey("PRINCIPLE_LINEWIDTH", MetaKey.LINEWIDTH);

    @objid ("2bdde16e-3a70-4a2c-99df-a72446b4c8ec")
    static final StyleKey FONT = createStyleKey("PRINCIPLE_FONT", MetaKey.FONT);

    @objid ("00e436ae-3c4d-407f-9291-aca966938ed1")
    static final StyleKey TEXTCOLOR = createStyleKey("PRINCIPLE_TEXTCOLOR", MetaKey.TEXTCOLOR);

    @objid ("bd0ea069-d99e-42d0-bf13-6367e56b1ba3")
    static final StyleKey SHOWSTEREOTYPES = createStyleKey("PRINCIPLE_SHOWSTEREOTYPES", MetaKey.SHOWSTEREOTYPES);

    @objid ("6d8ee54f-2f67-409f-b5d4-cecd208d8617")
    static final StyleKey SHOWTAGS = createStyleKey("PRINCIPLE_SHOWTAGS", MetaKey.SHOWTAGS);

}

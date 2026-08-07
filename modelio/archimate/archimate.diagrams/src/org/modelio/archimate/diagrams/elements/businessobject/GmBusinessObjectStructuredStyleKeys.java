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
package org.modelio.archimate.diagrams.elements.businessobject;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmBusinessObject when its representation mode is RepresentationMode.STRUCTURED
 */
@objid ("bd79fda2-8f7d-4c85-9048-eee2f817d91b")
public class GmBusinessObjectStructuredStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("8834ad27-9ecf-4e37-abfd-6ea434cd497f")
    static final StyleKey REPMODE = createStyleKey("BUSINESSOBJECT_REPMODE", MetaKey.REPMODE);

    @objid ("e611c11c-7417-4ef9-8aaf-eb403a5737bc")
    static final StyleKey FILLCOLOR = createStyleKey("BUSINESSOBJECT_FILLCOLOR", MetaKey.FILLCOLOR);

    @objid ("c253fb4d-aba4-4a72-856e-24cc0ff80100")
    static final StyleKey FILLMODE = createStyleKey("BUSINESSOBJECT_FILLMODE", MetaKey.FILLMODE);

    @objid ("f8a12780-0c5e-4d14-bba3-701099c94b9a")
    static final StyleKey LINECOLOR = createStyleKey("BUSINESSOBJECT_LINECOLOR", MetaKey.LINECOLOR);

    @objid ("4c536390-3158-482d-8109-aba1fab7f1cd")
    static final StyleKey LINEWIDTH = createStyleKey("BUSINESSOBJECT_LINEWIDTH", MetaKey.LINEWIDTH);

    @objid ("86adfd8a-4755-432c-b948-c946146fb75f")
    static final StyleKey FONT = createStyleKey("BUSINESSOBJECT_FONT", MetaKey.FONT);

    @objid ("6e2e9cc9-1a2e-4220-ac61-70a337158a90")
    static final StyleKey TEXTCOLOR = createStyleKey("BUSINESSOBJECT_TEXTCOLOR", MetaKey.TEXTCOLOR);

    @objid ("d02268b1-fb73-430f-865b-617b0bb897b5")
    static final StyleKey SHOWSTEREOTYPES = createStyleKey("BUSINESSOBJECT_SHOWSTEREOTYPES", MetaKey.SHOWSTEREOTYPES);

    @objid ("fb9eb515-82e5-498d-8494-d637b447d249")
    static final StyleKey SHOWTAGS = createStyleKey("BUSINESSOBJECT_SHOWTAGS", MetaKey.SHOWTAGS);

}

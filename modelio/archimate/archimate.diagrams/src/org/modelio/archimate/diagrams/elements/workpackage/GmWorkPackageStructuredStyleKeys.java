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
package org.modelio.archimate.diagrams.elements.workpackage;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmWorkPackage when its representation mode is RepresentationMode.STRUCTURED
 */
@objid ("1c9ed3d3-7523-40e3-b48e-2c961f0a0252")
public class GmWorkPackageStructuredStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("c06b4c82-aa27-464d-96ad-ba1884136853")
    static final StyleKey REPMODE = createStyleKey("WORKPACKAGE_REPMODE", MetaKey.REPMODE);

    @objid ("cdf2bc04-ff1a-4c6c-8f63-872b0a91e3ca")
    static final StyleKey FILLCOLOR = createStyleKey("WORKPACKAGE_FILLCOLOR", MetaKey.FILLCOLOR);

    @objid ("73651f2a-8f51-477b-adc4-84f5886f5ecc")
    static final StyleKey FILLMODE = createStyleKey("WORKPACKAGE_FILLMODE", MetaKey.FILLMODE);

    @objid ("16f0e762-d227-45a4-820c-1691e8588d05")
    static final StyleKey LINECOLOR = createStyleKey("WORKPACKAGE_LINECOLOR", MetaKey.LINECOLOR);

    @objid ("fc414cba-5efe-478f-b72a-02c252cda644")
    static final StyleKey LINEWIDTH = createStyleKey("WORKPACKAGE_LINEWIDTH", MetaKey.LINEWIDTH);

    @objid ("6213e14b-588f-4df8-9972-00d5f642f4f8")
    static final StyleKey FONT = createStyleKey("WORKPACKAGE_FONT", MetaKey.FONT);

    @objid ("1cf90317-4df2-48aa-ac4f-f85987e31603")
    static final StyleKey TEXTCOLOR = createStyleKey("WORKPACKAGE_TEXTCOLOR", MetaKey.TEXTCOLOR);

    @objid ("2a2876a4-c699-4382-babf-06292fceee49")
    static final StyleKey SHOWSTEREOTYPES = createStyleKey("WORKPACKAGE_SHOWSTEREOTYPES", MetaKey.SHOWSTEREOTYPES);

    @objid ("3b2a25c3-fc42-4b7c-9ab0-fe2929a72054")
    static final StyleKey SHOWTAGS = createStyleKey("WORKPACKAGE_SHOWTAGS", MetaKey.SHOWTAGS);

}

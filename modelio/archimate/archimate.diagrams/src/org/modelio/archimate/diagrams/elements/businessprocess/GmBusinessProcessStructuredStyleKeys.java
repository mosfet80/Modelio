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
package org.modelio.archimate.diagrams.elements.businessprocess;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmBusinessProcess when its representation mode is RepresentationMode.STRUCTURED
 */
@objid ("add5a8cf-0406-4311-8b88-1cfc319db26d")
public class GmBusinessProcessStructuredStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("f1806a89-62a3-4382-b2f3-0096e8bc8629")
    static final StyleKey REPMODE = createStyleKey("BUSINESSPROCESS_REPMODE", MetaKey.REPMODE);

    @objid ("dd9049cd-aeda-4d48-a5d5-16c3b7c8d37e")
    static final StyleKey FILLCOLOR = createStyleKey("BUSINESSPROCESS_FILLCOLOR", MetaKey.FILLCOLOR);

    @objid ("c7ad3922-4a6a-48ef-a950-b1d477a83762")
    static final StyleKey FILLMODE = createStyleKey("BUSINESSPROCESS_FILLMODE", MetaKey.FILLMODE);

    @objid ("36a3e992-b59c-472d-90cd-6fd19926287b")
    static final StyleKey LINECOLOR = createStyleKey("BUSINESSPROCESS_LINECOLOR", MetaKey.LINECOLOR);

    @objid ("380f5f02-deb1-4576-beef-0804b2b64bad")
    static final StyleKey LINEWIDTH = createStyleKey("BUSINESSPROCESS_LINEWIDTH", MetaKey.LINEWIDTH);

    @objid ("a84edaac-97da-40bb-baf0-c0a42427394a")
    static final StyleKey FONT = createStyleKey("BUSINESSPROCESS_FONT", MetaKey.FONT);

    @objid ("76b05165-bafc-4d70-8f3e-f74b74cf6867")
    static final StyleKey TEXTCOLOR = createStyleKey("BUSINESSPROCESS_TEXTCOLOR", MetaKey.TEXTCOLOR);

    @objid ("0af95d3c-d0bb-4f63-b61b-42eaff71c1bb")
    static final StyleKey SHOWSTEREOTYPES = createStyleKey("BUSINESSPROCESS_SHOWSTEREOTYPES", MetaKey.SHOWSTEREOTYPES);

    @objid ("94977080-c2e1-490d-9e04-b1c7fe3899b8")
    static final StyleKey SHOWTAGS = createStyleKey("BUSINESSPROCESS_SHOWTAGS", MetaKey.SHOWTAGS);

}

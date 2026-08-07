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
package org.modelio.archimate.diagrams.elements.applicationprocess;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmApplicationProcess when its representation mode is RepresentationMode.STRUCTURED
 */
@objid ("7bb09d42-67a9-408f-8491-7f36f2d29de0")
public class GmApplicationProcessStructuredStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("0fdb1c77-c385-40bf-9f84-4ca21231d340")
    static final StyleKey REPMODE = createStyleKey("APPLICATIONPROCESS_REPMODE", MetaKey.REPMODE);

    @objid ("95df1066-a186-428f-9762-c566c75aec7f")
    static final StyleKey FILLCOLOR = createStyleKey("APPLICATIONPROCESS_FILLCOLOR", MetaKey.FILLCOLOR);

    @objid ("76d53709-8c20-4555-b128-d9721eaeacd5")
    static final StyleKey FILLMODE = createStyleKey("APPLICATIONPROCESS_FILLMODE", MetaKey.FILLMODE);

    @objid ("461d981b-5ea2-47d8-8f16-ddda77a095ab")
    static final StyleKey LINECOLOR = createStyleKey("APPLICATIONPROCESS_LINECOLOR", MetaKey.LINECOLOR);

    @objid ("63de7925-2015-45ff-a9f9-a75a65aa42fe")
    static final StyleKey LINEWIDTH = createStyleKey("APPLICATIONPROCESS_LINEWIDTH", MetaKey.LINEWIDTH);

    @objid ("bbb55c3a-9211-49d4-86d9-a933f8ff48d8")
    static final StyleKey FONT = createStyleKey("APPLICATIONPROCESS_FONT", MetaKey.FONT);

    @objid ("ff007f11-256e-4173-81dc-011a8f90c396")
    static final StyleKey TEXTCOLOR = createStyleKey("APPLICATIONPROCESS_TEXTCOLOR", MetaKey.TEXTCOLOR);

    @objid ("cab98313-c30e-41d0-be76-a47872765eb6")
    static final StyleKey SHOWSTEREOTYPES = createStyleKey("APPLICATIONPROCESS_SHOWSTEREOTYPES", MetaKey.SHOWSTEREOTYPES);

    @objid ("b0700f3a-db41-454d-870b-d722917c8124")
    static final StyleKey SHOWTAGS = createStyleKey("APPLICATIONPROCESS_SHOWTAGS", MetaKey.SHOWTAGS);

}

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
package org.modelio.archimate.diagrams.elements.grouping;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmGrouping when its representation mode is RepresentationMode.STRUCTURED
 */
@objid ("4d8e38e5-39ef-4377-ad02-ac49cb761324")
public class GmGroupingStructuredStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("8eeb27c7-a2ee-466a-b9cd-212caf1f0cee")
    static final StyleKey REPMODE = createStyleKey("GROUPING_REPMODE", MetaKey.REPMODE);

    @objid ("f91562a3-672e-44c6-95dc-fae66ca0414a")
    static final StyleKey FILLCOLOR = createStyleKey("GROUPING_FILLCOLOR", MetaKey.FILLCOLOR);

    @objid ("ae9e3899-6700-4bd1-a2c9-7b9f7fc8486e")
    static final StyleKey FILLMODE = createStyleKey("GROUPING_FILLMODE", MetaKey.FILLMODE);

    @objid ("26adc5c9-54a4-42ab-8eed-74d68ec8bd76")
    static final StyleKey LINECOLOR = createStyleKey("GROUPING_LINECOLOR", MetaKey.LINECOLOR);

    @objid ("9d0b154a-a5ab-4a3a-b61a-354a138c7b01")
    static final StyleKey LINEWIDTH = createStyleKey("GROUPING_LINEWIDTH", MetaKey.LINEWIDTH);

    @objid ("a1d0212a-de19-4c60-b6e6-21794cc276f9")
    static final StyleKey FONT = createStyleKey("GROUPING_FONT", MetaKey.FONT);

    @objid ("db56a4c5-7c61-4c74-a367-2e1575072fb5")
    static final StyleKey TEXTCOLOR = createStyleKey("GROUPING_TEXTCOLOR", MetaKey.TEXTCOLOR);

    @objid ("7a5d0b7d-1316-4cc8-a875-c4e08d241555")
    static final StyleKey SHOWSTEREOTYPES = createStyleKey("GROUPING_SHOWSTEREOTYPES", MetaKey.SHOWSTEREOTYPES);

    @objid ("c66323d8-77b1-4177-a51c-e3072e9e306f")
    static final StyleKey SHOWTAGS = createStyleKey("GROUPING_SHOWTAGS", MetaKey.SHOWTAGS);

}

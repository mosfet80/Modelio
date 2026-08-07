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
package org.modelio.archimate.diagrams.elements.gap;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmGap when its representation mode is RepresentationMode.STRUCTURED
 */
@objid ("6929c2db-613b-47de-ace2-85e44b94ad38")
public class GmGapStructuredStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("3ab8094b-7120-4bb8-a1b9-589cd7caea25")
    static final StyleKey REPMODE = createStyleKey("GAP_REPMODE", MetaKey.REPMODE);

    @objid ("b8d8d631-0f95-454b-b683-8719928c5a79")
    static final StyleKey FILLCOLOR = createStyleKey("GAP_FILLCOLOR", MetaKey.FILLCOLOR);

    @objid ("49679557-825e-4ba7-9138-381f079da14a")
    static final StyleKey FILLMODE = createStyleKey("GAP_FILLMODE", MetaKey.FILLMODE);

    @objid ("db1b996f-1264-4ac9-9467-5c645d88093a")
    static final StyleKey LINECOLOR = createStyleKey("GAP_LINECOLOR", MetaKey.LINECOLOR);

    @objid ("69807c2c-8ebd-4257-9da2-a491065cc747")
    static final StyleKey LINEWIDTH = createStyleKey("GAP_LINEWIDTH", MetaKey.LINEWIDTH);

    @objid ("481ea1c4-0845-4b9e-9ccb-b8aa33554a04")
    static final StyleKey FONT = createStyleKey("GAP_FONT", MetaKey.FONT);

    @objid ("d0e30ea2-668a-4679-8c4c-ffbd4fd7b644")
    static final StyleKey TEXTCOLOR = createStyleKey("GAP_TEXTCOLOR", MetaKey.TEXTCOLOR);

    @objid ("73aad558-25bb-42f1-bce8-3c78ec1a0915")
    static final StyleKey SHOWSTEREOTYPES = createStyleKey("GAP_SHOWSTEREOTYPES", MetaKey.SHOWSTEREOTYPES);

    @objid ("197a3cdc-d97b-46cd-8886-702e99cb4358")
    static final StyleKey SHOWTAGS = createStyleKey("GAP_SHOWTAGS", MetaKey.SHOWTAGS);

}

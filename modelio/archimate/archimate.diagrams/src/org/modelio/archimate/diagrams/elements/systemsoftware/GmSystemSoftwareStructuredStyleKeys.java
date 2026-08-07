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
package org.modelio.archimate.diagrams.elements.systemsoftware;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmSystemSoftware when its representation mode is RepresentationMode.STRUCTURED
 */
@objid ("957a1f5a-bb51-4f6f-8539-4200bdfede67")
public class GmSystemSoftwareStructuredStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("bc4621da-2f69-4e6e-b7f4-758859106e96")
    static final StyleKey REPMODE = createStyleKey("SYSTEMSOFTWARE_REPMODE", MetaKey.REPMODE);

    @objid ("7f625559-ef75-4db1-af71-eb864b56c61c")
    static final StyleKey FILLCOLOR = createStyleKey("SYSTEMSOFTWARE_FILLCOLOR", MetaKey.FILLCOLOR);

    @objid ("deedde18-a067-44c7-ab69-d36b5608b0b5")
    static final StyleKey FILLMODE = createStyleKey("SYSTEMSOFTWARE_FILLMODE", MetaKey.FILLMODE);

    @objid ("e55d7630-94d0-488e-a678-d08332a8cdd3")
    static final StyleKey LINECOLOR = createStyleKey("SYSTEMSOFTWARE_LINECOLOR", MetaKey.LINECOLOR);

    @objid ("704186a4-6ac0-42c4-bf5f-04f21df65b1d")
    static final StyleKey LINEWIDTH = createStyleKey("SYSTEMSOFTWARE_LINEWIDTH", MetaKey.LINEWIDTH);

    @objid ("59c1810c-9ee7-434e-ab32-6591762fc1e6")
    static final StyleKey FONT = createStyleKey("SYSTEMSOFTWARE_FONT", MetaKey.FONT);

    @objid ("a7452a4f-72fb-4bf6-b415-e62bb2418dd4")
    static final StyleKey TEXTCOLOR = createStyleKey("SYSTEMSOFTWARE_TEXTCOLOR", MetaKey.TEXTCOLOR);

    @objid ("d750db15-d429-4b6e-b7f3-deae73108675")
    static final StyleKey SHOWSTEREOTYPES = createStyleKey("SYSTEMSOFTWARE_SHOWSTEREOTYPES", MetaKey.SHOWSTEREOTYPES);

    @objid ("832f7895-6263-429c-943d-58f058bbc639")
    static final StyleKey SHOWTAGS = createStyleKey("SYSTEMSOFTWARE_SHOWTAGS", MetaKey.SHOWTAGS);

}

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
package org.modelio.archimate.diagrams.elements.product;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmProduct when its representation mode is RepresentationMode.STRUCTURED
 */
@objid ("49dfdf14-2a46-490e-9769-9cf117ba1425")
public class GmProductStructuredStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("a60eee4e-c5f0-4c26-afa9-9635eb2b22ed")
    static final StyleKey REPMODE = createStyleKey("PRODUCT_REPMODE", MetaKey.REPMODE);

    @objid ("0ced2a76-d013-4500-872d-a16484249401")
    static final StyleKey FILLCOLOR = createStyleKey("PRODUCT_FILLCOLOR", MetaKey.FILLCOLOR);

    @objid ("05c3b39a-4d45-419a-80eb-2731b8e5756a")
    static final StyleKey FILLMODE = createStyleKey("PRODUCT_FILLMODE", MetaKey.FILLMODE);

    @objid ("825415ca-4360-4b7e-8dfd-a3479fdca169")
    static final StyleKey LINECOLOR = createStyleKey("PRODUCT_LINECOLOR", MetaKey.LINECOLOR);

    @objid ("b2884399-266b-4893-8a00-ad295170da7b")
    static final StyleKey LINEWIDTH = createStyleKey("PRODUCT_LINEWIDTH", MetaKey.LINEWIDTH);

    @objid ("e57bb3ab-f550-4461-8384-b48288b1db27")
    static final StyleKey FONT = createStyleKey("PRODUCT_FONT", MetaKey.FONT);

    @objid ("339ce924-e081-4857-aca4-f056fb1cd709")
    static final StyleKey TEXTCOLOR = createStyleKey("PRODUCT_TEXTCOLOR", MetaKey.TEXTCOLOR);

    @objid ("734dc4a7-8fa0-4492-ba53-817b3dcefad3")
    static final StyleKey SHOWSTEREOTYPES = createStyleKey("PRODUCT_SHOWSTEREOTYPES", MetaKey.SHOWSTEREOTYPES);

    @objid ("e555630c-3dc0-461c-b9f3-7384c27cd037")
    static final StyleKey SHOWTAGS = createStyleKey("PRODUCT_SHOWTAGS", MetaKey.SHOWTAGS);

}

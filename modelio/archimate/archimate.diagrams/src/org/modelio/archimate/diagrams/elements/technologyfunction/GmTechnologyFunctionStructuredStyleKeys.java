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
package org.modelio.archimate.diagrams.elements.technologyfunction;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmTechnologyFunction when its representation mode is RepresentationMode.STRUCTURED
 */
@objid ("e2512395-c51c-43ab-b360-6fe08d12798c")
public class GmTechnologyFunctionStructuredStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("4d4ec988-7e7b-41cf-b273-8519d92f40f4")
    static final StyleKey REPMODE = createStyleKey("TECHNOLOGYFUNCTION_REPMODE", MetaKey.REPMODE);

    @objid ("45719cfa-e943-45c9-a565-e96723230d85")
    static final StyleKey FILLCOLOR = createStyleKey("TECHNOLOGYFUNCTION_FILLCOLOR", MetaKey.FILLCOLOR);

    @objid ("bbf45230-2f7f-4ca0-adf5-b8200d2e7690")
    static final StyleKey FILLMODE = createStyleKey("TECHNOLOGYFUNCTION_FILLMODE", MetaKey.FILLMODE);

    @objid ("910bedc2-d078-4ca6-8c03-8743eefd2a95")
    static final StyleKey LINECOLOR = createStyleKey("TECHNOLOGYFUNCTION_LINECOLOR", MetaKey.LINECOLOR);

    @objid ("31f94ab9-bc92-4f43-b929-b65face1f521")
    static final StyleKey LINEWIDTH = createStyleKey("TECHNOLOGYFUNCTION_LINEWIDTH", MetaKey.LINEWIDTH);

    @objid ("ffdd0e74-e57a-4d52-b6da-b66528b1da01")
    static final StyleKey FONT = createStyleKey("TECHNOLOGYFUNCTION_FONT", MetaKey.FONT);

    @objid ("c5a06859-c412-41bd-b6bb-c1e0a618a995")
    static final StyleKey TEXTCOLOR = createStyleKey("TECHNOLOGYFUNCTION_TEXTCOLOR", MetaKey.TEXTCOLOR);

    @objid ("09f6be9f-2927-4509-ab40-202a0a249d78")
    static final StyleKey SHOWSTEREOTYPES = createStyleKey("TECHNOLOGYFUNCTION_SHOWSTEREOTYPES", MetaKey.SHOWSTEREOTYPES);

    @objid ("fce0a7b9-d39c-4696-94be-0466c2df7422")
    static final StyleKey SHOWTAGS = createStyleKey("TECHNOLOGYFUNCTION_SHOWTAGS", MetaKey.SHOWTAGS);

}

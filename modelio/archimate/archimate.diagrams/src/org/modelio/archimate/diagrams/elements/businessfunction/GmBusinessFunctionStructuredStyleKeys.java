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
package org.modelio.archimate.diagrams.elements.businessfunction;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmBusinessFunction when its representation mode is RepresentationMode.STRUCTURED
 */
@objid ("72ba3c6a-a6f4-4912-b63d-988aedad371f")
public class GmBusinessFunctionStructuredStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("abda9981-d9bc-4430-8180-b41d7706551e")
    static final StyleKey REPMODE = createStyleKey("BUSINESSFUNCTION_REPMODE", MetaKey.REPMODE);

    @objid ("5bd3b8d0-f7c7-44df-86d1-9cd470f2c3a7")
    static final StyleKey FILLCOLOR = createStyleKey("BUSINESSFUNCTION_FILLCOLOR", MetaKey.FILLCOLOR);

    @objid ("b796fdf8-900c-4e80-8b96-c16cd300dc6a")
    static final StyleKey FILLMODE = createStyleKey("BUSINESSFUNCTION_FILLMODE", MetaKey.FILLMODE);

    @objid ("dc257cde-3a95-466c-9b6a-39a1a3f417de")
    static final StyleKey LINECOLOR = createStyleKey("BUSINESSFUNCTION_LINECOLOR", MetaKey.LINECOLOR);

    @objid ("31d99d85-9456-40e7-9a9c-0f64ce9298e3")
    static final StyleKey LINEWIDTH = createStyleKey("BUSINESSFUNCTION_LINEWIDTH", MetaKey.LINEWIDTH);

    @objid ("d86a3f7e-2bdf-437b-8873-121073d425b1")
    static final StyleKey FONT = createStyleKey("BUSINESSFUNCTION_FONT", MetaKey.FONT);

    @objid ("59803599-f39f-4daf-9d7a-913039723af5")
    static final StyleKey TEXTCOLOR = createStyleKey("BUSINESSFUNCTION_TEXTCOLOR", MetaKey.TEXTCOLOR);

    @objid ("93082f1d-02f6-4d6c-9031-dd734b80ee7d")
    static final StyleKey SHOWSTEREOTYPES = createStyleKey("BUSINESSFUNCTION_SHOWSTEREOTYPES", MetaKey.SHOWSTEREOTYPES);

    @objid ("7ffbe6a7-27a3-42e9-a1b4-a1d02bfff39f")
    static final StyleKey SHOWTAGS = createStyleKey("BUSINESSFUNCTION_SHOWTAGS", MetaKey.SHOWTAGS);

}

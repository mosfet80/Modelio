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
package org.modelio.archimate.diagrams.elements.applicationfunction;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmApplicationFunction when its representation mode is RepresentationMode.IMAGE
 */
@objid ("02ac8bb7-0b83-4336-bc0d-2e249e389acb")
public class GmApplicationFunctionImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("5e30c664-0c91-4a8c-87bc-a3597d1f36e5")
    static final StyleKey REPMODE = GmApplicationFunctionStructuredStyleKeys.REPMODE;

    @objid ("ced5e759-66a8-4d90-8df7-0448767b6c6f")
    static final StyleKey FONT = GmApplicationFunctionStructuredStyleKeys.FONT;

    @objid ("f0a2211a-3505-47c1-ae68-d3f305f4bd33")
    static final StyleKey TEXTCOLOR = GmApplicationFunctionStructuredStyleKeys.TEXTCOLOR;

    @objid ("f12e139f-3ac9-4c75-bf01-645652cd39dd")
    static final StyleKey SHOWSTEREOTYPES = GmApplicationFunctionStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("944641d5-5ee2-4cff-92c3-a604035f7799")
    static final StyleKey SHOWTAGS = GmApplicationFunctionStructuredStyleKeys.SHOWTAGS;

}

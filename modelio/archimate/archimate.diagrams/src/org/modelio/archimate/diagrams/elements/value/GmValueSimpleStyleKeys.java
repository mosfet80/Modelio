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
package org.modelio.archimate.diagrams.elements.value;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmValue when its representation mode is RepresentationMode.SIMPLE
 */
@objid ("e8cb915e-f755-4ca1-90a9-7adff4a8ad65")
public class GmValueSimpleStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("b6d554ed-46c7-469e-9ae8-a76ad741fe04")
    static final StyleKey REPMODE = GmValueStructuredStyleKeys.REPMODE;

    @objid ("9db4979e-9cee-4ca4-be22-ab69cbd501d6")
    static final StyleKey FILLCOLOR = GmValueStructuredStyleKeys.FILLCOLOR;

    @objid ("3490a07a-7c34-43d9-86eb-8efa6820676a")
    static final StyleKey FILLMODE = GmValueStructuredStyleKeys.FILLMODE;

    @objid ("4070601e-8d3b-4f93-8c30-291c830f0a3d")
    static final StyleKey LINECOLOR = GmValueStructuredStyleKeys.LINECOLOR;

    @objid ("01be1f4a-265b-40c9-b9da-f615faae0072")
    static final StyleKey LINEWIDTH = GmValueStructuredStyleKeys.LINEWIDTH;

    @objid ("97ab0d49-69de-4ddb-adf4-d48ad6e64666")
    static final StyleKey FONT = GmValueStructuredStyleKeys.FONT;

    @objid ("61888d02-5dd0-4ddf-b8a7-d0cf03782d9a")
    static final StyleKey TEXTCOLOR = GmValueStructuredStyleKeys.TEXTCOLOR;

    @objid ("7dfef5f8-1ddc-40d8-8a03-91fa1a185f37")
    static final StyleKey SHOWSTEREOTYPES = GmValueStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("0e323b85-83aa-487d-b60e-11553542c883")
    static final StyleKey SHOWTAGS = GmValueStructuredStyleKeys.SHOWTAGS;

}

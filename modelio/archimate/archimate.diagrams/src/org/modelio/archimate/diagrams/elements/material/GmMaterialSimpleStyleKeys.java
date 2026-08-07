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
package org.modelio.archimate.diagrams.elements.material;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmMaterial when its representation mode is RepresentationMode.SIMPLE
 */
@objid ("16d2b994-d00f-4e3b-bfe6-d48362b1baaa")
public class GmMaterialSimpleStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("bb0f5102-af44-4f3d-b69f-8288e68cd8fe")
    static final StyleKey REPMODE = GmMaterialStructuredStyleKeys.REPMODE;

    @objid ("490ff9a8-0aa7-4d24-b442-be99b80a6934")
    static final StyleKey FILLCOLOR = GmMaterialStructuredStyleKeys.FILLCOLOR;

    @objid ("df5b4879-e19b-49c4-ab48-b1a1b8654916")
    static final StyleKey FILLMODE = GmMaterialStructuredStyleKeys.FILLMODE;

    @objid ("5a2d6584-f79f-44f6-afa1-8b383a09f877")
    static final StyleKey LINECOLOR = GmMaterialStructuredStyleKeys.LINECOLOR;

    @objid ("a7d66b1d-85d2-449d-8ab1-04393634c436")
    static final StyleKey LINEWIDTH = GmMaterialStructuredStyleKeys.LINEWIDTH;

    @objid ("d62cdc6e-86c9-4d5e-a191-d1bad01f055a")
    static final StyleKey FONT = GmMaterialStructuredStyleKeys.FONT;

    @objid ("4725c147-fca8-46f8-ac94-8950965b98a9")
    static final StyleKey TEXTCOLOR = GmMaterialStructuredStyleKeys.TEXTCOLOR;

    @objid ("c2bffce9-cee9-44e1-9514-9056fbd6e78c")
    static final StyleKey SHOWSTEREOTYPES = GmMaterialStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("488c0932-69ee-442b-868e-7a808416bd6f")
    static final StyleKey SHOWTAGS = GmMaterialStructuredStyleKeys.SHOWTAGS;

}

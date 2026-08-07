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
package org.modelio.archimate.diagrams.elements.driver;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmDriver when its representation mode is RepresentationMode.SIMPLE
 */
@objid ("f52aa184-99fc-4db8-b85b-564d11997a50")
public class GmDriverSimpleStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("dfc86fc1-6619-4057-9a06-9edc8d20f263")
    static final StyleKey REPMODE = GmDriverStructuredStyleKeys.REPMODE;

    @objid ("30c5b9f1-d9af-4f4a-9682-80a279c17e82")
    static final StyleKey FILLCOLOR = GmDriverStructuredStyleKeys.FILLCOLOR;

    @objid ("1b00b421-ab9c-4061-a085-93cd957e9733")
    static final StyleKey FILLMODE = GmDriverStructuredStyleKeys.FILLMODE;

    @objid ("a2e7457c-b4e1-4be3-9056-25a48848b507")
    static final StyleKey LINECOLOR = GmDriverStructuredStyleKeys.LINECOLOR;

    @objid ("92cfe7a8-67ca-4a9d-be1d-4ae28eacc6b5")
    static final StyleKey LINEWIDTH = GmDriverStructuredStyleKeys.LINEWIDTH;

    @objid ("2bb99a4d-7bd2-41c3-8cbb-ee03cdf3161f")
    static final StyleKey FONT = GmDriverStructuredStyleKeys.FONT;

    @objid ("2031c2ec-2a93-48d2-a0b6-d6fcc16b3365")
    static final StyleKey TEXTCOLOR = GmDriverStructuredStyleKeys.TEXTCOLOR;

    @objid ("c9683ec9-66f0-4296-bf8a-439dd12a4734")
    static final StyleKey SHOWSTEREOTYPES = GmDriverStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("cca76c60-263a-4d92-9139-ab47c1a122f9")
    static final StyleKey SHOWTAGS = GmDriverStructuredStyleKeys.SHOWTAGS;

}

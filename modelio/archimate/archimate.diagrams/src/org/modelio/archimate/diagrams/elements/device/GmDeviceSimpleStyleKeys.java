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
package org.modelio.archimate.diagrams.elements.device;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmDevice when its representation mode is RepresentationMode.SIMPLE
 */
@objid ("6d967066-ccd9-4f29-8234-7e8ce030994f")
public class GmDeviceSimpleStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("1823c460-1dd2-4a48-a0e4-f10843bc22a7")
    static final StyleKey REPMODE = GmDeviceStructuredStyleKeys.REPMODE;

    @objid ("f72a4183-ac94-4c6b-a178-6738b7d51b7f")
    static final StyleKey FILLCOLOR = GmDeviceStructuredStyleKeys.FILLCOLOR;

    @objid ("9116f155-4ad3-4e21-813a-b4b1dfa51a3b")
    static final StyleKey FILLMODE = GmDeviceStructuredStyleKeys.FILLMODE;

    @objid ("1b4763a1-4f7f-40db-beda-997af17eb1e6")
    static final StyleKey LINECOLOR = GmDeviceStructuredStyleKeys.LINECOLOR;

    @objid ("7bee8436-4492-4b61-8ff9-67c047d65d16")
    static final StyleKey LINEWIDTH = GmDeviceStructuredStyleKeys.LINEWIDTH;

    @objid ("2665fb15-b343-46f9-a1ab-84b784b5dbd3")
    static final StyleKey FONT = GmDeviceStructuredStyleKeys.FONT;

    @objid ("64c1d40b-64fd-4fbd-9713-3f0da1949245")
    static final StyleKey TEXTCOLOR = GmDeviceStructuredStyleKeys.TEXTCOLOR;

    @objid ("0516c6fc-a1cd-45cd-b6f3-90f5278669fd")
    static final StyleKey SHOWSTEREOTYPES = GmDeviceStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("1ae8ea4d-51c8-4ac9-8095-da7b89c0a29f")
    static final StyleKey SHOWTAGS = GmDeviceStructuredStyleKeys.SHOWTAGS;

}

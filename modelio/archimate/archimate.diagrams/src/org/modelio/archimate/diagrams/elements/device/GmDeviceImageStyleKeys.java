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
 * This class provides the StyleKey constants for a GmDevice when its representation mode is RepresentationMode.IMAGE
 */
@objid ("b21b8005-8b05-43a5-ac1c-9ac932783cb3")
public class GmDeviceImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("8d7dad7b-4451-4237-b8b2-952af73be500")
    static final StyleKey REPMODE = GmDeviceStructuredStyleKeys.REPMODE;

    @objid ("ee885f7a-8956-4403-b3df-f807d54ea3db")
    static final StyleKey FONT = GmDeviceStructuredStyleKeys.FONT;

    @objid ("19a3f327-1bf9-4fb5-84ab-8842941a1a01")
    static final StyleKey TEXTCOLOR = GmDeviceStructuredStyleKeys.TEXTCOLOR;

    @objid ("5b1a5ceb-a3da-44bc-b602-d39178a0790c")
    static final StyleKey SHOWSTEREOTYPES = GmDeviceStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("b352bac2-9b9b-43fd-bcd3-873b2e8c4c1b")
    static final StyleKey SHOWTAGS = GmDeviceStructuredStyleKeys.SHOWTAGS;

}

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
package org.modelio.archimate.diagrams.elements.applicationcollaboration;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmApplicationCollaboration when its representation mode is RepresentationMode.IMAGE
 */
@objid ("cc32fe60-d720-45cb-bd1e-f37e1bd61cb3")
public class GmApplicationCollaborationImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("6522085c-a77d-4cde-887a-227959927e00")
    static final StyleKey REPMODE = GmApplicationCollaborationStructuredStyleKeys.REPMODE;

    @objid ("4067d293-3bba-482f-87a1-8ba159eb3e03")
    static final StyleKey FONT = GmApplicationCollaborationStructuredStyleKeys.FONT;

    @objid ("fafeaf9a-805f-4373-941f-0ddc734b1cf2")
    static final StyleKey TEXTCOLOR = GmApplicationCollaborationStructuredStyleKeys.TEXTCOLOR;

    @objid ("c0bd29cc-55d8-4265-8bd0-cbc3882994e3")
    static final StyleKey SHOWSTEREOTYPES = GmApplicationCollaborationStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("7decbf86-a22e-4179-8ed0-26fad9bd7fd7")
    static final StyleKey SHOWTAGS = GmApplicationCollaborationStructuredStyleKeys.SHOWTAGS;

}

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
package org.modelio.archimate.diagrams.elements.stakeholder;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmStakeholder when its representation mode is RepresentationMode.IMAGE
 */
@objid ("5d3959c9-1d3c-45ea-b7b6-929182249c73")
public class GmStakeholderUserImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("141f34b3-0340-4c52-afcb-34053a5130bd")
    static final StyleKey REPMODE = GmStakeholderStructuredStyleKeys.REPMODE;

    @objid ("9c36bd0f-f39d-49eb-9ab9-4867e3296936")
    static final StyleKey FONT = GmStakeholderStructuredStyleKeys.FONT;

    @objid ("e8e6f6eb-b041-4807-9b8c-bff9792fbe50")
    static final StyleKey TEXTCOLOR = GmStakeholderStructuredStyleKeys.TEXTCOLOR;

    @objid ("3495255a-7b4a-4293-9a59-7a28faa0c574")
    static final StyleKey SHOWSTEREOTYPES = GmStakeholderStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("a3ba4490-f846-41f1-9e44-a4ca42e23b8d")
    static final StyleKey SHOWTAGS = GmStakeholderStructuredStyleKeys.SHOWTAGS;

}

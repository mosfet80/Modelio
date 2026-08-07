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
package org.modelio.archimate.diagrams.elements.resource;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmResource when its representation mode is RepresentationMode.IMAGE
 */
@objid ("56b27ccf-ebf0-4e13-b0e9-768ce4f37406")
public class GmResourceUserImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("2dc4e5d9-c45a-4ecd-8526-74c505d02ff6")
    static final StyleKey REPMODE = GmResourceStructuredStyleKeys.REPMODE;

    @objid ("8f55b2cd-4d31-4740-beb5-37b81285d122")
    static final StyleKey FONT = GmResourceStructuredStyleKeys.FONT;

    @objid ("754d9cc9-6718-48a7-8045-69f5fa4e9e41")
    static final StyleKey TEXTCOLOR = GmResourceStructuredStyleKeys.TEXTCOLOR;

    @objid ("c96cc820-1210-4f41-99f5-3643f7df5456")
    static final StyleKey SHOWSTEREOTYPES = GmResourceStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("bc34d7f1-161c-47f3-bf89-1c9332a51245")
    static final StyleKey SHOWTAGS = GmResourceStructuredStyleKeys.SHOWTAGS;

}

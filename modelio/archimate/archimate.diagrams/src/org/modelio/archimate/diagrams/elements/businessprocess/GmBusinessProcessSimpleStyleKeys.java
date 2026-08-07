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
package org.modelio.archimate.diagrams.elements.businessprocess;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmBusinessProcess when its representation mode is RepresentationMode.SIMPLE
 */
@objid ("eae08187-3bce-4fb1-ae66-bda531accc73")
public class GmBusinessProcessSimpleStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("126b188f-516d-4731-afe6-de994e913f52")
    static final StyleKey REPMODE = GmBusinessProcessStructuredStyleKeys.REPMODE;

    @objid ("54fda250-4b53-4887-9268-1a3170768bdb")
    static final StyleKey FILLCOLOR = GmBusinessProcessStructuredStyleKeys.FILLCOLOR;

    @objid ("5dda8ea7-8bbc-4cf3-b043-04abe0a59bc0")
    static final StyleKey FILLMODE = GmBusinessProcessStructuredStyleKeys.FILLMODE;

    @objid ("a485b1ce-a789-4bc7-9f91-be90a201c46a")
    static final StyleKey LINECOLOR = GmBusinessProcessStructuredStyleKeys.LINECOLOR;

    @objid ("f3d48657-3425-4a21-a100-f4ce58a1ef5e")
    static final StyleKey LINEWIDTH = GmBusinessProcessStructuredStyleKeys.LINEWIDTH;

    @objid ("8c970ed1-badc-4d10-a3a8-a9907b013483")
    static final StyleKey FONT = GmBusinessProcessStructuredStyleKeys.FONT;

    @objid ("90d97153-3a7a-443f-9fa0-fd5587040413")
    static final StyleKey TEXTCOLOR = GmBusinessProcessStructuredStyleKeys.TEXTCOLOR;

    @objid ("7301feb8-609b-4113-870a-01f38a8e8943")
    static final StyleKey SHOWSTEREOTYPES = GmBusinessProcessStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("64f8b5c8-dc2e-4b78-8909-c772bdc9fd60")
    static final StyleKey SHOWTAGS = GmBusinessProcessStructuredStyleKeys.SHOWTAGS;

}

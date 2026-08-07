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
package org.modelio.archimate.diagrams.elements.technologyinterface;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmTechnologyInterface when its representation mode is RepresentationMode.IMAGE
 */
@objid ("9bd5c1bb-424d-44e3-b58c-a9b8a0af1a14")
public class GmTechnologyInterfaceUserImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("7857b9fb-79d1-4717-a578-6e936ad72991")
    static final StyleKey REPMODE = GmTechnologyInterfaceStructuredStyleKeys.REPMODE;

    @objid ("468156d8-0c02-4b21-9279-1b3cf7f4e768")
    static final StyleKey FONT = GmTechnologyInterfaceStructuredStyleKeys.FONT;

    @objid ("59437120-8082-49e7-8b03-11f82b9407f5")
    static final StyleKey TEXTCOLOR = GmTechnologyInterfaceStructuredStyleKeys.TEXTCOLOR;

    @objid ("26f87fb5-cef3-4e11-8978-1bec51f249d0")
    static final StyleKey SHOWSTEREOTYPES = GmTechnologyInterfaceStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("7a7aeaca-cbf7-4848-a83e-3848b740522d")
    static final StyleKey SHOWTAGS = GmTechnologyInterfaceStructuredStyleKeys.SHOWTAGS;

}

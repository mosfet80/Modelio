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
package org.modelio.archimate.diagrams.elements.businessevent;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmBusinessEvent when its representation mode is RepresentationMode.IMAGE
 */
@objid ("4172a567-81fb-4bfd-8cac-37b9fbbe5527")
public class GmBusinessEventImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("49305ef2-62f2-4b03-a45a-8bfd883390c0")
    static final StyleKey REPMODE = GmBusinessEventStructuredStyleKeys.REPMODE;

    @objid ("6b3259f4-df8c-41d8-88ea-46ae083c8589")
    static final StyleKey FONT = GmBusinessEventStructuredStyleKeys.FONT;

    @objid ("af994657-b4d6-4321-8cea-63f254445f60")
    static final StyleKey TEXTCOLOR = GmBusinessEventStructuredStyleKeys.TEXTCOLOR;

    @objid ("073fe798-9521-4a2b-9a23-33d476d5ea4c")
    static final StyleKey SHOWSTEREOTYPES = GmBusinessEventStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("06ab37e9-a213-4f7c-af0d-8c9fed565a02")
    static final StyleKey SHOWTAGS = GmBusinessEventStructuredStyleKeys.SHOWTAGS;

}

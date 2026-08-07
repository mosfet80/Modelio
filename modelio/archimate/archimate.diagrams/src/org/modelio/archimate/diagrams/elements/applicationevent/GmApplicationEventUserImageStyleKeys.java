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
package org.modelio.archimate.diagrams.elements.applicationevent;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmApplicationEvent when its representation mode is RepresentationMode.IMAGE
 */
@objid ("e82337f8-6e43-4a40-a5bd-ba23a2221251")
public class GmApplicationEventUserImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("bd6bf650-ad72-4fcb-968d-1c356a316a3f")
    static final StyleKey REPMODE = GmApplicationEventStructuredStyleKeys.REPMODE;

    @objid ("69fd147e-2432-4fde-9c0a-5feac82bec05")
    static final StyleKey FONT = GmApplicationEventStructuredStyleKeys.FONT;

    @objid ("38f9914d-96eb-4f47-bd8c-9edd96f5b042")
    static final StyleKey TEXTCOLOR = GmApplicationEventStructuredStyleKeys.TEXTCOLOR;

    @objid ("f60f0fdc-21a0-4337-af21-e5b94b5abc87")
    static final StyleKey SHOWSTEREOTYPES = GmApplicationEventStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("c1eba131-fc12-4f00-93c9-9b9dda638ed4")
    static final StyleKey SHOWTAGS = GmApplicationEventStructuredStyleKeys.SHOWTAGS;

}

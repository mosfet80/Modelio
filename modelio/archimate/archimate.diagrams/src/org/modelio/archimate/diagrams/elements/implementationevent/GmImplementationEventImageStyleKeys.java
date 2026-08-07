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
package org.modelio.archimate.diagrams.elements.implementationevent;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmImplementationEvent when its representation mode is RepresentationMode.IMAGE
 */
@objid ("dd9debda-ce13-4023-ac32-a4ee76004ad8")
public class GmImplementationEventImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("33823293-c17e-4036-9142-dd171945f8ba")
    static final StyleKey REPMODE = GmImplementationEventStructuredStyleKeys.REPMODE;

    @objid ("1742a8df-4fb8-4aee-807a-79ccdd7679a1")
    static final StyleKey FONT = GmImplementationEventStructuredStyleKeys.FONT;

    @objid ("978dbd9d-a1b0-4326-acbd-769107c97d93")
    static final StyleKey TEXTCOLOR = GmImplementationEventStructuredStyleKeys.TEXTCOLOR;

    @objid ("de559745-6f4d-4347-a67c-d4da999e1485")
    static final StyleKey SHOWSTEREOTYPES = GmImplementationEventStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("125fe726-61bd-4ceb-aa2e-5d7b1a25b15d")
    static final StyleKey SHOWTAGS = GmImplementationEventStructuredStyleKeys.SHOWTAGS;

}

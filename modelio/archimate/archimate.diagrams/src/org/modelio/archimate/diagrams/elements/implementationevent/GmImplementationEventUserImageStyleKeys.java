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
@objid ("bdb01e10-7b8b-4d93-87bb-d216d0cb88bc")
public class GmImplementationEventUserImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("08232c6f-17f4-47d4-9a64-0d18eac800b0")
    static final StyleKey REPMODE = GmImplementationEventStructuredStyleKeys.REPMODE;

    @objid ("9d1513cd-ae3f-4cbf-aa6f-8f6426854cc1")
    static final StyleKey FONT = GmImplementationEventStructuredStyleKeys.FONT;

    @objid ("df4a085c-749a-4e05-a04e-73f2aa8a5daa")
    static final StyleKey TEXTCOLOR = GmImplementationEventStructuredStyleKeys.TEXTCOLOR;

    @objid ("3019ba6d-c002-4e5c-bbe3-f1ee0f59ff0c")
    static final StyleKey SHOWSTEREOTYPES = GmImplementationEventStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("bbb6ee29-6db0-486f-b380-a5ab02e6d731")
    static final StyleKey SHOWTAGS = GmImplementationEventStructuredStyleKeys.SHOWTAGS;

}

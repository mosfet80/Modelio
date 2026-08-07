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
package org.modelio.archimate.diagrams.elements.technologyevent;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmTechnologyEvent when its representation mode is RepresentationMode.IMAGE
 */
@objid ("4bbc76ac-ba50-45c2-892a-fe3b0f14fe48")
public class GmTechnologyEventImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("a6d4405e-ef3e-4f35-b198-8c75140d045b")
    static final StyleKey REPMODE = GmTechnologyEventStructuredStyleKeys.REPMODE;

    @objid ("9d8cc66a-5cae-47d7-96e1-38f86fd5f50b")
    static final StyleKey FONT = GmTechnologyEventStructuredStyleKeys.FONT;

    @objid ("3c8419cb-d1cd-47b3-9741-119dfd3403c7")
    static final StyleKey TEXTCOLOR = GmTechnologyEventStructuredStyleKeys.TEXTCOLOR;

    @objid ("ff033662-c221-4d4a-93f5-805bbbf9d275")
    static final StyleKey SHOWSTEREOTYPES = GmTechnologyEventStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("3e84d020-68a6-4f41-9d2e-7f28577c9bc7")
    static final StyleKey SHOWTAGS = GmTechnologyEventStructuredStyleKeys.SHOWTAGS;

}

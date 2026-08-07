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
 * This class provides the StyleKey constants for a GmBusinessProcess when its representation mode is RepresentationMode.IMAGE
 */
@objid ("27798482-8795-4dca-81e3-6d9f26965221")
public class GmBusinessProcessUserImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("43fdbe62-e75b-4b9f-9505-3f4200a477c1")
    static final StyleKey REPMODE = GmBusinessProcessStructuredStyleKeys.REPMODE;

    @objid ("e8cbde5d-f9a7-4329-96d3-da4d1ecc1716")
    static final StyleKey FONT = GmBusinessProcessStructuredStyleKeys.FONT;

    @objid ("b5652eb6-11c4-4fec-9cf8-155be3cf65a5")
    static final StyleKey TEXTCOLOR = GmBusinessProcessStructuredStyleKeys.TEXTCOLOR;

    @objid ("30590fed-8a32-45ae-919b-b9e288ad271a")
    static final StyleKey SHOWSTEREOTYPES = GmBusinessProcessStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("ff3f0e6b-0c52-4052-8d7e-15687b8376b4")
    static final StyleKey SHOWTAGS = GmBusinessProcessStructuredStyleKeys.SHOWTAGS;

}

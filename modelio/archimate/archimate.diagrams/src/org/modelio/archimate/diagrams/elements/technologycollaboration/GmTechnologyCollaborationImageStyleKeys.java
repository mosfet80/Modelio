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
package org.modelio.archimate.diagrams.elements.technologycollaboration;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmTechnologyCollaboration when its representation mode is RepresentationMode.IMAGE
 */
@objid ("999920f5-e104-4590-8037-1253204d0b13")
public class GmTechnologyCollaborationImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("70fb4ecc-faec-45d2-b569-0adea474d455")
    static final StyleKey REPMODE = GmTechnologyCollaborationStructuredStyleKeys.REPMODE;

    @objid ("af316469-0e3f-4029-9c3a-041c13485169")
    static final StyleKey FONT = GmTechnologyCollaborationStructuredStyleKeys.FONT;

    @objid ("1d09517a-8bb3-4610-adfb-55af4979e773")
    static final StyleKey TEXTCOLOR = GmTechnologyCollaborationStructuredStyleKeys.TEXTCOLOR;

    @objid ("07101309-f24f-4444-9116-aade187f5395")
    static final StyleKey SHOWSTEREOTYPES = GmTechnologyCollaborationStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("ba654f78-7ba7-4e15-9b36-3dd07384a508")
    static final StyleKey SHOWTAGS = GmTechnologyCollaborationStructuredStyleKeys.SHOWTAGS;

}

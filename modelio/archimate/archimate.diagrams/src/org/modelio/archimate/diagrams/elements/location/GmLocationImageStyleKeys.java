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
package org.modelio.archimate.diagrams.elements.location;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmLocation when its representation mode is RepresentationMode.IMAGE
 */
@objid ("a1f2daaa-cc09-4236-b8ac-ce1deed7e7e4")
public class GmLocationImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("22c65d2f-c02e-425f-bc9a-c780e7fcef1a")
    static final StyleKey REPMODE = GmLocationStructuredStyleKeys.REPMODE;

    @objid ("f200c5f9-8fc7-4cbc-81af-64a03d84adef")
    static final StyleKey FONT = GmLocationStructuredStyleKeys.FONT;

    @objid ("3bb21af4-c367-4cea-9c12-4c6cf7e66d2b")
    static final StyleKey TEXTCOLOR = GmLocationStructuredStyleKeys.TEXTCOLOR;

    @objid ("b6ecf99a-2516-41ff-b19d-9388bbd6d322")
    static final StyleKey SHOWSTEREOTYPES = GmLocationStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("e793b97e-f6ed-4da7-a86d-769b9d3c5286")
    static final StyleKey SHOWTAGS = GmLocationStructuredStyleKeys.SHOWTAGS;

}

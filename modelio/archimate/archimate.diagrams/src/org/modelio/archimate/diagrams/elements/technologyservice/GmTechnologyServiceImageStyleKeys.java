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
package org.modelio.archimate.diagrams.elements.technologyservice;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmTechnologyService when its representation mode is RepresentationMode.IMAGE
 */
@objid ("8a360efd-0067-4679-9d39-69fa793acc66")
public class GmTechnologyServiceImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("f29d9cb1-2b4b-4dc8-8397-6a602d2ee5a3")
    static final StyleKey REPMODE = GmTechnologyServiceStructuredStyleKeys.REPMODE;

    @objid ("e8cd5c5f-bb44-4a1d-9de0-e917cb1fa95d")
    static final StyleKey FONT = GmTechnologyServiceStructuredStyleKeys.FONT;

    @objid ("dd1964db-4d7f-424c-8276-583afd643938")
    static final StyleKey TEXTCOLOR = GmTechnologyServiceStructuredStyleKeys.TEXTCOLOR;

    @objid ("f984c646-0ac9-4965-8c8d-38744db1b837")
    static final StyleKey SHOWSTEREOTYPES = GmTechnologyServiceStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("be422b49-9a80-4cc6-ac51-5d5aa8a9ab76")
    static final StyleKey SHOWTAGS = GmTechnologyServiceStructuredStyleKeys.SHOWTAGS;

}

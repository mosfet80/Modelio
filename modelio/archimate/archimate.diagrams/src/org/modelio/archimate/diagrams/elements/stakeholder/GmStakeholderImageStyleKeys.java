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
package org.modelio.archimate.diagrams.elements.stakeholder;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmStakeholder when its representation mode is RepresentationMode.IMAGE
 */
@objid ("61f64cee-55b7-4098-a377-567da38b8eef")
public class GmStakeholderImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("197a24e6-43e6-4c3c-9939-138f5f9a5c07")
    static final StyleKey REPMODE = GmStakeholderStructuredStyleKeys.REPMODE;

    @objid ("f048ea89-5c3a-45f1-ab52-f92bd73ce645")
    static final StyleKey FONT = GmStakeholderStructuredStyleKeys.FONT;

    @objid ("b811d275-6705-4af3-b051-a1810a573005")
    static final StyleKey TEXTCOLOR = GmStakeholderStructuredStyleKeys.TEXTCOLOR;

    @objid ("8b1bca33-2af2-42d3-b863-e93b933f9335")
    static final StyleKey SHOWSTEREOTYPES = GmStakeholderStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("5ea1aafd-126c-4ed6-8209-af9115ad904e")
    static final StyleKey SHOWTAGS = GmStakeholderStructuredStyleKeys.SHOWTAGS;

}

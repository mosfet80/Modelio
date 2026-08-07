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
package org.modelio.archimate.diagrams.elements.businessobject;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmBusinessObject when its representation mode is RepresentationMode.SIMPLE
 */
@objid ("eb4cd905-19d9-4281-87dd-2127efb0ca69")
public class GmBusinessObjectSimpleStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("c7c016ed-95e4-4e72-a060-7280dd0f29d2")
    static final StyleKey REPMODE = GmBusinessObjectStructuredStyleKeys.REPMODE;

    @objid ("73bd2a26-01aa-40c9-a722-8db616926ea4")
    static final StyleKey FILLCOLOR = GmBusinessObjectStructuredStyleKeys.FILLCOLOR;

    @objid ("90db7d7c-ea92-4193-8ab1-85ff32f7c188")
    static final StyleKey FILLMODE = GmBusinessObjectStructuredStyleKeys.FILLMODE;

    @objid ("5b1ad70c-bf01-4d94-b406-08ef8d09acab")
    static final StyleKey LINECOLOR = GmBusinessObjectStructuredStyleKeys.LINECOLOR;

    @objid ("e2363894-6754-43d1-ab31-afc46ae29c4d")
    static final StyleKey LINEWIDTH = GmBusinessObjectStructuredStyleKeys.LINEWIDTH;

    @objid ("0e0ae58d-e430-4ce8-8ebf-6d5e38af4845")
    static final StyleKey FONT = GmBusinessObjectStructuredStyleKeys.FONT;

    @objid ("b4b4c5b3-c5a4-4ef2-a4b0-01aa86aaa3ce")
    static final StyleKey TEXTCOLOR = GmBusinessObjectStructuredStyleKeys.TEXTCOLOR;

    @objid ("a8fa3be1-63ff-4808-ac8a-83a978d660e9")
    static final StyleKey SHOWSTEREOTYPES = GmBusinessObjectStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("6debd9e6-8c83-4920-879c-a50ab87a45a8")
    static final StyleKey SHOWTAGS = GmBusinessObjectStructuredStyleKeys.SHOWTAGS;

}

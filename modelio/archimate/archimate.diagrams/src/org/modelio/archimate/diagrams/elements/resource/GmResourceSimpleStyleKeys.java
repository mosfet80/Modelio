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
package org.modelio.archimate.diagrams.elements.resource;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmResource when its representation mode is RepresentationMode.SIMPLE
 */
@objid ("a54bd918-0049-478d-965d-3e86d26447d8")
public class GmResourceSimpleStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("cd9b4a01-dd27-4fa7-a31b-ced2ff193737")
    static final StyleKey REPMODE = GmResourceStructuredStyleKeys.REPMODE;

    @objid ("bf51ac9a-227b-4abc-b8f7-b63a802b0787")
    static final StyleKey FILLCOLOR = GmResourceStructuredStyleKeys.FILLCOLOR;

    @objid ("7779e43b-6f60-47bf-bbce-b8c77ca95053")
    static final StyleKey FILLMODE = GmResourceStructuredStyleKeys.FILLMODE;

    @objid ("53ce5f94-c288-46c9-a280-9b328612e85f")
    static final StyleKey LINECOLOR = GmResourceStructuredStyleKeys.LINECOLOR;

    @objid ("fecadac8-5630-44a7-bcc1-cfdc9c197b65")
    static final StyleKey LINEWIDTH = GmResourceStructuredStyleKeys.LINEWIDTH;

    @objid ("a00d526c-91d3-4dd7-ad18-bd9556e30461")
    static final StyleKey FONT = GmResourceStructuredStyleKeys.FONT;

    @objid ("f30a2317-1777-4aa3-87d5-b81c7ae0baf3")
    static final StyleKey TEXTCOLOR = GmResourceStructuredStyleKeys.TEXTCOLOR;

    @objid ("ab655482-e692-4f82-ac5f-624730b1e7d1")
    static final StyleKey SHOWSTEREOTYPES = GmResourceStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("c52abbd1-c6ce-401e-a540-8622442ed739")
    static final StyleKey SHOWTAGS = GmResourceStructuredStyleKeys.SHOWTAGS;

}

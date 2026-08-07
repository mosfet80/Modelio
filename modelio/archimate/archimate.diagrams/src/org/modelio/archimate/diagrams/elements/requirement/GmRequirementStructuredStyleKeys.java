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
package org.modelio.archimate.diagrams.elements.requirement;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmRequirement when its representation mode is RepresentationMode.STRUCTURED
 */
@objid ("176382de-ced3-4e2a-9261-56910dcca56f")
public class GmRequirementStructuredStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("ead9dc3f-0a9f-4d03-b41a-c4b03a0bc902")
    static final StyleKey REPMODE = createStyleKey("ARCHIMATE_REQUIREMENT_REPMODE", MetaKey.REPMODE);

    @objid ("74ace27d-0300-41fc-bd35-786b9b961b43")
    static final StyleKey FILLCOLOR = createStyleKey("ARCHIMATE_REQUIREMENT_FILLCOLOR", MetaKey.FILLCOLOR);

    @objid ("3862e0f8-b1ac-4caa-96f6-dd880e9218c2")
    static final StyleKey FILLMODE = createStyleKey("ARCHIMATE_REQUIREMENT_FILLMODE", MetaKey.FILLMODE);

    @objid ("dac310e7-d92e-4fda-8804-a20cabe9f785")
    static final StyleKey LINECOLOR = createStyleKey("ARCHIMATE_REQUIREMENT_LINECOLOR", MetaKey.LINECOLOR);

    @objid ("2ecfecde-8df5-4fe6-a61c-8ee29959f064")
    static final StyleKey LINEWIDTH = createStyleKey("ARCHIMATE_REQUIREMENT_LINEWIDTH", MetaKey.LINEWIDTH);

    @objid ("d5bcdd24-52ab-4794-86bc-421a7ced9eb1")
    static final StyleKey FONT = createStyleKey("ARCHIMATE_REQUIREMENT_FONT", MetaKey.FONT);

    @objid ("9b6e2baa-675f-43ce-afc0-05325f391abe")
    static final StyleKey TEXTCOLOR = createStyleKey("ARCHIMATE_REQUIREMENT_TEXTCOLOR", MetaKey.TEXTCOLOR);

    @objid ("b365c292-d942-4848-8f54-d0eb70d0d184")
    static final StyleKey SHOWSTEREOTYPES = createStyleKey("ARCHIMATE_REQUIREMENT_SHOWSTEREOTYPES", MetaKey.SHOWSTEREOTYPES);

    @objid ("81ced91f-dbe2-4b1e-bf2f-c151f43e5be5")
    static final StyleKey SHOWTAGS = createStyleKey("ARCHIMATE_REQUIREMENT_SHOWTAGS", MetaKey.SHOWTAGS);

}

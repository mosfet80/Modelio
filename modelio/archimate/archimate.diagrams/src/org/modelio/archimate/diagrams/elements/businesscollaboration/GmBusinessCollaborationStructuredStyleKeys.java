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
package org.modelio.archimate.diagrams.elements.businesscollaboration;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmBusinessCollaboration when its representation mode is RepresentationMode.STRUCTURED
 */
@objid ("d25a04fa-d4bc-4c21-8a66-4654725b34af")
public class GmBusinessCollaborationStructuredStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("763f6ccb-1a8a-4b53-9285-437f8f52b032")
    static final StyleKey REPMODE = createStyleKey("BUSINESSCOLLABORATION_REPMODE", MetaKey.REPMODE);

    @objid ("4fc309b2-9625-4f47-a616-a657f05fcfcc")
    static final StyleKey FILLCOLOR = createStyleKey("BUSINESSCOLLABORATION_FILLCOLOR", MetaKey.FILLCOLOR);

    @objid ("b9ccaaf5-6c12-49e0-b3e6-50d25425cea4")
    static final StyleKey FILLMODE = createStyleKey("BUSINESSCOLLABORATION_FILLMODE", MetaKey.FILLMODE);

    @objid ("a4810363-d456-4680-ac28-7cda09cf442d")
    static final StyleKey LINECOLOR = createStyleKey("BUSINESSCOLLABORATION_LINECOLOR", MetaKey.LINECOLOR);

    @objid ("db1ccd46-2b41-45c8-9c98-f532d88cf591")
    static final StyleKey LINEWIDTH = createStyleKey("BUSINESSCOLLABORATION_LINEWIDTH", MetaKey.LINEWIDTH);

    @objid ("756df231-647c-4762-8e2a-dbfdc1b3c4c9")
    static final StyleKey FONT = createStyleKey("BUSINESSCOLLABORATION_FONT", MetaKey.FONT);

    @objid ("44b40d30-6c74-4eac-a006-af1c3c1371d2")
    static final StyleKey TEXTCOLOR = createStyleKey("BUSINESSCOLLABORATION_TEXTCOLOR", MetaKey.TEXTCOLOR);

    @objid ("437c2c78-191c-4bb7-aa3f-301210ef466c")
    static final StyleKey SHOWSTEREOTYPES = createStyleKey("BUSINESSCOLLABORATION_SHOWSTEREOTYPES", MetaKey.SHOWSTEREOTYPES);

    @objid ("76bff651-bd1b-4415-a94e-9aeaeabce5f4")
    static final StyleKey SHOWTAGS = createStyleKey("BUSINESSCOLLABORATION_SHOWTAGS", MetaKey.SHOWTAGS);

}

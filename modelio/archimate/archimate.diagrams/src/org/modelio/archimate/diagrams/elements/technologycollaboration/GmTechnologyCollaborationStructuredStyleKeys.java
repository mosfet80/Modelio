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
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmTechnologyCollaboration when its representation mode is RepresentationMode.STRUCTURED
 */
@objid ("8460839b-2209-4732-8053-6dc3fb46f794")
public class GmTechnologyCollaborationStructuredStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("3ed1d6f6-b3bf-4726-974f-cb07c940e134")
    static final StyleKey REPMODE = createStyleKey("TECHNOLOGYCOLLABORATION_REPMODE", MetaKey.REPMODE);

    @objid ("a9151548-52c4-42cd-abd0-101aba850712")
    static final StyleKey FILLCOLOR = createStyleKey("TECHNOLOGYCOLLABORATION_FILLCOLOR", MetaKey.FILLCOLOR);

    @objid ("8da2b03d-97b2-41d2-80dd-3338fbcd7c03")
    static final StyleKey FILLMODE = createStyleKey("TECHNOLOGYCOLLABORATION_FILLMODE", MetaKey.FILLMODE);

    @objid ("7316f19a-9d4d-4ee4-b4b4-b36bfc4eee99")
    static final StyleKey LINECOLOR = createStyleKey("TECHNOLOGYCOLLABORATION_LINECOLOR", MetaKey.LINECOLOR);

    @objid ("96aaff73-899d-4646-8b39-7f411468182b")
    static final StyleKey LINEWIDTH = createStyleKey("TECHNOLOGYCOLLABORATION_LINEWIDTH", MetaKey.LINEWIDTH);

    @objid ("169a8dcb-d944-4261-a695-9670cbef1a3a")
    static final StyleKey FONT = createStyleKey("TECHNOLOGYCOLLABORATION_FONT", MetaKey.FONT);

    @objid ("97140844-8f5a-48b9-aa75-391757123a35")
    static final StyleKey TEXTCOLOR = createStyleKey("TECHNOLOGYCOLLABORATION_TEXTCOLOR", MetaKey.TEXTCOLOR);

    @objid ("c2b9827c-23d8-48e1-903e-33411353e585")
    static final StyleKey SHOWSTEREOTYPES = createStyleKey("TECHNOLOGYCOLLABORATION_SHOWSTEREOTYPES", MetaKey.SHOWSTEREOTYPES);

    @objid ("8bfcc679-14a9-4151-ad09-543677b12021")
    static final StyleKey SHOWTAGS = createStyleKey("TECHNOLOGYCOLLABORATION_SHOWTAGS", MetaKey.SHOWTAGS);

}

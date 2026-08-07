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
package org.modelio.archimate.diagrams.elements.path;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmPath when its representation mode is RepresentationMode.STRUCTURED
 */
@objid ("e8f26d09-78dc-48a9-9f72-81869fa0ede8")
public class GmPathStructuredStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("342f8c89-c333-48db-9035-affb2b1c3f01")
    static final StyleKey REPMODE = createStyleKey("PATH_REPMODE", MetaKey.REPMODE);

    @objid ("0423416c-cec8-4e42-aa2c-4a10f48feaa4")
    static final StyleKey FILLCOLOR = createStyleKey("PATH_FILLCOLOR", MetaKey.FILLCOLOR);

    @objid ("6511bc98-09d8-430a-b072-ef4581f6f02e")
    static final StyleKey FILLMODE = createStyleKey("PATH_FILLMODE", MetaKey.FILLMODE);

    @objid ("90fd0954-1fca-4da6-9c23-e8ffa71f3d00")
    static final StyleKey LINECOLOR = createStyleKey("PATH_LINECOLOR", MetaKey.LINECOLOR);

    @objid ("3561c5c6-ba72-4ca9-9b94-d52c3f1e7384")
    static final StyleKey LINEWIDTH = createStyleKey("PATH_LINEWIDTH", MetaKey.LINEWIDTH);

    @objid ("71194582-73c3-42f8-abf0-0736f8f5bf5b")
    static final StyleKey FONT = createStyleKey("PATH_FONT", MetaKey.FONT);

    @objid ("107481c5-3931-40a1-bb6a-8df164b8d7b0")
    static final StyleKey TEXTCOLOR = createStyleKey("PATH_TEXTCOLOR", MetaKey.TEXTCOLOR);

    @objid ("7d9d20f0-a493-4a24-ad06-9540bc621d79")
    static final StyleKey SHOWSTEREOTYPES = createStyleKey("PATH_SHOWSTEREOTYPES", MetaKey.SHOWSTEREOTYPES);

    @objid ("69a5ebe9-d1ee-4a78-a70e-96e15ab8f097")
    static final StyleKey SHOWTAGS = createStyleKey("PATH_SHOWTAGS", MetaKey.SHOWTAGS);

}

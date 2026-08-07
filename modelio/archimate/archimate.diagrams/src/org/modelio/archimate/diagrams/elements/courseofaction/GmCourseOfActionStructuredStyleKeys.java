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
package org.modelio.archimate.diagrams.elements.courseofaction;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmCourseOfAction when its representation mode is RepresentationMode.STRUCTURED
 */
@objid ("7949c34d-2dad-4312-917e-4138cfc4495f")
public class GmCourseOfActionStructuredStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("0bdd1793-ee4c-44c3-afb9-b3823f084570")
    static final StyleKey REPMODE = createStyleKey("COURSEOFACTION_REPMODE", MetaKey.REPMODE);

    @objid ("37413f6b-00a6-4ebb-bf81-b5039988767b")
    static final StyleKey FILLCOLOR = createStyleKey("COURSEOFACTION_FILLCOLOR", MetaKey.FILLCOLOR);

    @objid ("4c121212-4057-44a3-a3ad-f11158a4694d")
    static final StyleKey FILLMODE = createStyleKey("COURSEOFACTION_FILLMODE", MetaKey.FILLMODE);

    @objid ("1dd433f4-ba92-4522-821b-56fa0d74534e")
    static final StyleKey LINECOLOR = createStyleKey("COURSEOFACTION_LINECOLOR", MetaKey.LINECOLOR);

    @objid ("d2d62b9d-269d-4f26-9c71-e44fdc7f5b7c")
    static final StyleKey LINEWIDTH = createStyleKey("COURSEOFACTION_LINEWIDTH", MetaKey.LINEWIDTH);

    @objid ("73018537-7b0d-48bf-9887-a1d899d3437a")
    static final StyleKey FONT = createStyleKey("COURSEOFACTION_FONT", MetaKey.FONT);

    @objid ("7366e067-637a-4afc-9def-6aab87a01540")
    static final StyleKey TEXTCOLOR = createStyleKey("COURSEOFACTION_TEXTCOLOR", MetaKey.TEXTCOLOR);

    @objid ("fd7ad7b0-77d1-4450-b04e-d11fe3b01e4a")
    static final StyleKey SHOWSTEREOTYPES = createStyleKey("COURSEOFACTION_SHOWSTEREOTYPES", MetaKey.SHOWSTEREOTYPES);

    @objid ("1580408e-b0c3-4b36-9018-afb4015d92f5")
    static final StyleKey SHOWTAGS = createStyleKey("COURSEOFACTION_SHOWTAGS", MetaKey.SHOWTAGS);

}

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
package org.modelio.archimate.diagrams.elements.constraint;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmConstraint when its representation mode is RepresentationMode.STRUCTURED
 */
@objid ("343e9681-daa9-44ec-bfea-ce2b13f70b28")
public class GmConstraintStructuredStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("c6495921-181c-49a1-a912-6322b96cf2d5")
    static final StyleKey REPMODE = createStyleKey("CONSTRAINT_REPMODE", MetaKey.REPMODE);

    @objid ("13c701e0-d4d3-485d-9058-1908d18da855")
    static final StyleKey FILLCOLOR = createStyleKey("CONSTRAINT_FILLCOLOR", MetaKey.FILLCOLOR);

    @objid ("5123a86e-5635-4b77-9242-9cd02ad981bb")
    static final StyleKey FILLMODE = createStyleKey("CONSTRAINT_FILLMODE", MetaKey.FILLMODE);

    @objid ("443c886c-c863-4309-aa28-e89f2c1dfe68")
    static final StyleKey LINECOLOR = createStyleKey("CONSTRAINT_LINECOLOR", MetaKey.LINECOLOR);

    @objid ("c0715ee9-3da5-48f3-9992-ac34685fd299")
    static final StyleKey LINEWIDTH = createStyleKey("CONSTRAINT_LINEWIDTH", MetaKey.LINEWIDTH);

    @objid ("2379701a-238b-4a12-8d55-ee2907abe5bd")
    static final StyleKey FONT = createStyleKey("CONSTRAINT_FONT", MetaKey.FONT);

    @objid ("c965ee34-add5-4411-ae8d-96e7ed885a67")
    static final StyleKey TEXTCOLOR = createStyleKey("CONSTRAINT_TEXTCOLOR", MetaKey.TEXTCOLOR);

    @objid ("6a4310ca-cacb-4933-93af-6052f701263f")
    static final StyleKey SHOWSTEREOTYPES = createStyleKey("CONSTRAINT_SHOWSTEREOTYPES", MetaKey.SHOWSTEREOTYPES);

    @objid ("edc48f6a-3b2f-4614-a43c-8b425e05735e")
    static final StyleKey SHOWTAGS = createStyleKey("CONSTRAINT_SHOWTAGS", MetaKey.SHOWTAGS);

}

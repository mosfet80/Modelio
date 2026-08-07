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
package org.modelio.archimate.diagrams.elements.grouping;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmGrouping when its representation mode is RepresentationMode.SIMPLE
 */
@objid ("e311eab7-4274-46c8-90ad-0270bcafa376")
public class GmGroupingSimpleStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("5a2ec150-40fd-47f9-8eb2-6e78d943c54c")
    static final StyleKey REPMODE = GmGroupingStructuredStyleKeys.REPMODE;

    @objid ("e4a1506d-3882-4cc8-93e3-3bfc1acc3ef7")
    static final StyleKey FILLCOLOR = GmGroupingStructuredStyleKeys.FILLCOLOR;

    @objid ("c1a874d1-23bb-4ce6-81bd-5afb166bdc84")
    static final StyleKey FILLMODE = GmGroupingStructuredStyleKeys.FILLMODE;

    @objid ("aed7bf69-dda1-4ab9-b9ac-878aad4503d2")
    static final StyleKey LINECOLOR = GmGroupingStructuredStyleKeys.LINECOLOR;

    @objid ("bfd1f91d-7f7d-42e5-a1fe-1908602bc9fe")
    static final StyleKey LINEWIDTH = GmGroupingStructuredStyleKeys.LINEWIDTH;

    @objid ("fd1af9e7-b664-45f6-98f8-22182c737ade")
    static final StyleKey FONT = GmGroupingStructuredStyleKeys.FONT;

    @objid ("48145d37-e010-4cef-a0e1-b1e9aab42c6a")
    static final StyleKey TEXTCOLOR = GmGroupingStructuredStyleKeys.TEXTCOLOR;

    @objid ("5d0b9032-7404-457b-af80-38bbaac15d17")
    static final StyleKey SHOWSTEREOTYPES = GmGroupingStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("4470e593-33f7-4e3d-b859-7a397f9fb9c2")
    static final StyleKey SHOWTAGS = GmGroupingStructuredStyleKeys.SHOWTAGS;

}

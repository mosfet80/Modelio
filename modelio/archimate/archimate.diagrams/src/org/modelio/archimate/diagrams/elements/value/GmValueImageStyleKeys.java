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
package org.modelio.archimate.diagrams.elements.value;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmValue when its representation mode is RepresentationMode.IMAGE
 */
@objid ("eccd3e38-2801-4d5b-967e-a0330c7199cd")
public class GmValueImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("c4652368-1e60-4f8e-84ed-2392e96ae42a")
    static final StyleKey REPMODE = GmValueStructuredStyleKeys.REPMODE;

    @objid ("c5fff85c-c7e5-4b3b-a687-6b3a7a5ceabd")
    static final StyleKey FONT = GmValueStructuredStyleKeys.FONT;

    @objid ("a7006b96-144c-47be-a418-8c6e3f4a3a72")
    static final StyleKey TEXTCOLOR = GmValueStructuredStyleKeys.TEXTCOLOR;

    @objid ("7915efea-f053-4522-8bd7-c56338b5fb00")
    static final StyleKey SHOWSTEREOTYPES = GmValueStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("3df38397-3984-49ec-ac4f-a378022b85f1")
    static final StyleKey SHOWTAGS = GmValueStructuredStyleKeys.SHOWTAGS;

}

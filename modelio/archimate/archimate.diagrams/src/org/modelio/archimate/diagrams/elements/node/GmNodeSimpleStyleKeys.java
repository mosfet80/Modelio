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
package org.modelio.archimate.diagrams.elements.node;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmNode when its representation mode is RepresentationMode.SIMPLE
 */
@objid ("9dcc70b0-1a9d-4afc-a3f3-f164325b6dd6")
public class GmNodeSimpleStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("7ab8dfea-b59c-44f4-b765-356dc063bb5b")
    static final StyleKey REPMODE = GmNodeStructuredStyleKeys.REPMODE;

    @objid ("38a34367-a76d-442e-9143-7ce1356e169a")
    static final StyleKey FILLCOLOR = GmNodeStructuredStyleKeys.FILLCOLOR;

    @objid ("6ccfb0a2-0c79-44c4-a913-da2c6c5aa59b")
    static final StyleKey FILLMODE = GmNodeStructuredStyleKeys.FILLMODE;

    @objid ("ec632081-11f7-4660-99e0-af8118196a45")
    static final StyleKey LINECOLOR = GmNodeStructuredStyleKeys.LINECOLOR;

    @objid ("f35c30de-5ed3-4f03-861e-43a93c3ccb83")
    static final StyleKey LINEWIDTH = GmNodeStructuredStyleKeys.LINEWIDTH;

    @objid ("e59c398a-25fb-42ae-8117-f844b37691b2")
    static final StyleKey FONT = GmNodeStructuredStyleKeys.FONT;

    @objid ("20453c25-a526-41b8-977e-76a6521704e9")
    static final StyleKey TEXTCOLOR = GmNodeStructuredStyleKeys.TEXTCOLOR;

    @objid ("b09a73b5-7b24-410d-ad19-c65d9fcda38c")
    static final StyleKey SHOWSTEREOTYPES = GmNodeStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("d06aa955-0b70-4f73-ae62-0dca2b8b7418")
    static final StyleKey SHOWTAGS = GmNodeStructuredStyleKeys.SHOWTAGS;

}

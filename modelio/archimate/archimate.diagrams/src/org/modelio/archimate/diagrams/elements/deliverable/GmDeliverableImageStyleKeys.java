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
package org.modelio.archimate.diagrams.elements.deliverable;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmDeliverable when its representation mode is RepresentationMode.IMAGE
 */
@objid ("590deb0f-e408-409c-9739-c531c2569dd1")
public class GmDeliverableImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("e36c5397-fe26-45b7-a23d-124dfdc0a9a3")
    static final StyleKey REPMODE = GmDeliverableStructuredStyleKeys.REPMODE;

    @objid ("74d28870-b47e-48d5-ac5d-1d095205c7e2")
    static final StyleKey FONT = GmDeliverableStructuredStyleKeys.FONT;

    @objid ("1fcfafd7-d088-4aaf-b6e9-c367d0886432")
    static final StyleKey TEXTCOLOR = GmDeliverableStructuredStyleKeys.TEXTCOLOR;

    @objid ("598c25a6-c11d-4567-a51e-2b4a540ba8bf")
    static final StyleKey SHOWSTEREOTYPES = GmDeliverableStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("3f9f83d3-8275-4185-ab29-5dfea49d6588")
    static final StyleKey SHOWTAGS = GmDeliverableStructuredStyleKeys.SHOWTAGS;

}

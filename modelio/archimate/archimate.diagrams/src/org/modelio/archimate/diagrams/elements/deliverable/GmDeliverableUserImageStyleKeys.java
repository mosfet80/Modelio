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
@objid ("4063a43d-f818-496e-a87a-13e31b9ac402")
public class GmDeliverableUserImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("1e9f5ba8-70d5-4590-bfe1-4430bd057966")
    static final StyleKey REPMODE = GmDeliverableStructuredStyleKeys.REPMODE;

    @objid ("f3745079-1d74-4109-a799-fdf571177480")
    static final StyleKey FONT = GmDeliverableStructuredStyleKeys.FONT;

    @objid ("d33a317b-bee3-4f80-a61b-c890bb74323b")
    static final StyleKey TEXTCOLOR = GmDeliverableStructuredStyleKeys.TEXTCOLOR;

    @objid ("4815609c-01bd-4869-9721-facae0328db1")
    static final StyleKey SHOWSTEREOTYPES = GmDeliverableStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("9e6dde2c-9917-43fe-bc71-327746b34b60")
    static final StyleKey SHOWTAGS = GmDeliverableStructuredStyleKeys.SHOWTAGS;

}

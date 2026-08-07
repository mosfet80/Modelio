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
 * This class provides the StyleKey constants for a GmDeliverable when its representation mode is RepresentationMode.SIMPLE
 */
@objid ("c1606878-9662-4ce9-a089-da4360168a43")
public class GmDeliverableSimpleStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("eae7ada6-7290-43c7-8608-f671d59e714a")
    static final StyleKey REPMODE = GmDeliverableStructuredStyleKeys.REPMODE;

    @objid ("e79939ba-23d2-4a25-a05e-c335e900c2e9")
    static final StyleKey FILLCOLOR = GmDeliverableStructuredStyleKeys.FILLCOLOR;

    @objid ("74993b3f-e23e-4e1d-93f2-00c24149c0f1")
    static final StyleKey FILLMODE = GmDeliverableStructuredStyleKeys.FILLMODE;

    @objid ("4f1e5b22-4184-497a-9436-4c2672de6c9c")
    static final StyleKey LINECOLOR = GmDeliverableStructuredStyleKeys.LINECOLOR;

    @objid ("ee442002-9be6-4703-bb6b-be43962b7e9d")
    static final StyleKey LINEWIDTH = GmDeliverableStructuredStyleKeys.LINEWIDTH;

    @objid ("2abb31a3-a276-492c-be74-f5bf0c28ef37")
    static final StyleKey FONT = GmDeliverableStructuredStyleKeys.FONT;

    @objid ("97b6a7f9-7cb8-4fe9-a726-002e42bca8c3")
    static final StyleKey TEXTCOLOR = GmDeliverableStructuredStyleKeys.TEXTCOLOR;

    @objid ("07850dc7-310d-4cab-9433-64dbc8723dd7")
    static final StyleKey SHOWSTEREOTYPES = GmDeliverableStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("e27e5bac-65f5-4693-b66e-9046aad7f2f4")
    static final StyleKey SHOWTAGS = GmDeliverableStructuredStyleKeys.SHOWTAGS;

}

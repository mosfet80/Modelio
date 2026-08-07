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
package org.modelio.archimate.diagrams.elements.dataobject;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmDataObject when its representation mode is RepresentationMode.SIMPLE
 */
@objid ("af6dd269-d810-40d2-9894-15470a028f82")
public class GmDataObjectSimpleStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("3a5902d7-b83c-42d9-811b-09ca8333d291")
    static final StyleKey REPMODE = GmDataObjectStructuredStyleKeys.REPMODE;

    @objid ("aded085f-bca4-497e-ab55-c4d11bd91000")
    static final StyleKey FILLCOLOR = GmDataObjectStructuredStyleKeys.FILLCOLOR;

    @objid ("974d34c9-6c89-477f-a8ad-bfb76ed621dd")
    static final StyleKey FILLMODE = GmDataObjectStructuredStyleKeys.FILLMODE;

    @objid ("53fd09c6-2601-45b1-b244-9443981aeb70")
    static final StyleKey LINECOLOR = GmDataObjectStructuredStyleKeys.LINECOLOR;

    @objid ("d5944dad-d6c4-4373-96ae-bb4377c5be08")
    static final StyleKey LINEWIDTH = GmDataObjectStructuredStyleKeys.LINEWIDTH;

    @objid ("95334b58-c21a-441f-bea7-ebe5abed832d")
    static final StyleKey FONT = GmDataObjectStructuredStyleKeys.FONT;

    @objid ("36d884d5-b585-48ec-849b-c57b903862e2")
    static final StyleKey TEXTCOLOR = GmDataObjectStructuredStyleKeys.TEXTCOLOR;

    @objid ("9d4cdc71-a84c-4219-9844-01a459d1cddb")
    static final StyleKey SHOWSTEREOTYPES = GmDataObjectStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("9a176b0a-72c2-4fb7-a32d-b9c5a6b4a927")
    static final StyleKey SHOWTAGS = GmDataObjectStructuredStyleKeys.SHOWTAGS;

}

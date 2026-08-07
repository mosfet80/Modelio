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
package org.modelio.archimate.diagrams.elements.applicationevent;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmApplicationEvent when its representation mode is RepresentationMode.IMAGE
 */
@objid ("36a4cd7b-a142-4da6-a36f-60cd8f883fce")
public class GmApplicationEventImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("090ccb00-23f6-4ee1-b3aa-f988a7a95882")
    static final StyleKey REPMODE = GmApplicationEventStructuredStyleKeys.REPMODE;

    @objid ("48a61e9e-bfce-4a3d-8bd5-95847d042773")
    static final StyleKey FONT = GmApplicationEventStructuredStyleKeys.FONT;

    @objid ("bd447273-cb53-4792-b211-15546e3578ad")
    static final StyleKey TEXTCOLOR = GmApplicationEventStructuredStyleKeys.TEXTCOLOR;

    @objid ("8c7011d8-8fe2-42d7-8f46-02272c5ca2a4")
    static final StyleKey SHOWSTEREOTYPES = GmApplicationEventStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("66d477d6-ef6a-4499-a536-d7ecbbc07d1e")
    static final StyleKey SHOWTAGS = GmApplicationEventStructuredStyleKeys.SHOWTAGS;

}

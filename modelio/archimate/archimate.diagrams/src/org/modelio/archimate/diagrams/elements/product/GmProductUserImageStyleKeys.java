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
package org.modelio.archimate.diagrams.elements.product;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmProduct when its representation mode is RepresentationMode.IMAGE
 */
@objid ("69464fec-6d60-41a1-ad80-419e1096f669")
public class GmProductUserImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("df12caba-d34f-4848-a121-d926e01712ad")
    static final StyleKey REPMODE = GmProductStructuredStyleKeys.REPMODE;

    @objid ("165bf14d-1a32-462e-9990-3437b1779355")
    static final StyleKey FONT = GmProductStructuredStyleKeys.FONT;

    @objid ("ebe46eb2-6152-4c3f-88cf-8ee3d66f6bf1")
    static final StyleKey TEXTCOLOR = GmProductStructuredStyleKeys.TEXTCOLOR;

    @objid ("3177ada7-9d9a-49df-8e8d-e91920bae244")
    static final StyleKey SHOWSTEREOTYPES = GmProductStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("c6d7b7ad-509d-4efc-a51c-ba0b73c6a925")
    static final StyleKey SHOWTAGS = GmProductStructuredStyleKeys.SHOWTAGS;

}

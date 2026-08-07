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
package org.modelio.archimate.diagrams.elements.outcome;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmOutcome when its representation mode is RepresentationMode.IMAGE
 */
@objid ("6e6d7be2-9aeb-480c-be43-359046fd8d6e")
public class GmOutcomeImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("2580653e-e37b-4c15-9344-6c0393a54b97")
    static final StyleKey REPMODE = GmOutcomeStructuredStyleKeys.REPMODE;

    @objid ("817ca879-c79f-4c35-917d-83ba3949ce1d")
    static final StyleKey FONT = GmOutcomeStructuredStyleKeys.FONT;

    @objid ("2d96b7c2-c222-428b-8183-717df75d6269")
    static final StyleKey TEXTCOLOR = GmOutcomeStructuredStyleKeys.TEXTCOLOR;

    @objid ("d369dd4b-8b2f-45dd-a353-6213d185a2f0")
    static final StyleKey SHOWSTEREOTYPES = GmOutcomeStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("0c2d1d8a-4777-4edd-8407-618744647cd5")
    static final StyleKey SHOWTAGS = GmOutcomeStructuredStyleKeys.SHOWTAGS;

}

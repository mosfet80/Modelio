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
@objid ("e97004a3-2584-4f82-bd5b-468ce698a729")
public class GmOutcomeUserImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("105cd6bd-55a0-40db-8ea2-c4e6b8caa4b1")
    static final StyleKey REPMODE = GmOutcomeStructuredStyleKeys.REPMODE;

    @objid ("0a188506-5fac-4a2e-968f-d1850b9498e0")
    static final StyleKey FONT = GmOutcomeStructuredStyleKeys.FONT;

    @objid ("d225af54-3231-428a-9424-2a5b1a1fd9f3")
    static final StyleKey TEXTCOLOR = GmOutcomeStructuredStyleKeys.TEXTCOLOR;

    @objid ("caf8344f-b1ad-48f7-9565-2362e9de4867")
    static final StyleKey SHOWSTEREOTYPES = GmOutcomeStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("e69bbdf7-f580-4366-83d4-1a171d91bcbc")
    static final StyleKey SHOWTAGS = GmOutcomeStructuredStyleKeys.SHOWTAGS;

}

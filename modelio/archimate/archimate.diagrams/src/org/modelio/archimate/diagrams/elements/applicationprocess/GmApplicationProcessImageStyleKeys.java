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
package org.modelio.archimate.diagrams.elements.applicationprocess;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmApplicationProcess when its representation mode is RepresentationMode.IMAGE
 */
@objid ("0693e82c-3ba1-439a-82be-215f466c3b90")
public class GmApplicationProcessImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("667888c6-b276-4c37-81b3-5ea67861ed85")
    static final StyleKey REPMODE = GmApplicationProcessStructuredStyleKeys.REPMODE;

    @objid ("e560e5d6-dc3d-42b6-92fe-c59e9d91410a")
    static final StyleKey FONT = GmApplicationProcessStructuredStyleKeys.FONT;

    @objid ("06685564-0969-4563-8506-e2c3c5705219")
    static final StyleKey TEXTCOLOR = GmApplicationProcessStructuredStyleKeys.TEXTCOLOR;

    @objid ("a604630b-1fe4-4e8f-b0d7-6595fa885dd0")
    static final StyleKey SHOWSTEREOTYPES = GmApplicationProcessStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("75753163-9c55-42c5-a3b2-168411e68984")
    static final StyleKey SHOWTAGS = GmApplicationProcessStructuredStyleKeys.SHOWTAGS;

}

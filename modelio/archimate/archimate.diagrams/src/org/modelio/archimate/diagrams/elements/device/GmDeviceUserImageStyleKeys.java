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
package org.modelio.archimate.diagrams.elements.device;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmDevice when its representation mode is RepresentationMode.IMAGE
 */
@objid ("5f4b7003-5c89-42e0-99c0-f26cb78be79f")
public class GmDeviceUserImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("e74e6e0c-1035-43e8-ac79-95eea1455664")
    static final StyleKey REPMODE = GmDeviceStructuredStyleKeys.REPMODE;

    @objid ("a10de266-54ad-4e38-8ad3-f5d1cb247cdf")
    static final StyleKey FONT = GmDeviceStructuredStyleKeys.FONT;

    @objid ("56d29daa-17d0-48f9-a101-350455c23394")
    static final StyleKey TEXTCOLOR = GmDeviceStructuredStyleKeys.TEXTCOLOR;

    @objid ("b3bd33fe-91f1-411b-9c3b-f95c9924711b")
    static final StyleKey SHOWSTEREOTYPES = GmDeviceStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("8092ddb9-711c-47a0-8994-318bea905257")
    static final StyleKey SHOWTAGS = GmDeviceStructuredStyleKeys.SHOWTAGS;

}

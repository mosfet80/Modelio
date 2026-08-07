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
package org.modelio.archimate.diagrams.elements.businessactor;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmBusinessActor when its representation mode is RepresentationMode.IMAGE
 */
@objid ("eb75a50f-e7d4-47ce-93d9-67fe5057902c")
public class GmBusinessActorUserImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("8612e240-b7a3-4345-85e5-e0991c6b5abd")
    static final StyleKey REPMODE = GmBusinessActorStructuredStyleKeys.REPMODE;

    @objid ("29000722-c667-4e5a-abcd-50f50ea5c97a")
    static final StyleKey FONT = GmBusinessActorStructuredStyleKeys.FONT;

    @objid ("70231940-1c02-4a1e-973d-50def49e9943")
    static final StyleKey TEXTCOLOR = GmBusinessActorStructuredStyleKeys.TEXTCOLOR;

    @objid ("1aafee6a-c671-45cc-a167-60b95d6161fe")
    static final StyleKey SHOWSTEREOTYPES = GmBusinessActorStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("1e2c9c41-852a-42fd-936a-1d8f8da50551")
    static final StyleKey SHOWTAGS = GmBusinessActorStructuredStyleKeys.SHOWTAGS;

}

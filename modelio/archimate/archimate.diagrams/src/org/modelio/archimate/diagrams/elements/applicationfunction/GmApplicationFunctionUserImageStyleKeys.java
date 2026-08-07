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
package org.modelio.archimate.diagrams.elements.applicationfunction;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmApplicationFunction when its representation mode is RepresentationMode.IMAGE
 */
@objid ("e891390c-9e58-4b40-ad9f-644774ed222f")
public class GmApplicationFunctionUserImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("66e034c6-edf6-46e6-91c4-f6326424032c")
    static final StyleKey REPMODE = GmApplicationFunctionStructuredStyleKeys.REPMODE;

    @objid ("00f0e2e8-c25d-4f1f-9b0c-5c89f0281553")
    static final StyleKey FONT = GmApplicationFunctionStructuredStyleKeys.FONT;

    @objid ("d6edd0df-5672-4a21-9a27-f9d8da0bb677")
    static final StyleKey TEXTCOLOR = GmApplicationFunctionStructuredStyleKeys.TEXTCOLOR;

    @objid ("c51c462e-e307-45ac-b352-3c41ccef47aa")
    static final StyleKey SHOWSTEREOTYPES = GmApplicationFunctionStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("d1a337cb-b711-4214-955a-161fbb6fc95e")
    static final StyleKey SHOWTAGS = GmApplicationFunctionStructuredStyleKeys.SHOWTAGS;

}

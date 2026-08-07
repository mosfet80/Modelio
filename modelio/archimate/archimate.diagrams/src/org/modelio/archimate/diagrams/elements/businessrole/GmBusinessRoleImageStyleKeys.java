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
package org.modelio.archimate.diagrams.elements.businessrole;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmBusinessRole when its representation mode is RepresentationMode.IMAGE
 */
@objid ("fd026352-3a56-4f3c-ad6c-be0d046da49d")
public class GmBusinessRoleImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("10780380-0cec-439f-b154-829dd35775f1")
    static final StyleKey REPMODE = GmBusinessRoleStructuredStyleKeys.REPMODE;

    @objid ("7118b115-d271-4886-a510-fb35186397d0")
    static final StyleKey FONT = GmBusinessRoleStructuredStyleKeys.FONT;

    @objid ("2dff65c4-6254-403c-a84b-d425872f3731")
    static final StyleKey TEXTCOLOR = GmBusinessRoleStructuredStyleKeys.TEXTCOLOR;

    @objid ("084ade1c-b0f1-47c2-97e9-40806fa2e470")
    static final StyleKey SHOWSTEREOTYPES = GmBusinessRoleStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("3c568bf4-1540-4681-9642-f794e6d21cf8")
    static final StyleKey SHOWTAGS = GmBusinessRoleStructuredStyleKeys.SHOWTAGS;

}

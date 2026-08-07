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
@objid ("013007c7-23f1-48db-b338-01b4434240e6")
public class GmBusinessRoleUserImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("e159d93c-ad98-4d22-8df4-2e8efbd210aa")
    static final StyleKey REPMODE = GmBusinessRoleStructuredStyleKeys.REPMODE;

    @objid ("0a14c51b-8ef0-417f-b663-13726d958abb")
    static final StyleKey FONT = GmBusinessRoleStructuredStyleKeys.FONT;

    @objid ("daa4b902-ca81-48d1-9a83-667fcb5ba950")
    static final StyleKey TEXTCOLOR = GmBusinessRoleStructuredStyleKeys.TEXTCOLOR;

    @objid ("76e61ea7-7a5e-4e74-b0a2-ad6d99fadacd")
    static final StyleKey SHOWSTEREOTYPES = GmBusinessRoleStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("6e71b69f-3705-4ecc-8327-7ee09af3a66c")
    static final StyleKey SHOWTAGS = GmBusinessRoleStructuredStyleKeys.SHOWTAGS;

}

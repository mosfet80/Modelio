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
package org.modelio.archimate.diagrams.elements.businessinterface;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmBusinessInterface when its representation mode is RepresentationMode.IMAGE
 */
@objid ("85c8424e-b1da-4704-b478-31116c30c303")
public class GmBusinessInterfaceUserImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("b748bbab-997e-49fb-baed-62f3795cbe01")
    static final StyleKey REPMODE = GmBusinessInterfaceStructuredStyleKeys.REPMODE;

    @objid ("8ebbd771-90d6-4758-85c5-52e6b9d96992")
    static final StyleKey FONT = GmBusinessInterfaceStructuredStyleKeys.FONT;

    @objid ("afcda3e0-6540-455e-8ffa-835bbb9d5ef5")
    static final StyleKey TEXTCOLOR = GmBusinessInterfaceStructuredStyleKeys.TEXTCOLOR;

    @objid ("1cae96cd-5ebd-45c7-9121-7c1292a5bed6")
    static final StyleKey SHOWSTEREOTYPES = GmBusinessInterfaceStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("30611aeb-3b69-4568-8abb-104052147e8c")
    static final StyleKey SHOWTAGS = GmBusinessInterfaceStructuredStyleKeys.SHOWTAGS;

}

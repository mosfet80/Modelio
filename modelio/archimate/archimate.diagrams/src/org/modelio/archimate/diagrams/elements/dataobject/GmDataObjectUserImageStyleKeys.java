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
package org.modelio.archimate.diagrams.elements.dataobject;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmDataObject when its representation mode is RepresentationMode.IMAGE
 */
@objid ("f6d88d96-a600-4b1a-82b2-01339c519d2c")
public class GmDataObjectUserImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("fcc91fbd-1a6f-4e75-907a-6bf2f0521e83")
    static final StyleKey REPMODE = GmDataObjectStructuredStyleKeys.REPMODE;

    @objid ("23518d6e-672d-4d90-b0f0-f016d4c0f46b")
    static final StyleKey FONT = GmDataObjectStructuredStyleKeys.FONT;

    @objid ("922eabb6-4af4-4fe1-a619-dfb0366cafbe")
    static final StyleKey TEXTCOLOR = GmDataObjectStructuredStyleKeys.TEXTCOLOR;

    @objid ("75711391-4ed7-4c7e-bddd-08f2f2faf05d")
    static final StyleKey SHOWSTEREOTYPES = GmDataObjectStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("7a341fd9-1761-42c7-be76-1240e36830f7")
    static final StyleKey SHOWTAGS = GmDataObjectStructuredStyleKeys.SHOWTAGS;

}

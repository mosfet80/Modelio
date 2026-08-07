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
package org.modelio.archimate.diagrams.elements.applicationcomponent;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmApplicationComponent when its representation mode is RepresentationMode.IMAGE
 */
@objid ("f24582e8-83e9-42c4-9d87-64cf18be6889")
public class GmApplicationComponentImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("48b73dd2-06f3-42ac-b051-0afc55401900")
    static final StyleKey REPMODE = GmApplicationComponentStructuredStyleKeys.REPMODE;

    @objid ("ce780569-ebd5-49aa-94e5-844be9495e03")
    static final StyleKey FONT = GmApplicationComponentStructuredStyleKeys.FONT;

    @objid ("38149c63-624c-4672-bf76-973f2928e37c")
    static final StyleKey TEXTCOLOR = GmApplicationComponentStructuredStyleKeys.TEXTCOLOR;

    @objid ("eb20efff-9312-45e6-b9c0-0e1a43902b0b")
    static final StyleKey SHOWSTEREOTYPES = GmApplicationComponentStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("cb73ba19-4c54-4dad-a01e-602227c1746f")
    static final StyleKey SHOWTAGS = GmApplicationComponentStructuredStyleKeys.SHOWTAGS;

}

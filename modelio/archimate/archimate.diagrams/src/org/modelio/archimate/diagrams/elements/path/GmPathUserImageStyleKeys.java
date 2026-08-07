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
package org.modelio.archimate.diagrams.elements.path;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmPath when its representation mode is RepresentationMode.IMAGE
 */
@objid ("f7b94787-88b6-4017-be0d-92da7fc5452f")
public class GmPathUserImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("4ecd8e83-d947-4c25-8eca-22c25fd3e6fe")
    static final StyleKey REPMODE = GmPathStructuredStyleKeys.REPMODE;

    @objid ("bdb8cb01-2466-433a-be34-c4ccaec4dc94")
    static final StyleKey FONT = GmPathStructuredStyleKeys.FONT;

    @objid ("16c2f7c0-23c4-498b-9f54-6268e1ab3e65")
    static final StyleKey TEXTCOLOR = GmPathStructuredStyleKeys.TEXTCOLOR;

    @objid ("0669995b-2933-4984-ab85-49bf1cdb563d")
    static final StyleKey SHOWSTEREOTYPES = GmPathStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("629e5f8a-d8e1-48b3-a371-dcd7c2ce8f5c")
    static final StyleKey SHOWTAGS = GmPathStructuredStyleKeys.SHOWTAGS;

}

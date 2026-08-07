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
package org.modelio.archimate.diagrams.elements.systemsoftware;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmSystemSoftware when its representation mode is RepresentationMode.IMAGE
 */
@objid ("8a908061-ee9b-4b53-8c7e-345abbbba2ad")
public class GmSystemSoftwareUserImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("3bfcb056-8dc5-4940-ae00-09b838a84cad")
    static final StyleKey REPMODE = GmSystemSoftwareStructuredStyleKeys.REPMODE;

    @objid ("c017cce2-6727-44d9-b298-7b64392b9262")
    static final StyleKey FONT = GmSystemSoftwareStructuredStyleKeys.FONT;

    @objid ("45bc19b0-b120-4311-9be6-e3c072799101")
    static final StyleKey TEXTCOLOR = GmSystemSoftwareStructuredStyleKeys.TEXTCOLOR;

    @objid ("38e6d7f1-0635-45d9-ae8d-99f644e554e0")
    static final StyleKey SHOWSTEREOTYPES = GmSystemSoftwareStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("f2603400-1e11-4e9a-9a68-6863c926cee2")
    static final StyleKey SHOWTAGS = GmSystemSoftwareStructuredStyleKeys.SHOWTAGS;

}

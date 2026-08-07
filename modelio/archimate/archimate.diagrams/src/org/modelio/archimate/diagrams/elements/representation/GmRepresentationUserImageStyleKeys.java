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
package org.modelio.archimate.diagrams.elements.representation;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmRepresentation when its representation mode is RepresentationMode.IMAGE
 */
@objid ("f7e9466f-5873-46c1-8fbe-27da5d61b3aa")
public class GmRepresentationUserImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("61dd60cf-2f45-47dd-af45-c0a39686298a")
    static final StyleKey REPMODE = GmRepresentationStructuredStyleKeys.REPMODE;

    @objid ("9579c140-755a-4344-91dd-0e57b8d13736")
    static final StyleKey FONT = GmRepresentationStructuredStyleKeys.FONT;

    @objid ("899eff7b-f725-47b4-9d49-02b6dd117863")
    static final StyleKey TEXTCOLOR = GmRepresentationStructuredStyleKeys.TEXTCOLOR;

    @objid ("3ccbf0d5-9a60-4cda-bbd8-1bae2bee7aaf")
    static final StyleKey SHOWSTEREOTYPES = GmRepresentationStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("acbefb8b-4608-483d-996b-bf5077b7f9ae")
    static final StyleKey SHOWTAGS = GmRepresentationStructuredStyleKeys.SHOWTAGS;

}

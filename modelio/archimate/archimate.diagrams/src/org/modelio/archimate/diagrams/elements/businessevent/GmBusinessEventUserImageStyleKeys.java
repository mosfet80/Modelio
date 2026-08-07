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
package org.modelio.archimate.diagrams.elements.businessevent;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmBusinessEvent when its representation mode is RepresentationMode.IMAGE
 */
@objid ("cd6c243f-5ddd-4945-b2b1-d5a4717bccb7")
public class GmBusinessEventUserImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("f8209b62-f4b8-4d7c-aef7-ed10c9e4e8d7")
    static final StyleKey REPMODE = GmBusinessEventStructuredStyleKeys.REPMODE;

    @objid ("cf26a6e0-396b-42a5-b4c1-3e958768d8c2")
    static final StyleKey FONT = GmBusinessEventStructuredStyleKeys.FONT;

    @objid ("5d49b3fb-54b7-4386-b30e-435e2d9affc0")
    static final StyleKey TEXTCOLOR = GmBusinessEventStructuredStyleKeys.TEXTCOLOR;

    @objid ("e7d2f1f9-1773-4ab9-9d72-ee699e02b6d1")
    static final StyleKey SHOWSTEREOTYPES = GmBusinessEventStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("59dae569-7575-4233-8dd3-611932b3083a")
    static final StyleKey SHOWTAGS = GmBusinessEventStructuredStyleKeys.SHOWTAGS;

}

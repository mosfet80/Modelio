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
package org.modelio.archimate.diagrams.elements.product;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmProduct when its representation mode is RepresentationMode.IMAGE
 */
@objid ("b88bf14a-38b3-4f5c-8b73-b2824205fdd2")
public class GmProductImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("9ba35fb7-8121-466d-bc3c-42f410e4f241")
    static final StyleKey REPMODE = GmProductStructuredStyleKeys.REPMODE;

    @objid ("24189723-f9c7-4849-8f90-e6a281b21826")
    static final StyleKey FONT = GmProductStructuredStyleKeys.FONT;

    @objid ("a4eaeb9a-1694-4d1e-9ec6-9a2e5c24643d")
    static final StyleKey TEXTCOLOR = GmProductStructuredStyleKeys.TEXTCOLOR;

    @objid ("333745c5-c953-430c-8682-8872df5ada48")
    static final StyleKey SHOWSTEREOTYPES = GmProductStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("ee23f550-9bd3-4283-891c-a3d658701b92")
    static final StyleKey SHOWTAGS = GmProductStructuredStyleKeys.SHOWTAGS;

}

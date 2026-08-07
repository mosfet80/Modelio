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
package org.modelio.archimate.diagrams.elements.technologyinterface;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmTechnologyInterface when its representation mode is RepresentationMode.IMAGE
 */
@objid ("1ab43af1-0fee-4613-97c9-057549476689")
public class GmTechnologyInterfaceImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("6f981d0e-b5e4-49a7-bdb2-aeae72fc9867")
    static final StyleKey REPMODE = GmTechnologyInterfaceStructuredStyleKeys.REPMODE;

    @objid ("9a65dfbf-7b01-4dc8-b0fc-f89f7b6a9143")
    static final StyleKey FONT = GmTechnologyInterfaceStructuredStyleKeys.FONT;

    @objid ("02e2ed2b-b8d1-4637-bbec-59f4b59ebb4d")
    static final StyleKey TEXTCOLOR = GmTechnologyInterfaceStructuredStyleKeys.TEXTCOLOR;

    @objid ("5543fbe9-02bc-43d3-8d13-58109d499a5d")
    static final StyleKey SHOWSTEREOTYPES = GmTechnologyInterfaceStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("a01fbd2d-0947-4b40-9cfb-181db00b617d")
    static final StyleKey SHOWTAGS = GmTechnologyInterfaceStructuredStyleKeys.SHOWTAGS;

}

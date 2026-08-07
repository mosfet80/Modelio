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
package org.modelio.archimate.diagrams.elements.contract;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmContract when its representation mode is RepresentationMode.SIMPLE
 */
@objid ("d579e2e1-2569-4375-9cc5-0222cc6f8d46")
public class GmContractSimpleStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("1971974b-5400-4a89-8357-4a96f9daca03")
    static final StyleKey REPMODE = GmContractStructuredStyleKeys.REPMODE;

    @objid ("f7500ad4-e71b-4fd5-9661-4d3a01f23bac")
    static final StyleKey FILLCOLOR = GmContractStructuredStyleKeys.FILLCOLOR;

    @objid ("1e7aa6d7-3601-4802-a03f-94be928d0673")
    static final StyleKey FILLMODE = GmContractStructuredStyleKeys.FILLMODE;

    @objid ("d522ab9f-120c-4000-aa25-9f967289d89e")
    static final StyleKey LINECOLOR = GmContractStructuredStyleKeys.LINECOLOR;

    @objid ("a33076fb-be4d-45c1-9f3d-91d39489c0af")
    static final StyleKey LINEWIDTH = GmContractStructuredStyleKeys.LINEWIDTH;

    @objid ("c012aa30-dd22-4a24-a0c3-fc6ac88b2712")
    static final StyleKey FONT = GmContractStructuredStyleKeys.FONT;

    @objid ("69efe51b-d56e-4cda-98b3-7fde0354c467")
    static final StyleKey TEXTCOLOR = GmContractStructuredStyleKeys.TEXTCOLOR;

    @objid ("4c2f4df2-fde9-4a79-a37f-b21102763512")
    static final StyleKey SHOWSTEREOTYPES = GmContractStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("022374a4-ede2-4bae-a11b-be1b432a10fa")
    static final StyleKey SHOWTAGS = GmContractStructuredStyleKeys.SHOWTAGS;

}

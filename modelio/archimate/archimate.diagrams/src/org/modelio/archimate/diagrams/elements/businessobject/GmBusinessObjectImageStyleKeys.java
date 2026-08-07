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
package org.modelio.archimate.diagrams.elements.businessobject;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmBusinessObject when its representation mode is RepresentationMode.IMAGE
 */
@objid ("b46eb3a8-a818-4902-9f2a-bba3c51535da")
public class GmBusinessObjectImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("0f141543-7d21-437f-9be9-ae34c04cc71a")
    static final StyleKey REPMODE = GmBusinessObjectStructuredStyleKeys.REPMODE;

    @objid ("ce3f2582-1f5b-4f90-823c-67a0a8e6a3b3")
    static final StyleKey FONT = GmBusinessObjectStructuredStyleKeys.FONT;

    @objid ("311d785e-1992-49f7-82ca-206448624b44")
    static final StyleKey TEXTCOLOR = GmBusinessObjectStructuredStyleKeys.TEXTCOLOR;

    @objid ("5e6005ba-b366-47f1-8f95-66475767af83")
    static final StyleKey SHOWSTEREOTYPES = GmBusinessObjectStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("16cf0e0f-cf3d-48ac-8637-a7022c02a5be")
    static final StyleKey SHOWTAGS = GmBusinessObjectStructuredStyleKeys.SHOWTAGS;

}

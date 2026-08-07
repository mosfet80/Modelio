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
@objid ("bda7c1f1-7a3e-4579-be1c-ecab51e171c2")
public class GmDataObjectImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("0b8c0bbd-36a5-48b2-880e-c140cecd4ef7")
    static final StyleKey REPMODE = GmDataObjectStructuredStyleKeys.REPMODE;

    @objid ("d3bfaa9b-045a-4aa7-9a10-53577f588dd6")
    static final StyleKey FONT = GmDataObjectStructuredStyleKeys.FONT;

    @objid ("12bd428f-0667-47e0-acb1-4279155954c4")
    static final StyleKey TEXTCOLOR = GmDataObjectStructuredStyleKeys.TEXTCOLOR;

    @objid ("42b1f368-579b-48f2-b6a5-7358063198c6")
    static final StyleKey SHOWSTEREOTYPES = GmDataObjectStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("e3af26e4-5019-466e-9bed-0f28d774bef6")
    static final StyleKey SHOWTAGS = GmDataObjectStructuredStyleKeys.SHOWTAGS;

}

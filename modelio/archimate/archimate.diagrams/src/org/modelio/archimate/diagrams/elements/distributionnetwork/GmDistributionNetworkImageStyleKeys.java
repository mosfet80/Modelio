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
package org.modelio.archimate.diagrams.elements.distributionnetwork;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmDistributionNetwork when its representation mode is RepresentationMode.IMAGE
 */
@objid ("ef2022f6-9806-42d9-a4eb-24ce448bc251")
public class GmDistributionNetworkImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("3f27d4aa-7aaf-4170-9008-973b3db941f5")
    static final StyleKey REPMODE = GmDistributionNetworkStructuredStyleKeys.REPMODE;

    @objid ("142fec8c-817c-4f70-a3da-ae355d5bb408")
    static final StyleKey FONT = GmDistributionNetworkStructuredStyleKeys.FONT;

    @objid ("11c16cef-94a9-4fff-b5d1-7ea0e7248028")
    static final StyleKey TEXTCOLOR = GmDistributionNetworkStructuredStyleKeys.TEXTCOLOR;

    @objid ("2f50d6b3-e144-459f-bbba-d00722313239")
    static final StyleKey SHOWSTEREOTYPES = GmDistributionNetworkStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("0ec9419a-05e4-4d83-9f48-2776498a280e")
    static final StyleKey SHOWTAGS = GmDistributionNetworkStructuredStyleKeys.SHOWTAGS;

}

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
@objid ("651e9dd2-d6f2-4f6d-bba0-317dcb1fee52")
public class GmDistributionNetworkUserImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("c46572dc-8129-4e37-a33e-0ffce2a5a7ea")
    static final StyleKey REPMODE = GmDistributionNetworkStructuredStyleKeys.REPMODE;

    @objid ("83944e2c-9cf4-4286-83c2-602da2097a72")
    static final StyleKey FONT = GmDistributionNetworkStructuredStyleKeys.FONT;

    @objid ("b9fc4918-d3a1-4ab6-a8cc-59e3325ec70b")
    static final StyleKey TEXTCOLOR = GmDistributionNetworkStructuredStyleKeys.TEXTCOLOR;

    @objid ("25017c2b-7343-4d4f-9578-80491833cd48")
    static final StyleKey SHOWSTEREOTYPES = GmDistributionNetworkStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("73dab2ea-8f8f-41a3-92f1-0bf72f35878a")
    static final StyleKey SHOWTAGS = GmDistributionNetworkStructuredStyleKeys.SHOWTAGS;

}

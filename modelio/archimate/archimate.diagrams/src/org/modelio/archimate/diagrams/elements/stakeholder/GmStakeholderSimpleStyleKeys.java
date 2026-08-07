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
package org.modelio.archimate.diagrams.elements.stakeholder;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmStakeholder when its representation mode is RepresentationMode.SIMPLE
 */
@objid ("e548883a-41d4-4ad1-8169-0eb933eff7f9")
public class GmStakeholderSimpleStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("bbec4ad2-f3b3-4738-8392-eb6b29572c97")
    static final StyleKey REPMODE = GmStakeholderStructuredStyleKeys.REPMODE;

    @objid ("1f7ae543-aef7-4086-8dd7-dc5a3e1f63a0")
    static final StyleKey FILLCOLOR = GmStakeholderStructuredStyleKeys.FILLCOLOR;

    @objid ("0306d890-9cb9-4b66-80fc-d465775560e1")
    static final StyleKey FILLMODE = GmStakeholderStructuredStyleKeys.FILLMODE;

    @objid ("f4592542-ad04-484d-baa2-5ec4554c2493")
    static final StyleKey LINECOLOR = GmStakeholderStructuredStyleKeys.LINECOLOR;

    @objid ("f0fc208f-dfb0-4438-acf1-9f344189c079")
    static final StyleKey LINEWIDTH = GmStakeholderStructuredStyleKeys.LINEWIDTH;

    @objid ("65737530-7b8a-4e61-9ef4-72d7c3541607")
    static final StyleKey FONT = GmStakeholderStructuredStyleKeys.FONT;

    @objid ("10d8554d-3d9d-4242-b789-29c92ff4c166")
    static final StyleKey TEXTCOLOR = GmStakeholderStructuredStyleKeys.TEXTCOLOR;

    @objid ("991bd18f-b59e-4f45-b442-8d22604979e2")
    static final StyleKey SHOWSTEREOTYPES = GmStakeholderStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("c4e847f5-c3f9-4df6-a0ce-2b2dec8241e4")
    static final StyleKey SHOWTAGS = GmStakeholderStructuredStyleKeys.SHOWTAGS;

}

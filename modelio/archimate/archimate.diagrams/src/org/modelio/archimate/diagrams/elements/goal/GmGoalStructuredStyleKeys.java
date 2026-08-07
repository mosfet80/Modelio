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
package org.modelio.archimate.diagrams.elements.goal;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmGoal when its representation mode is RepresentationMode.STRUCTURED
 */
@objid ("ad1de3a3-df01-4618-b774-311d1b63c906")
public class GmGoalStructuredStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("830afe40-7da0-4732-8c5c-9b0fcd35d812")
    static final StyleKey REPMODE = createStyleKey("ARCHIMATE_GOAL_REPMODE", MetaKey.REPMODE);

    @objid ("4783ac61-3380-4c7f-be7d-f5a6f19337e1")
    static final StyleKey FILLCOLOR = createStyleKey("ARCHIMATE_GOAL_FILLCOLOR", MetaKey.FILLCOLOR);

    @objid ("e0507dbd-e6fe-4a6a-ad81-a1bd46585ec9")
    static final StyleKey FILLMODE = createStyleKey("ARCHIMATE_GOAL_FILLMODE", MetaKey.FILLMODE);

    @objid ("6271f563-696f-4899-84b5-ff7266c22cec")
    static final StyleKey LINECOLOR = createStyleKey("ARCHIMATE_GOAL_LINECOLOR", MetaKey.LINECOLOR);

    @objid ("4bb8a3af-2e85-4241-8c67-f1165f397426")
    static final StyleKey LINEWIDTH = createStyleKey("ARCHIMATE_GOAL_LINEWIDTH", MetaKey.LINEWIDTH);

    @objid ("390bcda2-8cc1-4877-ad11-4ea8be74ef6c")
    static final StyleKey FONT = createStyleKey("ARCHIMATE_GOAL_FONT", MetaKey.FONT);

    @objid ("dc9d4f19-8f7e-4170-b8f1-12bc0f4dfe93")
    static final StyleKey TEXTCOLOR = createStyleKey("ARCHIMATE_GOAL_TEXTCOLOR", MetaKey.TEXTCOLOR);

    @objid ("7d6650dc-e0e6-4217-962f-66f40ec2bb5c")
    static final StyleKey SHOWSTEREOTYPES = createStyleKey("ARCHIMATE_GOAL_SHOWSTEREOTYPES", MetaKey.SHOWSTEREOTYPES);

    @objid ("971092c4-6115-42e6-b303-13ccf3ff79c4")
    static final StyleKey SHOWTAGS = createStyleKey("ARCHIMATE_GOAL_SHOWTAGS", MetaKey.SHOWTAGS);

}

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
package org.modelio.archimate.diagrams.elements.outcome;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmOutcome when its representation mode is RepresentationMode.STRUCTURED
 */
@objid ("88665663-1b95-4fdd-a479-3c4d018c3711")
public class GmOutcomeStructuredStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("abbc128d-c78d-4588-b040-13d09c79fa6e")
    static final StyleKey REPMODE = createStyleKey("OUTCOME_REPMODE", MetaKey.REPMODE);

    @objid ("893c39b6-31a8-475d-ac7c-e89d61474d55")
    static final StyleKey FILLCOLOR = createStyleKey("OUTCOME_FILLCOLOR", MetaKey.FILLCOLOR);

    @objid ("e0a5dc0a-7b04-411e-832f-b5ac821d69a4")
    static final StyleKey FILLMODE = createStyleKey("OUTCOME_FILLMODE", MetaKey.FILLMODE);

    @objid ("5c4f3eff-1b10-4afe-841f-384496c494d9")
    static final StyleKey LINECOLOR = createStyleKey("OUTCOME_LINECOLOR", MetaKey.LINECOLOR);

    @objid ("0d259519-3ce2-4cd0-91ab-cb8f3d8f4b22")
    static final StyleKey LINEWIDTH = createStyleKey("OUTCOME_LINEWIDTH", MetaKey.LINEWIDTH);

    @objid ("7b7d51c3-79a5-4f4c-a169-91f1c43915bf")
    static final StyleKey FONT = createStyleKey("OUTCOME_FONT", MetaKey.FONT);

    @objid ("88bc9d59-c33c-456b-b4a2-d81d52ba80b7")
    static final StyleKey TEXTCOLOR = createStyleKey("OUTCOME_TEXTCOLOR", MetaKey.TEXTCOLOR);

    @objid ("654053a3-4e42-4c13-a5ad-2f8e88e13cd5")
    static final StyleKey SHOWSTEREOTYPES = createStyleKey("OUTCOME_SHOWSTEREOTYPES", MetaKey.SHOWSTEREOTYPES);

    @objid ("07715ea9-0c44-4677-8ebf-d1d15ce5c16f")
    static final StyleKey SHOWTAGS = createStyleKey("OUTCOME_SHOWTAGS", MetaKey.SHOWTAGS);

}

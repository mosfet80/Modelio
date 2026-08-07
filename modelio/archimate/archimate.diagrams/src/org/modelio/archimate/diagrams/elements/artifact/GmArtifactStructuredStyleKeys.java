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
package org.modelio.archimate.diagrams.elements.artifact;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmArtifact when its representation mode is RepresentationMode.STRUCTURED
 */
@objid ("c42ce765-5cfe-49de-b83d-2b1e249efa59")
public class GmArtifactStructuredStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("064632c4-7ead-4f37-8ec3-3747aa27ca44")
    static final StyleKey REPMODE = createStyleKey("ARCHIMATE_ARTIFACT_REPMODE", MetaKey.REPMODE);

    @objid ("ad6d0c17-94f1-48f8-a8c9-4c72308de520")
    static final StyleKey FILLCOLOR = createStyleKey("ARCHIMATE_ARTIFACT_FILLCOLOR", MetaKey.FILLCOLOR);

    @objid ("4bcc5f20-922e-46c7-a0eb-a6fcb84d70c7")
    static final StyleKey FILLMODE = createStyleKey("ARCHIMATE_ARTIFACT_FILLMODE", MetaKey.FILLMODE);

    @objid ("8a4c3d58-6322-4965-8aff-a7b379e0c53d")
    static final StyleKey LINECOLOR = createStyleKey("ARCHIMATE_ARTIFACT_LINECOLOR", MetaKey.LINECOLOR);

    @objid ("117dd054-34e3-4450-aca1-7d35000e9d0a")
    static final StyleKey LINEWIDTH = createStyleKey("ARCHIMATE_ARTIFACT_LINEWIDTH", MetaKey.LINEWIDTH);

    @objid ("3ee0b3d7-51b4-47b7-9dee-39536a65a125")
    static final StyleKey FONT = createStyleKey("ARCHIMATE_ARTIFACT_FONT", MetaKey.FONT);

    @objid ("f1116fc6-5611-445b-9f27-40ae985c6869")
    static final StyleKey TEXTCOLOR = createStyleKey("ARCHIMATE_ARTIFACT_TEXTCOLOR", MetaKey.TEXTCOLOR);

    @objid ("05a57038-6785-4282-987e-39301d25ca81")
    static final StyleKey SHOWSTEREOTYPES = createStyleKey("ARCHIMATE_ARTIFACT_SHOWSTEREOTYPES", MetaKey.SHOWSTEREOTYPES);

    @objid ("3e97d05f-4b37-43d2-8214-d839b0282e9b")
    static final StyleKey SHOWTAGS = createStyleKey("ARCHIMATE_ARTIFACT_SHOWTAGS", MetaKey.SHOWTAGS);

}

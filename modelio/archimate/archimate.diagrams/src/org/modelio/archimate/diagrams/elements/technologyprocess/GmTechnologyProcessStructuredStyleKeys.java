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
package org.modelio.archimate.diagrams.elements.technologyprocess;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmTechnologyProcess when its representation mode is RepresentationMode.STRUCTURED
 */
@objid ("147ae6e4-94b0-461a-a9bd-63131089be65")
public class GmTechnologyProcessStructuredStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("3031e409-8195-4bda-b655-34a410f84723")
    static final StyleKey REPMODE = createStyleKey("TECHNOLOGYPROCESS_REPMODE", MetaKey.REPMODE);

    @objid ("246c83ce-2657-462c-866e-1c36119c7369")
    static final StyleKey FILLCOLOR = createStyleKey("TECHNOLOGYPROCESS_FILLCOLOR", MetaKey.FILLCOLOR);

    @objid ("a7980667-7d31-44a4-abce-d76fd7bc569d")
    static final StyleKey FILLMODE = createStyleKey("TECHNOLOGYPROCESS_FILLMODE", MetaKey.FILLMODE);

    @objid ("0664d908-a4d1-4100-9101-ca4b4ec50f46")
    static final StyleKey LINECOLOR = createStyleKey("TECHNOLOGYPROCESS_LINECOLOR", MetaKey.LINECOLOR);

    @objid ("6d0fcd91-f22f-4a20-8170-e374f03746d6")
    static final StyleKey LINEWIDTH = createStyleKey("TECHNOLOGYPROCESS_LINEWIDTH", MetaKey.LINEWIDTH);

    @objid ("43cb0aa5-9c1d-46b5-90c6-eff366a4944e")
    static final StyleKey FONT = createStyleKey("TECHNOLOGYPROCESS_FONT", MetaKey.FONT);

    @objid ("e98cb3fe-933f-4636-a615-51c9fa8d82b0")
    static final StyleKey TEXTCOLOR = createStyleKey("TECHNOLOGYPROCESS_TEXTCOLOR", MetaKey.TEXTCOLOR);

    @objid ("39fa48ea-c8f5-432d-9f1c-1948b3ec1319")
    static final StyleKey SHOWSTEREOTYPES = createStyleKey("TECHNOLOGYPROCESS_SHOWSTEREOTYPES", MetaKey.SHOWSTEREOTYPES);

    @objid ("25c416e9-bb70-4606-b9f7-e474aad55c26")
    static final StyleKey SHOWTAGS = createStyleKey("TECHNOLOGYPROCESS_SHOWTAGS", MetaKey.SHOWTAGS);

}

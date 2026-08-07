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
package org.modelio.archimate.diagrams.elements.meaning;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;
import org.modelio.diagram.styles.core.StyleKey.RepresentationMode;

/**
 * This class provides the StyleKey constants for a GmMeaning when its representation mode is {@link RepresentationMode#STRUCTURED}.
 */
@objid ("320c7532-89cb-4f5a-9e51-c72a0bd2ffb3")
public class GmMeaningStructuredStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("3c61fea0-a47e-4a7c-9248-0a12ef32957b")
    static final StyleKey REPMODE = createStyleKey("MEANING_REPMODE", MetaKey.REPMODE);

    @objid ("380f3233-48a3-47e3-bac2-de010e692938")
    static final StyleKey FILLCOLOR = createStyleKey("MEANING_FILLCOLOR", MetaKey.FILLCOLOR);

    @objid ("ba8a76f9-bd9b-46b9-a61b-ca222c232f30")
    static final StyleKey FILLMODE = createStyleKey("MEANING_FILLMODE", MetaKey.FILLMODE);

    @objid ("d2eea25d-70fb-437d-953c-e951d6d7b8e9")
    static final StyleKey LINECOLOR = createStyleKey("MEANING_LINECOLOR", MetaKey.LINECOLOR);

    @objid ("8fb42130-de1c-46fc-8d78-6260f773c678")
    static final StyleKey LINEWIDTH = createStyleKey("MEANING_LINEWIDTH", MetaKey.LINEWIDTH);

    @objid ("86cd98a5-b5ff-4452-bdcd-b49f77b5ddf0")
    static final StyleKey FONT = createStyleKey("MEANING_FONT", MetaKey.FONT);

    @objid ("a55b4729-0a2c-4270-be62-5eb270026326")
    static final StyleKey TEXTCOLOR = createStyleKey("MEANING_TEXTCOLOR", MetaKey.TEXTCOLOR);

    @objid ("2f2b7f09-9ae0-46a7-af68-cff1a02b5a36")
    static final StyleKey SHOWSTEREOTYPES = createStyleKey("MEANING_SHOWSTEREOTYPES", MetaKey.SHOWSTEREOTYPES);

    @objid ("764a6007-ce7b-4198-90e4-2f19f34c91d6")
    static final StyleKey SHOWTAGS = createStyleKey("MEANING_SHOWTAGS", MetaKey.SHOWTAGS);

}

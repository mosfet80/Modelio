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
package org.modelio.archimate.diagrams.elements.deliverable;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmDeliverable when its representation mode is RepresentationMode.STRUCTURED
 */
@objid ("f88d9556-75bf-4c33-bcce-ebceac59f573")
public class GmDeliverableStructuredStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("94e1ac08-7160-41ef-8706-d618343d5826")
    static final StyleKey REPMODE = createStyleKey("DELIVERABLE_REPMODE", MetaKey.REPMODE);

    @objid ("289e25b6-ccdb-4181-99cb-02a2c5285071")
    static final StyleKey FILLCOLOR = createStyleKey("DELIVERABLE_FILLCOLOR", MetaKey.FILLCOLOR);

    @objid ("31bf6675-8e43-43a8-ae14-97e59b6fab5d")
    static final StyleKey FILLMODE = createStyleKey("DELIVERABLE_FILLMODE", MetaKey.FILLMODE);

    @objid ("ca5d0af7-5c7e-4442-8606-262d4c077452")
    static final StyleKey LINECOLOR = createStyleKey("DELIVERABLE_LINECOLOR", MetaKey.LINECOLOR);

    @objid ("3026cdd5-9464-4b39-ad33-31cd41f3c834")
    static final StyleKey LINEWIDTH = createStyleKey("DELIVERABLE_LINEWIDTH", MetaKey.LINEWIDTH);

    @objid ("e238f392-33d4-463a-8552-e5e0d18020ba")
    static final StyleKey FONT = createStyleKey("DELIVERABLE_FONT", MetaKey.FONT);

    @objid ("a2aadd6c-2025-4013-91be-00ff1833cee0")
    static final StyleKey TEXTCOLOR = createStyleKey("DELIVERABLE_TEXTCOLOR", MetaKey.TEXTCOLOR);

    @objid ("51503cc4-f06d-43e4-8f90-21aacae9afdf")
    static final StyleKey SHOWSTEREOTYPES = createStyleKey("DELIVERABLE_SHOWSTEREOTYPES", MetaKey.SHOWSTEREOTYPES);

    @objid ("83720358-ff51-4008-aac8-6b79106964ff")
    static final StyleKey SHOWTAGS = createStyleKey("DELIVERABLE_SHOWTAGS", MetaKey.SHOWTAGS);

}

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
package org.modelio.archimate.diagrams.elements.applicationevent;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmApplicationEvent when its representation mode is RepresentationMode.STRUCTURED
 */
@objid ("db90929a-22f7-4085-bd9e-75f605971921")
public class GmApplicationEventStructuredStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("eda198af-d66d-4720-922d-7145c4e0c753")
    static final StyleKey REPMODE = createStyleKey("APPLICATIONEVENT_REPMODE", MetaKey.REPMODE);

    @objid ("01364419-f19d-421c-9a9b-a8486cfc799e")
    static final StyleKey FILLCOLOR = createStyleKey("APPLICATIONEVENT_FILLCOLOR", MetaKey.FILLCOLOR);

    @objid ("76c8f7cf-b122-4ccd-867c-bd4ff39c28b6")
    static final StyleKey FILLMODE = createStyleKey("APPLICATIONEVENT_FILLMODE", MetaKey.FILLMODE);

    @objid ("12123c3e-98a0-40c1-a03e-c10a2e08fa01")
    static final StyleKey LINECOLOR = createStyleKey("APPLICATIONEVENT_LINECOLOR", MetaKey.LINECOLOR);

    @objid ("9dc5057e-1125-471e-8027-e9df5c687b54")
    static final StyleKey LINEWIDTH = createStyleKey("APPLICATIONEVENT_LINEWIDTH", MetaKey.LINEWIDTH);

    @objid ("6790ecd0-a9fb-4780-818d-e41b3fa4fe78")
    static final StyleKey FONT = createStyleKey("APPLICATIONEVENT_FONT", MetaKey.FONT);

    @objid ("56f60262-7ed2-47de-885c-8699c6e38321")
    static final StyleKey TEXTCOLOR = createStyleKey("APPLICATIONEVENT_TEXTCOLOR", MetaKey.TEXTCOLOR);

    @objid ("9bc056e6-f830-4c36-9eff-4e39dc5c38fe")
    static final StyleKey SHOWSTEREOTYPES = createStyleKey("APPLICATIONEVENT_SHOWSTEREOTYPES", MetaKey.SHOWSTEREOTYPES);

    @objid ("5ee0fa7d-5439-4951-b05c-5d4c8e3a3b7a")
    static final StyleKey SHOWTAGS = createStyleKey("APPLICATIONEVENT_SHOWTAGS", MetaKey.SHOWTAGS);

}

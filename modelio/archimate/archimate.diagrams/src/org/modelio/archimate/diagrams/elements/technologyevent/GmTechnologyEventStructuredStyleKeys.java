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
package org.modelio.archimate.diagrams.elements.technologyevent;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmTechnologyEvent when its representation mode is RepresentationMode.STRUCTURED
 */
@objid ("7e2c8e12-b5df-4d93-80ba-02c982f89b1c")
public class GmTechnologyEventStructuredStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("137d554f-dd71-4732-9414-9abdc1c7bdfe")
    static final StyleKey REPMODE = createStyleKey("TECHNOLOGYEVENT_REPMODE", MetaKey.REPMODE);

    @objid ("f8162e89-b5ba-4644-9408-384f06e4475f")
    static final StyleKey FILLCOLOR = createStyleKey("TECHNOLOGYEVENT_FILLCOLOR", MetaKey.FILLCOLOR);

    @objid ("3202476b-0326-4cc2-99e6-adf4185cca19")
    static final StyleKey FILLMODE = createStyleKey("TECHNOLOGYEVENT_FILLMODE", MetaKey.FILLMODE);

    @objid ("7b7fed61-12a0-4dd7-8889-29ae1d81051c")
    static final StyleKey LINECOLOR = createStyleKey("TECHNOLOGYEVENT_LINECOLOR", MetaKey.LINECOLOR);

    @objid ("cf8bb076-cf0b-43dc-995a-2d1fe73b83c0")
    static final StyleKey LINEWIDTH = createStyleKey("TECHNOLOGYEVENT_LINEWIDTH", MetaKey.LINEWIDTH);

    @objid ("aa8d1985-06d8-42a6-a14f-936ee54eaa76")
    static final StyleKey FONT = createStyleKey("TECHNOLOGYEVENT_FONT", MetaKey.FONT);

    @objid ("518082cd-f951-47b8-87bd-efcb442b80b2")
    static final StyleKey TEXTCOLOR = createStyleKey("TECHNOLOGYEVENT_TEXTCOLOR", MetaKey.TEXTCOLOR);

    @objid ("7414f7eb-adf4-4a62-bf44-794295eebef9")
    static final StyleKey SHOWSTEREOTYPES = createStyleKey("TECHNOLOGYEVENT_SHOWSTEREOTYPES", MetaKey.SHOWSTEREOTYPES);

    @objid ("b6d9b1e5-11b2-4b34-911c-e025caa05322")
    static final StyleKey SHOWTAGS = createStyleKey("TECHNOLOGYEVENT_SHOWTAGS", MetaKey.SHOWTAGS);

}

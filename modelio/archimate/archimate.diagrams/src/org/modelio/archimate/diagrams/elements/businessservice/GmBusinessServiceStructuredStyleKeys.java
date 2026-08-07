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
package org.modelio.archimate.diagrams.elements.businessservice;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmBusinessService when its representation mode is RepresentationMode.STRUCTURED
 */
@objid ("cb70fd15-8c01-481c-b756-90693914dc9d")
public class GmBusinessServiceStructuredStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("0a3b0daa-0653-48cf-ac53-ef5f2f3d0df8")
    static final StyleKey REPMODE = createStyleKey("BUSINESSSERVICE_REPMODE", MetaKey.REPMODE);

    @objid ("b19b29fe-a302-43c2-8c1d-2579cc84454c")
    static final StyleKey FILLCOLOR = createStyleKey("BUSINESSSERVICE_FILLCOLOR", MetaKey.FILLCOLOR);

    @objid ("41d5d81b-4e84-4d6a-9a4a-ac540fb9d263")
    static final StyleKey FILLMODE = createStyleKey("BUSINESSSERVICE_FILLMODE", MetaKey.FILLMODE);

    @objid ("5edf9122-5874-4a27-b7ef-12871bdf7488")
    static final StyleKey LINECOLOR = createStyleKey("BUSINESSSERVICE_LINECOLOR", MetaKey.LINECOLOR);

    @objid ("c28e1ed0-551d-46ae-8b2c-fe3750715935")
    static final StyleKey LINEWIDTH = createStyleKey("BUSINESSSERVICE_LINEWIDTH", MetaKey.LINEWIDTH);

    @objid ("a2610fd5-8ad5-42db-8734-47270561647a")
    static final StyleKey FONT = createStyleKey("BUSINESSSERVICE_FONT", MetaKey.FONT);

    @objid ("33d354c1-799b-49ab-8bff-487a8df52fb1")
    static final StyleKey TEXTCOLOR = createStyleKey("BUSINESSSERVICE_TEXTCOLOR", MetaKey.TEXTCOLOR);

    @objid ("07716a4c-c321-4fb4-907c-721407e671be")
    static final StyleKey SHOWSTEREOTYPES = createStyleKey("BUSINESSSERVICE_SHOWSTEREOTYPES", MetaKey.SHOWSTEREOTYPES);

    @objid ("848e0118-7b87-483a-b142-e8a01d1a1a55")
    static final StyleKey SHOWTAGS = createStyleKey("BUSINESSSERVICE_SHOWTAGS", MetaKey.SHOWTAGS);

}

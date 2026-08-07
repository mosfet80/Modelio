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
package org.modelio.archimate.diagrams.elements.implementationevent;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmImplementationEvent when its representation mode is RepresentationMode.STRUCTURED
 */
@objid ("9692004c-b7aa-4dd1-9dec-1e663d096b4c")
public class GmImplementationEventStructuredStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("d558a4f3-a214-404b-bdcf-ee1de364e7c1")
    static final StyleKey REPMODE = createStyleKey("IMPLEMENTATIONEVENT_REPMODE", MetaKey.REPMODE);

    @objid ("cdde7e96-5cd9-470f-a7bf-9b0305276c56")
    static final StyleKey FILLCOLOR = createStyleKey("IMPLEMENTATIONEVENT_FILLCOLOR", MetaKey.FILLCOLOR);

    @objid ("2b475d8d-59d9-46e3-be20-b914567b740a")
    static final StyleKey FILLMODE = createStyleKey("IMPLEMENTATIONEVENT_FILLMODE", MetaKey.FILLMODE);

    @objid ("7e778555-4774-42d8-a8be-643fd0d65a5c")
    static final StyleKey LINECOLOR = createStyleKey("IMPLEMENTATIONEVENT_LINECOLOR", MetaKey.LINECOLOR);

    @objid ("ed8b8cc1-899f-4106-b180-3629fe5e75d0")
    static final StyleKey LINEWIDTH = createStyleKey("IMPLEMENTATIONEVENT_LINEWIDTH", MetaKey.LINEWIDTH);

    @objid ("cc902026-47ad-4a20-844c-e9c36f29a3e7")
    static final StyleKey FONT = createStyleKey("IMPLEMENTATIONEVENT_FONT", MetaKey.FONT);

    @objid ("778ceaf4-b938-4523-96b5-06f72d02d907")
    static final StyleKey TEXTCOLOR = createStyleKey("IMPLEMENTATIONEVENT_TEXTCOLOR", MetaKey.TEXTCOLOR);

    @objid ("a02d21ca-7bce-46bc-93ee-aeb086cfaa62")
    static final StyleKey SHOWSTEREOTYPES = createStyleKey("IMPLEMENTATIONEVENT_SHOWSTEREOTYPES", MetaKey.SHOWSTEREOTYPES);

    @objid ("e42b5340-4784-4096-a4b2-89182e0466cf")
    static final StyleKey SHOWTAGS = createStyleKey("IMPLEMENTATIONEVENT_SHOWTAGS", MetaKey.SHOWTAGS);

}

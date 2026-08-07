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
package org.modelio.archimate.diagrams.elements.valuestream;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmValueStream when its representation mode is RepresentationMode.STRUCTURED
 */
@objid ("9ae1a982-8a2a-499b-a130-4c24c76fe6f7")
public class GmValueStreamStructuredStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("e7a78436-78f3-4ccd-a806-a363b313217e")
    static final StyleKey REPMODE = createStyleKey("VALUESTREAM_REPMODE", MetaKey.REPMODE);

    @objid ("2b69b79e-538c-4863-bbb0-f9de8a3f1404")
    static final StyleKey FILLCOLOR = createStyleKey("VALUESTREAM_FILLCOLOR", MetaKey.FILLCOLOR);

    @objid ("37bdd17b-d246-40bb-b66f-85857c22f7fa")
    static final StyleKey FILLMODE = createStyleKey("VALUESTREAM_FILLMODE", MetaKey.FILLMODE);

    @objid ("b38c4d27-c374-4dae-9951-c95e985d0e80")
    static final StyleKey LINECOLOR = createStyleKey("VALUESTREAM_LINECOLOR", MetaKey.LINECOLOR);

    @objid ("825b05b0-a985-4cec-acb1-d74c0da777e1")
    static final StyleKey LINEWIDTH = createStyleKey("VALUESTREAM_LINEWIDTH", MetaKey.LINEWIDTH);

    @objid ("3606ce51-5a48-4e2d-9ed2-bb73bdce6ff4")
    static final StyleKey FONT = createStyleKey("VALUESTREAM_FONT", MetaKey.FONT);

    @objid ("46b4d146-da21-4ad7-92d0-9ef4edb4e5a6")
    static final StyleKey TEXTCOLOR = createStyleKey("VALUESTREAM_TEXTCOLOR", MetaKey.TEXTCOLOR);

    @objid ("e2a5f5dc-895e-4143-b575-33740fa10530")
    static final StyleKey SHOWSTEREOTYPES = createStyleKey("VALUESTREAM_SHOWSTEREOTYPES", MetaKey.SHOWSTEREOTYPES);

    @objid ("d5f91b24-f9f5-4375-b75d-55c7560d4ee3")
    static final StyleKey SHOWTAGS = createStyleKey("VALUESTREAM_SHOWTAGS", MetaKey.SHOWTAGS);

}

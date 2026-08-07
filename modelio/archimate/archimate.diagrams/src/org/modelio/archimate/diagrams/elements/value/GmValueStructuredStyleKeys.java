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
package org.modelio.archimate.diagrams.elements.value;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmValue when its representation mode is RepresentationMode.STRUCTURED
 */
@objid ("0743de9d-ba02-4433-9f04-3d82f7102122")
public class GmValueStructuredStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("573010d0-9a9d-4219-be19-44f78c24c7fb")
    static final StyleKey REPMODE = createStyleKey("VALUE_REPMODE", MetaKey.REPMODE);

    @objid ("dc322fc8-2911-49fc-8fdd-3867637901b2")
    static final StyleKey FILLCOLOR = createStyleKey("VALUE_FILLCOLOR", MetaKey.FILLCOLOR);

    @objid ("f23e4d56-b09f-46b5-a0a4-6e06769d11a4")
    static final StyleKey FILLMODE = createStyleKey("VALUE_FILLMODE", MetaKey.FILLMODE);

    @objid ("35bb8200-3757-4ade-9b42-47cd2170ed22")
    static final StyleKey LINECOLOR = createStyleKey("VALUE_LINECOLOR", MetaKey.LINECOLOR);

    @objid ("cb00bbbf-a0d6-4edd-aac4-281596d2248e")
    static final StyleKey LINEWIDTH = createStyleKey("VALUE_LINEWIDTH", MetaKey.LINEWIDTH);

    @objid ("db95c4c1-feba-4c3e-aadb-762ef405125b")
    static final StyleKey FONT = createStyleKey("VALUE_FONT", MetaKey.FONT);

    @objid ("9efaacd7-653d-47d1-9162-fe40d54e4d1d")
    static final StyleKey TEXTCOLOR = createStyleKey("VALUE_TEXTCOLOR", MetaKey.TEXTCOLOR);

    @objid ("37b235e9-c0fc-4a70-bce3-11bc936ebe00")
    static final StyleKey SHOWSTEREOTYPES = createStyleKey("VALUE_SHOWSTEREOTYPES", MetaKey.SHOWSTEREOTYPES);

    @objid ("a3846712-43dd-487f-a8ae-02206c7b2276")
    static final StyleKey SHOWTAGS = createStyleKey("VALUE_SHOWTAGS", MetaKey.SHOWTAGS);

}

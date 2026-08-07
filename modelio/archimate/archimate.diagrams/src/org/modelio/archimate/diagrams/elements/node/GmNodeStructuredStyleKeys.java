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
package org.modelio.archimate.diagrams.elements.node;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmNode when its representation mode is RepresentationMode.STRUCTURED
 */
@objid ("1b956b1a-700f-4b2b-9f04-d8458a972024")
public class GmNodeStructuredStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("e527d34c-5999-470d-ae19-f9c689439def")
    static final StyleKey REPMODE = createStyleKey("ARCHIMATE_NODE_REPMODE", MetaKey.REPMODE);

    @objid ("87481082-d64b-4440-aa4f-490957b98f46")
    static final StyleKey FILLCOLOR = createStyleKey("ARCHIMATE_NODE_FILLCOLOR", MetaKey.FILLCOLOR);

    @objid ("a28e60d7-b75c-4e8e-bea2-01674881661a")
    static final StyleKey FILLMODE = createStyleKey("ARCHIMATE_NODE_FILLMODE", MetaKey.FILLMODE);

    @objid ("8b309522-1f10-4b74-b6db-f10557f4d68b")
    static final StyleKey LINECOLOR = createStyleKey("ARCHIMATE_NODE_LINECOLOR", MetaKey.LINECOLOR);

    @objid ("a3fef75c-6651-48a3-9be9-22cf83aafa4d")
    static final StyleKey LINEWIDTH = createStyleKey("ARCHIMATE_NODE_LINEWIDTH", MetaKey.LINEWIDTH);

    @objid ("8298b3b1-9f0e-4846-a0a9-44322e540469")
    static final StyleKey FONT = createStyleKey("ARCHIMATE_NODE_FONT", MetaKey.FONT);

    @objid ("74095e44-ba3a-4b58-b393-7e99ea860c1d")
    static final StyleKey TEXTCOLOR = createStyleKey("ARCHIMATE_NODE_TEXTCOLOR", MetaKey.TEXTCOLOR);

    @objid ("5d52f294-8a65-4ee4-85a9-20bedb8226e2")
    static final StyleKey SHOWSTEREOTYPES = createStyleKey("ARCHIMATE_NODE_SHOWSTEREOTYPES", MetaKey.SHOWSTEREOTYPES);

    @objid ("b10af812-2471-4c08-9517-ec9d4e9239b8")
    static final StyleKey SHOWTAGS = createStyleKey("ARCHIMATE_NODE_SHOWTAGS", MetaKey.SHOWTAGS);

}

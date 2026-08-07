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
package org.modelio.archimate.diagrams.elements.contract;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmContract when its representation mode is RepresentationMode.STRUCTURED
 */
@objid ("d7a3415b-b3b7-4c56-8d6e-0c6a4b268b86")
public class GmContractStructuredStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("2d55eb83-c853-42e5-b970-8f8d263af741")
    static final StyleKey REPMODE = createStyleKey("CONTRACT_REPMODE", MetaKey.REPMODE);

    @objid ("e8d4376f-4b3d-4fbc-b355-2a8f33cafac8")
    static final StyleKey FILLCOLOR = createStyleKey("CONTRACT_FILLCOLOR", MetaKey.FILLCOLOR);

    @objid ("90ebbc0c-58f9-4a20-b929-374146a91af8")
    static final StyleKey FILLMODE = createStyleKey("CONTRACT_FILLMODE", MetaKey.FILLMODE);

    @objid ("91a985c0-c296-4f76-a279-49eca1bc7498")
    static final StyleKey LINECOLOR = createStyleKey("CONTRACT_LINECOLOR", MetaKey.LINECOLOR);

    @objid ("3d8380a3-9fb8-4f75-b1c2-efa118028741")
    static final StyleKey LINEWIDTH = createStyleKey("CONTRACT_LINEWIDTH", MetaKey.LINEWIDTH);

    @objid ("b32aad69-0594-4ffe-881b-46af5e39e3d2")
    static final StyleKey FONT = createStyleKey("CONTRACT_FONT", MetaKey.FONT);

    @objid ("c009867f-0f61-4ff3-a448-6f999dc956d0")
    static final StyleKey TEXTCOLOR = createStyleKey("CONTRACT_TEXTCOLOR", MetaKey.TEXTCOLOR);

    @objid ("fc8dc25a-29d0-4409-afa9-35454512ea5b")
    static final StyleKey SHOWSTEREOTYPES = createStyleKey("CONTRACT_SHOWSTEREOTYPES", MetaKey.SHOWSTEREOTYPES);

    @objid ("52a7ae50-f577-4a14-a6ad-94147b0a108c")
    static final StyleKey SHOWTAGS = createStyleKey("CONTRACT_SHOWTAGS", MetaKey.SHOWTAGS);

}

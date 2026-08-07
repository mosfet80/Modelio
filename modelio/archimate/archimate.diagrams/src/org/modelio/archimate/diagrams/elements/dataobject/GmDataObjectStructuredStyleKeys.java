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
package org.modelio.archimate.diagrams.elements.dataobject;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmDataObject when its representation mode is RepresentationMode.STRUCTURED
 */
@objid ("9fa1dbb1-4e08-4b7c-a313-b42665b60e7b")
public class GmDataObjectStructuredStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("8d680925-f3fd-4d94-aec2-8cc61fa71fa8")
    static final StyleKey REPMODE = createStyleKey("DATAOBJECT_REPMODE", MetaKey.REPMODE);

    @objid ("f87a14ec-82e6-466a-b345-fa009486b5a7")
    static final StyleKey FILLCOLOR = createStyleKey("DATAOBJECT_FILLCOLOR", MetaKey.FILLCOLOR);

    @objid ("8d0cf6c3-b24f-49d3-82e2-50ed9bcbb1bd")
    static final StyleKey FILLMODE = createStyleKey("DATAOBJECT_FILLMODE", MetaKey.FILLMODE);

    @objid ("aeef91c1-006d-4fe9-a327-8271ba6c690e")
    static final StyleKey LINECOLOR = createStyleKey("DATAOBJECT_LINECOLOR", MetaKey.LINECOLOR);

    @objid ("95fc0e4d-8319-4468-8f2e-5a4786da8b72")
    static final StyleKey LINEWIDTH = createStyleKey("DATAOBJECT_LINEWIDTH", MetaKey.LINEWIDTH);

    @objid ("23a15ab2-58d4-4c4c-8abe-472526dcf381")
    static final StyleKey FONT = createStyleKey("DATAOBJECT_FONT", MetaKey.FONT);

    @objid ("e6efcadd-29f1-48eb-8059-3f2ff196f375")
    static final StyleKey TEXTCOLOR = createStyleKey("DATAOBJECT_TEXTCOLOR", MetaKey.TEXTCOLOR);

    @objid ("0fd058a6-9a8a-4ce9-ac50-99940e3d0f3d")
    static final StyleKey SHOWSTEREOTYPES = createStyleKey("DATAOBJECT_SHOWSTEREOTYPES", MetaKey.SHOWSTEREOTYPES);

    @objid ("cc126159-a977-4184-b516-365aa48885ca")
    static final StyleKey SHOWTAGS = createStyleKey("DATAOBJECT_SHOWTAGS", MetaKey.SHOWTAGS);

}

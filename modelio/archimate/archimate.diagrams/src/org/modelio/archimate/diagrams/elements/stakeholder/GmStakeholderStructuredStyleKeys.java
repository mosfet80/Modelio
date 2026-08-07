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
package org.modelio.archimate.diagrams.elements.stakeholder;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmStakeholder when its representation mode is RepresentationMode.STRUCTURED
 */
@objid ("c71a3d57-a8ac-40bb-85b0-ed1ecb5c309a")
public class GmStakeholderStructuredStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("defd2fa3-0566-4428-a707-7c7dad4f027c")
    static final StyleKey REPMODE = createStyleKey("STAKEHOLDER_REPMODE", MetaKey.REPMODE);

    @objid ("93031775-853d-4833-9d10-116a5d4d6de0")
    static final StyleKey FILLCOLOR = createStyleKey("STAKEHOLDER_FILLCOLOR", MetaKey.FILLCOLOR);

    @objid ("7d31aa21-0908-4494-803b-cef3a4902105")
    static final StyleKey FILLMODE = createStyleKey("STAKEHOLDER_FILLMODE", MetaKey.FILLMODE);

    @objid ("0af6c88a-1276-40bc-8516-82c06171a9ab")
    static final StyleKey LINECOLOR = createStyleKey("STAKEHOLDER_LINECOLOR", MetaKey.LINECOLOR);

    @objid ("5065483d-5876-4836-935b-a3a67d90ff2c")
    static final StyleKey LINEWIDTH = createStyleKey("STAKEHOLDER_LINEWIDTH", MetaKey.LINEWIDTH);

    @objid ("91d22177-9b6a-4cac-b5a5-7bb4a49c7fca")
    static final StyleKey FONT = createStyleKey("STAKEHOLDER_FONT", MetaKey.FONT);

    @objid ("eebf83ab-0be2-44bc-a152-94e3d36a37f1")
    static final StyleKey TEXTCOLOR = createStyleKey("STAKEHOLDER_TEXTCOLOR", MetaKey.TEXTCOLOR);

    @objid ("f23c9ab6-e368-499a-b6f3-f907b760f6ae")
    static final StyleKey SHOWSTEREOTYPES = createStyleKey("STAKEHOLDER_SHOWSTEREOTYPES", MetaKey.SHOWSTEREOTYPES);

    @objid ("447e495c-31a7-4310-a8d6-baade8e6cc32")
    static final StyleKey SHOWTAGS = createStyleKey("STAKEHOLDER_SHOWTAGS", MetaKey.SHOWTAGS);

}

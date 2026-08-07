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
package org.modelio.archimate.diagrams.elements.applicationservice;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmApplicationService when its representation mode is RepresentationMode.STRUCTURED
 */
@objid ("942c8404-0a78-4212-9c88-a255f31e9fea")
public class GmApplicationServiceStructuredStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("6bb3dd73-bf16-438a-94aa-9cd9c9aa098c")
    static final StyleKey REPMODE = createStyleKey("APPLICATIONSERVICE_REPMODE", MetaKey.REPMODE);

    @objid ("9758d7c7-3143-487e-94d3-6ab85592a517")
    static final StyleKey FILLCOLOR = createStyleKey("APPLICATIONSERVICE_FILLCOLOR", MetaKey.FILLCOLOR);

    @objid ("865e9957-8aa5-4e57-8db7-8a50545698b8")
    static final StyleKey FILLMODE = createStyleKey("APPLICATIONSERVICE_FILLMODE", MetaKey.FILLMODE);

    @objid ("7b5650e4-51dc-45a5-820b-0356eeb4fe9d")
    static final StyleKey LINECOLOR = createStyleKey("APPLICATIONSERVICE_LINECOLOR", MetaKey.LINECOLOR);

    @objid ("f94eb85d-98f3-4f7b-8af4-101d78c3bb19")
    static final StyleKey LINEWIDTH = createStyleKey("APPLICATIONSERVICE_LINEWIDTH", MetaKey.LINEWIDTH);

    @objid ("d54f79a3-3e19-4aa8-b487-11cb1191f5c3")
    static final StyleKey FONT = createStyleKey("APPLICATIONSERVICE_FONT", MetaKey.FONT);

    @objid ("6a4a9539-39f0-4622-8d0f-b9fa394bb63a")
    static final StyleKey TEXTCOLOR = createStyleKey("APPLICATIONSERVICE_TEXTCOLOR", MetaKey.TEXTCOLOR);

    @objid ("4d411c68-587c-45ab-a191-83b567bc3c55")
    static final StyleKey SHOWSTEREOTYPES = createStyleKey("APPLICATIONSERVICE_SHOWSTEREOTYPES", MetaKey.SHOWSTEREOTYPES);

    @objid ("80af566e-0409-4f50-b218-be638496cfc0")
    static final StyleKey SHOWTAGS = createStyleKey("APPLICATIONSERVICE_SHOWTAGS", MetaKey.SHOWTAGS);

}

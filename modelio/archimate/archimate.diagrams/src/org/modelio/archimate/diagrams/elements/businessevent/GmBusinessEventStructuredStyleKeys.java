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
package org.modelio.archimate.diagrams.elements.businessevent;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmBusinessEvent when its representation mode is RepresentationMode.STRUCTURED
 */
@objid ("4a4962c1-8535-43ac-9f98-4f5252a7f707")
public class GmBusinessEventStructuredStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("bbc512c5-7a3f-4f98-b963-97fe69d7871e")
    static final StyleKey REPMODE = createStyleKey("BUSINESSEVENT_REPMODE", MetaKey.REPMODE);

    @objid ("55b3e381-a236-4431-9fee-b5efdb711696")
    static final StyleKey FILLCOLOR = createStyleKey("BUSINESSEVENT_FILLCOLOR", MetaKey.FILLCOLOR);

    @objid ("62194c35-7e22-43ff-82cf-61a9f0532bad")
    static final StyleKey FILLMODE = createStyleKey("BUSINESSEVENT_FILLMODE", MetaKey.FILLMODE);

    @objid ("240f8507-2003-40b2-b19a-9f3bcf1ad698")
    static final StyleKey LINECOLOR = createStyleKey("BUSINESSEVENT_LINECOLOR", MetaKey.LINECOLOR);

    @objid ("44887f05-f21a-48e2-bda4-47a8d5cd9d06")
    static final StyleKey LINEWIDTH = createStyleKey("BUSINESSEVENT_LINEWIDTH", MetaKey.LINEWIDTH);

    @objid ("582a906a-9c96-48ba-a556-e5a2ad26cee0")
    static final StyleKey FONT = createStyleKey("BUSINESSEVENT_FONT", MetaKey.FONT);

    @objid ("c35e73ff-76bf-42e8-9aab-d2b092f643c0")
    static final StyleKey TEXTCOLOR = createStyleKey("BUSINESSEVENT_TEXTCOLOR", MetaKey.TEXTCOLOR);

    @objid ("fb00a9e6-175a-4c5c-a7e7-dbd9e2da8452")
    static final StyleKey SHOWSTEREOTYPES = createStyleKey("BUSINESSEVENT_SHOWSTEREOTYPES", MetaKey.SHOWSTEREOTYPES);

    @objid ("ad0a0566-f099-42cf-b9c1-d5ee70c8d78e")
    static final StyleKey SHOWTAGS = createStyleKey("BUSINESSEVENT_SHOWTAGS", MetaKey.SHOWTAGS);

}

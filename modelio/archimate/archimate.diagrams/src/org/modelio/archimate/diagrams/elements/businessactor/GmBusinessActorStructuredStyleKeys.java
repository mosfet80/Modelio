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
package org.modelio.archimate.diagrams.elements.businessactor;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmBusinessActor when its representation mode is RepresentationMode.STRUCTURED
 */
@objid ("8847b4ae-bf05-4f9e-a4f4-70cb3c69f904")
public class GmBusinessActorStructuredStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("1f474fd7-6c76-41f8-9bd4-f5165c77c482")
    static final StyleKey REPMODE = createStyleKey("BUSINESSACTOR_REPMODE", MetaKey.REPMODE);

    @objid ("8ff62584-ee57-4b45-a354-27a3924f9a68")
    static final StyleKey FILLCOLOR = createStyleKey("BUSINESSACTOR_FILLCOLOR", MetaKey.FILLCOLOR);

    @objid ("d6f14a98-00d8-4e18-8c71-cb991bfe6f77")
    static final StyleKey FILLMODE = createStyleKey("BUSINESSACTOR_FILLMODE", MetaKey.FILLMODE);

    @objid ("3f613034-1889-4a1f-8855-b72893cef2fd")
    static final StyleKey LINECOLOR = createStyleKey("BUSINESSACTOR_LINECOLOR", MetaKey.LINECOLOR);

    @objid ("e2bb681a-84aa-409c-ae9c-d66ae0cf6216")
    static final StyleKey LINEWIDTH = createStyleKey("BUSINESSACTOR_LINEWIDTH", MetaKey.LINEWIDTH);

    @objid ("598dad14-7b08-4f6f-aa87-b8e2018119ec")
    static final StyleKey FONT = createStyleKey("BUSINESSACTOR_FONT", MetaKey.FONT);

    @objid ("ede94722-dd8a-4c52-8643-02e92ad10fa4")
    static final StyleKey TEXTCOLOR = createStyleKey("BUSINESSACTOR_TEXTCOLOR", MetaKey.TEXTCOLOR);

    @objid ("b74bb8dd-6583-42c3-887b-cf4e7f0135d7")
    static final StyleKey SHOWSTEREOTYPES = createStyleKey("BUSINESSACTOR_SHOWSTEREOTYPES", MetaKey.SHOWSTEREOTYPES);

    @objid ("b98e384e-fbb8-44ee-ba9d-fd2eb5e708dd")
    static final StyleKey SHOWTAGS = createStyleKey("BUSINESSACTOR_SHOWTAGS", MetaKey.SHOWTAGS);

}

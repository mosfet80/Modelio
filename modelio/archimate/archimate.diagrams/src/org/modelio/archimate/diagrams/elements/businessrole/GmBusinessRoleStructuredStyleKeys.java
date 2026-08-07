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
package org.modelio.archimate.diagrams.elements.businessrole;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmBusinessRole when its representation mode is RepresentationMode.STRUCTURED
 */
@objid ("db75dde8-1012-4e2c-bbc7-5e3b3e257130")
public class GmBusinessRoleStructuredStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("a3a8814e-7809-45a4-83ad-3a444f2a64ea")
    static final StyleKey REPMODE = createStyleKey("BUSINESSROLE_REPMODE", MetaKey.REPMODE);

    @objid ("60d5ac9c-1133-447a-a4aa-4514548d92a4")
    static final StyleKey FILLCOLOR = createStyleKey("BUSINESSROLE_FILLCOLOR", MetaKey.FILLCOLOR);

    @objid ("1f4eb546-299b-4017-9397-64cc031858ab")
    static final StyleKey FILLMODE = createStyleKey("BUSINESSROLE_FILLMODE", MetaKey.FILLMODE);

    @objid ("508d6c97-fbfa-4d85-b7d3-61afa71c9ca1")
    static final StyleKey LINECOLOR = createStyleKey("BUSINESSROLE_LINECOLOR", MetaKey.LINECOLOR);

    @objid ("3e44a5b7-1800-43bb-a39f-c3154ed215c5")
    static final StyleKey LINEWIDTH = createStyleKey("BUSINESSROLE_LINEWIDTH", MetaKey.LINEWIDTH);

    @objid ("60994903-e7da-443f-86b2-96a0741321d9")
    static final StyleKey FONT = createStyleKey("BUSINESSROLE_FONT", MetaKey.FONT);

    @objid ("5fa7ea3b-c8e8-41fa-9bfe-832cce55e8a5")
    static final StyleKey TEXTCOLOR = createStyleKey("BUSINESSROLE_TEXTCOLOR", MetaKey.TEXTCOLOR);

    @objid ("f8fe8755-a7a4-4d07-bb7b-613798140a74")
    static final StyleKey SHOWSTEREOTYPES = createStyleKey("BUSINESSROLE_SHOWSTEREOTYPES", MetaKey.SHOWSTEREOTYPES);

    @objid ("1b7848a9-8231-40fb-8ab4-83a534a26472")
    static final StyleKey SHOWTAGS = createStyleKey("BUSINESSROLE_SHOWTAGS", MetaKey.SHOWTAGS);

}

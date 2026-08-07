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
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmBusinessActor when its representation mode is RepresentationMode.IMAGE
 */
@objid ("1384d099-1d69-4bf4-8ca4-db8bc6cd30ae")
public class GmBusinessActorImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("e46508ca-09d1-4b68-ae18-bd18d2906874")
    static final StyleKey REPMODE = GmBusinessActorStructuredStyleKeys.REPMODE;

    @objid ("914e64cc-a202-46f9-8a54-9cab12062762")
    static final StyleKey FONT = GmBusinessActorStructuredStyleKeys.FONT;

    @objid ("6298ffde-9f2d-49c3-9dad-42ac38f651c3")
    static final StyleKey TEXTCOLOR = GmBusinessActorStructuredStyleKeys.TEXTCOLOR;

    @objid ("50eea5ae-10ea-49db-9b21-b839eb23567d")
    static final StyleKey SHOWSTEREOTYPES = GmBusinessActorStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("146a1681-b557-4d16-87af-e556af2549c8")
    static final StyleKey SHOWTAGS = GmBusinessActorStructuredStyleKeys.SHOWTAGS;

}

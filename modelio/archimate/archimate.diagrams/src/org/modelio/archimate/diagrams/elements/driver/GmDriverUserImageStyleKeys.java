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
package org.modelio.archimate.diagrams.elements.driver;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmDriver when its representation mode is RepresentationMode.IMAGE
 */
@objid ("9dc9d4c9-35e4-47f9-96a0-72d9daebcb60")
public class GmDriverUserImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("694ad499-01ce-42a3-a4d7-c81cf04b206a")
    static final StyleKey REPMODE = GmDriverStructuredStyleKeys.REPMODE;

    @objid ("c535ff7f-67de-4fea-8452-b2ee8b8254ea")
    static final StyleKey FONT = GmDriverStructuredStyleKeys.FONT;

    @objid ("bbdd3eb5-62e3-4bba-abbb-505b51252fe7")
    static final StyleKey TEXTCOLOR = GmDriverStructuredStyleKeys.TEXTCOLOR;

    @objid ("042b25e6-d37b-40b3-8846-8e0f1593e131")
    static final StyleKey SHOWSTEREOTYPES = GmDriverStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("f6d22f77-d139-4b69-92aa-d15a2b5ed9fe")
    static final StyleKey SHOWTAGS = GmDriverStructuredStyleKeys.SHOWTAGS;

}

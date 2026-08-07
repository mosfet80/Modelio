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
package org.modelio.archimate.diagrams.elements.applicationinterface;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmApplicationInterface when its representation mode is RepresentationMode.IMAGE
 */
@objid ("4a579a4d-5b51-4acb-a0d8-6289eb85dd29")
public class GmApplicationInterfaceUserImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("0ff6f8f7-8de2-48aa-ae3b-0f22179d35cd")
    static final StyleKey REPMODE = GmApplicationInterfaceStructuredStyleKeys.REPMODE;

    @objid ("276c600d-21f3-408e-b0b2-7c8e606c7e33")
    static final StyleKey FONT = GmApplicationInterfaceStructuredStyleKeys.FONT;

    @objid ("49c7771f-55a1-433f-b1ee-bba32ee46e5e")
    static final StyleKey TEXTCOLOR = GmApplicationInterfaceStructuredStyleKeys.TEXTCOLOR;

    @objid ("43dfc97e-4274-45ce-91de-e0268f155124")
    static final StyleKey SHOWSTEREOTYPES = GmApplicationInterfaceStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("e2d9b3fa-b72c-4871-94c9-2e09df43ec8c")
    static final StyleKey SHOWTAGS = GmApplicationInterfaceStructuredStyleKeys.SHOWTAGS;

}

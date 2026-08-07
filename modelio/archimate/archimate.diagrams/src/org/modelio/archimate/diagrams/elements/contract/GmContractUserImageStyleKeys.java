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
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmContract when its representation mode is RepresentationMode.IMAGE
 */
@objid ("a1fb9931-ec73-43f5-a432-5c8cdd62d58e")
public class GmContractUserImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("b1b25ad0-73fb-4ff9-bdb6-9306ca623c90")
    static final StyleKey REPMODE = GmContractStructuredStyleKeys.REPMODE;

    @objid ("3f7d9203-e357-4379-bda7-5db51acc1a5d")
    static final StyleKey FONT = GmContractStructuredStyleKeys.FONT;

    @objid ("40fef052-a06e-4358-bacd-c3088fa2e9ac")
    static final StyleKey TEXTCOLOR = GmContractStructuredStyleKeys.TEXTCOLOR;

    @objid ("95e03c8f-f8e4-4d14-b2a9-306359bea7dd")
    static final StyleKey SHOWSTEREOTYPES = GmContractStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("ede6b2a1-9f06-4c36-a253-f22bf53608cb")
    static final StyleKey SHOWTAGS = GmContractStructuredStyleKeys.SHOWTAGS;

}

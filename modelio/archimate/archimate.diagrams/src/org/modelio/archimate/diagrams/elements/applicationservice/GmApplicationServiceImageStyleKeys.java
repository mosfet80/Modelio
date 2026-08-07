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
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmApplicationService when its representation mode is RepresentationMode.IMAGE
 */
@objid ("a273b960-d356-460f-b306-007e17aff531")
public class GmApplicationServiceImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("88884322-4641-4d57-8fa5-619f1d1b3c55")
    static final StyleKey REPMODE = GmApplicationServiceStructuredStyleKeys.REPMODE;

    @objid ("13af8e46-7852-4873-b447-5e28712e6ae5")
    static final StyleKey FONT = GmApplicationServiceStructuredStyleKeys.FONT;

    @objid ("1393e373-4631-47dd-8e7b-5bb694869129")
    static final StyleKey TEXTCOLOR = GmApplicationServiceStructuredStyleKeys.TEXTCOLOR;

    @objid ("4251193f-86a2-495d-a9f9-fc7e15f97c0a")
    static final StyleKey SHOWSTEREOTYPES = GmApplicationServiceStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("5fa85cd4-b2a2-4d72-8abe-06e30e183686")
    static final StyleKey SHOWTAGS = GmApplicationServiceStructuredStyleKeys.SHOWTAGS;

}

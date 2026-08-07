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
package org.modelio.archimate.diagrams.elements.businessservice;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmBusinessService when its representation mode is RepresentationMode.IMAGE
 */
@objid ("00963f2d-ae78-4ae2-acf2-92387d52c891")
public class GmBusinessServiceUserImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("4c7d99c3-5322-43f1-b321-6db4e228bee6")
    static final StyleKey REPMODE = GmBusinessServiceStructuredStyleKeys.REPMODE;

    @objid ("ed8e4065-e243-4851-9cb9-56882283f234")
    static final StyleKey FONT = GmBusinessServiceStructuredStyleKeys.FONT;

    @objid ("eed95518-f1c3-4a46-8e79-4bbdbf9687cd")
    static final StyleKey TEXTCOLOR = GmBusinessServiceStructuredStyleKeys.TEXTCOLOR;

    @objid ("3473fc92-16cd-4e8f-91ee-90754eaeaa74")
    static final StyleKey SHOWSTEREOTYPES = GmBusinessServiceStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("c6076405-348b-49a0-8fcf-3484608a7816")
    static final StyleKey SHOWTAGS = GmBusinessServiceStructuredStyleKeys.SHOWTAGS;

}

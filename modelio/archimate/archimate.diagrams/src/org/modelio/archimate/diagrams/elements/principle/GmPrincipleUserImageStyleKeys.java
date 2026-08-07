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
package org.modelio.archimate.diagrams.elements.principle;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.StyleKey;
import org.modelio.diagram.styles.core.StyleKey.RepresentationMode;

/**
 * This class provides the StyleKey constants for a GmPrinciple when its representation mode is {@link RepresentationMode#USER_IMAGE}.
 */
@objid ("312a104e-153a-4894-837b-9d5e4092637e")
public class GmPrincipleUserImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("e7b06ace-ed63-4b25-b838-81c842f8b27e")
    static final StyleKey REPMODE = GmPrincipleStructuredStyleKeys.REPMODE;

    @objid ("c50258fc-9c21-434e-ac8e-be4816c78922")
    static final StyleKey FONT = GmPrincipleStructuredStyleKeys.FONT;

    @objid ("d885f5c6-e462-430c-9e97-c8d691e4c671")
    static final StyleKey TEXTCOLOR = GmPrincipleStructuredStyleKeys.TEXTCOLOR;

    @objid ("c29a3fb0-3211-48bf-a160-5728614e860a")
    static final StyleKey SHOWSTEREOTYPES = GmPrincipleStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("4bc39642-12d7-4040-9a03-6e78f8ab9ae3")
    static final StyleKey SHOWTAGS = GmPrincipleStructuredStyleKeys.SHOWTAGS;

}

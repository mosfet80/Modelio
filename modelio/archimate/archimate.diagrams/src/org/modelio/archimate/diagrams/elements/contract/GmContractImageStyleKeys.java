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
@objid ("af8e46d5-8fc4-4021-90c2-1bf4500c4465")
public class GmContractImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("8ec3b4bd-4b37-4f23-a4aa-74f7bc80803b")
    static final StyleKey REPMODE = GmContractStructuredStyleKeys.REPMODE;

    @objid ("9f1620a9-2168-4687-b586-90b368a0bc6a")
    static final StyleKey FONT = GmContractStructuredStyleKeys.FONT;

    @objid ("a635b9cf-6d8e-4968-896e-5897e49b2784")
    static final StyleKey TEXTCOLOR = GmContractStructuredStyleKeys.TEXTCOLOR;

    @objid ("f1d445eb-a4ac-4663-b936-e37c9f271c07")
    static final StyleKey SHOWSTEREOTYPES = GmContractStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("273a45ad-7ff1-44bc-b008-97eae62b489f")
    static final StyleKey SHOWTAGS = GmContractStructuredStyleKeys.SHOWTAGS;

}

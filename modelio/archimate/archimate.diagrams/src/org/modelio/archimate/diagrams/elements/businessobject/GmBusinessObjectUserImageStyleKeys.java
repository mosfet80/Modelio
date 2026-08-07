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
package org.modelio.archimate.diagrams.elements.businessobject;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmBusinessObject when its representation mode is RepresentationMode.IMAGE
 */
@objid ("cf57b165-a8e0-4527-9476-baae0552bfaa")
public class GmBusinessObjectUserImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("140430c2-f309-46a9-a8d2-96788ae272be")
    static final StyleKey REPMODE = GmBusinessObjectStructuredStyleKeys.REPMODE;

    @objid ("6dfec4a0-e5ed-4ff6-b6c2-c375eaaf7714")
    static final StyleKey FONT = GmBusinessObjectStructuredStyleKeys.FONT;

    @objid ("b49c176c-298e-4295-a85c-29248da8e830")
    static final StyleKey TEXTCOLOR = GmBusinessObjectStructuredStyleKeys.TEXTCOLOR;

    @objid ("0fbf8d0a-48ad-408a-b765-00034a9ffe9b")
    static final StyleKey SHOWSTEREOTYPES = GmBusinessObjectStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("3c9899e0-1d00-4de1-b8c8-cdec7ca824fb")
    static final StyleKey SHOWTAGS = GmBusinessObjectStructuredStyleKeys.SHOWTAGS;

}

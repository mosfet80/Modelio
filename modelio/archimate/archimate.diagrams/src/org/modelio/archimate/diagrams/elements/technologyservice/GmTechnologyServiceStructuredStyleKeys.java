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
package org.modelio.archimate.diagrams.elements.technologyservice;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmTechnologyService when its representation mode is RepresentationMode.STRUCTURED
 */
@objid ("2f5e702b-524d-4907-91db-22b980840a30")
public class GmTechnologyServiceStructuredStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("e9d68dc0-cd2a-4f18-a6d0-afe89d173c0e")
    static final StyleKey REPMODE = createStyleKey("TECHNOLOGYSERVICE_REPMODE", MetaKey.REPMODE);

    @objid ("8bc5791a-e257-4f4b-9502-8b39920a22a7")
    static final StyleKey FILLCOLOR = createStyleKey("TECHNOLOGYSERVICE_FILLCOLOR", MetaKey.FILLCOLOR);

    @objid ("9170016f-d274-4575-a75c-c364f11056bc")
    static final StyleKey FILLMODE = createStyleKey("TECHNOLOGYSERVICE_FILLMODE", MetaKey.FILLMODE);

    @objid ("65085faf-2f5e-42c6-a15b-ecbe5af7f371")
    static final StyleKey LINECOLOR = createStyleKey("TECHNOLOGYSERVICE_LINECOLOR", MetaKey.LINECOLOR);

    @objid ("5453561e-5838-4927-b5a2-f33993a4072e")
    static final StyleKey LINEWIDTH = createStyleKey("TECHNOLOGYSERVICE_LINEWIDTH", MetaKey.LINEWIDTH);

    @objid ("88d80a20-b481-43c1-8503-cfac18308999")
    static final StyleKey FONT = createStyleKey("TECHNOLOGYSERVICE_FONT", MetaKey.FONT);

    @objid ("da308d9e-4b7e-45f5-9b93-4a6b4c289d94")
    static final StyleKey TEXTCOLOR = createStyleKey("TECHNOLOGYSERVICE_TEXTCOLOR", MetaKey.TEXTCOLOR);

    @objid ("42b4a605-5332-4e66-828b-a1a7a474f480")
    static final StyleKey SHOWSTEREOTYPES = createStyleKey("TECHNOLOGYSERVICE_SHOWSTEREOTYPES", MetaKey.SHOWSTEREOTYPES);

    @objid ("4fb2d0fb-3d17-4da4-ae50-dcd4f1ef79eb")
    static final StyleKey SHOWTAGS = createStyleKey("TECHNOLOGYSERVICE_SHOWTAGS", MetaKey.SHOWTAGS);

}

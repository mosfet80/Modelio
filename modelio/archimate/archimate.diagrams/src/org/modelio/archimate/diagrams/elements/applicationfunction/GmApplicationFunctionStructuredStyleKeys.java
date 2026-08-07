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
package org.modelio.archimate.diagrams.elements.applicationfunction;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmApplicationFunction when its representation mode is RepresentationMode.STRUCTURED
 */
@objid ("15f0807f-a61f-4b7c-9009-937f9e6a53ed")
public class GmApplicationFunctionStructuredStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("60c2fdaa-736e-4d24-b815-cc230102b82c")
    static final StyleKey REPMODE = createStyleKey("APPLICATIONFUNCTION_REPMODE", MetaKey.REPMODE);

    @objid ("c3c9613c-a588-4e5e-b489-67cda6b699dc")
    static final StyleKey FILLCOLOR = createStyleKey("APPLICATIONFUNCTION_FILLCOLOR", MetaKey.FILLCOLOR);

    @objid ("b0e0bec9-7bf2-4ae9-b470-8436ac757d64")
    static final StyleKey FILLMODE = createStyleKey("APPLICATIONFUNCTION_FILLMODE", MetaKey.FILLMODE);

    @objid ("23013809-a1f7-46cc-97f5-eca6ba0ac5dc")
    static final StyleKey LINECOLOR = createStyleKey("APPLICATIONFUNCTION_LINECOLOR", MetaKey.LINECOLOR);

    @objid ("14c35aec-33e7-4d8e-b9ad-7eee080d9c64")
    static final StyleKey LINEWIDTH = createStyleKey("APPLICATIONFUNCTION_LINEWIDTH", MetaKey.LINEWIDTH);

    @objid ("732e1cc0-829c-409b-a4da-0800700d8a0c")
    static final StyleKey FONT = createStyleKey("APPLICATIONFUNCTION_FONT", MetaKey.FONT);

    @objid ("14d25b2b-78cf-474a-a06f-bb837a850a8a")
    static final StyleKey TEXTCOLOR = createStyleKey("APPLICATIONFUNCTION_TEXTCOLOR", MetaKey.TEXTCOLOR);

    @objid ("390af7c1-6603-499e-bd2a-f0bf04113705")
    static final StyleKey SHOWSTEREOTYPES = createStyleKey("APPLICATIONFUNCTION_SHOWSTEREOTYPES", MetaKey.SHOWSTEREOTYPES);

    @objid ("d7f02bee-dc3a-46f9-a43c-3997151f327b")
    static final StyleKey SHOWTAGS = createStyleKey("APPLICATIONFUNCTION_SHOWTAGS", MetaKey.SHOWTAGS);

}

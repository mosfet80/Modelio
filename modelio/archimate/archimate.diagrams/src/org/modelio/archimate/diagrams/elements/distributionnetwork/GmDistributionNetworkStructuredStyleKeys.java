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
package org.modelio.archimate.diagrams.elements.distributionnetwork;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmDistributionNetwork when its representation mode is RepresentationMode.STRUCTURED
 */
@objid ("50c3b199-a730-4f9f-b13d-bbea2482c2ed")
public class GmDistributionNetworkStructuredStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("fa6ebbcb-ad65-43c7-96fc-2a6662af1b3d")
    static final StyleKey REPMODE = createStyleKey("DISTRIBUTIONNETWORK_REPMODE", MetaKey.REPMODE);

    @objid ("97db6909-7bfe-4887-a614-51c0a9367bbf")
    static final StyleKey FILLCOLOR = createStyleKey("DISTRIBUTIONNETWORK_FILLCOLOR", MetaKey.FILLCOLOR);

    @objid ("ce1e91ee-73a1-4db0-b199-bac8baeeee42")
    static final StyleKey FILLMODE = createStyleKey("DISTRIBUTIONNETWORK_FILLMODE", MetaKey.FILLMODE);

    @objid ("3cd3a6d2-05ff-40d9-8bc9-a38f96d6b2f0")
    static final StyleKey LINECOLOR = createStyleKey("DISTRIBUTIONNETWORK_LINECOLOR", MetaKey.LINECOLOR);

    @objid ("34772241-c772-425d-93a9-e87689ce1c64")
    static final StyleKey LINEWIDTH = createStyleKey("DISTRIBUTIONNETWORK_LINEWIDTH", MetaKey.LINEWIDTH);

    @objid ("818a3317-e955-41c0-abc5-da2b5f96d9fd")
    static final StyleKey FONT = createStyleKey("DISTRIBUTIONNETWORK_FONT", MetaKey.FONT);

    @objid ("543ce653-ec22-4ec7-b0a7-5598ba275ec2")
    static final StyleKey TEXTCOLOR = createStyleKey("DISTRIBUTIONNETWORK_TEXTCOLOR", MetaKey.TEXTCOLOR);

    @objid ("bbcd1551-c2d4-4daf-a1c4-1037861edf99")
    static final StyleKey SHOWSTEREOTYPES = createStyleKey("DISTRIBUTIONNETWORK_SHOWSTEREOTYPES", MetaKey.SHOWSTEREOTYPES);

    @objid ("606bc813-0b84-43a4-9500-0296e2624c69")
    static final StyleKey SHOWTAGS = createStyleKey("DISTRIBUTIONNETWORK_SHOWTAGS", MetaKey.SHOWTAGS);

}

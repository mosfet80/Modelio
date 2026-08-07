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
package org.modelio.archimate.diagrams.elements.communicationnetwork;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmCommunicationNetwork when its representation mode is RepresentationMode.STRUCTURED
 */
@objid ("45da2b07-bafd-479c-96b5-a442d67b5289")
public class GmCommunicationNetworkStructuredStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("18c111e0-32f5-405e-af84-d052dc02a909")
    static final StyleKey REPMODE = createStyleKey("COMMUNICATIONNETWORK_REPMODE", MetaKey.REPMODE);

    @objid ("e7e869a3-4fc4-43bf-909c-ab0b87b7d4ee")
    static final StyleKey FILLCOLOR = createStyleKey("COMMUNICATIONNETWORK_FILLCOLOR", MetaKey.FILLCOLOR);

    @objid ("3af5172c-29c5-4bbb-9432-55ea9bb0ea8e")
    static final StyleKey FILLMODE = createStyleKey("COMMUNICATIONNETWORK_FILLMODE", MetaKey.FILLMODE);

    @objid ("ea7acf57-b9b1-452a-85c1-d2dc3172a06a")
    static final StyleKey LINECOLOR = createStyleKey("COMMUNICATIONNETWORK_LINECOLOR", MetaKey.LINECOLOR);

    @objid ("c6d00151-7b73-425d-91a5-306caf3b7325")
    static final StyleKey LINEWIDTH = createStyleKey("COMMUNICATIONNETWORK_LINEWIDTH", MetaKey.LINEWIDTH);

    @objid ("e8be6043-cecd-4e64-b416-2c67a3f1b179")
    static final StyleKey FONT = createStyleKey("COMMUNICATIONNETWORK_FONT", MetaKey.FONT);

    @objid ("f69ca7e0-c325-4555-934b-f00328f011c2")
    static final StyleKey TEXTCOLOR = createStyleKey("COMMUNICATIONNETWORK_TEXTCOLOR", MetaKey.TEXTCOLOR);

    @objid ("b6294cab-1c64-42f9-b5c6-66f2dd850f97")
    static final StyleKey SHOWSTEREOTYPES = createStyleKey("COMMUNICATIONNETWORK_SHOWSTEREOTYPES", MetaKey.SHOWSTEREOTYPES);

    @objid ("5bead85e-3312-4832-9539-336f312e01f8")
    static final StyleKey SHOWTAGS = createStyleKey("COMMUNICATIONNETWORK_SHOWTAGS", MetaKey.SHOWTAGS);

}

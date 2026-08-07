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
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmCommunicationNetwork when its representation mode is RepresentationMode.IMAGE
 */
@objid ("e379e241-84b2-4cf4-b86f-f622f626b9e7")
public class GmCommunicationNetworkImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("1bcf524f-aec8-4961-8e16-4a2297a7dee8")
    static final StyleKey REPMODE = GmCommunicationNetworkStructuredStyleKeys.REPMODE;

    @objid ("226051db-000d-40ad-928a-4e225de100f2")
    static final StyleKey FONT = GmCommunicationNetworkStructuredStyleKeys.FONT;

    @objid ("ff5fdd83-e68e-4c38-a65f-bdc44b27f617")
    static final StyleKey TEXTCOLOR = GmCommunicationNetworkStructuredStyleKeys.TEXTCOLOR;

    @objid ("bc2372dc-ae1a-4b73-80e1-95bafbc9ecd5")
    static final StyleKey SHOWSTEREOTYPES = GmCommunicationNetworkStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("ae25a7fb-a6fb-4d57-a1c9-da11dcb440a5")
    static final StyleKey SHOWTAGS = GmCommunicationNetworkStructuredStyleKeys.SHOWTAGS;

}

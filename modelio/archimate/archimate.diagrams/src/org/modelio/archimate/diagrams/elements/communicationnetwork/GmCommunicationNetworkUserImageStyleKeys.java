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
@objid ("c31403cd-103f-46d4-8791-89bdbee22df0")
public class GmCommunicationNetworkUserImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("28a3b7af-324c-47e2-b93c-09b2b3967e19")
    static final StyleKey REPMODE = GmCommunicationNetworkStructuredStyleKeys.REPMODE;

    @objid ("8626c778-b637-4b05-b094-42ac72786f82")
    static final StyleKey FONT = GmCommunicationNetworkStructuredStyleKeys.FONT;

    @objid ("9aecc323-ef4b-4c9a-8eae-867ade174222")
    static final StyleKey TEXTCOLOR = GmCommunicationNetworkStructuredStyleKeys.TEXTCOLOR;

    @objid ("426d18dc-b322-48e6-b9f7-b331e12cda1f")
    static final StyleKey SHOWSTEREOTYPES = GmCommunicationNetworkStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("38f97585-4e2f-4bac-b8c7-b2f0c1dea28e")
    static final StyleKey SHOWTAGS = GmCommunicationNetworkStructuredStyleKeys.SHOWTAGS;

}

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
 * This class provides the StyleKey constants for a GmCommunicationNetwork when its representation mode is RepresentationMode.SIMPLE
 */
@objid ("f8b3885a-9676-4792-9e61-0b8d08714560")
public class GmCommunicationNetworkSimpleStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("c244c54f-c3a7-4791-8316-aaf7c66d3603")
    static final StyleKey REPMODE = GmCommunicationNetworkStructuredStyleKeys.REPMODE;

    @objid ("23254885-3340-4c0a-b455-b262cd347588")
    static final StyleKey LINECOLOR = GmCommunicationNetworkStructuredStyleKeys.LINECOLOR;

    @objid ("223027b8-21f1-426d-a8a0-ed8eb2bac3fe")
    static final StyleKey FONT = GmCommunicationNetworkStructuredStyleKeys.FONT;

    @objid ("fbea6d0a-76c1-4b5b-b9e6-f90fc390637e")
    static final StyleKey TEXTCOLOR = GmCommunicationNetworkStructuredStyleKeys.TEXTCOLOR;

    @objid ("d2a9350b-329c-4663-a892-2d795c807ade")
    static final StyleKey SHOWSTEREOTYPES = GmCommunicationNetworkStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("5ae60ef8-a42a-4661-bcf2-537f2cfd1750")
    static final StyleKey SHOWTAGS = GmCommunicationNetworkStructuredStyleKeys.SHOWTAGS;

    @objid ("5d7397ca-ccfd-4989-8c5a-dbdb40d42488")
    static final StyleKey FILLCOLOR = GmCommunicationNetworkStructuredStyleKeys.FILLCOLOR;

}

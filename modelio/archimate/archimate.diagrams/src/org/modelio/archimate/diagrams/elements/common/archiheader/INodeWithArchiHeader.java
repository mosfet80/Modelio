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
package org.modelio.archimate.diagrams.elements.common.archiheader;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.diagram.elements.common.header.GmModelElementHeader;
import org.modelio.diagram.styles.core.StyleKey.RepresentationMode;

@objid ("90cfd09b-656c-4638-bbff-758539e31551")
public interface INodeWithArchiHeader {
    @objid ("8c1807bd-9338-4873-8d11-b00a5aa5b234")
    GmModelElementHeader getHeader();

    @objid ("84642373-b051-487a-83e8-2acfa207080f")
    RepresentationMode getRepresentationMode();

}

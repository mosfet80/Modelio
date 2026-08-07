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
package org.modelio.archimate.diagrams.editor.viewpointdiagram;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.viewpointdiagram.GmViewPointDiagram;
import org.modelio.archimate.metamodel.core.ViewPointDiagram;
import org.modelio.diagram.editor.IDiagramEditorInputProvider.GmDiagramCreator;
import org.modelio.diagram.elements.common.abstractdiagram.GmAbstractDiagram;
import org.modelio.diagram.elements.core.model.IGmDiagram.IModelManager;
import org.modelio.metamodel.diagrams.AbstractDiagram;
import org.modelio.vcore.smkernel.mapi.MRef;

@objid ("5dd5f162-5aff-4267-8007-1b6196dacc15")
public final class ViewPointGmDiagramCreator implements GmDiagramCreator {
    @objid ("221c3d94-86eb-44cc-b27b-7127c5ce4378")
    @Override
    public GmAbstractDiagram createDiagram(IModelManager modelManager, AbstractDiagram diagram) {
        if (diagram instanceof ViewPointDiagram) {
            return new GmViewPointDiagram(modelManager, (ViewPointDiagram) diagram, new MRef(diagram));
        }
        return null;
    }

}

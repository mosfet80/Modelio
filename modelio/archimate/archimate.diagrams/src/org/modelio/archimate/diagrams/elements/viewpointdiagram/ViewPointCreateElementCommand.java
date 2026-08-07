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
package org.modelio.archimate.diagrams.elements.viewpointdiagram;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.core.structure.ViewPoint;
import org.modelio.diagram.elements.core.commands.DefaultCreateElementCommand;
import org.modelio.diagram.elements.core.commands.ModelioCreationContext;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.elements.core.node.GmCompositeNode;
import org.modelio.vcore.smkernel.mapi.MObject;

@objid ("aa21ca80-4599-46e5-944e-b06aa5a1612b")
public class ViewPointCreateElementCommand extends DefaultCreateElementCommand {
    /**
     * Creates a node creation command.
     *
     * @param parentNode The parent node
     * @param context Details on the MObject and/or the node to create
     * @param constraint The initial constraint of the created node.
     */
    @objid ("4b08ba34-f813-4ad6-be40-2a6c7ce8851c")
    public ViewPointCreateElementCommand(GmCompositeNode parentNode, ModelioCreationContext context, Object constraint) {
        super(parentNode, context, constraint);
    }

    /**
     * Creates a node creation command.
     *
     * @param parentElement The parent MObject of the MObject to create
     * @param parentNode The parent node
     * @param context Details on the MObject and/or the node to create
     * @param constraint The initial constraint of the created node.
     */
    @objid ("52cce727-4ee3-4648-a5bd-baec0c498f10")
    public ViewPointCreateElementCommand(MObject parentElement, GmCompositeNode parentNode, ModelioCreationContext context, Object constraint) {
        super(parentElement,parentNode, context,constraint);
    }

    @objid ("3fdfb370-1af0-463f-90ce-75f625ef8c4d")
    @Override
    protected MObject createElement(final IGmDiagram diagram) {
        if(this.context.getMetaclass().getName().equals(ViewPoint.MNAME)){
            ViewPoint viewPoint = (ViewPoint)super.createElement(diagram);
            if(viewPoint.getCompositionOwner() instanceof ViewPoint){
                viewPoint.setContext(((ViewPoint)viewPoint.getCompositionOwner()).getContext());
            }

            return viewPoint;
        }else{
            return super.createElement(diagram);
        }

    }

}

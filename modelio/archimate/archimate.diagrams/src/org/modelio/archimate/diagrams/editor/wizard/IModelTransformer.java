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
package org.modelio.archimate.diagrams.editor.wizard;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.jface.viewers.ISelection;
import org.modelio.metamodel.diagrams.AbstractDiagram;

@objid ("2e2543cb-c3a4-4ef0-b603-16a1152eae59")
public interface IModelTransformer {
    /**
     * Return true is the transformer is theoretically able to carry out a transformation given the diagram and the selection. This check will make the transformation command appear or not in the GUI. Tips: - try to keep this evaluation as light and fast
     * as possible - consider <code>canExecute()</code> alternative that only "grays" the transformation command. A greyed command has some indicative value to the end-user which is sometimes more clear than an 'not visible' command.
     * @return
     */
    @objid ("6165f6b4-2155-4631-bb34-75beba682dc3")
    boolean isAvailable(AbstractDiagram diagram, ISelection selection);

    /**
     * Execute the transformation.
     * @return
     */
    @objid ("a802a686-9373-408f-8927-4595462027e2")
    boolean transform(ISelection selection);

    /**
     * Return true is the transformer can be run given the diagram, the selection and the model current state. Typically this method checks read only conditions, model links, values and so on. The effect of returning false is a 'greyed' command (i.e. disable
     * but visible) that is an indication to the end-user that some transformation could be possible but is not executable immediately.
     * @return
     */
    @objid ("91b70388-0533-425c-9977-53833d88c72a")
    boolean canExecute(AbstractDiagram diagram, ISelection selection);

    /**
     * return the metaclassname of the targeted result
     * @return
     */
    @objid ("dc7b2bbe-2548-4ca3-bbe7-5206c91111cc")
    String getTargetMetaclassName();

}

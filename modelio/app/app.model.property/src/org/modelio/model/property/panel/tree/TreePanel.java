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
package org.modelio.model.property.panel.tree;

import java.util.Objects;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.modelio.metamodel.mda.ModuleComponent;
import org.modelio.metamodel.uml.infrastructure.Element;
import org.modelio.metamodel.uml.infrastructure.Stereotype;

@objid ("8faeec99-c068-11e1-8c0a-002564c97630")
public class TreePanel extends Composite {
    @objid ("8faeec9c-c068-11e1-8c0a-002564c97630")
    private Element currentElement = null;

    @objid ("7128b332-5495-4054-852e-489eb92222bd")
    private Object lastSelectedType = null;

    @objid ("da391a18-0fc8-4141-a993-14f04594dce3")
    private TreeViewer viewer = null;

    @objid ("8faeec9b-c068-11e1-8c0a-002564c97630")
    private TreeLabelProvider annotationLabelProvider = null;

    @objid ("29c3d158-164b-4b7e-a92b-60c0cb974667")
    private TreeContentProvider contentProvider;

    @objid ("8faeeca3-c068-11e1-8c0a-002564c97630")
    public TreePanel(SashForm sash, int style) {
        super(sash, style);

        this.annotationLabelProvider = new TreeLabelProvider();

        createGUI();

    }

    @objid ("8faeeca8-c068-11e1-8c0a-002564c97630")
    private void createGUI() {
        Composite treeArea = new Composite(this, SWT.NONE);
        treeArea.setLayout(new FillLayout());

        this.viewer = new TreeViewer(treeArea, SWT.MULTI | SWT.BORDER | SWT.V_SCROLL);
        this.viewer.setLabelProvider(this.annotationLabelProvider);
        this.contentProvider = new TreeContentProvider();
        this.viewer.setContentProvider(this.contentProvider);
        this.viewer.setAutoExpandLevel(3);

        initEditor();

    }

    @objid ("8faeecaa-c068-11e1-8c0a-002564c97630")
    @Override
    public boolean setFocus() {
        return this.viewer.getControl().setFocus();
    }

    @objid ("8fb14da6-c068-11e1-8c0a-002564c97630")
    private void initEditor() {
        // Define cell editor:
        TextCellEditor[] cellEditors = new TextCellEditor[1];
        cellEditors[0] = new TextCellEditor(this.viewer.getTree(), SWT.NONE);
        this.viewer.setCellEditors(cellEditors);

        // Define ICellModifier:
        String[] properties = new String[1];
        properties[0] = "name";
        this.viewer.setColumnProperties(properties);

    }

    /**
     *
     * @return the tree viewer.
     */
    @objid ("8fb14daa-c068-11e1-8c0a-002564c97630")
    public TreeViewer getTreeViewer() {
        return this.viewer;
    }

    /**
     * Select the given model element in the annotation view.
     *
     * @param target the model element to select.
     */
    @objid ("8fb14db1-c068-11e1-8c0a-002564c97630")
    private void select(final Object target) {
        if (this.currentElement == null) {
            this.viewer.setSelection(null);
            return;
        }

        if (target == null) {
            // neither stereotype nor module => SmClass
            this.viewer.setSelection(new TreeSelection(new TreePath(new Object[] { this.currentElement.getMClass() })));
        } else {
            TreePath treePath = new TreePath(new Object[] { target });
            this.viewer.setSelection(new TreeSelection(treePath), true);
            setLastType(target);
        }

    }

    @objid ("8fb14dba-c068-11e1-8c0a-002564c97630")
    public void setLastType(final Object typeItem) {
        if (typeItem instanceof Stereotype) {
            this.lastSelectedType = typeItem;
        } else if (typeItem instanceof ModuleComponent) {
            this.lastSelectedType = typeItem;
        } else {
            // Don't keep the selection if it is nor a module, nor stereotype
            this.lastSelectedType = null;
        }

    }

    /**
     *
     * @param newInput the new input
     */
    @objid ("8fb14dbe-c068-11e1-8c0a-002564c97630")
    public void setInput(TreePanelInput newInput) {
        this.contentProvider.setShowHiddenMdaElements(newInput.isDisplayHiddenAnnotations());

        Element typedElement = newInput.getTypedElement();
        Object typingElement = newInput.getPreselectedTypingElement();

        if (Objects.equals(typedElement, this.currentElement)) {
            // The current element did not change, only the tree selection moved
            select(typingElement);
            this.viewer.refresh();
            // Fast exit
            return;
        }

        this.currentElement = typedElement;
        this.viewer.setInput(this.currentElement);
        if (this.currentElement != null) {
            if (typingElement != null) {
                select(typingElement);
            } else {
                // try to find an optimal default selection.
                // rules are:
                // - try to find a stereotype or module of the same type as the last selected one
                // - if not, select the model element's class itself
                select(this.lastSelectedType);
                if (this.viewer.getSelection().isEmpty()) {
                    select(typedElement.getMClass());
                }
            }
        }

    }

    /**
     *
     * @return the last selected annotation set
     */
    @objid ("2df98193-c68e-44aa-94ab-4c3b02901c21")
    public Object getLastSelectedType() {
        return this.lastSelectedType;
    }

}

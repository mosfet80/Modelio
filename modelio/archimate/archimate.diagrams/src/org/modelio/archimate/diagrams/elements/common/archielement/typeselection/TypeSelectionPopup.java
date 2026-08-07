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
package org.modelio.archimate.diagrams.elements.common.archielement.typeselection;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.modelio.api.modelio.model.scope.ElementScope;
import org.modelio.archimate.diagrams.plugin.ArchiDiagrams;
import org.modelio.metamodel.uml.infrastructure.Stereotype;
import org.modelio.platform.mda.infra.MdaResources;
import org.modelio.platform.model.ui.swt.images.MetamodelImageService;
import org.modelio.platform.ui.dialog.ModelioDialog;

/**
 * Dialog used to resolve ambiguity on the link type to create
 */
@objid ("96070f74-a825-44d9-8935-de0e98182836")
public class TypeSelectionPopup extends ModelioDialog {
    @objid ("5f03f9be-0dee-4052-a722-9e11e54b04b9")
    protected TypeSelectionModel model;

    @objid ("cd468117-374e-423b-af00-988be014b29b")
    protected Composite composite;

    @objid ("2d89f43b-4df8-4c2f-b5cb-2839e2d8c838")
    protected Button okButton;

    /**
     * C'tor.
     *
     * @param shell The shell to use to create this dialog.
     * @param model The model to use for this popup.
     */
    @objid ("9560dcfe-c2cd-42de-b407-2434fdf47198")
    public TypeSelectionPopup(final Shell shell, final TypeSelectionModel model) {
        super(shell);
        this.model = model;
        setShellStyle(SWT.TITLE |
                SWT.RESIZE |
                SWT.BORDER |
                SWT.APPLICATION_MODAL |
                Window.getDefaultOrientation());

    }

    @objid ("4ed7d233-c453-4224-835e-c09be6d06345")
    @Override
    protected boolean canHandleShellCloseEvent() {
        return false;
    }

    @objid ("87c0a8b4-82fa-4858-afad-42444644e463")
    @Override
    public Control createContentArea(final Composite parent) {
        this.composite = new Composite(parent, SWT.NONE);
        this.composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        this.composite.setLayout(new GridLayout(1, true));

        TreeViewer treeViewer = new TreeViewer(this.composite, SWT.BORDER);
        treeViewer.setContentProvider(new TypeSelectionContentProvider());
        treeViewer.setLabelProvider(new TypeSelectionLabelProvider());
        treeViewer.setInput(this.model);
        treeViewer.expandAll();
        treeViewer.setAutoExpandLevel(2);
        treeViewer.getTree().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

        treeViewer.addSelectionChangedListener(new ISelectionChangedListener() {
            @Override
            public void selectionChanged(SelectionChangedEvent event) {
                ISelection selection = event.getSelection();
                if (selection instanceof StructuredSelection) {
                    Optional<ElementScope> selectedObject = (Optional<ElementScope>) ((StructuredSelection) selection).getFirstElement();
                    TypeSelectionPopup.this.model.setSelectedType(selectedObject.orElse(null));
                    TypeSelectionPopup.this.okButton.setEnabled(!((StructuredSelection) selection).isEmpty());
                }
            }
        });
        return this.composite;
    }

    @objid ("1c4449e4-1068-4913-b057-9b60fd052aaa")
    @Override
    public void addButtonsInButtonBar(final Composite parent) {
        this.okButton = createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
        createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);

    }

    @objid ("f5bdb5db-2bc3-4264-8715-4c61bdc965ce")
    @Override
    public void init() {
        // Put the window title, dialog title and dialog message
        getShell().setText(ArchiDiagrams.I18N.getMessage("TypeSelectionPopup.WindowTitle"));
        setTitle(ArchiDiagrams.I18N.getMessage("TypeSelectionPopup.DialogTitle"));
        setMessage(ArchiDiagrams.I18N.getMessage("TypeSelectionPopup.DialogMessage"));

        // Set minimum size
        getShell().setMinimumSize(400, 300);

    }

    @objid ("290bec4e-f5cd-4af7-babe-5be3958bdfb4")
    @Override
    protected Point getInitialSize() {
        return new Point(400, 400);
    }

    @objid ("3b1fa83c-a1ec-4c66-a0eb-36a20e178e63")
    @Override
    protected Point getInitialLocation(final Point initialSize) {
        return super.getInitialLocation(initialSize);
    }

    /**
     * Label and image provider for the type selection dialog.
     */
    @objid ("90d06d47-0024-4851-b69a-160d1fe0c466")
    private static class TypeSelectionLabelProvider extends LabelProvider {
        @objid ("8caf572c-d55d-4780-89ea-c6092e1aa80f")
        public TypeSelectionLabelProvider() {
            super();
        }

        @objid ("f724c584-cd49-44d5-bb61-bea90afc1efe")
        @Override
        public Image getImage(final Object obj) {
            if (obj instanceof Optional) {
                ElementScope element = ((Optional<ElementScope>) obj).orElse(null);
                if (element != null) {
                    Stereotype stereotype = element.getStereotype();
                    if (stereotype != null) {
                        return MdaResources.getIcon(stereotype);
                    } else {
                        return MetamodelImageService.getIcon(element.getMetaclass());
                    }
                } else {
                    return null;
                }
            }
            return super.getImage(obj);
        }

        @objid ("eb933f2c-97e1-408f-8793-e8c4f062a03c")
        @Override
        public String getText(final Object obj) {
            if (obj instanceof Optional) {
                ElementScope element = ((Optional<ElementScope>) obj).orElse(null);
                if (element != null) {
                    Stereotype stereotype = element.getStereotype();
                    if (stereotype != null) {
                        return MdaResources.getLabel(stereotype);
                    } else {
                        return element.getMetaclass().getName();
                    }
                } else {
                    return ArchiDiagrams.I18N.getMessage("TypeSelectionPopup.NoneChoice");
                }
            }
            return obj.toString();
        }

    }

    /**
     * Content provider for the type selection dialog.
     */
    @objid ("31c64077-5ed5-440d-a311-b472f25befca")
    private static class TypeSelectionContentProvider implements ITreeContentProvider {
        @objid ("1d47da6a-92da-4a3b-8dd2-ee78b1cb2825")
        public TypeSelectionContentProvider() {
            super();
        }

        @objid ("5abcd75d-a605-40e3-a6e3-e575d3620b35")
        @Override
        public void inputChanged(final Viewer viewer, final Object oldInput, final Object newInput) {
            // Nothing to do.
        }

        @objid ("4b19a28c-aa36-49a9-99ee-b71114e2d218")
        @Override
        public void dispose() {
            // Nothing to do.
        }

        @objid ("4005de0d-6492-47d3-be0f-e359dceab9c0")
        @Override
        public boolean hasChildren(final Object element) {
            return element instanceof TypeSelectionModel;
        }

        @objid ("1f82328c-ce20-4b0c-8f14-8b8279a6281e")
        @Override
        public Object getParent(final Object element) {
            return null;
        }

        @objid ("42e846fb-979f-44b6-a412-2dc7fa30936b")
        @Override
        public Object[] getElements(final Object inputElement) {
            List<Object> ret = new ArrayList<>();
            List<ElementScope> allowedTypes = ((TypeSelectionModel) inputElement).getAllowedTypes();
            for (ElementScope type : allowedTypes) {
                if (type == null) {
                    ret.add(Optional.empty());
                } else {
                    ret.add(Optional.of(type));
                }
            }
            return ret.toArray();
        }

        @objid ("5097bdeb-03d6-45f1-afaa-71f1a5124873")
        @Override
        public Object[] getChildren(final Object parentElement) {
            if (parentElement instanceof TypeSelectionModel) {
                List<Object> ret = new ArrayList<>();
                List<ElementScope> allowedTypes = ((TypeSelectionModel) parentElement).getAllowedTypes();
                for (ElementScope type : allowedTypes) {
                    if (type == null) {
                        ret.add(Optional.empty());
                    } else {
                        ret.add(type);
                    }
                }
                return ret.toArray();
            }
            return null;
        }

    }

}

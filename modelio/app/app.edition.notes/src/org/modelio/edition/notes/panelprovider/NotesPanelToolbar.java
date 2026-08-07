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
package org.modelio.edition.notes.panelprovider;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.modelio.edition.notes.plugin.EditionNotes;
import org.modelio.platform.ui.panel.IPanelProvider;
import org.modelio.platform.ui.plugin.UI;

/**
 * Implement the tool bar of the Notes & Constraints panel.
 */
@objid ("2ddaa41e-4814-4f81-b61e-131e84da513c")
public class NotesPanelToolbar implements IPanelProvider {
    @objid ("68ea08fe-6f9e-49c2-9259-46dbe2eaf299")
    private ToolItem addConstraint;

    @objid ("38ac3dc4-6bb5-4652-b699-64acd9553c9d")
    private Composite tbComp;

    @objid ("a2c234e6-bf21-4790-8c4c-abd4407c64f0")
    private ToolItem addNote;

    @objid ("d1b8e886-182f-4bdd-9c8c-0a4c5663508b")
    private ToolItem addDescription;

    @objid ("6489ab2c-7985-4b63-a93a-af0f2777d094")
    private ToolItem removeAnnotation;

    @objid ("3fd8a36b-3e01-4588-8d8d-2dcfd82321c3")
    private ToolItem cleanContent;

    @objid ("dfcadc72-81ff-4877-a735-e65f2d2b591a")
    private ToolItem moveUp;

    @objid ("f528befc-0b34-4f45-9fa7-585a9b691667")
    private ToolItem moveDown;

    @objid ("5d778211-e1fe-48e2-aa2b-56395117b76e")
    private MenuItem horizontalLayout;

    @objid ("5a5e0a93-2c7a-417b-bc81-110f86e19a64")
    private MenuItem verticalLayout;

    @objid ("a700872e-ad33-47f5-8b65-9e5a8c81e17c")
    private MenuItem autoLayout;

    @objid ("80c8f62a-ccd4-443f-9796-40abb2bbc930")
    private ToolItem addDocument;

    @objid ("14674e5a-0e10-4402-9aea-cb0e81f8c38c")
    private NotesPanelController controller;

    /**
     * C'Tor
     *
     * @param controller the controller of the GUI panel owning the tool bar
     */
    @objid ("3e929c96-c812-4811-8401-f0783c4a15d6")
    public NotesPanelToolbar(NotesPanelController controller) {
        NotesPanelToolbar.this.controller = controller;
    }

    @objid ("de82d177-a31a-4ece-b16e-79b53a6ac164")
    @Override
    public boolean isRelevantFor(Object obj) {
        return true;
    }

    @objid ("d8d9e865-1ee1-4ec3-a210-dacb3926c593")
    @Override
    public Object createPanel(Composite parent) {
        this.tbComp = new Composite(parent, SWT.NONE);
        GridLayout gl = new GridLayout(2, false);
        gl.horizontalSpacing = gl.verticalSpacing = 0;
        gl.marginHeight = gl.marginTop = gl.marginBottom = -1;
        gl.marginLeft = gl.marginRight = gl.marginWidth = 0;
        this.tbComp.setLayout(gl);

        ToolBar tb = new ToolBar(this.tbComp, SWT.HORIZONTAL);
        tb.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false));

        this.addConstraint = createToolButton(tb, SWT.PUSH, EditionNotes.getImageDescriptor("icons/addconstraint.png"), "$AddConstraint.tooltip");
        this.addConstraint.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                NotesPanelToolbar.this.tbComp.setFocus();
                NotesPanelToolbar.this.controller.onAddConstraint();
            }
        });

        this.addNote = createToolButton(tb, SWT.PUSH, EditionNotes.getImageDescriptor("icons/addnote.png"), "$AddNote.tooltip");
        this.addNote.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                NotesPanelToolbar.this.tbComp.setFocus();
                NotesPanelToolbar.this.controller.onAddNote();
            }
        });

        this.addDescription = createToolButton(tb, SWT.PUSH, EditionNotes.getImageDescriptor("icons/adddescription.png"), "$AddDescription.tooltip");
        this.addDescription.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                NotesPanelToolbar.this.tbComp.setFocus();
                NotesPanelToolbar.this.controller.onAddDescription();
            }
        });

        this.addDocument = createToolButton(tb, SWT.PUSH, EditionNotes.getImageDescriptor("icons/adddocument.png"), "$AddDocument.tooltip");
        this.addDocument.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                NotesPanelToolbar.this.tbComp.setFocus();
                NotesPanelToolbar.this.controller.onAddRichNote();
            }
        });

        this.removeAnnotation = createToolButton(tb, SWT.PUSH, UI.getImageDescriptor("icons/delete.png"), "$RemoveAnnotation.tooltip");
        this.removeAnnotation.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                NotesPanelToolbar.this.tbComp.setFocus();
                NotesPanelToolbar.this.controller.onRemoveAnnotation();
            }
        });

        this.cleanContent = createToolButton(tb, SWT.PUSH, EditionNotes.getImageDescriptor("icons/cleannote.png"), "$CleanNote.tooltip");
        this.cleanContent.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                NotesPanelToolbar.this.tbComp.setFocus();
                NotesPanelToolbar.this.controller.onCleanContent();
            }
        });

        this.moveUp = createToolButton(tb, SWT.PUSH, UI.getImageDescriptor("icons/uparrow.png"), "$MoveUp.tooltip");
        this.moveUp.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                NotesPanelToolbar.this.tbComp.setFocus();
                NotesPanelToolbar.this.controller.onMoveUp();
            }
        });

        this.moveDown = createToolButton(tb, SWT.PUSH, UI.getImageDescriptor("icons/downarrow.png"), "$MoveDown.tooltip");
        this.moveDown.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                NotesPanelToolbar.this.tbComp.setFocus();
                NotesPanelToolbar.this.controller.onMoveDown();
            }
        });

        // Drop down menu to select layout mode
        final ToolItem dropDown = new ToolItem(tb, SWT.DROP_DOWN);
        final Menu menu = new Menu(tb.getShell(), SWT.POP_UP);

        this.autoLayout = createMenuItem(menu, SWT.RADIO, UI.getImageDescriptor("icons/automaticorientation.png"), "$SetAutoLayout.label", "$SetAutoLayout.tooltip");
        this.autoLayout.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                NotesPanelToolbar.this.controller.onAutomaticLayout();
            }
        });

        this.horizontalLayout = createMenuItem(menu, SWT.RADIO, UI.getImageDescriptor("icons/horizontalorientation.png"), "$SetHorizontalLayout.label", "$SetHorizontalLayout.tooltip");
        this.horizontalLayout.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                NotesPanelToolbar.this.controller.onHorizontalLayout();
            }
        });
        this.verticalLayout = createMenuItem(menu, SWT.RADIO, UI.getImageDescriptor("icons/verticalorientation.png"), "$SetVerticalLayout.label", "$SetVerticalLayout.tooltip");
        this.verticalLayout.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                NotesPanelToolbar.this.controller.onVerticalLayout();
            }
        });

        dropDown.addListener(SWT.Selection, event -> {
            if (event.detail == SWT.ARROW) {
                Rectangle rect = dropDown.getBounds();
                Point pt = new Point(rect.x, rect.y + rect.height);
                pt = tb.toDisplay(pt);
                menu.setLocation(pt.x, pt.y);
                menu.setVisible(true);
            }
        });
        return this.tbComp;
    }

    @objid ("5117beae-3f2d-4b20-8ff8-64d20963a7dd")
    @Override
    public Object getPanel() {
        return this.tbComp;
    }

    @objid ("05c6ce5c-d2c7-4334-823b-055f2b436406")
    @Override
    public String getHelpTopic() {
        return null;
    }

    @objid ("8b820737-6027-4c93-b4ee-61ba04635a18")
    @Override
    public Object getInput() {
        return null;
    }

    @objid ("b4dbb353-ec36-44f0-8256-e93fa799ea08")
    @Override
    public void setInput(Object input) {
        update();
    }

    @objid ("de9caf6a-ec29-4b99-9b59-3f10736436ff")
    private void update() {
        this.addConstraint.setEnabled(this.controller.canAddConstraint());
        this.addNote.setEnabled(this.controller.canAddNote());
        this.addDescription.setEnabled(this.controller.canAddNote());
        this.addDocument.setEnabled(this.controller.canAddDocument());
        this.removeAnnotation.setEnabled(this.controller.canRemoveAnnotation());
        this.cleanContent.setEnabled(this.controller.canCleanContent());
        this.moveDown.setEnabled(this.controller.canMoveDown());
        this.moveUp.setEnabled(this.controller.canMoveUp());

        this.verticalLayout.setSelection(this.controller.isVerticalLayout());
        this.horizontalLayout.setSelection(this.controller.isHorizontalLayout());
        this.autoLayout.setSelection(this.controller.isAutoLayout());
    }

    /**
     * Helper function to create tool item
     *
     * @param parent the parent toolbar
     * @param iconDescriptor the image to display on the tool item
     * @param tooltip the tool tip text for the tool item
     */
    @objid ("9c262707-acc6-44ba-9ea7-27689faca7e9")
    private ToolItem createToolButton(ToolBar parent, int style, ImageDescriptor iconDescriptor, String tooltip) {
        ToolItem item = new ToolItem(parent, style);
        // Get the icon and setup a listener for disposal
        if (iconDescriptor != null) {
            final Image icon = iconDescriptor.createImage();
            item.setImage(icon);
            parent.addDisposeListener(new DisposeListener() {
                @Override
                public void widgetDisposed(DisposeEvent e) {
                    icon.dispose();
                }
            });
        }

        item.setToolTipText(EditionNotes.I18N.getString(tooltip));
        return item;
    }

    @objid ("119b4f32-f5ee-4bc5-aaa2-f164599f2b45")
    @Override
    public void dispose() {
        // nothing to do
    }

    @objid ("589fee9a-a0cc-43a5-814e-2240f9f97d7e")
    private MenuItem createMenuItem(Menu parent, int style, ImageDescriptor iconDescriptor, String label, String tooltip) {
        MenuItem item = new MenuItem(parent, style);

        // Get the icon and setup a listener for disposal
        if (iconDescriptor != null) {
            final Image icon = iconDescriptor.createImage();
            item.setImage(icon);

            parent.addDisposeListener(new DisposeListener() {
                @Override
                public void widgetDisposed(DisposeEvent e) {
                    icon.dispose();
                }
            });
        }
        item.setText(EditionNotes.I18N.getString(label));
        item.setToolTipText(EditionNotes.I18N.getString(tooltip));
        return item;
    }

}

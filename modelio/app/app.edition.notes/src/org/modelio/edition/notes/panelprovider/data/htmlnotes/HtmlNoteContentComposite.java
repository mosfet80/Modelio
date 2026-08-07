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
package org.modelio.edition.notes.panelprovider.data.htmlnotes;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.e4.ui.services.EContextService;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.modelio.edition.notes.panelprovider.data.AbstractContentComposite;
import org.modelio.edition.notes.plugin.EditionNotes;
import org.modelio.metamodel.uml.infrastructure.ModelElement;
import org.modelio.metamodel.uml.infrastructure.Note;
import org.modelio.platform.ui.UIColor;
import org.modelio.platform.ui.htmleditor.HtmlComposer;
import org.modelio.vcore.session.api.transactions.ITransaction;
import org.modelio.vcore.session.impl.CoreSession;

/**
 * <p>
 * HTML Note content editor with read/write mode support. Uses HtmlComposer for
 * editing and Browser for reading.
 * </p>
 */
@objid ("7819d4fc-e7cb-4a9a-9f13-b46d4b725298")
public class HtmlNoteContentComposite extends AbstractContentComposite {
    @objid ("a17dfb92-19e6-4e11-8d19-3f631a37ccbe")
    private boolean isInWriteMode = false;

    @objid ("bbd806eb-7666-4775-87a5-64c79d2606e4")
    private String originalContent = "";

    @objid ("f0efb37f-8be9-4571-b1db-75be248d9cbd")
    private final Browser htmlBrowser;

    @objid ("164e2a0c-36a0-4688-b2af-f64d4e6baa11")
    private final StackLayout stackLayout;

    @objid ("30b57716-0dbb-4765-a8d8-601d9c6b6eb5")
    private final Composite containerComposite;

    @objid ("021040f9-26fb-453e-9854-b07c2ac5624e")
    private final Composite editionComposite;

    @objid ("c2daa14f-e625-456f-954c-6653dc9ffe27")
    private Button validateButton;

    @objid ("858ea4d9-f144-4e9e-b6ba-8b7ae6d2a37b")
    private Button cancelButton;

    @objid ("956b4340-0daf-4b19-a55e-999a9a39d014")
    private HtmlComposer htmlComposer;

    @objid ("bda4c5f0-8e1d-4590-8b2d-06456ec225e2")
    private Controler controler;

    @objid ("d618d5cb-e240-466b-8ebd-e32e144c937d")
    private Note note = null;

    @objid ("781a01be-a389-40f5-a59c-9a9c33325024")
    @Override
    public void setInput(final ModelElement aNote) {
        // Check if we are in write mode and content has been modified
        if (isInWriteMode && this.note != null) {
            String currentContent = this.htmlComposer.getHtml();
            if (!currentContent.equals(this.originalContent)) {
                validateChanges();
            }
        }

        if (aNote != null) {
            if (!aNote.equals(this.note) || !((Note) aNote).getContent().equals(this.originalContent)) {
                updateContent((Note) aNote);
            }
        } else if (this.note != null) {
            updateContent(null);
        }
        setWriteMode(false);
    }

    @objid ("93822920-a36a-4185-91d6-30a0bd2f08e0")
    @Override
    public Control getControl() {
        return this;
    }

    @objid ("d3a2e9f7-c588-48a2-a143-09ada737bd37")
    @Override
    public Note getNoteElement() {
        return this.note;
    }

    @objid ("809354b4-6c0a-4b83-8d8d-f1853c4f833e")
    private void enterEdition() {
        if (this.note != null && this.note.isModifiable() && !isInWriteMode) {
            deactivateContexts();
            // Store original content for cancel operation
            this.originalContent = this.note.getContent();
            setWriteMode(true);
            updateContent(this.note);
        }
    }

    @objid ("31a5b972-7f39-421b-b58c-b13d586c9f88")
    private void leaveEdition() {
        // Switch back to read mode when leaving edition
        setWriteMode(false);
        reactivateContexts();
    }

    @objid ("6cd6a4a8-a8b4-488e-ba13-9a269acf26d7")
    @Override
    public void dispose() {
        this.htmlComposer.dispose();
        this.htmlBrowser.dispose();
        super.dispose();
    }

    @objid ("e9e7aae2-41d1-4770-921b-c4136d2e0db0")
    public HtmlNoteContentComposite(Composite parentComposite, int style, EContextService contextService) {
        super(parentComposite, style, contextService);
        setLayout(new FillLayout());

        // Container composite with stack layout to switch between read/write modes
        this.containerComposite = new Composite(this, SWT.NONE);
        this.stackLayout = new StackLayout();
        this.containerComposite.setLayout(this.stackLayout);

        // Browser for read mode
        this.htmlBrowser = new Browser(this.containerComposite, SWT.BORDER);

        // Add mouse listener to browser for switching to write mode on click
        this.htmlBrowser.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseDown(MouseEvent e) {
                // Switch to write mode when clicking on the browser
                if (note != null && note.isModifiable()) {
                    enterEdition();
                    htmlComposer.setFocus();
                }
            }
        });


        // Edition composite for write mode (HtmlComposer + buttons)
        this.editionComposite = new Composite(this.containerComposite, SWT.BORDER);
        GridLayout editionLayout = new GridLayout(1, false);
        editionLayout.marginWidth = 0;
        editionLayout.marginHeight = 0;
        editionLayout.verticalSpacing = 0;
        editionLayout.horizontalSpacing = 0;
        this.editionComposite.setLayout(editionLayout);

        // Initially set to read mode
        setWriteMode(false);
    }

    /**
     * Updates the content in both Browser and HtmlComposer components
     */
    @objid ("4e89ce4d-f018-4b26-a2f3-98c7a0c23200")
    private void updateContent(Note aNote) {
        this.note = aNote;
        String content = this.note != null ? this.note.getContent() : "";
        this.originalContent = content;

        /*if(this.htmlComposer != null && !this.htmlComposer.isDisposed()) {
            this.htmlComposer.setEditable(this.note != null && this.note.isModifiable());
        }*/

        // Update HtmlComposer content
        if (isInWriteMode)
            this.htmlComposer.setHtml(content);

        // Update Browser content
        if (!content.equals(this.htmlBrowser.getText()))
            this.htmlBrowser.setText(content);
    }

    /**
     * Switches between read mode (Browser) and write mode (HtmlComposer)
     *
     * @param writeMode true for write mode (HtmlComposer), false for read mode
     * (Browser)
     */
    @objid ("4a053d8c-8959-4ef7-8a5f-29ce6ade55c6")
    private void setWriteMode(boolean writeMode) {
        this.isInWriteMode = writeMode;

        if (writeMode && this.note != null && this.note.isModifiable()) {

            // HTML Composer for write mode
            this.htmlComposer = new HtmlComposer(this.editionComposite, SWT.NONE);
            this.htmlComposer.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
            // Button composite
            Composite buttonComposite = new Composite(this.editionComposite, SWT.NONE);
            GridLayout buttonLayout = new GridLayout(2, false);
            buttonLayout.marginWidth = 0;
            buttonLayout.marginHeight = 5;
            buttonComposite.setLayout(buttonLayout);
            buttonComposite.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false));

            // Validate button
            this.validateButton = new Button(buttonComposite, SWT.PUSH);
            this.validateButton.setText(EditionNotes.I18N.getString("HtmlNoteComposite.validation"));
            this.validateButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
            this.validateButton.addSelectionListener(new SelectionAdapter() {
                @Override
                public void widgetSelected(SelectionEvent e) {
                    validateChanges();
                }
            });

            // Cancel button
            this.cancelButton = new Button(buttonComposite, SWT.PUSH);
            this.cancelButton.setText(EditionNotes.I18N.getString("HtmlNoteComposite.cancel"));
            this.cancelButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
            this.cancelButton.addSelectionListener(new SelectionAdapter() {
                @Override
                public void widgetSelected(SelectionEvent e) {
                    cancelChanges();
                }
            });

              // Controller
            this.controler = new Controler(this, this.htmlComposer);

            // Switch to write mode - show editionComposite (HtmlComposer + buttons)
            this.stackLayout.topControl = this.editionComposite;
        } else {

            // Dispose all children of editionComposite (htmlComposer, buttonComposite and its buttons)
            for (Control c : this.editionComposite.getChildren()) {
                if (!c.isDisposed()) {
                    c.dispose();
                }
            }
            this.htmlComposer = null;
            this.validateButton = null;
            this.cancelButton = null;

            // Switch to read mode - show Browser
            this.stackLayout.topControl = this.htmlBrowser;
        }

        this.containerComposite.layout(true, true);
        this.editionComposite.layout(true, true);
    }

    /**
     * Returns true if currently in write mode
     */
    @objid ("088cbb4b-bab1-4267-976c-863bd2b2ce94")
    public boolean isInWriteMode() {
        return this.isInWriteMode;
    }

    /**
     * Validates the changes and saves them to the note
     */
    @objid ("346a007c-4989-46ba-a1f0-24a65afcd770")
    private void validateChanges() {
        if (this.note != null && this.note.isModifiable()) {
            String newContent = this.htmlComposer.getHtml();
            this.controler.changeContent(this.note, newContent);
            this.htmlBrowser.setText(newContent);
        }
        setWriteMode(false);
    }

    /**
     * Cancels the changes and restores the original content
     */
    @objid ("b7846d61-0aa4-4ff0-a335-1b3c97e34876")
    private void cancelChanges() {
        if (this.note != null) {
            // Restore original content
            this.htmlComposer.setHtml(this.originalContent, true);
            // Return to read mode after cancellation
            setWriteMode(false);
        }
    }

    @objid ("9d1541a0-570d-46eb-966b-695e82b19752")
    private static class Controler {
        @objid ("1b3689ad-feff-4368-b9df-b0c042a4416a")
        public String lastContent = "";

        @objid ("9fa306f8-8ca5-44a0-8b6c-c5f890ebbed8")
        private final HtmlNoteContentComposite view;

        @objid ("836ad8f9-68c8-43a9-83cc-725afb528c5e")
        private final HtmlComposer htmlComposer;

        @objid ("f00283b2-6678-430b-b79f-c976fba85e07")
        public Controler(HtmlNoteContentComposite htmlNoteContentComposite, HtmlComposer htmlComposer) {
            this.view = htmlNoteContentComposite;
            this.htmlComposer = htmlComposer;
        }

        /**
         * The note text has been modified.<br/>
         * The model change event fired by the transaction is in charge of refreshing
         * the whole GUI.
         */
        @objid ("0bea3b3d-0856-4791-ab08-f3cc1f1c40a4")
        public void changeContent(Note editedNote, String s) {
            if (editedNote != null && editedNote.isModifiable() && !editedNote.getContent().equals(s)) {
                try (ITransaction transaction = CoreSession.getSession(editedNote).getTransactionSupport()
                        .createTransaction(EditionNotes.I18N.getString("UpdateNote"))) {
                    editedNote.setContent(s.replaceAll("\r\n", "\n"));
                    this.lastContent = editedNote.getContent();
                    transaction.commit();
                }
            }
        }

    }

}

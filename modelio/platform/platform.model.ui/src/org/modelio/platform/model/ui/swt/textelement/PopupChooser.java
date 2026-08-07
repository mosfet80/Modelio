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
package org.modelio.platform.model.ui.swt.textelement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.jface.dialogs.PopupDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.modelio.platform.model.ui.plugin.CoreUi;
import org.modelio.platform.model.ui.swt.images.BasicModelElementLabelProvider;
import org.modelio.platform.ui.swt.BrowserConfigurator;
import org.modelio.vcore.smkernel.mapi.MObject;

/**
 * This class provides the popup of proposed results that appears when user uses
 * the 'Ctrl+Space' completion shortcut and there are several valid results.
 */
@objid ("02f69a83-ef5d-436a-a1f8-292f025deeba")
public class PopupChooser extends PopupDialog {
    @objid ("9adf321f-3ecc-4edb-9f76-4a6969260dad")
    private static final int POPUP_MIN_HEIGHT = 200;

    @objid ("024101d5-8306-4314-8965-75595d786462")
    private static final int POPUP_MIN_WIDTH = 100;

    /**
     * InfoPopup delay in ms
     */
    @objid ("c1359f26-5142-44e1-9713-c5cb5e679897")
    private static final int INFO_POPUP_DELAY = 1000;

    @objid ("140b2cd9-e4d6-420e-b510-2bb2f5b1976f")
    protected boolean loop;

    @objid ("6c36dc65-1721-45a7-a9ef-1d29dcceb6cf")
    protected boolean proposeNullValue = false;

    /**
     * True is there is a pending InfoPopup
     */
    @objid ("424a3e47-87d7-4291-83c8-5c95104ff9ce")
    private boolean infoPopupIsPending;

    @objid ("b60a5e0b-4a68-447b-b341-8eba9d71ac2a")
    protected List<? extends MObject> elements;

    @objid ("6606ef5b-8406-44f5-a2c2-6dfaced72aef")
    protected Rectangle listRectangle;

    @objid ("0c622beb-4e5d-4131-9efb-0fce671a7755")
    protected Composite parent;

    @objid ("82189123-b314-41e8-8e7d-ecb38f7beca9")
    TableViewer tableViewer;

    @objid ("bb919c7f-6fc9-4eac-94bc-02eb95e89284")
    protected List<Object> list;

    @objid ("ab7ee49d-e6e2-4d2f-b802-bbbb6a6e6026")
    MObject selected;

    /*
             * Auxialiary popup showing detailed information about the selected
             * proposal..
             */
    @objid ("7ad9227d-057c-4cd0-b352-61be67e243da")
    private InfoPopup infoPopup;

    /**
     * Constructor initializing a ProposalPopup.
     *
     * @param control the swt control displaying the popup.
     * @param elements the elements to display in the popup.
     * @param proposeNullValue indicates whether or not the "null" value must be shown in the
     * popup.
     */
    @objid ("535d4103-ad37-4e13-95c5-da5f85edcff9")
    public PopupChooser(final Control control, final List<? extends MObject> elements, final boolean proposeNullValue) {
        super(control.getShell(), PopupDialog.INFOPOPUPRESIZE_SHELLSTYLE,
                /* take focus */true,
                /* persist size */false,
                /* persist location */false,
                /* show dialog menu */false,
                /* show persist action */false,
                /* info title */CoreUi.I18N.getMessage("ResultsProposalPopup.title"), //$NON-NLS-1$
                /* info description */CoreUi.I18N.getMessage("ResultsProposalPopup.description")); //$NON-NLS-1$

        this.parent = control.getParent();
        this.elements = elements;
        this.selected = null;
        this.loop = false;

        this.proposeNullValue = proposeNullValue;
        final Rectangle textRect = control.getBounds();
        final Rectangle tableRect = this.parent.getBounds();

        final int posX = textRect.x;
        final int posY = textRect.y;
        int width = textRect.width;
        int height = (tableRect.height - textRect.y);

        if (width < PopupChooser.POPUP_MIN_WIDTH) {
            width = PopupChooser.POPUP_MIN_WIDTH;
        }
        if (height < PopupChooser.POPUP_MIN_HEIGHT) {
            height = PopupChooser.POPUP_MIN_HEIGHT;
        }
        this.listRectangle = control.getDisplay().map(this.parent, null, new Rectangle(posX, posY, width, height));
    }

    /**
     * Open a popup to choose elements from.
     *
     * @param previousSelectedElt The initial selection
     * @return the element chosen in the popup. Might be <code>null</code>.
     */
    @objid ("1e2019fe-ef53-483c-b69e-82c10678f6f3")
    public MObject getChoice(final MObject previousSelectedElt) {
        final Display display = this.parent.getDisplay();

        open();

        setTitleText(CoreUi.I18N.getMessage("ResultsProposalPopup.choose", this.elements.size())); //$NON-NLS-1$

        if (getShell().getSize().y < PopupChooser.POPUP_MIN_HEIGHT) {
            getShell().setSize(getShell().getSize().x, PopupChooser.POPUP_MIN_HEIGHT);
        }

        this.list = new ArrayList<>();
        this.list.addAll(this.elements);
        this.list.sort((o1, o2) -> ((MObject) o1).getName().compareTo(((MObject) o2).getName()));
        if (this.proposeNullValue) {
            this.list.add(0, CoreUi.I18N.getMessage("ResultsProposalPopup.None")); //$NON-NLS-1$
        }

        this.tableViewer.setInput(this.list);

        // Abort on ESC key
        this.tableViewer.getTable().addTraverseListener(e -> {
            if (e.detail == SWT.TRAVERSE_ESCAPE) {
                e.detail = SWT.TRAVERSE_NONE;
                this.selected = previousSelectedElt;
                this.loop = false;
            }
        });
        this.tableViewer.getTable().addKeyListener(KeyListener.keyPressedAdapter((KeyEvent e) ->{
            if (e.character == SWT.ESC) {
                this.loop = false;
            }
        }));

        // Validate on double click
        this.tableViewer.getTable().addSelectionListener(new SelectionListener() {

            /**
             * This one is called whenever the selection changes.<br>
             * For our table: on SingleClick an don navigation (up/down arrow)<br>
             * When the selection changes, the InfoPopup is displayed after a
             * short delay.
             *
             */
            @Override
            public void widgetSelected(SelectionEvent e) {
                final IStructuredSelection selection = (IStructuredSelection) PopupChooser.this.tableViewer.getSelection();
                if (selection.getFirstElement() instanceof MObject) {
                    PopupChooser.this.selected = (MObject) selection.getFirstElement();
                } else {
                    PopupChooser.this.selected = null;
                }
                scheduleInfoPopup();
            }

            /**
             * For our Table this one is called for <ENTER> and DoubleClick
             */
            @Override
            public void widgetDefaultSelected(SelectionEvent e) {
                final IStructuredSelection selection = (IStructuredSelection) PopupChooser.this.tableViewer.getSelection();
                if (selection.getFirstElement() instanceof MObject) {
                    PopupChooser.this.selected = (MObject) selection.getFirstElement();
                } else {
                    PopupChooser.this.selected = null;
                }
                PopupChooser.this.loop = false;
            }
        });

        // In case this dialog is disposed before exit of the local event loop
        getShell().addDisposeListener(
                e -> this.loop = false);

        // Run a local event loop to make the popup modal.
        this.loop = true;
        while (this.loop) {
            try {
                if (!display.readAndDispatch()) {
                    display.sleep();
                }
            } catch (final RuntimeException e) {
                CoreUi.LOG.error(e);
                this.loop = false; // Emergency exit
            }
        }

        close();
        return this.selected;
    }

    @objid ("37cfcc49-2e42-4a89-98d2-d9463d386804")
    @Override
    protected void adjustBounds() {
        getShell().setBounds(this.listRectangle);
    }

    @objid ("894d4fb4-51e1-4718-b8fd-b2589f0e50fe")
    @Override
    protected Control createDialogArea(final Composite area) {
        final Composite composite = (Composite) super.createDialogArea(area);
        composite.setLayout(new FillLayout(SWT.VERTICAL));

        // create TableCombo
        this.tableViewer = new TableViewer(composite, SWT.READ_ONLY | SWT.BORDER);

        // set the content provider
        this.tableViewer.setContentProvider(ArrayContentProvider.getInstance());

        // set the label provider
        this.tableViewer.setLabelProvider(new BasicModelElementLabelProvider() {
            @Override
            public String getText(Object obj) {
                if (obj instanceof MObject) {
                    String s = super.getText(obj);
                    MObject owner = ((MObject) obj).getCompositionOwner();
                    if (owner != null) {
                        s = s + " " + CoreUi.I18N.getMessage("ResultsProposalPopup.From", owner.getName());
                    }
                    return s;
                } else if (obj instanceof String) {
                    return (String) obj;
                } else {
                    return obj.toString();
                }
            }

            @Override
            public Image getImage(Object obj) {
                if (obj instanceof MObject) {
                    return super.getImage(obj);
                }
                return null;
            }

            @Override
            public StyledString getStyledText(Object obj) {
                if (obj instanceof MObject) {
                    return super.getStyledText(obj);
                }
                return null;
            }
        });

        // load the data
        this.tableViewer.setInput(Collections.EMPTY_LIST);

        // add listener
        // this.tcv.addSelectionChangedListener(new ItemSelected("Sample1"));
        return composite;
    }

    @objid ("98733cad-0a73-4919-ac7d-99b91fb36bf5")
    @Override
    protected Point getInitialLocation(final Point initialSize) {
        return new Point(this.listRectangle.x, this.listRectangle.y);
    }

    @objid ("9243a6b4-13c7-4ac2-b409-f5108f16a8f9")
    @Override
    protected Point getInitialSize() {
        return new Point(PopupChooser.POPUP_MIN_WIDTH, PopupChooser.POPUP_MIN_HEIGHT);
    }

    /**
     * Build the element description that is displayed in the info popup
     * @return
     */
    @objid ("e0d440de-72f1-4e47-a2dd-b1c855d4950d")
    String getElementInfo(MObject element) {
        return ElementHtmlTooltip.getHtml(element);
    }

    @objid ("b5443d7a-ca32-4438-a874-529b7ec751dd")
    boolean isActive() {
        return (this.tableViewer != null && !this.tableViewer.getTable().isDisposed());
    }

    /**
     * Show details about selectedElement after a short delay in an auxiliary
     * InfoPopup.
     */
    @objid ("fea0beb7-d3e5-4b34-aeaa-25f2aa4f7137")
    void scheduleInfoPopup() {
        // If there is already a currently pending InfoPopup,just return
        if (this.infoPopupIsPending) {
            return;
        }

        if (this.infoPopup != null) {
            this.infoPopup.setContents(getElementInfo(this.selected));
            return;
        }

        // Delays the creation of the info popup.
        getShell().getDisplay().timerExec(PopupChooser.INFO_POPUP_DELAY,
                () -> doShowInfoPopup());

        this.infoPopupIsPending = true;
    }

    /**
     * Show details about selectedElement immediately in an auxiliary
     * InfoPopup.
     */
    @objid ("e949830c-bb38-4aa3-8225-55112457b998")
    void doShowInfoPopup() {
        if (!isActive()) {
            return;
        }

        // If there is no info popup , create one
        if (this.selected != null) {
            if (this.infoPopup == null) {
                this.infoPopup = new InfoPopup(getShell());
                this.infoPopup.open();
                this.infoPopup.getShell().addDisposeListener(
                        event -> this.infoPopup = null);
            }
            // Set the info popup text
            this.infoPopup.setContents(getElementInfo(PopupChooser.this.selected));
        } else if (this.infoPopup != null) {
            // When there is no selection, close the info popup
            this.infoPopup.close();
        }
        this.infoPopupIsPending = false;
    }

    /**
     * This class is the companion info popup that describes the current
     * selection in the PopupChooser
     */
    @objid ("2b029dce-b4fe-46af-b949-f51d35f14e01")
    private static class InfoPopup extends PopupDialog {
        @objid ("6fdf4b3d-9127-48eb-ab4f-d74667779c49")
        private static final String EMPTY = "";

        /**
         * The description text displayed in the popup.
         */
        @objid ("e05f7400-3311-4c6f-bd91-73548e40e4fd")
        private String contents = InfoPopup.EMPTY;

        /**
         * The text control that displays the description.
         */
        @objid ("7830eab3-9710-4d87-ab0f-5c68492a3081")
        private Browser text;

        /**
         * Construct an info-popup with the specified parent.
         */
        @objid ("1f06a357-9c2c-4f75-b61b-211cffcd7905")
        InfoPopup(Shell parent) {
            super(parent,
                    PopupDialog.HOVER_SHELLSTYLE | SWT.RESIZE,
                    /* takefocusOnOpen */false,
                    /* persistSize */false,
                    /* persistLocation */ false,
                    /* showDialogMenu */false,
                    /* showPersistActions */false,
                    /* titleText */null,
                    /* infoText */null);
        }

        @objid ("d8dc3933-d23c-4112-bc20-922dfefd5292")
        @Override
        protected Control createDialogArea(Composite parentComposite) {
            this.text = BrowserConfigurator.newBrowser(parentComposite, SWT.NO_FOCUS);

            this.text.setBackground(getBackground());

            // Use the compact margins employed by PopupDialog.
            final GridData gd = new GridData(GridData.BEGINNING | GridData.FILL_BOTH);
            gd.horizontalIndent = PopupDialog.POPUP_HORIZONTALSPACING;
            gd.verticalIndent = PopupDialog.POPUP_VERTICALSPACING;
            this.text.setLayoutData(gd);
            this.text.setText(this.contents);
            return this.text;
        }

        /**
         * Position the info popup adjacent to the proposal popup
         */
        @objid ("09c56136-2edd-4d84-a0b7-141d10102cd8")
        @Override
        protected void adjustBounds() {
            final Rectangle parentBounds = getParentShell().getBounds();
            Rectangle proposedBounds;
            // Try placing the info popup to the right
            Rectangle rightProposedBounds = new Rectangle(
                    parentBounds.x + parentBounds.width + PopupDialog.POPUP_HORIZONTALSPACING,
                    parentBounds.y + PopupDialog.POPUP_VERTICALSPACING,
                    parentBounds.width,
                    parentBounds.height);
            rightProposedBounds = getConstrainedShellBounds(rightProposedBounds);
            // If it won't fit on the right, try the left
            if (rightProposedBounds.intersects(parentBounds)) {
                Rectangle leftProposedBounds = new Rectangle(
                        parentBounds.x - parentBounds.width - PopupDialog.POPUP_HORIZONTALSPACING - 1,
                        parentBounds.y,
                        parentBounds.width,
                        parentBounds.height);
                leftProposedBounds = getConstrainedShellBounds(leftProposedBounds);
                // If it won't fit on the left, choose the proposed bounds
                // that fits the best
                if (leftProposedBounds.intersects(parentBounds)) {
                    if (rightProposedBounds.x - parentBounds.x >= parentBounds.x - leftProposedBounds.x) {
                        rightProposedBounds.x = parentBounds.x + parentBounds.width + PopupDialog.POPUP_HORIZONTALSPACING;
                        proposedBounds = rightProposedBounds;
                    } else {
                        leftProposedBounds.width = parentBounds.x - PopupDialog.POPUP_HORIZONTALSPACING - leftProposedBounds.x;
                        proposedBounds = leftProposedBounds;
                    }
                } else {
                    // use the proposed bounds on the left
                    proposedBounds = leftProposedBounds;
                }
            } else {
                // use the proposed bounds on the right
                proposedBounds = rightProposedBounds;
            }
            getShell().setBounds(proposedBounds);
        }

        @objid ("cf265123-70ac-42fc-b25d-7ad805898c72")
        @Override
        protected Color getForeground() {
            return this.text.getDisplay().getSystemColor(SWT.COLOR_INFO_FOREGROUND);
        }

        @objid ("aaeeae4c-6acf-4db5-a078-8d8dd192db1f")
        @Override
        protected Color getBackground() {
            return this.text.getDisplay().getSystemColor(SWT.COLOR_INFO_BACKGROUND);
        }

        /**
         * Set the text contents of the popup.
         */
        @objid ("e66f23df-680f-4b45-abde-82b6b5d7024f")
        void setContents(String newContents) {
            if (newContents == null) {
                this.contents = InfoPopup.EMPTY;
            } else {
                this.contents = newContents;
            }

            if (this.text != null && !this.text.isDisposed()) {
                this.text.setText(this.contents);
            }
        }

        /**
         * Return whether the popup has focus.
         */
        @objid ("075e3891-ec84-40c7-9bf4-b3cb8fd8c8d1")
        boolean hasFocus() {
            if (this.text == null || this.text.isDisposed()) {
                return false;
            }
            return this.text.getShell().isFocusControl() || this.text.isFocusControl();
        }

    }

}

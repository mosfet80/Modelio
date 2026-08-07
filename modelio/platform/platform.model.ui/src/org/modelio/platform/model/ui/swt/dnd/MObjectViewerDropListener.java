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
package org.modelio.platform.model.ui.swt.dnd;

import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.core.runtime.Platform.OS;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.layout.RowLayoutFactory;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerDropAdapter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.TransferData;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.modelio.api.ui.dnd.ModelElementTransfer;
import org.modelio.metamodel.uml.infrastructure.AbstractProject;
import org.modelio.metamodel.uml.statik.Association;
import org.modelio.metamodel.uml.statik.ClassAssociation;
import org.modelio.metamodel.uml.statik.Link;
import org.modelio.metamodel.uml.statik.Operation;
import org.modelio.metamodel.uml.statik.Parameter;
import org.modelio.platform.model.ui.plugin.CoreUi;
import org.modelio.platform.model.ui.swt.SelectionHelper;
import org.modelio.platform.ui.UIColor;
import org.modelio.platform.ui.UIImages;
import org.modelio.vcore.model.api.MTools;
import org.modelio.vcore.session.api.model.IModel;
import org.modelio.vcore.session.api.transactions.ITransaction;
import org.modelio.vcore.session.api.transactions.ITransactionSupport;
import org.modelio.vcore.session.impl.CoreSession;
import org.modelio.vcore.smkernel.IllegalModelManipulationException;
import org.modelio.vcore.smkernel.mapi.MDependency;
import org.modelio.vcore.smkernel.mapi.MExpert;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.mapi.MRef;
import org.modelio.vcore.smkernel.mapi.MStatus;

/**
 * Drop listener implementation for a viewer containing MObjects.
 * <p>
 * Handles 'Copy' and 'Move' operations only.
 * </p>
 *
 * @see ModelElementTransfer
 */
@objid ("6f1a74cc-f75d-4e6c-9d92-05c7d75cbd7b")
public class MObjectViewerDropListener extends ViewerDropAdapter {
    /**
     * Last reason why a drop was forbidden, shown as a tooltip during drag.
     * Reset to {@code null} when the drop is valid.
     */
    @objid ("6bfcd669-0c27-4132-b056-aca75d81fee5")
    private String forbiddenReason;

    /**
     * Custom tooltip shell displayed when the drop is forbidden.
     * <p>
     * We use a Shell instead of SWT ToolTip (SWT.BALLOON) because balloon tooltips
     * require a TrayItem on Windows and will not appear without one.
     */
    @objid ("d9bb2215-cbbe-4eea-9fd5-1f05b82fbe2f")
    private Shell forbiddenTooltip;

    /**
     * Constructor initializing an instance of MObjectViewerDropListener.
     *
     * @param viewer the viewer were elements are dropped
     */
    @objid ("c328ed80-63d2-44d6-a3ea-cbc8a71fd5e4")
    public MObjectViewerDropListener(Viewer viewer) {
        super(viewer);
        this.setFeedbackEnabled(false);
    }

    // -------------------------------------------------------------------
    // Drag-over: show / hide the balloon tooltip
    // -------------------------------------------------------------------
    @objid ("4695e20f-80c4-406c-b104-59b33999a99f")
    @Override
    public void dragOver(DropTargetEvent event) {
        super.dragOver(event);
        if (event.detail == DND.DROP_NONE && this.forbiddenReason != null) {
            showForbiddenTooltip(this.forbiddenReason, event.x, event.y);
        } else {
            hideForbiddenTooltip();
        }
    }

    @objid ("4bf2a8bc-b215-40f4-8ec6-5a10480a2edc")
    @Override
    public void dragLeave(DropTargetEvent event) {
        hideForbiddenTooltip();
        super.dragLeave(event);
    }

    @objid ("df9edbe2-080c-42f6-998a-727f8e63ee48")
    @Override
    public void drop(DropTargetEvent event) {
        hideForbiddenTooltip();
        super.drop(event);
    }

    // -------------------------------------------------------------------
    // Tooltip helpers
    // -------------------------------------------------------------------
    @objid ("c669e5e2-93d5-4d5c-aadf-59a83ad0874f")
    private void showForbiddenTooltip(String reason, int cursorX, int cursorY) {
        // Recreate the shell if needed (disposed or first call)
        if (this.forbiddenTooltip == null || this.forbiddenTooltip.isDisposed()) {
            // SWT.TOOL gives a lightweight always-on-top window styled as a tooltip on all platforms.
            // SWT.BALLOON is NOT used here because on Windows it requires attachment to a TrayItem
            // and will not appear without one.

            int shellStyle = SWT.TOOL | SWT.ON_TOP ;
            if (OS.isLinux()) {
                shellStyle |= SWT.BORDER; // On Linux, display the border to hide a strange gray line at the bottom of the tooltip .
            }
            this.forbiddenTooltip = new Shell(getViewer().getControl().getShell(), shellStyle);
            RowLayoutFactory.swtDefaults().type(SWT.HORIZONTAL).center(true).applyTo(this.forbiddenTooltip);

            // Use SWT_LIST_* colors because on my Ubuntu machine the background is black, which is inconsistent with the rest of the UI.
            Color bgColor = UIColor.SWT_LIST_BACKGROUND;
            Color fgColor = UIColor.SWT_LIST_FOREGROUND;

            this.forbiddenTooltip.setBackground(bgColor);
            this.forbiddenTooltip.setForeground(fgColor);

            Label image = new Label(this.forbiddenTooltip, SWT.NONE);
            image.setImage(UIImages.ASSIST);
            image.setBackground(bgColor);

            Label label = new Label(this.forbiddenTooltip, SWT.WRAP);
            label.setForeground(fgColor);
            label.setBackground(bgColor);
        }

        // Update the text (title + reason on separate lines)
        Label label = (Label) this.forbiddenTooltip.getChildren()[1];
        if (false) {
            // TODO 20/05/2026 : delete this code if everybody is happy about user experience
            String title = CoreUi.I18N.getMessage("MObjectViewerDropListener.forbidden.title");
            label.setText(title + "\n" + reason);
        } else {
            label.setText(reason);
        }

        this.forbiddenTooltip.pack();

        // Place the tooltip below and to the right of the cursor
        if (false) {
            // TODO 20/05/2026 : delete this code if everybody is happy about user experience
            // The dragged element feedback is already displayed below the cursor, we need to avoid overlapping it.
            // Assume the feedback height is the same as our tooltip.
            int dy = this.forbiddenTooltip.getSize().y;
        }
        this.forbiddenTooltip.setLocation(cursorX + 16, cursorY + 20);
        this.forbiddenTooltip.setVisible(true);
    }

    @objid ("c85250a2-fb0b-4e3d-81d6-75b5f34c66b6")
    private void hideForbiddenTooltip() {
        if (this.forbiddenTooltip != null && !this.forbiddenTooltip.isDisposed()) {
            this.forbiddenTooltip.setVisible(false);
            this.forbiddenTooltip.dispose();
        }
    }

    /**
     * After a drop has been stated as valid, copy or move the dragged elements under the target.
     */
    @objid ("cf6575af-9344-4771-8185-859cc389a182")
    @Override
    public boolean performDrop(Object data) {
        MObject target = (MObject) getCurrentTarget();

        // Convert the transfer data to MRefs.
        MRef[] refs = (MRef[]) data;
        if (refs != null) {
            // Find model elements in the session from their refs
            List<MObject> dropedElements = new ArrayList<>();
            for (int i = 0; i < refs.length; i++) {
                dropedElements.add(CoreSession.getSession(target).getModel().findByRef(refs[i], IModel.NODELETED));
            }

            boolean isMove = getCurrentOperation() == DND.DROP_MOVE;
            if (isValidDrop(target, dropedElements, isMove)) {
                return performDrop(target, dropedElements, isMove);
            }
        }
        return false;
    }

    /**
     * Indicates whether or not the currently transfered elements can be dropped on the target.
     * <p>
     * Metamodel rules are checked, as well as manipulation rights for both the target and dropped elements.
     * </p>
     *
     * @param target the targeted element, must be a MObject.
     * @param operation the d&d operation, must be {@link DND#DROP_COPY} or {@link DND#DROP_MOVE}.
     * @param transferType the contents of data being dropped.
     * @return <code>true</code> if all the drop parameters are valid.
     */
    @objid ("68ec59ae-47c4-4fdb-aa0a-61f80ddf897d")
    @Override
    public boolean validateDrop(Object target, int operation, TransferData transferType) {
        this.forbiddenReason = null;   // reset

        // Is the target a model element?
        if (!(target instanceof MObject targetModel)) {
            return false;
        }

        // We only handle moves and copies.
        if (operation != DND.DROP_MOVE && operation != DND.DROP_COPY) {
            return false;
        }

        // The transfer type must be supported by ModelElementTransfer.
        ModelElementTransfer elementTransfer = ModelElementTransfer.getInstance();
        if (!elementTransfer.isSupportedType(transferType)) {
            return false;
        }

        // Convert the transfer data to MRefs.
        MRef[] refs = (MRef[]) elementTransfer.nativeToJava(transferType);
        if (refs != null) {
            // Find model elements in the session from their refs
            List<MObject> droppedElements = new ArrayList<>(refs.length);
            IModel modelFinder = CoreSession.getSession(targetModel).getModel();
            for (int i = 0; i < refs.length; i++) {
                droppedElements.add(modelFinder.findByRef(refs[i], IModel.NODELETED));
            }

            return isValidDrop(targetModel, droppedElements, operation == DND.DROP_MOVE);
        }

        // On Linux, the event data is not filled until the 'drop'. Try getting the selection from LocalSelectionTransfer.
        List<MObject> localDraggedElements = getLocalDraggedElements();
        if (! localDraggedElements.isEmpty()) {
            return isValidDrop(targetModel, localDraggedElements, operation == DND.DROP_MOVE);
        }

        return false;
    }

    /**
     * Tells whether 'child' can be owned by 'parent'.
     *
     * @param parent The future parent element
     * @param child a child element
     * @return true only if parent can contain the child.
     */
    @objid ("f7230fe2-2f94-43d8-8566-601c3f397fab")
    private boolean canBeParentOf(final MObject parent, final MObject child) {
        MExpert mExpert = parent.getMClass().getMetamodel().getMExpert();
        return mExpert.canCompose(parent, child, null) || mExpert.canSource(child, parent);
    }

    @objid ("4a13f923-01bd-49ce-813e-c00b98ddc0fa")
    private boolean copyElements(final List<MObject> elementsToCopy, final MObject targetElement) {
        List<MObject> copyResult = null;
        try {
            copyResult = MTools.getModelTool().copyElements(elementsToCopy, targetElement);

            // Select the result
            getViewer().setSelection(new StructuredSelection(copyResult));

            return true;
        } catch (final Exception e) {
            // Show an error box
            MessageDialog.openError(null, CoreUi.I18N.getMessage("CopyFailed"), e.getLocalizedMessage());
            return false;
        }
    }

    /**
     * Get the elements dragged from the same instance of Modelio. Uses {@link LocalSelectionTransfer}.
     *
     * @return the dragged elements.
     */
    @objid ("b1e30427-6c6e-47fe-ba24-d7e166b09c11")
    private List<MObject> getLocalDraggedElements() {
        ISelection selection = LocalSelectionTransfer.getTransfer().getSelection();

        if (selection instanceof IStructuredSelection) {
            return SelectionHelper.toList(selection, MObject.class);
        }
        return List.of();
    }

    /**
     * Tells whether 'element' is owned by 'parentCandidate'.
     *
     * @param parentCandidate The parent element to check
     * @param element an element
     * @return true only if parentCandidate owns element.
     */
    @objid ("3c3fdf0b-df43-47a4-9076-e2a631540e3f")
    private boolean isParentOf(MObject parentCandidate, MObject element) {
        final MObject parent = element.getCompositionOwner();

        if (parent == null) {
            return false;
        }

        if (parentCandidate.equals(parent)) {
            return true;
        }
        return isParentOf(parentCandidate, parent);
    }

    /**
     * Checks whether or not this drop configuration is valid, using different parameters:
     * <p>
     * When the drop is invalid, {@link #forbiddenReason} is set to a human-readable explanation.
     * <ul>
     * <li>The model manipulation rules are not violated.</li>
     * <li>We do not drop an element onto itself or a child</li>
     * <li>The drop target can be modified</li>
     * <li>For a "move", the auth tool must allow the move.</li>
     * </ul>
     *
     * @param targetElement the targeted element.
     * @param elementsToDrop the elements to drop.
     * @param isMove <code>true</code> if the current drop is a move operation, <code>false</code> if it is a copy.
     * @return <code>true</code> if all the drop parameters are valid.
     */
    @objid ("a1985e67-bd81-414e-b78a-810d219ae7f0")
    private boolean isValidDrop(MObject targetElement, List<MObject> elementsToDrop, boolean isMove) {
        this.forbiddenReason = null;   // reset

        if (targetElement == null || elementsToDrop.isEmpty()) {
            this.forbiddenReason = CoreUi.I18N.getMessage("MObjectViewerDropListener.forbidden.noTarget");
            return false;
        }

        if (isMove) {
            for (MObject movedElement : elementsToDrop) {
                if (movedElement.equals(targetElement) || isParentOf(movedElement, targetElement)) {
                    this.forbiddenReason = CoreUi.I18N.getMessage("MObjectViewerDropListener.forbidden.selfOrChild",
                            movedElement.getName(), targetElement.getName());
                    return false;
                }
            }
        }

        final MStatus targetStatus = targetElement.getStatus();

        for (final MObject movedElement : elementsToDrop) {
            final MStatus movedStatus = movedElement.getStatus();

            if (movedElement instanceof Association || movedElement instanceof Link) {
                this.forbiddenReason = CoreUi.I18N.getMessage("MObjectViewerDropListener.forbidden.association");
                return false;
            } else if (movedElement instanceof Parameter) {
                final Parameter parameter = (Parameter) movedElement;
                if (targetElement instanceof Operation && parameter.getReturned() != null) {
                    final Operation targetOperation = (Operation) targetElement;
                    if (targetOperation.getReturn() != null) {
                        this.forbiddenReason = CoreUi.I18N.getMessage("MObjectViewerDropListener.forbidden.returnParamExists");
                        return false;
                    }
                }
            } else if (movedElement instanceof ClassAssociation) {
                // for a class associationn check we are not targeting an already link object
                if (targetElement instanceof Association) {
                    final Association targetAssociation = (Association) targetElement;
                    if (targetAssociation.getLinkToClass() != null) {
                        this.forbiddenReason = CoreUi.I18N.getMessage("MObjectViewerDropListener.forbidden.classAssociation");
                        return false;
                    }
                }
            } else if (movedElement instanceof AbstractProject || movedElement.getMClass().areOrphansAllowed()) {
                // cannot D&D projects
                this.forbiddenReason = CoreUi.I18N.getMessage("MObjectViewerDropListener.forbidden.project");
                return false;
            } else {
                // 'ordinary' model element, treat the D&D as a composition owner change
                MDependency dep = targetElement.getMClass().getMetamodel().getMExpert().getDefaultCompositionDep(targetElement, movedElement);
                if (dep == null) {
                    this.forbiddenReason = CoreUi.I18N.getMessage("MObjectViewerDropListener.forbidden.metamodel",
                            movedElement.getMClass().getName(), targetElement.getMClass().getName());
                    return false;
                }
                if (!canBeParentOf(targetElement, movedElement)) {
                    this.forbiddenReason = CoreUi.I18N.getMessage("MObjectViewerDropListener.forbidden.metamodel",
                            movedElement.getMClass().getName(), targetElement.getMClass().getName());
                    return false;
                }
            }

            // If the current DND detail is a "move", make sure that the dragged elements are all modifiable and that
            // their respective parent are also modifiable.
            if (isMove) {
                if (!movedStatus.isModifiable()) {
                    this.forbiddenReason = CoreUi.I18N.getMessage("MObjectViewerDropListener.forbidden.readOnly",
                            movedElement.getName());
                    return false;
                }

                final MObject parentElement = movedElement.getCompositionOwner();
                if (parentElement == null) {
                    this.forbiddenReason = CoreUi.I18N.getMessage("MObjectViewerDropListener.forbidden.noParent",
                            movedElement.getName(), targetElement.getName());
                    return false;
                }

                // Delegate to the auth tool for CMS-aware move permission
                if (!MTools.getAuthTool().canMove(movedElement, targetElement)) {
                    this.forbiddenReason = CoreUi.I18N.getMessage("MObjectViewerDropListener.forbidden.notAllowed",
                            movedElement.getName(), targetElement.getName());
                    return false;
                }
            }
        }

        // Make sure the drop target can be modified
        if (targetStatus.isRamc()) {
            this.forbiddenReason = CoreUi.I18N.getMessage("MObjectViewerDropListener.forbidden.targetRamc",
                    targetElement.getName());
            return false;
        }

        // Accept drop
        return true;
    }

    @objid ("3b38336f-ff70-478d-a9ae-1159b20740ff")
    private boolean moveElements(final List<MObject> elementsToMove, final MObject targetElement) {
        try {
            MTools.getModelTool().moveElements(elementsToMove, targetElement, null);
            // Select the result
            getViewer().setSelection(new StructuredSelection(elementsToMove));

            return true;
        } catch (final Exception e) {
            // Show an error box
            MessageDialog.openError(null, CoreUi.I18N.getMessage("MovingFailed"), e.getLocalizedMessage());
            return false;
        }
    }

    /**
     * After a drop has been stated as valid, copy or move the dragged elements under the target.
     *
     * @param targetElement the targeted element.
     * @param elementsToDrop the elements to drop.
     * @param isMove <code>true</code> if the current drop is a move operation, <code>false</code> if it is a copy.
     * @return <code>true</code> if all the drop parameters are valid.
     */
    @objid ("929de76c-80aa-49ab-a961-5efc439c3a29")
    private boolean performDrop(MObject targetElement, List<MObject> elementsToDrop, boolean isMove) {
        if (targetElement == null || elementsToDrop.isEmpty()) {
            return false;
        }

        // Perform the action
        ITransactionSupport transactionManager = CoreSession.getSession(targetElement).getTransactionSupport();

        try (ITransaction transaction = transactionManager.createTransaction((isMove) ? "Cut" : "Copy")) {
            boolean ret;
            if (isMove) {
                ret = moveElements(elementsToDrop, targetElement);
            } else {
                ret = copyElements(elementsToDrop, targetElement);
            }
            if (ret) {
                transaction.commit();
                return true;
            } else {
                transaction.rollback();
                return false;
            }
        } catch (IllegalModelManipulationException e) {
            // Ignore model shield error
            return false;
        }
    }

}

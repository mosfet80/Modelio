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
package org.modelio.diagram.elements.common.abstractdiagram;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.swt.widgets.Display;
import org.modelio.diagram.elements.core.model.GmModel;
import org.modelio.diagram.elements.core.model.IGmDiagram.IModelManager;
import org.modelio.diagram.elements.plugin.DiagramElements;
import org.modelio.diagram.persistence.PersistenceException;
import org.modelio.metamodel.diagrams.AbstractDiagram;
import org.modelio.vcore.session.api.model.change.ChangeCause;
import org.modelio.vcore.session.api.model.change.IElementDeletedEvent;
import org.modelio.vcore.session.api.model.change.IModelChangeEvent;
import org.modelio.vcore.session.api.model.change.IModelChangeSupport;
import org.modelio.vcore.session.api.model.change.IStatusChangeEvent;
import org.modelio.vcore.session.api.transactions.ITransaction;
import org.modelio.vcore.session.api.transactions.ITransactionSupport;
import org.modelio.vcore.session.api.transactions.TransactionCreationException;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Service class that triggers the refresh of the  {@link GmAbstractDiagram} from the model.
 * <p>
 * The behavior is different depending on the diagram is visible, invisible or an edition interaction is in progress.
 *
 * @since 6.0.1+ 28/11/2024 . Before that the 2 sub classes were inside {@link GmAbstractDiagram}
 */
@objid ("d84aacd6-b3e5-4cec-84db-38242b331fe4")
public class GmAbstractDiagramRefresher {
    @objid ("5cadb21e-44a9-4c19-9a6f-2a516aad4598")
    private State currentState;

    @objid ("0bbf3096-6c8b-48fb-8acd-68e203afc500")
    private GmAbstractDiagram gmDiagram;

    @objid ("b1ab7aec-19a0-4ac7-8fa8-314ac3856376")
    private final DiagramRefresherSwitcher switcher;

    @objid ("7e169b63-1dec-11e2-8cad-001ec947c8cc")
    private IDiagramRefresher hiddenRefresher;

    @objid ("7e169b5b-1dec-11e2-8cad-001ec947c8cc")
    private IDiagramRefresher visibleRefresher;

    @objid ("ea319926-eeee-49dc-abfa-fb5a9f330092")
    private final DeferDiagramRefresher suspendDiagramRefresher;

    @objid ("0a008b8a-ddc1-418b-a533-af6e3ce41840")
    public GmAbstractDiagramRefresher() {
        this.switcher = new DiagramRefresherSwitcher();
        this.suspendDiagramRefresher = createDeferDiagramRefresher();
    }

    @objid ("e0bf036a-dfdd-4d05-9a4f-38b535938297")
    public final void initialize(GmAbstractDiagram gmDiagram) {
        this.gmDiagram = gmDiagram;
        this.visibleRefresher = createVisibleDiagramRefresher();
        this.hiddenRefresher = createHiddenDiagramRefresher();
        activate();
    }

    @objid ("68227271-dcf5-4c17-a410-74ce9e1db800")
    public GmAbstractDiagram getGmDiagram() {
        return gmDiagram;
    }

    @objid ("293783e7-60fd-4199-94a7-eafc462a744b")
    public final void dispose() {
        IModelManager modelManager = this.gmDiagram.getModelManager();
        if (modelManager != null) {
            final IModelChangeSupport modelChangeSupport = modelManager.getModelingSession().getModelChangeSupport();
            // Note: it is safe to remove listeners event if they are null

            modelChangeSupport.removePersistentViewListener(this.switcher);
            modelChangeSupport.removeModelChangeListener(this.switcher);
            modelChangeSupport.removeStatusChangeListener(this.switcher);
        }
    }

    @objid ("c03ab552-3f7c-42cc-aac3-9f46e5395edb")
    private void activate() {
        IModelManager modelManager = this.gmDiagram.getModelManager();
        if (modelManager != null) {
            final IModelChangeSupport modelChangeSupport = modelManager.getModelingSession().getModelChangeSupport();

            modelChangeSupport.addPersistentViewListener(this.switcher);
            modelChangeSupport.addModelChangeListener(this.switcher);
            modelChangeSupport.addStatusChangeListener(this.switcher);
        }
    }

    @objid ("7b4eb814-2196-41af-af79-358f345019a6")
    public final Runnable suspendRefresh() {
        if (true) {
            return () -> {};
        } else {
            // Disabled : This wipe all remote modifications made while the refresh is suspended.
            // The remedy is worse than the disease.
            if (this.currentState == State.SUSPENDED)
                throw new IllegalStateException(String.format("%s diagram refresher is already suspended", this.gmDiagram));

            final State oldState = this.currentState;
            Runnable restorer = () -> {
                setState(oldState);
            };

            setState(State.SUSPENDED);

            return restorer;
        }
    }

    /**
     * Reconfigure the current refresher for either processing or ignoring the model change events.
     *
     * @param onOff true to process events, false to defer them.
     * @return true if the state changed, false if nothing changed
     */
    @objid ("2dc460ed-be44-424f-93a4-ee1afd1e7da4")
    public final boolean enableRefresh(boolean onOff) {
        return setState(onOff ? State.VISIBLE : State.HIDDEN);
    }

    @objid ("d0f11098-97ff-40ac-bf11-10b849199981")
    private final boolean setState(State newState) {
        State oldState = this.currentState;
        if (oldState == newState) {
            return false;
        }

        this.currentState = newState;

        switch (newState) {
        case HIDDEN:
            this.switcher.setCurrent(this.hiddenRefresher);
            this.hiddenRefresher.visibilityChanged(false);
            break;
        case SUSPENDED:
            this.suspendDiagramRefresher.setOriginalRefresher(switcher.getCurrent());
            this.switcher.setCurrent(this.suspendDiagramRefresher);
            break;
        case VISIBLE:
            this.switcher.setCurrent(this.visibleRefresher);
            this.visibleRefresher.visibilityChanged(true);
            break;
        }

        if (oldState == State.SUSPENDED) {
            this.suspendDiagramRefresher.sendTo(switcher.getCurrent());
        }

        return true;
    }

    /**
     * Initialize a diagram refresher to be called when the model changes and the diagram is not visible., i.e. <code>enableRefresh(false)</code> has been called.
     * <p>
     * This method is called during the class initialization, and should not access fields (that may not be initialized yet).
     * </p>
     *
     * @return a diagram refresher. Must not be <code>null</code>.
     */
    @objid ("9e4cd3c3-52b7-404e-bad6-65e7be8e0a7f")
    protected IDiagramRefresher createHiddenDiagramRefresher() {
        return new HiddenDiagramRefresher(this.gmDiagram);
    }

    /**
     * Initialize a diagram refresher to be called when the model changes and the diagram is visible, i.e. <code>enableRefresh(true)</code> has been called.
     * <p>
     * This method is called during the class initialization, and should not access fields (that may not be initialized yet).
     * </p>
     *
     * @return a diagram refresher. Must not be <code>null</code>.
     */
    @objid ("7e1b6043-1dec-11e2-8cad-001ec947c8cc")
    protected IDiagramRefresher createVisibleDiagramRefresher() {
        return new VisibleDiagramRefresher(this.gmDiagram);
    }

    @objid ("54ee70e4-b0c7-47f0-9840-442709a7b818")
    private final DeferDiagramRefresher createDeferDiagramRefresher() {
        return new DeferDiagramRefresher();
    }

    /**
     * Updates the Graphic Model from the Ob model.
     */
    @objid ("7e1dc274-1dec-11e2-8cad-001ec947c8cc")
    public static class HiddenDiagramRefresher implements IDiagramRefresher {
        @objid ("ce962625-925c-4396-9550-c9863e2252ba")
        private GmAbstractDiagram gmAbstractDiagram;

        /**
         * Default constructor.
         *
         * @param gmAbstractDiagram the opened diagram.
         */
        @objid ("7e1dc276-1dec-11e2-8cad-001ec947c8cc")
        public HiddenDiagramRefresher(GmAbstractDiagram gmAbstractDiagram) {
            this.gmAbstractDiagram = gmAbstractDiagram;
        }

        @objid ("7e1dc279-1dec-11e2-8cad-001ec947c8cc")
        @Override
        public void updateView(final IModelChangeEvent event) {
            final AbstractDiagram obDiagram = this.gmAbstractDiagram.getRelatedElement();
            // Remove deleted elements from the diagram in the display thread
            Display.getDefault().syncExec(() -> {

                if (!obDiagram.isShell()
                        && !obDiagram.isDeleted()
                        && !this.gmAbstractDiagram.isDisposed()
                        && obDiagram.getStatus().isModifiable()) {
                    for (final GmModel model : this.gmAbstractDiagram.getAllModels()) {
                        final MObject el = model.getRelatedElement();
                        if (el != null && el.isDeleted()) {
                            model.obElementDeleted();
                        }
                    }

                    // Save the refreshed diagram only if sync with the Ob model
                    if (obDiagram.getUiDataVersion() == this.gmAbstractDiagram.lastSavedUiDataVersion) {
                        this.gmAbstractDiagram.save(false);
                    }
                }
            });
        }

        @objid ("7e1dc27e-1dec-11e2-8cad-001ec947c8cc")
        @Override
        public final void modelChanged(IModelChangeEvent event) {
            // Do nothing.
        }

        @objid ("9c87e127-7998-4459-9c7b-3d287a4700f0")
        @Override
        public void visibilityChanged(boolean visible) {
            // do nothing
        }

        @objid ("55203d10-c164-4434-8c85-94dfa5ea846f")
        @Override
        public void statusChanged(IStatusChangeEvent ev) {
            // do nothing
        }

    }

    /**
     * Updates the Graphic Model from the Ob model.
     */
    @objid ("7e1b604d-1dec-11e2-8cad-001ec947c8cc")
    public static class VisibleDiagramRefresher implements IDiagramRefresher {
        @objid ("0f0f5f0b-600d-4ea4-8c6c-920b913f87e5")
        private final GmAbstractDiagram gmAbstractDiagram;

        /**
         * Used by {@link #scheduleDiagramReload()} to schedule reload only once.
         */
        @objid ("394c4167-45a7-4870-911f-d9afe96e4a5e")
        private final AtomicBoolean reloadScheduled = new AtomicBoolean();

        /**
         * Used by {@link #statusChanged(IStatusChangeEvent)} to schedule refresh only once.
         */
        @objid ("d3a508bd-ab7a-4d1f-9474-b53520a01618")
        private final AtomicReference<DiagramRefreshCommand> refreshInTransactionScheduled = new AtomicReference<>();

        @objid ("659eff46-e738-409b-87d8-f889b3bbbe07")
        private final DiagramRefreshCommand emptyRefreshCommand;

        /**
         * Default constructor.
         *
         * @param gmAbstractDiagram the opened diagram.
         */
        @objid ("7e1dc262-1dec-11e2-8cad-001ec947c8cc")
        public VisibleDiagramRefresher(GmAbstractDiagram gmAbstractDiagram) {
            this.gmAbstractDiagram = gmAbstractDiagram;
            this.emptyRefreshCommand = new DiagramRefreshCommand(gmAbstractDiagram);
            this.refreshInTransactionScheduled.set(emptyRefreshCommand);
        }

        /**
         * Invoked when the model has changed.
         * <p>
         * Delegates to {@link #refreshAllDiagram()}.
         */
        @objid ("7e1dc265-1dec-11e2-8cad-001ec947c8cc")
        @Override
        public void updateView(final IModelChangeEvent event) {
            final AbstractDiagram obDiagram = this.gmAbstractDiagram.getRelatedElement();
            // Refresh the diagram in the display thread
            Display.getDefault().syncExec(() -> {

                // Guard agains'st disposed diagram editor and deleted element
                if (this.gmAbstractDiagram.isDisposed()
                        || obDiagram == null
                        || obDiagram.isShell()
                        || obDiagram.isDeleted()
                        || !obDiagram.getStatus().isModifiable()) {
                    // The diagram has been deleted or closed, do nothing.
                    // Another listener will close the view.
                    return;
                } else if (obDiagram.getUiDataVersion() != this.gmAbstractDiagram.lastSavedUiDataVersion) {
                    // The diagram data itself is modified.
                    // If represented elements are also deleted,
                    // reload the diagram and remove deleted elements.

                    // Get all refs from invalid elements
                    final Set<MRef> invalidRefs = new HashSet<>();
                    for (final GmModel gm : this.gmAbstractDiagram.getAllModels()) {
                        final MObject el = gm.getRelatedElement();
                        if (el != null && el.isDeleted()) {
                            invalidRefs.add(gm.getRepresentedRef());
                        }
                    }

                    if (!invalidRefs.isEmpty()) {
                        this.gmAbstractDiagram.load();

                        // Delete all Gm whose refs were invalid, to avoid
                        // unwanted ghosts.
                        int deletedNodes = 0;
                        for (final GmModel gm : this.gmAbstractDiagram.getAllModels()) {
                            if (invalidRefs.contains(gm.getRepresentedRef())) {
                                gm.obElementDeleted();
                                deletedNodes++;
                            }
                        }

                        // Save the refreshed diagram if necessary
                        if (deletedNodes > 0) {
                            this.gmAbstractDiagram.save(false);
                        }
                    }
                } else {
                    // Standard case : refresh the diagram
                    new DiagramRefreshCommand(this.gmAbstractDiagram, true).run();
                }
            });
        }

        /**
         * Reload the diagram if it has been modified outside of the diagram editor.
         *
         * @param event The change event.
         */
        @objid ("7e1dc26b-1dec-11e2-8cad-001ec947c8cc")
        @Override
        public final void modelChanged(final IModelChangeEvent event) {
            final AbstractDiagram obDiagram = this.gmAbstractDiagram.getRelatedElement();

            if (obDiagram == null || obDiagram.isShell() || obDiagram.isDeleted()) {
                // The diagram has been deleted, do nothing.
                // Another listener will close the view.
                return;
            } else if (obDiagram.getUiDataVersion() != this.gmAbstractDiagram.lastSavedUiDataVersion) {
                // The diagram itself changed.
                // Schedule a diagram reload
                scheduleDiagramReload();

            } else if (!obDiagram.getStatus().isModifiable()) {
                // When the diagram is read only:
                // - The diagram was not refreshed by updateView(...) on transaction commit
                // - as it is not refreshed on commit, nothing happens on undo/redo
                // do all of these here.
                //
                // FIXME: The ghost nodes can't resurrect because
                // GmModel#obElementResolved() is neither called
                // nor implemented .
                // The only thing to do is reload completely the diagram.
                scheduleDiagramReload();
            } else {
                switch (event.getCause()) {
                case REPOSITORY:
                case UNDO:
                case REDO:
                    // updateView(...) is not called in these cases
                    //scheduleDiagramReload();
                    scheduleDiagramRefresh(event);
                    break;
                default:
                    // do nothing
                }
            }
        }

        @objid ("f20f0c34-0ce5-4d42-965c-35d018a91077")
        private void scheduleDiagramReload() {
            if (this.reloadScheduled.compareAndSet(false, true)) {
                Display.getDefault().asyncExec(() -> {
                    this.reloadScheduled.set(false);
                    if (!this.gmAbstractDiagram.isDisposed() && this.gmAbstractDiagram.getModelManager().getModelingSession().isValid()) {
                        this.gmAbstractDiagram.load();
                    }
                });
            }
        }

        @objid ("d06823a1-b39d-4517-ba89-3b71f56748de")
        private void scheduleDiagramRefresh(IModelChangeEvent event) {
            if (this.refreshInTransactionScheduled.getAndUpdate(old -> old.addElements(event)) == emptyRefreshCommand) {
                Display.getDefault().asyncExec(() -> runScheduledDiagramRefresh());
            }
        }

        @objid ("54b895cb-64ed-4cd0-a7e5-61c6953121af")
        private void scheduleDiagramRefresh(IStatusChangeEvent event) {
            if (this.refreshInTransactionScheduled.getAndUpdate(old -> old.addElements(event)) == emptyRefreshCommand) {
                Display.getDefault().asyncExec(() -> runScheduledDiagramRefresh());
            }
        }

        @objid ("7f375fbd-f514-4798-bb77-f09207b88a99")
        private void scheduleDiagramCompleteRefresh() {
            if (this.refreshInTransactionScheduled.getAndUpdate(old -> new DiagramRefreshCommand(gmAbstractDiagram, true)) == emptyRefreshCommand) {
                Display.getDefault().asyncExec(() -> runScheduledDiagramRefresh());
            }
        }

        @objid ("4f1af50c-2ce2-4dc9-85e1-4729b1b1c81b")
        private void scheduleDiagramRefresh(DiagramRefreshCommand curCommand) {
            if (this.refreshInTransactionScheduled.getAndUpdate(old -> old.addElements(curCommand)) == emptyRefreshCommand) {
                Display.getDefault().asyncExec(() -> runScheduledDiagramRefresh());
            }
        }

        @objid ("4dc517e1-6318-4912-92b9-d8428ef2ac0c")
        @Override
        public void visibilityChanged(boolean visible) {
            if (visible && !this.gmAbstractDiagram.isDisposed()) {
                MObject relatedElement = this.gmAbstractDiagram.getRelatedElement();
                if (relatedElement != null) {
                    this.gmAbstractDiagram.load();
                }
            }
        }

        @objid ("c0205b31-9645-4acc-ab34-662fe2f8a17c")
        @Override
        public void statusChanged(IStatusChangeEvent ev) {
            if (ev.getCause() == ChangeCause.REPOSITORY) {
                // Schedule only one diagram refresh at a time

                // (Obsolete ?) notes from previous default implementation on IDiagramRefresher:
                // - module may have been added/removed : all icons must be reloaded
                // - don't filter on ev.getShellStateChanged().isEmpty(), it is often empty because elements are unloaded then reloaded to same state

                scheduleDiagramRefresh(ev);
            }
        }

        @objid ("4d00c961-9071-46f7-8c21-0fcffeeb4a39")
        private void runScheduledDiagramRefresh() {
            assert Display.getCurrent() != null ;

            // Allow immediately another refresh schedule
            DiagramRefreshCommand curCommand = this.refreshInTransactionScheduled.getAndSet(this.emptyRefreshCommand);

            if (this.gmAbstractDiagram.isDisposed() || !this.gmAbstractDiagram.getModelManager().getModelingSession().isValid())
                return;

            // TODO : the call to refreshAllDiagram() instead of scheduleDiagramReload() leads to the creation of a ghost transaction
            // in the case of creation of elements including diagrams (BPMN Process for example)
            MObject diagramElement = this.gmAbstractDiagram.getRepresentedElement();
            ITransactionSupport transactionSupport = this.gmAbstractDiagram.getModelManager().getModelingSession().getTransactionSupport();
            try (ITransaction tr = transactionSupport.createTransaction(
                    String.format("Refresh %s diagram.", diagramElement),
                    10,
                    TimeUnit.MILLISECONDS)) {
                tr.disableUndo();
                curCommand.run();

                tr.commit();
            } catch (TransactionCreationException ex) {
                // Also catches org.modelio.vcore.session.api.transactions.ConcurrentTransactionException .
                // - ConcurrentTransactionException : a transaction is running
                // - TransactionCreationException : the lock is held for another reason

                // Log as debug and try later
                DiagramElements.LOG.debug(ex);
                transactionSupport.asyncExec(() -> scheduleDiagramRefresh(curCommand));
            }
        }

    }

    @objid ("e249d897-d4d7-4df9-b12e-4a32b750b3ad")
    private static enum State {
        @objid ("6d903354-2d11-45f7-8561-1fcac7b1525b")
        VISIBLE,
        @objid ("bc8a860f-5e2a-42c2-9d60-1d71469c15c8")
        HIDDEN,
        @objid ("11cf96a9-72aa-4572-ac9c-3cb983a6f9fa")
        SUSPENDED;

    }

    @objid ("4f526d51-d2ea-48a5-b3aa-6b322da83172")
    private static class DiagramRefresherSwitcher implements IDiagramRefresher {
        @objid ("fa924fe0-887b-4560-a8cd-e0ddcb4532a8")
        private IDiagramRefresher currentDiagramRefresher;

        @objid ("2d8c06d1-6dae-4f45-a29e-44023b96faa2")
        public DiagramRefresherSwitcher() {

        }

        @objid ("870ad7cc-caec-48a3-bbf0-59247e60b3cb")
        public IDiagramRefresher getCurrent() {
            return this.currentDiagramRefresher;
        }

        @objid ("f3079c22-b9f2-4947-90cb-b0bf16a5fdaa")
        public void setCurrent(IDiagramRefresher currentDiagramRefresher) {
            this.currentDiagramRefresher = currentDiagramRefresher;
        }

        @objid ("5b4ae2fb-2109-45c7-8383-de0e6f7b03ac")
        @Override
        public void modelChanged(IModelChangeEvent event) {
            currentDiagramRefresher.modelChanged(event);
        }

        @objid ("30fc174c-bf96-4246-995f-408abe93a37a")
        @Override
        public void updateView(IModelChangeEvent event) {
            currentDiagramRefresher.updateView(event);
        }

        @objid ("3bea411d-22f1-4c43-afff-0045939c1a49")
        @Override
        public void visibilityChanged(boolean visible) {
            currentDiagramRefresher.visibilityChanged(visible);
        }

        @objid ("d979fa0a-b381-414d-83cd-6e3e7c45c2e9")
        @Override
        public void statusChanged(IStatusChangeEvent event) {
            currentDiagramRefresher.statusChanged(event);
        }

    }

    /**
     * {@link IDiagramRefresher} that defers most calls until #sendTo
     */
    @objid ("545066a6-883f-4ff0-aad2-e16c7edbc5b6")
    @Deprecated
    private static class DeferDiagramRefresher implements IDiagramRefresher {
        @objid ("f46358c9-551e-4161-a551-4b0b6e61e517")
        private List<Consumer<IDiagramRefresher>> defferedCalls;

        @objid ("4402b5ed-3037-4a7a-8163-8cfc671023dd")
        private IDiagramRefresher originalRefresher;

        @objid ("9572d13e-b06e-4883-b2eb-da1dd31b10d2")
        public DeferDiagramRefresher() {
            this.defferedCalls = new ArrayList<>();
        }

        @objid ("8f365458-bbdf-4867-a5a4-664382ffde5f")
        public void setOriginalRefresher(IDiagramRefresher originalRefresher) {
            this.originalRefresher = originalRefresher;
        }

        @objid ("57b60993-aad0-40a0-b414-a05286a886b6")
        @Override
        public void modelChanged(IModelChangeEvent event) {
            defferedCalls.add( r -> r.modelChanged(event));
        }

        @objid ("dd33cfbc-9191-4deb-8474-29bde8105652")
        @Override
        public void updateView(IModelChangeEvent event) {
            //defferedCalls.add( r -> r.updateView(event));
            this.originalRefresher.updateView(event);
        }

        @objid ("66eb1929-a3be-42e9-ad92-0d831edd0bc4")
        @Override
        public void statusChanged(IStatusChangeEvent event) {
            defferedCalls.add( r -> r.statusChanged(event));
        }

        @objid ("366c13bd-f090-4187-b28b-f6dfe92ce1bc")
        @Override
        public void visibilityChanged(boolean visible) {
            //defferedCalls.add( r -> r.visibilityChanged(visible));
        }

        @objid ("8ba28583-f7ee-428c-a874-8f55a9b624b9")
        public void sendTo(IDiagramRefresher r) {
            try {
                for (Consumer<IDiagramRefresher> consumer : defferedCalls) {
                    consumer.accept(r);
                }
            } finally {
                this.defferedCalls = new ArrayList<>();
            }
        }

    }

    /**
     * Complete or partial diagram refresh command.
     * <p>
     * This class is immutable, its addXxxx(...) return a new instance.
     */
    @objid ("78461b5e-f957-4c97-a363-e72e3ea28630")
    private static class DiagramRefreshCommand {
        /**
         * If more than this count of elements have been modified, a full diagram refresh will be done.
         */
        @objid ("e2c6820c-9970-49be-a53e-41f82ddf020a")
        private static final int MAX_SIZE = 20;

        @objid ("2028fda9-eb47-4418-a538-f8da3c67c94c")
        private final boolean fullRefresh;

        @objid ("9da2d52a-7c87-42bc-b614-f586f16dbcc8")
        private final Set<MObject> toRefresh;

        @objid ("232c4c92-fca4-4421-8226-2a0a87f14a40")
        private final GmAbstractDiagram gmAbstractDiagram;

        /**
         * Empty constructor
         */
        @objid ("15722de5-c805-4cef-b05e-e37cb4e573b4")
        public DiagramRefreshCommand(GmAbstractDiagram gmAbstractDiagram) {
            this.gmAbstractDiagram = gmAbstractDiagram;
            this.toRefresh = Set.of();
            this.fullRefresh = false;
        }

        /**
         * Constructor for complete refresh
         *
         * @param all ignored, as if always true
         */
        @objid ("08cb68eb-6561-4934-b044-0d5d2d25ede5")
        public DiagramRefreshCommand(GmAbstractDiagram gmAbstractDiagram, boolean all) {
            this.gmAbstractDiagram = gmAbstractDiagram;
            this.toRefresh = Set.of();
            this.fullRefresh = true;
            traceDeletedDiagram();
        }

        @objid ("c7043cdc-52ab-4e54-a1d3-cf688a94980d")
        private DiagramRefreshCommand(DiagramRefreshCommand orig, Collection<? extends MObject> toAdd) {
            this.gmAbstractDiagram = orig.gmAbstractDiagram;
            this.fullRefresh = false;
            this.toRefresh = new HashSet<MObject>(toAdd);
            if (orig.toRefresh != null && ! orig.toRefresh.isEmpty())
                this.toRefresh.addAll(orig.toRefresh);
            traceDeletedDiagram();
        }

        /**
         * Debug code to intercept refresh commands creation on invalid diagram.
         */
        @objid ("7eff4aae-3067-4cab-9197-95b766dd677e")
        private void traceDeletedDiagram() {
            if (! DiagramElements.LOG.isDebugEnabled())
                return;

            try {
                if (this.gmAbstractDiagram.isDisposed()) {
                    DiagramElements.LOG.debug(new IllegalStateException(this.gmAbstractDiagram+" is disposed"));
                } else if (this.gmAbstractDiagram.getRelatedElement() == null) {
                    DiagramElements.LOG.debug(new IllegalStateException(this.gmAbstractDiagram+" related element is null"));
                } else if (! this.gmAbstractDiagram.getRelatedElement().isValid()) {
                    DiagramElements.LOG.debug(new IllegalStateException(this.gmAbstractDiagram+" related element is not valid :"+this.gmAbstractDiagram));
                }
            } catch (RuntimeException e) {
                // should not happen, log and continue.
                DiagramElements.LOG.warning(e);
            }
        }

        @objid ("7146b8df-ffa9-47b6-ae7d-a1eaf75179a8")
        public DiagramRefreshCommand addElements(IStatusChangeEvent ev) {
            if (this.fullRefresh)
                return this;
            else if (this.toRefresh.size() + ev.getStatusChanged().size() > MAX_SIZE)
                return new DiagramRefreshCommand(this.gmAbstractDiagram, true);
            else
                return new DiagramRefreshCommand(this, ev.getStatusChanged().keySet());
        }

        @objid ("77a6b768-a8ce-44c1-bebd-7dc4e9e635b6")
        public DiagramRefreshCommand addElements(DiagramRefreshCommand other) {
            if (this.fullRefresh)
                return this;
            else if (other.fullRefresh)
                return other;
            else if (this.toRefresh.size() + other.toRefresh.size() > MAX_SIZE)
                return new DiagramRefreshCommand(this.gmAbstractDiagram, true);
            else
                return new DiagramRefreshCommand(this, other.toRefresh);
        }

        @objid ("622280cb-9600-45ee-a599-75da61d5a032")
        public DiagramRefreshCommand addElements(IModelChangeEvent ev) {
            if (this.fullRefresh)
                return this;

            if (this.toRefresh.size() + ev.getUpdateEvents().size() +  ev.getDeleteEvents().size() + ev.getCreationEvents().size() > MAX_SIZE)
                return new DiagramRefreshCommand(this.gmAbstractDiagram, true);

            HashSet<MObject> allEls = new HashSet<MObject>(ev.getUpdateEvents());

            for (MObject created : ev.getCreationEvents()) {
                allEls.add(created.getCompositionOwner());
            }

            for (IElementDeletedEvent delEvent : ev.getDeleteEvents()) {
                allEls.add(delEvent.getOldParent());
                allEls.add(delEvent.getDeletedElement());
            }

            return new DiagramRefreshCommand(this, allEls);
        }

        @objid ("0227851e-604b-44d9-963c-69375269f2cd")
        public void run() {
            // Avoid refresh on invalid states, this command may be run asynchronously.
            if (this.gmAbstractDiagram.isDisposed()
                    || this.gmAbstractDiagram.getRelatedElement() == null
                    || ! this.gmAbstractDiagram.getRelatedElement().isValid())
                return;

            if (this.fullRefresh) {
                refreshAllDiagram();
            } else {
                refreshDiagramPartial();
            }
        }

        @objid ("a748997e-5490-45ef-b5f9-e1fb46ea6ec4")
        private final void refreshDiagramPartial() {
            final Collection<GmModel> toRefresh = new HashSet<GmModel>(this.toRefresh.size()*2);
            for (MObject obj : this.toRefresh) {
                MRef ref = new MRef(obj);
                toRefresh.addAll(this.gmAbstractDiagram.getAllGMRelatedTo(ref));
            }

            refreshGmModels(toRefresh);
        }

        /**
         * Force a refresh of the whole diagram.
         */
        @objid ("7e1dc271-1dec-11e2-8cad-001ec947c8cc")
        private final void refreshAllDiagram() {
            final Collection<GmModel> toRefresh = this.gmAbstractDiagram.getAllModels();
            refreshGmModels(toRefresh);
        }

        @objid ("4145e572-96c0-4db5-b667-53725943af69")
        private void refreshGmModels(final Collection<GmModel> toRefresh) throws PersistenceException {
            final Collection<GmModel> toDelete = new ArrayList<>();
            final Collection<GmModel> toDeleteLinks = new ArrayList<>();
            for (final GmModel model : toRefresh) {
                if (model.getDiagram() != null) {
                    final MObject el = model.getRelatedElement();
                    if (el != null && el.isDeleted()) {
                        // Schedule deletion to give a chance to links connected to this node to reroute.

                        if(model.getRelatedElement().getMClass().isLinkMetaclass()) {
                            toDeleteLinks.add(model);
                        }else {
                            toDelete.add(model);
                        }
                    } else if (model.isValid()) {
                        model.obElementsUpdated();
                    }
                }
            }

            // Delete Links first
            for (GmModel model : toDeleteLinks) {
                model.obElementDeleted();
            }

            // Do all deletions now
            for (GmModel model : toDelete) {
                model.obElementDeleted();
            }

            // Save the refreshed diagram
            final AbstractDiagram obDiagram = this.gmAbstractDiagram.getRelatedElement();
            if (obDiagram.isModifiable()) {
                this.gmAbstractDiagram.save(false);
            }
        }

    }

}

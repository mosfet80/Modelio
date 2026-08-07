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

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.diagram.elements.core.model.GmModel;
import org.modelio.diagram.elements.core.model.IDiagramPersister;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.elements.persistence.ExtReferenceResolver;
import org.modelio.diagram.elements.persistence.InstanceFactory;
import org.modelio.diagram.elements.plugin.DiagramElements;
import org.modelio.diagram.persistence.IDiagramReader;
import org.modelio.diagram.persistence.IDiagramWriter;
import org.modelio.diagram.persistence.PersistenceException;
import org.modelio.diagram.persistence.XmlDiagramReader;
import org.modelio.diagram.persistence.XmlDiagramWriter;
import org.modelio.metamodel.diagrams.AbstractDiagram;
import org.modelio.metamodel.uml.infrastructure.Element;
import org.modelio.vcore.session.api.transactions.ConcurrentTransactionException;
import org.modelio.vcore.session.api.transactions.ITransaction;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Service class that load and save a {@link GmAbstractDiagram} from its {@link AbstractDiagram} saved data.
 *
 * @author cmarin
 */
@objid ("7e143931-1dec-11e2-8cad-001ec947c8cc")
public class DiagramPersistence implements IDiagramPersister {
    @objid ("c0115129-dbd0-4e47-a7ab-fa75054ed82e")
    private GmAbstractDiagram gmDiagram;

    /**
     * C'tor.
     *
     * @param gmDiagram the diagram to manage persistence for.
     */
    @objid ("c893559b-26fc-40c7-a044-f72a5f7c5662")
    public DiagramPersistence(GmAbstractDiagram gmDiagram) {
        this.gmDiagram = gmDiagram;
    }

    /**
     * Load a {@link GmAbstractDiagram} from its {@link AbstractDiagram} saved data.
     * <p>
     * Resets the diagram before (re)loading it.
     * </p>
     *
     * @throws PersistenceException on load failure
     */
    @objid ("613b9470-edbd-4d30-90ba-57415ce7b42c")
    @Override
    public void load() throws PersistenceException {
        final MRef diagramRef = this.gmDiagram.getRepresentedRef();
        final AbstractDiagram obDiagram = (AbstractDiagram) this.gmDiagram.getModelManager().resolveRef(diagramRef);

        if (obDiagram == null) {
            throw new PersistenceException("{" + diagramRef.uuid + "} " + diagramRef.mc
                    + " not found, it may have been deleted.");
        }

        final String data = obDiagram.getUiData();
        boolean hasPersistedData = data != null && !data.isEmpty();
        this.gmDiagram.reset(hasPersistedData);

        if (hasPersistedData) {
            final IDiagramReader reader = new XmlDiagramReader(new InstanceFactory(this.gmDiagram), new ExtReferenceResolver());
            reader.readDiagram(data, this.gmDiagram);
        }
        this.gmDiagram.updateLastSaveDate();
        this.gmDiagram.refreshAllFromObModel();
        this.gmDiagram.refreshFromObModel();
    }

    /**
     * Save the {@link GmAbstractDiagram} content in the {@link AbstractDiagram}.
     * <p>
     * A transaction must already be open.
     *
     * @param withEmbeddeddiagrams whether or not embedded diagrams should also be saved.
     * @throws PersistenceException on save failure
     */
    @objid ("36e1ff90-cbe4-496a-8cc5-5f9a41b6d96f")
    public void save(boolean withEmbeddeddiagrams) throws PersistenceException {
        final IDiagramWriter writer = new XmlDiagramWriter();
        writer.save(this.gmDiagram);

        final AbstractDiagram obDiagram = (this.gmDiagram.getRelatedElement());
        if (!obDiagram.isShell() && !obDiagram.isDeleted()) {
            String newUidata = writer.getOutput();
            if (!Objects.equals(newUidata, obDiagram.getUiData())) {
                obDiagram.setUiData(writer.getOutput());
                obDiagram.setUiDataVersion(obDiagram.getUiDataVersion() + 1);
                updateDiagramElementRelation(obDiagram);
                this.gmDiagram.updateLastSaveDate();
            }
        }

        if (withEmbeddeddiagrams) {
            for (IGmDiagram embedded : this.gmDiagram.getEmbeddedDiagrams()) {
                MObject relatedElement = embedded.getRelatedElement();
                if (relatedElement != null && relatedElement.getStatus().isModifiable()) {
                    embedded.save(true);
                }
            }
        }
    }

    /**
     * Update the {@link AbstractDiagram#getRepresented()} relation from the diagram graphic model.
     *
     * @param gmDiagram the graphic model
     * @param obDiagram the model element
     */
    @objid ("c091670c-4b2e-4a7a-978d-0ae199225bb9")
    private void updateDiagramElementRelation(AbstractDiagram obDiagram) {
        if(this.gmDiagram.isDisposed()) {
            return;
        }

        try (ITransaction transaction = this.gmDiagram.getModelManager().getModelingSession().getTransactionSupport()
                .createTransaction("Update "+obDiagram+" represented elements relation", 100, TimeUnit.MILLISECONDS)) {
            // Disable undo on this :
            // - since 6.0 the diagram is always refreshed even on undo.
            // - Moreover redo is not stable on conference fragments:
            //   > Transaction: Error redoing append 'Operation'{363d160e-5297-44fc-801d-4a655c019fb4} Standard.Operation to 'Model Class diagram'{c8b2d417-cfb8-4ef1-8425-592f24f3210d} Standard.ClassDiagram->Represented: Element [0..-1][21] : java.lang.IndexOutOfBoundsException: Index: 21, Size: 17
            transaction.disableUndo();

            doUpdateDiagramElementRelation(obDiagram);

            transaction.commit();
        } catch (ConcurrentTransactionException e) {
            // Diagram modification probably run with Display.syncExec(...)
            // Dirty workaround : run the operation directly: the transaction manager does not check the thread making actions
            // is the one that created the transaction.
            //TODO add something like TransactionSupport.forceCreateSubTransaction(...)
            DiagramElements.LOG.debug("DiagramPersistence.updateDiagramElementRelation(): ConcurrentTransactionException while trying to save %s, updating it in current transaction as workaround.", obDiagram);
            DiagramElements.LOG.debug(e.toString());

            try {
                doUpdateDiagramElementRelation(obDiagram);
            } catch (RuntimeException e2) {
                e2.addSuppressed(e);
                throw e2;
            }
        };
    }

    @objid ("10ab8048-9508-4074-a88b-30f587b3b72f")
    private void doUpdateDiagramElementRelation(AbstractDiagram obDiagram) {
        Collection<Element> dgRepresented = obDiagram.getRepresented();
        Collection<Element> newcontent = new HashSet<>();

        for (Entry<MRef, List<GmModel>> entry : this.gmDiagram.models.entrySet()) {
            List<GmModel> l = entry.getValue();
            for (GmModel gmModel : l) {
                MObject representedEl = gmModel.getRepresentedElement();
                if (representedEl instanceof Element && !representedEl.equals(obDiagram) && representedEl.isValid()) {
                    newcontent.add((Element) representedEl);
                    break; // exit for loop
                }
            }
        }

        // remove spare
        dgRepresented.retainAll(newcontent);

        // add missing
        if (true) {
            newcontent.removeAll(dgRepresented);
            dgRepresented.addAll(newcontent);
        } else {
            for (Element el : newcontent) {
                if (!dgRepresented.contains(el)) {
                    dgRepresented.add(el);
                }
            }
        }
    }

}

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
package org.modelio.platform.model.ui.panels.search.query.elements.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.platform.model.ui.panels.search.query.elements.addstep.MqlAddStepNode;
import org.modelio.platform.model.ui.panels.search.query.elements.source.MqlSourceNode;
import org.modelio.platform.search.engine.searchers.query.api.model.query.AllSource;
import org.modelio.platform.search.engine.searchers.query.api.model.query.LimitsSpec;
import org.modelio.platform.search.engine.searchers.query.api.model.query.Query;
import org.modelio.platform.search.engine.searchers.query.api.model.query.Source;
import org.modelio.platform.search.engine.searchers.query.api.model.query.Step;
import org.modelio.vcore.session.api.ICoreSession;
import org.modelio.vcore.smkernel.mapi.MObject;

/**
 * Root editor domain model for MQL.
 * <p>
 * Wraps a mutable {@link Query} AST and exposes a UI-friendly tree that maps 1:1
 * to the AST while providing change notifications.
 */
@objid ("7f53256d-b218-4c17-83fd-e8fa4c47165e")
public final class MqlQueryModel extends AbstractMqlNode {
    /**
     * Fired for any model change (including nested nodes).
     */
    @objid ("f4e5f055-c2bb-4696-8c0c-520feb2ccee0")
    public static final String PROP_CHANGED = "mql.changed";

    /**
     * Fired when top-level step ordering changes.
     */
    @objid ("eb345a25-7852-4a55-a971-9e77700961e4")
    public static final String PROP_STEPS = "mql.steps";

    /**
     * Fired when the top-level source changes.
     */
    @objid ("e80b3a91-d9e3-4ef6-897e-e5cd226c3200")
    public static final String PROP_SOURCE = "mql.source";

    /**
     * Fired when query limits change.
     */
    @objid ("95b253fd-679f-407f-94f2-22f3e354e757")
    public static final String PROP_LIMITS = "mql.limits";

    @objid ("85972b0e-5f55-4962-8c97-ed3bc789e9d5")
    private String name;

    @objid ("0cdc95ac-9672-4db8-a16c-9acbf3edaa73")
    private final Query query;

    @objid ("3e73524e-4e89-4a97-83de-e4d611fa780f")
    private MqlSourceNode sourceNode;

    @objid ("2a3a1ca8-8d22-47d0-bb58-0c02850bd58e")
    private final List<MqlStepNode> stepNodes = new ArrayList<>();

    /**
     * Singleton marker node for the "+" add-step button at the end of the pipeline.
     */
    @objid ("4d28733a-4ee7-4d4a-b5a9-238e4aec453b")
    private final MqlAddStepNode addStepNode = new MqlAddStepNode(this);

    @objid ("f778fbb2-663b-4b41-a73a-cafc305d3cd2")
    public String getName() {
        return name;
    }

    @objid ("89f18b7f-85f8-48ef-b762-365948c4b58f")
    public void setName(String name) {
        this.name = name;
    }

    @objid ("3cb57dc0-0609-440d-9473-50dbafdb1a2d")
    public MqlQueryModel(final String name, final Query query) {
        super(null);
        this.name = name;
        this.query = Objects.requireNonNull(query, "query");
        rebuildFromAst();
    }

    // Simplified constructor to create an empty model
    @objid ("b57be647-6bf9-43ee-aa36-8480f913b93b")
    public MqlQueryModel(ICoreSession session) {
        this("Query",createDefaultQuery(session));
    }

    // Create a default query
    @objid ("c17def9a-9754-4b45-8c9c-df55d45d5b39")
    private static Query createDefaultQuery(ICoreSession session) {
        Source source = new AllSource("Infrastructure.ModelElement");
        List<Step> steps = List.of();
        LimitsSpec limits = new LimitsSpec();
        limits.setMaxDepth(10);
        limits.setLimit(1000);
        limits.setTimeoutMs(60000L);
        return new Query(source, steps, limits);
    }

    // Convert the model to a Query AST
    @objid ("41c728a6-b972-46e5-9150-2b197584f28a")
    public Query toQuery() {
        // The model already wraps the AST Query, which is kept up-to-date
        return this.query;
    }

    @objid ("740b2275-b385-4efc-9cdb-a47713bd381f")
    public static MqlQueryModel createDefaultAllSource(final String kindRef) {
        Source source = new AllSource(kindRef);
        List<Step> steps = List.of();
        LimitsSpec limits = new LimitsSpec();
        return new MqlQueryModel("Query",new Query(source, steps, limits));
    }

    @objid ("26fb2d38-5071-4bb5-a2b5-4ac7b6f662f0")
    public Query getQueryAst() {
        return this.query;
    }

    @objid ("beaa00ba-d36a-423b-919b-6e58fe942025")
    public MqlSourceNode getSourceNode() {
        return this.sourceNode;
    }

    @objid ("5df6a26c-8ad4-44ea-a64e-7f3e1b39dab5")
    public List<MqlStepNode> getStepNodes() {
        return Collections.unmodifiableList(this.stepNodes);
    }

    /**
     * Returns the singleton marker node for the "+" add-step button.
     */
    @objid ("343aead2-d255-4ff1-bbd8-c164f7c0109a")
    public MqlAddStepNode getAddStepNode() {
        return this.addStepNode;
    }

    @objid ("1e9495bc-4d68-460c-89fd-4c192c4393fb")
    public LimitsSpec getLimits() {
        return this.query.getLimits();
    }

    @objid ("7b5811ca-58c5-404b-be14-376669003e61")
    public void setLimitsMaxDepth(final Integer maxDepth) {
        Integer old = this.query.getLimits().getMaxDepth();
        this.query.getLimits().setMaxDepth(maxDepth);
        firePropertyChange(PROP_LIMITS, old, maxDepth);
        fireChanged();
    }

    @objid ("112a88e2-bee9-4cb2-92c5-0adf2c26a0de")
    public void setLimitsLimit(final Integer limit) {
        Integer old = this.query.getLimits().getLimit();
        this.query.getLimits().setLimit(limit);
        firePropertyChange(PROP_LIMITS, old, limit);
        fireChanged();
    }

    @objid ("2e4f9836-ec0d-45f1-94ab-a37e019beea7")
    public void setLimitsTimeoutMs(final Long timeoutMs) {
        Long old = this.query.getLimits().getTimeoutMs();
        this.query.getLimits().setTimeoutMs(timeoutMs);
        firePropertyChange(PROP_LIMITS, old, timeoutMs);
        fireChanged();
    }

    @objid ("eeaac2d3-bb07-4eed-9d9f-8df76d83731d")
    public void setSource(final Source source) {
        Objects.requireNonNull(source, "source");
        Source old = this.query.getSource();
        this.query.setSource(source);
        rebuildSourceNode();
        firePropertyChange(PROP_SOURCE, old, source);
        fireChanged();
    }

    @objid ("7dcf46f9-30ca-463d-b763-9e93af0d198b")
    public void addStep(final Step step) {
        Objects.requireNonNull(step, "step");
        this.query.addStep(step);
        this.stepNodes.add(new MqlStepNode(this, step));
        firePropertyChange(PROP_STEPS, null, step);
        fireChanged();
    }

    @objid ("f5650386-6eb7-4bce-9f75-47ad6bd9f9e6")
    public void insertStep(final int index, final Step step) {
        Objects.requireNonNull(step, "step");
        this.query.getSteps().add(index, step);
        this.stepNodes.add(index, new MqlStepNode(this, step));
        firePropertyChange(PROP_STEPS, null, step);
        fireChanged();
    }

    @objid ("9594f8c2-b198-489a-b485-73f96f7a60e0")
    public void removeStep(final int index) {
        Step removed = this.query.getSteps().get(index);
        this.query.removeStep(index);
        this.stepNodes.remove(index);
        firePropertyChange(PROP_STEPS, removed, null);
        fireChanged();
    }

    @objid ("99b1ac8d-6c73-4ad8-a640-7e10ae4c5b93")
    public void moveStep(final int fromIndex, final int toIndex) {
        if (fromIndex == toIndex) {
            return;
        }
        List<Step> steps = this.query.getSteps();
        Step step = steps.remove(fromIndex);
        steps.add(toIndex, step);

        MqlStepNode node = this.stepNodes.remove(fromIndex);
        this.stepNodes.add(toIndex, node);

        firePropertyChange(PROP_STEPS, fromIndex, toIndex);
        fireChanged();
    }

    /*   @objid ("dbe44577-57eb-4578-9063-7e31b7309635")
       public void refreshProvidedSourceFromSelection() {
           if (this.sourceNode != null) {
               this.sourceNode.refreshProvidedElementsFromSelection();
           }
       }*/
    /*  @objid ("a70c5cd1-20b4-493e-95a1-bdd482f219f1")
      public Supplier<Iterable<MObject>> getProvidedSelectionSupplier() {
          return this.providedSelectionSupplier;
      }*/
    /**
     * Refresh the {@link org.modelio.platform.query.api.model.query.ProvidedSource} elements
     * from the supplied UI selection, if this query currently uses a provided source.
     */
    @objid ("39f299ac-a4da-4673-99da-1f555c93edfa")
    void rebuildFromAst() {
        rebuildSourceNode();

        this.stepNodes.clear();
        for (Step step : this.query.getSteps()) {
            this.stepNodes.add(new MqlStepNode(this, step));
        }
    }

    @objid ("39b5bd1f-8008-48cb-9ccc-365afa94a9bb")
    void rebuildSourceNode() {
        this.sourceNode = new MqlSourceNode(this, this.query.getSource());
    }

    @objid ("a83c9a2a-7acd-4d6b-9ee9-7c00c92adc3f")
    @Override
    protected void fireChanged() {
        // Root emits the change event; nested nodes bubble up via parent.
        firePropertyChange(PROP_CHANGED, null, null);
    }

}

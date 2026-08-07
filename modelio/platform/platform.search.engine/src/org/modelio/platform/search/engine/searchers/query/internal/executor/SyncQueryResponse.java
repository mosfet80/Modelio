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
package org.modelio.platform.search.engine.searchers.query.internal.executor;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.platform.search.engine.searchers.query.api.model.result.Diagnostic;
import org.modelio.platform.search.engine.searchers.query.api.model.result.IQueryResponse;
import org.modelio.platform.search.engine.searchers.query.api.model.result.NodeWithExplainOut;
import org.modelio.platform.search.engine.searchers.query.api.model.result.PathOutput;
import org.modelio.platform.search.engine.searchers.query.api.model.result.QueryCompletionStatus;
import org.modelio.vcore.smkernel.mapi.MObject;

@objid ("4944505e-1268-4dc9-b351-6e3f75c5b85f")
public class SyncQueryResponse implements IQueryResponse, IQueryResponseFiller {
    @objid ("c2eb20f2-7641-40ef-89e3-cc515792e0ae")
    private boolean truncated;

    @objid ("3b97e1a3-32c4-49d1-b087-a118e5e88943")
    private CompletableFuture<QueryCompletionStatus> state;

    @objid ("e2b031f7-6ce2-4a43-acef-5b34ae3cc2b2")
    private final LinkedHashMap<MObject, NodeWithExplainOut> itemsByNode = new LinkedHashMap<>();

    @objid ("ba2705df-320c-4898-a3c1-4e0447c7f448")
    private List<Diagnostic> diagnostics;

    @objid ("01668d77-7075-41b2-bcda-4e4ee8cbfc72")
    public SyncQueryResponse() {
        this.state = new CompletableFuture<>();
        this.truncated = false;
        this.diagnostics = new ArrayList<>();
    }

    @objid ("360aed85-1b43-4562-9906-204e52b85f93")
    @Override
    public CompletableFuture<QueryCompletionStatus> state() {
        return this.state;
    }

    @objid ("8e2f8ac5-98e5-4f6b-ae53-33a10971092e")
    @Override
    public boolean isTruncated() {
        return this.truncated;
    }

    @objid ("231cdd1b-6886-4c26-9066-a636e63b15fd")
    @Override
    public List<NodeWithExplainOut> items() {
        return List.copyOf(this.itemsByNode.values());
    }

    @objid ("f0e3af45-eb29-41de-a695-30fe27754eae")
    @Override
    public List<Diagnostic> diagnostics() {
        return this.diagnostics;
    }

    @objid ("7302460b-ffc0-4909-b016-e58c8f0157e4")
    @Override
    public void pushItem(TraversalItem item) {
        NodeWithExplainOut newNodeWithPath = new NodeWithExplainOut(item.node(), List.of(item.path()));
        this.itemsByNode.merge(item.node(), newNodeWithPath, (existing, incoming) -> {
            Set<PathOutput> merged = new LinkedHashSet<>(existing.whyPaths());
            merged.addAll(incoming.whyPaths());
            return new NodeWithExplainOut(existing.node(), merged);
        });
    }

    @objid ("b5647cfe-47c5-4554-a33f-267706827c46")
    @Override
    public void pushDiagnostic(Diagnostic diagnostic) {
        this.diagnostics.add(diagnostic);
    }

    @objid ("1223c6c7-70b2-4b70-895f-8de1c7fbd446")
    @Override
    public void setTruncated() {
        this.truncated = true;
    }

    @objid ("afe1e601-8c41-49fe-8eb6-95a4eaba3b57")
    @Override
    public CompletableFuture<QueryCompletionStatus> getState() {
        return this.state;
    }

    @objid ("0b057fc3-1f76-4129-ae0e-1b3c6edd619e")
    @Override
    public void complete() {
        // no accumulation — results are pushed directly via pushItem()
    }

}

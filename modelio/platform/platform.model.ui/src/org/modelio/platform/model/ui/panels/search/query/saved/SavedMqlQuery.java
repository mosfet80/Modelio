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
package org.modelio.platform.model.ui.panels.search.query.saved;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.platform.search.engine.searchers.query.api.model.query.Query;

/**
 * A named, persisted MQL query with metadata.
 */
@objid ("97f1b37e-f47c-4313-ba76-5cef6d62ebae")
public class SavedMqlQuery {
    @objid ("3c36e6e2-95c1-4cac-96fb-854c31597d4f")
    private final String id;

    @objid ("9d9da647-3fea-43a7-82f5-5bfe747f0c04")
    private String name;

    @objid ("82b6a4ec-119c-4c3d-94ed-47c4743e0356")
    private String description;

    @objid ("ee785c2f-09b9-4c5e-88c6-aacb6a5796d8")
    private String summary;

    @objid ("10870df3-c430-4bcd-9228-a472fccb4d8f")
    private int executionCount;

    @objid ("6b35d009-9123-4198-8ab9-89737a7b5350")
    private Query queryAst;

    @objid ("d64ec609-d2b0-41bd-b232-dfc5a089a8d5")
    private LocalDateTime modified;

    @objid ("e4482f0f-7e27-40f3-b3f5-cdcf404809ea")
    private LocalDateTime lastExecuted;

    @objid ("39fd6b07-cebf-4e63-9be4-373888c02a9b")
    public SavedMqlQuery() {
        this.id = UUID.randomUUID().toString();
        this.modified = LocalDateTime.now();
    }

    @objid ("94430e60-e505-437f-af71-4587e82cab16")
    public String getId() {
        return this.id;
    }

    @objid ("95556a59-7f5f-4005-92f4-67c21ce46bf8")
    public String getName() {
        return this.name;
    }

    @objid ("772f8ed7-1593-4c78-b4ca-e0f1fe428b76")
    public void setName(String name) {
        this.name = name;
    }

    @objid ("52e67c28-ff02-43aa-90b9-1146d121982c")
    public String getDescription() {
        return this.description;
    }

    @objid ("5e136d44-5e7a-4464-9e15-5c4441bd664a")
    public void setDescription(String description) {
        this.description = description;
    }

    @objid ("84d726cc-5b7b-4dce-a09e-bb5248f9093a")
    public String getSummary() {
        return this.summary;
    }

    @objid ("db1f8d5a-29af-4a62-814a-cffbbb8956ef")
    public void setSummary(String summary) {
        this.summary = summary;
    }

    @objid ("481abfd3-8044-443c-ad29-5f02446d91ee")
    public Query getQueryAst() {
        return this.queryAst;
    }

    @objid ("7041a025-abaf-4c0d-ac90-d8ea91e5d9fd")
    public void setQueryAst(Query queryAst) {
        this.queryAst = queryAst;
    }

    @objid ("c55c2d34-d008-406a-9512-b18eb5a85759")
    public LocalDateTime getModified() {
        return this.modified;
    }

    @objid ("f32e9e34-2ee2-4786-aa19-4b328c9ab91b")
    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }

    @objid ("e3d08161-6ece-4f9f-83ce-602d590ae6a3")
    public int getExecutionCount() {
        return this.executionCount;
    }

    @objid ("ff724a2d-aecd-41a3-b0f8-16eea582b133")
    public void setExecutionCount(int executionCount) {
        this.executionCount = executionCount;
    }

    @objid ("16c29178-f6d5-46b1-97f3-e8a818952f59")
    public LocalDateTime getLastExecuted() {
        return this.lastExecuted;
    }

    @objid ("120a075e-7d1d-468d-a041-ed3274208342")
    public void setLastExecuted(LocalDateTime lastExecuted) {
        this.lastExecuted = lastExecuted;
    }

    @objid ("846e8b32-d1cf-4be2-b316-5a46975d27a0")
    public String getFormattedModified() {
        return this.modified != null
                ? this.modified.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
                : "";
    }

    @objid ("d2108062-f335-4c55-82db-11d70d09d340")
    public String getFormattedLastExecuted() {
        return this.lastExecuted != null
                ? this.lastExecuted.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))
                : "Never";
    }

}

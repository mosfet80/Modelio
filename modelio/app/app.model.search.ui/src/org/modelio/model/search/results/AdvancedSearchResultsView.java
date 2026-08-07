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
package org.modelio.model.search.results;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.inject.Inject;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.di.Focus;
import org.eclipse.e4.ui.di.UIEventTopic;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.widgets.Composite;
import org.modelio.gproject.core.IGProject;
import org.modelio.metamodel.uml.infrastructure.Element;
import org.modelio.platform.core.events.ModelioEventTopics;
import org.modelio.platform.core.navigate.IModelioNavigationService;
import org.modelio.platform.project.services.IProjectService;
import org.modelio.platform.search.engine.api.ModelSearchResult;
import org.modelio.platform.search.engine.api.ModelSearchResult.SearchCriterion;
import org.modelio.vcore.session.api.ICoreSession;

@objid ("a21a8f77-0591-40e3-be15-33b7e3fd2316")
public class AdvancedSearchResultsView {
    @objid ("974f703c-bd20-494d-b68a-03e800c3b934")
    public static final String VIEW_ID = "org.modelio.model.search.advanced.results.view";

    @objid ("3de99092-27c2-497a-8d7f-4b7737975c50")
    public static final String SHOW_RESULTS_TOPIC = "org/modelio/model/search/advanced/results/show";

    @objid ("3f5ac466-6a7a-4d9c-a841-7d4a836e684b")
    @Inject
    private IModelioNavigationService navigationService;

    @objid ("a0753c42-e4db-48b4-b581-f823e1553f9d")
    @Inject
    private IProjectService projectService;

    @objid ("0a7ea0ff-218d-4c0f-9864-bcc72cc6d0a9")
    private AdvancedResultsPanel resultsPanel;

    @objid ("d8681741-b133-4d4f-b3b7-f1c8cc79c47b")
    private ICoreSession session;

    @objid ("0f27831e-1886-4612-a49f-e73c272993b4")
    @PostConstruct
    public void createComposite(Composite parent) {
        IGProject project = this.projectService.getOpenedProject();
        if (project != null) {
            this.session = project.getSession();
        }

        this.resultsPanel = new AdvancedResultsPanel(parent, this.navigationService);

        this.resultsPanel.addSelectionChangedListener(new ISelectionChangedListener() {
            @Override
            public void selectionChanged(SelectionChangedEvent event) {
                IStructuredSelection selection = (IStructuredSelection) event.getSelection();
            }
        });

        //this.resultsPanel.refresh();
    }

    @objid ("53824189-fcb7-49fb-8bf5-62802a18b1a0")
    @PreDestroy
    public void dispose() {
        if (this.resultsPanel != null) {
            this.resultsPanel.dispose();
            this.resultsPanel = null;
        }
        this.session = null;
    }

    @objid ("15b6ffd9-d73a-4a09-92f7-6513ba81f949")
    @Focus
    public void setFocus() {
        if (this.resultsPanel != null) {
            this.resultsPanel.setFocus();
        }
    }

    @objid ("2d0a39d7-6d34-4fdb-83d1-2fe1f325384f")
    @Inject
    @Optional
    public void receiveSearchResults(@UIEventTopic(SHOW_RESULTS_TOPIC) SearchResultsEvent event) {
        if (this.resultsPanel != null && event != null) {
            this.resultsPanel.showResults(event.getResults(), event.getCriteria());
        }
    }

    @objid ("6d48ed30-f66a-4523-b84f-40a74672db59")
    @Inject
    @Optional
    public void onProjectClosing(@UIEventTopic(ModelioEventTopics.PROJECT_CLOSING) final IGProject project) {
        if (this.resultsPanel != null) {
            this.resultsPanel.clear();
        }
        this.session = null;
    }

    @objid ("f6c98f37-8a07-4eaa-8c5f-d0a8b924c7e6")
    @Inject
    @Optional
    public void onProjectOpened(@UIEventTopic(ModelioEventTopics.PROJECT_OPENED) final IGProject project) {
        this.session = project.getSession();
    }

    @objid ("255d75cc-19ea-4c76-b538-8f88ec8a2cc6")
    public static class SearchResultsEvent {
        @objid ("170baaf1-5e62-41a1-95bd-dbe62ab02083")
        private ModelSearchResult results;

        @objid ("228a58fa-7d0b-4d8e-be85-ee1641f166a9")
        public SearchResultsEvent(ModelSearchResult results) {
            this.results = results;
        }

        @objid ("3e7dde41-45a8-42e3-8565-b0a948bfb82f")
        public List<Element> getResults() {
            return this.results.getResults();
        }

        @objid ("64ba8016-f827-4cd9-b72f-9893d460fd8e")
        public List<SearchCriterion> getCriteria() {
            return this.results.getCriterions();
        }

    }

}

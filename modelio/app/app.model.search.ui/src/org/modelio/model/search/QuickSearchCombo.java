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
package org.modelio.model.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import jakarta.inject.Inject;
import org.eclipse.core.commands.ParameterizedCommand;
import org.eclipse.e4.core.commands.ECommandService;
import org.eclipse.e4.core.commands.EHandlerService;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.di.UIEventTopic;
import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.model.application.ui.basic.MWindow;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.e4.ui.workbench.modeling.EPartService.PartState;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.modelio.app.ui.plugin.AppUi;
import org.modelio.gproject.core.IGProject;
import org.modelio.metamodel.uml.infrastructure.Element;
import org.modelio.metamodel.uml.infrastructure.ModelElement;
import org.modelio.model.search.dialog.SearchDialog;
import org.modelio.model.search.plugin.ModelSearch;
import org.modelio.model.search.results.AdvancedSearchResultsView;
import org.modelio.platform.core.events.ModelioEventTopics;
import org.modelio.platform.core.navigate.IModelioNavigationService;
import org.modelio.platform.model.ui.swt.trimbarcomponent.TrimBarComponent;
import org.modelio.platform.project.services.IProjectService;
import org.modelio.platform.search.engine.api.DefaultSearchCriteria;
import org.modelio.platform.search.engine.api.ModelSearchResult;
import org.modelio.platform.search.engine.searchers.model.ModelSearchCriteria;
import org.modelio.platform.search.engine.searchers.model.ModelSearchEngine;
import org.modelio.platform.ui.UIImages;
import org.modelio.vcore.session.api.ICoreSession;
import org.modelio.vcore.session.api.model.IModel;
import org.modelio.vcore.smkernel.mapi.MObject;

/**
 * Provide a custom toolbar field (based on a combo) to provide the quick search
 * service (search a name space from name pattern)
 */
@objid ("000fd412-c59e-10ab-8258-001ec947cd2a")
@SuppressWarnings("restriction")
public class QuickSearchCombo extends TrimBarComponent {
    @objid ("765a6949-007f-4fa0-b25c-d8de00d8fdfb")
    private static final String SEARCH_COMMAND_ID = "org.modelio.model.search.command.search";

    @objid ("e67e658f-67b4-41c0-a7b1-719ee82944e1")
    private static String searchText = "";

    @objid ("10a875f3-7c49-4ebc-8e6d-fc2d01729869")
    @Inject
    private ECommandService commandService;

    @objid ("9d7ea73f-539e-4e35-9676-6e01911592c4")
    @Inject
    private EHandlerService handlerService;

    @objid ("e5f70252-3ad0-4940-92c2-2512ad611550")
    protected Combo searchCombo;

    @objid ("5dac4f5f-7c4e-4565-bcfb-52fe83556c35")
    private ToolBar searchToolbar;

    @objid ("27b28886-9683-4a74-96c4-6000dab5eda8")
    @Inject
    protected IEventBroker eventBroker;

    @objid ("d143b79b-32dc-4785-90b3-4715eef080f3")
    @Inject
    protected MWindow window;

    @objid ("312f79c2-1c77-47b7-94de-0bd4ef8ced6b")
    @Inject
    protected EPartService partService;

    @objid ("90d4d425-fd5e-4f58-8c39-d9deb72e4321")
    @Inject
    protected ESelectionService selectionService;

    @objid ("005a2738-ec63-10ac-8258-001ec947cd2a")
    @Inject
    protected IModelioNavigationService navigationService;

    @objid ("00393dfc-a34e-10ac-8258-001ec947cd2a")
    protected IGProject project;

    @objid ("9c6fb70b-d410-4d0a-ba14-df39a13ab157")
    public QuickSearchCombo() {
        super(ModelSearch.I18N.getString("QuickSearchCombo.SearchZone.label"));
    }

    @objid ("00110512-c59e-10ab-8258-001ec947cd2a")
    @Inject
    @Optional
    void onProjectClosed(@UIEventTopic(ModelioEventTopics.PROJECT_CLOSED) final IGProject closedProject) {
        if (!QuickSearchCombo.this.searchCombo.isDisposed()) {
            QuickSearchCombo.this.searchCombo.setEnabled(false);
            QuickSearchCombo.this.searchCombo.removeAll();
            SearchDialog.closeInstance();
        }
        QuickSearchCombo.this.project = null;
        setVisible(false);
    }

    @objid ("0010cade-c59e-10ab-8258-001ec947cd2a")
    @Inject
    @Optional
    void onProjectOpened(@UIEventTopic(ModelioEventTopics.PROJECT_OPENED) final IGProject openedProject, IProjectService projectService) {
        QuickSearchCombo.this.searchCombo.setEnabled(true);
        QuickSearchCombo.this.searchCombo.removeAll();
        QuickSearchCombo.this.project = openedProject;

        // Reload saved search history
        IPreferenceStore statePrefs = projectService.getStatePreferences();
        StatePersistenceHelper.restoreState(statePrefs, this);

        setVisible(true);
    }

    @objid ("6d103eda-afcd-477d-afaf-bfbcec1615be")
    @Override
    protected Control createControl(Composite parent) {
        // The control is a toolbar
        this.searchToolbar = new ToolBar(parent, SWT.WRAP | SWT.RIGHT | SWT.FLAT);

        // The toolbar has a combo for the search history
        ToolItem comboItem = new ToolItem(this.searchToolbar, SWT.SEPARATOR);
        this.searchCombo = new Combo(this.searchToolbar, SWT.DROP_DOWN | SWT.SINGLE | SWT.V_SCROLL | SWT.H_SCROLL);
        this.searchCombo.setToolTipText(ModelSearch.I18N.getString("QuickSearch.tooltip"));
        this.searchCombo.addSelectionListener(new SCWSelectionListener(this));
        this.searchCombo.setEnabled(false);
        this.searchCombo.addModifyListener(new ModifyListener() {
            @Override
            public void modifyText(ModifyEvent e) {
                final Combo combo = (Combo) e.getSource();
                if (ModelSearchCriteria.isValidExpression(combo.getText())) {
                    combo.setForeground(combo.getDisplay().getSystemColor(SWT.COLOR_LIST_FOREGROUND));
                } else {
                    combo.setForeground(combo.getDisplay().getSystemColor(SWT.COLOR_RED));
                }
                QuickSearchCombo.searchText = combo.getText();
            }
        });

        comboItem.setWidth(200);
        comboItem.setControl(this.searchCombo);

        // The toolbar also has a search button
        ToolItem item = new ToolItem(this.searchToolbar, SWT.PUSH);
        item.setToolTipText(ModelSearch.I18N.getString("QuickSearch.execute.tooltip"));
        item.setImage(UIImages.SEARCH);
        // Execute the e4 handler for "create diagram" with the contribution
        Map<String, Object> parameters = new HashMap<>();
        ParameterizedCommand openCommand = this.commandService.createCommand(QuickSearchCombo.SEARCH_COMMAND_ID,
                parameters);

        item.addSelectionListener(new SelectionListener() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                QuickSearchCombo.this.handlerService.executeHandler(openCommand);
            }

            @Override
            public void widgetDefaultSelected(SelectionEvent e) {
                // Nothing to do
            }
        });
        return this.searchToolbar;
    }

    /**
     * This method is called when the end-user validate (press ENTER) the filter
     * combo text.<br/>
     * It runs a default search using:
     * <ul>
     * <li>metaclass filter = NameSpace</li>
     * <li>includeRamc = true</li>
     * <li>no stereotype </li<
     * </ul>
     *
     * @param expression the search expression
     */
    @objid ("00102d0e-c59e-10ab-8258-001ec947cd2a")
    protected void runSearch(String expression) {
        if (this.project == null) {
            return; // not expected, but in any case cannot do anything without
            // a project
        }

        if (searchForUuid(expression)) {
            return;
        }

        final ICoreSession session = this.project.getSession();

        ModelSearchResult found = null;

        // Search By ID
        try {
            UUID.fromString(expression);
            List<MObject> result = Arrays.asList(
                    session.getModel().findById(session.getMetamodel().getMClass(ModelElement.MQNAME), expression));
            found = new ModelSearchResult(result.stream().map(o -> (Element) o).collect(Collectors.toList()),
                    new ArrayList<>());
        } catch (@SuppressWarnings("unused") IllegalArgumentException e) {
            // ignore and continue search
        }

        // Search exact Name
        if (found == null) {
            ModelSearchEngine basicSearch = new ModelSearchEngine();
            ModelSearchCriteria searchCriteria = new ModelSearchCriteria();
            searchCriteria.addMetaclass(ModelElement.class);
            searchCriteria.setIncludeRamc(false);
            searchCriteria.setExpression(expression + ".*");

            found = basicSearch.search(session, searchCriteria);
        }

        switch (found.getResults().size()) {
        case 0:
            // No element found
            runExtendedSearch(expression);
            break;
        case 1:
            // One matching element found => navigate
            this.navigationService.fireNavigate(found.getResults().get(0));
            break;
        default:
            // Several matching elements => propose for choice.
            openSearchResultView();
            AdvancedSearchResultsView.SearchResultsEvent event = new AdvancedSearchResultsView.SearchResultsEvent(found);
            this.eventBroker.post(AdvancedSearchResultsView.SHOW_RESULTS_TOPIC, event);
        }
    }

    /**
     * Called when a quick search returned no results.
     *
     * @param quickSearchCriteria the quick search used criteria
     */
    @objid ("0010400a-c59e-10ab-8258-001ec947cd2a")
    private void runExtendedSearch(String expression) {
        final ICoreSession session = this.project.getSession();
        final DefaultSearchCriteria searchCriteria = new DefaultSearchCriteria();

        searchCriteria.setOption("name", expression);

        // No Element found or several matching elements => propose for choice.
        final SearchDialog dlg = SearchDialog.getInstance(this.searchCombo.getShell(), session, this.navigationService,
                this.eventBroker, window, partService, this.selectionService);
        dlg.setBlockOnOpen(false);

        dlg.open();
        dlg.setDisplayedContent(searchCriteria);
    }

    @objid ("57d3d80d-4118-4e3b-a96e-bd282ec74b8e")
    public void openSearchResultView() {
        MPart part = null;

        // Get a shared part (if exists)
        for (MUIElement x : this.window.getSharedElements()) {
            if (x.getElementId().equals(AdvancedSearchResultsView.VIEW_ID)) {
                part = (MPart) x;
                break;
            }
        }

        // Get an existing part
        if (part == null) {
            part = this.partService.findPart(AdvancedSearchResultsView.VIEW_ID);
        }

        // Create one
        if (part == null)
            part = this.partService.createPart(AdvancedSearchResultsView.VIEW_ID);

        if (part != null) {
            this.partService.showPart(part, PartState.ACTIVATE);
            AppUi.LOG.debug("Show view %s", AdvancedSearchResultsView.VIEW_ID);
        } else {
            AppUi.LOG.debug("The view %s is null.", AdvancedSearchResultsView.VIEW_ID);
        }
    }

    @objid ("f8221b89-cfbd-479e-99f9-b7a73aaf1730")
    private boolean searchForUuid(String expression) {
        try {
            final ICoreSession session = this.project.getSession();
            MObject found = session.getModel().findById(MObject.class, expression, IModel.NODELETED);
            if (found != null) {
                this.navigationService.fireNavigate(found);
                return true;
            }

        } catch (@SuppressWarnings("unused") IllegalArgumentException e) {
            // ignore and return false
        }
        return false;
    }

    @objid ("00164fd5-f534-498f-8cb3-886c0a4ce24e")
    @Inject
    @Optional
    void onProjectClosing(@UIEventTopic(ModelioEventTopics.PROJECT_CLOSING) final IGProject project, IProjectService projectService) {
        // Save search history
        IPreferenceStore statePrefs = projectService.getStatePreferences();
        StatePersistenceHelper.saveState(statePrefs, this);
    }

    @objid ("eeab8a1b-3900-4557-a72c-6d2fcecc831a")
    public static String getSearchText() {
        return QuickSearchCombo.searchText;
    }

    @objid ("00106d8c-c59e-10ab-8258-001ec947cd2a")
    private static final class SCWSelectionListener implements SelectionListener {
        @objid ("001075ca-c59e-10ab-8258-001ec947cd2a")
        QuickSearchCombo scw;

        @objid ("00107ce6-c59e-10ab-8258-001ec947cd2a")
        public SCWSelectionListener(QuickSearchCombo scw) {
            this.scw = scw;
        }

        @objid ("0010900a-c59e-10ab-8258-001ec947cd2a")
        @Override
        public void widgetSelected(SelectionEvent e) {
            final String expression = this.scw.searchCombo.getText();
            this.scw.searchCombo.setText(expression);
            this.scw.searchCombo.setSelection(new Point(expression.length(), expression.length()));
        }

        @objid ("0010ad2e-c59e-10ab-8258-001ec947cd2a")
        @Override
        public void widgetDefaultSelected(SelectionEvent e) {
            final String expression = this.scw.searchCombo.getText();
            this.scw.runSearch(expression);
            try {
                // Avoid duplicated expressions in the combo
                this.scw.searchCombo.remove(expression);
            } catch (@SuppressWarnings("unused") IllegalArgumentException ex) {
                // expression not in the combo, ignore exception
            }
            this.scw.searchCombo.add(expression, 0);
            this.scw.searchCombo.setText("");
        }

    }

    @objid ("91684e20-4785-468b-ba13-ed4f18c799dd")
    private static class StatePersistenceHelper {
        @objid ("ceba83cd-be21-4af8-8908-48f8c98c8200")
        private static final String SEARCH_HISTORY_CONFIG_KEY = ModelSearch.PLUGIN_ID + ".SearchHistory";

        @objid ("d6c8b16b-9f33-46a9-ba49-a7722952b411")
        private static final int MAX_HISTORY = 8;

        @objid ("2ec7159e-3cea-45cd-ae88-a2c94c64b589")
        public static void restoreState(IPreferenceStore savedPrefs, QuickSearchCombo searchCombo) {
            // Empty combo list
            searchCombo.searchCombo.removeAll();

            // Read search history items
            for (int i = 1; i < StatePersistenceHelper.MAX_HISTORY; i++) {
                String key = StatePersistenceHelper.SEARCH_HISTORY_CONFIG_KEY + i;
                String value = savedPrefs.getString(key);
                if (value != null && !value.isEmpty()) {
                    searchCombo.searchCombo.add(value);
                } else {
                    break;
                }
            }
        }

        @objid ("1680d533-9e27-4546-9767-ea8cf6e93d0d")
        public static void saveState(IPreferenceStore prefs, QuickSearchCombo searchCombo) {
            StatePersistenceHelper.clean(prefs);

            int i = 1;
            for (String item : searchCombo.searchCombo.getItems()) {
                String key = StatePersistenceHelper.SEARCH_HISTORY_CONFIG_KEY + i;
                prefs.setValue(key, item);
                i++;
                if (i > StatePersistenceHelper.MAX_HISTORY) {
                    break;
                }
            }
        }

        @objid ("7cd35eb1-5549-4f6d-9336-3e1eb7e947ba")
        private static void clean(IPreferenceStore prefs) {
            // Clean previous values
            for (int i = 1; i < StatePersistenceHelper.MAX_HISTORY; i++) {
                String key = StatePersistenceHelper.SEARCH_HISTORY_CONFIG_KEY + i;
                prefs.setToDefault(key);
            }
        }

    }

}

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

import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.modelio.metamodel.uml.infrastructure.Element;
import org.modelio.metamodel.uml.infrastructure.ModelElement;
import org.modelio.metamodel.uml.infrastructure.TagType;
import org.modelio.metamodel.uml.infrastructure.properties.PropertyDefinition;
import org.modelio.metamodel.uml.statik.Classifier;
import org.modelio.metamodel.uml.statik.Feature;
import org.modelio.model.search.plugin.ModelSearch;
import org.modelio.platform.core.navigate.IModelioNavigationService;
import org.modelio.platform.model.ui.swt.labelprovider.UniversalLabelProvider2;
import org.modelio.platform.search.engine.api.ModelSearchResult.SearchCriterion;
import org.modelio.platform.ui.UIColor;
import org.modelio.platform.ui.UIFont;
import org.modelio.vcore.smkernel.mapi.MAttribute;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.mapi.MStatus;

@objid ("c7542e37-b068-4e80-bc2b-776ef7973f6a")
public class AdvancedResultsPanel {
    @objid ("425155a8-37bf-4daa-9b8e-66bd40263d81")
    private Composite composite;

    @objid ("b90b4f31-734b-48d6-9aea-e7f6289e1730")
    private TableViewer tableViewer;

    @objid ("454a4eb8-89df-4651-bc0a-3bde58882c94")
    private IModelioNavigationService navigationService;

    @objid ("ba8378b1-6a9d-4f6f-a70d-0f67f9e49f41")
    private List<SearchCriterion> criterion;

    @objid ("f278f60a-2439-4ea6-a89d-a9bc5afc1578")
    private List<Object> currentResults;

    @objid ("8a21bb7b-0b07-4a66-ac59-0d3e8f54ffba")
    private UniversalLabelProvider2 universalLabelProvider;

    @objid ("3bef7801-ca71-4f98-9b31-0def84e93552")
    public AdvancedResultsPanel(Composite parent, IModelioNavigationService navigationService) {
        this.navigationService = navigationService;
        this.currentResults = new ArrayList<>();
        this.universalLabelProvider = new UniversalLabelProvider2();
        createUI(parent);
    }

    @objid ("b60b650b-07a0-4985-9a3a-ed84da5d17fb")
    private void createUI(Composite parent) {
        this.composite = new Composite(parent, SWT.NONE);
        this.composite.setLayout(new GridLayout());
        this.composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

        this.tableViewer = new TableViewer(this.composite,
                SWT.BORDER | SWT.FULL_SELECTION | SWT.MULTI | SWT.V_SCROLL | SWT.H_SCROLL);

        Table table = this.tableViewer.getTable();
        table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        table.setHeaderVisible(true);
        table.setLinesVisible(true);

        createDefaultColumns();

        this.tableViewer.setContentProvider(new IStructuredContentProvider() {
            @Override
            public Object[] getElements(Object inputElement) {
                if (inputElement instanceof List) {
                    return ((List<?>) inputElement).toArray();
                }
                return new Object[0];
            }
        });

        this.tableViewer.addDoubleClickListener(new IDoubleClickListener() {
            @Override
            public void doubleClick(DoubleClickEvent event) {
                IStructuredSelection selection = (IStructuredSelection) event.getSelection();
                if (!selection.isEmpty() && selection.getFirstElement() instanceof MObject) {
                    MObject element = (MObject) selection.getFirstElement();
                    AdvancedResultsPanel.this.navigationService.fireNavigate(element);
                }
            }
        });
    }

    @objid ("6ecefccc-2815-4ea7-ab39-3dcd746b3813")
    private void createDefaultColumns() {
        TableViewerColumn nameColumn = new TableViewerColumn(this.tableViewer, SWT.NONE);
        TableColumn nameCol = nameColumn.getColumn();
        nameCol.setText("Element ↕");
        nameCol.setWidth(200);
        ColumnLabelProvider nameLabelProvider =  new ColumnLabelProvider() {
            @Override
            public String getText(Object element) {
                return AdvancedResultsPanel.this.universalLabelProvider.getText(element);
            }

            @Override
            public Image getImage(Object element) {
                return AdvancedResultsPanel.this.universalLabelProvider.getImage(element);
            }

            @Override
            public Color getForeground(Object element) {
                if (element instanceof MObject) {
                    MStatus status = ((MObject) element).getStatusLazy();
                    if (status.isRamc()) {
                        return UIColor.RAMC_ELEMENT_FG;
                    } else if (!status.isModifiable()) {
                        return UIColor.NONMODIFIABLE_ELEMENT_FG;
                    }
                }
                return null;
            }

            @Override
            public Font getFont(Object element) {
                if (element instanceof MObject && !((MObject) element).isShell()) {
                    if (element instanceof Classifier && ((Classifier) element).isIsAbstract()) {
                        return UIFont.NORMALI;
                    }
                    if (element instanceof Feature && ((Feature) element).isIsAbstract()) {
                        return UIFont.NORMALI;
                    }
                }
                return null;
            }
        };
        nameColumn.setLabelProvider(nameLabelProvider);
        addColumnSorting(nameColumn, nameLabelProvider);

        TableViewerColumn contextColumn = new TableViewerColumn(this.tableViewer, SWT.NONE);
        TableColumn contextCol = contextColumn.getColumn();
        contextCol.setText("Context ↕");
        contextCol.setWidth(300);

        ColumnLabelProvider contextLabelProvider =  new ColumnLabelProvider() {
            @Override
            public String getText(Object element) {
                if (element instanceof Element) {
                    MObject parent = ((Element) element).getCompositionOwner();
                    return getContext(parent, 6);
                }
                return "";
            }

            private String getContext(MObject parent, int i) {
                MObject current = parent;
                String result = "";
                while(current != null && i > 0) {
                    result = current.getName() + ( result.isEmpty() ? "": "." + result);
                    current = current.getCompositionOwner();
                    i --;
                }
                return result;
            }
        };
        contextColumn.setLabelProvider(contextLabelProvider);
        addColumnSorting(contextColumn, contextLabelProvider);
    }

    @objid ("533a0b36-64f3-41f7-9c3f-225906992723")
    public void showResults(List<Element> results, List<SearchCriterion> criteria) {
        this.currentResults = results != null ? new ArrayList<>(results) : new ArrayList<>();
        this.criterion = criteria;

        for (TableColumn column : this.tableViewer.getTable().getColumns()) {
            column.dispose();
        }

        createDefaultColumns();

        if (this.criterion != null) {
            for (SearchCriterion propertyCriterion : this.criterion) {
                createPropertyColumn(propertyCriterion);
            }
        }

        if (this.currentResults.isEmpty()) {
            this.currentResults.add(ModelSearch.I18N.getString("AdvancedSearchResults.noResults"));
        }

        this.tableViewer.setInput(this.currentResults);
        this.tableViewer.refresh();

        this.composite.layout(true, true);
    }

    @objid ("4fdafd6e-d518-437d-acd7-bd2a030afb93")
    private void createPropertyColumn(SearchCriterion criterion) {
        String propertyName = criterion.propertyName();

        TableViewerColumn propColumn = new TableViewerColumn(this.tableViewer, SWT.NONE);
        TableColumn col = propColumn.getColumn();
        col.setText(propertyName +" ↕");
        col.setWidth(150);
        ColumnLabelProvider contextLabelProvider = new ColumnLabelProvider() {
            @Override
            public String getText(Object element) {
                if (criterion.type() instanceof MAttribute) {
                    return getValue((MAttribute) criterion.type(), (ModelElement) element);
                } else if (criterion.type() instanceof TagType) {
                    return getValue((TagType) criterion.type(), (ModelElement) element);
                } else if (criterion.type() instanceof PropertyDefinition) {
                    return getValue((PropertyDefinition) criterion.type(), (ModelElement) element);
                }
                return "";
            }

        };
        propColumn.setLabelProvider(contextLabelProvider);
        addColumnSorting(propColumn,contextLabelProvider);
    }

    @objid ("0e892792-4969-4306-a60a-25e28b20033b")
    private void addColumnSorting(TableViewerColumn viewerColumn, ColumnLabelProvider labelProvider) {
        TableColumn column = viewerColumn.getColumn();
        column.addSelectionListener(new org.eclipse.swt.events.SelectionAdapter() {
            @Override
            public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
                Table table = AdvancedResultsPanel.this.tableViewer.getTable();
                TableColumn sortColumn = table.getSortColumn();
                int direction = table.getSortDirection();

                if (sortColumn == column) {
                    direction = (direction == SWT.UP) ? SWT.DOWN : SWT.UP;
                } else {
                    direction = SWT.UP;
                }

                table.setSortColumn(column);
                table.setSortDirection(direction);

                final int dir = direction;
                AdvancedResultsPanel.this.tableViewer.setComparator(new ViewerComparator() {
                    @Override
                    public int compare(Viewer viewer, Object e1, Object e2) {
                        String t1 = labelProvider.getText(e1);
                        String t2 = labelProvider.getText(e2);
                        if (t1 == null) t1 = "";
                        if (t2 == null) t2 = "";
                        int result = t1.compareToIgnoreCase(t2);
                        return (dir == SWT.DOWN) ? -result : result;
                    }
                });
            }
        });
    }

    @objid ("17b104cb-bfc3-43f2-b5fa-8815fe73685c")
    protected String getValue(PropertyDefinition type, ModelElement element) {
        return element.getProperty(type.getOwner().getName(), type.getName());
    }

    @objid ("c0b91e7c-c9e3-4ad7-8d49-e8e48d4aa86a")
    protected String getValue(TagType type, ModelElement element) {
        return element.getTagValue(type);
    }

    @objid ("400a80e1-fca7-41a0-a44d-9cb9e6259aea")
    private String getValue(MAttribute type, ModelElement element) {
        return element.mGet(type).toString();
    }

    @objid ("0521a271-76f1-4406-acb2-2b6e6ce40d62")
    public void refresh() {
        if (this.tableViewer != null && !this.tableViewer.getTable().isDisposed()) {
            this.tableViewer.refresh();
        }
    }

    @objid ("14c7cc30-db66-4f07-acce-8686d674674b")
    public void clear() {
        this.currentResults = new ArrayList<>();
        this.tableViewer.setInput(this.currentResults);
        this.tableViewer.refresh();
        this.criterion = new ArrayList<>();
        this.composite.layout(true, true);
    }

    @objid ("e0a9bb47-d202-46f1-bdda-8211446da16d")
    public void setFocus() {
        if (this.tableViewer != null && this.tableViewer.getTable() != null) {
            this.tableViewer.getTable().setFocus();
        }
    }

    @objid ("cd9dfbb0-b931-40b6-b97b-27e60e4241b4")
    public void dispose() {
        if (this.universalLabelProvider != null) {
            this.universalLabelProvider.dispose();
            this.universalLabelProvider = null;
        }
        if (this.composite != null && !this.composite.isDisposed()) {
            this.composite.dispose();
        }
    }

    @objid ("9c8cf899-09fa-43f3-8437-73232cffa0e2")
    public void addSelectionChangedListener(ISelectionChangedListener listener) {
        this.tableViewer.addSelectionChangedListener(listener);
    }

}

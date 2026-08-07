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
/*
 * Copyright 2013-2024 Docaposte
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
package org.modelio.diagram.editor.handlers.unmask.ui;

import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ControlListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.modelio.diagram.elements.plugin.DiagramElements;
import org.modelio.platform.model.ui.swt.images.MetamodelImageService;
import org.modelio.platform.ui.UIColor;
import org.modelio.platform.ui.UIImages;
import org.modelio.platform.ui.dialog.ModelioDialog2;
import org.modelio.platform.ui.dialog.PolluxWidgetConfigurator;
import org.modelio.vcore.smkernel.mapi.MClass;

@objid ("4250aead-5ff2-42e4-84ef-f65b659ae9dd")
public class UnmaskLinkSelectionDialog extends ModelioDialog2 {
    @objid ("172b962c-a758-4958-a0a5-6a8553059ee6")
    private List<LinkedElementData> _data;

    @objid ("7dcdc824-7b45-4b24-8bba-412bf61c7bd2")
    private Controler _controler;

    @objid ("8e6fde35-ba69-4cbc-9337-7ce548fb6546")
    private Ui _ui;

    @objid ("5333c213-549a-4bbe-ae5c-7e8c2b708d37")
    public UnmaskLinkSelectionDialog(Shell parentShell) {
        super(parentShell);
        this._controler = new Controler();
        this._ui = new Ui(this._controler);
        this._controler.setUi(this._ui);
    }

    @objid ("694ae5fe-c521-4ee6-9292-4adc77a512aa")
    @Override
    protected Point getInitialSize() {
        return new Point(400, 400);
    }

    @objid ("e0da1c97-29c0-423a-b93c-2f9bbc9d2d23")
    @Override
    protected void addButtonsInButtonBar(Composite parent) {
        addDefaultButtons(parent);
        getButton(IDialogConstants.OK_ID).setEnabled(true);
        this._ui.setOkButton(getButton(IDialogConstants.OK_ID));
    }

    @objid ("21a1f7bf-cc89-4950-8321-72caa5a61bdd")
    @Override
    protected Control createContentArea(Composite parent) {
        Composite top = this._ui.create(parent);
        if (this._data != null) {
            this._controler.updateData(this._data);
        }
        return top;
    }

    @objid ("f531849e-a499-46d5-9b7d-4d87531d1959")
    @Override
    protected void init() {

    }

    @objid ("e0becc62-0758-46e6-a202-4aeae1c596b8")
    public void setInput(List<LinkedElementData> data) {
        this._data = data;
    }

    @objid ("2e1db229-4424-434f-aa5e-d06d3653379c")
    private static class Controler {
        @objid ("aa5171c6-0403-42d6-b4c5-fb5349b1a41b")
        private Ui _ui;

        @objid ("91af6dc2-9fa3-4526-bd4c-0cef88b0795a")
        private List<LinkedElementData> _data;

        @objid ("d9623a34-d821-4f51-b9ce-052ac478b1fd")
        public void setUi(Ui ui) {
            this._ui = ui;
        }

        @objid ("28b97a92-e0fc-4c1c-9461-751abc5c678c")
        public void updateData(List<LinkedElementData> data) {
            this._data = data;
            this._ui.update(data);
        }

        @objid ("e541d744-17dc-4ec6-8e74-ab3e04b58b52")
        public void onSearchUpdate(String searchText) {
            List<LinkedElementData> filtredData = new ArrayList<>();
            if (this._data != null) {
                for (LinkedElementData candidate : this._data) {
                    LinkedElementData mobj = candidate;
                    if (mobj.getFirstLinkedElement().getName().contains(searchText) ||
                            mobj.getLink().getMClass().getName().contains(searchText)) {
                        filtredData.add(candidate);
                    }
                }
            }
            this._ui.update(filtredData);
        }

        @objid ("736cbac6-5b53-4640-ae8b-d631dfd7d3a4")
        public boolean onElementSelectionChange(List<LinkedElementData> element) {
            boolean updateRequired = false;
            for (LinkedElementData candidate : this._data) {
                if(element.contains(candidate)) {
                    if(!candidate.getIsSelected()) {
                        candidate.setIsSelected(true);
                        updateRequired = true;
                    }
                }else {
                    if(candidate.getIsSelected()) {
                        candidate.setIsSelected(false);
                        updateRequired = true;
                    }
                }
            }
            return updateRequired;
        }

    }

    @objid ("49c94c1d-15fa-42c6-ba9d-69ea6cc692bd")
    private static class Ui {
        @objid ("356ae135-83ac-438a-bad3-0476b1cb6491")
        private Composite _rootComposite;

        @objid ("295b98ae-220c-4355-af8e-3b519c4c5d7e")
        private CLabel _headerLabel;

        @objid ("6b137e71-6362-478b-b50e-b235be648389")
        private TableViewer _existingElementTable;

        @objid ("1fa726c5-1030-4975-b247-3ff66db7eeef")
        private Text _searchText;

        @objid ("f9aba841-181d-425d-a31d-ba9b48c17e89")
        private Button _okButton;

        @objid ("84815dd9-9884-4af1-b5b6-e5a37d3bd41d")
        private Controler _controler;

        @objid ("f2f3b542-4c04-4e10-b800-2dcccc96b306")
        public Ui(Controler controler) {
            this._controler = controler;
        }

        @objid ("cce54ff6-7fac-4649-873e-aa02b06914b2")
        public Composite create(Composite parent) {
            this._rootComposite = new Composite(parent, SWT.NONE);
            GridData gd = new GridData(GridData.FILL_BOTH | GridData.GRAB_HORIZONTAL | GridData.GRAB_VERTICAL);
            this._rootComposite.setLayoutData(gd);
            this._rootComposite.setFont(parent.getFont());
            PolluxWidgetConfigurator.configureContainer(this._rootComposite);
            createHeaderArea(this._rootComposite);
            createElementsTable(this._rootComposite);
            return this._rootComposite;
        }

        @objid ("7bf829cb-ed2d-4459-b76d-4716ac3a7fd8")
        private Composite createHeaderArea(Composite parent) {
            this._headerLabel = new CLabel(parent, SWT.NONE);
            PolluxWidgetConfigurator.configureHeaderField(this._headerLabel);
            return this._headerLabel;
        }

        @objid ("2d8a6330-d6a9-4613-a7a3-20de11c7b6a2")
        private Composite createElementsTable(Composite parent) {
            Composite listComposite = new Composite(parent, SWT.NONE);
            GridData gd = new GridData(GridData.FILL_BOTH);
            listComposite.setLayoutData(gd);
            PolluxWidgetConfigurator.configureContainer(listComposite);

            createSearchComposite(listComposite);

            this._searchText.addListener(SWT.Modify, new Listener() {
                @Override
                public void handleEvent(Event event) {
                    Ui.this._controler.onSearchUpdate(Ui.this._searchText.getText());
                }
            });

            this._existingElementTable = new TableViewer(listComposite, SWT.V_SCROLL | SWT.BORDER | SWT.MULTI);

            this._existingElementTable.getTable().setLayoutData(new GridData(GridData.FILL_BOTH));
            this._existingElementTable.setContentProvider(ArrayContentProvider.getInstance());

            TableViewerColumn elementListColumn = new TableViewerColumn(this._existingElementTable, SWT.FILL);
            elementListColumn.getColumn().setAlignment(SWT.CENTER);
            elementListColumn.getColumn().setResizable(false);

            // Universal Label Provider
            elementListColumn.setLabelProvider(new ColumnLabelProvider() {
                @Override
                public String getText(Object element) {
                    LinkedElementData linkedElement = (LinkedElementData) element;


                    String dependencyLabel = "";
                    if(!"".equals(linkedElement.getLink().getName())){
                        dependencyLabel =  " (" + linkedElement.getLink().getName() + " - "  + linkedElement.getLink().getMClass().getName() + ")";
                    }else {
                        dependencyLabel =  " (" + linkedElement.getLink().getMClass().getName() + ")";
                    }

                    return linkedElement.getFirstLinkedElement().getName() + dependencyLabel;
                }

                @Override
                public Image getImage(Object element) {
                    LinkedElementData linkedElement = (LinkedElementData) element;
                    return getMetaclassImage(linkedElement.getFirstLinkedElement().getMClass());
                }

            });

            this._existingElementTable.getControl().addControlListener(new ControlListener() {
                @Override
                public void controlResized(ControlEvent e) {
                    Rectangle rect = Ui.this._existingElementTable.getTable().getClientArea();
                    if (rect.width > 0) {
                        elementListColumn.getColumn().setWidth(rect.width);
                    }
                }

                @Override
                public void controlMoved(ControlEvent e) {
                    // TODO Auto-generated method stub
                }
            });

            this._existingElementTable.addSelectionChangedListener(new ISelectionChangedListener() {
                @Override
                public void selectionChanged(SelectionChangedEvent event) {
                    IStructuredSelection selection = Ui.this._existingElementTable.getStructuredSelection();
                    if (Ui.this._controler.onElementSelectionChange(selection.toList())) {
                        Ui.this._controler.onSearchUpdate(Ui.this._searchText.getText());
                    }
                }
            });
            return listComposite;
        }

        @objid ("6fdd5793-32bc-4cac-b2ef-50341ef84f9a")
        private Composite createSearchComposite(Composite composite) {
            Composite searchComposite = new Composite(composite, SWT.NONE);
            GridData gd = new GridData(GridData.FILL_HORIZONTAL);
            searchComposite.setLayoutData(gd);
            PolluxWidgetConfigurator.configureContainer(searchComposite);

            GridLayout gridLayout = new GridLayout();
            gridLayout.numColumns = 2;

            searchComposite.setLayout(gridLayout);
            Label searchImage = new Label(searchComposite, SWT.NONE);
            searchImage.setImage(UIImages.SEARCH);
            searchImage.setBackground(UIColor.WHITE);
            searchImage.setSize(30, 30);
            this._searchText = new Text(searchComposite, SWT.BORDER | SWT.WRAP | SWT.SINGLE);
            this._searchText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
            return searchComposite;
        }

        @objid ("b32563c8-5207-4f71-9603-f216ebc32ec2")
        public void update(List<LinkedElementData> data) {
            this._headerLabel.setText(DiagramElements.I18N.getMessage("linkselection.dialog.description"));
            this._existingElementTable.setInput(data);

            List<LinkedElementData> selected = new ArrayList<>();
            for(LinkedElementData linked : data) {
                if(linked.getIsSelected()) {
                    selected.add(linked);
                }
            }

            this._existingElementTable.setSelection(new StructuredSelection(selected));
            if(this._okButton != null) {
                this._okButton.setEnabled(!selected.isEmpty());
            }
        }

        @objid ("9198d038-e4a1-4642-9dfe-3bd734c58586")
        private Image getMetaclassImage(MClass metaclass) {
            return MetamodelImageService.getIcon(metaclass);
        }

        @objid ("37b392f7-f92d-4206-9e45-8a73aeeb180c")
        public void setOkButton(Button button) {
            this._okButton = button;
        }

    }

}

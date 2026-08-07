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
package org.modelio.platform.model.ui.panels.search.note;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.TraverseEvent;
import org.eclipse.swt.events.TraverseListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.modelio.metamodel.uml.infrastructure.NoteType;
import org.modelio.platform.model.ui.panels.search.IPanelValidationListener;
import org.modelio.platform.model.ui.panels.search.ISearchController;
import org.modelio.platform.model.ui.panels.search.ISearchPanel;
import org.modelio.platform.model.ui.plugin.CoreUi;
import org.modelio.platform.search.engine.api.ISearchCriteria;
import org.modelio.platform.search.engine.searchers.model.ModelSearchCriteria;
import org.modelio.platform.search.engine.searchers.note.NoteSearchCriteria;
import org.modelio.platform.ui.UIFont;
import org.modelio.platform.ui.dialog.PolluxWidgetConfigurator;
import org.modelio.vcore.session.api.ICoreSession;
import org.modelio.vcore.session.api.model.IModel;
import org.modelio.vcore.smkernel.mapi.MObject;

/**
 * Model search criteria panel. It is composed of:
 * <ul>
 * <li>a name pattern field</li>
 * <li>a metaclass selection table</li>
 * <li>a checkbox to include or not the 'ramc' elements</li<
 * <li>a text field to enter a (unique) stereotype name</li>
 * </ul>
 */
@objid ("ecdf6679-4109-4a33-8384-95952139b94c")
public class NoteSearchPanel implements ISearchPanel {
    @objid ("eae38d46-ceb0-4bea-8bc1-3fe01da1c7bc")
    private static final String DEFAULT_NOTE_TYPE = "description";

    @objid ("2c75028b-4ff7-48d9-90dd-9f7b4d4fbfa3")
    private Composite topGroup;

    @objid ("24e32bc1-b253-49af-87f3-b400e8f16bfc")
    private Text textfield = null;

    @objid ("0bdd12b1-d7ce-4181-9d8b-8067d1722ea2")
    private Button includeRamcCheckBox;

    @objid ("522f406b-046a-444e-96be-96843b94ebdf")
    private Button caseSensitiveCheckBox;

    @objid ("5c7afec0-b500-4bc7-a565-f405c9be6e23")
    private Combo notetypeCombo;

    @objid ("de6a0ca7-4047-4dd1-81de-7bb67554a213")
    private NoteSearchCriteria searchCriteria;

    @objid ("ed39fe21-c700-47f8-a10a-95199159edf5")
    private IPanelValidationListener validationListener;

    @objid ("c7ebacd5-569d-4b58-a6d1-5e3f0eae51d8")
    @Override
    public void initialize(Composite parent, ICoreSession session, ISearchController searchController, ESelectionService selectionService, IPanelValidationListener validationListener) {
        this.validationListener = validationListener;

        this.topGroup = new Composite(parent, SWT.NONE);
        PolluxWidgetConfigurator.configureContainer(this.topGroup);
        this.topGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        GridLayout gridLayout = new GridLayout(1, false);
        this.topGroup.setLayout(gridLayout);

        // The name pattern field and its label
        final Label nameLabel = new Label(this.topGroup, SWT.NONE);
        this.textfield = new Text(this.topGroup, SWT.SINGLE | SWT.BORDER);

        GridData gridData = new GridData(SWT.FILL, SWT.TOP, true, false);
        this.textfield.setLayoutData(gridData);

        this.textfield.setToolTipText(CoreUi.I18N.getString("NoteSearch.TextPattern.tooltip"));
        // Prevent CR from going to the default button
        this.textfield.addTraverseListener(new TraverseListener() {
            @Override
            public void keyTraversed(TraverseEvent e) {
                if (e.detail == SWT.TRAVERSE_RETURN) {
                    e.doit = false;
                    e.detail = SWT.TRAVERSE_NONE;
                }
            }
        });

        this.textfield.addModifyListener(new ModifyListener() {
            @Override
            public void modifyText(ModifyEvent e) {
                final Text text = (Text) e.getSource();
                boolean isValide = NoteSearchCriteria.isValidExpression(text.getText()) && !text.getText().trim().isEmpty();

                if (isValide) {
                    text.setForeground(text.getDisplay().getSystemColor(SWT.COLOR_LIST_FOREGROUND));
                    validationListener.validationStateChanged(true);
                } else {
                    text.setForeground(text.getDisplay().getSystemColor(SWT.COLOR_RED));
                    validationListener.validationStateChanged(false);
                }
            }
        });


        this.caseSensitiveCheckBox = new Button(this.topGroup, SWT.CHECK);
        this.caseSensitiveCheckBox.setText(CoreUi.I18N.getString("NoteSearch.TextCase.tooltip"));
        this.caseSensitiveCheckBox.setToolTipText(CoreUi.I18N.getString("NoteSearch.TextCase.tooltip"));
        gridData = new GridData(SWT.RIGHT, SWT.CENTER, false, false);
        this.caseSensitiveCheckBox.setLayoutData(gridData);

        PolluxWidgetConfigurator.configureSimpleField( nameLabel, this.textfield, this.caseSensitiveCheckBox);



        // The 'note type' criterion
        final Label stereotypeLabel = new Label(this.topGroup, SWT.NONE);
        stereotypeLabel.setText(CoreUi.I18N.getString("NoteSearch.TypePattern.label"));

        this.notetypeCombo = new Combo(this.topGroup, SWT.DROP_DOWN);
        gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
        this.notetypeCombo.setLayoutData(gridData);
        this.notetypeCombo.setToolTipText(CoreUi.I18N.getString("NoteSearch.TypePattern.tooltip"));

        // Populate the combo with available NoteType names from the session
        Collection<? extends MObject> allNoteTypes = session.getModel().findByClass(
                session.getMetamodel().getMClass(NoteType.class), IModel.NODELETED);
        List<String> noteTypeNames = allNoteTypes.stream()
                .map(nt -> ((NoteType) nt).getName())
                .filter(name -> name != null && !name.isEmpty())
                .distinct()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
        for (String name : noteTypeNames) {
            this.notetypeCombo.add(name);
        }

        PolluxWidgetConfigurator.configureSimpleField(stereotypeLabel, this.notetypeCombo, null);


        // Setup default values for criteria
        final NoteSearchCriteria defaultCriteria = new NoteSearchCriteria();
        defaultCriteria.setExpression("");
        defaultCriteria.setCaseSensitive(false);

        this.validationListener.validationStateChanged(false);
        setCriteria(defaultCriteria);
    }

    @objid ("2be34ff5-c625-4e3e-b324-e2532a865a0c")
    @Override
    public Control getControl() {
        return this.topGroup;
    }

    @objid ("428a0594-16ca-4d40-b79e-c9cb93a03db4")
    @Override
    public ISearchCriteria getCriteria() {
        this.searchCriteria.reset();
        this.searchCriteria.setExpression(this.textfield.getText());
        this.searchCriteria.setNoteType(this.notetypeCombo.getText().trim());
        this.searchCriteria.setCaseSensitive(this.caseSensitiveCheckBox.getSelection());
        return this.searchCriteria;
    }

    @objid ("15bd7a44-9ca8-4ac0-b22e-3693ce6e4006")
    @Override
    public void setCriteria(ISearchCriteria searchCriteria) {
        if(searchCriteria == null || !(searchCriteria instanceof NoteSearchCriteria)) {
            return;
        }

        final NoteSearchCriteria criteria = (NoteSearchCriteria) searchCriteria;

        this.searchCriteria = criteria;

        this.textfield.setText(criteria.getExpression());
        this.notetypeCombo.setText(criteria.getNoteType());
        this.caseSensitiveCheckBox.setSelection(this.searchCriteria.isCaseSensitive());
    }

    /**
     * Default constructor
     */
    @objid ("adfc7124-f6c7-4ac1-b570-5c5ed6ef4025")
    public NoteSearchPanel() {

    }

    @objid ("bb6787e5-b547-4a80-bde3-04880c592456")
    public int getPriority() {
        return 9;
    }

}

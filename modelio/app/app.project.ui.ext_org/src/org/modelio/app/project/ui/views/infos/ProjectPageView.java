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
package org.modelio.app.project.ui.views.infos;

import java.io.InputStream;
import java.net.URI;
import java.nio.file.Files;

import org.eclipse.e4.ui.di.Focus;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.modelio.app.project.ui.plugin.AppProjectUiExt;
import org.modelio.gproject.data.project.GProjectPartDescriptor;
import org.modelio.gproject.data.project.GProjectPartDescriptor.GProjectPartType;
import org.modelio.platform.model.ui.swt.images.FragmentImageService;
import org.modelio.platform.ui.dialog.PolluxWidgetConfigurator;
import org.modelio.vbasic.version.Version;
import org.modelio.version.ModelioVersion;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

/**
 * Project page view.
 */
@objid("61641e68-3173-4904-a08c-7c833ce12641")
public class ProjectPageView {
	@objid("f487ef26-9d82-49f0-88fb-d36d32f6c356")
	public static final String ID = "org.modelio.app.project.ui.part.projectpage";

	private static final String INFO_DESCRIPTION = "info.description";
	private static final String INFO_PROJECT_LOGO_NAME = "info.projetLogoName";
	private static final String INFO_LOGIN = "constellation.user.login";
	private static final String EMPTY = "";

	@objid("045f9d66-8247-41b4-9634-11fb25aeb97d")
	private ScrolledComposite scrolled;
	private Composite contentContainer;
	private Composite summarySection;
	private Composite summaryFields;
	private Label logoLabel;
	private Label nameValue;
	private Label versionValue;
	private Label storagePathValue;
	private Label storageLastModificationValue;
	private Label remoteLocationLabel;
	private Label remoteLocationValue;
	private Label loginLabel;
	private Label loginValue;
	private Text descriptionValue;
	private Composite workModelsSection;
	private Table workModelsTable;
	private Composite librariesSection;
	private Table librariesTable;
	private Composite modulesSection;
	private Table modulesTable;
	private Image projectLogoImage;

	@objid("e5d7f486-50cd-4cb2-bfff-c46ba25dc4c6")
	public ProjectPageView() {
		// C'tor
	}

	@objid("7290565c-fe42-4282-8fbf-52a69c798f7a")
	@PostConstruct
	public void createControls(final Composite parent) {
		this.scrolled = new ScrolledComposite(parent, SWT.V_SCROLL | SWT.H_SCROLL | SWT.BORDER);
		this.scrolled.setExpandHorizontal(true);
		this.scrolled.setExpandVertical(true);

		this.contentContainer = new Composite(this.scrolled, SWT.NONE);
		PolluxWidgetConfigurator.configureContainer(this.contentContainer);
		this.contentContainer.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		createSummarySection(this.contentContainer);
		createWorkModelsSection(this.contentContainer);
		createLibrariesSection(this.contentContainer);
		createModulesSection(this.contentContainer);

		this.scrolled.setContent(this.contentContainer);
		clearContent();
		updateMinSize();
	}

	@objid("96b90d3a-3e3d-4e7b-ac85-da96b5005a93")
	@PreDestroy
	private void dispose() {
		disposeProjectLogo();
		if (this.scrolled != null && !this.scrolled.isDisposed()) {
			this.scrolled.dispose();
			this.scrolled = null;
		}
	}

	@objid("95cdf026-4383-4136-ba9e-840b7b80db01")
	@Focus
	void setFocus() {
		if (this.scrolled != null && !this.scrolled.isDisposed()) {
			this.scrolled.setFocus();
		}
	}

	public void setProject(ProjectAdapter projectAdapter) {
		if (projectAdapter == null || projectAdapter.getProjectDescriptor() == null) {
			clearContent();
			return;
		}

		updateSummary(projectAdapter);
		updateWorkModels(projectAdapter);
		updateLibraries(projectAdapter);
		updateModules(projectAdapter);
		updateMinSize();
	}

	/**
	 * Legacy method kept for backward compatibility.
	 */
	public void setHtmlComtent(String htmlContent) {
		if (htmlContent == null || htmlContent.isEmpty()) {
			clearContent();
		}
	}

	private void createSummarySection(Composite parent) {
		this.summarySection = createSection(parent, "$ProjectInfoHtmlPage.lbl_summary", false);
		GridLayout sectionLayout = (GridLayout) this.summarySection.getLayout();
		sectionLayout.marginHeight = 0;
		sectionLayout.marginWidth = 0;

		Composite body = new Composite(this.summarySection, SWT.NONE);
		body.setBackground(this.summarySection.getBackground());
		body.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		GridLayout bodyLayout = new GridLayout(2, false);
		bodyLayout.marginHeight = 0;
		bodyLayout.marginWidth = 0;
		bodyLayout.horizontalSpacing = 12;
		body.setLayout(bodyLayout);

		this.summaryFields = new Composite(body, SWT.NONE);
		this.summaryFields.setBackground(body.getBackground());
		this.summaryFields.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		GridLayout fieldsLayout = new GridLayout(2, false);
		fieldsLayout.marginHeight = 0;
		fieldsLayout.marginWidth = 0;
		fieldsLayout.verticalSpacing = PolluxWidgetConfigurator.VERTICAL_SPACING;
		fieldsLayout.horizontalSpacing = 8;
		this.summaryFields.setLayout(fieldsLayout);

		this.logoLabel = new Label(body, SWT.NONE);
		this.logoLabel.setBackground(body.getBackground());
		this.logoLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.TOP, false, false));

		newSummaryRow("$ProjectInfoHtmlPage.lbl_project_name", valueLabel -> this.nameValue = valueLabel);
		newSummaryRow("$ProjectInfoHtmlPage.lbl_modelio_version", valueLabel -> this.versionValue = valueLabel);
		newSummaryRow("$ProjectInfoHtmlPage.lbl_storage_path", valueLabel -> this.storagePathValue = valueLabel);
		newSummaryRow("$ProjectInfoHtmlPage.lbl_storage_last_modification", valueLabel -> this.storageLastModificationValue = valueLabel);

		this.remoteLocationLabel = new Label(this.summaryFields, SWT.NONE);
		this.remoteLocationLabel.setText(AppProjectUiExt.I18N.getString("$ProjectInfoHtmlPage.lbl_remote_location"));
		this.remoteLocationValue = new Label(this.summaryFields, SWT.WRAP);
		configureFieldRow(this.remoteLocationLabel, this.remoteLocationValue);

		this.loginLabel = new Label(this.summaryFields, SWT.NONE);
		this.loginLabel.setText(AppProjectUiExt.I18N.getString("$ProjectInfoHtmlPage.lbl_login"));
		this.loginValue = new Label(this.summaryFields, SWT.WRAP);
		configureFieldRow(this.loginLabel, this.loginValue);

		Label descriptionLabel = new Label(this.summaryFields, SWT.NONE);
		descriptionLabel.setText("Description");
		PolluxWidgetConfigurator.configureStyleForFieldLabel(descriptionLabel);

		this.descriptionValue = new Text(this.summaryFields, SWT.BORDER | SWT.MULTI | SWT.WRAP | SWT.V_SCROLL | SWT.READ_ONLY);
		GridData descriptionData = new GridData(SWT.FILL, SWT.FILL, true, true);
		descriptionData.heightHint = 90;
		this.descriptionValue.setLayoutData(descriptionData);
		PolluxWidgetConfigurator.configureStyleForFieldControl(this.descriptionValue);
	}

	private void createWorkModelsSection(Composite parent) {
		this.workModelsSection = createSection(parent, "$ProjectInfoHtmlPage.title_workModels", false);
		this.workModelsTable = createTable(this.workModelsSection, 3);
		newColumn(this.workModelsTable, "$ProjectInfoHtmlPage.tbl_workmodels_head_name", 280);
		newColumn(this.workModelsTable, "$ProjectInfoHtmlPage.tbl_workmodels_head_type", 120);
		newColumn(this.workModelsTable, "$ProjectInfoHtmlPage.tbl_workmodels_head_uri", 420);
	}

	private void createLibrariesSection(Composite parent) {
		this.librariesSection = createSection(parent, "$ProjectInfoHtmlPage.title_libraries", false);
		this.librariesTable = createTable(this.librariesSection, 3);
		newColumn(this.librariesTable, "$ProjectInfoHtmlPage.tbl_libraries_head_name", 280);
		newColumn(this.librariesTable, "$ProjectInfoHtmlPage.tbl_libraries_head_version", 120);
		newColumn(this.librariesTable, "$ProjectInfoHtmlPage.tbl_libraries_head_description", 420);
	}

	private void createModulesSection(Composite parent) {
		this.modulesSection = createSection(parent, "$ProjectInfoHtmlPage.title_modules", false);
		this.modulesTable = createTable(this.modulesSection, 2);
		newColumn(this.modulesTable, "$ProjectInfoHtmlPage.tbl_modules_head_name", 320);
		newColumn(this.modulesTable, "$ProjectInfoHtmlPage.tbl_modules_head_version", 160);
	}

	private Composite createSection(Composite parent, String titleKey, boolean topAligned) {
		Composite section = new Composite(parent, SWT.NONE);
		PolluxWidgetConfigurator.configureContainer(section);
		GridData sectionData = new GridData(SWT.FILL, topAligned ? SWT.TOP : SWT.FILL, true, true);
		section.setLayoutData(sectionData);

		Label title = new Label(section, SWT.NONE);
		title.setText(AppProjectUiExt.I18N.getString(titleKey));
		PolluxWidgetConfigurator.configureSubtitleField(title);
		return section;
	}

	private Table createTable(Composite parent, int columns) {
		Table table = new Table(parent, SWT.BORDER | SWT.FULL_SELECTION);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		GridData tableData = new GridData(SWT.FILL, SWT.FILL, true, true);
		table.setLayoutData(tableData);
		PolluxWidgetConfigurator.configureStyleForFieldControl(table);
		return table;
	}

	private void newSummaryRow(String key, java.util.function.Consumer<Label> valueInitializer) {
		Label label = new Label(this.summaryFields, SWT.NONE);
		label.setText(AppProjectUiExt.I18N.getString(key));
		PolluxWidgetConfigurator.configureStyleForFieldLabel(label);

		Label value = new Label(this.summaryFields, SWT.WRAP);
		GridData valueData = new GridData(SWT.FILL, SWT.TOP, true, false);
		value.setLayoutData(valueData);
		PolluxWidgetConfigurator.configureStyleForFieldControl(value);
		valueInitializer.accept(value);
	}

	private void configureFieldRow(Label label, Label value) {
		PolluxWidgetConfigurator.configureStyleForFieldLabel(label);
		GridData valueData = new GridData(SWT.FILL, SWT.TOP, true, false);
		value.setLayoutData(valueData);
		PolluxWidgetConfigurator.configureStyleForFieldControl(value);
	}

	private void newColumn(Table table, String titleKey, int width) {
		TableColumn column = new TableColumn(table, SWT.LEFT);
		column.setText(AppProjectUiExt.I18N.getString(titleKey));
		column.setWidth(width);
	}

	private void updateSummary(ProjectAdapter projectAdapter) {
		this.nameValue.setText(nvl(projectAdapter.getName()));
		this.versionValue.setText(getModelioVersionString(projectAdapter));
		this.versionValue.setForeground(getModelioVersionColor(projectAdapter));
		this.storagePathValue.setText(nvl(projectAdapter.getStoragePathString()));
		this.storageLastModificationValue.setText(nvl(projectAdapter.getStorageLastModificationTimeString()));
		this.descriptionValue.setText(normalizeDescription(projectAdapter.getProperties().getValue(INFO_DESCRIPTION, EMPTY)));

		String remoteLocation = projectAdapter.getProjectDescriptor().getRemoteLocation();
		boolean hasRemote = remoteLocation != null && !remoteLocation.isEmpty();
		setVisibleAndExclude(this.remoteLocationLabel, hasRemote);
		setVisibleAndExclude(this.remoteLocationValue, hasRemote);
		setVisibleAndExclude(this.loginLabel, hasRemote);
		setVisibleAndExclude(this.loginValue, hasRemote);
		this.remoteLocationValue.setText(hasRemote ? remoteLocation : EMPTY);
		this.loginValue.setText(hasRemote ? nvl(projectAdapter.getProperties().getValue(INFO_LOGIN, EMPTY)) : EMPTY);

		setProjectLogo(projectAdapter);
	}

	private void updateWorkModels(ProjectAdapter projectAdapter) {
		this.workModelsTable.removeAll();
		for (GProjectPartDescriptor fragment : projectAdapter.getWorkModelsFragments()) {
			TableItem item = new TableItem(this.workModelsTable, SWT.NONE);
			item.setImage(0, FragmentImageService.getImage(fragment));
			boolean isDistant = fragment.getType() == GProjectPartType.SVNFRAGMENT;
			String type = isDistant
					? AppProjectUiExt.I18N.getString("ProjectInfoHtmlGenerator.workmodeltype.distant")
					: AppProjectUiExt.I18N.getString("ProjectInfoHtmlGenerator.workmodeltype.local");
			String uri = isDistant && fragment.getLocation() != null ? fragment.getLocation().toString().replace("%20", " ") : EMPTY;
			item.setText(new String[] { sanitizeTableText(nvl(fragment.getId())), sanitizeTableText(type), sanitizeTableText(uri) });
		}
		setVisibleAndExclude(this.workModelsSection, this.workModelsTable.getItemCount() > 0);
	}

	private void updateLibraries(ProjectAdapter projectAdapter) {
		this.librariesTable.removeAll();
		for (GProjectPartDescriptor fragment : projectAdapter.getLibrariesFragments()) {
			TableItem item = new TableItem(this.librariesTable, SWT.NONE);
			item.setImage(0, FragmentImageService.getImage(fragment));
			String version = sanitizeTableText(nvl(fragment.getProperties().getValue("FragmentVersion")));
			String description = sanitizeTableText(nvl(fragment.getProperties().getValue("FragmentDescription")));
			item.setText(new String[] { sanitizeTableText(nvl(fragment.getId())), version, description });
		}
		setVisibleAndExclude(this.librariesSection, this.librariesTable.getItemCount() > 0);
	}

	private void updateModules(ProjectAdapter projectAdapter) {
		this.modulesTable.removeAll();
		for (GProjectPartDescriptor module : projectAdapter.getParts(GProjectPartType.MODULE)) {
			TableItem item = new TableItem(this.modulesTable, SWT.NONE);
			item.setImage(0, FragmentImageService.getImage(module));
			String version = module.getVersion() != null ? module.getVersion().toString() : EMPTY;
			item.setText(new String[] { sanitizeTableText(nvl(module.getId())), sanitizeTableText(version) });
		}
		setVisibleAndExclude(this.modulesSection, this.modulesTable.getItemCount() > 0);
	}

	private void clearContent() {
		disposeProjectLogo();
		if (this.logoLabel != null && !this.logoLabel.isDisposed()) {
			this.logoLabel.setImage(null);
			setVisibleAndExclude(this.logoLabel, false);
		}

		if (this.nameValue != null) {
			this.nameValue.setText(EMPTY);
			this.versionValue.setText(EMPTY);
			this.storagePathValue.setText(EMPTY);
			this.storageLastModificationValue.setText(EMPTY);
			this.descriptionValue.setText(EMPTY);
			this.remoteLocationValue.setText(EMPTY);
			this.loginValue.setText(EMPTY);
			setVisibleAndExclude(this.remoteLocationLabel, false);
			setVisibleAndExclude(this.remoteLocationValue, false);
			setVisibleAndExclude(this.loginLabel, false);
			setVisibleAndExclude(this.loginValue, false);
		}

		if (this.workModelsTable != null) {
			this.workModelsTable.removeAll();
			setVisibleAndExclude(this.workModelsSection, false);
		}
		if (this.librariesTable != null) {
			this.librariesTable.removeAll();
			setVisibleAndExclude(this.librariesSection, false);
		}
		if (this.modulesTable != null) {
			this.modulesTable.removeAll();
			setVisibleAndExclude(this.modulesSection, false);
		}

		updateMinSize();
	}

	private void setProjectLogo(ProjectAdapter projectAdapter) {
		disposeProjectLogo();
		setVisibleAndExclude(this.logoLabel, false);
		this.logoLabel.setImage(null);

		String iconName = projectAdapter.getProperties().getValue(INFO_PROJECT_LOGO_NAME);
		if (iconName == null || iconName.isEmpty()) {
			return;
		}

		Image loadedImage = null;
		try {
			if (iconName.startsWith("http")) {
				try (InputStream stream = new URI(iconName).toURL().openStream()) {
					loadedImage = new Image(this.contentContainer.getDisplay(), new ImageData(stream));
				}
			} else {
				java.nio.file.Path iconPath = projectAdapter.getProjectFileStructure().getProjectDataPath().resolve(iconName);
				if (Files.exists(iconPath)) {
					loadedImage = new Image(this.contentContainer.getDisplay(), iconPath.toString());
				}
			}
		} catch (Exception e) {
			loadedImage = null;
		}

		if (loadedImage != null) {
			this.projectLogoImage = loadedImage;
			this.logoLabel.setImage(loadedImage);
			setVisibleAndExclude(this.logoLabel, true);
		}
	}

	private void disposeProjectLogo() {
		if (this.projectLogoImage != null && !this.projectLogoImage.isDisposed()) {
			this.projectLogoImage.dispose();
		}
		this.projectLogoImage = null;
	}

	private void updateMinSize() {
		if (this.scrolled != null && !this.scrolled.isDisposed() && this.contentContainer != null && !this.contentContainer.isDisposed()) {
			this.contentContainer.layout(true, true);
			this.scrolled.setMinSize(this.contentContainer.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		}
	}

	private String normalizeDescription(String description) {
		if (description == null || description.isEmpty()) {
			return EMPTY;
		}
		return sanitizeTableText(description).replaceAll("[ ]{2,}", System.lineSeparator()).replaceAll("\\xA0{2,}", System.lineSeparator() + "-");
	}

	private String sanitizeTableText(String value) {
		if (value == null || value.isEmpty()) {
			return EMPTY;
		}
		return value.replaceAll("<[^>]+>", EMPTY).trim();
	}

	private String getModelioVersionString(ProjectAdapter projectAdapter) {
		Version modelioVersion = projectAdapter.getProjectDescriptor().getModelioVersion();
		if (modelioVersion == null) {
			return "<3.4.01";
		}
		return modelioVersion.toString();
	}

	private Color getModelioVersionColor(ProjectAdapter projectAdapter) {
		Version projVersion = projectAdapter.getProjectDescriptor().getModelioVersion();
		if (projVersion == null) {
			return this.contentContainer.getDisplay().getSystemColor(SWT.COLOR_DARK_YELLOW);
		}

		int compare = projVersion.withoutBuild().compareTo(ModelioVersion.MAJOR_MINOR);
		if (compare < 0) {
			return this.contentContainer.getDisplay().getSystemColor(SWT.COLOR_DARK_YELLOW);
		} else if (compare > 0) {
			return this.contentContainer.getDisplay().getSystemColor(SWT.COLOR_DARK_BLUE);
		}
		return this.contentContainer.getDisplay().getSystemColor(SWT.COLOR_DARK_GREEN);
	}

	private String nvl(String value) {
		return value == null ? EMPTY : value;
	}

	private void setVisibleAndExclude(Control control, boolean visible) {
		if (control == null || control.isDisposed()) {
			return;
		}
		control.setVisible(visible);
		if (control.getLayoutData() instanceof GridData) {
			((GridData) control.getLayoutData()).exclude = !visible;
		}
	}
}

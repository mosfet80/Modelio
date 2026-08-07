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
package org.modelio.archimate.diagrams.editor.archimateview;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import jakarta.inject.Inject;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.di.AboutToHide;
import org.eclipse.e4.ui.di.AboutToShow;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.commands.MCommand;
import org.eclipse.e4.ui.model.application.commands.MCommandsFactory;
import org.eclipse.e4.ui.model.application.commands.MParameter;
import org.eclipse.e4.ui.model.application.ui.menu.MHandledMenuItem;
import org.eclipse.e4.ui.model.application.ui.menu.MMenu;
import org.eclipse.e4.ui.model.application.ui.menu.MMenuElement;
import org.eclipse.e4.ui.model.application.ui.menu.MMenuFactory;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.gef.EditPart;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.modelio.archimate.diagrams.editor.wizard.ModelTransformHandler;
import org.modelio.archimate.diagrams.editor.wizard.TransformerRegistry;
import org.modelio.archimate.diagrams.editor.wizard.TransformerRegistry.ArchimateLayer;
import org.modelio.archimate.diagrams.editor.wizard.TransformerRegistry.ModelTransformerCommand;
import org.modelio.archimate.diagrams.plugin.ArchiDiagrams;
import org.modelio.diagram.editor.context.AbstractCreationPopupProvider;
import org.modelio.diagram.editor.plugin.DiagramEditor;
import org.modelio.diagram.elements.core.model.GmModel;
import org.modelio.metamodel.diagrams.AbstractDiagram;
import org.modelio.platform.model.ui.swt.SelectionHelper;
import org.modelio.platform.model.ui.swt.images.MetamodelImageService;
import org.modelio.platform.utils.i18n.BundledMessages;
import org.osgi.framework.Bundle;

/**
 * <p>Implementation of {@link AbstractCreationPopupProvider} for Archimate diagram.</p>
 */
@objid ("95104518-2ad4-4ee9-94f6-5e887a835ba2")
public class ArchimateTransmutationPopupProvider {
    @objid ("4d524890-eb91-4b6b-b407-2b13427f665b")
    @Inject
    protected MApplication application;

    @objid ("dbb8e41a-a723-4ea3-9798-d9d82a572ed8")
    @Inject
    protected IEclipseContext context;

    /**
     * A local MCommand cache, to minimize navigation in the e4 model.
     */
    @objid ("6cd0ec1a-961d-4361-8cd0-f1c484fe02c7")
    private final Map<String, MCommand> commandCache = new HashMap<>();

    @objid ("863d7d2b-4875-4da5-839b-2b58ce403801")
    protected String getMenuIconPath() {
        return "platform:/plugin/" + DiagramEditor.PLUGIN_ID + "/icons/uml.png";
    }

    @objid ("b22c9870-64f5-4c07-9c74-b46d5f50f98f")
    protected String getMenuLabel() {
        return ArchiDiagrams.I18N.getString("TransmuteElementMenu.label");
    }

    /**
     * Fills a dynamic creation menu with selection-compatible contributions before display. <br/>
     * Called by the rcp platform through injection.
     *
     * @param items the item list to fill.
     */
    @objid ("a1fa2d97-ee54-40c3-b659-e02ddbc9b23c")
    @AboutToShow
    public void aboutToShow(final List<MMenuElement> items) {
        // add menu items
        items.add(createMenu());
    }

    @objid ("79c4e68c-309e-45d7-8cac-a9c844051942")
    @AboutToHide
    public void aboutToHide(@SuppressWarnings("unused") final List<MMenuElement> items) {
        // Here, we could dispose things and so on...
    }

    @objid ("fc7d36bb-21ed-492b-896a-6ed13df3b9d8")
    protected AbstractDiagram getEditedDiagram(final ISelection selection) {
        final EditPart ep = SelectionHelper.getFirst(selection, EditPart.class);
        if (ep != null) {
            final Object model = ep.getModel();
            if (model instanceof GmModel) {
                return ((GmModel) model).getDiagram().getRelatedElement();
            }
        }
        return null;
    }

    /**
     *
     * @return the currently selected elements.
     */
    @objid ("bd24d79b-8380-4dcc-a2fb-fd5645bcc6cc")
    protected ISelection getApplicationSelection() {
        // Get the active selection from the application, to avoid context-related issues when opening the same diagram several times...
        ISelection selection = (ISelection) this.application.getContext().get(IServiceConstants.ACTIVE_SELECTION);
        return selection != null ? selection : new StructuredSelection();
    }

    /**
     * Compute a contributor id from a bundle.
     *
     * @return a contributor id.
     */
    @objid ("81818c14-6ae2-4ea7-bb9e-31c7aa82206e")
    private String getContributorId(final Bundle bundle) {
        return "platform:/plugin/" + bundle.getSymbolicName();
    }

    /**
     * Create a new handled menu item from a popup entry descriptor.
     *
     * @param entry the descriptor to convert.
     * @return a new menu elements.
     */
    @objid ("b3521d5c-e7f0-479c-950c-2297653163d7")
    private MHandledMenuItem createMenuItem(ModelTransformerCommand entry, final String contributorId) {
        // Get current selection and extract source metaclass
        final ISelection applicationSelection = getApplicationSelection();
        String sourceMetaclass = null;
        if (applicationSelection instanceof StructuredSelection) {
            StructuredSelection structuredSelection = (StructuredSelection) applicationSelection;
            Object firstElement = structuredSelection.getFirstElement();
            if (firstElement instanceof EditPart) {
                EditPart editPart = (EditPart) firstElement;
                Object model = editPart.getModel();
                if (model instanceof GmModel) {
                    String modelString = model.toString();
                    int startIndex = modelString.indexOf("Archimate.");
                    if (startIndex != -1) {
                        int endIndex = modelString.indexOf(",", startIndex);
                        if (endIndex != -1) {
                            sourceMetaclass = modelString.substring(startIndex, endIndex);
                        }
                    }
                }
            }
        }

        // Compare with target metaclass
        String elementName = entry.i18nKey.replace("ArchimateTransmuter.", "");
        String targetMetaclass = "Archimate." + elementName;

        // Don't create menu item if source and target are the same
        if (sourceMetaclass != null && sourceMetaclass.equals(targetMetaclass)) {
            return null;
        }
        // create a new handled item
        final MHandledMenuItem item = MMenuFactory.INSTANCE.createHandledMenuItem();
        final MCommand command = getCommand(entry);
        item.setCommand(command);
        item.setElementId(entry.i18nKey);

        // compute label, tooltip and icon
        final BundledMessages i18nBundle = ArchiDiagrams.I18N;
        item.setLabel(i18nBundle.getString(entry.i18nKey + ".label"));


        ModelTransformHandler handler = new ModelTransformHandler();
        boolean canExecute = handler.canExecute(String.valueOf(entry.index), null, applicationSelection, this.context);

        if (canExecute) {
            item.setTooltip(elementName);
        } else {
            item.setTooltip(i18nBundle.getString("TransformWizard.disabled.tooltip"));
        }


        try {
            item.setIconURI(MetamodelImageService.getIconCompletePath("Archimate." + elementName));
        } catch (Exception e) {
            ArchiDiagrams.LOG.error(e);
        }

        // make the item visible
        item.setEnabled(true);
        item.setToBeRendered(true);
        item.setVisible(true);

        // bind the item to the contributing plugin
        item.setContributorURI(contributorId);

        final MParameter p = MCommandsFactory.INSTANCE.createParameter();
        p.setContributorURI(contributorId);
        p.setName("transformerindex");
        p.setValue(Integer.toString(entry.index));
        item.getParameters().add(p);
        return item;
    }

    /**
     * Get the MCommand defined in the application having a specific id.
     *
     * @param commandId the element id of the MCommand to find.
     * @return a MCommand, or <code>null</code> if the id is not found.
     */
    @objid ("db7605ab-934d-4ccf-a7fb-d09f9cac04e9")
    private MCommand getCommand(ModelTransformerCommand entry) {
        final String commandId = entry.e4CmdId;
        // Try the cache first...
        MCommand command = this.commandCache.get(commandId);
        if (command == null) {
            // Not in the cache, look into the application commands
            for (final MCommand c : this.application.getCommands()) {
                if (commandId.equals(c.getElementId())) {
                    // Match, keep it in the cache...
                    command = c;
                    this.commandCache.put(commandId, command);
                    break;
                }
            }
        }
        return command;
    }

    @objid ("4b961993-d7e7-4e19-8d74-0664aafa3386")
    private void createSubMenu(List<ModelTransformerCommand> commands, MMenu elementTransmutationMenu, ArchimateLayer layer) {
        final String contributorId = getContributorId(ArchiDiagrams.getContext().getBundle());

        // create a new menu
        final MMenu transmutationSubMenu = MMenuFactory.INSTANCE.createMenu();
        transmutationSubMenu.setLabel(ArchiDiagrams.I18N.getString("TransformWizard.submenu." + layer.toString().toLowerCase() + ".label"));
        transmutationSubMenu.setTooltip(ArchiDiagrams.I18N.getString("TransformWizard.submenu." + layer.toString().toLowerCase() + ".tooltip"));

        String layerName = ArchiDiagrams.I18N.getString("TransformWizard.submenu." + layer.toString().toLowerCase() + ".label");
        if (layerName.contains(" ")) {
            layerName = layerName.split(" ")[0];
        }
        try {
            transmutationSubMenu.setIconURI(MetamodelImageService.getIconCompletePath("Archimate." + layerName + "Folder"));
        } catch (Exception e) {
            ArchiDiagrams.LOG.error(e);
        }
        // make the menu visible
        transmutationSubMenu.setEnabled(true);
        transmutationSubMenu.setToBeRendered(true);
        transmutationSubMenu.setVisible(true);

        // bound the menu to the contributing plugin
        transmutationSubMenu.setContributorURI(contributorId);

        elementTransmutationMenu.getChildren().add(transmutationSubMenu);
        final List<MMenuElement> menuChildren = transmutationSubMenu.getChildren();

        // add transform commands
        for (final ModelTransformerCommand command : commands) {
             MHandledMenuItem menuItem = createMenuItem(command, contributorId);
                if (menuItem != null) {
                    menuChildren.add(menuItem);
                }
        }
    }

    @objid ("b38daa03-cb53-432a-b235-8d5ff4523f1f")
    private MMenu createMenu() {
        final String contributorId = getContributorId(ArchiDiagrams.getContext().getBundle());

        // create a new menu
        final MMenu elementTransmutationMenu = MMenuFactory.INSTANCE.createMenu();
        elementTransmutationMenu.setLabel(ArchiDiagrams.I18N.getString("TransformWizard.label"));
        elementTransmutationMenu.setTooltip(ArchiDiagrams.I18N.getString("TransformWizard.tooltip"));

        // make the menu visible
        elementTransmutationMenu.setEnabled(true);
        elementTransmutationMenu.setToBeRendered(true);
        elementTransmutationMenu.setVisible(true);

        // bound the menu to the contributing plugin
        elementTransmutationMenu.setContributorURI(contributorId);

        final ISelection applicationSelection = getApplicationSelection();

        List<ArchimateLayer> sortedLayers = Arrays.stream(ArchimateLayer.values())
                .sorted((layer1, layer2) -> {
                    if (layer1 == ArchimateLayer.OTHER) return 1;
                    if (layer2 == ArchimateLayer.OTHER) return -1;
                    String name1 = ArchiDiagrams.I18N.getString("TransformWizard.submenu." + layer1.toString().toLowerCase() + ".label");
                    String name2 = ArchiDiagrams.I18N.getString("TransformWizard.submenu." + layer2.toString().toLowerCase() + ".label");
                    return name1.compareToIgnoreCase(name2);
                })
                .collect(Collectors.toList());


        for (ArchimateLayer layer : sortedLayers) {
            List<ModelTransformerCommand> entries = TransformerRegistry.getInstance(this.context).getTransformers(getEditedDiagram(applicationSelection), applicationSelection, layer);
            if (!entries.isEmpty()) {
                // add menu items
                createSubMenu(entries, elementTransmutationMenu, layer);
            }
        }

        return elementTransmutationMenu;
    }

}

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
package org.modelio.archimate.metamodel.mmextensions.archimate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.ArchimateMetamodel;
import org.modelio.archimate.metamodel.core.structure.Folder;
import org.modelio.archimate.metamodel.core.structure.Model;
import org.modelio.archimate.metamodel.core.structure.folder.ApplicationFolder;
import org.modelio.archimate.metamodel.core.structure.folder.BusinessFolder;
import org.modelio.archimate.metamodel.core.structure.folder.ImplementationFolder;
import org.modelio.archimate.metamodel.core.structure.folder.MotivationFolder;
import org.modelio.archimate.metamodel.core.structure.folder.PhysicalFolder;
import org.modelio.archimate.metamodel.core.structure.folder.StrategyFolder;
import org.modelio.archimate.metamodel.core.structure.folder.TechnologyFolder;
import org.modelio.archimate.metamodel.layers.application.behavior.ApplicationEvent;
import org.modelio.archimate.metamodel.layers.application.behavior.ApplicationFunction;
import org.modelio.archimate.metamodel.layers.application.behavior.ApplicationInteraction;
import org.modelio.archimate.metamodel.layers.application.behavior.ApplicationProcess;
import org.modelio.archimate.metamodel.layers.application.behavior.ApplicationService;
import org.modelio.archimate.metamodel.layers.application.structure.active.ApplicationCollaboration;
import org.modelio.archimate.metamodel.layers.application.structure.active.ApplicationComponent;
import org.modelio.archimate.metamodel.layers.application.structure.active.ApplicationInterface;
import org.modelio.archimate.metamodel.layers.application.structure.passive.DataObject;
import org.modelio.archimate.metamodel.layers.business.behavior.BusinessEvent;
import org.modelio.archimate.metamodel.layers.business.behavior.BusinessFunction;
import org.modelio.archimate.metamodel.layers.business.behavior.BusinessInteraction;
import org.modelio.archimate.metamodel.layers.business.behavior.BusinessProcess;
import org.modelio.archimate.metamodel.layers.business.behavior.BusinessService;
import org.modelio.archimate.metamodel.layers.business.composite.Product;
import org.modelio.archimate.metamodel.layers.business.structure.active.BusinessActor;
import org.modelio.archimate.metamodel.layers.business.structure.active.BusinessCollaboration;
import org.modelio.archimate.metamodel.layers.business.structure.active.BusinessInterface;
import org.modelio.archimate.metamodel.layers.business.structure.active.BusinessRole;
import org.modelio.archimate.metamodel.layers.business.structure.passive.BusinessObject;
import org.modelio.archimate.metamodel.layers.business.structure.passive.Contract;
import org.modelio.archimate.metamodel.layers.business.structure.passive.Representation;
import org.modelio.archimate.metamodel.layers.implementation_and_migration.Deliverable;
import org.modelio.archimate.metamodel.layers.implementation_and_migration.Gap;
import org.modelio.archimate.metamodel.layers.implementation_and_migration.ImplementationEvent;
import org.modelio.archimate.metamodel.layers.implementation_and_migration.Plateau;
import org.modelio.archimate.metamodel.layers.implementation_and_migration.WorkPackage;
import org.modelio.archimate.metamodel.layers.motivation.Assessment;
import org.modelio.archimate.metamodel.layers.motivation.Constraint;
import org.modelio.archimate.metamodel.layers.motivation.Driver;
import org.modelio.archimate.metamodel.layers.motivation.Goal;
import org.modelio.archimate.metamodel.layers.motivation.Meaning;
import org.modelio.archimate.metamodel.layers.motivation.Outcome;
import org.modelio.archimate.metamodel.layers.motivation.Principle;
import org.modelio.archimate.metamodel.layers.motivation.Requirement;
import org.modelio.archimate.metamodel.layers.motivation.Stakeholder;
import org.modelio.archimate.metamodel.layers.motivation.Value;
import org.modelio.archimate.metamodel.layers.physical.structure.active.DistributionNetwork;
import org.modelio.archimate.metamodel.layers.physical.structure.active.Equipment;
import org.modelio.archimate.metamodel.layers.physical.structure.active.Facility;
import org.modelio.archimate.metamodel.layers.physical.structure.passive.Material;
import org.modelio.archimate.metamodel.layers.strategy.behavior.Capability;
import org.modelio.archimate.metamodel.layers.strategy.behavior.CourseOfAction;
import org.modelio.archimate.metamodel.layers.strategy.behavior.ValueStream;
import org.modelio.archimate.metamodel.layers.strategy.structure.Resource;
import org.modelio.archimate.metamodel.layers.technology.behavior.TechnologyEvent;
import org.modelio.archimate.metamodel.layers.technology.behavior.TechnologyFunction;
import org.modelio.archimate.metamodel.layers.technology.behavior.TechnologyInteraction;
import org.modelio.archimate.metamodel.layers.technology.behavior.TechnologyProcess;
import org.modelio.archimate.metamodel.layers.technology.behavior.TechnologyService;
import org.modelio.archimate.metamodel.layers.technology.structure.active.CommunicationNetwork;
import org.modelio.archimate.metamodel.layers.technology.structure.active.Device;
import org.modelio.archimate.metamodel.layers.technology.structure.active.Node;
import org.modelio.archimate.metamodel.layers.technology.structure.active.Path;
import org.modelio.archimate.metamodel.layers.technology.structure.active.SystemSoftware;
import org.modelio.archimate.metamodel.layers.technology.structure.active.TechnologyCollaboration;
import org.modelio.archimate.metamodel.layers.technology.structure.active.TechnologyInterface;
import org.modelio.archimate.metamodel.layers.technology.structure.passive.Artifact;
import org.modelio.vcore.smkernel.mapi.MClass;

/**
 * Service Class allowing to associate Archimate Folder elements to Archimate Concept elements
 */
@objid ("f4105ebd-e36b-4e3d-9047-64d8cce7cc70")
public class ArchimateLayerExpert {
    @objid ("90366c96-6079-4b08-a8b2-91b2af62796a")
    private static List<String> layers = Arrays.asList(ApplicationFolder.MQNAME, BusinessFolder.MQNAME, ImplementationFolder.MQNAME, MotivationFolder.MQNAME, PhysicalFolder.MQNAME, StrategyFolder.MQNAME, TechnologyFolder.MQNAME);

    @objid ("090ac6db-bcc9-4056-962a-99660ceec0f2")
    private static Map<String, String> elementLayerMap;

    @objid ("ac11f4ea-12db-408c-8bde-05b246ee5aa4")
    private static Map<String, List<String>> elementByLayerMap;

    /**
     *
     * @return the list of Archimate layers (aka {@link Folder metaclasses}
     */
    @objid ("cfd23b3f-6a1e-4684-8616-1c8ca1c2d3de")
    public static List<String> getLayers() {
        return layers;
    }

    /**
     * Return the Archimate Concepts associated to a specified layer (aka {@link Folder} qualified name)
     *
     * @param layer Qualified name of an archimate layer, e.g. <code>BusinessFolder.MQNAME</code>.
     * @return List of Archimate Concepts belonging to this folder
     */
    @objid ("02732d75-d24b-4b89-a4b8-29bf3eb2914f")
    public static List<String> getMetaclassByLayer(String layer) {
        if (elementByLayerMap == null) {
            initMaps();
        }
        return elementByLayerMap.get(layer);
    }

    /**
     * Return the layer (aka {@link Folder} qualified name) of a specified Archimate Concept.
     *
     * @param metaclassName Qualified name of an Archimate Concept.
     * @return qualified name of an archimate folder associated with the specified Archimate Concept. <code>null</code> for relationships and concepts not belonging to a specific layer (like Groupings and Junctions).
     */
    @objid ("1e7c0d33-315d-4903-ba2f-9812e14da5a7")
    public static String getMetaclassLayer(String metaclassName) {
        if (elementLayerMap == null) {
            initMaps();
        }
        return elementLayerMap.get(metaclassName);
    }

    @objid ("ca38d068-cfc9-49b7-afde-fde979096a9e")
    private static void initMaps() {
        elementByLayerMap = new HashMap<>();
        elementLayerMap = new HashMap<>();

        List<String> motivationLayer = new ArrayList<>();
        motivationLayer.add(Stakeholder.MQNAME);
        motivationLayer.add(Meaning.MQNAME);
        motivationLayer.add(Value.MQNAME);
        motivationLayer.add(Driver.MQNAME);
        motivationLayer.add(Assessment.MQNAME);
        motivationLayer.add(Goal.MQNAME);
        motivationLayer.add(Outcome.MQNAME);
        motivationLayer.add(Principle.MQNAME);
        motivationLayer.add(Requirement.MQNAME);
        motivationLayer.add(Constraint.MQNAME);

        elementByLayerMap.put(MotivationFolder.MQNAME, motivationLayer);
        for (String value : motivationLayer) {
            elementLayerMap.put(value, MotivationFolder.MQNAME);
        }

        List<String> implementationLayer = new ArrayList<>();
        implementationLayer.add(WorkPackage.MQNAME);
        implementationLayer.add(Deliverable.MQNAME);
        implementationLayer.add(ImplementationEvent.MQNAME);
        implementationLayer.add(Plateau.MQNAME);
        implementationLayer.add(Gap.MQNAME);

        elementByLayerMap.put(ImplementationFolder.MQNAME, implementationLayer);
        for (String value : implementationLayer) {
            elementLayerMap.put(value, ImplementationFolder.MQNAME);
        }

        List<String> businessLayer = new ArrayList<>();
        businessLayer.add(BusinessProcess.MQNAME);
        businessLayer.add(BusinessFunction.MQNAME);
        businessLayer.add(BusinessInteraction.MQNAME);
        businessLayer.add(BusinessEvent.MQNAME);
        businessLayer.add(BusinessService.MQNAME);
        businessLayer.add(BusinessActor.MQNAME);
        businessLayer.add(BusinessRole.MQNAME);
        businessLayer.add(BusinessCollaboration.MQNAME);
        businessLayer.add(BusinessInterface.MQNAME);
        businessLayer.add(BusinessObject.MQNAME);
        businessLayer.add(Contract.MQNAME);
        businessLayer.add(Representation.MQNAME);
        businessLayer.add(Product.MQNAME);

        elementByLayerMap.put(BusinessFolder.MQNAME, businessLayer);
        for (String value : businessLayer) {
            elementLayerMap.put(value, BusinessFolder.MQNAME);
        }

        List<String> applicationLayer = new ArrayList<>();
        applicationLayer.add(ApplicationFunction.MQNAME);
        applicationLayer.add(ApplicationInteraction.MQNAME);
        applicationLayer.add(ApplicationProcess.MQNAME);
        applicationLayer.add(ApplicationEvent.MQNAME);
        applicationLayer.add(ApplicationService.MQNAME);
        applicationLayer.add(ApplicationComponent.MQNAME);
        applicationLayer.add(ApplicationCollaboration.MQNAME);
        applicationLayer.add(ApplicationInterface.MQNAME);
        applicationLayer.add(DataObject.MQNAME);

        elementByLayerMap.put(ApplicationFolder.MQNAME, applicationLayer);
        for (String value : applicationLayer) {
            elementLayerMap.put(value, ApplicationFolder.MQNAME);
        }

        List<String> technologyLayer = new ArrayList<>();
        technologyLayer.add(TechnologyFunction.MQNAME);
        technologyLayer.add(TechnologyProcess.MQNAME);
        technologyLayer.add(TechnologyInteraction.MQNAME);
        technologyLayer.add(TechnologyEvent.MQNAME);
        technologyLayer.add(TechnologyService.MQNAME);
        technologyLayer.add(CommunicationNetwork.MQNAME);
        technologyLayer.add(Device.MQNAME);
        technologyLayer.add(Node.MQNAME);
        technologyLayer.add(Path.MQNAME);
        technologyLayer.add(SystemSoftware.MQNAME);
        technologyLayer.add(TechnologyCollaboration.MQNAME);
        technologyLayer.add(TechnologyInterface.MQNAME);
        technologyLayer.add(Artifact.MQNAME);

        elementByLayerMap.put(TechnologyFolder.MQNAME, technologyLayer);
        for (String value : technologyLayer) {
            elementLayerMap.put(value, TechnologyFolder.MQNAME);
        }

        List<String> physicalLayer = new ArrayList<>();
        physicalLayer.add(DistributionNetwork.MQNAME);
        physicalLayer.add(Equipment.MQNAME);
        physicalLayer.add(Facility.MQNAME);
        physicalLayer.add(Material.MQNAME);

        elementByLayerMap.put(PhysicalFolder.MQNAME, physicalLayer);
        for (String value : physicalLayer) {
            elementLayerMap.put(value, PhysicalFolder.MQNAME);
        }

        List<String> strategyLayer = new ArrayList<>();
        strategyLayer.add(Resource.MQNAME);
        strategyLayer.add(Capability.MQNAME);
        strategyLayer.add(CourseOfAction.MQNAME);
        strategyLayer.add(ValueStream.MQNAME);

        elementByLayerMap.put(StrategyFolder.MQNAME, strategyLayer);
        for (String value : strategyLayer) {
            elementLayerMap.put(value, StrategyFolder.MQNAME);
        }

    }

    /**
     * Get the folder corresponding to the metaclass layer.
     *
     * @param model the archimate model to look for the folder into.
     * @param metaclass a metaclass.
     * @return for any Archimate metaclass, returns the first model's children having the right layer, or the model itself. <code>null</code> otherwise.
     */
    @objid ("5d0cac04-c965-4b07-b197-4babaab48f14")
    public static Folder getLayerContainer(Model model, MClass metaclass) {
        if (!metaclass.getOrigin().getName().equals(ArchimateMetamodel.NAME)) {
            return null;
        }
        return getLayerContainer(model, getLayerType(metaclass));
    }

    /**
     * Get the folder corresponding to the given layer.
     *
     * @param model the archimate model to look for the folder into.
     * @param layer an archimate layer.
     * @return the first model's children having the right layer, or the model itself.
     */
    @objid ("efb83cb8-b163-420e-9ae6-7aef21b391c3")
    public static Folder getLayerContainer(Model model, Class<? extends Folder> layer) {
        if (layer != null) {
            for (Folder folder : model.getFolder(layer)) {
                return folder;
            }
        }
        return model;
    }

    @objid ("a4c7cf97-0a46-4478-b62a-8980a479e891")
    private static Class<? extends Folder> getLayerType(MClass metaclass) {
        String namespacing = metaclass.getJavaInterface().getPackage().getName();
        if (namespacing.contains("business")) {
            return BusinessFolder.class;
        } else if (namespacing.contains("strategy")) {
            return StrategyFolder.class;
        } else if (namespacing.contains("motivation")) {
            return MotivationFolder.class;
        } else if (namespacing.contains("application")) {
            return ApplicationFolder.class;
        } else if (namespacing.contains("technology")) {
            return TechnologyFolder.class;
        } else if (namespacing.contains("physical")) {
            return PhysicalFolder.class;
        } else if (namespacing.contains("implementation")) {
            return ImplementationFolder.class;
        } else {
            return null;
        }

    }

}

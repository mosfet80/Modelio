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
package org.modelio.archimate.diagrams.editor.wizard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.jface.viewers.ISelection;
import org.modelio.archimate.metamodel.core.generic.composite.Grouping;
import org.modelio.archimate.metamodel.core.generic.composite.Location;
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
import org.modelio.metamodel.diagrams.AbstractDiagram;

@objid ("e883acb6-9737-49dc-b06e-210be5ae4c8a")
public class TransformerRegistry {
    @objid ("b6b40f39-957e-4f85-8db1-8a3559e52a18")
    private Map<ArchimateLayer, List<ModelTransformerCommand>> transformers = new HashMap<>();

    @objid ("fee5d881-c6f9-44c2-8219-ecd0da7a216a")
    private static TransformerRegistry INSTANCE;

    @objid ("8526a66c-e95f-43c5-a6b2-e99294b46693")
    private TransformerRegistry(IEclipseContext context) {
        int index = 0;


        List<ModelTransformerCommand> businessTransformers = new ArrayList<>();
        businessTransformers.add(new ModelTransformerCommand(index++, "ArchimateTransmuter.BusinessActor", "org.modelio.archimate.ModelTransformCommand", new ArchimateElementTransmuter(BusinessActor.MQNAME)));
        businessTransformers.add(new ModelTransformerCommand(index++, "ArchimateTransmuter.BusinessRole", "org.modelio.archimate.ModelTransformCommand", new ArchimateElementTransmuter(BusinessRole.MQNAME)));
        businessTransformers.add(new ModelTransformerCommand(index++, "ArchimateTransmuter.BusinessCollaboration", "org.modelio.archimate.ModelTransformCommand", new ArchimateElementTransmuter(BusinessCollaboration.MQNAME)));
        businessTransformers.add(new ModelTransformerCommand(index++, "ArchimateTransmuter.BusinessInterface", "org.modelio.archimate.ModelTransformCommand", new ArchimateElementTransmuter(BusinessInterface.MQNAME)));
        businessTransformers.add(new ModelTransformerCommand(index++, "ArchimateTransmuter.BusinessProcess", "org.modelio.archimate.ModelTransformCommand", new ArchimateElementTransmuter(BusinessProcess.MQNAME)));
        businessTransformers.add(new ModelTransformerCommand(index++, "ArchimateTransmuter.BusinessFunction", "org.modelio.archimate.ModelTransformCommand", new ArchimateElementTransmuter(BusinessFunction.MQNAME)));
        businessTransformers.add(new ModelTransformerCommand(index++, "ArchimateTransmuter.BusinessInteraction", "org.modelio.archimate.ModelTransformCommand", new ArchimateElementTransmuter(BusinessInteraction.MQNAME)));
        businessTransformers.add(new ModelTransformerCommand(index++, "ArchimateTransmuter.BusinessService", "org.modelio.archimate.ModelTransformCommand", new ArchimateElementTransmuter(BusinessService.MQNAME)));
        businessTransformers.add(new ModelTransformerCommand(index++, "ArchimateTransmuter.BusinessEvent", "org.modelio.archimate.ModelTransformCommand", new ArchimateElementTransmuter(BusinessEvent.MQNAME)));
        businessTransformers.add(new ModelTransformerCommand(index++, "ArchimateTransmuter.BusinessObject", "org.modelio.archimate.ModelTransformCommand", new ArchimateElementTransmuter(BusinessObject.MQNAME)));
        businessTransformers.add(new ModelTransformerCommand(index++, "ArchimateTransmuter.Contract", "org.modelio.archimate.ModelTransformCommand", new ArchimateElementTransmuter(Contract.MQNAME)));
        businessTransformers.add(new ModelTransformerCommand(index++, "ArchimateTransmuter.Representation", "org.modelio.archimate.ModelTransformCommand", new ArchimateElementTransmuter(Representation.MQNAME)));
        businessTransformers.add(new ModelTransformerCommand(index++, "ArchimateTransmuter.Product", "org.modelio.archimate.ModelTransformCommand", new ArchimateElementTransmuter(Product.MQNAME)));
        this.transformers.put(ArchimateLayer.BUSINESS, businessTransformers);

        List<ModelTransformerCommand> applicationTransformers = new ArrayList<>();
        applicationTransformers.add(new ModelTransformerCommand(index++, "ArchimateTransmuter.ApplicationComponent", "org.modelio.archimate.ModelTransformCommand", new ArchimateElementTransmuter(ApplicationComponent.MQNAME)));
        applicationTransformers.add(new ModelTransformerCommand(index++, "ArchimateTransmuter.ApplicationCollaboration", "org.modelio.archimate.ModelTransformCommand", new ArchimateElementTransmuter(ApplicationCollaboration.MQNAME)));
        applicationTransformers.add(new ModelTransformerCommand(index++, "ArchimateTransmuter.ApplicationInterface", "org.modelio.archimate.ModelTransformCommand", new ArchimateElementTransmuter(ApplicationInterface.MQNAME)));
        applicationTransformers.add(new ModelTransformerCommand(index++, "ArchimateTransmuter.ApplicationProcess", "org.modelio.archimate.ModelTransformCommand", new ArchimateElementTransmuter(ApplicationProcess.MQNAME)));
        applicationTransformers.add(new ModelTransformerCommand(index++, "ArchimateTransmuter.ApplicationFunction", "org.modelio.archimate.ModelTransformCommand", new ArchimateElementTransmuter(ApplicationFunction.MQNAME)));
        applicationTransformers.add(new ModelTransformerCommand(index++, "ArchimateTransmuter.ApplicationInteraction", "org.modelio.archimate.ModelTransformCommand", new ArchimateElementTransmuter(ApplicationInteraction.MQNAME)));
        applicationTransformers.add(new ModelTransformerCommand(index++, "ArchimateTransmuter.ApplicationService", "org.modelio.archimate.ModelTransformCommand", new ArchimateElementTransmuter(ApplicationService.MQNAME)));
        applicationTransformers.add(new ModelTransformerCommand(index++, "ArchimateTransmuter.ApplicationEvent", "org.modelio.archimate.ModelTransformCommand", new ArchimateElementTransmuter(ApplicationEvent.MQNAME)));
        applicationTransformers.add(new ModelTransformerCommand(index++, "ArchimateTransmuter.DataObject", "org.modelio.archimate.ModelTransformCommand", new ArchimateElementTransmuter(DataObject.MQNAME)));
        this.transformers.put(ArchimateLayer.APPLICATION, applicationTransformers);

        List<ModelTransformerCommand> technologyTransformers = new ArrayList<>();
        technologyTransformers.add(new ModelTransformerCommand(index++, "ArchimateTransmuter.Node", "org.modelio.archimate.ModelTransformCommand", new ArchimateElementTransmuter(Node.MQNAME)));
        technologyTransformers.add(new ModelTransformerCommand(index++, "ArchimateTransmuter.Device", "org.modelio.archimate.ModelTransformCommand", new ArchimateElementTransmuter(Device.MQNAME)));
        technologyTransformers.add(new ModelTransformerCommand(index++, "ArchimateTransmuter.SystemSoftware", "org.modelio.archimate.ModelTransformCommand", new ArchimateElementTransmuter(SystemSoftware.MQNAME)));
        technologyTransformers.add(new ModelTransformerCommand(index++, "ArchimateTransmuter.TechnologyCollaboration", "org.modelio.archimate.ModelTransformCommand", new ArchimateElementTransmuter(TechnologyCollaboration.MQNAME)));
        technologyTransformers.add(new ModelTransformerCommand(index++, "ArchimateTransmuter.TechnologyInterface", "org.modelio.archimate.ModelTransformCommand", new ArchimateElementTransmuter(TechnologyInterface.MQNAME)));
        technologyTransformers.add(new ModelTransformerCommand(index++, "ArchimateTransmuter.TechnologyProcess", "org.modelio.archimate.ModelTransformCommand", new ArchimateElementTransmuter(TechnologyProcess.MQNAME)));
        technologyTransformers.add(new ModelTransformerCommand(index++, "ArchimateTransmuter.TechnologyFunction", "org.modelio.archimate.ModelTransformCommand", new ArchimateElementTransmuter(TechnologyFunction.MQNAME)));
        technologyTransformers.add(new ModelTransformerCommand(index++, "ArchimateTransmuter.TechnologyInteraction", "org.modelio.archimate.ModelTransformCommand", new ArchimateElementTransmuter(TechnologyInteraction.MQNAME)));
        technologyTransformers.add(new ModelTransformerCommand(index++, "ArchimateTransmuter.TechnologyService", "org.modelio.archimate.ModelTransformCommand", new ArchimateElementTransmuter(TechnologyService.MQNAME)));
        technologyTransformers.add(new ModelTransformerCommand(index++, "ArchimateTransmuter.TechnologyEvent", "org.modelio.archimate.ModelTransformCommand", new ArchimateElementTransmuter(TechnologyEvent.MQNAME)));
        technologyTransformers.add(new ModelTransformerCommand(index++, "ArchimateTransmuter.Artifact", "org.modelio.archimate.ModelTransformCommand", new ArchimateElementTransmuter(Artifact.MQNAME)));
        technologyTransformers.add(new ModelTransformerCommand(index++, "ArchimateTransmuter.CommunicationNetwork", "org.modelio.archimate.ModelTransformCommand", new ArchimateElementTransmuter(CommunicationNetwork.MQNAME)));
        technologyTransformers.add(new ModelTransformerCommand(index++, "ArchimateTransmuter.Path", "org.modelio.archimate.ModelTransformCommand", new ArchimateElementTransmuter(Path.MQNAME)));
        this.transformers.put(ArchimateLayer.TECHNOLOGY, technologyTransformers);


        List<ModelTransformerCommand> physicalTransformers = new ArrayList<>();
        physicalTransformers.add(new ModelTransformerCommand(index++, "ArchimateTransmuter.Facility", "org.modelio.archimate.ModelTransformCommand", new ArchimateElementTransmuter(Facility.MQNAME)));
        physicalTransformers.add(new ModelTransformerCommand(index++, "ArchimateTransmuter.Equipment", "org.modelio.archimate.ModelTransformCommand", new ArchimateElementTransmuter(Equipment.MQNAME)));
        physicalTransformers.add(new ModelTransformerCommand(index++, "ArchimateTransmuter.Material", "org.modelio.archimate.ModelTransformCommand", new ArchimateElementTransmuter(Material.MQNAME)));
        physicalTransformers.add(new ModelTransformerCommand(index++, "ArchimateTransmuter.DistributionNetwork", "org.modelio.archimate.ModelTransformCommand", new ArchimateElementTransmuter(DistributionNetwork.MQNAME)));
        this.transformers.put(ArchimateLayer.PHYSICAL, physicalTransformers);

        List<ModelTransformerCommand> strategyTransformers = new ArrayList<>();
        strategyTransformers.add(new ModelTransformerCommand(index++, "ArchimateTransmuter.Resource", "org.modelio.archimate.ModelTransformCommand", new ArchimateElementTransmuter(Resource.MQNAME)));
        strategyTransformers.add(new ModelTransformerCommand(index++, "ArchimateTransmuter.Capability", "org.modelio.archimate.ModelTransformCommand", new ArchimateElementTransmuter(Capability.MQNAME)));
        strategyTransformers.add(new ModelTransformerCommand(index++, "ArchimateTransmuter.CourseOfAction", "org.modelio.archimate.ModelTransformCommand", new ArchimateElementTransmuter(CourseOfAction.MQNAME)));
        strategyTransformers.add(new ModelTransformerCommand(index++, "ArchimateTransmuter.ValueStream", "org.modelio.archimate.ModelTransformCommand", new ArchimateElementTransmuter(ValueStream.MQNAME)));
        this.transformers.put(ArchimateLayer.STRATEGY, strategyTransformers);

        List<ModelTransformerCommand> moticationTransformers = new ArrayList<>();
        moticationTransformers.add(new ModelTransformerCommand(index++, "ArchimateTransmuter.Stakeholder", "org.modelio.archimate.ModelTransformCommand", new ArchimateElementTransmuter(Stakeholder.MQNAME)));
        moticationTransformers.add(new ModelTransformerCommand(index++, "ArchimateTransmuter.Driver", "org.modelio.archimate.ModelTransformCommand", new ArchimateElementTransmuter(Driver.MQNAME)));
        moticationTransformers.add(new ModelTransformerCommand(index++, "ArchimateTransmuter.Assessment", "org.modelio.archimate.ModelTransformCommand", new ArchimateElementTransmuter(Assessment.MQNAME)));
        moticationTransformers.add(new ModelTransformerCommand(index++, "ArchimateTransmuter.Value", "org.modelio.archimate.ModelTransformCommand", new ArchimateElementTransmuter(Value.MQNAME)));
        moticationTransformers.add(new ModelTransformerCommand(index++, "ArchimateTransmuter.Meaning", "org.modelio.archimate.ModelTransformCommand", new ArchimateElementTransmuter(Meaning.MQNAME)));
        moticationTransformers.add(new ModelTransformerCommand(index++, "ArchimateTransmuter.Goal", "org.modelio.archimate.ModelTransformCommand", new ArchimateElementTransmuter(Goal.MQNAME)));
        moticationTransformers.add(new ModelTransformerCommand(index++, "ArchimateTransmuter.Outcome", "org.modelio.archimate.ModelTransformCommand", new ArchimateElementTransmuter(Outcome.MQNAME)));
        moticationTransformers.add(new ModelTransformerCommand(index++, "ArchimateTransmuter.Principle", "org.modelio.archimate.ModelTransformCommand", new ArchimateElementTransmuter(Principle.MQNAME)));
        moticationTransformers.add(new ModelTransformerCommand(index++, "ArchimateTransmuter.Requirement", "org.modelio.archimate.ModelTransformCommand", new ArchimateElementTransmuter(Requirement.MQNAME)));
        moticationTransformers.add(new ModelTransformerCommand(index++, "ArchimateTransmuter.Constraint", "org.modelio.archimate.ModelTransformCommand", new ArchimateElementTransmuter(Constraint.MQNAME)));
        this.transformers.put(ArchimateLayer.MOTIVATION, moticationTransformers);


        List<ModelTransformerCommand> implementationTransformers = new ArrayList<>();
        implementationTransformers.add(new ModelTransformerCommand(index++, "ArchimateTransmuter.WorkPackage", "org.modelio.archimate.ModelTransformCommand", new ArchimateElementTransmuter(WorkPackage.MQNAME)));
        implementationTransformers.add(new ModelTransformerCommand(index++, "ArchimateTransmuter.ImplementationEvent", "org.modelio.archimate.ModelTransformCommand", new ArchimateElementTransmuter(ImplementationEvent.MQNAME)));
        implementationTransformers.add(new ModelTransformerCommand(index++, "ArchimateTransmuter.Deliverable", "org.modelio.archimate.ModelTransformCommand", new ArchimateElementTransmuter(Deliverable.MQNAME)));
        implementationTransformers.add(new ModelTransformerCommand(index++, "ArchimateTransmuter.Plateau", "org.modelio.archimate.ModelTransformCommand", new ArchimateElementTransmuter(Plateau.MQNAME)));
        implementationTransformers.add(new ModelTransformerCommand(index++, "ArchimateTransmuter.Gap", "org.modelio.archimate.ModelTransformCommand", new ArchimateElementTransmuter(Gap.MQNAME)));
        this.transformers.put(ArchimateLayer.IMPLEMENTATION_AND_MIGRATION, implementationTransformers);


        List<ModelTransformerCommand> otherTransformers = new ArrayList<>();
        otherTransformers.add(new ModelTransformerCommand(index++, "ArchimateTransmuter.Location", "org.modelio.archimate.ModelTransformCommand", new ArchimateElementTransmuter(Location.MQNAME)));
        otherTransformers.add(new ModelTransformerCommand(index++, "ArchimateTransmuter.Grouping", "org.modelio.archimate.ModelTransformCommand", new ArchimateElementTransmuter(Grouping.MQNAME)));
        this.transformers.put(ArchimateLayer.OTHER, otherTransformers);


        for (ArchimateLayer layer : ArchimateLayer.values()) {
            for (ModelTransformerCommand mt : this.transformers.get(layer)) {
                ContextInjectionFactory.inject(mt.transformer, context);
            }
        }
    }

    @objid ("ec9eb2a1-e966-4bb1-8c88-936dfb4de6b3")
    public static TransformerRegistry getInstance(IEclipseContext context) {
        if (TransformerRegistry.INSTANCE == null) {
            TransformerRegistry.INSTANCE = new TransformerRegistry(context);
        }
        return TransformerRegistry.INSTANCE;
    }

    @objid ("54393c97-c656-49a1-a153-322a1a271915")
    public List<ModelTransformerCommand> getTransformers(AbstractDiagram diagram, ISelection selection, ArchimateLayer layer) {
        return this.transformers.get(layer).stream()
                .filter(mt -> mt.transformer.isAvailable(diagram, selection))
                .collect(Collectors.toList());
    }

    @objid ("4daaccfa-3d4e-43ee-b60b-ee067b66777a")
    public IModelTransformer getTransformer(int index) {
        for (ArchimateLayer layer : ArchimateLayer.values()) {
            if (index < this.transformers.get(layer).size()) {
                return this.transformers.get(layer).get(index).transformer;
            }
            index -= this.transformers.get(layer).size();
        }
        return null;
    }

    @objid ("bd1bb14b-fc5d-4cfb-8a34-ab30f2cc6e60")
    public enum ArchimateLayer {
        @objid ("db61e81a-a690-4b31-98ea-64516148ae3c")
        BUSINESS,
        @objid ("a25092ba-c793-4456-b11c-5661971a57fb")
        APPLICATION,
        @objid ("77535bf9-e615-4231-bf18-8a75df73547d")
        TECHNOLOGY,
        @objid ("86e91dcf-cd34-4b45-9fea-49582df41af4")
        PHYSICAL,
        @objid ("fc828e0e-19dd-4980-8441-ae196270f310")
        STRATEGY,
        @objid ("dee2a67d-e6b6-45f9-84b4-4a3eb45d194e")
        MOTIVATION,
        @objid ("3828f50b-38e9-4c4a-a288-988ad9329f3f")
        IMPLEMENTATION_AND_MIGRATION,
        @objid ("8ed4ef7c-4366-4969-9533-ed83e3229ada")
        OTHER;

    }

    @objid ("84904528-d9a2-4bba-beb2-1edaf39d33ee")
    public static class ModelTransformerCommand {
        @objid ("73e4629c-82c0-4429-8612-17d53026dc1b")
        public int index;

        @objid ("8ebc8ad8-eaa4-4e8f-99f8-ceff812a3257")
        public String i18nKey;

        @objid ("841ad9bf-e805-4b51-97b6-7079265fcd02")
        public String e4CmdId;

        @objid ("d0649122-6062-4080-b4e8-42320274dbfb")
        public IModelTransformer transformer;

        @objid ("f532efc3-0e55-4de4-bbff-4ae8a426aeb4")
        public ModelTransformerCommand(int index, String i18nKey, String e4CmdId, IModelTransformer transformer) {
            this.index = index;
            this.transformer = transformer;
            this.i18nKey = i18nKey;
            this.e4CmdId = e4CmdId;
        }

    }

}

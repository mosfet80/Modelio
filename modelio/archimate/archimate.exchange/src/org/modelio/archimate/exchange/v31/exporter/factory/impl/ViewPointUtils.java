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
package org.modelio.archimate.exchange.v31.exporter.factory.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.exchange.v31.xmlmodel.ElementTypeEnum;
import org.modelio.archimate.exchange.v31.xmlmodel.RelationshipConnectorEnum;
import org.modelio.archimate.exchange.v31.xmlmodel.RelationshipTypeEnum;

@objid ("4f67158b-ce53-452f-acfb-cf4dc74e007c")
public class ViewPointUtils {
    @objid ("fe88ce49-3672-4f64-b574-90062996dbc1")
    public static List<RelationshipTypeEnum> getViewPointRelations(String viewPoint) {
        return Arrays.asList(RelationshipTypeEnum.values());
    }

    @objid ("12f37dee-ba46-412d-b394-03082db65990")
    public static List<ElementTypeEnum> getViewPointElements(String viewPoint) {
        if (viewPoint.equals("Organization")) {
            return getOrganizationElement();
        } else if (viewPoint.equals("BusinessProcessCooperation")) {
            return getBusinessProcessCooperationElement();
        } else if (viewPoint.equals("Product")) {
            return getProductElement();
        } else if (viewPoint.equals("ApplicationCooperation")) {
            return getApplicationCooperationElement();
        } else if (viewPoint.equals("ApplicationUsage")) {
            return getApplicationUsageElement();
        } else if (viewPoint.equals("ImplementationAndDeployment")) {
            return getImplementationAndDeploymentElement();
        } else if (viewPoint.equals("Technology")) {
            return getTechnologyElement();
        } else if (viewPoint.equals("TechnologyUsage")) {
            return getTechnologyUsageElement();
        } else if (viewPoint.equals("InformationStructure")) {
            return getInformationStructureElement();
        } else if (viewPoint.equals("ServiceRealization")) {
            return getServiceRealizationElement();
        } else if (viewPoint.equals("Physical")) {
            return getPhysicalElement();
        } else if (viewPoint.equals("Layered")) {
            return getLayeredElement();
        } else if (viewPoint.equals("Stakeholder")) {
            return getStakeholderElement();
        } else if (viewPoint.equals("GoalRealization")) {
            return getGoalRealizationElement();
        } else if (viewPoint.equals("RequirementsRealization")) {
            return getRequirementsRealizationElement();
        } else if (viewPoint.equals("Motivation")) {
            return getMotivationElement();
        } else if (viewPoint.equals("Strategy")) {
            return getStrategyElement();
        } else if (viewPoint.equals("CapabilityMap")) {
            return getCapabilityMapElement();
        } else if (viewPoint.equals("OutcomeRealization")) {
            return getOutcomeRealizationElement();
        } else if (viewPoint.equals("ResourceMap")) {
            return getResourceMapElement();
        } else if (viewPoint.equals("Project")) {
            return getProjectElement();
        } else if (viewPoint.equals("Migration")) {
            return getMigrationElement();
        } else if (viewPoint.equals("ImplementationAndMigration")) {
            return getImplementationAndMigrationElement();
        }
        return new ArrayList<>();
    }

    @objid ("2635823f-636d-4e55-bf6c-fa743e9df204")
    private static List<ElementTypeEnum> getImplementationAndMigrationElement() {
        List<ElementTypeEnum> elements = new ArrayList<>();
        elements.add(ElementTypeEnum.GOAL);
        elements.add(ElementTypeEnum.REQUIREMENT);
        elements.add(ElementTypeEnum.CONSTRAINT);
        elements.add(ElementTypeEnum.WORK_PACKAGE);
        elements.add(ElementTypeEnum.IMPLEMENTATION_EVENT);
        elements.add(ElementTypeEnum.DELIVERABLE);
        elements.add(ElementTypeEnum.PLATEAU);
        elements.add(ElementTypeEnum.GAP);
        elements.add(ElementTypeEnum.BUSINESS_ACTOR);
        elements.add(ElementTypeEnum.BUSINESS_ROLE);
        elements.add(ElementTypeEnum.LOCATION);
        return elements;
    }

    @objid ("472e9a88-4374-427f-bb8c-66467f9f780d")
    private static List<ElementTypeEnum> getMigrationElement() {
        List<ElementTypeEnum> elements = new ArrayList<>();
        elements.add(ElementTypeEnum.PLATEAU);
        elements.add(ElementTypeEnum.GAP);
        return elements;
    }

    @objid ("d2a4424d-fd74-45fd-8575-406a9793ba60")
    private static List<ElementTypeEnum> getProjectElement() {
        List<ElementTypeEnum> elements = new ArrayList<>();
        elements.add(ElementTypeEnum.GOAL);
        elements.add(ElementTypeEnum.WORK_PACKAGE);
        elements.add(ElementTypeEnum.IMPLEMENTATION_EVENT);
        elements.add(ElementTypeEnum.DELIVERABLE);
        elements.add(ElementTypeEnum.BUSINESS_ACTOR);
        elements.add(ElementTypeEnum.BUSINESS_ROLE);
        return elements;
    }

    @objid ("4697a8d6-da6f-4228-b82b-072685741b61")
    private static List<ElementTypeEnum> getResourceMapElement() {
        List<ElementTypeEnum> elements = new ArrayList<>();
        elements.add(ElementTypeEnum.RESOURCE);
        elements.add(ElementTypeEnum.CAPABILITY);
        elements.add(ElementTypeEnum.WORK_PACKAGE);
        return elements;
    }

    @objid ("e43018bd-c212-4308-8873-107573e15377")
    private static List<ElementTypeEnum> getCapabilityMapElement() {
        List<ElementTypeEnum> elements = new ArrayList<>();
        elements.add(ElementTypeEnum.OUTCOME);
        elements.add(ElementTypeEnum.CAPABILITY);
        elements.add(ElementTypeEnum.RESOURCE);
        return elements;
    }

    @objid ("7192063e-287d-4f98-b387-fc53601fa124")
    private static List<ElementTypeEnum> getOutcomeRealizationElement() {
        List<ElementTypeEnum> elements = new ArrayList<>();
        elements.add(ElementTypeEnum.CAPABILITY);
        elements.add(ElementTypeEnum.RESOURCE);
        elements.add(ElementTypeEnum.OUTCOME);
        elements.add(ElementTypeEnum.VALUE);
        elements.add(ElementTypeEnum.MEANING);
        elements.addAll(getBusinessLayerElements());
        elements.addAll(getApplicationLayerElements());
        elements.addAll(getTechnologyLayerElements());
        return elements;
    }

    @objid ("89dcf882-75f5-446e-96cd-4723467036f9")
    private static List<ElementTypeEnum> getStrategyElement() {
        List<ElementTypeEnum> elements = new ArrayList<>();
        elements.add(ElementTypeEnum.COURSE_OF_ACTION);
        elements.add(ElementTypeEnum.CAPABILITY);
        elements.add(ElementTypeEnum.RESOURCE);
        elements.add(ElementTypeEnum.OUTCOME);
        return elements;
    }

    @objid ("50f7d8f3-d2ed-4712-aee5-f16f875ee22a")
    private static List<ElementTypeEnum> getMotivationElement() {
        List<ElementTypeEnum> elements = new ArrayList<>();
        elements.add(ElementTypeEnum.STAKEHOLDER);
        elements.add(ElementTypeEnum.DRIVER);
        elements.add(ElementTypeEnum.ASSESSMENT);
        elements.add(ElementTypeEnum.GOAL);
        elements.add(ElementTypeEnum.PRINCIPLE);
        elements.add(ElementTypeEnum.REQUIREMENT);
        elements.add(ElementTypeEnum.CONSTRAINT);
        elements.add(ElementTypeEnum.OUTCOME);
        elements.add(ElementTypeEnum.VALUE);
        elements.add(ElementTypeEnum.MEANING);
        return elements;
    }

    @objid ("3c152557-23ff-4bc5-9e07-1abdd943e830")
    private static List<ElementTypeEnum> getRequirementsRealizationElement() {
        List<ElementTypeEnum> elements = new ArrayList<>();
        elements.add(ElementTypeEnum.GOAL);
        elements.add(ElementTypeEnum.REQUIREMENT);
        elements.add(ElementTypeEnum.CONSTRAINT);
        elements.add(ElementTypeEnum.OUTCOME);
        elements.add(ElementTypeEnum.VALUE);
        elements.add(ElementTypeEnum.MEANING);

        elements.addAll(getBusinessLayerElements());
        elements.addAll(getApplicationLayerElements());
        elements.addAll(getTechnologyLayerElements());
        return elements;
    }

    @objid ("b7abe102-9f6a-4093-8643-42201989007c")
    private static List<ElementTypeEnum> getGoalRealizationElement() {
        List<ElementTypeEnum> elements = new ArrayList<>();
        elements.add(ElementTypeEnum.GOAL);
        elements.add(ElementTypeEnum.PRINCIPLE);
        elements.add(ElementTypeEnum.REQUIREMENT);
        elements.add(ElementTypeEnum.CONSTRAINT);
        elements.add(ElementTypeEnum.OUTCOME);
        return elements;
    }

    @objid ("d5decca6-db16-4d6d-a657-545e489d85e2")
    private static List<ElementTypeEnum> getStakeholderElement() {
        List<ElementTypeEnum> elements = new ArrayList<>();
        elements.add(ElementTypeEnum.STAKEHOLDER);
        elements.add(ElementTypeEnum.DRIVER);
        elements.add(ElementTypeEnum.ASSESSMENT);
        elements.add(ElementTypeEnum.GOAL);
        elements.add(ElementTypeEnum.OUTCOME);
        return elements;
    }

    @objid ("90d1b637-0507-4f2c-9a11-24895e23f43c")
    private static List<ElementTypeEnum> getLayeredElement() {
        List<ElementTypeEnum> elements = new ArrayList<>();
        elements.addAll(getApplicationLayerElements());
        elements.addAll(getBusinessLayerElements());
        elements.addAll(getTechnologyLayerElements());
        return elements;
    }

    @objid ("ef52772e-8a9a-4fbd-977c-d4329968069a")
    private static Collection<? extends ElementTypeEnum> getTechnologyLayerElements() {
        List<ElementTypeEnum> elements = new ArrayList<>();
        elements.add(ElementTypeEnum.FACILITY);
        elements.add(ElementTypeEnum.EQUIPMENT);
        elements.add(ElementTypeEnum.MATERIAL);
        elements.add(ElementTypeEnum.NODE);
        elements.add(ElementTypeEnum.DEVICE);
        elements.add(ElementTypeEnum.SYSTEM_SOFTWARE);
        elements.add(ElementTypeEnum.TECHNOLOGY_COLLABORATION);
        elements.add(ElementTypeEnum.TECHNOLOGY_INTERFACE);
        elements.add(ElementTypeEnum.TECHNOLOGY_PROCESS);
        elements.add(ElementTypeEnum.TECHNOLOGY_FUNCTION);
        elements.add(ElementTypeEnum.TECHNOLOGY_INTERACTION);
        elements.add(ElementTypeEnum.TECHNOLOGY_SERVICE);
        elements.add(ElementTypeEnum.TECHNOLOGY_EVENT);
        elements.add(ElementTypeEnum.ARTIFACT);
        elements.add(ElementTypeEnum.COMMUNICATION_NETWORK);
        elements.add(ElementTypeEnum.PATH);
        elements.add(ElementTypeEnum.DISTRIBUTION_NETWORK);
        return elements;
    }

    @objid ("445964dc-8bb1-400a-a25a-aaec58ed1741")
    private static Collection<? extends ElementTypeEnum> getBusinessLayerElements() {
        List<ElementTypeEnum> elements = new ArrayList<>();
        elements.add(ElementTypeEnum.BUSINESS_ACTOR);
        elements.add(ElementTypeEnum.BUSINESS_ROLE);
        elements.add(ElementTypeEnum.BUSINESS_COLLABORATION);
        elements.add(ElementTypeEnum.BUSINESS_INTERFACE);
        elements.add(ElementTypeEnum.BUSINESS_PROCESS);
        elements.add(ElementTypeEnum.BUSINESS_FUNCTION);
        elements.add(ElementTypeEnum.BUSINESS_INTERACTION);
        elements.add(ElementTypeEnum.BUSINESS_SERVICE);
        elements.add(ElementTypeEnum.BUSINESS_EVENT);
        elements.add(ElementTypeEnum.BUSINESS_OBJECT);
        elements.add(ElementTypeEnum.CONTRACT);
        elements.add(ElementTypeEnum.REPRESENTATION);
        elements.add(ElementTypeEnum.PRODUCT);
        return elements;
    }

    @objid ("ef104849-95d3-4154-b70c-c360928a057c")
    private static Collection<? extends ElementTypeEnum> getApplicationLayerElements() {
        List<ElementTypeEnum> elements = new ArrayList<>();
        elements.add(ElementTypeEnum.APPLICATION_COMPONENT);
        elements.add(ElementTypeEnum.APPLICATION_COLLABORATION);
        elements.add(ElementTypeEnum.APPLICATION_INTERFACE);
        elements.add(ElementTypeEnum.APPLICATION_PROCESS);
        elements.add(ElementTypeEnum.APPLICATION_FUNCTION);
        elements.add(ElementTypeEnum.APPLICATION_INTERACTION);
        elements.add(ElementTypeEnum.APPLICATION_SERVICE);
        elements.add(ElementTypeEnum.APPLICATION_EVENT);
        elements.add(ElementTypeEnum.DATA_OBJECT);
        return elements;
    }

    @objid ("621236ca-ade9-4ca5-bd13-7e2ca430d105")
    private static List<ElementTypeEnum> getServiceRealizationElement() {
        List<ElementTypeEnum> elements = new ArrayList<>();
        elements.add(ElementTypeEnum.BUSINESS_ACTOR);
        elements.add(ElementTypeEnum.BUSINESS_ROLE);
        elements.add(ElementTypeEnum.BUSINESS_COLLABORATION);
        elements.add(ElementTypeEnum.BUSINESS_INTERFACE);
        elements.add(ElementTypeEnum.BUSINESS_PROCESS);
        elements.add(ElementTypeEnum.BUSINESS_FUNCTION);
        elements.add(ElementTypeEnum.BUSINESS_INTERACTION);
        elements.add(ElementTypeEnum.BUSINESS_EVENT);
        elements.add(ElementTypeEnum.BUSINESS_SERVICE);
        elements.add(ElementTypeEnum.BUSINESS_OBJECT);
        elements.add(ElementTypeEnum.REPRESENTATION);
        elements.add(ElementTypeEnum.APPLICATION_COMPONENT);
        elements.add(ElementTypeEnum.APPLICATION_COLLABORATION);
        elements.add(ElementTypeEnum.APPLICATION_INTERFACE);
        elements.add(ElementTypeEnum.APPLICATION_PROCESS);
        elements.add(ElementTypeEnum.APPLICATION_FUNCTION);
        elements.add(ElementTypeEnum.APPLICATION_INTERACTION);
        elements.add(ElementTypeEnum.APPLICATION_EVENT);
        elements.add(ElementTypeEnum.APPLICATION_SERVICE);
        elements.add(ElementTypeEnum.DATA_OBJECT);
        return elements;
    }

    @objid ("eb71a12f-2efd-41c6-a60c-2b577299d127")
    private static List<ElementTypeEnum> getPhysicalElement() {
        List<ElementTypeEnum> elements = new ArrayList<>();
        elements.add(ElementTypeEnum.LOCATION);
        elements.add(ElementTypeEnum.NODE);
        elements.add(ElementTypeEnum.DEVICE);
        elements.add(ElementTypeEnum.EQUIPMENT);
        elements.add(ElementTypeEnum.FACILITY);
        elements.add(ElementTypeEnum.PATH);
        elements.add(ElementTypeEnum.COMMUNICATION_NETWORK);
        elements.add(ElementTypeEnum.DISTRIBUTION_NETWORK);
        elements.add(ElementTypeEnum.MATERIAL);
        return elements;
    }

    @objid ("fb339367-5a1f-454f-b93d-9dde03525393")
    private static List<ElementTypeEnum> getInformationStructureElement() {
        List<ElementTypeEnum> elements = new ArrayList<>();
        elements.add(ElementTypeEnum.BUSINESS_OBJECT);
        elements.add(ElementTypeEnum.REPRESENTATION);
        elements.add(ElementTypeEnum.DATA_OBJECT);
        elements.add(ElementTypeEnum.ARTIFACT);
        elements.add(ElementTypeEnum.MEANING);
        return elements;
    }

    @objid ("de77defd-dac9-4be8-878c-3e35c1056421")
    private static List<ElementTypeEnum> getTechnologyUsageElement() {
        List<ElementTypeEnum> elements = new ArrayList<>();
        elements.add(ElementTypeEnum.APPLICATION_COMPONENT);
        elements.add(ElementTypeEnum.APPLICATION_COLLABORATION);
        elements.add(ElementTypeEnum.APPLICATION_PROCESS);
        elements.add(ElementTypeEnum.APPLICATION_FUNCTION);
        elements.add(ElementTypeEnum.APPLICATION_INTERACTION);
        elements.add(ElementTypeEnum.APPLICATION_EVENT);
        elements.add(ElementTypeEnum.DATA_OBJECT);
        elements.add(ElementTypeEnum.NODE);
        elements.add(ElementTypeEnum.DEVICE);
        elements.add(ElementTypeEnum.TECHNOLOGY_COLLABORATION);
        elements.add(ElementTypeEnum.SYSTEM_SOFTWARE);
        elements.add(ElementTypeEnum.TECHNOLOGY_INTERFACE);
        elements.add(ElementTypeEnum.COMMUNICATION_NETWORK);
        elements.add(ElementTypeEnum.PATH);
        elements.add(ElementTypeEnum.TECHNOLOGY_PROCESS);
        elements.add(ElementTypeEnum.TECHNOLOGY_FUNCTION);
        elements.add(ElementTypeEnum.TECHNOLOGY_INTERACTION);
        elements.add(ElementTypeEnum.TECHNOLOGY_SERVICE);
        elements.add(ElementTypeEnum.TECHNOLOGY_EVENT);
        elements.add(ElementTypeEnum.ARTIFACT);
        return elements;
    }

    @objid ("d7e2a591-d126-46f5-a51d-9fef8d5654bd")
    private static List<ElementTypeEnum> getTechnologyElement() {
        List<ElementTypeEnum> elements = new ArrayList<>();
        elements.add(ElementTypeEnum.LOCATION);
        elements.add(ElementTypeEnum.NODE);
        elements.add(ElementTypeEnum.TECHNOLOGY_COLLABORATION);
        elements.add(ElementTypeEnum.DEVICE);
        elements.add(ElementTypeEnum.SYSTEM_SOFTWARE);
        elements.add(ElementTypeEnum.TECHNOLOGY_INTERFACE);
        elements.add(ElementTypeEnum.COMMUNICATION_NETWORK);
        elements.add(ElementTypeEnum.PATH);
        elements.add(ElementTypeEnum.TECHNOLOGY_PROCESS);
        elements.add(ElementTypeEnum.TECHNOLOGY_FUNCTION);
        elements.add(ElementTypeEnum.TECHNOLOGY_INTERACTION);
        elements.add(ElementTypeEnum.TECHNOLOGY_SERVICE);
        elements.add(ElementTypeEnum.TECHNOLOGY_EVENT);
        elements.add(ElementTypeEnum.ARTIFACT);
        return elements;
    }

    @objid ("13405d4e-729f-4ca4-b428-59ac1d36aebb")
    private static List<ElementTypeEnum> getImplementationAndDeploymentElement() {
        List<ElementTypeEnum> elements = new ArrayList<>();
        elements.add(ElementTypeEnum.APPLICATION_COMPONENT);
        elements.add(ElementTypeEnum.APPLICATION_COLLABORATION);
        elements.add(ElementTypeEnum.APPLICATION_INTERFACE);
        elements.add(ElementTypeEnum.APPLICATION_PROCESS);
        elements.add(ElementTypeEnum.APPLICATION_FUNCTION);
        elements.add(ElementTypeEnum.APPLICATION_INTERACTION);
        elements.add(ElementTypeEnum.APPLICATION_EVENT);
        elements.add(ElementTypeEnum.APPLICATION_SERVICE);
        elements.add(ElementTypeEnum.DATA_OBJECT);
        elements.add(ElementTypeEnum.SYSTEM_SOFTWARE);
        elements.add(ElementTypeEnum.TECHNOLOGY_INTERFACE);
        elements.add(ElementTypeEnum.PATH);
        elements.add(ElementTypeEnum.TECHNOLOGY_PROCESS);
        elements.add(ElementTypeEnum.TECHNOLOGY_FUNCTION);
        elements.add(ElementTypeEnum.TECHNOLOGY_INTERACTION);
        elements.add(ElementTypeEnum.TECHNOLOGY_SERVICE);
        elements.add(ElementTypeEnum.ARTIFACT);
        return elements;
    }

    @objid ("9088b2f4-6c59-44fd-9d9f-872c1559a235")
    private static List<ElementTypeEnum> getApplicationUsageElement() {
        List<ElementTypeEnum> elements = new ArrayList<>();
        elements.add(ElementTypeEnum.BUSINESS_ACTOR);
        elements.add(ElementTypeEnum.BUSINESS_ROLE);
        elements.add(ElementTypeEnum.BUSINESS_COLLABORATION);
        elements.add(ElementTypeEnum.BUSINESS_PROCESS);
        elements.add(ElementTypeEnum.BUSINESS_FUNCTION);
        elements.add(ElementTypeEnum.BUSINESS_INTERACTION);
        elements.add(ElementTypeEnum.BUSINESS_EVENT);
        elements.add(ElementTypeEnum.BUSINESS_OBJECT);
        elements.add(ElementTypeEnum.APPLICATION_COMPONENT);
        elements.add(ElementTypeEnum.APPLICATION_COLLABORATION);
        elements.add(ElementTypeEnum.APPLICATION_INTERFACE);
        elements.add(ElementTypeEnum.APPLICATION_PROCESS);
        elements.add(ElementTypeEnum.APPLICATION_FUNCTION);
        elements.add(ElementTypeEnum.APPLICATION_INTERACTION);
        elements.add(ElementTypeEnum.APPLICATION_EVENT);
        elements.add(ElementTypeEnum.APPLICATION_SERVICE);
        elements.add(ElementTypeEnum.DATA_OBJECT);
        return elements;
    }

    @objid ("171aa6c7-3350-4bb9-b8d9-1bf6faa38e6f")
    private static List<ElementTypeEnum> getApplicationCooperationElement() {
        List<ElementTypeEnum> elements = new ArrayList<>();
        elements.add(ElementTypeEnum.LOCATION);
        elements.add(ElementTypeEnum.APPLICATION_COMPONENT);
        elements.add(ElementTypeEnum.APPLICATION_COLLABORATION);
        elements.add(ElementTypeEnum.APPLICATION_INTERFACE);
        elements.add(ElementTypeEnum.APPLICATION_PROCESS);
        elements.add(ElementTypeEnum.APPLICATION_FUNCTION);
        elements.add(ElementTypeEnum.APPLICATION_INTERACTION);
        elements.add(ElementTypeEnum.APPLICATION_EVENT);
        elements.add(ElementTypeEnum.APPLICATION_SERVICE);
        elements.add(ElementTypeEnum.DATA_OBJECT);
        return elements;
    }

    @objid ("cb47e6ea-7c33-4f75-8c42-aa9367159acf")
    private static List<ElementTypeEnum> getProductElement() {
        List<ElementTypeEnum> elements = new ArrayList<>();
        elements.add(ElementTypeEnum.BUSINESS_ACTOR);
        elements.add(ElementTypeEnum.BUSINESS_ROLE);
        elements.add(ElementTypeEnum.BUSINESS_COLLABORATION);
        elements.add(ElementTypeEnum.BUSINESS_INTERFACE);
        elements.add(ElementTypeEnum.BUSINESS_PROCESS);
        elements.add(ElementTypeEnum.BUSINESS_FUNCTION);
        elements.add(ElementTypeEnum.BUSINESS_INTERACTION);
        elements.add(ElementTypeEnum.BUSINESS_EVENT);
        elements.add(ElementTypeEnum.BUSINESS_SERVICE);
        elements.add(ElementTypeEnum.BUSINESS_OBJECT);
        elements.add(ElementTypeEnum.PRODUCT);
        elements.add(ElementTypeEnum.CONTRACT);
        elements.add(ElementTypeEnum.APPLICATION_COMPONENT);
        elements.add(ElementTypeEnum.APPLICATION_COLLABORATION);
        elements.add(ElementTypeEnum.APPLICATION_INTERFACE);
        elements.add(ElementTypeEnum.APPLICATION_PROCESS);
        elements.add(ElementTypeEnum.APPLICATION_FUNCTION);
        elements.add(ElementTypeEnum.APPLICATION_INTERACTION);
        elements.add(ElementTypeEnum.APPLICATION_EVENT);
        elements.add(ElementTypeEnum.APPLICATION_SERVICE);
        elements.add(ElementTypeEnum.DATA_OBJECT);
        elements.add(ElementTypeEnum.TECHNOLOGY_SERVICE);
        elements.add(ElementTypeEnum.ARTIFACT);
        elements.add(ElementTypeEnum.MATERIAL);
        elements.add(ElementTypeEnum.VALUE);
        return elements;
    }

    @objid ("ee5e9716-528a-4d15-b41f-717f181f669a")
    private static List<ElementTypeEnum> getBusinessProcessCooperationElement() {
        List<ElementTypeEnum> elements = new ArrayList<>();
        elements.add(ElementTypeEnum.BUSINESS_ACTOR);
        elements.add(ElementTypeEnum.BUSINESS_ROLE);
        elements.add(ElementTypeEnum.BUSINESS_COLLABORATION);

        elements.add(ElementTypeEnum.BUSINESS_INTERFACE);
        elements.add(ElementTypeEnum.BUSINESS_PROCESS);
        elements.add(ElementTypeEnum.BUSINESS_FUNCTION);
        elements.add(ElementTypeEnum.BUSINESS_INTERACTION);
        elements.add(ElementTypeEnum.BUSINESS_EVENT);
        elements.add(ElementTypeEnum.BUSINESS_SERVICE);
        elements.add(ElementTypeEnum.BUSINESS_OBJECT);
        elements.add(ElementTypeEnum.REPRESENTATION);
        elements.add(ElementTypeEnum.APPLICATION_COMPONENT);
        elements.add(ElementTypeEnum.APPLICATION_COLLABORATION);
        elements.add(ElementTypeEnum.APPLICATION_INTERFACE);
        elements.add(ElementTypeEnum.APPLICATION_PROCESS);
        elements.add(ElementTypeEnum.APPLICATION_FUNCTION);
        elements.add(ElementTypeEnum.APPLICATION_INTERACTION);
        elements.add(ElementTypeEnum.APPLICATION_EVENT);
        elements.add(ElementTypeEnum.APPLICATION_SERVICE);
        elements.add(ElementTypeEnum.DATA_OBJECT);

        elements.add(ElementTypeEnum.LOCATION);
        return elements;
    }

    @objid ("744fa28f-5d3d-4043-a53b-8cf930717115")
    private static List<ElementTypeEnum> getOrganizationElement() {
        List<ElementTypeEnum> elements = new ArrayList<>();
        elements.add(ElementTypeEnum.BUSINESS_ACTOR);
        elements.add(ElementTypeEnum.BUSINESS_ROLE);
        elements.add(ElementTypeEnum.BUSINESS_INTERFACE);
        elements.add(ElementTypeEnum.BUSINESS_COLLABORATION);
        elements.add(ElementTypeEnum.LOCATION);
        return elements;
    }

    @objid ("6e8180ac-f599-47ec-9991-ae249bc82e53")
    public static List<RelationshipConnectorEnum> getViewPointRelationshipConnector(String viewPoint) {
        return Arrays.asList(RelationshipConnectorEnum.values());
    }

}

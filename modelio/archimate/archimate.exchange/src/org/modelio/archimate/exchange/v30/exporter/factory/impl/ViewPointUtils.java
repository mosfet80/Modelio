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
package org.modelio.archimate.exchange.v30.exporter.factory.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.exchange.v30.xmlmodel.ElementTypeEnum;
import org.modelio.archimate.exchange.v30.xmlmodel.RelationshipConnectorEnum;
import org.modelio.archimate.exchange.v30.xmlmodel.RelationshipTypeEnum;

@objid ("d4477193-85c9-412d-9c8f-e52af3c30228")
public class ViewPointUtils {
    @objid ("941054d0-0e0f-43c6-aa19-b768c87d7560")
    public static List<RelationshipTypeEnum> getViewPointRelations(String viewPoint) {
        return Arrays.asList(RelationshipTypeEnum.values());
    }

    @objid ("fc490834-c52d-49ae-8a33-9e6fba09ace0")
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

    @objid ("6d5447e4-7ccf-4a3a-a78e-c0db4b8bde40")
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

    @objid ("9383f43d-ad7e-460a-a98b-eae17c49fc56")
    private static List<ElementTypeEnum> getMigrationElement() {
        List<ElementTypeEnum> elements = new ArrayList<>();
        elements.add(ElementTypeEnum.PLATEAU);
        elements.add(ElementTypeEnum.GAP);
        return elements;
    }

    @objid ("12da7018-6abe-45bc-a471-dbf4745849d2")
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

    @objid ("ae659480-9c98-4b1a-8182-2314fdbeeca4")
    private static List<ElementTypeEnum> getResourceMapElement() {
        List<ElementTypeEnum> elements = new ArrayList<>();
        elements.add(ElementTypeEnum.RESOURCE);
        elements.add(ElementTypeEnum.CAPABILITY);
        elements.add(ElementTypeEnum.WORK_PACKAGE);
        return elements;
    }

    @objid ("8667feff-5916-40e1-87bc-d196cb3f9489")
    private static List<ElementTypeEnum> getCapabilityMapElement() {
        List<ElementTypeEnum> elements = new ArrayList<>();
        elements.add(ElementTypeEnum.OUTCOME);
        elements.add(ElementTypeEnum.CAPABILITY);
        elements.add(ElementTypeEnum.RESOURCE);
        return elements;
    }

    @objid ("b1eda25e-4b66-4cb7-906a-6a577557eb93")
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

    @objid ("5fb70d5f-4313-49d9-8867-4911160bd317")
    private static List<ElementTypeEnum> getStrategyElement() {
        List<ElementTypeEnum> elements = new ArrayList<>();
        elements.add(ElementTypeEnum.COURSE_OF_ACTION);
        elements.add(ElementTypeEnum.CAPABILITY);
        elements.add(ElementTypeEnum.RESOURCE);
        elements.add(ElementTypeEnum.OUTCOME);
        return elements;
    }

    @objid ("13493254-bf3c-4183-8d1a-fe7ade560c73")
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

    @objid ("b397f707-16bd-42ad-b081-04a76e6ec1ec")
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

    @objid ("999a8013-a6d9-45d7-8e64-484a189e8822")
    private static List<ElementTypeEnum> getGoalRealizationElement() {
        List<ElementTypeEnum> elements = new ArrayList<>();
        elements.add(ElementTypeEnum.GOAL);
        elements.add(ElementTypeEnum.PRINCIPLE);
        elements.add(ElementTypeEnum.REQUIREMENT);
        elements.add(ElementTypeEnum.CONSTRAINT);
        elements.add(ElementTypeEnum.OUTCOME);
        return elements;
    }

    @objid ("4ee820b9-c5a9-444f-bdf7-e1479fbde4d7")
    private static List<ElementTypeEnum> getStakeholderElement() {
        List<ElementTypeEnum> elements = new ArrayList<>();
        elements.add(ElementTypeEnum.STAKEHOLDER);
        elements.add(ElementTypeEnum.DRIVER);
        elements.add(ElementTypeEnum.ASSESSMENT);
        elements.add(ElementTypeEnum.GOAL);
        elements.add(ElementTypeEnum.OUTCOME);
        return elements;
    }

    @objid ("646bd33e-f3c7-48b2-bbcc-b48693ed3888")
    private static List<ElementTypeEnum> getLayeredElement() {
        List<ElementTypeEnum> elements = new ArrayList<>();
        elements.addAll(getApplicationLayerElements());
        elements.addAll(getBusinessLayerElements());
        elements.addAll(getTechnologyLayerElements());
        return elements;
    }

    @objid ("e10c7a8a-b720-4c7f-81e1-9c81af8e3e57")
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

    @objid ("c50fabe7-7483-43f2-b886-46d194cf1ace")
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

    @objid ("76570e74-f74d-426a-83aa-32c72857da32")
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

    @objid ("4dff17d5-3414-4bd3-a823-17511096289d")
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

    @objid ("d2c356ea-d629-4acc-9681-82d936b66405")
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

    @objid ("1214c9eb-3a17-4d7b-8c32-72cea012bbb7")
    private static List<ElementTypeEnum> getInformationStructureElement() {
        List<ElementTypeEnum> elements = new ArrayList<>();
        elements.add(ElementTypeEnum.BUSINESS_OBJECT);
        elements.add(ElementTypeEnum.REPRESENTATION);
        elements.add(ElementTypeEnum.DATA_OBJECT);
        elements.add(ElementTypeEnum.ARTIFACT);
        elements.add(ElementTypeEnum.MEANING);
        return elements;
    }

    @objid ("2692ac24-9120-4f39-a603-7602d0d9e20f")
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

    @objid ("92a595d5-87ce-4b45-9652-038469bf560c")
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

    @objid ("c82b212c-81dc-4df7-ab7e-80eb58f6a599")
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

    @objid ("f9e79f03-c65b-474e-941e-7d22b24afa0a")
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

    @objid ("6ddd4c80-ba5f-4f66-acf2-6c6128c9ffd4")
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

    @objid ("2fcd2c6c-ce64-4afc-a366-43a819ddc24e")
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

    @objid ("4e92c94e-933a-4097-a90b-895a2a245e63")
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

    @objid ("9179bc3f-5a5a-4907-af50-b853a0b75128")
    private static List<ElementTypeEnum> getOrganizationElement() {
        List<ElementTypeEnum> elements = new ArrayList<>();
        elements.add(ElementTypeEnum.BUSINESS_ACTOR);
        elements.add(ElementTypeEnum.BUSINESS_ROLE);
        elements.add(ElementTypeEnum.BUSINESS_INTERFACE);
        elements.add(ElementTypeEnum.BUSINESS_COLLABORATION);
        elements.add(ElementTypeEnum.LOCATION);
        return elements;
    }

    @objid ("76077098-548a-47c0-b691-432673d31f67")
    public static List<RelationshipConnectorEnum> getViewPointRelationshipConnector(String viewPoint) {
        return Arrays.asList(RelationshipConnectorEnum.values());
    }

}

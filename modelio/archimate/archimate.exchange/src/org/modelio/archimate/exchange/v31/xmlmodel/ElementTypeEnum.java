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
//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.8-b130911.1802
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source.
// Généré le : 2019.08.22 à 10:16:32 AM CEST
//
package org.modelio.archimate.exchange.v31.xmlmodel;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;

/**
 * <p>Classe Java pour ElementTypeEnum.
 *
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;simpleType name="ElementTypeEnum">
 * &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 * &lt;enumeration value="BusinessActor"/>
 * &lt;enumeration value="BusinessRole"/>
 * &lt;enumeration value="BusinessCollaboration"/>
 * &lt;enumeration value="BusinessInterface"/>
 * &lt;enumeration value="BusinessProcess"/>
 * &lt;enumeration value="BusinessFunction"/>
 * &lt;enumeration value="BusinessInteraction"/>
 * &lt;enumeration value="BusinessEvent"/>
 * &lt;enumeration value="BusinessService"/>
 * &lt;enumeration value="BusinessObject"/>
 * &lt;enumeration value="Contract"/>
 * &lt;enumeration value="Representation"/>
 * &lt;enumeration value="Product"/>
 * &lt;enumeration value="ApplicationComponent"/>
 * &lt;enumeration value="ApplicationCollaboration"/>
 * &lt;enumeration value="ApplicationInterface"/>
 * &lt;enumeration value="ApplicationFunction"/>
 * &lt;enumeration value="ApplicationInteraction"/>
 * &lt;enumeration value="ApplicationProcess"/>
 * &lt;enumeration value="ApplicationEvent"/>
 * &lt;enumeration value="ApplicationService"/>
 * &lt;enumeration value="DataObject"/>
 * &lt;enumeration value="Node"/>
 * &lt;enumeration value="Device"/>
 * &lt;enumeration value="SystemSoftware"/>
 * &lt;enumeration value="TechnologyCollaboration"/>
 * &lt;enumeration value="TechnologyInterface"/>
 * &lt;enumeration value="Path"/>
 * &lt;enumeration value="CommunicationNetwork"/>
 * &lt;enumeration value="TechnologyFunction"/>
 * &lt;enumeration value="TechnologyProcess"/>
 * &lt;enumeration value="TechnologyInteraction"/>
 * &lt;enumeration value="TechnologyEvent"/>
 * &lt;enumeration value="TechnologyService"/>
 * &lt;enumeration value="Artifact"/>
 * &lt;enumeration value="Equipment"/>
 * &lt;enumeration value="Facility"/>
 * &lt;enumeration value="DistributionNetwork"/>
 * &lt;enumeration value="Material"/>
 * &lt;enumeration value="Stakeholder"/>
 * &lt;enumeration value="Driver"/>
 * &lt;enumeration value="Assessment"/>
 * &lt;enumeration value="Goal"/>
 * &lt;enumeration value="Outcome"/>
 * &lt;enumeration value="Principle"/>
 * &lt;enumeration value="Requirement"/>
 * &lt;enumeration value="Constraint"/>
 * &lt;enumeration value="Meaning"/>
 * &lt;enumeration value="Value"/>
 * &lt;enumeration value="Resource"/>
 * &lt;enumeration value="Capability"/>
 * &lt;enumeration value="CourseOfAction"/>
 * &lt;enumeration value="ValueStream"/>
 * &lt;enumeration value="WorkPackage"/>
 * &lt;enumeration value="Deliverable"/>
 * &lt;enumeration value="ImplementationEvent"/>
 * &lt;enumeration value="Plateau"/>
 * &lt;enumeration value="Gap"/>
 * &lt;enumeration value="Grouping"/>
 * &lt;enumeration value="Location"/>
 * &lt;enumeration value="AndJunction"/>
 * &lt;enumeration value="OrJunction"/>
 * &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 */
@objid ("c6ede0e4-79f4-4769-ad77-9d56dd8317b2")
@XmlType(name = "ElementTypeEnum")
@XmlEnum
public enum ElementTypeEnum {
    @objid ("f2dcbc01-d6ea-4326-b8d4-981585b2bb89")
    @XmlEnumValue("BusinessActor")
    BUSINESS_ACTOR("BusinessActor"),
    @objid ("78cf2810-2f8f-4c46-852e-6d07be2c0676")
    @XmlEnumValue("BusinessRole")
    BUSINESS_ROLE("BusinessRole"),
    @objid ("9d2bea69-1af6-4358-81ae-5ad30f44a68d")
    @XmlEnumValue("BusinessCollaboration")
    BUSINESS_COLLABORATION("BusinessCollaboration"),
    @objid ("912bf300-f3ae-4302-99d6-f7d37bd29749")
    @XmlEnumValue("BusinessInterface")
    BUSINESS_INTERFACE("BusinessInterface"),
    @objid ("76eade28-f720-4812-9f91-1d18a2d4b94d")
    @XmlEnumValue("BusinessProcess")
    BUSINESS_PROCESS("BusinessProcess"),
    @objid ("7ea6f4c1-253b-4447-b08c-c9f8cf5322e1")
    @XmlEnumValue("BusinessFunction")
    BUSINESS_FUNCTION("BusinessFunction"),
    @objid ("a6d466e3-3b77-41fb-b1b1-7d71469f8d3e")
    @XmlEnumValue("BusinessInteraction")
    BUSINESS_INTERACTION("BusinessInteraction"),
    @objid ("36307f04-1684-4c76-b46a-919fff1c9004")
    @XmlEnumValue("BusinessEvent")
    BUSINESS_EVENT("BusinessEvent"),
    @objid ("42355686-4b14-4f5a-b58e-e6308d007e87")
    @XmlEnumValue("BusinessService")
    BUSINESS_SERVICE("BusinessService"),
    @objid ("685a111e-bb44-4f49-9fe9-15cc30e59227")
    @XmlEnumValue("BusinessObject")
    BUSINESS_OBJECT("BusinessObject"),
    @objid ("1acd0830-251a-41de-962f-5ab8c055107d")
    @XmlEnumValue("Contract")
    CONTRACT("Contract"),
    @objid ("cfbdfeb4-5c2f-474f-b424-08c162a81acd")
    @XmlEnumValue("Representation")
    REPRESENTATION("Representation"),
    @objid ("d9f98c4d-0f70-4391-97fa-ae2c83e99412")
    @XmlEnumValue("Product")
    PRODUCT("Product"),
    @objid ("908969e2-1923-48f0-909e-d862a8b89db6")
    @XmlEnumValue("ApplicationComponent")
    APPLICATION_COMPONENT("ApplicationComponent"),
    @objid ("1a0bcb38-14e8-4deb-93e0-710e471db5b7")
    @XmlEnumValue("ApplicationCollaboration")
    APPLICATION_COLLABORATION("ApplicationCollaboration"),
    @objid ("046dbf9d-8e5a-4b52-8f79-67e2ec91dd37")
    @XmlEnumValue("ApplicationInterface")
    APPLICATION_INTERFACE("ApplicationInterface"),
    @objid ("5e3e1a50-15e0-4beb-8e78-8c9621a832b5")
    @XmlEnumValue("ApplicationFunction")
    APPLICATION_FUNCTION("ApplicationFunction"),
    @objid ("bfec3f16-bdb1-4d0b-a770-44b332d11538")
    @XmlEnumValue("ApplicationInteraction")
    APPLICATION_INTERACTION("ApplicationInteraction"),
    @objid ("3f5dda28-dd25-4eb1-afdb-f664c2996845")
    @XmlEnumValue("ApplicationProcess")
    APPLICATION_PROCESS("ApplicationProcess"),
    @objid ("dba505c3-c233-481e-a3ee-feeaaced6026")
    @XmlEnumValue("ApplicationEvent")
    APPLICATION_EVENT("ApplicationEvent"),
    @objid ("582d5083-8604-417d-9985-39d220c03594")
    @XmlEnumValue("ApplicationService")
    APPLICATION_SERVICE("ApplicationService"),
    @objid ("4412b78e-853c-40f8-bb8e-61b615309817")
    @XmlEnumValue("DataObject")
    DATA_OBJECT("DataObject"),
    @objid ("7fe7fe66-6d67-4685-8095-2635d6247c21")
    @XmlEnumValue("Node")
    NODE("Node"),
    @objid ("2eaa57ce-cce3-451e-bd09-90f235730212")
    @XmlEnumValue("Device")
    DEVICE("Device"),
    @objid ("75cada3e-696a-451a-9526-19443b9df82d")
    @XmlEnumValue("SystemSoftware")
    SYSTEM_SOFTWARE("SystemSoftware"),
    @objid ("1385606b-2969-419b-8799-84e642a1046f")
    @XmlEnumValue("TechnologyCollaboration")
    TECHNOLOGY_COLLABORATION("TechnologyCollaboration"),
    @objid ("954bf1bc-f5e3-456e-9d24-7cdbdc238e03")
    @XmlEnumValue("TechnologyInterface")
    TECHNOLOGY_INTERFACE("TechnologyInterface"),
    @objid ("bdf730b7-23c5-48ea-b018-0594a0de110a")
    @XmlEnumValue("Path")
    PATH("Path"),
    @objid ("ded5418c-5d4f-4871-9d09-9d97036c7287")
    @XmlEnumValue("CommunicationNetwork")
    COMMUNICATION_NETWORK("CommunicationNetwork"),
    @objid ("0ec6377e-16fd-47d7-9764-46060ead3fd2")
    @XmlEnumValue("TechnologyFunction")
    TECHNOLOGY_FUNCTION("TechnologyFunction"),
    @objid ("0c8b58a5-7cee-4101-8bea-7dcc14c23347")
    @XmlEnumValue("TechnologyProcess")
    TECHNOLOGY_PROCESS("TechnologyProcess"),
    @objid ("5292d992-e2c4-48c2-a6c9-ce78281cbe0d")
    @XmlEnumValue("TechnologyInteraction")
    TECHNOLOGY_INTERACTION("TechnologyInteraction"),
    @objid ("e6b528c9-9433-4991-ba4f-e114edc95edb")
    @XmlEnumValue("TechnologyEvent")
    TECHNOLOGY_EVENT("TechnologyEvent"),
    @objid ("f983c577-2550-4e20-97d5-023411a4892b")
    @XmlEnumValue("TechnologyService")
    TECHNOLOGY_SERVICE("TechnologyService"),
    @objid ("e491adb2-3bbf-41c0-8c03-356c728ae6d0")
    @XmlEnumValue("Artifact")
    ARTIFACT("Artifact"),
    @objid ("93f01aa4-d3e8-4d25-b69a-fdb30af80584")
    @XmlEnumValue("Equipment")
    EQUIPMENT("Equipment"),
    @objid ("16a67c9c-5a5d-4abf-ba02-2e55bec4d0db")
    @XmlEnumValue("Facility")
    FACILITY("Facility"),
    @objid ("52c78908-dd8b-4eee-9154-3d8bb06ddbf6")
    @XmlEnumValue("DistributionNetwork")
    DISTRIBUTION_NETWORK("DistributionNetwork"),
    @objid ("50365bd1-1d9a-4247-84d9-2f5b8cdb5a79")
    @XmlEnumValue("Material")
    MATERIAL("Material"),
    @objid ("ade72822-8179-4d7f-a7f4-c0f206750460")
    @XmlEnumValue("Stakeholder")
    STAKEHOLDER("Stakeholder"),
    @objid ("75967723-b8f9-476e-b20c-f04edba92ad7")
    @XmlEnumValue("Driver")
    DRIVER("Driver"),
    @objid ("5fa3cf1f-5848-4d76-8a00-4c183277c16f")
    @XmlEnumValue("Assessment")
    ASSESSMENT("Assessment"),
    @objid ("638e9287-83fd-48f6-ae8c-547f2cb5d150")
    @XmlEnumValue("Goal")
    GOAL("Goal"),
    @objid ("2ea10f52-cffc-4218-a0e1-81074d303d19")
    @XmlEnumValue("Outcome")
    OUTCOME("Outcome"),
    @objid ("766c767d-b670-43cf-99cd-03dc9962190d")
    @XmlEnumValue("Principle")
    PRINCIPLE("Principle"),
    @objid ("504ffde7-ae27-406d-a595-6610961129fd")
    @XmlEnumValue("Requirement")
    REQUIREMENT("Requirement"),
    @objid ("f3ae757f-3d7f-4931-a683-59d41c510963")
    @XmlEnumValue("Constraint")
    CONSTRAINT("Constraint"),
    @objid ("28c9c1b1-c863-4022-8cb4-f0b92252be66")
    @XmlEnumValue("Meaning")
    MEANING("Meaning"),
    @objid ("e5ade8de-ff42-4d49-b7e3-7995947cea0a")
    @XmlEnumValue("Value")
    VALUE("Value"),
    @objid ("cd19a96f-730c-4ffd-ab9e-bcb5161de6da")
    @XmlEnumValue("Resource")
    RESOURCE("Resource"),
    @objid ("453621a9-b38f-4dd5-81cf-4c588ac01c19")
    @XmlEnumValue("Capability")
    CAPABILITY("Capability"),
    @objid ("6fa30c91-2ec2-4828-8293-0d42fc1ac7be")
    @XmlEnumValue("CourseOfAction")
    COURSE_OF_ACTION("CourseOfAction"),
    @objid ("4b993df7-5b8c-42d1-87a1-3b8e820467c5")
    @XmlEnumValue("ValueStream")
    VALUE_STREAM("ValueStream"),
    @objid ("93af377b-8baf-4d73-afae-4732e649c028")
    @XmlEnumValue("WorkPackage")
    WORK_PACKAGE("WorkPackage"),
    @objid ("a9d84aee-66b0-441a-b750-d37396a90b04")
    @XmlEnumValue("Deliverable")
    DELIVERABLE("Deliverable"),
    @objid ("9428f9f6-8580-4f83-95b2-2ca76e6f32f3")
    @XmlEnumValue("ImplementationEvent")
    IMPLEMENTATION_EVENT("ImplementationEvent"),
    @objid ("3a9e80cb-7bf8-435b-b2bb-2ca1f5f76cee")
    @XmlEnumValue("Plateau")
    PLATEAU("Plateau"),
    @objid ("ed89cf7a-842e-432d-ba9e-260c3aed6183")
    @XmlEnumValue("Gap")
    GAP("Gap"),
    @objid ("273a0b51-eb5e-405a-9431-d30d1ef481e6")
    @XmlEnumValue("Grouping")
    GROUPING("Grouping"),
    @objid ("73d453ba-1ba1-45b3-861a-38593182a926")
    @XmlEnumValue("Location")
    LOCATION("Location"),
    @objid ("09fb341b-f63e-4c72-9d3b-376508c4cf9f")
    @XmlEnumValue("AndJunction")
    AND_JUNCTION("AndJunction"),
    @objid ("2564def4-f5e4-419e-892f-2555673f85ad")
    @XmlEnumValue("OrJunction")
    OR_JUNCTION("OrJunction");

    @objid ("3c70a532-190a-4985-8e74-375e930e0414")
    private final String value;

    @objid ("73921676-649b-4d98-a929-f2e384c13807")
    ElementTypeEnum(String v) {
        value = v;
    }

    @objid ("d366b0aa-db45-4eac-9c9d-f913ac97d6fc")
    public String value() {
        return value;
    }

    @objid ("c5abf665-3df0-4ac8-ac56-feb18bd17449")
    public static ElementTypeEnum fromValue(String v) {
        for (ElementTypeEnum c: ElementTypeEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);

    }

}

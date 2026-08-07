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
 * <p>Classe Java pour ViewpointsEnum.
 *
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;simpleType name="ViewpointsEnum">
 * &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 * &lt;enumeration value="Organization"/>
 * &lt;enumeration value="Application Platform"/>
 * &lt;enumeration value="Information Structure"/>
 * &lt;enumeration value="Technology"/>
 * &lt;enumeration value="Layered"/>
 * &lt;enumeration value="Physical"/>
 * &lt;enumeration value="Product"/>
 * &lt;enumeration value="Application Usage"/>
 * &lt;enumeration value="Technology Usage"/>
 * &lt;enumeration value="Business Process Cooperation"/>
 * &lt;enumeration value="Application Cooperation"/>
 * &lt;enumeration value="Service Realization"/>
 * &lt;enumeration value="Implementation and Deployment"/>
 * &lt;enumeration value="Goal Realization"/>
 * &lt;enumeration value="Goal Contribution"/>
 * &lt;enumeration value="Principles"/>
 * &lt;enumeration value="Requirements Realization"/>
 * &lt;enumeration value="Motivation"/>
 * &lt;enumeration value="Strategy"/>
 * &lt;enumeration value="Capability Map"/>
 * &lt;enumeration value="Outcome Realization"/>
 * &lt;enumeration value="Resource Map"/>
 * &lt;enumeration value="Value Stream"/>
 * &lt;enumeration value="Project"/>
 * &lt;enumeration value="Migration"/>
 * &lt;enumeration value="Implementation and Migration"/>
 * &lt;enumeration value="Stakeholder"/>
 * &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 */
@objid ("45b6c1e4-e2dc-4400-9f50-e142dde95122")
@XmlType(name = "ViewpointsEnum")
@XmlEnum
public enum ViewpointsEnum {
    @objid ("bc796c48-c73e-4dee-bfe0-a517f55e6a70")
    @XmlEnumValue("Organization")
    ORGANIZATION("Organization"),
    @objid ("dab1c465-37af-473e-a463-47a0191c8fe3")
    @XmlEnumValue("Application Platform")
    APPLICATION_PLATFORM("Application Platform"),
    @objid ("d8b5cd16-c417-4f0b-b8a8-d41814c9a88f")
    @XmlEnumValue("Information Structure")
    INFORMATION_STRUCTURE("Information Structure"),
    @objid ("7fa4cd1a-2874-46c1-9764-6a13f2d68ea2")
    @XmlEnumValue("Technology")
    TECHNOLOGY("Technology"),
    @objid ("c3b0810f-b0d5-456e-a220-462c24b4d0f1")
    @XmlEnumValue("Layered")
    LAYERED("Layered"),
    @objid ("829f678f-bfb3-4ca1-aa43-73a10d1b9f4d")
    @XmlEnumValue("Physical")
    PHYSICAL("Physical"),
    @objid ("3880c57c-b84b-4fca-9e5e-275ff5c0ee4f")
    @XmlEnumValue("Product")
    PRODUCT("Product"),
    @objid ("5c9fdc39-73c7-476e-a2a6-03639778889c")
    @XmlEnumValue("Application Usage")
    APPLICATION_USAGE("Application Usage"),
    @objid ("9521cab4-7746-4516-8670-677fb77cf4fc")
    @XmlEnumValue("Technology Usage")
    TECHNOLOGY_USAGE("Technology Usage"),
    @objid ("919a6ff5-5d1d-4b29-a603-49e6162ef273")
    @XmlEnumValue("Business Process Cooperation")
    BUSINESS_PROCESS_COOPERATION("Business Process Cooperation"),
    @objid ("f72ee9c7-aeb3-4eea-a538-65d92ea5e433")
    @XmlEnumValue("Application Cooperation")
    APPLICATION_COOPERATION("Application Cooperation"),
    @objid ("2e6b661d-c522-4acc-baf9-5ca55a2f17cb")
    @XmlEnumValue("Service Realization")
    SERVICE_REALIZATION("Service Realization"),
    @objid ("3d24e49c-5228-49f8-8aeb-adbc6f44c92e")
    @XmlEnumValue("Implementation and Deployment")
    IMPLEMENTATION_AND_DEPLOYMENT("Implementation and Deployment"),
    @objid ("1d3a736d-6b57-47be-be5f-5c27be5576ce")
    @XmlEnumValue("Goal Realization")
    GOAL_REALIZATION("Goal Realization"),
    @objid ("e759381e-62ab-4458-ba74-9b1cd0287960")
    @XmlEnumValue("Goal Contribution")
    GOAL_CONTRIBUTION("Goal Contribution"),
    @objid ("c5e7849d-2321-45dc-8c50-5e666026cb2e")
    @XmlEnumValue("Principles")
    PRINCIPLES("Principles"),
    @objid ("a1e14874-5fc6-4d5e-9a5f-3cdda4bacec1")
    @XmlEnumValue("Requirements Realization")
    REQUIREMENTS_REALIZATION("Requirements Realization"),
    @objid ("3d9e8505-e237-4aab-8daf-61c7ac830893")
    @XmlEnumValue("Motivation")
    MOTIVATION("Motivation"),
    @objid ("c2d4058a-cf57-4800-bb73-0f59f73fb63a")
    @XmlEnumValue("Strategy")
    STRATEGY("Strategy"),
    @objid ("85d49dbc-c944-4d07-8c70-7a58bffd3762")
    @XmlEnumValue("Capability Map")
    CAPABILITY_MAP("Capability Map"),
    @objid ("a14b07bb-5456-4884-85e5-f61f2eb3613c")
    @XmlEnumValue("Outcome Realization")
    OUTCOME_REALIZATION("Outcome Realization"),
    @objid ("e18d486c-5824-4b7f-9df7-6c9b2c659ad6")
    @XmlEnumValue("Resource Map")
    RESOURCE_MAP("Resource Map"),
    @objid ("c278744e-7a84-4a6f-98eb-f325983de108")
    @XmlEnumValue("Value Stream")
    VALUE_STREAM("Value Stream"),
    @objid ("05268de0-9212-4e2a-a5cf-c387c6c3c01a")
    @XmlEnumValue("Project")
    PROJECT("Project"),
    @objid ("17ea1f79-8448-451c-994b-37710d0eb3d7")
    @XmlEnumValue("Migration")
    MIGRATION("Migration"),
    @objid ("ba599983-c7af-4e5e-a667-cce1cfd9a2ad")
    @XmlEnumValue("Implementation and Migration")
    IMPLEMENTATION_AND_MIGRATION("Implementation and Migration"),
    @objid ("a276272c-46fe-48df-85a5-a249cea90c43")
    @XmlEnumValue("Stakeholder")
    STAKEHOLDER("Stakeholder");

    @objid ("f81eb70d-56c0-4a61-b670-432f0a05cff6")
    private final String value;

    @objid ("c4081f7b-189e-4837-afe4-23408f6ebf2b")
    ViewpointsEnum(String v) {
        value = v;
    }

    @objid ("da342e73-4293-482c-bd92-e2b76d75c3c6")
    public String value() {
        return value;
    }

    @objid ("6098855b-4e8a-4afc-9c86-6524a3bb2ecf")
    public static ViewpointsEnum fromValue(String v) {
        for (ViewpointsEnum c: ViewpointsEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);

    }

}

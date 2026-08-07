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

import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;

/**
 * This is a container for all of the Nodes and Connections in the Diagrams.
 *
 *
 * <p>Classe Java pour Diagram complex type.
 *
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 *
 * <pre>
 * &lt;complexType name="Diagram">
 * &lt;complexContent>
 * &lt;extension base="{http://www.opengroup.org/xsd/archimate/3.0/}ViewType">
 * &lt;sequence>
 * &lt;element name="node" type="{http://www.opengroup.org/xsd/archimate/3.0/}ViewNodeType" maxOccurs="unbounded" minOccurs="0"/>
 * &lt;element name="connection" type="{http://www.opengroup.org/xsd/archimate/3.0/}ConnectionType" maxOccurs="unbounded" minOccurs="0"/>
 * &lt;/sequence>
 * &lt;anyAttribute namespace='##other'/>
 * &lt;/extension>
 * &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@objid ("9b04d5ef-475c-44cc-b020-02515bda5bb4")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Diagram", propOrder = {
    "node",
    "connection"
})
public class Diagram extends ViewType {
    @objid ("278dc438-1ba3-44e0-bbac-746de508342d")
    protected List<ViewNodeType> node;

    @objid ("d48c3e62-f6ef-489f-9c51-042e2bb5381e")
    protected List<ConnectionType> connection;

    /**
     * Gets the value of the node property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the node property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     * getNode().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ViewNodeType }
     */
    @objid ("913a9b9d-be96-4ff4-88e5-3ea140b5ec66")
    public List<ViewNodeType> getNode() {
        if (node == null) {
            node = new ArrayList<ViewNodeType>();
        }
        return this.node;
    }

    /**
     * Gets the value of the connection property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the connection property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     * getConnection().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ConnectionType }
     */
    @objid ("5340679b-5190-4638-8356-30aed6c7bb3d")
    public List<ConnectionType> getConnection() {
        if (connection == null) {
            connection = new ArrayList<ConnectionType>();
        }
        return this.connection;
    }

}

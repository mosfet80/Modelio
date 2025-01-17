/* 
 * Copyright 2013-2020 Modeliosoft
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
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2015.12.02 at 02:29:48 PM CET
//
package org.modelio.bpmnxml.model;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;

/**
 * <p>Java class for tGlobalBusinessRuleTask complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tGlobalBusinessRuleTask">
 * &lt;complexContent>
 * &lt;extension base="{http://www.omg.org/spec/BPMN/20100524/MODEL}tGlobalTask">
 * &lt;attribute name="implementation" type="{http://www.omg.org/spec/BPMN/20100524/MODEL}tImplementation" default="##unspecified" />
 * &lt;anyAttribute processContents='lax' namespace='##other'/>
 * &lt;/extension>
 * &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@objid ("840bb83b-f929-448d-8157-9a52dcfeae99")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tGlobalBusinessRuleTask")
public class TGlobalBusinessRuleTask extends TGlobalTask {
    @objid ("53fc7abe-0812-4f64-be4a-9a429678b163")
    @XmlAttribute(name = "implementation")
    protected String implementation;

    /**
     * Gets the value of the implementation property.
     * @return
     * possible object is
     * {@link String }
     */
    @objid ("73c7efdc-63d0-4e91-a667-548b6cc0fec3")
    public String getImplementation() {
        if (this.implementation == null) {
            return "##unspecified";
        } else {
            return this.implementation;
        }
        
    }

    /**
     * Sets the value of the implementation property.
     * @param value allowed object is
     * {@link String }
     */
    @objid ("a85bdff7-c793-4fdc-ac98-7c5597924d02")
    public void setImplementation(String value) {
        this.implementation = value;
    }

}

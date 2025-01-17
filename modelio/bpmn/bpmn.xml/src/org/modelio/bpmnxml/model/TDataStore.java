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

import java.math.BigInteger;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;

/**
 * <p>Java class for tDataStore complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tDataStore">
 * &lt;complexContent>
 * &lt;extension base="{http://www.omg.org/spec/BPMN/20100524/MODEL}tRootElement">
 * &lt;sequence>
 * &lt;element ref="{http://www.omg.org/spec/BPMN/20100524/MODEL}dataState" minOccurs="0"/>
 * &lt;/sequence>
 * &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 * &lt;attribute name="capacity" type="{http://www.w3.org/2001/XMLSchema}integer" />
 * &lt;attribute name="isUnlimited" type="{http://www.w3.org/2001/XMLSchema}boolean" default="true" />
 * &lt;attribute name="itemSubjectRef" type="{http://www.w3.org/2001/XMLSchema}QName" />
 * &lt;anyAttribute processContents='lax' namespace='##other'/>
 * &lt;/extension>
 * &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@objid ("e99d2787-348b-43d2-93cd-4374dea0bbe0")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tDataStore", propOrder = {
    "dataState"
})
public class TDataStore extends TRootElement {
    @objid ("d9ef2613-ab0e-40de-8d8a-be2b3c5018dc")
    @XmlAttribute(name = "name")
    protected String name;

    @objid ("83832959-ebfc-40f4-9eb8-e03547937435")
    @XmlAttribute(name = "isUnlimited")
    protected Boolean isUnlimited;

    @objid ("31900187-744b-45b9-bba4-ebee85d3a4fc")
    protected TDataState dataState;

    @objid ("2aac912a-fe78-47eb-8a08-5ecbc5b8840f")
    @XmlAttribute(name = "capacity")
    protected BigInteger capacity;

    @objid ("91543d5d-6dfd-429c-a94a-343cd2b05aa9")
    @XmlAttribute(name = "itemSubjectRef")
    protected QName itemSubjectRef;

    /**
     * Gets the value of the dataState property.
     * @return
     * possible object is
     * {@link TDataState }
     */
    @objid ("3a557c67-62ec-470e-b496-f2b7e3b14860")
    public TDataState getDataState() {
        return this.dataState;
    }

    /**
     * Sets the value of the dataState property.
     * @param value allowed object is
     * {@link TDataState }
     */
    @objid ("be60acd2-b365-4473-b1d4-74ca646f249e")
    public void setDataState(TDataState value) {
        this.dataState = value;
    }

    /**
     * Gets the value of the name property.
     * @return
     * possible object is
     * {@link String }
     */
    @objid ("91185559-212b-42a8-97d3-1cc3990e0a0c")
    public String getName() {
        return this.name;
    }

    /**
     * Sets the value of the name property.
     * @param value allowed object is
     * {@link String }
     */
    @objid ("114fad78-da95-49da-803c-a79837383d9e")
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the capacity property.
     * @return
     * possible object is
     * {@link BigInteger }
     */
    @objid ("6be4fd3f-e496-4389-8639-8becdcfaa25f")
    public BigInteger getCapacity() {
        return this.capacity;
    }

    /**
     * Sets the value of the capacity property.
     * @param value allowed object is
     * {@link BigInteger }
     */
    @objid ("dfddeb20-3a2e-46db-8211-aa21e70dede1")
    public void setCapacity(BigInteger value) {
        this.capacity = value;
    }

    /**
     * Gets the value of the isUnlimited property.
     * @return
     * possible object is
     * {@link Boolean }
     */
    @objid ("6ca7b73e-62eb-44ec-9819-24f66ebfe728")
    public boolean isIsUnlimited() {
        if (this.isUnlimited == null) {
            return true;
        } else {
            return this.isUnlimited;
        }
        
    }

    /**
     * Sets the value of the isUnlimited property.
     * @param value allowed object is
     * {@link Boolean }
     */
    @objid ("235f611e-3221-4341-9aed-9ff7ce85f132")
    public void setIsUnlimited(Boolean value) {
        this.isUnlimited = value;
    }

    /**
     * Gets the value of the itemSubjectRef property.
     * @return
     * possible object is
     * {@link QName }
     */
    @objid ("f5fd5ac0-8074-4724-8c69-4e9d5f68c610")
    public QName getItemSubjectRef() {
        return this.itemSubjectRef;
    }

    /**
     * Sets the value of the itemSubjectRef property.
     * @param value allowed object is
     * {@link QName }
     */
    @objid ("ca51af46-58c7-4a87-ac6b-49163e6fdd30")
    public void setItemSubjectRef(QName value) {
        this.itemSubjectRef = value;
    }

}

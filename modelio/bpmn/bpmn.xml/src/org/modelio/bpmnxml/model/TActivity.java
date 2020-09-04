/* 
 * Copyright 2013-2019 Modeliosoft
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
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

/**
 * <p>Java class for tActivity complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tActivity">
 * &lt;complexContent>
 * &lt;extension base="{http://www.omg.org/spec/BPMN/20100524/MODEL}tFlowNode">
 * &lt;sequence>
 * &lt;element ref="{http://www.omg.org/spec/BPMN/20100524/MODEL}ioSpecification" minOccurs="0"/>
 * &lt;element ref="{http://www.omg.org/spec/BPMN/20100524/MODEL}property" maxOccurs="unbounded" minOccurs="0"/>
 * &lt;element ref="{http://www.omg.org/spec/BPMN/20100524/MODEL}dataInputAssociation" maxOccurs="unbounded" minOccurs="0"/>
 * &lt;element ref="{http://www.omg.org/spec/BPMN/20100524/MODEL}dataOutputAssociation" maxOccurs="unbounded" minOccurs="0"/>
 * &lt;element ref="{http://www.omg.org/spec/BPMN/20100524/MODEL}resourceRole" maxOccurs="unbounded" minOccurs="0"/>
 * &lt;element ref="{http://www.omg.org/spec/BPMN/20100524/MODEL}loopCharacteristics" minOccurs="0"/>
 * &lt;/sequence>
 * &lt;attribute name="isForCompensation" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 * &lt;attribute name="startQuantity" type="{http://www.w3.org/2001/XMLSchema}integer" default="1" />
 * &lt;attribute name="completionQuantity" type="{http://www.w3.org/2001/XMLSchema}integer" default="1" />
 * &lt;attribute name="default" type="{http://www.w3.org/2001/XMLSchema}IDREF" />
 * &lt;anyAttribute processContents='lax' namespace='##other'/>
 * &lt;/extension>
 * &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@objid ("9c9c3ffb-3b9e-4353-873e-aedb537d803e")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tActivity", propOrder = {
    "ioSpecification",
    "property",
    "dataInputAssociation",
    "dataOutputAssociation",
    "resourceRole",
    "loopCharacteristics"
})
@XmlSeeAlso({
    TSubProcess.class,
    TCallActivity.class,
    TTask.class
})
public abstract class TActivity extends TFlowNode {
    @objid ("ea21102e-ce48-4f24-ba9c-58d7ce7f1af6")
    @XmlAttribute(name = "isForCompensation")
    protected Boolean isForCompensation;

    @objid ("c9dfa5cd-6cca-4dd3-9895-207b93434603")
    protected TInputOutputSpecification ioSpecification;

    @objid ("b70f50df-a7fd-4995-88cd-ee98a0406b6c")
    protected List<TProperty> property;

    @objid ("7ee7d3ae-ae99-47c3-8dd2-d16aa11a54ea")
    protected List<TDataInputAssociation> dataInputAssociation;

    @objid ("e0e918b1-e26b-4437-8433-3a6a082a3398")
    protected List<TDataOutputAssociation> dataOutputAssociation;

    @objid ("5b73e9d2-8d2b-4ff8-bc90-f2c5884019e0")
    @XmlElementRef(name = "resourceRole", namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", type = JAXBElement.class, required = false)
    protected List<JAXBElement<? extends TResourceRole>> resourceRole;

    @objid ("bf006218-22dd-4880-a09d-1061e2ba904f")
    @XmlElementRef(name = "loopCharacteristics", namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", type = JAXBElement.class, required = false)
    protected JAXBElement<? extends TLoopCharacteristics> loopCharacteristics;

    @objid ("63807183-e09d-4d2d-84a0-1c0ae010bab6")
    @XmlAttribute(name = "startQuantity")
    protected BigInteger startQuantity;

    @objid ("7777ce0d-85d4-47df-987f-7320f24ba2bc")
    @XmlAttribute(name = "completionQuantity")
    protected BigInteger completionQuantity;

    @objid ("b9c8e936-f039-4e93-9453-883b2c381b6b")
    @XmlAttribute(name = "default")
    @XmlIDREF
    @XmlSchemaType(name = "IDREF")
    protected Object _default;

    /**
     * Gets the value of the ioSpecification property.
     * @return
     * possible object is
     * {@link TInputOutputSpecification }
     */
    @objid ("6c07eac2-deee-4564-8317-d53978611912")
    public TInputOutputSpecification getIoSpecification() {
        return this.ioSpecification;
    }

    /**
     * Sets the value of the ioSpecification property.
     * 
     * @param value allowed object is
     * {@link TInputOutputSpecification }
     */
    @objid ("8f9c5a3a-a3c3-40d6-bf2b-f81b26a9600a")
    public void setIoSpecification(TInputOutputSpecification value) {
        this.ioSpecification = value;
    }

    /**
     * Gets the value of the property property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the property property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     * getProperty().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TProperty }
     */
    @objid ("52c73197-6690-48e9-afb5-8a480db5ebdc")
    public List<TProperty> getProperty() {
        if (this.property == null) {
            this.property = new ArrayList<>();
        }
        return this.property;
    }

    /**
     * Gets the value of the dataInputAssociation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dataInputAssociation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     * getDataInputAssociation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TDataInputAssociation }
     */
    @objid ("ae5f351e-af13-404a-84da-dc8249606b69")
    public List<TDataInputAssociation> getDataInputAssociation() {
        if (this.dataInputAssociation == null) {
            this.dataInputAssociation = new ArrayList<>();
        }
        return this.dataInputAssociation;
    }

    /**
     * Gets the value of the dataOutputAssociation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dataOutputAssociation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     * getDataOutputAssociation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TDataOutputAssociation }
     */
    @objid ("3f40e339-e853-4679-bfbf-23f01ee593a8")
    public List<TDataOutputAssociation> getDataOutputAssociation() {
        if (this.dataOutputAssociation == null) {
            this.dataOutputAssociation = new ArrayList<>();
        }
        return this.dataOutputAssociation;
    }

    /**
     * Gets the value of the resourceRole property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the resourceRole property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     * getResourceRole().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link TResourceRole }{@code >}
     * {@link JAXBElement }{@code <}{@link THumanPerformer }{@code >}
     * {@link JAXBElement }{@code <}{@link TPerformer }{@code >}
     * {@link JAXBElement }{@code <}{@link TPotentialOwner }{@code >}
     */
    @objid ("89f74291-8264-4769-a987-602b6699e058")
    public List<JAXBElement<? extends TResourceRole>> getResourceRole() {
        if (this.resourceRole == null) {
            this.resourceRole = new ArrayList<>();
        }
        return this.resourceRole;
    }

    /**
     * Gets the value of the loopCharacteristics property.
     * @return
     * possible object is
     * {@link JAXBElement }{@code <}{@link TStandardLoopCharacteristics }{@code >}
     * {@link JAXBElement }{@code <}{@link TMultiInstanceLoopCharacteristics }{@code >}
     * {@link JAXBElement }{@code <}{@link TLoopCharacteristics }{@code >}
     */
    @objid ("89a328d3-e8f7-4fba-8314-91c46a94bab0")
    public JAXBElement<? extends TLoopCharacteristics> getLoopCharacteristics() {
        return this.loopCharacteristics;
    }

    /**
     * Sets the value of the loopCharacteristics property.
     * 
     * @param value allowed object is
     * {@link JAXBElement }{@code <}{@link TStandardLoopCharacteristics }{@code >}
     * {@link JAXBElement }{@code <}{@link TMultiInstanceLoopCharacteristics }{@code >}
     * {@link JAXBElement }{@code <}{@link TLoopCharacteristics }{@code >}
     */
    @objid ("f3fddde1-530a-480c-9da8-a91dba8d0cc8")
    public void setLoopCharacteristics(JAXBElement<? extends TLoopCharacteristics> value) {
        this.loopCharacteristics = value;
    }

    /**
     * Gets the value of the isForCompensation property.
     * @return
     * possible object is
     * {@link Boolean }
     */
    @objid ("a96ce716-c318-443e-b7b5-8648169519a2")
    public boolean isIsForCompensation() {
        if (this.isForCompensation == null) {
            return false;
        } else {
            return this.isForCompensation;
        }
    }

    /**
     * Sets the value of the isForCompensation property.
     * 
     * @param value allowed object is
     * {@link Boolean }
     */
    @objid ("5b40d05b-51f7-42e4-8c51-ad39384aba64")
    public void setIsForCompensation(Boolean value) {
        this.isForCompensation = value;
    }

    /**
     * Gets the value of the startQuantity property.
     * @return
     * possible object is
     * {@link BigInteger }
     */
    @objid ("2a239a20-f174-42a6-9c6a-7c543aa4b369")
    public BigInteger getStartQuantity() {
        if (this.startQuantity == null) {
            return new BigInteger("1");
        } else {
            return this.startQuantity;
        }
    }

    /**
     * Sets the value of the startQuantity property.
     * 
     * @param value allowed object is
     * {@link BigInteger }
     */
    @objid ("46c221fa-a9ed-4675-989d-9643a0a493c1")
    public void setStartQuantity(BigInteger value) {
        this.startQuantity = value;
    }

    /**
     * Gets the value of the completionQuantity property.
     * @return
     * possible object is
     * {@link BigInteger }
     */
    @objid ("c87fbd46-9f22-42a7-98bc-db11b63598ac")
    public BigInteger getCompletionQuantity() {
        if (this.completionQuantity == null) {
            return new BigInteger("1");
        } else {
            return this.completionQuantity;
        }
    }

    /**
     * Sets the value of the completionQuantity property.
     * 
     * @param value allowed object is
     * {@link BigInteger }
     */
    @objid ("2e4a2942-77f0-4fa3-8d30-58948be63833")
    public void setCompletionQuantity(BigInteger value) {
        this.completionQuantity = value;
    }

    /**
     * Gets the value of the default property.
     * @return
     * possible object is
     * {@link Object }
     */
    @objid ("7021e389-af1b-4e40-988e-bc357ca478e2")
    public Object getDefault() {
        return this._default;
    }

    /**
     * Sets the value of the default property.
     * 
     * @param value allowed object is
     * {@link Object }
     */
    @objid ("86833d81-4436-43c3-bc01-4435e0c7583f")
    public void setDefault(Object value) {
        this._default = value;
    }

}
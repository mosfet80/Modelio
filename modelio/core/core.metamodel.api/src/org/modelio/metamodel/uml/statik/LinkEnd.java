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
/* WARNING: GENERATED FILE -  DO NOT EDIT
     Metamodel: Standard, version 2.3.00, by Modeliosoft
     Generator version: 3.14.00
     Generated on: Aug 7, 2024
*/
package org.modelio.metamodel.uml.statik;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.uml.informationFlow.InformationFlow;
import org.modelio.metamodel.uml.infrastructure.UmlModelElement;

/**
 * LinkEnd v0.0.9054
 *
 *
 * A LinkEnd is the part of a Link that connects to an Instance. It corresponds to an AssociationEnd of an Association.
 *
 * In UML 2.0, LinkEnds are implemented as slots.
 *
 * A LinkEnd belongs to a Link.
 *
 */
@objid ("000fb1bc-c4bf-1fd8-97fe-001ec947cd2a")
public interface LinkEnd extends UmlModelElement {
    /**
     * The metaclass simple name.
     */
    @objid ("86d57bd8-8dab-45be-af3b-93d127176f83")
    public static final String MNAME = "LinkEnd";

    /**
     * The metaclass qualified name.
     */
    @objid ("83191131-325f-4ee5-a282-742df655fc23")
    public static final String MQNAME = "Standard.LinkEnd";

    /**
     * Get the 'graphical owner' related to this end.
     * The owner is the current source or the opposite end's target according to the navigability.
     */
    @objid ("8b942215-f0a1-454e-9f8a-596315ee40d5")
    abstract Instance getOwner();

    @objid ("006058b0-2963-1080-943a-001ec947cd2a")
    abstract void setTarget(final Instance value, final boolean fixModel);

    @objid ("006059f0-2963-1080-943a-001ec947cd2a")
    abstract void setSource(final Instance value, final boolean fixModel);

    /**
     * Sets both ends sources and targets according to the given navigability.
     * <ul>
     * <li>THISSIDE: only current source and target must be filled.</li>
     * <li>OHERSIDE: only opposite source and target must be filled.</li>
     * <li>BOTHSIDES: current source must be equals to opposite target as well as current target and opposite source.</li>
     * <li>NONE: both sources must be filled, but no target</li>
     * </ul>
     *
     * @param value whether or not to synchronize the other end and both source/target values. This end will be made navigable whatever the current navigability is.
     */
    @objid ("50d3075c-1fcb-4a03-a648-16729171986f")
    abstract void setNavigable(boolean value);

    @objid ("6d12e031-ad22-449a-9171-6a88d4158b48")
    abstract boolean isNavigable();

    /**
     * Getter for attribute 'LinkEnd.IsOrdered'
     *
     * Metamodel description:
     * <i>Determines if this LinkEnd is ordered.</i>
     */
    @objid ("96cbb2f5-b076-42c7-a46a-615ae44e5744")
    boolean isIsOrdered();

    /**
     * Setter for attribute 'LinkEnd.IsOrdered'
     *
     * Metamodel description:
     * <i>Determines if this LinkEnd is ordered.</i>
     */
    @objid ("14651a9e-4de4-477a-a910-060d9b9c2a37")
    void setIsOrdered(boolean value);

    /**
     * Getter for attribute 'LinkEnd.IsUnique'
     *
     * Metamodel description:
     * <i>Determines if this LinkEnd is unique.</i>
     */
    @objid ("d7c1df77-489c-46ba-ad2c-a3b3a37c2a7e")
    boolean isIsUnique();

    /**
     * Setter for attribute 'LinkEnd.IsUnique'
     *
     * Metamodel description:
     * <i>Determines if this LinkEnd is unique.</i>
     */
    @objid ("9e313f38-6075-426e-b83e-db00e03e7858")
    void setIsUnique(boolean value);

    /**
     * Getter for attribute 'LinkEnd.MultiplicityMax'
     *
     * Metamodel description:
     * <i>Maximum value of the Link's multiplicity.</i>
     */
    @objid ("9909dc52-341c-4717-bae3-c4e07d778fb8")
    String getMultiplicityMax();

    /**
     * Setter for attribute 'LinkEnd.MultiplicityMax'
     *
     * Metamodel description:
     * <i>Maximum value of the Link's multiplicity.</i>
     */
    @objid ("0d6c1863-af59-4f39-ba02-40d396e258ca")
    void setMultiplicityMax(String value);

    /**
     * Getter for attribute 'LinkEnd.MultiplicityMin'
     *
     * Metamodel description:
     * <i>Minimum value of the Link's multiplicity. When placed on a target end, the multiplicity specifies the number of target instances that may be associated with a single source instance across the given Link.</i>
     */
    @objid ("614de2d6-d2bc-4be5-85a7-b4c008661776")
    String getMultiplicityMin();

    /**
     * Setter for attribute 'LinkEnd.MultiplicityMin'
     *
     * Metamodel description:
     * <i>Minimum value of the Link's multiplicity. When placed on a target end, the multiplicity specifies the number of target instances that may be associated with a single source instance across the given Link.</i>
     */
    @objid ("9b5d7609-1481-4b18-b022-1ab307fd83a8")
    void setMultiplicityMin(String value);

    /**
     * Getter for relation 'LinkEnd->Link'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("9af1dcc9-b37c-4ae6-b262-223865836d40")
    Link getLink();

    /**
     * Setter for relation 'LinkEnd->Link'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("6bcbbb71-0809-42f9-a875-d664d1ae1fcc")
    void setLink(Link value);

    /**
     * Getter for relation 'LinkEnd->Target'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("4410efb5-e7f6-450e-8537-bc821c8b93f1")
    Instance getTarget();

    /**
     * Setter for relation 'LinkEnd->Target'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("fff237fd-8a13-41a4-bc60-f98e421a1fbd")
    void setTarget(Instance value);

    /**
     * Getter for relation 'LinkEnd->OppositeOwner'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("71964405-33ac-4e52-acf5-2a9c6cce1fc5")
    LinkEnd getOppositeOwner();

    /**
     * Setter for relation 'LinkEnd->OppositeOwner'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("a86dcaa6-929c-4aa1-9c61-a21248d0aace")
    void setOppositeOwner(LinkEnd value);

    /**
     * Getter for relation 'LinkEnd->RealizedInformationFlow'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("ff851c7d-ad95-4e9f-915e-56242f6e8e92")
    EList<InformationFlow> getRealizedInformationFlow();

    /**
     * Filtered Getter for relation 'LinkEnd->RealizedInformationFlow'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("d8059776-bef1-422d-b3e8-13317307cd03")
    <T extends InformationFlow> List<T> getRealizedInformationFlow(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'LinkEnd->Model'
     *
     * Metamodel description:
     * <i>The LinkEnd is an occurrence of this AssociationEnd.</i>
     */
    @objid ("363b9587-e8a9-46ef-bbb6-3dc567308019")
    AssociationEnd getModel();

    /**
     * Setter for relation 'LinkEnd->Model'
     *
     * Metamodel description:
     * <i>The LinkEnd is an occurrence of this AssociationEnd.</i>
     */
    @objid ("35d58c0d-623f-4d10-a8eb-eb2c57e3062b")
    void setModel(AssociationEnd value);

    /**
     * Getter for relation 'LinkEnd->Consumer'
     *
     * Metamodel description:
     * <i>Used for Connectors between Ports to designate the RequiredInterface(s) set the LinkEnd is connected to.</i>
     */
    @objid ("8f0291db-57bb-4aaa-806e-83ebb3519e4d")
    RequiredInterface getConsumer();

    /**
     * Setter for relation 'LinkEnd->Consumer'
     *
     * Metamodel description:
     * <i>Used for Connectors between Ports to designate the RequiredInterface(s) set the LinkEnd is connected to.</i>
     */
    @objid ("bf7b6291-c2fb-4f0e-8ae8-583eedca9a29")
    void setConsumer(RequiredInterface value);

    /**
     * Getter for relation 'LinkEnd->Opposite'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("d6fb57f1-9912-4aaa-bf98-2396f82e4c3a")
    LinkEnd getOpposite();

    /**
     * Setter for relation 'LinkEnd->Opposite'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("cd2f2ae0-97dc-4219-845a-11a4df80a469")
    void setOpposite(LinkEnd value);

    /**
     * Getter for relation 'LinkEnd->Source'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("46ae5843-57e7-42cc-b5c2-6bf5f421a576")
    Instance getSource();

    /**
     * Setter for relation 'LinkEnd->Source'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("1dbb998d-945e-4f75-94dd-72ad8a040d25")
    void setSource(Instance value);

    /**
     * Getter for relation 'LinkEnd->Provider'
     *
     * Metamodel description:
     * <i>Used for Connectors between Ports to designate the ProvidedInterface(s) set the LinkEnd is connected to.</i>
     */
    @objid ("3a34e34c-d294-4931-8e98-d52d42555446")
    ProvidedInterface getProvider();

    /**
     * Setter for relation 'LinkEnd->Provider'
     *
     * Metamodel description:
     * <i>Used for Connectors between Ports to designate the ProvidedInterface(s) set the LinkEnd is connected to.</i>
     */
    @objid ("c4af5f2e-e173-4686-84f0-5b20bfeebfed")
    void setProvider(ProvidedInterface value);

}

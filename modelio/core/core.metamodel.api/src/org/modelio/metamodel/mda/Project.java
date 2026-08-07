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
package org.modelio.metamodel.mda;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.uml.infrastructure.AbstractProject;
import org.modelio.metamodel.uml.statik.Package;

/**
 * Project v1.1.1
 *
 *
 * <p>A project in Modelio corresponds to the UML Model concept. A Project in Modelio has a root Package, and in addition a specific configuration, detailing deployed MDACs, MDAC parameter values, and so on. A Project does not belong to any other element.</p>
 *
 *
 */
@objid ("006602e2-c4bf-1fd8-97fe-001ec947cd2a")
public interface Project extends AbstractProject {
    /**
     * The metaclass simple name.
     */
    @objid ("5bb864ad-1253-4bf5-9b86-b1f325dba7b5")
    public static final String MNAME = "Project";

    /**
     * The metaclass qualified name.
     */
    @objid ("0e4f0b6f-6f35-4836-975e-5f7426017984")
    public static final String MQNAME = "Standard.Project";

    /**
     * Getter for attribute 'Project.ProjectContext'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("bebd0f47-4d69-4822-9ea3-51398efe4eab")
    String getProjectContext();

    /**
     * Setter for attribute 'Project.ProjectContext'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("407b6494-2ecb-4e27-992b-4ee42cbfe40b")
    void setProjectContext(String value);

    /**
     * Getter for attribute 'Project.ProjectDescr'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("641f36f6-b04a-4508-b493-5b91df6bc3e6")
    String getProjectDescr();

    /**
     * Setter for attribute 'Project.ProjectDescr'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("02e8778e-9b07-4bd4-9240-f8d392e20d89")
    void setProjectDescr(String value);

    /**
     * Getter for relation 'Project->Model'
     *
     * Metamodel description:
     * <i>Defines the Package associated to the Project (equivalent to the UML Model notion) that is the root of the Project's Package organization.</i>
     */
    @objid ("e3cd72fc-2686-4cf0-9493-6925a430a96e")
    EList<Package> getModel();

    /**
     * Filtered Getter for relation 'Project->Model'
     *
     * Metamodel description:
     * <i>Defines the Package associated to the Project (equivalent to the UML Model notion) that is the root of the Project's Package organization.</i>
     */
    @objid ("52289b3f-0d4d-4dab-bd20-403d4fcacbb4")
    <T extends Package> List<T> getModel(java.lang.Class<T> filterClass);

}

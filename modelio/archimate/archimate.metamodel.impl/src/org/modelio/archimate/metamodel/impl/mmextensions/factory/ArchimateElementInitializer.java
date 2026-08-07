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
package org.modelio.archimate.metamodel.impl.mmextensions.factory;

import java.util.Arrays;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.core.ArchimateView;
import org.modelio.archimate.metamodel.core.ViewPointDiagram;
import org.modelio.archimate.metamodel.core.structure.ArchimateProject;
import org.modelio.archimate.metamodel.core.structure.Folder;
import org.modelio.archimate.metamodel.core.structure.Model;
import org.modelio.archimate.metamodel.core.structure.ViewPoint;
import org.modelio.archimate.metamodel.core.structure.folder.ApplicationFolder;
import org.modelio.archimate.metamodel.core.structure.folder.BusinessFolder;
import org.modelio.archimate.metamodel.core.structure.folder.ImplementationFolder;
import org.modelio.archimate.metamodel.core.structure.folder.MotivationFolder;
import org.modelio.archimate.metamodel.core.structure.folder.PhysicalFolder;
import org.modelio.archimate.metamodel.core.structure.folder.StrategyFolder;
import org.modelio.archimate.metamodel.core.structure.folder.TechnologyFolder;
import org.modelio.archimate.metamodel.mmextensions.archimate.IArchimateModelFactory;
import org.modelio.archimate.metamodel.visitors.DefaultArchimateVisitor;
import org.modelio.metamodel.uml.infrastructure.ModelElement;
import org.modelio.vcore.smkernel.mapi.MObject;

/**
 * Default implementation of IElementInitializer interface
 */
@objid ("564efac7-4817-4bfc-b39d-f682ab32889d")
class ArchimateElementInitializer implements IArchimateElementInitializer {
    @objid ("63950363-ea31-4448-8133-22761ef29d36")
    private ElementInitializerVisitor visitor;

    @objid ("eb2f63ce-c58d-4169-8178-8ea45f90f63e")
    public ArchimateElementInitializer(IArchimateModelFactory modelFactory) {
        this.visitor = new ElementInitializerVisitor(modelFactory);
    }

    @objid ("65853e70-6b3e-4b4d-bf0b-12057fff842b")
    @Override
    public void initialize(MObject element) {
        element.accept(this.visitor);
    }

    @objid ("ac5e193c-1e72-4425-88be-07da1adbc50c")
    @Override
    public void setDefaultValue(String key, Object value) {
        // ignore
    }

    @objid ("fdc8db8e-21b9-4015-a229-09b10dcdc926")
    @SuppressWarnings("synthetic-access")
    private static class ElementInitializerVisitor extends DefaultArchimateVisitor {
        @objid ("850302f3-28a7-416e-bdad-677b3934dcbd")
        private IArchimateModelFactory modelFactory;

        @objid ("e421abd8-d914-4df2-a8ba-a65755b6eb47")
        public ElementInitializerVisitor(final IArchimateModelFactory modelFactory) {
            this.modelFactory = modelFactory;
        }

        @objid ("c5fcb5cd-300f-46ca-acce-0e25837ca413")
        @Override
        public Object visitArchimateProject(ArchimateProject project) {
            // Create a Model and a ViewPoint
            Model model = this.modelFactory.createModel();
            model.setProject(project);
            model.setName(Model.MNAME);

            ViewPoint viewPoint = this.modelFactory.createViewPoint();
            viewPoint.setProject(project);
            viewPoint.setName(ViewPoint.MNAME);
            viewPoint.setContext(model);
            return super.visitArchimateProject(project);
        }

        @objid ("df032870-9cb1-43ad-9fd6-a7c37d5b0eef")
        @Override
        public Object visitModel(Model model) {
            // create layer folders
            List<Class<? extends Folder>> cls = Arrays.asList(
                    ApplicationFolder.class,
                    BusinessFolder.class,
                    ImplementationFolder.class,
                    MotivationFolder.class,
                    PhysicalFolder.class,
                    StrategyFolder.class,
                    TechnologyFolder.class);

            for (Class<? extends Folder> mc : cls) {
                Folder folder = this.modelFactory.createElement(mc);
                model.getFolder().add(folder);
                folder.setName(mc.getSimpleName().replace("Folder", ""));
            }
            return super.visitModel(model);
        }

        @objid ("b7775911-0f85-4ef6-b393-f6fa7d2a44e8")
        @Override
        public Object visitViewPoint(ViewPoint viewPoint) {
            ViewPointDiagram vpDiagrap = this.modelFactory.createViewPointDiagram();
            vpDiagrap.setOrigin(viewPoint);
            vpDiagrap.setName(ViewPointDiagram.MNAME);

            ArchimateView archimateView = this.modelFactory.createArchimateView();
            archimateView.setOrigin(viewPoint);
            archimateView.setName(ArchimateView.MNAME);

            // Reference the projec't root model
            ArchimateProject project = viewPoint.getProject();
            if (project != null) {
                for (Model model : project.getModel()) {
                    viewPoint.setContext(model);
                    break;
                }
            } else {
                // Reference the parent's model
                ViewPoint parentViewPoint = viewPoint.getParent();
                if (parentViewPoint != null) {
                    viewPoint.setContext(parentViewPoint.getContext());
                }
            }
            return super.visitViewPoint(viewPoint);
        }

    }

}

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
package org.modelio.archimate.ui.modelproperty;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.core.ArchimateAbstractElement;
import org.modelio.archimate.metamodel.core.ArchimateView;
import org.modelio.archimate.metamodel.core.Relationship;
import org.modelio.archimate.metamodel.core.generic.Event;
import org.modelio.archimate.metamodel.core.structure.ArchimateProject;
import org.modelio.archimate.metamodel.core.structure.ViewPoint;
import org.modelio.archimate.metamodel.layers.motivation.Goal;
import org.modelio.archimate.metamodel.layers.motivation.Meaning;
import org.modelio.archimate.metamodel.layers.motivation.Requirement;
import org.modelio.archimate.metamodel.relationships.dependency.Access;
import org.modelio.archimate.metamodel.relationships.dependency.Influence;
import org.modelio.archimate.metamodel.relationships.other.Association;
import org.modelio.archimate.metamodel.visitors.DefaultArchimateVisitor;
import org.modelio.archimate.ui.modelproperty.archimate.AccessPropertyModel;
import org.modelio.archimate.ui.modelproperty.archimate.ArchimateAbstractElementPropertyModel;
import org.modelio.archimate.ui.modelproperty.archimate.ArchimateProjectPropertyModel;
import org.modelio.archimate.ui.modelproperty.archimate.ArchimateViewPropertyModel;
import org.modelio.archimate.ui.modelproperty.archimate.AssociationPropertyModel;
import org.modelio.archimate.ui.modelproperty.archimate.EventPropertyModel;
import org.modelio.archimate.ui.modelproperty.archimate.GoalPropertyModel;
import org.modelio.archimate.ui.modelproperty.archimate.InfluencePropertyModel;
import org.modelio.archimate.ui.modelproperty.archimate.MeaningPropertyModel;
import org.modelio.archimate.ui.modelproperty.archimate.RelationshipPropertyModel;
import org.modelio.archimate.ui.modelproperty.archimate.RequirementPropertyModel;
import org.modelio.archimate.ui.modelproperty.archimate.ViewPointPropertyModel;
import org.modelio.platform.model.ui.nattable.viewer.model.INatTableViewerContext;
import org.modelio.platform.model.ui.nattable.viewer.model.IPropertyModel;
import org.modelio.platform.model.ui.nattable.viewer.model.IPropertyModelProvider;
import org.modelio.vcore.smkernel.mapi.MObject;

/**
 * Default property model provider with Archimate elements for the property view.
 */
@objid ("e38f25dd-086e-46ad-8e22-25d1c142a81e")
public class ArchimatePropertyModelProvider implements IPropertyModelProvider {
    @objid ("dd39699e-ba35-41dc-9c97-e8310c5c2333")
    @Override
    public IPropertyModel<?> getPropertyModel(MObject element, INatTableViewerContext context) {
        return (IPropertyModel<?>) element.accept(new ArchimatePropertyModelVisitor());
    }

    @objid ("2935721f-68db-423d-8bfb-70e712adeaa2")
    private static class ArchimatePropertyModelVisitor extends DefaultArchimateVisitor {
        @objid ("688b17d0-deec-4aa6-a9aa-e394909de39b")
        public ArchimatePropertyModelVisitor() {
            super();
        }

        @objid ("6869449f-54c3-474d-9bc4-5e00cee676ab")
        @Override
        public Object visitAccess(Access theEditedElement) {
            return new AccessPropertyModel(theEditedElement);
        }

        @objid ("a6b3af83-060a-4e08-a472-3cfa12c170a3")
        @Override
        public Object visitArchimateAbstractElement(ArchimateAbstractElement theEditedElement) {
            return new ArchimateAbstractElementPropertyModel(theEditedElement);
        }

        @objid ("1c7f0f9d-d0ed-4786-bff1-502de26ecb2d")
        @Override
        public Object visitArchimateProject(ArchimateProject theEditedElement) {
            return new ArchimateProjectPropertyModel(theEditedElement);
        }

        @objid ("44659f68-3705-4732-985b-8099ae10ac1c")
        @Override
        public Object visitArchimateView(ArchimateView theEditedElement) {
            return new ArchimateViewPropertyModel(theEditedElement);
        }

        @objid ("5fba5f64-2909-408f-bac7-d942e66bf54c")
        @Override
        public Object visitAssociation(Association theEditedElement) {
            return new AssociationPropertyModel(theEditedElement);
        }

        @objid ("af22814e-c727-4d3d-a67c-c0cd9e81dbd9")
        @Override
        public Object visitEvent(Event theEditedElement) {
            return new EventPropertyModel(theEditedElement);
        }

        @objid ("3e6f3bf6-f131-422e-ab51-da67f1c661e0")
        @Override
        public Object visitGoal(Goal theEditedElement) {
            return new GoalPropertyModel(theEditedElement);
        }

        @objid ("69de990d-2a73-4f3e-9bab-6dd0e67614bf")
        @Override
        public Object visitInfluence(Influence theEditedElement) {
            return new InfluencePropertyModel(theEditedElement);
        }

        @objid ("c2af2b87-d006-4ad8-9837-75957d32472f")
        @Override
        public Object visitMeaning(Meaning theEditedElement) {
            return new MeaningPropertyModel(theEditedElement);
        }

        @objid ("f658846a-6201-44aa-b6a9-d0fcaf57b40f")
        @Override
        public Object visitRelationship(Relationship theEditedElement) {
            return new RelationshipPropertyModel(theEditedElement);
        }

        @objid ("2a2c5180-2c11-48d5-a1a6-3dfcbb4fccb6")
        @Override
        public Object visitRequirement(Requirement theEditedElement) {
            return new RequirementPropertyModel(theEditedElement);
        }

        @objid ("ba88fc9e-eaa5-4549-99de-9d520c497811")
        @Override
        public Object visitViewPoint(ViewPoint theEditedElement) {
            return new ViewPointPropertyModel(theEditedElement);
        }

    }

}

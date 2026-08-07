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
package org.modelio.archimate.diagrams.elements.factories;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.access.GmAccess;
import org.modelio.archimate.diagrams.elements.aggregation.GmAggregation;
import org.modelio.archimate.diagrams.elements.assignment.GmAssignment;
import org.modelio.archimate.diagrams.elements.association.GmAssociation;
import org.modelio.archimate.diagrams.elements.composition.GmComposition;
import org.modelio.archimate.diagrams.elements.flow.GmFlow;
import org.modelio.archimate.diagrams.elements.influence.GmInfluence;
import org.modelio.archimate.diagrams.elements.realization.GmRealization;
import org.modelio.archimate.diagrams.elements.serving.GmServing;
import org.modelio.archimate.diagrams.elements.specialization.GmSpecialization;
import org.modelio.archimate.diagrams.elements.triggering.GmTriggering;
import org.modelio.archimate.metamodel.core.ArchimateAbstractElement;
import org.modelio.archimate.metamodel.relationships.dependency.Access;
import org.modelio.archimate.metamodel.relationships.dependency.Influence;
import org.modelio.archimate.metamodel.relationships.dependency.Serving;
import org.modelio.archimate.metamodel.relationships.dynamic.Flow;
import org.modelio.archimate.metamodel.relationships.dynamic.Triggering;
import org.modelio.archimate.metamodel.relationships.other.Association;
import org.modelio.archimate.metamodel.relationships.other.Specialization;
import org.modelio.archimate.metamodel.relationships.structural.Aggregation;
import org.modelio.archimate.metamodel.relationships.structural.Assignment;
import org.modelio.archimate.metamodel.relationships.structural.Composition;
import org.modelio.archimate.metamodel.relationships.structural.Realization;
import org.modelio.archimate.metamodel.visitors.DefaultArchimateVisitor;
import org.modelio.diagram.elements.core.link.GmLink;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.elements.core.model.factory.IGmLinkFactory;
import org.modelio.diagram.persistence.IPersistent;
import org.modelio.diagram.persistence.IPersistentMigrator;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Archimate diagram specific implementation of {@link IGmLinkFactory}.
 * <p>
 * This particular implementation:
 * <ul>
 * <li>does not support cascading</li>
 * <li>only processes Archimate elements</li>
 * </ul>
 * </p>
 */
@objid ("de578ac2-0454-4e0b-ad41-d54ce2194ba7")
public class ArchimateGmLinkFactory implements IGmLinkFactory {
    @objid ("01ef6119-656a-431e-afb3-478f2e327098")
    @Override
    public GmLink create(IGmDiagram diagram, MObject linkElement) {
        return (GmLink) linkElement.accept(new ImplVisitor(diagram));
    }

    @objid ("8d062fa7-d4c0-4443-8fb9-d217229e4f73")
    @Override
    public Class<? extends IPersistent> resolveClass(String namespace) {
        try {
            if (namespace.startsWith("org.modelio.archimate.diagrams")) {
                Class<?> clazz = Class.forName(namespace);
                if (clazz != null) {
                    return clazz.asSubclass(IPersistent.class);
                }
            }
        } catch (@SuppressWarnings ("unused") ClassNotFoundException | ClassCastException e) {
            // Class not found, return null
        }
        return null;
    }

    @objid ("1ba00675-dda9-4f28-981f-d51830e62b06")
    @Override
    public Class<? extends IPersistentMigrator> resolveMigratorClass(String classNamespace) {
        try {
            Class<?> clazz = Class.forName(classNamespace);
            if (clazz != null) {
                return clazz.asSubclass(IPersistentMigrator.class);
            }
        } catch (@SuppressWarnings ("unused") ClassNotFoundException | ClassCastException e) {
            // Class not found, return null
        }
        return null;
    }

    @objid ("3d579618-f4a6-4fd7-8cad-ee613322abb8")
    @Override
    public Class<? extends Enum<?>> resolveEnumClass(String enumNamespace) {
        try {
            Class<?> clazz = Class.forName(enumNamespace);
            if (clazz != null && clazz.isEnum()) {
                return (Class<? extends Enum<?>>) clazz;
            }
        } catch (@SuppressWarnings ("unused") ClassNotFoundException | ClassCastException e) {
            // Enum not found, return null
        }
        return null;
    }

    /**
     * visitor class for the implementation of the links.
     */
    @objid ("9605712b-9ae5-43f6-b5f9-8c4b83621461")
    private class ImplVisitor extends DefaultArchimateVisitor {
        @objid ("c782ca1d-d943-411b-9f5f-4289e38d8704")
        private IGmDiagram diagram;

        @objid ("e9995f07-cc5e-409d-b50b-361f4f264ab6")
        public ImplVisitor(IGmDiagram diagram) {
            this.diagram = diagram;
        }

        @objid ("c5157234-f886-4998-b252-7ceb60c9f2e4")
        @Override
        public Object visitAccess(Access theAccess) {
            // GmAccess
            final GmAccess access = new GmAccess(this.diagram, theAccess, new MRef(theAccess));
            return access;
        }

        @objid ("e9770dd6-434f-4bc2-a33a-a38e7954c644")
        @Override
        public Object visitAggregation(Aggregation theAggregation) {
            // GmAggregation
            final GmAggregation aggregation = new GmAggregation(this.diagram, theAggregation, new MRef(theAggregation));
            return aggregation;
        }

        @objid ("071ff041-d848-41ce-a7dc-142ef0bd6089")
        @Override
        public Object visitArchimateAbstractElement(ArchimateAbstractElement linkElement) {
            // We don't know what to do with that element.
            return null;
        }

        @objid ("962d3de0-7df0-4d37-baf8-750eb3d7f5c7")
        @Override
        public Object visitAssignment(Assignment theAssignment) {
            // GmAssignment
            final GmAssignment assignment = new GmAssignment(this.diagram, theAssignment, new MRef(theAssignment));
            return assignment;
        }

        @objid ("faf137ef-a5fa-4ace-a8d4-82212c4301d5")
        @Override
        public Object visitAssociation(Association theAssociation) {
            // GmAssociation
            final GmAssociation association = new GmAssociation(this.diagram, theAssociation, new MRef(theAssociation));
            return association;
        }

        @objid ("42d3942c-6314-4db4-a9f5-4f9c6769e49b")
        @Override
        public Object visitComposition(Composition theComposition) {
            // GmComposition
            final GmComposition composition = new GmComposition(this.diagram, theComposition, new MRef(theComposition));
            return composition;
        }

        @objid ("7da00ff2-e7dd-41e3-99aa-1b2d5dd82fec")
        @Override
        public Object visitFlow(Flow theFlow) {
            // GmFlow
            final GmFlow flow = new GmFlow(this.diagram, theFlow, new MRef(theFlow));
            return flow;
        }

        @objid ("591fbbd5-9bcf-4eb4-beda-a008a5d874af")
        @Override
        public Object visitInfluence(Influence theInfluence) {
            // GmInfluence
            final GmInfluence influence = new GmInfluence(this.diagram, theInfluence, new MRef(theInfluence));
            return influence;
        }

        @objid ("1226c99d-73e3-4e73-9bc0-3fa40de7387d")
        @Override
        public Object visitRealization(Realization theRealization) {
            // GmRealization
            final GmRealization realization = new GmRealization(this.diagram, theRealization, new MRef(theRealization));
            return realization;
        }

        @objid ("02b6595e-77d0-48e6-b083-d9ec4f349163")
        @Override
        public Object visitServing(Serving theServing) {
            // GmServing
            final GmServing serving = new GmServing(this.diagram, theServing, new MRef(theServing));
            return serving;
        }

        @objid ("dae74f96-1c6c-4f70-bbc2-6215a0feb7a8")
        @Override
        public Object visitSpecialization(Specialization theSpecialization) {
            // GmSpecialization
            final GmSpecialization specialization = new GmSpecialization(this.diagram, theSpecialization, new MRef(theSpecialization));
            return specialization;
        }

        @objid ("1135d32e-dfad-499d-97b7-8147e4b9eb54")
        @Override
        public Object visitTriggering(Triggering theTriggering) {
            // GmTriggering
            final GmTriggering triggering = new GmTriggering(this.diagram, theTriggering, new MRef(theTriggering));
            return triggering;
        }

    }

}

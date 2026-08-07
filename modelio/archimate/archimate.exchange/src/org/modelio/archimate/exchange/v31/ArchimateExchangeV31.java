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
package org.modelio.archimate.exchange.v31;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import org.eclipse.core.runtime.IProgressMonitor;
import org.modelio.api.modelio.diagram.IDiagramService;
import org.modelio.archimate.exchange.service.IArchimateExchange;
import org.modelio.archimate.exchange.service.exception.ArchimateException;
import org.modelio.archimate.exchange.service.exception.MarshalingException;
import org.modelio.archimate.exchange.v31.exporter.ModelioWalker;
import org.modelio.archimate.exchange.v31.exporter.factory.IDiagramFactoryExport;
import org.modelio.archimate.exchange.v31.exporter.factory.IElementFactoryExport;
import org.modelio.archimate.exchange.v31.exporter.factory.impl.DiagramFactoryExport;
import org.modelio.archimate.exchange.v31.exporter.factory.impl.ElementFactoryExport;
import org.modelio.archimate.exchange.v31.importer.JAXBWalker;
import org.modelio.archimate.exchange.v31.importer.factory.IDiagramFactoryImport;
import org.modelio.archimate.exchange.v31.importer.factory.IElementFactoryImport;
import org.modelio.archimate.exchange.v31.importer.factory.impl.DiagramFactoryImport;
import org.modelio.archimate.exchange.v31.importer.factory.impl.ElementFactoryImport;
import org.modelio.archimate.exchange.v31.xmlmodel.ModelType;
import org.modelio.archimate.metamodel.core.structure.ArchimateProject;
import org.modelio.archimate.metamodel.core.structure.Model;
import org.modelio.archimate.metamodel.mmextensions.archimate.IArchimateModelFactory;
import org.modelio.gproject.core.IGModelFragment;
import org.modelio.vcore.model.api.MTools;
import org.modelio.vcore.session.api.ICoreSession;
import org.modelio.vcore.session.api.transactions.ITransaction;
import org.modelio.vcore.smkernel.mapi.MObject;

@objid ("ae96100a-8e8c-4d9c-840e-beb0420d5cd4")
public class ArchimateExchangeV31 implements IArchimateExchange {
    @objid ("693c345c-bb79-4640-b5f6-ce7a4958509c")
    private IProgressMonitor progress;

    @objid ("d5d4274c-495d-41f9-9b55-393ea411b2a8")
    private IDiagramService diagramService;

    @objid ("eacfa13c-8eb2-4484-8118-69518bde4666")
    private ICoreSession session;

    @objid ("9ed42af4-45d7-4be1-aba8-32a6bedad626")
    public ArchimateExchangeV31(ICoreSession session, IDiagramService diagramService) {
        this.diagramService = diagramService;
        this.session = session;
    }

    @objid ("e4f6d500-435f-4e96-af68-7beaa4e0d633")
    @Override
    public void setProgressMonitor(IProgressMonitor progress) {
        this.progress = progress;
    }

    @objid ("c6e39faa-d7ce-449e-8245-487778e0dd75")
    @Override
    public MObject importArchimateModel(Path filePath, Object context, boolean keepId, boolean nativeStyle) throws ArchimateException {
        File input = filePath.toFile();
        if (input.exists()) {

            ArchimateProject archimateProject = getArchimateProject(context, input.getName().replace(".xml", ""));

            ModelType jaxModel = unmarshall(input);
            IElementFactoryImport elementFactory = new ElementFactoryImport(this.session, archimateProject, keepId,false);
            IDiagramFactoryImport diagramFactory = new DiagramFactoryImport(this.diagramService, archimateProject,nativeStyle);

            JAXBWalker walker = new JAXBWalker(elementFactory, diagramFactory, archimateProject, this.session);
            walker.walk(jaxModel, this.progress);

        } else {
            throw new ArchimateException("TODO : File Missing");
        }
        return null;
    }

    @objid ("bb5182bb-9fb8-4b25-98fa-71c39a62d9bb")
    @Override
    public Path exportArchimateModel(Path filePath, Model context) throws ArchimateException {
        File output = filePath.toFile();
        IElementFactoryExport elementFactory = new ElementFactoryExport();
        IDiagramFactoryExport diagramFactory = new DiagramFactoryExport(this.diagramService);

        ModelioWalker walker = new ModelioWalker(elementFactory, diagramFactory);
        ModelType jaxModel = walker.walk(context, this.progress);

        if (jaxModel != null) {
            marshall(output, jaxModel);
        }
        return filePath;
    }

    @objid ("53197730-b483-4e40-9890-056fc099610b")
    public void marshall(File file, ModelType model) throws ArchimateException {
        try {
            JAXBContext jc = JAXBContext.newInstance("org.modelio.archimate.exchange.v31.xmlmodel", ModelType.class.getClassLoader());
            Marshaller marshaller = jc.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION,"http://www.opengroup.org/xsd/archimate/3.0/ http://www.opengroup.org/xsd/archimate/3.1/archimate3_Diagram.xsd http://purl.org/dc/elements/1.1/ http://www.opengroup.org/xsd/archimate/3.1/dc.xsd");
            marshaller.marshal(model, file);
        } catch (JAXBException e) {
            throw new ArchimateException(e);
        }
    }

    @objid ("fb4a2378-fc02-4cd3-a800-86c08f67a076")
    public ModelType unmarshall(File file) throws ArchimateException {
        try {
            JAXBContext jc = JAXBContext.newInstance("org.modelio.archimate.exchange.v31.xmlmodel", ModelType.class.getClassLoader());
            Unmarshaller marshaller = jc.createUnmarshaller();

            JAXBElement o = (JAXBElement) marshaller.unmarshal(file);
            return (ModelType)o.getValue();
        } catch (JAXBException | LinkageError e) {
            throw new MarshalingException(e);
        }
    }

    @objid ("238df7f5-4735-40f6-9521-103481e20ab7")
    private ArchimateProject getArchimateProject(Object context, String name) {
        if (context instanceof ArchimateProject) {
            return (ArchimateProject) context;
        } else if (context instanceof IGModelFragment) {

            for (MObject root : ((IGModelFragment) context).getRoots()) {
                if (root instanceof ArchimateProject) {
                    return (ArchimateProject) root;
                }
            }

            ArchimateProject project = null;
            try (ITransaction tr = this.session.getTransactionSupport().createTransaction("Create ArchimateProject")) {
                project = MTools.get(this.session).getModelFactory(IArchimateModelFactory.class).createArchimateProject(name,
                        ((IGModelFragment) context).getRepository());
                // FIXME
                for (MObject sub : new ArrayList<>(project.getCompositionChildren())) {
                    sub.delete();
                }
                tr.commit();
            }
            return project;
        }
        return null;
    }

}

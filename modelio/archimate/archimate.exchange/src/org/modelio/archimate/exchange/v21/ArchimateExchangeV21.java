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
package org.modelio.archimate.exchange.v21;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import javax.xml.XMLConstants;
import javax.xml.validation.SchemaFactory;
import org.eclipse.core.runtime.IProgressMonitor;
import org.modelio.api.modelio.diagram.IDiagramService;
import org.modelio.archimate.exchange.service.IArchimateExchange;
import org.modelio.archimate.exchange.service.exception.ArchimateException;
import org.modelio.archimate.exchange.service.exception.MarshalingException;
import org.modelio.archimate.exchange.v21.exporter.ModelioWalker;
import org.modelio.archimate.exchange.v21.exporter.factory.IDiagramFactoryExport;
import org.modelio.archimate.exchange.v21.exporter.factory.IElementFactoryExport;
import org.modelio.archimate.exchange.v21.exporter.factory.impl.DiagramFactoryExport;
import org.modelio.archimate.exchange.v21.exporter.factory.impl.ElementFactoryExport;
import org.modelio.archimate.exchange.v21.importer.JAXBWalker;
import org.modelio.archimate.exchange.v21.importer.factory.IDiagramFactoryImport;
import org.modelio.archimate.exchange.v21.importer.factory.IElementFactoryImport;
import org.modelio.archimate.exchange.v21.importer.factory.impl.DiagramFactoryImport;
import org.modelio.archimate.exchange.v21.importer.factory.impl.ElementFactoryImport;
import org.modelio.archimate.exchange.v21.xmlmodel.ModelType;
import org.modelio.archimate.metamodel.core.structure.ArchimateProject;
import org.modelio.archimate.metamodel.core.structure.Model;
import org.modelio.archimate.metamodel.mmextensions.archimate.IArchimateModelFactory;
import org.modelio.gproject.core.IGModelFragment;
import org.modelio.vcore.model.api.MTools;
import org.modelio.vcore.session.api.ICoreSession;
import org.modelio.vcore.session.api.transactions.ITransaction;
import org.modelio.vcore.smkernel.mapi.MObject;

@objid ("b96146ae-9f5c-432e-b155-6f7af46c8ffd")
public class ArchimateExchangeV21 implements IArchimateExchange {
    @objid ("dc18e7b3-e11b-48af-8cf8-ed04f08cb691")
    private IProgressMonitor progress;

    @objid ("3cc05dad-794b-481f-9714-269882b0a960")
    private IDiagramService diagramService;

    @objid ("7c936280-ddc4-420a-96eb-417897f40720")
    private ICoreSession session;

    @objid ("b9010550-1a1e-46e7-999f-1da9242da596")
    public ArchimateExchangeV21(ICoreSession session, IDiagramService diagramService) {
        this.diagramService = diagramService;
        this.session = session;
    }

    @objid ("cdc61458-01d2-4b73-b4c9-58ec6f213b48")
    @Override
    public void setProgressMonitor(IProgressMonitor progress) {
        this.progress = progress;
    }

    @objid ("80c97ec5-57e3-42f0-8f42-c9fd4b60c0a0")
    @Override
    public MObject importArchimateModel(Path filePath, Object context, boolean keepId, boolean nativeStyle) throws ArchimateException {
        File input = filePath.toFile();
        if (input.exists()) {
            ArchimateProject archimateProject = getArchimateProject(context, input.getName().replace(".xml", ""));

            ModelType jaxModel = unmarshall(input);
            IElementFactoryImport elementFactory = new ElementFactoryImport(this.session, archimateProject, keepId,false);
            IDiagramFactoryImport diagramFactory = new DiagramFactoryImport(this.session, this.diagramService,archimateProject);
            JAXBWalker walker = new JAXBWalker(elementFactory, diagramFactory, archimateProject, this.session);
            walker.walk(jaxModel, this.progress);
        } else {
            throw new ArchimateException("TODO : File Missing");
        }
        return null;
    }

    @objid ("86e094d4-ae6a-4449-a61a-5030f9748c89")
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

    @objid ("29c05e71-935c-40db-b6e5-bf2e4131af82")
    public void marshall(File file, ModelType model) throws ArchimateException {
        try {
            JAXBContext jc = JAXBContext.newInstance("org.modelio.archimate.exchange.v21.xmlmodel", ModelType.class.getClassLoader());
            Marshaller marshaller = jc.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION,
                    "http://www.opengroup.org/xsd/archimate archimate_v2p1.xsd");
            marshaller.marshal(model, file);
        } catch (JAXBException e) {
            throw new ArchimateException(e);
        }
    }

    @objid ("42b41865-ab70-466a-91dd-a34afa432296")
    public ModelType unmarshall(File file) throws ArchimateException {
        try {

            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
               //    Schema schema = schemaFactory.newSchema(ArchiExchange.getBundleFile("res/schema/2.1/archimate_v2p1.xsd"));

            JAXBContext jc = JAXBContext.newInstance("org.modelio.archimate.exchange.v21.xmlmodel", ModelType.class.getClassLoader());
            Unmarshaller marshaller = jc.createUnmarshaller();

            @SuppressWarnings ("unchecked")
            JAXBElement<ModelType> o = (JAXBElement<ModelType>) marshaller.unmarshal(file);

            return o.getValue();
        } catch (JAXBException | LinkageError e) {
            throw new MarshalingException(e);
        }
    }

    @objid ("23dec1f2-6f0a-4111-a3e6-97cafdf9fe69")
    private ArchimateProject getArchimateProject(Object context, String name) {
        if (context instanceof ArchimateProject) {
            return (ArchimateProject) context;
        } else if (context instanceof IGModelFragment) {
            ArchimateProject project = null;
            try (ITransaction tr = this.session.getTransactionSupport().createTransaction("Create ArchimateProject")) {
                project = MTools.get(this.session).getModelFactory(IArchimateModelFactory.class)
                        .createArchimateProject(name, ((IGModelFragment) context).getRepository());
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

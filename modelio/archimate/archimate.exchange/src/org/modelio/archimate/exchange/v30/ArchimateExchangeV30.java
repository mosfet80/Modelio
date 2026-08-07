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
package org.modelio.archimate.exchange.v30;

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
import org.modelio.archimate.exchange.v30.exporter.ModelioWalker;
import org.modelio.archimate.exchange.v30.exporter.factory.IDiagramFactoryExport;
import org.modelio.archimate.exchange.v30.exporter.factory.IElementFactoryExport;
import org.modelio.archimate.exchange.v30.exporter.factory.impl.DiagramFactoryExport;
import org.modelio.archimate.exchange.v30.exporter.factory.impl.ElementFactoryExport;
import org.modelio.archimate.exchange.v30.importer.JAXBWalker;
import org.modelio.archimate.exchange.v30.importer.factory.IDiagramFactoryImport;
import org.modelio.archimate.exchange.v30.importer.factory.IElementFactoryImport;
import org.modelio.archimate.exchange.v30.importer.factory.impl.DiagramFactoryImport;
import org.modelio.archimate.exchange.v30.importer.factory.impl.ElementFactoryImport;
import org.modelio.archimate.exchange.v30.xmlmodel.ModelType;
import org.modelio.archimate.metamodel.core.structure.ArchimateProject;
import org.modelio.archimate.metamodel.core.structure.Model;
import org.modelio.archimate.metamodel.mmextensions.archimate.IArchimateModelFactory;
import org.modelio.gproject.core.IGModelFragment;
import org.modelio.vcore.model.api.MTools;
import org.modelio.vcore.session.api.ICoreSession;
import org.modelio.vcore.session.api.transactions.ITransaction;
import org.modelio.vcore.smkernel.mapi.MObject;

@objid ("8f6f1e3e-088a-4b53-b991-d1626392e122")
public class ArchimateExchangeV30 implements IArchimateExchange {
    @objid ("b447ba5c-acec-463a-a9e4-e2691d5be232")
    private IProgressMonitor progress;

    @objid ("7e24800d-8d49-481e-be71-61369c6abdf8")
    private IDiagramService diagramService;

    @objid ("ccf483a2-6fc4-448b-841b-b137c77eb6b1")
    private ICoreSession session;

    @objid ("9716f1b3-e53f-42ea-afc5-9ff3e35c022e")
    public ArchimateExchangeV30(ICoreSession session, IDiagramService diagramService) {
        this.diagramService = diagramService;
        this.session = session;
    }

    @objid ("1380dfc0-3da1-47c5-a7d1-47bca51dccc1")
    @Override
    public void setProgressMonitor(IProgressMonitor progress) {
        this.progress = progress;
    }

    @objid ("ddffaa97-45d6-4636-9002-bebcc1b466f6")
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

    @objid ("8ba2bd07-d27d-4427-90ac-868f379024da")
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

    @objid ("b769d30a-31ad-483c-a249-044666164d50")
    public void marshall(File file, ModelType model) throws ArchimateException {
        try {
            JAXBContext jc = JAXBContext.newInstance("org.modelio.archimate.exchange.v30.xmlmodel", ModelType.class.getClassLoader());
            Marshaller marshaller = jc.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION,
                    "http://www.opengroup.org/xsd/archimate/3.0/ http://www.opengroup.org/xsd/archimate/3.0/archimate3_Diagram.xsd");
            marshaller.marshal(model, file);
        } catch (JAXBException e) {
            throw new ArchimateException(e);
        }
    }

    @objid ("6d370012-5e64-4d50-9a8c-28ab11d5d722")
    public ModelType unmarshall(File file) throws ArchimateException {
        try {
            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

            JAXBContext jc = JAXBContext.newInstance("org.modelio.archimate.exchange.v30.xmlmodel", ModelType.class.getClassLoader());
            Unmarshaller marshaller = jc.createUnmarshaller();
            // marshaller.setSchema(schema);

            JAXBElement o = (JAXBElement) marshaller.unmarshal(file);
            return (ModelType)o.getValue();
        } catch (JAXBException | LinkageError e) {
            throw new MarshalingException(e);
        }
    }

    @objid ("b41627ba-a10f-4df5-a9ae-14d4cb79ccb2")
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

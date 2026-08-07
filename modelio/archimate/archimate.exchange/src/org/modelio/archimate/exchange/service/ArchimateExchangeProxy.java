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
package org.modelio.archimate.exchange.service;

import java.nio.file.Path;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.core.runtime.IProgressMonitor;
import org.modelio.api.modelio.diagram.IDiagramService;
import org.modelio.archimate.exchange.service.exception.ArchimateException;
import org.modelio.archimate.exchange.v21.ArchimateExchangeV21;
import org.modelio.archimate.exchange.v30.ArchimateExchangeV30;
import org.modelio.archimate.exchange.v31.ArchimateExchangeV31;
import org.modelio.archimate.metamodel.core.structure.Model;
import org.modelio.vcore.session.api.ICoreSession;
import org.modelio.vcore.smkernel.mapi.MObject;

@objid ("cfc15746-9450-403b-a68f-581241061210")
public class ArchimateExchangeProxy implements IArchimateExchange {
    @objid ("5adf0ea3-d44c-4ce5-b937-bf353bf86edc")
    private ExchangeFormatVersion version;

    @objid ("9d3cac91-179f-4882-83fb-86af248e11c5")
    private IProgressMonitor progress;

    @objid ("ecd45fe2-968c-47f0-939b-4665376d5445")
    private IDiagramService diagramService;

    @objid ("d6d8b680-d488-420f-8a01-7b8bceffb22b")
    private ICoreSession session;

    @objid ("328934ed-3470-4c76-bb9f-2f3c6778a211")
    public ArchimateExchangeProxy(ICoreSession session, IDiagramService diagramService, ExchangeFormatVersion version) {
        this.version = version;
        this.diagramService = diagramService;
        this.session = session;

    }

    @objid ("11412929-b458-4d4d-84dc-7425a0384e82")
    @Override
    public MObject importArchimateModel(Path filePath, Object context, boolean keepId, boolean nativeStyle) throws ArchimateException {
        IArchimateExchange service = null;
        if (this.version.equals(ExchangeFormatVersion.V21)) {
            service = new ArchimateExchangeV21(this.session,this.diagramService);
        } else if (this.version.equals(ExchangeFormatVersion.V30)) {
            service = new ArchimateExchangeV30(this.session,this.diagramService);
        } else if (this.version.equals(ExchangeFormatVersion.V31)) {
            service = new ArchimateExchangeV31(this.session,this.diagramService);
        } else {
            return null;
        }

        if(this.progress != null){
            service.setProgressMonitor(this.progress);
        }
        return service.importArchimateModel(filePath, context, keepId,nativeStyle);
    }

    @objid ("dc6d6141-bc60-46ea-a492-1d5538f348f4")
    @Override
    public Path exportArchimateModel(Path filePath, Model context) throws ArchimateException {
        IArchimateExchange service = null;
        if (this.version.equals(ExchangeFormatVersion.V21)){
            service = new ArchimateExchangeV21(this.session,this.diagramService);
        } else if (this.version.equals(ExchangeFormatVersion.V30)){
            service = new ArchimateExchangeV30(this.session,this.diagramService);
        }else if (this.version.equals(ExchangeFormatVersion.V31)){
            service = new ArchimateExchangeV31(this.session,this.diagramService);
        }else {
            return null;
        }

        if(this.progress != null){
            service.setProgressMonitor(this.progress);
        }
        return service.exportArchimateModel(filePath, context);
    }

    @objid ("df1d2f0c-dfd6-4666-940d-5ae725a3cdb6")
    @Override
    public void setProgressMonitor(IProgressMonitor progress) {
        this.progress = progress;
    }

    @objid ("0c5e6eeb-9d6b-445a-841a-c6fb1a7873aa")
    public enum ExchangeFormatVersion {
        @objid ("5fbe97e4-93b7-4035-a58a-36460f2c00c5")
        V21,
        @objid ("3dda7a2f-a9b4-40d8-ac0f-66fb1cce5f37")
        V30,
        @objid ("44d3a6e4-5df7-459d-a787-16fc79388784")
        V31;

    }

}

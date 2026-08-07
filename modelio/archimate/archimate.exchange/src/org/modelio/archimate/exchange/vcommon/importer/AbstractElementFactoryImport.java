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
package org.modelio.archimate.exchange.vcommon.importer;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.exchange.service.utils.BaseFactory;
import org.modelio.archimate.exchange.service.utils.IDUtils;
import org.modelio.archimate.metamodel.core.structure.ArchimateProject;
import org.modelio.metamodel.mmextensions.infrastructure.ElementNotUniqueException;
import org.modelio.metamodel.mmextensions.standard.services.MModelServices;
import org.modelio.metamodel.uml.infrastructure.ModelElement;
import org.modelio.metamodel.uml.infrastructure.NoteType;
import org.modelio.metamodel.uml.infrastructure.properties.PropertyTableDefinition;
import org.modelio.vcore.session.api.ICoreSession;
import org.modelio.vcore.session.impl.CoreSession;
import org.modelio.vcore.smkernel.mapi.MObject;

@objid ("6e1e19d4-8224-4715-8a0f-e59423de64c1")
public abstract class AbstractElementFactoryImport {
    @objid ("1c9f801a-3b02-48b8-91f8-08e17d90cb19")
    protected final String primaryLocale;

    @objid ("f9447723-233f-4c27-b81d-5b5d4bca0beb")
    protected final boolean keepId;

    @objid ("a6221dd2-4c7e-43cf-9771-eb618c6f3084")
    private boolean isUpdate = false;

    @objid ("daaf979a-da8d-46ef-8977-48bb3e768eb5")
    protected final ArchimateProject context;

    @objid ("54c0f50b-bae5-4cd5-88ee-616a082753f7")
    protected final ICoreSession session;

    @objid ("f8603f1b-7247-444f-8571-48fc6323c982")
    protected final BaseFactory baseFactory;

    @objid ("3f0299fb-3043-4078-bb0f-fd06126cc838")
    protected Map<String, ModelElement> refs;

    @objid ("60e42687-d389-4d6c-9d51-d75b0954fa9c")
    protected final Map<String, PropertyTableDefinition> genericTableMap;

    @objid ("fed07f5e-c844-40e6-bab3-07257f22dffd")
    protected final NoteType descNoteType;

    @objid ("e78e7e03-b540-41e9-9c14-590fc4e0f079")
    protected AbstractElementFactoryImport(ICoreSession session, ArchimateProject context, boolean keepId, boolean isUpdate) {
        this.context = context;
        this.keepId = keepId;
        this.isUpdate = isUpdate;
        this.session = session;
        this.baseFactory = new BaseFactory((CoreSession) session);
        this.refs = new HashMap<>();
        this.genericTableMap = new HashMap<>();
        this.primaryLocale = ResourceBundle.getBundle("archiexchange").getLocale().getLanguage();

        try {
            this.descNoteType = new MModelServices(session).getNoteType("ModelerModule", null, "description", session.getMetamodel().getMClass(ModelElement.class));
            if (this.descNoteType == null)
                throw new IllegalStateException("No 'description' note type in the project");
        } catch (ElementNotUniqueException e) {
            throw new IllegalStateException(e);
        }
    }

    @objid ("79ba531e-4807-4cfa-a69c-0623eb36ba42")
    public final void setReferenceMap(Map<String, ModelElement> refs) {
        this.refs = refs;
    }

    @objid ("42756b1a-eed5-48ac-b317-28623ea3442a")
    protected final ModelElement createElement(String identifier, Class<? extends MObject> type) {
        ModelElement result = null;
        if (this.keepId) {
            result = (ModelElement) this.baseFactory.createWithId(type, this.context, IDUtils.importId(identifier));
        } else {
            result = (ModelElement) this.baseFactory.create(type, this.context);
        }

        this.refs.put(IDUtils.importId(identifier), result);
        return result;
    }

    @objid ("98c029d8-0ec9-4494-9666-d1064e7e0517")
    public final ModelElement findElement(String identifier) {
        if(!isUpdate) {
            return null;
        }

        ModelElement result = this.session.getModel().findById(ModelElement.class, IDUtils.importId(identifier));

        if (result != null) {
            this.refs.put(IDUtils.importId(identifier), result);
        }
        return result;
    }

}

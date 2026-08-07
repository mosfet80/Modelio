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
package org.modelio.platform.search.engine.searchers.query.internal.resolver;

import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.mda.ModuleComponent;
import org.modelio.metamodel.uml.infrastructure.Stereotype;
import org.modelio.vcore.session.api.ICoreSession;
import org.modelio.vcore.session.api.model.IModel;
import org.modelio.vcore.smkernel.mapi.MClass;

/**
 * Default resolver context backed by a real {@link ICoreSession}.
 */
@objid ("f0e092e3-654e-4f95-8b89-8e7ffcbb0618")
public final class DefaultResolverContext implements ResolverContext {
    @objid ("69e9f0f8-4107-47fd-b78a-09f6e514beba")
    private final ICoreSession session;

    @objid ("8e3e3e9c-d0cb-483a-b4c1-00b75c20b194")
    public DefaultResolverContext(ICoreSession session) {
        if (session == null) {
            throw new IllegalArgumentException("session must not be null");
        }
        this.session = session;
    }

    @objid ("7740c35a-5730-4e3b-9dd9-ab82970e04dd")
    @Override
    public MClass getMetaclass(String kindToken) {
        if (kindToken == null || kindToken.isBlank()) {
            return null;
        }
        return this.session.getMetamodel().getMClass(kindToken);
    }

    @objid ("3fc67c34-410e-4e11-8c76-e6013e74ea75")
    @Override
    public Iterable<? extends MClass> getRegisteredMetaclasses() {
        return this.session.getMetamodel().getRegisteredMClasses();
    }

    @objid ("2a4f860a-2a74-4fa4-82b3-4dd537bbf887")
    @Override
    public List<Stereotype> findStereotypesByName(String stereotypeName) {
        if (stereotypeName == null || stereotypeName.isBlank()) {
            return List.of();
        }
        final IModel model = this.session.getModel();
        return new ArrayList<>(model.findByName(Stereotype.class, true, stereotypeName));
    }

    @objid ("7d53150c-4376-4238-b542-83d5e38de7be")
    @Override
    public Iterable<? extends ModuleComponent> getModules() {
        final IModel model = this.session.getModel();
        return model.findByClass(ModuleComponent.class);
    }

}

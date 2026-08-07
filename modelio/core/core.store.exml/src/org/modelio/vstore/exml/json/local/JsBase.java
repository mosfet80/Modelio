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
package org.modelio.vstore.exml.json.local;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Path;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.vbasic.progress.IModelioProgress;
import org.modelio.vcore.model.DuplicateObjectException;
import org.modelio.vcore.session.impl.storage.IModelLoader;
import org.modelio.vcore.session.impl.storage.IModelLoaderProvider;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vstore.exml.common.AbstractExmlRepository;
import org.modelio.vstore.exml.common.ExmlStorageHandler;
import org.modelio.vstore.exml.common.ILoadHelper;
import org.modelio.vstore.exml.common.LoadHelper;
import org.modelio.vstore.exml.common.index.IndexException;
import org.modelio.vstore.exml.common.model.ObjId;
import org.modelio.vstore.exml.json.common.JsonModelParser;
import org.modelio.vstore.exml.resource.IExmlResourceProvider;
import org.modelio.vstore.exml.resource.IExmlResourceProvider.ExmlResource;
import org.xml.sax.InputSource;

/**
 * JSON local repository implementation.
 *
 * @since 5.5
 */
@objid ("96acfa1d-7545-48c7-b03e-c9f03cdb1b69")
public class JsBase extends AbstractExmlRepository {
    @objid ("e33256aa-5e94-4a5b-a877-6c2530322dbc")
    private ILoadHelper loadHelper;

    /**
     * Initialize a JSON repository from an JSON resource provider.
     *
     * @param resProvider an JSON resource provider.
     */
    @objid ("6884dbe3-c416-48bc-b028-4407dd983129")
    public JsBase(IExmlResourceProvider resProvider) {
        super(resProvider);
    }

    /**
     * Initialize a JSON repository from a directory path.
     * <p>
     * The repository needs to be {@link #open(IModelLoaderProvider, IModelioProgress) opened} before being used.
     *
     * @param path a directory path.
     * @param name a repository identifier to use in messages.
     * @throws IOException in case of failure.
     */
    @objid ("bd0726e4-d0c0-488a-944e-d2c59e186291")
    public JsBase(final Path path, final String name) throws IOException {
        super(path, path, name);
    }

    @objid ("2b0d2c04-74ac-4010-9c3a-355ac10fb740")
    @Override
    public synchronized void doReloadCmsNode(final SmObjectImpl obj, IModelLoader modelLoader) throws DuplicateObjectException, IOException, IndexException {
        final ObjId cmsNodeId = new ObjId(obj);

        ExmlResource resource = getResourceProvider().getResource(cmsNodeId);
        if (resource == null) {
            // No JSON for this node, set the object as shell.
            throw new FileNotFoundException(cmsNodeId.toString());
        } else {
            try(InputStream is= resource.bufferedRead()) {
                if (is == null) {
                    // Exml not found, set the object as shell.
                    throw new FileNotFoundException(resource.getPublicLocation());
                } else {
                    InputSource isrc = new InputSource(is);
                    isrc.setPublicId(resource.getPublicLocation());

                    new JsonModelParser(getloadHelper()).load(isrc, modelLoader);
                }
            }
        }
    }

    @objid ("998948e4-82ce-4343-863f-c4f42edd398d")
    @Override
    protected ILoadHelper getloadHelper() {
        return this.loadHelper;
    }

    @objid ("35e1547f-5c7a-4146-9a7c-614533ce0462")
    @Override
    protected void initializeLoader() {
        this.loadHelper = new LoadHelper(this, isWriteable());
    }

    @objid ("a8beb568-6624-4d2e-ac97-06d2471fefc2")
    @Override
    protected void save(ExmlStorageHandler handler, final IModelioProgress progress) throws IOException {
        SmObjectImpl cmsNode = handler.getCmsNode();
        ObjId cmsNodeId = handler.getCmsNodeId();

        try (OutputStream os = getResourceProvider().getResource(cmsNodeId).bufferedWrite()){
            JsStoreSaver saver = new JsStoreSaver();
            saver.externalize(cmsNode, os);
        }
    }

}

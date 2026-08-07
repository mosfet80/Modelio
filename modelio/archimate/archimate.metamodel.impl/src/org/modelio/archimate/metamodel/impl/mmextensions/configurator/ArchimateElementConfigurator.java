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
package org.modelio.archimate.metamodel.impl.mmextensions.configurator;

import java.util.Map;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.vcore.model.api.IElementConfigurator;
import org.modelio.vcore.smkernel.mapi.MObject;

/**
 * Implementation of {@link IElementConfigurator} for Archimate.
 */
@objid ("a9b15fea-0888-4093-9dc9-1dcf96a87b7b")
public class ArchimateElementConfigurator implements IElementConfigurator {
    @objid ("267f8a1d-47b8-404e-b976-bc2fc621d32c")
    @Override
    public void configure(MObject element, Map<String, Object> properties) {
        /*ArchimateElementConfiguratorVisitor visitor = new ArchimateElementConfiguratorVisitor(
                MTools.get(element).getModelFactory(IArchimateModelFactory.class),
                properties);

        element.accept(visitor);*/

    }

}

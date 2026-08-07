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
package org.modelio.archimate.extensions.plugin;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.core.structure.ArchimateProject;
import org.modelio.platform.script.engine.core.engine.IClassLoaderProvider;

/**
 * Class providing a classloader to the script.engine plugin to make the archimate.api plugin accessible with jython.
 * <p>
 * The archimate.api plugin can't depend on script.engine, so we have to implement this class here instead.
 * </p>
 * <p>
 * See also plugin.xml for extension point declaration.
 * </p>
 */
@objid ("e28ba32c-b81e-49a7-ae23-b4aa492d08ec")
public class ArchimateClassLoaderProvider implements IClassLoaderProvider {
    @objid ("9026a34d-91dd-44d3-8985-ed390d23274a")
    @Override
    public ClassLoader getClassLoader() {
        return ArchimateProject.class.getClassLoader();
    }

}

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
/*
 * Copyright 2013-2024 Docaposte
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
package org.modelio.vcore.smkernel.mapi;

import java.util.Collection;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.meta.SmDependency;

/**
 * Complex queries that must be implemented.
 *
 * @since 6.0.1 10/09/2024
 * @deprecated Alpha stage, will probably change, may be deleted or renamed without notice.
 */
@objid ("6bf65787-df40-4702-96b8-a8129e72b690")
@Deprecated(since = "6.0.1", forRemoval = false)
public interface MQueryRunner extends AutoCloseable {
    /**
     * Load all model objects that reference the given ones, with the dependency used to reference them.
     * <p>
     * Must load navigable <b>and</b> non navigable dependencies.
     * To be used to navigate many non navigable dependencies at once, avoiding plenty database queries.
     * <p>
     * After having called this method, call {@link SmDependency#getValueAsCollection(org.modelio.vcore.smkernel.ISmObjectData)}
     * to get the loaded values instead of calling standard getters.
     *
     * @param objs all model objects whose all dependencies must be loaded.
     */
    @objid ("b7f015a5-c730-4a78-845d-998c6ef81157")
    void loadAllReferencesTo(Collection<SmObjectImpl> objs);

    /**
     * Get the loaded dependency value.
     * <p>
     * {@link #loadAllReferencesTo(Collection)} must have been called with the object passed in the collection before,
     * or undefined behavior will occur.
     *
     * @param object the model object data.
     * @return the dependency content.
     */
    @objid ("be9762fa-e014-4d70-9493-91a0c08ccb52")
    Collection<SmObjectImpl> getDepValue(SmObjectImpl object, SmDependency dep);

    /**
     * May release or unload all allocated resources or restore the loaded state.
     */
    @objid ("eaa3760f-ec69-4a45-8b8a-cb22d2d0b3ee")
    @Override
    void close();

}

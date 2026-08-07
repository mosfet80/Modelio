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
package org.modelio.vstore.exml.common.index;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Stream;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.vbasic.files.StreamException;
import org.modelio.vstore.exml.common.model.ObjId;

/**
 * Interface for the node uses indexes.
 */
@objid ("de5a4021-5c79-11e1-863f-001ec947ccaf")
public interface IUserNodeIndex {
    /**
     * Remove a CMS node from the indexes.
     *
     * @throws IndexException in case of IO failure.
     */
    @objid ("32337f90-5c7b-11e1-863f-001ec947ccaf")
    void remove(final ObjId id) throws IndexException;

    /**
     * Add a used object.
     *
     * @param userNodeId the user CMS node
     * @param depName the dependency from user to used.
     * @param usedObjectId the used object.
     * @throws IndexException in case of IO failure.
     */
    @objid ("32337f93-5c7b-11e1-863f-001ec947ccaf")
    void addUsed(final ObjId userNodeId, String depName, final ObjId usedObjectId) throws IndexException;

    /**
     * Get the model objects using the given object.
     *
     * @param objectId an object ID.
     * @return The ID of all CMS nodes using it.
     * @throws IndexException in case of IO failure.
     */
    @objid ("32337f98-5c7b-11e1-863f-001ec947ccaf")
    Collection<ObjId> getObjectUsers(ObjId objectId, String depName) throws IndexException;

    /**
     * Get the model objects using the given objects.
     *
     * @param objectIds many object IDs.
     * @return The ID of all objects using them, in any order.
     * @throws IndexException in case of IO failure.
     * @since 6.0.1 11/09/2024
     */
    @objid ("7ecebf71-933e-49b2-8698-051f6a2a2e22")
    default Collection<ObjId> getObjectUsers(Collection<ObjId> objectIds) throws IndexException {
        Collection<ObjId> ret = new ArrayList<ObjId>(objectIds.size() * 2);
        for (ObjId obj : objectIds) {
            ret.addAll(getObjectUsers(obj, null));
        }
        return ret;
    }

    /**
     * Get the model objects using the given objects.
     *
     * @param objectIds many object IDs.
     * @return The ID of all objects using them, in any order.
     * @throws StreamException contains a IndexException in case of IO failure.
     * @since 6.0.1 11/09/2024
     */
    @objid ("c98b4158-1348-4be1-a0d9-87a381bffd37")
    default Stream<ObjId> getObjectUsers(Stream<ObjId> objectIds) throws StreamException {
        return objectIds.flatMap(id -> {
            try {
                return getObjectUsers(id, null).stream();
            } catch (IndexException e) {
                throw new StreamException(e);
            }
        });
    }

}

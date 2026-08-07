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
package org.modelio.vstore.exml.common.model;

import java.util.Objects;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

/**
 * Result of ICmsNodeIndex#findById .
 */
@objid ("f1d8ff28-b523-4b88-bb22-8d42f7d93d24")
public class IndexElement {
    /**
     * The object
     */
    @objid ("c58953a9-8703-4695-b8e2-b72a245898d9")
    public final ObjIdName object;

    /**
     * The CMS node containing the object
     */
    @objid ("e41fef41-182e-4f38-a249-f6d943e41d29")
    public final ObjId cmsNode;

    @objid ("ddf1fa12-4094-4a03-8b9c-bdc2407e9156")
    public IndexElement(ObjIdName object, ObjId cmsNode) {
        super();
        this.object = object;
        this.cmsNode = cmsNode;
    }

    @objid ("cc53f01f-6d93-46e3-90c0-e29572bebb02")
    @Override
    public int hashCode() {
        return Objects.hash(this.cmsNode, this.object);
    }

    @objid ("d41c1b0d-9607-430d-81cb-5dbdf8ac3a5a")
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        IndexElement other = (IndexElement) obj;
        return Objects.equals(this.cmsNode, other.cmsNode) && Objects.equals(this.object, other.object);
    }

    @objid ("91f5db88-fc30-47bd-bec7-62d5fcae8fca")
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("IndexElement [");
        if (this.object != null) {
            builder.append("object=");
            builder.append(this.object);
            builder.append(", ");
        }
        if (this.cmsNode != null) {
            builder.append("cmsNode=");
            builder.append(this.cmsNode);
        }
        builder.append("]");
        return builder.toString();
    }

}

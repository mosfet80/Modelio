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
package org.modelio.platform.model.ui.panels.search.advanced.datas;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("8ec49af2-3e6c-4b5b-bde1-2473ab77f5f7")
public enum NameMatchMode {
    @objid ("6a6ddd30-185e-4b82-94f8-ff88c3df6654")
    EXACT,
    @objid ("9644a3da-0574-4ec3-8eb6-40b54040fd52")
    CONTAINS,
    @objid ("89abe63d-e437-49a9-976c-1faffc9b7a72")
    STARTS_WITH,
    @objid ("aa8ba061-6b30-4a9a-8f85-6569bccb0289")
    ENDS_WITH;

}

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
package org.modelio.archimate.metamodel.impl.mmextensions.namer;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.core.Relationship;
import org.modelio.archimate.metamodel.core.structure.ArchimateProject;
import org.modelio.archimate.metamodel.visitors.DefaultArchimateVisitor;
import org.modelio.vcore.smkernel.mapi.MObject;

@objid ("45753c2a-c7f9-4826-a10e-ecf5253aa9ab")
class GetArchiNameVisitor extends DefaultArchimateVisitor {
    @objid ("2f00a431-38f5-412f-9846-bf666de767a5")
    public String getDefaultName(MObject object) {
        String result = (String) object.accept(this);
        if (result != null) {
            return result;
        }
        String baseName = object.getMClass().getName();
        char[] chars = baseName.toCharArray();

        StringBuilder newName = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (i > 0 && Character.isUpperCase(chars[i])) {
                newName.append(" ");
            }
            newName.append(chars[i]);
        }
        return newName.toString();
    }

    @objid ("adfb0942-5ecc-4478-b603-986950458b25")
    @Override
    public Object visitRelationship(Relationship theRelationship) {
        return "";
    }

    @objid ("61e82f78-32c1-4b07-93a8-51f7ba22116f")
    @Override
    public Object visitArchimateProject(ArchimateProject theArchimateProject) {
        return "ArchiMate";
    }

}

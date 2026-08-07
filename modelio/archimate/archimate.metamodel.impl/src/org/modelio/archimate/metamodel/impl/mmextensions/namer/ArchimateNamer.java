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

import java.util.Set;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.diagrams.AbstractDiagram;
import org.modelio.metamodel.uml.infrastructure.Element;
import org.modelio.vcore.model.api.IElementNamer;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.mapi.MObject;

@objid ("cf8911d7-79e2-430a-b2b3-051f969e2f5c")
public class ArchimateNamer implements IElementNamer {
    /*
         * This implementation simply returns the metaclass name.
         */
    @objid ("fdea1001-31f4-484a-9bbd-7b79ffc81b2b")
    @Override
    public String getBaseName(MClass metaclass) {
        assert (metaclass != null);
        return metaclass.getName();
    }

    /**
     * This implementation uses an auxiliary visitor to generate a name for the object that can be smarter than just its metaclass
     * name.
     */
    @objid ("f2efa887-c605-4431-bce4-cef84d616a4e")
    @Override
    public String getBaseName(final MObject object) {
        assert (object != null);
        GetArchiNameVisitor visitor = new GetArchiNameVisitor();
        return visitor.getDefaultName(object);
    }

    /**
     * This implementation uses an auxiliary visitor to generate a name for the object that can be smarter than just its metaclass
     * name.
     */
    @objid ("946f69ec-e7ee-4558-9e26-9e8b915e9bb3")
    @Override
    public String getUniqueName(MObject object) {
        assert (object != null);
        return getUniqueName(getBaseName(object), object);
    }

    /**
     * This implementation returns basename unless this name is already used in which case it is completed with the smaller possible
     * value for X an integer such as basenameX does not exist.
     */
    @objid ("6e7f84e2-ffa9-4742-9405-68335f8afcf2")
    @Override
    public String getUniqueName(String basename, MObject object) {
        boolean diagramsuffix = (object instanceof AbstractDiagram);

        assert (basename != null);
        assert (object != null);

        final Set<String> siblingIdentifiers = getSiblingIdentifiers(object);

        String newName = basename;
        int i = 0;
        while (siblingIdentifiers.contains(newName)) {
            i = i + 1;
            if (diagramsuffix) {
                newName = basename + " (" + i + ")";
            } else {
                newName = basename + i;
            }
        }
        return newName;
    }

    @objid ("8234c2a9-217b-46a8-859c-44142b7ad56a")
    private static Set<String> getSiblingIdentifiers(MObject object) {
        final GetArchiSiblingsVisitor v = new GetArchiSiblingsVisitor();
        final Set<String> results = v.getSiblings((Element) object);
        return results;
    }

}

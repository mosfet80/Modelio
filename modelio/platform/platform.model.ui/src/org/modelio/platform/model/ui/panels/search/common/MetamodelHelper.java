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
package org.modelio.platform.model.ui.panels.search.common;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.uml.infrastructure.MetaclassReference;
import org.modelio.metamodel.uml.infrastructure.Stereotype;
import org.modelio.metamodel.uml.infrastructure.TagType;
import org.modelio.metamodel.uml.infrastructure.properties.PropertyDefinition;
import org.modelio.metamodel.uml.infrastructure.properties.PropertyTableDefinition;
import org.modelio.vcore.session.api.ICoreSession;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.mapi.MDependency;
import org.modelio.vcore.smkernel.meta.SmClass;

@objid ("4304724d-05b7-468e-9191-db68da6d08fa")
public class MetamodelHelper {
    @objid ("1469162a-a72c-465e-aa96-90d6d744eb41")
    private ICoreSession session;

    @objid ("504854d1-b14f-490e-8c6a-fb876c07c377")
    private List<SmClass> mlinks = new ArrayList<>();

    @objid ("db82e4c5-edc0-46e0-aa1c-1d8e1f2de966")
    private Map<String, List<MClass>> mclassByDependencyName = new HashMap<>();

    @objid ("f8eaf103-cd24-48dd-b0af-eebd7918981d")
    public MetamodelHelper(ICoreSession session) {
        this.session = session;
        initCaches();
    }

    @objid ("c83f4f43-90f5-465a-83f6-c88bc5829873")
    private void initCaches() {
        // Find Links
        for (SmClass sClass : session.getMetamodel().getRegisteredMClasses()) {
            if (sClass.isLinkMetaclass()) {
                mlinks.add(sClass);
            }

        }

        this.mlinks.sort(new Comparator<SmClass>() {
            @Override
            public int compare(SmClass o1, SmClass o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        for (SmClass sClass : session.getMetamodel().getRegisteredMClasses()) {
            for (MDependency dep : sClass.getDependencies(true)) {
                List<MClass> mClasses = this.mclassByDependencyName.get(dep.getName());
                if (mClasses == null) {
                    mClasses = new ArrayList<>();
                    this.mclassByDependencyName.put(dep.getName(), mClasses);
                }
                mClasses.add(sClass);
            }
        }
    }

    @objid ("1c3ec34f-4205-4722-bce0-64119f898371")
    public List<String> getAvailableLinkMetaclass(MClass context) {
        return this.mlinks.stream().map(sc -> sc.getName()).toList();
    }

    @objid ("dc226998-71fd-4201-a10e-9b9cfba855fe")
    public MClass getMClassByName(String name) {
        return this.session.getMetamodel().getMClass(name);
    }

    @objid ("1a530ac1-cef3-4afe-ae6d-6d93653fddd0")
    public List<MDependency> getMDependencyByMetaclass(String metaclassName) {
        MClass mClass = this.session.getMetamodel().getMClass(metaclassName);

        List<MDependency> owners = mClass.getDependencies(true).stream().filter(d -> d.getSymetric().isComposition())
                .sorted(new MDependencyComparator()).toList();
        List<MDependency> childrens = mClass.getDependencies(true).stream().filter(d -> d.isComposition())
                .sorted(new MDependencyComparator()).toList();
        List<MDependency> others = mClass.getDependencies(true).stream()
                .filter(d -> !d.getSymetric().isComposition() && !d.isComposition()).sorted(new MDependencyComparator())
                .toList();

        List<MDependency> result = new ArrayList<>();

        result.addAll(owners);
        result.addAll(childrens);
        result.addAll(others);
        return result;
    }

    @objid ("31cf6399-06c6-401a-9af5-ad74541473b8")
    public MDependency getMDependencyByMetaclass(MClass mClass, String depName) {
        Optional<MDependency> depOpt = mClass.getDependencies(true).stream().filter(d -> d.getName().equals(depName))
                .findFirst();
        if (depOpt.isPresent()) {
            return depOpt.get();
        }
        return null;
    }

    @objid ("a583e3e8-2699-4e81-8671-b5262b4e6c47")
    public MClass getMClassByDependencyName(String depName) {
        List<MClass> mClasses = this.mclassByDependencyName.get(depName);
        if (mClasses == null || mClasses.isEmpty()) {
            return null;
        } else {
            return mClasses.getFirst();
        }
    }

    @objid ("d643061f-fd59-4adf-8936-a546c3e6800c")
    public List<MPropertyInfo> getAttributeByMetaclass(MClass mclass) {
        return mclass.getAttributes(true).stream().map(elt -> new MPropertyInfo(elt.getName(), elt)).toList();
    }

    @objid ("b7057e79-a923-4556-b4df-7e973a77ffa3")
    public List<MPropertyInfo> getTagTypeByMetaclass(MClass mclass) {
        Collection<MetaclassReference> metaRefs = this.session.getModel().findByClass(MetaclassReference.class);

        // List MetaclassReference for mclass and its super class
        List<MetaclassReference> mclassMetaRefs = new ArrayList<>();

        // Find hierarchy of mclass
        MClass currentMClass = mclass;
        while (currentMClass != null) {
            for (MetaclassReference mtRef : metaRefs) {
                if (mtRef.getReferencedClassName() != null
                        && mtRef.getReferencedClassName().equals(currentMClass.getQualifiedName())) {
                    mclassMetaRefs.add(mtRef);
                }
            }
            currentMClass = currentMClass.getSuper();
        }

        // Get TagType from MetaclassReference
        List<TagType> tagTypes = new ArrayList<>();
        for (MetaclassReference mtRef : mclassMetaRefs) {
            tagTypes.addAll(mtRef.getDefinedTagType());
        }

        return tagTypes.stream().map(elt -> new MPropertyInfo(elt.getName(), elt)).toList();
    }

    @objid ("f184f636-4e35-41c9-9bd7-00769e5cdd87")
    public List<MPropertyInfo> getPropertyTypeMetaclass(MClass mclass) {
        Collection<MetaclassReference> metaRefs = this.session.getModel().findByClass(MetaclassReference.class);

        // List MetaclassReference for mclass and its super class
        List<MetaclassReference> mclassMetaRefs = new ArrayList<>();

        // Find hierarchy of mclass

        for (MetaclassReference mtRef : metaRefs) {
            if (mtRef.getReferencedClassName() != null
                    && mtRef.getReferencedClassName().equals(mclass.getQualifiedName())) {
                mclassMetaRefs.add(mtRef);
            }
        }

        // Get PropertyTableDefinition from MetaclassReference
        List<PropertyDefinition> porpTypes = new ArrayList<>();
        for (MetaclassReference mtRef : mclassMetaRefs) {
            PropertyTableDefinition difTable = mtRef.getDefinedTable();
            if (difTable != null) {
                porpTypes.addAll(difTable.getOwned());
            }
        }

        return porpTypes.stream().map(elt -> new MPropertyInfo(elt.getName(), elt)).toList();
    }

    @objid ("db92758d-d02f-43c5-9ff2-e0fb2c73539d")
    public List<MPropertyInfo> getTagTypeByStereotype(Stereotype stereotype) {
        List<Stereotype> stereotypeRefs = new ArrayList<>();

        // List Stereotype Hierarchy for STEREOTYPE
        Stereotype currentStereotype = stereotype;
        while (currentStereotype != null) {
            stereotypeRefs.add(currentStereotype);
            currentStereotype = currentStereotype.getParent();
        }

        List<TagType> tagTypes = new ArrayList<>();
        for (Stereotype ster : stereotypeRefs) {
            tagTypes.addAll(ster.getDefinedTagType());
        }

        return tagTypes.stream().map(elt -> new MPropertyInfo(elt.getName(), elt)).toList();
    }

    @objid ("38df031d-de0b-4190-b61d-da6aa7531f6e")
    public List<MPropertyInfo> getPropertyTypeStereotype(Stereotype stereotype) {
        List<Stereotype> stereotypeRefs = new ArrayList<>();

        // List Stereotype Hierarchy for STEREOTYPE
        Stereotype currentStereotype = stereotype;
        while (currentStereotype != null) {
            stereotypeRefs.add(currentStereotype);
            currentStereotype = currentStereotype.getParent();
        }

        // Get PropertyTableDefinition from Stereotype
        List<PropertyDefinition> porpTypes = new ArrayList<>();
        for (Stereotype ster : stereotypeRefs) {
            PropertyTableDefinition difTable = ster.getDefinedTable();
            if (difTable != null) {
                porpTypes.addAll(difTable.getOwned());
            }
        }

        return porpTypes.stream().map(elt -> new MPropertyInfo(elt.getName(), elt)).toList();
    }

    @objid ("e86b4661-f83f-43e8-b138-a64b8663f845")
    public List<MPropertyInfo> getAllAttributesByMetaclass(MClass mclass) {
        List<MPropertyInfo> attributes = new ArrayList<>();
        attributes.addAll(getAttributeByMetaclass(mclass));
        attributes.addAll(getPropertyTypeMetaclass(mclass));
        attributes.addAll(getTagTypeByMetaclass(mclass));
        return attributes;
    }

    @objid ("b3689f4d-fb79-4001-9e75-598cb9a1dca4")
    public List<MPropertyInfo> getAllAttributesByStereotype(Stereotype stereotype) {
        List<MPropertyInfo> attributes = new ArrayList<>();

        MClass baseClass = this.session.getMetamodel().getMClass(stereotype.getBaseClassName());
        attributes.addAll(getAllAttributesByMetaclass(baseClass));
        attributes.addAll(getPropertyTypeStereotype(stereotype));
        attributes.addAll(getTagTypeByStereotype(stereotype));
        return attributes;
    }

    @objid ("9a9bd163-fa26-4972-a448-da6259b58f24")
    private class MDependencyComparator implements Comparator<MDependency> {
        @objid ("ea9a3357-9103-4515-a5c6-a32cff06711d")
        @Override
        public int compare(MDependency o1, MDependency o2) {
            return o1.getName().compareTo(o2.getName());
        }

    }

    @objid ("ceeba04c-ba85-4f87-9921-91ace0a19374")
    public record MPropertyInfo ( String label,
            Object type )  {
    }

}

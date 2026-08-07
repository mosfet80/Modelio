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
package org.modelio.archimate.ui.browser.contrib;

import java.net.URL;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.graphics.Image;
import org.modelio.archimate.metamodel.core.Concept;
import org.modelio.archimate.metamodel.core.Relationship;
import org.modelio.archimate.metamodel.core.generic.composite.Grouping;
import org.modelio.archimate.metamodel.core.generic.composite.Location;
import org.modelio.archimate.metamodel.core.structure.ArchimateProject;
import org.modelio.archimate.metamodel.core.structure.Folder;
import org.modelio.archimate.metamodel.core.structure.Model;
import org.modelio.archimate.metamodel.core.structure.ViewPoint;
import org.modelio.archimate.metamodel.relationships.other.Junction;
import org.modelio.archimate.metamodel.visitors.DefaultArchimateVisitor;
import org.modelio.archimate.ui.plugin.ArchiUi;
import org.modelio.gproject.core.IGModelFragment;
import org.modelio.gproject.core.IGProject;
import org.modelio.gproject.project.AbstractGProject;
import org.modelio.model.browser.view.content.IModelioTreeContentProvider;
import org.modelio.platform.model.ui.swt.labelprovider.AbstractContainer;
import org.modelio.platform.model.ui.swt.labelprovider.LinkContainer;
import org.modelio.vcore.session.api.repository.IRepository;
import org.modelio.vcore.smkernel.mapi.MObject;

/**
 * Default content provider with Archimate elements for the model browser.
 */
@objid ("6ae94d87-0203-43b2-a1d4-d26fcc2539cf")
public class ArchimateBrowserContentProvider implements IModelioTreeContentProvider {
    @objid ("36ecbe74-dd8d-43f6-9e16-bc52232c14c2")
    private boolean showArchimateModel = true;

    @objid ("d96826d5-3486-478a-ac3c-616890ad2fd5")
    private Viewer currentViewer;

    @objid ("e8f5f1fd-36bc-4c6f-86b8-d93b916668fa")
    private static ArchimateVisitor visitor = new ArchimateVisitor();

    @objid ("40ecd4b7-591c-40fc-b84d-3b9f394dfc50")
    @Override
    public void inputChanged(final Viewer viewer, final Object oldInput, final Object newInput) {
        this.currentViewer = viewer;
    }

    @objid ("1b69d672-2989-44e0-848b-269eb9138cfc")
    @Override
    public void dispose() {
        // Nothing to do.
    }

    @objid ("e6f2d3eb-a9c5-42f2-a342-642c81657e0c")
    @Override
    public Object[] getElements(final Object parent) {
        // Nothing to return yet
        return new Object[0];
    }

    @objid ("4706c06a-dec4-43ac-b32e-80ff65f5d27f")
    @Override
    public Object getParent(final Object child) {
        if (child instanceof MObject) {
            MObject element = (MObject) child;
            MObject owner = element.getCompositionOwner();
            if (owner != null) {
                // look for right container
                if (ArchimateBrowserContentProvider.visitor.getLinks(owner).contains(element)) {
                    return new LinkContainer(owner, null);
                }

                if (ArchimateBrowserContentProvider.visitor.getGroupings(owner).contains(element)) {
                    return new GroupingContainer(owner, null);
                }

                return owner;
            } else {
                IGProject project = AbstractGProject.getProject(element);
                if (project != null) {
                    return project.getFragment(element);
                }
            }
        }
        return null;
    }

    @objid ("e776298c-2a5e-4589-a59b-0eef2d661615")
    @Override
    public Object[] getChildren(final Object parent) {
        if (parent instanceof IGModelFragment) {
            IGModelFragment fragment = (IGModelFragment) parent;
            return getFragmentRoots(fragment).toArray();
        }

        if (parent instanceof GroupingContainer) {
            return ((GroupingContainer) parent).getContents().toArray();
        }
        // Sort elements in Archimate Folders
        if (parent instanceof Folder) {
            List<Object> childrens = getChildren((MObject) parent);
            Collections.sort(childrens, comparator());
            return childrens.toArray();
        }

        if (parent instanceof MObject) {
            return getChildren((MObject) parent).toArray();
        }
        return new Object[0];
    }

    @objid ("e5c03766-d961-4ae7-98fa-08df223037e4")
    private Comparator<Object> comparator() {
        return new Comparator<>() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Folder && !(o2 instanceof Folder)) {
                    return -1;
                }
                if (o2 instanceof Folder && !(o1 instanceof Folder)) {
                    return 1;
                }
                if (o1 instanceof MObject && o2 instanceof MObject) {
                    MObject object1 = (MObject) o1;
                    MObject object2 = (MObject) o2;
                    final Collator instance = Collator.getInstance();
                    // This strategy mean it'll ignore the accents and the case
                    instance.setStrength(Collator.PRIMARY);
                    if (!isNumber(object1.getName(), object2.getName())) {
                        return instance.compare(object1.getName(), object2.getName());
                    } else {
                        int nu1 = Integer.parseInt(object1.getName());
                        int nu2 = Integer.parseInt(object2.getName());
                        if (nu1 > nu2)
                            return 1;
                        else
                            return -1;
                    }

                }
                return 0;
            }
        };
    }

    @objid ("f73c7e12-87ab-4a26-b623-6081ae415326")
    private static Boolean isNumber(String n1, String n2) {
        try {
            int nu1 = Integer.parseInt(n1);
            int nu2 = Integer.parseInt(n2);
            return true;
        } catch (Exception x) {
            return false;
        }
    }

    @objid ("e5421668-978b-43ca-9bda-7ddbc2342389")
    @Override
    public boolean hasChildren(final Object parent) {
        if (parent instanceof IGModelFragment) {
            return hasChildren((IGModelFragment) parent);
        }

        if (parent instanceof MObject) {
            return hasChildren((MObject) parent);

        }

        // Not expected, returning yes allows for next getChildren() call in any case, might help debugging :)
        return true;
    }

    /**
     * Get children for a IGModelFragment
     */
    @objid ("3dd410a1-779f-42a1-b718-5282e2a2142e")
    private List<Object> getFragmentRoots(IGModelFragment fragment) {
        List<Object> ret = new ArrayList<>();

        IRepository repository = fragment.getRepository();
        if (repository != null) {
            for (MObject root : fragment.getRoots()) {
                if (root.isValid() && root instanceof ArchimateProject) {
                    ret.add(root);
                }
            }
        }
        return ret;
    }

    @objid ("095dba2e-0ef2-4df5-abb1-4d81acffbd68")
    public boolean isShowArchimateModel() {
        return this.showArchimateModel;
    }

    @objid ("74f9c09e-f2b2-4edc-9362-32180945463a")
    public void setShowArchimateModel(boolean showArchimateModel) {
        this.showArchimateModel = showArchimateModel;
        if (this.currentViewer != null) {
            this.currentViewer.refresh();
        }
    }

    /**
     * Get children for a MObject
     */
    @objid ("8fb7c6d1-658c-4d40-a0ea-cf25c9c5dca5")
    private List<Object> getChildren(MObject parent) {
        List<Object> elements = ArchimateBrowserContentProvider.visitor.getElements(parent);
        List<MObject> groupings = ArchimateBrowserContentProvider.visitor.getGroupings(parent);
        List<MObject> links = ArchimateBrowserContentProvider.visitor.getLinks(parent);

        List<Object> ret = new ArrayList<>(elements.size() + 2);

        ret.addAll(elements);

        if (!groupings.isEmpty()) {
            ret.add(new GroupingContainer(parent, groupings));
        }
        if (!links.isEmpty()) {
            links.sort(linkComparator());
            ret.add(new LinkContainer(parent, links));
        }
        return ret;
    }

    @objid ("129fe09a-2f70-4502-9129-21278ca96082")
    private Comparator<MObject> linkComparator() {
        final Collator collator = Collator.getInstance();
        collator.setStrength(Collator.PRIMARY);
        return (o1, o2) -> {
            // 1. Sort by link type
            int cmp = collator.compare(o1.getMClass().getName(), o2.getMClass().getName());
            if (cmp != 0) {
                return cmp;
            }
            // 2. Sort by target element name
            if (o1 instanceof Relationship && o2 instanceof Relationship) {
                Concept to1 = ((Relationship) o1).getTo();
                Concept to2 = ((Relationship) o2).getTo();
                if (to1 != null && to2 != null) {
                    cmp = collator.compare(to1.getName(), to2.getName());
                    if (cmp != 0) {
                        return cmp;
                    }
                }
            }
            // 3. Sort by link own name
            return collator.compare(o1.getName(), o2.getName());
        };
    }

    @objid ("80fc71d8-859d-4663-a023-f8ebccbd3344")
    private boolean hasChildren(IGModelFragment fragment) {
        return !getFragmentRoots(fragment).isEmpty();
    }

    @objid ("c58a71ba-dcb4-4647-bbfd-3f99321bb2f4")
    private boolean hasChildren(MObject parent) {
        return !(ArchimateBrowserContentProvider.visitor.getElements(parent).isEmpty() && ArchimateBrowserContentProvider.visitor.getLinks(parent).isEmpty() && ArchimateBrowserContentProvider.visitor.getGroupings(parent).isEmpty());
    }

    @objid ("5251398d-02ba-46e7-80ac-e7e097102855")
    @Override
    public boolean canReorder(Object treeContent) {
        return !(treeContent instanceof Concept || treeContent instanceof Folder) || treeContent instanceof Model;
    }

    /**
     * Visitor used to get tree node children.
     * <p>
     * <h3>Implementation note:</h3> If {@link #includeLinks} is <code>true</code>, the implementation should use {@link #addResults(List)} so that children tree nodes are linked to the container.
     * </p>
     * This should help the tree view not shrinking sometimes.
     * <p>
     * In the other case {@link #addResults(List)} should be called, to avoid creating adapters for nothing.
     * </p>
     */
    @objid ("e5e0815e-5026-44e6-ad2c-9c561c7c03db")
    private static class ArchimateVisitor extends DefaultArchimateVisitor {
        /**
         * Show 'link' container and links
         */
        @objid ("9109de2d-dfa3-4316-95d3-02da68da7122")
        private boolean includeLinks;

        /**
         * Show archimate model or not
         */
        @objid ("1f4dc1bf-ce3e-4166-b3eb-9dad28729ff7")
        private boolean includeElements;

        /**
         * Show Grouping model or not
         */
        @objid ("ec733e66-2625-4a79-9940-eb52ea89cfed")
        private boolean includeGroupings;

        @objid ("a072a22e-70ff-46c7-b5a8-f24603cc0c4f")
        private List<Object> elements;

        @objid ("b51aa955-2210-4bd7-b09d-546acf17967f")
        private List<MObject> links;

        @objid ("7463d5ea-56da-4ebe-be03-4c626708cea5")
        private List<MObject> groupings;

        @objid ("bd73aa4b-a601-4ba4-a8fa-a3f86a76cbf0")
        public ArchimateVisitor() {
            // nothing to do
        }

        @objid ("dc652576-fcc6-49dd-b05d-2fc3063de9c7")
        @Override
        public Object visitArchimateProject(ArchimateProject theArchimateProject) {
            if (this.includeElements) {
                // Models
                addElements(theArchimateProject.getModel());

                // ViewPoints
                addElements(theArchimateProject.getViewPoints());
            }
            return super.visitArchimateProject(theArchimateProject);
        }

        @objid ("53e77752-fc51-417f-a4b1-8cd775f07848")
        @Override
        public Object visitConcept(Concept theArchimateConcept) {
            if (this.includeLinks) {
                List<Relationship> toRelationships = new ArrayList<>(theArchimateConcept.getRelatedTo());
                addLinks(toRelationships);
            }
            return super.visitConcept(theArchimateConcept);
        }

        @objid ("06a27376-09bd-4103-9dd9-c09401ef06e2")
        @Override
        public Object visitFolder(org.modelio.archimate.metamodel.core.structure.Folder theArchimateFolder) {
            if (this.includeElements) {
                // Folders
                addElements(theArchimateFolder.getFolder());

                // Contents
                List<Concept> concepts = new ArrayList<>();
                for (Concept concept : theArchimateFolder.getContent()) {
                    if (!isGroupingChild(concept)) {
                        concepts.add(concept);
                    }
                }
                addElements(concepts);

            }

            // Grouping
            if (this.includeGroupings) {
                for (Concept concept : theArchimateFolder.getContent().stream().filter(elt -> isGroupingChild(elt)).sorted(groupingComparator()).collect((Collectors.toList()))) {
                    addGrouping(concept);
                }
            }
            return super.visitFolder(theArchimateFolder);
        }

        @objid ("c2bc5fd7-070c-4462-80b5-20b08674f547")
        private Comparator<Concept> groupingComparator() {
            return new Comparator<>() {
                @Override
                public int compare(Concept o1, Concept o2) {
                    if (o1 instanceof Grouping && !(o2 instanceof Grouping)) {
                        return -1;
                    }
                    if (o2 instanceof Grouping && !(o1 instanceof Grouping)) {
                        return 1;
                    }

                    final Collator instance = Collator.getInstance();
                    // This strategy mean it'll ignore the accents and the case
                    instance.setStrength(Collator.PRIMARY);
                    if (!isNumber(o1.getName(), o2.getName())) {
                        return instance.compare(o1.getName(), o2.getName());
                    } else {
                        int nu1 = Integer.parseInt(o1.getName());
                        int nu2 = Integer.parseInt(o2.getName());
                        if (nu1 > nu2)
                            return 1;
                        else
                            return -1;
                    }
                }
            };
        }

        @objid ("5a744653-ed13-4b81-8530-2f5fd5a8687f")
        public List<MObject> getLinks(MObject parent) {
            this.includeElements = false;
            this.includeLinks = true;
            this.includeGroupings = false;
            this.links = new ArrayList<>();
            parent.accept(this);
            return this.links;
        }

        /**
         * Avoid having a duplicated element in the result, but preserves order unlike a Set.
         *
         * @param elt the element to add.
         */
        @objid ("0b5ee7a6-4f52-4448-b875-dc443835a809")
        private void addElement(Object elt) {
            if (elt != null && !this.elements.contains(elt)) {
                this.elements.add(elt);
            }
        }

        /**
         * Avoid having duplicated elements in the result, but preserves order unlike a Set.
         *
         * @param elts the element to add.
         */
        @objid ("2956c3a7-b00a-483b-88b1-3ec16502fcc7")
        private void addElements(List<? extends MObject> elts) {
            if (elts.size() > 0) {
                for (MObject elt : elts) {
                    addElement(elt);
                }
            }
        }

        @objid ("31f3a78e-9b22-47f6-9bbf-c893b017038d")
        @Override
        public Object visitViewPoint(ViewPoint theViewPoint) {
            if (this.includeElements) {
                // ViewPoints
                addElements(theViewPoint.getChild());
            }
            return super.visitViewPoint(theViewPoint);
        }

        @objid ("44c0aaf9-9a6a-4cd8-acb3-15bb3c2c6a17")
        private boolean isGroupingChild(Concept concept) {
            return concept instanceof Grouping || concept instanceof Location || concept instanceof Junction;
        }

        @objid ("b754cf8c-ef48-484f-a5b0-b2305aff39a1")
        public List<Object> getElements(MObject parent) {
            this.includeElements = true;
            this.includeLinks = false;
            this.includeGroupings = false;
            this.elements = new ArrayList<>();
            parent.accept(this);
            return this.elements;
        }

        @objid ("267b3d54-080b-4e68-9bcf-f164f1b6fa01")
        public List<MObject> getGroupings(MObject parent) {
            this.includeElements = false;
            this.includeLinks = false;
            this.includeGroupings = true;
            this.groupings = new ArrayList<>();
            parent.accept(this);
            return this.groupings;
        }

        /**
         * Avoid having a duplicated element in the result, but preserves order unlike a Set.
         *
         * @param elt the element to add.
         */
        @objid ("bea139be-6cc6-4dfb-83e4-b8895a3f59e0")
        private void addLink(MObject elt) {
            if (elt != null && !this.links.contains(elt)) {
                this.links.add(elt);
            }
        }

        /**
         * Avoid having duplicated elements in the result, but preserves order unlike a Set.
         *
         * @param elts the element to add.
         */
        @objid ("3d89edb9-1546-4ede-9888-632d8a30503d")
        private void addLinks(List<? extends MObject> elts) {
            if (elts.size() > 0) {
                for (MObject elt : elts) {
                    addLink(elt);
                }
            }
        }

        /**
         * Avoid having a duplicated element in the result, but preserves order unlike a Set.
         *
         * @param elt the element to add.
         */
        @objid ("566bc647-8f44-4ced-b650-41deb895d63d")
        private void addGrouping(MObject elt) {
            if (elt != null && !this.groupings.contains(elt)) {
                this.groupings.add(elt);
            }
        }

        /**
         * Avoid having duplicated elements in the result, but preserves order unlike a Set.
         *
         * @param elts the element to add.
         */
        @objid ("72af021d-3272-4a0a-a695-850e353300cc")
        private void addGroupings(List<? extends MObject> elts) {
            if (elts.size() > 0) {
                for (MObject elt : elts) {
                    addGrouping(elt);
                }
            }
        }

    }

    /**
     * Model container that contains Grouping elements.
     */
    @objid ("8748b8bf-7345-4193-8c4e-f2a9e4d80a95")
    private static class GroupingContainer extends AbstractContainer<MObject> {
        @objid ("0eb711b6-8f29-4fb9-afff-233ba0884d24")
        public GroupingContainer(MObject owner, List<MObject> groupings) {
            super(owner, groupings);
        }

        @objid ("fac264c6-5b8d-41b5-a0af-e0a0e382504a")
        private static Image loadImage(String imageFilePath) {
            ImageDescriptor desc = null;
            Image image = null;

            // Get the relative file name
            final IPath imagePath = new Path(imageFilePath);
            final URL url = FileLocator.find(ArchiUi.getContext().getBundle(), imagePath, null);
            assert url != null : imagePath + " not found in " + ArchiUi.getContext().getBundle();

            if (url != null) {
                desc = ImageDescriptor.createFromURL(url);
                image = desc.createImage();
                assert image != null;
            }
            return image;
        }

        @objid ("e70a0777-0120-434d-b8d8-b74d9d99302f")
        @Override
        public String getLabel() {
            return ArchiUi.I18N.getString("BrowserLabelProvider.Grouping.label");
        }

    }

}

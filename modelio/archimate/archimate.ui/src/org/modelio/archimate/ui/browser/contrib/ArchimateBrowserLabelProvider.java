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

import java.util.Stack;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.StyledString.Styler;
import org.eclipse.swt.graphics.Image;
import org.modelio.archimate.metamodel.core.ArchimateAbstractElement;
import org.modelio.archimate.metamodel.core.ArchimateView;
import org.modelio.archimate.metamodel.core.Concept;
import org.modelio.archimate.metamodel.core.Relationship;
import org.modelio.archimate.metamodel.core.ViewPointDiagram;
import org.modelio.archimate.metamodel.core.structure.ArchimateProject;
import org.modelio.archimate.metamodel.visitors.DefaultArchimateVisitor;
import org.modelio.archimate.ui.plugin.ArchiUi;
import org.modelio.platform.model.ui.swt.images.ElementImageService;
import org.modelio.platform.model.ui.swt.images.ElementStyler;
import org.modelio.platform.model.ui.swt.images.IModelioElementLabelProvider;
import org.modelio.vcore.smkernel.mapi.MObject;

/**
 * Default label provider with Archimate elements for the model browser.
 */
@objid ("a354c01a-7bb0-4304-a864-02403536cd13")
public class ArchimateBrowserLabelProvider extends LabelProvider implements IModelioElementLabelProvider {
    @objid ("cc88835d-fbbf-48cf-bb6a-e34c2c5bba56")
    private final BrowserLabelService archimateLabelService = new BrowserLabelService();

    @objid ("857e9120-ac2c-447e-bbe6-5c430919354a")
    @Override
    public StyledString getStyledText(Object object) {
        if (object == null) {
            return new StyledString("<null>", StyledString.createColorRegistryStyler("red", null));
        } else if (object instanceof MObject) {
            return this.archimateLabelService.getLabel((MObject) object);
        }

        // Unknown object
        return null;
    }

    @objid ("9a779fba-a4a2-4ffe-9e97-ee85d5960a93")
    @Override
    public boolean showAsReference(Object object) {
        return false;
    }

    @objid ("bb370e09-f5ab-46b0-aed7-9c7e744ac4eb")
    @Override
    public Image getImage(Object object) {
        if (object instanceof MObject) {
            return ElementImageService.getIcon((MObject) object);
        }

        // Unknown object
        return null;
    }

    /**
     * This class provide the label of the elements displayed in the UML
     * explorer
     */
    @objid ("9f2c013b-fff8-467f-9e7b-960e707a153b")
    private static class BrowserLabelService extends DefaultArchimateVisitor {
        /**
         * a stack used for recursive calls to
         * {@link #getLabel(MObject)}
         */
        @objid ("99d092e9-4d9a-4d18-a037-c295b2b751d5")
        private final Stack<MObject> elementStack;

        @objid ("b5f5db41-6d14-46ba-9dc1-85102749551c")
        public BrowserLabelService() {
            this(new Stack<MObject>());
        }

        /**
         * Initialize the label service.
         *
         * @param elementStack a stack to use for recursive calls to
         * {@link #getLabel(MObject)}
         */
        @objid ("f6469e92-34d5-45c5-89a8-60623b433871")
        BrowserLabelService(Stack<MObject> elementStack) {
            super();
            this.elementStack = elementStack;

        }

        /**
         * Get the explorer label for the given element.
         *
         * @param element The element to get symbol labels.
         * @return The element symbol.
         */
        @objid ("6f6e69e0-0ca3-46cb-8e49-5ce7f30bd73f")
        public StyledString getLabel(MObject element) {
            // Guard agains't null elements
            if (element == null) {
                return new StyledString("<null>", ElementStyler.getStyler(null));
            }

            if (this.elementStack.contains(element)) {
                // loop detected, return the name...
                return new StyledString(element.getName());
            }

            // store the element for loop detection, push context
            this.elementStack.push(element);

            try {
                // call the visitor
                return (StyledString) element.accept(this);
            } finally {
                this.elementStack.pop();
            }

        }

        @objid ("2fc82e14-6b1a-4d74-8ce4-9d47883b393e")
        @Override
        public Object visitArchimateAbstractElement(ArchimateAbstractElement theArchimateAbstractElement) {
            return new StyledString(theArchimateAbstractElement.getName(),
                                ElementStyler.getStyler(theArchimateAbstractElement));

        }

        @objid ("1cbb0c83-c0b2-414b-90da-5412ecba8f42")
        @Override
        public Object visitArchimateProject(ArchimateProject theArchimateProject) {
            return new StyledString(theArchimateProject.getName(), ElementStyler.getStyler(theArchimateProject));
        }

        @objid ("7ee6dc86-13d5-46d4-ae88-131e8310d01c")
        @Override
        public Object visitArchimateView(ArchimateView theArchimateView) {
            return new StyledString(theArchimateView.getName(), ElementStyler.getStyler(theArchimateView));
        }

        @objid ("c767ccf2-33de-41e3-89a5-35e6965ccd93")
        @Override
        public Object visitRelationship(Relationship theRelationship) {
            final StyledString symbol = new StyledString();
            final Styler styler = ElementStyler.getStyler(theRelationship);

            final String name = theRelationship.getName();
            if (name.isEmpty()) {
                symbol.append(ArchiUi.I18N.getString("NoName"), styler);
            } else {
                symbol.append(name, styler);
            }

            symbol.append(": ", styler);

            final Concept target = theRelationship.getTo();
            if (target != null) {
                symbol.append(getLabel(target).toString(), ElementStyler.getStyler(theRelationship, target));
            }
            return symbol;
        }

        @objid ("3a1e536c-f837-4843-962b-79ac474e784f")
        @Override
        public Object visitViewPointDiagram(ViewPointDiagram theViewPointDiagram) {
            return new StyledString(theViewPointDiagram.getName(), ElementStyler.getStyler(theViewPointDiagram));
        }

    }

}

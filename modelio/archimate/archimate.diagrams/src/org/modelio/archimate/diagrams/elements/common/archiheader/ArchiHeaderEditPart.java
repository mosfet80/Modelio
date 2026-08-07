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
package org.modelio.archimate.diagrams.elements.common.archiheader;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.swt.graphics.Image;
import org.modelio.diagram.elements.common.edition.TextDirectEditManager;
import org.modelio.diagram.elements.common.header.GmModelElementHeader;
import org.modelio.diagram.elements.common.header.IHeaderFigure;
import org.modelio.diagram.elements.common.label.base.AutoFitOnEditEditPolicy;
import org.modelio.diagram.elements.core.model.IEditableText;
import org.modelio.diagram.elements.core.model.IGmObject;
import org.modelio.diagram.elements.core.node.AbstractNodeEditPart;
import org.modelio.diagram.elements.core.policies.DefaultElementDirectEditPolicy;
import org.modelio.diagram.styles.core.IStyle;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey.ShowStereotypeMode;

/**
 * Manages a {@link GmArchiHeader}.
 * <p>
 * The unique editing policy is the text edition of the main label.
 */
@objid ("1ac5d3d0-91ed-4834-8af1-b3c29887623b")
public class ArchiHeaderEditPart extends AbstractNodeEditPart {
    /**
     * Default constructor.
     */
    @objid ("129ab1dc-f182-4ade-b0b7-5269ac0750c7")
    public ArchiHeaderEditPart() {
        super();
    }

    @objid ("fa9d4237-9aa2-4761-8e8a-c6d759049eeb")
    @Override
    public ArchiHeaderFigure getFigure() {
        return (ArchiHeaderFigure) super.getFigure();
    }

    /**
     * By default model element headers are not selectable.
     */
    @objid ("43c4ffa5-2e7e-4fc2-9436-1590b670e25d")
    @Override
    public boolean isSelectable() {
        return false;
    }

    @objid ("2b1a7bc2-7fdd-4e19-851c-a31f70cfc8f9")
    @Override
    public void performRequest(Request req) {
        if (req.getType() == RequestConstants.REQ_DIRECT_EDIT) {
            GmModelElementHeader gm = (GmModelElementHeader) getModel();

            if (gm.getRelatedElement() == null
                    || gm.getRelatedElement().isShell()
                    || gm.getRelatedElement().isDeleted()
                    || !gm.getRelatedElement().getStatus().isModifiable() || this.getViewer().getControl() == null) {
                return;
            }

            final IEditableText editableText = gm.getEditableText();
            if (editableText != null) {
                ArchiHeaderFigure headerFigure = getFigure();
                TextDirectEditManager.forLabelum(
                        this,
                        headerFigure,
                        editableText.getText(),
                        false)
                .show();
            }
        } else {
            super.performRequest(req);
        }

    }

    @objid ("4a0053d5-1fb8-46aa-b3b8-95962e4a99d2")
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals(IGmObject.PROPERTY_LABEL)) {
            refreshVisuals();
        }

        super.propertyChange(evt);

    }

    @objid ("a06a521a-45b0-410b-8dc6-7f7d5d1d64b0")
    @Override
    protected void createEditPolicies() {
        super.createEditPolicies();
        installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE, new DefaultElementDirectEditPolicy());
        installEditPolicy(AutoFitOnEditEditPolicy.ROLE, new AutoFitOnEditEditPolicy());

    }

    @objid ("4afae26f-b8f1-4c5d-bc04-a81b0f86a261")
    @Override
    protected IFigure createFigure() {
        final GmArchiHeader gm = (GmArchiHeader) getModel();
        // Create the header figure
        final IHeaderFigure headerFigure = new ArchiHeaderFigure();

        // Set style dependent properties
        refreshFromStyle(headerFigure, getModelStyle());

        // Set style independent properties
        headerFigure.setLineWidth(0);

        // Main label
        refreshLabel(headerFigure);

        // Tagged values
        refreshTaggedValues(headerFigure);

        // Stereotypes
        ShowStereotypeMode mode = getStereotypeMode(gm);
        refreshStereotypes(headerFigure, mode);

        // // Keyword
        // refreshMetaclassKeyword(headerFigure, gm, mode);

        // Metaclass and stereotypes icon
        refreshRightIcons(headerFigure, gm, mode);
        return headerFigure;
    }

    /**
     * Get whether each stereotype is in its own &lt;&lt; >> or all are in the same &lt;&lt;a, b, c ...>>.
     * <p>
     * By default asks to {@link GmArchiHeader#isDisplayStereotypesAsStack()}, may be redefined in sub classes.
     *
     * @return <li><i>true</i>: each stereotype is in its &lt;&lt; >>.<br>
     * <li><i>false</i>: all stereotypes will be in a single &lt;&lt;a, b, c ...>> label
     */
    @objid ("a6942f85-fd61-44d9-a58f-93397432d569")
    protected boolean isDisplayStereotypesAsStack(GmArchiHeader gm) {
        return gm.isDisplayStereotypesAsStack();
    }

    @objid ("2f9b3f30-cd9e-4568-9891-ae462a805f01")
    @Override
    protected void refreshFromStyle(final IFigure aFigure, IStyle style) {
        final IHeaderFigure headerFigure = (IHeaderFigure) aFigure;

        // Pen and brush options are managed by the superclass
        super.refreshFromStyle(headerFigure, style);

        // We have to deal with stereotype mode and show/hide for name,
        // stereotypes and tags
        ShowStereotypeMode mode = getStereotypeMode((GmArchiHeader) getModel());
        GmArchiHeader gm = (GmArchiHeader) getModel();
        refreshLabel(headerFigure);
        refreshRightIcons(headerFigure, gm, mode);
        refreshStereotypes(headerFigure, mode);
        refreshTaggedValues(headerFigure);

    }

    @objid ("aa831ceb-8c84-4f86-bd0f-51a16d2c782a")
    protected void refreshRightIcons(final IHeaderFigure headerFigure, final GmArchiHeader gm, ShowStereotypeMode mode) {
        ArrayList<Image> icons = new ArrayList<>(4);
        if (gm.isShowMetaclassIcon()) {
            icons.add(gm.getMetaclassIcon());
        }

        if (mode == ShowStereotypeMode.ICON || mode == ShowStereotypeMode.TEXTICON) {
            icons.addAll(gm.getStereotypeIcons());
        }
        headerFigure.setRightIcons(icons);

    }

    /**
     * To be called when the stereotype mode changes or when the applied stereotypes change. It updates the top label
     *
     * @param aFigure The figure to update.
     */
    @objid ("1cfd335d-eaec-4b89-8213-cb6bfc21928b")
    protected final void refreshStereotypes(final IHeaderFigure headerFigure, ShowStereotypeMode mode) {
        GmArchiHeader gm = (GmArchiHeader) getModel();

        switch (mode) {
        case ICON:
            headerFigure.setTopLabel("");
            break;
        case TEXT:
            headerFigure.setTopLabel(computeStereotypeText(gm));
            break;
        case TEXTICON:
            headerFigure.setTopLabel(computeStereotypeText(gm));
            break;
        default:
        case NONE:
            headerFigure.setTopLabel("");
            break;
        }

    }

    @objid ("36346915-521f-4751-8e04-9a83f1bc106f")
    @Override
    protected void refreshVisuals() {
        final IHeaderFigure aFigure = (getFigure());
        final GmArchiHeader gm = (GmArchiHeader) getModel();

        ShowStereotypeMode mode = getStereotypeMode(gm);

        // Layout data
        final Object layoutData = gm.getLayoutData();
        if (layoutData != null) {
            aFigure.getParent().setConstraint(aFigure, layoutData);
        }

        // Main label
        refreshLabel(aFigure);

        // Tagged values
        refreshTaggedValues(aFigure);

        // Stereotypes
        refreshStereotypes(aFigure, mode);

        // Metaclass Keyword
        // refreshMetaclassKeyword(aFigure, gm, mode);

        // Metaclass Icon
        refreshRightIcons(aFigure, gm, mode);

    }

    @objid ("6ff303c6-fcd8-44fc-bd07-390386e0d4ae")
    private String computeStereotypeText(GmArchiHeader gm) {
        if (gm.getStereotypesLabel().isEmpty()) {
            return "";
        }

        final StringBuilder labels = new StringBuilder();
        if (isDisplayStereotypesAsStack(gm)) {
            // Each stereotype in <<s1>> <<s2>>
            for (String s : gm.getStereotypesLabel()) {
                if (labels.length() > 2) {
                    labels.append("\u200B"); // ZERO WIDTH SPACE
                }

                labels.append("<<");
                labels.append(s.replace(" ", "\u00A0")); // replace spaces by
                // non breaking
                // spaces
                labels.append(">>");
            }
        } else {
            // All stereotypes in <<s1, s2>>
            labels.append("<<");
            for (String s : gm.getStereotypesLabel()) {
                if (labels.length() > 2) {
                    labels.append(", ");
                }

                labels.append(s.replace(" ", "\u00A0")); // replace spaces by
                // non breaking
                // spaces
            }
            labels.append(">>");
        }
        return labels.toString();
    }

    @objid ("4db4f03b-96a7-433b-bc20-f8ccbb0ff498")
    private String computeTagsLabel(GmArchiHeader gm) {
        List<String> taggedValuesLabels = gm.getTaggedValueLabels();

        if (taggedValuesLabels.isEmpty()) {
            return "";
        }

        StringBuilder sb = new StringBuilder(taggedValuesLabels.size() * 20);

        // add new label figures
        for (String s : taggedValuesLabels) {
            if (sb.length() != 0) {
                sb.append(", ");
            }

            sb.append(s.replace(" ", "\u00A0")); // replace spaces by non
            // breaking spaces
        }
        return sb.toString();
    }

    @objid ("cb2aff48-7afd-492c-b896-0a6416071dc8")
    private ShowStereotypeMode getStereotypeMode(final GmArchiHeader gm) {
        ShowStereotypeMode mode = gm.getDisplayedStyle().getProperty(gm.getStyleKey(MetaKey.SHOWSTEREOTYPES));
        if (mode == null) {
            mode = ShowStereotypeMode.NONE;
        }
        return mode;
    }

    @objid ("c03c6f2b-e75d-40ef-b9b1-7b48a851fb35")
    private void refreshLabel(IHeaderFigure headerFigure) {
        GmArchiHeader gm = (GmArchiHeader) getModel();

        // Ask the gm if the label is shown
        if (gm.isShowLabel()) {
            headerFigure.setMainLabel(gm.getMainLabel());
        } else {
            headerFigure.setMainLabel("");
        }

    }

    @objid ("894e23f6-8afd-43d1-a849-742d18330d66")
    private void refreshTaggedValues(IHeaderFigure aFigure) {
        GmArchiHeader gm = (GmArchiHeader) getModel();

        boolean mode = gm.getDisplayedStyle().getProperty(gm.getStyleKey(MetaKey.SHOWTAGS));
        if (mode) {
            aFigure.setBottomLabel(computeTagsLabel(gm));
        } else {
            aFigure.setBottomLabel("");
        }

    }

    @objid ("4721f5b4-fd37-4505-b5b5-3c10ff6bbe1b")
    public void setWideMode(boolean wideMode) {
        getFigure().setWideMode(wideMode);
    }

}

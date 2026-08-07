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
package org.modelio.diagram.elements.common.embeddeddiagram;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.DragTracker;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartListener;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gef.Request;
import org.eclipse.gef.RootEditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editparts.LayerManager;

/**
 * Embedded diagrams layer manager.
 * <p>
 * Embedded diagrams have their own layers except the handle layer and the feed back layers.
 * The root diagram layer is used for the last ones.
 *
 * @author cma
 * @since 3.7
 */
@objid ("5482b4cf-57ba-4941-836c-5dab0b39d86c")
class EmbeddedLayerManager implements LayerManager, EditPart {
    @objid ("f00f19f9-1bc5-4462-b4e1-7696811e4ecf")
    private final LayerManager parentLayerManager;

    @objid ("75074a72-0282-4a60-82db-caa3fcedc076")
    private final EmbeddedDiagramRootEditPart rootEp;

    @objid ("9d9b2c3d-c598-43fe-93ff-9fad143e3028")
    public EmbeddedLayerManager(EmbeddedDiagramRootEditPart rootEp) {
        this.rootEp = rootEp;
        this.parentLayerManager = LayerManager.Helper.find(this.rootEp.getParent());
    }

    @objid ("f623ee0b-d62a-4359-9182-28fc009ec312")
    @Override
    public IFigure getLayer(Object key) {
        if (key == LayerConstants.HANDLE_LAYER
                || key == LayerConstants.FEEDBACK_LAYER
                || key == LayerConstants.SCALED_FEEDBACK_LAYER) {
            return this.parentLayerManager.getLayer(key);
        }

        IFigure layer = this.rootEp.getLayer(key);
        return layer;
    }

    @objid ("20cd7c5d-a46b-41ce-a316-65f068e72c61")
    @Override
    public <T> T getAdapter(Class<T> adapter) {
        throw new UnsupportedOperationException();
    }

    @objid ("e1569e89-7ee7-4e4f-8cd4-143a91dd2c74")
    @Override
    public void activate() {
        throw new UnsupportedOperationException();
    }

    @objid ("381129a1-f062-47bf-a4ec-24144b326d50")
    @Override
    public void addEditPartListener(EditPartListener listener) {
        throw new UnsupportedOperationException();
    }

    @objid ("ed79b983-d3b8-4c27-a1d7-5f2a93a86c24")
    @Override
    public void addNotify() {
        throw new UnsupportedOperationException();
    }

    @objid ("1afddd5b-1126-4460-8462-e818b5b4d3a2")
    @Override
    public void deactivate() {
        throw new UnsupportedOperationException();
    }

    @objid ("a58ca777-6d07-4d5a-ac65-f6c40609fa1b")
    @Override
    public void eraseSourceFeedback(Request request) {
        throw new UnsupportedOperationException();
    }

    @objid ("e39ee8d9-2be1-4daf-9c7f-94da7fd5ef39")
    @Override
    public void eraseTargetFeedback(Request request) {
        throw new UnsupportedOperationException();
    }

    @objid ("a0021a74-cbf8-4841-88cb-abba2779f121")
    @Override
    public List<? extends EditPart> getChildren() {
        throw new UnsupportedOperationException();
    }

    @objid ("a7c00786-c861-47f2-a447-875cf7d2d0b5")
    @Override
    public Command getCommand(Request request) {
        throw new UnsupportedOperationException();
    }

    @objid ("29d9b111-0196-4a55-b2e7-c5b0b473d7ed")
    @Override
    public DragTracker getDragTracker(Request request) {
        throw new UnsupportedOperationException();
    }

    @objid ("7f6e3e75-84b6-4106-b8e4-bdebc489b90d")
    @Override
    public EditPolicy getEditPolicy(Object key) {
        throw new UnsupportedOperationException();
    }

    @objid ("7724b6f8-f9f3-4af2-b08e-24622ab6abf6")
    @Override
    public Object getModel() {
        throw new UnsupportedOperationException();
    }

    @objid ("183e6f3c-1b7e-46de-a8a2-7edb67501b54")
    @Override
    public EditPart getParent() {
        throw new UnsupportedOperationException();
    }

    @objid ("6ef4d0ce-369e-4239-8511-11dcf54a89b1")
    @Override
    public RootEditPart getRoot() {
        throw new UnsupportedOperationException();
    }

    @objid ("40e3cb6a-7260-4d19-a311-6c8376b01670")
    @Override
    public int getSelected() {
        throw new UnsupportedOperationException();
    }

    @objid ("30b6ddbe-165b-46e3-8b06-208ad2ba0b5d")
    @Override
    public EditPart getTargetEditPart(Request request) {
        throw new UnsupportedOperationException();
    }

    @objid ("bc77686e-e2c5-459f-8c6c-710ed216d69e")
    @Override
    public EditPartViewer getViewer() {
        throw new UnsupportedOperationException();
    }

    @objid ("ce986a83-c51f-4cad-a671-9fe8b2f05998")
    @Override
    public boolean hasFocus() {
        throw new UnsupportedOperationException();
    }

    @objid ("d8605a9f-c085-4684-9ff4-21e1a061a3d0")
    @Override
    public void installEditPolicy(Object role, EditPolicy editPolicy) {
        throw new UnsupportedOperationException();
    }

    @objid ("8a00d526-5330-4e19-bd67-b3da7b6f7fa5")
    @Override
    public boolean isActive() {
        throw new UnsupportedOperationException();
    }

    @objid ("b4d416f3-b93f-4ce5-ab59-aa6e6593787d")
    @Override
    public boolean isSelectable() {
        throw new UnsupportedOperationException();
    }

    @objid ("72f42c3e-aacf-4921-a40a-5d0bdc9f1fcf")
    @Override
    public void performRequest(Request request) {
        throw new UnsupportedOperationException();
    }

    @objid ("97466d3d-2c2b-4191-bf68-0c08f383921a")
    @Override
    public void refresh() {
        throw new UnsupportedOperationException();
    }

    @objid ("de18a637-d88d-4deb-94c2-edca0d091a69")
    @Override
    public void removeEditPartListener(EditPartListener listener) {
        throw new UnsupportedOperationException();
    }

    @objid ("334bc820-75e9-4081-a706-36c52452ef36")
    @Override
    public void removeEditPolicy(Object role) {
        throw new UnsupportedOperationException();
    }

    @objid ("d8bf2fab-6f65-4797-be68-8557dc4ce5b3")
    @Override
    public void removeNotify() {
        throw new UnsupportedOperationException();
    }

    @objid ("ef9d8932-a7ac-4852-888d-adad80788b6e")
    @Override
    public void setFocus(boolean hasFocus) {
        throw new UnsupportedOperationException();
    }

    @objid ("1d433f34-7361-4f85-93e9-d1785db21514")
    @Override
    public void setModel(Object model) {
        throw new UnsupportedOperationException();
    }

    @objid ("b613b125-9e93-463a-9c88-df345f1fbe67")
    @Override
    public void setParent(EditPart parent) {
        throw new UnsupportedOperationException();
    }

    @objid ("6dd0e213-d149-4c15-8fc2-9eaa8b03cf5e")
    @Override
    public void setSelected(int value) {
        throw new UnsupportedOperationException();
    }

    @objid ("70a99cea-4623-43a4-9180-d1c7342a1423")
    @Override
    public void showSourceFeedback(Request request) {
        throw new UnsupportedOperationException();
    }

    @objid ("95ba0af0-367a-47c2-b4a2-cf8e02c1a89e")
    @Override
    public void showTargetFeedback(Request request) {
        throw new UnsupportedOperationException();
    }

    @objid ("17e132fb-eca1-4030-ac2f-791d932bcd51")
    @Override
    public boolean understandsRequest(Request request) {
        throw new UnsupportedOperationException();
    }

}

/* 
 * Copyright 2013-2020 Modeliosoft
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
/**
 * 
 */
package org.modelio.linkeditor.handlers.zoom;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import jakarta.inject.Named;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.modelio.linkeditor.panel.ILinkEditor;
import org.modelio.linkeditor.view.ILinkEditorView;

/**
 * Handler that will increase zoom level by one if available in the link editor.
 */
@objid ("1bc0dcdd-5e33-11e2-b81d-002564c97630")
public class ZoomInHandler {
    @objid ("1bc0dcdf-5e33-11e2-b81d-002564c97630")
    @Execute
    public Object execute(@Named(IServiceConstants.ACTIVE_PART) final MPart part) {
        if (!(part.getObject() instanceof ILinkEditorView)) {
            return null;
        } else {
            final ILinkEditor linkEditor = ((ILinkEditorView) part.getObject()).getLinkEditor();
            linkEditor.setZoomLevel( linkEditor.getZoomLevel() * Math.sqrt(2.0));
            return null;
        }
        
    }

}

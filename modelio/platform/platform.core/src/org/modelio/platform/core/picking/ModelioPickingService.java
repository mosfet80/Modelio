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
package org.modelio.platform.core.picking;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import jakarta.inject.Inject;
import org.eclipse.e4.core.di.annotations.Creatable;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.modelio.platform.core.IModelioEventService;
import org.modelio.platform.core.events.ModelioEvent;
import org.modelio.vcore.smkernel.mapi.MObject;

@objid ("005bcf84-0355-106f-bbdd-001ec947cd2a")
@Creatable
public class ModelioPickingService implements IModelioPickingService {
    @objid ("008de96a-0592-106f-bbdd-001ec947cd2a")
    @Inject
    private IModelioEventService eventService;

    @objid ("008df93c-0592-106f-bbdd-001ec947cd2a")
    private IPickingSession currentSession = null;

    @objid ("92d23eb1-6941-4559-8ff9-25f3ca387f9c")
    private final Listener displayEventFilter = this::filterKeyPressed;

    @objid ("008dff5e-0592-106f-bbdd-001ec947cd2a")
    @Override
    public String getName() {
        return "ModelioPickingService";
    }

    @objid ("008e2632-0592-106f-bbdd-001ec947cd2a")
    @Override
    public IPickingSession startPicking(IPickingClient client) {
        assert (this.currentSession == null);
        this.currentSession = new PickingSession(client);
        this.eventService.postAsyncEvent(this, ModelioEvent.PICKING_START, this.currentSession);
        
        // Install a global key listener that will abort picking on ESC key
        Display.getCurrent().addFilter(SWT.KeyDown, this.displayEventFilter);
        return this.currentSession;
    }

    @objid ("008e504e-0592-106f-bbdd-001ec947cd2a")
    @Override
    public void stopPicking(IPickingSession session) {
        assert (this.currentSession.equals(session));
        
        Display.getCurrent().removeFilter(SWT.KeyDown, this.displayEventFilter);
        
        this.eventService.postAsyncEvent(this, ModelioEvent.PICKING_STOP, this.currentSession);
        this.currentSession = null;
        
    }

    @objid ("10ab6c36-4fc0-4f69-be68-eb2a8a16dd8c")
    private void filterKeyPressed(Event ev) {
        if (ev.character==SWT.ESC) {
            this.currentSession.abort();
        }
        
    }

    @objid ("008e6cbe-0592-106f-bbdd-001ec947cd2a")
    static class PickingSession implements IPickingSession {
        @objid ("008e82e4-0592-106f-bbdd-001ec947cd2a")
        private final IPickingClient client;

        @objid ("008e92d4-0592-106f-bbdd-001ec947cd2a")
        public  PickingSession(IPickingClient client) {
            this.client = client;
        }

        @objid ("008ea558-0592-106f-bbdd-001ec947cd2a")
        @Override
        public boolean hover(MObject mObject) {
            return this.client.hover(mObject);
        }

        @objid ("008ecf42-0592-106f-bbdd-001ec947cd2a")
        @Override
        public boolean pick(MObject mObject) {
            return this.client.pick(mObject);
        }

        @objid ("007d70f8-e423-1076-aae0-001ec947cd2a")
        @Override
        public void abort() {
            this.client.abort();
        }

    }

}

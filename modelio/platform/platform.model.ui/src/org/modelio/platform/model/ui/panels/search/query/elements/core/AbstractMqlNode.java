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
package org.modelio.platform.model.ui.panels.search.query.elements.core;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

/**
 * Base class for all MQL editor domain model nodes.
 */
@objid ("5ce6ab4f-484a-4d64-80b9-c334eca663bb")
public abstract class AbstractMqlNode {
    @objid ("f86d8c9b-9e24-49dd-9220-103656306f8b")
    private final PropertyChangeSupport changeSupport;

    @objid ("4657a913-a1d2-471f-9100-9bd8b2718875")
    private final AbstractMqlNode parent;

    @objid ("e33c229c-9dfe-4a7e-a4b2-c0fa5726a255")
    protected AbstractMqlNode(final AbstractMqlNode parent) {
        this.parent = parent;
        this.changeSupport = new PropertyChangeSupport(this);
    }

    @objid ("a28aebb9-4feb-4ceb-b8d5-1390974311c9")
    public void addPropertyChangeListener(final PropertyChangeListener listener) {
        this.changeSupport.addPropertyChangeListener(listener);
    }

    @objid ("5ba81375-4527-4473-9193-584e2cfc5007")
    public void removePropertyChangeListener(final PropertyChangeListener listener) {
        this.changeSupport.removePropertyChangeListener(listener);
    }

    @objid ("09bcd676-d19e-47a2-89b9-2f529d598290")
    protected final void firePropertyChange(final String propertyName, final Object oldValue, final Object newValue) {
        this.changeSupport.firePropertyChange(propertyName, oldValue, newValue);
    }

    @objid ("82cc5b6a-0225-40b3-ae14-67ea3efa3cbf")
    protected final AbstractMqlNode getParent() {
        return this.parent;
    }

    @objid ("83d7b3f5-cefb-4f70-a570-7069457dbcfb")
    protected final MqlQueryModel getRootModel() {
        AbstractMqlNode current = this;
        while (current != null && !(current instanceof MqlQueryModel)) {
            current = current.parent;
        }
        return (MqlQueryModel) current;
    }

    @objid ("8aefbf9a-eb53-499a-adfc-0b3adab93376")
    protected void fireChanged() {
        if (this.parent != null) {
            this.parent.fireChanged();
        }
    }

}

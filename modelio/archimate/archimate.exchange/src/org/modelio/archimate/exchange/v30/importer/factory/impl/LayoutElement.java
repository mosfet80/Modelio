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
package org.modelio.archimate.exchange.v30.importer.factory.impl;

import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.api.modelio.diagram.IDiagramNode;
import org.modelio.archimate.exchange.v30.xmlmodel.Element;

@objid ("719486b7-7dd7-44a2-9fa3-f5f39f667f25")
public class LayoutElement {
    @objid ("ddf852c4-6208-459c-845c-96b983866a85")
    private IDiagramNode dgNode;

    @objid ("b69e53ef-a545-493a-9da8-e1493b803630")
    private Element jaxNode;

    @objid ("61628d80-cc8c-4fc6-b5a2-da8b4cc44d9c")
    private List<LayoutElement> children;

    @objid ("df8b3659-4132-4372-bea7-6b37a2580de4")
    public LayoutElement() {
        this.children = new ArrayList<>();
    }

    @objid ("5a2aae42-092f-40de-ad68-2dfbdd64d945")
    public IDiagramNode getDgNode() {
        return dgNode;
    }

    @objid ("d746cd81-2d1d-4ad8-91e2-b39e5c832094")
    public void setDgNode(IDiagramNode dgNode) {
        this.dgNode = dgNode;
    }

    @objid ("6213480e-117b-48e0-980f-eaf4a0e43b83")
    public Element getJaxNode() {
        return jaxNode;
    }

    @objid ("d0c30ace-76dc-4047-a0b4-517911ce5368")
    public void setJaxNode(Element jaxNode) {
        this.jaxNode = jaxNode;
    }

    @objid ("fc4f2079-bf43-4902-90d7-58b7ab227d3f")
    public List<LayoutElement> getChildren() {
        return children;
    }

    @objid ("407b4817-51a2-440a-9269-821e7ae991d1")
    public void setChildren(List<LayoutElement> children) {
        this.children = children;
    }

}

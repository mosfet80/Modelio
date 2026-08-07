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
package org.modelio.archimate.exchange.v31.importer.factory.impl;

import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.api.modelio.diagram.IDiagramNode;
import org.modelio.archimate.exchange.v31.xmlmodel.Element;

@objid ("0ba93ef1-ddb2-4a05-84b5-393f7d3642f0")
public class LayoutElement {
    @objid ("bca877ac-d10e-4b0c-b725-4704fa011f7d")
    private IDiagramNode dgNode;

    @objid ("20854696-3506-468b-bc48-67800a5ee07e")
    private Element jaxNode;

    @objid ("7e5e3147-a2ce-4676-bacb-71d7bb836c81")
    private List<LayoutElement> children;

    @objid ("85ca2da4-7f92-42b5-9e9c-05bb61480ece")
    public LayoutElement() {
        this.children = new ArrayList<>();
    }

    @objid ("7adf1aa5-abbf-409b-a3e6-d51c0d85e890")
    public IDiagramNode getDgNode() {
        return dgNode;
    }

    @objid ("b66559ac-c2cc-4488-bb4f-abbaa8a61214")
    public void setDgNode(IDiagramNode dgNode) {
        this.dgNode = dgNode;
    }

    @objid ("b7dbf833-12f5-459c-9e9d-bf2b56eba160")
    public Element getJaxNode() {
        return jaxNode;
    }

    @objid ("93a80251-c0c4-4ace-b921-74d30a7b0c59")
    public void setJaxNode(Element jaxNode) {
        this.jaxNode = jaxNode;
    }

    @objid ("ace0a39e-85ac-44bb-8e40-535502deabec")
    public List<LayoutElement> getChildren() {
        return children;
    }

    @objid ("03627c1d-2682-45d3-b1f9-c9a5f2537db2")
    public void setChildren(List<LayoutElement> children) {
        this.children = children;
    }

}

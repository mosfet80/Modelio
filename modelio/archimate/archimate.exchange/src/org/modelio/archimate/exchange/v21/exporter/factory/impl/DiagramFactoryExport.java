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
package org.modelio.archimate.exchange.v21.exporter.factory.impl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.draw2d.geometry.Point;
import org.modelio.api.modelio.diagram.IDiagramHandle;
import org.modelio.api.modelio.diagram.IDiagramLink;
import org.modelio.api.modelio.diagram.IDiagramNode;
import org.modelio.api.modelio.diagram.IDiagramService;
import org.modelio.archimate.exchange.service.utils.IDUtils;
import org.modelio.archimate.exchange.v21.exporter.factory.IDiagramFactoryExport;
import org.modelio.archimate.exchange.v21.xmlmodel.BendpointType;
import org.modelio.archimate.exchange.v21.xmlmodel.ConnectionType;
import org.modelio.archimate.exchange.v21.xmlmodel.ElementType;
import org.modelio.archimate.exchange.v21.xmlmodel.FontType;
import org.modelio.archimate.exchange.v21.xmlmodel.LangStringType;
import org.modelio.archimate.exchange.v21.xmlmodel.NodeType;
import org.modelio.archimate.exchange.v21.xmlmodel.ObjectFactory;
import org.modelio.archimate.exchange.v21.xmlmodel.RelationshipType;
import org.modelio.archimate.exchange.v21.xmlmodel.RgbColorType;
import org.modelio.archimate.exchange.v21.xmlmodel.StyleType;
import org.modelio.archimate.exchange.v21.xmlmodel.ViewType;
import org.modelio.archimate.metamodel.core.Relationship;
import org.modelio.archimate.metamodel.core.generic.composite.Grouping;
import org.modelio.diagram.api.dg.common.LabelDG;
import org.modelio.metamodel.diagrams.AbstractDiagram;
import org.modelio.metamodel.uml.infrastructure.ModelElement;

@objid ("c679f471-fc07-480a-99eb-864f4fa62908")
public class DiagramFactoryExport implements IDiagramFactoryExport {
    @objid ("84d09851-697e-4d0a-ba9b-ad8b0562c031")
    private IDiagramService diagramService;

    @objid ("f97ce7a2-6038-4b3f-8c4e-7f77f8cbc983")
    private ObjectFactory baseFactory;

    @objid ("5957def8-bce9-4be2-bb3d-64d4d76a3efb")
    private Map<String, Object> elementRefs;

    @objid ("1fcc955b-0a4f-49e1-9b50-155b4e7b6c60")
    private Map<Object, NodeType> diagRefs;

    @objid ("33bda3f9-82ac-426e-bb74-db2933502a94")
    public DiagramFactoryExport(IDiagramService diagramService) {
        this.diagramService = diagramService;
        this.baseFactory = new ObjectFactory();
        this.diagRefs = new HashMap<>();

    }

    @objid ("3d163d6f-8523-40a6-9cd9-20c714008a9f")
    @Override
    public void setReferenceMap(Map<String, Object> refs) {
        this.elementRefs = refs;
    }

    @objid ("1d09b180-487f-46d0-be33-99db0a9db383")
    @Override
    public void createArchimateView(ViewType view, AbstractDiagram diagram) {
        try (IDiagramHandle handle = this.diagramService.getDiagramHandle(diagram)) {

            for (IDiagramNode node : handle.getDiagramNode().getNodes()) {
                if (node.getElement() != null) {
                    NodeType jaxNode = createNode(node);
                    if (jaxNode != null) {
                        view.getNode().add(jaxNode);
                    }
                }
            }

            for (IDiagramLink node : handle.getDiagramNode().getLinks()) {
                if (node.getElement() != null) {
                    creteLink(view, node);
                }
            }

            handle.close();
        }

    }

    @objid ("b7193ff2-82e7-4faf-bfe0-bf0c203b1042")
    private NodeType createNode(IDiagramNode node) {
        ElementType element = (ElementType) this.elementRefs.get(node.getElement().getUuid());
        if (element != null || node.getElement() instanceof Grouping) {
            NodeType jaxNode = this.baseFactory.createNodeType();
            jaxNode.setIdentifier(IDUtils.exportId(UUID.randomUUID().toString()));
            jaxNode.setElementref(element);
            jaxNode.setX(BigInteger.valueOf(node.getBounds().x));
            jaxNode.setY(BigInteger.valueOf(node.getBounds().y));
            jaxNode.setW(BigInteger.valueOf(node.getBounds().width));
            jaxNode.setH(BigInteger.valueOf(node.getBounds().height));

            if (node.getElement() instanceof Grouping) {
                jaxNode.getLabel().add(createLabel((Grouping) node.getElement()));
                jaxNode.setType("group");
            } else {
                jaxNode.setElementref(element);
            }

            this.diagRefs.put(node, jaxNode);

            StyleType style = this.baseFactory.createStyleType();
            jaxNode.setStyle(style);

            if (node.getFillColor() != null) {
                style.setFillColor(parseColor(node.getFillColor()));
            }

            if (node.getLineColor() != null) {
                style.setLineColor(parseColor(node.getLineColor()));
            }
            style.setLineWidth(BigInteger.valueOf(node.getLineWidth()));
            style.setFont(convertFontType(node.getFont(), node.getTextColor()));

            for (IDiagramNode subNode : node.getNodes()) {
                if (!(subNode instanceof LabelDG) && subNode.getElement() != null) {
                    NodeType jaxSubNode = createNode(subNode);
                    jaxNode.getNode().add(jaxSubNode);
                }
            }
            return jaxNode;
        }
        return null;
    }

    @objid ("7ea0557f-c6b8-4ed4-83b6-17c5387266e3")
    private void creteLink(ViewType view, IDiagramLink node) {
        Object obj = node.getElement();
        if (obj instanceof Relationship) {
            Relationship relationship = (Relationship) obj;

            if (relationship.getFrom() != null && relationship.getTo() != null) {
                RelationshipType jaxRelationship = (RelationshipType) this.elementRefs.get(node.getElement().getUuid());
                NodeType jaxSource = this.diagRefs.get(node.getFrom());
                NodeType jaxTarget = this.diagRefs.get(node.getTo());

                if (jaxRelationship != null && jaxSource != null && jaxTarget != null) {
                    ConnectionType jaxConnection = this.baseFactory.createConnectionType();
                    jaxConnection.setIdentifier(IDUtils.exportId(UUID.randomUUID().toString()));
                    jaxConnection.setRelationshipref(jaxRelationship);

                    jaxConnection.setSource(jaxSource);
                    jaxConnection.setTarget(jaxTarget);

                    StyleType style = this.baseFactory.createStyleType();
                    jaxConnection.setStyle(style);

                    style.setLineColor(parseColor(node.getLineColor()));
                    style.setLineWidth(BigInteger.valueOf(node.getLineWidth()));
                    style.setFont(convertFontType(node.getFont(), node.getTextColor()));

                    view.getConnection().add(jaxConnection);

                    if (node.getPath() != null) {
                        List<Point> points = node.getPath().getPoints();
                        for (int i = 1; i < points.size() - 1; i++) {
                            BendpointType jaxPoint = this.baseFactory.createBendpointType();
                            jaxPoint.setX(BigInteger.valueOf(points.get(i).x));
                            jaxPoint.setY(BigInteger.valueOf(points.get(i).y));
                            jaxConnection.getBendpoint().add(jaxPoint);
                        }
                    }
                }
            }
        }

    }

    @objid ("20b4dc76-7f7d-41b3-b1f3-97e968faae06")
    private RgbColorType parseColor(String input) {
        Pattern c = Pattern.compile("([0-9]+),([0-9]+),([0-9]+)");
        Matcher m = c.matcher(input);
        RgbColorType jaxFillColor = this.baseFactory.createRgbColorType();
        if (m.matches()) {
            jaxFillColor.setR(Short.valueOf(m.group(1)));
            jaxFillColor.setG(Short.valueOf(m.group(2)));
            jaxFillColor.setB(Short.valueOf(m.group(3)));
        }
        jaxFillColor.setA(Short.valueOf("100"));
        return jaxFillColor;
    }

    @objid ("130632a9-f8f8-46ad-a822-f30c596a24eb")
    private LangStringType createLabel(ModelElement element) {
        LangStringType jaxLabel = this.baseFactory.createLangStringType();
        jaxLabel.setValue(element.getName());
        String local = Locale.getDefault().getLanguage();
        jaxLabel.setLang(local);
        return jaxLabel;
    }

    @objid ("c4e3c326-4400-41c7-8d8a-e757e68f0f7f")
    public FontType convertFontType(String font, String color) {
        FontType fontType = this.baseFactory.createFontType();
        String[] fonts = font.split("-");
        fontType.setName(fonts[0]);
        fontType.setSize(BigDecimal.valueOf(Integer.valueOf(fonts[2])));
        fontType.setStyle("plain");
        fontType.setColor(parseColor(color));
        return fontType;
    }

}

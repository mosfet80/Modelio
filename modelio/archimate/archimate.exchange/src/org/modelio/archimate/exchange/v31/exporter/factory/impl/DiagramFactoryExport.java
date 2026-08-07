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
package org.modelio.archimate.exchange.v31.exporter.factory.impl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
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
import org.modelio.archimate.exchange.v31.exporter.factory.IDiagramFactoryExport;
import org.modelio.archimate.exchange.v31.xmlmodel.AllowedElementTypeType;
import org.modelio.archimate.exchange.v31.xmlmodel.AllowedRelationshipTypeType;
import org.modelio.archimate.exchange.v31.xmlmodel.ConnectionType;
import org.modelio.archimate.exchange.v31.xmlmodel.Diagram;
import org.modelio.archimate.exchange.v31.xmlmodel.Element;
import org.modelio.archimate.exchange.v31.xmlmodel.ElementType;
import org.modelio.archimate.exchange.v31.xmlmodel.ElementTypeEnum;
import org.modelio.archimate.exchange.v31.xmlmodel.FontType;
import org.modelio.archimate.exchange.v31.xmlmodel.LangStringType;
import org.modelio.archimate.exchange.v31.xmlmodel.LocationType;
import org.modelio.archimate.exchange.v31.xmlmodel.ModelType;
import org.modelio.archimate.exchange.v31.xmlmodel.ObjectFactory;
import org.modelio.archimate.exchange.v31.xmlmodel.RGBColorType;
import org.modelio.archimate.exchange.v31.xmlmodel.RelationshipConnectorEnum;
import org.modelio.archimate.exchange.v31.xmlmodel.RelationshipType;
import org.modelio.archimate.exchange.v31.xmlmodel.RelationshipTypeEnum;
import org.modelio.archimate.exchange.v31.xmlmodel.StyleType;
import org.modelio.archimate.exchange.v31.xmlmodel.ViewpointType;
import org.modelio.archimate.exchange.v31.xmlmodel.ViewpointsType;
import org.modelio.archimate.exchange.v31.xmlmodel.ViewsType;
import org.modelio.archimate.metamodel.core.Relationship;
import org.modelio.diagram.api.dg.common.LabelDG;
import org.modelio.metamodel.diagrams.AbstractDiagram;
import org.modelio.metamodel.uml.infrastructure.Stereotype;

@objid ("0ac690a9-ea5f-4cd0-a53a-6baa1d6850ec")
public class DiagramFactoryExport implements IDiagramFactoryExport {
    @objid ("e479ba88-3e7d-4faf-a53a-18d1ef430e7f")
    private IDiagramService diagramService;

    @objid ("cd394747-8e59-44d9-bc84-1050f322a534")
    private Map<String, Object> elementRefs;

    @objid ("6011e064-8a46-4ede-84ed-bc276a56eec4")
    private Map<Object, Object> diagRefs;

    @objid ("34715d35-f75c-4975-b628-3c8243985436")
    private ObjectFactory baseFactory;

    @objid ("19802804-77af-45e9-9f3a-f4c95fea9355")
    public DiagramFactoryExport(IDiagramService diagramService) {
        this.diagramService = diagramService;
        this.baseFactory = new ObjectFactory();
        this.diagRefs = new HashMap<>();

    }

    @objid ("d180dff6-d53e-4bbc-95df-9159a5865c6f")
    @Override
    public void setReferenceMap(Map<String, Object> refs) {
        this.elementRefs = refs;
    }

    @objid ("8570fa65-e591-4809-8535-f02f14b276d5")
    @Override
    public void createArchimateView(Diagram view, AbstractDiagram diagram) {
        try (IDiagramHandle handle = this.diagramService.getDiagramHandle(diagram)) {

            // Migration af All point to 0+ Referential
            Point translation = calculateTranslation(handle);
            for (IDiagramNode node : handle.getDiagramNode().getNodes()) {
                if (node.getElement() != null) {
                    List<Element> jaxNode = createNode(node, translation);
                    view.getNode().addAll(jaxNode);
                }
            }

            List<IDiagramLink> postponeLinks = new ArrayList<>();
            for (IDiagramLink node : handle.getDiagramNode().getLinks()) {
                if (node.getElement() != null) {
                    if (creteLink(view, node, translation) == null) {
                        postponeLinks.add(node);
                    }
                }
            }

            for (IDiagramLink node : postponeLinks) {
                creteLink(view, node, translation);
            }

            handle.close();
        }

    }

    @objid ("b9ecacd4-5dda-4ee0-8f07-d4a86c35f8d8")
    private List<Element> createNode(IDiagramNode node, Point translation) {
        List<Element> elements = new ArrayList();
        ElementType element = (ElementType) this.elementRefs.get(node.getElement().getUuid());
        if (element != null) {
            Element jaxNode = this.baseFactory.createElement();

            jaxNode.setIdentifier(IDUtils.exportId(UUID.randomUUID().toString()));
            jaxNode.setElementRef(element);
            jaxNode.setX(BigInteger.valueOf(node.getBounds().x + translation.x));
            jaxNode.setY(BigInteger.valueOf(node.getBounds().y + translation.y));
            jaxNode.setW(BigInteger.valueOf(node.getBounds().width));
            jaxNode.setH(BigInteger.valueOf(node.getBounds().height));
            jaxNode.setElementRef(element);
            this.diagRefs.put(node, jaxNode);

            StyleType style = this.baseFactory.createStyleType();
            jaxNode.setStyle(style);

            if (node.getFillColor() != null) {
                style.setFillColor(parseColor(node.getFillColor()));
            }

            if (node.getLineColor() != null) {
                style.setLineColor(parseColor(node.getLineColor()));
            }

            // In structures mode LineWidth is 0, it's not a valide value in exchange format
            int lindWidth = 1;
            if (node.getLineWidth() > 1) {
                lindWidth = node.getLineWidth();
            }

            style.setLineWidth(BigInteger.valueOf(lindWidth));
            style.setFont(convertFontType(node.getFont(), node.getTextColor()));

            elements.add(jaxNode);

            for (IDiagramNode subNode : node.getNodes()) {
                if (!(subNode instanceof LabelDG) && subNode.getElement() != null) {
                    List<Element> jaxSubNode = createNode(subNode, translation);
                    jaxNode.getNode().addAll(jaxSubNode);
                }
            }
            return elements;
        }
        return new ArrayList<>();
    }

    @objid ("e22e4dd7-d89f-469b-86ef-cce5dec65c50")
    private ConnectionType creteLink(Diagram view, IDiagramLink node, Point translation) {
        Object obj = node.getElement();
        if (obj instanceof Relationship) {
            Relationship relationship = (Relationship) obj;

            if (relationship.getFrom() != null && relationship.getTo() != null) {
                RelationshipType jaxRelationship = (RelationshipType) this.elementRefs.get(node.getElement().getUuid());
                Object jaxSource = this.diagRefs.get(node.getFrom());
                Object jaxTarget = this.diagRefs.get(node.getTo());

                if (jaxRelationship != null && jaxSource != null && jaxTarget != null) {
                    org.modelio.archimate.exchange.v31.xmlmodel.Relationship jaxConnection = this.baseFactory.createRelationship();
                    jaxConnection.setIdentifier(IDUtils.exportId(UUID.randomUUID().toString()));
                    jaxConnection.setRelationshipRef(jaxRelationship);

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
                            LocationType jaxPoint = this.baseFactory.createLocationType();
                            jaxPoint.setX(BigInteger.valueOf(points.get(i).x + translation.x));
                            jaxPoint.setY(BigInteger.valueOf(points.get(i).y + translation.y));
                            jaxConnection.getBendpoint().add(jaxPoint);
                        }
                    }

                    this.diagRefs.put(node, jaxConnection);
                    return jaxConnection;
                }
            }
        }
        return null;
    }

    @objid ("00b62477-79e4-4dca-8829-dfcc0f3f200b")
    private RGBColorType parseColor(String input) {
        Pattern c = Pattern.compile("([0-9]+),([0-9]+),([0-9]+)");
        Matcher m = c.matcher(input);
        RGBColorType jaxFillColor = this.baseFactory.createRGBColorType();
        if (m.matches()) {
            jaxFillColor.setR(Short.valueOf(m.group(1)));
            jaxFillColor.setG(Short.valueOf(m.group(2)));
            jaxFillColor.setB(Short.valueOf(m.group(3)));
        }
        jaxFillColor.setA(Short.valueOf("100"));
        return jaxFillColor;
    }

    @objid ("474dcc84-a8ca-42d0-8ecb-73b9f9dda48a")
    public FontType convertFontType(String font, String color) {
        FontType fontType = this.baseFactory.createFontType();
        String[] fonts = font.split("-");
        fontType.setName(fonts[0]);
        fontType.setSize(BigDecimal.valueOf(Integer.valueOf(fonts[2])));
        fontType.setColor(parseColor(color));
        return fontType;
    }

    @objid ("532177ca-e4d5-4059-9004-2ea7fb0fcf11")
    @Override
    public ViewpointType createViewPoint(ModelType context, Diagram view, AbstractDiagram diagram) {
        for (Stereotype ext : diagram.getExtension()) {
            List<ElementTypeEnum> elements = ViewPointUtils.getViewPointElements(ext.getName());
            List<RelationshipTypeEnum> relations = ViewPointUtils.getViewPointRelations(ext.getName());
            List<RelationshipConnectorEnum> connectors = ViewPointUtils.getViewPointRelationshipConnector(ext.getName());

            if (elements.size() > 0 || relations.size() > 0) {

                ViewsType viewType = context.getViews();
                if (viewType == null) {
                    viewType = this.baseFactory.createViewsType();
                    context.setViews(viewType);
                }

                ViewpointsType viewpoints = viewType.getViewpoints();
                if (viewpoints == null) {
                    viewpoints = this.baseFactory.createViewpointsType();
                    viewType.setViewpoints(viewpoints);
                }

                ViewpointType viewpoint = null;
                for (ViewpointType jaxViewPoint : viewpoints.getViewpoint()) {
                    if (jaxViewPoint.getIdentifier().equals(ext.getName())) {
                        viewpoint = jaxViewPoint;
                    }
                }

                if (viewpoint == null) {

                    viewpoint = this.baseFactory.createViewpointType();
                    viewpoints.getViewpoint().add(viewpoint);
                    viewpoint.setIdentifier(ext.getName());
                    viewpoint.getNameGroup().add(createLabel(ext.getName()));

                    for (ElementTypeEnum elem : elements) {
                        AllowedElementTypeType base = this.baseFactory.createAllowedElementTypeType();
                        base.setType(elem.value());
                        viewpoint.getAllowedElementType().add(base);
                    }

                    for (RelationshipTypeEnum elem : relations) {
                        AllowedRelationshipTypeType base = this.baseFactory.createAllowedRelationshipTypeType();
                        base.setType(elem);
                        viewpoint.getAllowedRelationshipType().add(base);
                    }

                    for (RelationshipConnectorEnum elem : connectors) {
                        AllowedElementTypeType base = this.baseFactory.createAllowedElementTypeType();
                        base.setType(elem.value());
                        viewpoint.getAllowedElementType().add(base);
                    }
                }

                return viewpoint;
            }
        }
        return null;
    }

    @objid ("80cc4284-4ddc-4c08-84ec-d96c14c2c9a7")
    private Point calculateTranslation(IDiagramHandle handle) {
        Point minval = new Point(1, 1);

        for (IDiagramNode node : handle.getDiagramNode().getNodes()) {
            if (node.getBounds().x < minval.x) {
                minval.x = node.getBounds().x;
            }

            if (node.getBounds().y < minval.y) {
                minval.y = node.getBounds().y;
            }
        }

        for (IDiagramLink node : handle.getDiagramNode().getLinks()) {
            for (Point p : node.getPath().getPoints()) {
                if (p.x < minval.x) {
                    minval.x = p.x;
                }

                if (p.y < minval.y) {
                    minval.y = p.y;
                }
            }
        }

        if (minval.x < 0) {
            minval.x = minval.x * -1;
        }
        if (minval.y < 0) {
            minval.y = minval.y * -1;
        }
        return minval;
    }

    @objid ("8d58b12c-9cc5-48b2-8107-b9caed820736")
    private LangStringType createLabel(String element) {
        LangStringType jaxLabel = this.baseFactory.createLangStringType();
        jaxLabel.setValue(element);
        String local = Locale.getDefault().getLanguage();
        jaxLabel.setLang(local);
        return jaxLabel;
    }

}

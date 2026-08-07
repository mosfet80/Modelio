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
package org.modelio.archimate.exchange.v30.exporter.factory.impl;

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
import org.modelio.archimate.exchange.v30.exporter.factory.IDiagramFactoryExport;
import org.modelio.archimate.exchange.v30.xmlmodel.AllowedElementTypeType;
import org.modelio.archimate.exchange.v30.xmlmodel.AllowedRelationshipTypeType;
import org.modelio.archimate.exchange.v30.xmlmodel.ConnectionType;
import org.modelio.archimate.exchange.v30.xmlmodel.Diagram;
import org.modelio.archimate.exchange.v30.xmlmodel.Element;
import org.modelio.archimate.exchange.v30.xmlmodel.ElementType;
import org.modelio.archimate.exchange.v30.xmlmodel.ElementTypeEnum;
import org.modelio.archimate.exchange.v30.xmlmodel.FontType;
import org.modelio.archimate.exchange.v30.xmlmodel.LangStringType;
import org.modelio.archimate.exchange.v30.xmlmodel.LocationType;
import org.modelio.archimate.exchange.v30.xmlmodel.ModelType;
import org.modelio.archimate.exchange.v30.xmlmodel.ObjectFactory;
import org.modelio.archimate.exchange.v30.xmlmodel.RGBColorType;
import org.modelio.archimate.exchange.v30.xmlmodel.RelationshipConnectorEnum;
import org.modelio.archimate.exchange.v30.xmlmodel.RelationshipType;
import org.modelio.archimate.exchange.v30.xmlmodel.RelationshipTypeEnum;
import org.modelio.archimate.exchange.v30.xmlmodel.StyleType;
import org.modelio.archimate.exchange.v30.xmlmodel.ViewpointType;
import org.modelio.archimate.exchange.v30.xmlmodel.ViewpointsType;
import org.modelio.archimate.exchange.v30.xmlmodel.ViewsType;
import org.modelio.archimate.metamodel.core.Relationship;
import org.modelio.diagram.api.dg.common.LabelDG;
import org.modelio.metamodel.diagrams.AbstractDiagram;
import org.modelio.metamodel.uml.infrastructure.Stereotype;

@objid ("7d99472e-a20e-44b1-a8ff-ff0a547e04b0")
public class DiagramFactoryExport implements IDiagramFactoryExport {
    @objid ("15986184-794c-4362-aa2b-748d4be5a7c9")
    private IDiagramService diagramService;

    @objid ("3b5f357a-37ab-4462-a744-9aa0b8df7f7e")
    private Map<String, Object> elementRefs;

    @objid ("b26b8969-cb3a-44f0-b9d1-b57bda1bc3d7")
    private Map<Object, Object> diagRefs;

    @objid ("327860c3-1084-4115-9b38-d21bf32ee82c")
    private ObjectFactory baseFactory;

    @objid ("4983e0cc-a7db-4fac-892a-c0b14b494b00")
    public DiagramFactoryExport(IDiagramService diagramService) {
        this.diagramService = diagramService;
        this.baseFactory = new ObjectFactory();
        this.diagRefs = new HashMap<>();

    }

    @objid ("f4b2a150-57e3-408f-a18d-c95c21c026f8")
    @Override
    public void setReferenceMap(Map<String, Object> refs) {
        this.elementRefs = refs;
    }

    @objid ("b8cfb539-29fb-47a1-a3cb-d97c0ea441c4")
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

    @objid ("8a287970-fabb-49d4-ad71-913145426be8")
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

    @objid ("8bd7ccf7-6f40-4c4a-bf6a-2d25e77f826b")
    private ConnectionType creteLink(Diagram view, IDiagramLink node, Point translation) {
        Object obj = node.getElement();
        if (obj instanceof Relationship) {
            Relationship relationship = (Relationship) obj;

            if (relationship.getFrom() != null && relationship.getTo() != null) {
                RelationshipType jaxRelationship = (RelationshipType) this.elementRefs.get(node.getElement().getUuid());
                Object jaxSource = this.diagRefs.get(node.getFrom());
                Object jaxTarget = this.diagRefs.get(node.getTo());

                if (jaxRelationship != null && jaxSource != null && jaxTarget != null) {
                    org.modelio.archimate.exchange.v30.xmlmodel.Relationship jaxConnection = this.baseFactory.createRelationship();
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

    @objid ("91e0f390-4e56-4670-8d18-baa4cc09a9fc")
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

    @objid ("88622240-973a-4ce0-9a50-1d12815a38dd")
    public FontType convertFontType(String font, String color) {
        FontType fontType = this.baseFactory.createFontType();
        String[] fonts = font.split("-");
        fontType.setName(fonts[0]);
        fontType.setSize(BigDecimal.valueOf(Integer.valueOf(fonts[2])));
        fontType.setColor(parseColor(color));
        return fontType;
    }

    @objid ("489b3590-8759-4a8d-80ea-8c6c257bdcfc")
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

    @objid ("591c47f0-8ed2-4d2a-9fbe-da2168472ee9")
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

    @objid ("1479ffb4-f414-4e4b-8956-90a684d98ce4")
    private LangStringType createLabel(String element) {
        LangStringType jaxLabel = this.baseFactory.createLangStringType();
        jaxLabel.setValue(element);
        String local = Locale.getDefault().getLanguage();
        jaxLabel.setLang(local);
        return jaxLabel;
    }

}

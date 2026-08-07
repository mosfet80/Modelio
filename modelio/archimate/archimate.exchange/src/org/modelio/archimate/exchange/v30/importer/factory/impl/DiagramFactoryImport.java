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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.jface.resource.DataFormatException;
import org.modelio.api.modelio.diagram.IDiagramGraphic;
import org.modelio.api.modelio.diagram.IDiagramHandle;
import org.modelio.api.modelio.diagram.IDiagramLink;
import org.modelio.api.modelio.diagram.IDiagramLink.LinkRouterKind;
import org.modelio.api.modelio.diagram.IDiagramNode;
import org.modelio.api.modelio.diagram.IDiagramService;
import org.modelio.api.modelio.diagram.dg.IDiagramDrawingsLayer;
import org.modelio.archimate.exchange.service.utils.IDUtils;
import org.modelio.archimate.exchange.v30.importer.factory.IDiagramFactoryImport;
import org.modelio.archimate.exchange.v30.xmlmodel.ConnectionType;
import org.modelio.archimate.exchange.v30.xmlmodel.Container;
import org.modelio.archimate.exchange.v30.xmlmodel.Diagram;
import org.modelio.archimate.exchange.v30.xmlmodel.Element;
import org.modelio.archimate.exchange.v30.xmlmodel.ElementType;
import org.modelio.archimate.exchange.v30.xmlmodel.FontType;
import org.modelio.archimate.exchange.v30.xmlmodel.Label;
import org.modelio.archimate.exchange.v30.xmlmodel.LocationType;
import org.modelio.archimate.exchange.v30.xmlmodel.RGBColorType;
import org.modelio.archimate.exchange.v30.xmlmodel.RelationshipType;
import org.modelio.archimate.exchange.v30.xmlmodel.StyleType;
import org.modelio.archimate.exchange.v30.xmlmodel.ViewNodeType;
import org.modelio.archimate.metamodel.core.ArchimateView;
import org.modelio.archimate.metamodel.core.Concept;
import org.modelio.archimate.metamodel.core.Relationship;
import org.modelio.archimate.metamodel.core.structure.ArchimateProject;
import org.modelio.archimate.metamodel.core.structure.Model;
import org.modelio.metamodel.uml.infrastructure.ModelElement;

/**
 * Create Archimate Diagram.
 */
@objid ("874a4c92-64c4-4805-9b5d-708af17b1410")
public class DiagramFactoryImport implements IDiagramFactoryImport {
    @objid ("ae54d1a0-8002-4dc8-a730-94a02973feec")
    private static final int DEFAULT_X = 120;

    @objid ("ccac87b7-31c5-4f74-9373-bf87b86d4adb")
    private static final int DEFAULT_Y = 60;

    @objid ("23490c9f-c59e-4a4b-b11c-8f5360a3222e")
    private static final int DEFAULT_W = 0;

    @objid ("7a93060b-6392-4dae-b158-c70f13f44d4f")
    private static final int DEFAULT_H = 0;

    @objid ("fed28f33-63df-4bc6-b13b-64f93a98c72d")
    private static final int STRUCTURED = 1;

    @objid ("55ec9880-6ed0-4ef9-a03b-a02f052a6fb9")
    private boolean nativeStyle = true;

    @objid ("ba205ade-3738-4918-80ec-937904c292a2")
    private IDiagramService diagramService;

    @objid ("b740b075-74dc-4109-a6ac-38f03cc761ea")
    private Map<String, ModelElement> refs;

    @objid ("aa63cbdf-f3d3-4b66-b3b2-7ed12eb53f73")
    public DiagramFactoryImport(IDiagramService diagramService, ArchimateProject context, boolean nativeStyle) {
        this.diagramService = diagramService;
        this.nativeStyle = nativeStyle;
        this.refs = new HashMap<>();
    }

    @objid ("9bf76da5-bf6f-4775-8479-bc195f7e0b91")
    @Override
    public void setReferenceMap(Map<String, ModelElement> refs) {
        this.refs = refs;
    }

    @objid ("3f6c9104-396b-4d05-b987-6c95d6cae58d")
    @Override
    public void createArchimateView(Model model, ArchimateView view, Diagram jaxView) {
        try (IDiagramHandle handle = this.diagramService.getDiagramHandle(view)) {
            // Clean Diagram
            for (IDiagramNode node : handle.getDiagramNode().getNodes()) {
                node.mask();
            }
            for (IDiagramLink node : handle.getDiagramNode().getLinks()) {
                node.mask();
            }

            // Import DG
            handle.setBatchMode(true);

            List<LayoutElement> layouts = new ArrayList<>();
            // Unmask node
            int srank = 0;
            for (ViewNodeType nodeType : jaxView.getNode()) {
                if (nodeType instanceof Element) {
                    Element jaxNode = (Element) nodeType;
                    if (jaxNode.getElementRef() instanceof ElementType) {
                        Concept concept = (Concept) this.refs.get(IDUtils.importId(((ElementType) jaxNode.getElementRef()).getIdentifier()));
                        if (concept != null) {
                            layouts.add(unmaskNode(handle, new Rectangle(0, 0, 10000, 100), srank, jaxView.getNode().size(), concept, jaxNode));
                        }
                    }
                } else if (nodeType instanceof Container) {
                    layouts.add(unmaskContainer(handle, new Rectangle(0, 0, 10000, 100), srank, jaxView.getNode().size(), nodeType));
                }else if (nodeType instanceof Label) {
                    unmaskNote(handle, (Label) nodeType);
                }
                srank++;
            }

            // Layout node
            for(LayoutElement layout : layouts) {
                layoutNode(layout);
            }

            // Unmask Connector
            for (ConnectionType connectionType : jaxView.getConnection()) {
                if (connectionType instanceof org.modelio.archimate.exchange.v30.xmlmodel.Relationship) {
                    org.modelio.archimate.exchange.v30.xmlmodel.Relationship jaxNode = (org.modelio.archimate.exchange.v30.xmlmodel.Relationship) connectionType;
                    Relationship relationship = (Relationship) this.refs.get(IDUtils.importId(((RelationshipType) jaxNode.getRelationshipRef()).getIdentifier()));
                    if (relationship != null) {
                        unmaskLink(handle, relationship, jaxNode);
                    }
                }
            }

            handle.save();
        }
    }

    @objid ("3c7cadbe-c4dc-47c7-ba48-92a8f3500aa4")
    private void unmaskLink(IDiagramHandle handle, Relationship relationship, org.modelio.archimate.exchange.v30.xmlmodel.Relationship jaxNode) {
        List<IDiagramGraphic> graphics = handle.getDiagramGraphics(relationship);
        if (graphics.isEmpty()) {
            graphics = handle.unmask(relationship, 0, 0);
        }

        List<LocationType> jaxBendpoints = jaxNode.getBendpoint();
        if (jaxBendpoints == null) {
            return;
        }

        // Load Points
        List<Point> points = new ArrayList<>();
        for (LocationType jaxBendpoint : jaxBendpoints) {
            if (jaxBendpoint.getX() != null && jaxBendpoint.getY() != null) {
                points.add(new Point(jaxBendpoint.getX().intValue(), jaxBendpoint.getY().intValue()));
            }
        }

        if (!graphics.isEmpty() && graphics.get(0) instanceof IDiagramLink) {

            //Set the router kind and the path
            IDiagramLink dgNode = ((IDiagramLink) graphics.get(0));
            if (points.isEmpty()) {
                dgNode.setRouterKind(LinkRouterKind.DIRECT);
            } else {
                dgNode.setRouterKind(LinkRouterKind.ORTHOGONAL);
                // Add First and Last point
                if (dgNode.getFrom() instanceof IDiagramNode) {
                    IDiagramNode from = (IDiagramNode) dgNode.getFrom();
                    points.add(0, from.getBounds().getCenter());
                }
                if (dgNode.getTo() instanceof IDiagramNode) {
                    IDiagramNode from = (IDiagramNode) dgNode.getTo();
                    points.add(from.getBounds().getCenter());
                }
                dgNode.setPath(points);

            }

            //Set the graphical style
            StyleType jaxStyle = jaxNode.getStyle();
            if (jaxStyle != null) {
                RGBColorType lineColor = jaxStyle.getLineColor();
                if (lineColor != null) {
                    String rgb = lineColor.getR() + "," + lineColor.getG() + ","
                            + lineColor.getB();
                    dgNode.setLineColor(rgb);
                }

                if (jaxStyle.getLineWidth() != null) {
                    dgNode.setLineWidth(jaxStyle.getLineWidth().intValue());
                }

                if (jaxStyle.getFont() != null) {
                    try {
                        FontType fontType = jaxStyle.getFont();
                        RGBColorType fontColor = fontType.getColor();
                        if (fontColor != null) {
                            String rgb = fontColor.getR() + "," + fontColor.getG() + "," + fontColor.getB();
                            dgNode.setTextColor(rgb);
                        }
                        dgNode.setFont(convertFont(fontType));
                    } catch (DataFormatException e) {
                        // Ignore invalid fonts
                    }
                }
            }

            //Set the rounded value
            dgNode.setLineRadius(5);
        }
    }

    @objid ("a1156baa-c610-46be-bb00-59a2a5211afa")
    private LayoutElement unmaskNode(IDiagramHandle handle, Rectangle parent, int rank, int total, Concept modelioElement, Element jaxNode) {
        LayoutElement layout = new LayoutElement();

        int width = (parent.width / total) - 2;
        int posX = parent.x + ((width + 1) * rank);
        Rectangle bounds = new Rectangle(posX, parent.y + 1, width, 100);

        List<IDiagramGraphic> graphics = handle.unmask(modelioElement, bounds.x, bounds.y);


        if (graphics.size() > 0) {
            IDiagramNode dgNode = (IDiagramNode) graphics.get(0);
            layout.setDgNode(dgNode);
            layout.setJaxNode(jaxNode);

            if(!this.nativeStyle) {
                dgNode.setRepresentationMode(DefaultRepresentationUtils.getDefaultRepresentationModel(modelioElement));
            }

            dgNode.setBounds(new Rectangle(bounds.x, bounds.y, width, 100));

            StyleType jaxStyle = jaxNode.getStyle();
            if (jaxStyle != null) {

                if (jaxStyle.getFillColor() != null) {
                    String rgb = jaxStyle.getFillColor().getR() + "," + jaxStyle.getFillColor().getG() + "," + jaxStyle.getFillColor().getB();
                    dgNode.setFillColor(rgb);
                }

                if (jaxStyle.getLineColor() != null) {
                    String rgb = jaxStyle.getLineColor().getR() + "," + jaxStyle.getLineColor().getG() + "," + jaxStyle.getLineColor().getB();
                    dgNode.setLineColor(rgb);
                }

                if (jaxStyle.getLineWidth() != null) {
                    dgNode.setLineWidth(jaxStyle.getLineWidth().intValue());
                }

                if (jaxStyle.getFont() != null) {
                    try {
                        FontType fontType = jaxStyle.getFont();
                        if (fontType.getColor() != null) {
                            String rgb = fontType.getColor().getR() + "," + fontType.getColor().getG() + "," + fontType.getColor().getB();
                            dgNode.setTextColor(rgb);
                        }
                        dgNode.setFont(convertFont(fontType));
                    } catch (DataFormatException e) {
                        // Ignore invalid fonts
                    }
                }
            }
        }

        int srank = 0;
        for (ViewNodeType subNode : jaxNode.getNode()) {
            if (subNode instanceof Element) {
                Element jaxSubNode = (Element) subNode;
                if (jaxSubNode.getElementRef() instanceof ElementType) {
                    Concept subConcept = (Concept) this.refs.get(IDUtils.importId(((ElementType) jaxSubNode.getElementRef()).getIdentifier()));
                    if (subConcept != null) {
                        layout.getChildren().add(unmaskNode(handle, bounds, srank, jaxNode.getNode().size(), subConcept, jaxSubNode));
                    }
                }
            } else if (subNode instanceof Container) {
                layout.getChildren().add(unmaskContainer(handle, bounds, srank, jaxNode.getNode().size(), subNode));
            }

            if (graphics.size() > 0) {
                IDiagramNode dgNode = (IDiagramNode) graphics.get(0);
                dgNode.setBounds(new Rectangle(bounds.x, bounds.y, width, 100));
            }
            srank++;
        }
        return layout;
    }

    @objid ("1c64e93f-2883-4601-b433-269d3bb12bc8")
    private String convertFont(FontType fontType) {
        String name = "Arial";
        String style = "regular";
        String size = "10";

        if (fontType.getName() != null && !fontType.getName().equals("")) {
            name = fontType.getName();
        }

        if (fontType.getSize() != null) {
            size = fontType.getSize().toString();
        }
        return name + "-" + style + "-" + size;
    }

    @objid ("1c4996df-d50c-480e-9441-63099213f97c")
    private LayoutElement unmaskContainer(IDiagramHandle handle, Rectangle parent, int rank, int total, ViewNodeType nodeType) {
        LayoutElement layouts = new LayoutElement();
        int width = (parent.width / total) - 2;
        int posX = parent.x + ((width + 1) * rank);
        Rectangle bounds = new Rectangle(posX, parent.y + 1, width, 100);

        int srank = 0;
        for (ViewNodeType subNode : ((Container) nodeType).getNode()) {
            if (subNode instanceof Element) {
                Element jaxSubNode = (Element) subNode;
                if (jaxSubNode.getElementRef() instanceof ElementType) {
                    Concept subConcept = (Concept) this.refs.get(IDUtils.importId(((ElementType) jaxSubNode.getElementRef()).getIdentifier()));
                    if (subConcept != null) {
                        layouts.getChildren().add(unmaskNode(handle, bounds, srank, ((Container) nodeType).getNode().size(), subConcept, jaxSubNode));
                    }
                }
            } else if (subNode instanceof Container) {
                layouts.getChildren().add(unmaskContainer(handle, bounds, srank, ((Container) nodeType).getNode().size(), subNode));
            }

            srank++;
        }
        return layouts;
    }

    @objid ("7ae93004-ac2f-4145-aba6-77102707ebe0")
    private void unmaskNote(IDiagramHandle handle, Label jaxNode) {
        Rectangle rect = getNodeBounds(jaxNode);

        if (!(jaxNode.getLabelGroup().isEmpty())) {
            String content = jaxNode.getLabelGroup().get(0).getValue();

            handle.getCreationFactory().createDrawingNote(handle.getDiagramNode().getDrawingsLayer(IDiagramDrawingsLayer.TOP), null,
                    content, rect.x(), rect.y(), rect.width(), rect.height());
        }
    }

    @objid ("1a2e5071-6dc8-48ff-80a7-2174df73027d")
    private void layoutNode(LayoutElement layout) {
        if(layout.getJaxNode() != null) {
            Element jaxNode = layout.getJaxNode();

            Rectangle rect = getNodeBounds(jaxNode);

            IDiagramNode dgNode = layout.getDgNode();
            dgNode.setBounds(new Rectangle(dgNode.getBounds().x,dgNode.getBounds().y,rect.width,rect.height));
            dgNode.setBounds(rect);
        }

        for(LayoutElement children : layout.getChildren()) {
            layoutNode(children);
        }
    }

    @objid ("f45968a4-bb0e-4b2d-b02a-a4f8dfc4c712")
    private Rectangle getNodeBounds(ViewNodeType jaxNode) {
        Rectangle rect = new Rectangle();
        if (jaxNode.getW() != null) {
            rect.width = jaxNode.getW().intValue();
        } else {
            rect.width = DEFAULT_W;
        }

        if (jaxNode.getH() != null) {
            rect.height = jaxNode.getH().intValue();
        } else {
            rect.height = DEFAULT_H;
        }

        if (jaxNode.getX() != null) {
            rect.x = jaxNode.getX().intValue();
        } else {
            rect.x = DEFAULT_X;
        }

        if (jaxNode.getY() != null) {
            rect.y = jaxNode.getY().intValue();
        } else {
            rect.y = DEFAULT_Y;
        }
        return rect;
    }

}

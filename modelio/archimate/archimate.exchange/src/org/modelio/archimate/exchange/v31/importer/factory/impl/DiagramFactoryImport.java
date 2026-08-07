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
import org.modelio.archimate.exchange.v31.importer.factory.IDiagramFactoryImport;
import org.modelio.archimate.exchange.v31.xmlmodel.ConnectionType;
import org.modelio.archimate.exchange.v31.xmlmodel.Container;
import org.modelio.archimate.exchange.v31.xmlmodel.Diagram;
import org.modelio.archimate.exchange.v31.xmlmodel.Element;
import org.modelio.archimate.exchange.v31.xmlmodel.ElementType;
import org.modelio.archimate.exchange.v31.xmlmodel.FontType;
import org.modelio.archimate.exchange.v31.xmlmodel.Label;
import org.modelio.archimate.exchange.v31.xmlmodel.LocationType;
import org.modelio.archimate.exchange.v31.xmlmodel.RGBColorType;
import org.modelio.archimate.exchange.v31.xmlmodel.RelationshipType;
import org.modelio.archimate.exchange.v31.xmlmodel.StyleType;
import org.modelio.archimate.exchange.v31.xmlmodel.ViewNodeType;
import org.modelio.archimate.metamodel.core.ArchimateView;
import org.modelio.archimate.metamodel.core.Concept;
import org.modelio.archimate.metamodel.core.Relationship;
import org.modelio.archimate.metamodel.core.structure.ArchimateProject;
import org.modelio.archimate.metamodel.core.structure.Model;
import org.modelio.metamodel.uml.infrastructure.ModelElement;

/**
 * Create Archimate Diagram.
 */
@objid ("58e2c8b2-654f-4381-a43a-f63483aba97c")
public class DiagramFactoryImport implements IDiagramFactoryImport {
    @objid ("5eab9838-cf50-4fb0-93d1-7a81e31eb9aa")
    private static final int DEFAULT_X = 120;

    @objid ("0eddd970-51ae-4529-8ae8-24170587ade2")
    private static final int DEFAULT_Y = 60;

    @objid ("5ea50c49-ee80-400c-ae9c-ee3a5d1d20f8")
    private static final int DEFAULT_W = 0;

    @objid ("cc65d3ef-0313-403d-bd71-96715a75f514")
    private static final int DEFAULT_H = 0;

    @objid ("81ec02d1-0cf6-42c6-be97-0490f3be4773")
    private static final int STRUCTURED = 1;

    @objid ("40767665-ac99-481f-a587-7926e58be2cc")
    private boolean nativeStyle = true;

    @objid ("c026f45a-f363-4a2b-bc21-dcd419fb758e")
    private IDiagramService diagramService;

    @objid ("e713b493-fb9c-40fd-a7bc-d576717b6514")
    private Map<String, ModelElement> refs;

    @objid ("70440b8c-73ea-40eb-a5dd-8d728cf8be60")
    public DiagramFactoryImport(IDiagramService diagramService, ArchimateProject context, boolean nativeStyle) {
        this.diagramService = diagramService;
        this.nativeStyle = nativeStyle;
        this.refs = new HashMap<>();
    }

    @objid ("18eab34e-e3cb-49c3-8f64-d428790f4049")
    @Override
    public void setReferenceMap(Map<String, ModelElement> refs) {
        this.refs = refs;
    }

    @objid ("acc89bce-fe71-4aa7-8d54-1ba8569b226c")
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
                if (connectionType instanceof org.modelio.archimate.exchange.v31.xmlmodel.Relationship) {
                    org.modelio.archimate.exchange.v31.xmlmodel.Relationship jaxNode = (org.modelio.archimate.exchange.v31.xmlmodel.Relationship) connectionType;
                    Relationship relationship = (Relationship) this.refs.get(IDUtils.importId(((RelationshipType) jaxNode.getRelationshipRef()).getIdentifier()));
                    if (relationship != null) {
                        unmaskLink(handle, relationship, jaxNode);
                    }
                }
            }

            handle.save();
        }
    }

    @objid ("4baf3e93-8d14-4426-9756-456d34b3367b")
    private void unmaskLink(IDiagramHandle handle, Relationship relationship, org.modelio.archimate.exchange.v31.xmlmodel.Relationship jaxNode) {
        List<IDiagramGraphic> graphics = handle.getDiagramGraphics(relationship);
        if (graphics.isEmpty()) {
            graphics = handle.unmask(relationship, 0, 0);
        }

        //                    List<IDiagramGraphic> graphics = handle.unmask(relationship, 0, 0);

        List<LocationType> jaxBendpoints = jaxNode.getBendpoint();
        if (jaxBendpoints == null)
            return;

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
                    IDiagramNode node = (IDiagramNode) dgNode.getFrom();
                    points.add(0, node.getBounds().getCenter());
                }

                if (dgNode.getTo() instanceof IDiagramNode) {
                    IDiagramNode node = (IDiagramNode) dgNode.getTo();
                    points.add(node.getBounds().getCenter());
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
                            String rgb = fontColor.getR() + "," + fontColor.getG() + ","
                                    + fontColor.getB();
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

    @objid ("f83af925-5f78-418a-9ac6-4b63c72441c7")
    private LayoutElement unmaskNode(IDiagramHandle handle, Rectangle parent, int rank, int total, Concept modelioElement, Element jaxNode) {
        LayoutElement layout = new LayoutElement();

        int width = (parent.width / total) - 2;
        int posX = parent.x + ((width + 1) * rank);
        Rectangle bounds = new Rectangle(posX, parent.y + 1, width, 100);

        List<IDiagramGraphic> graphics = handle.unmask(modelioElement, bounds.x, bounds.y);

        if (! graphics.isEmpty()) {
            IDiagramNode dgNode = (IDiagramNode) graphics.get(0);
            layout.setDgNode(dgNode);
            layout.setJaxNode(jaxNode);

            if(!this.nativeStyle) {
                dgNode.setRepresentationMode(DefaultRepresentationUtils.getDefaultRepresentationModel(modelioElement));
            }
            dgNode.setBounds(new Rectangle(bounds.x, bounds.y, width, 100));
            StyleType jaxStyle = jaxNode.getStyle();
            if (jaxStyle != null) {

                RGBColorType fillColor = jaxStyle.getFillColor();
                if (fillColor != null) {
                    String rgb = fillColor.getR() + "," + fillColor.getG() + "," + fillColor.getB();
                    dgNode.setFillColor(rgb);
                }

                RGBColorType lineColor = jaxStyle.getLineColor();
                if (lineColor != null) {
                    String rgb = lineColor.getR() + "," + lineColor.getG() + "," + lineColor.getB();
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

            if (!graphics.isEmpty()) {
                IDiagramNode dgNode = (IDiagramNode) graphics.get(0);
                dgNode.setBounds(new Rectangle(bounds.x, bounds.y, width, 100));
            }
            srank++;
        }
        return layout;
    }

    @objid ("93cd85f4-aab4-4ddc-a30c-13154c76e1fc")
    private void unmaskNote(IDiagramHandle handle, Label jaxNode) {
        Rectangle rect = getNodeBounds(jaxNode);

        if (!(jaxNode.getLabelGroup().isEmpty())) {
            String content = jaxNode.getLabelGroup().get(0).getValue();

            handle.getCreationFactory().createDrawingNote(handle.getDiagramNode().getDrawingsLayer(IDiagramDrawingsLayer.TOP), null,
                    content, rect.x(), rect.y(), rect.width(), rect.height());
        }
    }

    @objid ("312fbacd-f00c-4b77-85ae-6d628ff7ae2b")
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

    @objid ("18fdd736-a8e9-45c7-a277-ce657329957b")
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

    @objid ("c4803389-6c27-4018-a04f-c99c01d633d4")
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

    @objid ("68df10a5-d0a9-408c-89c9-239c6d13ee49")
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

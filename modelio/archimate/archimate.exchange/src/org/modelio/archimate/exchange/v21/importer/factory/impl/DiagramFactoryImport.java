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
package org.modelio.archimate.exchange.v21.importer.factory.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
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
import org.modelio.archimate.exchange.service.utils.BaseFactory;
import org.modelio.archimate.exchange.service.utils.IDUtils;
import org.modelio.archimate.exchange.v21.importer.factory.IDiagramFactoryImport;
import org.modelio.archimate.exchange.v21.xmlmodel.BendpointType;
import org.modelio.archimate.exchange.v21.xmlmodel.ConnectionType;
import org.modelio.archimate.exchange.v21.xmlmodel.ElementType;
import org.modelio.archimate.exchange.v21.xmlmodel.FontType;
import org.modelio.archimate.exchange.v21.xmlmodel.LangStringType;
import org.modelio.archimate.exchange.v21.xmlmodel.NodeType;
import org.modelio.archimate.exchange.v21.xmlmodel.RelationshipType;
import org.modelio.archimate.exchange.v21.xmlmodel.StyleType;
import org.modelio.archimate.exchange.v21.xmlmodel.ViewType;
import org.modelio.archimate.metamodel.core.ArchimateView;
import org.modelio.archimate.metamodel.core.Concept;
import org.modelio.archimate.metamodel.core.Relationship;
import org.modelio.archimate.metamodel.core.generic.composite.Grouping;
import org.modelio.archimate.metamodel.core.structure.ArchimateProject;
import org.modelio.archimate.metamodel.core.structure.Model;
import org.modelio.metamodel.uml.infrastructure.ModelElement;
import org.modelio.vcore.session.api.ICoreSession;
import org.modelio.vcore.session.impl.CoreSession;

@objid ("d1aadba8-852f-41f8-95d8-4b1d51f2603f")
public class DiagramFactoryImport implements IDiagramFactoryImport {
    @objid ("dd1721be-e168-4a9b-b0d1-261518293223")
    private static final int DEFAULT_X = 120;

    @objid ("0a947000-16cb-45ad-9722-a19a48b9f72d")
    private static final int DEFAULT_Y = 60;

    @objid ("48729e8c-ef2e-4b5b-8700-61de5328a085")
    private static final int DEFAULT_W = 0;

    @objid ("2b25661a-e918-4de9-bf85-819b62632c70")
    private static final int DEFAULT_H = 0;

    @objid ("8a7b2a86-55fe-4060-ba80-609b9c3e3e15")
    private static final int STRUCTURED = 1;

    @objid ("6097acc0-a216-440d-98b7-20959603a024")
    private IDiagramService diagramService;

    @objid ("f0972e7b-ef59-40ad-bcf0-eb4979c25acd")
    private BaseFactory baseFactory;

    @objid ("371f1770-7547-4bd3-b0af-2e4b865b9b22")
    private Map<String, ModelElement> refs;

    @objid ("0d3127c5-15a0-4e59-9cfe-2742cc002fbb")
    public DiagramFactoryImport(ICoreSession session, IDiagramService diagramService, ArchimateProject context) {
        this.diagramService = diagramService;
        this.baseFactory = new BaseFactory((CoreSession) session);
        this.refs = new HashMap<>();

    }

    @objid ("9cc63d10-14d6-4451-9941-9bd4cd0fdf9b")
    @Override
    public void setReferenceMap(Map<String, ModelElement> refs) {
        this.refs = refs;
    }

    @objid ("8fa94341-f309-47b8-b2a2-b4952398b1d6")
    @Override
    public void createArchimateView(Model model, ArchimateView view, ViewType jaxView) {
        try (IDiagramHandle handle = this.diagramService.getDiagramHandle(view)) {

            // Clean Diagram
            for (IDiagramNode node : handle.getDiagramNode().getNodes()) {
                node.mask();
            }
            for (IDiagramLink node : handle.getDiagramNode().getLinks()) {
                node.mask();
            }

            handle.setBatchMode(true);
            for (NodeType jaxNode : jaxView.getNode()) {

                if (jaxNode.getType() != null && jaxNode.getType().equals("group")) {
                    createGroup(model, handle, jaxNode);
                } else if (jaxNode.getElementref() instanceof ElementType) {
                    Concept concept = (Concept) this.refs.get(IDUtils.importId(((ElementType) jaxNode.getElementref()).getIdentifier()));
                    if (concept != null) {
                        unmaskNode(model, handle, null, concept, jaxNode);
                    }
                }
            }

            for (ConnectionType jaxNode : jaxView.getConnection()) {
                if (jaxNode.getRelationshipref() instanceof RelationshipType) {
                    Relationship relationship = (Relationship) this.refs
                            .get(IDUtils.importId(((RelationshipType) jaxNode.getRelationshipref()).getIdentifier()));
                    if (relationship != null) {
                        unmaskLink(handle, relationship, jaxNode);
                    }
                }
            }

            handle.save();
        }

    }

    @objid ("a25d650a-2bca-4e23-b9e4-7de4eb0102f1")
    private void unmaskLink(IDiagramHandle handle, Relationship relationship, ConnectionType jaxNode) {
        List<IDiagramGraphic> graphics = handle.getDiagramGraphics(relationship);
        if (graphics.isEmpty()) {
            graphics = handle.unmask(relationship, 0, 0);
        }

        List<BendpointType> jaxBendpoints = jaxNode.getBendpoint();
        if (jaxBendpoints == null)
            return;

            // Load Points

            List<Point> points = new ArrayList<>();
            for (BendpointType jaxBendpoint : jaxBendpoints) {
                if (jaxBendpoint.getX() != null && jaxBendpoint.getY() != null) {
                    points.add(new Point(jaxBendpoint.getX().intValue(), jaxBendpoint.getY().intValue()));
                }
            }

            if (graphics.size() > 0 && graphics.get(0) instanceof IDiagramLink) {
                IDiagramLink dgNode = ((IDiagramLink) graphics.get(0));
                if (points.isEmpty()) {
                    dgNode.setRouterKind(LinkRouterKind.DIRECT);
                } else {
                    // Add First and Last point
                    dgNode.setRouterKind(LinkRouterKind.ORTHOGONAL);
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


                StyleType jaxStyle = jaxNode.getStyle();
                if (jaxStyle != null) {
                    if (jaxStyle.getLineColor() != null) {
                        String rgb = jaxStyle.getLineColor().getR() + "," + jaxStyle.getLineColor().getG() + ","
                                + jaxStyle.getLineColor().getB();
                        dgNode.setLineColor(rgb);
                    }

                    if (jaxStyle.getLineWidth() != null) {
                        dgNode.setLineWidth(jaxStyle.getLineWidth().intValue());
                    }

                    if (jaxStyle.getFont() != null) {
                        try {
                            FontType fontType = jaxStyle.getFont();
                            if (fontType.getColor() != null) {
                                String rgb = fontType.getColor().getR() + "," + fontType.getColor().getG() + ","
                                        + fontType.getColor().getB();
                                dgNode.setTextColor(rgb);
                            }
                            dgNode.setFont(convertFont(fontType));
                        } catch (DataFormatException e) {
                            // Ignore invalid fonts
                        }
                    }
                }
            }

    }

    @objid ("bcedf19b-53f9-48c7-8f50-5fe436250831")
    private void unmaskNode(Model model, IDiagramHandle handle, Concept parent, Concept concept, NodeType jaxNode) {
        Rectangle rect = new Rectangle();
        if (jaxNode.getW() != null) {
            rect.width = jaxNode.getW().intValue();
        } else {
            rect.width = DiagramFactoryImport.DEFAULT_W;
        }

        if (jaxNode.getH() != null) {
            rect.height = jaxNode.getH().intValue();
        } else {
            rect.height = DiagramFactoryImport.DEFAULT_H;
        }

        if (jaxNode.getX() != null) {
            rect.x = jaxNode.getX().intValue();
        } else {
            rect.x = DiagramFactoryImport.DEFAULT_X;
        }

        if (jaxNode.getY() != null) {
            rect.y = jaxNode.getY().intValue();
        } else {
            rect.y = DiagramFactoryImport.DEFAULT_Y;
        }

        List<IDiagramGraphic> graphics = new ArrayList<>();
        if (parent != null) {
            List<IDiagramGraphic> graphicsParent = handle.getDiagramGraphics(parent);
            // FIXME take the appropriate parent for this child instead of the
            // first one
            if (graphicsParent.size() > 0) {
                IDiagramNode dgNode = (IDiagramNode) graphicsParent.get(0);
                graphics = handle.unmask(concept, dgNode.getBounds().x + 1, dgNode.getBounds().y + 1);

            }
        } else {
            graphics = handle.unmask(concept, rect.x, rect.y);
        }

        if (graphics.size() > 0) {
            IDiagramNode dgNode = (IDiagramNode) graphics.get(0);
            dgNode.setBounds(rect);
        }

        for (NodeType jaxSubNode : jaxNode.getNode()) {
            if (jaxSubNode != null && jaxSubNode.getType() != null && jaxNode.getType().equals("group")) {
                createGroup(model, handle, jaxSubNode);
            } else if (jaxSubNode != null && jaxSubNode.getElementref() instanceof ElementType) {
                Concept subConcept = (Concept) this.refs
                        .get(IDUtils.importId(((ElementType) jaxSubNode.getElementref()).getIdentifier()));
                if (subConcept != null) {
                    unmaskNode(model, handle, concept, subConcept, jaxSubNode);
                }
            }
        }

        if (graphics.size() > 0) {
            IDiagramNode dgNode = (IDiagramNode) graphics.get(0);
            dgNode.setRepresentationMode(DiagramFactoryImport.STRUCTURED);
            dgNode.setBounds(rect);

            StyleType jaxStyle = jaxNode.getStyle();
            if (jaxStyle != null) {
                if (jaxStyle.getFillColor() != null) {
                    String rgb = jaxStyle.getFillColor().getR() + "," + jaxStyle.getFillColor().getG() + ","
                            + jaxStyle.getFillColor().getB();
                    dgNode.setFillColor(rgb);
                }

                if (jaxStyle.getLineColor() != null) {
                    String rgb = jaxStyle.getLineColor().getR() + "," + jaxStyle.getLineColor().getG() + ","
                            + jaxStyle.getLineColor().getB();
                    dgNode.setLineColor(rgb);
                }

                if (jaxStyle.getLineWidth() != null) {
                    dgNode.setLineWidth(jaxStyle.getLineWidth().intValue());
                }
                if (jaxStyle.getFont() != null) {
                    try {
                        FontType fontType = jaxStyle.getFont();
                        if (fontType.getColor() != null) {
                            String rgb = fontType.getColor().getR() + "," + fontType.getColor().getG() + ","
                                    + fontType.getColor().getB();
                            dgNode.setTextColor(rgb);
                        }
                        dgNode.setFont(convertFont(fontType));
                    } catch (DataFormatException e) {
                        // Ignore invalid fonts
                    }
                }
            }
        }

    }

    @objid ("6a6eb0f6-ea6f-43a5-ab82-2f0dbb7e0c16")
    private void createGroup(Model model, IDiagramHandle handle, NodeType jaxNode) {
        Grouping grouping = this.baseFactory.create(Grouping.class, model);
        model.getContent().add(grouping);

        String label = getInternationalisedString(jaxNode.getLabel());
        grouping.setName(label);

        unmaskNode(model, handle, null, grouping, jaxNode);

    }

    @objid ("89c763ee-3ffe-4240-8ead-23724f4f16b4")
    private String getInternationalisedString(List<LangStringType> labels) {
        String local = ResourceBundle.getBundle("archiexchange").getLocale().getLanguage();
        if (labels != null) {
            for (LangStringType label : labels) {
                if (label.getLang() != null && label.getLang().equals(local)) {
                    return label.getValue();
                }
            }

            if (labels.size() > 0) {
                return labels.get(0).getValue();
            }
        }
        return "";
    }

    @objid ("a48bdb6d-c0b4-4f8c-914b-943899c1af85")
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

}

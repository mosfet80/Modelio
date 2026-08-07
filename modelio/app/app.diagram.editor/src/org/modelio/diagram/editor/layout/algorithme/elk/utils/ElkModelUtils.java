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
package org.modelio.diagram.editor.layout.algorithme.elk.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Set;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionRectangle;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.elk.graph.ElkBendPoint;
import org.eclipse.elk.graph.ElkConnectableShape;
import org.eclipse.elk.graph.ElkEdge;
import org.eclipse.elk.graph.ElkEdgeSection;
import org.eclipse.elk.graph.ElkNode;
import org.eclipse.elk.graph.ElkPort;
import org.eclipse.gef.GraphicalEditPart;
import org.modelio.api.modelio.diagram.IDiagramLink;
import org.modelio.api.modelio.diagram.IDiagramNode;
import org.modelio.api.modelio.diagram.ILinkPath;

@objid ("093b9320-9c4a-47bc-b64e-86a1d1b6c01c")
public class ElkModelUtils {
    @objid ("90c4b83b-b071-4691-9e13-64d6b368c7bd")
    public static void setBounds(ElkConnectableShape node, IDiagramNode nodeDg, Point translation) {
        // Set the coordinates into your own diagram
        PrecisionRectangle newBounds = new PrecisionRectangle(0, 0, 0, 0);

        newBounds.setX((int) (translation.x + node.getX()));
        newBounds.setY((int) (translation.y + node.getY()));
        newBounds.setWidth(Math.max((int) node.getWidth(), 15));
        newBounds.setHeight(Math.max((int) node.getHeight(), 15));
        nodeDg.setBounds(newBounds);
        if (nodeDg.getBounds().width < 20 && nodeDg.getBounds().height < 20) {
            nodeDg.fitToContent();
        }
    }

    @objid ("2c34a778-311c-4861-9f5b-938ca2d78429")
    public static Point getBarycentreFromParts(List<GraphicalEditPart> editParts) {
        Point barycentre = new Point(0, 0);

        for (GraphicalEditPart part : editParts) {
            Rectangle fig = part.getFigure().getBounds();
            Point center = fig.getCenter();
            barycentre.x += center.x;
            barycentre.y += center.y;
        }

        int size = editParts.size();
        barycentre.x = barycentre.x / size;
        barycentre.y = barycentre.y / size;

        return barycentre;
    }

    @objid ("b36007ab-56b3-4e29-afdd-ab7554a546b9")
    public static Set<IDiagramLink> getAllLinks(IDiagramNode diagramDg) {
        Set<IDiagramLink> allLinks = new HashSet<>();
        for (IDiagramNode nodeDg : diagramDg.getNodes()) {
            allLinks.addAll(nodeDg.getFromLinks());
            allLinks.addAll(nodeDg.getToLinks());
            allLinks.addAll(getAllLinks(nodeDg));
        }
        return allLinks;
    }

    @objid ("214a1cf0-c3e9-45ef-bd0c-1a588bf6bfac")
    public static Point getBarycentreFromNodes(List<IDiagramNode> nodes) {
        Point barycentre = new Point(0, 0);

        for (IDiagramNode node : nodes) {
            Rectangle fig = node.getBounds();
            Point center = fig.getCenter();
            barycentre.x += center.x;
            barycentre.y += center.y;
        }

        int size = nodes.size();
        barycentre.x = barycentre.x / size;
        barycentre.y = barycentre.y / size;

        return barycentre;
    }

    @objid ("ade67058-c563-4fb6-a439-8ac39bc5c4ae")
    public static List<Point> getContour(List<GraphicalEditPart> editParts) {
        List<Point> contour = new ArrayList<>();

        for (GraphicalEditPart part : editParts) {
            Rectangle fig = part.getFigure().getBounds();
            contour.add(fig.getCenter());
        }

        return contour;
    }

    @objid ("d93264dc-361d-4630-a2f0-cf232536d74c")
    public static Point getAbsDelta(ElkConnectableShape node, IDiagramNode diagramDg) {
        ElkNode owner = null;
        Point delta = new Point();

        if (node instanceof ElkNode)
            owner = ((ElkNode) node).getParent();

        if (node instanceof ElkPort)
            owner = ((ElkPort) node).getParent();

        while (owner != null) {

            delta.x += owner.getX();
            delta.y += (int) owner.getY();

            owner = owner.getParent();
        }

        return delta;
    }

    @objid ("af31b2e1-5824-4dfa-b13d-11f15fd0a653")
    public static <T> List<T> createListFromIterator(Iterator<T> iterator) {
        List<T> list = new ArrayList<>();
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        return list;
    }

    @objid ("1f51a7a7-7912-4c17-aabb-10e66e2b42f5")
    public static IDiagramNode findLowestCommonOwner(List<IDiagramLink> links) {
        List<IDiagramNode> nodes = new ArrayList<>();

        for (IDiagramLink link : links) {
            IDiagramNode source = (IDiagramNode) link.getTo();
            IDiagramNode target = (IDiagramNode) link.getFrom();

            nodes.add(source);
            nodes.add(target);

        }

        return findLowestCommonAncestor(nodes);
    }

    @objid ("2d6c1a48-f727-46b1-bcd1-20fad14e5926")
    public static IDiagramNode findLowestCommonAncestor(List<IDiagramNode> nodes) {
        if (nodes.isEmpty()) {
            return null;
        } else if (nodes.size() == 1) {
            return nodes.get(0);
        }

        IDiagramNode lowestCommonAncestor = nodes.get(0);

        for (int i = 1; i < nodes.size(); i++) {
            lowestCommonAncestor = findLowestCommonAncestor(lowestCommonAncestor, nodes.get(i));
        }

        return lowestCommonAncestor;
    }

    /**
     * Returns the lowest common ancestor of the given two nodes. If the two nodes
     * are not part of the same graph (that is, their root nodes differ), there is
     * no common ancestor.
     *
     * @param node1 the first node.
     * @param node2 the second node.
     * @return the lowest common ancestor or {@code null} if there is none.
     */
    @objid ("a3638938-98a1-40a0-b0b6-5a1d080a79f3")
    public static IDiagramNode findLowestCommonAncestor(final IDiagramNode node1, final IDiagramNode node2) {
        // Retrieve iterators over the node ancestors
        List<IDiagramNode> ancestors1 = createListFromIterator(new AncestorIterator(node1, true));
        ListIterator<IDiagramNode> iterator1 = ancestors1.listIterator(ancestors1.size());

        List<IDiagramNode> ancestors2 = createListFromIterator(new AncestorIterator(node2, true));
        ListIterator<IDiagramNode> iterator2 = ancestors2.listIterator(ancestors2.size());

        // Traverse the ancestor hierarchies from the end as longs as the elements we
        // find are the same
        IDiagramNode commonAncestor = null;

        while (iterator1.hasPrevious() && iterator2.hasPrevious()) {
            IDiagramNode ancestor1 = iterator1.previous();
            IDiagramNode ancestor2 = iterator2.previous();

            if (ancestor1.getElement() == ancestor2.getElement()) {
                commonAncestor = ancestor1;
            } else {
                // The ancestral lines differ; no need to continue
                break;
            }
        }

        return commonAncestor;
    }

    @objid ("3e0dcb16-895b-436c-b712-0f9b1c94eed1")
    private static Point getAbsDelta(ElkEdge line) {
        ElkNode owner = line.getContainingNode();
        Point delta = new Point();

        while (owner != null) {

            delta.x += owner.getX();
            delta.y += (int) owner.getY();

            owner = owner.getParent();
        }

        return delta;
    }

    @objid ("116bb700-2fd1-4f92-a641-02457e966262")
    public static Point getAbsPoint(ElkEdge line, Point point) {
        Point delta = getAbsDelta(line);
        Point result = new Point(point);

        return result.getTranslated(delta);
    }

    @objid ("d35772fa-cdf2-4af5-8e95-eddd10a9c0ce")
    public static void updateLinkPath(List<ElkEdge> lines, ILinkPath path, Point translation) {
        List<Point> newPath = new ArrayList<Point>();

        if (lines.size() == 1) {
            ElkEdge line = lines.get(0);
            if (line.getSections().isEmpty()) {
                Point soucePoint = new Point((int) line.getSources().get(0).getX(), (int) line.getSources().get(0).getY());
                newPath.add(ElkModelUtils.getAbsPoint(line, soucePoint, translation));

                Point targetPoint = new Point((int) line.getTargets().get(0).getX(), (int) line.getTargets().get(0).getY());
                newPath.add(ElkModelUtils.getAbsPoint(line, targetPoint, translation));

            } else {
                Iterator<ElkEdgeSection> iterator = line.getSections().iterator();
                ElkEdgeSection section = null;

                while (iterator.hasNext()) {
                    section = iterator.next();

                    Point tmpPoint = new Point((int) section.getStartX(), (int) section.getStartY());
                    newPath.add(ElkModelUtils.getAbsPoint(line, tmpPoint, translation));

                    for (ElkBendPoint bendpoint : section.getBendPoints()) {
                        Point bendPoint = new Point((int) bendpoint.getX(), (int) bendpoint.getY());
                        newPath.add(ElkModelUtils.getAbsPoint(line, bendPoint, translation));
                    }
                }

                // Last Point
                if (section != null) {
                    double endX = section.getEndX();
                    double endY = section.getEndY();
                    Point endPoint = new Point((int) endX, (int) endY);
                    newPath.add(ElkModelUtils.getAbsPoint(line, endPoint, translation));
                }
            }

        } else {
            ElkEdge firstLine = lines.get(0);
            if (firstLine.getSections().isEmpty()) {
                Point soucePoint = new Point((int) firstLine.getSources().get(0).getX(), (int) firstLine.getSources().get(0).getY());
                newPath.add(ElkModelUtils.getAbsPoint(firstLine, soucePoint, translation));
            } else {
                firstLine.getSections().stream().findFirst().ifPresent(section -> {
                    Point tmpPoint = new Point((int) section.getStartX(), (int) section.getStartY());
                    newPath.add(ElkModelUtils.getAbsPoint(firstLine, tmpPoint, translation));
                });
            }

            ElkEdge lastLine = lines.get(lines.size() - 1);
            if (lastLine.getSections().isEmpty()) {
                Point targetPoint = new Point((int) lastLine.getTargets().get(0).getX(), (int) lastLine.getTargets().get(0).getY());
                newPath.add(ElkModelUtils.getAbsPoint(lastLine, targetPoint, translation));
            } else {
                firstLine.getSections().stream().reduce((first, second) -> second).ifPresent(section -> {
                    Point endPoint = new Point((int) section.getEndX(), (int) section.getEndY());
                    newPath.add(ElkModelUtils.getAbsPoint(lastLine, endPoint, translation));
                });
            }

        }

        path.setPoints(newPath);
    }

    @objid ("e61c54d0-5870-4f88-b01d-2e5dab702b7a")
    public static Point getAbsPoint(ElkEdge line, Point point, Point translate) {
        Point delta = getAbsDelta(line);
        Point result = new Point(point);

        return result.getTranslated(delta).getTranslated(translate);
    }

    @objid ("403b24bc-c52f-486d-8fff-9fe8e3a625d1")
    public static void dumpElkModel(ElkNode graph) {
        System.out.println("ElkNode: " + graph.getIdentifier() + " x=" + graph.getX() + " y=" + graph.getY() + " w=" + graph.getWidth() + " h=" + graph.getHeight());

        graph.getContainedEdges().forEach(edge -> {
            System.out.println("Contained Edge: " + edge.getIdentifier() + " source=" + edge.getSources().get(0).getIdentifier() + " target=" + edge.getTargets().get(0).getIdentifier());
        });

        for (ElkPort port : graph.getPorts()) {
            System.out.println("ElkPort: " + port.getIdentifier() + " x=" + port.getX() + " y=" + port.getY() + " w=" + port.getWidth() + " h=" + port.getHeight());

            for (ElkEdge edge : port.getOutgoingEdges()) {
                System.out.println("ElkEdge: " + edge.getIdentifier() + " source=" + edge.getSources().get(0).getIdentifier() + " target=" + edge.getTargets().get(0).getIdentifier());
            }
        }

        for (ElkNode child : graph.getChildren()) {
            dumpElkModel(child);
        }

        for (ElkEdge edge : graph.getOutgoingEdges()) {
            System.out.println("ElkEdge: " + edge.getIdentifier() + " source=" + edge.getSources().get(0).getIdentifier() + " target=" + edge.getTargets().get(0).getIdentifier());
        }
    }

    @objid ("75cec99d-c678-4724-bf28-7859e3973b61")
    private static class AncestorIterator implements Iterator<IDiagramNode> {
        /**
         * The next node we will return.
         */
        @objid ("91bdd353-db71-46ab-a538-0d5267351048")
        private IDiagramNode nextNode;

        /**
         * Creates a new iterator.
         *
         * @param startNode the node whose ancestors we want to travel along.
         * @param includeNode {@code true} if {@code startNode} should be the first
         * thing we return, {@code false} if its parent should be the
         * first thing.
         */
        @objid ("8253a4cf-5fce-43c4-adac-a3ac5612bddf")
        AncestorIterator(final IDiagramNode startNode, final boolean includeNode) {
            nextNode = includeNode ? startNode : (IDiagramNode) startNode.getParent();
        }

        /*
         * (non-Javadoc)
         *
         * @see java.util.Iterator#hasNext()
         */
        @objid ("7dea322b-1fa6-459f-bc64-5b0cf43e7814")
        @Override
        public boolean hasNext() {
            return nextNode != null;
        }

        /*
         * (non-Javadoc)
         *
         * @see java.util.Iterator#next()
         */
        @objid ("184c6869-38fb-457c-87cc-203d56bc37e6")
        @Override
        public IDiagramNode next() {
            if (nextNode == null) {
                throw new NoSuchElementException("There is no more element.");
            }
            IDiagramNode next = nextNode;
            nextNode = (IDiagramNode) nextNode.getParent();
            return next;
        }

    }

}

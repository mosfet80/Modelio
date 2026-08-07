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
package org.modelio.archimate.diagrams.elements.common.figures;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.draw2d.FlowLayout;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Path;
import org.eclipse.swt.widgets.Display;
import org.modelio.diagram.elements.core.figures.IShaper;
import org.modelio.diagram.elements.core.figures.ShapedFigure;
import org.modelio.diagram.elements.core.figures.ToolbarLayoutWithGrab;
import org.modelio.diagram.elements.core.figures.borders.ShapedBorder;
import org.modelio.diagram.styles.core.StyleKey.LinePattern;

@objid ("33bf185f-4dc4-4f77-bde3-735d36c7a52a")
public class BeveledRectangleFigure extends ShapedFigure {
    @objid ("bdd70963-9af3-4e6f-996e-5c10fcac3a33")
    private ShapedBorder shapedBorder;

    /**
     * Default c'tor building an opaque figure using a {@link ToolbarLayoutWithGrab}.
     */
    @objid ("a75d270f-550a-404a-b95c-f812f13ac91c")
    public BeveledRectangleFigure() {
        super(new BeveledRectangleShaper());

        this.setLayoutManager(new FlowLayout());

        setSize(30, 40);
        this.setOpaque(true);
        this.shapedBorder = new ShapedBorder(this.penOptions.lineColor, this.penOptions.lineWidth, this.shaper);
        this.shapedBorder.setStyle(this.penOptions.linePattern.toSWTConstant());
        setBorder(this.shapedBorder);

    }

    @objid ("404f49b4-5315-40bd-8b0b-d6943cd0cea9")
    @Override
    public void setLineColor(Color lineColor) {
        if (lineColor != this.penOptions.lineColor) {
            super.setLineColor(lineColor);
            this.shapedBorder.setColor(lineColor);
        }

    }

    @objid ("8c27c4d8-bb9b-4b87-a9d1-d763212c376c")
    @Override
    public void setLinePattern(LinePattern lineStyle) {
        if (lineStyle != this.penOptions.linePattern) {
            super.setLinePattern(lineStyle);
            this.shapedBorder.setStyle(lineStyle.toSWTConstant());
        }

    }

    @objid ("9d40068c-e5c8-4dac-b974-1d685fc410f5")
    @Override
    public void setLineWidth(int lineWidth) {
        if (lineWidth != this.penOptions.lineWidth) {
            super.setLineWidth(lineWidth);
            this.shapedBorder.setWidth(lineWidth);
        }

    }

    @objid ("7279f5bc-357b-4ba5-9660-126139780c95")
    private static class BeveledRectangleShaper implements IShaper {
        @objid ("ea039710-b331-4252-b098-6e1b6b9782a4")
        private static final float CUT_DEFAULT_RATIO = 0.12f;

        @objid ("055798ac-7876-45bb-8126-bd442331dae9")
        private static final int DEFAULT_CUT = 10;

        @objid ("b37179d5-58ed-4cfa-be46-3f49999be5c9")
        private boolean isFixedBevel = true;

        @objid ("876ed135-0d5f-47a5-9830-3cd7c36a68b9")
        private float bevelCutRatio = CUT_DEFAULT_RATIO;

        @objid ("b8e7065f-cefa-4374-a888-7e205a206600")
        private int bevelFixedCut = DEFAULT_CUT;

        @objid ("7ec9957d-92e1-4a5a-b08f-bdf4f2d685a7")
        public BeveledRectangleShaper(boolean fixedBevel) {
            this.isFixedBevel = fixedBevel;
        }

        @objid ("91a2125d-52de-4dcf-b501-b74c719fc31a")
        public BeveledRectangleShaper() {
            this(true);
        }

        @objid ("44d154c1-0f1a-4efd-9015-8a3cca273fde")
        @Override
        public Path createShapePath(Rectangle rect) {
            int cut = getCut(rect);

            int x = rect.x;
            int y = rect.y;
            int w = rect.width;
            int h = rect.height;

            Path path = new Path(Display.getCurrent());
            path.moveTo(x + cut, y);
            path.lineTo(x + w - cut, y);
            path.lineTo(x + w, y + cut);
            path.lineTo(x + w, y + h - cut);
            path.lineTo(x + w - cut, y + h);
            path.lineTo(x + cut, y + h);
            path.lineTo(x, y + h - cut);
            path.lineTo(x, y + cut);
            path.lineTo(x + cut, y);
            return path;
        }

        @objid ("3c76ead6-6a20-4c24-9309-42b5ff913776")
        @Override
        public Insets getShapeInsets(Rectangle rect) {
            int offset = (getCut(rect) / 2);
            return new Insets(offset, offset, offset, offset);
        }

        @objid ("802a428d-846d-4c64-8810-79769194682d")
        private int getCut(Rectangle rect) {
            if (this.isFixedBevel) {
                return Math.min(this.bevelFixedCut, Math.min(rect.width, rect.height) / 3);
            } else {
                return (int) (Math.min(rect.width, rect.height) * this.bevelCutRatio);
            }

        }

    }

}

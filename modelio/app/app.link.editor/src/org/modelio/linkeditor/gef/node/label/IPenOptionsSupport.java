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
/*
 * Copyright 2013-2024 Docaposte
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
package org.modelio.linkeditor.gef.node.label;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Shape;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;

/**
 * A figure implements this interface to indicate that it is using a pen defined by: <li>a line drawing Color <li>a line
 * thickness<li>a text color<li>a text font</li>
 */
@objid ("f9c1e0c3-d78e-4a33-bf9c-d51caf30c9d9")
public interface IPenOptionsSupport {
    /**
     * Set the line(s) color.
     *
     * @param lineColor the line color.
     */
    @objid ("fd2ea0e3-a751-4340-93cb-c25b9a862b03")
    void setLineColor(Color lineColor);

    /**
     * Set the line(s) width.
     *
     * @param lineWidth the line(s) width.
     */
    @objid ("44e4f10c-1d69-4ec8-a100-f2e308ac448a")
    void setLineWidth(int lineWidth);

    /**
     * Get the line color.
     *
     * @return the line color.
     */
    @objid ("d05aa918-3339-4480-b8ec-50f5ddebe2c7")
    Color getLineColor();

    /**
     * Get the line width.
     *
     * @return the line width.
     */
    @objid ("e057b2b5-7ab6-4d1e-8fa7-a5bde897d709")
    int getLineWidth();

    /**
     * Set the text color.
     *
     * @param textColor the text color.
     */
    @objid ("4eb47536-5c2c-49d7-bc01-db64fb364eb2")
    void setTextColor(Color textColor);

    /**
     * Set the text font.
     *
     * @param textFont the text font.
     */
    @objid ("19e54db9-fb16-4860-b4f8-40530d4e17fa")
    void setTextFont(Font textFont);

    /**
     * Get the text color.
     *
     * @return the text color.
     */
    @objid ("ee2b522d-7c46-4939-9c14-355a212ef909")
    Color getTextColor();

    /**
     * Get the text font.
     *
     * @return the text font.
     */
    @objid ("df892c17-a68f-4777-a493-a4a325d7e684")
    Font getTextFont();

    /**
     * Make small effort to adapt any IFigure to IPenOptionsSupport.
     *
     * @param fig a IFigure
     * @return the figure if it implements IPenOptionsSupport, or an adapter.
     */
    @objid ("d24845bf-1415-4beb-b865-1783ba1f681f")
    static IPenOptionsSupport adapt(IFigure fig) {
        if (fig instanceof IPenOptionsSupport)
            return (IPenOptionsSupport) fig;
        if (fig instanceof org.eclipse.draw2d.Shape)
            return new ShapeAdapter<>((Shape) fig);
        return new FigureAdapter<>(fig);
    }

    /**
     * Best effort adapter for IFigure that don't implement IPenOptionsSupport.
     *
     * @param <T> the figure class
     */
    @objid ("de5cebb3-9e00-4d71-ae0f-e45e748138ca")
    static class FigureAdapter<T extends IFigure> implements IPenOptionsSupport {
        @objid ("9f4f0510-e1de-4ac6-a130-76ed9a39b6e4")
        protected final T fig;

        @objid ("d925fd71-a769-42de-9689-e37d69132f62")
        private FigureAdapter(T fig) {
            this.fig = fig;
        }

        @objid ("7eab345e-1b14-4736-8791-be405497f822")
        @Override
        public void setTextFont(Font textFont) {
            this.fig.setFont(textFont);
        }

        @objid ("75ef9534-8c12-485e-99be-c346eef809cd")
        @Override
        public void setTextColor(Color textColor) {
            this.fig.setForegroundColor(textColor);
        }

        @objid ("765d5540-2b70-4909-826f-70bbfe43d693")
        @Override
        public void setLineWidth(int lineWidth) {
            // ignore
        }

        @objid ("dfb33452-1de7-4a3e-a94f-855b49bb8b76")
        @Override
        public void setLineColor(Color lineColor) {
            this.fig.setForegroundColor(lineColor);
        }

        @objid ("d20d3d7b-747e-4dff-8f9e-e2253c06ea93")
        @Override
        public Font getTextFont() {
            return this.fig.getFont();
        }

        @objid ("2a9f14e7-fa98-4df6-b8c9-a2af2cb5c388")
        @Override
        public Color getTextColor() {
            return this.fig.getForegroundColor();
        }

        @objid ("7a664891-ef17-426a-bc4d-16a9f44af1ff")
        @Override
        public int getLineWidth() {
            return 1;
        }

        @objid ("4a78e99c-e01d-4492-a388-849b5013148e")
        @Override
        public Color getLineColor() {
            return this.fig.getForegroundColor();
        }

    }

    /**
     * Best effort adapter for {@link Shape} that don't implement {@link IPenOptionsSupport}.
     *
     * @param <T> the figure class
     */
    @objid ("96820153-82ac-4b59-9aab-21fe62ad071c")
    static class ShapeAdapter<T extends Shape> extends FigureAdapter<T> {
        @objid ("33096c38-f98d-4cfc-a6a0-6777b6447795")
        public ShapeAdapter(T fig) {
            super(fig);
        }

        @objid ("abde0baf-3c7f-4e6f-b502-c4f6dea6e6c9")
        @Override
        public void setLineWidth(int lineWidth) {
            this.fig.setLineWidth(lineWidth);
        }

        @objid ("7189a5de-4672-4467-aae0-182193498874")
        @Override
        public int getLineWidth() {
            return this.fig.getLineWidth();
        }

    }

}

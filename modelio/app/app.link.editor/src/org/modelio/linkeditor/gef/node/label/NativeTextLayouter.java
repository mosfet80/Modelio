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
package org.modelio.linkeditor.gef.node.label;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.draw2d.TextUtilities;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.graphics.TextLayout;

/**
 * Text layouter that breaks lines at word boundaries if possible, else at any character.
 * <p>
 * Can also append a symbol at the end of each lines.
 * <p>
 * This implementation uses native wrapping capabilities of {@link TextLayout}
 */
@objid ("17183bd5-f48d-4e3e-9b4b-d531f80ea94c")
public class NativeTextLayouter implements ILabelumTextLayouter {
    @objid ("dae7f4b1-3394-40d4-abfa-a1d5ea797caf")
    public static final String CR_END_SYMB1 = "\uE684";

    @objid ("a27e9cc7-8fba-4b2a-b731-33832a580fdb")
    public static final String CR_END_SYMB2 = "\u23CE";

    @objid ("73093e5a-545f-40ac-ab7c-c39b6f8d9c3a")
    private String lineEndSymbol;

    /**
     * The instance
     */
    @objid ("997ce91f-e3b3-43c3-9a9c-49656a739dce")
    public static final NativeTextLayouter INSTANCE = new NativeTextLayouter();

    @objid ("ba7dd661-e7c1-4349-afff-e3a4578f407f")
    public NativeTextLayouter() {
        this("");
    }

    /**
     * Initialize the word breaking line layouter .
     *
     * @param lineEndSymbol the symbol to add at end of broken lines.
     * See {@value #CR_END_SYMB1} or {@value #CR_END_SYMB2}.
     */
    @objid ("344a0b8e-d061-4b07-b142-5b0bf5cf3ee1")
    public NativeTextLayouter(String lineEndSymbol) {
        this.lineEndSymbol = lineEndSymbol;
    }

    @objid ("a3e6437c-6832-495c-9a71-33ae83b15aba")
    @Override
    public String formatText(LabelumFigure labelumFigure, String origText, Dimension maxSize) {
        final TextUtilities textUtilities = labelumFigure.getTextUtilities();

        // Remplace tous les espaces simples par une combinaision d'espace sécable, insécable et sécable
        origText = origText.replace(" ", "\u200B" + "\u00A0"+"\u200B");

        String lineBreakSymbol = getLineEndSymbol();
        int lineBreakWidth = textUtilities.getTextExtents(
                lineBreakSymbol, labelumFigure.getFont()).width;

        String truncSymbol = getTruncationString();
        int truncationWidth = textUtilities.getTextExtents(
                truncSymbol, labelumFigure.getFont()).width;

        int allowedWidth;
        if (maxSize.width > 0) {
            allowedWidth = Math.max(maxSize.width - lineBreakWidth, truncationWidth);
        } else {
            allowedWidth = -1;
        }

        final TextLayout textLayout = labelumFigure.getTextDrawer( origText, allowedWidth);
        StringBuilder sb = new StringBuilder();


        Rectangle lineBounds;
        int[] offsets = textLayout.getLineOffsets();
        for (int i=0; i< offsets.length-1; i++) {
            final boolean isNextLine = i < offsets.length-2;

            lineBounds = textLayout.getLineBounds(i);

            if (sb.length() > 0
                    && (isNextLine || lineBounds.width > lineBreakWidth)
                    && sb.charAt(sb.length()-1) != '\n') {
                // Append line break unless it is the last line and last line size is
                // thinner than line break symbol
                sb.append(lineBreakSymbol);
                sb.append("\n");
            }

            sb.append(origText, offsets[i], offsets[i+1]);

            if ( isNextLine) {
                // There is a next line
                Rectangle nextLineBounds = textLayout.getLineBounds(i+1) ;
                int lineBottom = nextLineBounds.y + nextLineBounds.height;
                if (maxSize.height > -1 && lineBottom > maxSize.height) {
                    // no vertical space left :
                    // put truncation string at the end of last displayed line and stop

                    String lastLine = origText.substring(offsets[i], offsets[i+1]);
                    int len = textUtilities.getLargestSubstringConfinedTo(
                            lastLine, labelumFigure.getFont(), maxSize.width - truncationWidth);
                    sb.replace(offsets[i] + len, sb.length(), truncSymbol);

                    return sb.toString();
                }
            }
        }
        return sb.toString();
    }

    /**
     * get the symbol that will be added as line wrapping symbol.
     *
     * @return the line wrap symbol.
     */
    @objid ("1ce35d93-24a1-4ca0-a7e7-95986090fd69")
    public String getLineEndSymbol() {
        return this.lineEndSymbol;
    }

    @objid ("709db132-ec15-44a6-b732-a1f69bd21ac9")
    private String getTruncationString() {
        return "...";
    }

}

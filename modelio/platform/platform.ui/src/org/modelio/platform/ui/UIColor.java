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
package org.modelio.platform.ui;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;

/**
 * The UIColor values are pre-allocated resources for Modelio that can be used without having to deal with their lifecycle (they are available once Modelio starts and only freed when Modelio stops).<br/>
 * There are three categories of UIColor pre-allocated colors
 * <ul>
 * <li><b>'swt' colors</b>: they are the colors defined by the SWT constants.<br/>
 * The main benefit of using these colors is that several of them are based on the OS/platform theme (where applicable). For this reason these values should always be the first choice. The 'swt'colors are named 'SWT_XXXXX' in UIColor.</li>
 * <li><b>'functional-colors'</b>: named from their intended context and usage specific in Modelio.<br/>
 * The 'functional-colors' name has the form: XXX_YYY_ZZ where:
 * <ul>
 * <li>XXX stands for the SWT widget or category of widget the color applies to.
 * <li>YYY stands for the functional context of the color
 * <li>ZZ is either BG for background, FG for foreground
 * </ul>
 * Example: TEXT_WRITABLE_BG => background color of a writable SWT Text widget</li>
 * <li><b>'color-named' colors</b>: named from the color they represent, for example BLACK, WHITE and so on. The proposed values and names are those from the CGA 16 colors standard palette, plus the ORANGE.
 * </ul>
 * <b>Modelio developers should use these colors in the priority order of their categories, ie 'swt colors' first, then 'functional colors' and lastly 'named colors'.</b>
 */
@objid ("8d550e35-c068-11e1-8c0a-002564c97630")
public interface UIColor {
    @objid ("b25d9456-8b85-4e1c-8c8e-78cddd572937")
    public static final Color BLACK = new Color(Display.getCurrent(), 0x00, 0x00, 0x00);

    @objid ("bc18404a-4f95-482e-a58c-01a7b536d7dd")
    public static final Color BLUE = new Color(Display.getCurrent(), 0x00, 0x00, 0xAA);

    @objid ("164723cc-1aec-4af6-8d2e-6fe1fe218e24")
    public static final Color BROWN = new Color(Display.getCurrent(), 0xAA, 0x55, 0x00);

    @objid ("3caa717f-a0f0-468b-b689-c0f181e25562")
    public static final Color CYAN = new Color(Display.getCurrent(), 0x00, 0xAA, 0xAA);

    @objid ("5fb00956-16bb-4584-961a-fbffbafeece0")
    public static final Color GRAY = new Color(Display.getCurrent(), 0x55, 0x55, 0x55);

    @objid ("a3606b0c-2898-40a4-aef2-5af33450d884")
    public static final Color GREEN = new Color(Display.getCurrent(), 0x00, 0XAA, 0x00);

    @objid ("c78f2f59-432e-46dd-8f36-b873a1a0a64b")
    public static final Color LIGHTBLUE = new Color(Display.getCurrent(), 0x55, 0x55, 0xFF);

    @objid ("855e2489-dcaf-461d-acfe-f1009733d484")
    public static final Color LIGHTCYAN = new Color(Display.getCurrent(), 0x55, 0xFF, 0xFF);

    @objid ("08c1a559-d532-4ca4-888d-c1f6dda6714f")
    public static final Color LIGHTGRAY = new Color(Display.getCurrent(), 0xAA, 0xAA, 0xAA);

    @objid ("5b422d6c-8cb7-4e17-9b4c-7f3a8f80afcf")
    public static final Color LIGHTGREEN = new Color(Display.getCurrent(), 0x55, 0xFF, 0x55);

    @objid ("221c0cae-43eb-4265-8312-5791763e9e0e")
    public static final Color LIGHTMAGENTA = new Color(Display.getCurrent(), 0xFF, 0x55, 0xFF);

    @objid ("294ece14-12fb-4cc9-8b25-aed05446b582")
    public static final Color LIGHTRED = new Color(Display.getCurrent(), 0xFF, 0x55, 0x55, 100);

    @objid ("40d1389f-72ef-4465-b371-f1d20576f752")
    public static final Color MAGENTA = new Color(Display.getCurrent(), 0xAA, 0x00, 0xAA);

    @objid ("8de989bf-281c-4f24-8254-66b4edc66c20")
    public static final Color ORANGE = new Color(Display.getCurrent(), 0xFF, 0xC4, 0x00);

    @objid ("9b24cd7e-60b8-45b6-94c5-2996f366ea2b")
    public static final Color POSTIT_YELLOW = new Color(Display.getCurrent(), 255, 255, 210);

    @objid ("964feedc-c3ca-4db9-bbcb-d52801e99fcd")
    public static final Color RED = new Color(Display.getCurrent(), 0xAA, 0x00, 0x00);

    @objid ("e85726e3-a0cd-484f-8f3e-b511b4db5a15")
    public static final Color WHITE = new Color(Display.getCurrent(), 0xFF, 0xFF, 0xFF);

    @objid ("bb863f18-92e3-4380-8fa9-ee031d3fa25d")
    public static final Color YELLOW = new Color(Display.getCurrent(), 0xFF, 0xFF, 0x55);

    @objid ("b8273c5c-affa-4c25-9716-405d67b1c9e2")
    public static final Color SWT_INFO_BACKGROUND = Display.getCurrent().getSystemColor(SWT.COLOR_INFO_BACKGROUND);

    @objid ("20268e61-80e4-40a1-a490-08cd503549dc")
    public static final Color SWT_INFO_FOREGROUND = Display.getCurrent().getSystemColor(SWT.COLOR_INFO_FOREGROUND);

    @objid ("44935d5b-5665-4bce-9447-3282ca761a24")
    public static final Color SWT_LINK_FOREGROUND = Display.getCurrent().getSystemColor(SWT.COLOR_LINK_FOREGROUND);

    @objid ("9fc632d7-11ea-4ef5-93fe-dd12ec4f48dc")
    public static final Color SWT_LIST_BACKGROUND = Display.getCurrent().getSystemColor(SWT.COLOR_LIST_BACKGROUND);

    @objid ("3b6e9b70-a971-47e6-939b-ba8e9517791c")
    public static final Color SWT_LIST_FOREGROUND = Display.getCurrent().getSystemColor(SWT.COLOR_LIST_FOREGROUND);

    @objid ("a9934397-d632-44ef-8bf8-6c21c159f461")
    public static final Color SWT_LIST_SELECTION = Display.getCurrent().getSystemColor(SWT.COLOR_LIST_SELECTION);

    @objid ("dd622e20-948c-448b-b922-6028a28ae633")
    public static final Color SWT_LIST_SELECTION_TEXT = Display.getCurrent().getSystemColor(SWT.COLOR_LIST_SELECTION_TEXT);

    @objid ("f5bd342b-ee95-423c-9a8e-18fb497b031f")
    public static final Color SWT_TITLE_BACKGROUND = Display.getCurrent().getSystemColor(SWT.COLOR_TITLE_BACKGROUND);

    @objid ("bdb5bb7c-8666-40da-ab98-97e678a70eb3")
    public static final Color SWT_TITLE_BACKGROUND_GRADIENT = Display.getCurrent().getSystemColor(SWT.COLOR_TITLE_BACKGROUND_GRADIENT);

    @objid ("4af19b42-2f39-4989-9e7d-d90ae4d7a32b")
    public static final Color SWT_TITLE_FOREGROUND = Display.getCurrent().getSystemColor(SWT.COLOR_TITLE_FOREGROUND);

    @objid ("c24d1aaf-4ab4-43ba-93f8-99acc5874c76")
    public static final Color SWT_TITLE_INACTIVE_BACKGROUND = Display.getCurrent().getSystemColor(SWT.COLOR_TITLE_INACTIVE_BACKGROUND);

    @objid ("c68a38f7-7bf5-4e04-b591-4f2974851cba")
    public static final Color SWT_TITLE_INACTIVE_BACKGROUND_GRADIENT = Display.getCurrent().getSystemColor(SWT.COLOR_TITLE_INACTIVE_BACKGROUND_GRADIENT);

    @objid ("cd1a501d-9b78-48e5-842b-4b13b80ff752")
    public static final Color SWT_TITLE_INACTIVE_FOREGROUND = Display.getCurrent().getSystemColor(SWT.COLOR_TITLE_INACTIVE_FOREGROUND);

    @objid ("cacc370e-21ea-475f-af0b-24971f7d820f")
    public static final Color SWT_TRANSPARENT = Display.getCurrent().getSystemColor(SWT.COLOR_TRANSPARENT);

    @objid ("34c5e714-afd1-4460-8290-5be6ffdd57df")
    public static final Color SWT_WIDGET_BACKGROUND = Display.getCurrent().getSystemColor(SWT.COLOR_WIDGET_BACKGROUND);

    @objid ("938d6d65-564c-419f-8633-48bfedb3e54b")
    public static final Color SWT_WIDGET_BORDER = Display.getCurrent().getSystemColor(SWT.COLOR_WIDGET_BORDER);

    @objid ("2f9e4fb2-58f4-4fd4-9f9e-d26aff8208dd")
    public static final Color SWT_WIDGET_DARK_SHADOW = Display.getCurrent().getSystemColor(SWT.COLOR_WIDGET_DARK_SHADOW);

    @objid ("33f93d13-d607-42b5-aa81-8b74b3b20a94")
    public static final Color SWT_WIDGET_FOREGROUND = Display.getCurrent().getSystemColor(SWT.COLOR_WIDGET_FOREGROUND);

    @objid ("4847caa5-e4a9-4d71-aea9-d8af30e26606")
    public static final Color SWT_WIDGET_HIGHLIGHT_SHADOW = Display.getCurrent().getSystemColor(SWT.COLOR_WIDGET_HIGHLIGHT_SHADOW);

    @objid ("86b1a9ff-375c-4c51-93e9-966e692ba6a1")
    public static final Color SWT_WIDGET_LIGHT_SHADOW = Display.getCurrent().getSystemColor(SWT.COLOR_WIDGET_LIGHT_SHADOW);

    @objid ("d9e78aa9-db1c-4815-9562-bc3f117a7f48")
    public static final Color SWT_WIDGET_NORMAL_SHADOW = Display.getCurrent().getSystemColor(SWT.COLOR_WIDGET_NORMAL_SHADOW);

    @objid ("c648078c-a5ea-45a3-9732-ba150a63c5e8")
    public static final Color EDITOR_COMMENT_FG = new Color(Display.getCurrent(), 0, 128, 0);

    @objid ("5ad4752a-5b54-496a-866a-8f12b597637a")
    public static final Color EDITOR_KEYWORD_FG = new Color(Display.getCurrent(), 120, 0, 164);

    @objid ("5e595ee5-bd08-48e9-a135-6d6dae17f307")
    public static final Color EDITOR_MDDTAG_FG = new Color(Display.getCurrent(), 160, 160, 160);

    /**
     * Code Editor highlighting colors. Should not be used for SWT widgets...
     */
    @objid ("9cf49977-f9b3-4a7e-a2d4-6dcd25225132")
    public static final Color EDITOR_ROTEXT_FG = new Color(Display.getCurrent(), 0, 0, 0);

    @objid ("2cf43b1e-b181-4afe-a1dc-a6b1ec37d65f")
    public static final Color EDITOR_RWTEXT_FG = new Color(Display.getCurrent(), 0, 0, 160);

    /**
     * Hyperlink color.
     */
    @objid ("efc6c020-25ed-4bd2-b495-182b2577814c")
    public static final Color HYPERLINK_FG = new Color(Display.getCurrent(), 0, 0, 128);

    /**
     * Label
     */
    @objid ("6c78f998-13b2-4829-b788-5470d49bea08")
    public static final Color LABEL_TIP_FG = new Color(Display.getCurrent(), 113, 111, 100);

    /**
     * Model elements whose metaclass is currently disabled by the metamodel mask, font color is light blue #C0C0FF.
     */
    @objid ("7cfc456a-5736-477c-8e9c-b2b0b2a531b3")
    public static final Color MASKED_METACLASS_FG = new Color(Display.getCurrent(), 192, 192, 255);

    /**
     * Modifiable model elements font color is black #000000.
     */
    @objid ("bcbd7ce2-7ecd-4ac9-93ad-97bc83fdb135")
    public static final Color MODIFIABLE_ELEMENT_FG = UIColor.BLACK;

    @objid ("5ce57ea5-6101-4308-9bc3-9a35eb9240be")
    public static final Color NONMODIFIABLE_ELEMENT_FG = new Color(Display.getCurrent(), 96, 96, 96);

    /**
     * Ramc model elements font or line color is modified yellow #3d5c99
     */
    @objid ("e031277c-4818-48bc-9de3-aff65aaed801")
    public static final Color RAMC_ELEMENT_FG = new Color(Display.getCurrent(), 61, 92, 153);

    /**
     * Incomplete model elements font color is light red #FF8080.
     */
    @objid ("421d36dd-58cc-4af0-8b96-01e25aee6d40")
    public static final Color SHELL_ELEMENT_FG = new Color(Display.getCurrent(), 255, 128, 128);

    /**
     * Table even/odd row colors
     */
    @objid ("d38704d0-9e2d-4273-8cab-ea597e16f38b")
    public static final Color TABLE_EVENROW_BG = new Color(Display.getCurrent(), 244, 250, 252);

    @objid ("14ef999a-e673-4724-ba16-378d34b58b46")
    public static final Color TABLE_HEADER_BG = new Color(Display.getCurrent(), 220, 220, 220);

    @objid ("a6fc110c-fe9e-452a-bfdf-26ae034a339a")
    public static final Color TABLE_HEADER_FG = new Color(Display.getCurrent(), 64, 64, 64);

    @objid ("d19a2897-8934-40ed-adc0-62f37b2e09e6")
    public static final Color TABLE_ODDROW_BG = new Color(Display.getCurrent(), 255, 255, 255);

    @objid ("ebe00ef4-d1bb-4ca9-ab50-fdca9d17fd60")
    public static final Color TEXT_READONLY_BG = new Color(Display.getCurrent(), 232, 232, 232);

    @objid ("ef3f13a6-a74f-4441-a283-b8cd43d0cecc")
    public static final Color TEXT_READONLY_FG = new Color(Display.getCurrent(), 111, 111, 111);

    /**
     * Text Field colors
     */
    @objid ("83b4eda7-2cad-47da-8db8-917fe2ad5d15")
    public static final Color TEXT_WRITABLE_BG = new Color(Display.getCurrent(), 255, 255, 255);

    @objid ("ddabdc56-88d6-4dbb-aa31-bc30071804c6")
    public static final Color TEXT_WRITABLE_FG = UIColor.BLACK;

    /**
     * Model elements whose metaclass is missing or unknown, font color is light red #FF8080.
     */
    @objid ("e9815961-fde9-46cc-af71-52da4618b030")
    public static final Color UNKNOWN_METACLASS_FG = new Color(Display.getCurrent(), 255, 128, 128);

    @objid ("63b3c79b-6216-4418-b51f-edb4ff4aed79")
    public static final Color COBALT_BACKGROUND = new Color(Display.getCurrent(), 150, 150, 175);

    @objid ("1f93e7a5-94d2-40f5-a5c5-074d30105fec")
    public static final Color COBALT_FOREGROUND = new Color(Display.getCurrent(), 242, 242, 255);

    @objid ("7f8bf76f-4a9a-4973-89c1-9f6426899782")
    public static final Color COBALT_TEXT = new Color(Display.getCurrent(), 0, 0, 140);

}

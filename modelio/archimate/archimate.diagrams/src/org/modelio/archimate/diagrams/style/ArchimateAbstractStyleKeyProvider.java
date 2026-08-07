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
package org.modelio.archimate.diagrams.style;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.plugin.ArchiDiagrams;
import org.modelio.diagram.styles.core.AbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class is an extension of {@link AbstractStyleKeyProvider} managing i18n for StyleKeys in Archimate diagrams.
 * <p>
 * You must use {@link ArchimateAbstractStyleKeyProvider#createStyleKey} to create each StyleKey.
 * </p>
 */
@objid ("f1a91e44-e528-4d1f-ad49-7f6c757edcc0")
public class ArchimateAbstractStyleKeyProvider extends AbstractStyleKeyProvider {
    /**
     * Creates a StyleKey based on a MetaKey.
     *
     * @param key The style key.
     * @param metakey the base meta key.
     * @return a StyleKey with i18n informations filled.
     */
    @objid ("40376590-cf7d-4bb6-83fa-07c3d1988054")
    public static StyleKey createStyleKey(String key, MetaKey metakey) {
        return new StyleKey(key,
                        metakey,
                        metakey.getLabel(),
                        metakey.getTooltip(),
                        ArchiDiagrams.I18N.getMessage(AbstractStyleKeyProvider.STYLEKEY_PREFIX + key + AbstractStyleKeyProvider.CATEGORY_SUFFIX));
    }

    /**
     * Creates a style key.
     *
     * @param key The style key id.
     * @param type The type of the style key.
     * @return a StyleKey with i18n informations filled.
     */
    @objid ("77cd3e85-2611-4008-9499-e6d6151877f6")
    public static StyleKey createStyleKey(String key, Class<?> type) {
        return new StyleKey(key,
                        type,
                        ArchiDiagrams.I18N.getMessage(AbstractStyleKeyProvider.STYLEKEY_PREFIX + key + AbstractStyleKeyProvider.LABEL_SUFFIX),
                        ArchiDiagrams.I18N.getMessage(AbstractStyleKeyProvider.STYLEKEY_PREFIX + key + AbstractStyleKeyProvider.TOOLTIP_SUFFIX),
                        ArchiDiagrams.I18N.getMessage(AbstractStyleKeyProvider.STYLEKEY_PREFIX + key + AbstractStyleKeyProvider.CATEGORY_SUFFIX));
    }

}

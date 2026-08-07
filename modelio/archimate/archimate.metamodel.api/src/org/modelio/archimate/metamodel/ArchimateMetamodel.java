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
package org.modelio.archimate.metamodel;

import java.util.ArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

/**
 * <h2>Metamodel history since&nbsp;ArchiMate 3.0 (Coronado)</h2>
 *
 * <p><strong>Modelio Wyrm (4.0)&nbsp;- 1.0.4&nbsp;</strong><em>(by&nbsp;cma)</em></p><p>+ StrategicBehaviourElement&nbsp;abstract class</p><p>+&nbsp;ApplicationInternalActiveStructureElement abstract class</p><p>+&nbsp;TechnologyActiveStructureElement&nbsp;abstract class</p><p>+&nbsp;TechnologyInternalActiveStructureElement&nbsp;abstract class</p><p>+ ValueStream</p><p>+ Association.IsDirected : boolean</p><p># some inheritance modifications</p><p># updated allowed links</p><p><strong>Modelio Unicorn (3.7)&nbsp;- 1.0.3&nbsp;</strong><em>(by&nbsp;cma)</em></p><p><em>#&nbsp;</em>Influence.strength : type changed from&nbsp;InfluenceStrength to&nbsp;string</p><p><strong>Modelio Toutatis (3.6)&nbsp;- 1.0.2 </strong><em>(by&nbsp;chm)</em></p><p>+ Influence.strength: InfluenceStrength</p><p>+Goal.equivalentRef: string</p><p>+Meaning.equivalentRef: string</p><p>+Requirement.equivalentRef: InfluenceStength</p><p>&nbsp;</p><p><strong>Modelio Toutatis (3.6)&nbsp;- 1.0.1 </strong><em>(by&nbsp;cma)</em></p><p>1st ArchiMate 3.0 metamodel</p>
 */
@objid ("585155b0-caae-4d6a-ae08-da33e31e44c6")
public final class ArchimateMetamodel {
    @objid ("88653570-126c-425d-b161-608342636c92")
    public static String NAME = "Archimate";

    @objid ("5b1f0889-aad7-4d4f-b39e-205090b08bba")
    public static String PROVIDER = "Modeliosoft";

    @objid ("0b2ef5c0-38f9-4c7d-b63d-b094d7365b8e")
    public static String VERSION = "1.0.4";

}

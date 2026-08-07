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
package org.modelio.archimate.exchange.vcommon.importer;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.uml.infrastructure.properties.PropertyType;
import org.modelio.vcore.session.api.model.IModel;

@objid ("1adabdf8-5248-41b3-841e-23f37ac9c3fb")
public class PrimitiveTypeImport {
    @objid ("efd2c7bf-eb26-4dc3-aa30-4c653dde0b89")
    private static final String _textID = "01a40888-0000-002a-0000-000000000000";

    @objid ("03cdbfaa-433a-495a-9a82-bb6ba473f68b")
    private static final String _booleanID = "01a40888-0000-002b-0000-000000000000";

    @objid ("34ad867e-cb99-4256-886a-6327ec4ff465")
    private static final String _dateID = "136b356c-3951-473b-aa4a-001c0241b996";

    @objid ("2c9ae7ef-5a31-49a4-85d3-0d5484468591")
    private static final String _timeID = "753fc9f9-c136-449c-949c-4fa467511d99";

    @objid ("a1a94e18-a020-447f-a778-89fed9ff77a7")
    private static PropertyType _text;

    @objid ("e8a13edc-c37e-4e50-a419-475ad54280f4")
    private static PropertyType _boolean;

    @objid ("4a92ea90-dc96-4d66-97b1-25e5ac2cde43")
    private static PropertyType _date;

    @objid ("a3ce330b-90a4-4c6a-9f2d-66ce6fca2b99")
    private static PropertyType _time;

    @objid ("01b04791-bda5-44b0-b199-22644214dfdd")
    public PrimitiveTypeImport(IModel model) {
        _text = model.findById(PropertyType.class, _textID);
        _boolean = model.findById(PropertyType.class, _booleanID);
        _date = model.findById(PropertyType.class, _dateID);
        _time = model.findById(PropertyType.class, _timeID);

    }

    @objid ("11e42e44-7e0a-4364-bb48-51311a2832d3")
    public PropertyType getType(String type) {
        switch (type) {
        case "Boolean":
            return _boolean;
        case "Date":
            return _date;
        case "Time":
            return _time;
        default:
            return _text;
        }

    }

}

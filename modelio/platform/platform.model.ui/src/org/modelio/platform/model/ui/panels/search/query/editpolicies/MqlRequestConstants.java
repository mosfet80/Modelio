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
package org.modelio.platform.model.ui.panels.search.query.editpolicies;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

/**
 * Custom GEF request types used by the MQL pipeline editor.
 */
@objid ("e382dff5-2380-4fd6-bfb1-aa5a4daa7821")
public final class MqlRequestConstants {
    @objid ("06023fe3-4ac4-43de-b34b-9208902ffe98")
    public static final String REQ_ADD_STEP_AFTER = "mql.addStepAfter";

    @objid ("80164001-2a57-423c-b2c5-522b7d3f2446")
    public static final String REQ_ADD_STEP_END = "mql.addStepEnd";

    @objid ("ccd6026b-6fc1-49ac-a33d-d5ef614b38ec")
    public static final String REQ_UNION_BRANCH_ADD_STEP_END = "mql.union.branch.addStepEnd";

    @objid ("7e540824-eba3-4b1c-8a26-769cf9eb893e")
    public static final String REQ_REPEAT_BODY_ADD_STEP_END = "mql.repeat.body.addStepEnd";

    @objid ("3635c717-1c65-45c1-9882-72cb01e46e5c")
    public static final String REQ_MOVE_LEFT = "mql.moveLeft";

    @objid ("22fc4fd9-09d5-4865-b82e-efaa8798174d")
    public static final String REQ_MOVE_RIGHT = "mql.moveRight";

    @objid ("66aa6af9-2ea4-431c-8305-ed82c7dbc9e4")
    public static final String REQ_UNION_ADD_BRANCH = "mql.union.addBranch";

    @objid ("1e9c551b-24de-4c72-b91e-022b75e3ddac")
    public static final String REQ_UNION_REMOVE_BRANCH = "mql.union.removeBranch";

    @objid ("3ff70e59-efb4-425e-b3df-d7325ead17b3")
    public static final String KEY_STEP_TYPE = "mql.stepType";

    @objid ("cf88caa0-11df-4bb7-8074-d228744d9bfb")
    public static final String KEY_BRANCH_INDEX = "mql.branchIndex";

    @objid ("5831f3ae-7771-415e-b671-f0b860759f10")
    private MqlRequestConstants() {

    }

    @objid ("43e0d918-0a7b-4505-8480-540e6d005f0a")
    public enum StepType {
        @objid ("8bba3cca-a281-41d9-8650-8963fedcedef")
        FILTER,
        @objid ("aa09ec84-ef8f-40c4-9cf0-0e2da02f85ab")
        TRAVERSE,
        @objid ("6a4609b2-da0e-42fb-98ad-43d5481db48f")
        UNION,
        @objid ("888138cc-50c2-45dd-b159-c95c0e14e3db")
        REPEAT;

    }

}

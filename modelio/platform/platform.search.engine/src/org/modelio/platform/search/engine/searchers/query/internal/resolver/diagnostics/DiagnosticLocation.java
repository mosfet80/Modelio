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
package org.modelio.platform.search.engine.searchers.query.internal.resolver.diagnostics;

import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

/**
 * Structured internal diagnostic location.
 * <p>
 * This is rendered into the public {@code Diagnostic.message} prefix.
 */
@objid ("766da0c4-d88f-4133-8a95-af492351cde6")
public record DiagnosticLocation ( int stepIndex,
        List<String> path )  {
    @objid ("901d560d-4f80-4cd0-8faa-db0d3aee0335")
    public DiagnosticLocation {
        if (stepIndex < 0) {
            throw new IllegalArgumentException("stepIndex must be >= 0");
        }
        path = (path == null) ? List.of() : List.copyOf(path);
        for (String segment : path) {
            if (segment == null || segment.isBlank()) {
                throw new IllegalArgumentException("path segments must not be null/blank");
            }
        }
    }

    @objid ("b0b04116-e4b7-426e-bdf3-924dee003961")
    public static DiagnosticLocation step(int stepIndex) {
        return new DiagnosticLocation(stepIndex, List.of());
    }

    @objid ("1560d68c-4d78-430d-b0f3-aec42a74478e")
    public String render() {
        final StringBuilder sb = new StringBuilder();
        sb.append("step[").append(this.stepIndex).append("]");
        for (String segment : this.path) {
            sb.append('/').append(segment);
        }
        return sb.toString();
    }

    @objid ("05bf49d5-d454-483e-8e2f-a9a1dd3fc2d5")
    public DiagnosticLocation child(String segment) {
        if (segment == null || segment.isBlank()) {
            throw new IllegalArgumentException("segment must not be null/blank");
        }
        final List<String> newPath = new ArrayList<>(this.path);
        newPath.add(segment);
        return new DiagnosticLocation(this.stepIndex, newPath);
    }

}

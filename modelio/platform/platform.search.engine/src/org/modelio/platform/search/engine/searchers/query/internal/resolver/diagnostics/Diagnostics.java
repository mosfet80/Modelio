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

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.platform.search.engine.searchers.query.api.model.result.Diagnostic;
import org.modelio.platform.search.engine.searchers.query.api.model.result.Diagnostic.Level;
import org.modelio.platform.search.engine.searchers.query.api.model.result.DiagnosticCode;
import org.modelio.vcore.smkernel.mapi.MObject;

/**
 * Internal helper factory for public {@link Diagnostic} values.
 */
@objid ("aad7d580-71d0-41af-afad-7061832bfafd")
public final class Diagnostics {
    @objid ("501a606e-0bc5-40a2-84a6-b52bf0e1513f")
    private static final int ELEMENTS_CAP = 500;

    @objid ("2213a52b-7bcf-422a-b774-c026f2025ac3")
    private Diagnostics() {

    }

    @objid ("5ae13f93-bdfe-478a-8bb7-5febcb52961d")
    public static Diagnostic info(DiagnosticCode code, String message) {
        return of(code, Level.INFO, null, message, List.of());
    }

    @objid ("9f74ca06-6934-4130-8701-02b9bc642c8a")
    public static Diagnostic info(DiagnosticCode code, String message, List<MObject> elements) {
        return of(code, Level.INFO, null, message, elements);
    }

    @objid ("41e79e1d-db63-4e51-91a7-8ec7e6644cda")
    public static Diagnostic info(DiagnosticCode code, DiagnosticLocation location, String message) {
        return of(code, Level.INFO, location, message, List.of());
    }

    @objid ("a3687425-7227-4b4e-95ea-338bde22d020")
    public static Diagnostic info(DiagnosticCode code, DiagnosticLocation location, String message, List<MObject> elements) {
        return of(code, Level.INFO, location, message, elements);
    }

    @objid ("65e530f3-5215-4c40-a7c3-609cc9714d96")
    public static Diagnostic warning(DiagnosticCode code, String message) {
        return of(code, Level.WARNING, null, message, List.of());
    }

    @objid ("3066be27-8f2b-4a9e-88dc-385c893c71fa")
    public static Diagnostic warning(DiagnosticCode code, String message, List<MObject> elements) {
        return of(code, Level.WARNING, null, message, elements);
    }

    @objid ("b6a24ba9-8e52-476b-9891-839565058531")
    public static Diagnostic warning(DiagnosticCode code, DiagnosticLocation location, String message) {
        return of(code, Level.WARNING, location, message, List.of());
    }

    @objid ("230763ce-43f1-4ccb-8c2b-34b73cf212c8")
    public static Diagnostic warning(DiagnosticCode code, DiagnosticLocation location, String message, List<MObject> elements) {
        return of(code, Level.WARNING, location, message, elements);
    }

    @objid ("e0bbc15b-8125-4b06-a93d-7b5488426aaf")
    public static Diagnostic error(DiagnosticCode code, String message) {
        return of(code, Level.ERROR, null, message, List.of());
    }

    @objid ("04723ebb-feff-457c-ad2e-edd4d1b603a9")
    public static Diagnostic error(DiagnosticCode code, String message, List<MObject> elements) {
        return of(code, Level.ERROR, null, message, elements);
    }

    @objid ("4a680a0a-d050-4cd1-9b29-f555b71a4209")
    public static Diagnostic error(DiagnosticCode code, DiagnosticLocation location, String message) {
        return of(code, Level.ERROR, location, message, List.of());
    }

    @objid ("59e16537-349d-4ac7-a1c7-62b050cf8af7")
    public static Diagnostic error(DiagnosticCode code, DiagnosticLocation location, String message, List<MObject> elements) {
        return of(code, Level.ERROR, location, message, elements);
    }

    @objid ("919eb986-3d52-434c-9ca5-3d3f6ba419e1")
    public static Diagnostic of(DiagnosticCode code, Level level, DiagnosticLocation location, String message, List<MObject> elements) {
        final String renderedMessage = renderMessage(location, message);
        final List<MObject> cappedElements = capElements(elements);
        return new Diagnostic(code, level, renderedMessage, cappedElements);
    }

    @objid ("e8f27179-4572-419b-90ae-6b36646d6c0b")
    private static String renderMessage(DiagnosticLocation location, String message) {
        if (location == null) {
            return message;
        }
        return location.render() + ": " + message;
    }

    @objid ("6072b37e-91e8-48ab-8d3c-840ef465c5e9")
    private static List<MObject> capElements(List<MObject> elements) {
        if (elements == null || elements.isEmpty()) {
            return List.of();
        }
        if (elements.size() <= ELEMENTS_CAP) {
            return List.copyOf(elements);
        }
        return List.copyOf(elements.subList(0, ELEMENTS_CAP));
    }

}

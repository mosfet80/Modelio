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
package org.modelio.platform.search.engine.searchers.query.internal.resolver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.uml.infrastructure.Stereotype;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.mapi.MDependency;

/**
 * Small, per-resolution edge lookup index.
 * <p>
 * The primary role of this registry is to avoid scanning the whole metamodel
 * for dependency edges on every lookup.
 */
@objid ("1f8b2b64-87cc-4125-9dcc-6aa5205cce43")
public final class EdgeRegistry {
    @objid ("6d06ee85-1ae3-4fb0-aeed-cebda9d60151")
    private final ResolverContext context;

    @objid ("307dc402-b831-46bc-8d79-6c5f7008f004")
    private volatile Map<String, List<MDependency>> dependenciesByName;

    @objid ("c47ebdee-8387-483c-a264-cf02c1973d1e")
    public EdgeRegistry(ResolverContext context) {
        if (context == null) {
            throw new IllegalArgumentException("context must not be null");
        }
        this.context = context;
    }

    @objid ("7cf6da13-759e-40f5-9dd7-eca3555d0c9a")
    public MClass getMetaclass(String token) {
        return this.context.getMetaclass(token);
    }

    @objid ("28941091-5a4f-4fbf-ab4e-3115bc7083e7")
    public List<Stereotype> findStereotypesByName(String name) {
        return this.context.findStereotypesByName(name);
    }

    @objid ("89528c85-573a-4a70-b712-dec70a3b007c")
    public List<MDependency> findDependenciesByName(String token) {
        if (token == null || token.isBlank()) {
            return List.of();
        }
        ensureDependenciesIndex();
        return this.dependenciesByName.getOrDefault(token, List.of());
    }

    @objid ("91eec566-206b-4e0c-b165-b7844fb89ad7")
    private void ensureDependenciesIndex() {
        if (this.dependenciesByName != null) {
            return;
        }
        synchronized (this) {
            if (this.dependenciesByName != null) {
                return;
            }
            this.dependenciesByName = buildDependenciesIndex();
        }
    }

    @objid ("62ab3ac1-5337-4a04-963b-5fcf7617fd78")
    private Map<String, List<MDependency>> buildDependenciesIndex() {
        final Map<String, List<MDependency>> index = new HashMap<>();

        for (MClass mc : this.context.getRegisteredMetaclasses()) {
            if (mc == null) {
                continue;
            }
            for (MDependency dep : mc.getDependencies(false)) {
                final String name = safeName(dep);
                if (name.isBlank()) {
                    continue;
                }
                index.computeIfAbsent(name, k -> new ArrayList<>()).add(dep);
            }
        }

        final Map<String, List<MDependency>> frozen = new HashMap<>(index.size());
        for (Map.Entry<String, List<MDependency>> e : index.entrySet()) {
            frozen.put(e.getKey(), List.copyOf(e.getValue()));
        }
        return Map.copyOf(frozen);
    }

    @objid ("acfd1eba-0d8c-49c4-ad90-945582f7e2e7")
    private static List<MDependency> safeDependencies(MClass mc) {
        try {
            final List<MDependency> deps = mc.getDependencies(false);
            return (deps == null) ? List.of() : deps;
        } catch (Exception e) {
            return List.of();
        }
    }

    @objid ("943211ad-74d3-4f33-94fd-0fec60eac72c")
    private static String safeName(MDependency dep) {
        try {
            final String name = dep.getName();
            return (name == null) ? "" : name;
        } catch (Exception e) {
            return "";
        }
    }

}

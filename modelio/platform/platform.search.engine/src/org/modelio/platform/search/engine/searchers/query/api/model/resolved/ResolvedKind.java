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
package org.modelio.platform.search.engine.searchers.query.api.model.resolved;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.uml.infrastructure.Stereotype;
import org.modelio.vcore.smkernel.mapi.MClass;

/**
 * Resolved, ambiguity-aware kind reference.
 * <p>
 * Kinds can resolve to metaclasses and/or stereotypes. Resolution may be ambiguous.
 */
@objid ("574ad9d3-7181-4625-91e5-c9caeb44aa8f")
public record ResolvedKind ( List<org.modelio.platform.search.engine.searchers.query.api.model.resolved.ResolvedKind.KindAlternative> alternatives )  {
    @objid ("b630f42f-6a4f-4bdc-a76c-85ccf0cb7a9b")
    private static final ResolvedKind ANY = new ResolvedKind(List.of(AnyKind.INSTANCE));

    @objid ("5f82f4f6-becb-40fc-9c8c-e25bd39bdacf")
    private static final ResolvedKind NONE = new ResolvedKind(List.of(NoneKind.INSTANCE));

    @objid ("2b40257a-1662-48fb-9950-85e23ff8d312")
    public ResolvedKind {
        if (alternatives == null) {
            throw new IllegalArgumentException("alternatives must not be null");
        }
    }

    @objid ("9238024b-324b-45da-886c-7bbe4b72c44e")
    public boolean isAny() {
        return equals(ANY);
    }

    @objid ("3cb97a49-8abd-4b7d-9c63-d0ff19764bb3")
    public boolean isNone() {
        return equals(NONE);
    }

    @objid ("97a5231a-1184-4fd2-beed-623e73b3ca6d")
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ResolvedKind ");
        // no '[' since alternatives already enclose their content in brackets
        builder.append(this.alternatives);
        return builder.toString();
    }

    @objid ("25b16ca6-8b8a-43fe-a9cd-e683a4fc090e")
    public static ResolvedKind ofStereotype(Stereotype stereotype) {
        return new ResolvedKind(List.of(new StereotypeKind(stereotype)));
    }

    @objid ("f08b0479-f6dc-4476-8c7d-dc53d37faf4b")
    public static ResolvedKind ofMetaclass(MClass metaclass) {
        return new ResolvedKind(List.of(new MetaclassKind(metaclass)));
    }

    @objid ("c27b29b6-0793-488b-be03-13fd614e31ba")
    public static ResolvedKind none() {
        return NONE;
    }

    @objid ("61d7c7cd-ebf6-43dc-b49f-5b62c8fb7ec3")
    public static ResolvedKind any() {
        return ANY;
    }

    @objid ("be5df0ff-f871-4ce0-a70e-4ce5657457fc")
    public sealed interface KindAlternative permits MetaclassKind, StereotypeKind, AnyKind, NoneKind {
    }

    /**
     * Resolved kind alternative representing a {@link MClass metaclass} .
     *
     * @param metaclass the resolved metaclass (never null)
     * /
     * /**
     */
    @objid ("111e8935-e18d-4122-9981-2b10c15b3112")
    public record MetaclassKind ( MClass metaclass )  implements KindAlternative {
        @objid ("d62249ab-fb2a-4221-8c0a-68d965e06271")
        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("MetaclassKind [");
            builder.append(this.metaclass.getQualifiedName());
            builder.append("]");
            return builder.toString();
        }

        @objid ("c9d05e71-fe22-45fe-b0ce-7d875b3f9492")
        public MetaclassKind {
            if (metaclass == null) {
                throw new IllegalArgumentException("metaclass must not be null");
            }
        }

    }

    /**
     * Resolved kind alternative representing a {@link Stereotype}.
     *
     * @param stereotype the resolved stereotype (never null)
     */
    @objid ("a2dbf89f-3706-4736-a507-8a4f6cd69612")
    public record StereotypeKind ( Stereotype stereotype )  implements KindAlternative {
        @objid ("a4ef6ea5-2ef5-4596-8d17-e2d50ffa6a97")
        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("StereotypeKind [stereotype=");
            builder.append("<<").append(this.stereotype.getName())
            .append(" on ")
            .append(this.stereotype.getBaseClassName())
            .append(">>");
            builder.append("]");
            return builder.toString();
        }

        @objid ("6000a47a-8c3f-4d18-ac92-213dcf13cd6e")
        public StereotypeKind {
            if (stereotype == null) {
                throw new IllegalArgumentException("stereotype must not be null");
            }
        }

    }

    @objid ("fce95148-4c35-412d-889c-9e70839ffd15")
    public record AnyKind (  )  implements KindAlternative {
        @objid ("36ed5197-1774-493b-993d-fcac9cdf54a6")
        public static final AnyKind INSTANCE = new AnyKind();

        @objid ("b4f5fce7-225c-49ce-a3ee-291c97513748")
        @Override
        public String toString() {
            return "[Any]";
        }

    }

    @objid ("7f16ee2c-2cc5-4e4a-93f6-a16304275eec")
    public record NoneKind (  )  implements KindAlternative {
        @objid ("55ae48ed-fcc7-4d9e-a032-41c80ac434c0")
        public static final NoneKind INSTANCE = new NoneKind();

        @objid ("774a2b5d-004c-4ee5-add3-1851e4096498")
        @Override
        public String toString() {
            return "[None]";
        }

    }

}

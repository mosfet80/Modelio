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
/*
 * Copyright 2013-2024 Docaposte
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
package org.modelio.core.modelshield.internal;

import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.core.modelshield.ModelShield;
import org.modelio.vbasic.log.IBasicLogger;
import org.modelio.vbasic.log.Log;
import org.modelio.vcore.smkernel.mapi.modelshield.api.IErrorReport;
import org.modelio.vcore.smkernel.mapi.modelshield.api.IModelError;

/**
 * Error report of a {@link ModelShield} check.
 */
@objid ("002804cc-0000-0008-0000-000000000000")
public class ErrorReport implements IErrorReport {
    @objid ("0071ef08-8f78-1f4b-b2b8-001ec947cd2a")
    private final List<IModelError> entries;

    @objid ("00280b20-0000-0003-0000-000000000000")
    public ErrorReport() {
        this.entries = new ArrayList<>();
    }

    @objid ("002806e4-0000-0212-0000-000000000000")
    @Override
    public void addEntry(final IModelError anEntry) {
        this.entries.add(anEntry);

        if (this.entries.size() <= 5 && Log.getLogger().getLevel() == IBasicLogger.TRACE)
            Log.trace(new IllegalStateException("Adding model error:"+anEntry));
    }

    @objid ("002804f8-0000-06a7-0000-000000000000")
    @Override
    public List<IModelError> getEntries() {
        return this.entries;
    }

    @objid ("00515932-524f-1036-812a-001ec947cd2a")
    @Override
    public boolean isFailed() {
        return !this.entries.isEmpty();
    }

    @objid ("a94630f4-7f7c-4665-a20f-a194e7d9f295")
    @Override
    public String toString() {
        if (isFailed()) {
            final int maxLen = 10;
            StringBuilder builder = new StringBuilder();
            builder.append(getClass().getName());
            builder.append(" [");
            builder.append(getEntries().size());
            builder.append(" entries: ");
            getEntries().subList(0, Math.min(getEntries().size(), maxLen)).forEach(en -> builder.append("\n\t-").append(en));
            if (getEntries().size() > maxLen)
                builder.append("\n\t...");
            builder.append("]");
            return builder.toString();
        } else {
            return "ErrorReport [success]";
        }
    }

}

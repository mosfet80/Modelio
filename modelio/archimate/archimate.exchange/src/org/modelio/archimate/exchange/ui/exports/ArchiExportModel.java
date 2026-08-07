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
package org.modelio.archimate.exchange.ui.exports;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.exchange.service.ArchimateExchangeProxy.ExchangeFormatVersion;

@objid ("034060d9-dd21-44e9-a3a5-8ed7522ada63")
public class ArchiExportModel {
    @objid ("1b40e831-ff4c-4337-9903-f1357c37e036")
    private String exportPath;

    @objid ("e8c9c898-61c6-470f-a3f4-e32b12d70f00")
    private ExchangeFormatVersion version;

    @objid ("e30f3820-aeaa-47a8-b2ce-995be08ce8c3")
    public String getExportPath() {
        return this.exportPath;
    }

    @objid ("1a8359c5-199e-48ef-a4cb-a1748820fad7")
    public void setExportPath(String exportPath) {
        this.exportPath = exportPath;
    }

    @objid ("9bdad6e5-6631-4f56-9759-0d10d002e3ca")
    public ExchangeFormatVersion getVersion() {
        return this.version;
    }

    @objid ("090636f4-1b61-49d2-9756-5f33838641d4")
    public void setVersion(ExchangeFormatVersion version) {
        this.version = version;
    }

}

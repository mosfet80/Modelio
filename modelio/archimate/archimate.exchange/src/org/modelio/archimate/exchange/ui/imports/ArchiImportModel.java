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
package org.modelio.archimate.exchange.ui.imports;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.exchange.service.ArchimateExchangeProxy.ExchangeFormatVersion;

@objid ("6c9576e5-3673-414f-af55-7249aaaf9ec4")
public class ArchiImportModel {
    @objid ("2b90e561-1e94-4264-94e9-abe57b3c98ae")
    private String importPath;

    @objid ("2ef6c80d-3c05-49fb-b4ca-73b03e8158a3")
    private boolean keepId = false;

    @objid ("0770dbe1-7777-4718-a124-0fecc76c4b2f")
    private ExchangeFormatVersion version;

    @objid ("9a3cdd56-90d5-4189-8fd1-f77baf5970a7")
    private boolean applyNativeStyle = false;

    @objid ("2b924d93-0e9c-472d-bb3c-42181a6cfcb1")
    public String getImportPath() {
        return this.importPath;
    }

    @objid ("5f13c570-b2da-4062-9097-7cb5769d1fe4")
    public void setImportPath(String filePath) {
        this.importPath = filePath;
    }

    @objid ("bd9f4366-e10f-425e-b6a9-06c426720c09")
    public boolean isKeepId() {
        return this.keepId;
    }

    @objid ("fa86b809-6c15-4f4d-9928-1b26d3071519")
    public void setKeepId(boolean keeyId) {
        this.keepId = keeyId;
    }

    @objid ("aa012467-cfb2-4ccf-96fb-ab6e35035b91")
    public ExchangeFormatVersion getVersion() {
        return this.version;
    }

    @objid ("1058c78f-df9b-47f1-924f-8001057cca26")
    public void setVersion(ExchangeFormatVersion version) {
        this.version = version;
    }

    @objid ("0a8311b1-359f-4b83-b164-2d001d558590")
    public boolean isApplyNativeStyle() {
        return applyNativeStyle;
    }

    @objid ("ec421f58-c128-474c-acce-d8593d9a3af4")
    public void setApplyNativeStyle(boolean applyNativeStyle) {
        this.applyNativeStyle = applyNativeStyle;
    }

}

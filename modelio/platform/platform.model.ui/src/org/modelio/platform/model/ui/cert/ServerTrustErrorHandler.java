/* 
 * Copyright 2013-2020 Modeliosoft
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
package org.modelio.platform.model.ui.cert;

import java.net.URI;
import java.security.KeyStoreException;
import java.security.cert.X509Certificate;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import javax.annotation.PostConstruct;
import jakarta.inject.Inject;
import javax.net.ssl.SSLHandshakeException;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.modelio.platform.model.ui.plugin.CoreUi;
import org.modelio.vbasic.net.ISslUntrustedServerFixer;
import org.modelio.vbasic.net.SslManager;

/**
 * Service class to use when SSL certificate validation for a server fails with a {@link SSLHandshakeException}.
 * <p>
 * It displays a dialog box allowing the user to accept temporarily or permanently
 * the invalid certificate.
 */
@objid ("c4a47855-d24d-432c-8274-d482cafd0d62")
public class ServerTrustErrorHandler implements ISslUntrustedServerFixer {
    @objid ("1f96d665-293a-4454-b810-8580cd06aa98")
    @Optional
    @Inject
    private MApplication app;

    @objid ("0c9ce26e-390b-4296-84db-7138bd1bb3d5")
    @PostConstruct
    void init(@Optional MApplication app) {
        SslManager.getInstance().setUntrustedServerFixer(this);
    }

    @objid ("b3f77897-4f1d-4f49-961f-dea32e3aba56")
    @Override
    public boolean fixUntrustedServer(final URI uri, X509Certificate[] chain, Throwable ex) {
        final Runner runnable = new Runner( ex, uri, chain);
        Display.getDefault().syncExec(runnable);
        return  runnable.getResult();
    }

    @objid ("d465c3ca-ccbe-46fd-b553-9538868b6c8d")
    private Shell getTopShell() {
        return new TopShellGetter(this.app).getShell();
    }

    @objid ("4ae7cae9-ffda-4ec9-9002-212aede8f929")
    private final class Runner implements Runnable {
        @objid ("0b514a99-8d2f-4b2b-8257-70cb6b4008d9")
        private boolean ret;

        @objid ("e80e26fa-6e70-4b48-a3df-d3928f591ef9")
        private final Throwable cause;

        @objid ("5f74d723-0efc-4cbd-9480-0ad1cb73a55e")
        private final URI uri;

        @objid ("9d5d1274-f96a-4120-b5a0-98de24a7d9cb")
        private X509Certificate[] chain;

        @objid ("c7baa7bb-122d-44f9-8dc9-9e6015d2d41d")
         Runner(Throwable cause, URI uri, X509Certificate[] chain) {
            this.cause = cause;
            this.uri = uri;
            this.chain = chain;
            
        }

        @objid ("524266d1-0742-45a1-8595-e0a6547df8b0")
        @Override
        public void run() {
            this.ret = handleInvalidCertificateException();
        }

        @objid ("00f64096-979e-4923-9b3a-7be3c5414d01")
        public boolean getResult() {
            return this.ret;
        }

        @objid ("55527c59-5966-4116-9d2a-322e796bc371")
        private boolean handleInvalidCertificateException() {
            Shell parentShell = ServerTrustErrorHandler.this.getTopShell();
            UntrustedServerDialog dlg = new UntrustedServerDialog(parentShell, this.uri, this.chain, this.cause);
            
            int res = dlg.open();
            X509Certificate cert = this.chain[0];
            
            try {
                switch (res) {
                case UntrustedServerDialog.TRUST_ONCE_ID:
                    SslManager.getInstance().addCertificate(cert, false);
                    return true;
                case UntrustedServerDialog.TRUST_ALWAYS_ID:
                    SslManager.getInstance().addCertificate(cert, true);
                    return true;
                case IDialogConstants.CANCEL_ID:
                default:
                    return false;
                }
            } catch (KeyStoreException e) {
                this.cause.addSuppressed(e);
                CoreUi.LOG.error(this.cause);
            
                MessageDialog.openError(parentShell, "Error", e.getLocalizedMessage());
                return false;
            }
            
        }

    }

}

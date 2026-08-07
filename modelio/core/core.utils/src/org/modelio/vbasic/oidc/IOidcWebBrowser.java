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
package org.modelio.vbasic.oidc;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

/**
 * Interface that represents a web browser component that displays the login page.
 *
 * @author cmarin
 * @since 5.2
 */
@objid ("1fd37883-b63f-4a18-9522-1787f9154f3d")
public interface IOidcWebBrowser {
    /**
     * Request the browser to display the given URI.
     * <p>
     * The caller expects this method to return as soon as possible and to open the browser asynchronously.
     * <p>
     * The browser should call the given runnable if it detects the user closed the browser or cancelled the authentication.
     *
     * @param reqUri the URL to load in the browser.
     * @param browserClosedListener a cancel listener
     */
    @objid ("d7b7d56a-970b-4988-aff7-22ba12d307a1")
    void browse(URI reqUri, Runnable browserClosedListener);

    /**
     * Called each time a thread requests a token, from the thread that requests it.
     * <p>
     * The implementation may use it to solve dead locks when the browser must
     * be displayed by a specific thread.
     *
     * @since 6.0.0
     */
    @objid ("5a646421-8c4c-4fb8-a645-372b48a0230b")
    default void ping() {
        return;
    }

    /**
     * Request the browser to close.
     * <p>
     * Called by the authentication flow at the end.
     */
    @objid ("3e55a892-beb2-4107-a753-294e862746dc")
    void closeBrowser();

    /**
     * Get a HTTP server basic implementation that will be called to serve pages
     * displayed after the authentication is successful.
     * <p>
     * It will be first called with '/' path, that should return an "authentication successfull" page
     * that asks the user to wait for the browser to close.
     *
     * @return the HTTP server
     * @since 6.0.0
     */
    @objid ("acfb446f-6957-4865-9a0c-0015539f9715")
    default OidcRedirectServer getOidcRedirectServer() {
        return null;
    }

    /**
     * A basic implementation of {@link IHttpResponse}.
     *
     * @since 6.0.0
     */
    @objid ("d0ce65b0-909e-4758-9ef2-4c07e810dc08")
    static class BasicHttpResponse implements IHttpResponse {
        @objid ("a343cb90-fa76-4847-9d33-619533829d4c")
        private int statusCode;

        @objid ("9c8966a3-60de-49b4-93ca-e8a3ef017ab7")
        private String contentType;

        @objid ("4737d08c-df63-469d-97ee-bd09bf2d1fb5")
        private InputStream content;

        @objid ("166e8450-b95e-4eb0-8726-fa2a47b04aae")
        public BasicHttpResponse(int statusCode, String contentType, InputStream content) {
            super();
            this.statusCode = statusCode;
            this.contentType = contentType;
            this.content = content;
        }

        @objid ("a3261fcc-6c42-4f45-90f7-45caa2fe9c82")
        public static BasicHttpResponse ofString(int status, String content) {
            return new BasicHttpResponse(status, "text/html; charset=UTF-8", new ByteArrayInputStream(content.getBytes(StandardCharsets.UTF_8)));
        }

        @objid ("db9b9ac6-be7f-47f2-8087-5c05eda74b08")
        public BasicHttpResponse withStatusCode(int status) {
            this.statusCode = status;
            return this;
        }

        @objid ("390ee388-3cb6-4adc-b823-9a7ac32177c6")
        public BasicHttpResponse withStringContent(String s) {
            this.content = new ByteArrayInputStream(s.getBytes(StandardCharsets.UTF_8));
            return this;
        }

        @objid ("ed17281f-aaf1-40cf-bc2b-6944bf93b9f9")
        public BasicHttpResponse withContent(InputStream s) {
            this.content = s;
            return this;
        }

        @objid ("1d7f0185-1f59-4026-91bb-07ea65b51ca9")
        public BasicHttpResponse withContentType(String contentType) {
            this.contentType = contentType;
            return this;
        }

        @objid ("bd9d969b-46da-4823-8e54-c3e9949f90aa")
        @Override
        public InputStream getContent() {
            return this.content;
        }

        @objid ("77de88af-e419-4744-9b58-cf81f5ca0397")
        @Override
        public String getContentType() {
            return this.contentType;
        }

        @objid ("a81ea027-4906-44cb-ada1-4178d7c5bbfe")
        @Override
        public int getStatusCode() {
            return this.statusCode;
        }

    }

    /**
     * Basic HTTP server request mapper, to serve a page and some images.
     * <p>
     * <b>Beware of security when implementing it, don't serve anything !!</b>
     *
     * @since 6.0.0
     */
    @objid ("5ec9d156-9df2-407e-b9ea-4763fbe92953")
    interface OidcRedirectServer {
        /**
         * Serve an URI.
         *
         * @param path the request path.
         * @return the request response. null will be interpreted as 404 not found.
         * @see BasicHttpResponse BasicHttpResponse for implementation
         */
        @objid ("2b9e2ac9-e6a8-4336-9386-022b3eb5e6b6")
        IHttpResponse serve(String path);

    }

    /**
     * A HTTP request response
     *
     * @see BasicHttpResponse
     * @since 6.0.0
     */
    @objid ("665bd34b-5168-4273-b3f0-b7ce641b18d8")
    interface IHttpResponse {
        /**
         *
         * @return HTTP status code
         */
        @objid ("b02e1d99-dd06-4510-8a38-9ec252e0ced2")
        int getStatusCode();

        /**
         * eg "text/html; charset=UTF-8"
         *
         * @return the content type.
         */
        @objid ("c97b4ff7-8a9b-41bc-9c40-12996e72d925")
        String getContentType();

        @objid ("41a2626a-0061-45a0-bdc8-95d1dfa33cf0")
        InputStream getContent();

    }

}

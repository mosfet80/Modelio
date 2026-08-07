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
package org.modelio.vbasic.net;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import java.io.Serializable;
import java.io.StreamCorruptedException;
import java.io.UncheckedIOException;
import java.net.URI;
import java.security.Principal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import javax.net.ssl.SSLException;
import org.apache.http.Consts;
import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.auth.AUTH;
import org.apache.http.auth.AuthScheme;
import org.apache.http.auth.AuthSchemeProvider;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.AuthenticationException;
import org.apache.http.auth.BasicUserPrincipal;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.InvalidCredentialsException;
import org.apache.http.auth.MalformedChallengeException;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.AuthCache;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.AuthSchemes;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.config.RequestConfig.Builder;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.config.Lookup;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.SchemePortResolver;
import org.apache.http.conn.UnsupportedSchemeException;
import org.apache.http.impl.auth.BasicSchemeFactory;
import org.apache.http.impl.auth.DigestSchemeFactory;
import org.apache.http.impl.auth.KerberosSchemeFactory;
import org.apache.http.impl.auth.NTLMSchemeFactory;
import org.apache.http.impl.auth.RFC2617Scheme;
import org.apache.http.impl.auth.SPNegoSchemeFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.SystemDefaultCredentialsProvider;
import org.apache.http.impl.conn.DefaultSchemePortResolver;
import org.apache.http.message.BufferedHeader;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.Args;
import org.apache.http.util.CharArrayBuffer;
import org.modelio.vbasic.auth.IAuthData;
import org.modelio.vbasic.auth.NoneAuthData;
import org.modelio.vbasic.auth.OidcAuthData;
import org.modelio.vbasic.auth.UserPasswordAuthData;
import org.modelio.vbasic.files.FileUtils;
import org.modelio.vbasic.log.IBasicLogger;
import org.modelio.vbasic.log.Log;

/**
 * Entry point to use Apache HTTP client.
 * <p>
 * Allows to:
 * <ul>
 * <li>Get a default HTTP client with {@link #getDefaultClient()}
 * <li>Get a configured client builder you may customize with {@link #createClientBuilder()}
 * <li>Setup proxy authentication from system preferences set by Eclipse preferences dialog with {@link #configProxyCredentials(Properties, String, CredentialsProvider)}.
 * </ul>
 * The HTTP clients are configured to use {@link SslManager} to validate server certificates that may ask the user for confirmation in case of untrusted certificate.
 *
 * @author cma
 * @since 3.7.1 : Extracted from {@link ApacheUriConnection} to be reused outside.
 */
@objid ("ea58b1b9-38a6-4b36-96e9-32f37f7016b7")
public class ApacheHttpClients {
    /**
     * Copy of {@link org.apache.http.impl.client.AuthenticationStrategyImpl#DEFAULT_SCHEME_PRIORITY} .
     * <p>
     * Needed for OAuth/token/OIDC authentication.
     *
     * @since 5.2
     */
    @objid ("d9c58319-faaa-407f-9abc-1f03cba3d5c6")
    @SuppressWarnings("javadoc")
    public static final List<String> DEFAULT_SCHEME_PRIORITY;

    /**
     * Default {@link RequestConfig#getConnectTimeout()}, {@link RequestConfig#getSocketTimeout()} .
     * <p>
     * It is used to initialize {@link #createClientBuilder()}.
     *
     * @since 5.4.1
     */
    @objid ("bb466e71-55a2-4bb2-aa3d-d2e82eb29e65")
    public static final int DEFAULT_TIMEOUT_IN_MILLIS = 5_000;

    @objid ("4ba63a3b-aab4-47f4-94f6-fcbd5158fd54")
    private static final HttpClient defaultClient;

    /**
     * Default auth scheme registry needed for OAuth/token/OIDC authentication.
     *
     * @since 5.2
     */
    @objid ("c49ad6e4-0455-4bd6-9e4f-6891c13ec2f7")
    public static final Lookup<AuthSchemeProvider> DEFAULT_AUTH_SCHEME_REGISTRY;

    /**
     *
     * @deprecated since 5.4.1 19/02/2024 replaced by {@link #createRequestConfig()} because it depends on system properties that
     * may in the future be changed while running.
     */
    @objid ("51661a9c-5a10-49a5-947f-89969e292b5b")
    @Deprecated
    private static final RequestConfig DEFAULT_REQUEST_CONFIG;

    /**
     * Configure HTTP(S) proxy authentication from the given properties .
     * <p>
     * Allows setup HTTP(S) proxy authentication from supplement system properties set by Eclipse.
     * <p>
     * http://docs.oracle.com/javase/7/docs/api/java/net/doc-files/net-properties.html:
     * <p>
     * There are 3 properties you can set to specify the proxy that will be used by the http protocol handler:
     * <ul>
     * <li>http.proxyHost: the host name of the proxy server
     * <li>http.proxyPort: the port number, the default value being 80.
     * <li>http.nonProxyHosts : not used in our case
     * </ul>
     * <p>
     * The Eclipse preference page allows modifying all of these. <code>proxyUser</code> and <code>proxyPassword</code> are properties not used by the JDK but set by Eclipse preference page.
     *
     * @param props configuration source
     * @param protocol "http" or "https"
     * @param credsProvider the credential provider to fill
     * @see <a href="http://stackoverflow.com/questions/1626549/authenticated-http-proxy-with-java">stackoverflow: Authenticated HTTP proxy with Java</a>
     * @see <a href="http://docs.oracle.com/javase/7/docs/api/java/net/doc-files/net-properties.html">Java documentation: Networking Properties</a>
     * @see org.eclipse.core.internal.net.ProxyType
     */
    @objid ("fbda3db8-0195-4690-81dc-81ecfe95a586")
    private static void configProxyCredentials(Properties props, String protocol, CredentialsProvider credsProvider) {
        /*
                         * http://docs.oracle.com/javase/7/docs/api/java/net/doc-files/net-properties.html:
                         *
                         * There are 3 properties you can set to specify the proxy that will be used by the http protocol handler: http.proxyHost: the host name of the proxy server http.proxyPort: the port number, the default value being 80.
                         *
                         * proxyUser and proxyPassword are not used by the JDK but are set by Eclipse preference page. see : org.eclipse.core.internal.net.ProxyType
                         */

        String proxyHostKey = protocol + ".proxyHost";
        String proxyUserKey = protocol + ".proxyUser";

        if (props.containsKey(proxyHostKey) &&
                props.containsKey(proxyUserKey)) {

            String proxyPortKey = protocol + ".proxyPort";
            String proxyPasswdKey = protocol + ".proxyPassword";

            String proxyHost = props.getProperty(proxyHostKey);
            String proxyUser = props.getProperty(proxyUserKey);
            String proxyPwd = props.getProperty(proxyPasswdKey);
            String portStr = props.getProperty(proxyPortKey);

            int port = AuthScope.ANY_PORT;
            if (portStr != null) {
                try {
                    port = Integer.parseInt(portStr);
                } catch (RuntimeException e) {
                    // Log and ignore
                    Log.warning(e);
                }
            }

            final UsernamePasswordCredentials credentials = new UsernamePasswordCredentials(proxyUser, proxyPwd);

            final AuthScope authscope = new AuthScope(proxyHost, port);
            credsProvider.setCredentials(
                    authscope,
                    credentials);
        }
    }

    /**
     * Create a configured but still customizable {@link HttpClientBuilder}.
     * <p>
     * Please note the builder has a default :<ul>
     * <li> request config set as {@link #DEFAULT_REQUEST_CONFIG}.
     * <li> Auth scheme registry
     *
     * @return a HttpClientBuilder
     */
    @objid ("bc1f0a0d-8efc-424f-ae30-745413b75e5e")
    public static HttpClientBuilder createClientBuilder() {
        return HttpClientBuilder.create()
                .useSystemProperties()
                .setSSLContext(SslManager.getInstance().getSslContext())
                .setRedirectStrategy(null)
                .setRetryHandler(new RetryHandler())
                .setDefaultRequestConfig(createRequestConfig().build())
                .setDefaultAuthSchemeRegistry(DEFAULT_AUTH_SCHEME_REGISTRY)
                ;
    }

    @objid ("b0822db6-c4e3-424f-b800-f5dc3761177a")
    private static Registry<AuthSchemeProvider> initAuthSchemeRegistry() {
        return RegistryBuilder.<AuthSchemeProvider>create()
                .register(AuthSchemes.BASIC, new BasicSchemeFactory())
                .register(AuthSchemes.DIGEST, new DigestSchemeFactory())
                .register(AuthSchemes.NTLM, new NTLMSchemeFactory())
                .register(AuthSchemes.SPNEGO, new SPNegoSchemeFactory())
                .register(AuthSchemes.KERBEROS, new KerberosSchemeFactory())
                .register(BearerAuthScheme.SCHEME_NAME, BearerAuthScheme.factory())
                .build();
    }

    /**
     * Get the default Apache HTTP client to be used inside Modelio.
     *
     * @return a ready to use {@link CloseableHttpClient}.
     */
    @objid ("65d4178b-287b-4e04-a887-477100021c0b")
    public static HttpClient getDefaultClient() {
        return ApacheHttpClients.defaultClient;
    }

    @objid ("526c188d-d764-4c43-bef9-8b09b0b3c1eb")
    private static HttpClient initDefaultHttpClient() {
        return createClientBuilder().build();
    }

    /**
     * Creates an {@link HttpClientContext} for the given URI and authentication data
     *
     * @param uri an URI to access
     * @param auth authentication for the URI. <i>null</i> if not authentication required.
     * @param configBuilder an optional RequestConfig builder to setup for proxy settings.
     * @return a configured {@link HttpClientContext}
     * @throws UriAuthenticationException if the authentication data is not handled.
     */
    @objid ("d8a251bb-eb0a-410d-8d25-351b0f8e0730")
    public static HttpClientContext createHttpContext(URI uri, IAuthData auth, Builder configBuilder) throws UriAuthenticationException {
        HttpClientContext context = HttpClientContext.create();

        CredentialsProvider credsProvider = new SystemDefaultCredentialsProvider();
        context.setCredentialsProvider(credsProvider);

        // Since Modelio 5.5 use our own auth cache that can cache BearerAuthScheme
        context.setAuthCache(new ModelioAuthCache());

        if (auth != null) {
            switch (auth.getSchemeId()) {
            case UserPasswordAuthData.USERPASS_SCHEME_ID: {
                UserPasswordAuthData authData = (UserPasswordAuthData) auth;

                if (authData.getUser() == null) {
                    throw new UriAuthenticationException(uri.toString(), "User name may not be null.");
                }

                Credentials credentials = new UsernamePasswordCredentials(authData.getUser(), authData.getPassword());
                AuthScope authscope = new AuthScope(uri.getHost(), AuthScope.ANY_PORT);
                credsProvider.setCredentials(authscope, credentials);
            }
            break;
            case OidcAuthData.SCHEME_ID: {
                OidcAuthData authData = (OidcAuthData) auth;

                AuthScope authscope = new AuthScope(uri.getHost(), AuthScope.ANY_PORT, AuthScope.ANY_REALM, BearerAuthScheme.SCHEME_NAME);
                credsProvider.setCredentials(authscope, new OidcCredentials(authData));

                if (configBuilder != null) {
                    configBuilder.setTargetPreferredAuthSchemes(Arrays.asList(BearerAuthScheme.SCHEME_NAME, AuthSchemes.DIGEST, AuthSchemes.BASIC));
                }
            }
            break;
            case NoneAuthData.AUTH_NONE_SCHEME_ID:
                break;
            default:
                throw new UriAuthenticationException(uri.toString(), auth + " not supported .");
            }
        }

        /** support different proxy */
        configProxy(credsProvider, auth, configBuilder);
        return context;
    }

    /**
     * Proxy configuration for a connection.
     * <p>
     * Configure the proxy if specified in the connection and set proxy authentication data from user settings and Eclipse preferences stored in System properties..
     *
     * @param credsProvider the credential provider to fill.
     * @param auth the authentication data for custom proxy settings
     * @param configBuilder an optional RequestConfig.Builder for proxy setup.
     */
    @objid ("e106d3cf-c3a2-4cea-9fcf-f405317e705f")
    private static void configProxy(CredentialsProvider credsProvider, IAuthData auth, Builder configBuilder) {
        // currently not used : allow auth data to specify proxy
        if (auth != null && configBuilder != null) {
            Map<String, String> data = auth.getData();
            if (data != null) {
                if (data.containsKey("http.proxyHost")) {
                    String host = data.get("http.proxyHost");
                    int port = Integer.parseInt(data.getOrDefault("http.proxyPort", "-1"));

                    HttpHost proxy = new HttpHost(host, port);
                    configBuilder.setProxy(proxy);

                    final Properties props = new Properties();
                    props.putAll(data);

                    ApacheHttpClients.configProxyCredentials(props, "http", credsProvider);
                }
            }
        }

        // Setup proxy authentication from system properties set by Eclipse
        // see : org.eclipse.core.internal.net.ProxyType
        configProxyCredentials(System.getProperties(), "http", credsProvider);
        configProxyCredentials(System.getProperties(), "https", credsProvider);
    }

    @objid ("d7162fc7-fe35-4cd1-9d77-5b7140a0337f")
    private static int getIntProperty(String key, int defaultVal) {
        String v = System.getProperty(key);
        if (v == null)
            return defaultVal;
        try {
            return Integer.parseInt(v);
        } catch (NumberFormatException e) {
            Log.warning("Invalid '%s' system property value: %s (%s)", key, v, e.getMessage());
            Log.trace(e);
        }
        return defaultVal;
    }

    /**
     * Create a {@link RequestConfig}
     * <p>
     * Configures it with Modelio defaults timeout and for OAuth/token/OIDC authentication.
     * It is used to initialize {@link #createClientBuilder()}.
     *
     * @since 5.4.1 19/02/2024 : Replaces the now removed  static DEFAULT_REQUEST_CONFIG RequestConfig .
     */
    @objid ("bb91e00f-94d1-4cf3-a0ac-ec040c4cb3d9")
    public static org.apache.http.client.config.RequestConfig.Builder createRequestConfig() {
        return RequestConfig
                .copy(RequestConfig.DEFAULT)
                .setTargetPreferredAuthSchemes(DEFAULT_SCHEME_PRIORITY)
                .setConnectTimeout(getIntProperty("modelio.http.timeout.connect", DEFAULT_TIMEOUT_IN_MILLIS))
                .setSocketTimeout(getIntProperty("modelio.http.timeout.socket", DEFAULT_TIMEOUT_IN_MILLIS))
                .setConnectionRequestTimeout(getIntProperty("modelio.http.timeout.connectionPool", DEFAULT_TIMEOUT_IN_MILLIS));
    }

static {
                    // Initialize all statics in the right order
                    DEFAULT_SCHEME_PRIORITY = Collections.unmodifiableList(Arrays.asList(
                            BearerAuthScheme.SCHEME_NAME,
                            AuthSchemes.SPNEGO,
                            AuthSchemes.KERBEROS,
                            AuthSchemes.NTLM,
                            AuthSchemes.CREDSSP,
                            AuthSchemes.DIGEST,
                            AuthSchemes.BASIC));

                    DEFAULT_AUTH_SCHEME_REGISTRY = initAuthSchemeRegistry();


                    DEFAULT_REQUEST_CONFIG = createRequestConfig().build();

                    // Initialize default client at last because it depends on above initializations.
                    defaultClient = initDefaultHttpClient();
                }

    /**
     * {@link DefaultHttpRequestRetryHandler} extension that handles:
     * <ul>
     * <li> {@link SSLException} to allow {@link SslManager#fixUntrustedServer(SSLException, URI)} to fix the error.
     * <li> since 5.4.1, {@link java.net.SocketTimeoutException} to allow retry contrary to {@link java.io.InterruptedIOException} and its sub classes
     * that are rejected by the default behavior.
     * </ul>
     */
    @objid ("9453ebe9-8193-4264-b09f-dfb4ab856a7c")
    public static class RetryHandler extends DefaultHttpRequestRetryHandler {
        @objid ("fded4899-30d6-4cc6-95ec-3a4a3b7773c4")
        @Override
        public boolean retryRequest(IOException exception, int executionCount, HttpContext context) {
            if (executionCount > getRetryCount()) {
                // Do not retry if over max retry count
                return false;
            }

            if (exception instanceof SSLException) {
                HttpClientContext clientContext = HttpClientContext.adapt(context);
                HttpHost currentHost = clientContext.getTargetHost();
                URI anUri = URI.create(currentHost.toURI());

                return SslManager.getInstance().fixUntrustedServer((SSLException) exception, anUri);
            }

            if (exception instanceof java.net.SocketTimeoutException) {
                // java.net.SocketTimeoutException is a subclass of InterruptedIOException, that is
                // a non retriable exception by default.
                // But SocketTimeoutException is caused by the remote part and InterruptedIOException is rather caused by our side.
                // So we want to retry on SocketTimeoutException contrary to InterruptedIOException and its subclasses.

                return isRequestRetriable(context);
            }

            if (exception instanceof java.io.InterruptedIOException && exception.getCause() instanceof org.apache.http.impl.conn.ConnectionShutdownException) {
                // Spurious connection closed
                /*
                                Caused by: java.io.InterruptedIOException: Connection has been shut down
                                    at org.apache.http.impl.execchain.MainClientExec.execute(MainClientExec.java:342)
                                    at org.apache.http.impl.execchain.ProtocolExec.execute(ProtocolExec.java:186)
                                    at org.apache.http.impl.execchain.RetryExec.execute(RetryExec.java:89)
                                    at org.apache.http.impl.execchain.RedirectExec.execute(RedirectExec.java:110)
                                    at org.apache.http.impl.client.InternalHttpClient.doExecute(InternalHttpClient.java:185)
                                    at org.apache.http.impl.client.CloseableHttpClient.execute(CloseableHttpClient.java:83)
                                    at org.apache.http.impl.client.CloseableHttpClient.execute(CloseableHttpClient.java:56)
                                    ...
                                Caused by: org.apache.http.impl.conn.ConnectionShutdownException
                                    at org.apache.http.impl.conn.CPoolProxy.getValidConnection(CPoolProxy.java:77)
                                    at org.apache.http.impl.conn.CPoolProxy.getSSLSession(CPoolProxy.java:137)
                                    at org.apache.http.impl.client.DefaultUserTokenHandler.getUserToken(DefaultUserTokenHandler.java:82)
                                    at org.apache.http.impl.execchain.MainClientExec.execute(MainClientExec.java:326)
                                    ...
                            */
                return isRequestRetriable(context);
            }

            // Default behavior
            return super.retryRequest(exception, executionCount, context);
        }

        @objid ("f75f7362-b1cd-43ae-9a58-78ef0e19f048")
        private boolean isRequestRetriable(HttpContext context) {
            // below is a copy paste of a part of the parent behavior
            final HttpClientContext clientContext = HttpClientContext.adapt(context);
            final HttpRequest request = clientContext.getRequest();
            if (handleAsIdempotent(request)) {
                // Retry if the request is considered idempotent
                return true;
            }

            if (!clientContext.isRequestSent() || isRequestSentRetryEnabled()) {
                // Retry if the request has not been sent fully or
                // if it's OK to retry methods that have been sent
                return true;
            }

            // otherwise do not retry
            return false;
        }

    }

    /**
     * "Bearer" authentication scheme for OIDC/OAuth authentication.
     * <p>
     * Expects the access token being stored in the {@link Credentials#getPassword()}.
     *
     * @author cmarin
     * @since 5.2
     */
    @objid ("2ac5eead-7eac-4800-90cf-8837c59baa24")
    public static class BearerAuthScheme extends RFC2617Scheme {
        @objid ("56dfafae-a4a9-496a-a827-071b56b16c57")
        private static final long serialVersionUID = -1931571557597830536L;

        /**
         * Whether the basic authentication process is complete
         */
        @objid ("f291c173-0961-4d25-8f05-0f788c158066")
        private boolean complete;

        /**
         * The scheme identifier
         */
        @objid ("33eb2f7d-cbac-4674-9c33-f57395275124")
        public static String SCHEME_NAME = "Bearer";

        @objid ("31a91c79-86e7-4c7d-a5b9-3848b3e992fd")
        public BearerAuthScheme() {
            super(Consts.ASCII);
        }

        /**
         * Returns textual designation of the basic authentication scheme.
         *
         * @return {@code basic}
         */
        @objid ("dd936bb3-07be-4ef2-838f-46d585693552")
        @Override
        public String getSchemeName() {
            return SCHEME_NAME;
        }

        /**
         * Processes the Basic challenge.
         *
         * @param header the challenge header
         * @throws MalformedChallengeException is thrown if the authentication challenge
         * is malformed
         */
        @objid ("5ce50f2f-7209-4b2b-99c1-83f93e9b9956")
        @Override
        public void processChallenge(final Header header) throws MalformedChallengeException {
            super.processChallenge(header);
            this.complete = true;
        }

        /**
         * Tests if the Basic authentication process has been completed.
         *
         * @return {@code true} if Basic authorization has been processed,
         * {@code false} otherwise.
         */
        @objid ("cc0a68fd-40a2-4eb6-8be6-e7983ebf107b")
        @Override
        public boolean isComplete() {
            return this.complete;
        }

        /**
         * Returns {@code false}. Basic authentication scheme is request based.
         *
         * @return {@code false}.
         */
        @objid ("e57820e1-e249-4360-b60a-826fec8f81ef")
        @Override
        public boolean isConnectionBased() {
            return false;
        }

        /**
         *
         * @deprecated (4.2) Use {@link org.apache.http.auth.ContextAwareAuthScheme#authenticate(
         * Credentials, HttpRequest, org.apache.http.protocol.HttpContext)}
         */
        @objid ("a26fd6e9-2347-4073-861a-d23f88a4baf4")
        @Override
        @Deprecated
        public Header authenticate(final Credentials credentials, final HttpRequest request) throws AuthenticationException {
            return authenticate(credentials, request, new BasicHttpContext());
        }

        /**
         * Produces basic authorization header for the given set of {@link Credentials}.
         *
         * @param credentials The set of credentials to be used for authentication
         * @param request The request being authenticated
         * @return a basic authorization string
         * @throws InvalidCredentialsException if authentication
         * credentials are not valid or not applicable for this authentication scheme
         * @throws AuthenticationException if authorization string cannot
         * be generated due to an authentication failure
         */
        @objid ("a4b721ca-c5c1-49ba-98a9-683199cf07c8")
        @Override
        public Header authenticate(final Credentials credentials, final HttpRequest request, final HttpContext context) throws InvalidCredentialsException, AuthenticationException {
            Args.notNull(credentials, "Credentials");
            Args.notNull(request, "HTTP request");

            String accessToken;
            try {
                accessToken = credentials.getPassword();
            } catch (UncheckedIOException e) {
                throw new AuthenticationException(FileUtils.getLocalizedMessage(e.getCause()), e);
            }
            if (accessToken == null)
                throw new InvalidCredentialsException("credentials.getPassword() returned null");

            final CharArrayBuffer buffer = new CharArrayBuffer(64);
            if (isProxy()) {
                buffer.append(AUTH.PROXY_AUTH_RESP);
            } else {
                buffer.append(AUTH.WWW_AUTH_RESP);
            }
            buffer.append(": Bearer ");
            buffer.append(accessToken);
            return new BufferedHeader(buffer);
        }

        @objid ("64bf14f1-d602-4810-bede-f458fa295018")
        @Override
        public String toString() {
            return new StringBuilder()
                    .append(BearerAuthScheme.SCHEME_NAME)
                    .append(" [complete=")
                    .append(this.complete)
                    .append("]")
                    .toString();
        }

        /**
         *
         * @return a {@link AuthSchemeProvider} that creates {@link BearerAuthScheme}.
         */
        @objid ("a25545a6-44f8-43e5-ac45-32f29b31ae95")
        public static AuthSchemeProvider factory() {
            return (HttpContext c)-> new BearerAuthScheme();
        }

    }

    /**
     * Modelio implementation of {@link org.apache.http.client.AuthCache}. This implements
     * expects {@link org.apache.http.auth.AuthScheme} to be {@link java.io.Serializable}
     * in order to be cacheable.
     * <p>
     * It a copy paste of BasicAuthCache, needed because httpclient plugin cannot load {@link BearerAuthScheme}.
     * Instances of this class are thread safe.
     * </p>
     *
     * @since 5.5
     */
    @objid ("f2b0ce22-0b98-45c1-85f8-53aa121db00c")
    public static class ModelioAuthCache implements AuthCache {
        @objid ("4e05ce5b-23d7-4553-b0e3-d33d192bee36")
        private final IBasicLogger log = Log.getLogger();

        @objid ("8d55c774-6917-4462-b270-490aa0cd66e7")
        private final Map<HttpHost, byte[]> map;

        @objid ("afe96f76-540e-4146-ad6f-dde8d20f5fe0")
        private final SchemePortResolver schemePortResolver;

        @objid ("fe99cd3b-b033-4c76-b971-cd62da70bc19")
        private ClassLoader loader;

        /**
         * Customized constructor.
         *
         * @param schemePortResolver a {@link SchemePortResolver} or null.
         * @param loader a ClassLoader that can load the needed {@link AuthScheme} classes. May be null.
         */
        @objid ("c7d9e4d2-c1d9-4889-bce9-3e12d792dc19")
        public ModelioAuthCache(final SchemePortResolver schemePortResolver, ClassLoader loader) {
            this.map = new ConcurrentHashMap<>();
            this.schemePortResolver = schemePortResolver != null ? schemePortResolver : DefaultSchemePortResolver.INSTANCE;

            this.loader = loader != null ? loader : Thread.currentThread().getContextClassLoader();
            if (this.loader == null)
                this.loader = ModelioAuthCache.class.getClassLoader();
        }

        /**
         * Default constructor
         */
        @objid ("b754f89e-1b3d-4a7c-b1c5-a35038130462")
        public ModelioAuthCache() {
            this(DefaultSchemePortResolver.INSTANCE, null);
        }

        @objid ("c97df159-2315-40ca-8964-abdc38b702a0")
        protected HttpHost getKey(final HttpHost host) {
            if (host.getPort() <= 0) {
                final int port;
                try {
                    port = this.schemePortResolver.resolve(host);
                } catch (final UnsupportedSchemeException ignore) {
                    return host;
                }
                return new HttpHost(host.getHostName(), port, host.getSchemeName());
            }
            return host;
        }

        @objid ("8d2fc011-4e7c-4875-a42d-f39c2f69fc80")
        @Override
        public void put(final HttpHost host, final AuthScheme authScheme) {
            Objects.requireNonNull(host, "HTTP host");
            if (authScheme == null) {
                return;
            }
            if (authScheme instanceof Serializable) {
                try {
                    final ByteArrayOutputStream buf = new ByteArrayOutputStream();
                    final ObjectOutputStream out = new ObjectOutputStream(buf);
                    out.writeObject(authScheme);
                    out.close();
                    this.map.put(getKey(host), buf.toByteArray());
                } catch (final IOException ex) {
                    this.log.warning("Unexpected I/O error while serializing auth scheme", ex);
                }
            } else {
               throw new IllegalArgumentException("Auth scheme " + authScheme.getClass() + " is not serializable");
            }
        }

        @objid ("b0ec54b0-742e-451d-8d5d-06b727e25a85")
        @Override
        public AuthScheme get(final HttpHost host) {
            Objects.requireNonNull(host, "HTTP host");
            final byte[] bytes = this.map.get(getKey(host));
            if (bytes != null) {
                try {
                    final ByteArrayInputStream buf = new ByteArrayInputStream(bytes);
                    @SuppressWarnings ("resource")
                    final ObjectInputStream in = new ObjectInputStreamWithLoader(buf, this.loader);
                    final AuthScheme authScheme = (AuthScheme) in.readObject();
                    in.close();
                    return authScheme;
                } catch (final IOException ex) {
                    this.log.warning("Unexpected I/O error while de-serializing auth scheme", ex);
                    return null;
                } catch (final ClassNotFoundException ex) {
                    this.log.warning("Unexpected error while de-serializing auth scheme", ex);
                    return null;
                }
            }
            return null;
        }

        @objid ("72142764-4b87-4d86-a456-9cd907a2e5a1")
        @Override
        public void remove(final HttpHost host) {
            Objects.requireNonNull(host, "HTTP host");
            this.map.remove(getKey(host));
        }

        @objid ("2a1a4a74-b5a4-4a6e-bc0b-04a5c1eb2324")
        @Override
        public void clear() {
            this.map.clear();
        }

        @objid ("ed2a59bf-ed37-45c9-8ab9-090bb6260f17")
        @Override
        public String toString() {
            return this.map.toString();
        }

    }

    /**
     * Adapter from {@link OidcAuthData} to Apache HTTP {@link Credentials}.
     *
     * @author cmarin
     * @since 5.2
     */
    @objid ("1d4a4b9f-bd0c-478d-b120-6541db315536")
    static class OidcCredentials implements Credentials {
        @objid ("72206676-33c7-4a70-b27b-2d33edad7033")
        private final OidcAuthData authData;

        @objid ("e7141898-cb78-4b38-b8e7-f90ddc8d208a")
        public OidcCredentials(OidcAuthData authData) {
            this.authData = authData;
        }

        @objid ("2b501a1f-33e7-4926-b5f0-096a1aba426f")
        @Override
        public Principal getUserPrincipal() {
            return new BasicUserPrincipal(this.authData.getUserId());
        }

        @objid ("f6f36c15-e826-4b40-a7e6-63a9618c730f")
        @Override
        public String getPassword() throws UncheckedIOException {
            try {
                return this.authData.getToken();
            } catch (IOException e) {
                throw new UncheckedIOException(FileUtils.getLocalizedMessage(e), e);
            }
        }

    }

    /**
     * This subclass of {@link ObjectInputStream} delegates loading of classes to
     * an existing {@link ClassLoader}.
     *
     * @since 5.5
     */
    @objid ("791cfeb4-deae-475d-978e-3a0a2640c0a6")
    public static class ObjectInputStreamWithLoader extends ObjectInputStream {
        @objid ("46d55778-6f33-46f4-a8fa-78e08d53f578")
        private final ClassLoader loader;

        /**
         * Loader must be non-null;
         *
         * @param in input stream to read from
         * @param loader the class loader to use to resolve classes
         * @throws StreamCorruptedException if the stream header is incorrect
         * @throws IOException if an I/O error occurs while reading stream header
         * @throws SecurityException if untrusted subclass illegally overrides
         *          security-sensitive methods
         * @throws NullPointerException if {@code in} is {@code null}
         */
        @objid ("fa39f2f2-269c-4c02-9b36-815bd3d7f47c")
        public ObjectInputStreamWithLoader(InputStream in, ClassLoader loader) throws IOException, StreamCorruptedException {
            super(in);
            Objects.requireNonNull(loader,"Illegal null 'loader' argument");

            this.loader = loader;
        }

        /**
         * Use the given ClassLoader rather than using the system class
         */
        @objid ("ecc7fd65-5802-4a2c-a7c1-4e293d70b6fb")
        @Override
        protected Class<?> resolveClass(ObjectStreamClass classDesc) throws IOException, ClassNotFoundException {
            String cname = classDesc.getName();
            try {
                return Class.forName(cname, false, this.loader);
            } catch (ClassNotFoundException e) {
                try {
                    // fall back to initial behavior
                    return super.resolveClass(classDesc);
                } catch (ClassNotFoundException e2) {
                    e.addSuppressed(e2);
                    throw e;
                }
            }
        }

    }

}

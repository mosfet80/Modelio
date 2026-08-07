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

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.CompletableFuture;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.vbasic.log.Log;

/**
 * Service to get the host name
 * <h2>Usage:</h2>
 * Use {@link #get()} to get the host name or {@link #getInstance()} to trigger background computation
 * <p>
 * <h2>Implementation notes:</h2>
 * {@link java.net.InetAddress#getCanonicalHostName()} is very long : 5 seconds on my machine !
 * To mitigate this the host name is computed and refined in a background task and refreshed if older than {@link #EXPIRE_DELAY}.
 *
 * @since 6.0.0
 */
@objid ("aa2b3533-2d9d-4a3d-90c2-2e993d0ae887")
public class HostName {
    @objid ("227a5a89-b6b2-4981-818b-3fe56418860e")
    private volatile String cachedHostName;

    @objid ("f9f0c7f0-42f8-4950-8232-5fc8660bf26a")
    private static final Duration EXPIRE_DELAY = Duration.ofMinutes(2);

    /**
     * The latest computed or being computed host name.
     */
    @objid ("a99ea1ec-1e39-4409-b24a-f9399fb2164e")
    private static volatile HostName latest;

    @objid ("6fd6672d-c27c-4274-87bc-34832fd0a317")
    private final Instant expirationTime;

    /**
     * A future that completes once the host name has been fully computed (or failed)
     */
    @objid ("4823204a-3f16-4b8f-8963-5ea09ab2add6")
    private final CompletableFuture<Void> computed;

    /**
     * Get a {@link HostName} service instance.
     * <p>
     * Triggers the background computation.
     *
     * @return the host name service
     */
    @objid ("7876da86-4cd7-4cd7-a7b4-4ee9c968050c")
    public static synchronized HostName getInstance() {
        Instant refreshTime = Instant.now();
        HostName previous = latest;
        if (previous != null && previous.expirationTime.isAfter(refreshTime))
            return previous;

        // Current latest absent or expired, create a new instance.
        HostName newHostName = previous != null ? new HostName(previous.cachedHostName): new HostName(null);
        latest = newHostName;
        return newHostName;
    }

    @objid ("f4e91100-1e14-44ec-912c-942f8689f1d4")
    private HostName(String initHostName) {
        this.expirationTime = Instant.now().plus(EXPIRE_DELAY);
        this.cachedHostName = initHostName;
        this.computed = CompletableFuture.runAsync( this::computeHostName);
    }

    /**
     * Get the host name as it is currently known.
     * <p>
     * If the host name has never being computed, wait for the end of computation. This may take many seconds.
     *
     * @return the host name
     */
    @objid ("b21dc4af-f674-4ccc-962b-6ba1254ad6dd")
    public static synchronized String get() {
        HostName h = getInstance();

        // Wait for the result only if we had no host name
        if (h.cachedHostName==null) {
            h.computed.join();
        }

        return h.cachedHostName;
    }

    @objid ("67a77dda-12a9-45fe-b1d9-8a68f152735e")
    private void computeHostName() {
        Instant start = Instant.now();
        try {
            InetAddress addr = InetAddress.getLocalHost();
            // first fast way
            if (this.cachedHostName == null) {
                this.cachedHostName = addr.getHostName();
            }
            // then expensive way
            this.cachedHostName = addr.getCanonicalHostName();

        } catch (UnknownHostException | RuntimeException ex) {
            this.cachedHostName = "Unknown host";
            Log.trace(ex);
        }

        // Perfs logging
        Instant end  = Instant.now();
        Duration len = Duration.between(start, end);
        if (len.getSeconds() >= 1) {
            Log.warning("Host name computation took %s (%s)", len, this.cachedHostName);
        } else {
            Log.trace("Host name computation took %s (%s)", len, this.cachedHostName);
        }
    }

}

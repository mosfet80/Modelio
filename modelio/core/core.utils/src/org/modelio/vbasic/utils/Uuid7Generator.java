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
package org.modelio.vbasic.utils;

import java.security.SecureRandom;
import java.util.HashSet;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.LongSupplier;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

/**
 * UUIDv7 generator: Factory for creating Unix epoch time-ordered unique identifiers.
 * <p>
 * UUIDv7 is a new UUID version proposed by Peabody and Davis. It is similar to
 * Prefix COMB GUID and ULID.
 * <p>
 * This factory creates only the Type 1 variant :
 * <p>
 * It is divided in 3 components, namely
 * time, counter and random. The counter component is incremented by 1 when the
 * time repeats. The random component is always randomized.
 * <p>
 * These kind of UUIDs are database indexes friendly, and more generally preferable
 * against UUID4 (random) UUIDs when they are stored in tree based structures.
 * <pre>
 *  0                   1                   2                   3
 *  0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1
 * +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
 * |                           unix_ts_ms                          |
 * +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
 * |          unix_ts_ms           |  ver  |       rand_a          |
 * +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
 * |var|                        rand_b                             |
 * +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
 * |                            rand_b                             |
 * +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
 * </pre>
 *
 * @author cmarin
 * @author Credits to https://github.com/f4b6a3/uuid-creator/
 * @see "https://www.rfc-editor.org/rfc/rfc9562#name-uuid-version-7"
 * @since 6.0.0 - not yet used
 * @deprecated Experimental, not yet used, may change without warning.
 */
@objid ("9b936df6-828b-42b6-9036-9c1cb8242a89")
@Deprecated(forRemoval = false)
public class Uuid7Generator {
    @objid ("d06d89fd-4b35-43a5-a5ba-cdb489313c8a")
    private static final long CLOCK_DRIFT_TOLERANCE = 10_000;

    @objid ("5991919c-dd6a-495d-9e65-ee17719a226f")
    private static final long versionBits = 0x000000000000f000L;

    @objid ("c98a0a65-16b9-4ccb-ba7a-68e27fe69577")
    private static final long variantBits = 0xc000000000000000L;

    @objid ("6cc94120-0ae8-49b6-bd45-727b1d6ac7b0")
    private static final long lower16Bits = 0x000000000000ffffL;

    @objid ("3faac97e-2270-4704-a9ee-600e8eeb8cda")
    private static final long upper16Bits = 0xffff000000000000L;

    @objid ("f37825ac-5a69-4af5-a76b-3884440b9bfe")
    protected static final long overflow = 0x0000000000000000L;

    @objid ("85a1ef6c-1dbd-4bb1-8503-7179fd9971a5")
    protected long msb = 0L;

    @objid ("c838a805-cb02-4feb-8ef1-f31c5b9ffab1")
    protected long lsb = 0L;

    @objid ("ca51c30d-5f23-495b-b15f-aef183508abd")
    protected final Random random;

    @objid ("448c2ce7-ed5a-4ae7-96f8-cbb58003c45b")
    protected final LongSupplier timeFunction;

    @objid ("06f70418-1b2e-47f1-b088-c255060a9352")
    protected final ReentrantLock lock = new ReentrantLock();

    /**
     * A default instance, returned by {@link #of()}
     */
    @objid ("08f58bad-c5f0-46e4-906f-166234c38efa")
    private static final Uuid7Generator defaultInstance = new Uuid7Generator(new SecureRandom(), () -> System.currentTimeMillis());

    @objid ("7c331bd8-0707-481d-b9b0-6cf79ecb1774")
    public static Uuid7Generator of() {
        return defaultInstance;
    }

    /**
     * Create a custom UUID7 generator
     *
     * @param random A random number generator
     * @param timeFunction a time function that return a milliseconds since Epoch as {@link System#currentTimeMillis()}c
     */
    @objid ("ce6504e7-71ae-463c-8220-36948a330129")
    public static Uuid7Generator of(Random random, LongSupplier timeFunction) {
        return new Uuid7Generator(random, timeFunction);
    }

    /**
     * Initialize a custom UUID7 generator.
     * <p>
     * To be used by instance factory or subclass.
     *
     * @param random A random number generator
     * @param timeFunction a time function that return a milliseconds since Epoch as {@link System#currentTimeMillis()}c
     */
    @objid ("eef6b82d-8810-4fc3-a5f2-370520c8d087")
    protected Uuid7Generator(Random random, LongSupplier timeFunction) {
        this.random = random;
        this.timeFunction = timeFunction;
    }

    /**
     * Creates a UUID from a pair of numbers.
     * <p>
     * It applies the version and variant numbers to the resulting UUID.
     *
     * @param msb the most significant bits
     * @param lsb the least significant bits
     * @return a UUID
     */
    @objid ("cf16e67b-091d-42dc-8bbe-b595ded35b87")
    protected UUID toUuid(final long msb, final long lsb) {
        final long versionMask = 7 << 12;
        final long msb0 = (msb & 0xffffffffffff0fffL) | versionMask; // set version
        final long lsb0 = (lsb & 0x3fffffffffffffffL) | 0x8000_0000_0000_0000L; // set variant
        return new UUID(msb0, lsb0);
    }

    /**
     * Generate an UUID V7.
     *
     * @return a new UUID .
     */
    @objid ("ac030abe-5c9a-49e8-80a7-817b316e579a")
    public UUID get() {
        this.lock.lock();
        try {

            final long lastTime = this.time();
            final long time = this.timeFunction.getAsLong();

            // Check if the current time is the same as the previous time or has moved
            // backwards after a small system clock adjustment or after a leap second.
            // Drift tolerance = (previous_time - 10s) < current_time <= previous_time
            if ((time > lastTime - CLOCK_DRIFT_TOLERANCE) && (time <= lastTime)) {
                increment();
            } else {
                reset(time);
            }

            return toUuid(this.msb, this.lsb);

        } finally {
            this.lock.unlock();
        }
    }

    @objid ("66b3883d-5045-43a2-8b7e-a2b57bd16986")
    void increment() {
        // add 2^48 to rand_b
        this.lsb = (this.lsb & upper16Bits);
        this.lsb = (this.lsb | variantBits) + (1L << 48);

        if (this.lsb == overflow) {
            // add 1 to rand_a if rand_b overflows
            this.msb = (this.msb | versionBits) + 1L;
        }

        // then randomize the lower 48 bits
        this.lsb |= this.random.nextLong() & (~upper16Bits);
    }

    @objid ("a3d7ef5a-e777-4c7c-ade3-32dbdcd844e7")
    long time() {
        return this.msb >>> 16;
    }

    @objid ("02293e34-f4ff-4d9a-a16b-bb987a0620f6")
    void reset(final long time) {
        this.msb = (time << 16) | (this.random.nextLong() & lower16Bits);
        this.lsb = this.random.nextLong();
    }

    /**
     * Test method
     *
     * @param args not used
     */
    @objid ("7d2caf4f-8951-4d8f-b5f1-94ec8fb436d4")
    public static void main(String[] args) {
        HashSet<UUID> bag = new HashSet<>(100000);
        for (int i=0; i < 100000; i++) {
            UUID uuid = of().get();
            System.out.println(uuid);
            if (! bag.add(uuid))
                throw new AssertionError("Duplicate !!!!" + uuid);
        }
    }

}

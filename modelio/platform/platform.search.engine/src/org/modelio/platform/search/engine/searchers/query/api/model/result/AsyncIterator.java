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
package org.modelio.platform.search.engine.searchers.query.api.model.result;

import java.util.concurrent.CompletableFuture;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

/**
 * An asynchronous iterator over a sequence of elements.
 * <p>
 * This interface is intended used to iterate over the results of a query execution,
 * which produce results asynchronously.
 *
 * @param <T> the type of elements returned by this iterator.
 */
@objid ("70dbb328-db90-40c2-8414-e5571a45c164")
public interface AsyncIterator<T> {
    /**
     *
     * @return the next element, or {@code null} if there is no more element or no element is ready.
     */
    @objid ("380fb24d-d47e-4bbc-8af7-27a07def547a")
    T next();

    /**
     * Tells whether there is a next element to come.
     * <p>
     * This method may return {@code true} even if the next element is not yet ready,
     * It will return {@code false} if there are no more elements to come.
     *
     * @code true} if there is more element to come, or {@code false} if the end of the iteration has been reached.
     */
    @objid ("1e900e01-80eb-4f4e-b369-f9cfea828035")
    boolean hasNext();

    /**
     * Waits for the next element to be ready, and returns it.
     * <p>
     * This method is intended to be used in asynchronous contexts, and will not block the calling thread.
     * Instead, it returns a future that will complete when the next element is ready.
     * <p>
     * The future will complete with {@code null} if there is no more element to come.
     *
     * @return a future that will complete when the next element is ready, or complete with {@code null} if there is no more element.
     */
    @objid ("3a71ba28-f189-45cb-b41f-026c38b03cfe")
    CompletableFuture<T> onNext();

}

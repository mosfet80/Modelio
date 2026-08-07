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
/**
 * MQL result model representing query execution outputs.
 * <p>
 * This package implements the result model defined in the MQL Technical Specification, Section 4 "Result model representation".
 * The result model provides structured representations of query results including:
 * <ul>
 * <li>Query responses with result items and diagnostics ({@link IQueryResponse})</li>
 * <li>Result items that can be simple nodes or nodes with explanation paths ({@link NodeWithExplainOut}, {@link MObjectItem})</li>
 * <li>Path explanations showing how nodes were reached ({@link PathOutput})</li>
 * <li>Path steps describing graph traversals ({@link PathStepOutput}, {@link LinkPathStepOutput}, {@link MDependencyPathStepOutput})</li>
 * <li>Diagnostic messages for warnings, errors, and information ({@link Diagnostic})</li>
 * </ul>
 * <p>
 *
 * @see org.modelio.platform.query.api.model.query for the query AST model
 */
package org.modelio.platform.search.engine.searchers.query.api.model.result;
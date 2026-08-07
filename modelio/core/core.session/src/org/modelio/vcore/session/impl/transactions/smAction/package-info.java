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
 * Package regroupant la gestion des actions. Permet le mécanisme du undo/redo.
 * Les actions sont regroupées dans des transactions, on peut valider, aborter une transaction.
 * Quand une transaction est termninée elle est sauvegardée dans la pile des transactions que l'on peut annuler "undo".
 * Quand une transaction é été annulée on la range dans la pile des actions rejouables "redo".
 * Chaque type action est représenté par une classe qui hérite de la classe Action.
 */
package org.modelio.vcore.session.impl.transactions.smAction;
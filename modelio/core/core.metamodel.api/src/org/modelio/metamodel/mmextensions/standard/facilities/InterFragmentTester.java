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
package org.modelio.metamodel.mmextensions.standard.facilities;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.uml.statik.AssociationEnd;
import org.modelio.metamodel.uml.statik.Classifier;
import org.modelio.metamodel.uml.statik.Instance;
import org.modelio.metamodel.uml.statik.LinkEnd;
import org.modelio.metamodel.uml.statik.NaryAssociation;
import org.modelio.metamodel.uml.statik.NaryAssociationEnd;
import org.modelio.metamodel.uml.statik.NaryLink;
import org.modelio.metamodel.uml.statik.NaryLinkEnd;
import org.modelio.vcore.smkernel.SmObjectImpl;

/**
 * Service that tells whether some buggy links relate conference fragment and local/SVN fragments.
 * <p>
 * In this case navigability changes must be blocked because with have issues guessing the right composition owner,
 * that can be solved only with a metamodel change.
 */
@objid ("1ad01007-69c6-4349-bd24-0e25817bdd70")
public class InterFragmentTester {
    @objid ("17fca2a1-6a6e-4924-9d44-a6af3f35d07a")
    public static boolean isAffected(AssociationEnd role) {
        AssociationEnd opp = role.getOpposite();
        if (opp == null)
            return false;

        // The source classifier is the current source or the opposite end's target according to the old navigability
        Classifier source = role.getSource() != null ? role.getSource() : opp.getTarget();

        // The target classifier is the opposite end's source or the current target according to the old navigability
        Classifier target = opp.getSource() != null ? opp.getSource() : role.getTarget();


        byte roleRid = ((SmObjectImpl)source).getRepositoryObject().getRepositoryId();
        byte oppRid = ((SmObjectImpl)target).getRepositoryObject().getRepositoryId();
        if (roleRid==oppRid)
            return false;

        return source.getStatusLazy().isPersistedRemotely() || target.getStatusLazy().isPersistedRemotely();
    }

    @objid ("1a23e134-1824-401c-8ff9-7275dfe73db2")
    public static boolean isAffected(NaryAssociation assoc) {
        byte assocRid = ((SmObjectImpl)assoc).getRepositoryObject().getRepositoryId();

        List<NaryAssociationEnd> ends = assoc.getNaryEnd();
        if (ends.size() < 2)
            return false;

        boolean assocPersistedRemotely = assoc.getStatusLazy().isPersistedRemotely();
        for (NaryAssociationEnd role : ends) {
            byte roleRid = ((SmObjectImpl) role.getOwner()).getRepositoryObject().getRepositoryId();
            if (roleRid == assocRid)
                continue;

            if (assocPersistedRemotely || role.getStatusLazy().isPersistedRemotely())
                return true;
        }

        return false;
    }

    @objid ("f17211e6-c792-48dd-a684-ac4920e4395e")
    public static boolean isAffected(NaryLink assoc) {
        byte assocRid = ((SmObjectImpl)assoc).getRepositoryObject().getRepositoryId();

        List<NaryLinkEnd> ends = assoc.getNaryLinkEnd();
        if (ends.size() < 2)
            return false;

        boolean assocPersistedRemotely = assoc.getStatusLazy().isPersistedRemotely();
        for (NaryLinkEnd role : ends) {
            Instance source = role.getSource();
            byte roleRid = ((SmObjectImpl) source).getRepositoryObject().getRepositoryId();
            if (roleRid == assocRid)
                continue;

            if (assocPersistedRemotely || source.getStatusLazy().isPersistedRemotely())
                return true;
        }

        return false;
    }

    @objid ("9a5e8afb-4813-4256-98eb-169970999030")
    public static boolean isAffected(LinkEnd role) {
        LinkEnd opp = role.getOpposite();
        if (opp == null)
            return false;

        // The source classifier is the current source or the opposite end's target according to the old navigability
        Instance source = role.getSource() != null ? role.getSource() : opp.getTarget();

        // The target classifier is the opposite end's source or the current target according to the old navigability
        Instance target = opp.getSource() != null ? opp.getSource() : role.getTarget();


        byte roleRid = ((SmObjectImpl)source).getRepositoryObject().getRepositoryId();
        byte oppRid = ((SmObjectImpl)target).getRepositoryObject().getRepositoryId();
        if (roleRid==oppRid)
            return false;

        return source.getStatusLazy().isPersistedRemotely() || target.getStatusLazy().isPersistedRemotely();
    }

}

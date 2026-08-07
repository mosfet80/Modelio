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
package org.modelio.diagram.editor.layout.algorithme.elk.utils;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.elk.core.data.ILayoutMetaDataProvider;
import org.eclipse.elk.core.data.LayoutMetaDataService;

@objid ("01920140-0247-4714-b200-130e95abdbb4")
public class ElkLibraryLoader {
    @objid ("4aed7fd0-7f7e-493c-a841-f326e53cb61f")
    private static final String _forceOptions = "org.eclipse.elk.alg.force.options.ForceOptions";

    @objid ("f3cac76b-411b-435c-acd5-3b9da85de1e4")
    private static final String _forceProvider = "org.eclipse.elk.alg.force.options.ForceMetaDataProvider";

    @objid ("373eba27-e009-415e-8de7-331128d2fa69")
    private static final String _stressOptions = "org.eclipse.elk.alg.force.options.StressOptions";

    @objid ("ce854af9-6c21-458b-ac0f-9850ab30ae9b")
    private static final String _stressProvider = "org.eclipse.elk.alg.force.options.StressMetaDataProvider";

    @objid ("97c7a9b3-ec2b-42ba-8daf-f53ab7b32a48")
    private static final String _layeredOptions = "org.eclipse.elk.alg.layered.options.LayeredOptions";

    @objid ("c6a48c91-17c0-44d9-ae76-3134360c0083")
    private static final String _layeredProvider = "org.eclipse.elk.alg.layered.options.LayeredMetaDataProvider";

    @objid ("f19c2f1d-7da4-40d0-b01e-50df97b54bae")
    private static final String _treeOptions = "org.eclipse.elk.alg.mrtree.options.MrTreeOptions";

    @objid ("3cacef84-c0b9-4d4a-8a38-5a2f3643b5d1")
    private static final String _treeProvider = "org.eclipse.elk.alg.mrtree.options.MrTreeMetaDataProvider";

    @objid ("4dc01492-210f-446f-9298-12f879c6c744")
    private static final String _draw2DOptions = "org.eclipse.elk.alg.force.options.StressOptions";

    @objid ("aa771e6b-b994-425c-9a6d-002cb0198723")
    private static final String _draw2DProvider = "org.eclipse.elk.conn.gmf.layouter.Draw2DLayoutProvider";

    @objid ("2547e5f5-df8d-45de-b544-24cd66ceae31")
    private static final String _discoOptions = "org.eclipse.elk.alg.disco.options.DisCoOptions";

    @objid ("b67a974a-3019-4e69-8e72-7f077111e5e6")
    private static final String _discoProvider = "org.eclipse.elk.alg.disco.options.DisCoMetaDataProvider";

    @objid ("db0b7423-711f-48d3-a36d-36b51ca972d2")
    private static final String _radialOptions = "org.eclipse.elk.alg.radial.options.RadialOptions";

    @objid ("bd8d53c0-3ea0-4bd4-8de1-400ad34ebe66")
    private static final String _radialProvider = "org.eclipse.elk.alg.radial.options.RadialMetaDataProvider";

    @objid ("4974e713-2421-4026-9faf-c1489d108797")
    private static final String _rectPackOptions = "org.eclipse.elk.alg.rectpacking.options.RectPackingOptions";

    @objid ("f9266d6b-ab11-46d9-9a04-ef5e1b064933")
    private static final String _rectPackProvider = "org.eclipse.elk.alg.rectpacking.options.RectPackingMetaDataProvider";

    @objid ("b4256547-ae6b-4233-bc1a-39dcfe9e2ca9")
    private static final String _sporeCompOptions = "org.eclipse.elk.alg.spore.options.SporeCompactionOptions";

    @objid ("13c5f6dc-a682-4e5b-b2d4-05bbfe91dab5")
    private static final String _sporeCompProvider = "org.eclipse.elk.alg.spore.options.SporeMetaDataProvider";

    @objid ("b1b2fa5e-308e-4cfd-8baa-d178f98a7216")
    private static final String _sporeOverlapOptions = "org.eclipse.elk.alg.spore.options.SporeOverlapRemovalOptions";

    @objid ("9a36495b-b5a6-498d-b3e3-260c3e829836")
    private static final String _sporeOverlapProvider = "org.eclipse.elk.alg.spore.options.SporeOverlapRemovalOptions";

    @objid ("ad08c2ae-222c-4a60-97fe-24520f7a7cbb")
    private static final String _topDownPackOptions = "org.eclipse.elk.alg.topdownpacking.options.TopdownpackingOptions";

    @objid ("b5de2839-83fd-4f79-9fb6-324408ca72f8")
    private static final String _topDownPackProvider = "org.eclipse.elk.alg.topdownpacking.options.TopdownpackingMetaDataProvider";

    @objid ("fc8e76c1-940d-442e-b323-e1761598e3a5")
    public static void loadElk() {
        List<String> classNames = new ArrayList<String>();

        // MrTree
        classNames.add(_treeProvider);
        classNames.add(_treeOptions);

        // Layered
        classNames.add(_layeredProvider);
        classNames.add(_layeredOptions);

        // Stress
        classNames.add(_stressProvider);
        classNames.add(_stressOptions);

        // Force
        classNames.add(_forceProvider);
        classNames.add(_forceOptions);

        // Disco
        classNames.add(_discoOptions);
        classNames.add(_discoProvider);

        // Radial
        classNames.add(_radialOptions);
        classNames.add(_radialProvider);

        // Rectangle packing
        classNames.add(_rectPackOptions);
        classNames.add(_rectPackProvider);

        // Spore Compaction
        classNames.add(_sporeCompOptions);
        classNames.add(_sporeCompProvider);

        // Spore Overlap
        classNames.add(_sporeOverlapOptions);
        classNames.add(_sporeOverlapProvider);

        // Top Down Packing
        classNames.add(_topDownPackOptions);
        classNames.add(_topDownPackProvider);

        for (String className : classNames) {

        try {

        LayoutMetaDataService layout = LayoutMetaDataService.getInstance();

        // Charger la classe dynamiquement
        Class<?> clazz = Class.forName(className);

        java.util.ServiceLoader.load(clazz, null);
        Object instance = clazz.getDeclaredConstructor().newInstance();
        layout.registerLayoutMetaDataProviders((ILayoutMetaDataProvider) instance);

        } catch (ClassNotFoundException e) {
        System.err.println("Classe non trouvée : " + e.getMessage());
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException
        | InvocationTargetException e) {
        System.err.println("Erreur lors de l'instanciation ou de l'appel de la méthode : " + e.getMessage());
        }
        }
    }

}

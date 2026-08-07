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
package org.modelio.audit.checker;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import jakarta.inject.Inject;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.modelio.audit.checker.actions.AuditSeverityAction;
import org.modelio.audit.checker.actions.DisableRuleHandlerAction;
import org.modelio.audit.checker.actions.SelectInExplorerAction;
import org.modelio.audit.checker.actions.ShowDetailsAction;
import org.modelio.audit.plugin.Audit;
import org.modelio.audit.service.IAuditService;
import org.modelio.audit.view.AuditPanelProvider;
import org.modelio.audit.view.providers.AuditProviderFactory.AuditViewMode;
import org.modelio.metamodel.mmextensions.standard.services.IMModelServices;
import org.modelio.platform.core.navigate.IModelioNavigationService;
import org.modelio.platform.model.ui.swt.InputHelper;
import org.modelio.platform.project.services.IProjectService;
import org.modelio.platform.ui.panel.IPanelProvider;
import org.modelio.vcore.smkernel.mapi.MObject;

@objid ("d109acb9-8b82-49bc-ad6c-1ffe1897d4e2")
public class CheckerPanelProvider implements IPanelProvider {
    @objid ("68a5e4bb-9868-46d4-8af1-a1d0d04cba5f")
    private String jobId;

    @objid ("e1b1c580-b265-4add-b9ef-7ebb35a9e36c")
    @Inject
    @Optional
    private MApplication application;

    @objid ("169f9ef1-47ef-4c6d-a0b8-d16f5978601e")
    @Inject
    @Optional
    private EModelService emService;

    @objid ("2484da5b-5821-427f-b213-ae679e64da06")
    private Button byElementButton;

    @objid ("5177f627-65c3-4ed7-9a06-956558edb95b")
    private Button byListButton;

    @objid ("bd6cb92f-8c50-4f3f-9f8d-2c0ea5ab4764")
    private Button byRuleButton;

    @objid ("660ef593-4b65-4b9f-9e3a-113930c614f4")
    private Button byTypeButton;

    @objid ("a13332f3-94cb-4f63-b14e-fdc90df69f14")
    private Composite rootComposite;

    @objid ("6e220856-42cc-43c8-bd0f-909f5924e0f3")
    private AuditPanelProvider auditPanel;

    @objid ("47a28aa2-f0b4-4dc9-9eb8-c39d068de1b4")
    @Inject
    @Optional
    private IAuditService auditService;

    @objid ("b300eafd-8ea4-4289-b3f4-97a8d6096886")
    private List<MObject> input;

    @objid ("3186ae38-056b-40f1-972b-a0e417dbe8d5")
    @Inject
    @Optional
    private IMModelServices modelService;

    @objid ("dd430258-a902-4fce-a087-009382e941a0")
    @Inject
    @Optional
    private IModelioNavigationService navigationService;

    @objid ("8de8d61e-850b-4ac3-9bbd-3923394df46f")
    @Inject
    @Optional
    private IProjectService projectService;

    @objid ("106b1506-22a7-4fae-ba45-39f2736da135")
    public CheckerPanelProvider() {

    }

    @objid ("44301568-bd03-4fd8-acef-96576f6c51ea")
    @Override
    public Object createPanel(Composite parent) {
        // This will dispose the images when closing the panel
        LocalResourceManager resMan = new LocalResourceManager(JFaceResources.getResources(parent.getDisplay()), parent);

        this.jobId = UUID.randomUUID().toString();
        this.auditPanel = new AuditPanelProvider(
                this.auditService, this.projectService.getSession(), this.modelService,
                this.navigationService, this.application, this.emService);

        this.rootComposite = new Composite(parent, SWT.NONE);
        GridData gd = new GridData();
        gd.horizontalAlignment = SWT.FILL;
        gd.verticalAlignment = SWT.FILL;
        gd.grabExcessHorizontalSpace = true;
        gd.grabExcessVerticalSpace = true;
        this.rootComposite.setLayoutData(gd);
        this.rootComposite.setLayout(new GridLayout(4, false));

        this.byTypeButton = new Button(this.rootComposite, SWT.TOGGLE);
        this.byTypeButton.setImage(resMan.get(Audit.getImageDescriptor("icons/layoutbytype.png")));

        this.byTypeButton.addListener(SWT.Selection, ev -> {
            this.auditPanel.setViewMode(AuditViewMode.BYTYPE);
            this.byRuleButton.setSelection(false);
            this.byElementButton.setSelection(false);
            this.byListButton.setSelection(false);

        });
        this.byTypeButton.setSelection(true);

        this.byRuleButton = new Button(this.rootComposite, SWT.TOGGLE);
        this.byRuleButton.setImage(resMan.get(Audit.getImageDescriptor("icons/layoutbyrule.png")));

        this.byRuleButton.addListener(SWT.Selection, ev -> {
            this.auditPanel.setViewMode(AuditViewMode.BYRULE);
            this.byTypeButton.setSelection(false);
            this.byElementButton.setSelection(false);
            this.byListButton.setSelection(false);
        });


        this.byElementButton = new Button(this.rootComposite, SWT.TOGGLE);
        this.byElementButton.setImage(resMan.get(Audit.getImageDescriptor("icons/layoutbyelement.png")));

        this.byElementButton.addListener(SWT.Selection, ev -> {
            this.auditPanel.setViewMode(AuditViewMode.BYELEMENT);
            this.byTypeButton.setSelection(false);
            this.byRuleButton.setSelection(false);
            this.byListButton.setSelection(false);
        });

        this.byListButton = new Button(this.rootComposite, SWT.TOGGLE);
        this.byListButton.setImage(resMan.get(Audit.getImageDescriptor("icons/layoutflat.png")));

        this.byListButton.addListener(SWT.Selection, ev -> {
            this.auditPanel.setViewMode(AuditViewMode.FLAT);
            this.byTypeButton.setSelection(false);
            this.byRuleButton.setSelection(false);
            this.byElementButton.setSelection(false);
        });



        this.auditPanel.createPanel(this.rootComposite);
        gd = new GridData();
        gd.horizontalSpan = 6;
        gd.horizontalAlignment = SWT.FILL;
        gd.grabExcessHorizontalSpace = true;
        gd.verticalAlignment = SWT.FILL;
        gd.grabExcessVerticalSpace = true;
        this.auditPanel.getPanel().setLayoutData(gd);

        this.auditPanel.setInput(this.auditService.getAuditEngine().getAuditDiagnostic());

        initContextMenu();
        return this.rootComposite;
    }

    @objid ("892d6ff0-3650-41d2-bbcc-2941e23f5f1d")
    @Override
    public void dispose() {
        this.auditService.interuptCheck(this.jobId);
        this.auditPanel.dispose();
    }

    @objid ("a83365ee-8848-4ff9-b3c5-18efaa1f82e9")
    public AuditPanelProvider getAuditPanel() {
        return this.auditPanel;
    }

    @objid ("2b25c80e-5b3f-4014-ad7d-18014d699194")
    @Override
    public String getHelpTopic() {
        return Audit.I18N.getString("CheckerPanelProvider.HelpId");
    }

    @objid ("502adaa9-c837-4e3d-809a-75afbc81b3e2")
    @Override
    public Object getInput() {
        return this.input;
    }

    @objid ("c8d34d25-0388-4cf0-8e65-826cdbff1d24")
    @Override
    public Object getPanel() {
        return this.rootComposite;
    }

    @objid ("e374641e-7342-40b6-9ccb-e86a2053bf49")
    @Override
    public boolean isRelevantFor(Object obj) {
        return InputHelper.contains(obj, MObject.class);
    }

    @objid ("64278a24-d758-439c-a27f-05a78a249a7b")
    public void setApplication(MApplication application) {
        this.application = application;
    }

    @objid ("5d6bc26e-7708-4530-8173-9e69209fbc5a")
    public void setAuditService(IAuditService auditService) {
        this.auditService = auditService;
    }

    @objid ("826f3c54-42e0-47ad-b064-b18116eac958")
    public void setEmService(EModelService emService) {
        this.emService = emService;
    }

    @objid ("a695f1ee-e0e2-4295-87cf-050d99488846")
    @Override
    public void setInput(Object input) {
        List<MObject> newInput = InputHelper.toList(input, MObject.class);

        // Because set input launches a background asynchronous process, better to avoid launching several instances for the same input.
        // Furthermore, in the case of the checker panel the audit process can fire a status change event which in turn will re-set
        // this input leading to a loop without the guard coded below.
        if (Objects.equals(this.input, newInput)) {
            return;
        }

        this.input = newInput;
        this.auditPanel.setScope(newInput, this.jobId);

        if (! newInput.isEmpty()) {
            this.auditService.checkElementTree(newInput, this.jobId);
        } else {
            this.auditService.interuptCheck(this.jobId);
        }
    }

    @objid ("b2171e31-c1e5-46f3-b01c-ff6fcdde325e")
    public void setModelService(IMModelServices modelService) {
        this.modelService = modelService;
    }

    @objid ("4931c70f-4887-4677-8a71-b33fb2cba5fc")
    public void setNavigationService(IModelioNavigationService navigationService) {
        this.navigationService = navigationService;
    }

    @objid ("b3da36c0-6983-4a37-9897-67466e6d8cba")
    public void setProjectService(IProjectService projectService) {
        this.projectService = projectService;
    }

    @objid ("6b242d1d-b598-463a-a0e2-f62417c51b33")
    private void initContextMenu() {
        // initialize the context menu
        MenuManager menuMgr = new MenuManager("#PopupMenu"); //$NON-NLS-1$
        menuMgr.setRemoveAllWhenShown(true);
        menuMgr.addMenuListener(manager -> {
            TreeViewer treeViewer = this.auditPanel.getTreeViewer();
            Tree swtTree = treeViewer.getTree();

            manager.add(new SelectInExplorerAction(this.navigationService, treeViewer));
            manager.add(new ShowDetailsAction(this.auditService, this.projectService, this.navigationService, treeViewer));
            manager.add(new AuditSeverityAction("AuditAdvice",  this.auditService, swtTree));
            manager.add(new AuditSeverityAction("AuditWarning", this.auditService, swtTree));
            manager.add(new AuditSeverityAction("AuditError",   this.auditService, swtTree));
            manager.add(new DisableRuleHandlerAction(this.auditService, swtTree));
        });

        Tree swtTree = this.auditPanel.getTreeViewer().getTree();
        swtTree.setMenu(menuMgr.createContextMenu(swtTree));
    }

}

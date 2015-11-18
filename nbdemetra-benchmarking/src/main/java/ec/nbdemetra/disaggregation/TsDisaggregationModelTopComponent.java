/*
 * Copyright 2013 National Bank of Belgium
 *
 * Licensed under the EUPL, Version 1.1 or – as soon they will be approved 
 * by the European Commission - subsequent versions of the EUPL (the "Licence");
 * You may not use this work except in compliance with the Licence.
 * You may obtain a copy of the Licence at:
 * 
 * http://ec.europa.eu/idabc/eupl
 * 
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the Licence is distributed on an "AS IS" basis,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the Licence for the specific language governing permissions and 
 * limitations under the Licence.
 */
package ec.nbdemetra.disaggregation;

import ec.nbdemetra.ui.NbUtilities;
import ec.nbdemetra.ws.WorkspaceFactory;
import ec.nbdemetra.ws.WorkspaceItem;
import ec.nbdemetra.ws.ui.WorkspaceTopComponent;
import ec.tss.disaggregation.documents.TsDisaggregationModelDocument;
import ec.ui.view.tsprocessing.RegTsProcessingViewer;
import org.netbeans.api.settings.ConvertAsProperties;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.util.NbBundle;
import org.openide.windows.TopComponent;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(dtd = "-//ec.nbdemetra.disaggregation//TsDisaggregationModel//EN",
        autostore = false)
@TopComponent.Description(preferredID = "TsDisaggregationModelTopComponent",
        //iconBase="SET/PATH/TO/ICON/HERE", 
        persistenceType = TopComponent.PERSISTENCE_NEVER)
@TopComponent.Registration(mode = "editor", openAtStartup = false)
//@ActionID(category = "Temporal Disaggregation", id = "ec.nbdemetra.disaggregation.TsDisaggregationModelTopComponent")
//@ActionReference(path = "Menu/Statistical methods/Temporal Disaggregation", position = 1000)
//@TopComponent.OpenActionRegistration(displayName = "#CTL_TsDisaggregationModelAction")
@NbBundle.Messages({
    "CTL_TsDisaggregationModelAction=Regression Model",
    "CTL_TsDisaggregationModelTopComponent=Regression Model Window",
    "HINT_TsDisaggregationModelTopComponent=This is a Regression Model window"
})
public final class TsDisaggregationModelTopComponent extends WorkspaceTopComponent<TsDisaggregationModelDocument> {

    protected RegTsProcessingViewer panel;

    public TsDisaggregationModelTopComponent() {
        super(null);
        //initDocument();
    }

    public TsDisaggregationModelTopComponent(WorkspaceItem<TsDisaggregationModelDocument> doc) {
        super(doc);
        initDocument();
    }

    public void initDocument() {
        setName(getDocument().getDisplayName());
        setToolTipText(Bundle.HINT_TsDisaggregationModelTopComponent());
        initComponents();
        panel = RegTsProcessingViewer.create(this.getDocument().getElement());
        add(panel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(new java.awt.BorderLayout());
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    @Override
    public void componentOpened() {
        super.componentOpened();
        if (panel != null) {
            panel.doLayout();
        }
    }

    @Override
    public void componentClosed() {
        // TODO add custom code on component closing
        super.componentClosed();
        if (panel != null) {
            panel.dispose();
        }
    }

    void writeProperties(java.util.Properties p) {
        // better to version settings since initial version as advocated at
        // http://wiki.apidesign.org/wiki/PropertyFiles
        p.setProperty("version", "1.0");
        // TODO store your settings
    }

    void readProperties(java.util.Properties p) {
        String version = p.getProperty("version");
        // TODO read your settings according to their version
    }

    @Override
    protected String getContextPath() {
        return TsDisaggregationModelManager.CONTEXTPATH;
    }

    public void editNote() {
        TsDisaggregationModelDocument element = getDocument().getElement();
        NbUtilities.editNote(element);
    }
}

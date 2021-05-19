package com.bsoft.workflow.entity.primary;

import java.io.Serializable;
import java.util.Map;

public class BpmnModelDO{
    private String bpmnString;
    private Map panel;
    private Map label;
    private Map flow;

    public String getBpmnString() {
        return bpmnString;
    }

    public void setBpmnString(String bpmnString) {
        this.bpmnString = bpmnString;
    }

    public Map getPanel() {
        return panel;
    }

    public void setPanel(Map panel) {
        this.panel = panel;
    }

    public Map getLabel() {
        return label;
    }

    public void setLabel(Map label) {
        this.label = label;
    }

    public Map getFlow() {
        return flow;
    }

    public void setFlow(Map flow) {
        this.flow = flow;
    }
}

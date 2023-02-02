package com.crm.Crm.enumeration;

public enum OpportunityStageEnum {
    QALIFICATION("qualification"),
    MEETING_SCHEDULED("meeting scheduled"),
    PROPOSAL("proposal"),
    NEGOCIATION("negociation"),
    CLOSED("closed");

    private final String label;

    OpportunityStageEnum(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}

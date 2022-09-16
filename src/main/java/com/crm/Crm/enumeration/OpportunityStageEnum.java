package com.crm.Crm.enumeration;

public enum OpportunityStageEnum {
    QALIFICATION("qualification"),
    MEETING_SCHEDULED("meeting scheduled"),
    PROPOSAL("proposal"),
    NEGOCIATION("negociation"),
    CLOSED("closed");

    public String label;

    OpportunityStageEnum(String label) {
        this.label = label;
    }
}

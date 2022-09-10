package com.crm.Crm.enumeration;

public enum ContactSortFields {
    FIRST_NAME("firstName"),
    LAST_NAME("lastName");

    public final String label;

    ContactSortFields(String label) {
        this.label = label;
    }
}

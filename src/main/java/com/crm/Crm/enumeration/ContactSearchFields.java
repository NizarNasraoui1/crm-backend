package com.crm.Crm.enumeration;

public enum ContactSearchFields {
    FIRST_NAME("firstName"),
    LAST_NAME("lastName");

    public final String label;

    ContactSearchFields(String label) {
        this.label = label;
    }
}

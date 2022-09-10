package com.crm.Crm.enumeration;

public enum ContactSearchFields {
    FIRST_NAME("firstName","First Name"),
    LAST_NAME("lastName","LastName");

    public final String label;
    public final String name;

    ContactSearchFields(String name,String label) {
        this.label = label;
        this.name= name;
    }
}

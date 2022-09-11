package com.crm.Crm.enumeration;

public enum ContactSortFields {
    MODIFY_DATE("modifyDate","Last Modification"),
    FIRST_NAME("firstName","First Name"),
    LAST_NAME("lastName","LastName");

    public final String label;
    public final String name;

    ContactSortFields(String name,String label) {
        this.label = label;
        this.name= name;
    }
}

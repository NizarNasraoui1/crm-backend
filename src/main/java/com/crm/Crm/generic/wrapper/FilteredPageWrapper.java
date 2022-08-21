package com.crm.Crm.generic.wrapper;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Collection;

@Data
@AllArgsConstructor
public class FilteredPageWrapper<T> {
    private int count;
    private Collection<T>results;
}

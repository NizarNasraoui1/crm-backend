package com.crm.Crm.generic;

import java.util.List;

public interface PagingAndFilteringRepo<T> {
    public List<T> getFilteredPage(int page, int rows, String searchWord, List<String> searchFields, String sortField);
}

package com.docvault.dto;

import java.util.List;
import java.util.Map;

public class SearchResponseDto {
    private List<SearchResultItem>               results;
    private long                                 count;
    private Map<String, List<Map<String, Object>>> facets;

    public List<SearchResultItem>               getResults()  { return results; }
    public void setResults(List<SearchResultItem> v)          { this.results = v; }
    public long                                 getCount()    { return count; }
    public void setCount(long v)                              { this.count = v; }
    public Map<String, List<Map<String, Object>>> getFacets() { return facets; }
    public void setFacets(Map<String, List<Map<String, Object>>> v) { this.facets = v; }
}

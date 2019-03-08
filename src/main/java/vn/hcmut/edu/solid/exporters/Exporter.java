package vn.hcmut.edu.solid.exporters;

import vn.hcmut.edu.solid.SearchResult;

public abstract class Exporter {
    protected SearchResult searchResult;

    public SearchResult getSearchResult() {
        return searchResult;
    }

    public void setSearchResult(SearchResult searchResult) {
        this.searchResult = searchResult;
    }

    public abstract String export();
}

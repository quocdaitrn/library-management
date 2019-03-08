package vn.hcmut.edu.solid.printers;

import com.itextpdf.text.DocumentException;
import vn.hcmut.edu.solid.SearchResult;

import java.io.IOException;

public abstract class Printer {
    protected SearchResult searchResult;

    public SearchResult getSearchResult() {
        return searchResult;
    }

    public void setSearchResult(SearchResult searchResult) {
        this.searchResult = searchResult;
    }

    public abstract void print() throws IOException, DocumentException;
}

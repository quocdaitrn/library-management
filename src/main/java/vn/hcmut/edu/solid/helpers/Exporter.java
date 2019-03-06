package vn.hcmut.edu.solid.helpers;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;
import vn.hcmut.edu.solid.SearchResult;
import vn.hcmut.edu.solid.items.LibItem;

public class Exporter {
    private SearchResult searchResult;

    public Exporter(SearchResult searchResult) {
        this.searchResult = searchResult;
    }

    public String toJson() {
        if (this.searchResult == null) {
            return null;
        }

        return new Gson().toJson(this.searchResult.getList());
    }

    public String toXML() {
        if (this.searchResult == null) {
            return null;
        }

        XStream xstream = new XStream();
        xstream.alias("Item", LibItem.class);
        xstream.alias("Items", SearchResult.class);
        xstream.addImplicitCollection(SearchResult.class, "list");

        return xstream.toXML(searchResult);
    }

    public SearchResult getSearchResult() {
        return searchResult;
    }

    public void setSearchResult(SearchResult searchResult) {
        this.searchResult = searchResult;
    }
}

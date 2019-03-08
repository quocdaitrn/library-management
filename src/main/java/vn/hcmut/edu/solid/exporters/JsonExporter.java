package vn.hcmut.edu.solid.exporters;

import com.google.gson.Gson;
import org.apache.commons.lang3.StringUtils;
import vn.hcmut.edu.solid.SearchResult;

public class JsonExporter extends Exporter {

    public JsonExporter(SearchResult searchResult) {
        this.searchResult = searchResult;
    }

    @Override
    public String export() {
        if (this.searchResult == null) {
            return StringUtils.EMPTY;
        }

        return new Gson().toJson(this.searchResult.getList());
    }
}

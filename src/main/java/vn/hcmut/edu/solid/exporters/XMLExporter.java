package vn.hcmut.edu.solid.exporters;

import com.thoughtworks.xstream.XStream;
import org.apache.commons.lang3.StringUtils;
import vn.hcmut.edu.solid.SearchResult;
import vn.hcmut.edu.solid.items.LibItem;

public class XMLExporter extends Exporter {

    public XMLExporter(SearchResult searchResult) {
        this.searchResult = searchResult;
    }

    @Override
    public String export() {
        if (this.searchResult == null) {
            return StringUtils.EMPTY;
        }

        XStream xstream = new XStream();
        xstream.alias("Item", LibItem.class);
        xstream.alias("Items", SearchResult.class);
        xstream.addImplicitCollection(SearchResult.class, "list");

        return xstream.toXML(searchResult);
    }
}

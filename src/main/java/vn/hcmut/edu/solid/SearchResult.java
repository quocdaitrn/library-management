package vn.hcmut.edu.solid;

import vn.hcmut.edu.solid.items.LibItem;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class SearchResult {
    private List<LibItem> list;

    public SearchResult(List<LibItem> result) {
        this.list = result;
    }

    public List<LibItem> getList() {
        return list;
    }

    public void sortBy(Function<LibItem, String> func) {
        list.sort(Comparator.comparing(func));
    }
}

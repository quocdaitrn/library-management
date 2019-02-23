package vn.hcmut.edu.solid.helpers;

import vn.hcmut.edu.solid.items.Book;
import vn.hcmut.edu.solid.items.LibItem;

public abstract class Exporter {
    private LibItem item;

    public Exporter(LibItem item) {
        this.item = item;
    }

    public LibItem getItem() {
        return item;
    }

    public void setItem(Book item) {
        this.item = item;
    }

    public abstract String toJson(int pageNum);

    public abstract String toXML(int pageNum);
}

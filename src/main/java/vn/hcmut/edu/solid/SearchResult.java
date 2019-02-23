package vn.hcmut.edu.solid;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import vn.hcmut.edu.solid.helpers.Printer;
import vn.hcmut.edu.solid.items.Book;
import vn.hcmut.edu.solid.items.LibItem;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class SearchResult {
    private List<LibItem> list;

    public SearchResult(List<LibItem> result) {
        this.list = result;
    }

    public List<LibItem> getList() {
        return list;
    }

    public List<LibItem> sortByDate() {
        return null;
    }
}

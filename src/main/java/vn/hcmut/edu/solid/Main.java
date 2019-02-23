package vn.hcmut.edu.solid;

import com.itextpdf.text.DocumentException;
import vn.hcmut.edu.solid.helpers.Display;
import vn.hcmut.edu.solid.items.Book;
import vn.hcmut.edu.solid.items.LibItem;
import vn.hcmut.edu.solid.items.Magazine;

import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        LibItem book1 = new Book("Toi thay hoa vang tren co xanh", "Nguyen Nhat Anh", "Thanh nien", "2015");
        LibItem book2 = new Book("Oxford thuong yeu", "Duong Thuy", "Van Hoa", "2010");
        LibItem magazine1 = new Magazine("Muc tim", "Van Hoa", "2019");

        SearchResult searchResult = new SearchResult(Arrays.asList(book1, book2, magazine1));
        Display display = new Display(searchResult);
        try {
            display.showList();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}

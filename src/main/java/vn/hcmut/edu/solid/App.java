package vn.hcmut.edu.solid;

import com.itextpdf.text.DocumentException;
import vn.hcmut.edu.solid.exporters.Exporter;
import vn.hcmut.edu.solid.exporters.JsonExporter;
import vn.hcmut.edu.solid.exporters.XMLExporter;
import vn.hcmut.edu.solid.items.Book;
import vn.hcmut.edu.solid.items.LibItem;
import vn.hcmut.edu.solid.items.Magazine;
import vn.hcmut.edu.solid.printers.PDFPrinter;
import vn.hcmut.edu.solid.printers.Printer;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        LibItem book1 = new Book("Toi thay hoa vang tren co xanh", "Nguyen Nhat Anh", "Thanh nien", 2010);
        LibItem book2 = new Book("Oxford thuong yeu", "Duong Thuy", "Van Hoa", 2009);
        LibItem magazine1 = new Magazine("Muc tim", "Van Hoa", "October 2015");

        SearchResult searchResult = new SearchResult(Arrays.asList(book1, book2, magazine1));
        searchResult.sortBy(LibItem::getTitle);

        System.out.println("Please choose mode to go:");
        System.out.println("1. Show list");
        System.out.println("2. Export json");
        System.out.println("3. Export XML");
        Scanner scanner = new Scanner(System.in);


        int mode = scanner.nextInt();
        if (mode == 1) {
            Printer printer = new PDFPrinter(searchResult);
            try {
                printer.print();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (DocumentException e) {
                e.printStackTrace();
            }
        } else if (mode == 2) {
            Exporter exporter = new JsonExporter(searchResult);
            System.out.println(exporter.export());
        } else if (mode == 3) {
            Exporter exporter = new XMLExporter(searchResult);
            System.out.println(exporter.export());
        } else {
            System.out.println("Bad request");
        }
    }
}

package vn.hcmut.edu.solid.helpers;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Image;
import vn.hcmut.edu.solid.items.LibItem;

import java.io.IOException;

public class Printer {
    private LibItem item;

    public Printer(LibItem item) {
        this.item = item;
    }

    public LibItem getItem() {
        return item;
    }

    public void setItem(LibItem item) {
        this.item = item;
    }

    public Image makeFrontCover() throws IOException, BadElementException {
        CoverGenerator generator = new CoverGenerator(item.getTitle());
        String imageUrl = generator.generateFrontCover();
        Image image = Image.getInstance(imageUrl);
        image.scaleToFit(30, 40);

        return image;
    }

    public Image makeBackCover() throws IOException, BadElementException {
        CoverGenerator generator = new CoverGenerator(item.getTitle());
        String imageUrl = generator.generateBackCover();
        Image image = Image.getInstance(imageUrl);
        image.scaleToFit(30, 40);

        return image;
    }

    public String makePreface() {
        return "Preface";
    }

    public String printPage(int pageNum) {
        return "Text in page " + pageNum;
    }
}

package vn.hcmut.edu.solid.helpers;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Image;
import vn.hcmut.edu.solid.items.LibItem;
import java.io.IOException;
import java.net.URL;

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
        String imageUrl = "https://isach.info/images/story/cover/toi_thay_hoa_vang_tren_co_xanh__nguyen_nhat_anh.jpg";
        Image image = Image.getInstance(new URL(imageUrl));
        image.scaleToFit(50, 60);

        return image;
    }

    public Image makeBackCover() throws IOException, BadElementException {
        String imageUrl = "https://isach.info/images/story/cover/toi_thay_hoa_vang_tren_co_xanh__nguyen_nhat_anh.jpg";
        Image image = Image.getInstance(new URL(imageUrl));
        image.scaleToFit(50, 60);

        return image;
    }

    public String makePreface() {
        return "Preface";
    }

    public String printPage(int pageNum) {
        return "Text in page " + pageNum;
    }
}

package vn.hcmut.edu.solid.helpers;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Image;
import vn.hcmut.edu.solid.items.LibItem;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Maker {
    private LibItem item;

    public Maker(LibItem item) {
        this.item = item;
    }

    public LibItem getItem() {
        return item;
    }

    public void setItem(LibItem item) {
        this.item = item;
    }

    public Image makeFrontCover() throws IOException, BadElementException {
        String pathName = this.item.getTitle().replace(" ", "") + "_Front.png";
        String[] text = this.item.getTitle().split(" ");
        String imageUrl = createImageFromText(text[0], pathName);

        Image image = Image.getInstance(imageUrl);
        image.scaleToFit(30, 40);

        return image;
    }

    public Image makeBackCover() throws IOException, BadElementException {
        String pathName = this.item.getTitle().replace(" ", "") + "_Back.png";
        String[] text = this.item.getTitle().split(" ");
        String imageUrl = createImageFromText(text[text.length - 1], pathName);

        Image image = Image.getInstance(imageUrl);
        image.scaleToFit(30, 40);

        return image;
    }

    private String createImageFromText(String text, String pathName) {
        BufferedImage img = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = img.createGraphics();
        Font font = new Font("Arial", Font.PLAIN, 48);
        g2d.setFont(font);
        FontMetrics fm;
        int width = 40;
        int height = 60;
        g2d.dispose();

        img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        g2d = img.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
        g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
        g2d.setFont(font);
        fm = g2d.getFontMetrics();
        g2d.setColor(Color.orange);
        g2d.fillRect(0, 0, width, height); // give the whole image a white background
        g2d.setColor(Color.blue);
        g2d.drawString(text, 0, fm.getAscent());
        g2d.dispose();

        try {
            ImageIO.write(img, "png", new File(pathName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return pathName;
    }
}

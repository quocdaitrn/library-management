package vn.hcmut.edu.solid.helpers;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CoverGenerator {
    private String title;

    public CoverGenerator(String title) {
        this.title = title;
    }

    public String generateFrontCover() {
        String pathName = this.title.replace(" ", "") + "_Front.png";
        String[] text = this.title.split(" ");
        return generateImageFromText(text[0], pathName);
    }

    public String generateBackCover() {
        String pathName = this.title.replace(" ", "") + "_Back.png";
        String[] text = this.title.split(" ");
        return generateImageFromText(text[text.length - 1], pathName);
    }

    private String generateImageFromText(String text, String pathName) {
        BufferedImage img = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = img.createGraphics();
        Font font = new Font("Arial", Font.PLAIN, 48);
        g2d.setFont(font);
        FontMetrics fm = g2d.getFontMetrics();
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
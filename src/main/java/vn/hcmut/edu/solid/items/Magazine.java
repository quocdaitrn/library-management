package vn.hcmut.edu.solid.items;

public class Magazine extends LibItem {
    private String publishDate;

    public Magazine() {
    }

    public Magazine(String title, String publisher, String publishDate) {
        this.title = title;
        this.publisher = publisher;
        this.publishDate = publishDate;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    @Override
    public String getInfo() {
        return "Publish date: " + this.publishDate;
    }
}

package vn.hcmut.edu.solid.items;

public abstract class LibItem {
    protected String title;
    protected String publisher;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public abstract String getInfo();
}

package vn.hcmut.edu.solid.items;

public class Book extends LibItem {
    private String authors;
    private int year;

    public Book() {
    }

    public Book(String title, String authors, String publisher, int year) {
        this.title = title;
        this.authors = authors;
        this.publisher = publisher;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String getInfo() {
        return "Authors: " + this.authors + "\n\n"
                + "Year: " + this.year;
    }
}

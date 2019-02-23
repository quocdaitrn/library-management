package vn.hcmut.edu.solid.items;

public class Book implements LibItem {
    private String title;
    private String authors;
    private String publisher;
    private String year;

    public Book() {
    }

    public Book(String title, String authors, String publisher, String year) {
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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", authors='" + authors + '\'' +
                ", publisher='" + publisher + '\'' +
                ", year='" + year + '\'' +
                '}';
    }
}

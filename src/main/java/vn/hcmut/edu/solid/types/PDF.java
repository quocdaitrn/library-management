package vn.hcmut.edu.solid.types;

public class PDF {
    private String image;

    public PDF() {
        this.image = "Image";
    }

    @Override
    public String toString() {
        return "PDF{" +
                "image='" + image + '\'' +
                '}';
    }
}

package bookstore;

import java.util.Objects;

public abstract class ForReading extends Product {
    private String author;
    private int countPage;

    public ForReading(String title, String description, double price, String author, int countPage, int count) {
        super(title, description, price, count);
        this.author = author;
        this.countPage = countPage;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String newAuthor) {
        author = newAuthor;
    }

    public int getCountPage() {
        return countPage;
    }

    public void setCountPage(int newCountPage) {
        countPage = newCountPage;
    }

    @Override
    public String toString() {
        return "ForReading{" +
                "author='" + author + '\'' +
                ", countPage=" + countPage + '\'' +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ForReading that = (ForReading) o;
        return countPage == that.countPage && Objects.equals(author, that.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), author, countPage);
    }
}

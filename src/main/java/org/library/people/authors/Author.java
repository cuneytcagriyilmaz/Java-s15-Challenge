package main.java.org.library.people.authors;

import main.java.org.library.people.abstraction.Personable;
import main.java.org.library.books.abstraction.Book;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Author implements Personable {
    private String authorName;
    private Set<Book> booksOfAuthor;

    public Author(String authorName) {
        this.authorName = authorName;
        this.booksOfAuthor = new HashSet<>();
    }

    // Yeni kitap ekleme metodu
    public void newBook(Book book) {
        getBooksOfAuthor().add(book);
        book.setAuthor(this);
    }

    // Yazarın kitaplarını gösterme metodu
    public void showBooks() {
        if (getBooksOfAuthor().isEmpty()) {
            System.out.println("Author " + getAuthorName() + " has no books.");
        } else {
            System.out.println("Books by author " + getAuthorName() + ":");
            for (Book book : getBooksOfAuthor()) {
                System.out.println(" - " + book);
            }
        }
    }

    // Kendi hakkında bilgi verme metodu
    @Override
    public void whoYouAre() {
        System.out.println(getAuthorName() + ", an author.");
    }

    public String getAuthorName() {
        return authorName;
    }

    @Override
    public String toString() {
        return "{" +
                "authorName='" + getAuthorName() + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(authorName, author.authorName) && Objects.equals(booksOfAuthor, author.booksOfAuthor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authorName, booksOfAuthor);
    }

    public Set<Book> getBooksOfAuthor() {
        return booksOfAuthor;
    }
}

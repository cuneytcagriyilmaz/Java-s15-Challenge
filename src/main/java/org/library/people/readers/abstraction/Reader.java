package main.java.org.library.people.readers.abstraction;

import main.java.org.library.people.abstraction.Personable;
import main.java.org.library.people.librarians.Librarian;
import main.java.org.library.library.Library;
import main.java.org.library.books.abstraction.Book;

import java.util.HashSet;
import java.util.Set;

public abstract class Reader implements Personable {
    private static int nextId = 1;
    private int readerId;
    private String nameofReader;
    private Set<Book> booksofReader;

    public Reader(String nameofReader) {
        this.readerId = nextId++;
        this.nameofReader = nameofReader;
        this.booksofReader = new HashSet<>();
        Library.getInstance().addReader(this);
    }

    // Kitap alabilecek maksimum sayıyı döndür
    public abstract int getMaxAllowedBooks();

    // Kitap satın alma metodu
    public void borrowBook(Book book) {
        if (book.isBookStatus()) {
            if (booksofReader.size() < getMaxAllowedBooks()) {
                booksofReader.add(book);
                book.changeOwner(nameofReader);
                book.updateStatus(false);
                Librarian.createBill(getReaderId());
            } else {
                System.out.println("Maximum number of books reached for " + nameofReader);
            }
        } else {
            System.out.println("The book is currently unavailable.");
        }
    }

    // Kitap iade etme metodu
    public void returnBook(Book book) {
        booksofReader.remove(book);
        book.updateStatus(true);
        book.changeOwner("Library");
        double fine = Librarian.calculateFine(getReaderId());
        if (fine > 0) {
            System.out.println("Refunding the fine of TL" + fine + " to " + nameofReader);
        }
    }

    // Kitapları gösterme metodu
    public void showBooks() {
        if (booksofReader.isEmpty()) {
            System.out.println("Reader " + nameofReader + " has no books.");
        } else {
            System.out.println("Books of reader " + nameofReader + ":");
            for (Book book : booksofReader) {
                System.out.println(" - " + book);
            }
        }
    }

    // Kendi hakkında bilgi verme metodu
    @Override
    public void whoYouAre() {
        String className = this.getClass().getSimpleName();
        System.out.println(nameofReader + ", a " + className + " with ID: " + readerId);
    }

    public String getName() {
        return nameofReader;
    }

    public int getReaderId() {
        return readerId;
    }


    public Set<Book> getBooksofReader() {
        return booksofReader;
    }

    @Override
    public String toString() {
        return "Reader{" +
                "readerId=" + readerId +
                ", nameofReader='" + nameofReader + '\'' +
                ", booksofReader=" + booksofReader +
                '}';
    }
}

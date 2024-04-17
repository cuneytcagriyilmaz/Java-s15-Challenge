package main.java.org.library.people.librarians;

import main.java.org.library.people.authors.Author;
import main.java.org.library.library.Library;
import main.java.org.library.people.abstraction.Personable;
import main.java.org.library.books.abstraction.Book;
import main.java.org.library.people.readers.abstraction.Reader;

import java.util.Date;
import java.util.Map;

public class Librarian implements Personable {
    private String nameofLibrarian;
    private String passwrd;

    public Librarian(String nameofLibrarian, String passwrd) {
        this.nameofLibrarian = nameofLibrarian;
        this.passwrd = passwrd;
    }

    @Override
    public void whoYouAre() {
        System.out.println("I am " + nameofLibrarian + ", a librarian.");
    }


    public void searchBook(String bookName) {
        Library library = Library.getInstance();
        boolean found = false;
        for (Map.Entry<Integer, Book> entry : library.getBooksOfLibrary().entrySet()) {
            Book book = entry.getValue();
            if (book.getTitle().equalsIgnoreCase(bookName)) {
                System.out.println("Book found:");
                book.display();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Book not found.");
        }
    }

    public void searchBook(int bookId) {
        Library library = Library.getInstance();
        Book book = library.getBooksOfLibrary().get(bookId);
        if (book != null) {
            System.out.println("Book found:");
            book.display();
        } else {
            System.out.println("Book not found.");
        }
    }

    public void searchBook(Author author) {
        author.showBooks();
    }

    public void verifyMember(int readerId) {
        Library library = Library.getInstance();
        Reader reader = library.getReadersOfLibrary().get(readerId);
        if (reader != null) {
            reader.whoYouAre();
        } else {
            System.out.println("Member not verified.");
        }
    }

    public void issueBook(int bookId, int readerId) {
        Library library = Library.getInstance();
        Book book = library.getBooksOfLibrary().get(bookId);
        Reader reader = library.getReadersOfLibrary().get(readerId);
        if (book != null && reader != null) {
            if (book.isBookStatus()) {
                reader.borrowBook(book);
                System.out.println(book.getTitle() + " lent to " + reader.getName());
            } else {
                System.out.println("The book is currently unavailable.");
            }
        } else {
            System.out.println("Book or reader not found.");
        }
    }

    public void returnBook(int bookId, int readerId) {
        Library library = Library.getInstance();
        Book book = library.getBooksOfLibrary().get(bookId);
        Reader reader = library.getReadersOfLibrary().get(readerId);
        if (book != null && reader != null) {
            reader.returnBook(book);
            System.out.println(book.getTitle() + " returned by " + reader.getName());
        } else {
            System.out.println("Book or reader not found.");
        }
    }


    public static double calculateFine(int readerId) {
        Library library = Library.getInstance();
        Reader reader = library.getReadersOfLibrary().get(readerId);
        if (reader != null) {
            double fine = 0.0;
            for (Book book : reader.getBooksofReader()) {
                fine += book.getBookPrice();
            }


            return fine;
        } else {
            System.out.println("Reader not found.");
            return 0.0;
        }
    }


    public static void createBill(int readerId) {
        double fine = calculateFine(readerId);
        System.out.println("Bill generated for reader " + readerId + ": TL" + fine);
    }

    public void updateBook(Book bookToUpdate, Author newAuthor, String newTitle, Double newPrice, Boolean newStatus, Integer newEdition, Date newDateOfPurchase, String newOwner) {
        if (bookToUpdate != null) {
            if (newAuthor != null) {
                bookToUpdate.setAuthor(newAuthor);
            }
            if (newTitle != null) {
                bookToUpdate.setTitle(newTitle);
            }
            if (newPrice != null) {
                bookToUpdate.setBookPrice(newPrice);
            }
            if (newStatus != null) {
                bookToUpdate.updateStatus(newStatus);
            }
            if (newEdition != null) {
                bookToUpdate.setBookEdition(newEdition);
            }
            if (newDateOfPurchase != null) {
                bookToUpdate.setBookDateOfPurchase(newDateOfPurchase);
            }
            if (newOwner != null) {
                bookToUpdate.setOwner(newOwner);
            }
        } else {
            System.out.println("Book not found.");
        }
    }

}

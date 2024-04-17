package main.java.org.library.library;

import main.java.org.library.books.NovelBook;
import main.java.org.library.books.abstraction.Book;
import main.java.org.library.books.JournalBook;
import main.java.org.library.books.MagazineBook;
import main.java.org.library.books.StudyBook;
import main.java.org.library.people.readers.abstraction.Reader;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Library {

    private static Library instance;

    private Map<Integer, Book> booksOfLibrary;
    private Map<Integer, Reader> readersOfLibrary;

    private Library() {
        booksOfLibrary = new HashMap<>();
        readersOfLibrary = new HashMap<>();
    }

    //Singleton
    public static Library getInstance() {
        if (instance == null) {
            instance = new Library();
        }
        return instance;
    }

    public void newBook(Book book) {
        booksOfLibrary.put(book.getBookId(), book);
    }

    public void addReader(Reader reader) {
        readersOfLibrary.put(reader.getReaderId(), reader);
    }

    public Map<Integer, Book> getBooksOfLibrary() {
        return booksOfLibrary;
    }

    public Map<Integer, Reader> getReadersOfLibrary() {
        return readersOfLibrary;
    }

    public void lendBook(int bookId, int readerId) {
        Book book = getBooksOfLibrary().get(bookId);
        Reader reader = getReadersOfLibrary().get(readerId);
        if (book != null && reader != null) {
            reader.borrowBook(book);
            System.out.println(book.getTitle() + " lent to " + reader.getName());
        } else {
            System.out.println("Book or reader not found.");
        }
    }

    public void takeBackBook(int bookId, int readerId) {
        Book book = getBooksOfLibrary().get(bookId);
        Reader reader = getReadersOfLibrary().get(readerId);
        if (book != null && reader != null) {
            reader.returnBook(book);
            System.out.println(book.getTitle() + " returned by " + reader.getName());
        } else {
            System.out.println("Book or reader not found.");
        }
    }

    public void showBook(int bookId) {
        Book book = getBooksOfLibrary().get(bookId);
        if (book != null) {
            System.out.println("Book Information:");
            book.display();
        } else {
            System.out.println("Book not found.");
        }
    }

    public void showAllBooks() {
        System.out.println("Books in the Library:");
        for (Book book : getBooksOfLibrary().values()) {
            System.out.println(book.getBookId() + "- " + book.getTitle());
        }
//        System.out.println(booksOfLibrary);

    }

    public void showAllReaders() {
        System.out.println("\nReaders in the Library:");
        for (Reader reader : readersOfLibrary.values()) {
            System.out.println(reader.getReaderId() + " - " + reader.getName());
        }
//        System.out.println(getReadersOfLibrary());
    }


    public void searchBookWithType() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter the type of books to list: ");
            System.out.println("1. Magazine Books");
            System.out.println("2. Journal Books");
            System.out.println("3. Study Books");
            System.out.println("4. Novel Books");
            int choice = scanner.nextInt();
            scanner.nextLine();

            boolean noBook = true;

            for (Book book : getBooksOfLibrary().values()) {
                switch (choice) {
                    case 1:
                        if (book instanceof MagazineBook) {
                            System.out.println(book);
                            noBook = false;
                        }
                        break;
                    case 2:
                        if (book instanceof JournalBook) {
                            System.out.println(book);
                            noBook = false;
                        }
                        break;
                    case 3:
                        if (book instanceof StudyBook) {
                            System.out.println(book);
                            noBook = false;
                        }
                        break;
                    case 4:
                        if (book instanceof NovelBook) {
                            System.out.println(book);
                            noBook = false;
                        }
                        break;
                    default:
                        System.out.println("Invalid choice!");
                }
            }
            if (noBook) {
                System.out.println("No books found in this category.");
            }
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a number.");
        } finally {
            scanner.close();
        }
    }


    @Override
    public String toString() {
        return "Library Info: \nid = {bookInfo}\n" +
                "Library= " + getBooksOfLibrary() +
                "\nid = {readerInfo}\n" +
                "Library= " + getReadersOfLibrary();
    }


}

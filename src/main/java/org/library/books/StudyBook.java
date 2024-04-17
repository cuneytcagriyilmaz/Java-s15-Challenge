package main.java.org.library.books;

import main.java.org.library.people.authors.Author;
import main.java.org.library.books.abstraction.Book;

import java.util.Date;

public class StudyBook extends Book {

    public StudyBook(Author author, String bookName, double bookPrice, boolean bookStatus, int bookEdition, Date bookDateOfPurchase) {
        super(author, bookName, bookPrice, bookStatus, bookEdition, bookDateOfPurchase);
    }

    public StudyBook(Author author, String bookName, double bookPrice, boolean bookStatus, int bookEdition, Date bookDateOfPurchase, String bookOwner) {
        super(author, bookName, bookPrice, bookStatus, bookEdition, bookDateOfPurchase, bookOwner);
    }
}

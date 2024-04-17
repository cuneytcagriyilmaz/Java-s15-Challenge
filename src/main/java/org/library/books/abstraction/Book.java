package main.java.org.library.books.abstraction;

import main.java.org.library.people.authors.Author;
import main.java.org.library.library.Library;

import java.util.Date;
import java.util.Objects;

public abstract class Book {

    private static int nextId = 1;
    private int bookId;
    private Author author;
    private String bookName;
    private double bookPrice;
    private boolean bookStatus;
    private int bookEdition;
    private Date bookDateOfPurchase;
    private String bookOwner;


    public Book(Author author, String bookName, double bookPrice, boolean bookStatus, int bookEdition, Date bookDateOfPurchase) {
        this.bookId = nextId++;
        this.author = author;
        this.bookName = bookName;
        this.bookPrice = bookPrice;
        this.bookStatus = bookStatus;
        this.bookEdition = bookEdition;
        this.bookDateOfPurchase = bookDateOfPurchase;
        this.bookOwner = "Library";
        this.author.newBook(this);
        Library.getInstance().newBook(this);

    }

    public Book(Author author, String bookName, double bookPrice, boolean bookStatus, int bookEdition, Date bookDateOfPurchase, String bookOwner) {
        this.bookId = nextId++;
        this.author = author;
        this.bookName = bookName;
        this.bookPrice = bookPrice;
        this.bookStatus = bookStatus;
        this.bookEdition = bookEdition;
        this.bookDateOfPurchase = bookDateOfPurchase;
        this.bookOwner = bookOwner;
        this.author.newBook(this);
        Library.getInstance().newBook(this);


    }

    // Getter methods
    public String getTitle() {
        return bookName;
    }

    public Author getAuthor() {
        return author;
    }

    public String getOwner() {
        return bookOwner;
    }

    public boolean isBookStatus() {
        return bookStatus;
    }

    // Method to change owner
    public void changeOwner(String newOwner) {
        this.bookOwner = newOwner;
    }


    // display()
    public void display() {
        System.out.println("Book ID: " + bookId);
        System.out.println("Title: " + bookName);
        System.out.println("Author: " + author);
        System.out.println("Price: " + bookPrice);
        System.out.println("Status: " + (bookStatus ? "Available" : "Not available"));
        System.out.println("Edition: " + bookEdition);
        System.out.println("Date of Purchase: " + bookDateOfPurchase);
        System.out.println("Owner: " + bookOwner);
    }

    // updateStatus()
    public void updateStatus(boolean newStatus) {
        this.bookStatus = newStatus;
        if (newStatus) {
            this.bookOwner = "Library";
        }
    }



    public void setTitle(String bookName) {
        this.bookName = bookName;
    }

    public void setBookPrice(double bookPrice) {
        this.bookPrice = bookPrice;
    }

    public void setBookEdition(int bookEdition) {
        this.bookEdition = bookEdition;
    }

    public void setBookDateOfPurchase(Date bookDateOfPurchase) {
        this.bookDateOfPurchase = bookDateOfPurchase;
    }

    public void setOwner(String bookOwner) {
        this.bookOwner = bookOwner;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }


    public int getBookId() {
        return bookId;
    }

    public double getBookPrice() {
        return bookPrice;
    }

    public int getBookEdition() {
        return bookEdition;
    }

    public Date getBookDateOfPurchase() {
        return bookDateOfPurchase;
    }

    @Override
    public String toString() {
        return "{" +
                "bookId=" + getBookId() +
                ", author=" + getAuthor() +
                ", bookName='" + getTitle() + '\'' +
                ", bookPrice=" + getBookPrice() +
                ", bookStatus=" + isBookStatus() +
                ", bookEdition=" + getBookEdition() +
                ", bookDateOfPurchase=" + getBookDateOfPurchase() +
                ", bookOwner='" + getOwner() + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return bookId == book.bookId;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(bookId);
    }
}

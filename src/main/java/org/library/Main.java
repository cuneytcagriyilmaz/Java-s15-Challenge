package main.java.org.library;


import main.java.org.library.books.NovelBook;
import main.java.org.library.books.StudyBook;
import main.java.org.library.people.authors.Author;
import main.java.org.library.books.abstraction.Book;
import main.java.org.library.books.JournalBook;
import main.java.org.library.books.MagazineBook;
import main.java.org.library.people.librarians.Librarian;
import main.java.org.library.library.Library;
import main.java.org.library.people.readers.Faculty;
import main.java.org.library.people.readers.Student;
import main.java.org.library.people.readers.abstraction.Reader;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

        //Library new'le
        Library library = Library.getInstance();
        Librarian librarian = new Librarian("Kutuphaneci Ali", "123456");


        // Yazar oluştur
        Author authorOrwell = new Author("George Orwell");
        Author authorDostoevsky = new Author("Fyodor Dostoevsky");
        Author authorFeyyaz = new Author("Feyyaz Yigit");
        Author authorBloch = new Author("Joshua Bloch");
        Author authorTanenbaum = new Author("Andrew S. Tanenbaum");
        Author authorGamma = new Author("Erich Gamma");
        Author authorHunt = new Author("Richard Helm");
        Author authorSmith = new Author("John Smith");
        Author authorJohnson = new Author("Emily Johnson");


        //Kitap oluşturma. ID otomatik olarak increment olur.
        Book book1984 = new NovelBook(authorOrwell, "1984", 10, true, 1, new Date(84, 6, 8));
        Book bookHayvanCift = new NovelBook(authorOrwell, "Hayvan Çiftliği", 15, true, 2, new Date(45, 7, 17));
        Book bookSucveCeza = new NovelBook(authorDostoevsky, "Suç ve Ceza", 25, true, 1, new Date(66, 1, 1));
        Book bookKumarbaz = new NovelBook(authorDostoevsky, "Kumarbaz", 30, true, 1, new Date(80, 2, 1));
        Book bookYeralti = new NovelBook(authorDostoevsky, "Yeraltından Notlar", 35, true, 1, new Date(64, 0, 1));

        Book bookKafa = new MagazineBook(authorFeyyaz, "Kafa", 100, true, 3, new Date(2020, 8, 1));

        Book bookEffectiveJava = new StudyBook(authorBloch, "Effective Java", 450, true, 3, new Date(2001, 4, 28));
        Book bookIntroCS = new StudyBook(authorTanenbaum, "Introduction to Computer Science", 550, true, 1, new Date(2019, 0, 1));
        Book bookDesignPatterns = new StudyBook(authorGamma, "Design Patterns: Elements of Reusable Object-Oriented Software", 600, true, 1, new Date(1994, 10, 10));
        Book bookCleanCode = new StudyBook(authorHunt, "Clean Code: A Handbook of Agile Software Craftsmanship", 500, true, 2, new Date(2008, 7, 1));

        Book journalBook1 = new JournalBook(authorSmith, "Journal of Artificial Intelligence Research", 300, true, 1, new Date(2023, 2, 15));
        Book journalBook2 = new JournalBook(authorJohnson, "Journal of Environmental Science and Technology", 250, true, 1, new Date(2022, 11, 10));


        Reader studentCagri = new Student("Cuneyt Cagri Yilmaz");

        System.out.println("===================BOOK METHODLARI===============");

        // updateStatus() methodunu test etme
        System.out.println("Before status update:");
        book1984.display();
        book1984.updateStatus(false);
        System.out.println("\nAfter status update:");
        book1984.display();

        // changeOwner() methodunu test etme
        System.out.println("\nBefore owner change:");
        book1984.display();
        book1984.changeOwner(studentCagri.getName());
        System.out.println("\nAfter owner change:");
        book1984.display();

        // display() methodunu test etme
        System.out.println("\nDisplaying book information:");
        book1984.display();


        System.out.println("===================AUTHOR METHODLARI===============");
        //showBook()
        authorOrwell.showBooks();

        //newBook()
        authorOrwell.newBook(bookSucveCeza);
        authorOrwell.showBooks();
        //whoyouare()
        authorOrwell.whoYouAre();

        System.out.println("===================Reader METHODLARI===============");
        // Faculty
        Reader facultyCelal = new Faculty("Prof. Celal Sengor");
        Reader facultyIlber = new Faculty("Prof. Ilber Ortayli");

        // Student
        Reader studentCagriYlm = new Student("Cagri Yilmaz");

        // borrowBook() methodunu test etme
        System.out.println("Before borrowing a book:");
        studentCagriYlm.showBooks();
        studentCagriYlm.borrowBook(bookKumarbaz);
        studentCagriYlm.borrowBook(bookCleanCode);
//        studentCagriYlm.borrowBook(bookHayvanCift);
        System.out.println("\nAfter borrowing a book:");
        studentCagriYlm.showBooks();

        // returnBook() methodunu test etme
        System.out.println("\nBefore returning a book:");
        studentCagriYlm.returnBook(bookCleanCode);
        System.out.println("\nAfter returning a book:");
        studentCagriYlm.showBooks();

        // showBooks() methodunu test etme
        System.out.println("\nDisplaying books of the reader:");
        studentCagriYlm.showBooks();

        //whoyouare()
        facultyIlber.whoYouAre();


        System.out.println("===================Library METHODLARI===============");
        library.newBook(book1984);
        library.newBook(bookHayvanCift);

        library.showAllBooks();
        library.showAllReaders();
        library.showBook(1);
        library.lendBook(1, 1);
        library.takeBackBook(1, 1);
        library.searchBookWithType();


        System.out.println("===================Librarian METHODLARI===============");

        // searchBook(String bookName)
        System.out.println("\nSearching for a book by name:");
        librarian.searchBook("1984");

        // searchBook(int bookId)
        System.out.println("\nSearching for a book by ID:");
        librarian.searchBook(1);

        // searchBook(Author author)
        System.out.println("\nSearching for books by author:");
        librarian.searchBook(authorOrwell);

        // verifyMember
        System.out.println("\nVerifying a member:");
        librarian.verifyMember(1);

        // issueBook
        System.out.println("\nIssuing a book:");
        librarian.issueBook(1, 1);

        // returnBook
        System.out.println("\nReturning a book:");
        librarian.returnBook(1, 1);

        // calculateFine
        System.out.println("\nCalculating fine for a reader:");
        double fine = Librarian.calculateFine(1);
        System.out.println("Fine: " + fine);

        // createBill
        System.out.println("\nCreating bill for a reader:");
        Librarian.createBill(1);

        //updateBook
        System.out.println("\nUpdating a book:");
        librarian.updateBook(book1984, null, "Animal Farm", null, null, null, null, null);
        book1984.display();
        System.out.println("search*******");
        librarian.searchBook("Kumarbaz");
    }

}


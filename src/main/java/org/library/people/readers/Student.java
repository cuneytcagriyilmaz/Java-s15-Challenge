package main.java.org.library.people.readers;

import main.java.org.library.people.readers.abstraction.Reader;

public class Student extends Reader {
    public static final int MAX_ALLOWED_BOOKS = 2;

    public Student(String name) {
        super(name);
    }

    @Override
    public int getMaxAllowedBooks() {
        return MAX_ALLOWED_BOOKS;
    }
}

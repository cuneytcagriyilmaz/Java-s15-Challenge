package main.java.org.library.people.readers;

import main.java.org.library.people.readers.abstraction.Reader;

public class Faculty extends Reader {
    public static final int MAX_ALLOWED_BOOKS = 8;

    public Faculty(String name) {
        super(name);
    }

    @Override
    public int getMaxAllowedBooks() {
        return MAX_ALLOWED_BOOKS;
    }
}

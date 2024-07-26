package main;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private String address;
    private List<Book> books;

    public Library(String laddress) {
        address = laddress;
        books = new ArrayList<Book>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void borrowBook(String str) {
        for (Book book : books) {
            if (book.getTitle().equals(str)) {
                if (!book.isBorrowed()) {
                    book.borrowed();
                    System.out.println("You successfully borrowed " + str + ".");
                    return;
                } else {
                    System.out.println("Sorry, this book is already borrowed.");
                    return;
                }
            }
        }

        // Book not in the catalog
        System.out.println("Sorry, this book is not in the catalog.");
        return;
    }

    public void returnBook(String str) {
        for (Book book : books) {
            if (book.getTitle().equals(str)) {
                book.returned();
                System.out.println("You successfully returned " + str + ".");
            }
        }
    }

    public static void printOpeningHours() {
        System.out.println("Library hours are daily 9am to 5pm.");
    }

    public void printAddress() {
        System.out.println(address);
    }

    public void printAvailableBooks() {
        if (books.isEmpty())
            System.out.println("No books in the catalog.");
        for (Book book : books) {
            if (!book.isBorrowed())
                System.out.println(book.getTitle());
        }
    }

    public List<Book> getBooks() {
        return books;
    }
}
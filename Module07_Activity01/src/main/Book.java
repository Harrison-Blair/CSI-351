package main;

public class Book {
 
    private String title;
    private boolean borrowed;
 
    // Creates a new Book
    public Book(String bookTitle) {
        // Implement this method
        title = bookTitle;
        borrowed = false;
    }
    
    // Marks the book as rented
    public void borrowed() {
        borrowed = true;
    }
    
    // Marks the book as not rented
    public void returned() {
        borrowed = false;
    }
    
    // Returns true if the book is rented, false otherwise
    public boolean isBorrowed() {
        return borrowed;
    }
    
    // Returns the title of the book
    public String getTitle() {
        return title;
    }
}
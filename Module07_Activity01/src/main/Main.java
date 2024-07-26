package main;

public class Main {

    public static void main(String[] args) {

        Book bookTesting = new Book("Testing");
        Book bookRefactoring = new Book("Refactoring");
        Book bookDesign = new Book("Design");

        Library library = new Library("Main St, Burlington, VT");
        library.addBook(bookTesting);
        library.addBook(bookRefactoring);
        library.addBook(bookDesign);  
        
        library.printAvailableBooks();
        
        library.borrowBook("Design");
        library.borrowBook("Design");
        library.borrowBook("Peace");
    }

}

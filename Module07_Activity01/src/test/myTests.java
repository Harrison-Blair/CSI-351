/* Harrison Blair's submission for Module 07 Activity 01
 * 
 */

package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;

import main.Library;
import main.Book;

public class myTests {

	private ByteArrayOutputStream out = new ByteArrayOutputStream();

	private Library library;
	
	@BeforeEach
	public void setUp() {
		System.setOut(new PrintStream(out));
		
		library = new Library("Lenox Blvd");
	}
	
	@AfterEach
	public void tearDown() {
		System.setOut(null);
	}
	
	@Test
	@DisplayName("Test output if no availible books")
	public void testPrintNoAvailableBooks() {
		// Print no available books
		library.printAvailableBooks();
		
		// Check there are no books in the catalog
		assertEquals("No books in the catalog.\r\n", out.toString());
	}

	@Test
	@DisplayName("Test adding a book to the library")
	public void testAddBookAndPrintBooks() {
		// Create book to add
		Book book1 = new Book("Infinite Jest");
		
		// Add book to library
		library.addBook(book1);
		
		// Print Books List
		library.printAvailableBooks();
		
		// Check Books List
		assertEquals("Infinite Jest\r\n", out.toString());
	}
	
	@Test
	@DisplayName("Test borrowing a book")
	public void testBorrowBook() {
		// Create book to add
		Book book1 = new Book("Infinite Jest");
				
		// Add book to library
		library.addBook(book1);
		
		// Borrow Book
		library.borrowBook(book1.getTitle());
		
		// Check Borrowing
		assertEquals("You successfully borrowed " + book1.getTitle() + ".\r\n", out.toString());
	}
	
	@Test
	@DisplayName("Test borrowing an already borrowed book")
	public void testBorrowBorrowedBook() {
		// Create book to add
		Book book1 = new Book("Infinite Jest");
						
		// Add book to library
		library.addBook(book1);
				
		// Borrow Book
		library.borrowBook(book1.getTitle());
		
		// Reset out stream
		out.reset();

		// Borrow Book
		library.borrowBook(book1.getTitle());
		
		// Check Message
		assertEquals("Sorry, this book is already borrowed.\r\n", out.toString());
	}
	
	@Test
	@DisplayName("Test borrowing a nonexistant book")
	public void testBorrowNonExistantBook() {

		// Borrow Book
		library.borrowBook("My Autobiography");
		
		// Check Message
		assertEquals("Sorry, this book is not in the catalog.\r\n", out.toString());
	}

}
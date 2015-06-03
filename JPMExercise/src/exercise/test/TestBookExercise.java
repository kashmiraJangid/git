package exercise.test;

import org.junit.Assert;

import org.junit.Before;
import org.junit.Test;

import exercise.library.Book;
import exercise.library.BookNotFoundException;
import exercise.library.BookService;
import exercise.library.BookServiceImpl;

/**
 * Test class for book exercise
 * @author Kashmira
 *
 */

public class TestBookExercise {
	private final String ISBN001_SUMMURY = "[ISBN-001] Harry Potter and the Deathly Hallows - Sorcery and Magic.";
	private final String ISBN002_SUMMURY = "[ISBN-002] The Player of Games - Jernau Morat Gurgeh. The Player of Games. Master of every...";
	private final String ISBN003_SUMMURY = "[ISBN-003] Genius: Richard Feynman and Modern Physics - A brilliant interweaving of Richard Feynman's colourful life and a...";
	private final String INVALID_TEXT = "INVALID-TEXT";
	private final String INVALID_BOOK = "ISBN-777";
	
	private BookService bs;
	
	/**
	 * Initialize
	 */
	@Before
	public void init() {
		bs = new BookServiceImpl();
	}
	
	/**
	 * Test - Input 'ISBN-777' should throw BookNotFoundException.
	 * @throws BookNotFoundException
	 */
	@Test(expected = BookNotFoundException.class)
	public void invalidBook() throws BookNotFoundException {
		bs.retrieveBook(INVALID_BOOK);
	}
	
	/**
	 * Test - Input 'INVALID-TEXT' should throw an Exception, </br>
	 * informing the client that the book isbn must begin with 'ISBN'.
	 * @throws BookNotFoundException
	 */
	@Test(expected = BookNotFoundException.class)
	public void testInvalidText() throws BookNotFoundException {
		bs.retrieveBook(INVALID_TEXT);
	}
	
	/**
	 * Test - Valid book scenario </br>
	 * Input 'ISBN-001' should return the book entitled 'Harry Potter and the Deathly Hallows'.
	 * @throws BookNotFoundException
	 */
	@Test
	public void testValidBook() throws BookNotFoundException {
		Book book = bs.retrieveBook("ISBN-001");
		Assert.assertTrue("Harry Potter and the Deathly Hallows".equals(book.getTitle()));
	}
	
	/**
	 * Test - invalid book test summary
	 * @throws BookNotFoundException
	 */
	@Test(expected = BookNotFoundException.class)
	public void invalidBookTextSummary() throws BookNotFoundException { 
		bs.getBookSummary(INVALID_TEXT);
	}
	
	/**
	 *  Test - invalid book test summary
	 * @throws BookNotFoundException
	 */
	@Test(expected = BookNotFoundException.class)
	public void invalidBookNameSummary() throws BookNotFoundException {
		bs.getBookSummary(INVALID_BOOK);
	}
	
	/**
	 * Test for valid book scenario 
	 * @throws BookNotFoundException
	 */
	@Test
	public void validBookSummury() throws BookNotFoundException {
		Assert.assertTrue(bs.getBookSummary("ISBN-001").equals(ISBN001_SUMMURY));
		Assert.assertTrue(bs.getBookSummary("ISBN-002").equals(ISBN002_SUMMURY));
		Assert.assertTrue(bs.getBookSummary("ISBN-003").equals(ISBN003_SUMMURY));
	}
}

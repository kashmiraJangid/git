package exercise.validate;

import exercise.library.BookNotFoundException;

/**
 * Validate book operations
 * @author Kashmira
 */

public class Validate {
	
	private static final String ISBN_PREFIX = "ISBN-";
	
	/**
	 * Validate whether book isbn started with ISBN- or not
	 * @param isbn
	 * @throws BookNotFoundException
	 */
	public static void validateBookprefix(String isbn) throws BookNotFoundException {
		if(isbn == null || !isbn.startsWith(ISBN_PREFIX))
			throw new BookNotFoundException("Book isbn must begin with \'ISBN-\'");
	}
}

package exercise.library;

import exercise.utility.BookUtility;
import exercise.validate.Validate;

/**
 * 
 * @author Kashmira
 *
 */
public class BookServiceImpl implements BookService {
	
	private BookRepository bookRepository;
	
	public BookServiceImpl() {
		bookRepository = new BookRepositoryImpl();
	}
	
	@Override
	public Book retrieveBook(String isbn) throws BookNotFoundException {
		// Validate book name should start with ISBN
		Validate.validateBookprefix(isbn);
		// Get book from repository
		Book searchResult = bookRepository.retrieveBook(isbn);
		// if no book found, throw Exception
		if(searchResult == null) 
			throw new BookNotFoundException("Book not found!");
		else  // else return the book
			return searchResult;
		
	}

	@Override
	public String getBookSummary(String isbn) throws BookNotFoundException {
		// Validate book name should start with ISBN
		Validate.validateBookprefix(isbn);
		Book searchResult = bookRepository.retrieveBook(isbn);
		// if no book found, throw Exception
		if(searchResult == null) 
			throw new BookNotFoundException("Book not found!");
		else {
			// else return the book
			return BookUtility.bookSummaryFormatter(searchResult);
		}
		
	}
	
}

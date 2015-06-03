package exercise.library;

/**
 * Custom exception
 * @author Kashmira
 */
public class BookNotFoundException extends Exception {
	
	private static final long serialVersionUID = 4433711522534936639L;

	public BookNotFoundException() {
		super();
	}
	
	public BookNotFoundException(String message) {
		super(message);
	}
}

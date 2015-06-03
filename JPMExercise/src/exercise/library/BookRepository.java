package exercise.library;

/**
 * Book repository innterface
 * @author Kashmira 
 *
 */
public interface BookRepository {
	/**
	 * Retrieve book by ISBN number
	 * @param isbn
	 * @return
	 */
	Book retrieveBook(String isbn);
}

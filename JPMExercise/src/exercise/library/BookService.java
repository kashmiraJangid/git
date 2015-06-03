package exercise.library;


public interface BookService {
	/**
	 *  Requirements:<br/>
     * 		Should retrieve a book by its ISBN<br/>
     * 		Should ensure that the isbn is prefixed by 'ISBN-'<br/>
     * 		Should throw a BookNotFoundException where appropriate<br/>
	 * @param isbn
	 * @return 
	 * @throws BookNotFoundException
	 */
    public Book retrieveBook(String isbn) throws BookNotFoundException;
    
    /**
     *  Requirements:<br/>
     * 		Should ensure that the isbn is prefixed by 'ISBN-'<br/>
     * 		Should throw a BookNotFoundException where appropriate<br/>
     * 		Should provide a book summary that concatenates the isbn, the title, and the first ten words of the review
     * 		followed by '...'
     * @param isbn
     * @return
     * @throws BookNotFoundException
     */
    public String getBookSummary(String isbn) throws BookNotFoundException;
}

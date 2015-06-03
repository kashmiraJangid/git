package exercise.library;

/**
 * Book POJO
 * @author Kashmira
 */
public class Book
{
    private String isbn;
    private String title;
    private String description;

    public Book(String isbn, String title, String description)
    {
        this.isbn = isbn;
        this.title = title;
        this.description = description;
    }

    public String getDescription()
    {
    	// should return description rather than null
        //return null;
    	return description;
    }

    public String getIsbn()
    {
        return isbn;
    }

    public String getTitle()
    {
        return title;
    }
    
}

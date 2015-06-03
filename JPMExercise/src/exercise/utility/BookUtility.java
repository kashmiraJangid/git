package exercise.utility;

import exercise.library.Book;

/**
 * Class useful for performing book related operations
 * @author Kashmira
 *
 */

public class BookUtility {

	/**
	 * Format book summary, if summery length is greater than 10 words it appends ... to it
	 * @param book
	 * @return
	 */
	public static String bookSummaryFormatter(Book book) {
		String description = book.getDescription();
		if(description.split(" ").length > 10) {
			StringBuffer tempDescription = new StringBuffer();
			int count = 1;
			for(String word : description.split(" ")) {
				if(count < 10)
					tempDescription.append(word + " ");
				else {
					tempDescription.append(word + "...");
					description = tempDescription.toString();
					break;
				}
				count++;
			}
		}
		return "["+book.getIsbn()+"] "+ book.getTitle() +" - "+ description;
	}
}

package practiceOL.exception;

/**
 * Thrown when trying to get item by number and item is not exist in DB
 * 
 * @author alons
 *
 */
public class ItemNotFoundExcption extends Exception {

	private static final long serialVersionUID = 1L;

	public ItemNotFoundExcption() {
		super("No item exist with specified item number");
	}
}
package practiceOL.exception;

/**
 * Thrown when trying to make withdrawal and there is no enough quantity
 * 
 * @author alons
 *
 */
public class AmountItsNotAviableExcption extends Exception {
	private static final long serialVersionUID = 1L;

	public AmountItsNotAviableExcption() {
		super("There is not enough quantity to withdrawal");
	}

}

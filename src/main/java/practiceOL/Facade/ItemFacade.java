package practiceOL.Facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import practiceOL.Beans.Item;
import practiceOL.dao.ItemDB;
import practiceOL.exception.AmountItsNotAviableExcption;
import practiceOL.exception.ItemNotFoundExcption;

/**
 * Exposed the item dao layer
 * 
 * @author alons
 *
 */
@Service
public class ItemFacade {
	@Autowired
	ItemDB itemdb;

	public ItemFacade(ItemDB itemdb) {
		super();
		this.itemdb = itemdb;
	}

	public Item getItemDetailsByNumber(int itemNumber) throws ItemNotFoundExcption {
		return itemdb.getItemDetailsByNumber(itemNumber);
	}

	public void itemWithdrawalQuantityOfSpecificItem(int itemNumber, int withdrawalAmount)
			throws ItemNotFoundExcption, AmountItsNotAviableExcption {
		itemdb.itemWithdrawalQuantityOfSpecificItem(itemNumber, withdrawalAmount);
	}

	public void updateItemQuantity(int itemNumber, int ammoutToAdd) throws ItemNotFoundExcption {
		itemdb.updateItemQuantity(itemNumber, ammoutToAdd);
	}

	public void addItem(Item item) throws IllegalArgumentException {
		itemdb.addItem(item);
	}

	public void deleteItem(int itemNumber) {
		itemdb.deleteItem(itemNumber);
	}

}

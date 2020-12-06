package practiceOL.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import practiceOL.Beans.Item;
import practiceOL.exception.AmountItsNotAviableExcption;
import practiceOL.exception.ItemNotFoundExcption;

@Repository
public class ItemDB {
	@Autowired
	private ItemDBrepository itemRepo;

	/**
	 * Get item details by item number
	 * 
	 * @param itemNumber
	 * @return correct item by number
	 * @throws itemNotFoundExcption
	 */
	public Item getItemDetailsByNumber(int itemNumber) throws ItemNotFoundExcption {
		java.util.Optional<Item> opt = itemRepo.findById(itemNumber);
		if (opt.isPresent()) {
			return opt.get();
		}
		throw new ItemNotFoundExcption();
	}

	/**
	 * Check if withdrawal quantity available, if not throw excption if yes update
	 * quantity
	 * 
	 * @param itemNumber
	 * @param withdrawalAmount
	 * @throws itemNotFoundExcption
	 * @throws AmountItsNotAviableExcption
	 */
	public void itemWithdrawalQuantityOfSpecificItem(int itemNumber, int withdrawalAmount)
			throws ItemNotFoundExcption, AmountItsNotAviableExcption {
		Item item = getItemDetailsByNumber(itemNumber);
		if (item.getAmount() < withdrawalAmount) {
			throw new AmountItsNotAviableExcption();
		} else {
			item.setAmount(item.getAmount() - withdrawalAmount);
			itemRepo.save(item);
		}
	}

	/**
	 * Add quantity for specific item to stock
	 * 
	 * @param itemNumber
	 * @param ammoutToAdd
	 * @throws itemNotFoundExcption
	 */
	public void updateItemQuantity(int itemNumber, int ammoutToAdd) throws ItemNotFoundExcption {
		Item currentItem = getItemDetailsByNumber(itemNumber);
		currentItem.setAmount(currentItem.getAmount() + ammoutToAdd);
		itemRepo.save(currentItem);
	}

	/**
	 * Add item to the stock
	 * 
	 * @param item
	 * @throws IllegalArgumentException
	 */
	public void addItem(Item item) throws IllegalArgumentException {
		itemRepo.save(item);
	}

	/**
	 * Delete item from stock
	 * 
	 * @param itemNumber
	 */
	public void deleteItem(int itemNumber) {
		itemRepo.deleteById(itemNumber);
	}

}

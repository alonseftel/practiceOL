package practiceOL.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import practiceOL.Beans.Item;
import practiceOL.Facade.ItemFacade;
import practiceOL.exception.AmountItsNotAviableExcption;
import practiceOL.exception.ItemNotFoundExcption;

/**
 * Controller between web layer and business layer
 * 
 * @author alons
 *
 */
@Controller
@RequestMapping("Items")
public class ItemController {

	@Autowired
	private ItemFacade itemFacade;

	@GetMapping("/items/details/{itemNumber}")
	public ResponseEntity<Object> getItemDetailsByNumber(@PathVariable int itemNumber) {
		try {
			return ResponseEntity.ok(itemFacade.getItemDetailsByNumber(itemNumber));
		} catch (ItemNotFoundExcption e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@PutMapping("/items/withdrawal/{itemNumber}/{withdrawalAmount}")
	public ResponseEntity<Object> itemWithdrawalQuantityOfSpecificItem(@PathVariable int itemNumber,
			@PathVariable int withdrawalAmount) {
		try {
			itemFacade.itemWithdrawalQuantityOfSpecificItem(itemNumber, withdrawalAmount);
			return ResponseEntity.ok("item quantity sucsses ");
		} catch (AmountItsNotAviableExcption e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		} catch (ItemNotFoundExcption e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@PutMapping("/items/update/{itemNumber}/{ammoutToAdd}")
	public ResponseEntity<Object> updateItemQuantity(@PathVariable int itemNumber, @PathVariable int ammoutToAdd) {
		try {
			itemFacade.updateItemQuantity(itemNumber, ammoutToAdd);
			return ResponseEntity.ok("item is updated");

		} catch (ItemNotFoundExcption e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@PostMapping("/items/additem")
	public ResponseEntity<Object> addItem(@RequestBody Item item) {
		try {
			itemFacade.addItem(item);
			return ResponseEntity.ok("item is add");
		} catch (IllegalArgumentException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@DeleteMapping("/items/{itemNumber}")
	public ResponseEntity<Object> deleteItem(@PathVariable int itemNumber) throws ItemNotFoundExcption {
		try {
			itemFacade.deleteItem(itemNumber);
			return ResponseEntity.ok("item is delete");
		} catch (IllegalArgumentException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}

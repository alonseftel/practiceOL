package practiceOL.web;

import practiceOL.Facade.ItemFacade;

public class Session {
	private ItemFacade facade;

	public Session(ItemFacade facade) {
		super();
		this.facade = facade;
	}

	public ItemFacade getFacade() {
		return facade;
	}
}

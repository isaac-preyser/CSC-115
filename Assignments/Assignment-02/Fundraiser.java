public class Fundraiser {
	private String name;
	private AuctionItem[] items;
	
	public Fundraiser() {
		this.name = null;
		this.items = null;
	}
	
	public Fundraiser(String name, AuctionItem[] items) {
		this.name = name;
		this.items = items;
	}
	
	public String getName() {
		return name;
	}
	
	public AuctionItem[] getItems() {
		return items;
	}
	
	public String toString() {
		if (items == null || items.length == 0) {
			return "Fundraiser without any items";
		}
		String s = name + "\nauction items:\n";
		for (int i = 0; i < items.length; i++) {
			s += items[i].toString();
		}
		return s;
	}
	
	/*
	 * Purpose: get the money raised, which will be the 
	 *          sum of all auction items that are sold
	 * Parameters: none
	 * Returns: int - the total money this fundraiser raises
	 */
	public int moneyRaised() {
		int total = 0;
		//if the list is null, return 0
		if (this.items == null){
			return 0;
		}
		//if the list is empty, return 0
		if (this.items.length == 0){
			return 0;
		}
		
		//if the list is not null or empty, add the highest bid of each item to the total
		for (int i = 0; i < this.items.length; i++){
			total += this.items[i].getHighestBid();
		}

		return total; 
	}
	
	/*
	 * Purpose: get the total money spent at this fundraiser
	 *          by those with the given name
	 * Parameters: String name - the name to search for
	 * Returns: int - the total money spent by name
	 */
	public int moneySpent(String name) {
		//if the list is null, return 0
		if (this.items == null){
			return 0;
		}
		//if the list is empty, return 0
		if (this.items.length == 0){
			return 0;
		}

		int total = 0;
		//if the list is not null or empty, begin the loop.
		for (int i = 0; i < this.items.length; i++){
			//if the bidder name is the same as the name, add the highest bid to the total
			if (this.items[i].getBidderName().equals(name)){
				total += this.items[i].getHighestBid();
			}
		}


		return total; 
	}
	
	/* 
	 * Purpose: get the most expensive auction item at this fundraiser
	 * Parameters: none
	 * Returns: AuctionItem - the most expensive item
	 * Preconditions: items is not null, and items.length > 0
	 */
	public AuctionItem mostExpensive() {
		//if the list is null, return null
		if (this.items == null){
			return null;
		}
		
		//if the list is empty, return null
		if (this.items.length == 0){
			return null;
		}
		
		AuctionItem mostExpensive = items[0];

		//if the list is not null or empty, begin the loop.
		for (int i = 0; i < this.items.length; i++){
			//if the current item is more expensive than the most expensive, set it as the most expensive
			if (this.items[i].getHighestBid() > mostExpensive.getHighestBid()){
				mostExpensive = this.items[i];
			}
		}


		return mostExpensive; 
	}
	
	/* 
	 * Purpose: adds the new item to the items sold at this fundraiser
	 * Parameters: AuctionItem newItem - the item to add to the fundraiser
	 * Returns: void - nothing
	 */
	public void addToFundraiser(AuctionItem newItem) {
		
		//if the item is null, add nothing and return the existing list. 
		if (newItem == null){
			return;
		}
		
		//if the list is null, create a new array of size 1 and add the new item to it
		if (this.items == null){
			AuctionItem[] newArray = new AuctionItem[1];
			newArray[0] = newItem;
			this.items = newArray;
			return;
		}
		//if the list is empty, create a new array of size 1 and add the new item to it
		if (this.items.length == 0){
			AuctionItem[] newArray = new AuctionItem[1];
			newArray[0] = newItem;
			this.items = newArray;
			return;
		}
		
		//if the list is not null or empty, create a new array of size 1 larger than the existing array
		AuctionItem[] newArray = new AuctionItem[this.items.length + 1];
		//loop over the existing array and add each item to the new array
		for (int i = 0; i < this.items.length; i++){
			newArray[i] = this.items[i];
		}
		//add the new item to the end of the new array
		newArray[this.items.length] = newItem;
		this.items = newArray;
		return;

		
	}
	
}
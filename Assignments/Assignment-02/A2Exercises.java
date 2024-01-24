public class A2Exercises {
	
	/*
	 * Purpose: get the total money raised across all fundraisers
	 *          in the given array
	 * Parameters: Fundraiser[] array - the array of fundraisers
	 * Returns: int: total money raised across all fundraisers
	 * Precondition: the array is not null
	 */	
	public static int totalMoneyRaised(Fundraiser[] array) {
		int total = 0;
		for (int i = 0; i < array.length; i++){
			total += array[i].moneyRaised();
		}
		return total;
	}
	
	/*
	 * Purpose: get the total money spent on winning auctions 
	 *          by people with the provided name
	 * Parameters: Fundraiser[] array - the array of fundraisers
	 *             String name - the name to search for
	 * Returns: int: total money raised across all fundraisers
	 * Precondition: the array and name are not null
	 */	
	public static  int totalSpent(Fundraiser[] array, String name) {
		int total = 0; 
		//loop over each fundraiser
		for (int i = 0; i < array.length; i++){
			//loop over each item in the fundraiser
			//if the current fundraiser has no items, or length 0 skip it
			if (array[i].getItems() == null || array[i].getItems().length == 0){
				continue;
			}
			for (int j = 0; j < array[i].getItems().length; j++){
				//if the bidder name is the same as the name, add the highest bid to the total
				if (array[i].getItems()[j].getBidderName().equals(name)){
					total += array[i].getItems()[j].getHighestBid();
				}
			}
		}
		return total;
		
	}

	/*
	 * Purpose: create a new array of AuctionItems that contains
	 *          only the most expensive item from each fundraiser
	 * Parameters: Fundraiser[] array - the array of fundraisers
	 * Returns: AuctionItem[]: the array of most expensive items
	 * Precondition: the array is not null
	 */	
	public static AuctionItem[] mostExpensiveItems(Fundraiser[] array) {
		//loop over each fundraiser and get the most expensive item and add it to the array
		
		
		AuctionItem[] mostExpensive = new AuctionItem[array.length];
		for (int i = 0; i < array.length; i++){
			//if the current fundraiser has no items, or length 0 skip it
			if (array[i].getItems() == null || array[i].getItems().length == 0){
				continue;
			}
			mostExpensive[i] = array[i].mostExpensive();
		}
		return mostExpensive;
	}
	
	/*
	 * Purpose: calculate and return the average price of the most
	 *          expensive items from each fundraiser in the array
	 * Parameters: Fundraiser[] array - the array of fundraisers
	 * Returns: double - the average price of the most expensive items
	 * Precondition: the array is not null
	 */	
	public static double averageOfMostExpensive(Fundraiser[] array) {
		//array of length of array, which will be filled with each most expensive item
		AuctionItem[] mostExpensive = new AuctionItem[array.length];
		//loop over each fundraiser and get the most expensive item and add it to the array
		for (int i = 0; i < array.length; i++){
			//if the current fundraiser has no items, or length 0 skip it
			if (array[i].getItems() == null || array[i].getItems().length == 0){
				continue;
			}
			mostExpensive[i] = array[i].mostExpensive();
			// System.out.println(mostExpensive[i]);
			
		}
		//loop over the array of most expensive items and get the total
		double total = 0;
		for (int i = 0; i < mostExpensive.length; i++){
			total += mostExpensive[i].getHighestBid();
		}
		// System.out.println(total + " / " + mostExpensive.length);
		//return the total divided by the length of the array. if the array is empty, or the length is 0, return 0	
		if (mostExpensive.length == 0){
			return 0;
		}

		// System.out.println(total / mostExpensive.length);
		return total / mostExpensive.length;

	}
}
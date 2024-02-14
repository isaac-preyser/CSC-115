import java.util.List;

public class A4Exercises {

	/*
	 * Purpose: gets the number of competitors in the given list
	 * Parameters: List cList - the list of competitors
	 * Returns: int - the number of competitors in the given list
	 */
	public static int competitorsCount(List cList) {
		int count = 0;
		for (int i = 0; i < cList.size(); i++) {
			Competitor c = (Competitor) cList.get(i); //just for testing. 
			System.out.println(c.getName());
			count++;
		}
		return count; 
	}
	
	/*
	 * Purpose: gets the number of competitors with a score above x
	 * Parameters: List cList - the list of competitors
	 *             int x - the threshold competitors must score more than
	 * Returns: int - the number competitors with a score above x
	 */
	public static int countScoresAboveX(List cList, int x) {
		int count = 0;
		
		while(cList.next() != null) {
			Competitor c = (Competitor) cList.get(0);
			if(c.getScore() > x) {
				System.out.println(c.getName());
				count++;
			}
		}
		return count; 
	}
	
	/*
	 * Purpose: get the number of competitors into the list c is
	 * Parameters: List cList - the list of competitors
	 *             Competitor c - the competitor to find
	 * Returns: int - the distance the first occurrence of 
	 *                c is from the start of the list, or 
	 *                -1 if c is not found in cList
	 */
	public static int distanceAway(List<E> cList, Competitor c) {
		//while loop until we hit it, keep a count to know how many times we've gone through the loop

		int count = 0;
		while(cList.next() != null) {
			Competitor current = cList.get();
			if(current.equals(c)) {
				return count;
			}
			count++;
		}
		return -1;

		//built-in List<T> has an indexOf method, which is the same as this method

		
	}
	
	/*
	 * Purpose: get the name of the competitor with the highest score
	 * Parameters: List cList - the list of competitors
	 * Returns: String - the name of the competitor with the highest
	 *                   score, or "" if the list is empty
	 *
	 * Note: if two or more competitors are tied with the highest 
	 *       score, the name of the competitor who comes first in the
	 *       list among those who are tied is returned
	 */
	public static String getBestCompetitorName(List cList) {
		if (cList.size() == 0) {
			return "";
		}
		
		Competitor best = cList.get(0);
		for (int i = 1; i < cList.size(); i++) {
			Competitor c = cList.get(i);
			if (c.getScore() > best.getScore()) {
				best = c;
			}
		}
		return best.getName();
	}

	/*
	 * Purpose: get the number of times a new highest score
	 *          in the list of competitors is found
	 * Parameters: List cList - the list of competitors
	 * Returns: int - the number times a new highest score is
	 *                found when traversing from left to right
	 *                through the list of competitors
	 * 
	 * Note: Read through the assignment PDF for more information
	 */
	public static int numberTimesRecordBroken(List cList) {
		// TODO: implement this
		// 1. keep track of the highest score seen so far
		// 2. keep track of the number of times a new highest score is found
		// 3. traverse the list from left to right
		// 4. update the highest score seen so far and the number of times a new highest score is found
		// 5. return the number of times a new highest score is found
		int highestScore = 0;
		int numBroken = 0;
		for (int i = 0; i < cList.size(); i++) {
			Competitor c = cList.get(i);
			if (c.getScore() > highestScore) {
				highestScore = c.getScore();
				numBroken++;
			}

		}
		return numBroken;
	}
		
	/*
	 * Purpose: get names of all the competitors who had
	 *          the highest score seen so far at some point
	 * Parameters: List cList - the list of competitors
	 * Returns: String[] - the names of competitors who had 
	 *                     the highest score seen so far
	 *                     at some point while traversing 
	 *                     the list from left to right
	 */
	public static String[] listOfRecordBreakers(List cList) {
		// TODO: implement this
		// 1. keep track of the highest score seen so far
		// 2. keep track of the names of competitors who had the highest score seen so far
		// 3. traverse the list from left to right
		// 4. update the highest score seen so far and the names of competitors who had the highest score seen so far
		// 5. return the names of competitors who had the highest score seen so far

		int highestScore = 0;
		String[] recordBreakers = new String[cList.size()];
		for (int i = 0; i < cList.size(); i++) {
			Competitor c = cList.get(i);
			if (c.getScore() > highestScore) {
				highestScore = c.getScore();
				recordBreakers[numRecordBreakers] = c.getName();
			}
		}
		

		return recordBreakers;
	}

}
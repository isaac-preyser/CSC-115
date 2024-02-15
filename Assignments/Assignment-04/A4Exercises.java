public class A4Exercises {

	/*
	 * Purpose: gets the number of competitors in the given list
	 * Parameters: List cList - the list of competitors
	 * Returns: int - the number of competitors in the given list
	 */
	public static int competitorsCount(List cList) {
		return cList.size();
	}
	
	/*
	 * Purpose: gets the number of competitors with a score above x
	 * Parameters: List cList - the list of competitors
	 *             int x - the threshold competitors must score more than
	 * Returns: int - the number competitors with a score above x
	 */
	public static int countScoresAboveX(List cList, int x) {
		int count = 0;
		for (int i = 0; i < cList.size(); i++) {
			if (cList.get(i).getScore() > x) {
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
	public static int distanceAway(List cList, Competitor c) {
		return cList.find(c); //double check that find indeed finds the first occurrence
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
		int bestScore = cList.get(0).getScore();
		String bestName = cList.get(0).getName();
		for (int i = 1; i < cList.size(); i++) {
			if (cList.get(i).getScore() > bestScore) {
				bestScore = cList.get(i).getScore();
				bestName = cList.get(i).getName();
			}
		}
		return bestName;
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
		int count = 0;
		int bestScore = 0;
		for (int i = 0; i < cList.size(); i++) {
			if (cList.get(i).getScore() > bestScore) {
				bestScore = cList.get(i).getScore();
				count++;
			}
		}
		return count;
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
		//make a temp string array of the size of the list. 
		//store the names of the competitors who had the highest score seen so far
		//at some point while traversing the list from left to right

		//WHO CARES ABOUT MEMORY MANAGEMENT RAAAAHHHHH
		String[] recordBreakers = new String[cList.size()];
		int bestScore = 0;
		int r = 0; 


		for (int i = 0; i < cList.size(); i++) {
			if (cList.get(i).getScore() > bestScore) {
				bestScore = cList.get(i).getScore();
				recordBreakers[r] = cList.get(i).getName();
				r++;
			}
		}
		// we have to make an array of the correct size, smh. 
		//turns out we do care about memory management (rahhh.. *sigh*)
		String[] result = new String[r];
		for (int i = 0; i < r; i++) {
			result[i] = recordBreakers[i];
		}

		return result;
	}

}
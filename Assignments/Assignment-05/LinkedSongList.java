public class LinkedSongList {
	// DO NOT ADD ANY MORE FIELDS OR METHODS
	private SongNode head;
	
	public LinkedSongList() {
		head = null;
	}

	public void addFront (Song s) {
		SongNode n = new SongNode(s);
		n.next = head;
		head = n;
	}

	public void addBack (Song s){
		SongNode n = new SongNode(s);
		if (head == null) {
			head = n;
		} else {
			addBackRec(head, n);
		}
	}
	
	private void addBackRec(SongNode cur, SongNode n) {
		if (cur.next == null) {
			cur.next = n;
		} else {
			addBackRec(cur.next, n);
		}
	}

	public boolean isEmpty() {
		return head == null;
	}

	public Song get (int position) {
		return getRec(head, 0, position);
	}
	
	private Song getRec(SongNode cur, int i, int position) {
		if (i == position) {
			return cur.getData();
		} else {
			return getRec(cur.next, i+1, position);
		}
	}

	/* Purpose: create a string representation of list
	 * Parameters: nothing	 
	 * Returns: String - the string representation of the list
	 */
	public String toString() {
		if (head == null) {
			return "{}";
		} else {
			return "{" + toStringRec(head) + "}";
		}
	}
	
	private String toStringRec(SongNode cur) {
		if (cur == null) {
			return "";
		} else if (cur.next == null) {
			return cur.getData().toString();
		} else {
			return cur.getData().toString() + ", " + toStringRec(cur.next);
		}
	}

	/*
	 * Purpose: Insert all elements from array into this linked list
	 * Parameters: Song[] array - the elements to add to this list
	 * Returns void - nothing
	 */
	public void buildFromArray(Song[] array) {
		buildFromArrayRec(array, array.length-1);
	}
	
	private void buildFromArrayRec(Song[] array, int i) {
		if (i < 0) {
			return;
		} else {
			addFront(array[i]);
			buildFromArrayRec(array, i-1);
		}
	}
	

	/*
	 * Purpose: gets the total number of songs in this list
	 * Parameters: none
	 * Returns: int - the number of songs in this list
	 */
	public int countSongs() {
		// make a copy of this list
		// traverse the copy and count the number of songs
		// return the counter
		SongNode cur = head;

		return countSongsRec(cur, 0); // so it compiles
	}

	private int countSongsRec(SongNode cur, int count) {
		if (cur == null) {
			return count;
		} else {
			return countSongsRec(cur.next, count + 1);
		}
	}
	
		
	/*
	 * Purpose: gets the total duration of all songs in this list
	 * Parameters: none
	 * Returns: int - the total duration of all songs in this list
	 */
	public int totalDuration() {
		//similar idea to method above. 
		//traverse list and add up the duration of all songs
		SongNode cur = head;
		return totalDurationRec(cur, 0); 
	}

	private int totalDurationRec(SongNode cur, int total) {
		if (cur == null) {
			return total;
		} else {
			return totalDurationRec(cur.next, total + cur.getData().getDuration());
		}
	}
	
	
	/*
	 * Purpose: counts the songs in this list by an artist with artistName
	 * Parameters: String artistName - the name of the artist to search for
	 * Returns: int - number of songs by artistName
	 */
	public int countSongsByArtist(String artistName) {
		//similar idea but check if the artist of the song is the same as the declared artistName
		SongNode cur = head;
		return countSongsByArtistRec(cur, artistName, 0); // so it compiles
	}

	private int countSongsByArtistRec(SongNode cur, String artistName, int count) {
		if (cur == null) {
			return count;
		} else {
			if (cur.getData().getArtist().equals(artistName)) {
				return countSongsByArtistRec(cur.next, artistName, count + 1);
			} else {
				return countSongsByArtistRec(cur.next, artistName, count);
			}
		}
	}
	
	
	/*
	 * Purpose: determines whether this list contains a song by artistName
	 * Parameters: String artistName - the name of the artist to search for
	 * Returns: boolean - true if a song by artistName is found
	 */
	public boolean containsArtist(String artistName) {
		// TODO: Call a recursive helper method
		SongNode cur = head;
		return containsArtistRec(cur, artistName); // so it compiles
	}
	
	private boolean containsArtistRec(SongNode cur, String artistName) {
		if (cur == null) {
			return false;
		} else {
			if (cur.getData().getArtist().equals(artistName)) {
				return true;
			} else {
				return containsArtistRec(cur.next, artistName);
			}
		}
	}
	
	/*
	 * Purpose: gets the longest song in the list
	 * Parameters: none
	 * Returns Song - the longest song in the list
	 *                or null if the list is empty
	 */
	public Song longestSong() {
		// TODO: Call a recursive helper method
		SongNode cur = head;
		return longestSongRec(cur, null); 
	}

	private Song longestSongRec(SongNode cur, Song longest) {
		if (cur == null) {
			return longest;
		} else {
			if (longest == null || cur.getData().getDuration() > longest.getDuration()) {
				return longestSongRec(cur.next, cur.getData());
			} else {
				return longestSongRec(cur.next, longest);
			}
		}
	}
	
		
	/*
	 * Purpose: get the total duration of all songs in the list
	 *          before the first song by artistName
	 * Parameters: String artistName - the artist name to search for
	 * Returns int - the duration of all songs before the first
	 *               song by artistName, or -1 if no song by 
	 *               artistName is found.
	 */
	public int totalTimeUntilArtist(String artistName) {
		// TODO: Call a recursive helper method
		SongNode cur = head;
		return totalTimeUntilArtistRec(cur, artistName, 0); // so it compiles
	}

	private int totalTimeUntilArtistRec(SongNode cur, String artistName, int total) {
		if (cur == null) {
			return -1;
		} else {
			if (cur.getData().getArtist().equals(artistName)) {
				return total;
			} else {
				return totalTimeUntilArtistRec(cur.next, artistName, total + cur.getData().getDuration());
			}
		}
	}
	
}
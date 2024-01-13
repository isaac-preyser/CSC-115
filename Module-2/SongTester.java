// SongTester.java
//
// We will write code here to test our implementation of Song.java
//
// We have put this code in a different file to help you understand 
// the difference between static and non-static.  In the real world,
// this style of test code might be included in the Song.java file.

public class SongTester {
    
	public static void main (String[] args) {
		/* Recall: if I want to declare an integer: */
		int i; // what is it initialized to? ANSWER: 0

		/* if I want to declare an array of integers: */
		int[] array;
		
		/* what is it initialized to? ANSWER: null
		   how would I initialize it to point to an array of size 10? */
		//ANSWER: array = new int[10];
		/* 3a. declare and initialize two new blank songs */
		//lets do this but with the constructor.
		Song s1 = new Song();
		Song s2 = new Song();
		s1 = s1.createSong("Song 1", "Artist 1", 2000, "Album 1");
		s2 = s2.createSong("Song 2", "Artist 2", 2001, "Album 2");
		//I think there is a way to do this with the constructor but I'm not sure how.


		/* 3b. print the values of the fields for each song */
		System.out.println("Song 1: ");
		System.out.println("Title: " + s1.getTitle());
		System.out.println("Artist: " + s1.getArtist());
		System.out.println("Year Released: " + s1.getYearReleased());
		System.out.println("Album: " + s1.getAlbum());
		System.out.println();
		System.out.println("Song 2: ");
		System.out.println("Title: " + s2.getTitle());
		System.out.println("Artist: " + s2.getArtist());
		System.out.println("Year Released: " + s2.getYearReleased());
		System.out.println("Album: " + s2.getAlbum());
		System.out.println();



		/* 3c. set the fields in the song to some values and reprint */

		s1.setTitle("Mine Diamonds");
		s1.setArtist("MineCraft Awesome Parodys");
		s1.setYearReleased(2016);
		s1.setAlbum("MineCraft Awesome Parodys");
		s2.setTitle("Mine All Day");
		s2.setArtist("MineCraft Awesome Parodys");
		s2.setYearReleased(2019);
		s2.setAlbum("MineCraft Awesome Parodys");
		System.out.println("Song 1: ");
		System.out.println("Title: " + s1.getTitle());
		System.out.println("Artist: " + s1.getArtist());
		System.out.println("Year Released: " + s1.getYearReleased());
		System.out.println("Album: " + s1.getAlbum());
		System.out.println();
		


		/* 5a. update statements where necessary from 3b and 3c */

		/* 6a. call constructor with args, then print fields */




		/* 6b. call alternative constructor, then print fields */





		/* 6c. try to print one of the songs
		   ie. pass your Song variable to System.out.println() */


		/* 7a. recompile and run your program - what changes in 6c. */
	}
}
// Song.java

public class Song {
	// 1. generalize what you use to describe a song?
	//    these dictate the fields/attributes in our Song class
	/*	Song Attributes
	 *  string: title * we will use
	 *  string: artist * we will use
	 *  int: yearReleased * we will use
	 *  int: durationInSeconds 
	 *  string: genre
	 *  string: album * we will use
	 *  string: recordLabel
	 *  string: producer
	 *  string: writer
	 *  string: composer
	 */
	// 2. create fields in Song class
	public String title;
	public String artist;
	public int yearReleased;
	public String album;
	// 3. go to tester and create some song objects...

	// 4. change fields to private in Song class
	//  - what happens when you try to access them from tester?
	// unable to access private fields from outside the class... 
	//  - what happens when you try to access them from Song class?
	// able to access private fields from inside the class...

	// 5. add getters and setters for fields
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getArtist(){
		return artist;
	}
	public void setArtist(String artist){
		this.artist = artist;
	}
	public int getYearReleased(){
		return yearReleased;
	}
	public void setYearReleased(int yearReleased){
		this.yearReleased = yearReleased;
	}
	public String getAlbum(){
		return album;
	}
	public void setAlbum(String album){
		this.album = album;
	}

	// 6. how do we initialize a song with data upon creation?
	//  - add a custom constructor
	public Song createSong(String title, String artist, int yearReleased, String album){
		Song song = new Song();
		song.setTitle(title);
		song.setArtist(artist);
		song.setYearReleased(yearReleased);
		song.setAlbum(album);
		return song;
	}

	// 7. add a toString method
	//  - takes no arguments and returns a String
	//    representing this object
	public String toString(){
		String output = "";
		output += "Title: " + this.title + "\n";
		output += "Artist: " + this.artist + "\n";
		output += "Year Released: " + this.yearReleased + "\n";
		output += "Album: " + this.album + "\n";
		return output;
	}
	
	
   
}
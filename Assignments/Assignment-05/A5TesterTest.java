public static void testCountSongs() {
    System.out.println("\nTesting countSongs");

    LinkedSongList list0 = new LinkedSongList();
    LinkedSongList list1 = new LinkedSongList();
    LinkedSongList list2 = new LinkedSongList();
    LinkedSongList list3 = new LinkedSongList();

    Song s1  = new Song("Shake it off", "Taylor Swift", 219);
    Song s2  = new Song("Halo", "Beyonce", 225);
    Song s3  = new Song("Love Story", "Taylor Swift", 237);
    Song s4  = new Song("22", "Taylor Swift", 243);
    Song s5  = new Song("Anti-Hero", "Taylor Swift", 310);
    Song s6  = new Song("Africa", "Toto", 272);
    Song s7  = new Song("Single Ladies", "Beyonce", 201);
    Song s8  = new Song("Irreplaceable", "Beyonce", 253);
    Song s9  = new Song("Blank Space", "Taylor Swift", 263);
    Song s10 = new Song("Bad Blood", "Taylor Swift", 245);
    Song s11 = new Song("Thunderstruck", "AC/DC", 293);
    Song s12 = new Song("Flowers", "Miley Cyrus", 195);

    Song[] songs1 = {s1}; 
    Song[] songs2 = {s1, s2, s3, s4}; 
    Song[] songs3 = {s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12}; 
    list1.buildFromArray(songs1);
    list2.buildFromArray(songs2);
    list3.buildFromArray(songs3);

    int result = 0;
    int expected = 0;

    result = list1.countSongs();
    expected = 1;
    displayResults(result==expected, "countSongs in list1");

    result = list2.countSongs();
    expected = 4;
    displayResults(result==expected, "countSongs in list2");

    result = list3.countSongs();
    expected = 12;
    displayResults(result==expected, "countSongs in list3");

    // Additional tests
    LinkedSongList list4 = new LinkedSongList();
    LinkedSongList list5 = new LinkedSongList();
    LinkedSongList list6 = new LinkedSongList();

    Song s13 = new Song("Hello", "Adele", 295);
    Song s14 = new Song("Shape of You", "Ed Sheeran", 233);
    Song s15 = new Song("Uptown Funk", "Mark Ronson ft. Bruno Mars", 270);
    Song s16 = new Song("Thinking Out Loud", "Ed Sheeran", 281);

    Song[] songs4 = {s13, s14, s15, s16};
    Song[] songs5 = {s13, s14, s15, s16, s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12};
    Song[] songs6 = {};

    list4.buildFromArray(songs4);
    list5.buildFromArray(songs5);
    list6.buildFromArray(songs6);

    result = list4.countSongs();
    expected = 4;
    displayResults(result==expected, "countSongs in list4");

    result = list5.countSongs();
    expected = 16;
    displayResults(result==expected, "countSongs in list5");

    result = list6.countSongs();
    expected = 0;
    displayResults(result==expected, "countSongs in list6");

    System.out.println();		
}
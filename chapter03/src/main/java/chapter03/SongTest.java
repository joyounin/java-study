package chapter03;

public class SongTest {

	public static void main(String[] args) {
		Song song01 = new Song("좋은날", "아이유", "Real", "이민수", 3, 2010);
		Song song02 = new Song("12:45", "adam");
//		song.setTitle("좋은날");
//		song.setArtist("아이유");
//		song.setAlbum("Real");
//		song.setComposer("이민수");
//		song.setTrack(3);
//		song.setYear(2010);
		
		song01.show();
		song02.show();
	}

}

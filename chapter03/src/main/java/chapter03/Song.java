package chapter03;

public class Song {
	private String title;
	private String album;
	private String composer;
	private String artist;
	private int year;
	private int track;
	
	public int getTrack() {
		return track;
	}
	public void setTrack(int track) {
		this.track = track;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAlbum() {
		return album;
	}
	public void setAlbum(String album) {
		this.album = album;
	}
	public String getComposer() {
		return composer;
	}
	public void setComposer(String composer) {
		this.composer = composer;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public void show() {
		System.out.println(artist + " " + 
				title + "(" + 
				album + ", " + 
				year + ", " +
				track + "번 track, " +
				composer + " 작곡)"
				);
	}
	

}

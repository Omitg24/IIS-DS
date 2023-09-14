package part1.model;

public class CompactDisc {

	private String title;
	private String artist;

	public CompactDisc(String title, String artist) {
		setTitle(title);
		setArtist(artist);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

}

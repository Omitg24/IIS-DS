package ipod.model;

public class Song 
{
	private String title, artist, filename;
	
	public Song(String title, String artist, String filename)
	{
		this.title = title;
		this.artist = artist;
		this.filename = filename;
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public String getArtist()
	{
		return artist;
	}
	
	public String getFilename()
	{
		return filename;
	}
	
	@Override
	public String toString()
	{
		return title + "(" + artist + ") [" + filename + "]";
	}
}

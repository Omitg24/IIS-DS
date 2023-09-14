package extension;

import extension.movies.ChildrenMovies;
import extension.movies.NewReleaseMovies;
import extension.movies.RegularMovies;

public class Movie
{
	public static final MovieType CHILDRENS = new ChildrenMovies();
	public static final MovieType NEW_RELEASE = new NewReleaseMovies();
	public static final MovieType REGULAR = new RegularMovies();

	private String title;
	private MovieType type;

	public Movie(String title, MovieType type) {
		this.title = title;
		this.type = type;
	}

	public MovieType getMovieType()
	{
		return type;
	}

	public void setMovieType(MovieType type)
	{
		this.type = type;
	}

	public String getTitle()
	{
		return title;
	}
}

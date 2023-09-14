package extension.movies;

import extension.MovieType;

public class NewReleaseMovies implements MovieType {

	@Override
	public double getAmount(int daysRented) {
		return daysRented * 3;
	}

	@Override
	public int getFrequentRenterPoints(int daysRented) {
		return daysRented > 1 ? 2 : 1;
	}

}

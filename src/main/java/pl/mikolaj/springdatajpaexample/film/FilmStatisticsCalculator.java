package pl.mikolaj.springdatajpaexample.film;

public class FilmStatisticsCalculator {

	private final int rate;
	private final int qualifier;

	public FilmStatisticsCalculator(int rate, int qualifier) {
		this.rate = rate;
		this.qualifier = qualifier;
	}

	public int rateFilm(Film film) {
		return film.getName().length() * qualifier * rate;
	}

	@Override
	public String toString() {
		return "FilmStatisticsCalculator{" +
				"rate=" + rate +
				", qualifier=" + qualifier +
				'}';
	}
}

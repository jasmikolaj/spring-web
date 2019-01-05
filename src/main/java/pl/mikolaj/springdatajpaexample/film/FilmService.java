package pl.mikolaj.springdatajpaexample.film;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class FilmService {

	private final FilmRepository filmRepository;
	private final FilmStatisticsCalculator filmStatisticsCalculator;

	@Autowired
	public FilmService(FilmRepository filmRepository,
					   @Qualifier("moreAccurateFilmStatisticsCalculator")
					   FilmStatisticsCalculator filmStatisticsCalculator) {
		this.filmRepository = filmRepository;
		this.filmStatisticsCalculator = filmStatisticsCalculator;
	}

	public Film getBestFilm() {
		Film film = filmRepository.getFilms().get(0);
		filmStatisticsCalculator.rateFilm(film);
		return film;
	}
}

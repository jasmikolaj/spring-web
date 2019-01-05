package pl.mikolaj.springdatajpaexample.film;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	@Bean
	public FilmStatisticsCalculator filmStatisticsCalculator() {
		return new FilmStatisticsCalculator(14, 50);
	}

	@Bean
	public FilmStatisticsCalculator moreAccurateFilmStatisticsCalculator() {
		return new FilmStatisticsCalculator(50, 100);
	}

}

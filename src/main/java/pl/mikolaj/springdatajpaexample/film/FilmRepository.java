package pl.mikolaj.springdatajpaexample.film;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Repository;

@Repository
public class FilmRepository {

	public List<Film> getFilms() {
		return Stream.of(new Film("1"), new Film("2"))
				.collect(Collectors.toList());
	}

}

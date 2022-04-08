package jpa.services;

import jpa.models.Movie;

public interface MovieService {

    Movie getMovieByGenre(String genre);

    Movie getRandomMovie();

    Movie getMovieById(long id);
}

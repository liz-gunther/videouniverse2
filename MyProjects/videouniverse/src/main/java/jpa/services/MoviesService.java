package jpa.services;

import jpa.models.Movies;

import java.util.List;

public interface MoviesService {

    Movies getMovieByGenre(String genre);

}

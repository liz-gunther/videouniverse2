package jpa.services;

import jpa.models.Movie;
import jpa.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements MovieService {

    private MovieRepository movieRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Movie getMovieByGenre(String genre) {
        return movieRepository.getMovieByGenre(genre);
    }

    @Override
    public Movie getRandomMovie() {
        return movieRepository.getRandomMovie();
    }

    @Override
    public Movie getMovieById(long id) {
        return movieRepository.getById(id);
    }

}

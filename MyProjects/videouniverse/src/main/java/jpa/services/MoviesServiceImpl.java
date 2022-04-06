package jpa.services;

import jpa.models.Customer;
import jpa.models.Movies;
import jpa.repository.MoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoviesServiceImpl implements MoviesService {

    private MoviesRepository moviesRepository;

    @Autowired
    public MoviesServiceImpl(MoviesRepository moviesRepository) {
        this.moviesRepository = moviesRepository;
    }
    @Override
    public Movies getMovieByGenre(String genre) {
       return moviesRepository.getMovieByGenre(genre);
    }
}

package jpa.repository;

import jpa.models.Movies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface MoviesRepository extends JpaRepository<Movies, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM moviedata m WHERE m.genre = :genre ORDER BY RAND() LIMIT 1;")
    Movies getMovieByGenre(@Param("genre") String genre);

    @Query(nativeQuery = true, value = "SELECT * FROM moviedata m ORDER BY RAND() LIMIT 1;")
    Movies getRandomMovie();

//    List<Movies> getMoviesByGenre(String genre);

}

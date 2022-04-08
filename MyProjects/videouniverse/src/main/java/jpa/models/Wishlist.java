package jpa.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "wishlist")
public class Wishlist {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long wishlistId;
    private long userId;
    @OneToMany(targetEntity = Movie.class)
    private List<Movie> movieList;

    public Wishlist() {
    }

    public long getWishlistId() {
        return wishlistId;
    }

    public void setWishlistId(long wishlistId) {
        this.wishlistId = wishlistId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public List<Movie> getMoviesList() {
        return movieList;
    }

    public void setMoviesList(List<Movie> movieList) {
        this.movieList = movieList;
    }
}

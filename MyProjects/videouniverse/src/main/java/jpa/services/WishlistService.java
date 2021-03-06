package jpa.services;

import jpa.models.Wishlist;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;


public interface WishlistService {

    void saveToWishlist(Wishlist wishlist);

    Set<Wishlist> getWishlistsByUserId(long id);

    Wishlist getWishlistById(long id);

    void saveWishlist(Wishlist wishlist);

    void deleteWishlistById(long id);

    Wishlist getWishlistByUserId(long id);

    void deleteMovieFromWishlist(long id);


}

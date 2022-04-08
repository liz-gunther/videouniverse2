package jpa.services;

import jpa.models.Movie;
import jpa.models.Wishlist;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public interface WishlistService {

    void saveToWishlist(Wishlist wishlist);

    List<Wishlist> getWishlistById(Long id);

}

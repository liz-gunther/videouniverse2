package jpa.repository;

import jpa.models.Movie;
import jpa.models.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface WishlistRepository extends JpaRepository<Wishlist, Long> {

    Set<Wishlist> getByUserId(long userId);

    Wishlist getById(long id);

    Wishlist getWishlistByUserId(long userid);


}

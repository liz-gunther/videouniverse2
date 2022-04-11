package jpa.services;

import jpa.models.Wishlist;
import jpa.repository.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class WishlistServiceImpl implements WishlistService {

    private WishlistRepository wishlistRepository;
    private UserService userService;

    @Autowired
    public WishlistServiceImpl(WishlistRepository wishlistRepository, UserService userService) {
        this.wishlistRepository = wishlistRepository;
        this.userService = userService;
    }

    @Override
    public void saveToWishlist(Wishlist wishlist) {
        this.wishlistRepository.save(wishlist);
    }


    @Override
    public Set<Wishlist> getWishlistsByUserId(long id) {
        return userService.getUserById(id).getWishlists();
    }

    @Override
    public Wishlist getWishlistById(long id) {
        return wishlistRepository.getById(id);
    }

    @Override
    public void deleteWishlistById(long id) {
        this.wishlistRepository.deleteById(id);
    }

    @Override
    public Wishlist getWishlistByUserId(long id) {
        return wishlistRepository.getWishlistByUserId(id);
    }

    @Override
    public void deleteMovieFromWishlist(long id) {

    }


}

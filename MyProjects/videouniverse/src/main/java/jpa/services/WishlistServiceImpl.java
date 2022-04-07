package jpa.services;

import jpa.models.Customer;
import jpa.models.Wishlist;
import jpa.repository.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishlistServiceImpl implements WishlistService {

    private WishlistRepository wishlistRepository;

    @Autowired
    public WishlistServiceImpl(WishlistRepository wishlistRepository) {
        this.wishlistRepository = wishlistRepository;
    }


    @Override
    public void saveWishlist(Wishlist wishlist) {
        this.wishlistRepository.save(wishlist);
    }

    @Override
    public List<Wishlist> getWishlistById(Long id) {
        List<Wishlist> byId;
        byId = (List<Wishlist>) wishlistRepository.getById(id);
        return byId;
    }

}

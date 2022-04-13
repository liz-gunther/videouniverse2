package jpa.repository;

import jpa.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailsRepository extends JpaRepository<User, Long> {


    User findUserById(Long Id);

    User findByEmail(String email);

}

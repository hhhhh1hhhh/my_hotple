package restaurant.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import restaurant.restaurant.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

//    boolean existsByUsername(String username);
//
//    UserEntity findByUsername(String username);

    boolean existsByEmail(String email);

    UserEntity findByEmail(String email);
}

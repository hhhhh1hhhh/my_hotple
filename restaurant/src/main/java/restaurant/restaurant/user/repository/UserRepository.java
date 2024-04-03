package restaurant.restaurant.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import restaurant.restaurant.user.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    boolean existsByUsername(String username);

    UserEntity findByUsername(String username);
}

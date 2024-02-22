package restaurant.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import restaurant.restaurant.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

}

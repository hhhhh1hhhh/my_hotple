package restaurant.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import restaurant.restaurant.entity.LikesEntity;

public interface LikesRepository extends JpaRepository<LikesEntity, Integer> {

}

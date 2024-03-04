package restaurant.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import restaurant.restaurant.entity.MyplaceEntity;


public interface MyplaceRepository extends JpaRepository<MyplaceEntity, Integer> {

}

package restaurant.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import restaurant.restaurant.entity.MyplaceEntity;

import java.util.List;


public interface MyplaceRepository extends JpaRepository<MyplaceEntity, Integer> {

    List<MyplaceEntity> findByUser_Id(int userId);


}

package restaurant.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import restaurant.restaurant.entity.LikesEntity;
import restaurant.restaurant.entity.MyplaceEntity;

import java.util.List;

public interface LikesRepository extends JpaRepository<LikesEntity, Integer> {
    boolean existsByUser_IdAndMyplace_Id(int userId, int myplaceId);

    void deleteByUser_IdAndMyplace_Id(int userId, int myplaceId);

    List<LikesEntity> findByUser_Id(int userId);


}

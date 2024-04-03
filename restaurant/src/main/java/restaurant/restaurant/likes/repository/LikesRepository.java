package restaurant.restaurant.likes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import restaurant.restaurant.likes.entity.LikesEntity;

import java.util.List;

public interface LikesRepository extends JpaRepository<LikesEntity, Integer> {
    boolean existsByUser_IdAndMyplace_Id(int userId, int myplaceId);

    void deleteByUser_IdAndMyplace_Id(int userId, int myplaceId);

    List<LikesEntity> findByUser_Id(int userId);


}

package restaurant.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import restaurant.restaurant.entity.CommentEntity;
import restaurant.restaurant.entity.MyplaceEntity;

import java.util.List;

public interface CommentRepository extends JpaRepository<CommentEntity, Integer> {
    List<CommentEntity> findAllByMyplaceEntityOrderByIdDesc(MyplaceEntity myplaceEntity);
}

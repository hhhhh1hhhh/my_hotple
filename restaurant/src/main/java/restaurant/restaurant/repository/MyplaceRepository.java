package restaurant.restaurant.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import restaurant.restaurant.entity.MyplaceEntity;

import java.util.List;


public interface MyplaceRepository extends JpaRepository<MyplaceEntity, Integer> {

    List<MyplaceEntity> findByUser_Id(int userId);


    @Modifying
    @Query(value = "update MyplaceEntity m set m.views=m.views+1 where m.id=:id")
    void updateViews(@Param("id") int id);

    Page<MyplaceEntity> findAllByShareIsTrue(PageRequest id);

    Page<MyplaceEntity> findAllByUser_Id(Integer userId, PageRequest id);


}

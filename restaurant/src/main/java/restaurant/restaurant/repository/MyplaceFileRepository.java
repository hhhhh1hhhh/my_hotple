package restaurant.restaurant.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import restaurant.restaurant.entity.MyplaceFileEntity;

public interface MyplaceFileRepository extends JpaRepository<MyplaceFileEntity, Integer>{

    void deleteByOriginalFileName(String originalFileName);
}

